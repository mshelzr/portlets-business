package pe.com.ibk.halcon.contenidoweb.controller;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SocialInterbank.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class SocialInterbank {

	//private static Integer indicadorPortlet = 40;
	//private static Integer indicadorController = 1;

	static final Log _log = LogFactoryUtil.getLog(SocialInterbank.class);

	/**
	 * Instancia un nuevo social interbank.
	 */
	public SocialInterbank() {
	}

	/**
	 * Default view. Fecha: 18/02/2013
	 * 
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {

		return "view";
	}

}
