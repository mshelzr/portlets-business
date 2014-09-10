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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.CargaTiendaServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.CargaTiendaServiceSoap
 * @generated
 */
public class CargaTiendaSoap implements Serializable {
	public static CargaTiendaSoap toSoapModel(CargaTienda model) {
		CargaTiendaSoap soapModel = new CargaTiendaSoap();

		soapModel.setIdCargaTienda(model.getIdCargaTienda());
		soapModel.setIdPtoServicio(model.getIdPtoServicio());
		soapModel.setIdCanal(model.getIdCanal());
		soapModel.setIdSubCanal(model.getIdSubCanal());
		soapModel.setCodDepartamento(model.getCodDepartamento());
		soapModel.setCodProvincia(model.getCodProvincia());
		soapModel.setCodDistrito(model.getCodDistrito());
		soapModel.setNomDepartamento(model.getNomDepartamento());
		soapModel.setNomProvincia(model.getNomProvincia());
		soapModel.setNomDistrito(model.getNomDistrito());
		soapModel.setLatitud(model.getLatitud());
		soapModel.setLongitud(model.getLongitud());
		soapModel.setDireccion(model.getDireccion());
		soapModel.setHorario(model.getHorario());
		soapModel.setTipoLocacion(model.getTipoLocacion());
		soapModel.setCodTienda(model.getCodTienda());
		soapModel.setIdLocacion(model.getIdLocacion());
		soapModel.setLocacion(model.getLocacion());
		soapModel.setEmailCom(model.getEmailCom());
		soapModel.setTelefono(model.getTelefono());

		return soapModel;
	}

	public static CargaTiendaSoap[] toSoapModels(CargaTienda[] models) {
		CargaTiendaSoap[] soapModels = new CargaTiendaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CargaTiendaSoap[][] toSoapModels(CargaTienda[][] models) {
		CargaTiendaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CargaTiendaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CargaTiendaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CargaTiendaSoap[] toSoapModels(List<CargaTienda> models) {
		List<CargaTiendaSoap> soapModels = new ArrayList<CargaTiendaSoap>(models.size());

		for (CargaTienda model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CargaTiendaSoap[soapModels.size()]);
	}

	public CargaTiendaSoap() {
	}

	public long getPrimaryKey() {
		return _idCargaTienda;
	}

	public void setPrimaryKey(long pk) {
		setIdCargaTienda(pk);
	}

	public long getIdCargaTienda() {
		return _idCargaTienda;
	}

	public void setIdCargaTienda(long idCargaTienda) {
		_idCargaTienda = idCargaTienda;
	}

	public String getIdPtoServicio() {
		return _idPtoServicio;
	}

	public void setIdPtoServicio(String idPtoServicio) {
		_idPtoServicio = idPtoServicio;
	}

	public String getIdCanal() {
		return _idCanal;
	}

	public void setIdCanal(String idCanal) {
		_idCanal = idCanal;
	}

	public String getIdSubCanal() {
		return _idSubCanal;
	}

	public void setIdSubCanal(String idSubCanal) {
		_idSubCanal = idSubCanal;
	}

	public String getCodDepartamento() {
		return _codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		_codDepartamento = codDepartamento;
	}

	public String getCodProvincia() {
		return _codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		_codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return _codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		_codDistrito = codDistrito;
	}

	public String getNomDepartamento() {
		return _nomDepartamento;
	}

	public void setNomDepartamento(String nomDepartamento) {
		_nomDepartamento = nomDepartamento;
	}

	public String getNomProvincia() {
		return _nomProvincia;
	}

	public void setNomProvincia(String nomProvincia) {
		_nomProvincia = nomProvincia;
	}

	public String getNomDistrito() {
		return _nomDistrito;
	}

	public void setNomDistrito(String nomDistrito) {
		_nomDistrito = nomDistrito;
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

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getHorario() {
		return _horario;
	}

	public void setHorario(String horario) {
		_horario = horario;
	}

	public String getTipoLocacion() {
		return _tipoLocacion;
	}

	public void setTipoLocacion(String tipoLocacion) {
		_tipoLocacion = tipoLocacion;
	}

	public Integer getCodTienda() {
		return _codTienda;
	}

	public void setCodTienda(Integer codTienda) {
		_codTienda = codTienda;
	}

	public Integer getIdLocacion() {
		return _idLocacion;
	}

	public void setIdLocacion(Integer idLocacion) {
		_idLocacion = idLocacion;
	}

	public String getLocacion() {
		return _locacion;
	}

	public void setLocacion(String locacion) {
		_locacion = locacion;
	}

	public String getEmailCom() {
		return _emailCom;
	}

	public void setEmailCom(String emailCom) {
		_emailCom = emailCom;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	private long _idCargaTienda;
	private String _idPtoServicio;
	private String _idCanal;
	private String _idSubCanal;
	private String _codDepartamento;
	private String _codProvincia;
	private String _codDistrito;
	private String _nomDepartamento;
	private String _nomProvincia;
	private String _nomDistrito;
	private String _latitud;
	private String _longitud;
	private String _direccion;
	private String _horario;
	private String _tipoLocacion;
	private Integer _codTienda;
	private Integer _idLocacion;
	private String _locacion;
	private String _emailCom;
	private String _telefono;
}