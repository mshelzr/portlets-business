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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SolicitudProducto}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       SolicitudProducto
 * @generated
 */
public class SolicitudProductoWrapper implements SolicitudProducto,
	ModelWrapper<SolicitudProducto> {
	public SolicitudProductoWrapper(SolicitudProducto solicitudProducto) {
		_solicitudProducto = solicitudProducto;
	}

	public Class<?> getModelClass() {
		return SolicitudProducto.class;
	}

	public String getModelClassName() {
		return SolicitudProducto.class.getName();
	}

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

	/**
	* Returns the primary key of this solicitud producto.
	*
	* @return the primary key of this solicitud producto
	*/
	public long getPrimaryKey() {
		return _solicitudProducto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this solicitud producto.
	*
	* @param primaryKey the primary key of this solicitud producto
	*/
	public void setPrimaryKey(long primaryKey) {
		_solicitudProducto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id solicitud producto of this solicitud producto.
	*
	* @return the id solicitud producto of this solicitud producto
	*/
	public long getIdSolicitudProducto() {
		return _solicitudProducto.getIdSolicitudProducto();
	}

	/**
	* Sets the id solicitud producto of this solicitud producto.
	*
	* @param idSolicitudProducto the id solicitud producto of this solicitud producto
	*/
	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_solicitudProducto.setIdSolicitudProducto(idSolicitudProducto);
	}

	/**
	* Returns the id tipo documento adq of this solicitud producto.
	*
	* @return the id tipo documento adq of this solicitud producto
	*/
	public java.lang.Integer getIdTipoDocumentoAdq() {
		return _solicitudProducto.getIdTipoDocumentoAdq();
	}

	/**
	* Sets the id tipo documento adq of this solicitud producto.
	*
	* @param idTipoDocumentoAdq the id tipo documento adq of this solicitud producto
	*/
	public void setIdTipoDocumentoAdq(java.lang.Integer idTipoDocumentoAdq) {
		_solicitudProducto.setIdTipoDocumentoAdq(idTipoDocumentoAdq);
	}

	/**
	* Returns the id tipo documento of this solicitud producto.
	*
	* @return the id tipo documento of this solicitud producto
	*/
	public java.lang.String getIdTipoDocumento() {
		return _solicitudProducto.getIdTipoDocumento();
	}

	/**
	* Sets the id tipo documento of this solicitud producto.
	*
	* @param idTipoDocumento the id tipo documento of this solicitud producto
	*/
	public void setIdTipoDocumento(java.lang.String idTipoDocumento) {
		_solicitudProducto.setIdTipoDocumento(idTipoDocumento);
	}

	/**
	* Returns the tipo credito of this solicitud producto.
	*
	* @return the tipo credito of this solicitud producto
	*/
	public java.lang.Integer getTipoCredito() {
		return _solicitudProducto.getTipoCredito();
	}

	/**
	* Sets the tipo credito of this solicitud producto.
	*
	* @param tipoCredito the tipo credito of this solicitud producto
	*/
	public void setTipoCredito(java.lang.Integer tipoCredito) {
		_solicitudProducto.setTipoCredito(tipoCredito);
	}

	/**
	* Returns the codigo canal of this solicitud producto.
	*
	* @return the codigo canal of this solicitud producto
	*/
	public java.lang.String getCodigoCanal() {
		return _solicitudProducto.getCodigoCanal();
	}

	/**
	* Sets the codigo canal of this solicitud producto.
	*
	* @param codigoCanal the codigo canal of this solicitud producto
	*/
	public void setCodigoCanal(java.lang.String codigoCanal) {
		_solicitudProducto.setCodigoCanal(codigoCanal);
	}

	/**
	* Returns the tipo envio of this solicitud producto.
	*
	* @return the tipo envio of this solicitud producto
	*/
	public java.lang.String getTipoEnvio() {
		return _solicitudProducto.getTipoEnvio();
	}

	/**
	* Sets the tipo envio of this solicitud producto.
	*
	* @param tipoEnvio the tipo envio of this solicitud producto
	*/
	public void setTipoEnvio(java.lang.String tipoEnvio) {
		_solicitudProducto.setTipoEnvio(tipoEnvio);
	}

	/**
	* Returns the numero documento of this solicitud producto.
	*
	* @return the numero documento of this solicitud producto
	*/
	public java.lang.String getNumeroDocumento() {
		return _solicitudProducto.getNumeroDocumento();
	}

	/**
	* Sets the numero documento of this solicitud producto.
	*
	* @param numeroDocumento the numero documento of this solicitud producto
	*/
	public void setNumeroDocumento(java.lang.String numeroDocumento) {
		_solicitudProducto.setNumeroDocumento(numeroDocumento);
	}

	/**
	* Returns the apellido paterno of this solicitud producto.
	*
	* @return the apellido paterno of this solicitud producto
	*/
	public java.lang.String getApellidoPaterno() {
		return _solicitudProducto.getApellidoPaterno();
	}

	/**
	* Sets the apellido paterno of this solicitud producto.
	*
	* @param apellidoPaterno the apellido paterno of this solicitud producto
	*/
	public void setApellidoPaterno(java.lang.String apellidoPaterno) {
		_solicitudProducto.setApellidoPaterno(apellidoPaterno);
	}

	/**
	* Returns the apellido materno of this solicitud producto.
	*
	* @return the apellido materno of this solicitud producto
	*/
	public java.lang.String getApellidoMaterno() {
		return _solicitudProducto.getApellidoMaterno();
	}

	/**
	* Sets the apellido materno of this solicitud producto.
	*
	* @param apellidoMaterno the apellido materno of this solicitud producto
	*/
	public void setApellidoMaterno(java.lang.String apellidoMaterno) {
		_solicitudProducto.setApellidoMaterno(apellidoMaterno);
	}

	/**
	* Returns the primer nombre of this solicitud producto.
	*
	* @return the primer nombre of this solicitud producto
	*/
	public java.lang.String getPrimerNombre() {
		return _solicitudProducto.getPrimerNombre();
	}

	/**
	* Sets the primer nombre of this solicitud producto.
	*
	* @param primerNombre the primer nombre of this solicitud producto
	*/
	public void setPrimerNombre(java.lang.String primerNombre) {
		_solicitudProducto.setPrimerNombre(primerNombre);
	}

	/**
	* Returns the segundo nombre of this solicitud producto.
	*
	* @return the segundo nombre of this solicitud producto
	*/
	public java.lang.String getSegundoNombre() {
		return _solicitudProducto.getSegundoNombre();
	}

	/**
	* Sets the segundo nombre of this solicitud producto.
	*
	* @param segundoNombre the segundo nombre of this solicitud producto
	*/
	public void setSegundoNombre(java.lang.String segundoNombre) {
		_solicitudProducto.setSegundoNombre(segundoNombre);
	}

	/**
	* Returns the fecha nacimiento of this solicitud producto.
	*
	* @return the fecha nacimiento of this solicitud producto
	*/
	public java.util.Date getFechaNacimiento() {
		return _solicitudProducto.getFechaNacimiento();
	}

	/**
	* Sets the fecha nacimiento of this solicitud producto.
	*
	* @param fechaNacimiento the fecha nacimiento of this solicitud producto
	*/
	public void setFechaNacimiento(java.util.Date fechaNacimiento) {
		_solicitudProducto.setFechaNacimiento(fechaNacimiento);
	}

	/**
	* Returns the sexo of this solicitud producto.
	*
	* @return the sexo of this solicitud producto
	*/
	public java.lang.String getSexo() {
		return _solicitudProducto.getSexo();
	}

	/**
	* Sets the sexo of this solicitud producto.
	*
	* @param sexo the sexo of this solicitud producto
	*/
	public void setSexo(java.lang.String sexo) {
		_solicitudProducto.setSexo(sexo);
	}

	/**
	* Returns the renta mensual of this solicitud producto.
	*
	* @return the renta mensual of this solicitud producto
	*/
	public java.lang.Double getRentaMensual() {
		return _solicitudProducto.getRentaMensual();
	}

	/**
	* Sets the renta mensual of this solicitud producto.
	*
	* @param rentaMensual the renta mensual of this solicitud producto
	*/
	public void setRentaMensual(java.lang.Double rentaMensual) {
		_solicitudProducto.setRentaMensual(rentaMensual);
	}

	/**
	* Returns the celular of this solicitud producto.
	*
	* @return the celular of this solicitud producto
	*/
	public java.lang.String getCelular() {
		return _solicitudProducto.getCelular();
	}

	/**
	* Sets the celular of this solicitud producto.
	*
	* @param celular the celular of this solicitud producto
	*/
	public void setCelular(java.lang.String celular) {
		_solicitudProducto.setCelular(celular);
	}

	/**
	* Returns the telefono casa of this solicitud producto.
	*
	* @return the telefono casa of this solicitud producto
	*/
	public java.lang.String getTelefonoCasa() {
		return _solicitudProducto.getTelefonoCasa();
	}

	/**
	* Sets the telefono casa of this solicitud producto.
	*
	* @param telefonoCasa the telefono casa of this solicitud producto
	*/
	public void setTelefonoCasa(java.lang.String telefonoCasa) {
		_solicitudProducto.setTelefonoCasa(telefonoCasa);
	}

	/**
	* Returns the telefono trabajo of this solicitud producto.
	*
	* @return the telefono trabajo of this solicitud producto
	*/
	public java.lang.String getTelefonoTrabajo() {
		return _solicitudProducto.getTelefonoTrabajo();
	}

	/**
	* Sets the telefono trabajo of this solicitud producto.
	*
	* @param telefonoTrabajo the telefono trabajo of this solicitud producto
	*/
	public void setTelefonoTrabajo(java.lang.String telefonoTrabajo) {
		_solicitudProducto.setTelefonoTrabajo(telefonoTrabajo);
	}

	/**
	* Returns the anexo of this solicitud producto.
	*
	* @return the anexo of this solicitud producto
	*/
	public java.lang.String getAnexo() {
		return _solicitudProducto.getAnexo();
	}

	/**
	* Sets the anexo of this solicitud producto.
	*
	* @param anexo the anexo of this solicitud producto
	*/
	public void setAnexo(java.lang.String anexo) {
		_solicitudProducto.setAnexo(anexo);
	}

	/**
	* Returns the id estado civil adq of this solicitud producto.
	*
	* @return the id estado civil adq of this solicitud producto
	*/
	public java.lang.Integer getIdEstadoCivilAdq() {
		return _solicitudProducto.getIdEstadoCivilAdq();
	}

	/**
	* Sets the id estado civil adq of this solicitud producto.
	*
	* @param idEstadoCivilAdq the id estado civil adq of this solicitud producto
	*/
	public void setIdEstadoCivilAdq(java.lang.Integer idEstadoCivilAdq) {
		_solicitudProducto.setIdEstadoCivilAdq(idEstadoCivilAdq);
	}

	/**
	* Returns the id estado civil of this solicitud producto.
	*
	* @return the id estado civil of this solicitud producto
	*/
	public java.lang.String getIdEstadoCivil() {
		return _solicitudProducto.getIdEstadoCivil();
	}

	/**
	* Sets the id estado civil of this solicitud producto.
	*
	* @param idEstadoCivil the id estado civil of this solicitud producto
	*/
	public void setIdEstadoCivil(java.lang.String idEstadoCivil) {
		_solicitudProducto.setIdEstadoCivil(idEstadoCivil);
	}

	/**
	* Returns the r u c of this solicitud producto.
	*
	* @return the r u c of this solicitud producto
	*/
	public java.lang.String getRUC() {
		return _solicitudProducto.getRUC();
	}

	/**
	* Sets the r u c of this solicitud producto.
	*
	* @param RUC the r u c of this solicitud producto
	*/
	public void setRUC(java.lang.String RUC) {
		_solicitudProducto.setRUC(RUC);
	}

	/**
	* Returns the razon social of this solicitud producto.
	*
	* @return the razon social of this solicitud producto
	*/
	public java.lang.String getRazonSocial() {
		return _solicitudProducto.getRazonSocial();
	}

	/**
	* Sets the razon social of this solicitud producto.
	*
	* @param razonSocial the razon social of this solicitud producto
	*/
	public void setRazonSocial(java.lang.String razonSocial) {
		_solicitudProducto.setRazonSocial(razonSocial);
	}

	/**
	* Returns the situacion laboral of this solicitud producto.
	*
	* @return the situacion laboral of this solicitud producto
	*/
	public java.lang.String getSituacionLaboral() {
		return _solicitudProducto.getSituacionLaboral();
	}

	/**
	* Sets the situacion laboral of this solicitud producto.
	*
	* @param situacionLaboral the situacion laboral of this solicitud producto
	*/
	public void setSituacionLaboral(java.lang.String situacionLaboral) {
		_solicitudProducto.setSituacionLaboral(situacionLaboral);
	}

	/**
	* Returns the id situacion laboral of this solicitud producto.
	*
	* @return the id situacion laboral of this solicitud producto
	*/
	public java.lang.Integer getIdSituacionLaboral() {
		return _solicitudProducto.getIdSituacionLaboral();
	}

	/**
	* Sets the id situacion laboral of this solicitud producto.
	*
	* @param idSituacionLaboral the id situacion laboral of this solicitud producto
	*/
	public void setIdSituacionLaboral(java.lang.Integer idSituacionLaboral) {
		_solicitudProducto.setIdSituacionLaboral(idSituacionLaboral);
	}

	/**
	* Returns the id departamento of this solicitud producto.
	*
	* @return the id departamento of this solicitud producto
	*/
	public java.lang.String getIdDepartamento() {
		return _solicitudProducto.getIdDepartamento();
	}

	/**
	* Sets the id departamento of this solicitud producto.
	*
	* @param idDepartamento the id departamento of this solicitud producto
	*/
	public void setIdDepartamento(java.lang.String idDepartamento) {
		_solicitudProducto.setIdDepartamento(idDepartamento);
	}

	/**
	* Returns the id provincia of this solicitud producto.
	*
	* @return the id provincia of this solicitud producto
	*/
	public java.lang.String getIdProvincia() {
		return _solicitudProducto.getIdProvincia();
	}

	/**
	* Sets the id provincia of this solicitud producto.
	*
	* @param idProvincia the id provincia of this solicitud producto
	*/
	public void setIdProvincia(java.lang.String idProvincia) {
		_solicitudProducto.setIdProvincia(idProvincia);
	}

	/**
	* Returns the id distrito of this solicitud producto.
	*
	* @return the id distrito of this solicitud producto
	*/
	public java.lang.String getIdDistrito() {
		return _solicitudProducto.getIdDistrito();
	}

	/**
	* Sets the id distrito of this solicitud producto.
	*
	* @param idDistrito the id distrito of this solicitud producto
	*/
	public void setIdDistrito(java.lang.String idDistrito) {
		_solicitudProducto.setIdDistrito(idDistrito);
	}

	/**
	* Returns the nom departamento of this solicitud producto.
	*
	* @return the nom departamento of this solicitud producto
	*/
	public java.lang.String getNomDepartamento() {
		return _solicitudProducto.getNomDepartamento();
	}

	/**
	* Sets the nom departamento of this solicitud producto.
	*
	* @param nomDepartamento the nom departamento of this solicitud producto
	*/
	public void setNomDepartamento(java.lang.String nomDepartamento) {
		_solicitudProducto.setNomDepartamento(nomDepartamento);
	}

	/**
	* Returns the nom provincia of this solicitud producto.
	*
	* @return the nom provincia of this solicitud producto
	*/
	public java.lang.String getNomProvincia() {
		return _solicitudProducto.getNomProvincia();
	}

	/**
	* Sets the nom provincia of this solicitud producto.
	*
	* @param nomProvincia the nom provincia of this solicitud producto
	*/
	public void setNomProvincia(java.lang.String nomProvincia) {
		_solicitudProducto.setNomProvincia(nomProvincia);
	}

	/**
	* Returns the nom distrito of this solicitud producto.
	*
	* @return the nom distrito of this solicitud producto
	*/
	public java.lang.String getNomDistrito() {
		return _solicitudProducto.getNomDistrito();
	}

	/**
	* Sets the nom distrito of this solicitud producto.
	*
	* @param nomDistrito the nom distrito of this solicitud producto
	*/
	public void setNomDistrito(java.lang.String nomDistrito) {
		_solicitudProducto.setNomDistrito(nomDistrito);
	}

	/**
	* Returns the correo electronico of this solicitud producto.
	*
	* @return the correo electronico of this solicitud producto
	*/
	public java.lang.String getCorreoElectronico() {
		return _solicitudProducto.getCorreoElectronico();
	}

	/**
	* Sets the correo electronico of this solicitud producto.
	*
	* @param correoElectronico the correo electronico of this solicitud producto
	*/
	public void setCorreoElectronico(java.lang.String correoElectronico) {
		_solicitudProducto.setCorreoElectronico(correoElectronico);
	}

	/**
	* Returns the direccion envio of this solicitud producto.
	*
	* @return the direccion envio of this solicitud producto
	*/
	public java.lang.String getDireccionEnvio() {
		return _solicitudProducto.getDireccionEnvio();
	}

	/**
	* Sets the direccion envio of this solicitud producto.
	*
	* @param direccionEnvio the direccion envio of this solicitud producto
	*/
	public void setDireccionEnvio(java.lang.String direccionEnvio) {
		_solicitudProducto.setDireccionEnvio(direccionEnvio);
	}

	/**
	* Returns the placa vehiculo of this solicitud producto.
	*
	* @return the placa vehiculo of this solicitud producto
	*/
	public java.lang.String getPlacaVehiculo() {
		return _solicitudProducto.getPlacaVehiculo();
	}

	/**
	* Sets the placa vehiculo of this solicitud producto.
	*
	* @param placaVehiculo the placa vehiculo of this solicitud producto
	*/
	public void setPlacaVehiculo(java.lang.String placaVehiculo) {
		_solicitudProducto.setPlacaVehiculo(placaVehiculo);
	}

	/**
	* Returns the id session of this solicitud producto.
	*
	* @return the id session of this solicitud producto
	*/
	public java.lang.String getIdSession() {
		return _solicitudProducto.getIdSession();
	}

	/**
	* Sets the id session of this solicitud producto.
	*
	* @param IdSession the id session of this solicitud producto
	*/
	public void setIdSession(java.lang.String IdSession) {
		_solicitudProducto.setIdSession(IdSession);
	}

	/**
	* Returns the i p cliente of this solicitud producto.
	*
	* @return the i p cliente of this solicitud producto
	*/
	public java.lang.String getIPCliente() {
		return _solicitudProducto.getIPCliente();
	}

	/**
	* Sets the i p cliente of this solicitud producto.
	*
	* @param IPCliente the i p cliente of this solicitud producto
	*/
	public void setIPCliente(java.lang.String IPCliente) {
		_solicitudProducto.setIPCliente(IPCliente);
	}

	/**
	* Returns the horario envio of this solicitud producto.
	*
	* @return the horario envio of this solicitud producto
	*/
	public java.util.Date getHorarioEnvio() {
		return _solicitudProducto.getHorarioEnvio();
	}

	/**
	* Sets the horario envio of this solicitud producto.
	*
	* @param horarioEnvio the horario envio of this solicitud producto
	*/
	public void setHorarioEnvio(java.util.Date horarioEnvio) {
		_solicitudProducto.setHorarioEnvio(horarioEnvio);
	}

	/**
	* Returns the fecha registro of this solicitud producto.
	*
	* @return the fecha registro of this solicitud producto
	*/
	public java.util.Date getFechaRegistro() {
		return _solicitudProducto.getFechaRegistro();
	}

	/**
	* Sets the fecha registro of this solicitud producto.
	*
	* @param fechaRegistro the fecha registro of this solicitud producto
	*/
	public void setFechaRegistro(java.util.Date fechaRegistro) {
		_solicitudProducto.setFechaRegistro(fechaRegistro);
	}

	/**
	* Returns the u t m source of this solicitud producto.
	*
	* @return the u t m source of this solicitud producto
	*/
	public java.lang.String getUTMSource() {
		return _solicitudProducto.getUTMSource();
	}

	/**
	* Sets the u t m source of this solicitud producto.
	*
	* @param UTMSource the u t m source of this solicitud producto
	*/
	public void setUTMSource(java.lang.String UTMSource) {
		_solicitudProducto.setUTMSource(UTMSource);
	}

	/**
	* Returns the u t m medium of this solicitud producto.
	*
	* @return the u t m medium of this solicitud producto
	*/
	public java.lang.String getUTMMedium() {
		return _solicitudProducto.getUTMMedium();
	}

	/**
	* Sets the u t m medium of this solicitud producto.
	*
	* @param UTMMedium the u t m medium of this solicitud producto
	*/
	public void setUTMMedium(java.lang.String UTMMedium) {
		_solicitudProducto.setUTMMedium(UTMMedium);
	}

	/**
	* Returns the u t m campaing of this solicitud producto.
	*
	* @return the u t m campaing of this solicitud producto
	*/
	public java.lang.String getUTMCampaing() {
		return _solicitudProducto.getUTMCampaing();
	}

	/**
	* Sets the u t m campaing of this solicitud producto.
	*
	* @param UTMCampaing the u t m campaing of this solicitud producto
	*/
	public void setUTMCampaing(java.lang.String UTMCampaing) {
		_solicitudProducto.setUTMCampaing(UTMCampaing);
	}

	/**
	* Returns the u t m content of this solicitud producto.
	*
	* @return the u t m content of this solicitud producto
	*/
	public java.lang.String getUTMContent() {
		return _solicitudProducto.getUTMContent();
	}

	/**
	* Sets the u t m content of this solicitud producto.
	*
	* @param UTMContent the u t m content of this solicitud producto
	*/
	public void setUTMContent(java.lang.String UTMContent) {
		_solicitudProducto.setUTMContent(UTMContent);
	}

	/**
	* Returns the fecha resultado pre calif of this solicitud producto.
	*
	* @return the fecha resultado pre calif of this solicitud producto
	*/
	public java.util.Date getFechaResultadoPreCalif() {
		return _solicitudProducto.getFechaResultadoPreCalif();
	}

	/**
	* Sets the fecha resultado pre calif of this solicitud producto.
	*
	* @param fechaResultadoPreCalif the fecha resultado pre calif of this solicitud producto
	*/
	public void setFechaResultadoPreCalif(java.util.Date fechaResultadoPreCalif) {
		_solicitudProducto.setFechaResultadoPreCalif(fechaResultadoPreCalif);
	}

	/**
	* Returns the fecha envio lead of this solicitud producto.
	*
	* @return the fecha envio lead of this solicitud producto
	*/
	public java.util.Date getFechaEnvioLead() {
		return _solicitudProducto.getFechaEnvioLead();
	}

	/**
	* Sets the fecha envio lead of this solicitud producto.
	*
	* @param fechaEnvioLead the fecha envio lead of this solicitud producto
	*/
	public void setFechaEnvioLead(java.util.Date fechaEnvioLead) {
		_solicitudProducto.setFechaEnvioLead(fechaEnvioLead);
	}

	/**
	* Returns the fecha envio emailing of this solicitud producto.
	*
	* @return the fecha envio emailing of this solicitud producto
	*/
	public java.util.Date getFechaEnvioEmailing() {
		return _solicitudProducto.getFechaEnvioEmailing();
	}

	/**
	* Sets the fecha envio emailing of this solicitud producto.
	*
	* @param fechaEnvioEmailing the fecha envio emailing of this solicitud producto
	*/
	public void setFechaEnvioEmailing(java.util.Date fechaEnvioEmailing) {
		_solicitudProducto.setFechaEnvioEmailing(fechaEnvioEmailing);
	}

	/**
	* Returns the estado pre calificacion of this solicitud producto.
	*
	* @return the estado pre calificacion of this solicitud producto
	*/
	public java.lang.Boolean getEstadoPreCalificacion() {
		return _solicitudProducto.getEstadoPreCalificacion();
	}

	/**
	* Sets the estado pre calificacion of this solicitud producto.
	*
	* @param estadoPreCalificacion the estado pre calificacion of this solicitud producto
	*/
	public void setEstadoPreCalificacion(
		java.lang.Boolean estadoPreCalificacion) {
		_solicitudProducto.setEstadoPreCalificacion(estadoPreCalificacion);
	}

	/**
	* Returns the estado reg lead of this solicitud producto.
	*
	* @return the estado reg lead of this solicitud producto
	*/
	public java.lang.Boolean getEstadoRegLead() {
		return _solicitudProducto.getEstadoRegLead();
	}

	/**
	* Sets the estado reg lead of this solicitud producto.
	*
	* @param estadoRegLead the estado reg lead of this solicitud producto
	*/
	public void setEstadoRegLead(java.lang.Boolean estadoRegLead) {
		_solicitudProducto.setEstadoRegLead(estadoRegLead);
	}

	/**
	* Returns the estado env correo of this solicitud producto.
	*
	* @return the estado env correo of this solicitud producto
	*/
	public java.lang.Boolean getEstadoEnvCorreo() {
		return _solicitudProducto.getEstadoEnvCorreo();
	}

	/**
	* Sets the estado env correo of this solicitud producto.
	*
	* @param estadoEnvCorreo the estado env correo of this solicitud producto
	*/
	public void setEstadoEnvCorreo(java.lang.Boolean estadoEnvCorreo) {
		_solicitudProducto.setEstadoEnvCorreo(estadoEnvCorreo);
	}

	/**
	* Returns the resp pre calificacion of this solicitud producto.
	*
	* @return the resp pre calificacion of this solicitud producto
	*/
	public java.lang.String getRespPreCalificacion() {
		return _solicitudProducto.getRespPreCalificacion();
	}

	/**
	* Sets the resp pre calificacion of this solicitud producto.
	*
	* @param respPreCalificacion the resp pre calificacion of this solicitud producto
	*/
	public void setRespPreCalificacion(java.lang.String respPreCalificacion) {
		_solicitudProducto.setRespPreCalificacion(respPreCalificacion);
	}

	/**
	* Returns the descripcion lead of this solicitud producto.
	*
	* @return the descripcion lead of this solicitud producto
	*/
	public java.lang.String getDescripcionLead() {
		return _solicitudProducto.getDescripcionLead();
	}

	/**
	* Sets the descripcion lead of this solicitud producto.
	*
	* @param descripcionLead the descripcion lead of this solicitud producto
	*/
	public void setDescripcionLead(java.lang.String descripcionLead) {
		_solicitudProducto.setDescripcionLead(descripcionLead);
	}

	/**
	* Returns the fecha actualizacion of this solicitud producto.
	*
	* @return the fecha actualizacion of this solicitud producto
	*/
	public java.util.Date getFechaActualizacion() {
		return _solicitudProducto.getFechaActualizacion();
	}

	/**
	* Sets the fecha actualizacion of this solicitud producto.
	*
	* @param fechaActualizacion the fecha actualizacion of this solicitud producto
	*/
	public void setFechaActualizacion(java.util.Date fechaActualizacion) {
		_solicitudProducto.setFechaActualizacion(fechaActualizacion);
	}

	/**
	* Returns the monto prospectado of this solicitud producto.
	*
	* @return the monto prospectado of this solicitud producto
	*/
	public java.lang.Double getMontoProspectado() {
		return _solicitudProducto.getMontoProspectado();
	}

	/**
	* Sets the monto prospectado of this solicitud producto.
	*
	* @param montoProspectado the monto prospectado of this solicitud producto
	*/
	public void setMontoProspectado(java.lang.Double montoProspectado) {
		_solicitudProducto.setMontoProspectado(montoProspectado);
	}

	/**
	* Returns the codigo campania of this solicitud producto.
	*
	* @return the codigo campania of this solicitud producto
	*/
	public java.lang.String getCodigoCampania() {
		return _solicitudProducto.getCodigoCampania();
	}

	/**
	* Sets the codigo campania of this solicitud producto.
	*
	* @param codigoCampania the codigo campania of this solicitud producto
	*/
	public void setCodigoCampania(java.lang.String codigoCampania) {
		_solicitudProducto.setCodigoCampania(codigoCampania);
	}

	/**
	* Returns the codigo moneda of this solicitud producto.
	*
	* @return the codigo moneda of this solicitud producto
	*/
	public java.lang.String getCodigoMoneda() {
		return _solicitudProducto.getCodigoMoneda();
	}

	/**
	* Sets the codigo moneda of this solicitud producto.
	*
	* @param codigoMoneda the codigo moneda of this solicitud producto
	*/
	public void setCodigoMoneda(java.lang.String codigoMoneda) {
		_solicitudProducto.setCodigoMoneda(codigoMoneda);
	}

	/**
	* Returns the nombre supervisor of this solicitud producto.
	*
	* @return the nombre supervisor of this solicitud producto
	*/
	public java.lang.String getNombreSupervisor() {
		return _solicitudProducto.getNombreSupervisor();
	}

	/**
	* Sets the nombre supervisor of this solicitud producto.
	*
	* @param nombreSupervisor the nombre supervisor of this solicitud producto
	*/
	public void setNombreSupervisor(java.lang.String nombreSupervisor) {
		_solicitudProducto.setNombreSupervisor(nombreSupervisor);
	}

	/**
	* Returns the resp reg lead of this solicitud producto.
	*
	* @return the resp reg lead of this solicitud producto
	*/
	public java.lang.String getRespRegLead() {
		return _solicitudProducto.getRespRegLead();
	}

	/**
	* Sets the resp reg lead of this solicitud producto.
	*
	* @param respRegLead the resp reg lead of this solicitud producto
	*/
	public void setRespRegLead(java.lang.String respRegLead) {
		_solicitudProducto.setRespRegLead(respRegLead);
	}

	public boolean isNew() {
		return _solicitudProducto.isNew();
	}

	public void setNew(boolean n) {
		_solicitudProducto.setNew(n);
	}

	public boolean isCachedModel() {
		return _solicitudProducto.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_solicitudProducto.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _solicitudProducto.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _solicitudProducto.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_solicitudProducto.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _solicitudProducto.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_solicitudProducto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SolicitudProductoWrapper((SolicitudProducto)_solicitudProducto.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto) {
		return _solicitudProducto.compareTo(solicitudProducto);
	}

	@Override
	public int hashCode() {
		return _solicitudProducto.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.SolicitudProducto> toCacheModel() {
		return _solicitudProducto.toCacheModel();
	}

	public com.ext.portlet.halcon.model.SolicitudProducto toEscapedModel() {
		return new SolicitudProductoWrapper(_solicitudProducto.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _solicitudProducto.toString();
	}

	public java.lang.String toXmlString() {
		return _solicitudProducto.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_solicitudProducto.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SolicitudProducto getWrappedSolicitudProducto() {
		return _solicitudProducto;
	}

	public SolicitudProducto getWrappedModel() {
		return _solicitudProducto;
	}

	public void resetOriginalValues() {
		_solicitudProducto.resetOriginalValues();
	}

	private SolicitudProducto _solicitudProducto;
}