package pe.com.interbank.halcon.cargar.tiendas.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import pe.com.interbank.halcon.cargar.tiendas.service.CargarTiendasService;
import pe.com.interbank.halcon.cargar.tiendas.util.Constantes;
import pe.com.interbank.halcon.cargar.tiendas.util.Util;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class CargarTiendas.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class CargarTiendasController extends MVCPortlet {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CargarTiendasController.class);
	private static Integer indicadorPortlet=8;
	private static Integer indicadorController=1;
	
	/** The cargar tiendas service. */
	@Autowired
	private CargarTiendasService cargarTiendasService;

	/**
	 * Defaultview. Fecha: 31-ene-2013
	 * 
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping
	public String defaultview(RenderRequest renderRequest, RenderResponse renderResponse,Model model) {
		JSonUtil.getPath(renderRequest);
		model.addAttribute("limite", Constantes.LIMITE);
		_log.info("ingreso a CargarTiendasController view donde model tiene los datos necesarios");
		JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}


	@ResourceMapping("obtenerRespuesta")
	public void obtenerRespuesta(ResourceRequest request,ResourceResponse response){
		HttpServletRequest r = PortalUtil.getHttpServletRequest(request);
		HttpSession session = r.getSession(false);
		String resp=(String) session.getAttribute("respuestaJson");		
		System.out.println("JSON resp obtenerRespuesta :" + resp);
		session.removeAttribute("respuestaJson");
		try {
			Util.returnJson(resp, response);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}
	
	
	
	/**
	 * Result wiev response. Fecha: 30-ene-2013
	 * 
	 * @param model the model
	 * @param respuesta the respuesta
	 * @return the string
	 */
	@RequestMapping(params = "action=verResultado")
	protected String resultWievResponse(RenderRequest request, RenderResponse response,Model model, @RequestParam("gsonString") String respuesta) {
		model.addAttribute("gsonString", respuesta);
		HttpServletRequest r = PortalUtil.getHttpServletRequest(request);
		HttpSession session = r.getSession(false);
		session.removeAttribute("respuestaJson");
		session.setAttribute("respuestaJson", respuesta);		
		System.out.println("JSON resultWievResponse :" + respuesta);
		JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		return "json";
	}
	
	/**
	 * Guardar documento. Fecha: 31-ene-2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws Exception the exception
	 */
	@ActionMapping(value = "guardarArchivo")
	public void guardarDocumento(ActionRequest resourceRequest, ActionResponse resourceResponse)
			throws Exception {
		Map<String, Object> i = new HashMap<String, Object>();
		_log.info("ingreso a CargarTiendasController guardarArchivo");
		try {
			i = cargarTiendasService.cargarTiendas(resourceRequest, resourceResponse);
		} catch (IOException e) {
			i.put("rep", false);
			i.put("error", 0);
			i.put("mensaje", "Error de Archivo al leer el formato");
			_log.error("Error ingresado en IOException:" + i);

			e.printStackTrace();
		} catch (Exception e) {
			i.put("rep", false);
			i.put("error", 0);
			i.put("mensaje", "Error interno del servidor ");
			_log.error("Error ingresado en Exception:" + i);

			e.printStackTrace();
		}

		String gsonString = Util.returnJson(i);
		JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
		resourceResponse.setRenderParameter("gsonString", gsonString);
		resourceResponse.setRenderParameter("action", "verResultado");
	}
	
	@ResourceMapping("verListaErrores")
	public void resourceOUT(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		cargarTiendasService.obtenerListaErrores(resourceRequest, resourceResponse);
		JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}
}
