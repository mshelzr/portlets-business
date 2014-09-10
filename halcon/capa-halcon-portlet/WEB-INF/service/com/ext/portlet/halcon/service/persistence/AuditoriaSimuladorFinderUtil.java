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
public class AuditoriaSimuladorFinderUtil {
	public static com.ext.portlet.halcon.model.Parametro obtenerTarifarioDepositoPlazo(
		java.lang.Integer monto, java.lang.String moneda,
		java.lang.String plazo, java.lang.String tipoTabla)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getFinder()
				   .obtenerTarifarioDepositoPlazo(monto, moneda, plazo,
			tipoTabla);
	}

	public static AuditoriaSimuladorFinder getFinder() {
		if (_finder == null) {
			_finder = (AuditoriaSimuladorFinder)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					AuditoriaSimuladorFinder.class.getName());

			ReferenceRegistry.registerReference(AuditoriaSimuladorFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AuditoriaSimuladorFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AuditoriaSimuladorFinderUtil.class,
			"_finder");
	}

	private static AuditoriaSimuladorFinder _finder;
}