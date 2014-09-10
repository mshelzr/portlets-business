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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.SolicitudProductoServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.SolicitudProductoServiceSoap
 * @generated
 */
public class SolicitudProductoSoap implements Serializable {
	public static SolicitudProductoSoap toSoapModel(SolicitudProducto model) {
		SolicitudProductoSoap soapModel = new SolicitudProductoSoap();

		soapModel.setIdSolicitudProducto(model.getIdSolicitudProducto());
		soapModel.setIdTipoDocumentoAdq(model.getIdTipoDocumentoAdq());
		soapModel.setIdTipoDocumento(model.getIdTipoDocumento());
		soapModel.setTipoCredito(model.getTipoCredito());
		soapModel.setCodigoCanal(model.getCodigoCanal());
		soapModel.setTipoEnvio(model.getTipoEnvio());
		soapModel.setNumeroDocumento(model.getNumeroDocumento());
		soapModel.setApellidoPaterno(model.getApellidoPaterno());
		soapModel.setApellidoMaterno(model.getApellidoMaterno());
		soapModel.setPrimerNombre(model.getPrimerNombre());
		soapModel.setSegundoNombre(model.getSegundoNombre());
		soapModel.setFechaNacimiento(model.getFechaNacimiento());
		soapModel.setSexo(model.getSexo());
		soapModel.setRentaMensual(model.getRentaMensual());
		soapModel.setCelular(model.getCelular());
		soapModel.setTelefonoCasa(model.getTelefonoCasa());
		soapModel.setTelefonoTrabajo(model.getTelefonoTrabajo());
		soapModel.setAnexo(model.getAnexo());
		soapModel.setIdEstadoCivilAdq(model.getIdEstadoCivilAdq());
		soapModel.setIdEstadoCivil(model.getIdEstadoCivil());
		soapModel.setRUC(model.getRUC());
		soapModel.setRazonSocial(model.getRazonSocial());
		soapModel.setSituacionLaboral(model.getSituacionLaboral());
		soapModel.setIdSituacionLaboral(model.getIdSituacionLaboral());
		soapModel.setIdDepartamento(model.getIdDepartamento());
		soapModel.setIdProvincia(model.getIdProvincia());
		soapModel.setIdDistrito(model.getIdDistrito());
		soapModel.setNomDepartamento(model.getNomDepartamento());
		soapModel.setNomProvincia(model.getNomProvincia());
		soapModel.setNomDistrito(model.getNomDistrito());
		soapModel.setCorreoElectronico(model.getCorreoElectronico());
		soapModel.setDireccionEnvio(model.getDireccionEnvio());
		soapModel.setPlacaVehiculo(model.getPlacaVehiculo());
		soapModel.setIdSession(model.getIdSession());
		soapModel.setIPCliente(model.getIPCliente());
		soapModel.setHorarioEnvio(model.getHorarioEnvio());
		soapModel.setFechaRegistro(model.getFechaRegistro());
		soapModel.setUTMSource(model.getUTMSource());
		soapModel.setUTMMedium(model.getUTMMedium());
		soapModel.setUTMCampaing(model.getUTMCampaing());
		soapModel.setUTMContent(model.getUTMContent());
		soapModel.setFechaResultadoPreCalif(model.getFechaResultadoPreCalif());
		soapModel.setFechaEnvioLead(model.getFechaEnvioLead());
		soapModel.setFechaEnvioEmailing(model.getFechaEnvioEmailing());
		soapModel.setEstadoPreCalificacion(model.getEstadoPreCalificacion());
		soapModel.setEstadoRegLead(model.getEstadoRegLead());
		soapModel.setEstadoEnvCorreo(model.getEstadoEnvCorreo());
		soapModel.setRespPreCalificacion(model.getRespPreCalificacion());
		soapModel.setDescripcionLead(model.getDescripcionLead());
		soapModel.setFechaActualizacion(model.getFechaActualizacion());
		soapModel.setMontoProspectado(model.getMontoProspectado());
		soapModel.setCodigoCampania(model.getCodigoCampania());
		soapModel.setCodigoMoneda(model.getCodigoMoneda());
		soapModel.setNombreSupervisor(model.getNombreSupervisor());
		soapModel.setRespRegLead(model.getRespRegLead());

		return soapModel;
	}

	public static SolicitudProductoSoap[] toSoapModels(
		SolicitudProducto[] models) {
		SolicitudProductoSoap[] soapModels = new SolicitudProductoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SolicitudProductoSoap[][] toSoapModels(
		SolicitudProducto[][] models) {
		SolicitudProductoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SolicitudProductoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SolicitudProductoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SolicitudProductoSoap[] toSoapModels(
		List<SolicitudProducto> models) {
		List<SolicitudProductoSoap> soapModels = new ArrayList<SolicitudProductoSoap>(models.size());

		for (SolicitudProducto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SolicitudProductoSoap[soapModels.size()]);
	}

	public SolicitudProductoSoap() {
	}

	public long getPrimaryKey() {
		return _idSolicitudProducto;
	}

	public void setPrimaryKey(long pk) {
		setIdSolicitudProducto(pk);
	}

	public long getIdSolicitudProducto() {
		return _idSolicitudProducto;
	}

	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_idSolicitudProducto = idSolicitudProducto;
	}

	public Integer getIdTipoDocumentoAdq() {
		return _idTipoDocumentoAdq;
	}

	public void setIdTipoDocumentoAdq(Integer idTipoDocumentoAdq) {
		_idTipoDocumentoAdq = idTipoDocumentoAdq;
	}

	public String getIdTipoDocumento() {
		return _idTipoDocumento;
	}

	public void setIdTipoDocumento(String idTipoDocumento) {
		_idTipoDocumento = idTipoDocumento;
	}

	public Integer getTipoCredito() {
		return _tipoCredito;
	}

	public void setTipoCredito(Integer tipoCredito) {
		_tipoCredito = tipoCredito;
	}

	public String getCodigoCanal() {
		return _codigoCanal;
	}

	public void setCodigoCanal(String codigoCanal) {
		_codigoCanal = codigoCanal;
	}

	public String getTipoEnvio() {
		return _tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		_tipoEnvio = tipoEnvio;
	}

	public String getNumeroDocumento() {
		return _numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		_numeroDocumento = numeroDocumento;
	}

	public String getApellidoPaterno() {
		return _apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		_apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return _apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		_apellidoMaterno = apellidoMaterno;
	}

	public String getPrimerNombre() {
		return _primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		_primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return _segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		_segundoNombre = segundoNombre;
	}

	public Date getFechaNacimiento() {
		return _fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		_fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return _sexo;
	}

	public void setSexo(String sexo) {
		_sexo = sexo;
	}

	public Double getRentaMensual() {
		return _rentaMensual;
	}

	public void setRentaMensual(Double rentaMensual) {
		_rentaMensual = rentaMensual;
	}

	public String getCelular() {
		return _celular;
	}

	public void setCelular(String celular) {
		_celular = celular;
	}

	public String getTelefonoCasa() {
		return _telefonoCasa;
	}

	public void setTelefonoCasa(String telefonoCasa) {
		_telefonoCasa = telefonoCasa;
	}

	public String getTelefonoTrabajo() {
		return _telefonoTrabajo;
	}

	public void setTelefonoTrabajo(String telefonoTrabajo) {
		_telefonoTrabajo = telefonoTrabajo;
	}

	public String getAnexo() {
		return _anexo;
	}

	public void setAnexo(String anexo) {
		_anexo = anexo;
	}

	public Integer getIdEstadoCivilAdq() {
		return _idEstadoCivilAdq;
	}

	public void setIdEstadoCivilAdq(Integer idEstadoCivilAdq) {
		_idEstadoCivilAdq = idEstadoCivilAdq;
	}

	public String getIdEstadoCivil() {
		return _idEstadoCivil;
	}

	public void setIdEstadoCivil(String idEstadoCivil) {
		_idEstadoCivil = idEstadoCivil;
	}

	public String getRUC() {
		return _RUC;
	}

	public void setRUC(String RUC) {
		_RUC = RUC;
	}

	public String getRazonSocial() {
		return _razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		_razonSocial = razonSocial;
	}

	public String getSituacionLaboral() {
		return _situacionLaboral;
	}

	public void setSituacionLaboral(String situacionLaboral) {
		_situacionLaboral = situacionLaboral;
	}

	public Integer getIdSituacionLaboral() {
		return _idSituacionLaboral;
	}

	public void setIdSituacionLaboral(Integer idSituacionLaboral) {
		_idSituacionLaboral = idSituacionLaboral;
	}

	public String getIdDepartamento() {
		return _idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		_idDepartamento = idDepartamento;
	}

	public String getIdProvincia() {
		return _idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		_idProvincia = idProvincia;
	}

	public String getIdDistrito() {
		return _idDistrito;
	}

	public void setIdDistrito(String idDistrito) {
		_idDistrito = idDistrito;
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

	public String getCorreoElectronico() {
		return _correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		_correoElectronico = correoElectronico;
	}

	public String getDireccionEnvio() {
		return _direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		_direccionEnvio = direccionEnvio;
	}

	public String getPlacaVehiculo() {
		return _placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		_placaVehiculo = placaVehiculo;
	}

	public String getIdSession() {
		return _IdSession;
	}

	public void setIdSession(String IdSession) {
		_IdSession = IdSession;
	}

	public String getIPCliente() {
		return _IPCliente;
	}

	public void setIPCliente(String IPCliente) {
		_IPCliente = IPCliente;
	}

	public Date getHorarioEnvio() {
		return _horarioEnvio;
	}

	public void setHorarioEnvio(Date horarioEnvio) {
		_horarioEnvio = horarioEnvio;
	}

	public Date getFechaRegistro() {
		return _fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		_fechaRegistro = fechaRegistro;
	}

	public String getUTMSource() {
		return _UTMSource;
	}

	public void setUTMSource(String UTMSource) {
		_UTMSource = UTMSource;
	}

	public String getUTMMedium() {
		return _UTMMedium;
	}

	public void setUTMMedium(String UTMMedium) {
		_UTMMedium = UTMMedium;
	}

	public String getUTMCampaing() {
		return _UTMCampaing;
	}

	public void setUTMCampaing(String UTMCampaing) {
		_UTMCampaing = UTMCampaing;
	}

	public String getUTMContent() {
		return _UTMContent;
	}

	public void setUTMContent(String UTMContent) {
		_UTMContent = UTMContent;
	}

	public Date getFechaResultadoPreCalif() {
		return _fechaResultadoPreCalif;
	}

	public void setFechaResultadoPreCalif(Date fechaResultadoPreCalif) {
		_fechaResultadoPreCalif = fechaResultadoPreCalif;
	}

	public Date getFechaEnvioLead() {
		return _fechaEnvioLead;
	}

	public void setFechaEnvioLead(Date fechaEnvioLead) {
		_fechaEnvioLead = fechaEnvioLead;
	}

	public Date getFechaEnvioEmailing() {
		return _fechaEnvioEmailing;
	}

	public void setFechaEnvioEmailing(Date fechaEnvioEmailing) {
		_fechaEnvioEmailing = fechaEnvioEmailing;
	}

	public Boolean getEstadoPreCalificacion() {
		return _estadoPreCalificacion;
	}

	public void setEstadoPreCalificacion(Boolean estadoPreCalificacion) {
		_estadoPreCalificacion = estadoPreCalificacion;
	}

	public Boolean getEstadoRegLead() {
		return _estadoRegLead;
	}

	public void setEstadoRegLead(Boolean estadoRegLead) {
		_estadoRegLead = estadoRegLead;
	}

	public Boolean getEstadoEnvCorreo() {
		return _estadoEnvCorreo;
	}

	public void setEstadoEnvCorreo(Boolean estadoEnvCorreo) {
		_estadoEnvCorreo = estadoEnvCorreo;
	}

	public String getRespPreCalificacion() {
		return _respPreCalificacion;
	}

	public void setRespPreCalificacion(String respPreCalificacion) {
		_respPreCalificacion = respPreCalificacion;
	}

	public String getDescripcionLead() {
		return _descripcionLead;
	}

	public void setDescripcionLead(String descripcionLead) {
		_descripcionLead = descripcionLead;
	}

	public Date getFechaActualizacion() {
		return _fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		_fechaActualizacion = fechaActualizacion;
	}

	public Double getMontoProspectado() {
		return _montoProspectado;
	}

	public void setMontoProspectado(Double montoProspectado) {
		_montoProspectado = montoProspectado;
	}

	public String getCodigoCampania() {
		return _codigoCampania;
	}

	public void setCodigoCampania(String codigoCampania) {
		_codigoCampania = codigoCampania;
	}

	public String getCodigoMoneda() {
		return _codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		_codigoMoneda = codigoMoneda;
	}

	public String getNombreSupervisor() {
		return _nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		_nombreSupervisor = nombreSupervisor;
	}

	public String getRespRegLead() {
		return _respRegLead;
	}

	public void setRespRegLead(String respRegLead) {
		_respRegLead = respRegLead;
	}

	private long _idSolicitudProducto;
	private Integer _idTipoDocumentoAdq;
	private String _idTipoDocumento;
	private Integer _tipoCredito;
	private String _codigoCanal;
	private String _tipoEnvio;
	private String _numeroDocumento;
	private String _apellidoPaterno;
	private String _apellidoMaterno;
	private String _primerNombre;
	private String _segundoNombre;
	private Date _fechaNacimiento;
	private String _sexo;
	private Double _rentaMensual;
	private String _celular;
	private String _telefonoCasa;
	private String _telefonoTrabajo;
	private String _anexo;
	private Integer _idEstadoCivilAdq;
	private String _idEstadoCivil;
	private String _RUC;
	private String _razonSocial;
	private String _situacionLaboral;
	private Integer _idSituacionLaboral;
	private String _idDepartamento;
	private String _idProvincia;
	private String _idDistrito;
	private String _nomDepartamento;
	private String _nomProvincia;
	private String _nomDistrito;
	private String _correoElectronico;
	private String _direccionEnvio;
	private String _placaVehiculo;
	private String _IdSession;
	private String _IPCliente;
	private Date _horarioEnvio;
	private Date _fechaRegistro;
	private String _UTMSource;
	private String _UTMMedium;
	private String _UTMCampaing;
	private String _UTMContent;
	private Date _fechaResultadoPreCalif;
	private Date _fechaEnvioLead;
	private Date _fechaEnvioEmailing;
	private Boolean _estadoPreCalificacion;
	private Boolean _estadoRegLead;
	private Boolean _estadoEnvCorreo;
	private String _respPreCalificacion;
	private String _descripcionLead;
	private Date _fechaActualizacion;
	private Double _montoProspectado;
	private String _codigoCampania;
	private String _codigoMoneda;
	private String _nombreSupervisor;
	private String _respRegLead;
}