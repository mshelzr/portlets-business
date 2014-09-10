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
 * This class is a wrapper for {@link CategoriaSubcategoria}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CategoriaSubcategoria
 * @generated
 */
public class CategoriaSubcategoriaWrapper implements CategoriaSubcategoria,
	ModelWrapper<CategoriaSubcategoria> {
	public CategoriaSubcategoriaWrapper(
		CategoriaSubcategoria categoriaSubcategoria) {
		_categoriaSubcategoria = categoriaSubcategoria;
	}

	public Class<?> getModelClass() {
		return CategoriaSubcategoria.class;
	}

	public String getModelClassName() {
		return CategoriaSubcategoria.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCategoriaSubCat", getIdCategoriaSubCat());
		attributes.put("idCategoriaSubCatPadre", getIdCategoriaSubCatPadre());
		attributes.put("descripcion", getDescripcion());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCategoriaSubCat = (Long)attributes.get("idCategoriaSubCat");

		if (idCategoriaSubCat != null) {
			setIdCategoriaSubCat(idCategoriaSubCat);
		}

		Integer idCategoriaSubCatPadre = (Integer)attributes.get(
				"idCategoriaSubCatPadre");

		if (idCategoriaSubCatPadre != null) {
			setIdCategoriaSubCatPadre(idCategoriaSubCatPadre);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
		}
	}

	/**
	* Returns the primary key of this categoria subcategoria.
	*
	* @return the primary key of this categoria subcategoria
	*/
	public long getPrimaryKey() {
		return _categoriaSubcategoria.getPrimaryKey();
	}

	/**
	* Sets the primary key of this categoria subcategoria.
	*
	* @param primaryKey the primary key of this categoria subcategoria
	*/
	public void setPrimaryKey(long primaryKey) {
		_categoriaSubcategoria.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id categoria sub cat of this categoria subcategoria.
	*
	* @return the id categoria sub cat of this categoria subcategoria
	*/
	public long getIdCategoriaSubCat() {
		return _categoriaSubcategoria.getIdCategoriaSubCat();
	}

	/**
	* Sets the id categoria sub cat of this categoria subcategoria.
	*
	* @param idCategoriaSubCat the id categoria sub cat of this categoria subcategoria
	*/
	public void setIdCategoriaSubCat(long idCategoriaSubCat) {
		_categoriaSubcategoria.setIdCategoriaSubCat(idCategoriaSubCat);
	}

	/**
	* Returns the id categoria sub cat padre of this categoria subcategoria.
	*
	* @return the id categoria sub cat padre of this categoria subcategoria
	*/
	public java.lang.Integer getIdCategoriaSubCatPadre() {
		return _categoriaSubcategoria.getIdCategoriaSubCatPadre();
	}

	/**
	* Sets the id categoria sub cat padre of this categoria subcategoria.
	*
	* @param idCategoriaSubCatPadre the id categoria sub cat padre of this categoria subcategoria
	*/
	public void setIdCategoriaSubCatPadre(
		java.lang.Integer idCategoriaSubCatPadre) {
		_categoriaSubcategoria.setIdCategoriaSubCatPadre(idCategoriaSubCatPadre);
	}

	/**
	* Returns the descripcion of this categoria subcategoria.
	*
	* @return the descripcion of this categoria subcategoria
	*/
	public java.lang.String getDescripcion() {
		return _categoriaSubcategoria.getDescripcion();
	}

	/**
	* Sets the descripcion of this categoria subcategoria.
	*
	* @param descripcion the descripcion of this categoria subcategoria
	*/
	public void setDescripcion(java.lang.String descripcion) {
		_categoriaSubcategoria.setDescripcion(descripcion);
	}

	public boolean isNew() {
		return _categoriaSubcategoria.isNew();
	}

	public void setNew(boolean n) {
		_categoriaSubcategoria.setNew(n);
	}

	public boolean isCachedModel() {
		return _categoriaSubcategoria.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_categoriaSubcategoria.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _categoriaSubcategoria.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _categoriaSubcategoria.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_categoriaSubcategoria.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _categoriaSubcategoria.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_categoriaSubcategoria.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CategoriaSubcategoriaWrapper((CategoriaSubcategoria)_categoriaSubcategoria.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria) {
		return _categoriaSubcategoria.compareTo(categoriaSubcategoria);
	}

	@Override
	public int hashCode() {
		return _categoriaSubcategoria.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.CategoriaSubcategoria> toCacheModel() {
		return _categoriaSubcategoria.toCacheModel();
	}

	public com.ext.portlet.halcon.model.CategoriaSubcategoria toEscapedModel() {
		return new CategoriaSubcategoriaWrapper(_categoriaSubcategoria.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _categoriaSubcategoria.toString();
	}

	public java.lang.String toXmlString() {
		return _categoriaSubcategoria.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_categoriaSubcategoria.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CategoriaSubcategoria getWrappedCategoriaSubcategoria() {
		return _categoriaSubcategoria;
	}

	public CategoriaSubcategoria getWrappedModel() {
		return _categoriaSubcategoria;
	}

	public void resetOriginalValues() {
		_categoriaSubcategoria.resetOriginalValues();
	}

	private CategoriaSubcategoria _categoriaSubcategoria;
}