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

package com.ext.portlet.pin.model.impl;

import com.ext.portlet.pin.model.Persona;
import com.ext.portlet.pin.model.PersonaModel;
import com.ext.portlet.pin.model.PersonaSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Persona service. Represents a row in the &quot;Persona&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.pin.model.PersonaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PersonaImpl}.
 * </p>
 *
 * @author arodriguez
 * @see PersonaImpl
 * @see com.ext.portlet.pin.model.Persona
 * @see com.ext.portlet.pin.model.PersonaModel
 * @generated
 */
@JSON(strict = true)
public class PersonaModelImpl extends BaseModelImpl<Persona>
	implements PersonaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a persona model instance should use the {@link com.ext.portlet.pin.model.Persona} interface instead.
	 */
	public static final String TABLE_NAME = "Persona";
	public static final Object[][] TABLE_COLUMNS = {
			{ "Userid", Types.BIGINT },
			{ "Nombres", Types.VARCHAR },
			{ "Apellido_Paterno", Types.VARCHAR },
			{ "Apellido_Materno", Types.VARCHAR },
			{ "DNI", Types.VARCHAR },
			{ "Tipo_Documento", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table Persona (Userid LONG not null primary key,Nombres VARCHAR(75) null,Apellido_Paterno VARCHAR(75) null,Apellido_Materno VARCHAR(75) null,DNI VARCHAR(75) null,Tipo_Documento INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table Persona";
	public static final String DATA_SOURCE = "pinDataSource";
	public static final String SESSION_FACTORY = "pinSessionFactory";
	public static final String TX_MANAGER = "pinTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.pin.model.Persona"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.pin.model.Persona"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Persona toModel(PersonaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Persona model = new PersonaImpl();

		model.setUserId(soapModel.getUserId());
		model.setNombres(soapModel.getNombres());
		model.setApellidoPaterno(soapModel.getApellidoPaterno());
		model.setApellidoMaterno(soapModel.getApellidoMaterno());
		model.setDni(soapModel.getDni());
		model.setTipoDocumento(soapModel.getTipoDocumento());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Persona> toModels(PersonaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Persona> models = new ArrayList<Persona>(soapModels.length);

		for (PersonaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.pin.model.Persona"));

	public PersonaModelImpl() {
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

	public Class<?> getModelClass() {
		return Persona.class;
	}

	public String getModelClassName() {
		return Persona.class.getName();
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

	@JSON
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

	@JSON
	public String getNombres() {
		if (_nombres == null) {
			return StringPool.BLANK;
		}
		else {
			return _nombres;
		}
	}

	public void setNombres(String nombres) {
		_nombres = nombres;
	}

	@JSON
	public String getApellidoPaterno() {
		if (_apellidoPaterno == null) {
			return StringPool.BLANK;
		}
		else {
			return _apellidoPaterno;
		}
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		_apellidoPaterno = apellidoPaterno;
	}

	@JSON
	public String getApellidoMaterno() {
		if (_apellidoMaterno == null) {
			return StringPool.BLANK;
		}
		else {
			return _apellidoMaterno;
		}
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		_apellidoMaterno = apellidoMaterno;
	}

	@JSON
	public String getDni() {
		if (_dni == null) {
			return StringPool.BLANK;
		}
		else {
			return _dni;
		}
	}

	public void setDni(String dni) {
		_dni = dni;
	}

	@JSON
	public int getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(int tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Persona.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Persona toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Persona)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		PersonaImpl personaImpl = new PersonaImpl();

		personaImpl.setUserId(getUserId());
		personaImpl.setNombres(getNombres());
		personaImpl.setApellidoPaterno(getApellidoPaterno());
		personaImpl.setApellidoMaterno(getApellidoMaterno());
		personaImpl.setDni(getDni());
		personaImpl.setTipoDocumento(getTipoDocumento());

		personaImpl.resetOriginalValues();

		return personaImpl;
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

		Persona persona = null;

		try {
			persona = (Persona)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Persona> toCacheModel() {
		PersonaCacheModel personaCacheModel = new PersonaCacheModel();

		personaCacheModel.userId = getUserId();

		personaCacheModel.nombres = getNombres();

		String nombres = personaCacheModel.nombres;

		if ((nombres != null) && (nombres.length() == 0)) {
			personaCacheModel.nombres = null;
		}

		personaCacheModel.apellidoPaterno = getApellidoPaterno();

		String apellidoPaterno = personaCacheModel.apellidoPaterno;

		if ((apellidoPaterno != null) && (apellidoPaterno.length() == 0)) {
			personaCacheModel.apellidoPaterno = null;
		}

		personaCacheModel.apellidoMaterno = getApellidoMaterno();

		String apellidoMaterno = personaCacheModel.apellidoMaterno;

		if ((apellidoMaterno != null) && (apellidoMaterno.length() == 0)) {
			personaCacheModel.apellidoMaterno = null;
		}

		personaCacheModel.dni = getDni();

		String dni = personaCacheModel.dni;

		if ((dni != null) && (dni.length() == 0)) {
			personaCacheModel.dni = null;
		}

		personaCacheModel.tipoDocumento = getTipoDocumento();

		return personaCacheModel;
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

	private static ClassLoader _classLoader = Persona.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Persona.class
		};
	private long _userId;
	private String _userUuid;
	private String _nombres;
	private String _apellidoPaterno;
	private String _apellidoMaterno;
	private String _dni;
	private int _tipoDocumento;
	private Persona _escapedModelProxy;
}