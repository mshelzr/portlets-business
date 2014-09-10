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

import com.ext.portlet.halcon.service.ValorCuotaLocalServiceUtil;

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
public class ValorCuotaClp extends BaseModelImpl<ValorCuota>
	implements ValorCuota {
	public ValorCuotaClp() {
	}

	public Class<?> getModelClass() {
		return ValorCuota.class;
	}

	public String getModelClassName() {
		return ValorCuota.class.getName();
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

	public long getIdValorCuota() {
		return _IdValorCuota;
	}

	public void setIdValorCuota(long IdValorCuota) {
		_IdValorCuota = IdValorCuota;
	}

	public Integer getTipoFondoMutuo() {
		return _tipoFondoMutuo;
	}

	public void setTipoFondoMutuo(Integer tipoFondoMutuo) {
		_tipoFondoMutuo = tipoFondoMutuo;
	}

	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public Double getValorCuota() {
		return _valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		_valorCuota = valorCuota;
	}

	public BaseModel<?> getValorCuotaRemoteModel() {
		return _valorCuotaRemoteModel;
	}

	public void setValorCuotaRemoteModel(BaseModel<?> valorCuotaRemoteModel) {
		_valorCuotaRemoteModel = valorCuotaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ValorCuotaLocalServiceUtil.addValorCuota(this);
		}
		else {
			ValorCuotaLocalServiceUtil.updateValorCuota(this);
		}
	}

	@Override
	public ValorCuota toEscapedModel() {
		return (ValorCuota)Proxy.newProxyInstance(ValorCuota.class.getClassLoader(),
			new Class[] { ValorCuota.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ValorCuotaClp clone = new ValorCuotaClp();

		clone.setIdValorCuota(getIdValorCuota());
		clone.setTipoFondoMutuo(getTipoFondoMutuo());
		clone.setFecha(getFecha());
		clone.setValorCuota(getValorCuota());

		return clone;
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

		ValorCuotaClp valorCuota = null;

		try {
			valorCuota = (ValorCuotaClp)obj;
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

	private long _IdValorCuota;
	private Integer _tipoFondoMutuo;
	private Date _fecha;
	private Double _valorCuota;
	private BaseModel<?> _valorCuotaRemoteModel;
}