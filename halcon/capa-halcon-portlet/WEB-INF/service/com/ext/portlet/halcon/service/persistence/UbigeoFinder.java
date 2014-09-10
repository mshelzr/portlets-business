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

/**
 * @author Infonet-Consulting
 */
public interface UbigeoFinder {
	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerDepartamentos()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerProvincias()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerDistritos()
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> obtenerDistritosLima(
		java.lang.String codigos)
		throws com.ext.portlet.halcon.exception.BusinessException;
}