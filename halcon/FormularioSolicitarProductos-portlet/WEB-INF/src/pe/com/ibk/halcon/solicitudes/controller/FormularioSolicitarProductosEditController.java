package pe.com.ibk.halcon.solicitudes.controller;

import java.io.PrintWriter;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class FormularioSolicitarProductosEditController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class FormularioSolicitarProductosEditController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(FormularioSolicitarProductosEditController.class);
	//private static Integer indicadorPortlet=23;
	//private static Integer indicadorController=2;
	
	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		return "edit";
	}

	/**
	 * Registrar.
	 * Fecha: 22/08/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionRegistrar")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		String codProducto = ParamUtil.getString(request, "formato", "0");
		
		String[] codContenidos = {ParamUtil.getString(request, "idcw1", "0"),ParamUtil.getString(request, "idcw2", "0"),ParamUtil.getString(request, "idcw3", "0"),
				ParamUtil.getString(request, "idcw4", "0"),ParamUtil.getString(request, "idcw5", "0")};
		
		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < codContenidos.length; i++) {
				JSONObject jsonObjeto = JSONFactoryUtil.createJSONObject();
				jsonObjeto.put("codigo", codContenidos[i]);
				jsonArr.put(jsonObjeto);
			}
			
			preferencias.setValue(codProducto, jsonArr.toString());
			preferencias.store();

			SessionMessages.add(actionRequest, "successEditRegistra");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEditRegistra");
			_log.error("Error al guardar el Preference:" + e.toString());
		}

		actionRequest.setAttribute("formato", codProducto);
		actionRequest.setAttribute("codContenidoWeb1", codContenidos[0]);
		actionRequest.setAttribute("codContenidoWeb2", codContenidos[1]);
		actionRequest.setAttribute("codContenidoWeb3", codContenidos[2]);
		actionRequest.setAttribute("codContenidoWeb4", codContenidos[3]);
		actionRequest.setAttribute("codContenidoWeb5", codContenidos[4]);
		//JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
	}

	/**
	 * Obtener contenidos.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("obtenerContenidos")
	protected void obtenerContenidos(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		String codProducto = ParamUtil.getString(resourceRequest, "codProducto");
		PortletPreferences preferencias = resourceRequest.getPreferences();
		
		String value = preferencias.getValue(codProducto, "{}");
		PrintWriter writer = null;
		try {
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(value);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			_log.info("ERROR");
		} finally{
			IOUtils.closeQuietly(writer);
		}
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}
	
	
}
