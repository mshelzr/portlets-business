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

import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class SolicitudProductoClp extends BaseModelImpl<SolicitudProducto>
	implements SolicitudProducto {
	public SolicitudProductoClp() {
	}

	public Class<?> getModelClass() {
		return SolicitudProducto.class;
	}

	public String getModelClassName() {
		return SolicitudProducto.class.getName();
	}

	public long getPrimaryKey() {
		return _idSolicitudProducto;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdSolicitudProducto(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idSolicitudProducto);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idSolicitudProducto", getIdSolicitudProducto());
		attributes.put("idTipoDocumentoAdq", getIdTipoDocumentoAdq());
		attributes.put("idTipoDocumento", getIdTipoDocumento());
		attributes.put("tipoCredito", getTipoCredito());
		attributes.put("codigoCanal", getCodigoCanal());
		attributes.put("tipoEnvio", getTipoEnvio());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("apellidoPaterno", getApellidoPaterno());
		attributes.put("apellidoMaterno", getApellidoMaterno());
		attributes.put("primerNombre", getPrimerNombre());
		attributes.put("segundoNombre", getSegundoNombre());
		attributes.put("fechaNacimiento", getFechaNacimiento());
		attributes.put("sexo", getSexo());
		attributes.put("rentaMensual", getRentaMensual());
		attributes.put("celular", getCelular());
		attributes.put("telefonoCasa", getTelefonoCasa());
		attributes.put("telefonoTrabajo", getTelefonoTrabajo());
		attributes.put("anexo", getAnexo());
		attributes.put("idEstadoCivilAdq", getIdEstadoCivilAdq());
		attributes.put("idEstadoCivil", getIdEstadoCivil());
		attributes.put("RUC", getRUC());
		attributes.put("razonSocial", getRazonSocial());
		attributes.put("situacionLaboral", getSituacionLaboral());
		attributes.put("idSituacionLaboral", getIdSituacionLaboral());
		attributes.put("idDepartamento", getIdDepartamento());
		attributes.put("idProvincia", getIdProvincia());
		attributes.put("idDistrito", getIdDistrito());
		attributes.put("nomDepartamento", getNomDepartamento());
		attributes.put("nomProvincia", getNomProvincia());
		attributes.put("nomDistrito", getNomDistrito());
		attributes.put("correoElectronico", getCorreoElectronico());
		attributes.put("direccionEnvio", getDireccionEnvio());
		attributes.put("placaVehiculo", getPlacaVehiculo());
		attributes.put("IdSession", getIdSession());
		attributes.put("IPCliente", getIPCliente());
		attributes.put("horarioEnvio", getHorarioEnvio());
		attributes.put("fechaRegistro", getFechaRegistro());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());
		attributes.put("fechaResultadoPreCalif", getFechaResultadoPreCalif());
		attributes.put("fechaEnvioLead", getFechaEnvioLead());
		attributes.put("fechaEnvioEmailing", getFechaEnvioEmailing());
		attributes.put("estadoPreCalificacion", getEstadoPreCalificacion());
		attributes.put("estadoRegLead", getEstadoRegLead());
		attributes.put("estadoEnvCorreo", getEstadoEnvCorreo());
		attributes.put("respPreCalificacion", getRespPreCalificacion());
		attributes.put("descripcionLead", getDescripcionLead());
		attributes.put("fechaActualizacion", getFechaActualizacion());
		attributes.put("montoProspectado", getMontoProspectado());
		attributes.put("codigoCampania", getCodigoCampania());
		attributes.put("codigoMoneda", getCodigoMoneda());
		attributes.put("nombreSupervisor", getNombreSupervisor());
		attributes.put("respRegLead", getRespRegLead());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idSolicitudProducto = (Long)attributes.get("idSolicitudProducto");

		if (idSolicitudProducto != null) {
			setIdSolicitudProducto(idSolicitudProducto);
		}

		Integer idTipoDocumentoAdq = (Integer)attributes.get(
				"idTipoDocumentoAdq");

		if (idTipoDocumentoAdq != null) {
			setIdTipoDocumentoAdq(idTipoDocumentoAdq);
		}

		String idTipoDocumento = (String)attributes.get("idTipoDocumento");

		if (idTipoDocumento != null) {
			setIdTipoDocumento(idTipoDocumento);
		}

		Integer tipoCredito = (Integer)attributes.get("tipoCredito");

		if (tipoCredito != null) {
			setTipoCredito(tipoCredito);
		}

		String codigoCanal = (String)attributes.get("codigoCanal");

		if (codigoCanal != null) {
			setCodigoCanal(codigoCanal);
		}

		String tipoEnvio = (String)attributes.get("tipoEnvio");

		if (tipoEnvio != null) {
			setTipoEnvio(tipoEnvio);
		}

		String numeroDocumento = (String)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		String apellidoPaterno = (String)attributes.get("apellidoPaterno");

		if (apellidoPaterno != null) {
			setApellidoPaterno(apellidoPaterno);
		}

		String apellidoMaterno = (String)attributes.get("apellidoMaterno");

		if (apellidoMaterno != null) {
			setApellidoMaterno(apellidoMaterno);
		}

		String primerNombre = (String)attributes.get("primerNombre");

		if (primerNombre != null) {
			setPrimerNombre(primerNombre);
		}

		String segundoNombre = (String)attributes.get("segundoNombre");

		if (segundoNombre != null) {
			setSegundoNombre(segundoNombre);
		}

		Date fechaNacimiento = (Date)attributes.get("fechaNacimiento");

		if (fechaNacimiento != null) {
			setFechaNacimiento(fechaNacimiento);
		}

		String sexo = (String)attributes.get("sexo");

		if (sexo != null) {
			setSexo(sexo);
		}

		Double rentaMensual = (Double)attributes.get("rentaMensual");

		if (rentaMensual != null) {
			setRentaMensual(rentaMensual);
		}

		String celular = (String)attributes.get("celular");

		if (celular != null) {
			setCelular(celular);
		}

		String telefonoCasa = (String)attributes.get("telefonoCasa");

		if (telefonoCasa != null) {
			setTelefonoCasa(telefonoCasa);
		}

		String telefonoTrabajo = (String)attributes.get("telefonoTrabajo");

		if (telefonoTrabajo != null) {
			setTelefonoTrabajo(telefonoTrabajo);
		}

		String anexo = (String)attributes.get("anexo");

		if (anexo != null) {
			setAnexo(anexo);
		}

		Integer idEstadoCivilAdq = (Integer)attributes.get("idEstadoCivilAdq");

		if (idEstadoCivilAdq != null) {
			setIdEstadoCivilAdq(idEstadoCivilAdq);
		}

		String idEstadoCivil = (String)attributes.get("idEstadoCivil");

		if (idEstadoCivil != null) {
			setIdEstadoCivil(idEstadoCivil);
		}

		String RUC = (String)attributes.get("RUC");

		if (RUC != null) {
			setRUC(RUC);
		}

		String razonSocial = (String)attributes.get("razonSocial");

		if (razonSocial != null) {
			setRazonSocial(razonSocial);
		}

		String situacionLaboral = (String)attributes.get("situacionLaboral");

		if (situacionLaboral != null) {
			setSituacionLaboral(situacionLaboral);
		}

		Integer idSituacionLaboral = (Integer)attributes.get(
				"idSituacionLaboral");

		if (idSituacionLaboral != null) {
			setIdSituacionLaboral(idSituacionLaboral);
		}

		String idDepartamento = (String)attributes.get("idDepartamento");

		if (idDepartamento != null) {
			setIdDepartamento(idDepartamento);
		}

		String idProvincia = (String)attributes.get("idProvincia");

		if (idProvincia != null) {
			setIdProvincia(idProvincia);
		}

		String idDistrito = (String)attributes.get("idDistrito");

		if (idDistrito != null) {
			setIdDistrito(idDistrito);
		}

		String nomDepartamento = (String)attributes.get("nomDepartamento");

		if (nomDepartamento != null) {
			setNomDepartamento(nomDepartamento);
		}

		String nomProvincia = (String)attributes.get("nomProvincia");

		if (nomProvincia != null) {
			setNomProvincia(nomProvincia);
		}

		String nomDistrito = (String)attributes.get("nomDistrito");

		if (nomDistrito != null) {
			setNomDistrito(nomDistrito);
		}

		String correoElectronico = (String)attributes.get("correoElectronico");

		if (correoElectronico != null) {
			setCorreoElectronico(correoElectronico);
		}

		String direccionEnvio = (String)attributes.get("direccionEnvio");

		if (direccionEnvio != null) {
			setDireccionEnvio(direccionEnvio);
		}

		String placaVehiculo = (String)attributes.get("placaVehiculo");

		if (placaVehiculo != null) {
			setPlacaVehiculo(placaVehiculo);
		}

		String IdSession = (String)attributes.get("IdSession");

		if (IdSession != null) {
			setIdSession(IdSession);
		}

		String IPCliente = (String)attributes.get("IPCliente");

		if (IPCliente != null) {
			setIPCliente(IPCliente);
		}

		Date horarioEnvio = (Date)attributes.get("horarioEnvio");

		if (horarioEnvio != null) {
			setHorarioEnvio(horarioEnvio);
		}

		Date fechaRegistro = (Date)attributes.get("fechaRegistro");

		if (fechaRegistro != null) {
			setFechaRegistro(fechaRegistro);
		}

		String UTMSource = (String)attributes.get("UTMSource");

		if (UTMSource != null) {
			setUTMSource(UTMSource);
		}

		String UTMMedium = (String)attributes.get("UTMMedium");

		if (UTMMedium != null) {
			setUTMMedium(UTMMedium);
		}

		String UTMCampaing = (String)attributes.get("UTMCampaing");

		if (UTMCampaing != null) {
			setUTMCampaing(UTMCampaing);
		}

		String UTMContent = (String)attributes.get("UTMContent");

		if (UTMContent != null) {
			setUTMContent(UTMContent);
		}

		Date fechaResultadoPreCalif = (Date)attributes.get(
				"fechaResultadoPreCalif");

		if (fechaResultadoPreCalif != null) {
			setFechaResultadoPreCalif(fechaResultadoPreCalif);
		}

		Date fechaEnvioLead = (Date)attributes.get("fechaEnvioLead");

		if (fechaEnvioLead != null) {
			setFechaEnvioLead(fechaEnvioLead);
		}

		Date fechaEnvioEmailing = (Date)attributes.get("fechaEnvioEmailing");

		if (fechaEnvioEmailing != null) {
			setFechaEnvioEmailing(fechaEnvioEmailing);
		}

		Boolean estadoPreCalificacion = (Boolean)attributes.get(
				"estadoPreCalificacion");

		if (estadoPreCalificacion != null) {
			setEstadoPreCalificacion(estadoPreCalificacion);
		}

		Boolean estadoRegLead = (Boolean)attributes.get("estadoRegLead");

		if (estadoRegLead != null) {
			setEstadoRegLead(estadoRegLead);
		}

		Boolean estadoEnvCorreo = (Boolean)attributes.get("estadoEnvCorreo");

		if (estadoEnvCorreo != null) {
			setEstadoEnvCorreo(estadoEnvCorreo);
		}

		String respPreCalificacion = (String)attributes.get(
				"respPreCalificacion");

		if (respPreCalificacion != null) {
			setRespPreCalificacion(respPreCalificacion);
		}

		String descripcionLead = (String)attributes.get("descripcionLead");

		if (descripcionLead != null) {
			setDescripcionLead(descripcionLead);
		}

		Date fechaActualizacion = (Date)attributes.get("fechaActualizacion");

		if (fechaActualizacion != null) {
			setFechaActualizacion(fechaActualizacion);
		}

		Double montoProspectado = (Double)attributes.get("montoProspectado");

		if (montoProspectado != null) {
			setMontoProspectado(montoProspectado);
		}

		String codigoCampania = (String)attributes.get("codigoCampania");

		if (codigoCampania != null) {
			setCodigoCampania(codigoCampania);
		}

		String codigoMoneda = (String)attributes.get("codigoMoneda");

		if (codigoMoneda != null) {
			setCodigoMoneda(codigoMoneda);
		}

		String nombreSupervisor = (String)attributes.get("nombreSupervisor");

		if (nombreSupervisor != null) {
			setNombreSupervisor(nombreSupervisor);
		}

		String respRegLead = (String)attributes.get("respRegLead");

		if (respRegLead != null) {
			setRespRegLead(respRegLead);
		}
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

	public BaseModel<?> getSolicitudProductoRemoteModel() {
		return _solicitudProductoRemoteModel;
	}

	public void setSolicitudProductoRemoteModel(
		BaseModel<?> solicitudProductoRemoteModel) {
		_solicitudProductoRemoteModel = solicitudProductoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SolicitudProductoLocalServiceUtil.addSolicitudProducto(this);
		}
		else {
			SolicitudProductoLocalServiceUtil.updateSolicitudProducto(this);
		}
	}

	@Override
	public SolicitudProducto toEscapedModel() {
		return (SolicitudProducto)Proxy.newProxyInstance(SolicitudProducto.class.getClassLoader(),
			new Class[] { SolicitudProducto.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SolicitudProductoClp clone = new SolicitudProductoClp();

		clone.setIdSolicitudProducto(getIdSolicitudProducto());
		clone.setIdTipoDocumentoAdq(getIdTipoDocumentoAdq());
		clone.setIdTipoDocumento(getIdTipoDocumento());
		clone.setTipoCredito(getTipoCredito());
		clone.setCodigoCanal(getCodigoCanal());
		clone.setTipoEnvio(getTipoEnvio());
		clone.setNumeroDocumento(getNumeroDocumento());
		clone.setApellidoPaterno(getApellidoPaterno());
		clone.setApellidoMaterno(getApellidoMaterno());
		clone.setPrimerNombre(getPrimerNombre());
		clone.setSegundoNombre(getSegundoNombre());
		clone.setFechaNacimiento(getFechaNacimiento());
		clone.setSexo(getSexo());
		clone.setRentaMensual(getRentaMensual());
		clone.setCelular(getCelular());
		clone.setTelefonoCasa(getTelefonoCasa());
		clone.setTelefonoTrabajo(getTelefonoTrabajo());
		clone.setAnexo(getAnexo());
		clone.setIdEstadoCivilAdq(getIdEstadoCivilAdq());
		clone.setIdEstadoCivil(getIdEstadoCivil());
		clone.setRUC(getRUC());
		clone.setRazonSocial(getRazonSocial());
		clone.setSituacionLaboral(getSituacionLaboral());
		clone.setIdSituacionLaboral(getIdSituacionLaboral());
		clone.setIdDepartamento(getIdDepartamento());
		clone.setIdProvincia(getIdProvincia());
		clone.setIdDistrito(getIdDistrito());
		clone.setNomDepartamento(getNomDepartamento());
		clone.setNomProvincia(getNomProvincia());
		clone.setNomDistrito(getNomDistrito());
		clone.setCorreoElectronico(getCorreoElectronico());
		clone.setDireccionEnvio(getDireccionEnvio());
		clone.setPlacaVehiculo(getPlacaVehiculo());
		clone.setIdSession(getIdSession());
		clone.setIPCliente(getIPCliente());
		clone.setHorarioEnvio(getHorarioEnvio());
		clone.setFechaRegistro(getFechaRegistro());
		clone.setUTMSource(getUTMSource());
		clone.setUTMMedium(getUTMMedium());
		clone.setUTMCampaing(getUTMCampaing());
		clone.setUTMContent(getUTMContent());
		clone.setFechaResultadoPreCalif(getFechaResultadoPreCalif());
		clone.setFechaEnvioLead(getFechaEnvioLead());
		clone.setFechaEnvioEmailing(getFechaEnvioEmailing());
		clone.setEstadoPreCalificacion(getEstadoPreCalificacion());
		clone.setEstadoRegLead(getEstadoRegLead());
		clone.setEstadoEnvCorreo(getEstadoEnvCorreo());
		clone.setRespPreCalificacion(getRespPreCalificacion());
		clone.setDescripcionLead(getDescripcionLead());
		clone.setFechaActualizacion(getFechaActualizacion());
		clone.setMontoProspectado(getMontoProspectado());
		clone.setCodigoCampania(getCodigoCampania());
		clone.setCodigoMoneda(getCodigoMoneda());
		clone.setNombreSupervisor(getNombreSupervisor());
		clone.setRespRegLead(getRespRegLead());

		return clone;
	}

	public int compareTo(SolicitudProducto solicitudProducto) {
		long primaryKey = solicitudProducto.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		SolicitudProductoClp solicitudProducto = null;

		try {
			solicitudProducto = (SolicitudProductoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = solicitudProducto.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(111);

		sb.append("{idSolicitudProducto=");
		sb.append(getIdSolicitudProducto());
		sb.append(", idTipoDocumentoAdq=");
		sb.append(getIdTipoDocumentoAdq());
		sb.append(", idTipoDocumento=");
		sb.append(getIdTipoDocumento());
		sb.append(", tipoCredito=");
		sb.append(getTipoCredito());
		sb.append(", codigoCanal=");
		sb.append(getCodigoCanal());
		sb.append(", tipoEnvio=");
		sb.append(getTipoEnvio());
		sb.append(", numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", apellidoPaterno=");
		sb.append(getApellidoPaterno());
		sb.append(", apellidoMaterno=");
		sb.append(getApellidoMaterno());
		sb.append(", primerNombre=");
		sb.append(getPrimerNombre());
		sb.append(", segundoNombre=");
		sb.append(getSegundoNombre());
		sb.append(", fechaNacimiento=");
		sb.append(getFechaNacimiento());
		sb.append(", sexo=");
		sb.append(getSexo());
		sb.append(", rentaMensual=");
		sb.append(getRentaMensual());
		sb.append(", celular=");
		sb.append(getCelular());
		sb.append(", telefonoCasa=");
		sb.append(getTelefonoCasa());
		sb.append(", telefonoTrabajo=");
		sb.append(getTelefonoTrabajo());
		sb.append(", anexo=");
		sb.append(getAnexo());
		sb.append(", idEstadoCivilAdq=");
		sb.append(getIdEstadoCivilAdq());
		sb.append(", idEstadoCivil=");
		sb.append(getIdEstadoCivil());
		sb.append(", RUC=");
		sb.append(getRUC());
		sb.append(", razonSocial=");
		sb.append(getRazonSocial());
		sb.append(", situacionLaboral=");
		sb.append(getSituacionLaboral());
		sb.append(", idSituacionLaboral=");
		sb.append(getIdSituacionLaboral());
		sb.append(", idDepartamento=");
		sb.append(getIdDepartamento());
		sb.append(", idProvincia=");
		sb.append(getIdProvincia());
		sb.append(", idDistrito=");
		sb.append(getIdDistrito());
		sb.append(", nomDepartamento=");
		sb.append(getNomDepartamento());
		sb.append(", nomProvincia=");
		sb.append(getNomProvincia());
		sb.append(", nomDistrito=");
		sb.append(getNomDistrito());
		sb.append(", correoElectronico=");
		sb.append(getCorreoElectronico());
		sb.append(", direccionEnvio=");
		sb.append(getDireccionEnvio());
		sb.append(", placaVehiculo=");
		sb.append(getPlacaVehiculo());
		sb.append(", IdSession=");
		sb.append(getIdSession());
		sb.append(", IPCliente=");
		sb.append(getIPCliente());
		sb.append(", horarioEnvio=");
		sb.append(getHorarioEnvio());
		sb.append(", fechaRegistro=");
		sb.append(getFechaRegistro());
		sb.append(", UTMSource=");
		sb.append(getUTMSource());
		sb.append(", UTMMedium=");
		sb.append(getUTMMedium());
		sb.append(", UTMCampaing=");
		sb.append(getUTMCampaing());
		sb.append(", UTMContent=");
		sb.append(getUTMContent());
		sb.append(", fechaResultadoPreCalif=");
		sb.append(getFechaResultadoPreCalif());
		sb.append(", fechaEnvioLead=");
		sb.append(getFechaEnvioLead());
		sb.append(", fechaEnvioEmailing=");
		sb.append(getFechaEnvioEmailing());
		sb.append(", estadoPreCalificacion=");
		sb.append(getEstadoPreCalificacion());
		sb.append(", estadoRegLead=");
		sb.append(getEstadoRegLead());
		sb.append(", estadoEnvCorreo=");
		sb.append(getEstadoEnvCorreo());
		sb.append(", respPreCalificacion=");
		sb.append(getRespPreCalificacion());
		sb.append(", descripcionLead=");
		sb.append(getDescripcionLead());
		sb.append(", fechaActualizacion=");
		sb.append(getFechaActualizacion());
		sb.append(", montoProspectado=");
		sb.append(getMontoProspectado());
		sb.append(", codigoCampania=");
		sb.append(getCodigoCampania());
		sb.append(", codigoMoneda=");
		sb.append(getCodigoMoneda());
		sb.append(", nombreSupervisor=");
		sb.append(getNombreSupervisor());
		sb.append(", respRegLead=");
		sb.append(getRespRegLead());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(169);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.SolicitudProducto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idSolicitudProducto</column-name><column-value><![CDATA[");
		sb.append(getIdSolicitudProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idTipoDocumentoAdq</column-name><column-value><![CDATA[");
		sb.append(getIdTipoDocumentoAdq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idTipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getIdTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoCredito</column-name><column-value><![CDATA[");
		sb.append(getTipoCredito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoCanal</column-name><column-value><![CDATA[");
		sb.append(getCodigoCanal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoEnvio</column-name><column-value><![CDATA[");
		sb.append(getTipoEnvio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumeroDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidoPaterno</column-name><column-value><![CDATA[");
		sb.append(getApellidoPaterno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidoMaterno</column-name><column-value><![CDATA[");
		sb.append(getApellidoMaterno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>primerNombre</column-name><column-value><![CDATA[");
		sb.append(getPrimerNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>segundoNombre</column-name><column-value><![CDATA[");
		sb.append(getSegundoNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaNacimiento</column-name><column-value><![CDATA[");
		sb.append(getFechaNacimiento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sexo</column-name><column-value><![CDATA[");
		sb.append(getSexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rentaMensual</column-name><column-value><![CDATA[");
		sb.append(getRentaMensual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>celular</column-name><column-value><![CDATA[");
		sb.append(getCelular());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefonoCasa</column-name><column-value><![CDATA[");
		sb.append(getTelefonoCasa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefonoTrabajo</column-name><column-value><![CDATA[");
		sb.append(getTelefonoTrabajo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anexo</column-name><column-value><![CDATA[");
		sb.append(getAnexo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idEstadoCivilAdq</column-name><column-value><![CDATA[");
		sb.append(getIdEstadoCivilAdq());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idEstadoCivil</column-name><column-value><![CDATA[");
		sb.append(getIdEstadoCivil());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RUC</column-name><column-value><![CDATA[");
		sb.append(getRUC());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>razonSocial</column-name><column-value><![CDATA[");
		sb.append(getRazonSocial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>situacionLaboral</column-name><column-value><![CDATA[");
		sb.append(getSituacionLaboral());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSituacionLaboral</column-name><column-value><![CDATA[");
		sb.append(getIdSituacionLaboral());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDepartamento</column-name><column-value><![CDATA[");
		sb.append(getIdDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idProvincia</column-name><column-value><![CDATA[");
		sb.append(getIdProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDistrito</column-name><column-value><![CDATA[");
		sb.append(getIdDistrito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomDepartamento</column-name><column-value><![CDATA[");
		sb.append(getNomDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomProvincia</column-name><column-value><![CDATA[");
		sb.append(getNomProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nomDistrito</column-name><column-value><![CDATA[");
		sb.append(getNomDistrito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>correoElectronico</column-name><column-value><![CDATA[");
		sb.append(getCorreoElectronico());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>direccionEnvio</column-name><column-value><![CDATA[");
		sb.append(getDireccionEnvio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placaVehiculo</column-name><column-value><![CDATA[");
		sb.append(getPlacaVehiculo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IdSession</column-name><column-value><![CDATA[");
		sb.append(getIdSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IPCliente</column-name><column-value><![CDATA[");
		sb.append(getIPCliente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>horarioEnvio</column-name><column-value><![CDATA[");
		sb.append(getHorarioEnvio());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaRegistro</column-name><column-value><![CDATA[");
		sb.append(getFechaRegistro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMSource</column-name><column-value><![CDATA[");
		sb.append(getUTMSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMMedium</column-name><column-value><![CDATA[");
		sb.append(getUTMMedium());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMCampaing</column-name><column-value><![CDATA[");
		sb.append(getUTMCampaing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMContent</column-name><column-value><![CDATA[");
		sb.append(getUTMContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaResultadoPreCalif</column-name><column-value><![CDATA[");
		sb.append(getFechaResultadoPreCalif());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaEnvioLead</column-name><column-value><![CDATA[");
		sb.append(getFechaEnvioLead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaEnvioEmailing</column-name><column-value><![CDATA[");
		sb.append(getFechaEnvioEmailing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estadoPreCalificacion</column-name><column-value><![CDATA[");
		sb.append(getEstadoPreCalificacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estadoRegLead</column-name><column-value><![CDATA[");
		sb.append(getEstadoRegLead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estadoEnvCorreo</column-name><column-value><![CDATA[");
		sb.append(getEstadoEnvCorreo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respPreCalificacion</column-name><column-value><![CDATA[");
		sb.append(getRespPreCalificacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descripcionLead</column-name><column-value><![CDATA[");
		sb.append(getDescripcionLead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaActualizacion</column-name><column-value><![CDATA[");
		sb.append(getFechaActualizacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>montoProspectado</column-name><column-value><![CDATA[");
		sb.append(getMontoProspectado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoCampania</column-name><column-value><![CDATA[");
		sb.append(getCodigoCampania());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoMoneda</column-name><column-value><![CDATA[");
		sb.append(getCodigoMoneda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombreSupervisor</column-name><column-value><![CDATA[");
		sb.append(getNombreSupervisor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respRegLead</column-name><column-value><![CDATA[");
		sb.append(getRespRegLead());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _solicitudProductoRemoteModel;
}