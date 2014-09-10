package pe.com.ibk.halcon.seccion.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.seccion.bean.SeccionBean;
import pe.com.ibk.halcon.seccion.service.SeccionService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.webserver.WebServerServletTokenUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;


/**
 * Portlet implementation class SeccionController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class SeccionController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SeccionController.class);
	private static Integer indicadorPortlet=49;
	private static Integer indicadorController=1;
	private static final String KEY_CACHE="com.liferay.portlet.journalcontent.util.JournalContent";
	
	/** The seccion service. */
	@Autowired
	private SeccionService seccionService;

	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		Layout actual;
		List<SeccionBean> hijos;
		List<SeccionBean> adicionales;
		ThemeDisplay themeDisplay;
		long groupId, companyId;

		PortletPreferences preferencias = renderRequest.getPreferences();
		try {
			hijos = null;
			adicionales = null;
			themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			actual = themeDisplay.getLayout();
			
			hijos=(List<SeccionBean>)MultiVMPoolUtil.get(KEY_CACHE, "seccionHermanos"+actual.getLayoutId());
			
			if(hijos==null){
				if (actual != null) {
					if (actual.getChildren() != null) {
						for (Layout page : actual.getChildren()) {
							try {
								if (!page.isPrivateLayout() && !page.isHidden()) {
									if (hijos == null) {
										hijos = new ArrayList<SeccionBean>();
									}
									page.setName(page.getName(themeDisplay.getLocale()));
									/* Extraemos el producto asociado la página */
									String codProducto = (String) page.getExpandoBridge().getAttribute(
											"idContenidoProducto");
									
									if (Validator.isNotNull(codProducto)) {
										SeccionBean aux = new SeccionBean();
										aux.setNombre(page.getName(themeDisplay.getLocale()));
										
										JournalArticle articulo = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(),codProducto, WorkflowConstants.STATUS_APPROVED);
										String idContenidoSeccion = seccionService.getParseValue("idContenidoSeccion", articulo,themeDisplay.getLanguageId());
										aux.setIdContenidoSeccion(idContenidoSeccion);
										aux.setIdImagen(page.getIconImageId());
										if (page.getIconImageId() > 0) {
											String urlImagen = themeDisplay.getPathImage()
													+ "/layout_icon?img_id="
													+ page.getIconImageId()
													+ "&t="
													+ WebServerServletTokenUtil.getToken(page
															.getIconImageId());
											aux.setUrlImagen(urlImagen);
										}

										hijos.add(aux);
										
									}
								}
							} catch (Exception e) {
								_log.error("Error al leer hijos:"+e.toString());
							}
						}
					}
					MultiVMPoolUtil.put(KEY_CACHE, "seccionHermanos"+actual.getLayoutId(), hijos);
				}
			}

			renderRequest.setAttribute("hermanos", hijos);
			
			
			/* Envio los productos adicionales */
			adicionales=(List<SeccionBean>)MultiVMPoolUtil.get(KEY_CACHE, "seccionAdicionales"+actual.getLayoutId());
			
			if(adicionales==null){
				//No esta en cache
				groupId = themeDisplay.getScopeGroupId();
				companyId = themeDisplay.getCompanyId();
				List<AssetEntry> resultados = seccionService.getAssetsByName(companyId, groupId,
						"Productos");

				if (resultados != null) {
					for (AssetEntry assetEntry : resultados) {
						JournalArticleResource recurso;
						JournalArticle articulo;
						String registrado;
						Integer orden;

						/* Extraemos el producto asociado la página */
						try {
							recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry
									.getClassPK());
							articulo = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(),
									recurso.getArticleId());
							
							String pageAsociada = seccionService.getParseValue("idPaginaAsociada",
									articulo, themeDisplay.getLanguageId());
							if (Validator.isNull(pageAsociada)) {
								continue;
							}
							
							Layout pAsoc = null;
							
							try{
								pAsoc=LayoutLocalServiceUtil.getLayout(groupId, false,	Long.valueOf(pageAsociada.replaceAll("@public", "")));
							}catch(Exception e){
								_log.error("Verificar la url de página asociada al articulo:"+articulo.getArticleId(),e);
							}
							
							if(pAsoc==null){
								continue;
							}

							if (adicionales == null) {
								adicionales = new ArrayList<SeccionBean>();
							}
							SeccionBean aux = new SeccionBean();
							aux.setNombre(pAsoc.getName(themeDisplay.getLocale()));
							
							String idContenidoSeccion = seccionService.getParseValue(
									"idContenidoSeccion", articulo, themeDisplay.getLanguageId());
							aux.setIdContenidoSeccion(idContenidoSeccion);
							aux.setIdImagen(pAsoc.getIconImageId());
							if (pAsoc.getIconImageId() > 0) {
								String urlImagen = themeDisplay.getPathImage() + "/layout_icon?img_id="
										+ pAsoc.getIconImageId() + "&t="
										+ WebServerServletTokenUtil.getToken(pAsoc.getIconImageId());
								aux.setUrlImagen(urlImagen);
							}
							/* Verifico si esta en properties registrado */
							registrado = preferencias.getValue("p-" + articulo.getArticleId(), "0");
							
							if (!registrado.equalsIgnoreCase("0")) {
								/* Extraemos la posicion si existiera sino le metemos 0 */
								orden = Integer.valueOf(preferencias.getValue("pos-" + articulo.getArticleId(), "0"));
								aux.setOrden(orden);
								
								adicionales.add(aux);
							
							}
						} catch (Exception e) {
							_log.error("Error al leer la lista de paginas:" + e.toString() +" del  Entry CPK " + assetEntry.getClassPK() + " :"
									+ assetEntry.getTitle(themeDisplay.getLocale()),e);
						}

					}

					//Ordenamos segun posicion
					if(adicionales!=null){
						Comparator<SeccionBean> c = 
							    new Comparator<SeccionBean>()
							    {
							        @Override
							        public int compare( SeccionBean o1, SeccionBean o2 )
							        {
							        	Integer ordeno1=(Integer)o1.getOrden();
							        	Integer ordeno2=(Integer)o2.getOrden();
							        	//0= Son iguales     -1: o1 <o2     1: o1>o2
							        	//Para hacer que si no tiene orden vaya al ultimo
							            if(ordeno1==0)ordeno1=9999;
							            if(ordeno2==0)ordeno2=9999;
							            
							            if(ordeno1<ordeno2) return -1;
							            else if (ordeno1>ordeno2) return 1;
							            else return 0;
							        }
							    };

						ListUtil.sort(adicionales, c);
					}
					
					MultiVMPoolUtil.put(KEY_CACHE, "seccionAdicionales"+actual.getLayoutId(), adicionales);
				}
			}
			
			renderRequest.setAttribute("adicionales", adicionales);
			renderRequest.setAttribute("titulo", preferencias.getValue("titulo", ""));
			renderRequest.setAttribute("slogan", preferencias.getValue("slogan", ""));
		} catch (Exception e) {
			_log.error("Error al procesar",e);
		}
		JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}
}