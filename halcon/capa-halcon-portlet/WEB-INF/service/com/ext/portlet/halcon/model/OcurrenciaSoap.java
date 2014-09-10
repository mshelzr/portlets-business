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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.OcurrenciaServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.OcurrenciaServiceSoap
 * @generated
 */
public class OcurrenciaSoap implements Serializable {
	public static OcurrenciaSoap toSoapModel(Ocurrencia model) {
		OcurrenciaSoap soapModel = new OcurrenciaSoap();

		soapModel.setIdGestionPeticion(model.getIdGestionPeticion());
		soapModel.setIp(model.getIp());
		soapModel.setCodigoProducto(model.getCodigoProducto());
		soapModel.setFecha(model.getFecha());
		soapModel.setEstado(model.getEstado());
		soapModel.setOcurrencia(model.getOcurrencia());

		return soapModel;
	}

	public static OcurrenciaSoap[] toSoapModels(Ocurrencia[] models) {
		OcurrenciaSoap[] soapModels = new OcurrenciaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OcurrenciaSoap[][] toSoapModels(Ocurrencia[][] models) {
		OcurrenciaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OcurrenciaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OcurrenciaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OcurrenciaSoap[] toSoapModels(List<Ocurrencia> models) {
		List<OcurrenciaSoap> soapModels = new ArrayList<OcurrenciaSoap>(models.size());

		for (Ocurrencia model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OcurrenciaSoap[soapModels.size()]);
	}

	public OcurrenciaSoap() {
	}

	public long getPrimaryKey() {
		return _idGestionPeticion;
	}

	public void setPrimaryKey(long pk) {
		setIdGestionPeticion(pk);
	}

	public long getIdGestionPeticion() {
		return _idGestionPeticion;
	}

	public void setIdGestionPeticion(long idGestionPeticion) {
		_idGestionPeticion = idGestionPeticion;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public String getCodigoProducto() {
		return _codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		_codigoProducto = codigoProducto;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public Integer getEstado() {
		return _estado;
	}

	public void setEstado(Integer estado) {
		_estado = estado;
	}

	public Integer getOcurrencia() {
		return _ocurrencia;
	}

	public void setOcurrencia(Integer ocurrencia) {
		_ocurrencia = ocurrencia;
	}

	private long _idGestionPeticion;
	private String _ip;
	private String _codigoProducto;
	private Date _fecha;
	private Integer _estado;
	private Integer _ocurrencia;
}