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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.ProductoComplementarioServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.ProductoComplementarioServiceSoap
 * @generated
 */
public class ProductoComplementarioSoap implements Serializable {
	public static ProductoComplementarioSoap toSoapModel(
		ProductoComplementario model) {
		ProductoComplementarioSoap soapModel = new ProductoComplementarioSoap();

		soapModel.setIdProductoComplementario(model.getIdProductoComplementario());
		soapModel.setIdSolicitudProducto(model.getIdSolicitudProducto());
		soapModel.setPrincipalidad(model.getPrincipalidad());
		soapModel.setProducto(model.getProducto());
		soapModel.setIdProducto(model.getIdProducto());
		soapModel.setIdGrupoProducto(model.getIdGrupoProducto());
		soapModel.setEmailSupervisor(model.getEmailSupervisor());

		return soapModel;
	}

	public static ProductoComplementarioSoap[] toSoapModels(
		ProductoComplementario[] models) {
		ProductoComplementarioSoap[] soapModels = new ProductoComplementarioSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductoComplementarioSoap[][] toSoapModels(
		ProductoComplementario[][] models) {
		ProductoComplementarioSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductoComplementarioSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductoComplementarioSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductoComplementarioSoap[] toSoapModels(
		List<ProductoComplementario> models) {
		List<ProductoComplementarioSoap> soapModels = new ArrayList<ProductoComplementarioSoap>(models.size());

		for (ProductoComplementario model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductoComplementarioSoap[soapModels.size()]);
	}

	public ProductoComplementarioSoap() {
	}

	public long getPrimaryKey() {
		return _idProductoComplementario;
	}

	public void setPrimaryKey(long pk) {
		setIdProductoComplementario(pk);
	}

	public long getIdProductoComplementario() {
		return _idProductoComplementario;
	}

	public void setIdProductoComplementario(long idProductoComplementario) {
		_idProductoComplementario = idProductoComplementario;
	}

	public long getIdSolicitudProducto() {
		return _idSolicitudProducto;
	}

	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_idSolicitudProducto = idSolicitudProducto;
	}

	public String getPrincipalidad() {
		return _principalidad;
	}

	public void setPrincipalidad(String principalidad) {
		_principalidad = principalidad;
	}

	public String getProducto() {
		return _producto;
	}

	public void setProducto(String producto) {
		_producto = producto;
	}

	public String getIdProducto() {
		return _idProducto;
	}

	public void setIdProducto(String idProducto) {
		_idProducto = idProducto;
	}

	public String getIdGrupoProducto() {
		return _idGrupoProducto;
	}

	public void setIdGrupoProducto(String idGrupoProducto) {
		_idGrupoProducto = idGrupoProducto;
	}

	public String getEmailSupervisor() {
		return _emailSupervisor;
	}

	public void setEmailSupervisor(String emailSupervisor) {
		_emailSupervisor = emailSupervisor;
	}

	private long _idProductoComplementario;
	private long _idSolicitudProducto;
	private String _principalidad;
	private String _producto;
	private String _idProducto;
	private String _idGrupoProducto;
	private String _emailSupervisor;
}