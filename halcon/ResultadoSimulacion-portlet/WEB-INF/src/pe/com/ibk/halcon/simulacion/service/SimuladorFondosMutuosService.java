package pe.com.ibk.halcon.simulacion.service;

import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.jfree.data.category.CategoryDataset;

import com.ext.portlet.halcon.dto.SimuladorBean;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface SimuladorFondosMutuosService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface SimuladorFondosMutuosService {
	
	/**
	 * Simular.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 * @param portletResponse the portlet response
	 * @param simulador the simulador
	 */
	void simular(PortletRequest portletRequest,PortletResponse portletResponse, SimuladorBean simulador);

	/**
	 * Creates the dataset.
	 * Fecha: 22/08/2013
	 *
	 * @param PorcentajeFondosMutuos the porcentaje fondos mutuos
	 * @return the category dataset
	 */
	CategoryDataset createDataset(List<Object[]> PorcentajeFondosMutuos);

	/**
	 * Creates the table header.
	 * Fecha: 22/08/2013
	 *
	 * @param documento the documento
	 * @param title the title
	 * @param optionGroup the option group
	 * @param pathEscrituraImagen the path escritura imagen
	 * @throws BadElementException the bad element exception
	 */
	void createTableHeader(Document documento, String title,String optionGroup,String pathEscrituraImagen) throws BadElementException;

	/**
	 * Creates the table lista fondos mutuos.
	 * Fecha: 22/08/2013
	 *
	 * @param documento the documento
	 * @param datos the datos
	 * @throws BadElementException the bad element exception
	 */
	void createTableListaFondosMutuos(Document documento, String datos) throws BadElementException;

	/**
	 * Adds the empty line.
	 * Fecha: 22/08/2013
	 *
	 * @param doc the doc
	 * @param number the number
	 */
	void addEmptyLine(Document doc, int number);

	/**
	 * Obtener monto portal.
	 * Fecha: 22/08/2013
	 *
	 * @return the double
	 */
	Double obtenerMontoPortal();
	
	/**
	 * Guardar historial simulador.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 * @param simulador the simulador
	 */
	void guardarHistorialSimulador(PortletRequest portletRequest,SimuladorBean simulador);
	
}
