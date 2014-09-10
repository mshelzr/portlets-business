package pe.com.ibk.halcon.conocenos.controller;


import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.conocenos.bean.BannerBean;

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
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
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
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ConocenosBanner.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class ConocenosBannerController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ConocenosBannerController.class);
	//private static Integer indicadorPortlet=11;
	//private static Integer indicadorController=1;

	/**
	 * Instancia un nuevo conocenos banner.
	 */
	public ConocenosBannerController() {
	}

	/**
	 * Default view, metodo que carga inicialmente por defecto
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
		String urlimagen = StringPool.BLANK;
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
			categoryId = getCategoryIdbyName(companyId, groupId, "Noticias");
			documentos = getLuceneContentSearch(renderRequest, companyId, groupId, categoryId);
			
			/**/
			if (documentos != null && !documentos.isEmpty()) {
				for (Document doc : documentos) {

					Long classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);
					JournalArticleResource recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
					JournalArticle articulo = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(), recurso.getArticleId());

					urlimagen = getParseValue("logoBannerDestacado", articulo,themeDisplay.getLanguageId());

					id++;
					titulo = assetEntry.getTitle(themeDisplay.getLocale());
					resumen = StringUtil.shorten(assetEntry.getDescription(themeDisplay.getLocale()), 90);

					BannerBean b1 = new BannerBean();
					b1.setId(id);
					b1.setTitulo(titulo);
					b1.setResumen(resumen);
					b1.setUrlImagen(urlimagen);
					StringBuilder itemSlash = new StringBuilder("/");	
					b1.setEnlace(itemSlash  + FriendlyURLGenerator.getURLAmigable(articulo, themeDisplay));
					banner1.add(b1);
				}
			}
			model.addAttribute("lstBanner", banner1);
			renderRequest.setAttribute("titulo", titulo);
			renderRequest.setAttribute("resumen", resumen);
			renderRequest.setAttribute("urlimagen", urlimagen);
			renderRequest.setAttribute("enlace", "/noticias");
		} catch (Exception e) {
			_log.error("Error al cargar el método por defecto:", e);
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}

	/**
	 * Obtiene lucene content search, obtiene del documento en la categoria indicada
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param categoryId the category id
	 * @return lucene content search
	 */
	private List<Document> getLuceneContentSearch(RenderRequest renderRequest, long companyId, long groupId, long categoryId) {

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
			BooleanQuery jCQuery = BooleanQueryFactoryUtil.create(searchContext);
			jCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			jCQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoryId);

			Query expandoQuery = StringQueryFactoryUtil
					.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demás obligando a que
			// el enlace sea un AND en lugar de un OR
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);

			fullQuery.add(jCQuery, BooleanClauseOccur.MUST);
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
			_log.error("Error al realizar la busqueda Lucene:", e);
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return documentos;
	}

	/**
	 * Obtiene category idby name, obtiene el nombre de la categoria
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
			_log.error("Error al obetener el Id de Categoria:", e);
		}
		return categoryId;
	}

	/**
	 * Obtiene parses the value, obtiene el articulo dentro del campo en xml de la bd 
	 * Fecha: 18/02/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parses the value
	 */
	public String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			
			StringBuilder nodeOne = new StringBuilder("/root/dynamic-element[@name='");
			StringBuilder nodeTwo = new StringBuilder("']/dynamic-content");
			
			Node node = document.selectSingleNode(nodeOne.append(fieldname).append(nodeTwo).toString());
			value = node.getText();
		} catch (Exception e) {

			_log.error(e.getMessage());
		}
		return value;
	}

}