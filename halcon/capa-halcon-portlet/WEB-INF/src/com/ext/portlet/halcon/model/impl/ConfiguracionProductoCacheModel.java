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

import com.ext.portlet.halcon.model.ConfiguracionProducto;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing ConfiguracionProducto in entity cache.
 *
 * @author Infonet-Consulting
 * @see ConfiguracionProducto
 * @generated
 */
public class ConfiguracionProductoCacheModel implements CacheModel<ConfiguracionProducto>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idConfiguracionProducto=");
		sb.append(idConfiguracionProducto);
		sb.append(", idConfiguracionPerfilador=");
		sb.append(idConfiguracionPerfilador);
		sb.append(", idProducto=");
		sb.append(idProducto);
		sb.append(", nombreProducto=");
		sb.append(nombreProducto);
		sb.append(", codigoSiebelProducto=");
		sb.append(codigoSiebelProducto);
		sb.append(", estadoConfiguracion=");
		sb.append(estadoConfiguracion);
		sb.append("}");

		return sb.toString();
	}

	public ConfiguracionProducto toEntityModel() {
		ConfiguracionProductoImpl configuracionProductoImpl = new ConfiguracionProductoImpl();

		configuracionProductoImpl.setIdConfiguracionProducto(idConfiguracionProducto);
		configuracionProductoImpl.setIdConfiguracionPerfilador(idConfiguracionPerfilador);
		configuracionProductoImpl.setIdProducto(idProducto);

		if (nombreProducto == null) {
			configuracionProductoImpl.setNombreProducto(StringPool.BLANK);
		}
		else {
			configuracionProductoImpl.setNombreProducto(nombreProducto);
		}

		if (codigoSiebelProducto == null) {
			configuracionProductoImpl.setCodigoSiebelProducto(StringPool.BLANK);
		}
		else {
			configuracionProductoImpl.setCodigoSiebelProducto(codigoSiebelProducto);
		}

		configuracionProductoImpl.setEstadoConfiguracion(estadoConfiguracion);

		configuracionProductoImpl.resetOriginalValues();

		return configuracionProductoImpl;
	}

	public long idConfiguracionProducto;
	public Long idConfiguracionPerfilador;
	public Long idProducto;
	public String nombreProducto;
	public String codigoSiebelProducto;
	public Integer estadoConfiguracion;
}