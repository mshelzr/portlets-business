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

package com.ext.portlet.halcon.model.impl;

import com.ext.portlet.halcon.model.Ocurrencia;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Ocurrencia in entity cache.
 *
 * @author Infonet-Consulting
 * @see Ocurrencia
 * @generated
 */
public class OcurrenciaCacheModel implements CacheModel<Ocurrencia>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idGestionPeticion=");
		sb.append(idGestionPeticion);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", codigoProducto=");
		sb.append(codigoProducto);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", estado=");
		sb.append(estado);
		sb.append(", ocurrencia=");
		sb.append(ocurrencia);
		sb.append("}");

		return sb.toString();
	}

	public Ocurrencia toEntityModel() {
		OcurrenciaImpl ocurrenciaImpl = new OcurrenciaImpl();

		ocurrenciaImpl.setIdGestionPeticion(idGestionPeticion);

		if (ip == null) {
			ocurrenciaImpl.setIp(StringPool.BLANK);
		}
		else {
			ocurrenciaImpl.setIp(ip);
		}

		if (codigoProducto == null) {
			ocurrenciaImpl.setCodigoProducto(StringPool.BLANK);
		}
		else {
			ocurrenciaImpl.setCodigoProducto(codigoProducto);
		}

		if (fecha == Long.MIN_VALUE) {
			ocurrenciaImpl.setFecha(null);
		}
		else {
			ocurrenciaImpl.setFecha(new Date(fecha));
		}

		ocurrenciaImpl.setEstado(estado);
		ocurrenciaImpl.setOcurrencia(ocurrencia);

		ocurrenciaImpl.resetOriginalValues();

		return ocurrenciaImpl;
	}

	public long idGestionPeticion;
	public String ip;
	public String codigoProducto;
	public long fecha;
	public Integer estado;
	public Integer ocurrencia;
}