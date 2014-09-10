package pe.com.ibk.halcon.simulacion.service;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.dto.TasaInteresBean;
import com.ext.portlet.halcon.exception.BusinessException;


// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface SimuladorVehicularService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface SimuladorVehicularService {
	
	/**
	 * Obtener tasa interes.
	 * Fecha: 22/08/2013
	 *
	 * @param tasa the tasa
	 * @return the double
	 * @throws BusinessException the business exception
	 */
	double obtenerTasaInteres(TasaInteresBean tasa) throws BusinessException ;
	
	/**
	 * Simular.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 * @param portletResponse the portlet response
	 * @param simulador the simulador
	 * @throws BusinessException the business exception
	 */
	void simular(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador) throws BusinessException ;
	
	/**
	 * Inits the.
	 * Fecha: 22/08/2013
	 */
	void init();
}
