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

import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing TelefonoSolicitudProducto in entity cache.
 *
 * @author Infonet-Consulting
 * @see TelefonoSolicitudProducto
 * @generated
 */
public class TelefonoSolicitudProductoCacheModel implements CacheModel<TelefonoSolicitudProducto>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idTelefSolicitudProducto=");
		sb.append(idTelefSolicitudProducto);
		sb.append(", idSolicitudProducto=");
		sb.append(idSolicitudProducto);
		sb.append(", tipoTelefono=");
		sb.append(tipoTelefono);
		sb.append(", numeroTelefono=");
		sb.append(numeroTelefono);
		sb.append(", anexo=");
		sb.append(anexo);
		sb.append("}");

		return sb.toString();
	}

	public TelefonoSolicitudProducto toEntityModel() {
		TelefonoSolicitudProductoImpl telefonoSolicitudProductoImpl = new TelefonoSolicitudProductoImpl();

		telefonoSolicitudProductoImpl.setIdTelefSolicitudProducto(idTelefSolicitudProducto);
		telefonoSolicitudProductoImpl.setIdSolicitudProducto(idSolicitudProducto);

		if (tipoTelefono == null) {
			telefonoSolicitudProductoImpl.setTipoTelefono(StringPool.BLANK);
		}
		else {
			telefonoSolicitudProductoImpl.setTipoTelefono(tipoTelefono);
		}

		if (numeroTelefono == null) {
			telefonoSolicitudProductoImpl.setNumeroTelefono(StringPool.BLANK);
		}
		else {
			telefonoSolicitudProductoImpl.setNumeroTelefono(numeroTelefono);
		}

		if (anexo == null) {
			telefonoSolicitudProductoImpl.setAnexo(StringPool.BLANK);
		}
		else {
			telefonoSolicitudProductoImpl.setAnexo(anexo);
		}

		telefonoSolicitudProductoImpl.resetOriginalValues();

		return telefonoSolicitudProductoImpl;
	}

	public long idTelefSolicitudProducto;
	public long idSolicitudProducto;
	public String tipoTelefono;
	public String numeroTelefono;
	public String anexo;
}