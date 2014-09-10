package pe.com.ibk.halcon.conocenos.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.conocenos.bean.NoticiaBean;

import com.exp.portlet.halcon.utils.FriendlyURLGenerator;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ConocenosNoticias.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class ConocenosNoticiasController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ConocenosNoticiasController.class);
	
	/**
	 * Instancia un nuevo conocenos noticias.
	 */
	public ConocenosNoticiasController() {
	}

	/**
	 * Default view, controller que se carga por defecto
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, Model model) {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId, categoryId;
		try {
			/* Obtenemos la categoria desde el nombre */
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(AssetCategory.class,
					PortalClassLoaderUtil.getClassLoader()).add(
					PropertyFactoryUtil.forName("name").like("Noticias"));

			AssetCategory codassset = (AssetCategory) AssetCategoryLocalServiceUtil.dynamicQuery(
					query).get(0);

			groupId = themeDisplay.getScopeGroupId();
			categoryId = codassset.getCategoryId();

			/* Query para buscar las noticias */
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassNameIds(new long[] { PortalUtil.getClassNameId(JournalArticle.class.getName()) });
			assetEntryQuery.setExcludeZeroViewCount(false);
			assetEntryQuery.setGroupIds(new long[] { groupId });
			assetEntryQuery.setAnyCategoryIds(new long[] { categoryId });
			assetEntryQuery.setOrderByCol1("createDate");
			assetEntryQuery.setStart(0);
			assetEntryQuery.setEnd(3);

			List<NoticiaBean> noticia1 = new ArrayList<NoticiaBean>();
			List<AssetEntry> noticias = AssetEntryServiceUtil.getEntries(assetEntryQuery);

			int i = 0;
			String titulo = "";
			String fecha = "";
			String descripcion = "";
			String urlimagen = StringPool.BLANK;

			// Para darle la forma de dia como se muestra
			for (AssetEntry p : noticias) {
				SimpleDateFormat formateador = new SimpleDateFormat("dd MMM yyyy', 'HH:mm",new Locale("es", "ES"));
				JournalArticleResource resource = JournalArticleResourceLocalServiceUtil.getArticleResource(p.getClassPK());
				StringBuilder sb = new StringBuilder();
				sb.append("");

				JournalArticle articulito = JournalArticleLocalServiceUtil.getArticle(resource.getGroupId(), String.valueOf(resource.getArticleId()));

				JournalArticleDisplay articulitoDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(articulito, null, null, themeDisplay.getLanguageId(), 1,null, themeDisplay);

				titulo = HtmlUtil.escape(p.getTitle(themeDisplay.getLocale()));

				descripcion = StringUtil.shorten(p.getDescription(themeDisplay.getLocale()), 130);

				JournalArticle article = JournalArticleLocalServiceUtil.getArticle(articulitoDisplay.getGroupId(),String.valueOf(articulitoDisplay.getArticleId()));
				JournalArticleResource articleResource = JournalArticleResourceLocalServiceUtil.getArticleResource(article.getResourcePrimKey());
				String languageId = LanguageUtil.getLanguageId(renderRequest);
				boolean workflowAssetPreview = ParamUtil.getString(renderRequest, "viewMode")
						.equals(Constants.PRINT);

				if (!workflowAssetPreview && article.isApproved()) {
					articulitoDisplay = JournalContentUtil.getDisplay(articleResource.getGroupId(),
							articleResource.getArticleId(), null, null, languageId, themeDisplay);
				} else {
					articulitoDisplay = JournalArticleLocalServiceUtil.getArticleDisplay(article,
							null, null, languageId, 1, null, themeDisplay);
				}

				// si esta activo el checkbox "usar imagen pequeña"
				if (articulitoDisplay.isSmallImage()) {
					descripcion = StringUtil
							.shorten(p.getDescription(themeDisplay.getLocale()), 80);
					if (Validator.isNotNull(articulitoDisplay.getSmallImageURL())) {
						// si la imagen es obtenida a través de una url externa
						urlimagen = articulitoDisplay.getSmallImageURL();
					} else {
						
						// si la imagen fue subida al portal
						StringBuilder pathImageTwo = new StringBuilder("/journal/article?img_id=");
						StringBuilder pathImageLink = new StringBuilder("&t=");
						
						urlimagen = themeDisplay.getPathImage()
								+ pathImageTwo
								+ articulitoDisplay.getSmallImageId()
								+ pathImageLink
								+ WebServerServletTokenUtil.getToken(articulitoDisplay.getSmallImageId());
					}
				}

				fecha = formateador.format(articulito.getCreateDate());
				i++;
				/**
				 * _log.info(i); _log.info(titulo); _log.info(descripcion); _log.info(urlimagen);
				 * _log.info(fecha);
				 */

				// List<NoticiaBean> noticia1 = new ArrayList<NoticiaBean>();
				NoticiaBean n1 = new NoticiaBean();
				n1.setId(i);
				n1.setTitulo(titulo);
				n1.setResumen(descripcion);
				n1.setUrlImagen(urlimagen);
				
				StringBuilder itemSlash = new StringBuilder("/");				
				n1.setUrl(itemSlash + FriendlyURLGenerator.getURLAmigable(articulito, themeDisplay));
				n1.setFecha(fecha);
				noticia1.add(n1);
			}

			model.addAttribute("lstNoticias", noticia1);
			renderRequest.setAttribute("titulo", titulo);
			renderRequest.setAttribute("descripcion", descripcion);
			renderRequest.setAttribute("urlimagen", urlimagen);
			renderRequest.setAttribute("fecha", fecha);
			renderRequest.setAttribute("url", "/noticias");

		} catch (Exception e) {
			_log.error("Error al obtener las noticias", e);
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}
}
