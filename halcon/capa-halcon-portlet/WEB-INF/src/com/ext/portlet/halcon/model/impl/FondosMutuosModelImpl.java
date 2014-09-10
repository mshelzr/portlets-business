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

import com.ext.portlet.halcon.model.FondosMutuos;
import com.ext.portlet.halcon.model.FondosMutuosModel;
import com.ext.portlet.halcon.model.FondosMutuosSoap;

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
 * The base model implementation for the FondosMutuos service. Represents a row in the &quot;T_FONDOS_MUTUOS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.halcon.model.FondosMutuosModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FondosMutuosImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosImpl
 * @see com.ext.portlet.halcon.model.FondosMutuos
 * @see com.ext.portlet.halcon.model.FondosMutuosModel
 * @generated
 */
@JSON(strict = true)
public class FondosMutuosModelImpl extends BaseModelImpl<FondosMutuos>
	implements FondosMutuosModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a fondos mutuos model instance should use the {@link com.ext.portlet.halcon.model.FondosMutuos} interface instead.
	 */
	public static final String TABLE_NAME = "T_FONDOS_MUTUOS";
	public static final Object[][] TABLE_COLUMNS = {
			{ "fomu_IdValorCuota", Types.BIGINT },
			{ "fomu_CodigoMoneda", Types.VARCHAR },
			{ "fomu_TipoFondo", Types.VARCHAR },
			{ "fomu_ValorCuota", Types.DOUBLE },
			{ "fomu_Fecha", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table T_FONDOS_MUTUOS (fomu_IdValorCuota LONG not null primary key IDENTITY,fomu_CodigoMoneda VARCHAR(75) null,fomu_TipoFondo VARCHAR(75) null,fomu_ValorCuota DOUBLE,fomu_Fecha VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table T_FONDOS_MUTUOS";
	public static final String DATA_SOURCE = "halconDataSource";
	public static final String SESSION_FACTORY = "halconSessionFactory";
	public static final String TX_MANAGER = "halconTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.halcon.model.FondosMutuos"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.halcon.model.FondosMutuos"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static FondosMutuos toModel(FondosMutuosSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		FondosMutuos model = new FondosMutuosImpl();

		model.setIdValorCuota(soapModel.getIdValorCuota());
		model.setCodigoMoneda(soapModel.getCodigoMoneda());
		model.setTipoFondo(soapModel.getTipoFondo());
		model.setValorCuota(soapModel.getValorCuota());
		model.setFecha(soapModel.getFecha());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<FondosMutuos> toModels(FondosMutuosSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<FondosMutuos> models = new ArrayList<FondosMutuos>(soapModels.length);

		for (FondosMutuosSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.halcon.model.FondosMutuos"));

	public FondosMutuosModelImpl() {
	}

	public long getPrimaryKey() {
		return _idValorCuota;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdValorCuota(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idValorCuota);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return FondosMutuos.class;
	}

	public String getModelClassName() {
		return FondosMutuos.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idValorCuota", getIdValorCuota());
		attributes.put("codigoMoneda", getCodigoMoneda());
		attributes.put("tipoFondo", getTipoFondo());
		attributes.put("valorCuota", getValorCuota());
		attributes.put("fecha", getFecha());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idValorCuota = (Long)attributes.get("idValorCuota");

		if (idValorCuota != null) {
			setIdValorCuota(idValorCuota);
		}

		String codigoMoneda = (String)attributes.get("codigoMoneda");

		if (codigoMoneda != null) {
			setCodigoMoneda(codigoMoneda);
		}

		String tipoFondo = (String)attributes.get("tipoFondo");

		if (tipoFondo != null) {
			setTipoFondo(tipoFondo);
		}

		Double valorCuota = (Double)attributes.get("valorCuota");

		if (valorCuota != null) {
			setValorCuota(valorCuota);
		}

		String fecha = (String)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}
	}

	@JSON
	public long getIdValorCuota() {
		return _idValorCuota;
	}

	public void setIdValorCuota(long idValorCuota) {
		_idValorCuota = idValorCuota;
	}

	@JSON
	public String getCodigoMoneda() {
		if (_codigoMoneda == null) {
			return StringPool.BLANK;
		}
		else {
			return _codigoMoneda;
		}
	}

	public void setCodigoMoneda(String codigoMoneda) {
		_codigoMoneda = codigoMoneda;
	}

	@JSON
	public String getTipoFondo() {
		if (_tipoFondo == null) {
			return StringPool.BLANK;
		}
		else {
			return _tipoFondo;
		}
	}

	public void setTipoFondo(String tipoFondo) {
		_tipoFondo = tipoFondo;
	}

	@JSON
	public Double getValorCuota() {
		return _valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		_valorCuota = valorCuota;
	}

	@JSON
	public String getFecha() {
		if (_fecha == null) {
			return StringPool.BLANK;
		}
		else {
			return _fecha;
		}
	}

	public void setFecha(String fecha) {
		_fecha = fecha;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			FondosMutuos.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FondosMutuos toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (FondosMutuos)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		FondosMutuosImpl fondosMutuosImpl = new FondosMutuosImpl();

		fondosMutuosImpl.setIdValorCuota(getIdValorCuota());
		fondosMutuosImpl.setCodigoMoneda(getCodigoMoneda());
		fondosMutuosImpl.setTipoFondo(getTipoFondo());
		fondosMutuosImpl.setValorCuota(getValorCuota());
		fondosMutuosImpl.setFecha(getFecha());

		fondosMutuosImpl.resetOriginalValues();

		return fondosMutuosImpl;
	}

	public int compareTo(FondosMutuos fondosMutuos) {
		long primaryKey = fondosMutuos.getPrimaryKey();

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

		FondosMutuos fondosMutuos = null;

		try {
			fondosMutuos = (FondosMutuos)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = fondosMutuos.getPrimaryKey();

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
	public CacheModel<FondosMutuos> toCacheModel() {
		FondosMutuosCacheModel fondosMutuosCacheModel = new FondosMutuosCacheModel();

		fondosMutuosCacheModel.idValorCuota = getIdValorCuota();

		fondosMutuosCacheModel.codigoMoneda = getCodigoMoneda();

		String codigoMoneda = fondosMutuosCacheModel.codigoMoneda;

		if ((codigoMoneda != null) && (codigoMoneda.length() == 0)) {
			fondosMutuosCacheModel.codigoMoneda = null;
		}

		fondosMutuosCacheModel.tipoFondo = getTipoFondo();

		String tipoFondo = fondosMutuosCacheModel.tipoFondo;

		if ((tipoFondo != null) && (tipoFondo.length() == 0)) {
			fondosMutuosCacheModel.tipoFondo = null;
		}

		fondosMutuosCacheModel.valorCuota = getValorCuota();

		fondosMutuosCacheModel.fecha = getFecha();

		String fecha = fondosMutuosCacheModel.fecha;

		if ((fecha != null) && (fecha.length() == 0)) {
			fondosMutuosCacheModel.fecha = null;
		}

		return fondosMutuosCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idValorCuota=");
		sb.append(getIdValorCuota());
		sb.append(", codigoMoneda=");
		sb.append(getCodigoMoneda());
		sb.append(", tipoFondo=");
		sb.append(getTipoFondo());
		sb.append(", valorCuota=");
		sb.append(getValorCuota());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.FondosMutuos");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idValorCuota</column-name><column-value><![CDATA[");
		sb.append(getIdValorCuota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoMoneda</column-name><column-value><![CDATA[");
		sb.append(getCodigoMoneda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoFondo</column-name><column-value><![CDATA[");
		sb.append(getTipoFondo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorCuota</column-name><column-value><![CDATA[");
		sb.append(getValorCuota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = FondosMutuos.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			FondosMutuos.class
		};
	private long _idValorCuota;
	private String _codigoMoneda;
	private String _tipoFondo;
	private Double _valorCuota;
	private String _fecha;
	private FondosMutuos _escapedModelProxy;
}