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
public class CargaTiendaFinderUtil {
	public static java.lang.Integer truncate()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().truncate();
	}

	public static java.lang.Boolean insert(
		java.util.List<com.ext.portlet.halcon.model.CargaTienda> beans)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().insert(beans);
	}

	public static CargaTiendaFinder getFinder() {
		if (_finder == null) {
			_finder = (CargaTiendaFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					CargaTiendaFinder.class.getName());

			ReferenceRegistry.registerReference(CargaTiendaFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CargaTiendaFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CargaTiendaFinderUtil.class,
			"_finder");
	}

	private static CargaTiendaFinder _finder;
}