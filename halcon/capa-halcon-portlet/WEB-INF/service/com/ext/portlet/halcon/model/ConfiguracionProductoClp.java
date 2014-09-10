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

import com.ext.portlet.halcon.service.ConfiguracionProductoLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class ConfiguracionProductoClp extends BaseModelImpl<ConfiguracionProducto>
	implements ConfiguracionProducto {
	public ConfiguracionProductoClp() {
	}

	public Class<?> getModelClass() {
		return ConfiguracionProducto.class;
	}

	public String getModelClassName() {
		return ConfiguracionProducto.class.getName();
	}

	public long getPrimaryKey() {
		return _idConfiguracionProducto;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdConfiguracionProducto(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idConfiguracionProducto);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idConfiguracionProducto", getIdConfiguracionProducto());
		attributes.put("idConfiguracionPerfilador",
			getIdConfiguracionPerfilador());
		attributes.put("idProducto", getIdProducto());
		attributes.put("nombreProducto", getNombreProducto());
		attributes.put("codigoSiebelProducto", getCodigoSiebelProducto());
		attributes.put("estadoConfiguracion", getEstadoConfiguracion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idConfiguracionProducto = (Long)attributes.get(
				"idConfiguracionProducto");

		if (idConfiguracionProducto != null) {
			setIdConfiguracionProducto(idConfiguracionProducto);
		}

		Long idConfiguracionPerfilador = (Long)attributes.get(
				"idConfiguracionPerfilador");

		if (idConfiguracionPerfilador != null) {
			setIdConfiguracionPerfilador(idConfiguracionPerfilador);
		}

		Long idProducto = (Long)attributes.get("idProducto");

		if (idProducto != null) {
			setIdProducto(idProducto);
		}

		String nombreProducto = (String)attributes.get("nombreProducto");

		if (nombreProducto != null) {
			setNombreProducto(nombreProducto);
		}

		String codigoSiebelProducto = (String)attributes.get(
				"codigoSiebelProducto");

		if (codigoSiebelProducto != null) {
			setCodigoSiebelProducto(codigoSiebelProducto);
		}

		Integer estadoConfiguracion = (Integer)attributes.get(
				"estadoConfiguracion");

		if (estadoConfiguracion != null) {
			setEstadoConfiguracion(estadoConfiguracion);
		}
	}

	public long getIdConfiguracionProducto() {
		return _idConfiguracionProducto;
	}

	public void setIdConfiguracionProducto(long idConfiguracionProducto) {
		_idConfiguracionProducto = idConfiguracionProducto;
	}

	public Long getIdConfiguracionPerfilador() {
		return _idConfiguracionPerfilador;
	}

	public void setIdConfiguracionPerfilador(Long idConfiguracionPerfilador) {
		_idConfiguracionPerfilador = idConfiguracionPerfilador;
	}

	public Long getIdProducto() {
		return _idProducto;
	}

	public void setIdProducto(Long idProducto) {
		_idProducto = idProducto;
	}

	public String getNombreProducto() {
		return _nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		_nombreProducto = nombreProducto;
	}

	public String getCodigoSiebelProducto() {
		return _codigoSiebelProducto;
	}

	public void setCodigoSiebelProducto(String codigoSiebelProducto) {
		_codigoSiebelProducto = codigoSiebelProducto;
	}

	public Integer getEstadoConfiguracion() {
		return _estadoConfiguracion;
	}

	public void setEstadoConfiguracion(Integer estadoConfiguracion) {
		_estadoConfiguracion = estadoConfiguracion;
	}

	public BaseModel<?> getConfiguracionProductoRemoteModel() {
		return _configuracionProductoRemoteModel;
	}

	public void setConfiguracionProductoRemoteModel(
		BaseModel<?> configuracionProductoRemoteModel) {
		_configuracionProductoRemoteModel = configuracionProductoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ConfiguracionProductoLocalServiceUtil.addConfiguracionProducto(this);
		}
		else {
			ConfiguracionProductoLocalServiceUtil.updateConfiguracionProducto(this);
		}
	}

	@Override
	public ConfiguracionProducto toEscapedModel() {
		return (ConfiguracionProducto)Proxy.newProxyInstance(ConfiguracionProducto.class.getClassLoader(),
			new Class[] { ConfiguracionProducto.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConfiguracionProductoClp clone = new ConfiguracionProductoClp();

		clone.setIdConfiguracionProducto(getIdConfiguracionProducto());
		clone.setIdConfiguracionPerfilador(getIdConfiguracionPerfilador());
		clone.setIdProducto(getIdProducto());
		clone.setNombreProducto(getNombreProducto());
		clone.setCodigoSiebelProducto(getCodigoSiebelProducto());
		clone.setEstadoConfiguracion(getEstadoConfiguracion());

		return clone;
	}

	public int compareTo(ConfiguracionProducto configuracionProducto) {
		long primaryKey = configuracionProducto.getPrimaryKey();

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

		ConfiguracionProductoClp configuracionProducto = null;

		try {
			configuracionProducto = (ConfiguracionProductoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = configuracionProducto.getPrimaryKey();

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

		sb.append("{idConfiguracionProducto=");
		sb.append(getIdConfiguracionProducto());
		sb.append(", idConfiguracionPerfilador=");
		sb.append(getIdConfiguracionPerfilador());
		sb.append(", idProducto=");
		sb.append(getIdProducto());
		sb.append(", nombreProducto=");
		sb.append(getNombreProducto());
		sb.append(", codigoSiebelProducto=");
		sb.append(getCodigoSiebelProducto());
		sb.append(", estadoConfiguracion=");
		sb.append(getEstadoConfiguracion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.ConfiguracionProducto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idConfiguracionProducto</column-name><column-value><![CDATA[");
		sb.append(getIdConfiguracionProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idConfiguracionPerfilador</column-name><column-value><![CDATA[");
		sb.append(getIdConfiguracionPerfilador());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idProducto</column-name><column-value><![CDATA[");
		sb.append(getIdProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombreProducto</column-name><column-value><![CDATA[");
		sb.append(getNombreProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoSiebelProducto</column-name><column-value><![CDATA[");
		sb.append(getCodigoSiebelProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estadoConfiguracion</column-name><column-value><![CDATA[");
		sb.append(getEstadoConfiguracion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idConfiguracionProducto;
	private Long _idConfiguracionPerfilador;
	private Long _idProducto;
	private String _nombreProducto;
	private String _codigoSiebelProducto;
	private Integer _estadoConfiguracion;
	private BaseModel<?> _configuracionProductoRemoteModel;
}