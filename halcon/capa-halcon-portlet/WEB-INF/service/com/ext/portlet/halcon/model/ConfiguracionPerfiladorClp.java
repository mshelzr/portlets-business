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

import com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil;

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
public class ConfiguracionPerfiladorClp extends BaseModelImpl<ConfiguracionPerfilador>
	implements ConfiguracionPerfilador {
	public ConfiguracionPerfiladorClp() {
	}

	public Class<?> getModelClass() {
		return ConfiguracionPerfilador.class;
	}

	public String getModelClassName() {
		return ConfiguracionPerfilador.class.getName();
	}

	public long getPrimaryKey() {
		return _idConfiguracionPerfilador;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdConfiguracionPerfilador(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idConfiguracionPerfilador);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idConfiguracionPerfilador",
			getIdConfiguracionPerfilador());
		attributes.put("tipoVariable", getTipoVariable());
		attributes.put("nombreVariable", getNombreVariable());
		attributes.put("codigoClasificacion", getCodigoClasificacion());
		attributes.put("codigoVariablePadre", getCodigoVariablePadre());
		attributes.put("valor1", getValor1());
		attributes.put("valor2", getValor2());
		attributes.put("valor3", getValor3());
		attributes.put("estado", getEstado());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idConfiguracionPerfilador = (Long)attributes.get(
				"idConfiguracionPerfilador");

		if (idConfiguracionPerfilador != null) {
			setIdConfiguracionPerfilador(idConfiguracionPerfilador);
		}

		Long tipoVariable = (Long)attributes.get("tipoVariable");

		if (tipoVariable != null) {
			setTipoVariable(tipoVariable);
		}

		String nombreVariable = (String)attributes.get("nombreVariable");

		if (nombreVariable != null) {
			setNombreVariable(nombreVariable);
		}

		Long codigoClasificacion = (Long)attributes.get("codigoClasificacion");

		if (codigoClasificacion != null) {
			setCodigoClasificacion(codigoClasificacion);
		}

		Long codigoVariablePadre = (Long)attributes.get("codigoVariablePadre");

		if (codigoVariablePadre != null) {
			setCodigoVariablePadre(codigoVariablePadre);
		}

		String valor1 = (String)attributes.get("valor1");

		if (valor1 != null) {
			setValor1(valor1);
		}

		String valor2 = (String)attributes.get("valor2");

		if (valor2 != null) {
			setValor2(valor2);
		}

		String valor3 = (String)attributes.get("valor3");

		if (valor3 != null) {
			setValor3(valor3);
		}

		Integer estado = (Integer)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	public long getIdConfiguracionPerfilador() {
		return _idConfiguracionPerfilador;
	}

	public void setIdConfiguracionPerfilador(long idConfiguracionPerfilador) {
		_idConfiguracionPerfilador = idConfiguracionPerfilador;
	}

	public Long getTipoVariable() {
		return _tipoVariable;
	}

	public void setTipoVariable(Long tipoVariable) {
		_tipoVariable = tipoVariable;
	}

	public String getNombreVariable() {
		return _nombreVariable;
	}

	public void setNombreVariable(String nombreVariable) {
		_nombreVariable = nombreVariable;
	}

	public Long getCodigoClasificacion() {
		return _codigoClasificacion;
	}

	public void setCodigoClasificacion(Long codigoClasificacion) {
		_codigoClasificacion = codigoClasificacion;
	}

	public Long getCodigoVariablePadre() {
		return _codigoVariablePadre;
	}

	public void setCodigoVariablePadre(Long codigoVariablePadre) {
		_codigoVariablePadre = codigoVariablePadre;
	}

	public String getValor1() {
		return _valor1;
	}

	public void setValor1(String valor1) {
		_valor1 = valor1;
	}

	public String getValor2() {
		return _valor2;
	}

	public void setValor2(String valor2) {
		_valor2 = valor2;
	}

	public String getValor3() {
		return _valor3;
	}

	public void setValor3(String valor3) {
		_valor3 = valor3;
	}

	public Integer getEstado() {
		return _estado;
	}

	public void setEstado(Integer estado) {
		_estado = estado;
	}

	public BaseModel<?> getConfiguracionPerfiladorRemoteModel() {
		return _configuracionPerfiladorRemoteModel;
	}

	public void setConfiguracionPerfiladorRemoteModel(
		BaseModel<?> configuracionPerfiladorRemoteModel) {
		_configuracionPerfiladorRemoteModel = configuracionPerfiladorRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ConfiguracionPerfiladorLocalServiceUtil.addConfiguracionPerfilador(this);
		}
		else {
			ConfiguracionPerfiladorLocalServiceUtil.updateConfiguracionPerfilador(this);
		}
	}

	@Override
	public ConfiguracionPerfilador toEscapedModel() {
		return (ConfiguracionPerfilador)Proxy.newProxyInstance(ConfiguracionPerfilador.class.getClassLoader(),
			new Class[] { ConfiguracionPerfilador.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ConfiguracionPerfiladorClp clone = new ConfiguracionPerfiladorClp();

		clone.setIdConfiguracionPerfilador(getIdConfiguracionPerfilador());
		clone.setTipoVariable(getTipoVariable());
		clone.setNombreVariable(getNombreVariable());
		clone.setCodigoClasificacion(getCodigoClasificacion());
		clone.setCodigoVariablePadre(getCodigoVariablePadre());
		clone.setValor1(getValor1());
		clone.setValor2(getValor2());
		clone.setValor3(getValor3());
		clone.setEstado(getEstado());

		return clone;
	}

	public int compareTo(ConfiguracionPerfilador configuracionPerfilador) {
		long primaryKey = configuracionPerfilador.getPrimaryKey();

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

		ConfiguracionPerfiladorClp configuracionPerfilador = null;

		try {
			configuracionPerfilador = (ConfiguracionPerfiladorClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = configuracionPerfilador.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{idConfiguracionPerfilador=");
		sb.append(getIdConfiguracionPerfilador());
		sb.append(", tipoVariable=");
		sb.append(getTipoVariable());
		sb.append(", nombreVariable=");
		sb.append(getNombreVariable());
		sb.append(", codigoClasificacion=");
		sb.append(getCodigoClasificacion());
		sb.append(", codigoVariablePadre=");
		sb.append(getCodigoVariablePadre());
		sb.append(", valor1=");
		sb.append(getValor1());
		sb.append(", valor2=");
		sb.append(getValor2());
		sb.append(", valor3=");
		sb.append(getValor3());
		sb.append(", estado=");
		sb.append(getEstado());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.ConfiguracionPerfilador");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idConfiguracionPerfilador</column-name><column-value><![CDATA[");
		sb.append(getIdConfiguracionPerfilador());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoVariable</column-name><column-value><![CDATA[");
		sb.append(getTipoVariable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombreVariable</column-name><column-value><![CDATA[");
		sb.append(getNombreVariable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoClasificacion</column-name><column-value><![CDATA[");
		sb.append(getCodigoClasificacion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoVariablePadre</column-name><column-value><![CDATA[");
		sb.append(getCodigoVariablePadre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valor1</column-name><column-value><![CDATA[");
		sb.append(getValor1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valor2</column-name><column-value><![CDATA[");
		sb.append(getValor2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valor3</column-name><column-value><![CDATA[");
		sb.append(getValor3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estado</column-name><column-value><![CDATA[");
		sb.append(getEstado());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idConfiguracionPerfilador;
	private Long _tipoVariable;
	private String _nombreVariable;
	private Long _codigoClasificacion;
	private Long _codigoVariablePadre;
	private String _valor1;
	private String _valor2;
	private String _valor3;
	private Integer _estado;
	private BaseModel<?> _configuracionPerfiladorRemoteModel;
}