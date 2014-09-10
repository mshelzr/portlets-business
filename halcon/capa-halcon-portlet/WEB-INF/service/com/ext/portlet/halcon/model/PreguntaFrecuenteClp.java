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

import com.ext.portlet.halcon.service.PreguntaFrecuenteLocalServiceUtil;

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
public class PreguntaFrecuenteClp extends BaseModelImpl<PreguntaFrecuente>
	implements PreguntaFrecuente {
	public PreguntaFrecuenteClp() {
	}

	public Class<?> getModelClass() {
		return PreguntaFrecuente.class;
	}

	public String getModelClassName() {
		return PreguntaFrecuente.class.getName();
	}

	public int getPrimaryKey() {
		return _idPreguntaFrecuente;
	}

	public void setPrimaryKey(int primaryKey) {
		setIdPreguntaFrecuente(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_idPreguntaFrecuente);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idPreguntaFrecuente", getIdPreguntaFrecuente());
		attributes.put("idCategoriaSubCat", getIdCategoriaSubCat());
		attributes.put("enunciado", getEnunciado());
		attributes.put("respuesta", getRespuesta());
		attributes.put("estado", getEstado());
		attributes.put("etiqueta", getEtiqueta());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idPreguntaFrecuente = (Integer)attributes.get(
				"idPreguntaFrecuente");

		if (idPreguntaFrecuente != null) {
			setIdPreguntaFrecuente(idPreguntaFrecuente);
		}

		Integer idCategoriaSubCat = (Integer)attributes.get("idCategoriaSubCat");

		if (idCategoriaSubCat != null) {
			setIdCategoriaSubCat(idCategoriaSubCat);
		}

		String enunciado = (String)attributes.get("enunciado");

		if (enunciado != null) {
			setEnunciado(enunciado);
		}

		String respuesta = (String)attributes.get("respuesta");

		if (respuesta != null) {
			setRespuesta(respuesta);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}

		String etiqueta = (String)attributes.get("etiqueta");

		if (etiqueta != null) {
			setEtiqueta(etiqueta);
		}
	}

	public int getIdPreguntaFrecuente() {
		return _idPreguntaFrecuente;
	}

	public void setIdPreguntaFrecuente(int idPreguntaFrecuente) {
		_idPreguntaFrecuente = idPreguntaFrecuente;
	}

	public Integer getIdCategoriaSubCat() {
		return _idCategoriaSubCat;
	}

	public void setIdCategoriaSubCat(Integer idCategoriaSubCat) {
		_idCategoriaSubCat = idCategoriaSubCat;
	}

	public String getEnunciado() {
		return _enunciado;
	}

	public void setEnunciado(String enunciado) {
		_enunciado = enunciado;
	}

	public String getRespuesta() {
		return _respuesta;
	}

	public void setRespuesta(String respuesta) {
		_respuesta = respuesta;
	}

	public Boolean getEstado() {
		return _estado;
	}

	public void setEstado(Boolean estado) {
		_estado = estado;
	}

	public String getEtiqueta() {
		return _etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		_etiqueta = etiqueta;
	}

	public BaseModel<?> getPreguntaFrecuenteRemoteModel() {
		return _preguntaFrecuenteRemoteModel;
	}

	public void setPreguntaFrecuenteRemoteModel(
		BaseModel<?> preguntaFrecuenteRemoteModel) {
		_preguntaFrecuenteRemoteModel = preguntaFrecuenteRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			PreguntaFrecuenteLocalServiceUtil.addPreguntaFrecuente(this);
		}
		else {
			PreguntaFrecuenteLocalServiceUtil.updatePreguntaFrecuente(this);
		}
	}

	@Override
	public PreguntaFrecuente toEscapedModel() {
		return (PreguntaFrecuente)Proxy.newProxyInstance(PreguntaFrecuente.class.getClassLoader(),
			new Class[] { PreguntaFrecuente.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PreguntaFrecuenteClp clone = new PreguntaFrecuenteClp();

		clone.setIdPreguntaFrecuente(getIdPreguntaFrecuente());
		clone.setIdCategoriaSubCat(getIdCategoriaSubCat());
		clone.setEnunciado(getEnunciado());
		clone.setRespuesta(getRespuesta());
		clone.setEstado(getEstado());
		clone.setEtiqueta(getEtiqueta());

		return clone;
	}

	public int compareTo(PreguntaFrecuente preguntaFrecuente) {
		int primaryKey = preguntaFrecuente.getPrimaryKey();

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

		PreguntaFrecuenteClp preguntaFrecuente = null;

		try {
			preguntaFrecuente = (PreguntaFrecuenteClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = preguntaFrecuente.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{idPreguntaFrecuente=");
		sb.append(getIdPreguntaFrecuente());
		sb.append(", idCategoriaSubCat=");
		sb.append(getIdCategoriaSubCat());
		sb.append(", enunciado=");
		sb.append(getEnunciado());
		sb.append(", respuesta=");
		sb.append(getRespuesta());
		sb.append(", estado=");
		sb.append(getEstado());
		sb.append(", etiqueta=");
		sb.append(getEtiqueta());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.PreguntaFrecuente");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idPreguntaFrecuente</column-name><column-value><![CDATA[");
		sb.append(getIdPreguntaFrecuente());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idCategoriaSubCat</column-name><column-value><![CDATA[");
		sb.append(getIdCategoriaSubCat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enunciado</column-name><column-value><![CDATA[");
		sb.append(getEnunciado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respuesta</column-name><column-value><![CDATA[");
		sb.append(getRespuesta());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>estado</column-name><column-value><![CDATA[");
		sb.append(getEstado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>etiqueta</column-name><column-value><![CDATA[");
		sb.append(getEtiqueta());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _idPreguntaFrecuente;
	private Integer _idCategoriaSubCat;
	private String _enunciado;
	private String _respuesta;
	private Boolean _estado;
	private String _etiqueta;
	private BaseModel<?> _preguntaFrecuenteRemoteModel;
}