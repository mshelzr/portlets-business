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

import com.ext.portlet.halcon.model.SolicitudContacto;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing SolicitudContacto in entity cache.
 *
 * @author Infonet-Consulting
 * @see SolicitudContacto
 * @generated
 */
public class SolicitudContactoCacheModel implements CacheModel<SolicitudContacto>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{idSolicitudContacto=");
		sb.append(idSolicitudContacto);
		sb.append(", esCliente=");
		sb.append(esCliente);
		sb.append(", nombres=");
		sb.append(nombres);
		sb.append(", apellidos=");
		sb.append(apellidos);
		sb.append(", email=");
		sb.append(email);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", ndocumento=");
		sb.append(ndocumento);
		sb.append(", direccion=");
		sb.append(direccion);
		sb.append(", departamento=");
		sb.append(departamento);
		sb.append(", provincia=");
		sb.append(provincia);
		sb.append(", distrito=");
		sb.append(distrito);
		sb.append(", telefono=");
		sb.append(telefono);
		sb.append(", fecha=");
		sb.append(fecha);
		sb.append(", mensaje=");
		sb.append(mensaje);
		sb.append(", moneda=");
		sb.append(moneda);
		sb.append(", importe=");
		sb.append(importe);
		sb.append(", tipoMensaje=");
		sb.append(tipoMensaje);
		sb.append(", tipoTema=");
		sb.append(tipoTema);
		sb.append("}");

		return sb.toString();
	}

	public SolicitudContacto toEntityModel() {
		SolicitudContactoImpl solicitudContactoImpl = new SolicitudContactoImpl();

		solicitudContactoImpl.setIdSolicitudContacto(idSolicitudContacto);
		solicitudContactoImpl.setEsCliente(esCliente);

		if (nombres == null) {
			solicitudContactoImpl.setNombres(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setNombres(nombres);
		}

		if (apellidos == null) {
			solicitudContactoImpl.setApellidos(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setApellidos(apellidos);
		}

		if (email == null) {
			solicitudContactoImpl.setEmail(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setEmail(email);
		}

		if (tipoDocumento == null) {
			solicitudContactoImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setTipoDocumento(tipoDocumento);
		}

		if (ndocumento == null) {
			solicitudContactoImpl.setNdocumento(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setNdocumento(ndocumento);
		}

		if (direccion == null) {
			solicitudContactoImpl.setDireccion(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setDireccion(direccion);
		}

		if (departamento == null) {
			solicitudContactoImpl.setDepartamento(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setDepartamento(departamento);
		}

		if (provincia == null) {
			solicitudContactoImpl.setProvincia(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setProvincia(provincia);
		}

		if (distrito == null) {
			solicitudContactoImpl.setDistrito(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setDistrito(distrito);
		}

		if (telefono == null) {
			solicitudContactoImpl.setTelefono(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setTelefono(telefono);
		}

		if (fecha == Long.MIN_VALUE) {
			solicitudContactoImpl.setFecha(null);
		}
		else {
			solicitudContactoImpl.setFecha(new Date(fecha));
		}

		if (mensaje == null) {
			solicitudContactoImpl.setMensaje(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setMensaje(mensaje);
		}

		if (moneda == null) {
			solicitudContactoImpl.setMoneda(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setMoneda(moneda);
		}

		if (importe == null) {
			solicitudContactoImpl.setImporte(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setImporte(importe);
		}

		if (tipoMensaje == null) {
			solicitudContactoImpl.setTipoMensaje(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setTipoMensaje(tipoMensaje);
		}

		if (tipoTema == null) {
			solicitudContactoImpl.setTipoTema(StringPool.BLANK);
		}
		else {
			solicitudContactoImpl.setTipoTema(tipoTema);
		}

		solicitudContactoImpl.resetOriginalValues();

		return solicitudContactoImpl;
	}

	public long idSolicitudContacto;
	public Integer esCliente;
	public String nombres;
	public String apellidos;
	public String email;
	public String tipoDocumento;
	public String ndocumento;
	public String direccion;
	public String departamento;
	public String provincia;
	public String distrito;
	public String telefono;
	public long fecha;
	public String mensaje;
	public String moneda;
	public String importe;
	public String tipoMensaje;
	public String tipoTema;
}