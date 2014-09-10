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
 * This class is a wrapper for {@link FondosMutuos}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       FondosMutuos
 * @generated
 */
public class FondosMutuosWrapper implements FondosMutuos,
	ModelWrapper<FondosMutuos> {
	public FondosMutuosWrapper(FondosMutuos fondosMutuos) {
		_fondosMutuos = fondosMutuos;
	}

	public Class<?> getModelClass() {
		return FondosMutuos.class;
	}

	public String getModelClassName() {
		return FondosMutuos.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idValorCuota", getIdValorCuota());
		attributes.put("codigoMoneda", getCodigoMoneda());
		attributes.put("tipoFondo", getTipoFondo());
		attributes.put("valorCuota", getValorCuota());
		attributes.put("fecha", getFecha());

		return attributes;
	}

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

	/**
	* Returns the primary key of this fondos mutuos.
	*
	* @return the primary key of this fondos mutuos
	*/
	public long getPrimaryKey() {
		return _fondosMutuos.getPrimaryKey();
	}

	/**
	* Sets the primary key of this fondos mutuos.
	*
	* @param primaryKey the primary key of this fondos mutuos
	*/
	public void setPrimaryKey(long primaryKey) {
		_fondosMutuos.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id valor cuota of this fondos mutuos.
	*
	* @return the id valor cuota of this fondos mutuos
	*/
	public long getIdValorCuota() {
		return _fondosMutuos.getIdValorCuota();
	}

	/**
	* Sets the id valor cuota of this fondos mutuos.
	*
	* @param idValorCuota the id valor cuota of this fondos mutuos
	*/
	public void setIdValorCuota(long idValorCuota) {
		_fondosMutuos.setIdValorCuota(idValorCuota);
	}

	/**
	* Returns the codigo moneda of this fondos mutuos.
	*
	* @return the codigo moneda of this fondos mutuos
	*/
	public java.lang.String getCodigoMoneda() {
		return _fondosMutuos.getCodigoMoneda();
	}

	/**
	* Sets the codigo moneda of this fondos mutuos.
	*
	* @param codigoMoneda the codigo moneda of this fondos mutuos
	*/
	public void setCodigoMoneda(java.lang.String codigoMoneda) {
		_fondosMutuos.setCodigoMoneda(codigoMoneda);
	}

	/**
	* Returns the tipo fondo of this fondos mutuos.
	*
	* @return the tipo fondo of this fondos mutuos
	*/
	public java.lang.String getTipoFondo() {
		return _fondosMutuos.getTipoFondo();
	}

	/**
	* Sets the tipo fondo of this fondos mutuos.
	*
	* @param tipoFondo the tipo fondo of this fondos mutuos
	*/
	public void setTipoFondo(java.lang.String tipoFondo) {
		_fondosMutuos.setTipoFondo(tipoFondo);
	}

	/**
	* Returns the valor cuota of this fondos mutuos.
	*
	* @return the valor cuota of this fondos mutuos
	*/
	public java.lang.Double getValorCuota() {
		return _fondosMutuos.getValorCuota();
	}

	/**
	* Sets the valor cuota of this fondos mutuos.
	*
	* @param valorCuota the valor cuota of this fondos mutuos
	*/
	public void setValorCuota(java.lang.Double valorCuota) {
		_fondosMutuos.setValorCuota(valorCuota);
	}

	/**
	* Returns the fecha of this fondos mutuos.
	*
	* @return the fecha of this fondos mutuos
	*/
	public java.lang.String getFecha() {
		return _fondosMutuos.getFecha();
	}

	/**
	* Sets the fecha of this fondos mutuos.
	*
	* @param fecha the fecha of this fondos mutuos
	*/
	public void setFecha(java.lang.String fecha) {
		_fondosMutuos.setFecha(fecha);
	}

	public boolean isNew() {
		return _fondosMutuos.isNew();
	}

	public void setNew(boolean n) {
		_fondosMutuos.setNew(n);
	}

	public boolean isCachedModel() {
		return _fondosMutuos.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_fondosMutuos.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _fondosMutuos.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _fondosMutuos.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fondosMutuos.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fondosMutuos.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fondosMutuos.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FondosMutuosWrapper((FondosMutuos)_fondosMutuos.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.FondosMutuos fondosMutuos) {
		return _fondosMutuos.compareTo(fondosMutuos);
	}

	@Override
	public int hashCode() {
		return _fondosMutuos.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.FondosMutuos> toCacheModel() {
		return _fondosMutuos.toCacheModel();
	}

	public com.ext.portlet.halcon.model.FondosMutuos toEscapedModel() {
		return new FondosMutuosWrapper(_fondosMutuos.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fondosMutuos.toString();
	}

	public java.lang.String toXmlString() {
		return _fondosMutuos.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fondosMutuos.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public FondosMutuos getWrappedFondosMutuos() {
		return _fondosMutuos;
	}

	public FondosMutuos getWrappedModel() {
		return _fondosMutuos;
	}

	public void resetOriginalValues() {
		_fondosMutuos.resetOriginalValues();
	}

	private FondosMutuos _fondosMutuos;
}