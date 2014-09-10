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
public interface ParametroFinder {
	public java.util.List<com.ext.portlet.halcon.model.Parametro> listarParametro()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public com.ext.portlet.halcon.model.Parametro obtenerParametroPadre(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijos(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijos(
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorTipo(
		java.lang.Integer id)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorDescripcion(
		java.lang.String descripcion)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorDescripcion(
		java.lang.String descripcionParametro,
		java.lang.String descripcionParametroPadre)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer cambiarParametroEstado(java.lang.Integer id,
		java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametroListaPadre()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerRangoValor(
		java.lang.Integer id)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Integer validarTipo(java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijosDos(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> listarPadresJson(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> listarHijosPadresJson(
		java.lang.Integer tipoLista)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public int registrarCabeceraDetalle(
		com.ext.portlet.halcon.model.Parametro parametroCab,
		com.ext.portlet.halcon.model.Parametro parametroDet)
		throws com.ext.portlet.halcon.exception.BusinessException;
}