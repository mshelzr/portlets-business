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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.UbigeoServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.UbigeoServiceSoap
 * @generated
 */
public class UbigeoSoap implements Serializable {
	public static UbigeoSoap toSoapModel(Ubigeo model) {
		UbigeoSoap soapModel = new UbigeoSoap();

		soapModel.setIdUbigeo(model.getIdUbigeo());
		soapModel.setCodigo(model.getCodigo());
		soapModel.setNombre(model.getNombre());
		soapModel.setCodDepartamento(model.getCodDepartamento());
		soapModel.setCodProvincia(model.getCodProvincia());
		soapModel.setCodDistrito(model.getCodDistrito());

		return soapModel;
	}

	public static UbigeoSoap[] toSoapModels(Ubigeo[] models) {
		UbigeoSoap[] soapModels = new UbigeoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UbigeoSoap[][] toSoapModels(Ubigeo[][] models) {
		UbigeoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UbigeoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UbigeoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UbigeoSoap[] toSoapModels(List<Ubigeo> models) {
		List<UbigeoSoap> soapModels = new ArrayList<UbigeoSoap>(models.size());

		for (Ubigeo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UbigeoSoap[soapModels.size()]);
	}

	public UbigeoSoap() {
	}

	public long getPrimaryKey() {
		return _idUbigeo;
	}

	public void setPrimaryKey(long pk) {
		setIdUbigeo(pk);
	}

	public long getIdUbigeo() {
		return _idUbigeo;
	}

	public void setIdUbigeo(long idUbigeo) {
		_idUbigeo = idUbigeo;
	}

	public String getCodigo() {
		return _codigo;
	}

	public void setCodigo(String codigo) {
		_codigo = codigo;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getCodDepartamento() {
		return _codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		_codDepartamento = codDepartamento;
	}

	public String getCodProvincia() {
		return _codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		_codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return _codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		_codDistrito = codDistrito;
	}

	private long _idUbigeo;
	private String _codigo;
	private String _nombre;
	private String _codDepartamento;
	private String _codProvincia;
	private String _codDistrito;
}