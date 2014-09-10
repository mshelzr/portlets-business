package pe.com.ibk.halcon.principal.service.impl;

import java.util.ResourceBundle;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;
import pe.com.ibk.halcon.principal.service.SimuladorFondosMutuosService;
import pe.com.ibk.halcon.principal.util.ValidarPeticionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.portlet.PortletProps;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SimuladorFondosMutuosServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorFondosMutuosServiceImpl  implements SimuladorFondosMutuosService {

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(SimuladorFondosMutuosServiceImpl.class);
	
	/** The Constant PAGE_SIM_FONDOS. */
	private static final String PAGE_SIM_FONDOS=PortletProps.get("destacado.simulador.fondosmutuos.page");
//	JSonUtil jSonUtil=new JSonUtil();
	/** The principal service. */
	@Autowired
	private PrincipalService principalService;
	
	@Autowired
	private CacheDestacadoUtil cachejsonUtil;
	
	/** The captcha service. */
	@Autowired
	private GenericManageableCaptchaService captchaService;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorFondosMutuosService#verificarCaptcha(javax.portlet.ResourceRequest, com.octo.captcha.service.multitype.GenericManageableCaptchaService)
	 */
	@Override
	public String verificarCaptcha(ResourceRequest resourceRequest,
			GenericManageableCaptchaService captchaService) {
		boolean captchaPassed = false;
		JSONObject json;

		String captcha = ParamUtil.getString(resourceRequest, "codCaptchaFondosMutuos");
		
		
		try{
			captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);
			//captchaPassed = true;
		 
		 }catch(Exception e){
			 _log.error("Codigo Captcha ya ha sido usado, reingresarlo.");
			 captchaPassed=false;
		 }
		
		 
		json = JSONFactoryUtil.createJSONObject();
		if (!captchaPassed) {
			ThemeDisplay themeDisplay=(ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ResourceBundle  rb = ResourceBundle.getBundle( "content.Language", themeDisplay.getLocale() );
			
			json.put("error", "true");
			json.put("mensaje", rb.getString("destacado.error.documento.captcha"));
			return json.toString();
		} else {
			return validarSesionFondosMutuos(resourceRequest, captchaService);
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorFondosMutuosService#validarSesionFondosMutuos(javax.portlet.ResourceRequest, com.octo.captcha.service.multitype.GenericManageableCaptchaService)
	 */
	@Override
	public String validarSesionFondosMutuos(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService){
		int total_inversion		= 	Integer.parseInt(resourceRequest.getParameter("monto_invertir"));
		String _tipoMoneda			=	resourceRequest.getParameter("tipoMonedaSimFondosMutuoshidden");
		String tipoMoneda = "10";
		if (_tipoMoneda.equals("1")) {
			tipoMoneda = "00";
		}
		int tiempo_inversion 	=	Integer.parseInt(resourceRequest.getParameter("tiempo_invertir"));

		int pregunta1,pregunta2,pregunta3 = 0;
		pregunta1 = Integer.parseInt(resourceRequest.getParameter("fondosSimInvertidoHidden"));
		pregunta2 = Integer.parseInt(resourceRequest.getParameter("fondosSimConocimientoHidden"));
		pregunta3 = Integer.parseInt(resourceRequest.getParameter("fondosSimVariacionesHidden"));	
		
		String textoPregunta1  =  resourceRequest.getParameter("textfondosSimInvertidoHidden");
		String textoPregunta2  =  resourceRequest.getParameter("textfondosSimConocimientoHidden");
		String textoPregunta3  =  resourceRequest.getParameter("textfondosSimVariacionesHidden");
		
		int total_puntos =  pregunta1 + pregunta2 + pregunta3;
		
		//Aumentamos dependiendo por el tiempo de inversion
		switch (tiempo_inversion) {
			case 1:
				total_puntos += 2;
				break;
			case 2:
			case 3:
			case 4:
				total_puntos += 4;
				break;
			case 5:
			case 6:
				total_puntos += 6;
				break;
			default:
				total_puntos += 8;
		}
		
		JSONObject json = JSONFactoryUtil.createJSONObject();
		SimuladorBean simFondos = new SimuladorBean();

		simFondos.setOpcion1(String.valueOf(textoPregunta1));
		simFondos.setOpcion2(String.valueOf(textoPregunta2));
		simFondos.setOpcion3(String.valueOf(textoPregunta3));
		simFondos.setTipoMoneda(_tipoMoneda);
		simFondos.setTipoMonedaFondosMutuos(tipoMoneda);
		simFondos.setTotalPuntos(total_puntos);
		simFondos.setPlazoCredito(String.valueOf(tiempo_inversion));
		simFondos.setTipoSimulador(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS);
		simFondos.setValorBien(String.valueOf(total_inversion));
		SimuladoresUtil.registrarSimulacion(resourceRequest, simFondos);
		
		Boolean peticionValida = ValidarPeticionUtil.validarGestionPeticion(resourceRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.fondos"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_FON_MUTUOS);
		
		if (peticionValida) {
			if (total_puntos >= 5 && total_puntos <= 6) {
				json.put("url", PortletProps.get("destacado.simulador.plazofijo.page"));
				simFondos.setTipoSimulador(SimuladoresUtil.SIMULADOR_PLAZO_FIJO);
				simFondos.setValorBien(String.valueOf(total_inversion));
				simFondos.setTipoMoneda(_tipoMoneda);
				simFondos.setIsFondoMutuo(true);
				SimuladoresUtil.registrarSimulacion(resourceRequest, simFondos);
			}else{
				json.put("url", PAGE_SIM_FONDOS);
			}
		}else {
			resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SIMULADOR","true", PortletSession.APPLICATION_SCOPE);
			//Aqui redirecciona a la pagina de error
			json.put("url", ValidarPeticionUtil.PAGINA_ERROR);
		}
			
		return json.toString();
	}

	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorFondosMutuosService#initFondosMutuos(javax.portlet.RenderRequest)
	 */
	public void initFondosMutuos(RenderRequest renderRequest){
		try{
			RangoBean RANGO_PLAZO_FONDOS_MUTUOS_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_FONDOS_MUTUOS_SOLES);
			RangoBean RANGO_PLAZO_FONDOS_MUTUOS_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_FONDOS_MUTUOS_DOLARES);
			String pregunta1_fondos = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_PREGUNTA1_FONDOS_MUTUOS);
			String pregunta2_fondos = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_PREGUNTA2_FONDOS_MUTUOS);
			String pregunta3_fondos = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_PREGUNTA3_FONDOS_MUTUOS);
			
			renderRequest.setAttribute("RANGO_PLAZO_FONDOS_MUTUOS_SOLES"  , getJSONValues(RANGO_PLAZO_FONDOS_MUTUOS_SOLES));
			renderRequest.setAttribute("RANGO_PLAZO_FONDOS_MUTUOS_DOLARES", getJSONValues(RANGO_PLAZO_FONDOS_MUTUOS_DOLARES));
			
			renderRequest.setAttribute("pregunta1Fondos", pregunta1_fondos);
			renderRequest.setAttribute("pregunta2Fondos", pregunta2_fondos);
			renderRequest.setAttribute("pregunta3Fondos", pregunta3_fondos);
		}catch(Exception e){
			_log.error("Error al cargar configuración de simulador vehicular:"+e.toString());
		}
	}
	
	/**
	 * Obtiene jSON values.
	 * Fecha: 22/08/2013
	 *
	 * @param rango the rango
	 * @return jSON values
	 */
	private String getJSONValues(RangoBean rango){
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		try{
			jsonObject.put("inicio", rango.getValorInicial());
			jsonObject.put("fin", rango.getValorFinal());
			jsonObject.put("incremento", rango.getIncremento());
		}catch(Exception e){
			_log.error("Error al  convertir en bean en JSON:"+e.toString());
		}
		return jsonObject.toString();
	}
	//**********************************
}
