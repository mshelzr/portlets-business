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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TelefonoSolicitudProducto}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       TelefonoSolicitudProducto
 * @generated
 */
public class TelefonoSolicitudProductoWrapper
	implements TelefonoSolicitudProducto,
		ModelWrapper<TelefonoSolicitudProducto> {
	public TelefonoSolicitudProductoWrapper(
		TelefonoSolicitudProducto telefonoSolicitudProducto) {
		_telefonoSolicitudProducto = telefonoSolicitudProducto;
	}

	public Class<?> getModelClass() {
		return TelefonoSolicitudProducto.class;
	}

	public String getModelClassName() {
		return TelefonoSolicitudProducto.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idTelefSolicitudProducto", getIdTelefSolicitudProducto());
		attributes.put("idSolicitudProducto", getIdSolicitudProducto());
		attributes.put("tipoTelefono", getTipoTelefono());
		attributes.put("numeroTelefono", getNumeroTelefono());
		attributes.put("anexo", getAnexo());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idTelefSolicitudProducto = (Long)attributes.get(
				"idTelefSolicitudProducto");

		if (idTelefSolicitudProducto != null) {
			setIdTelefSolicitudProducto(idTelefSolicitudProducto);
		}

		Long idSolicitudProducto = (Long)attributes.get("idSolicitudProducto");

		if (idSolicitudProducto != null) {
			setIdSolicitudProducto(idSolicitudProducto);
		}

		String tipoTelefono = (String)attributes.get("tipoTelefono");

		if (tipoTelefono != null) {
			setTipoTelefono(tipoTelefono);
		}

		String numeroTelefono = (String)attributes.get("numeroTelefono");

		if (numeroTelefono != null) {
			setNumeroTelefono(numeroTelefono);
		}

		String anexo = (String)attributes.get("anexo");

		if (anexo != null) {
			setAnexo(anexo);
		}
	}

	/**
	* Returns the primary key of this telefono solicitud producto.
	*
	* @return the primary key of this telefono solicitud producto
	*/
	public long getPrimaryKey() {
		return _telefonoSolicitudProducto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this telefono solicitud producto.
	*
	* @param primaryKey the primary key of this telefono solicitud producto
	*/
	public void setPrimaryKey(long primaryKey) {
		_telefonoSolicitudProducto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id telef solicitud producto of this telefono solicitud producto.
	*
	* @return the id telef solicitud producto of this telefono solicitud producto
	*/
	public long getIdTelefSolicitudProducto() {
		return _telefonoSolicitudProducto.getIdTelefSolicitudProducto();
	}

	/**
	* Sets the id telef solicitud producto of this telefono solicitud producto.
	*
	* @param idTelefSolicitudProducto the id telef solicitud producto of this telefono solicitud producto
	*/
	public void setIdTelefSolicitudProducto(long idTelefSolicitudProducto) {
		_telefonoSolicitudProducto.setIdTelefSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Returns the id solicitud producto of this telefono solicitud producto.
	*
	* @return the id solicitud producto of this telefono solicitud producto
	*/
	public long getIdSolicitudProducto() {
		return _telefonoSolicitudProducto.getIdSolicitudProducto();
	}

	/**
	* Sets the id solicitud producto of this telefono solicitud producto.
	*
	* @param idSolicitudProducto the id solicitud producto of this telefono solicitud producto
	*/
	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_telefonoSolicitudProducto.setIdSolicitudProducto(idSolicitudProducto);
	}

	/**
	* Returns the tipo telefono of this telefono solicitud producto.
	*
	* @return the tipo telefono of this telefono solicitud producto
	*/
	public java.lang.String getTipoTelefono() {
		return _telefonoSolicitudProducto.getTipoTelefono();
	}

	/**
	* Sets the tipo telefono of this telefono solicitud producto.
	*
	* @param tipoTelefono the tipo telefono of this telefono solicitud producto
	*/
	public void setTipoTelefono(java.lang.String tipoTelefono) {
		_telefonoSolicitudProducto.setTipoTelefono(tipoTelefono);
	}

	/**
	* Returns the numero telefono of this telefono solicitud producto.
	*
	* @return the numero telefono of this telefono solicitud producto
	*/
	public java.lang.String getNumeroTelefono() {
		return _telefonoSolicitudProducto.getNumeroTelefono();
	}

	/**
	* Sets the numero telefono of this telefono solicitud producto.
	*
	* @param numeroTelefono the numero telefono of this telefono solicitud producto
	*/
	public void setNumeroTelefono(java.lang.String numeroTelefono) {
		_telefonoSolicitudProducto.setNumeroTelefono(numeroTelefono);
	}

	/**
	* Returns the anexo of this telefono solicitud producto.
	*
	* @return the anexo of this telefono solicitud producto
	*/
	public java.lang.String getAnexo() {
		return _telefonoSolicitudProducto.getAnexo();
	}

	/**
	* Sets the anexo of this telefono solicitud producto.
	*
	* @param anexo the anexo of this telefono solicitud producto
	*/
	public void setAnexo(java.lang.String anexo) {
		_telefonoSolicitudProducto.setAnexo(anexo);
	}

	public boolean isNew() {
		return _telefonoSolicitudProducto.isNew();
	}

	public void setNew(boolean n) {
		_telefonoSolicitudProducto.setNew(n);
	}

	public boolean isCachedModel() {
		return _telefonoSolicitudProducto.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_telefonoSolicitudProducto.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _telefonoSolicitudProducto.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _telefonoSolicitudProducto.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_telefonoSolicitudProducto.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _telefonoSolicitudProducto.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_telefonoSolicitudProducto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TelefonoSolicitudProductoWrapper((TelefonoSolicitudProducto)_telefonoSolicitudProducto.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto) {
		return _telefonoSolicitudProducto.compareTo(telefonoSolicitudProducto);
	}

	@Override
	public int hashCode() {
		return _telefonoSolicitudProducto.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> toCacheModel() {
		return _telefonoSolicitudProducto.toCacheModel();
	}

	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto toEscapedModel() {
		return new TelefonoSolicitudProductoWrapper(_telefonoSolicitudProducto.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _telefonoSolicitudProducto.toString();
	}

	public java.lang.String toXmlString() {
		return _telefonoSolicitudProducto.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_telefonoSolicitudProducto.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public TelefonoSolicitudProducto getWrappedTelefonoSolicitudProducto() {
		return _telefonoSolicitudProducto;
	}

	public TelefonoSolicitudProducto getWrappedModel() {
		return _telefonoSolicitudProducto;
	}

	public void resetOriginalValues() {
		_telefonoSolicitudProducto.resetOriginalValues();
	}

	private TelefonoSolicitudProducto _telefonoSolicitudProducto;
}