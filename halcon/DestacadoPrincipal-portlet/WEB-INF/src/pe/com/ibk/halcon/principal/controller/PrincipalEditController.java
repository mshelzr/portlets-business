package pe.com.ibk.halcon.principal.controller;

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

import pe.com.ibk.halcon.principal.bean.TipoFichaSimuladorBean;
import pe.com.ibk.halcon.principal.bean.TipoSimuladorBean;

import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class PrincipalEditController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("EDIT")
public class PrincipalEditController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(PrincipalEditController.class);
	/**
	 * Default view. Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		//Leemos el properties
		String tipoSimulador,fichaProducto;
		tipoSimulador = renderRequest.getPreferences().getValue("tipoSimulador", "");
		fichaProducto = renderRequest.getPreferences().getValue("tipoFichaSimulador", "");
		renderRequest.setAttribute("tipoSimulador", tipoSimulador);
		renderRequest.setAttribute("tipoFichaSimulador", fichaProducto);
		
		//LLenando la lista de simuladores
		List<TipoSimuladorBean> tipos=cargarSimuladores();
		renderRequest.setAttribute("listaSimuladores", tipos);
		renderRequest.setAttribute("listaSimuladoresProductos", cargarProductosxSimulador(tipoSimulador));
		String json=JSONFactoryUtil.serialize(tipos);

		renderRequest.setAttribute("listaSimuladoresJSON", HtmlUtil.escape(json));
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
		String tipoFichaSimulador;
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		tipoSimulador = ParamUtil.getString(request, "tipoSimulador", "");
		tipoFichaSimulador = ParamUtil.getString(request, "tipoFichaSimulador", "");
		
		try {
			PortletPreferences preferencias = actionRequest.getPreferences();
			// crea una variable de preferencia y la guarda.
			preferencias.setValue("tipoSimulador", tipoSimulador);
			preferencias.setValue("tipoFichaSimulador", tipoFichaSimulador);
			preferencias.store();
			SessionMessages.add(actionRequest, "successEdit");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "errorEdit");
			_log.error("Error al guardar el Preference:" + e.toString());
		}
	}
	
	/**
	 * Cargar simuladores. Fecha: 22/08/2013
	 *
	 * @return the list
	 */
	private List<TipoSimuladorBean> cargarSimuladores(){
		
		List<TipoSimuladorBean> tipos=new ArrayList<TipoSimuladorBean>();
		TipoSimuladorBean aux=new TipoSimuladorBean();
		
		aux.setCodigo(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS);
		aux.setNombre("Simulador de fondos mutuos");
		aux.setProductos(cargarProductosxSimulador(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS));
		tipos.add(aux);
		
		//Simulador Hipotecario
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
		aux.setNombre("Simulador hipotecario");
		aux.setProductos(cargarProductosxSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO));
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_PERSONAL);
		aux.setNombre("Simulador de crédito personal");
		aux.setProductos(cargarProductosxSimulador(SimuladoresUtil.SIMULADOR_PERSONAL));
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_PLAZO_FIJO);
		aux.setNombre("Simulador depósito a plazo");
		aux.setProductos(cargarProductosxSimulador(SimuladoresUtil.SIMULADOR_PLAZO_FIJO));
		tipos.add(aux);
		
		aux=new TipoSimuladorBean();
		aux.setCodigo(SimuladoresUtil.SIMULADOR_VEHICULAR);
		aux.setNombre("Simulador vehicular");
		aux.setProductos(cargarProductosxSimulador(SimuladoresUtil.SIMULADOR_VEHICULAR));
		tipos.add(aux);
		
		return tipos;
	}
	
	/**
	 * Cargar productosx simulador.
	 * Fecha: 22/08/2013
	 *
	 * @param tipoSimulador the tipo simulador
	 * @return the list
	 */
	private List<TipoFichaSimuladorBean> cargarProductosxSimulador(String tipoSimulador){
		List<TipoFichaSimuladorBean> productos=new ArrayList<TipoFichaSimuladorBean>();
		
		if(tipoSimulador.equalsIgnoreCase(SimuladoresUtil.SIMULADOR_HIPOTECARIO)){
			TipoFichaSimuladorBean aux=new TipoFichaSimuladorBean();
			//Hipotecario Regular
			aux.setCodigo("hipotecario-regular");
			aux.setNombre("Producto Hipotecario Regular");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
			productos.add(aux);
			//Hipotecario Mi Vivienda
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("hipotecario-mi-vivienda");
			aux.setNombre("Producto Hipotecario Mi Vivienda");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
			productos.add(aux);
			//Hipotecario Mi Vivienda
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("hipotecario-techo-propio");
			aux.setNombre("Producto Hipotecario Techo Propio");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
			productos.add(aux);
			//Hipotecario Mi Vivienda
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("garantia-hipotecaria");
			aux.setNombre("Producto Hipotecario con garantía Hipotecaria");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
			productos.add(aux);
			
		}else if(tipoSimulador.equalsIgnoreCase(SimuladoresUtil.SIMULADOR_VEHICULAR)){
			TipoFichaSimuladorBean aux=new TipoFichaSimuladorBean();
			//Vehicular Tradicional
			aux.setCodigo("vehicular-tradicional");
			aux.setNombre("Producto Vehicular Tradicional");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_VEHICULAR);
			productos.add(aux);
			//Vehicular Compra inteligente
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("vehicular-inteligente");
			aux.setNombre("Producto Vehicular Compra Inteligente");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_VEHICULAR);
			productos.add(aux);
			//Vehicular Casi nuevo
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("vehicular-casi-nuevo");
			aux.setNombre("Producto Vehicular Casi Nuevo");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_VEHICULAR);
			productos.add(aux);
			//Vehicular Mi Vivienda
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("vehicular-especial");
			aux.setNombre("Producto Vehicular Especial");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_VEHICULAR);
			productos.add(aux);
			
		}else if(tipoSimulador.equalsIgnoreCase(SimuladoresUtil.SIMULADOR_PERSONAL)){
			TipoFichaSimuladorBean aux=new TipoFichaSimuladorBean();
			//Personal prestamo efectivo
			aux.setCodigo("personal-efectivo");
			aux.setNombre("Producto Personal Préstamo Efectivo");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_PERSONAL);
			productos.add(aux);
			//Personal maestria part time
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("personal-maestria-part");
			aux.setNombre("Producto Personal Maestría Part Time");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_PERSONAL);
			productos.add(aux);
			//Personal maestria full time
			aux=new TipoFichaSimuladorBean();
			aux.setCodigo("personal-maestria-full");
			aux.setNombre("Producto Personal Maestría Full Time");
			aux.setTipoSimulador(SimuladoresUtil.SIMULADOR_PERSONAL);
			productos.add(aux);
			
		}else if(tipoSimulador.equalsIgnoreCase(SimuladoresUtil.SIMULADOR_PLAZO_FIJO)){
			
		}else if(tipoSimulador.equalsIgnoreCase(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS)){
			
		}

		return productos;
	}
	
}
