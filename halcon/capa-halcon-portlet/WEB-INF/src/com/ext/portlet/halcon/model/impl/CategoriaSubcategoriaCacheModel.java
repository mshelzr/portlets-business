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

import com.ext.portlet.halcon.model.CategoriaSubcategoria;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

/**
 * The cache model class for representing CategoriaSubcategoria in entity cache.
 *
 * @author Infonet-Consulting
 * @see CategoriaSubcategoria
 * @generated
 */
public class CategoriaSubcategoriaCacheModel implements CacheModel<CategoriaSubcategoria>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{idCategoriaSubCat=");
		sb.append(idCategoriaSubCat);
		sb.append(", idCategoriaSubCatPadre=");
		sb.append(idCategoriaSubCatPadre);
		sb.append(", descripcion=");
		sb.append(descripcion);
		sb.append("}");

		return sb.toString();
	}

	public CategoriaSubcategoria toEntityModel() {
		CategoriaSubcategoriaImpl categoriaSubcategoriaImpl = new CategoriaSubcategoriaImpl();

		categoriaSubcategoriaImpl.setIdCategoriaSubCat(idCategoriaSubCat);
		categoriaSubcategoriaImpl.setIdCategoriaSubCatPadre(idCategoriaSubCatPadre);

		if (descripcion == null) {
			categoriaSubcategoriaImpl.setDescripcion(StringPool.BLANK);
		}
		else {
			categoriaSubcategoriaImpl.setDescripcion(descripcion);
		}

		categoriaSubcategoriaImpl.resetOriginalValues();

		return categoriaSubcategoriaImpl;
	}

	public long idCategoriaSubCat;
	public Integer idCategoriaSubCatPadre;
	public String descripcion;
}