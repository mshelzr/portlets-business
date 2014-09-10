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

package com.ext.portlet.pin.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Categoria}.
 * </p>
 *
 * @author    arodriguez
 * @see       Categoria
 * @generated
 */
public class CategoriaWrapper implements Categoria, ModelWrapper<Categoria> {
	public CategoriaWrapper(Categoria categoria) {
		_categoria = categoria;
	}

	public Class<?> getModelClass() {
		return Categoria.class;
	}

	public String getModelClassName() {
		return Categoria.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoriaId", getCategoriaId());
		attributes.put("idImagen", getIdImagen());
		attributes.put("nombre", getNombre());
		attributes.put("estado", getEstado());
		attributes.put("descripcion", getDescripcion());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoriaId = (Long)attributes.get("categoriaId");

		if (categoriaId != null) {
			setCategoriaId(categoriaId);
		}

		Long idImagen = (Long)attributes.get("idImagen");

		if (idImagen != null) {
			setIdImagen(idImagen);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		Boolean estado = (Boolean)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}
	}

	/**
	* Returns the primary key of this categoria.
	*
	* @return the primary key of this categoria
	*/
	public long getPrimaryKey() {
		return _categoria.getPrimaryKey();
	}

	/**
	* Sets the primary key of this categoria.
	*
	* @param primaryKey the primary key of this categoria
	*/
	public void setPrimaryKey(long primaryKey) {
		_categoria.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the categoria ID of this categoria.
	*
	* @return the categoria ID of this categoria
	*/
	public long getCategoriaId() {
		return _categoria.getCategoriaId();
	}

	/**
	* Sets the categoria ID of this categoria.
	*
	* @param categoriaId the categoria ID of this categoria
	*/
	public void setCategoriaId(long categoriaId) {
		_categoria.setCategoriaId(categoriaId);
	}

	/**
	* Returns the id imagen of this categoria.
	*
	* @return the id imagen of this categoria
	*/
	public long getIdImagen() {
		return _categoria.getIdImagen();
	}

	/**
	* Sets the id imagen of this categoria.
	*
	* @param idImagen the id imagen of this categoria
	*/
	public void setIdImagen(long idImagen) {
		_categoria.setIdImagen(idImagen);
	}

	/**
	* Returns the nombre of this categoria.
	*
	* @return the nombre of this categoria
	*/
	public java.lang.String getNombre() {
		return _categoria.getNombre();
	}

	/**
	* Sets the nombre of this categoria.
	*
	* @param nombre the nombre of this categoria
	*/
	public void setNombre(java.lang.String nombre) {
		_categoria.setNombre(nombre);
	}

	/**
	* Returns the estado of this categoria.
	*
	* @return the estado of this categoria
	*/
	public boolean getEstado() {
		return _categoria.getEstado();
	}

	/**
	* Returns <code>true</code> if this categoria is estado.
	*
	* @return <code>true</code> if this categoria is estado; <code>false</code> otherwise
	*/
	public boolean isEstado() {
		return _categoria.isEstado();
	}

	/**
	* Sets whether this categoria is estado.
	*
	* @param estado the estado of this categoria
	*/
	public void setEstado(boolean estado) {
		_categoria.setEstado(estado);
	}

	/**
	* Returns the descripcion of this categoria.
	*
	* @return the descripcion of this categoria
	*/
	public java.lang.String getDescripcion() {
		return _categoria.getDescripcion();
	}

	/**
	* Sets the descripcion of this categoria.
	*
	* @param descripcion the descripcion of this categoria
	*/
	public void setDescripcion(java.lang.String descripcion) {
		_categoria.setDescripcion(descripcion);
	}

	public boolean isNew() {
		return _categoria.isNew();
	}

	public void setNew(boolean n) {
		_categoria.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoria.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoria.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoria.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoria.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoria.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoria.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoria.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoriaWrapper((Categoria)_categoria.clone());
	}

	public int compareTo(com.ext.portlet.pin.model.Categoria categoria) {
		return _categoria.compareTo(categoria);
	}

	@Override
	public int hashCode() {
		return _categoria.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.pin.model.Categoria> toCacheModel() {
		return _categoria.toCacheModel();
	}

	public com.ext.portlet.pin.model.Categoria toEscapedModel() {
		return new CategoriaWrapper(_categoria.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoria.toString();
	}

	public java.lang.String toXmlString() {
		return _categoria.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoria.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Categoria getWrappedCategoria() {
		return _categoria;
	}

	public Categoria getWrappedModel() {
		return _categoria;
	}

	public void resetOriginalValues() {
		_categoria.resetOriginalValues();
	}

	private Categoria _categoria;
}