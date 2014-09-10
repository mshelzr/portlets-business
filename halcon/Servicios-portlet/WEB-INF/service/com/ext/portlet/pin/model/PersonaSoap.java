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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.pin.service.http.PersonaServiceSoap}.
 *
 * @author    arodriguez
 * @see       com.ext.portlet.pin.service.http.PersonaServiceSoap
 * @generated
 */
public class PersonaSoap implements Serializable {
	public static PersonaSoap toSoapModel(Persona model) {
		PersonaSoap soapModel = new PersonaSoap();

		soapModel.setUserId(model.getUserId());
		soapModel.setNombres(model.getNombres());
		soapModel.setApellidoPaterno(model.getApellidoPaterno());
		soapModel.setApellidoMaterno(model.getApellidoMaterno());
		soapModel.setDni(model.getDni());
		soapModel.setTipoDocumento(model.getTipoDocumento());

		return soapModel;
	}

	public static PersonaSoap[] toSoapModels(Persona[] models) {
		PersonaSoap[] soapModels = new PersonaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonaSoap[][] toSoapModels(Persona[][] models) {
		PersonaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonaSoap[] toSoapModels(List<Persona> models) {
		List<PersonaSoap> soapModels = new ArrayList<PersonaSoap>(models.size());

		for (Persona model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonaSoap[soapModels.size()]);
	}

	public PersonaSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidoPaterno() {
		return _apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		_apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return _apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		_apellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return _dni;
	}

	public void setDni(String dni) {
		_dni = dni;
	}

	public int getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	private long _userId;
	private String _nombres;
	private String _apellidoPaterno;
	private String _apellidoMaterno;
	private String _dni;
	private int _tipoDocumento;
}