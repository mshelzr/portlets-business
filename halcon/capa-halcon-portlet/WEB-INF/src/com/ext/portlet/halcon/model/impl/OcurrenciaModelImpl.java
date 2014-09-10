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

package com.ext.portlet.halcon.model.impl;

import com.ext.portlet.halcon.model.Ocurrencia;
import com.ext.portlet.halcon.model.OcurrenciaModel;
import com.ext.portlet.halcon.model.OcurrenciaSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Ocurrencia service. Represents a row in the &quot;T_PETICION&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.halcon.model.OcurrenciaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link OcurrenciaImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see OcurrenciaImpl
 * @see com.ext.portlet.halcon.model.Ocurrencia
 * @see com.ext.portlet.halcon.model.OcurrenciaModel
 * @generated
 */
@JSON(strict = true)
public class OcurrenciaModelImpl extends BaseModelImpl<Ocurrencia>
	implements OcurrenciaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ocurrencia model instance should use the {@link com.ext.portlet.halcon.model.Ocurrencia} interface instead.
	 */
	public static final String TABLE_NAME = "T_PETICION";
	public static final Object[][] TABLE_COLUMNS = {
			{ "gepe_IdGestionPeticion", Types.BIGINT },
			{ "gepe_IP", Types.VARCHAR },
			{ "gepe_CodigoProducto", Types.VARCHAR },
			{ "gepe_fecha", Types.TIMESTAMP },
			{ "gepe_estado", Types.INTEGER },
			{ "gepe_ocurrencia", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table T_PETICION (gepe_IdGestionPeticion LONG not null primary key IDENTITY,gepe_IP VARCHAR(75) null,gepe_CodigoProducto VARCHAR(75) null,gepe_fecha DATE null,gepe_estado INTEGER,gepe_ocurrencia INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table T_PETICION";
	public static final String DATA_SOURCE = "halconDataSource";
	public static final String SESSION_FACTORY = "halconSessionFactory";
	public static final String TX_MANAGER = "halconTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.halcon.model.Ocurrencia"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.halcon.model.Ocurrencia"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Ocurrencia toModel(OcurrenciaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Ocurrencia model = new OcurrenciaImpl();

		model.setIdGestionPeticion(soapModel.getIdGestionPeticion());
		model.setIp(soapModel.getIp());
		model.setCodigoProducto(soapModel.getCodigoProducto());
		model.setFecha(soapModel.getFecha());
		model.setEstado(soapModel.getEstado());
		model.setOcurrencia(soapModel.getOcurrencia());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Ocurrencia> toModels(OcurrenciaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Ocurrencia> models = new ArrayList<Ocurrencia>(soapModels.length);

		for (OcurrenciaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.halcon.model.Ocurrencia"));

	public OcurrenciaModelImpl() {
	}

	public long getPrimaryKey() {
		return _idGestionPeticion;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdGestionPeticion(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idGestionPeticion);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return Ocurrencia.class;
	}

	public String getModelClassName() {
		return Ocurrencia.class.getName();
	}

	@Override
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

	@Override
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

	@JSON
	public long getIdGestionPeticion() {
		return _idGestionPeticion;
	}

	public void setIdGestionPeticion(long idGestionPeticion) {
		_idGestionPeticion = idGestionPeticion;
	}

	@JSON
	public String getIp() {
		if (_ip == null) {
			return StringPool.BLANK;
		}
		else {
			return _ip;
		}
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	@JSON
	public String getCodigoProducto() {
		if (_codigoProducto == null) {
			return StringPool.BLANK;
		}
		else {
			return _codigoProducto;
		}
	}

	public void setCodigoProducto(String codigoProducto) {
		_codigoProducto = codigoProducto;
	}

	@JSON
	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	@JSON
	public Integer getEstado() {
		return _estado;
	}

	public void setEstado(Integer estado) {
		_estado = estado;
	}

	@JSON
	public Integer getOcurrencia() {
		return _ocurrencia;
	}

	public void setOcurrencia(Integer ocurrencia) {
		_ocurrencia = ocurrencia;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Ocurrencia.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Ocurrencia toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (Ocurrencia)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		OcurrenciaImpl ocurrenciaImpl = new OcurrenciaImpl();

		ocurrenciaImpl.setIdGestionPeticion(getIdGestionPeticion());
		ocurrenciaImpl.setIp(getIp());
		ocurrenciaImpl.setCodigoProducto(getCodigoProducto());
		ocurrenciaImpl.setFecha(getFecha());
		ocurrenciaImpl.setEstado(getEstado());
		ocurrenciaImpl.setOcurrencia(getOcurrencia());

		ocurrenciaImpl.resetOriginalValues();

		return ocurrenciaImpl;
	}

	public int compareTo(Ocurrencia ocurrencia) {
		long primaryKey = ocurrencia.getPrimaryKey();

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

		Ocurrencia ocurrencia = null;

		try {
			ocurrencia = (Ocurrencia)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ocurrencia.getPrimaryKey();

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
	public CacheModel<Ocurrencia> toCacheModel() {
		OcurrenciaCacheModel ocurrenciaCacheModel = new OcurrenciaCacheModel();

		ocurrenciaCacheModel.idGestionPeticion = getIdGestionPeticion();

		ocurrenciaCacheModel.ip = getIp();

		String ip = ocurrenciaCacheModel.ip;

		if ((ip != null) && (ip.length() == 0)) {
			ocurrenciaCacheModel.ip = null;
		}

		ocurrenciaCacheModel.codigoProducto = getCodigoProducto();

		String codigoProducto = ocurrenciaCacheModel.codigoProducto;

		if ((codigoProducto != null) && (codigoProducto.length() == 0)) {
			ocurrenciaCacheModel.codigoProducto = null;
		}

		Date fecha = getFecha();

		if (fecha != null) {
			ocurrenciaCacheModel.fecha = fecha.getTime();
		}
		else {
			ocurrenciaCacheModel.fecha = Long.MIN_VALUE;
		}

		ocurrenciaCacheModel.estado = getEstado();

		ocurrenciaCacheModel.ocurrencia = getOcurrencia();

		return ocurrenciaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idGestionPeticion=");
		sb.append(getIdGestionPeticion());
		sb.append(", ip=");
		sb.append(getIp());
		sb.append(", codigoProducto=");
		sb.append(getCodigoProducto());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append(", estado=");
		sb.append(getEstado());
		sb.append(", ocurrencia=");
		sb.append(getOcurrencia());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.Ocurrencia");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idGestionPeticion</column-name><column-value><![CDATA[");
		sb.append(getIdGestionPeticion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip</column-name><column-value><![CDATA[");
		sb.append(getIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoProducto</column-name><column-value><![CDATA[");
		sb.append(getCodigoProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estado</column-name><column-value><![CDATA[");
		sb.append(getEstado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ocurrencia</column-name><column-value><![CDATA[");
		sb.append(getOcurrencia());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Ocurrencia.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			Ocurrencia.class
		};
	private long _idGestionPeticion;
	private String _ip;
	private String _codigoProducto;
	private Date _fecha;
	private Integer _estado;
	private Integer _ocurrencia;
	private Ocurrencia _escapedModelProxy;
}