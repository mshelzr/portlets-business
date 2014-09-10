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
public class CategoriaSubcategoriaFinderUtil {
	public static int insertar(java.lang.Integer idCategoriaSubCatPadre,
		java.lang.String descripcion)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().insertar(idCategoriaSubCatPadre, descripcion);
	}

	public static CategoriaSubcategoriaFinder getFinder() {
		if (_finder == null) {
			_finder = (CategoriaSubcategoriaFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					CategoriaSubcategoriaFinder.class.getName());

			ReferenceRegistry.registerReference(CategoriaSubcategoriaFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CategoriaSubcategoriaFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CategoriaSubcategoriaFinderUtil.class,
			"_finder");
	}

	private static CategoriaSubcategoriaFinder _finder;
}