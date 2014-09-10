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

import com.ext.portlet.halcon.service.PaisLocalServiceUtil;

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
public class PaisClp extends BaseModelImpl<Pais> implements Pais {
	public PaisClp() {
	}

	public Class<?> getModelClass() {
		return Pais.class;
	}

	public String getModelClassName() {
		return Pais.class.getName();
	}

	public long getPrimaryKey() {
		return _pais_IdPais;
	}

	public void setPrimaryKey(long primaryKey) {
		setPais_IdPais(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pais_IdPais);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pais_IdPais", getPais_IdPais());
		attributes.put("codigo", getCodigo());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pais_IdPais = (Long)attributes.get("pais_IdPais");

		if (pais_IdPais != null) {
			setPais_IdPais(pais_IdPais);
		}

		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	public long getPais_IdPais() {
		return _pais_IdPais;
	}

	public void setPais_IdPais(long pais_IdPais) {
		_pais_IdPais = pais_IdPais;
	}

	public String getCodigo() {
		return _codigo;
	}

	public void setCodigo(String codigo) {
		_codigo = codigo;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public BaseModel<?> getPaisRemoteModel() {
		return _paisRemoteModel;
	}

	public void setPaisRemoteModel(BaseModel<?> paisRemoteModel) {
		_paisRemoteModel = paisRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PaisLocalServiceUtil.addPais(this);
		}
		else {
			PaisLocalServiceUtil.updatePais(this);
		}
	}

	@Override
	public Pais toEscapedModel() {
		return (Pais)Proxy.newProxyInstance(Pais.class.getClassLoader(),
			new Class[] { Pais.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PaisClp clone = new PaisClp();

		clone.setPais_IdPais(getPais_IdPais());
		clone.setCodigo(getCodigo());
		clone.setNombre(getNombre());

		return clone;
	}

	public int compareTo(Pais pais) {
		long primaryKey = pais.getPrimaryKey();

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

		PaisClp pais = null;

		try {
			pais = (PaisClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = pais.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{pais_IdPais=");
		sb.append(getPais_IdPais());
		sb.append(", codigo=");
		sb.append(getCodigo());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.Pais");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pais_IdPais</column-name><column-value><![CDATA[");
		sb.append(getPais_IdPais());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigo</column-name><column-value><![CDATA[");
		sb.append(getCodigo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _pais_IdPais;
	private String _codigo;
	private String _nombre;
	private BaseModel<?> _paisRemoteModel;
}