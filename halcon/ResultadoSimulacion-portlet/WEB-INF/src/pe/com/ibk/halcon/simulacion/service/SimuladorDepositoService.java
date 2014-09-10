package pe.com.ibk.halcon.simulacion.service;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.exception.BusinessException;


// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface SimuladorDepositoService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface SimuladorDepositoService {
	
	/**
	 * Obtener tasa interes.
	 * Fecha: 22/08/2013
	 *
	 * @param simulador the simulador
	 * @param plazo the plazo
	 * @return the double
	 * @throws NumberFormatException the number format exception
	 * @throws BusinessException the business exception
	 */
	Double obtenerTasaInteres(SimuladorBean simulador,String plazo) throws NumberFormatException, BusinessException;
	
	/**
	 * Simular.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 * @param portletResponse the portlet response
	 * @param simulador the simulador
	 */
	void simular(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador);
}
