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

package com.ext.portlet.pin.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.pin.service.http.CategoriaServiceSoap}.
 *
 * @author    arodriguez
 * @see       com.ext.portlet.pin.service.http.CategoriaServiceSoap
 * @generated
 */
public class CategoriaSoap implements Serializable {
	public static CategoriaSoap toSoapModel(Categoria model) {
		CategoriaSoap soapModel = new CategoriaSoap();

		soapModel.setCategoriaId(model.getCategoriaId());
		soapModel.setIdImagen(model.getIdImagen());
		soapModel.setNombre(model.getNombre());
		soapModel.setEstado(model.getEstado());
		soapModel.setDescripcion(model.getDescripcion());

		return soapModel;
	}

	public static CategoriaSoap[] toSoapModels(Categoria[] models) {
		CategoriaSoap[] soapModels = new CategoriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CategoriaSoap[][] toSoapModels(Categoria[][] models) {
		CategoriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CategoriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CategoriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CategoriaSoap[] toSoapModels(List<Categoria> models) {
		List<CategoriaSoap> soapModels = new ArrayList<CategoriaSoap>(models.size());

		for (Categoria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CategoriaSoap[soapModels.size()]);
	}

	public CategoriaSoap() {
	}

	public long getPrimaryKey() {
		return _categoriaId;
	}

	public void setPrimaryKey(long pk) {
		setCategoriaId(pk);
	}

	public long getCategoriaId() {
		return _categoriaId;
	}

	public void setCategoriaId(long categoriaId) {
		_categoriaId = categoriaId;
	}

	public long getIdImagen() {
		return _idImagen;
	}

	public void setIdImagen(long idImagen) {
		_idImagen = idImagen;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public boolean getEstado() {
		return _estado;
	}

	public boolean isEstado() {
		return _estado;
	}

	public void setEstado(boolean estado) {
		_estado = estado;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	private long _categoriaId;
	private long _idImagen;
	private String _nombre;
	private boolean _estado;
	private String _descripcion;
}