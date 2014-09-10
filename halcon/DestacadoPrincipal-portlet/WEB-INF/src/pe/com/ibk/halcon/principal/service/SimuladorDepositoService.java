package pe.com.ibk.halcon.principal.service;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import com.octo.captcha.service.multitype.GenericManageableCaptchaService;


// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface SimuladorDepositoService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface SimuladorDepositoService {
	
	/**
	 * Inits the deposito.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 */
	void initDeposito(RenderRequest renderRequest);
	
	/**
	 * Verificar captcha.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param captchaService the captcha service
	 * @return the string
	 */
	String verificarCaptcha(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService);
}
