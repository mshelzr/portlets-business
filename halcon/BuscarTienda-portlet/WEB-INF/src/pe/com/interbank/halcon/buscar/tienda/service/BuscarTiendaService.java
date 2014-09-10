package pe.com.interbank.halcon.buscar.tienda.service;

import java.io.IOException;

import javax.portlet.ResourceResponse;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface BuscarTiendaService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface BuscarTiendaService {

	/**
	 * Obt lista sucursales.
	 * Fecha: 22/08/2013
	 *
	 * @param distrito the distrito
	 * @param checkTipoLocal the check tipo local
	 * @param resourceRequest the resource request
	 * @param pagina the pagina
	 * @param filas the filas
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	void obtListaSucursales(String distrito, String[] checkTipoLocal, ResourceResponse resourceRequest, int pagina, int filas) throws IOException;

}
