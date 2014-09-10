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
 * The Interface SimuladorHipotecarioService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface SimuladorHipotecarioService {
	
	/**
	 * Inits the hipotecario.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 */
	public void initHipotecario(RenderRequest renderRequest);
	
	/**
	 * Verificar captcha.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param captchaService the captcha service
	 * @return the string
	 */
	public String verificarCaptcha(ResourceRequest resourceRequest,GenericManageableCaptchaService captchaService);
}
