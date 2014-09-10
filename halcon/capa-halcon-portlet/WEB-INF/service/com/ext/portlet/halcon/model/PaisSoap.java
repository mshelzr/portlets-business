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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.PaisServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.PaisServiceSoap
 * @generated
 */
public class PaisSoap implements Serializable {
	public static PaisSoap toSoapModel(Pais model) {
		PaisSoap soapModel = new PaisSoap();

		soapModel.setPais_IdPais(model.getPais_IdPais());
		soapModel.setCodigo(model.getCodigo());
		soapModel.setNombre(model.getNombre());

		return soapModel;
	}

	public static PaisSoap[] toSoapModels(Pais[] models) {
		PaisSoap[] soapModels = new PaisSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PaisSoap[][] toSoapModels(Pais[][] models) {
		PaisSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PaisSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PaisSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PaisSoap[] toSoapModels(List<Pais> models) {
		List<PaisSoap> soapModels = new ArrayList<PaisSoap>(models.size());

		for (Pais model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PaisSoap[soapModels.size()]);
	}

	public PaisSoap() {
	}

	public long getPrimaryKey() {
		return _pais_IdPais;
	}

	public void setPrimaryKey(long pk) {
		setPais_IdPais(pk);
	}

	public long getPais_IdPais() {
		return _pais_IdPais;
	}

	public void setPais_IdPais(long pais_IdPais) {
		_pais_IdPais = pais_IdPais;
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

	private long _pais_IdPais;
	private String _codigo;
	private String _nombre;
}