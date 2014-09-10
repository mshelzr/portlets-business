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

import com.ext.portlet.halcon.model.ProductoComplementario;
import com.ext.portlet.halcon.model.ProductoComplementarioModel;
import com.ext.portlet.halcon.model.ProductoComplementarioSoap;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ProductoComplementario service. Represents a row in the &quot;T_PRODUCTO_COMPLEMENTARIO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.halcon.model.ProductoComplementarioModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductoComplementarioImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ProductoComplementarioImpl
 * @see com.ext.portlet.halcon.model.ProductoComplementario
 * @see com.ext.portlet.halcon.model.ProductoComplementarioModel
 * @generated
 */
@JSON(strict = true)
public class ProductoComplementarioModelImpl extends BaseModelImpl<ProductoComplementario>
	implements ProductoComplementarioModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a producto complementario model instance should use the {@link com.ext.portlet.halcon.model.ProductoComplementario} interface instead.
	 */
	public static final String TABLE_NAME = "T_PRODUCTO_COMPLEMENTARIO";
	public static final Object[][] TABLE_COLUMNS = {
			{ "prcm_IdProductoComplementario", Types.BIGINT },
			{ "prcm_IdSolicitudProducto", Types.BIGINT },
			{ "prcm_Principalidad", Types.VARCHAR },
			{ "prcm_Producto", Types.VARCHAR },
			{ "prcm_IdProducto", Types.VARCHAR },
			{ "prcm_IdGrupoProducto", Types.VARCHAR },
			{ "prcm_EmailSupervisor", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table T_PRODUCTO_COMPLEMENTARIO (prcm_IdProductoComplementario LONG not null primary key IDENTITY,prcm_IdSolicitudProducto LONG,prcm_Principalidad VARCHAR(75) null,prcm_Producto VARCHAR(75) null,prcm_IdProducto VARCHAR(75) null,prcm_IdGrupoProducto VARCHAR(75) null,prcm_EmailSupervisor VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table T_PRODUCTO_COMPLEMENTARIO";
	public static final String DATA_SOURCE = "halconDataSource";
	public static final String SESSION_FACTORY = "halconSessionFactory";
	public static final String TX_MANAGER = "halconTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.halcon.model.ProductoComplementario"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.halcon.model.ProductoComplementario"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProductoComplementario toModel(
		ProductoComplementarioSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProductoComplementario model = new ProductoComplementarioImpl();

		model.setIdProductoComplementario(soapModel.getIdProductoComplementario());
		model.setIdSolicitudProducto(soapModel.getIdSolicitudProducto());
		model.setPrincipalidad(soapModel.getPrincipalidad());
		model.setProducto(soapModel.getProducto());
		model.setIdProducto(soapModel.getIdProducto());
		model.setIdGrupoProducto(soapModel.getIdGrupoProducto());
		model.setEmailSupervisor(soapModel.getEmailSupervisor());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProductoComplementario> toModels(
		ProductoComplementarioSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ProductoComplementario> models = new ArrayList<ProductoComplementario>(soapModels.length);

		for (ProductoComplementarioSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.halcon.model.ProductoComplementario"));

	public ProductoComplementarioModelImpl() {
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

	public Class<?> getModelClass() {
		return ProductoComplementario.class;
	}

	public String getModelClassName() {
		return ProductoComplementario.class.getName();
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

	@JSON
	public long getIdProductoComplementario() {
		return _idProductoComplementario;
	}

	public void setIdProductoComplementario(long idProductoComplementario) {
		_idProductoComplementario = idProductoComplementario;
	}

	@JSON
	public long getIdSolicitudProducto() {
		return _idSolicitudProducto;
	}

	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_idSolicitudProducto = idSolicitudProducto;
	}

	@JSON
	public String getPrincipalidad() {
		if (_principalidad == null) {
			return StringPool.BLANK;
		}
		else {
			return _principalidad;
		}
	}

	public void setPrincipalidad(String principalidad) {
		_principalidad = principalidad;
	}

	@JSON
	public String getProducto() {
		if (_producto == null) {
			return StringPool.BLANK;
		}
		else {
			return _producto;
		}
	}

	public void setProducto(String producto) {
		_producto = producto;
	}

	@JSON
	public String getIdProducto() {
		if (_idProducto == null) {
			return StringPool.BLANK;
		}
		else {
			return _idProducto;
		}
	}

	public void setIdProducto(String idProducto) {
		_idProducto = idProducto;
	}

	@JSON
	public String getIdGrupoProducto() {
		if (_idGrupoProducto == null) {
			return StringPool.BLANK;
		}
		else {
			return _idGrupoProducto;
		}
	}

	public void setIdGrupoProducto(String idGrupoProducto) {
		_idGrupoProducto = idGrupoProducto;
	}

	@JSON
	public String getEmailSupervisor() {
		if (_emailSupervisor == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailSupervisor;
		}
	}

	public void setEmailSupervisor(String emailSupervisor) {
		_emailSupervisor = emailSupervisor;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ProductoComplementario.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProductoComplementario toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ProductoComplementario)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ProductoComplementarioImpl productoComplementarioImpl = new ProductoComplementarioImpl();

		productoComplementarioImpl.setIdProductoComplementario(getIdProductoComplementario());
		productoComplementarioImpl.setIdSolicitudProducto(getIdSolicitudProducto());
		productoComplementarioImpl.setPrincipalidad(getPrincipalidad());
		productoComplementarioImpl.setProducto(getProducto());
		productoComplementarioImpl.setIdProducto(getIdProducto());
		productoComplementarioImpl.setIdGrupoProducto(getIdGrupoProducto());
		productoComplementarioImpl.setEmailSupervisor(getEmailSupervisor());

		productoComplementarioImpl.resetOriginalValues();

		return productoComplementarioImpl;
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

		ProductoComplementario productoComplementario = null;

		try {
			productoComplementario = (ProductoComplementario)obj;
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
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<ProductoComplementario> toCacheModel() {
		ProductoComplementarioCacheModel productoComplementarioCacheModel = new ProductoComplementarioCacheModel();

		productoComplementarioCacheModel.idProductoComplementario = getIdProductoComplementario();

		productoComplementarioCacheModel.idSolicitudProducto = getIdSolicitudProducto();

		productoComplementarioCacheModel.principalidad = getPrincipalidad();

		String principalidad = productoComplementarioCacheModel.principalidad;

		if ((principalidad != null) && (principalidad.length() == 0)) {
			productoComplementarioCacheModel.principalidad = null;
		}

		productoComplementarioCacheModel.producto = getProducto();

		String producto = productoComplementarioCacheModel.producto;

		if ((producto != null) && (producto.length() == 0)) {
			productoComplementarioCacheModel.producto = null;
		}

		productoComplementarioCacheModel.idProducto = getIdProducto();

		String idProducto = productoComplementarioCacheModel.idProducto;

		if ((idProducto != null) && (idProducto.length() == 0)) {
			productoComplementarioCacheModel.idProducto = null;
		}

		productoComplementarioCacheModel.idGrupoProducto = getIdGrupoProducto();

		String idGrupoProducto = productoComplementarioCacheModel.idGrupoProducto;

		if ((idGrupoProducto != null) && (idGrupoProducto.length() == 0)) {
			productoComplementarioCacheModel.idGrupoProducto = null;
		}

		productoComplementarioCacheModel.emailSupervisor = getEmailSupervisor();

		String emailSupervisor = productoComplementarioCacheModel.emailSupervisor;

		if ((emailSupervisor != null) && (emailSupervisor.length() == 0)) {
			productoComplementarioCacheModel.emailSupervisor = null;
		}

		return productoComplementarioCacheModel;
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

	private static ClassLoader _classLoader = ProductoComplementario.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ProductoComplementario.class
		};
	private long _idProductoComplementario;
	private long _idSolicitudProducto;
	private String _principalidad;
	private String _producto;
	private String _idProducto;
	private String _idGrupoProducto;
	private String _emailSupervisor;
	private ProductoComplementario _escapedModelProxy;
}