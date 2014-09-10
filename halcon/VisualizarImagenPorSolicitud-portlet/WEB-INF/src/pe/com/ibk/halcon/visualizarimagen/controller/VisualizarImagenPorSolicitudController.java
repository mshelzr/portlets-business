package pe.com.ibk.halcon.visualizarimagen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import pe.com.ibk.halcon.visualizarimagen.bean.ContenidoWebDisplay;

import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;


@Controller
@RequestMapping("VIEW")
public class VisualizarImagenPorSolicitudController {
 
	private static final Log _log = LogFactoryUtil.getLog(VisualizarImagenPorSolicitudController.class);
	
	@RequestMapping
	public String defaultView(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		String producto = ParamUtil.getString(PortalUtil.getOriginalServletRequest(httpServletRequest), "pro");
		boolean mostrarImagen = false;
		boolean mostrarLightBox = false;
		if (Validator.isNotNull(producto)) {
			String etiquetaProducto = SolicitudProductoLocalServiceUtil.getEtiquetaProductoByFriendlyURL(producto);
			
			if (Validator.isNotNull(etiquetaProducto)) {
				long companyId = themeDisplay.getCompanyId();
				long groupId = themeDisplay.getScopeGroupId();
				long categoryId = getCategoryIdByName("Productos", groupId);
				
				try {
					List<Document> document = getDocumentByLuceneSearch(httpServletRequest, companyId, groupId, etiquetaProducto, categoryId);
					if (document != null && !document.isEmpty()) {
						for (Document d : document) {
							JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(GetterUtil.getLong(d.get(Field.ENTRY_CLASS_PK)));
							
							com.liferay.portal.kernel.xml.Document documentXML = SAXReaderUtil.read(article.getContentByLocale(LocaleUtil.getDefault().getLanguage()));
							String etiquetaActual = getParseValue("codigoSiebel", documentXML);
							if (etiquetaActual.equalsIgnoreCase(etiquetaProducto)) {
								String urlImagen = getParseValue("imagenByProducto", documentXML);
								if (Validator.isNotNull(urlImagen)) {
									mostrarImagen = true;
									renderRequest.setAttribute("imagenProducto", themeDisplay.getURLPortal()+urlImagen);
									String idDetalleProducto = getParseValue("idDetalleProducto", documentXML);
									if (Validator.isNotNull(idDetalleProducto) && !idDetalleProducto.equals("0")) {
										renderRequest.setAttribute("idDetalleProducto", idDetalleProducto);
										mostrarLightBox = true;
									}
									renderRequest.setAttribute("mostrarLightBox", mostrarLightBox);
									break;
								}
							}
						}
				    }
				} catch (Exception e) {
					_log.error("No se pudo obtener la imagen para mostrar",e);
				}
			}
		}
		renderRequest.setAttribute("mostrarImagen", mostrarImagen);	
		return "view";
	}
	
	private List<Document> getDocumentByLuceneSearch(HttpServletRequest httpServletRequest,long companyId,
			long groupId,String etiqueta,long categoryId) throws SearchException, ParseException{
		
		SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);
		Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);
		
		BooleanQuery booleanQuery = BooleanQueryFactoryUtil.create(searchContext);
		booleanQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
		booleanQuery.addRequiredTerm(Field.GROUP_ID, groupId);
		booleanQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
		booleanQuery.addRequiredTerm(Field.STATUS, WorkflowConstants.STATUS_APPROVED);
		booleanQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoryId);
		
		BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
		searchQuery.addTerm(Field.CONTENT, etiqueta);
		
		BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
		fullQuery.add(booleanQuery, BooleanClauseOccur.MUST);
		fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
		
		searchContext.setKeywords(fullQuery.toString());
		Hits hits = indexer.search(searchContext);
		return hits.toList();
	}
	
	private long getCategoryIdByName(String name,long groupId){
		try {
			List<AssetCategory> lista = AssetCategoryLocalServiceUtil.search(groupId, name, new String[]{}, -1, -1);
			if (!lista.isEmpty()) {
				return lista.get(0).getCategoryId();
			}
		} catch (Exception e) {
			_log.error("Sucedio un error al obtener el nombre de la categoria",e);
		}
		return 0;
	}
	
	private String getParseValue(String fieldname,com.liferay.portal.kernel.xml.Document documentXML) {
		String value = StringPool.BLANK;
		try {
			Node node = documentXML.selectSingleNode("/root/dynamic-element[@name='"
							+ fieldname + "']/dynamic-content");
			if (Validator.isNotNull(node)) {
				value = node.getText();
			}
		} catch (Exception e) {
			_log.error("No se pudo obtener el valor de la estructura",e);
		}
		return value;
	}
	
	
	@RenderMapping(params="action=mostrarContenido")
	public String mostrarContenidoWebPorSolicitud(RenderRequest renderRequest){
		boolean mostrarContenido = false;
		String idDetalleProducto = ParamUtil.getString(renderRequest, "idDetalleProducto");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (Validator.isNotNull(idDetalleProducto) && !idDetalleProducto.equals("0")) {
			//Obtenemos solo 2 tabs del contenido web
			try {
				JournalArticle article = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(), idDetalleProducto);
				com.liferay.portal.kernel.xml.Document documentXML = SAXReaderUtil.read(article.getContentByLocale(LocaleUtil.getDefault().getLanguage()));
				List<Element> dynamicElementElements =  documentXML.getRootElement().elements("dynamic-element");
				
				List<ContenidoWebDisplay> listaContenidoWeb = new ArrayList<ContenidoWebDisplay>();
				ContenidoWebDisplay display;
				boolean isSaltoLinea = false;
				int contador = 1;
				for (Element e : dynamicElementElements) {
					display = new ContenidoWebDisplay();
					Element element = e.element("dynamic-content");
					display.setTitulo(element.getText());
					
					isSaltoLinea = display.getTitulo().matches(".*[;].*");
					if (isSaltoLinea) {
						display.setTituloHTML(display.getTitulo().replaceAll(";", "<br/>"));
						display.setTitulo(display.getTitulo().replaceAll(";", ""));
					}
					display.setSaltoLinea(isSaltoLinea);
					element = e.element("dynamic-element").element("dynamic-content");
					display.setContenido(element.getText());
					listaContenidoWeb.add(display);
					if (contador == 2) {
						break;
					}
					contador++;
				}
				renderRequest.setAttribute("listaContenidoWeb", listaContenidoWeb);
				mostrarContenido = true;
			} catch (Exception e) {
				_log.error("No se pudo obtener el contenido web",e);
			}
		}
		renderRequest.setAttribute("mostrarContenido", mostrarContenido);
		return "contenidoweb";
	}
}
