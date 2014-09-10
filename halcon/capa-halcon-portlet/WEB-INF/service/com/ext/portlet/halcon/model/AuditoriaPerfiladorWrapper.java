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
 * This class is a wrapper for {@link AuditoriaPerfilador}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       AuditoriaPerfilador
 * @generated
 */
public class AuditoriaPerfiladorWrapper implements AuditoriaPerfilador,
	ModelWrapper<AuditoriaPerfilador> {
	public AuditoriaPerfiladorWrapper(AuditoriaPerfilador auditoriaPerfilador) {
		_auditoriaPerfilador = auditoriaPerfilador;
	}

	public Class<?> getModelClass() {
		return AuditoriaPerfilador.class;
	}

	public String getModelClassName() {
		return AuditoriaPerfilador.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAuditoriaPer", getIdAuditoriaPer());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("perfilador", getPerfilador());
		attributes.put("session", getSession());
		attributes.put("transaccion", getTransaccion());
		attributes.put("monto", getMonto());
		attributes.put("tipoCredito", getTipoCredito());
		attributes.put("IP", getIP());
		attributes.put("fechaHora", getFechaHora());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());
		attributes.put("pregunta01", getPregunta01());
		attributes.put("pregunta02", getPregunta02());
		attributes.put("pregunta03", getPregunta03());
		attributes.put("pregunta04", getPregunta04());
		attributes.put("respuesta01", getRespuesta01());
		attributes.put("respuesta02", getRespuesta02());
		attributes.put("respuesta03", getRespuesta03());
		attributes.put("respuesta04", getRespuesta04());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAuditoriaPer = (Long)attributes.get("idAuditoriaPer");

		if (idAuditoriaPer != null) {
			setIdAuditoriaPer(idAuditoriaPer);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String numeroDocumento = (String)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		String perfilador = (String)attributes.get("perfilador");

		if (perfilador != null) {
			setPerfilador(perfilador);
		}

		String session = (String)attributes.get("session");

		if (session != null) {
			setSession(session);
		}

		String transaccion = (String)attributes.get("transaccion");

		if (transaccion != null) {
			setTransaccion(transaccion);
		}

		Double monto = (Double)attributes.get("monto");

		if (monto != null) {
			setMonto(monto);
		}

		String tipoCredito = (String)attributes.get("tipoCredito");

		if (tipoCredito != null) {
			setTipoCredito(tipoCredito);
		}

		String IP = (String)attributes.get("IP");

		if (IP != null) {
			setIP(IP);
		}

		Date fechaHora = (Date)attributes.get("fechaHora");

		if (fechaHora != null) {
			setFechaHora(fechaHora);
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

		String pregunta01 = (String)attributes.get("pregunta01");

		if (pregunta01 != null) {
			setPregunta01(pregunta01);
		}

		String pregunta02 = (String)attributes.get("pregunta02");

		if (pregunta02 != null) {
			setPregunta02(pregunta02);
		}

		String pregunta03 = (String)attributes.get("pregunta03");

		if (pregunta03 != null) {
			setPregunta03(pregunta03);
		}

		String pregunta04 = (String)attributes.get("pregunta04");

		if (pregunta04 != null) {
			setPregunta04(pregunta04);
		}

		String respuesta01 = (String)attributes.get("respuesta01");

		if (respuesta01 != null) {
			setRespuesta01(respuesta01);
		}

		String respuesta02 = (String)attributes.get("respuesta02");

		if (respuesta02 != null) {
			setRespuesta02(respuesta02);
		}

		String respuesta03 = (String)attributes.get("respuesta03");

		if (respuesta03 != null) {
			setRespuesta03(respuesta03);
		}

		String respuesta04 = (String)attributes.get("respuesta04");

		if (respuesta04 != null) {
			setRespuesta04(respuesta04);
		}
	}

	/**
	* Returns the primary key of this auditoria perfilador.
	*
	* @return the primary key of this auditoria perfilador
	*/
	public long getPrimaryKey() {
		return _auditoriaPerfilador.getPrimaryKey();
	}

	/**
	* Sets the primary key of this auditoria perfilador.
	*
	* @param primaryKey the primary key of this auditoria perfilador
	*/
	public void setPrimaryKey(long primaryKey) {
		_auditoriaPerfilador.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id auditoria per of this auditoria perfilador.
	*
	* @return the id auditoria per of this auditoria perfilador
	*/
	public long getIdAuditoriaPer() {
		return _auditoriaPerfilador.getIdAuditoriaPer();
	}

	/**
	* Sets the id auditoria per of this auditoria perfilador.
	*
	* @param idAuditoriaPer the id auditoria per of this auditoria perfilador
	*/
	public void setIdAuditoriaPer(long idAuditoriaPer) {
		_auditoriaPerfilador.setIdAuditoriaPer(idAuditoriaPer);
	}

	/**
	* Returns the tipo documento of this auditoria perfilador.
	*
	* @return the tipo documento of this auditoria perfilador
	*/
	public java.lang.String getTipoDocumento() {
		return _auditoriaPerfilador.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this auditoria perfilador.
	*
	* @param tipoDocumento the tipo documento of this auditoria perfilador
	*/
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_auditoriaPerfilador.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the numero documento of this auditoria perfilador.
	*
	* @return the numero documento of this auditoria perfilador
	*/
	public java.lang.String getNumeroDocumento() {
		return _auditoriaPerfilador.getNumeroDocumento();
	}

	/**
	* Sets the numero documento of this auditoria perfilador.
	*
	* @param numeroDocumento the numero documento of this auditoria perfilador
	*/
	public void setNumeroDocumento(java.lang.String numeroDocumento) {
		_auditoriaPerfilador.setNumeroDocumento(numeroDocumento);
	}

	/**
	* Returns the perfilador of this auditoria perfilador.
	*
	* @return the perfilador of this auditoria perfilador
	*/
	public java.lang.String getPerfilador() {
		return _auditoriaPerfilador.getPerfilador();
	}

	/**
	* Sets the perfilador of this auditoria perfilador.
	*
	* @param perfilador the perfilador of this auditoria perfilador
	*/
	public void setPerfilador(java.lang.String perfilador) {
		_auditoriaPerfilador.setPerfilador(perfilador);
	}

	/**
	* Returns the session of this auditoria perfilador.
	*
	* @return the session of this auditoria perfilador
	*/
	public java.lang.String getSession() {
		return _auditoriaPerfilador.getSession();
	}

	/**
	* Sets the session of this auditoria perfilador.
	*
	* @param session the session of this auditoria perfilador
	*/
	public void setSession(java.lang.String session) {
		_auditoriaPerfilador.setSession(session);
	}

	/**
	* Returns the transaccion of this auditoria perfilador.
	*
	* @return the transaccion of this auditoria perfilador
	*/
	public java.lang.String getTransaccion() {
		return _auditoriaPerfilador.getTransaccion();
	}

	/**
	* Sets the transaccion of this auditoria perfilador.
	*
	* @param transaccion the transaccion of this auditoria perfilador
	*/
	public void setTransaccion(java.lang.String transaccion) {
		_auditoriaPerfilador.setTransaccion(transaccion);
	}

	/**
	* Returns the monto of this auditoria perfilador.
	*
	* @return the monto of this auditoria perfilador
	*/
	public java.lang.Double getMonto() {
		return _auditoriaPerfilador.getMonto();
	}

	/**
	* Sets the monto of this auditoria perfilador.
	*
	* @param monto the monto of this auditoria perfilador
	*/
	public void setMonto(java.lang.Double monto) {
		_auditoriaPerfilador.setMonto(monto);
	}

	/**
	* Returns the tipo credito of this auditoria perfilador.
	*
	* @return the tipo credito of this auditoria perfilador
	*/
	public java.lang.String getTipoCredito() {
		return _auditoriaPerfilador.getTipoCredito();
	}

	/**
	* Sets the tipo credito of this auditoria perfilador.
	*
	* @param tipoCredito the tipo credito of this auditoria perfilador
	*/
	public void setTipoCredito(java.lang.String tipoCredito) {
		_auditoriaPerfilador.setTipoCredito(tipoCredito);
	}

	/**
	* Returns the i p of this auditoria perfilador.
	*
	* @return the i p of this auditoria perfilador
	*/
	public java.lang.String getIP() {
		return _auditoriaPerfilador.getIP();
	}

	/**
	* Sets the i p of this auditoria perfilador.
	*
	* @param IP the i p of this auditoria perfilador
	*/
	public void setIP(java.lang.String IP) {
		_auditoriaPerfilador.setIP(IP);
	}

	/**
	* Returns the fecha hora of this auditoria perfilador.
	*
	* @return the fecha hora of this auditoria perfilador
	*/
	public java.util.Date getFechaHora() {
		return _auditoriaPerfilador.getFechaHora();
	}

	/**
	* Sets the fecha hora of this auditoria perfilador.
	*
	* @param fechaHora the fecha hora of this auditoria perfilador
	*/
	public void setFechaHora(java.util.Date fechaHora) {
		_auditoriaPerfilador.setFechaHora(fechaHora);
	}

	/**
	* Returns the u t m source of this auditoria perfilador.
	*
	* @return the u t m source of this auditoria perfilador
	*/
	public java.lang.String getUTMSource() {
		return _auditoriaPerfilador.getUTMSource();
	}

	/**
	* Sets the u t m source of this auditoria perfilador.
	*
	* @param UTMSource the u t m source of this auditoria perfilador
	*/
	public void setUTMSource(java.lang.String UTMSource) {
		_auditoriaPerfilador.setUTMSource(UTMSource);
	}

	/**
	* Returns the u t m medium of this auditoria perfilador.
	*
	* @return the u t m medium of this auditoria perfilador
	*/
	public java.lang.String getUTMMedium() {
		return _auditoriaPerfilador.getUTMMedium();
	}

	/**
	* Sets the u t m medium of this auditoria perfilador.
	*
	* @param UTMMedium the u t m medium of this auditoria perfilador
	*/
	public void setUTMMedium(java.lang.String UTMMedium) {
		_auditoriaPerfilador.setUTMMedium(UTMMedium);
	}

	/**
	* Returns the u t m campaing of this auditoria perfilador.
	*
	* @return the u t m campaing of this auditoria perfilador
	*/
	public java.lang.String getUTMCampaing() {
		return _auditoriaPerfilador.getUTMCampaing();
	}

	/**
	* Sets the u t m campaing of this auditoria perfilador.
	*
	* @param UTMCampaing the u t m campaing of this auditoria perfilador
	*/
	public void setUTMCampaing(java.lang.String UTMCampaing) {
		_auditoriaPerfilador.setUTMCampaing(UTMCampaing);
	}

	/**
	* Returns the u t m content of this auditoria perfilador.
	*
	* @return the u t m content of this auditoria perfilador
	*/
	public java.lang.String getUTMContent() {
		return _auditoriaPerfilador.getUTMContent();
	}

	/**
	* Sets the u t m content of this auditoria perfilador.
	*
	* @param UTMContent the u t m content of this auditoria perfilador
	*/
	public void setUTMContent(java.lang.String UTMContent) {
		_auditoriaPerfilador.setUTMContent(UTMContent);
	}

	/**
	* Returns the pregunta01 of this auditoria perfilador.
	*
	* @return the pregunta01 of this auditoria perfilador
	*/
	public java.lang.String getPregunta01() {
		return _auditoriaPerfilador.getPregunta01();
	}

	/**
	* Sets the pregunta01 of this auditoria perfilador.
	*
	* @param pregunta01 the pregunta01 of this auditoria perfilador
	*/
	public void setPregunta01(java.lang.String pregunta01) {
		_auditoriaPerfilador.setPregunta01(pregunta01);
	}

	/**
	* Returns the pregunta02 of this auditoria perfilador.
	*
	* @return the pregunta02 of this auditoria perfilador
	*/
	public java.lang.String getPregunta02() {
		return _auditoriaPerfilador.getPregunta02();
	}

	/**
	* Sets the pregunta02 of this auditoria perfilador.
	*
	* @param pregunta02 the pregunta02 of this auditoria perfilador
	*/
	public void setPregunta02(java.lang.String pregunta02) {
		_auditoriaPerfilador.setPregunta02(pregunta02);
	}

	/**
	* Returns the pregunta03 of this auditoria perfilador.
	*
	* @return the pregunta03 of this auditoria perfilador
	*/
	public java.lang.String getPregunta03() {
		return _auditoriaPerfilador.getPregunta03();
	}

	/**
	* Sets the pregunta03 of this auditoria perfilador.
	*
	* @param pregunta03 the pregunta03 of this auditoria perfilador
	*/
	public void setPregunta03(java.lang.String pregunta03) {
		_auditoriaPerfilador.setPregunta03(pregunta03);
	}

	/**
	* Returns the pregunta04 of this auditoria perfilador.
	*
	* @return the pregunta04 of this auditoria perfilador
	*/
	public java.lang.String getPregunta04() {
		return _auditoriaPerfilador.getPregunta04();
	}

	/**
	* Sets the pregunta04 of this auditoria perfilador.
	*
	* @param pregunta04 the pregunta04 of this auditoria perfilador
	*/
	public void setPregunta04(java.lang.String pregunta04) {
		_auditoriaPerfilador.setPregunta04(pregunta04);
	}

	/**
	* Returns the respuesta01 of this auditoria perfilador.
	*
	* @return the respuesta01 of this auditoria perfilador
	*/
	public java.lang.String getRespuesta01() {
		return _auditoriaPerfilador.getRespuesta01();
	}

	/**
	* Sets the respuesta01 of this auditoria perfilador.
	*
	* @param respuesta01 the respuesta01 of this auditoria perfilador
	*/
	public void setRespuesta01(java.lang.String respuesta01) {
		_auditoriaPerfilador.setRespuesta01(respuesta01);
	}

	/**
	* Returns the respuesta02 of this auditoria perfilador.
	*
	* @return the respuesta02 of this auditoria perfilador
	*/
	public java.lang.String getRespuesta02() {
		return _auditoriaPerfilador.getRespuesta02();
	}

	/**
	* Sets the respuesta02 of this auditoria perfilador.
	*
	* @param respuesta02 the respuesta02 of this auditoria perfilador
	*/
	public void setRespuesta02(java.lang.String respuesta02) {
		_auditoriaPerfilador.setRespuesta02(respuesta02);
	}

	/**
	* Returns the respuesta03 of this auditoria perfilador.
	*
	* @return the respuesta03 of this auditoria perfilador
	*/
	public java.lang.String getRespuesta03() {
		return _auditoriaPerfilador.getRespuesta03();
	}

	/**
	* Sets the respuesta03 of this auditoria perfilador.
	*
	* @param respuesta03 the respuesta03 of this auditoria perfilador
	*/
	public void setRespuesta03(java.lang.String respuesta03) {
		_auditoriaPerfilador.setRespuesta03(respuesta03);
	}

	/**
	* Returns the respuesta04 of this auditoria perfilador.
	*
	* @return the respuesta04 of this auditoria perfilador
	*/
	public java.lang.String getRespuesta04() {
		return _auditoriaPerfilador.getRespuesta04();
	}

	/**
	* Sets the respuesta04 of this auditoria perfilador.
	*
	* @param respuesta04 the respuesta04 of this auditoria perfilador
	*/
	public void setRespuesta04(java.lang.String respuesta04) {
		_auditoriaPerfilador.setRespuesta04(respuesta04);
	}

	public boolean isNew() {
		return _auditoriaPerfilador.isNew();
	}

	public void setNew(boolean n) {
		_auditoriaPerfilador.setNew(n);
	}

	public boolean isCachedModel() {
		return _auditoriaPerfilador.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_auditoriaPerfilador.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _auditoriaPerfilador.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _auditoriaPerfilador.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_auditoriaPerfilador.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _auditoriaPerfilador.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_auditoriaPerfilador.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuditoriaPerfiladorWrapper((AuditoriaPerfilador)_auditoriaPerfilador.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador) {
		return _auditoriaPerfilador.compareTo(auditoriaPerfilador);
	}

	@Override
	public int hashCode() {
		return _auditoriaPerfilador.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.AuditoriaPerfilador> toCacheModel() {
		return _auditoriaPerfilador.toCacheModel();
	}

	public com.ext.portlet.halcon.model.AuditoriaPerfilador toEscapedModel() {
		return new AuditoriaPerfiladorWrapper(_auditoriaPerfilador.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _auditoriaPerfilador.toString();
	}

	public java.lang.String toXmlString() {
		return _auditoriaPerfilador.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_auditoriaPerfilador.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AuditoriaPerfilador getWrappedAuditoriaPerfilador() {
		return _auditoriaPerfilador;
	}

	public AuditoriaPerfilador getWrappedModel() {
		return _auditoriaPerfilador;
	}

	public void resetOriginalValues() {
		_auditoriaPerfilador.resetOriginalValues();
	}

	private AuditoriaPerfilador _auditoriaPerfilador;
}