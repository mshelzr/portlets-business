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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.ConfiguracionProductoServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.ConfiguracionProductoServiceSoap
 * @generated
 */
public class ConfiguracionProductoSoap implements Serializable {
	public static ConfiguracionProductoSoap toSoapModel(
		ConfiguracionProducto model) {
		ConfiguracionProductoSoap soapModel = new ConfiguracionProductoSoap();

		soapModel.setIdConfiguracionProducto(model.getIdConfiguracionProducto());
		soapModel.setIdConfiguracionPerfilador(model.getIdConfiguracionPerfilador());
		soapModel.setIdProducto(model.getIdProducto());
		soapModel.setNombreProducto(model.getNombreProducto());
		soapModel.setCodigoSiebelProducto(model.getCodigoSiebelProducto());
		soapModel.setEstadoConfiguracion(model.getEstadoConfiguracion());

		return soapModel;
	}

	public static ConfiguracionProductoSoap[] toSoapModels(
		ConfiguracionProducto[] models) {
		ConfiguracionProductoSoap[] soapModels = new ConfiguracionProductoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConfiguracionProductoSoap[][] toSoapModels(
		ConfiguracionProducto[][] models) {
		ConfiguracionProductoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConfiguracionProductoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConfiguracionProductoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConfiguracionProductoSoap[] toSoapModels(
		List<ConfiguracionProducto> models) {
		List<ConfiguracionProductoSoap> soapModels = new ArrayList<ConfiguracionProductoSoap>(models.size());

		for (ConfiguracionProducto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConfiguracionProductoSoap[soapModels.size()]);
	}

	public ConfiguracionProductoSoap() {
	}

	public long getPrimaryKey() {
		return _idConfiguracionProducto;
	}

	public void setPrimaryKey(long pk) {
		setIdConfiguracionProducto(pk);
	}

	public long getIdConfiguracionProducto() {
		return _idConfiguracionProducto;
	}

	public void setIdConfiguracionProducto(long idConfiguracionProducto) {
		_idConfiguracionProducto = idConfiguracionProducto;
	}

	public Long getIdConfiguracionPerfilador() {
		return _idConfiguracionPerfilador;
	}

	public void setIdConfiguracionPerfilador(Long idConfiguracionPerfilador) {
		_idConfiguracionPerfilador = idConfiguracionPerfilador;
	}

	public Long getIdProducto() {
		return _idProducto;
	}

	public void setIdProducto(Long idProducto) {
		_idProducto = idProducto;
	}

	public String getNombreProducto() {
		return _nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		_nombreProducto = nombreProducto;
	}

	public String getCodigoSiebelProducto() {
		return _codigoSiebelProducto;
	}

	public void setCodigoSiebelProducto(String codigoSiebelProducto) {
		_codigoSiebelProducto = codigoSiebelProducto;
	}

	public Integer getEstadoConfiguracion() {
		return _estadoConfiguracion;
	}

	public void setEstadoConfiguracion(Integer estadoConfiguracion) {
		_estadoConfiguracion = estadoConfiguracion;
	}

	private long _idConfiguracionProducto;
	private Long _idConfiguracionPerfilador;
	private Long _idProducto;
	private String _nombreProducto;
	private String _codigoSiebelProducto;
	private Integer _estadoConfiguracion;
}