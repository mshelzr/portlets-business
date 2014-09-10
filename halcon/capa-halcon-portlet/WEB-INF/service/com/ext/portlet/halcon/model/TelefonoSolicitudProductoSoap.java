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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.TelefonoSolicitudProductoServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.TelefonoSolicitudProductoServiceSoap
 * @generated
 */
public class TelefonoSolicitudProductoSoap implements Serializable {
	public static TelefonoSolicitudProductoSoap toSoapModel(
		TelefonoSolicitudProducto model) {
		TelefonoSolicitudProductoSoap soapModel = new TelefonoSolicitudProductoSoap();

		soapModel.setIdTelefSolicitudProducto(model.getIdTelefSolicitudProducto());
		soapModel.setIdSolicitudProducto(model.getIdSolicitudProducto());
		soapModel.setTipoTelefono(model.getTipoTelefono());
		soapModel.setNumeroTelefono(model.getNumeroTelefono());
		soapModel.setAnexo(model.getAnexo());

		return soapModel;
	}

	public static TelefonoSolicitudProductoSoap[] toSoapModels(
		TelefonoSolicitudProducto[] models) {
		TelefonoSolicitudProductoSoap[] soapModels = new TelefonoSolicitudProductoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TelefonoSolicitudProductoSoap[][] toSoapModels(
		TelefonoSolicitudProducto[][] models) {
		TelefonoSolicitudProductoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TelefonoSolicitudProductoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TelefonoSolicitudProductoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TelefonoSolicitudProductoSoap[] toSoapModels(
		List<TelefonoSolicitudProducto> models) {
		List<TelefonoSolicitudProductoSoap> soapModels = new ArrayList<TelefonoSolicitudProductoSoap>(models.size());

		for (TelefonoSolicitudProducto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TelefonoSolicitudProductoSoap[soapModels.size()]);
	}

	public TelefonoSolicitudProductoSoap() {
	}

	public long getPrimaryKey() {
		return _idTelefSolicitudProducto;
	}

	public void setPrimaryKey(long pk) {
		setIdTelefSolicitudProducto(pk);
	}

	public long getIdTelefSolicitudProducto() {
		return _idTelefSolicitudProducto;
	}

	public void setIdTelefSolicitudProducto(long idTelefSolicitudProducto) {
		_idTelefSolicitudProducto = idTelefSolicitudProducto;
	}

	public long getIdSolicitudProducto() {
		return _idSolicitudProducto;
	}

	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_idSolicitudProducto = idSolicitudProducto;
	}

	public String getTipoTelefono() {
		return _tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		_tipoTelefono = tipoTelefono;
	}

	public String getNumeroTelefono() {
		return _numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		_numeroTelefono = numeroTelefono;
	}

	public String getAnexo() {
		return _anexo;
	}

	public void setAnexo(String anexo) {
		_anexo = anexo;
	}

	private long _idTelefSolicitudProducto;
	private long _idSolicitudProducto;
	private String _tipoTelefono;
	private String _numeroTelefono;
	private String _anexo;
}