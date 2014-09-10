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

import com.ext.portlet.halcon.service.FondosMutuosLocalServiceUtil;

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
public class FondosMutuosClp extends BaseModelImpl<FondosMutuos>
	implements FondosMutuos {
	public FondosMutuosClp() {
	}

	public Class<?> getModelClass() {
		return FondosMutuos.class;
	}

	public String getModelClassName() {
		return FondosMutuos.class.getName();
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

	public long getIdValorCuota() {
		return _idValorCuota;
	}

	public void setIdValorCuota(long idValorCuota) {
		_idValorCuota = idValorCuota;
	}

	public String getCodigoMoneda() {
		return _codigoMoneda;
	}

	public void setCodigoMoneda(String codigoMoneda) {
		_codigoMoneda = codigoMoneda;
	}

	public String getTipoFondo() {
		return _tipoFondo;
	}

	public void setTipoFondo(String tipoFondo) {
		_tipoFondo = tipoFondo;
	}

	public Double getValorCuota() {
		return _valorCuota;
	}

	public void setValorCuota(Double valorCuota) {
		_valorCuota = valorCuota;
	}

	public String getFecha() {
		return _fecha;
	}

	public void setFecha(String fecha) {
		_fecha = fecha;
	}

	public BaseModel<?> getFondosMutuosRemoteModel() {
		return _fondosMutuosRemoteModel;
	}

	public void setFondosMutuosRemoteModel(BaseModel<?> fondosMutuosRemoteModel) {
		_fondosMutuosRemoteModel = fondosMutuosRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FondosMutuosLocalServiceUtil.addFondosMutuos(this);
		}
		else {
			FondosMutuosLocalServiceUtil.updateFondosMutuos(this);
		}
	}

	@Override
	public FondosMutuos toEscapedModel() {
		return (FondosMutuos)Proxy.newProxyInstance(FondosMutuos.class.getClassLoader(),
			new Class[] { FondosMutuos.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FondosMutuosClp clone = new FondosMutuosClp();

		clone.setIdValorCuota(getIdValorCuota());
		clone.setCodigoMoneda(getCodigoMoneda());
		clone.setTipoFondo(getTipoFondo());
		clone.setValorCuota(getValorCuota());
		clone.setFecha(getFecha());

		return clone;
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

		FondosMutuosClp fondosMutuos = null;

		try {
			fondosMutuos = (FondosMutuosClp)obj;
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

	private long _idValorCuota;
	private String _codigoMoneda;
	private String _tipoFondo;
	private Double _valorCuota;
	private String _fecha;
	private BaseModel<?> _fondosMutuosRemoteModel;
}