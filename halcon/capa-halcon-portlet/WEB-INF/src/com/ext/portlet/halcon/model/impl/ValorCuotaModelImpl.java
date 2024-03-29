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

import com.ext.portlet.halcon.model.ValorCuota;
import com.ext.portlet.halcon.model.ValorCuotaModel;
import com.ext.portlet.halcon.model.ValorCuotaSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ValorCuota service. Represents a row in the &quot;T_VALOR_CUOTA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ext.portlet.halcon.model.ValorCuotaModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ValorCuotaImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ValorCuotaImpl
 * @see com.ext.portlet.halcon.model.ValorCuota
 * @see com.ext.portlet.halcon.model.ValorCuotaModel
 * @generated
 */
@JSON(strict = true)
public class ValorCuotaModelImpl extends BaseModelImpl<ValorCuota>
	implements ValorCuotaModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a valor cuota model instance should use the {@link com.ext.portlet.halcon.model.ValorCuota} interface instead.
	 */
	public static final String TABLE_NAME = "T_VALOR_CUOTA";
	public static final Object[][] TABLE_COLUMNS = {
			{ "vlct_IdValorCuota", Types.BIGINT },
			{ "vlct_TipoFondoMutuo", Types.INTEGER },
			{ "vlct_Fecha", Types.TIMESTAMP },
			{ "vlct_ValorCuota", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table T_VALOR_CUOTA (vlct_IdValorCuota LONG not null primary key IDENTITY,vlct_TipoFondoMutuo INTEGER,vlct_Fecha DATE null,vlct_ValorCuota DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table T_VALOR_CUOTA";
	public static final String DATA_SOURCE = "halconDataSource";
	public static final String SESSION_FACTORY = "halconSessionFactory";
	public static final String TX_MANAGER = "halconTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ext.portlet.halcon.model.ValorCuota"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ext.portlet.halcon.model.ValorCuota"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ValorCuota toModel(ValorCuotaSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ValorCuota model = new ValorCuotaImpl();

		model.setIdValorCuota(soapModel.getIdValorCuota());
		model.setTipoFondoMutuo(soapModel.getTipoFondoMutuo());
		model.setFecha(soapModel.getFecha());
		model.setValorCuota(soapModel.getValorCuota());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ValorCuota> toModels(ValorCuotaSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ValorCuota> models = new ArrayList<ValorCuota>(soapModels.length);

		for (ValorCuotaSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ext.portlet.halcon.model.ValorCuota"));

	public ValorCuotaModelImpl() {
	}

	public long getPrimaryKey() {
		return _IdValorCuota;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdValorCuota(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_IdValorCuota);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public Class<?> getModelClass() {
		return ValorCuota.class;
	}

	public String getModelClassName() {
		return ValorCuota.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("IdValorCuota", getIdValorCuota());
		attributes.put("tipoFondoMutuo", getTipoFondoMutuo());
		attributes.put("fecha", getFecha());
		attributes.put("valorCuota", getValorCuota());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long IdValorCuota = (Long)attributes.get("IdValorCuota");

		if (IdValorCuota != null) {
			setIdValorCuota(IdValorCuota);
		}

		Integer tipoFondoMutuo = (Integer)attributes.get("tipoFondoMutuo");

		if (tipoFondoMutuo != null) {
			setTipoFondoMutuo(tipoFondoMutuo);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		Double valorCuota = (Double)attributes.get("valorCuota");

		if (valorCuota != null) {
			setValorCuota(valorCuota);
		}
	}

	@JSON
	public long getIdValorCuota() {
		return _IdValorCuota;
	}

	public void setIdValorCuota(long IdValorCuota) {
		_IdValorCuota = IdValorCuota;
	}

	@JSON
	public Integer getTipoFondoMutuo() {
		return _tipoFondoMutuo;
	}

	public void setTipoFondoMutuo(Integer tipoFondoMutuo) {
		_tipoFondoMutuo = tipoFondoMutuo;
	}

	@JSON
	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	@JSON
	public Double getValorCuota() {
		return _valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		_valorCuota = valorCuota;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ValorCuota.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ValorCuota toEscapedModel() {
		if (_escapedModelProxy == null) {
			_escapedModelProxy = (ValorCuota)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelProxyInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModelProxy;
	}

	@Override
	public Object clone() {
		ValorCuotaImpl valorCuotaImpl = new ValorCuotaImpl();

		valorCuotaImpl.setIdValorCuota(getIdValorCuota());
		valorCuotaImpl.setTipoFondoMutuo(getTipoFondoMutuo());
		valorCuotaImpl.setFecha(getFecha());
		valorCuotaImpl.setValorCuota(getValorCuota());

		valorCuotaImpl.resetOriginalValues();

		return valorCuotaImpl;
	}

	public int compareTo(ValorCuota valorCuota) {
		long primaryKey = valorCuota.getPrimaryKey();

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

		ValorCuota valorCuota = null;

		try {
			valorCuota = (ValorCuota)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = valorCuota.getPrimaryKey();

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
	public CacheModel<ValorCuota> toCacheModel() {
		ValorCuotaCacheModel valorCuotaCacheModel = new ValorCuotaCacheModel();

		valorCuotaCacheModel.IdValorCuota = getIdValorCuota();

		valorCuotaCacheModel.tipoFondoMutuo = getTipoFondoMutuo();

		Date fecha = getFecha();

		if (fecha != null) {
			valorCuotaCacheModel.fecha = fecha.getTime();
		}
		else {
			valorCuotaCacheModel.fecha = Long.MIN_VALUE;
		}

		valorCuotaCacheModel.valorCuota = getValorCuota();

		return valorCuotaCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{IdValorCuota=");
		sb.append(getIdValorCuota());
		sb.append(", tipoFondoMutuo=");
		sb.append(getTipoFondoMutuo());
		sb.append(", fecha=");
		sb.append(getFecha());
		sb.append(", valorCuota=");
		sb.append(getValorCuota());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.ValorCuota");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>IdValorCuota</column-name><column-value><![CDATA[");
		sb.append(getIdValorCuota());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoFondoMutuo</column-name><column-value><![CDATA[");
		sb.append(getTipoFondoMutuo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fecha</column-name><column-value><![CDATA[");
		sb.append(getFecha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorCuota</column-name><column-value><![CDATA[");
		sb.append(getValorCuota());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = ValorCuota.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			ValorCuota.class
		};
	private long _IdValorCuota;
	private Integer _tipoFondoMutuo;
	private Date _fecha;
	private Double _valorCuota;
	private ValorCuota _escapedModelProxy;
}