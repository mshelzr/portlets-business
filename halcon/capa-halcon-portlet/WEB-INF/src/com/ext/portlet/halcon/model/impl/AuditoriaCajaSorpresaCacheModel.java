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

import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing AuditoriaCajaSorpresa in entity cache.
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresa
 * @generated
 */
public class AuditoriaCajaSorpresaCacheModel implements CacheModel<AuditoriaCajaSorpresa>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{idAuditoriaCajSorp=");
		sb.append(idAuditoriaCajSorp);
		sb.append(", idTransaccion=");
		sb.append(idTransaccion);
		sb.append(", tipoDocumento=");
		sb.append(tipoDocumento);
		sb.append(", numDocumento=");
		sb.append(numDocumento);
		sb.append(", producto1=");
		sb.append(producto1);
		sb.append(", producto2=");
		sb.append(producto2);
		sb.append(", producto3=");
		sb.append(producto3);
		sb.append(", producto4=");
		sb.append(producto4);
		sb.append(", codProducto1=");
		sb.append(codProducto1);
		sb.append(", codProducto2=");
		sb.append(codProducto2);
		sb.append(", codProducto3=");
		sb.append(codProducto3);
		sb.append(", codProducto4=");
		sb.append(codProducto4);
		sb.append(", IP=");
		sb.append(IP);
		sb.append(", session=");
		sb.append(session);
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

	public AuditoriaCajaSorpresa toEntityModel() {
		AuditoriaCajaSorpresaImpl auditoriaCajaSorpresaImpl = new AuditoriaCajaSorpresaImpl();

		auditoriaCajaSorpresaImpl.setIdAuditoriaCajSorp(idAuditoriaCajSorp);

		if (idTransaccion == null) {
			auditoriaCajaSorpresaImpl.setIdTransaccion(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setIdTransaccion(idTransaccion);
		}

		if (tipoDocumento == null) {
			auditoriaCajaSorpresaImpl.setTipoDocumento(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setTipoDocumento(tipoDocumento);
		}

		if (numDocumento == null) {
			auditoriaCajaSorpresaImpl.setNumDocumento(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setNumDocumento(numDocumento);
		}

		if (producto1 == null) {
			auditoriaCajaSorpresaImpl.setProducto1(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setProducto1(producto1);
		}

		if (producto2 == null) {
			auditoriaCajaSorpresaImpl.setProducto2(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setProducto2(producto2);
		}

		if (producto3 == null) {
			auditoriaCajaSorpresaImpl.setProducto3(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setProducto3(producto3);
		}

		if (producto4 == null) {
			auditoriaCajaSorpresaImpl.setProducto4(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setProducto4(producto4);
		}

		if (codProducto1 == null) {
			auditoriaCajaSorpresaImpl.setCodProducto1(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setCodProducto1(codProducto1);
		}

		if (codProducto2 == null) {
			auditoriaCajaSorpresaImpl.setCodProducto2(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setCodProducto2(codProducto2);
		}

		if (codProducto3 == null) {
			auditoriaCajaSorpresaImpl.setCodProducto3(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setCodProducto3(codProducto3);
		}

		if (codProducto4 == null) {
			auditoriaCajaSorpresaImpl.setCodProducto4(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setCodProducto4(codProducto4);
		}

		if (IP == null) {
			auditoriaCajaSorpresaImpl.setIP(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setIP(IP);
		}

		if (session == null) {
			auditoriaCajaSorpresaImpl.setSession(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setSession(session);
		}

		if (fechaHora == Long.MIN_VALUE) {
			auditoriaCajaSorpresaImpl.setFechaHora(null);
		}
		else {
			auditoriaCajaSorpresaImpl.setFechaHora(new Date(fechaHora));
		}

		if (UTMSource == null) {
			auditoriaCajaSorpresaImpl.setUTMSource(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setUTMSource(UTMSource);
		}

		if (UTMMedium == null) {
			auditoriaCajaSorpresaImpl.setUTMMedium(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setUTMMedium(UTMMedium);
		}

		if (UTMCampaing == null) {
			auditoriaCajaSorpresaImpl.setUTMCampaing(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setUTMCampaing(UTMCampaing);
		}

		if (UTMContent == null) {
			auditoriaCajaSorpresaImpl.setUTMContent(StringPool.BLANK);
		}
		else {
			auditoriaCajaSorpresaImpl.setUTMContent(UTMContent);
		}

		auditoriaCajaSorpresaImpl.resetOriginalValues();

		return auditoriaCajaSorpresaImpl;
	}

	public long idAuditoriaCajSorp;
	public String idTransaccion;
	public String tipoDocumento;
	public String numDocumento;
	public String producto1;
	public String producto2;
	public String producto3;
	public String producto4;
	public String codProducto1;
	public String codProducto2;
	public String codProducto3;
	public String codProducto4;
	public String IP;
	public String session;
	public long fechaHora;
	public String UTMSource;
	public String UTMMedium;
	public String UTMCampaing;
	public String UTMContent;
}