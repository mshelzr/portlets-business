package pe.com.ibk.halcon.principal.service.impl;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;
import pe.com.ibk.halcon.principal.service.SimuladorVehicularService;
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
 * The Class SimuladorVehicularServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorVehicularServiceImpl implements SimuladorVehicularService {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(SimuladorVehicularServiceImpl.class);
	
	/** The Constant PAGE_SIM_VEH. */
	private static final String PAGE_SIM_VEH=PortletProps.get("destacado.simulador.vehicular.page");
//	JSonUtil jSonUtil=new JSonUtil();
	/** The principal service. */
	@Autowired
	private PrincipalService principalService;
	
	@Autowired
	private CacheDestacadoUtil cachejsonUtil;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorVehicularService#initVehicular(javax.portlet.RenderRequest)
	 */
	public void initVehicular(RenderRequest renderRequest){
		try{
			//Valor del Vehiculo
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES);
			RangoBean RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES);
			
			//Cuota inicial vehiculo
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES);
			RangoBean RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES);
			
			//plazo del credito
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES);
			RangoBean RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES);
			
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES"  , getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES", getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES"  , getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES", getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES"  , getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES", getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES"  , getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES", getJSONValues(RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES));
			
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES"  , getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES", getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES"  , getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES", getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES"  , getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES", getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES"  , getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES", getJSONValues(RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES));
			
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES"  , getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES", getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES"  , getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES", getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES"  , getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES", getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES"  , getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES));
			renderRequest.setAttribute("RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES", getJSONValues(RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES));
			
		}catch(Exception e){
			_log.error("Error al cargar configuración de simulador vehicular:"+e.toString());
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorVehicularService#verificarCaptcha(javax.portlet.ResourceRequest, com.octo.captcha.service.multitype.GenericManageableCaptchaService)
	 */
	public String verificarCaptcha(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService){
		 String captcha,aviso,codTipoDoc,codTipoCredito,codTipoCuota,
		 codTipoMoneda,codTipoSeguro,plazoCredito,valorAuto,
		 cuotaInicial,numDocumento,utmSource,utmMedium,utmCampaing,utmContent,nombreTipoCredito;
		 boolean captchaPassed;
		 JSONObject json;
		 
		 captcha =ParamUtil.getString(resourceRequest, "txtCaptchaVehicular");
		 try{
			 captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);
			 // captchaPassed = true;
		 }catch(Exception e){
			 _log.error("Codigo Captcha ya ha sido usado, reingresarlo.");
			 captchaPassed=false;
		 }
		 codTipoDoc=ParamUtil.getString(resourceRequest, "hcmbTipDocVehicular");
		 codTipoCredito=ParamUtil.getString(resourceRequest, "hoptTipCreditoVehicular");
		 nombreTipoCredito=ParamUtil.getString(resourceRequest, "hoptTipCreditoVehicularText");
		 codTipoCuota=ParamUtil.getString(resourceRequest, "hoptTipCuotaVehicular");
		 codTipoMoneda=ParamUtil.getString(resourceRequest, "hoptTipMonedaVehicular");
		 codTipoSeguro=ParamUtil.getString(resourceRequest, "hoptTipSeguroVehicular");
		 plazoCredito=ParamUtil.getString(resourceRequest, "sliderPlazoCreditoVehicular");
		 valorAuto=ParamUtil.getString(resourceRequest, "sliderValorAuto");
		 cuotaInicial=ParamUtil.getString(resourceRequest, "sliderValorInicial");
		 numDocumento=ParamUtil.getString(resourceRequest, "txtNumDocVehicular");
		 
		 utmSource=ParamUtil.getString(resourceRequest, "utmSource");
		 utmMedium=ParamUtil.getString(resourceRequest, "utmMedium");
		 utmCampaing=ParamUtil.getString(resourceRequest, "utmCampaing");
		 utmContent=ParamUtil.getString(resourceRequest, "utmContent");
		 
		 if(codTipoDoc.equalsIgnoreCase("0")){
				codTipoDoc="";
				numDocumento="";
		 }
		
		 json=JSONFactoryUtil.createJSONObject();
					if(!captchaPassed){
						aviso="Código captcha incorrecto.";
						_log.info(aviso);
						json.put("error",  "true");
						json.put("mensaje",  "Código captcha incorrecto.");

					}else{
						//Generamos el bean registrandolo en la session
						 SimuladorBean simVehicular=new SimuladorBean();
						 simVehicular.setCuotaInicial(cuotaInicial);
						 simVehicular.setNumeroDocumento(numDocumento);
						 simVehicular.setPlazoCredito(plazoCredito);
						 simVehicular.setTipoCredito(codTipoCredito);
						 simVehicular.setNombreCreditoProducto(nombreTipoCredito.replaceAll("<br />", "").replaceAll("<BR />", ""));
						 simVehicular.setTipoCuota(codTipoCuota);
						 simVehicular.setTipoDocumento(codTipoDoc);
						 simVehicular.setTipoMoneda(codTipoMoneda);
						 simVehicular.setSeguroDesgravamen(codTipoSeguro);
						 simVehicular.setValorBien(valorAuto);
						 simVehicular.setUtmSource(utmSource);
						 simVehicular.setUtmMedium(utmMedium);
						 simVehicular.setUtmCampaing(utmCampaing);
						 simVehicular.setUtmContent(utmContent);
						 simVehicular.setTipoSimulador(SimuladoresUtil.SIMULADOR_VEHICULAR);
						 SimuladoresUtil.registrarSimulacion(resourceRequest,simVehicular);
						 
						//Registramos el DNI en sesion
						SessionBean session=new SessionBean();
						session.setTipoDoc(codTipoDoc);
						session.setNumDoc(numDocumento);
						SessionUtil.registrarSession(session, resourceRequest,true);
						
						Boolean peticionValida = ValidarPeticionUtil.validarGestionPeticion(resourceRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.vehicular"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_CRE_VEHICULAR);
						
						if (peticionValida) {
							json.put("error",  "false");
							json.put("url",PAGE_SIM_VEH);
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
