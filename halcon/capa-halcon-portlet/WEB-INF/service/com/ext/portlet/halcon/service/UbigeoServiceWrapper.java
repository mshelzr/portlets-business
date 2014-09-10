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

package com.ext.portlet.halcon.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link UbigeoService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       UbigeoService
 * @generated
 */
public class UbigeoServiceWrapper implements UbigeoService,
	ServiceWrapper<UbigeoService> {
	public UbigeoServiceWrapper(UbigeoService ubigeoService) {
		_ubigeoService = ubigeoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ubigeoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ubigeoService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ubigeoService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public UbigeoService getWrappedUbigeoService() {
		return _ubigeoService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedUbigeoService(UbigeoService ubigeoService) {
		_ubigeoService = ubigeoService;
	}

	public UbigeoService getWrappedService() {
		return _ubigeoService;
	}

	public void setWrappedService(UbigeoService ubigeoService) {
		_ubigeoService = ubigeoService;
	}

	private UbigeoService _ubigeoService;
}