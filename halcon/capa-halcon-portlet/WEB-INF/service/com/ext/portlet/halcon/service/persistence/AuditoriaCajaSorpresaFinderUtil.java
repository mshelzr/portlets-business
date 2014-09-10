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
public class AuditoriaCajaSorpresaFinderUtil {
	public static java.lang.Boolean insert(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa beans)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder().insert(beans);
	}

	public static AuditoriaCajaSorpresaFinder getFinder() {
		if (_finder == null) {
			_finder = (AuditoriaCajaSorpresaFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					AuditoriaCajaSorpresaFinder.class.getName());

			ReferenceRegistry.registerReference(AuditoriaCajaSorpresaFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AuditoriaCajaSorpresaFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AuditoriaCajaSorpresaFinderUtil.class,
			"_finder");
	}

	private static AuditoriaCajaSorpresaFinder _finder;
}