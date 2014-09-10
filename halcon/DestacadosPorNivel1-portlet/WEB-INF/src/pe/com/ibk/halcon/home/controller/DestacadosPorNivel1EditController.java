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
 * The Class DestacadosPorNivel1EditController, metodo por defecto invocado en modo edit
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class DestacadosPorNivel1EditController {

	/**
	 * Instancia un nuevo destacados por nivel1 edit controller.
	 */
	public DestacadosPorNivel1EditController() {
	}

	/** The cod contenido web1. */
	String codContenidoWeb1;
	
	/** The cod contenido web2. */
	String codContenidoWeb2;
	
	/** The cod contenido web3. */
	String codContenidoWeb3;
	
	/** The cod contenido web4. */
	String codContenidoWeb4;
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DestacadosPorNivel1Controller.class);
	//private static Integer indicadorPortlet=17;
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
		List<ContenidoBeanEdit> contenidos = null;
		int numAdicionales;

		try {
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
	 * Registrar, metodo que registra los contenidos webs
	 * Fecha: 18/02/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionRegistrar")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

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
			_log.error("Error al guardar el Preference:" + e.toString());
		}
		actionRequest.setAttribute("codContenidoWeb1", codContenidoWeb1);
		actionRequest.setAttribute("codContenidoWeb2", codContenidoWeb2);
		actionRequest.setAttribute("codContenidoWeb3", codContenidoWeb3);
		actionRequest.setAttribute("codContenidoWeb4", codContenidoWeb4);
		//JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);
	}
}
