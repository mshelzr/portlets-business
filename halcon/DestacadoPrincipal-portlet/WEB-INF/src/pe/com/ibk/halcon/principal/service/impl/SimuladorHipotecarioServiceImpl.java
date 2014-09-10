package pe.com.ibk.halcon.principal.service.impl;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;
import pe.com.ibk.halcon.principal.service.SimuladorHipotecarioService;
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
 * The Class SimuladorHipotecarioServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorHipotecarioServiceImpl implements SimuladorHipotecarioService {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(SimuladorHipotecarioServiceImpl.class);
	
	/** The Constant PAGE_SIM_HIP. */
	private static final String PAGE_SIM_HIP=PortletProps.get("destacado.simulador.hipotecario.page");
//	JSonUtil jSonUtil=new JSonUtil();
	/** The principal service. */
@Autowired
	private PrincipalService principalService;
	
	@Autowired
	private CacheDestacadoUtil cachejsonUtil;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorHipotecarioService#initHipotecario(javax.portlet.RenderRequest)
	 */
	public void initHipotecario(RenderRequest renderRequest){
		try{
			
			RangoBean RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES);
			RangoBean RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES);
			RangoBean RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES);
			RangoBean RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES);
			RangoBean RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES);
			RangoBean RANGO_VALOR_GARANTIA_HIPOTECARIO_CRE_HIPO_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES);
			
			RangoBean RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES);
			RangoBean RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES);
			RangoBean RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES);
			RangoBean RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES);
			RangoBean RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES);
			RangoBean RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES);
			
			RangoBean RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO);
			RangoBean RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO);
			RangoBean RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO);
			RangoBean RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO);
			
			
			
			renderRequest.setAttribute("RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES"  , getJSONValues(RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES", getJSONValues(RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES));
			renderRequest.setAttribute("RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES"  , getJSONValues(RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES", getJSONValues(RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES"  , getJSONValues(RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_GARANTIA_HIPOTECARIO_CRE_HIPO_DOLARES", getJSONValues(RANGO_VALOR_GARANTIA_HIPOTECARIO_CRE_HIPO_DOLARES));

			renderRequest.setAttribute("RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES", getJSONValues(RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES", getJSONValues(RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES));
			renderRequest.setAttribute("RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES", getJSONValues(RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES", getJSONValues(RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES", getJSONValues(RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES));
			renderRequest.setAttribute("RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES", getJSONValues(RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES));
			
			renderRequest.setAttribute("RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO", getJSONValues(RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO));
			renderRequest.setAttribute("RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO", getJSONValues(RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO));
			renderRequest.setAttribute("RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO", getJSONValues(RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO));
			renderRequest.setAttribute("RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO", getJSONValues(RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO));
			
			
		}catch(Exception e){
			_log.error("Error al cargar configuración de simulador hipotecario:"+e.toString());
			
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorHipotecarioService#verificarCaptcha(javax.portlet.ResourceRequest, com.octo.captcha.service.multitype.GenericManageableCaptchaService)
	 */
	public String verificarCaptcha(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService){
		String captcha,aviso,codTipoDoc,codTipoCredito,codTipoCuota,
		 codTipoMoneda,codTipoSeguro,plazoCredito,valorInmueble,
		 cuotaInicial,numDocumento,utmSource,utmMedium,utmCampaing,utmContent,nombreTipoCredito;
		
		 boolean captchaPassed;
		 JSONObject json;
		 
		 captcha =ParamUtil.getString(resourceRequest, "txtCaptchaHipotecario");
		 try{
			 captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);
			 //captchaPassed = true;
		 }catch(Exception e){
			 _log.error("Codigo Captcha ya ha sido usado, reingresarlo.");
			 captchaPassed=false;
		 }
		 codTipoDoc=ParamUtil.getString(resourceRequest, "hcmbTipDocHipotecario");
		 codTipoCredito=ParamUtil.getString(resourceRequest, "hoptTipCreditoHipotecario");
		 nombreTipoCredito = ParamUtil.getString(resourceRequest, "hoptTipCreditoHipotecarioText");
		 codTipoCuota=ParamUtil.getString(resourceRequest, "hoptTipCuotaHipotecario");
		 codTipoMoneda=ParamUtil.getString(resourceRequest, "hoptTipMonedaHipotecario");
		 codTipoSeguro=ParamUtil.getString(resourceRequest, "hoptTipSeguroHipotecario");
		 plazoCredito=ParamUtil.getString(resourceRequest, "sliderPlazoCreditoHipotecario");
		 valorInmueble=ParamUtil.getString(resourceRequest, "sliderValorInmueble");
		 cuotaInicial=ParamUtil.getString(resourceRequest, "sliderValorInicialHipotecario");
		 numDocumento=ParamUtil.getString(resourceRequest, "txtNumDocHipotecario");
		 		 
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
						 SimuladorBean simHipotecario=new SimuladorBean();
						 simHipotecario.setCuotaInicial(cuotaInicial);
						 simHipotecario.setNumeroDocumento(numDocumento);
						 simHipotecario.setPlazoCredito(plazoCredito);
						 simHipotecario.setTipoCredito(codTipoCredito);
						 simHipotecario.setNombreCreditoProducto(nombreTipoCredito.replaceAll("<br />", "").replaceAll("<BR />", ""));
						 simHipotecario.setTipoCuota(codTipoCuota);
						 simHipotecario.setTipoDocumento(codTipoDoc);
						 simHipotecario.setTipoMoneda(codTipoMoneda);
						 simHipotecario.setSeguroDesgravamen(codTipoSeguro);
						 simHipotecario.setValorBien(valorInmueble);
						 simHipotecario.setUtmSource(utmSource);
						 simHipotecario.setUtmMedium(utmMedium);
						 simHipotecario.setUtmCampaing(utmCampaing);
						 simHipotecario.setUtmContent(utmContent);
						 simHipotecario.setTipoSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
						 SimuladoresUtil.registrarSimulacion(resourceRequest,simHipotecario);
						 
						//Registramos el DNI en sesion
						SessionBean session=new SessionBean();
						session.setTipoDoc(codTipoDoc);
						session.setNumDoc(numDocumento);
						SessionUtil.registrarSession(session, resourceRequest,true);
						
						Boolean peticionValida = ValidarPeticionUtil.validarGestionPeticion(resourceRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.hipotecario"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_CRE_HIPOTECARIO);
						
						if (peticionValida) {
							json.put("error",  "false");
							json.put("url", PAGE_SIM_HIP);
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
