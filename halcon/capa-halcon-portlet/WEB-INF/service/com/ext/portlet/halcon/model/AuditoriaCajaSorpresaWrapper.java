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
 * This class is a wrapper for {@link AuditoriaCajaSorpresa}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       AuditoriaCajaSorpresa
 * @generated
 */
public class AuditoriaCajaSorpresaWrapper implements AuditoriaCajaSorpresa,
	ModelWrapper<AuditoriaCajaSorpresa> {
	public AuditoriaCajaSorpresaWrapper(
		AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		_auditoriaCajaSorpresa = auditoriaCajaSorpresa;
	}

	public Class<?> getModelClass() {
		return AuditoriaCajaSorpresa.class;
	}

	public String getModelClassName() {
		return AuditoriaCajaSorpresa.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAuditoriaCajSorp", getIdAuditoriaCajSorp());
		attributes.put("idTransaccion", getIdTransaccion());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numDocumento", getNumDocumento());
		attributes.put("producto1", getProducto1());
		attributes.put("producto2", getProducto2());
		attributes.put("producto3", getProducto3());
		attributes.put("producto4", getProducto4());
		attributes.put("codProducto1", getCodProducto1());
		attributes.put("codProducto2", getCodProducto2());
		attributes.put("codProducto3", getCodProducto3());
		attributes.put("codProducto4", getCodProducto4());
		attributes.put("IP", getIP());
		attributes.put("session", getSession());
		attributes.put("fechaHora", getFechaHora());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAuditoriaCajSorp = (Long)attributes.get("idAuditoriaCajSorp");

		if (idAuditoriaCajSorp != null) {
			setIdAuditoriaCajSorp(idAuditoriaCajSorp);
		}

		String idTransaccion = (String)attributes.get("idTransaccion");

		if (idTransaccion != null) {
			setIdTransaccion(idTransaccion);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String numDocumento = (String)attributes.get("numDocumento");

		if (numDocumento != null) {
			setNumDocumento(numDocumento);
		}

		String producto1 = (String)attributes.get("producto1");

		if (producto1 != null) {
			setProducto1(producto1);
		}

		String producto2 = (String)attributes.get("producto2");

		if (producto2 != null) {
			setProducto2(producto2);
		}

		String producto3 = (String)attributes.get("producto3");

		if (producto3 != null) {
			setProducto3(producto3);
		}

		String producto4 = (String)attributes.get("producto4");

		if (producto4 != null) {
			setProducto4(producto4);
		}

		String codProducto1 = (String)attributes.get("codProducto1");

		if (codProducto1 != null) {
			setCodProducto1(codProducto1);
		}

		String codProducto2 = (String)attributes.get("codProducto2");

		if (codProducto2 != null) {
			setCodProducto2(codProducto2);
		}

		String codProducto3 = (String)attributes.get("codProducto3");

		if (codProducto3 != null) {
			setCodProducto3(codProducto3);
		}

		String codProducto4 = (String)attributes.get("codProducto4");

		if (codProducto4 != null) {
			setCodProducto4(codProducto4);
		}

		String IP = (String)attributes.get("IP");

		if (IP != null) {
			setIP(IP);
		}

		String session = (String)attributes.get("session");

		if (session != null) {
			setSession(session);
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
	}

	/**
	* Returns the primary key of this auditoria caja sorpresa.
	*
	* @return the primary key of this auditoria caja sorpresa
	*/
	public long getPrimaryKey() {
		return _auditoriaCajaSorpresa.getPrimaryKey();
	}

	/**
	* Sets the primary key of this auditoria caja sorpresa.
	*
	* @param primaryKey the primary key of this auditoria caja sorpresa
	*/
	public void setPrimaryKey(long primaryKey) {
		_auditoriaCajaSorpresa.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id auditoria caj sorp of this auditoria caja sorpresa.
	*
	* @return the id auditoria caj sorp of this auditoria caja sorpresa
	*/
	public long getIdAuditoriaCajSorp() {
		return _auditoriaCajaSorpresa.getIdAuditoriaCajSorp();
	}

	/**
	* Sets the id auditoria caj sorp of this auditoria caja sorpresa.
	*
	* @param idAuditoriaCajSorp the id auditoria caj sorp of this auditoria caja sorpresa
	*/
	public void setIdAuditoriaCajSorp(long idAuditoriaCajSorp) {
		_auditoriaCajaSorpresa.setIdAuditoriaCajSorp(idAuditoriaCajSorp);
	}

	/**
	* Returns the id transaccion of this auditoria caja sorpresa.
	*
	* @return the id transaccion of this auditoria caja sorpresa
	*/
	public java.lang.String getIdTransaccion() {
		return _auditoriaCajaSorpresa.getIdTransaccion();
	}

	/**
	* Sets the id transaccion of this auditoria caja sorpresa.
	*
	* @param idTransaccion the id transaccion of this auditoria caja sorpresa
	*/
	public void setIdTransaccion(java.lang.String idTransaccion) {
		_auditoriaCajaSorpresa.setIdTransaccion(idTransaccion);
	}

	/**
	* Returns the tipo documento of this auditoria caja sorpresa.
	*
	* @return the tipo documento of this auditoria caja sorpresa
	*/
	public java.lang.String getTipoDocumento() {
		return _auditoriaCajaSorpresa.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this auditoria caja sorpresa.
	*
	* @param tipoDocumento the tipo documento of this auditoria caja sorpresa
	*/
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_auditoriaCajaSorpresa.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the num documento of this auditoria caja sorpresa.
	*
	* @return the num documento of this auditoria caja sorpresa
	*/
	public java.lang.String getNumDocumento() {
		return _auditoriaCajaSorpresa.getNumDocumento();
	}

	/**
	* Sets the num documento of this auditoria caja sorpresa.
	*
	* @param numDocumento the num documento of this auditoria caja sorpresa
	*/
	public void setNumDocumento(java.lang.String numDocumento) {
		_auditoriaCajaSorpresa.setNumDocumento(numDocumento);
	}

	/**
	* Returns the producto1 of this auditoria caja sorpresa.
	*
	* @return the producto1 of this auditoria caja sorpresa
	*/
	public java.lang.String getProducto1() {
		return _auditoriaCajaSorpresa.getProducto1();
	}

	/**
	* Sets the producto1 of this auditoria caja sorpresa.
	*
	* @param producto1 the producto1 of this auditoria caja sorpresa
	*/
	public void setProducto1(java.lang.String producto1) {
		_auditoriaCajaSorpresa.setProducto1(producto1);
	}

	/**
	* Returns the producto2 of this auditoria caja sorpresa.
	*
	* @return the producto2 of this auditoria caja sorpresa
	*/
	public java.lang.String getProducto2() {
		return _auditoriaCajaSorpresa.getProducto2();
	}

	/**
	* Sets the producto2 of this auditoria caja sorpresa.
	*
	* @param producto2 the producto2 of this auditoria caja sorpresa
	*/
	public void setProducto2(java.lang.String producto2) {
		_auditoriaCajaSorpresa.setProducto2(producto2);
	}

	/**
	* Returns the producto3 of this auditoria caja sorpresa.
	*
	* @return the producto3 of this auditoria caja sorpresa
	*/
	public java.lang.String getProducto3() {
		return _auditoriaCajaSorpresa.getProducto3();
	}

	/**
	* Sets the producto3 of this auditoria caja sorpresa.
	*
	* @param producto3 the producto3 of this auditoria caja sorpresa
	*/
	public void setProducto3(java.lang.String producto3) {
		_auditoriaCajaSorpresa.setProducto3(producto3);
	}

	/**
	* Returns the producto4 of this auditoria caja sorpresa.
	*
	* @return the producto4 of this auditoria caja sorpresa
	*/
	public java.lang.String getProducto4() {
		return _auditoriaCajaSorpresa.getProducto4();
	}

	/**
	* Sets the producto4 of this auditoria caja sorpresa.
	*
	* @param producto4 the producto4 of this auditoria caja sorpresa
	*/
	public void setProducto4(java.lang.String producto4) {
		_auditoriaCajaSorpresa.setProducto4(producto4);
	}

	/**
	* Returns the cod producto1 of this auditoria caja sorpresa.
	*
	* @return the cod producto1 of this auditoria caja sorpresa
	*/
	public java.lang.String getCodProducto1() {
		return _auditoriaCajaSorpresa.getCodProducto1();
	}

	/**
	* Sets the cod producto1 of this auditoria caja sorpresa.
	*
	* @param codProducto1 the cod producto1 of this auditoria caja sorpresa
	*/
	public void setCodProducto1(java.lang.String codProducto1) {
		_auditoriaCajaSorpresa.setCodProducto1(codProducto1);
	}

	/**
	* Returns the cod producto2 of this auditoria caja sorpresa.
	*
	* @return the cod producto2 of this auditoria caja sorpresa
	*/
	public java.lang.String getCodProducto2() {
		return _auditoriaCajaSorpresa.getCodProducto2();
	}

	/**
	* Sets the cod producto2 of this auditoria caja sorpresa.
	*
	* @param codProducto2 the cod producto2 of this auditoria caja sorpresa
	*/
	public void setCodProducto2(java.lang.String codProducto2) {
		_auditoriaCajaSorpresa.setCodProducto2(codProducto2);
	}

	/**
	* Returns the cod producto3 of this auditoria caja sorpresa.
	*
	* @return the cod producto3 of this auditoria caja sorpresa
	*/
	public java.lang.String getCodProducto3() {
		return _auditoriaCajaSorpresa.getCodProducto3();
	}

	/**
	* Sets the cod producto3 of this auditoria caja sorpresa.
	*
	* @param codProducto3 the cod producto3 of this auditoria caja sorpresa
	*/
	public void setCodProducto3(java.lang.String codProducto3) {
		_auditoriaCajaSorpresa.setCodProducto3(codProducto3);
	}

	/**
	* Returns the cod producto4 of this auditoria caja sorpresa.
	*
	* @return the cod producto4 of this auditoria caja sorpresa
	*/
	public java.lang.String getCodProducto4() {
		return _auditoriaCajaSorpresa.getCodProducto4();
	}

	/**
	* Sets the cod producto4 of this auditoria caja sorpresa.
	*
	* @param codProducto4 the cod producto4 of this auditoria caja sorpresa
	*/
	public void setCodProducto4(java.lang.String codProducto4) {
		_auditoriaCajaSorpresa.setCodProducto4(codProducto4);
	}

	/**
	* Returns the i p of this auditoria caja sorpresa.
	*
	* @return the i p of this auditoria caja sorpresa
	*/
	public java.lang.String getIP() {
		return _auditoriaCajaSorpresa.getIP();
	}

	/**
	* Sets the i p of this auditoria caja sorpresa.
	*
	* @param IP the i p of this auditoria caja sorpresa
	*/
	public void setIP(java.lang.String IP) {
		_auditoriaCajaSorpresa.setIP(IP);
	}

	/**
	* Returns the session of this auditoria caja sorpresa.
	*
	* @return the session of this auditoria caja sorpresa
	*/
	public java.lang.String getSession() {
		return _auditoriaCajaSorpresa.getSession();
	}

	/**
	* Sets the session of this auditoria caja sorpresa.
	*
	* @param session the session of this auditoria caja sorpresa
	*/
	public void setSession(java.lang.String session) {
		_auditoriaCajaSorpresa.setSession(session);
	}

	/**
	* Returns the fecha hora of this auditoria caja sorpresa.
	*
	* @return the fecha hora of this auditoria caja sorpresa
	*/
	public java.util.Date getFechaHora() {
		return _auditoriaCajaSorpresa.getFechaHora();
	}

	/**
	* Sets the fecha hora of this auditoria caja sorpresa.
	*
	* @param fechaHora the fecha hora of this auditoria caja sorpresa
	*/
	public void setFechaHora(java.util.Date fechaHora) {
		_auditoriaCajaSorpresa.setFechaHora(fechaHora);
	}

	/**
	* Returns the u t m source of this auditoria caja sorpresa.
	*
	* @return the u t m source of this auditoria caja sorpresa
	*/
	public java.lang.String getUTMSource() {
		return _auditoriaCajaSorpresa.getUTMSource();
	}

	/**
	* Sets the u t m source of this auditoria caja sorpresa.
	*
	* @param UTMSource the u t m source of this auditoria caja sorpresa
	*/
	public void setUTMSource(java.lang.String UTMSource) {
		_auditoriaCajaSorpresa.setUTMSource(UTMSource);
	}

	/**
	* Returns the u t m medium of this auditoria caja sorpresa.
	*
	* @return the u t m medium of this auditoria caja sorpresa
	*/
	public java.lang.String getUTMMedium() {
		return _auditoriaCajaSorpresa.getUTMMedium();
	}

	/**
	* Sets the u t m medium of this auditoria caja sorpresa.
	*
	* @param UTMMedium the u t m medium of this auditoria caja sorpresa
	*/
	public void setUTMMedium(java.lang.String UTMMedium) {
		_auditoriaCajaSorpresa.setUTMMedium(UTMMedium);
	}

	/**
	* Returns the u t m campaing of this auditoria caja sorpresa.
	*
	* @return the u t m campaing of this auditoria caja sorpresa
	*/
	public java.lang.String getUTMCampaing() {
		return _auditoriaCajaSorpresa.getUTMCampaing();
	}

	/**
	* Sets the u t m campaing of this auditoria caja sorpresa.
	*
	* @param UTMCampaing the u t m campaing of this auditoria caja sorpresa
	*/
	public void setUTMCampaing(java.lang.String UTMCampaing) {
		_auditoriaCajaSorpresa.setUTMCampaing(UTMCampaing);
	}

	/**
	* Returns the u t m content of this auditoria caja sorpresa.
	*
	* @return the u t m content of this auditoria caja sorpresa
	*/
	public java.lang.String getUTMContent() {
		return _auditoriaCajaSorpresa.getUTMContent();
	}

	/**
	* Sets the u t m content of this auditoria caja sorpresa.
	*
	* @param UTMContent the u t m content of this auditoria caja sorpresa
	*/
	public void setUTMContent(java.lang.String UTMContent) {
		_auditoriaCajaSorpresa.setUTMContent(UTMContent);
	}

	public boolean isNew() {
		return _auditoriaCajaSorpresa.isNew();
	}

	public void setNew(boolean n) {
		_auditoriaCajaSorpresa.setNew(n);
	}

	public boolean isCachedModel() {
		return _auditoriaCajaSorpresa.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_auditoriaCajaSorpresa.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _auditoriaCajaSorpresa.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _auditoriaCajaSorpresa.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_auditoriaCajaSorpresa.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _auditoriaCajaSorpresa.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_auditoriaCajaSorpresa.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuditoriaCajaSorpresaWrapper((AuditoriaCajaSorpresa)_auditoriaCajaSorpresa.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		return _auditoriaCajaSorpresa.compareTo(auditoriaCajaSorpresa);
	}

	@Override
	public int hashCode() {
		return _auditoriaCajaSorpresa.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> toCacheModel() {
		return _auditoriaCajaSorpresa.toCacheModel();
	}

	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa toEscapedModel() {
		return new AuditoriaCajaSorpresaWrapper(_auditoriaCajaSorpresa.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _auditoriaCajaSorpresa.toString();
	}

	public java.lang.String toXmlString() {
		return _auditoriaCajaSorpresa.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_auditoriaCajaSorpresa.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AuditoriaCajaSorpresa getWrappedAuditoriaCajaSorpresa() {
		return _auditoriaCajaSorpresa;
	}

	public AuditoriaCajaSorpresa getWrappedModel() {
		return _auditoriaCajaSorpresa;
	}

	public void resetOriginalValues() {
		_auditoriaCajaSorpresa.resetOriginalValues();
	}

	private AuditoriaCajaSorpresa _auditoriaCajaSorpresa;
}