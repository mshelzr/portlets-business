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

import com.ext.portlet.halcon.model.LogIncidencias;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing LogIncidencias in entity cache.
 *
 * @author Infonet-Consulting
 * @see LogIncidencias
 * @generated
 */
public class LogIncidenciasCacheModel implements CacheModel<LogIncidencias>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{idError=");
		sb.append(idError);
		sb.append(", mensajeError=");
		sb.append(mensajeError);
		sb.append(", parametro=");
		sb.append(parametro);
		sb.append(", idSessionVisitante=");
		sb.append(idSessionVisitante);
		sb.append(", tipoNumDoc=");
		sb.append(tipoNumDoc);
		sb.append(", IP=");
		sb.append(IP);
		sb.append(", fechaHoraError=");
		sb.append(fechaHoraError);
		sb.append(", trazaError=");
		sb.append(trazaError);
		sb.append(", paginaHija=");
		sb.append(paginaHija);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", recursoId=");
		sb.append(recursoId);
		sb.append(", recursoName=");
		sb.append(recursoName);
		sb.append(", recursoAction=");
		sb.append(recursoAction);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", clienteHost=");
		sb.append(clienteHost);
		sb.append(", serverName=");
		sb.append(serverName);
		sb.append(", serverId=");
		sb.append(serverId);
		sb.append(", additionalInformation=");
		sb.append(additionalInformation);
		sb.append("}");

		return sb.toString();
	}

	public LogIncidencias toEntityModel() {
		LogIncidenciasImpl logIncidenciasImpl = new LogIncidenciasImpl();

		logIncidenciasImpl.setIdError(idError);

		if (mensajeError == null) {
			logIncidenciasImpl.setMensajeError(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setMensajeError(mensajeError);
		}

		if (parametro == null) {
			logIncidenciasImpl.setParametro(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setParametro(parametro);
		}

		if (idSessionVisitante == null) {
			logIncidenciasImpl.setIdSessionVisitante(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setIdSessionVisitante(idSessionVisitante);
		}

		if (tipoNumDoc == null) {
			logIncidenciasImpl.setTipoNumDoc(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setTipoNumDoc(tipoNumDoc);
		}

		if (IP == null) {
			logIncidenciasImpl.setIP(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setIP(IP);
		}

		if (fechaHoraError == Long.MIN_VALUE) {
			logIncidenciasImpl.setFechaHoraError(null);
		}
		else {
			logIncidenciasImpl.setFechaHoraError(new Date(fechaHoraError));
		}

		if (trazaError == null) {
			logIncidenciasImpl.setTrazaError(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setTrazaError(trazaError);
		}

		if (paginaHija == null) {
			logIncidenciasImpl.setPaginaHija(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setPaginaHija(paginaHija);
		}

		if (userId == null) {
			logIncidenciasImpl.setUserId(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setUserId(userId);
		}

		if (userName == null) {
			logIncidenciasImpl.setUserName(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setUserName(userName);
		}

		if (recursoId == null) {
			logIncidenciasImpl.setRecursoId(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setRecursoId(recursoId);
		}

		if (recursoName == null) {
			logIncidenciasImpl.setRecursoName(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setRecursoName(recursoName);
		}

		if (recursoAction == null) {
			logIncidenciasImpl.setRecursoAction(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setRecursoAction(recursoAction);
		}

		if (createDate == Long.MIN_VALUE) {
			logIncidenciasImpl.setCreateDate(null);
		}
		else {
			logIncidenciasImpl.setCreateDate(new Date(createDate));
		}

		if (clienteHost == null) {
			logIncidenciasImpl.setClienteHost(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setClienteHost(clienteHost);
		}

		if (serverName == null) {
			logIncidenciasImpl.setServerName(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setServerName(serverName);
		}

		if (serverId == null) {
			logIncidenciasImpl.setServerId(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setServerId(serverId);
		}

		if (additionalInformation == null) {
			logIncidenciasImpl.setAdditionalInformation(StringPool.BLANK);
		}
		else {
			logIncidenciasImpl.setAdditionalInformation(additionalInformation);
		}

		logIncidenciasImpl.resetOriginalValues();

		return logIncidenciasImpl;
	}

	public long idError;
	public String mensajeError;
	public String parametro;
	public String idSessionVisitante;
	public String tipoNumDoc;
	public String IP;
	public long fechaHoraError;
	public String trazaError;
	public String paginaHija;
	public String userId;
	public String userName;
	public String recursoId;
	public String recursoName;
	public String recursoAction;
	public long createDate;
	public String clienteHost;
	public String serverName;
	public String serverId;
	public String additionalInformation;
}