package pe.com.ibk.halcon.promociones.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.promociones.bean.BannerBean;

import com.exp.portlet.halcon.utils.FriendlyURLGenerator;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class CarruselPromocionesController. 
 * Clase controladora para mostrar un
 * carrusel de Imagenes para promociones
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class CarruselPromocionesController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CarruselPromocionesController.class);
	//private static Integer indicadorPortlet=30;
	//private static Integer indicadorController=1;

	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse,
			Model model) {
		int id = 0;
		List<BannerBean> banner1 = new ArrayList<BannerBean>();
		String urlImagen = StringPool.BLANK;
		String urlImagenSmall = StringPool.BLANK;
		String urlDetalle = StringPool.BLANK;
		String linkDetalle = StringPool.BLANK;
		String titulo = "";
		String resumen = "";
		try {
			ThemeDisplay themeDisplay;

			long groupId, categoryId, companyId;
			List<Document> documentos;

			themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			groupId = themeDisplay.getScopeGroupId();
			companyId = themeDisplay.getCompanyId();

			/* Obtenemos la categoria desde el nombre */
			categoryId = getCategoryIdbyName(companyId, groupId, "Promociones");
			documentos = getLuceneContentSearch(renderRequest, companyId, groupId, categoryId);

			/**/
			if (documentos != null && !documentos.isEmpty()) {
				for (Document doc : documentos) {

					Long classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(
							JournalArticle.class.getName(), classPK);
					JournalArticleResource recurso = JournalArticleResourceLocalServiceUtil
							.getArticleResource(assetEntry.getClassPK());
					JournalArticle articulo = JournalArticleLocalServiceUtil.getArticle(
							assetEntry.getGroupId(), recurso.getArticleId());

					_log.info("Articulo " + articulo.getArticleId() + " :"
							+ assetEntry.getTitle(themeDisplay.getLocale()));

					urlImagen = getParseValue("logoBannerDestacado", articulo,
							themeDisplay.getLanguageId());
					
					urlImagenSmall = getParseValue("logoPequenioBannerDestacado", articulo,
							themeDisplay.getLanguageId());
					
					linkDetalle = getParseValue("linkLogoPequenioBannerDestacado", articulo,
							themeDisplay.getLanguageId());
					
					if (Validator.isNotNull(linkDetalle)) {
						linkDetalle = linkDetalle.replaceAll("@public", "");
						Layout pAsoc = LayoutLocalServiceUtil.getLayout(groupId, false, Long.valueOf(linkDetalle.replaceAll("@public", " ")));
						linkDetalle = themeDisplay.getURLPortal() + pAsoc.getFriendlyURL();
						_log.info("linkDetalle " + linkDetalle);
					}
					
					id++;
					titulo = assetEntry.getTitle(themeDisplay.getLocale());
					resumen = StringUtil.shorten(
							assetEntry.getDescription(themeDisplay.getLocale()), 90);

					BannerBean b1 = new BannerBean();
					b1.setId(id);
					b1.setTitulo(titulo);
					b1.setResumen(resumen);
					b1.setUrlImagen(urlImagen);
					b1.setUrlDetalle("/"+ FriendlyURLGenerator.getURLAmigable(articulo, themeDisplay));
					b1.setUrlImagenPequenia(urlImagenSmall);
					b1.setLinkImagenPequenia(linkDetalle);
					banner1.add(b1);

				}
			}
			model.addAttribute("lstPromociones", banner1);
			renderRequest.setAttribute("titulo", titulo);
			renderRequest.setAttribute("resumen", resumen);
			renderRequest.setAttribute("urlimagen", urlImagen);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		
		return "view";
	}

	/**
	 * Obtiene lucene content search.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param categoryId the category id
	 * @return lucene content search
	 */
	private List<Document> getLuceneContentSearch(RenderRequest renderRequest, long companyId,
			long groupId, long categoryId) {

		List<Document> documentos = null;
		Hits resultados;
		try {
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil
					.getHttpServletRequest(renderRequest));
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

			// Querypara buscador solo JournalContents
			BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
			JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			JCQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoryId);

			Query expandoQuery = StringQueryFactoryUtil
					.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demás obligando a que
			// el enlace sea un AND en lugar de un OR
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			fullQuery.add(JCQuery, BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery, BooleanClauseOccur.MUST);
			fullQuery.add(expandoQuery, BooleanClauseOccur.MUST);

			// Añadimos ordenación (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.CREATE_DATE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);

			_log.info("Query New:" + fullQuery.toString());

			// Recorremos resultados

			resultados = SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),
					companyId, fullQuery, sort, 0, 3);

			documentos = resultados.toList();
		} catch (Exception e) {
			_log.error("Error al realizar la busqueda Lucene:" + e.toString());
		}
		
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return documentos;
	}

	/**
	 * Obtiene category idby name.
	 * Fecha: 18/02/2013
	 *
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param nombreCategoria the nombre categoria
	 * @return category idby name
	 */
	private long getCategoryIdbyName(long companyId, long groupId, String nombreCategoria) {
		long categoryId = 0;
		/* Obtenemos la categoria desde el nombre */
		try {
			DynamicQuery queryCategoria = DynamicQueryFactoryUtil
					.forClass(AssetCategory.class, PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("name").like(nombreCategoria));

			AssetCategory codassset = (AssetCategory) AssetCategoryLocalServiceUtil.dynamicQuery(
					queryCategoria).get(0);

			categoryId = codassset.getCategoryId();
			_log.info("Categoria:" + categoryId + " / " + codassset.getName());
		} catch (Exception e) {
			_log.error("Error al obetener el Id de Categoria:" + e.toString());
		}
		return categoryId;
	}

	/**
	 * Obtiene parse value.
	 * Fecha: 18/02/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parse value
	 */
	public String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname
					+ "']/dynamic-content");
			value = node.getText();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}

		return value;
	}

}
