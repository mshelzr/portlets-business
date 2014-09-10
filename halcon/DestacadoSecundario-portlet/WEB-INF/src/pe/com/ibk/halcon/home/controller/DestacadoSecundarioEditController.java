/*
 * 
 */
package pe.com.ibk.halcon.home.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import pe.com.ibk.halcon.home.bean.ContenidoBeanEdit;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class DestacadoSecundarioEditController.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class DestacadoSecundarioEditController {

	/**
	 * Instancia un nuevo destacado secundario edit controller.
	 */
	public DestacadoSecundarioEditController() {
	}

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DestacadoSecundarioEditController.class);
	//private static Integer indicadorPortlet=16;
	//private static Integer indicadorController=2;
	
	/**
	 * Default view, controller que es invocado por defecto en modo edit Fecha: 18/02/2013.
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		List<ContenidoBeanEdit> contenidos = null;
		int numAdicionales;
		String codContenidoWeb1;
		String codContenidoWeb2;
		String codContenidoWeb3;
		String codContenidoWeb4;

		try {
			PortletPreferences preferencias = renderRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			codContenidoWeb1 = preferencias.getValue("codContenidoWeb1", "0");
			codContenidoWeb2 = preferencias.getValue("codContenidoWeb2", "0");
			codContenidoWeb3 = preferencias.getValue("codContenidoWeb3", "0");
			codContenidoWeb4 = preferencias.getValue("codContenidoWeb4", "0");
			
			/* Recuperamos la lista de productos del Portal */
			numAdicionales = 0;

			if (contenidos == null)
				contenidos = new ArrayList<ContenidoBeanEdit>();
			ContenidoBeanEdit aux = new ContenidoBeanEdit();
			aux.setRegitrado(true);
			numAdicionales++;

			/* Verificamos si esta registrado en properties o nada */
			contenidos.add(aux);

			renderRequest.setAttribute("codContenidoWeb1", codContenidoWeb1);
			renderRequest.setAttribute("codContenidoWeb2", codContenidoWeb2);
			renderRequest.setAttribute("codContenidoWeb3", codContenidoWeb3);
			renderRequest.setAttribute("codContenidoWeb4", codContenidoWeb4);
			renderRequest.setAttribute("contenidos", contenidos);
			renderRequest.setAttribute("numAdicionales", numAdicionales);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "edit";
	}

	/**
	 * Registrar, con el siguiente metodo se registra el formato deseado y contenidos webs asociados
	 * Fecha: 18/02/2013.
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionRegistrar")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String codContenidoWeb1;
		String codContenidoWeb2;
		String codContenidoWeb3;
		String codContenidoWeb4;

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		codContenidoWeb1 = ParamUtil.getString(request, "idcw1", "0");
		codContenidoWeb2 = ParamUtil.getString(request, "idcw2", "0");
		codContenidoWeb3 = ParamUtil.getString(request, "idcw3", "0");
		codContenidoWeb4 = ParamUtil.getString(request, "idcw4", "0");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("codContenidoWeb1", codContenidoWeb1);
			preferencias.setValue("codContenidoWeb2", codContenidoWeb2);
			preferencias.setValue("codContenidoWeb3", codContenidoWeb3);
			preferencias.setValue("codContenidoWeb4", codContenidoWeb4);
			preferencias.store();

			SessionMessages.add(actionRequest, "successEditRegistra");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEditRegistra");
			_log.error("Error al guardar el Preferences:" + e.toString());
		}

		/**
		 * _log.info("Registro"); _log.info("=====================================");
		 * _log.info("formato: " + formato); _log.info("codContenidoWeb1: " + codContenidoWeb1);
		 * _log.info("codContenidoWeb2: " + codContenidoWeb2); _log.info("codContenidoWeb3: " +
		 * codContenidoWeb3);
		 */

		actionRequest.setAttribute("codContenidoWeb1", codContenidoWeb1);
		actionRequest.setAttribute("codContenidoWeb2", codContenidoWeb2);
		actionRequest.setAttribute("codContenidoWeb3", codContenidoWeb3);
		actionRequest.setAttribute("codContenidoWeb4", codContenidoWeb4);
	}
}
