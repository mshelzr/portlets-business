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

import com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalServiceUtil;

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
public class CategoriaSubcategoriaClp extends BaseModelImpl<CategoriaSubcategoria>
	implements CategoriaSubcategoria {
	public CategoriaSubcategoriaClp() {
	}

	public Class<?> getModelClass() {
		return CategoriaSubcategoria.class;
	}

	public String getModelClassName() {
		return CategoriaSubcategoria.class.getName();
	}

	public long getPrimaryKey() {
		return _idCategoriaSubCat;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdCategoriaSubCat(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idCategoriaSubCat);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCategoriaSubCat", getIdCategoriaSubCat());
		attributes.put("idCategoriaSubCatPadre", getIdCategoriaSubCatPadre());
		attributes.put("descripcion", getDescripcion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCategoriaSubCat = (Long)attributes.get("idCategoriaSubCat");

		if (idCategoriaSubCat != null) {
			setIdCategoriaSubCat(idCategoriaSubCat);
		}

		Integer idCategoriaSubCatPadre = (Integer)attributes.get(
				"idCategoriaSubCatPadre");

		if (idCategoriaSubCatPadre != null) {
			setIdCategoriaSubCatPadre(idCategoriaSubCatPadre);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}
	}

	public long getIdCategoriaSubCat() {
		return _idCategoriaSubCat;
	}

	public void setIdCategoriaSubCat(long idCategoriaSubCat) {
		_idCategoriaSubCat = idCategoriaSubCat;
	}

	public Integer getIdCategoriaSubCatPadre() {
		return _idCategoriaSubCatPadre;
	}

	public void setIdCategoriaSubCatPadre(Integer idCategoriaSubCatPadre) {
		_idCategoriaSubCatPadre = idCategoriaSubCatPadre;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
	}

	public BaseModel<?> getCategoriaSubcategoriaRemoteModel() {
		return _categoriaSubcategoriaRemoteModel;
	}

	public void setCategoriaSubcategoriaRemoteModel(
		BaseModel<?> categoriaSubcategoriaRemoteModel) {
		_categoriaSubcategoriaRemoteModel = categoriaSubcategoriaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CategoriaSubcategoriaLocalServiceUtil.addCategoriaSubcategoria(this);
		}
		else {
			CategoriaSubcategoriaLocalServiceUtil.updateCategoriaSubcategoria(this);
		}
	}

	@Override
	public CategoriaSubcategoria toEscapedModel() {
		return (CategoriaSubcategoria)Proxy.newProxyInstance(CategoriaSubcategoria.class.getClassLoader(),
			new Class[] { CategoriaSubcategoria.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CategoriaSubcategoriaClp clone = new CategoriaSubcategoriaClp();

		clone.setIdCategoriaSubCat(getIdCategoriaSubCat());
		clone.setIdCategoriaSubCatPadre(getIdCategoriaSubCatPadre());
		clone.setDescripcion(getDescripcion());

		return clone;
	}

	public int compareTo(CategoriaSubcategoria categoriaSubcategoria) {
		long primaryKey = categoriaSubcategoria.getPrimaryKey();

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

		CategoriaSubcategoriaClp categoriaSubcategoria = null;

		try {
			categoriaSubcategoria = (CategoriaSubcategoriaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = categoriaSubcategoria.getPrimaryKey();

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

		sb.append("{idCategoriaSubCat=");
		sb.append(getIdCategoriaSubCat());
		sb.append(", idCategoriaSubCatPadre=");
		sb.append(getIdCategoriaSubCatPadre());
		sb.append(", descripcion=");
		sb.append(getDescripcion());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.CategoriaSubcategoria");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idCategoriaSubCat</column-name><column-value><![CDATA[");
		sb.append(getIdCategoriaSubCat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCategoriaSubCatPadre</column-name><column-value><![CDATA[");
		sb.append(getIdCategoriaSubCatPadre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descripcion</column-name><column-value><![CDATA[");
		sb.append(getDescripcion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idCategoriaSubCat;
	private Integer _idCategoriaSubCatPadre;
	private String _descripcion;
	private BaseModel<?> _categoriaSubcategoriaRemoteModel;
}