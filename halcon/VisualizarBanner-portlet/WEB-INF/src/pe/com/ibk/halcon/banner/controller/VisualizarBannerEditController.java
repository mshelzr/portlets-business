package pe.com.ibk.halcon.banner.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class VisualizarBannerController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class VisualizarBannerEditController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(VisualizarBannerEditController.class);
	//private static Integer indicadorPortlet=44;
	//private static Integer indicadorController=2;

	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		PortletPreferences preferencias = renderRequest.getPreferences();
		String tipo = preferencias.getValue("tipo", "0");
		renderRequest.setAttribute("tipo", tipo);
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "edit";
	}

	/**
	 * Registrar.
	 * Fecha: 18/02/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionRegistrarURL")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String codProducto;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		codProducto = ParamUtil.getString(request, "cmbProducto", "0");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("tipo", codProducto);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEditRegistra");
			//JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
			_log.info("Preference Guardado:" + codProducto);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEditRegistra");
			_log.error("Error al guardar el Preference:" + e.toString());
		}

	}
}
