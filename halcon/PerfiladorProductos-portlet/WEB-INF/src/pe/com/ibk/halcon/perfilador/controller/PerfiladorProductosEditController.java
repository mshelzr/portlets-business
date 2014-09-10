package pe.com.ibk.halcon.perfilador.controller;

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

import org.apache.commons.io.IOUtils;
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
 * Portlet implementation class PerfiladorProductosController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  24/06/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class PerfiladorProductosEditController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(PerfiladorProductosEditController.class);
	
	/** The indicador portlet. */
	//private static Integer indicadorPortlet = 26;
	
	/** The indicador controller. */
	//private static Integer indicadorController = 2;

	/**
	 * Default view.
	 * Fecha: 24/06/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {

		String tipoPerfilador, idPerfilador;
		tipoPerfilador = renderRequest.getPreferences().getValue("tipoPerfilador", "");
		idPerfilador = renderRequest.getPreferences().getValue("idPerfilador", "");

		renderRequest.setAttribute("tipoPerfilador", tipoPerfilador);
		renderRequest.setAttribute("idPerfilador", idPerfilador);
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);

		return "edit";
	}

	/**
	 * Obtener perfilador.
	 * Fecha: 24/06/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping(value = "obtenerPerfilador")
	public void obtenerPerfilador(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		Map<String, Object> objRespuesta = new HashMap<String, Object>();
		Gson gson = new Gson();
		String gsonString = "";
		PrintWriter writer = null;
		try {
			String tipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");
			objRespuesta.put("tipoPerfilador", tipoPerfilador);
			gsonString = gson.toJson(objRespuesta);
			_log.info("gsonString: " + gsonString);
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(gsonString);
			writer.flush();

		} catch (Exception e) {
			_log.error("Error al obtener preferencias del Perfilador: " + e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}

	/**
	 * Registrar.
	 * Fecha: 24/06/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "configuraPerfilador")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String tipoPerfilador, idPerfilador;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		tipoPerfilador = ParamUtil.getString(request, "cmbTipoPerfiladorHidden", "");
		idPerfilador = ParamUtil.getString(request, "idPerfilador", "");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();

			preferencias.setValue("tipoPerfilador", tipoPerfilador);
			preferencias.setValue("idPerfilador", idPerfilador);

			preferencias.store();
			SessionMessages.add(actionRequest, "successEdit");
			_log.info("Preference Guardado");

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEdit");
			_log.error("Error al guardar los Preference:" + e.toString());
		}

		//JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);

	}
}
