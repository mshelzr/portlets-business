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

import com.ext.portlet.halcon.model.Pais;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Pais in entity cache.
 *
 * @author Infonet-Consulting
 * @see Pais
 * @generated
 */
public class PaisCacheModel implements CacheModel<Pais>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{pais_IdPais=");
		sb.append(pais_IdPais);
		sb.append(", codigo=");
		sb.append(codigo);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append("}");

		return sb.toString();
	}

	public Pais toEntityModel() {
		PaisImpl paisImpl = new PaisImpl();

		paisImpl.setPais_IdPais(pais_IdPais);

		if (codigo == null) {
			paisImpl.setCodigo(StringPool.BLANK);
		}
		else {
			paisImpl.setCodigo(codigo);
		}

		if (nombre == null) {
			paisImpl.setNombre(StringPool.BLANK);
		}
		else {
			paisImpl.setNombre(nombre);
		}

		paisImpl.resetOriginalValues();

		return paisImpl;
	}

	public long pais_IdPais;
	public String codigo;
	public String nombre;
}