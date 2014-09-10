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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.FondosMutuosServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.FondosMutuosServiceSoap
 * @generated
 */
public class FondosMutuosSoap implements Serializable {
	public static FondosMutuosSoap toSoapModel(FondosMutuos model) {
		FondosMutuosSoap soapModel = new FondosMutuosSoap();

		soapModel.setIdValorCuota(model.getIdValorCuota());
		soapModel.setCodigoMoneda(model.getCodigoMoneda());
		soapModel.setTipoFondo(model.getTipoFondo());
		soapModel.setValorCuota(model.getValorCuota());
		soapModel.setFecha(model.getFecha());

		return soapModel;
	}

	public static FondosMutuosSoap[] toSoapModels(FondosMutuos[] models) {
		FondosMutuosSoap[] soapModels = new FondosMutuosSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FondosMutuosSoap[][] toSoapModels(FondosMutuos[][] models) {
		FondosMutuosSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FondosMutuosSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FondosMutuosSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FondosMutuosSoap[] toSoapModels(List<FondosMutuos> models) {
		List<FondosMutuosSoap> soapModels = new ArrayList<FondosMutuosSoap>(models.size());

		for (FondosMutuos model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FondosMutuosSoap[soapModels.size()]);
	}

	public FondosMutuosSoap() {
	}

	public long getPrimaryKey() {
		return _idValorCuota;
	}

	public void setPrimaryKey(long pk) {
		setIdValorCuota(pk);
	}

	public long getIdValorCuota() {
		return _idValorCuota;
	}

	public void setIdValorCuota(long idValorCuota) {
		_idValorCuota = idValorCuota;
	}

	public String getCodigoMoneda() {
		return _codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		_codigoMoneda = codigoMoneda;
	}

	public String getTipoFondo() {
		return _tipoFondo;
	}

	public void setTipoFondo(String tipoFondo) {
		_tipoFondo = tipoFondo;
	}

	public Double getValorCuota() {
		return _valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		_valorCuota = valorCuota;
	}

	public String getFecha() {
		return _fecha;
	}

	public void setFecha(String fecha) {
		_fecha = fecha;
	}

	private long _idValorCuota;
	private String _codigoMoneda;
	private String _tipoFondo;
	private Double _valorCuota;
	private String _fecha;
}