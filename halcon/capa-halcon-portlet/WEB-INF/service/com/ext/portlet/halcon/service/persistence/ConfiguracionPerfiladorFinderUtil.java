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
public class ConfiguracionPerfiladorFinderUtil {
	public static java.lang.Long obtenerRangoValor(
		java.lang.Long idConfiguracionPerfiladorPadre, java.lang.Long valor)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder()
				   .obtenerRangoValor(idConfiguracionPerfiladorPadre, valor);
	}

	public static ConfiguracionPerfiladorFinder getFinder() {
		if (_finder == null) {
			_finder = (ConfiguracionPerfiladorFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					ConfiguracionPerfiladorFinder.class.getName());

			ReferenceRegistry.registerReference(ConfiguracionPerfiladorFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ConfiguracionPerfiladorFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ConfiguracionPerfiladorFinderUtil.class,
			"_finder");
	}

	private static ConfiguracionPerfiladorFinder _finder;
}