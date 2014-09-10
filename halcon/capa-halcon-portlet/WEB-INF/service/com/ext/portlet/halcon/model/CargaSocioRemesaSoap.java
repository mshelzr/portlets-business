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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.CargaSocioRemesaServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.CargaSocioRemesaServiceSoap
 * @generated
 */
public class CargaSocioRemesaSoap implements Serializable {
	public static CargaSocioRemesaSoap toSoapModel(CargaSocioRemesa model) {
		CargaSocioRemesaSoap soapModel = new CargaSocioRemesaSoap();

		soapModel.setIdSocioRemesa(model.getIdSocioRemesa());
		soapModel.setEmpresa(model.getEmpresa());
		soapModel.setPaisCobertura(model.getPaisCobertura());
		soapModel.setPaginaWeb(model.getPaginaWeb());
		soapModel.setTelefono(model.getTelefono());

		return soapModel;
	}

	public static CargaSocioRemesaSoap[] toSoapModels(CargaSocioRemesa[] models) {
		CargaSocioRemesaSoap[] soapModels = new CargaSocioRemesaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CargaSocioRemesaSoap[][] toSoapModels(
		CargaSocioRemesa[][] models) {
		CargaSocioRemesaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CargaSocioRemesaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CargaSocioRemesaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CargaSocioRemesaSoap[] toSoapModels(
		List<CargaSocioRemesa> models) {
		List<CargaSocioRemesaSoap> soapModels = new ArrayList<CargaSocioRemesaSoap>(models.size());

		for (CargaSocioRemesa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CargaSocioRemesaSoap[soapModels.size()]);
	}

	public CargaSocioRemesaSoap() {
	}

	public long getPrimaryKey() {
		return _idSocioRemesa;
	}

	public void setPrimaryKey(long pk) {
		setIdSocioRemesa(pk);
	}

	public long getIdSocioRemesa() {
		return _idSocioRemesa;
	}

	public void setIdSocioRemesa(long idSocioRemesa) {
		_idSocioRemesa = idSocioRemesa;
	}

	public String getEmpresa() {
		return _empresa;
	}

	public void setEmpresa(String empresa) {
		_empresa = empresa;
	}

	public String getPaisCobertura() {
		return _paisCobertura;
	}

	public void setPaisCobertura(String paisCobertura) {
		_paisCobertura = paisCobertura;
	}

	public String getPaginaWeb() {
		return _paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		_paginaWeb = paginaWeb;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	private long _idSocioRemesa;
	private String _empresa;
	private String _paisCobertura;
	private String _paginaWeb;
	private String _telefono;
}