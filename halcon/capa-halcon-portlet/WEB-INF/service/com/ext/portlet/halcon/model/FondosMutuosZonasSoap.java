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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.FondosMutuosZonasServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.FondosMutuosZonasServiceSoap
 * @generated
 */
public class FondosMutuosZonasSoap implements Serializable {
	public static FondosMutuosZonasSoap toSoapModel(FondosMutuosZonas model) {
		FondosMutuosZonasSoap soapModel = new FondosMutuosZonasSoap();

		soapModel.setIdFondoMutuoZona(model.getIdFondoMutuoZona());
		soapModel.setCodigoZona(model.getCodigoZona());
		soapModel.setZona(model.getZona());
		soapModel.setPuntajeInicial(model.getPuntajeInicial());
		soapModel.setPuntajeFinal(model.getPuntajeFinal());
		soapModel.setDescripcionZona(model.getDescripcionZona());
		soapModel.setMoneda(model.getMoneda());
		soapModel.setRiesgo(model.getRiesgo());

		return soapModel;
	}

	public static FondosMutuosZonasSoap[] toSoapModels(
		FondosMutuosZonas[] models) {
		FondosMutuosZonasSoap[] soapModels = new FondosMutuosZonasSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FondosMutuosZonasSoap[][] toSoapModels(
		FondosMutuosZonas[][] models) {
		FondosMutuosZonasSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FondosMutuosZonasSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FondosMutuosZonasSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FondosMutuosZonasSoap[] toSoapModels(
		List<FondosMutuosZonas> models) {
		List<FondosMutuosZonasSoap> soapModels = new ArrayList<FondosMutuosZonasSoap>(models.size());

		for (FondosMutuosZonas model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FondosMutuosZonasSoap[soapModels.size()]);
	}

	public FondosMutuosZonasSoap() {
	}

	public long getPrimaryKey() {
		return _idFondoMutuoZona;
	}

	public void setPrimaryKey(long pk) {
		setIdFondoMutuoZona(pk);
	}

	public long getIdFondoMutuoZona() {
		return _idFondoMutuoZona;
	}

	public void setIdFondoMutuoZona(long idFondoMutuoZona) {
		_idFondoMutuoZona = idFondoMutuoZona;
	}

	public String getCodigoZona() {
		return _codigoZona;
	}

	public void setCodigoZona(String codigoZona) {
		_codigoZona = codigoZona;
	}

	public String getZona() {
		return _zona;
	}

	public void setZona(String zona) {
		_zona = zona;
	}

	public Integer getPuntajeInicial() {
		return _puntajeInicial;
	}

	public void setPuntajeInicial(Integer puntajeInicial) {
		_puntajeInicial = puntajeInicial;
	}

	public Integer getPuntajeFinal() {
		return _puntajeFinal;
	}

	public void setPuntajeFinal(Integer puntajeFinal) {
		_puntajeFinal = puntajeFinal;
	}

	public String getDescripcionZona() {
		return _descripcionZona;
	}

	public void setDescripcionZona(String descripcionZona) {
		_descripcionZona = descripcionZona;
	}

	public String getMoneda() {
		return _moneda;
	}

	public void setMoneda(String moneda) {
		_moneda = moneda;
	}

	public String getRiesgo() {
		return _riesgo;
	}

	public void setRiesgo(String riesgo) {
		_riesgo = riesgo;
	}

	private long _idFondoMutuoZona;
	private String _codigoZona;
	private String _zona;
	private Integer _puntajeInicial;
	private Integer _puntajeFinal;
	private String _descripcionZona;
	private String _moneda;
	private String _riesgo;
}