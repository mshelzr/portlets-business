package pe.com.ibk.halcon.banner.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.exp.portlet.halcon.utils.WsPromocionServiceUtil;
import com.ext.portlet.halcon.dto.PromocionBean;
import com.ext.portlet.halcon.dto.PromocionResponseBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
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


/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class VisualizarBannerUtils.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Service("VisualizarBannerService")
public class VisualizarBannerUtils {

	/** The _log. */
	private static final Log _log = LogFactoryUtil.getLog(VisualizarBannerUtils.class);
	
	/** The promocion default code. */
	private static final String PROMOCION_DEFAULT_CODE = "0";



	/**
	 * Obtiene parses the value.
	 * Fecha: 18/02/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parses the value
	 */
	public static String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			Node node = document.selectSingleNode(String.format("/root/dynamic-element[@name='%s']/dynamic-content",fieldname));
			value = node.getText();
		} catch (Exception e) {
			_log.error(e);
		}

		return value;
	}

	/**
	 * Obtiene articulo ramdom.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param banca the banca
	 * @return articulo ramdom
	 */
	public static JournalArticle getArticuloRamdom(RenderRequest renderRequest,String banca) {

		long categoryId, companyId, groupId;
		
		JournalArticle resultado;
		JournalArticleResource recurso;
		List<Document> documentos;
		ThemeDisplay themeDisplay;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		categoryId = getCategoryIdbyName(companyId, groupId, "Banners Promocionales");
		resultado = null;
		try {

			/* Realizamos el filtro de solo banners por defecto codigo=0 */
			List<PromocionResponseBean> promociones = new ArrayList<PromocionResponseBean>();
			PromocionResponseBean bean = new PromocionResponseBean();
			bean.setCodigoPromocion(PROMOCION_DEFAULT_CODE);
			promociones.add(bean);
			
			documentos = getLuceneContentSearch(renderRequest, categoryId, promociones);
			
			if (documentos != null && !documentos.isEmpty()) {

				Collections.shuffle(documentos);

				for (Document docs : documentos) {
					Document doc = docs;
					Long classPK;
					AssetEntry assetEntry;
					JournalArticle articulo;
					classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					assetEntry = AssetEntryLocalServiceUtil.getEntry(
							JournalArticle.class.getName(), classPK);
					recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry
							.getClassPK());
					articulo = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(),
							recurso.getArticleId());

					/* Verificamos si efectivamente es un banner que pertenece a los valores dados */
					String codigoPromocion = getParseValue("codigoPromocion", articulo,
							themeDisplay.getLanguageId());
					
					String bancaPromocion = getParseValue("banca", articulo,
							themeDisplay.getLanguageId());
					
					boolean isCorrect = false;
					
					if(bancaPromocion.equalsIgnoreCase(banca)){
						
						for (PromocionResponseBean prom : promociones) {
							if (prom.getCodigoPromocion().equalsIgnoreCase(codigoPromocion)) {
								resultado=articulo;
								isCorrect = true;
								break;
							} else {
								continue;
							}
						}

					}
					
					if (isCorrect) {
						
						break;
					}
				}
			}

			/* Esto es una lista de Liferay */
			/*
			 * if (UnmodifiableList.class.isAssignableFrom(bannersPromocionales.getClass())) {
			 * bannersPromocionales = ListUtil.copy(bannersPromocionales); }
			 */
		} catch (Exception e) {
			_log.error("Error al obtener getArticuloRamdom:" + e.toString());
		}
		return resultado;
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
	public static long getCategoryIdbyName(long companyId, long groupId, String nombreCategoria) {
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
			
		} catch (Exception e) {
			_log.error("Error al obetener el Id de Categoria:" + e.toString());
		}

		return categoryId;
	}

	/**
	 * Obtiene articulo ramdom ws.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param identidadBean the identidad bean
	 * @param banca the banca
	 * @param llamarWS the llamar ws
	 * @return articulo ramdom ws
	 */
	public static JournalArticle getArticuloRamdomWS(RenderRequest renderRequest, PromocionBean identidadBean,String banca,boolean llamarWS) {

		long categoryId, companyId, groupId;
		
		JournalArticle resultado;
		JournalArticleResource recurso;
		List<Document> documentos;
		ThemeDisplay themeDisplay;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		categoryId = getCategoryIdbyName(companyId, groupId, "Banners Promocionales");
		resultado = null;
		try {
			/*Solo en banca personas*/
			if (!banca.equalsIgnoreCase("BP")) {
				return null;
			}
			/* Extaremos los codigos Promocionales por DNI) */
			
			List<PromocionResponseBean> promociones=null;
			
			if(llamarWS){
				promociones= WsPromocionServiceUtil.realizarWsPromocion(identidadBean);
				registrarPromociones(promociones, renderRequest);
			}else{
				/*Leemos el bean de promociones de session*/
				promociones=traerPromociones(renderRequest);
			}
			
			if (promociones==null) {
				return null;
			}
			
			if (promociones.isEmpty()) {
				return null;
			}

			
			documentos = getLuceneContentSearch(renderRequest, categoryId, promociones);
			

			if (documentos != null && !documentos.isEmpty()) {
				Collections.shuffle(documentos);

				for (Document docs : documentos) {
					Document doc = docs;
					Long classPK;
					AssetEntry assetEntry;
					JournalArticle articulo;
					
					classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					assetEntry = AssetEntryLocalServiceUtil.getEntry(
							JournalArticle.class.getName(), classPK);
					recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry
							.getClassPK());
					articulo = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(),
							recurso.getArticleId());

					/* Verificamos si efectivamente es un banner que pertenece a los valores dados */
					String codigoPromocion = getParseValue("codigoPromocion", articulo,
							themeDisplay.getLanguageId());
					
					String bancaPromocion = getParseValue("banca", articulo,
							themeDisplay.getLanguageId());
					
					boolean isCorrect = false;
					if(bancaPromocion.equalsIgnoreCase(banca)){
						for (PromocionResponseBean prom : promociones) {
							if (prom.getCodigoPromocion().equalsIgnoreCase(codigoPromocion)) {
								resultado=articulo;
								isCorrect = true;
								break;
							} else {
								continue;
							}
						}
					}
					
					if (isCorrect) {
						break;
					}
				}
			}

			/* Esto es una lista de Liferay */
			/*
			 * if (UnmodifiableList.class.isAssignableFrom(bannersPromocionales.getClass())) {
			 * bannersPromocionales = ListUtil.copy(bannersPromocionales); }
			 */
		} catch (Exception e) {
			_log.error("Error al obtener getArticuloRamdom:" + e.toString());
		}
		return resultado;
	}


	/**
	 * Obtiene lucene content search.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param categoryId the category id
	 * @param codigosPromocionales the codigos promocionales
	 * @return lucene content search
	 */
	public static List<Document> getLuceneContentSearch(RenderRequest renderRequest,
			long categoryId, List<PromocionResponseBean> codigosPromocionales) {

		long companyId, groupId;
		ThemeDisplay themeDisplay;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();

		List<Document> documentos = null;
		Hits resultados;
		
		//Verificamos
		
		
		try {
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil
					.getHttpServletRequest(renderRequest));
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);

			// Query que busca que la cadena introducida por el usuairo está en uno de los campos
			// principales
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
			// searchQuery.addTerm(Field.TITLE, palabraClave);
			// searchQuery.addTerm(Field.DESCRIPTION, palabraClave);
			searchQuery.addTerm(Field.CONTENT,
					StringUtils.arrayToDelimitedString(codigosPromocionales.toArray(), " OR "));
			// searchQuery.addTerm(Field.PROPERTIES, palabraClave);

			// Querypara buscador solo JournalContents
			BooleanQuery journalContentQuery = BooleanQueryFactoryUtil.create(searchContext);
			journalContentQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			journalContentQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoryId);

			// Query
			// expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demás obligando a que
			// el enlace sea un AND en lugar de un OR
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			fullQuery.add(journalContentQuery, BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery, BooleanClauseOccur.MUST);
			// fullQuery.add(expandoQuery , BooleanClauseOccur.MUST);

			// Añadimos ordenación (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.CREATE_DATE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);
			
			
			
			resultados = SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(),
					companyId, fullQuery, sort, -1, -1);

			documentos = resultados.toList();
		} catch (Exception e) {
			_log.error("Error al realizar la busqueda Lucene:",e);
		}

		return documentos;
	}
	
	/**
	 * Registrar promociones.
	 * Fecha: 21/08/2013
	 *
	 * @param promociones the promociones
	 * @param portletRequest the portlet request
	 */
	public static void registrarPromociones(List<PromocionResponseBean> promociones,PortletRequest portletRequest){
		PortletSession pSession;
		pSession=portletRequest.getPortletSession();
		
		if(promociones!=null){
			if(!promociones.isEmpty() && promociones.size()>0){
				String json=JSONFactoryUtil.serialize(promociones);
				pSession.setAttribute("LIFERAY_SHARED_PROMOCIONES_BANNER",json, PortletSession.APPLICATION_SCOPE);
			}else{
				pSession.setAttribute("LIFERAY_SHARED_PROMOCIONES_BANNER","", PortletSession.APPLICATION_SCOPE);
			}
		}else{
			pSession.setAttribute("LIFERAY_SHARED_PROMOCIONES_BANNER","", PortletSession.APPLICATION_SCOPE);
		}
	}
	
	/**
	 * Traer promociones.
	 * Fecha: 21/08/2013
	 *
	 * @param portletRequest the portlet request
	 * @return the list
	 */
	public static List<PromocionResponseBean> traerPromociones(PortletRequest portletRequest){
			
			List<PromocionResponseBean> respuesta=null;
			
			PortletSession pSession;
			pSession=portletRequest.getPortletSession();
			
			Object fondosJSON=pSession.getAttribute("LIFERAY_SHARED_PROMOCIONES_BANNER",PortletSession.APPLICATION_SCOPE);
			
			if(Validator.isNotNull(fondosJSON)){
				try {
					JSONObject objetoPromociones=JSONFactoryUtil.createJSONObject((String)fondosJSON);
					JSONArray listaPromociones=  objetoPromociones.getJSONArray("list");
					
					Gson converter = new Gson();
					
	                Type type = new TypeToken<List<PromocionResponseBean>>(){}.getType();
	                respuesta =  converter.fromJson(listaPromociones.toString(), type );
			
				} catch (JSONException e) {
					_log.error("Error al obtener la lista de banners de la sesión:"+e.toString());
				}
			}
			
			return respuesta;
		}
}
