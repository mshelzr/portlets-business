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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Infonet-Consulting
 */
public class ParametroFinderUtil {
	public static java.util.List<com.ext.portlet.halcon.model.Parametro> listarParametro()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().listarParametro();
	}

	public static com.ext.portlet.halcon.model.Parametro obtenerParametroPadre(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametroPadre(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijos(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametrosHijos(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijos(
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametrosHijos(etiqueta);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorTipo(
		java.lang.Integer id)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametrosPorTipo(id);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorDescripcion(
		java.lang.String descripcion)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametrosPorDescripcion(descripcion);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorDescripcion(
		java.lang.String descripcionParametro,
		java.lang.String descripcionParametroPadre)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder()
				   .obtenerParametrosPorDescripcion(descripcionParametro,
			descripcionParametroPadre);
	}

	public static java.lang.Integer cambiarParametroEstado(
		java.lang.Integer id, java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().cambiarParametroEstado(id, estado);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametroListaPadre()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametroListaPadre();
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerRangoValor(
		java.lang.Integer id)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerRangoValor(id);
	}

	public static java.lang.Integer validarTipo(java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().validarTipo(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijosDos(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerParametrosHijosDos(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> listarPadresJson(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().listarPadresJson(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> listarHijosPadresJson(
		java.lang.Integer tipoLista)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().listarHijosPadresJson(tipoLista);
	}

	public static int registrarCabeceraDetalle(
		com.ext.portlet.halcon.model.Parametro parametroCab,
		com.ext.portlet.halcon.model.Parametro parametroDet)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().registrarCabeceraDetalle(parametroCab, parametroDet);
	}

	public static ParametroFinder getFinder() {
		if (_finder == null) {
			_finder = (ParametroFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					ParametroFinder.class.getName());

			ReferenceRegistry.registerReference(ParametroFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ParametroFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ParametroFinderUtil.class, "_finder");
	}

	private static ParametroFinder _finder;
}