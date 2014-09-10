package pe.com.interbank.halcon.buscar.descuento.service;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface BuscarDescuentoService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public interface BuscarDescuentoService {

	/**
	 * Obt lista sucursales descuentos.
	 * Fecha: 21/08/2013
	 *
	 * @param buscar the buscar
	 * @param distrito the distrito
	 * @param categoria the categoria
	 * @param pagina the pagina
	 * @param filas the filas
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	void obtListaSucursalesDescuentos(String buscar, String distrito, Integer categoria, int pagina, int filas, ResourceRequest resourceRequest,ResourceResponse resourceResponse) throws IOException ;


}
