package pe.com.ibk.halcon.principal.service.impl;

import java.util.ResourceBundle;

import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil;
import pe.com.ibk.halcon.principal.service.PrincipalService;
import pe.com.ibk.halcon.principal.service.SimuladorDepositoService;
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
 * The Class SimuladorDepositoServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorDepositoServiceImpl implements SimuladorDepositoService {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(SimuladorDepositoServiceImpl.class);
	
	/** The Constant PAGE_SIM_PF. */
	private static final String PAGE_SIM_PF =PortletProps.get("destacado.simulador.plazofijo.page");
//	JSonUtil jSonUtil=new JSonUtil();
	/** The principal service. */
@Autowired
	private PrincipalService principalService;
	
	@Autowired
	private CacheDestacadoUtil cachejsonUtil;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorDepositoService#initDeposito(javax.portlet.RenderRequest)
	 */
	public void initDeposito(RenderRequest renderRequest){
		try{
			
			//monto del credito
			RangoBean RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES   = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES);
			RangoBean RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES);
			RangoBean RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS);
			
			renderRequest.setAttribute("RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES"  , getJSONValues(RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES));
			renderRequest.setAttribute("RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES", getJSONValues(RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES));
			renderRequest.setAttribute("RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS", getJSONValues(RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS));
		}catch(Exception e){
			e.printStackTrace();
			_log.error("Error al cargar configuración de simulador plazofijo :"+e.toString());
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.principal.service.SimuladorDepositoService#verificarCaptcha(javax.portlet.ResourceRequest, com.octo.captcha.service.multitype.GenericManageableCaptchaService)
	 */
	public String verificarCaptcha(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService){
		String captcha,codTipoDoc,numDocumento,inversion,plazoInversion,codTipoMoneda,utmSource,utmMedium,utmCampaing,utmContent;
		boolean captchaPassed;
		JSONObject json = JSONFactoryUtil.createJSONObject();
 
		captcha =ParamUtil.getString(resourceRequest, "codCaptchaDeposito");
		 try{
			 captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);
			//captchaPassed = true;
		 
		 }catch(Exception e){
			 _log.error("Codigo Captcha ya ha sido usado, reingresarlo.");
			 captchaPassed=false;
		 }
		
		codTipoDoc = ParamUtil.getString(resourceRequest,"docCreDepositoPlazoHidden");
		numDocumento = ParamUtil.getString(resourceRequest,"documentSimDeposito");
		inversion = ParamUtil.getString(resourceRequest,"valorInversion");
		plazoInversion = ParamUtil.getString(resourceRequest,"plazoInversion");
		codTipoMoneda = ParamUtil.getString(resourceRequest,"tipoMonedaDepositoHidden");
		
		utmSource=ParamUtil.getString(resourceRequest, "utmSource");
		utmMedium=ParamUtil.getString(resourceRequest, "utmMedium");
		utmCampaing=ParamUtil.getString(resourceRequest, "utmCampaing");
		utmContent=ParamUtil.getString(resourceRequest, "utmContent");
		
		if(codTipoDoc.equalsIgnoreCase("0")){
			codTipoDoc="";
			numDocumento="";
		}
		
		if(!captchaPassed){
			ThemeDisplay themeDisplay=(ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ResourceBundle  rb = ResourceBundle.getBundle( "content.Language", themeDisplay.getLocale() );
			
			json.put("error", "true");
			json.put("mensaje", rb.getString("destacado.error.documento.captcha"));
		}else{
			// Generamos el bean registrandolo en la session
			SimuladorBean simDeposito = new SimuladorBean();
			simDeposito.setNumeroDocumento(numDocumento);
			simDeposito.setTipoDocumento(codTipoDoc);
			simDeposito.setPlazoCredito(plazoInversion);
			simDeposito.setValorBien(inversion);
			simDeposito.setTipoMoneda(codTipoMoneda);
			simDeposito.setUtmSource(utmSource);
			simDeposito.setUtmMedium(utmMedium);
			simDeposito.setUtmCampaing(utmCampaing);
			simDeposito.setUtmContent(utmContent);
			simDeposito.setIsFondoMutuo(false);
			simDeposito.setTipoSimulador(SimuladoresUtil.SIMULADOR_PLAZO_FIJO);
			SimuladoresUtil.registrarSimulacion(resourceRequest, simDeposito);
			
			//Registramos el DNI en sesion
			SessionBean session=new SessionBean();
			session.setTipoDoc(codTipoDoc);
			session.setNumDoc(numDocumento);
			SessionUtil.registrarSession(session, resourceRequest,true);
			
			Boolean peticionValida = ValidarPeticionUtil.validarGestionPeticion(resourceRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.deposito"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_DEP_PLAZO);
			_log.info("Peticion Deposito :"+peticionValida);
			
			
			if (peticionValida) {
				json.put("error", "false");
				json.put("url", PAGE_SIM_PF);
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
