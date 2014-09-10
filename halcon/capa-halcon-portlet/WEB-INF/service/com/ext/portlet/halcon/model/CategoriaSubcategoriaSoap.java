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

package com.ext.portlet.halcon.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.CategoriaSubcategoriaServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.CategoriaSubcategoriaServiceSoap
 * @generated
 */
public class CategoriaSubcategoriaSoap implements Serializable {
	public static CategoriaSubcategoriaSoap toSoapModel(
		CategoriaSubcategoria model) {
		CategoriaSubcategoriaSoap soapModel = new CategoriaSubcategoriaSoap();

		soapModel.setIdCategoriaSubCat(model.getIdCategoriaSubCat());
		soapModel.setIdCategoriaSubCatPadre(model.getIdCategoriaSubCatPadre());
		soapModel.setDescripcion(model.getDescripcion());

		return soapModel;
	}

	public static CategoriaSubcategoriaSoap[] toSoapModels(
		CategoriaSubcategoria[] models) {
		CategoriaSubcategoriaSoap[] soapModels = new CategoriaSubcategoriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoriaSubcategoriaSoap[][] toSoapModels(
		CategoriaSubcategoria[][] models) {
		CategoriaSubcategoriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategoriaSubcategoriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoriaSubcategoriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoriaSubcategoriaSoap[] toSoapModels(
		List<CategoriaSubcategoria> models) {
		List<CategoriaSubcategoriaSoap> soapModels = new ArrayList<CategoriaSubcategoriaSoap>(models.size());

		for (CategoriaSubcategoria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoriaSubcategoriaSoap[soapModels.size()]);
	}

	public CategoriaSubcategoriaSoap() {
	}

	public long getPrimaryKey() {
		return _idCategoriaSubCat;
	}

	public void setPrimaryKey(long pk) {
		setIdCategoriaSubCat(pk);
	}

	public long getIdCategoriaSubCat() {
		return _idCategoriaSubCat;
	}

	public void setIdCategoriaSubCat(long idCategoriaSubCat) {
		_idCategoriaSubCat = idCategoriaSubCat;
	}

	public Integer getIdCategoriaSubCatPadre() {
		return _idCategoriaSubCatPadre;
	}

	public void setIdCategoriaSubCatPadre(Integer idCategoriaSubCatPadre) {
		_idCategoriaSubCatPadre = idCategoriaSubCatPadre;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	private long _idCategoriaSubCat;
	private Integer _idCategoriaSubCatPadre;
	private String _descripcion;
}