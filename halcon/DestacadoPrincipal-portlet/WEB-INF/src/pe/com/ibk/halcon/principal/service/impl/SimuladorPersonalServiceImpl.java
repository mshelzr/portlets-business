package pe.com.ibk.halcon.principal.service.impl;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;
import pe.com.ibk.halcon.principal.service.SimuladorPersonalService;
import pe.com.ibk.halcon.principal.util.ValidarPeticionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.portlet.PortletProps;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;



// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SimuladorPersonalServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorPersonalServiceImpl implements SimuladorPersonalService {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(SimuladorPersonalServiceImpl.class);
	
	/** The Constant PAGE_SIM_PER. */
	private static final String PAGE_SIM_PER =PortletProps.get("destacado.simulador.personal.page");
//	JSonUtil jSonUtil=new JSonUtil();
	/** The principal service. */
@Autowired
	private PrincipalService principalService;
	
	@Autowired
	private CacheDestacadoUtil cachejsonUtil;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorPersonalService#initPersonal(javax.portlet.RenderRequest)
	 */
	public void initPersonal(RenderRequest renderRequest){
		try{
			
			//monto del credito
			RangoBean RANGO_VALOR_PERSONAL_SIM_PER_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_PERSONAL_SIM_PER_SOLES);
			RangoBean RANGO_VALOR_PERSONAL_SIM_PER_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_PERSONAL_SIM_PER_DOLARES);

			
			renderRequest.setAttribute("RANGO_VALOR_PERSONAL_SIM_PER_SOLES"  , getJSONValues(RANGO_VALOR_PERSONAL_SIM_PER_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_PERSONAL_SIM_PER_DOLARES", getJSONValues(RANGO_VALOR_PERSONAL_SIM_PER_DOLARES));
		}catch(Exception e){
			_log.error("Error al cargar configuración de simulador personal :"+e.toString());
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorPersonalService#verificarCaptcha(javax.portlet.ResourceRequest, com.octo.captcha.service.multitype.GenericManageableCaptchaService)
	 */
	public String verificarCaptcha(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService){
		 
		String captcha,codTipoDoc,numDocumento,codTipoMoneda,codTipoCuota,codTipoCredito,montoCredito,plazoCredito,utmSource,utmMedium,utmCampaing,utmContent,nombreTipoCredito;
		boolean captchaPassed;
		JSONObject json = JSONFactoryUtil.createJSONObject();
 
		captcha = ParamUtil.getString(resourceRequest, "txtcaptchaPersonal");
		 try{
			 captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);
			// captchaPassed = true;
		 }catch(Exception e){
			 _log.error("Codigo Captcha ya ha sido usado, reingresarlo.");
			 captchaPassed=false;
		 }
		
		codTipoDoc = ParamUtil.getString(resourceRequest, "docCrePersonalHidden");
		numDocumento = ParamUtil.getString(resourceRequest, "documentSimPersonal");
		codTipoMoneda = ParamUtil.getString(resourceRequest, "hiddenSimPertMoneda");
		codTipoCuota = ParamUtil.getString(resourceRequest, "tipoCuotaHidden");
		codTipoCredito = ParamUtil.getString(resourceRequest, "tipoCreditoHidden");
		nombreTipoCredito = ParamUtil.getString(resourceRequest, "tipoCreditoHiddenText");
		montoCredito = ParamUtil.getString(resourceRequest, "montoCredito");
		plazoCredito = ParamUtil.getString(resourceRequest, "plazoCreditoPrestamo");
		
		utmSource=ParamUtil.getString(resourceRequest, "utmSource");
		utmMedium=ParamUtil.getString(resourceRequest, "utmMedium");
		utmCampaing=ParamUtil.getString(resourceRequest, "utmCampaing");
		utmContent=ParamUtil.getString(resourceRequest, "utmContent");
		
		if(codTipoDoc.equalsIgnoreCase("0")){
			codTipoDoc="";
			numDocumento="";
		}
		
		if(!captchaPassed){
			json.put("error",  "true").put("mensaje",  "Código captcha incorrecto.");
		}else{
			// Generamos el bean registrandolo en la session
			SimuladorBean simPersonal = new SimuladorBean();
			simPersonal.setTipoDocumento(codTipoDoc);
			simPersonal.setNumeroDocumento(numDocumento);
			simPersonal.setTipoMoneda(codTipoMoneda);
			simPersonal.setTipoCuota(codTipoCuota);
			simPersonal.setTipoCredito(codTipoCredito);
			simPersonal.setNombreCreditoProducto(nombreTipoCredito.replaceAll("<br />", "").replaceAll("<BR />", ""));
			simPersonal.setPlazoCredito(plazoCredito);
			simPersonal.setMontoPrestamo(montoCredito);
			simPersonal.setUtmSource(utmSource);
			simPersonal.setUtmMedium(utmMedium);
			simPersonal.setUtmCampaing(utmCampaing);
			simPersonal.setUtmContent(utmContent);
			simPersonal.setTipoSimulador(SimuladoresUtil.SIMULADOR_PERSONAL);
			SimuladoresUtil.registrarSimulacion(resourceRequest, simPersonal);
			
			//Registramos el DNI en sesion
			SessionBean session=new SessionBean();
			session.setTipoDoc(codTipoDoc);
			session.setNumDoc(numDocumento);
			SessionUtil.registrarSession(session, resourceRequest,true);
			
			Boolean peticionValida = ValidarPeticionUtil.validarGestionPeticion(resourceRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.personal"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_PRESTAMO);
			
			if (peticionValida) {
				json.put("error", "false");
				json.put("url", PAGE_SIM_PER);
			}else {
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SIMULADOR","true", PortletSession.APPLICATION_SCOPE);
				//Aqui redirecciona a la pagina de error
				json.put("error", "redirecciona");
				json.put("url", ValidarPeticionUtil.PAGINA_ERROR);
			}
			
		}
		return json.toString();
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
}
