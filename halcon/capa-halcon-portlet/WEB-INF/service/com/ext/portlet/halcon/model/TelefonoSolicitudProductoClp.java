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

import com.ext.portlet.halcon.service.TelefonoSolicitudProductoLocalServiceUtil;

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
public class TelefonoSolicitudProductoClp extends BaseModelImpl<TelefonoSolicitudProducto>
	implements TelefonoSolicitudProducto {
	public TelefonoSolicitudProductoClp() {
	}

	public Class<?> getModelClass() {
		return TelefonoSolicitudProducto.class;
	}

	public String getModelClassName() {
		return TelefonoSolicitudProducto.class.getName();
	}

	public long getPrimaryKey() {
		return _idTelefSolicitudProducto;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdTelefSolicitudProducto(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idTelefSolicitudProducto);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idTelefSolicitudProducto", getIdTelefSolicitudProducto());
		attributes.put("idSolicitudProducto", getIdSolicitudProducto());
		attributes.put("tipoTelefono", getTipoTelefono());
		attributes.put("numeroTelefono", getNumeroTelefono());
		attributes.put("anexo", getAnexo());

		return attributes;
	}

	@Override
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

	public long getIdTelefSolicitudProducto() {
		return _idTelefSolicitudProducto;
	}

	public void setIdTelefSolicitudProducto(long idTelefSolicitudProducto) {
		_idTelefSolicitudProducto = idTelefSolicitudProducto;
	}

	public long getIdSolicitudProducto() {
		return _idSolicitudProducto;
	}

	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_idSolicitudProducto = idSolicitudProducto;
	}

	public String getTipoTelefono() {
		return _tipoTelefono;
	}

	public void setTipoTelefono(String tipoTelefono) {
		_tipoTelefono = tipoTelefono;
	}

	public String getNumeroTelefono() {
		return _numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		_numeroTelefono = numeroTelefono;
	}

	public String getAnexo() {
		return _anexo;
	}

	public void setAnexo(String anexo) {
		_anexo = anexo;
	}

	public BaseModel<?> getTelefonoSolicitudProductoRemoteModel() {
		return _telefonoSolicitudProductoRemoteModel;
	}

	public void setTelefonoSolicitudProductoRemoteModel(
		BaseModel<?> telefonoSolicitudProductoRemoteModel) {
		_telefonoSolicitudProductoRemoteModel = telefonoSolicitudProductoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TelefonoSolicitudProductoLocalServiceUtil.addTelefonoSolicitudProducto(this);
		}
		else {
			TelefonoSolicitudProductoLocalServiceUtil.updateTelefonoSolicitudProducto(this);
		}
	}

	@Override
	public TelefonoSolicitudProducto toEscapedModel() {
		return (TelefonoSolicitudProducto)Proxy.newProxyInstance(TelefonoSolicitudProducto.class.getClassLoader(),
			new Class[] { TelefonoSolicitudProducto.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TelefonoSolicitudProductoClp clone = new TelefonoSolicitudProductoClp();

		clone.setIdTelefSolicitudProducto(getIdTelefSolicitudProducto());
		clone.setIdSolicitudProducto(getIdSolicitudProducto());
		clone.setTipoTelefono(getTipoTelefono());
		clone.setNumeroTelefono(getNumeroTelefono());
		clone.setAnexo(getAnexo());

		return clone;
	}

	public int compareTo(TelefonoSolicitudProducto telefonoSolicitudProducto) {
		long primaryKey = telefonoSolicitudProducto.getPrimaryKey();

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

		TelefonoSolicitudProductoClp telefonoSolicitudProducto = null;

		try {
			telefonoSolicitudProducto = (TelefonoSolicitudProductoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = telefonoSolicitudProducto.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{idTelefSolicitudProducto=");
		sb.append(getIdTelefSolicitudProducto());
		sb.append(", idSolicitudProducto=");
		sb.append(getIdSolicitudProducto());
		sb.append(", tipoTelefono=");
		sb.append(getTipoTelefono());
		sb.append(", numeroTelefono=");
		sb.append(getNumeroTelefono());
		sb.append(", anexo=");
		sb.append(getAnexo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.TelefonoSolicitudProducto");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idTelefSolicitudProducto</column-name><column-value><![CDATA[");
		sb.append(getIdTelefSolicitudProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSolicitudProducto</column-name><column-value><![CDATA[");
		sb.append(getIdSolicitudProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoTelefono</column-name><column-value><![CDATA[");
		sb.append(getTipoTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroTelefono</column-name><column-value><![CDATA[");
		sb.append(getNumeroTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anexo</column-name><column-value><![CDATA[");
		sb.append(getAnexo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idTelefSolicitudProducto;
	private long _idSolicitudProducto;
	private String _tipoTelefono;
	private String _numeroTelefono;
	private String _anexo;
	private BaseModel<?> _telefonoSolicitudProductoRemoteModel;
}