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

import com.ext.portlet.halcon.model.AuditoriaPerfilador;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AuditoriaPerfilador in entity cache.
 *
 * @author Infonet-Consulting
 * @see AuditoriaPerfilador
 * @generated
 */
public class AuditoriaPerfiladorCacheModel implements CacheModel<AuditoriaPerfilador>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{idAuditoriaPer=");
		sb.append(idAuditoriaPer);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", numeroDocumento=");
		sb.append(numeroDocumento);
		sb.append(", perfilador=");
		sb.append(perfilador);
		sb.append(", session=");
		sb.append(session);
		sb.append(", transaccion=");
		sb.append(transaccion);
		sb.append(", monto=");
		sb.append(monto);
		sb.append(", tipoCredito=");
		sb.append(tipoCredito);
		sb.append(", IP=");
		sb.append(IP);
		sb.append(", fechaHora=");
		sb.append(fechaHora);
		sb.append(", UTMSource=");
		sb.append(UTMSource);
		sb.append(", UTMMedium=");
		sb.append(UTMMedium);
		sb.append(", UTMCampaing=");
		sb.append(UTMCampaing);
		sb.append(", UTMContent=");
		sb.append(UTMContent);
		sb.append(", pregunta01=");
		sb.append(pregunta01);
		sb.append(", pregunta02=");
		sb.append(pregunta02);
		sb.append(", pregunta03=");
		sb.append(pregunta03);
		sb.append(", pregunta04=");
		sb.append(pregunta04);
		sb.append(", respuesta01=");
		sb.append(respuesta01);
		sb.append(", respuesta02=");
		sb.append(respuesta02);
		sb.append(", respuesta03=");
		sb.append(respuesta03);
		sb.append(", respuesta04=");
		sb.append(respuesta04);
		sb.append("}");

		return sb.toString();
	}

	public AuditoriaPerfilador toEntityModel() {
		AuditoriaPerfiladorImpl auditoriaPerfiladorImpl = new AuditoriaPerfiladorImpl();

		auditoriaPerfiladorImpl.setIdAuditoriaPer(idAuditoriaPer);

		if (tipoDocumento == null) {
			auditoriaPerfiladorImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setTipoDocumento(tipoDocumento);
		}

		if (numeroDocumento == null) {
			auditoriaPerfiladorImpl.setNumeroDocumento(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setNumeroDocumento(numeroDocumento);
		}

		if (perfilador == null) {
			auditoriaPerfiladorImpl.setPerfilador(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setPerfilador(perfilador);
		}

		if (session == null) {
			auditoriaPerfiladorImpl.setSession(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setSession(session);
		}

		if (transaccion == null) {
			auditoriaPerfiladorImpl.setTransaccion(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setTransaccion(transaccion);
		}

		auditoriaPerfiladorImpl.setMonto(monto);

		if (tipoCredito == null) {
			auditoriaPerfiladorImpl.setTipoCredito(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setTipoCredito(tipoCredito);
		}

		if (IP == null) {
			auditoriaPerfiladorImpl.setIP(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setIP(IP);
		}

		if (fechaHora == Long.MIN_VALUE) {
			auditoriaPerfiladorImpl.setFechaHora(null);
		}
		else {
			auditoriaPerfiladorImpl.setFechaHora(new Date(fechaHora));
		}

		if (UTMSource == null) {
			auditoriaPerfiladorImpl.setUTMSource(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setUTMSource(UTMSource);
		}

		if (UTMMedium == null) {
			auditoriaPerfiladorImpl.setUTMMedium(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setUTMMedium(UTMMedium);
		}

		if (UTMCampaing == null) {
			auditoriaPerfiladorImpl.setUTMCampaing(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setUTMCampaing(UTMCampaing);
		}

		if (UTMContent == null) {
			auditoriaPerfiladorImpl.setUTMContent(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setUTMContent(UTMContent);
		}

		if (pregunta01 == null) {
			auditoriaPerfiladorImpl.setPregunta01(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setPregunta01(pregunta01);
		}

		if (pregunta02 == null) {
			auditoriaPerfiladorImpl.setPregunta02(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setPregunta02(pregunta02);
		}

		if (pregunta03 == null) {
			auditoriaPerfiladorImpl.setPregunta03(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setPregunta03(pregunta03);
		}

		if (pregunta04 == null) {
			auditoriaPerfiladorImpl.setPregunta04(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setPregunta04(pregunta04);
		}

		if (respuesta01 == null) {
			auditoriaPerfiladorImpl.setRespuesta01(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setRespuesta01(respuesta01);
		}

		if (respuesta02 == null) {
			auditoriaPerfiladorImpl.setRespuesta02(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setRespuesta02(respuesta02);
		}

		if (respuesta03 == null) {
			auditoriaPerfiladorImpl.setRespuesta03(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setRespuesta03(respuesta03);
		}

		if (respuesta04 == null) {
			auditoriaPerfiladorImpl.setRespuesta04(StringPool.BLANK);
		}
		else {
			auditoriaPerfiladorImpl.setRespuesta04(respuesta04);
		}

		auditoriaPerfiladorImpl.resetOriginalValues();

		return auditoriaPerfiladorImpl;
	}

	public long idAuditoriaPer;
	public String tipoDocumento;
	public String numeroDocumento;
	public String perfilador;
	public String session;
	public String transaccion;
	public Double monto;
	public String tipoCredito;
	public String IP;
	public long fechaHora;
	public String UTMSource;
	public String UTMMedium;
	public String UTMCampaing;
	public String UTMContent;
	public String pregunta01;
	public String pregunta02;
	public String pregunta03;
	public String pregunta04;
	public String respuesta01;
	public String respuesta02;
	public String respuesta03;
	public String respuesta04;
}