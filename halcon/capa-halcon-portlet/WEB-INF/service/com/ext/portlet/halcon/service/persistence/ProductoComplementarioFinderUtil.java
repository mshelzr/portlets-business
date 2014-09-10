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
public class ProductoComplementarioFinderUtil {
	public static java.lang.Integer insertProductoComplementario(
		java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> lstProductos) {
		return getFinder().insertProductoComplementario(lstProductos);
	}

	public static ProductoComplementarioFinder getFinder() {
		if (_finder == null) {
			_finder = (ProductoComplementarioFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					ProductoComplementarioFinder.class.getName());

			ReferenceRegistry.registerReference(ProductoComplementarioFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ProductoComplementarioFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ProductoComplementarioFinderUtil.class,
			"_finder");
	}

	private static ProductoComplementarioFinder _finder;
}