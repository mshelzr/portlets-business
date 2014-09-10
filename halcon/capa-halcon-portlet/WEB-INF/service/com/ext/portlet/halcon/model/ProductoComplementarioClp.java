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

import com.ext.portlet.halcon.service.ProductoComplementarioLocalServiceUtil;

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
public class ProductoComplementarioClp extends BaseModelImpl<ProductoComplementario>
	implements ProductoComplementario {
	public ProductoComplementarioClp() {
	}

	public Class<?> getModelClass() {
		return ProductoComplementario.class;
	}

	public String getModelClassName() {
		return ProductoComplementario.class.getName();
	}

	public long getPrimaryKey() {
		return _idProductoComplementario;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdProductoComplementario(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idProductoComplementario);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idProductoComplementario", getIdProductoComplementario());
		attributes.put("idSolicitudProducto", getIdSolicitudProducto());
		attributes.put("principalidad", getPrincipalidad());
		attributes.put("producto", getProducto());
		attributes.put("idProducto", getIdProducto());
		attributes.put("idGrupoProducto", getIdGrupoProducto());
		attributes.put("emailSupervisor", getEmailSupervisor());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idProductoComplementario = (Long)attributes.get(
				"idProductoComplementario");

		if (idProductoComplementario != null) {
			setIdProductoComplementario(idProductoComplementario);
		}

		Long idSolicitudProducto = (Long)attributes.get("idSolicitudProducto");

		if (idSolicitudProducto != null) {
			setIdSolicitudProducto(idSolicitudProducto);
		}

		String principalidad = (String)attributes.get("principalidad");

		if (principalidad != null) {
			setPrincipalidad(principalidad);
		}

		String producto = (String)attributes.get("producto");

		if (producto != null) {
			setProducto(producto);
		}

		String idProducto = (String)attributes.get("idProducto");

		if (idProducto != null) {
			setIdProducto(idProducto);
		}

		String idGrupoProducto = (String)attributes.get("idGrupoProducto");

		if (idGrupoProducto != null) {
			setIdGrupoProducto(idGrupoProducto);
		}

		String emailSupervisor = (String)attributes.get("emailSupervisor");

		if (emailSupervisor != null) {
			setEmailSupervisor(emailSupervisor);
		}
	}

	public long getIdProductoComplementario() {
		return _idProductoComplementario;
	}

	public void setIdProductoComplementario(long idProductoComplementario) {
		_idProductoComplementario = idProductoComplementario;
	}

	public long getIdSolicitudProducto() {
		return _idSolicitudProducto;
	}

	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_idSolicitudProducto = idSolicitudProducto;
	}

	public String getPrincipalidad() {
		return _principalidad;
	}

	public void setPrincipalidad(String principalidad) {
		_principalidad = principalidad;
	}

	public String getProducto() {
		return _producto;
	}

	public void setProducto(String producto) {
		_producto = producto;
	}

	public String getIdProducto() {
		return _idProducto;
	}

	public void setIdProducto(String idProducto) {
		_idProducto = idProducto;
	}

	public String getIdGrupoProducto() {
		return _idGrupoProducto;
	}

	public void setIdGrupoProducto(String idGrupoProducto) {
		_idGrupoProducto = idGrupoProducto;
	}

	public String getEmailSupervisor() {
		return _emailSupervisor;
	}

	public void setEmailSupervisor(String emailSupervisor) {
		_emailSupervisor = emailSupervisor;
	}

	public BaseModel<?> getProductoComplementarioRemoteModel() {
		return _productoComplementarioRemoteModel;
	}

	public void setProductoComplementarioRemoteModel(
		BaseModel<?> productoComplementarioRemoteModel) {
		_productoComplementarioRemoteModel = productoComplementarioRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductoComplementarioLocalServiceUtil.addProductoComplementario(this);
		}
		else {
			ProductoComplementarioLocalServiceUtil.updateProductoComplementario(this);
		}
	}

	@Override
	public ProductoComplementario toEscapedModel() {
		return (ProductoComplementario)Proxy.newProxyInstance(ProductoComplementario.class.getClassLoader(),
			new Class[] { ProductoComplementario.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductoComplementarioClp clone = new ProductoComplementarioClp();

		clone.setIdProductoComplementario(getIdProductoComplementario());
		clone.setIdSolicitudProducto(getIdSolicitudProducto());
		clone.setPrincipalidad(getPrincipalidad());
		clone.setProducto(getProducto());
		clone.setIdProducto(getIdProducto());
		clone.setIdGrupoProducto(getIdGrupoProducto());
		clone.setEmailSupervisor(getEmailSupervisor());

		return clone;
	}

	public int compareTo(ProductoComplementario productoComplementario) {
		long primaryKey = productoComplementario.getPrimaryKey();

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

		ProductoComplementarioClp productoComplementario = null;

		try {
			productoComplementario = (ProductoComplementarioClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = productoComplementario.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{idProductoComplementario=");
		sb.append(getIdProductoComplementario());
		sb.append(", idSolicitudProducto=");
		sb.append(getIdSolicitudProducto());
		sb.append(", principalidad=");
		sb.append(getPrincipalidad());
		sb.append(", producto=");
		sb.append(getProducto());
		sb.append(", idProducto=");
		sb.append(getIdProducto());
		sb.append(", idGrupoProducto=");
		sb.append(getIdGrupoProducto());
		sb.append(", emailSupervisor=");
		sb.append(getEmailSupervisor());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.ProductoComplementario");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idProductoComplementario</column-name><column-value><![CDATA[");
		sb.append(getIdProductoComplementario());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idSolicitudProducto</column-name><column-value><![CDATA[");
		sb.append(getIdSolicitudProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>principalidad</column-name><column-value><![CDATA[");
		sb.append(getPrincipalidad());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto</column-name><column-value><![CDATA[");
		sb.append(getProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idProducto</column-name><column-value><![CDATA[");
		sb.append(getIdProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idGrupoProducto</column-name><column-value><![CDATA[");
		sb.append(getIdGrupoProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailSupervisor</column-name><column-value><![CDATA[");
		sb.append(getEmailSupervisor());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idProductoComplementario;
	private long _idSolicitudProducto;
	private String _principalidad;
	private String _producto;
	private String _idProducto;
	private String _idGrupoProducto;
	private String _emailSupervisor;
	private BaseModel<?> _productoComplementarioRemoteModel;
}