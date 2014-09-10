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
 * This class is a wrapper for {@link Ubigeo}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       Ubigeo
 * @generated
 */
public class UbigeoWrapper implements Ubigeo, ModelWrapper<Ubigeo> {
	public UbigeoWrapper(Ubigeo ubigeo) {
		_ubigeo = ubigeo;
	}

	public Class<?> getModelClass() {
		return Ubigeo.class;
	}

	public String getModelClassName() {
		return Ubigeo.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idUbigeo", getIdUbigeo());
		attributes.put("codigo", getCodigo());
		attributes.put("nombre", getNombre());
		attributes.put("codDepartamento", getCodDepartamento());
		attributes.put("codProvincia", getCodProvincia());
		attributes.put("codDistrito", getCodDistrito());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idUbigeo = (Long)attributes.get("idUbigeo");

		if (idUbigeo != null) {
			setIdUbigeo(idUbigeo);
		}

		String codigo = (String)attributes.get("codigo");

		if (codigo != null) {
			setCodigo(codigo);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String codDepartamento = (String)attributes.get("codDepartamento");

		if (codDepartamento != null) {
			setCodDepartamento(codDepartamento);
		}

		String codProvincia = (String)attributes.get("codProvincia");

		if (codProvincia != null) {
			setCodProvincia(codProvincia);
		}

		String codDistrito = (String)attributes.get("codDistrito");

		if (codDistrito != null) {
			setCodDistrito(codDistrito);
		}
	}

	/**
	* Returns the primary key of this ubigeo.
	*
	* @return the primary key of this ubigeo
	*/
	public long getPrimaryKey() {
		return _ubigeo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ubigeo.
	*
	* @param primaryKey the primary key of this ubigeo
	*/
	public void setPrimaryKey(long primaryKey) {
		_ubigeo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id ubigeo of this ubigeo.
	*
	* @return the id ubigeo of this ubigeo
	*/
	public long getIdUbigeo() {
		return _ubigeo.getIdUbigeo();
	}

	/**
	* Sets the id ubigeo of this ubigeo.
	*
	* @param idUbigeo the id ubigeo of this ubigeo
	*/
	public void setIdUbigeo(long idUbigeo) {
		_ubigeo.setIdUbigeo(idUbigeo);
	}

	/**
	* Returns the codigo of this ubigeo.
	*
	* @return the codigo of this ubigeo
	*/
	public java.lang.String getCodigo() {
		return _ubigeo.getCodigo();
	}

	/**
	* Sets the codigo of this ubigeo.
	*
	* @param codigo the codigo of this ubigeo
	*/
	public void setCodigo(java.lang.String codigo) {
		_ubigeo.setCodigo(codigo);
	}

	/**
	* Returns the nombre of this ubigeo.
	*
	* @return the nombre of this ubigeo
	*/
	public java.lang.String getNombre() {
		return _ubigeo.getNombre();
	}

	/**
	* Sets the nombre of this ubigeo.
	*
	* @param nombre the nombre of this ubigeo
	*/
	public void setNombre(java.lang.String nombre) {
		_ubigeo.setNombre(nombre);
	}

	/**
	* Returns the cod departamento of this ubigeo.
	*
	* @return the cod departamento of this ubigeo
	*/
	public java.lang.String getCodDepartamento() {
		return _ubigeo.getCodDepartamento();
	}

	/**
	* Sets the cod departamento of this ubigeo.
	*
	* @param codDepartamento the cod departamento of this ubigeo
	*/
	public void setCodDepartamento(java.lang.String codDepartamento) {
		_ubigeo.setCodDepartamento(codDepartamento);
	}

	/**
	* Returns the cod provincia of this ubigeo.
	*
	* @return the cod provincia of this ubigeo
	*/
	public java.lang.String getCodProvincia() {
		return _ubigeo.getCodProvincia();
	}

	/**
	* Sets the cod provincia of this ubigeo.
	*
	* @param codProvincia the cod provincia of this ubigeo
	*/
	public void setCodProvincia(java.lang.String codProvincia) {
		_ubigeo.setCodProvincia(codProvincia);
	}

	/**
	* Returns the cod distrito of this ubigeo.
	*
	* @return the cod distrito of this ubigeo
	*/
	public java.lang.String getCodDistrito() {
		return _ubigeo.getCodDistrito();
	}

	/**
	* Sets the cod distrito of this ubigeo.
	*
	* @param codDistrito the cod distrito of this ubigeo
	*/
	public void setCodDistrito(java.lang.String codDistrito) {
		_ubigeo.setCodDistrito(codDistrito);
	}

	public boolean isNew() {
		return _ubigeo.isNew();
	}

	public void setNew(boolean n) {
		_ubigeo.setNew(n);
	}

	public boolean isCachedModel() {
		return _ubigeo.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ubigeo.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ubigeo.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ubigeo.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ubigeo.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ubigeo.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ubigeo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UbigeoWrapper((Ubigeo)_ubigeo.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.Ubigeo ubigeo) {
		return _ubigeo.compareTo(ubigeo);
	}

	@Override
	public int hashCode() {
		return _ubigeo.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.Ubigeo> toCacheModel() {
		return _ubigeo.toCacheModel();
	}

	public com.ext.portlet.halcon.model.Ubigeo toEscapedModel() {
		return new UbigeoWrapper(_ubigeo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ubigeo.toString();
	}

	public java.lang.String toXmlString() {
		return _ubigeo.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ubigeo.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Ubigeo getWrappedUbigeo() {
		return _ubigeo;
	}

	public Ubigeo getWrappedModel() {
		return _ubigeo;
	}

	public void resetOriginalValues() {
		_ubigeo.resetOriginalValues();
	}

	private Ubigeo _ubigeo;
}