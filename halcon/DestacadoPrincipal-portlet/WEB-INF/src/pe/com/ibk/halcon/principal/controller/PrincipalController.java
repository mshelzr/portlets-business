package pe.com.ibk.halcon.principal.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import pe.com.ibk.halcon.principal.bean.ProductoDestacadoBean;
import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;
import pe.com.ibk.halcon.principal.service.SimuladorDepositoService;
import pe.com.ibk.halcon.principal.service.SimuladorFondosMutuosService;
import pe.com.ibk.halcon.principal.service.SimuladorHipotecarioService;
import pe.com.ibk.halcon.principal.service.SimuladorPersonalService;
import pe.com.ibk.halcon.principal.service.SimuladorVehicularService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class PrincipalController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class PrincipalController{
	//private RenderRequest render1;
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(PrincipalController.class);
	
	/** The Constant MODO_DPRI. */
	private static final String MODO_DPRI="DPRI";
	
	/** The Constant MODO_SIM_VEH. */
	private static final String MODO_SIM_VEH=SimuladoresUtil.SIMULADOR_VEHICULAR;
	
	/** The Constant MODO_SIM_PF. */
	private static final String MODO_SIM_PF=SimuladoresUtil.SIMULADOR_PLAZO_FIJO;
	
	/** The Constant MODO_SIM_FONDOS. */
	private static final String MODO_SIM_FONDOS=SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS;
	
	/** The Constant MODO_SIM_HIP. */
	private static final String MODO_SIM_HIP=SimuladoresUtil.SIMULADOR_HIPOTECARIO;
	
	/** The Constant MODO_SIM_PER. */
	private static final String MODO_SIM_PER=SimuladoresUtil.SIMULADOR_PERSONAL;
	
	/** The captcha service. */
	@Autowired
	private GenericManageableCaptchaService captchaService;
	
	/** The principal service. */
	@Autowired
	private PrincipalService principalService;
	
	/** The simulador vehicular service. */
	@Autowired
	private SimuladorVehicularService simuladorVehicularService;
	
	/** The simulador personal service. */
	@Autowired
	private SimuladorPersonalService simuladorPersonalService;
	
	/** The simulador deposito service. */
	@Autowired
	private SimuladorDepositoService simuladorDepositoService;
	
	/** The simulador fondos mutuos service. */
	@Autowired
	private SimuladorFondosMutuosService simuladorFondosMutuosService;
	
	/** The simulador hipotecario service. */
	@Autowired
	private SimuladorHipotecarioService simuladorHipotecarioService;
	
	@Autowired
	private CacheDestacadoUtil cacheJsonUtil;
	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	private String defaultView(RenderRequest renderRequest, RenderResponse renderResponse){
		JSonUtil.getPath(renderRequest);
		//Cargamos el tipo de simulador de la configuracion del modo edicion del portlet
		String comportamientoPortlet = renderRequest.getPreferences().getValue("tipoSimulador", "DPRI");
		
		SimuladoresUtil.inicializarHPC();
		//Verificamos de donde hemos entrado, si es de volver a simular o diferente
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		String strVolverSimular = ParamUtil.getString(httpReq, "vs");
		String productoDefault = renderRequest.getPreferences().getValue("tipoFichaSimulador", "");
		
		if (ValidatorUtils.isNull(strVolverSimular)) {
			SimuladorBean simulacionSession = SimuladoresUtil.traerSimulacion(renderRequest);
			if (simulacionSession != null && !simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS)) {
				SimuladoresUtil.eliminarSimulacion(renderRequest);
			}
		}else{
			renderRequest.setAttribute("vs", strVolverSimular);
		}
		
		renderRequest.setAttribute("utmSource", ParamUtil.getString(httpReq, "utm_source"));
		renderRequest.setAttribute("utmMedium", ParamUtil.getString(httpReq, "utm_medium"));
		renderRequest.setAttribute("utmCampaing", ParamUtil.getString(httpReq, "utm_campaign"));
		renderRequest.setAttribute("utmContent", ParamUtil.getString(httpReq, "utm_content"));
		renderRequest.setAttribute("productoDefault",principalService.getHPCbyURL(productoDefault));
			
		ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String ruta = themeDisplay.getLayout().getName(themeDisplay.getLocale());
		
		if(ruta.equals("PERSONAS")){
			
		}else{
			ruta="Personas - "+ruta;
		}
		
		renderRequest.setAttribute("simPaginaActual",ruta);
		/*TIPO DOCS*/
		renderRequest.setAttribute("DNI",SimuladoresUtil.CODIGO_DNI);
		renderRequest.setAttribute("CE",SimuladoresUtil.CODIGO_CARNE_EXTRANJERIA);
		/*TIPO MONEDAS*/
		renderRequest.setAttribute("SOLES",SimuladoresUtil.CODIGO_MONEDA_SOLES);
		renderRequest.setAttribute("DOLARES",SimuladoresUtil.CODIGO_MONEDA_DOLARES);
		renderRequest.setAttribute("EUROS",SimuladoresUtil.CODIGO_MONEDA_EUROS);
		/*Verificamos si DNI esta en session*/
		SessionBean sBean=SessionUtil.traerSession(renderRequest);

		if(sBean.getIndicador()==1){
			//Se verifica si hay session
			String jsonSesion=JSONFactoryUtil.serialize(sBean);
			renderRequest.setAttribute("SESSION",jsonSesion);
		}
		
		
		/*Se usará el mismo portlet para todos los simuladores 
		 * Se tomara en cuenta 6 comportamientos paar este portlet 
		 * -Como los 5 simuladores y como destacado principal
		 * DPRI:
		 * SIM-VEH:
		 * SIM-PF:
		 * SIM-FONDOS:
		 * SIM-HIP:
		 * SIM-PER:
		 * */
		
		String pagina="";
		
		
		//Para evaluar
		SimuladorBean simulacionSession = SimuladoresUtil.traerSimulacion(renderRequest);
		
		if(comportamientoPortlet.equalsIgnoreCase(MODO_DPRI)){
			//Destacado Principal
			List<ProductoDestacadoBean> lstDestacados=principalService.initDestacadoPrincipal(renderRequest);
			pagina="vistas/destacadoPrincipal";
			
			//Cargando valores de simuladores
				//Simulador Vehicular
			simuladorVehicularService.initVehicular(renderRequest);
			
			//Simulador personal
			simuladorPersonalService.initPersonal(renderRequest);
			
			//Simulador Plazo fijo
			simuladorDepositoService.initDeposito(renderRequest);
			
			//fondos Mutuos
			simuladorFondosMutuosService.initFondosMutuos(renderRequest);
			
			// Cresito Hipotecario
			simuladorHipotecarioService.initHipotecario(renderRequest);
			
			renderRequest.setAttribute("lstDestacados", lstDestacados);
			//Tiempo de cambio en entre Slider
			try {
//				JSonUtil jSonUtil=new JSonUtil();
				String tiempo=(String)cacheJsonUtil.getValor(JSonUtil.TIEMPO_TRANSICION_DESTACADO);
				renderRequest.setAttribute("tiempoSlider", Integer.parseInt(tiempo)*1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				_log.error("Error al traer el tiempo de cambio entre Slider en destacado Principal."+e.toString());
			}
		}else if(comportamientoPortlet.equalsIgnoreCase(MODO_SIM_VEH)){
			//Simulador Vehicular
			simuladorVehicularService.initVehicular(renderRequest);
			//Se verifica que exista en session para poder retonar el valor
			String json = "";
			if (ValidatorUtils.isNotNull(simulacionSession)) {
				json=JSONFactoryUtil.serialize(simulacionSession);
			}
			SimuladoresUtil.eliminarSimulacion(renderRequest);
			renderRequest.setAttribute("simuladorBean", json);
			//
			pagina="vistas/simuladorVehicular";
		}else if(comportamientoPortlet.equalsIgnoreCase(MODO_SIM_PER)){
			//Simulador Credito Personal
			simuladorPersonalService.initPersonal(renderRequest);
			//Se verifica que exista en session para poder retonar el valor
			String json = "";
			if (ValidatorUtils.isNotNull(simulacionSession)) {
				json=JSONFactoryUtil.serialize(simulacionSession);
			}
			SimuladoresUtil.eliminarSimulacion(renderRequest);
			renderRequest.setAttribute("simuladorBean", json);
			//
			pagina="vistas/simuladorPersonal";
		}else if(comportamientoPortlet.equalsIgnoreCase(MODO_SIM_HIP)){
			// Cresito Hipotecario
			simuladorHipotecarioService.initHipotecario(renderRequest);
			//Se verifica que exista en session para poder retonar el valor
			String json = "";
			if (ValidatorUtils.isNotNull(simulacionSession)) {
				json=JSONFactoryUtil.serialize(simulacionSession);
			}
			SimuladoresUtil.eliminarSimulacion(renderRequest);
			renderRequest.setAttribute("simuladorBean", json);
			//
			pagina="vistas/simuladorHipotecario";
		}else if(comportamientoPortlet.equalsIgnoreCase(MODO_SIM_FONDOS)){
			//Simulador Fondos mutuos
			//fondos Mutuos
			simuladorFondosMutuosService.initFondosMutuos(renderRequest);
			pagina="vistas/simuladorFondos";
		}else if(comportamientoPortlet.equalsIgnoreCase(MODO_SIM_PF)){
			//Simulador PLAZO FIJO
			simuladorDepositoService.initDeposito(renderRequest);
			//Se verifica que exista en session para poder retonar el valor
			String json = "";
			if (ValidatorUtils.isNotNull(simulacionSession)) {
				json=JSONFactoryUtil.serialize(simulacionSession);
			}
			SimuladoresUtil.eliminarSimulacion(renderRequest);
			renderRequest.setAttribute("simuladorBean", json);
			//
			pagina="vistas/simuladorDeposito";
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return pagina;
	}
	
	 
	 /**
 	 * Json.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 */
 	@ResourceMapping("validarCaptchaVehicular")
	 protected void json(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {
		String json;
		PrintWriter writer = null;
		
		json=simuladorVehicularService.verificarCaptcha(resourceRequest,captchaService);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		try {
			writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error al validar Captcha Vehicular:"+e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}	
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	 }
	 
	 /**
 	 * Json captcha personal.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 */
 	@ResourceMapping("validarCaptchaPersonal")
	 protected void jsonCaptchaPersonal(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {
		String json;
		PrintWriter writer = null;
		
		json=simuladorPersonalService.verificarCaptcha(resourceRequest, captchaService);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		try {
			writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error al validar Captcha Vehicular:"+e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}	
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	 }
	 
	 /**
 	 * Json captcha deposito.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 */
 	@ResourceMapping("validarCaptchaDeposito")
	 protected void jsonCaptchaDeposito(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {
		String json;
		PrintWriter writer = null;
		
		json=simuladorDepositoService.verificarCaptcha(resourceRequest, captchaService);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		try {
			writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error al validar Captcha Deposito:"+e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}	
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	 }
	 
 	/**
 	 * Json captcha fondos mutuos.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 */
 	@ResourceMapping("validarCaptchaFondosMutuos")
	 protected void jsonCaptchaFondosMutuos(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {
		String json;
		PrintWriter writer = null;
	
		json=simuladorFondosMutuosService.verificarCaptcha(resourceRequest, captchaService);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		try {
			writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error al validar Captcha Vehicular:"+e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}	
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	 }
	 

	 /**
 	 * Json captcha hipotecario.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 */
 	@ResourceMapping("validarCaptchaHipotecario")
	 protected void jsonCaptchaHipotecario(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {
		String json;
		PrintWriter writer = null;		
		json=simuladorHipotecarioService.verificarCaptcha(resourceRequest, captchaService);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		try {
			writer = resourceResponse.getWriter();
			writer.write(json);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error al validar Captcha Vehicular:"+e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}	
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	 }
	 
	 
	 
	 /**
 	 * Obtener imagen.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param resourceRequest the resource request
 	 * @param resourceResponse the resource response
 	 * @throws Exception the exception
 	 */
 	@ResourceMapping("traerCaptcha")
		public void obtenerImagen(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
			
			byte[] captchaChallengeAsJpeg = null;
			ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
			String captchaId = resourceRequest.getPortletSession().getId();
			
			
			BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, resourceRequest.getLocale());
			JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
			ServletOutputStream responseOutputStream = null;
			try {
			jpegEncoder.encode(challenge);
			
			captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
			resourceResponse.setContentType("image/jpeg");
				responseOutputStream = (ServletOutputStream) resourceResponse.getPortletOutputStream();
			
			responseOutputStream.write(captchaChallengeAsJpeg);
			responseOutputStream.flush();
			responseOutputStream.close();
			} catch (Exception e) {
				_log.error("Error : "+e.toString());
			} finally{
				IOUtils.closeQuietly(responseOutputStream);
			}
			//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
		}
}
