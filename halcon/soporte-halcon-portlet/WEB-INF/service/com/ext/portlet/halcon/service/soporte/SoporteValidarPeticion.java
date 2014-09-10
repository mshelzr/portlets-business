package com.ext.portlet.halcon.service.soporte;

import java.util.Date;

import com.exp.portlet.halcon.utils.TiempoUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SoporteValidarPeticion.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public class SoporteValidarPeticion extends Soporte {
	
	/**
	 * Obtener minutos transcurridos.
	 * Fecha: 21/08/2013
	 *
	 * @param fecha the fecha
	 * @return the integer
	 */
	public static Integer obtenerMinutosTranscurridos(Date fecha) {
		return TiempoUtil.getMinutosTranscurridos(fecha);
	}

}
