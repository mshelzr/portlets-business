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

import com.ext.portlet.halcon.service.UbigeoLocalServiceUtil;

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
public class UbigeoClp extends BaseModelImpl<Ubigeo> implements Ubigeo {
	public UbigeoClp() {
	}

	public Class<?> getModelClass() {
		return Ubigeo.class;
	}

	public String getModelClassName() {
		return Ubigeo.class.getName();
	}

	public long getPrimaryKey() {
		return _idUbigeo;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdUbigeo(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idUbigeo);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idUbigeo", getIdUbigeo());
		attributes.put("codigo", getCodigo());
		attributes.put("nombre", getNombre());
		attributes.put("codDepartamento", getCodDepartamento());
		attributes.put("codProvincia", getCodProvincia());
		attributes.put("codDistrito", getCodDistrito());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idUbigeo = (Long)attributes.get("idUbigeo");

		if (idUbigeo != null) {
			setIdUbigeo(idUbigeo);
		}

		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String codDepartamento = (String)attributes.get("codDepartamento");

		if (codDepartamento != null) {
			setCodDepartamento(codDepartamento);
		}

		String codProvincia = (String)attributes.get("codProvincia");

		if (codProvincia != null) {
			setCodProvincia(codProvincia);
		}

		String codDistrito = (String)attributes.get("codDistrito");

		if (codDistrito != null) {
			setCodDistrito(codDistrito);
		}
	}

	public long getIdUbigeo() {
		return _idUbigeo;
	}

	public void setIdUbigeo(long idUbigeo) {
		_idUbigeo = idUbigeo;
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

	public String getCodDepartamento() {
		return _codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		_codDepartamento = codDepartamento;
	}

	public String getCodProvincia() {
		return _codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		_codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return _codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		_codDistrito = codDistrito;
	}

	public BaseModel<?> getUbigeoRemoteModel() {
		return _ubigeoRemoteModel;
	}

	public void setUbigeoRemoteModel(BaseModel<?> ubigeoRemoteModel) {
		_ubigeoRemoteModel = ubigeoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			UbigeoLocalServiceUtil.addUbigeo(this);
		}
		else {
			UbigeoLocalServiceUtil.updateUbigeo(this);
		}
	}

	@Override
	public Ubigeo toEscapedModel() {
		return (Ubigeo)Proxy.newProxyInstance(Ubigeo.class.getClassLoader(),
			new Class[] { Ubigeo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UbigeoClp clone = new UbigeoClp();

		clone.setIdUbigeo(getIdUbigeo());
		clone.setCodigo(getCodigo());
		clone.setNombre(getNombre());
		clone.setCodDepartamento(getCodDepartamento());
		clone.setCodProvincia(getCodProvincia());
		clone.setCodDistrito(getCodDistrito());

		return clone;
	}

	public int compareTo(Ubigeo ubigeo) {
		long primaryKey = ubigeo.getPrimaryKey();

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

		UbigeoClp ubigeo = null;

		try {
			ubigeo = (UbigeoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ubigeo.getPrimaryKey();

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

		sb.append("{idUbigeo=");
		sb.append(getIdUbigeo());
		sb.append(", codigo=");
		sb.append(getCodigo());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append(", codDepartamento=");
		sb.append(getCodDepartamento());
		sb.append(", codProvincia=");
		sb.append(getCodProvincia());
		sb.append(", codDistrito=");
		sb.append(getCodDistrito());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.Ubigeo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idUbigeo</column-name><column-value><![CDATA[");
		sb.append(getIdUbigeo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigo</column-name><column-value><![CDATA[");
		sb.append(getCodigo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codDepartamento</column-name><column-value><![CDATA[");
		sb.append(getCodDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProvincia</column-name><column-value><![CDATA[");
		sb.append(getCodProvincia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codDistrito</column-name><column-value><![CDATA[");
		sb.append(getCodDistrito());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idUbigeo;
	private String _codigo;
	private String _nombre;
	private String _codDepartamento;
	private String _codProvincia;
	private String _codDistrito;
	private BaseModel<?> _ubigeoRemoteModel;
}