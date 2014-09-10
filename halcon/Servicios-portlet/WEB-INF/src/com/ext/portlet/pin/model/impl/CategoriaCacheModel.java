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

package com.ext.portlet.pin.model.impl;

import com.ext.portlet.pin.model.Categoria;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing Categoria in entity cache.
 *
 * @author arodriguez
 * @see Categoria
 * @generated
 */
public class CategoriaCacheModel implements CacheModel<Categoria>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{categoriaId=");
		sb.append(categoriaId);
		sb.append(", idImagen=");
		sb.append(idImagen);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", estado=");
		sb.append(estado);
		sb.append(", descripcion=");
		sb.append(descripcion);
		sb.append("}");

		return sb.toString();
	}

	public Categoria toEntityModel() {
		CategoriaImpl categoriaImpl = new CategoriaImpl();

		categoriaImpl.setCategoriaId(categoriaId);
		categoriaImpl.setIdImagen(idImagen);

		if (nombre == null) {
			categoriaImpl.setNombre(StringPool.BLANK);
		}
		else {
			categoriaImpl.setNombre(nombre);
		}

		categoriaImpl.setEstado(estado);

		if (descripcion == null) {
			categoriaImpl.setDescripcion(StringPool.BLANK);
		}
		else {
			categoriaImpl.setDescripcion(descripcion);
		}

		categoriaImpl.resetOriginalValues();

		return categoriaImpl;
	}

	public long categoriaId;
	public long idImagen;
	public String nombre;
	public boolean estado;
	public String descripcion;
}