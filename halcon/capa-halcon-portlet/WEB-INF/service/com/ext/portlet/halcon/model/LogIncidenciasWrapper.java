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
 * This class is a wrapper for {@link LogIncidencias}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       LogIncidencias
 * @generated
 */
public class LogIncidenciasWrapper implements LogIncidencias,
	ModelWrapper<LogIncidencias> {
	public LogIncidenciasWrapper(LogIncidencias logIncidencias) {
		_logIncidencias = logIncidencias;
	}

	public Class<?> getModelClass() {
		return LogIncidencias.class;
	}

	public String getModelClassName() {
		return LogIncidencias.class.getName();
	}

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

	/**
	* Returns the primary key of this log incidencias.
	*
	* @return the primary key of this log incidencias
	*/
	public long getPrimaryKey() {
		return _logIncidencias.getPrimaryKey();
	}

	/**
	* Sets the primary key of this log incidencias.
	*
	* @param primaryKey the primary key of this log incidencias
	*/
	public void setPrimaryKey(long primaryKey) {
		_logIncidencias.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id error of this log incidencias.
	*
	* @return the id error of this log incidencias
	*/
	public long getIdError() {
		return _logIncidencias.getIdError();
	}

	/**
	* Sets the id error of this log incidencias.
	*
	* @param idError the id error of this log incidencias
	*/
	public void setIdError(long idError) {
		_logIncidencias.setIdError(idError);
	}

	/**
	* Returns the mensaje error of this log incidencias.
	*
	* @return the mensaje error of this log incidencias
	*/
	public java.lang.String getMensajeError() {
		return _logIncidencias.getMensajeError();
	}

	/**
	* Sets the mensaje error of this log incidencias.
	*
	* @param mensajeError the mensaje error of this log incidencias
	*/
	public void setMensajeError(java.lang.String mensajeError) {
		_logIncidencias.setMensajeError(mensajeError);
	}

	/**
	* Returns the parametro of this log incidencias.
	*
	* @return the parametro of this log incidencias
	*/
	public java.lang.String getParametro() {
		return _logIncidencias.getParametro();
	}

	/**
	* Sets the parametro of this log incidencias.
	*
	* @param parametro the parametro of this log incidencias
	*/
	public void setParametro(java.lang.String parametro) {
		_logIncidencias.setParametro(parametro);
	}

	/**
	* Returns the id session visitante of this log incidencias.
	*
	* @return the id session visitante of this log incidencias
	*/
	public java.lang.String getIdSessionVisitante() {
		return _logIncidencias.getIdSessionVisitante();
	}

	/**
	* Sets the id session visitante of this log incidencias.
	*
	* @param idSessionVisitante the id session visitante of this log incidencias
	*/
	public void setIdSessionVisitante(java.lang.String idSessionVisitante) {
		_logIncidencias.setIdSessionVisitante(idSessionVisitante);
	}

	/**
	* Returns the tipo num doc of this log incidencias.
	*
	* @return the tipo num doc of this log incidencias
	*/
	public java.lang.String getTipoNumDoc() {
		return _logIncidencias.getTipoNumDoc();
	}

	/**
	* Sets the tipo num doc of this log incidencias.
	*
	* @param tipoNumDoc the tipo num doc of this log incidencias
	*/
	public void setTipoNumDoc(java.lang.String tipoNumDoc) {
		_logIncidencias.setTipoNumDoc(tipoNumDoc);
	}

	/**
	* Returns the i p of this log incidencias.
	*
	* @return the i p of this log incidencias
	*/
	public java.lang.String getIP() {
		return _logIncidencias.getIP();
	}

	/**
	* Sets the i p of this log incidencias.
	*
	* @param IP the i p of this log incidencias
	*/
	public void setIP(java.lang.String IP) {
		_logIncidencias.setIP(IP);
	}

	/**
	* Returns the fecha hora error of this log incidencias.
	*
	* @return the fecha hora error of this log incidencias
	*/
	public java.util.Date getFechaHoraError() {
		return _logIncidencias.getFechaHoraError();
	}

	/**
	* Sets the fecha hora error of this log incidencias.
	*
	* @param fechaHoraError the fecha hora error of this log incidencias
	*/
	public void setFechaHoraError(java.util.Date fechaHoraError) {
		_logIncidencias.setFechaHoraError(fechaHoraError);
	}

	/**
	* Returns the traza error of this log incidencias.
	*
	* @return the traza error of this log incidencias
	*/
	public java.lang.String getTrazaError() {
		return _logIncidencias.getTrazaError();
	}

	/**
	* Sets the traza error of this log incidencias.
	*
	* @param trazaError the traza error of this log incidencias
	*/
	public void setTrazaError(java.lang.String trazaError) {
		_logIncidencias.setTrazaError(trazaError);
	}

	/**
	* Returns the pagina hija of this log incidencias.
	*
	* @return the pagina hija of this log incidencias
	*/
	public java.lang.String getPaginaHija() {
		return _logIncidencias.getPaginaHija();
	}

	/**
	* Sets the pagina hija of this log incidencias.
	*
	* @param paginaHija the pagina hija of this log incidencias
	*/
	public void setPaginaHija(java.lang.String paginaHija) {
		_logIncidencias.setPaginaHija(paginaHija);
	}

	/**
	* Returns the user ID of this log incidencias.
	*
	* @return the user ID of this log incidencias
	*/
	public java.lang.String getUserId() {
		return _logIncidencias.getUserId();
	}

	/**
	* Sets the user ID of this log incidencias.
	*
	* @param userId the user ID of this log incidencias
	*/
	public void setUserId(java.lang.String userId) {
		_logIncidencias.setUserId(userId);
	}

	/**
	* Returns the user name of this log incidencias.
	*
	* @return the user name of this log incidencias
	*/
	public java.lang.String getUserName() {
		return _logIncidencias.getUserName();
	}

	/**
	* Sets the user name of this log incidencias.
	*
	* @param userName the user name of this log incidencias
	*/
	public void setUserName(java.lang.String userName) {
		_logIncidencias.setUserName(userName);
	}

	/**
	* Returns the recurso ID of this log incidencias.
	*
	* @return the recurso ID of this log incidencias
	*/
	public java.lang.String getRecursoId() {
		return _logIncidencias.getRecursoId();
	}

	/**
	* Sets the recurso ID of this log incidencias.
	*
	* @param recursoId the recurso ID of this log incidencias
	*/
	public void setRecursoId(java.lang.String recursoId) {
		_logIncidencias.setRecursoId(recursoId);
	}

	/**
	* Returns the recurso name of this log incidencias.
	*
	* @return the recurso name of this log incidencias
	*/
	public java.lang.String getRecursoName() {
		return _logIncidencias.getRecursoName();
	}

	/**
	* Sets the recurso name of this log incidencias.
	*
	* @param recursoName the recurso name of this log incidencias
	*/
	public void setRecursoName(java.lang.String recursoName) {
		_logIncidencias.setRecursoName(recursoName);
	}

	/**
	* Returns the recurso action of this log incidencias.
	*
	* @return the recurso action of this log incidencias
	*/
	public java.lang.String getRecursoAction() {
		return _logIncidencias.getRecursoAction();
	}

	/**
	* Sets the recurso action of this log incidencias.
	*
	* @param recursoAction the recurso action of this log incidencias
	*/
	public void setRecursoAction(java.lang.String recursoAction) {
		_logIncidencias.setRecursoAction(recursoAction);
	}

	/**
	* Returns the create date of this log incidencias.
	*
	* @return the create date of this log incidencias
	*/
	public java.util.Date getCreateDate() {
		return _logIncidencias.getCreateDate();
	}

	/**
	* Sets the create date of this log incidencias.
	*
	* @param createDate the create date of this log incidencias
	*/
	public void setCreateDate(java.util.Date createDate) {
		_logIncidencias.setCreateDate(createDate);
	}

	/**
	* Returns the cliente host of this log incidencias.
	*
	* @return the cliente host of this log incidencias
	*/
	public java.lang.String getClienteHost() {
		return _logIncidencias.getClienteHost();
	}

	/**
	* Sets the cliente host of this log incidencias.
	*
	* @param clienteHost the cliente host of this log incidencias
	*/
	public void setClienteHost(java.lang.String clienteHost) {
		_logIncidencias.setClienteHost(clienteHost);
	}

	/**
	* Returns the server name of this log incidencias.
	*
	* @return the server name of this log incidencias
	*/
	public java.lang.String getServerName() {
		return _logIncidencias.getServerName();
	}

	/**
	* Sets the server name of this log incidencias.
	*
	* @param serverName the server name of this log incidencias
	*/
	public void setServerName(java.lang.String serverName) {
		_logIncidencias.setServerName(serverName);
	}

	/**
	* Returns the server ID of this log incidencias.
	*
	* @return the server ID of this log incidencias
	*/
	public java.lang.String getServerId() {
		return _logIncidencias.getServerId();
	}

	/**
	* Sets the server ID of this log incidencias.
	*
	* @param serverId the server ID of this log incidencias
	*/
	public void setServerId(java.lang.String serverId) {
		_logIncidencias.setServerId(serverId);
	}

	/**
	* Returns the additional information of this log incidencias.
	*
	* @return the additional information of this log incidencias
	*/
	public java.lang.String getAdditionalInformation() {
		return _logIncidencias.getAdditionalInformation();
	}

	/**
	* Sets the additional information of this log incidencias.
	*
	* @param additionalInformation the additional information of this log incidencias
	*/
	public void setAdditionalInformation(java.lang.String additionalInformation) {
		_logIncidencias.setAdditionalInformation(additionalInformation);
	}

	public boolean isNew() {
		return _logIncidencias.isNew();
	}

	public void setNew(boolean n) {
		_logIncidencias.setNew(n);
	}

	public boolean isCachedModel() {
		return _logIncidencias.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_logIncidencias.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _logIncidencias.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _logIncidencias.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_logIncidencias.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _logIncidencias.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_logIncidencias.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LogIncidenciasWrapper((LogIncidencias)_logIncidencias.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias) {
		return _logIncidencias.compareTo(logIncidencias);
	}

	@Override
	public int hashCode() {
		return _logIncidencias.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.LogIncidencias> toCacheModel() {
		return _logIncidencias.toCacheModel();
	}

	public com.ext.portlet.halcon.model.LogIncidencias toEscapedModel() {
		return new LogIncidenciasWrapper(_logIncidencias.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _logIncidencias.toString();
	}

	public java.lang.String toXmlString() {
		return _logIncidencias.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_logIncidencias.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LogIncidencias getWrappedLogIncidencias() {
		return _logIncidencias;
	}

	public LogIncidencias getWrappedModel() {
		return _logIncidencias;
	}

	public void resetOriginalValues() {
		_logIncidencias.resetOriginalValues();
	}

	private LogIncidencias _logIncidencias;
}