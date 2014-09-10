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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.PreguntaFrecuenteServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.PreguntaFrecuenteServiceSoap
 * @generated
 */
public class PreguntaFrecuenteSoap implements Serializable {
	public static PreguntaFrecuenteSoap toSoapModel(PreguntaFrecuente model) {
		PreguntaFrecuenteSoap soapModel = new PreguntaFrecuenteSoap();

		soapModel.setIdPreguntaFrecuente(model.getIdPreguntaFrecuente());
		soapModel.setIdCategoriaSubCat(model.getIdCategoriaSubCat());
		soapModel.setEnunciado(model.getEnunciado());
		soapModel.setRespuesta(model.getRespuesta());
		soapModel.setEstado(model.getEstado());
		soapModel.setEtiqueta(model.getEtiqueta());

		return soapModel;
	}

	public static PreguntaFrecuenteSoap[] toSoapModels(
		PreguntaFrecuente[] models) {
		PreguntaFrecuenteSoap[] soapModels = new PreguntaFrecuenteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PreguntaFrecuenteSoap[][] toSoapModels(
		PreguntaFrecuente[][] models) {
		PreguntaFrecuenteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PreguntaFrecuenteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PreguntaFrecuenteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PreguntaFrecuenteSoap[] toSoapModels(
		List<PreguntaFrecuente> models) {
		List<PreguntaFrecuenteSoap> soapModels = new ArrayList<PreguntaFrecuenteSoap>(models.size());

		for (PreguntaFrecuente model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PreguntaFrecuenteSoap[soapModels.size()]);
	}

	public PreguntaFrecuenteSoap() {
	}

	public int getPrimaryKey() {
		return _idPreguntaFrecuente;
	}

	public void setPrimaryKey(int pk) {
		setIdPreguntaFrecuente(pk);
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

	private int _idPreguntaFrecuente;
	private Integer _idCategoriaSubCat;
	private String _enunciado;
	private String _respuesta;
	private Boolean _estado;
	private String _etiqueta;
}