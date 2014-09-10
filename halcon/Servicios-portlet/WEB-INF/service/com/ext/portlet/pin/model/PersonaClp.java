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

import com.ext.portlet.pin.service.PersonaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author arodriguez
 */
public class PersonaClp extends BaseModelImpl<Persona> implements Persona {
	public PersonaClp() {
	}

	public Class<?> getModelClass() {
		return Persona.class;
	}

	public String getModelClassName() {
		return Persona.class.getName();
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_userId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public String getNombres() {
		return _nombres;
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	public String getApellidoPaterno() {
		return _apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		_apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return _apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		_apellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return _dni;
	}

	public void setDni(String dni) {
		_dni = dni;
	}

	public int getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public BaseModel<?> getPersonaRemoteModel() {
		return _personaRemoteModel;
	}

	public void setPersonaRemoteModel(BaseModel<?> personaRemoteModel) {
		_personaRemoteModel = personaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PersonaLocalServiceUtil.addPersona(this);
		}
		else {
			PersonaLocalServiceUtil.updatePersona(this);
		}
	}

	@Override
	public Persona toEscapedModel() {
		return (Persona)Proxy.newProxyInstance(Persona.class.getClassLoader(),
			new Class[] { Persona.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PersonaClp clone = new PersonaClp();

		clone.setUserId(getUserId());
		clone.setNombres(getNombres());
		clone.setApellidoPaterno(getApellidoPaterno());
		clone.setApellidoMaterno(getApellidoMaterno());
		clone.setDni(getDni());
		clone.setTipoDocumento(getTipoDocumento());

		return clone;
	}

	public int compareTo(Persona persona) {
		long primaryKey = persona.getPrimaryKey();

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

		PersonaClp persona = null;

		try {
			persona = (PersonaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = persona.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{userId=");
		sb.append(getUserId());
		sb.append(", nombres=");
		sb.append(getNombres());
		sb.append(", apellidoPaterno=");
		sb.append(getApellidoPaterno());
		sb.append(", apellidoMaterno=");
		sb.append(getApellidoMaterno());
		sb.append(", dni=");
		sb.append(getDni());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.pin.model.Persona");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombres</column-name><column-value><![CDATA[");
		sb.append(getNombres());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidoPaterno</column-name><column-value><![CDATA[");
		sb.append(getApellidoPaterno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apellidoMaterno</column-name><column-value><![CDATA[");
		sb.append(getApellidoMaterno());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dni</column-name><column-value><![CDATA[");
		sb.append(getDni());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userId;
	private String _userUuid;
	private String _nombres;
	private String _apellidoPaterno;
	private String _apellidoMaterno;
	private String _dni;
	private int _tipoDocumento;
	private BaseModel<?> _personaRemoteModel;
}