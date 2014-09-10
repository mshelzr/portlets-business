package com.ext.portlet.halcon.service;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.service.impl.SeguridadLocalServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SeguridadLocalServiceUtil.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public class SeguridadLocalServiceUtil {
	
	/** The _service. */
	private static SeguridadLocalServiceImpl _service;
	
	/**
	 * Validar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public static Object[] validar(javax.portlet.RenderRequest request, java.lang.String ip, java.lang.String codigoProducto, java.lang.String etiqueta) throws BusinessException, Exception {
		return getService().validar(request, ip, codigoProducto, etiqueta);
	}
	
	/**
	 * Consultar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public static Object[] consultar(javax.portlet.RenderRequest request, java.lang.String ip, java.lang.String codigoProducto, java.lang.String etiqueta) throws BusinessException, Exception {
		return getService().consultar(request, ip, codigoProducto, etiqueta);
	}
	
	/**
	 * Validar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public static Object[] validar(javax.portlet.ResourceRequest request, java.lang.String ip, java.lang.String codigoProducto, java.lang.String etiqueta) throws BusinessException, Exception {
		return getService().validar(request, ip, codigoProducto, etiqueta);
	}
	
	/**
	 * Consultar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public static Object[] consultar(javax.portlet.ResourceRequest request, java.lang.String ip, java.lang.String codigoProducto, java.lang.String etiqueta) throws BusinessException, Exception {
		return getService().consultar(request, ip, codigoProducto, etiqueta);
	}
	
	
	/**
	 * Obtiene service.
	 * Fecha: 21/08/2013
	 *
	 * @return service
	 */
	public static SeguridadLocalServiceImpl getService() {
		if (_service == null) {
			_service = new SeguridadLocalServiceImpl().getInstance();
		}
		return _service;
	}

}
