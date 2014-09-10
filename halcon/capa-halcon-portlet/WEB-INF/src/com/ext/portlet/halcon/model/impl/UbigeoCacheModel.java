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

import com.ext.portlet.halcon.model.Ubigeo;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Ubigeo in entity cache.
 *
 * @author Infonet-Consulting
 * @see Ubigeo
 * @generated
 */
public class UbigeoCacheModel implements CacheModel<Ubigeo>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idUbigeo=");
		sb.append(idUbigeo);
		sb.append(", codigo=");
		sb.append(codigo);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", codDepartamento=");
		sb.append(codDepartamento);
		sb.append(", codProvincia=");
		sb.append(codProvincia);
		sb.append(", codDistrito=");
		sb.append(codDistrito);
		sb.append("}");

		return sb.toString();
	}

	public Ubigeo toEntityModel() {
		UbigeoImpl ubigeoImpl = new UbigeoImpl();

		ubigeoImpl.setIdUbigeo(idUbigeo);

		if (codigo == null) {
			ubigeoImpl.setCodigo(StringPool.BLANK);
		}
		else {
			ubigeoImpl.setCodigo(codigo);
		}

		if (nombre == null) {
			ubigeoImpl.setNombre(StringPool.BLANK);
		}
		else {
			ubigeoImpl.setNombre(nombre);
		}

		if (codDepartamento == null) {
			ubigeoImpl.setCodDepartamento(StringPool.BLANK);
		}
		else {
			ubigeoImpl.setCodDepartamento(codDepartamento);
		}

		if (codProvincia == null) {
			ubigeoImpl.setCodProvincia(StringPool.BLANK);
		}
		else {
			ubigeoImpl.setCodProvincia(codProvincia);
		}

		if (codDistrito == null) {
			ubigeoImpl.setCodDistrito(StringPool.BLANK);
		}
		else {
			ubigeoImpl.setCodDistrito(codDistrito);
		}

		ubigeoImpl.resetOriginalValues();

		return ubigeoImpl;
	}

	public long idUbigeo;
	public String codigo;
	public String nombre;
	public String codDepartamento;
	public String codProvincia;
	public String codDistrito;
}