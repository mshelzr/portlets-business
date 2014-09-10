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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ValorCuota}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       ValorCuota
 * @generated
 */
public class ValorCuotaWrapper implements ValorCuota, ModelWrapper<ValorCuota> {
	public ValorCuotaWrapper(ValorCuota valorCuota) {
		_valorCuota = valorCuota;
	}

	public Class<?> getModelClass() {
		return ValorCuota.class;
	}

	public String getModelClassName() {
		return ValorCuota.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("IdValorCuota", getIdValorCuota());
		attributes.put("tipoFondoMutuo", getTipoFondoMutuo());
		attributes.put("fecha", getFecha());
		attributes.put("valorCuota", getValorCuota());

		return attributes;
	}

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

	/**
	* Returns the primary key of this valor cuota.
	*
	* @return the primary key of this valor cuota
	*/
	public long getPrimaryKey() {
		return _valorCuota.getPrimaryKey();
	}

	/**
	* Sets the primary key of this valor cuota.
	*
	* @param primaryKey the primary key of this valor cuota
	*/
	public void setPrimaryKey(long primaryKey) {
		_valorCuota.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id valor cuota of this valor cuota.
	*
	* @return the id valor cuota of this valor cuota
	*/
	public long getIdValorCuota() {
		return _valorCuota.getIdValorCuota();
	}

	/**
	* Sets the id valor cuota of this valor cuota.
	*
	* @param IdValorCuota the id valor cuota of this valor cuota
	*/
	public void setIdValorCuota(long IdValorCuota) {
		_valorCuota.setIdValorCuota(IdValorCuota);
	}

	/**
	* Returns the tipo fondo mutuo of this valor cuota.
	*
	* @return the tipo fondo mutuo of this valor cuota
	*/
	public java.lang.Integer getTipoFondoMutuo() {
		return _valorCuota.getTipoFondoMutuo();
	}

	/**
	* Sets the tipo fondo mutuo of this valor cuota.
	*
	* @param tipoFondoMutuo the tipo fondo mutuo of this valor cuota
	*/
	public void setTipoFondoMutuo(java.lang.Integer tipoFondoMutuo) {
		_valorCuota.setTipoFondoMutuo(tipoFondoMutuo);
	}

	/**
	* Returns the fecha of this valor cuota.
	*
	* @return the fecha of this valor cuota
	*/
	public java.util.Date getFecha() {
		return _valorCuota.getFecha();
	}

	/**
	* Sets the fecha of this valor cuota.
	*
	* @param fecha the fecha of this valor cuota
	*/
	public void setFecha(java.util.Date fecha) {
		_valorCuota.setFecha(fecha);
	}

	/**
	* Returns the valor cuota of this valor cuota.
	*
	* @return the valor cuota of this valor cuota
	*/
	public java.lang.Double getValorCuota() {
		return _valorCuota.getValorCuota();
	}

	/**
	* Sets the valor cuota of this valor cuota.
	*
	* @param valorCuota the valor cuota of this valor cuota
	*/
	public void setValorCuota(java.lang.Double valorCuota) {
		_valorCuota.setValorCuota(valorCuota);
	}

	public boolean isNew() {
		return _valorCuota.isNew();
	}

	public void setNew(boolean n) {
		_valorCuota.setNew(n);
	}

	public boolean isCachedModel() {
		return _valorCuota.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_valorCuota.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _valorCuota.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _valorCuota.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_valorCuota.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _valorCuota.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_valorCuota.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ValorCuotaWrapper((ValorCuota)_valorCuota.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.ValorCuota valorCuota) {
		return _valorCuota.compareTo(valorCuota);
	}

	@Override
	public int hashCode() {
		return _valorCuota.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.ValorCuota> toCacheModel() {
		return _valorCuota.toCacheModel();
	}

	public com.ext.portlet.halcon.model.ValorCuota toEscapedModel() {
		return new ValorCuotaWrapper(_valorCuota.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _valorCuota.toString();
	}

	public java.lang.String toXmlString() {
		return _valorCuota.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_valorCuota.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ValorCuota getWrappedValorCuota() {
		return _valorCuota;
	}

	public ValorCuota getWrappedModel() {
		return _valorCuota;
	}

	public void resetOriginalValues() {
		_valorCuota.resetOriginalValues();
	}

	private ValorCuota _valorCuota;
}