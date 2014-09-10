package pe.com.interbank.halcon.carga.masiva.controller;

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

import pe.com.interbank.halcon.carga.masiva.service.CargaMasivaService;
import pe.com.interbank.halcon.carga.masiva.util.Constantes;
import pe.com.interbank.halcon.carga.masiva.util.Util;

import com.exp.portlet.halcon.utils.AuditoriaHalcon;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CargaMasivaController.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class CargaMasivaController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CargaMasivaController.class);
	private static Integer indicadorPortlet=6;
	private static Integer indicadorController=1;
	
	/** The carga masiva service. */
	@Autowired
	private CargaMasivaService cargaMasivaService;

	/**
	 * Defaultview. Fecha: 31-ene-2013
	 * 
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping

	public String defaultview(Model model,RenderRequest request) {
		model.addAttribute("limite", Constantes.LIMITE);
		HttpServletRequest resq = PortalUtil.getHttpServletRequest(request);
		//***********************
		JSonUtil.getPath(request);
		//************************
//		AuditoriaHalcon.auditar("saludo", "CargaMasivaController", " CargaMasivaControllerPK ", "un saludo a todos", null, resq);
		
//		cargaMasivaService.probar();
		
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("ingresando", "datos");
		jsonObject.put("de", "prueba");
		jsonObject.put("json", "prueba");
		jsonObject.put("add", "info");
		
//		AuditoriaHalcon.auditar("saludo",this.getClass().getName(), " CargaMasivaControllerPK ", "un saludo a todos", jsonObject, resq);
		
		AuditoriaHalcon.auditar(ActionKeys.ACCESS_IN_CONTROL_PANEL, " un saludo a todos ", jsonObject, resq);
		
//		cargaMasivaService.auditoriaPrueba(resq);
		_log.info("ingreso a CargaMasivaController view donde model tiene los datos necesarios.");
		JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		return "view";
	}

	
	@ResourceMapping("obtenerRespuesta")
	public void obtenerRespuesta(ResourceRequest request,ResourceResponse response){
		HttpServletRequest r = PortalUtil.getHttpServletRequest(request);
		HttpSession session = r.getSession(false);
		String resp=(String) session.getAttribute("respuestaJson");		
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
	public void guardarDocumento(ActionRequest resourceRequest, ActionResponse resourceResponse) {

		Map<String, Object> i = null;
		String gsonString = null;
		_log.info("ingreso a CargaMasivaController guardarArchivo");
		try {
//			Thread.sleep(10000);
			i = cargaMasivaService.cargarArchivoSocios(resourceRequest, resourceResponse);
		} catch (Exception e) {
			if (i == null) {
				i = new HashMap<String, Object>();
			}
			i.put("rep", false);
			i.put("error", 0);
			e.printStackTrace();
			i.put("mensaje", "Error interno del servidor :" + e.getMessage());
			_log.error("Error ingresado en Exception:" + i);
		}
		gsonString = Util.returnJson(i);
		JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
		resourceResponse.setRenderParameter("gsonString", gsonString);
		resourceResponse.setRenderParameter("action", "verResultado");
	}

	@ResourceMapping("verListaErrores")
	public void resourceOUT(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		cargaMasivaService.obtenerListaErrores(resourceRequest, resourceResponse);
		JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}
	
}
