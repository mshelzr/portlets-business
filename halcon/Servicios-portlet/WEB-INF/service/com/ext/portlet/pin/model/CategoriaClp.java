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

import com.ext.portlet.pin.service.CategoriaLocalServiceUtil;

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
 * @author arodriguez
 */
public class CategoriaClp extends BaseModelImpl<Categoria> implements Categoria {
	public CategoriaClp() {
	}

	public Class<?> getModelClass() {
		return Categoria.class;
	}

	public String getModelClassName() {
		return Categoria.class.getName();
	}

	public long getPrimaryKey() {
		return _categoriaId;
	}

	public void setPrimaryKey(long primaryKey) {
		setCategoriaId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_categoriaId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoriaId", getCategoriaId());
		attributes.put("idImagen", getIdImagen());
		attributes.put("nombre", getNombre());
		attributes.put("estado", getEstado());
		attributes.put("descripcion", getDescripcion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoriaId = (Long)attributes.get("categoriaId");

		if (categoriaId != null) {
			setCategoriaId(categoriaId);
		}

		Long idImagen = (Long)attributes.get("idImagen");

		if (idImagen != null) {
			setIdImagen(idImagen);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}
	}

	public long getCategoriaId() {
		return _categoriaId;
	}

	public void setCategoriaId(long categoriaId) {
		_categoriaId = categoriaId;
	}

	public long getIdImagen() {
		return _idImagen;
	}

	public void setIdImagen(long idImagen) {
		_idImagen = idImagen;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public boolean getEstado() {
		return _estado;
	}

	public boolean isEstado() {
		return _estado;
	}

	public void setEstado(boolean estado) {
		_estado = estado;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	public BaseModel<?> getCategoriaRemoteModel() {
		return _categoriaRemoteModel;
	}

	public void setCategoriaRemoteModel(BaseModel<?> categoriaRemoteModel) {
		_categoriaRemoteModel = categoriaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CategoriaLocalServiceUtil.addCategoria(this);
		}
		else {
			CategoriaLocalServiceUtil.updateCategoria(this);
		}
	}

	@Override
	public Categoria toEscapedModel() {
		return (Categoria)Proxy.newProxyInstance(Categoria.class.getClassLoader(),
			new Class[] { Categoria.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CategoriaClp clone = new CategoriaClp();

		clone.setCategoriaId(getCategoriaId());
		clone.setIdImagen(getIdImagen());
		clone.setNombre(getNombre());
		clone.setEstado(getEstado());
		clone.setDescripcion(getDescripcion());

		return clone;
	}

	public int compareTo(Categoria categoria) {
		long primaryKey = categoria.getPrimaryKey();

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

		CategoriaClp categoria = null;

		try {
			categoria = (CategoriaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = categoria.getPrimaryKey();

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

		sb.append("{categoriaId=");
		sb.append(getCategoriaId());
		sb.append(", idImagen=");
		sb.append(getIdImagen());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append(", estado=");
		sb.append(getEstado());
		sb.append(", descripcion=");
		sb.append(getDescripcion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.pin.model.Categoria");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoriaId</column-name><column-value><![CDATA[");
		sb.append(getCategoriaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idImagen</column-name><column-value><![CDATA[");
		sb.append(getIdImagen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estado</column-name><column-value><![CDATA[");
		sb.append(getEstado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descripcion</column-name><column-value><![CDATA[");
		sb.append(getDescripcion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _categoriaId;
	private long _idImagen;
	private String _nombre;
	private boolean _estado;
	private String _descripcion;
	private BaseModel<?> _categoriaRemoteModel;
}