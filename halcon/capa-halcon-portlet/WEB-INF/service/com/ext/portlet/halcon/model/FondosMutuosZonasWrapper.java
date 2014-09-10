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
 * This class is a wrapper for {@link FondosMutuosZonas}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       FondosMutuosZonas
 * @generated
 */
public class FondosMutuosZonasWrapper implements FondosMutuosZonas,
	ModelWrapper<FondosMutuosZonas> {
	public FondosMutuosZonasWrapper(FondosMutuosZonas fondosMutuosZonas) {
		_fondosMutuosZonas = fondosMutuosZonas;
	}

	public Class<?> getModelClass() {
		return FondosMutuosZonas.class;
	}

	public String getModelClassName() {
		return FondosMutuosZonas.class.getName();
	}

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

	/**
	* Returns the primary key of this fondos mutuos zonas.
	*
	* @return the primary key of this fondos mutuos zonas
	*/
	public long getPrimaryKey() {
		return _fondosMutuosZonas.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fondos mutuos zonas.
	*
	* @param primaryKey the primary key of this fondos mutuos zonas
	*/
	public void setPrimaryKey(long primaryKey) {
		_fondosMutuosZonas.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id fondo mutuo zona of this fondos mutuos zonas.
	*
	* @return the id fondo mutuo zona of this fondos mutuos zonas
	*/
	public long getIdFondoMutuoZona() {
		return _fondosMutuosZonas.getIdFondoMutuoZona();
	}

	/**
	* Sets the id fondo mutuo zona of this fondos mutuos zonas.
	*
	* @param idFondoMutuoZona the id fondo mutuo zona of this fondos mutuos zonas
	*/
	public void setIdFondoMutuoZona(long idFondoMutuoZona) {
		_fondosMutuosZonas.setIdFondoMutuoZona(idFondoMutuoZona);
	}

	/**
	* Returns the codigo zona of this fondos mutuos zonas.
	*
	* @return the codigo zona of this fondos mutuos zonas
	*/
	public java.lang.String getCodigoZona() {
		return _fondosMutuosZonas.getCodigoZona();
	}

	/**
	* Sets the codigo zona of this fondos mutuos zonas.
	*
	* @param codigoZona the codigo zona of this fondos mutuos zonas
	*/
	public void setCodigoZona(java.lang.String codigoZona) {
		_fondosMutuosZonas.setCodigoZona(codigoZona);
	}

	/**
	* Returns the zona of this fondos mutuos zonas.
	*
	* @return the zona of this fondos mutuos zonas
	*/
	public java.lang.String getZona() {
		return _fondosMutuosZonas.getZona();
	}

	/**
	* Sets the zona of this fondos mutuos zonas.
	*
	* @param zona the zona of this fondos mutuos zonas
	*/
	public void setZona(java.lang.String zona) {
		_fondosMutuosZonas.setZona(zona);
	}

	/**
	* Returns the puntaje inicial of this fondos mutuos zonas.
	*
	* @return the puntaje inicial of this fondos mutuos zonas
	*/
	public java.lang.Integer getPuntajeInicial() {
		return _fondosMutuosZonas.getPuntajeInicial();
	}

	/**
	* Sets the puntaje inicial of this fondos mutuos zonas.
	*
	* @param puntajeInicial the puntaje inicial of this fondos mutuos zonas
	*/
	public void setPuntajeInicial(java.lang.Integer puntajeInicial) {
		_fondosMutuosZonas.setPuntajeInicial(puntajeInicial);
	}

	/**
	* Returns the puntaje final of this fondos mutuos zonas.
	*
	* @return the puntaje final of this fondos mutuos zonas
	*/
	public java.lang.Integer getPuntajeFinal() {
		return _fondosMutuosZonas.getPuntajeFinal();
	}

	/**
	* Sets the puntaje final of this fondos mutuos zonas.
	*
	* @param puntajeFinal the puntaje final of this fondos mutuos zonas
	*/
	public void setPuntajeFinal(java.lang.Integer puntajeFinal) {
		_fondosMutuosZonas.setPuntajeFinal(puntajeFinal);
	}

	/**
	* Returns the descripcion zona of this fondos mutuos zonas.
	*
	* @return the descripcion zona of this fondos mutuos zonas
	*/
	public java.lang.String getDescripcionZona() {
		return _fondosMutuosZonas.getDescripcionZona();
	}

	/**
	* Sets the descripcion zona of this fondos mutuos zonas.
	*
	* @param descripcionZona the descripcion zona of this fondos mutuos zonas
	*/
	public void setDescripcionZona(java.lang.String descripcionZona) {
		_fondosMutuosZonas.setDescripcionZona(descripcionZona);
	}

	/**
	* Returns the moneda of this fondos mutuos zonas.
	*
	* @return the moneda of this fondos mutuos zonas
	*/
	public java.lang.String getMoneda() {
		return _fondosMutuosZonas.getMoneda();
	}

	/**
	* Sets the moneda of this fondos mutuos zonas.
	*
	* @param moneda the moneda of this fondos mutuos zonas
	*/
	public void setMoneda(java.lang.String moneda) {
		_fondosMutuosZonas.setMoneda(moneda);
	}

	/**
	* Returns the riesgo of this fondos mutuos zonas.
	*
	* @return the riesgo of this fondos mutuos zonas
	*/
	public java.lang.String getRiesgo() {
		return _fondosMutuosZonas.getRiesgo();
	}

	/**
	* Sets the riesgo of this fondos mutuos zonas.
	*
	* @param riesgo the riesgo of this fondos mutuos zonas
	*/
	public void setRiesgo(java.lang.String riesgo) {
		_fondosMutuosZonas.setRiesgo(riesgo);
	}

	public boolean isNew() {
		return _fondosMutuosZonas.isNew();
	}

	public void setNew(boolean n) {
		_fondosMutuosZonas.setNew(n);
	}

	public boolean isCachedModel() {
		return _fondosMutuosZonas.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_fondosMutuosZonas.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _fondosMutuosZonas.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _fondosMutuosZonas.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fondosMutuosZonas.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fondosMutuosZonas.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fondosMutuosZonas.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FondosMutuosZonasWrapper((FondosMutuosZonas)_fondosMutuosZonas.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas) {
		return _fondosMutuosZonas.compareTo(fondosMutuosZonas);
	}

	@Override
	public int hashCode() {
		return _fondosMutuosZonas.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.FondosMutuosZonas> toCacheModel() {
		return _fondosMutuosZonas.toCacheModel();
	}

	public com.ext.portlet.halcon.model.FondosMutuosZonas toEscapedModel() {
		return new FondosMutuosZonasWrapper(_fondosMutuosZonas.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fondosMutuosZonas.toString();
	}

	public java.lang.String toXmlString() {
		return _fondosMutuosZonas.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fondosMutuosZonas.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FondosMutuosZonas getWrappedFondosMutuosZonas() {
		return _fondosMutuosZonas;
	}

	public FondosMutuosZonas getWrappedModel() {
		return _fondosMutuosZonas;
	}

	public void resetOriginalValues() {
		_fondosMutuosZonas.resetOriginalValues();
	}

	private FondosMutuosZonas _fondosMutuosZonas;
}