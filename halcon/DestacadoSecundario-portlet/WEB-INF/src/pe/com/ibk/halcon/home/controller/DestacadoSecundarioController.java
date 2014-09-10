/*
 * 
 */
package pe.com.ibk.halcon.home.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class DestacadoSecundarioController.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class DestacadoSecundarioController {

	/**
	 * Instancia un nuevo destacado secundario controller.
	 */
	public DestacadoSecundarioController() {
	}

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DestacadoSecundarioController.class);
	//private static Integer indicadorPortlet=16;
	//private static Integer indicadorController=1;

	/**
	 * Default view, controller que es invocado por defecto Fecha: 18/02/2013.
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {

		String codContenidoWeb1;
		String codContenidoWeb2;
		String codContenidoWeb3;
		String codContenidoWeb4;

		codContenidoWeb1 = renderRequest.getPreferences().getValue("codContenidoWeb1", "0");
		codContenidoWeb2 = renderRequest.getPreferences().getValue("codContenidoWeb2", "0");
		codContenidoWeb3 = renderRequest.getPreferences().getValue("codContenidoWeb3", "0");
		codContenidoWeb4 = renderRequest.getPreferences().getValue("codContenidoWeb4", "0");
		
		renderRequest.setAttribute("codContenidoWeb1", codContenidoWeb1);
		renderRequest.setAttribute("codContenidoWeb2", codContenidoWeb2);
		renderRequest.setAttribute("codContenidoWeb3", codContenidoWeb3);
		renderRequest.setAttribute("codContenidoWeb4", codContenidoWeb4);

		/**
		 * _log.info("Default"); _log.info("=====================================");
		 * _log.info("formato: " + formato); _log.info("codContenidoWeb1: " + codContenidoWeb1);
		 * _log.info("codContenidoWeb2: " + codContenidoWeb2); _log.info("codContenidoWeb3: " +
		 * codContenidoWeb3);
		 */
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}
}
