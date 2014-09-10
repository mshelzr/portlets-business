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

import com.ext.portlet.halcon.service.LogIncidenciasLocalServiceUtil;

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
public class LogIncidenciasClp extends BaseModelImpl<LogIncidencias>
	implements LogIncidencias {
	public LogIncidenciasClp() {
	}

	public Class<?> getModelClass() {
		return LogIncidencias.class;
	}

	public String getModelClassName() {
		return LogIncidencias.class.getName();
	}

	public long getPrimaryKey() {
		return _idError;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdError(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idError);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idError", getIdError());
		attributes.put("mensajeError", getMensajeError());
		attributes.put("parametro", getParametro());
		attributes.put("idSessionVisitante", getIdSessionVisitante());
		attributes.put("tipoNumDoc", getTipoNumDoc());
		attributes.put("IP", getIP());
		attributes.put("fechaHoraError", getFechaHoraError());
		attributes.put("trazaError", getTrazaError());
		attributes.put("paginaHija", getPaginaHija());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("recursoId", getRecursoId());
		attributes.put("recursoName", getRecursoName());
		attributes.put("recursoAction", getRecursoAction());
		attributes.put("createDate", getCreateDate());
		attributes.put("clienteHost", getClienteHost());
		attributes.put("serverName", getServerName());
		attributes.put("serverId", getServerId());
		attributes.put("additionalInformation", getAdditionalInformation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idError = (Long)attributes.get("idError");

		if (idError != null) {
			setIdError(idError);
		}

		String mensajeError = (String)attributes.get("mensajeError");

		if (mensajeError != null) {
			setMensajeError(mensajeError);
		}

		String parametro = (String)attributes.get("parametro");

		if (parametro != null) {
			setParametro(parametro);
		}

		String idSessionVisitante = (String)attributes.get("idSessionVisitante");

		if (idSessionVisitante != null) {
			setIdSessionVisitante(idSessionVisitante);
		}

		String tipoNumDoc = (String)attributes.get("tipoNumDoc");

		if (tipoNumDoc != null) {
			setTipoNumDoc(tipoNumDoc);
		}

		String IP = (String)attributes.get("IP");

		if (IP != null) {
			setIP(IP);
		}

		Date fechaHoraError = (Date)attributes.get("fechaHoraError");

		if (fechaHoraError != null) {
			setFechaHoraError(fechaHoraError);
		}

		String trazaError = (String)attributes.get("trazaError");

		if (trazaError != null) {
			setTrazaError(trazaError);
		}

		String paginaHija = (String)attributes.get("paginaHija");

		if (paginaHija != null) {
			setPaginaHija(paginaHija);
		}

		String userId = (String)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String recursoId = (String)attributes.get("recursoId");

		if (recursoId != null) {
			setRecursoId(recursoId);
		}

		String recursoName = (String)attributes.get("recursoName");

		if (recursoName != null) {
			setRecursoName(recursoName);
		}

		String recursoAction = (String)attributes.get("recursoAction");

		if (recursoAction != null) {
			setRecursoAction(recursoAction);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String clienteHost = (String)attributes.get("clienteHost");

		if (clienteHost != null) {
			setClienteHost(clienteHost);
		}

		String serverName = (String)attributes.get("serverName");

		if (serverName != null) {
			setServerName(serverName);
		}

		String serverId = (String)attributes.get("serverId");

		if (serverId != null) {
			setServerId(serverId);
		}

		String additionalInformation = (String)attributes.get(
				"additionalInformation");

		if (additionalInformation != null) {
			setAdditionalInformation(additionalInformation);
		}
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

	public BaseModel<?> getLogIncidenciasRemoteModel() {
		return _logIncidenciasRemoteModel;
	}

	public void setLogIncidenciasRemoteModel(
		BaseModel<?> logIncidenciasRemoteModel) {
		_logIncidenciasRemoteModel = logIncidenciasRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LogIncidenciasLocalServiceUtil.addLogIncidencias(this);
		}
		else {
			LogIncidenciasLocalServiceUtil.updateLogIncidencias(this);
		}
	}

	@Override
	public LogIncidencias toEscapedModel() {
		return (LogIncidencias)Proxy.newProxyInstance(LogIncidencias.class.getClassLoader(),
			new Class[] { LogIncidencias.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LogIncidenciasClp clone = new LogIncidenciasClp();

		clone.setIdError(getIdError());
		clone.setMensajeError(getMensajeError());
		clone.setParametro(getParametro());
		clone.setIdSessionVisitante(getIdSessionVisitante());
		clone.setTipoNumDoc(getTipoNumDoc());
		clone.setIP(getIP());
		clone.setFechaHoraError(getFechaHoraError());
		clone.setTrazaError(getTrazaError());
		clone.setPaginaHija(getPaginaHija());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setRecursoId(getRecursoId());
		clone.setRecursoName(getRecursoName());
		clone.setRecursoAction(getRecursoAction());
		clone.setCreateDate(getCreateDate());
		clone.setClienteHost(getClienteHost());
		clone.setServerName(getServerName());
		clone.setServerId(getServerId());
		clone.setAdditionalInformation(getAdditionalInformation());

		return clone;
	}

	public int compareTo(LogIncidencias logIncidencias) {
		long primaryKey = logIncidencias.getPrimaryKey();

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

		LogIncidenciasClp logIncidencias = null;

		try {
			logIncidencias = (LogIncidenciasClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = logIncidencias.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{idError=");
		sb.append(getIdError());
		sb.append(", mensajeError=");
		sb.append(getMensajeError());
		sb.append(", parametro=");
		sb.append(getParametro());
		sb.append(", idSessionVisitante=");
		sb.append(getIdSessionVisitante());
		sb.append(", tipoNumDoc=");
		sb.append(getTipoNumDoc());
		sb.append(", IP=");
		sb.append(getIP());
		sb.append(", fechaHoraError=");
		sb.append(getFechaHoraError());
		sb.append(", trazaError=");
		sb.append(getTrazaError());
		sb.append(", paginaHija=");
		sb.append(getPaginaHija());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", recursoId=");
		sb.append(getRecursoId());
		sb.append(", recursoName=");
		sb.append(getRecursoName());
		sb.append(", recursoAction=");
		sb.append(getRecursoAction());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", clienteHost=");
		sb.append(getClienteHost());
		sb.append(", serverName=");
		sb.append(getServerName());
		sb.append(", serverId=");
		sb.append(getServerId());
		sb.append(", additionalInformation=");
		sb.append(getAdditionalInformation());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.LogIncidencias");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idError</column-name><column-value><![CDATA[");
		sb.append(getIdError());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mensajeError</column-name><column-value><![CDATA[");
		sb.append(getMensajeError());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parametro</column-name><column-value><![CDATA[");
		sb.append(getParametro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSessionVisitante</column-name><column-value><![CDATA[");
		sb.append(getIdSessionVisitante());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoNumDoc</column-name><column-value><![CDATA[");
		sb.append(getTipoNumDoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IP</column-name><column-value><![CDATA[");
		sb.append(getIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaHoraError</column-name><column-value><![CDATA[");
		sb.append(getFechaHoraError());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trazaError</column-name><column-value><![CDATA[");
		sb.append(getTrazaError());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paginaHija</column-name><column-value><![CDATA[");
		sb.append(getPaginaHija());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recursoId</column-name><column-value><![CDATA[");
		sb.append(getRecursoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recursoName</column-name><column-value><![CDATA[");
		sb.append(getRecursoName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>recursoAction</column-name><column-value><![CDATA[");
		sb.append(getRecursoAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clienteHost</column-name><column-value><![CDATA[");
		sb.append(getClienteHost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverName</column-name><column-value><![CDATA[");
		sb.append(getServerName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serverId</column-name><column-value><![CDATA[");
		sb.append(getServerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>additionalInformation</column-name><column-value><![CDATA[");
		sb.append(getAdditionalInformation());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _logIncidenciasRemoteModel;
}