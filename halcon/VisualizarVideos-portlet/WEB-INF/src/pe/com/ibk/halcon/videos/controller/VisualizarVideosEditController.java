package pe.com.ibk.halcon.videos.controller;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

@Controller
@RequestMapping("EDIT")
public class VisualizarVideosEditController {

	private static Log _log = LogFactoryUtil.getLog(VisualizarVideosEditController.class);
	private static String CARPETA_VIDEO_CENTRAL = "Videos";
	//private static Integer indicadorPortlet=50;
	//private static Integer indicadorController=2;
	
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		
		ThemeDisplay themeDisplay;
		long groupId;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		groupId = themeDisplay.getScopeGroupId();

		List<Folder> folderCategorias = getCategorias(groupId);
		renderRequest.setAttribute("carpetas", folderCategorias);
		
		//Leemos el properties
		String nombreCarpeta;
		nombreCarpeta = renderRequest.getPreferences().getValue("nombreCarpeta", "");
		renderRequest.setAttribute("nombreCarpeta", nombreCarpeta);

		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);

		return "edit";
	}

	private List<Folder> getCategorias(long groupId) {
		List<Folder> folderCategorias = null;
		try {
			Folder folderVideo = DLAppLocalServiceUtil.getFolder(groupId, 0, CARPETA_VIDEO_CENTRAL);
			folderCategorias = DLAppLocalServiceUtil.getFolders(groupId,folderVideo.getFolderId());
		} catch (Exception e) {
			_log.error("No se pudo obtener las categorias de carpetas de video:" + e.toString());
		}
		return folderCategorias;
	}
	
	@ActionMapping(value = "actionURL")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String nombreCarpeta;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		nombreCarpeta = ParamUtil.getString(request, "nombreCarpeta", "");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("nombreCarpeta", nombreCarpeta);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEdit");
			_log.info("Preference Guardado");
			//JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEdit");
			_log.error("Error al guardar el Preference:" + e.toString());
		}

	}
}
