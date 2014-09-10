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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.ValorCuotaServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.ValorCuotaServiceSoap
 * @generated
 */
public class ValorCuotaSoap implements Serializable {
	public static ValorCuotaSoap toSoapModel(ValorCuota model) {
		ValorCuotaSoap soapModel = new ValorCuotaSoap();

		soapModel.setIdValorCuota(model.getIdValorCuota());
		soapModel.setTipoFondoMutuo(model.getTipoFondoMutuo());
		soapModel.setFecha(model.getFecha());
		soapModel.setValorCuota(model.getValorCuota());

		return soapModel;
	}

	public static ValorCuotaSoap[] toSoapModels(ValorCuota[] models) {
		ValorCuotaSoap[] soapModels = new ValorCuotaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ValorCuotaSoap[][] toSoapModels(ValorCuota[][] models) {
		ValorCuotaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ValorCuotaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ValorCuotaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ValorCuotaSoap[] toSoapModels(List<ValorCuota> models) {
		List<ValorCuotaSoap> soapModels = new ArrayList<ValorCuotaSoap>(models.size());

		for (ValorCuota model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ValorCuotaSoap[soapModels.size()]);
	}

	public ValorCuotaSoap() {
	}

	public long getPrimaryKey() {
		return _IdValorCuota;
	}

	public void setPrimaryKey(long pk) {
		setIdValorCuota(pk);
	}

	public long getIdValorCuota() {
		return _IdValorCuota;
	}

	public void setIdValorCuota(long IdValorCuota) {
		_IdValorCuota = IdValorCuota;
	}

	public Integer getTipoFondoMutuo() {
		return _tipoFondoMutuo;
	}

	public void setTipoFondoMutuo(Integer tipoFondoMutuo) {
		_tipoFondoMutuo = tipoFondoMutuo;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public Double getValorCuota() {
		return _valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		_valorCuota = valorCuota;
	}

	private long _IdValorCuota;
	private Integer _tipoFondoMutuo;
	private Date _fecha;
	private Double _valorCuota;
}