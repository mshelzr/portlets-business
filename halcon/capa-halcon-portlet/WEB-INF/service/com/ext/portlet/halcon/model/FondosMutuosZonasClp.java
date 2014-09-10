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

import com.ext.portlet.halcon.service.FondosMutuosZonasLocalServiceUtil;

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
public class FondosMutuosZonasClp extends BaseModelImpl<FondosMutuosZonas>
	implements FondosMutuosZonas {
	public FondosMutuosZonasClp() {
	}

	public Class<?> getModelClass() {
		return FondosMutuosZonas.class;
	}

	public String getModelClassName() {
		return FondosMutuosZonas.class.getName();
	}

	public long getPrimaryKey() {
		return _idFondoMutuoZona;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdFondoMutuoZona(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idFondoMutuoZona);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idFondoMutuoZona", getIdFondoMutuoZona());
		attributes.put("codigoZona", getCodigoZona());
		attributes.put("zona", getZona());
		attributes.put("puntajeInicial", getPuntajeInicial());
		attributes.put("puntajeFinal", getPuntajeFinal());
		attributes.put("descripcionZona", getDescripcionZona());
		attributes.put("moneda", getMoneda());
		attributes.put("riesgo", getRiesgo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idFondoMutuoZona = (Long)attributes.get("idFondoMutuoZona");

		if (idFondoMutuoZona != null) {
			setIdFondoMutuoZona(idFondoMutuoZona);
		}

		String codigoZona = (String)attributes.get("codigoZona");

		if (codigoZona != null) {
			setCodigoZona(codigoZona);
		}

		String zona = (String)attributes.get("zona");

		if (zona != null) {
			setZona(zona);
		}

		Integer puntajeInicial = (Integer)attributes.get("puntajeInicial");

		if (puntajeInicial != null) {
			setPuntajeInicial(puntajeInicial);
		}

		Integer puntajeFinal = (Integer)attributes.get("puntajeFinal");

		if (puntajeFinal != null) {
			setPuntajeFinal(puntajeFinal);
		}

		String descripcionZona = (String)attributes.get("descripcionZona");

		if (descripcionZona != null) {
			setDescripcionZona(descripcionZona);
		}

		String moneda = (String)attributes.get("moneda");

		if (moneda != null) {
			setMoneda(moneda);
		}

		String riesgo = (String)attributes.get("riesgo");

		if (riesgo != null) {
			setRiesgo(riesgo);
		}
	}

	public long getIdFondoMutuoZona() {
		return _idFondoMutuoZona;
	}

	public void setIdFondoMutuoZona(long idFondoMutuoZona) {
		_idFondoMutuoZona = idFondoMutuoZona;
	}

	public String getCodigoZona() {
		return _codigoZona;
	}

	public void setCodigoZona(String codigoZona) {
		_codigoZona = codigoZona;
	}

	public String getZona() {
		return _zona;
	}

	public void setZona(String zona) {
		_zona = zona;
	}

	public Integer getPuntajeInicial() {
		return _puntajeInicial;
	}

	public void setPuntajeInicial(Integer puntajeInicial) {
		_puntajeInicial = puntajeInicial;
	}

	public Integer getPuntajeFinal() {
		return _puntajeFinal;
	}

	public void setPuntajeFinal(Integer puntajeFinal) {
		_puntajeFinal = puntajeFinal;
	}

	public String getDescripcionZona() {
		return _descripcionZona;
	}

	public void setDescripcionZona(String descripcionZona) {
		_descripcionZona = descripcionZona;
	}

	public String getMoneda() {
		return _moneda;
	}

	public void setMoneda(String moneda) {
		_moneda = moneda;
	}

	public String getRiesgo() {
		return _riesgo;
	}

	public void setRiesgo(String riesgo) {
		_riesgo = riesgo;
	}

	public BaseModel<?> getFondosMutuosZonasRemoteModel() {
		return _fondosMutuosZonasRemoteModel;
	}

	public void setFondosMutuosZonasRemoteModel(
		BaseModel<?> fondosMutuosZonasRemoteModel) {
		_fondosMutuosZonasRemoteModel = fondosMutuosZonasRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			FondosMutuosZonasLocalServiceUtil.addFondosMutuosZonas(this);
		}
		else {
			FondosMutuosZonasLocalServiceUtil.updateFondosMutuosZonas(this);
		}
	}

	@Override
	public FondosMutuosZonas toEscapedModel() {
		return (FondosMutuosZonas)Proxy.newProxyInstance(FondosMutuosZonas.class.getClassLoader(),
			new Class[] { FondosMutuosZonas.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FondosMutuosZonasClp clone = new FondosMutuosZonasClp();

		clone.setIdFondoMutuoZona(getIdFondoMutuoZona());
		clone.setCodigoZona(getCodigoZona());
		clone.setZona(getZona());
		clone.setPuntajeInicial(getPuntajeInicial());
		clone.setPuntajeFinal(getPuntajeFinal());
		clone.setDescripcionZona(getDescripcionZona());
		clone.setMoneda(getMoneda());
		clone.setRiesgo(getRiesgo());

		return clone;
	}

	public int compareTo(FondosMutuosZonas fondosMutuosZonas) {
		long primaryKey = fondosMutuosZonas.getPrimaryKey();

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

		FondosMutuosZonasClp fondosMutuosZonas = null;

		try {
			fondosMutuosZonas = (FondosMutuosZonasClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = fondosMutuosZonas.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{idFondoMutuoZona=");
		sb.append(getIdFondoMutuoZona());
		sb.append(", codigoZona=");
		sb.append(getCodigoZona());
		sb.append(", zona=");
		sb.append(getZona());
		sb.append(", puntajeInicial=");
		sb.append(getPuntajeInicial());
		sb.append(", puntajeFinal=");
		sb.append(getPuntajeFinal());
		sb.append(", descripcionZona=");
		sb.append(getDescripcionZona());
		sb.append(", moneda=");
		sb.append(getMoneda());
		sb.append(", riesgo=");
		sb.append(getRiesgo());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.FondosMutuosZonas");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idFondoMutuoZona</column-name><column-value><![CDATA[");
		sb.append(getIdFondoMutuoZona());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codigoZona</column-name><column-value><![CDATA[");
		sb.append(getCodigoZona());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>zona</column-name><column-value><![CDATA[");
		sb.append(getZona());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>puntajeInicial</column-name><column-value><![CDATA[");
		sb.append(getPuntajeInicial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>puntajeFinal</column-name><column-value><![CDATA[");
		sb.append(getPuntajeFinal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descripcionZona</column-name><column-value><![CDATA[");
		sb.append(getDescripcionZona());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moneda</column-name><column-value><![CDATA[");
		sb.append(getMoneda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>riesgo</column-name><column-value><![CDATA[");
		sb.append(getRiesgo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idFondoMutuoZona;
	private String _codigoZona;
	private String _zona;
	private Integer _puntajeInicial;
	private Integer _puntajeFinal;
	private String _descripcionZona;
	private String _moneda;
	private String _riesgo;
	private BaseModel<?> _fondosMutuosZonasRemoteModel;
}