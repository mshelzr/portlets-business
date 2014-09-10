/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ext.portlet.halcon.service.impl;

import java.util.List;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Ocurrencia;
import com.ext.portlet.halcon.model.impl.OcurrenciaImpl;
import com.ext.portlet.halcon.service.base.OcurrenciaLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the ocurrencia local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.OcurrenciaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.OcurrenciaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.OcurrenciaLocalServiceUtil
 */
public class OcurrenciaLocalServiceImpl extends OcurrenciaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.OcurrenciaLocalServiceUtil} to access the ocurrencia local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(OcurrenciaLocalServiceImpl.class);
	
	public List<Ocurrencia> obtenerUltimaPeticion(java.lang.String ip, java.lang.String codigoProducto, java.lang.Integer estado, java.lang.String fecha) throws BusinessException {
		return ocurrenciaFinder.obtenerUltimaPeticion(ip, codigoProducto, estado, fecha);
	}
	
	public java.lang.Integer cambiarPeticionEstado(Long id, java.lang.Integer estado) throws BusinessException {
		return ocurrenciaFinder.cambiarPeticionEstado(id, estado);
	}
	
	public Ocurrencia getInstance() {
		return new OcurrenciaImpl();
	}
	
	public Ocurrencia insertar(Ocurrencia ocurrencia) throws BusinessException{
		return ocurrenciaFinder.insertar(ocurrencia);
	}
}