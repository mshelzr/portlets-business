package pe.com.ibk.halcon.principal.service;

import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;

import pe.com.ibk.halcon.principal.bean.ProductoDestacadoBean;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.ext.portlet.halcon.model.Parametro;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface PrincipalService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface PrincipalService {
	
	/**
	 * Obtener promociones.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param banca the banca
	 * @return the list
	 */
	public   List<String> obtenerPromociones(RenderRequest renderRequest,String banca);
	
	/**
	 * Obtiene lucene content search.
	 * Fecha: 22/08/2013
	 *
	 * @param searchContext the search context
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param categoryId the category id
	 * @return lucene content search
	 */
	public  List<Document> getLuceneContentSearch(SearchContext searchContext, long companyId, long groupId, long categoryId);
	
	/**
	 * Obtiene articulos por documentos.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param listaDoc the lista doc
	 * @param languageId the language id
	 * @param themeDisplay the theme display
	 * @return articulos por documentos
	 */
	public  Map<String,JournalArticle> getArticulosPorDocumentos(RenderRequest renderRequest, List<Document> listaDoc, String languageId, ThemeDisplay themeDisplay);
	
	/**
	 * Obtiene parses the value.
	 * Fecha: 22/08/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parses the value
	 */
	public  String getParseValue(String fieldname, JournalArticle article, String languageID);
	
	/**
	 * Obtener bean destacado.
	 * Fecha: 22/08/2013
	 *
	 * @param art the art
	 * @param themeDisplay the theme display
	 * @param idProducto the id producto
	 * @param listaProductos the lista productos
	 * @return the producto destacado bean
	 */
	public  ProductoDestacadoBean obtenerBeanDestacado(JournalArticle art, ThemeDisplay themeDisplay, String idProducto,List<Parametro> listaProductos);
	
	/**
	 * Obtiene hP cby url.
	 * Fecha: 22/08/2013
	 *
	 * @param parametroURL the parametro url
	 * @return hP cby url
	 */
	public Integer getHPCbyURL(String parametroURL);
	
	/**
	 * Inits the destacado principal.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the list
	 */
	public  List<ProductoDestacadoBean>  initDestacadoPrincipal(RenderRequest renderRequest);
	
	/**
	 * Obtiene j son util.
	 * Fecha: 22/08/2013
	 *
	 * @return j son util
	 */
	public JSonUtil getjSonUtil();
}
