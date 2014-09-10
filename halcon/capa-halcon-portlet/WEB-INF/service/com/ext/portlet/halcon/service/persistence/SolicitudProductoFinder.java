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
public interface SolicitudProductoFinder {
	public java.lang.Integer insertarSolicitud(
		com.ext.portlet.halcon.model.SolicitudProducto solicitud)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer insertProductoComplementario(
		java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> lstProductos,
		java.lang.Long idSolicitud)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer insertarTelefonos(
		java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> lstTelefonos,
		java.lang.Long idSolicitud)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer obtenerDetalleSolicitudCount(
		java.lang.String producto, java.lang.Integer respuestaADQ,
		java.lang.String fechaInicio, java.lang.String fechaFinal);

	public java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> obtenerLstProductosComplementariosDistinc()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<java.lang.Object[]> obtenerDetalleSolicitud(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.String producto, java.lang.Integer respuestaADQ,
		java.lang.String fechaInicio, java.lang.String fechaFinal)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer eliminarSolicitud(java.lang.Long idProducto)
		throws com.ext.portlet.halcon.exception.BusinessException;
}