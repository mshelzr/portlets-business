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
 * This class is a wrapper for {@link Pais}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       Pais
 * @generated
 */
public class PaisWrapper implements Pais, ModelWrapper<Pais> {
	public PaisWrapper(Pais pais) {
		_pais = pais;
	}

	public Class<?> getModelClass() {
		return Pais.class;
	}

	public String getModelClassName() {
		return Pais.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pais_IdPais", getPais_IdPais());
		attributes.put("codigo", getCodigo());
		attributes.put("nombre", getNombre());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long pais_IdPais = (Long)attributes.get("pais_IdPais");

		if (pais_IdPais != null) {
			setPais_IdPais(pais_IdPais);
		}

		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}
	}

	/**
	* Returns the primary key of this pais.
	*
	* @return the primary key of this pais
	*/
	public long getPrimaryKey() {
		return _pais.getPrimaryKey();
	}

	/**
	* Sets the primary key of this pais.
	*
	* @param primaryKey the primary key of this pais
	*/
	public void setPrimaryKey(long primaryKey) {
		_pais.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the pais_ ID pais of this pais.
	*
	* @return the pais_ ID pais of this pais
	*/
	public long getPais_IdPais() {
		return _pais.getPais_IdPais();
	}

	/**
	* Sets the pais_ ID pais of this pais.
	*
	* @param pais_IdPais the pais_ ID pais of this pais
	*/
	public void setPais_IdPais(long pais_IdPais) {
		_pais.setPais_IdPais(pais_IdPais);
	}

	/**
	* Returns the codigo of this pais.
	*
	* @return the codigo of this pais
	*/
	public java.lang.String getCodigo() {
		return _pais.getCodigo();
	}

	/**
	* Sets the codigo of this pais.
	*
	* @param codigo the codigo of this pais
	*/
	public void setCodigo(java.lang.String codigo) {
		_pais.setCodigo(codigo);
	}

	/**
	* Returns the nombre of this pais.
	*
	* @return the nombre of this pais
	*/
	public java.lang.String getNombre() {
		return _pais.getNombre();
	}

	/**
	* Sets the nombre of this pais.
	*
	* @param nombre the nombre of this pais
	*/
	public void setNombre(java.lang.String nombre) {
		_pais.setNombre(nombre);
	}

	public boolean isNew() {
		return _pais.isNew();
	}

	public void setNew(boolean n) {
		_pais.setNew(n);
	}

	public boolean isCachedModel() {
		return _pais.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_pais.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _pais.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _pais.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_pais.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _pais.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_pais.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PaisWrapper((Pais)_pais.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.Pais pais) {
		return _pais.compareTo(pais);
	}

	@Override
	public int hashCode() {
		return _pais.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.Pais> toCacheModel() {
		return _pais.toCacheModel();
	}

	public com.ext.portlet.halcon.model.Pais toEscapedModel() {
		return new PaisWrapper(_pais.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _pais.toString();
	}

	public java.lang.String toXmlString() {
		return _pais.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_pais.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Pais getWrappedPais() {
		return _pais;
	}

	public Pais getWrappedModel() {
		return _pais;
	}

	public void resetOriginalValues() {
		_pais.resetOriginalValues();
	}

	private Pais _pais;
}