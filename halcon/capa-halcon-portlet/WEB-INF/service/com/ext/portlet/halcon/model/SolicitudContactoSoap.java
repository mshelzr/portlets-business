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
 * This class is used by SOAP remote services.
 *
 * @author    Infonet-Consulting
 * @generated
 */
public class SolicitudContactoSoap implements Serializable {
	public static SolicitudContactoSoap toSoapModel(SolicitudContacto model) {
		SolicitudContactoSoap soapModel = new SolicitudContactoSoap();

		soapModel.setIdSolicitudContacto(model.getIdSolicitudContacto());
		soapModel.setEsCliente(model.getEsCliente());
		soapModel.setNombres(model.getNombres());
		soapModel.setApellidos(model.getApellidos());
		soapModel.setEmail(model.getEmail());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNdocumento(model.getNdocumento());
		soapModel.setDireccion(model.getDireccion());
		soapModel.setDepartamento(model.getDepartamento());
		soapModel.setProvincia(model.getProvincia());
		soapModel.setDistrito(model.getDistrito());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setFecha(model.getFecha());
		soapModel.setMensaje(model.getMensaje());
		soapModel.setMoneda(model.getMoneda());
		soapModel.setImporte(model.getImporte());
		soapModel.setTipoMensaje(model.getTipoMensaje());
		soapModel.setTipoTema(model.getTipoTema());

		return soapModel;
	}

	public static SolicitudContactoSoap[] toSoapModels(
		SolicitudContacto[] models) {
		SolicitudContactoSoap[] soapModels = new SolicitudContactoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SolicitudContactoSoap[][] toSoapModels(
		SolicitudContacto[][] models) {
		SolicitudContactoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SolicitudContactoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SolicitudContactoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SolicitudContactoSoap[] toSoapModels(
		List<SolicitudContacto> models) {
		List<SolicitudContactoSoap> soapModels = new ArrayList<SolicitudContactoSoap>(models.size());

		for (SolicitudContacto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SolicitudContactoSoap[soapModels.size()]);
	}

	public SolicitudContactoSoap() {
	}

	public long getPrimaryKey() {
		return _idSolicitudContacto;
	}

	public void setPrimaryKey(long pk) {
		setIdSolicitudContacto(pk);
	}

	public long getIdSolicitudContacto() {
		return _idSolicitudContacto;
	}

	public void setIdSolicitudContacto(long idSolicitudContacto) {
		_idSolicitudContacto = idSolicitudContacto;
	}

	public Integer getEsCliente() {
		return _esCliente;
	}

	public void setEsCliente(Integer esCliente) {
		_esCliente = esCliente;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidos() {
		return _apellidos;
	}

	public void setApellidos(String apellidos) {
		_apellidos = apellidos;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNdocumento() {
		return _ndocumento;
	}

	public void setNdocumento(String ndocumento) {
		_ndocumento = ndocumento;
	}

	public String getDireccion() {
		return _direccion;
	}

	public void setDireccion(String direccion) {
		_direccion = direccion;
	}

	public String getDepartamento() {
		return _departamento;
	}

	public void setDepartamento(String departamento) {
		_departamento = departamento;
	}

	public String getProvincia() {
		return _provincia;
	}

	public void setProvincia(String provincia) {
		_provincia = provincia;
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

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getMensaje() {
		return _mensaje;
	}

	public void setMensaje(String mensaje) {
		_mensaje = mensaje;
	}

	public String getMoneda() {
		return _moneda;
	}

	public void setMoneda(String moneda) {
		_moneda = moneda;
	}

	public String getImporte() {
		return _importe;
	}

	public void setImporte(String importe) {
		_importe = importe;
	}

	public String getTipoMensaje() {
		return _tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		_tipoMensaje = tipoMensaje;
	}

	public String getTipoTema() {
		return _tipoTema;
	}

	public void setTipoTema(String tipoTema) {
		_tipoTema = tipoTema;
	}

	private long _idSolicitudContacto;
	private Integer _esCliente;
	private String _nombres;
	private String _apellidos;
	private String _email;
	private String _tipoDocumento;
	private String _ndocumento;
	private String _direccion;
	private String _departamento;
	private String _provincia;
	private String _distrito;
	private String _telefono;
	private Date _fecha;
	private String _mensaje;
	private String _moneda;
	private String _importe;
	private String _tipoMensaje;
	private String _tipoTema;
}