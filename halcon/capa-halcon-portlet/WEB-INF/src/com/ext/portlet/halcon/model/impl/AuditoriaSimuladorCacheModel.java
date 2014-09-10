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

import com.ext.portlet.halcon.model.AuditoriaSimulador;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AuditoriaSimulador in entity cache.
 *
 * @author Infonet-Consulting
 * @see AuditoriaSimulador
 * @generated
 */
public class AuditoriaSimuladorCacheModel implements CacheModel<AuditoriaSimulador>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{idAuditoriaSim=");
		sb.append(idAuditoriaSim);
		sb.append(", tipoSimulador=");
		sb.append(tipoSimulador);
		sb.append(", idTransaccion=");
		sb.append(idTransaccion);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", numDocumento=");
		sb.append(numDocumento);
		sb.append(", moneda=");
		sb.append(moneda);
		sb.append(", tipoProducto=");
		sb.append(tipoProducto);
		sb.append(", invirtioFondMut=");
		sb.append(invirtioFondMut);
		sb.append(", nivelConocimFondMut=");
		sb.append(nivelConocimFondMut);
		sb.append(", reaccionVarMerc=");
		sb.append(reaccionVarMerc);
		sb.append(", valorBien=");
		sb.append(valorBien);
		sb.append(", montoPrestamo=");
		sb.append(montoPrestamo);
		sb.append(", cuotaInicial=");
		sb.append(cuotaInicial);
		sb.append(", periodoInvers=");
		sb.append(periodoInvers);
		sb.append(", tasa=");
		sb.append(tasa);
		sb.append(", segDesgrav=");
		sb.append(segDesgrav);
		sb.append(", tipoCuota=");
		sb.append(tipoCuota);
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
		sb.append("}");

		return sb.toString();
	}

	public AuditoriaSimulador toEntityModel() {
		AuditoriaSimuladorImpl auditoriaSimuladorImpl = new AuditoriaSimuladorImpl();

		auditoriaSimuladorImpl.setIdAuditoriaSim(idAuditoriaSim);

		if (tipoSimulador == null) {
			auditoriaSimuladorImpl.setTipoSimulador(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setTipoSimulador(tipoSimulador);
		}

		if (idTransaccion == null) {
			auditoriaSimuladorImpl.setIdTransaccion(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setIdTransaccion(idTransaccion);
		}

		if (tipoDocumento == null) {
			auditoriaSimuladorImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setTipoDocumento(tipoDocumento);
		}

		if (numDocumento == null) {
			auditoriaSimuladorImpl.setNumDocumento(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setNumDocumento(numDocumento);
		}

		if (moneda == null) {
			auditoriaSimuladorImpl.setMoneda(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setMoneda(moneda);
		}

		if (tipoProducto == null) {
			auditoriaSimuladorImpl.setTipoProducto(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setTipoProducto(tipoProducto);
		}

		if (invirtioFondMut == null) {
			auditoriaSimuladorImpl.setInvirtioFondMut(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setInvirtioFondMut(invirtioFondMut);
		}

		if (nivelConocimFondMut == null) {
			auditoriaSimuladorImpl.setNivelConocimFondMut(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setNivelConocimFondMut(nivelConocimFondMut);
		}

		if (reaccionVarMerc == null) {
			auditoriaSimuladorImpl.setReaccionVarMerc(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setReaccionVarMerc(reaccionVarMerc);
		}

		auditoriaSimuladorImpl.setValorBien(valorBien);
		auditoriaSimuladorImpl.setMontoPrestamo(montoPrestamo);
		auditoriaSimuladorImpl.setCuotaInicial(cuotaInicial);

		if (periodoInvers == null) {
			auditoriaSimuladorImpl.setPeriodoInvers(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setPeriodoInvers(periodoInvers);
		}

		auditoriaSimuladorImpl.setTasa(tasa);

		if (segDesgrav == null) {
			auditoriaSimuladorImpl.setSegDesgrav(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setSegDesgrav(segDesgrav);
		}

		if (tipoCuota == null) {
			auditoriaSimuladorImpl.setTipoCuota(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setTipoCuota(tipoCuota);
		}

		if (IP == null) {
			auditoriaSimuladorImpl.setIP(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setIP(IP);
		}

		if (fechaHora == Long.MIN_VALUE) {
			auditoriaSimuladorImpl.setFechaHora(null);
		}
		else {
			auditoriaSimuladorImpl.setFechaHora(new Date(fechaHora));
		}

		if (UTMSource == null) {
			auditoriaSimuladorImpl.setUTMSource(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setUTMSource(UTMSource);
		}

		if (UTMMedium == null) {
			auditoriaSimuladorImpl.setUTMMedium(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setUTMMedium(UTMMedium);
		}

		if (UTMCampaing == null) {
			auditoriaSimuladorImpl.setUTMCampaing(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setUTMCampaing(UTMCampaing);
		}

		if (UTMContent == null) {
			auditoriaSimuladorImpl.setUTMContent(StringPool.BLANK);
		}
		else {
			auditoriaSimuladorImpl.setUTMContent(UTMContent);
		}

		auditoriaSimuladorImpl.resetOriginalValues();

		return auditoriaSimuladorImpl;
	}

	public long idAuditoriaSim;
	public String tipoSimulador;
	public String idTransaccion;
	public String tipoDocumento;
	public String numDocumento;
	public String moneda;
	public String tipoProducto;
	public String invirtioFondMut;
	public String nivelConocimFondMut;
	public String reaccionVarMerc;
	public Double valorBien;
	public Double montoPrestamo;
	public Double cuotaInicial;
	public String periodoInvers;
	public Double tasa;
	public String segDesgrav;
	public String tipoCuota;
	public String IP;
	public long fechaHora;
	public String UTMSource;
	public String UTMMedium;
	public String UTMCampaing;
	public String UTMContent;
}