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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.ParametroServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.ParametroServiceSoap
 * @generated
 */
public class ParametroSoap implements Serializable {
	public static ParametroSoap toSoapModel(Parametro model) {
		ParametroSoap soapModel = new ParametroSoap();

		soapModel.setIdParametro(model.getIdParametro());
		soapModel.setIdParametroPadre(model.getIdParametroPadre());
		soapModel.setValorMonto1(model.getValorMonto1());
		soapModel.setValorMonto2(model.getValorMonto2());
		soapModel.setValorMonto3(model.getValorMonto3());
		soapModel.setDato1(model.getDato1());
		soapModel.setDato2(model.getDato2());
		soapModel.setDato3(model.getDato3());
		soapModel.setDato4(model.getDato4());
		soapModel.setNum1(model.getNum1());
		soapModel.setNum2(model.getNum2());
		soapModel.setNum3(model.getNum3());

		return soapModel;
	}

	public static ParametroSoap[] toSoapModels(Parametro[] models) {
		ParametroSoap[] soapModels = new ParametroSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ParametroSoap[][] toSoapModels(Parametro[][] models) {
		ParametroSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ParametroSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ParametroSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ParametroSoap[] toSoapModels(List<Parametro> models) {
		List<ParametroSoap> soapModels = new ArrayList<ParametroSoap>(models.size());

		for (Parametro model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ParametroSoap[soapModels.size()]);
	}

	public ParametroSoap() {
	}

	public int getPrimaryKey() {
		return _idParametro;
	}

	public void setPrimaryKey(int pk) {
		setIdParametro(pk);
	}

	public int getIdParametro() {
		return _idParametro;
	}

	public void setIdParametro(int idParametro) {
		_idParametro = idParametro;
	}

	public Integer getIdParametroPadre() {
		return _idParametroPadre;
	}

	public void setIdParametroPadre(Integer idParametroPadre) {
		_idParametroPadre = idParametroPadre;
	}

	public String getValorMonto1() {
		return _valorMonto1;
	}

	public void setValorMonto1(String valorMonto1) {
		_valorMonto1 = valorMonto1;
	}

	public String getValorMonto2() {
		return _valorMonto2;
	}

	public void setValorMonto2(String valorMonto2) {
		_valorMonto2 = valorMonto2;
	}

	public String getValorMonto3() {
		return _valorMonto3;
	}

	public void setValorMonto3(String valorMonto3) {
		_valorMonto3 = valorMonto3;
	}

	public String getDato1() {
		return _dato1;
	}

	public void setDato1(String dato1) {
		_dato1 = dato1;
	}

	public String getDato2() {
		return _dato2;
	}

	public void setDato2(String dato2) {
		_dato2 = dato2;
	}

	public String getDato3() {
		return _dato3;
	}

	public void setDato3(String dato3) {
		_dato3 = dato3;
	}

	public String getDato4() {
		return _dato4;
	}

	public void setDato4(String dato4) {
		_dato4 = dato4;
	}

	public Integer getNum1() {
		return _num1;
	}

	public void setNum1(Integer num1) {
		_num1 = num1;
	}

	public Integer getNum2() {
		return _num2;
	}

	public void setNum2(Integer num2) {
		_num2 = num2;
	}

	public Integer getNum3() {
		return _num3;
	}

	public void setNum3(Integer num3) {
		_num3 = num3;
	}

	private int _idParametro;
	private Integer _idParametroPadre;
	private String _valorMonto1;
	private String _valorMonto2;
	private String _valorMonto3;
	private String _dato1;
	private String _dato2;
	private String _dato3;
	private String _dato4;
	private Integer _num1;
	private Integer _num2;
	private Integer _num3;
}