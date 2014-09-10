package pe.com.ibk.halcon.seccion.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import pe.com.ibk.halcon.seccion.bean.SeccionEditBean;
import pe.com.ibk.halcon.seccion.service.SeccionService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class SeccionController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class SeccionEditController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SeccionEditController.class);
	private static Integer indicadorPortlet=49;
	private static Integer indicadorController=2;
	
	/** The seccion service. */
	@Autowired
	SeccionService seccionService;

	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId, companyId;
		List<SeccionEditBean> productos = null;
		List<SeccionEditBean> productosSeleccionados = null;
		int numAdicionales;
		PortletPreferences preferencias = renderRequest.getPreferences();
		try {
			/* Recuperamos la lista de productos del Portal */
			groupId = themeDisplay.getScopeGroupId();
			companyId = themeDisplay.getCompanyId();
			List<AssetEntry> resultados = seccionService.getAssetsByName(companyId, groupId,
					"Productos");
			numAdicionales = 0;
			
			List<Integer> posicionesOcupadas=null;

			if (resultados != null) {
				for (AssetEntry assetEntry : resultados) {
					JournalArticleResource recurso;
					JournalArticle articulo;
					String registrado;
					Integer orden;
					recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry
							.getClassPK());
					articulo = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(),
							recurso.getArticleId());


					if (productos == null)
						productos = new ArrayList<SeccionEditBean>();
					SeccionEditBean aux = new SeccionEditBean();
					aux.setCodigo(articulo.getArticleId());
					aux.setNombre(assetEntry.getTitle(themeDisplay.getLocale()));
					aux.setRegitrado(true);
					numAdicionales++;
					/* Verificamos si esta registrado en properties o nada */
					registrado = preferencias.getValue("p-" + articulo.getArticleId(), "0");
					if (registrado.equalsIgnoreCase("0")) {
						aux.setRegitrado(false);
						numAdicionales--;
					}else{
						//Si es un producto listado
						/* Extraemos la posicion si existiera sino le metemos 0 */
						orden = Integer.valueOf(preferencias.getValue("pos-" + articulo.getArticleId(), "0"));
						aux.setOrden(orden);
						
						if(orden!=0){
							if(posicionesOcupadas==null)posicionesOcupadas=new ArrayList<Integer>();
							if(!posicionesOcupadas.contains(orden)){
								posicionesOcupadas.add(orden);
							}
						}
						
						if(productosSeleccionados==null)productosSeleccionados=new ArrayList<SeccionEditBean>();
						productosSeleccionados.add(aux);	
					}

					productos.add(aux);

				}
			}

			//Generamos el array de posiciones disponibles:
			List<Integer>posicionesDisponibles=null;
			if(numAdicionales>0){
				List<Integer> posicionesTotales=new ArrayList<Integer>();
				for(int i=1;i<=numAdicionales;i++){
					posicionesTotales.add(i);
				}
				//Intersectamos posiciones Totales con Posiciones ocupadas para obtener las posiciones disponibles
				
				if(posicionesOcupadas==null){
					posicionesDisponibles=posicionesTotales;
				}else{
					posicionesDisponibles=seccionService.subtract(posicionesTotales,posicionesOcupadas);
				}
				for (Integer integer : posicionesDisponibles) {
					System.out.println("Disponible:"+integer);
				}
				
				renderRequest.setAttribute("ordenes", posicionesDisponibles);
			}else{
				posicionesDisponibles=new ArrayList<Integer>();
				posicionesDisponibles.add(1);
				renderRequest.setAttribute("ordenes", posicionesDisponibles);
			}
			
			//Ordenamos la seccion
			if(numAdicionales>0){
				Comparator<SeccionEditBean> c = 
					    new Comparator<SeccionEditBean>()
					    {
					        @Override
					        public int compare( SeccionEditBean o1, SeccionEditBean o2 )
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

				ListUtil.sort(productosSeleccionados, c);
			}
			
			renderRequest.setAttribute("productos", productos);
			renderRequest.setAttribute("productosSeleccionados", productosSeleccionados);
			renderRequest.setAttribute("numAdicionales", numAdicionales);
			_log.info("titulo rec props:"+preferencias.getValue("titulo", ""));
			_log.info("slogan rec props:"+preferencias.getValue("slogan", ""));
			renderRequest.setAttribute("titulo", preferencias.getValue("titulo", ""));
			renderRequest.setAttribute("slogan", preferencias.getValue("slogan", ""));
			
			JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);

		} catch (Exception e) {
			_log.error("Error al leer la lista de paginas:" + e.toString());
			e.printStackTrace();
		}
		return "edit";
	}

	/**
	 * Registrar.
	 * Fecha: 18/02/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionRegistrarURL")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String codProducto,orden;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		codProducto = ParamUtil.getString(request, "cmbProducto", "0");
		orden=ParamUtil.getString(request, "cmbOrdenProducto", "0");
		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("p-" + codProducto, codProducto);
			preferencias.setValue("pos-" + codProducto, orden);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEditRegistra");
			_log.info("Preference Guardado:" + "p-" + codProducto+" pos-"+orden);
			JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEditRegistra");
			_log.error("Error al guardar el Preference:" + e.toString());
		}

	}

	/**
	 * Eliminar.
	 * Fecha: 18/02/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionEliminarURL")
	public void eliminar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String codProducto,orden;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		codProducto = ParamUtil.getString(request, "cmbProducto", "0");
		orden=ParamUtil.getString(request, "cmbOrdenProducto", "0");
		
		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("p-" + codProducto, "0");
			preferencias.setValue("pos-" + codProducto, "0");
			preferencias.store();
			SessionMessages.add(actionRequest, "successEditElimina");
			_log.info("Preference Eliminado:" + "p-" + codProducto+" pos-"+orden);
			JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEditElimina");
			_log.error("Error al eliminar el Preference:" + e.toString());
		}

	}

	/**
	 * Editar.
	 * Fecha: 18/02/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionEditarURL")
	public void editar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String titulo, slogan;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		titulo = ParamUtil.getString(request, "txtTitulo", "");
		slogan = ParamUtil.getString(request, "txtResumen", "");

		_log.info("titulo recuperado post:"+titulo);
		_log.info("slogan recuperado post:"+slogan);
		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("titulo", titulo);
			preferencias.setValue("slogan", slogan);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEditEdita");
			_log.info("Registrado correctamente.");
			JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEditEdita");
			_log.error("Error al editar el Preference:" + e.toString());
		}

	}
}
