package pe.com.ibk.halcon.simulacion.controller;

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

import pe.com.ibk.halcon.simulacion.bean.TipoSimuladorBean;

import com.exp.portlet.halcon.utils.SimuladoresUtil;
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
 * The Class ResultadoSimulacionEditController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class ResultadoSimulacionEditController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ResultadoSimulacionEditController.class);
	//private static Integer indicadorPortlet=37;
	//private static Integer indicadorController=1;
	
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
		
		//Leemos el properties
		String tipoSimulador;
		tipoSimulador = renderRequest.getPreferences().getValue("tipoSimulador", "");
		renderRequest.setAttribute("tipoSimulador", tipoSimulador);
		
		//LLenando la lista de simuladores
		List<TipoSimuladorBean> tipos=cargarSimuladores();
		renderRequest.setAttribute("listaSimuladores", tipos);
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "edit";
	}

	/**
	 * Registrar.
	 * Fecha: 22/08/2013
	 *
	 * @param actionRequest the action request
	 * @param renderResponse the render response
	 */
	@ActionMapping(value = "actionURL")
	public void registrar(ActionRequest actionRequest, ActionResponse renderResponse) {

		String tipoSimulador;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		tipoSimulador = ParamUtil.getString(request, "tipoSimulador", "");

		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("tipoSimulador", tipoSimulador);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEdit");
			_log.info("Preference Guardado");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEdit");
			_log.error("Error al guardar el Preference:" + e.toString());
		}
		
		//JSonUtil.LogAuditoria(actionRequest, indicadorPortlet, indicadorController);

	}
	
	
	/**
	 * Cargar simuladores.
	 * Fecha: 22/08/2013
	 *
	 * @return the list
	 */
	private List<TipoSimuladorBean> cargarSimuladores(){
		List<TipoSimuladorBean> tipos=new ArrayList<TipoSimuladorBean>();
		TipoSimuladorBean aux=new TipoSimuladorBean();
		
		aux.setCodigo(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS);
		aux.setNombre("Simulador de fondos mutuos");
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
		aux.setNombre("Simulador hipotecario");
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_PERSONAL);
		aux.setNombre("Simulador de crédito personal");
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_PLAZO_FIJO);
		aux.setNombre("Simulador depósito a plazo");
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_VEHICULAR);
		aux.setNombre("Simulador vehicular");
		tipos.add(aux);
		
		return tipos;
	}
}
