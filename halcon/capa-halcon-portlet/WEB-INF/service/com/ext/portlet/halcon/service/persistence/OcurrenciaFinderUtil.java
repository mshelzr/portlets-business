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
public class OcurrenciaFinderUtil {
	public static java.util.List<com.ext.portlet.halcon.model.Ocurrencia> obtenerUltimaPeticion(
		java.lang.String ip, java.lang.String codigoProducto,
		java.lang.Integer estado, java.lang.String fecha)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder()
				   .obtenerUltimaPeticion(ip, codigoProducto, estado, fecha);
	}

	public static java.lang.Integer cambiarPeticionEstado(java.lang.Long id,
		java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().cambiarPeticionEstado(id, estado);
	}

	public static com.ext.portlet.halcon.model.Ocurrencia insertar(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().insertar(ocurrencia);
	}

	public static OcurrenciaFinder getFinder() {
		if (_finder == null) {
			_finder = (OcurrenciaFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					OcurrenciaFinder.class.getName());

			ReferenceRegistry.registerReference(OcurrenciaFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(OcurrenciaFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(OcurrenciaFinderUtil.class,
			"_finder");
	}

	private static OcurrenciaFinder _finder;
}