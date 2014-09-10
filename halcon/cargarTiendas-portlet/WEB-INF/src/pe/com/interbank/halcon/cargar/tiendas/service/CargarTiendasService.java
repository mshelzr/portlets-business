package pe.com.interbank.halcon.cargar.tiendas.service;

import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface CargarTiendasService.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
public interface CargarTiendasService {

	/**
	 * Cargar descuentos. Fecha: 31-ene-2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @return the map
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 * @throws Exception the exception
	 */
	Map<String, Object> cargarTiendas(ActionRequest resourceRequest, ActionResponse resourceResponse)
			throws IOException, Exception;

	void obtenerListaErrores(ResourceRequest resourceRequest, ResourceResponse resourceResponse);

}
