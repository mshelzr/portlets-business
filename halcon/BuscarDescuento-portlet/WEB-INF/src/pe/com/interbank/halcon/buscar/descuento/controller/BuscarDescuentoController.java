package pe.com.interbank.halcon.buscar.descuento.controller;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import pe.com.interbank.halcon.buscar.descuento.service.BuscarDescuentoService;
import pe.com.interbank.halcon.buscar.descuento.util.Constantes;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class BuscarDescuentoController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class BuscarDescuentoController extends MVCPortlet {
 
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscarDescuentoController.class);
	//private static Integer indicadorPortlet=2;
	//private static Integer indicadorController=1;
	
	/** The buscar mapas service. */
	@Autowired
	private BuscarDescuentoService buscarMapasService;
	
	
	/**
	 * Default view. <br>
	 * Método que es llamado por defecto al iniciar.<br>
	 * Fecha: 21/08/2013
	 *
	 * @param model the model
	 * @param request the request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(Model model, RenderRequest request) {
		model.addAttribute("MENSAJE_SIN_RESULTADOS", Constantes.MENSAJE_SIN_RESULTADOS);
		return "view";
	}

	/**
	 * Lista Sucursales Descuentos<br>
	 * Se obtiene los descuentos segun los tipos de cajeros y codigo de ubigeo de lima y callao.<br>
	 * Fecha: 21/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws Exception the exception
	 */
	@ResourceMapping("obtListaSucursalesDescuentos")
	public void obtListaSucursalesDescuentos(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		String buscar = ParamUtil.getString(resourceRequest, "buscar");
		String distrito = ParamUtil.getString(resourceRequest, "cboDistritosDescuentoHidden");
		Integer categoria = ParamUtil.getInteger(resourceRequest, "cboCategoriaHidden");
		int pagina = ParamUtil.getInteger(resourceRequest, "pagina");
		int filas = ParamUtil.getInteger(resourceRequest, "filas");
		// si hay dsitrito selecionado en lima callao y categoria selecionada filtra
		buscarMapasService.obtListaSucursalesDescuentos(buscar, distrito, categoria, pagina, filas, resourceRequest, resourceResponse);
	}
	
}