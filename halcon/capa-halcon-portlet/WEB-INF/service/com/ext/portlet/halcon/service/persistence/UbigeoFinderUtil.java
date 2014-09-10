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
public class UbigeoFinderUtil {
	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerDepartamentos()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerDepartamentos();
	}

	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerProvincias()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerProvincias();
	}

	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerDistritos()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerDistritos();
	}

	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerDistritosLima(
		java.lang.String codigos)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().obtenerDistritosLima(codigos);
	}

	public static UbigeoFinder getFinder() {
		if (_finder == null) {
			_finder = (UbigeoFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					UbigeoFinder.class.getName());

			ReferenceRegistry.registerReference(UbigeoFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UbigeoFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UbigeoFinderUtil.class, "_finder");
	}

	private static UbigeoFinder _finder;
}