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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.LogIncidenciasServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.LogIncidenciasServiceSoap
 * @generated
 */
public class LogIncidenciasSoap implements Serializable {
	public static LogIncidenciasSoap toSoapModel(LogIncidencias model) {
		LogIncidenciasSoap soapModel = new LogIncidenciasSoap();

		soapModel.setIdError(model.getIdError());
		soapModel.setMensajeError(model.getMensajeError());
		soapModel.setParametro(model.getParametro());
		soapModel.setIdSessionVisitante(model.getIdSessionVisitante());
		soapModel.setTipoNumDoc(model.getTipoNumDoc());
		soapModel.setIP(model.getIP());
		soapModel.setFechaHoraError(model.getFechaHoraError());
		soapModel.setTrazaError(model.getTrazaError());
		soapModel.setPaginaHija(model.getPaginaHija());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setRecursoId(model.getRecursoId());
		soapModel.setRecursoName(model.getRecursoName());
		soapModel.setRecursoAction(model.getRecursoAction());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setClienteHost(model.getClienteHost());
		soapModel.setServerName(model.getServerName());
		soapModel.setServerId(model.getServerId());
		soapModel.setAdditionalInformation(model.getAdditionalInformation());

		return soapModel;
	}

	public static LogIncidenciasSoap[] toSoapModels(LogIncidencias[] models) {
		LogIncidenciasSoap[] soapModels = new LogIncidenciasSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogIncidenciasSoap[][] toSoapModels(LogIncidencias[][] models) {
		LogIncidenciasSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogIncidenciasSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogIncidenciasSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogIncidenciasSoap[] toSoapModels(List<LogIncidencias> models) {
		List<LogIncidenciasSoap> soapModels = new ArrayList<LogIncidenciasSoap>(models.size());

		for (LogIncidencias model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogIncidenciasSoap[soapModels.size()]);
	}

	public LogIncidenciasSoap() {
	}

	public long getPrimaryKey() {
		return _idError;
	}

	public void setPrimaryKey(long pk) {
		setIdError(pk);
	}

	public long getIdError() {
		return _idError;
	}

	public void setIdError(long idError) {
		_idError = idError;
	}

	public String getMensajeError() {
		return _mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		_mensajeError = mensajeError;
	}

	public String getParametro() {
		return _parametro;
	}

	public void setParametro(String parametro) {
		_parametro = parametro;
	}

	public String getIdSessionVisitante() {
		return _idSessionVisitante;
	}

	public void setIdSessionVisitante(String idSessionVisitante) {
		_idSessionVisitante = idSessionVisitante;
	}

	public String getTipoNumDoc() {
		return _tipoNumDoc;
	}

	public void setTipoNumDoc(String tipoNumDoc) {
		_tipoNumDoc = tipoNumDoc;
	}

	public String getIP() {
		return _IP;
	}

	public void setIP(String IP) {
		_IP = IP;
	}

	public Date getFechaHoraError() {
		return _fechaHoraError;
	}

	public void setFechaHoraError(Date fechaHoraError) {
		_fechaHoraError = fechaHoraError;
	}

	public String getTrazaError() {
		return _trazaError;
	}

	public void setTrazaError(String trazaError) {
		_trazaError = trazaError;
	}

	public String getPaginaHija() {
		return _paginaHija;
	}

	public void setPaginaHija(String paginaHija) {
		_paginaHija = paginaHija;
	}

	public String getUserId() {
		return _userId;
	}

	public void setUserId(String userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getRecursoId() {
		return _recursoId;
	}

	public void setRecursoId(String recursoId) {
		_recursoId = recursoId;
	}

	public String getRecursoName() {
		return _recursoName;
	}

	public void setRecursoName(String recursoName) {
		_recursoName = recursoName;
	}

	public String getRecursoAction() {
		return _recursoAction;
	}

	public void setRecursoAction(String recursoAction) {
		_recursoAction = recursoAction;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getClienteHost() {
		return _clienteHost;
	}

	public void setClienteHost(String clienteHost) {
		_clienteHost = clienteHost;
	}

	public String getServerName() {
		return _serverName;
	}

	public void setServerName(String serverName) {
		_serverName = serverName;
	}

	public String getServerId() {
		return _serverId;
	}

	public void setServerId(String serverId) {
		_serverId = serverId;
	}

	public String getAdditionalInformation() {
		return _additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		_additionalInformation = additionalInformation;
	}

	private long _idError;
	private String _mensajeError;
	private String _parametro;
	private String _idSessionVisitante;
	private String _tipoNumDoc;
	private String _IP;
	private Date _fechaHoraError;
	private String _trazaError;
	private String _paginaHija;
	private String _userId;
	private String _userName;
	private String _recursoId;
	private String _recursoName;
	private String _recursoAction;
	private Date _createDate;
	private String _clienteHost;
	private String _serverName;
	private String _serverId;
	private String _additionalInformation;
}