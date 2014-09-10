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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.ConfiguracionPerfiladorServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.ConfiguracionPerfiladorServiceSoap
 * @generated
 */
public class ConfiguracionPerfiladorSoap implements Serializable {
	public static ConfiguracionPerfiladorSoap toSoapModel(
		ConfiguracionPerfilador model) {
		ConfiguracionPerfiladorSoap soapModel = new ConfiguracionPerfiladorSoap();

		soapModel.setIdConfiguracionPerfilador(model.getIdConfiguracionPerfilador());
		soapModel.setTipoVariable(model.getTipoVariable());
		soapModel.setNombreVariable(model.getNombreVariable());
		soapModel.setCodigoClasificacion(model.getCodigoClasificacion());
		soapModel.setCodigoVariablePadre(model.getCodigoVariablePadre());
		soapModel.setValor1(model.getValor1());
		soapModel.setValor2(model.getValor2());
		soapModel.setValor3(model.getValor3());
		soapModel.setEstado(model.getEstado());

		return soapModel;
	}

	public static ConfiguracionPerfiladorSoap[] toSoapModels(
		ConfiguracionPerfilador[] models) {
		ConfiguracionPerfiladorSoap[] soapModels = new ConfiguracionPerfiladorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConfiguracionPerfiladorSoap[][] toSoapModels(
		ConfiguracionPerfilador[][] models) {
		ConfiguracionPerfiladorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConfiguracionPerfiladorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConfiguracionPerfiladorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConfiguracionPerfiladorSoap[] toSoapModels(
		List<ConfiguracionPerfilador> models) {
		List<ConfiguracionPerfiladorSoap> soapModels = new ArrayList<ConfiguracionPerfiladorSoap>(models.size());

		for (ConfiguracionPerfilador model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConfiguracionPerfiladorSoap[soapModels.size()]);
	}

	public ConfiguracionPerfiladorSoap() {
	}

	public long getPrimaryKey() {
		return _idConfiguracionPerfilador;
	}

	public void setPrimaryKey(long pk) {
		setIdConfiguracionPerfilador(pk);
	}

	public long getIdConfiguracionPerfilador() {
		return _idConfiguracionPerfilador;
	}

	public void setIdConfiguracionPerfilador(long idConfiguracionPerfilador) {
		_idConfiguracionPerfilador = idConfiguracionPerfilador;
	}

	public Long getTipoVariable() {
		return _tipoVariable;
	}

	public void setTipoVariable(Long tipoVariable) {
		_tipoVariable = tipoVariable;
	}

	public String getNombreVariable() {
		return _nombreVariable;
	}

	public void setNombreVariable(String nombreVariable) {
		_nombreVariable = nombreVariable;
	}

	public Long getCodigoClasificacion() {
		return _codigoClasificacion;
	}

	public void setCodigoClasificacion(Long codigoClasificacion) {
		_codigoClasificacion = codigoClasificacion;
	}

	public Long getCodigoVariablePadre() {
		return _codigoVariablePadre;
	}

	public void setCodigoVariablePadre(Long codigoVariablePadre) {
		_codigoVariablePadre = codigoVariablePadre;
	}

	public String getValor1() {
		return _valor1;
	}

	public void setValor1(String valor1) {
		_valor1 = valor1;
	}

	public String getValor2() {
		return _valor2;
	}

	public void setValor2(String valor2) {
		_valor2 = valor2;
	}

	public String getValor3() {
		return _valor3;
	}

	public void setValor3(String valor3) {
		_valor3 = valor3;
	}

	public Integer getEstado() {
		return _estado;
	}

	public void setEstado(Integer estado) {
		_estado = estado;
	}

	private long _idConfiguracionPerfilador;
	private Long _tipoVariable;
	private String _nombreVariable;
	private Long _codigoClasificacion;
	private Long _codigoVariablePadre;
	private String _valor1;
	private String _valor2;
	private String _valor3;
	private Integer _estado;
}