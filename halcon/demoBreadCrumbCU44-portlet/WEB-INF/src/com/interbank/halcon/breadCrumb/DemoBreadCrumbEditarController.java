package com.interbank.halcon.breadCrumb;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
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
 * Portlet implementation class DemoBreadCrumb. Clase controladora para la seccion de Encabezado de las diferentes paginas 
 * 
 * @author Infonet Consulting S.A.C. 
 * Fecha: 30/01/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class DemoBreadCrumbEditarController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DemoBreadCrumbEditarController.class);

	/**
	 * Default view. Fecha: 30/01/2013
	 * 
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {
		String contenidoPage, formato, titulo, sloganExt;
		contenidoPage = renderRequest.getPreferences().getValue("contenidoPage", "");
		formato = renderRequest.getPreferences().getValue("formatoPage", "");

		sloganExt = renderRequest.getPreferences().getValue("sloganExt", "");
		renderRequest.setAttribute("contenidoPage", contenidoPage);
		renderRequest.setAttribute("formato", formato);

		renderRequest.setAttribute("sloganExt", sloganExt);
		return "edit";
	}

	/**
	 * Registrar. Fecha: 30/01/2013
	 * 
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionApoyoURL")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String detEncabezado, formato, sloganExt;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		detEncabezado = ParamUtil.getString(request, "contenidoPage", "");
		formato = ParamUtil.getString(request, "cmbTipoFormato", "");

		sloganExt = ParamUtil.getString(request, "sloganExt", "");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();

			preferencias.setValue("contenidoPage", detEncabezado);
			preferencias.setValue("formatoPage", formato);

			preferencias.setValue("sloganExt", sloganExt);
			preferencias.store();

			SessionMessages.add(actionRequest, "successEdit");

		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEdit");
			_log.error("Error al guardar el Preference:" + e.toString());
		}

	}
}
