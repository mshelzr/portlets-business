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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.CargaDescuentoServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.CargaDescuentoServiceSoap
 * @generated
 */
public class CargaDescuentoSoap implements Serializable {
	public static CargaDescuentoSoap toSoapModel(CargaDescuento model) {
		CargaDescuentoSoap soapModel = new CargaDescuentoSoap();

		soapModel.setIdCargaDesc(model.getIdCargaDesc());
		soapModel.setLocal(model.getLocal());
		soapModel.setDescuentoGeneral(model.getDescuentoGeneral());
		soapModel.setCondicionesRestricciones(model.getCondicionesRestricciones());
		soapModel.setDireccion(model.getDireccion());
		soapModel.setIdDistrito(model.getIdDistrito());
		soapModel.setDistrito(model.getDistrito());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setWeb(model.getWeb());
		soapModel.setFinVigencia(model.getFinVigencia());
		soapModel.setCategoria(model.getCategoria());
		soapModel.setCoordenada(model.getCoordenada());
		soapModel.setURLImagen(model.getURLImagen());
		soapModel.setLatitud(model.getLatitud());
		soapModel.setLongitud(model.getLongitud());

		return soapModel;
	}

	public static CargaDescuentoSoap[] toSoapModels(CargaDescuento[] models) {
		CargaDescuentoSoap[] soapModels = new CargaDescuentoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CargaDescuentoSoap[][] toSoapModels(CargaDescuento[][] models) {
		CargaDescuentoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CargaDescuentoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CargaDescuentoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CargaDescuentoSoap[] toSoapModels(List<CargaDescuento> models) {
		List<CargaDescuentoSoap> soapModels = new ArrayList<CargaDescuentoSoap>(models.size());

		for (CargaDescuento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CargaDescuentoSoap[soapModels.size()]);
	}

	public CargaDescuentoSoap() {
	}

	public long getPrimaryKey() {
		return _idCargaDesc;
	}

	public void setPrimaryKey(long pk) {
		setIdCargaDesc(pk);
	}

	public long getIdCargaDesc() {
		return _idCargaDesc;
	}

	public void setIdCargaDesc(long idCargaDesc) {
		_idCargaDesc = idCargaDesc;
	}

	public String getLocal() {
		return _local;
	}

	public void setLocal(String local) {
		_local = local;
	}

	public String getDescuentoGeneral() {
		return _descuentoGeneral;
	}

	public void setDescuentoGeneral(String descuentoGeneral) {
		_descuentoGeneral = descuentoGeneral;
	}

	public String getCondicionesRestricciones() {
		return _condicionesRestricciones;
	}

	public void setCondicionesRestricciones(String condicionesRestricciones) {
		_condicionesRestricciones = condicionesRestricciones;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getIdDistrito() {
		return _idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		_idDistrito = idDistrito;
	}

	public String getDistrito() {
		return _distrito;
	}

	public void setDistrito(String distrito) {
		_distrito = distrito;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public String getWeb() {
		return _web;
	}

	public void setWeb(String web) {
		_web = web;
	}

	public Date getFinVigencia() {
		return _finVigencia;
	}

	public void setFinVigencia(Date finVigencia) {
		_finVigencia = finVigencia;
	}

	public String getCategoria() {
		return _categoria;
	}

	public void setCategoria(String categoria) {
		_categoria = categoria;
	}

	public String getCoordenada() {
		return _coordenada;
	}

	public void setCoordenada(String coordenada) {
		_coordenada = coordenada;
	}

	public String getURLImagen() {
		return _URLImagen;
	}

	public void setURLImagen(String URLImagen) {
		_URLImagen = URLImagen;
	}

	public String getLatitud() {
		return _latitud;
	}

	public void setLatitud(String latitud) {
		_latitud = latitud;
	}

	public String getLongitud() {
		return _longitud;
	}

	public void setLongitud(String longitud) {
		_longitud = longitud;
	}

	private long _idCargaDesc;
	private String _local;
	private String _descuentoGeneral;
	private String _condicionesRestricciones;
	private String _direccion;
	private String _idDistrito;
	private String _distrito;
	private String _telefono;
	private String _web;
	private Date _finVigencia;
	private String _categoria;
	private String _coordenada;
	private String _URLImagen;
	private String _latitud;
	private String _longitud;
}