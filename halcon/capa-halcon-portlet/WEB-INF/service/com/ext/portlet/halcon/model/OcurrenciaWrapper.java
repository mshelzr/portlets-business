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
 * This class is a wrapper for {@link Ocurrencia}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       Ocurrencia
 * @generated
 */
public class OcurrenciaWrapper implements Ocurrencia, ModelWrapper<Ocurrencia> {
	public OcurrenciaWrapper(Ocurrencia ocurrencia) {
		_ocurrencia = ocurrencia;
	}

	public Class<?> getModelClass() {
		return Ocurrencia.class;
	}

	public String getModelClassName() {
		return Ocurrencia.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idGestionPeticion", getIdGestionPeticion());
		attributes.put("ip", getIp());
		attributes.put("codigoProducto", getCodigoProducto());
		attributes.put("fecha", getFecha());
		attributes.put("estado", getEstado());
		attributes.put("ocurrencia", getOcurrencia());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idGestionPeticion = (Long)attributes.get("idGestionPeticion");

		if (idGestionPeticion != null) {
			setIdGestionPeticion(idGestionPeticion);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		String codigoProducto = (String)attributes.get("codigoProducto");

		if (codigoProducto != null) {
			setCodigoProducto(codigoProducto);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		Integer estado = (Integer)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}

		Integer ocurrencia = (Integer)attributes.get("ocurrencia");

		if (ocurrencia != null) {
			setOcurrencia(ocurrencia);
		}
	}

	/**
	* Returns the primary key of this ocurrencia.
	*
	* @return the primary key of this ocurrencia
	*/
	public long getPrimaryKey() {
		return _ocurrencia.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ocurrencia.
	*
	* @param primaryKey the primary key of this ocurrencia
	*/
	public void setPrimaryKey(long primaryKey) {
		_ocurrencia.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id gestion peticion of this ocurrencia.
	*
	* @return the id gestion peticion of this ocurrencia
	*/
	public long getIdGestionPeticion() {
		return _ocurrencia.getIdGestionPeticion();
	}

	/**
	* Sets the id gestion peticion of this ocurrencia.
	*
	* @param idGestionPeticion the id gestion peticion of this ocurrencia
	*/
	public void setIdGestionPeticion(long idGestionPeticion) {
		_ocurrencia.setIdGestionPeticion(idGestionPeticion);
	}

	/**
	* Returns the ip of this ocurrencia.
	*
	* @return the ip of this ocurrencia
	*/
	public java.lang.String getIp() {
		return _ocurrencia.getIp();
	}

	/**
	* Sets the ip of this ocurrencia.
	*
	* @param ip the ip of this ocurrencia
	*/
	public void setIp(java.lang.String ip) {
		_ocurrencia.setIp(ip);
	}

	/**
	* Returns the codigo producto of this ocurrencia.
	*
	* @return the codigo producto of this ocurrencia
	*/
	public java.lang.String getCodigoProducto() {
		return _ocurrencia.getCodigoProducto();
	}

	/**
	* Sets the codigo producto of this ocurrencia.
	*
	* @param codigoProducto the codigo producto of this ocurrencia
	*/
	public void setCodigoProducto(java.lang.String codigoProducto) {
		_ocurrencia.setCodigoProducto(codigoProducto);
	}

	/**
	* Returns the fecha of this ocurrencia.
	*
	* @return the fecha of this ocurrencia
	*/
	public java.util.Date getFecha() {
		return _ocurrencia.getFecha();
	}

	/**
	* Sets the fecha of this ocurrencia.
	*
	* @param fecha the fecha of this ocurrencia
	*/
	public void setFecha(java.util.Date fecha) {
		_ocurrencia.setFecha(fecha);
	}

	/**
	* Returns the estado of this ocurrencia.
	*
	* @return the estado of this ocurrencia
	*/
	public java.lang.Integer getEstado() {
		return _ocurrencia.getEstado();
	}

	/**
	* Sets the estado of this ocurrencia.
	*
	* @param estado the estado of this ocurrencia
	*/
	public void setEstado(java.lang.Integer estado) {
		_ocurrencia.setEstado(estado);
	}

	/**
	* Returns the ocurrencia of this ocurrencia.
	*
	* @return the ocurrencia of this ocurrencia
	*/
	public java.lang.Integer getOcurrencia() {
		return _ocurrencia.getOcurrencia();
	}

	/**
	* Sets the ocurrencia of this ocurrencia.
	*
	* @param ocurrencia the ocurrencia of this ocurrencia
	*/
	public void setOcurrencia(java.lang.Integer ocurrencia) {
		_ocurrencia.setOcurrencia(ocurrencia);
	}

	public boolean isNew() {
		return _ocurrencia.isNew();
	}

	public void setNew(boolean n) {
		_ocurrencia.setNew(n);
	}

	public boolean isCachedModel() {
		return _ocurrencia.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ocurrencia.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ocurrencia.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ocurrencia.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ocurrencia.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ocurrencia.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ocurrencia.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OcurrenciaWrapper((Ocurrencia)_ocurrencia.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.Ocurrencia ocurrencia) {
		return _ocurrencia.compareTo(ocurrencia);
	}

	@Override
	public int hashCode() {
		return _ocurrencia.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.Ocurrencia> toCacheModel() {
		return _ocurrencia.toCacheModel();
	}

	public com.ext.portlet.halcon.model.Ocurrencia toEscapedModel() {
		return new OcurrenciaWrapper(_ocurrencia.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ocurrencia.toString();
	}

	public java.lang.String toXmlString() {
		return _ocurrencia.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ocurrencia.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Ocurrencia getWrappedOcurrencia() {
		return _ocurrencia;
	}

	public Ocurrencia getWrappedModel() {
		return _ocurrencia;
	}

	public void resetOriginalValues() {
		_ocurrencia.resetOriginalValues();
	}

	private Ocurrencia _ocurrencia;
}