/*
 * 
 */
package pe.com.ibk.halcon.replicadores.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class ReplicadorPrestamoController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  05/11/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class ReplicadorPrestamoEditController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ReplicadorPrestamoEditController.class);

	/**
	 * Default view.
	 * Fecha: 05/11/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {
		String tipoReplicador;
		tipoReplicador = renderRequest.getPreferences().getValue("tipoReplicador", "");

		renderRequest.setAttribute("tipoReplicador", tipoReplicador);
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);

		return "edit";
	}

	/**
	 * Registrar.
	 * Fecha: 05/11/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "configuraReplicador")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String tipoReplicador;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		tipoReplicador = ParamUtil.getString(request, "cmbTipoReplicador", "");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			preferencias.setValue("tipoReplicador", tipoReplicador);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEdit");
			_log.info("Preference Guardado");

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEdit");
			_log.error("Error al guardar los Preference:" + e.toString());
		}

	}

	/**
	 * Obtener perfilador. Fecha: 24/06/2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping(value = "obtenerReplicador")
	public void obtenerReplicador(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		Map<String, Object> objRespuesta = new HashMap<String, Object>();
		Gson gson = new Gson();
		String gsonString = "";

		try {
			String tipoReplicador = resourceRequest.getPreferences().getValue("tipoReplicador", "");
			objRespuesta.put("tipoReplicador", tipoReplicador);
			gsonString = gson.toJson(objRespuesta);
			_log.info("gsonString: " + gsonString);
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(gsonString);
			writer.flush();
			writer.close();

		} catch (Exception e) {
			_log.error("Error al obtener preferencias del Replicador: " + e.toString());
		}
		// JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}
}
