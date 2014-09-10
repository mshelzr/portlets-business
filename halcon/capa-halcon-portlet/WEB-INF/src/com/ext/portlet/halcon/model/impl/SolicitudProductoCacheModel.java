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

package com.ext.portlet.halcon.model.impl;

import com.ext.portlet.halcon.model.SolicitudProducto;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing SolicitudProducto in entity cache.
 *
 * @author Infonet-Consulting
 * @see SolicitudProducto
 * @generated
 */
public class SolicitudProductoCacheModel implements CacheModel<SolicitudProducto>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(111);

		sb.append("{idSolicitudProducto=");
		sb.append(idSolicitudProducto);
		sb.append(", idTipoDocumentoAdq=");
		sb.append(idTipoDocumentoAdq);
		sb.append(", idTipoDocumento=");
		sb.append(idTipoDocumento);
		sb.append(", tipoCredito=");
		sb.append(tipoCredito);
		sb.append(", codigoCanal=");
		sb.append(codigoCanal);
		sb.append(", tipoEnvio=");
		sb.append(tipoEnvio);
		sb.append(", numeroDocumento=");
		sb.append(numeroDocumento);
		sb.append(", apellidoPaterno=");
		sb.append(apellidoPaterno);
		sb.append(", apellidoMaterno=");
		sb.append(apellidoMaterno);
		sb.append(", primerNombre=");
		sb.append(primerNombre);
		sb.append(", segundoNombre=");
		sb.append(segundoNombre);
		sb.append(", fechaNacimiento=");
		sb.append(fechaNacimiento);
		sb.append(", sexo=");
		sb.append(sexo);
		sb.append(", rentaMensual=");
		sb.append(rentaMensual);
		sb.append(", celular=");
		sb.append(celular);
		sb.append(", telefonoCasa=");
		sb.append(telefonoCasa);
		sb.append(", telefonoTrabajo=");
		sb.append(telefonoTrabajo);
		sb.append(", anexo=");
		sb.append(anexo);
		sb.append(", idEstadoCivilAdq=");
		sb.append(idEstadoCivilAdq);
		sb.append(", idEstadoCivil=");
		sb.append(idEstadoCivil);
		sb.append(", RUC=");
		sb.append(RUC);
		sb.append(", razonSocial=");
		sb.append(razonSocial);
		sb.append(", situacionLaboral=");
		sb.append(situacionLaboral);
		sb.append(", idSituacionLaboral=");
		sb.append(idSituacionLaboral);
		sb.append(", idDepartamento=");
		sb.append(idDepartamento);
		sb.append(", idProvincia=");
		sb.append(idProvincia);
		sb.append(", idDistrito=");
		sb.append(idDistrito);
		sb.append(", nomDepartamento=");
		sb.append(nomDepartamento);
		sb.append(", nomProvincia=");
		sb.append(nomProvincia);
		sb.append(", nomDistrito=");
		sb.append(nomDistrito);
		sb.append(", correoElectronico=");
		sb.append(correoElectronico);
		sb.append(", direccionEnvio=");
		sb.append(direccionEnvio);
		sb.append(", placaVehiculo=");
		sb.append(placaVehiculo);
		sb.append(", IdSession=");
		sb.append(IdSession);
		sb.append(", IPCliente=");
		sb.append(IPCliente);
		sb.append(", horarioEnvio=");
		sb.append(horarioEnvio);
		sb.append(", fechaRegistro=");
		sb.append(fechaRegistro);
		sb.append(", UTMSource=");
		sb.append(UTMSource);
		sb.append(", UTMMedium=");
		sb.append(UTMMedium);
		sb.append(", UTMCampaing=");
		sb.append(UTMCampaing);
		sb.append(", UTMContent=");
		sb.append(UTMContent);
		sb.append(", fechaResultadoPreCalif=");
		sb.append(fechaResultadoPreCalif);
		sb.append(", fechaEnvioLead=");
		sb.append(fechaEnvioLead);
		sb.append(", fechaEnvioEmailing=");
		sb.append(fechaEnvioEmailing);
		sb.append(", estadoPreCalificacion=");
		sb.append(estadoPreCalificacion);
		sb.append(", estadoRegLead=");
		sb.append(estadoRegLead);
		sb.append(", estadoEnvCorreo=");
		sb.append(estadoEnvCorreo);
		sb.append(", respPreCalificacion=");
		sb.append(respPreCalificacion);
		sb.append(", descripcionLead=");
		sb.append(descripcionLead);
		sb.append(", fechaActualizacion=");
		sb.append(fechaActualizacion);
		sb.append(", montoProspectado=");
		sb.append(montoProspectado);
		sb.append(", codigoCampania=");
		sb.append(codigoCampania);
		sb.append(", codigoMoneda=");
		sb.append(codigoMoneda);
		sb.append(", nombreSupervisor=");
		sb.append(nombreSupervisor);
		sb.append(", respRegLead=");
		sb.append(respRegLead);
		sb.append("}");

		return sb.toString();
	}

	public SolicitudProducto toEntityModel() {
		SolicitudProductoImpl solicitudProductoImpl = new SolicitudProductoImpl();

		solicitudProductoImpl.setIdSolicitudProducto(idSolicitudProducto);
		solicitudProductoImpl.setIdTipoDocumentoAdq(idTipoDocumentoAdq);

		if (idTipoDocumento == null) {
			solicitudProductoImpl.setIdTipoDocumento(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIdTipoDocumento(idTipoDocumento);
		}

		solicitudProductoImpl.setTipoCredito(tipoCredito);

		if (codigoCanal == null) {
			solicitudProductoImpl.setCodigoCanal(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setCodigoCanal(codigoCanal);
		}

		if (tipoEnvio == null) {
			solicitudProductoImpl.setTipoEnvio(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setTipoEnvio(tipoEnvio);
		}

		if (numeroDocumento == null) {
			solicitudProductoImpl.setNumeroDocumento(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setNumeroDocumento(numeroDocumento);
		}

		if (apellidoPaterno == null) {
			solicitudProductoImpl.setApellidoPaterno(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setApellidoPaterno(apellidoPaterno);
		}

		if (apellidoMaterno == null) {
			solicitudProductoImpl.setApellidoMaterno(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setApellidoMaterno(apellidoMaterno);
		}

		if (primerNombre == null) {
			solicitudProductoImpl.setPrimerNombre(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setPrimerNombre(primerNombre);
		}

		if (segundoNombre == null) {
			solicitudProductoImpl.setSegundoNombre(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setSegundoNombre(segundoNombre);
		}

		if (fechaNacimiento == Long.MIN_VALUE) {
			solicitudProductoImpl.setFechaNacimiento(null);
		}
		else {
			solicitudProductoImpl.setFechaNacimiento(new Date(fechaNacimiento));
		}

		if (sexo == null) {
			solicitudProductoImpl.setSexo(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setSexo(sexo);
		}

		solicitudProductoImpl.setRentaMensual(rentaMensual);

		if (celular == null) {
			solicitudProductoImpl.setCelular(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setCelular(celular);
		}

		if (telefonoCasa == null) {
			solicitudProductoImpl.setTelefonoCasa(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setTelefonoCasa(telefonoCasa);
		}

		if (telefonoTrabajo == null) {
			solicitudProductoImpl.setTelefonoTrabajo(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setTelefonoTrabajo(telefonoTrabajo);
		}

		if (anexo == null) {
			solicitudProductoImpl.setAnexo(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setAnexo(anexo);
		}

		solicitudProductoImpl.setIdEstadoCivilAdq(idEstadoCivilAdq);

		if (idEstadoCivil == null) {
			solicitudProductoImpl.setIdEstadoCivil(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIdEstadoCivil(idEstadoCivil);
		}

		if (RUC == null) {
			solicitudProductoImpl.setRUC(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setRUC(RUC);
		}

		if (razonSocial == null) {
			solicitudProductoImpl.setRazonSocial(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setRazonSocial(razonSocial);
		}

		if (situacionLaboral == null) {
			solicitudProductoImpl.setSituacionLaboral(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setSituacionLaboral(situacionLaboral);
		}

		solicitudProductoImpl.setIdSituacionLaboral(idSituacionLaboral);

		if (idDepartamento == null) {
			solicitudProductoImpl.setIdDepartamento(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIdDepartamento(idDepartamento);
		}

		if (idProvincia == null) {
			solicitudProductoImpl.setIdProvincia(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIdProvincia(idProvincia);
		}

		if (idDistrito == null) {
			solicitudProductoImpl.setIdDistrito(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIdDistrito(idDistrito);
		}

		if (nomDepartamento == null) {
			solicitudProductoImpl.setNomDepartamento(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setNomDepartamento(nomDepartamento);
		}

		if (nomProvincia == null) {
			solicitudProductoImpl.setNomProvincia(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setNomProvincia(nomProvincia);
		}

		if (nomDistrito == null) {
			solicitudProductoImpl.setNomDistrito(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setNomDistrito(nomDistrito);
		}

		if (correoElectronico == null) {
			solicitudProductoImpl.setCorreoElectronico(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setCorreoElectronico(correoElectronico);
		}

		if (direccionEnvio == null) {
			solicitudProductoImpl.setDireccionEnvio(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setDireccionEnvio(direccionEnvio);
		}

		if (placaVehiculo == null) {
			solicitudProductoImpl.setPlacaVehiculo(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setPlacaVehiculo(placaVehiculo);
		}

		if (IdSession == null) {
			solicitudProductoImpl.setIdSession(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIdSession(IdSession);
		}

		if (IPCliente == null) {
			solicitudProductoImpl.setIPCliente(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setIPCliente(IPCliente);
		}

		if (horarioEnvio == Long.MIN_VALUE) {
			solicitudProductoImpl.setHorarioEnvio(null);
		}
		else {
			solicitudProductoImpl.setHorarioEnvio(new Date(horarioEnvio));
		}

		if (fechaRegistro == Long.MIN_VALUE) {
			solicitudProductoImpl.setFechaRegistro(null);
		}
		else {
			solicitudProductoImpl.setFechaRegistro(new Date(fechaRegistro));
		}

		if (UTMSource == null) {
			solicitudProductoImpl.setUTMSource(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setUTMSource(UTMSource);
		}

		if (UTMMedium == null) {
			solicitudProductoImpl.setUTMMedium(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setUTMMedium(UTMMedium);
		}

		if (UTMCampaing == null) {
			solicitudProductoImpl.setUTMCampaing(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setUTMCampaing(UTMCampaing);
		}

		if (UTMContent == null) {
			solicitudProductoImpl.setUTMContent(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setUTMContent(UTMContent);
		}

		if (fechaResultadoPreCalif == Long.MIN_VALUE) {
			solicitudProductoImpl.setFechaResultadoPreCalif(null);
		}
		else {
			solicitudProductoImpl.setFechaResultadoPreCalif(new Date(
					fechaResultadoPreCalif));
		}

		if (fechaEnvioLead == Long.MIN_VALUE) {
			solicitudProductoImpl.setFechaEnvioLead(null);
		}
		else {
			solicitudProductoImpl.setFechaEnvioLead(new Date(fechaEnvioLead));
		}

		if (fechaEnvioEmailing == Long.MIN_VALUE) {
			solicitudProductoImpl.setFechaEnvioEmailing(null);
		}
		else {
			solicitudProductoImpl.setFechaEnvioEmailing(new Date(
					fechaEnvioEmailing));
		}

		solicitudProductoImpl.setEstadoPreCalificacion(estadoPreCalificacion);
		solicitudProductoImpl.setEstadoRegLead(estadoRegLead);
		solicitudProductoImpl.setEstadoEnvCorreo(estadoEnvCorreo);

		if (respPreCalificacion == null) {
			solicitudProductoImpl.setRespPreCalificacion(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setRespPreCalificacion(respPreCalificacion);
		}

		if (descripcionLead == null) {
			solicitudProductoImpl.setDescripcionLead(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setDescripcionLead(descripcionLead);
		}

		if (fechaActualizacion == Long.MIN_VALUE) {
			solicitudProductoImpl.setFechaActualizacion(null);
		}
		else {
			solicitudProductoImpl.setFechaActualizacion(new Date(
					fechaActualizacion));
		}

		solicitudProductoImpl.setMontoProspectado(montoProspectado);

		if (codigoCampania == null) {
			solicitudProductoImpl.setCodigoCampania(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setCodigoCampania(codigoCampania);
		}

		if (codigoMoneda == null) {
			solicitudProductoImpl.setCodigoMoneda(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setCodigoMoneda(codigoMoneda);
		}

		if (nombreSupervisor == null) {
			solicitudProductoImpl.setNombreSupervisor(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setNombreSupervisor(nombreSupervisor);
		}

		if (respRegLead == null) {
			solicitudProductoImpl.setRespRegLead(StringPool.BLANK);
		}
		else {
			solicitudProductoImpl.setRespRegLead(respRegLead);
		}

		solicitudProductoImpl.resetOriginalValues();

		return solicitudProductoImpl;
	}

	public long idSolicitudProducto;
	public Integer idTipoDocumentoAdq;
	public String idTipoDocumento;
	public Integer tipoCredito;
	public String codigoCanal;
	public String tipoEnvio;
	public String numeroDocumento;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String primerNombre;
	public String segundoNombre;
	public long fechaNacimiento;
	public String sexo;
	public Double rentaMensual;
	public String celular;
	public String telefonoCasa;
	public String telefonoTrabajo;
	public String anexo;
	public Integer idEstadoCivilAdq;
	public String idEstadoCivil;
	public String RUC;
	public String razonSocial;
	public String situacionLaboral;
	public Integer idSituacionLaboral;
	public String idDepartamento;
	public String idProvincia;
	public String idDistrito;
	public String nomDepartamento;
	public String nomProvincia;
	public String nomDistrito;
	public String correoElectronico;
	public String direccionEnvio;
	public String placaVehiculo;
	public String IdSession;
	public String IPCliente;
	public long horarioEnvio;
	public long fechaRegistro;
	public String UTMSource;
	public String UTMMedium;
	public String UTMCampaing;
	public String UTMContent;
	public long fechaResultadoPreCalif;
	public long fechaEnvioLead;
	public long fechaEnvioEmailing;
	public Boolean estadoPreCalificacion;
	public Boolean estadoRegLead;
	public Boolean estadoEnvCorreo;
	public String respPreCalificacion;
	public String descripcionLead;
	public long fechaActualizacion;
	public Double montoProspectado;
	public String codigoCampania;
	public String codigoMoneda;
	public String nombreSupervisor;
	public String respRegLead;
}