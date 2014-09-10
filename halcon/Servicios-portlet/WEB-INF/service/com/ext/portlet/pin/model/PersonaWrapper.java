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

package com.ext.portlet.pin.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Persona}.
 * </p>
 *
 * @author    arodriguez
 * @see       Persona
 * @generated
 */
public class PersonaWrapper implements Persona, ModelWrapper<Persona> {
	public PersonaWrapper(Persona persona) {
		_persona = persona;
	}

	public Class<?> getModelClass() {
		return Persona.class;
	}

	public String getModelClassName() {
		return Persona.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("nombres", getNombres());
		attributes.put("apellidoPaterno", getApellidoPaterno());
		attributes.put("apellidoMaterno", getApellidoMaterno());
		attributes.put("dni", getDni());
		attributes.put("tipoDocumento", getTipoDocumento());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidoPaterno = (String)attributes.get("apellidoPaterno");

		if (apellidoPaterno != null) {
			setApellidoPaterno(apellidoPaterno);
		}

		String apellidoMaterno = (String)attributes.get("apellidoMaterno");

		if (apellidoMaterno != null) {
			setApellidoMaterno(apellidoMaterno);
		}

		String dni = (String)attributes.get("dni");

		if (dni != null) {
			setDni(dni);
		}

		Integer tipoDocumento = (Integer)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}
	}

	/**
	* Returns the primary key of this persona.
	*
	* @return the primary key of this persona
	*/
	public long getPrimaryKey() {
		return _persona.getPrimaryKey();
	}

	/**
	* Sets the primary key of this persona.
	*
	* @param primaryKey the primary key of this persona
	*/
	public void setPrimaryKey(long primaryKey) {
		_persona.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user ID of this persona.
	*
	* @return the user ID of this persona
	*/
	public long getUserId() {
		return _persona.getUserId();
	}

	/**
	* Sets the user ID of this persona.
	*
	* @param userId the user ID of this persona
	*/
	public void setUserId(long userId) {
		_persona.setUserId(userId);
	}

	/**
	* Returns the user uuid of this persona.
	*
	* @return the user uuid of this persona
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _persona.getUserUuid();
	}

	/**
	* Sets the user uuid of this persona.
	*
	* @param userUuid the user uuid of this persona
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_persona.setUserUuid(userUuid);
	}

	/**
	* Returns the nombres of this persona.
	*
	* @return the nombres of this persona
	*/
	public java.lang.String getNombres() {
		return _persona.getNombres();
	}

	/**
	* Sets the nombres of this persona.
	*
	* @param nombres the nombres of this persona
	*/
	public void setNombres(java.lang.String nombres) {
		_persona.setNombres(nombres);
	}

	/**
	* Returns the apellido paterno of this persona.
	*
	* @return the apellido paterno of this persona
	*/
	public java.lang.String getApellidoPaterno() {
		return _persona.getApellidoPaterno();
	}

	/**
	* Sets the apellido paterno of this persona.
	*
	* @param apellidoPaterno the apellido paterno of this persona
	*/
	public void setApellidoPaterno(java.lang.String apellidoPaterno) {
		_persona.setApellidoPaterno(apellidoPaterno);
	}

	/**
	* Returns the apellido materno of this persona.
	*
	* @return the apellido materno of this persona
	*/
	public java.lang.String getApellidoMaterno() {
		return _persona.getApellidoMaterno();
	}

	/**
	* Sets the apellido materno of this persona.
	*
	* @param apellidoMaterno the apellido materno of this persona
	*/
	public void setApellidoMaterno(java.lang.String apellidoMaterno) {
		_persona.setApellidoMaterno(apellidoMaterno);
	}

	/**
	* Returns the dni of this persona.
	*
	* @return the dni of this persona
	*/
	public java.lang.String getDni() {
		return _persona.getDni();
	}

	/**
	* Sets the dni of this persona.
	*
	* @param dni the dni of this persona
	*/
	public void setDni(java.lang.String dni) {
		_persona.setDni(dni);
	}

	/**
	* Returns the tipo documento of this persona.
	*
	* @return the tipo documento of this persona
	*/
	public int getTipoDocumento() {
		return _persona.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this persona.
	*
	* @param tipoDocumento the tipo documento of this persona
	*/
	public void setTipoDocumento(int tipoDocumento) {
		_persona.setTipoDocumento(tipoDocumento);
	}

	public boolean isNew() {
		return _persona.isNew();
	}

	public void setNew(boolean n) {
		_persona.setNew(n);
	}

	public boolean isCachedModel() {
		return _persona.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_persona.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _persona.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _persona.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_persona.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _persona.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_persona.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PersonaWrapper((Persona)_persona.clone());
	}

	public int compareTo(com.ext.portlet.pin.model.Persona persona) {
		return _persona.compareTo(persona);
	}

	@Override
	public int hashCode() {
		return _persona.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.pin.model.Persona> toCacheModel() {
		return _persona.toCacheModel();
	}

	public com.ext.portlet.pin.model.Persona toEscapedModel() {
		return new PersonaWrapper(_persona.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _persona.toString();
	}

	public java.lang.String toXmlString() {
		return _persona.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_persona.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Persona getWrappedPersona() {
		return _persona;
	}

	public Persona getWrappedModel() {
		return _persona;
	}

	public void resetOriginalValues() {
		_persona.resetOriginalValues();
	}

	private Persona _persona;
}