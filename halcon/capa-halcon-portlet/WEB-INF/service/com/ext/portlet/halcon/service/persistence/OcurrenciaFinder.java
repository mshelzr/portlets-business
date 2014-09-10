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

package com.ext.portlet.halcon.service.persistence;

/**
 * @author Infonet-Consulting
 */
public interface OcurrenciaFinder {
	public java.util.List<com.ext.portlet.halcon.model.Ocurrencia> obtenerUltimaPeticion(
		java.lang.String ip, java.lang.String codigoProducto,
		java.lang.Integer estado, java.lang.String fecha)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer cambiarPeticionEstado(java.lang.Long id,
		java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public com.ext.portlet.halcon.model.Ocurrencia insertar(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.ext.portlet.halcon.exception.BusinessException;
}