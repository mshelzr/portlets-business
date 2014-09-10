package pe.com.interbank.halcon.buscar.tienda.controller;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import pe.com.interbank.halcon.buscar.tienda.service.BuscarTiendaService;
import pe.com.interbank.halcon.buscar.tienda.util.Constantes;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class BuscarTiendaController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class BuscarTiendaController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscarTiendaController.class);
	
	/** The indicador portlet. */
	private static Integer indicadorPortlet=3;
	
	/** The indicador controller. */
	private static Integer indicadorController=1;

	/** The buscar tiendas service. */
	@Autowired
	private BuscarTiendaService buscarTiendasService;


	/**
	 * Ingreso a view cargando los parametros necesarios.
	 *
	 * @param model the model
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(Model model, RenderRequest request) {		
		model.addAttribute("MENSAJE_SIN_RESULTADOS", Constantes.MENSAJE_SIN_RESULTADOS);
		model.addAttribute("tiendas", Constantes.CANAL_TIENDAS);
		model.addAttribute("agentes", Constantes.CANAL_AGENTES);
		model.addAttribute("cajerosglobalnet", Constantes.CANAL_CAJEROS_GLOBAL_NET);
		model.addAttribute("monederosglobalnet", Constantes.CANAL_MONEDEROS_GLOBAL_NET);
		model.addAttribute("cajerosglobalnetplus", Constantes.CANAL_CAJEROS_GLOBAL_NET_PLUS);
		_log.info("ingreso a BuscarEnMapaController view donde model tiene los datos necesarios");
		//JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
		return "view";
	}

	/**
	 * se obtiene las tiendas segun los tipos de cajeros y codigo de ubigeo.
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws Exception the exception
	 */
	@ResourceMapping("obtListaSucursales")
	public void obtListaSucursales(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		_log.info("BuscarEnMapaController ejecuto metodo  obtListaSucursales");
		int[] checkTipoLocal = ParamUtil.getIntegerValues(resourceRequest, "checkTipoLocal");
		String distrito = ParamUtil.getString(resourceRequest, "cboDistritoHidden");
		int pagina = ParamUtil.getInteger(resourceRequest, "pagina");
		int filas = ParamUtil.getInteger(resourceRequest, "filas");
		// si hay mas de un tipo de cajero y distrito seleccionado
		// se obtiene el paginado correspondiente
		_log.info(" datos ingresados[ distrito :" + distrito + ", tipo de cajero(checks) seleccionados: " + checkTipoLocal.length + ", pagina : " + pagina + ", filas : " + filas + "]");
		if (checkTipoLocal.length > 0 && !"".equals(distrito) && !"0".equals(distrito)) {
			String[] cheks = new String[checkTipoLocal.length];
			if (checkTipoLocal != null && checkTipoLocal.length > 0) {
				for (int i = 0; i < checkTipoLocal.length; i++) {
					int s = checkTipoLocal[i];
					cheks[i] = String.valueOf(s);
				}
			}
			buscarTiendasService.obtListaSucursales(distrito, cheks, resourceResponse, pagina, filas);
		}
		_log.info("Termina metodo obtListaSucursales");
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}

}
