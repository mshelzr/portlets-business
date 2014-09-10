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
public interface FondosMutuosFinder {
	public com.ext.portlet.halcon.model.Parametro obtenerFondoMutuoZona(
		java.lang.Integer puntaje, java.lang.String moneda,
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> listarPlazozFondoMutuo(
		java.lang.String valor)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.FondosMutuos> listarFondoMutuo(
		java.lang.String moneda, java.util.List<java.lang.String> lista,
		java.lang.String tipoFondo)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public com.ext.portlet.halcon.model.FondosMutuos consultarUltimaFecha()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Boolean insertarFondoMutuo(
		java.util.List<com.ext.portlet.halcon.model.FondosMutuos> lstBeans)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Parametro> consultarFondoMutuoTipos(
		java.lang.Integer puntaje, java.lang.String moneda,
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public com.ext.portlet.halcon.model.Parametro obtenerFondosMutuosPuntos(
		java.lang.String numeroDias, java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<java.lang.Object[]> consultarFondosMutuosParte(
		java.lang.String moneda, java.lang.String fondo1,
		java.lang.String fondo2, java.lang.String fondo3,
		java.lang.Integer dias, java.util.List<java.lang.String> lista)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public com.ext.portlet.halcon.model.Parametro consultarDiasDesdeIdentificadorSlider(
		java.lang.String etiqueta, java.lang.String periodo)
		throws com.ext.portlet.halcon.exception.BusinessException;
}