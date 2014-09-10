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

import com.ext.portlet.halcon.service.OcurrenciaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class OcurrenciaClp extends BaseModelImpl<Ocurrencia>
	implements Ocurrencia {
	public OcurrenciaClp() {
	}

	public Class<?> getModelClass() {
		return Ocurrencia.class;
	}

	public String getModelClassName() {
		return Ocurrencia.class.getName();
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

	public long getIdGestionPeticion() {
		return _idGestionPeticion;
	}

	public void setIdGestionPeticion(long idGestionPeticion) {
		_idGestionPeticion = idGestionPeticion;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public String getCodigoProducto() {
		return _codigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		_codigoProducto = codigoProducto;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public Integer getEstado() {
		return _estado;
	}

	public void setEstado(Integer estado) {
		_estado = estado;
	}

	public Integer getOcurrencia() {
		return _ocurrencia;
	}

	public void setOcurrencia(Integer ocurrencia) {
		_ocurrencia = ocurrencia;
	}

	public BaseModel<?> getOcurrenciaRemoteModel() {
		return _ocurrenciaRemoteModel;
	}

	public void setOcurrenciaRemoteModel(BaseModel<?> ocurrenciaRemoteModel) {
		_ocurrenciaRemoteModel = ocurrenciaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			OcurrenciaLocalServiceUtil.addOcurrencia(this);
		}
		else {
			OcurrenciaLocalServiceUtil.updateOcurrencia(this);
		}
	}

	@Override
	public Ocurrencia toEscapedModel() {
		return (Ocurrencia)Proxy.newProxyInstance(Ocurrencia.class.getClassLoader(),
			new Class[] { Ocurrencia.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OcurrenciaClp clone = new OcurrenciaClp();

		clone.setIdGestionPeticion(getIdGestionPeticion());
		clone.setIp(getIp());
		clone.setCodigoProducto(getCodigoProducto());
		clone.setFecha(getFecha());
		clone.setEstado(getEstado());
		clone.setOcurrencia(getOcurrencia());

		return clone;
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

		OcurrenciaClp ocurrencia = null;

		try {
			ocurrencia = (OcurrenciaClp)obj;
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

	private long _idGestionPeticion;
	private String _ip;
	private String _codigoProducto;
	private Date _fecha;
	private Integer _estado;
	private Integer _ocurrencia;
	private BaseModel<?> _ocurrenciaRemoteModel;
}