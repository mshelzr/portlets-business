/*
 * 
 */
package pe.com.ibk.halcon.replicadores.service;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import com.ext.portlet.halcon.dto.FormularioReplicadorBean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface ReplicadorPrestamoService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  05/11/2013
 * @version Halcon 1.0
 */
public interface ReplicadorPrestamoService {

	/**
	 * Validar captcha.
	 * Fecha: 05/11/2013
	 *
	 * @param request the request
	 * @param captcha the captcha
	 * @return true, en caso de exito
	 */
	public boolean validarCaptcha(ResourceRequest request, String captcha);

	/**
	 * Validar credito.
	 * Fecha: 05/11/2013
	 *
	 * @param grupoCredito the grupo credito
	 * @param numCredito the num credito
	 * @param moneda the moneda
	 * @return the int
	 */
	public int validarCredito(int grupoCredito, int numCredito, int moneda);

	/**
	 * Generar cronograma.
	 * Fecha: 05/11/2013
	 *
	 * @param portletRequest the portlet request
	 * @param form the form
	 * @return the object[]
	 */
	public Object[] generarCronograma(PortletRequest portletRequest, FormularioReplicadorBean form);

}
