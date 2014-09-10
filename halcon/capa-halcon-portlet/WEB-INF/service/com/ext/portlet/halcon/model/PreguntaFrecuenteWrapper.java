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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PreguntaFrecuente}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       PreguntaFrecuente
 * @generated
 */
public class PreguntaFrecuenteWrapper implements PreguntaFrecuente,
	ModelWrapper<PreguntaFrecuente> {
	public PreguntaFrecuenteWrapper(PreguntaFrecuente preguntaFrecuente) {
		_preguntaFrecuente = preguntaFrecuente;
	}

	public Class<?> getModelClass() {
		return PreguntaFrecuente.class;
	}

	public String getModelClassName() {
		return PreguntaFrecuente.class.getName();
	}

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

	/**
	* Returns the primary key of this pregunta frecuente.
	*
	* @return the primary key of this pregunta frecuente
	*/
	public int getPrimaryKey() {
		return _preguntaFrecuente.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pregunta frecuente.
	*
	* @param primaryKey the primary key of this pregunta frecuente
	*/
	public void setPrimaryKey(int primaryKey) {
		_preguntaFrecuente.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id pregunta frecuente of this pregunta frecuente.
	*
	* @return the id pregunta frecuente of this pregunta frecuente
	*/
	public int getIdPreguntaFrecuente() {
		return _preguntaFrecuente.getIdPreguntaFrecuente();
	}

	/**
	* Sets the id pregunta frecuente of this pregunta frecuente.
	*
	* @param idPreguntaFrecuente the id pregunta frecuente of this pregunta frecuente
	*/
	public void setIdPreguntaFrecuente(int idPreguntaFrecuente) {
		_preguntaFrecuente.setIdPreguntaFrecuente(idPreguntaFrecuente);
	}

	/**
	* Returns the id categoria sub cat of this pregunta frecuente.
	*
	* @return the id categoria sub cat of this pregunta frecuente
	*/
	public java.lang.Integer getIdCategoriaSubCat() {
		return _preguntaFrecuente.getIdCategoriaSubCat();
	}

	/**
	* Sets the id categoria sub cat of this pregunta frecuente.
	*
	* @param idCategoriaSubCat the id categoria sub cat of this pregunta frecuente
	*/
	public void setIdCategoriaSubCat(java.lang.Integer idCategoriaSubCat) {
		_preguntaFrecuente.setIdCategoriaSubCat(idCategoriaSubCat);
	}

	/**
	* Returns the enunciado of this pregunta frecuente.
	*
	* @return the enunciado of this pregunta frecuente
	*/
	public java.lang.String getEnunciado() {
		return _preguntaFrecuente.getEnunciado();
	}

	/**
	* Sets the enunciado of this pregunta frecuente.
	*
	* @param enunciado the enunciado of this pregunta frecuente
	*/
	public void setEnunciado(java.lang.String enunciado) {
		_preguntaFrecuente.setEnunciado(enunciado);
	}

	/**
	* Returns the respuesta of this pregunta frecuente.
	*
	* @return the respuesta of this pregunta frecuente
	*/
	public java.lang.String getRespuesta() {
		return _preguntaFrecuente.getRespuesta();
	}

	/**
	* Sets the respuesta of this pregunta frecuente.
	*
	* @param respuesta the respuesta of this pregunta frecuente
	*/
	public void setRespuesta(java.lang.String respuesta) {
		_preguntaFrecuente.setRespuesta(respuesta);
	}

	/**
	* Returns the estado of this pregunta frecuente.
	*
	* @return the estado of this pregunta frecuente
	*/
	public java.lang.Boolean getEstado() {
		return _preguntaFrecuente.getEstado();
	}

	/**
	* Sets the estado of this pregunta frecuente.
	*
	* @param estado the estado of this pregunta frecuente
	*/
	public void setEstado(java.lang.Boolean estado) {
		_preguntaFrecuente.setEstado(estado);
	}

	/**
	* Returns the etiqueta of this pregunta frecuente.
	*
	* @return the etiqueta of this pregunta frecuente
	*/
	public java.lang.String getEtiqueta() {
		return _preguntaFrecuente.getEtiqueta();
	}

	/**
	* Sets the etiqueta of this pregunta frecuente.
	*
	* @param etiqueta the etiqueta of this pregunta frecuente
	*/
	public void setEtiqueta(java.lang.String etiqueta) {
		_preguntaFrecuente.setEtiqueta(etiqueta);
	}

	public boolean isNew() {
		return _preguntaFrecuente.isNew();
	}

	public void setNew(boolean n) {
		_preguntaFrecuente.setNew(n);
	}

	public boolean isCachedModel() {
		return _preguntaFrecuente.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_preguntaFrecuente.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _preguntaFrecuente.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _preguntaFrecuente.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_preguntaFrecuente.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _preguntaFrecuente.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_preguntaFrecuente.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PreguntaFrecuenteWrapper((PreguntaFrecuente)_preguntaFrecuente.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente) {
		return _preguntaFrecuente.compareTo(preguntaFrecuente);
	}

	@Override
	public int hashCode() {
		return _preguntaFrecuente.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.PreguntaFrecuente> toCacheModel() {
		return _preguntaFrecuente.toCacheModel();
	}

	public com.ext.portlet.halcon.model.PreguntaFrecuente toEscapedModel() {
		return new PreguntaFrecuenteWrapper(_preguntaFrecuente.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _preguntaFrecuente.toString();
	}

	public java.lang.String toXmlString() {
		return _preguntaFrecuente.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_preguntaFrecuente.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public PreguntaFrecuente getWrappedPreguntaFrecuente() {
		return _preguntaFrecuente;
	}

	public PreguntaFrecuente getWrappedModel() {
		return _preguntaFrecuente;
	}

	public void resetOriginalValues() {
		_preguntaFrecuente.resetOriginalValues();
	}

	private PreguntaFrecuente _preguntaFrecuente;
}