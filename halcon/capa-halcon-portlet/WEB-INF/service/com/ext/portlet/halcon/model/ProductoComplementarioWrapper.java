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
 * This class is a wrapper for {@link ProductoComplementario}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       ProductoComplementario
 * @generated
 */
public class ProductoComplementarioWrapper implements ProductoComplementario,
	ModelWrapper<ProductoComplementario> {
	public ProductoComplementarioWrapper(
		ProductoComplementario productoComplementario) {
		_productoComplementario = productoComplementario;
	}

	public Class<?> getModelClass() {
		return ProductoComplementario.class;
	}

	public String getModelClassName() {
		return ProductoComplementario.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idProductoComplementario", getIdProductoComplementario());
		attributes.put("idSolicitudProducto", getIdSolicitudProducto());
		attributes.put("principalidad", getPrincipalidad());
		attributes.put("producto", getProducto());
		attributes.put("idProducto", getIdProducto());
		attributes.put("idGrupoProducto", getIdGrupoProducto());
		attributes.put("emailSupervisor", getEmailSupervisor());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idProductoComplementario = (Long)attributes.get(
				"idProductoComplementario");

		if (idProductoComplementario != null) {
			setIdProductoComplementario(idProductoComplementario);
		}

		Long idSolicitudProducto = (Long)attributes.get("idSolicitudProducto");

		if (idSolicitudProducto != null) {
			setIdSolicitudProducto(idSolicitudProducto);
		}

		String principalidad = (String)attributes.get("principalidad");

		if (principalidad != null) {
			setPrincipalidad(principalidad);
		}

		String producto = (String)attributes.get("producto");

		if (producto != null) {
			setProducto(producto);
		}

		String idProducto = (String)attributes.get("idProducto");

		if (idProducto != null) {
			setIdProducto(idProducto);
		}

		String idGrupoProducto = (String)attributes.get("idGrupoProducto");

		if (idGrupoProducto != null) {
			setIdGrupoProducto(idGrupoProducto);
		}

		String emailSupervisor = (String)attributes.get("emailSupervisor");

		if (emailSupervisor != null) {
			setEmailSupervisor(emailSupervisor);
		}
	}

	/**
	* Returns the primary key of this producto complementario.
	*
	* @return the primary key of this producto complementario
	*/
	public long getPrimaryKey() {
		return _productoComplementario.getPrimaryKey();
	}

	/**
	* Sets the primary key of this producto complementario.
	*
	* @param primaryKey the primary key of this producto complementario
	*/
	public void setPrimaryKey(long primaryKey) {
		_productoComplementario.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id producto complementario of this producto complementario.
	*
	* @return the id producto complementario of this producto complementario
	*/
	public long getIdProductoComplementario() {
		return _productoComplementario.getIdProductoComplementario();
	}

	/**
	* Sets the id producto complementario of this producto complementario.
	*
	* @param idProductoComplementario the id producto complementario of this producto complementario
	*/
	public void setIdProductoComplementario(long idProductoComplementario) {
		_productoComplementario.setIdProductoComplementario(idProductoComplementario);
	}

	/**
	* Returns the id solicitud producto of this producto complementario.
	*
	* @return the id solicitud producto of this producto complementario
	*/
	public long getIdSolicitudProducto() {
		return _productoComplementario.getIdSolicitudProducto();
	}

	/**
	* Sets the id solicitud producto of this producto complementario.
	*
	* @param idSolicitudProducto the id solicitud producto of this producto complementario
	*/
	public void setIdSolicitudProducto(long idSolicitudProducto) {
		_productoComplementario.setIdSolicitudProducto(idSolicitudProducto);
	}

	/**
	* Returns the principalidad of this producto complementario.
	*
	* @return the principalidad of this producto complementario
	*/
	public java.lang.String getPrincipalidad() {
		return _productoComplementario.getPrincipalidad();
	}

	/**
	* Sets the principalidad of this producto complementario.
	*
	* @param principalidad the principalidad of this producto complementario
	*/
	public void setPrincipalidad(java.lang.String principalidad) {
		_productoComplementario.setPrincipalidad(principalidad);
	}

	/**
	* Returns the producto of this producto complementario.
	*
	* @return the producto of this producto complementario
	*/
	public java.lang.String getProducto() {
		return _productoComplementario.getProducto();
	}

	/**
	* Sets the producto of this producto complementario.
	*
	* @param producto the producto of this producto complementario
	*/
	public void setProducto(java.lang.String producto) {
		_productoComplementario.setProducto(producto);
	}

	/**
	* Returns the id producto of this producto complementario.
	*
	* @return the id producto of this producto complementario
	*/
	public java.lang.String getIdProducto() {
		return _productoComplementario.getIdProducto();
	}

	/**
	* Sets the id producto of this producto complementario.
	*
	* @param idProducto the id producto of this producto complementario
	*/
	public void setIdProducto(java.lang.String idProducto) {
		_productoComplementario.setIdProducto(idProducto);
	}

	/**
	* Returns the id grupo producto of this producto complementario.
	*
	* @return the id grupo producto of this producto complementario
	*/
	public java.lang.String getIdGrupoProducto() {
		return _productoComplementario.getIdGrupoProducto();
	}

	/**
	* Sets the id grupo producto of this producto complementario.
	*
	* @param idGrupoProducto the id grupo producto of this producto complementario
	*/
	public void setIdGrupoProducto(java.lang.String idGrupoProducto) {
		_productoComplementario.setIdGrupoProducto(idGrupoProducto);
	}

	/**
	* Returns the email supervisor of this producto complementario.
	*
	* @return the email supervisor of this producto complementario
	*/
	public java.lang.String getEmailSupervisor() {
		return _productoComplementario.getEmailSupervisor();
	}

	/**
	* Sets the email supervisor of this producto complementario.
	*
	* @param emailSupervisor the email supervisor of this producto complementario
	*/
	public void setEmailSupervisor(java.lang.String emailSupervisor) {
		_productoComplementario.setEmailSupervisor(emailSupervisor);
	}

	public boolean isNew() {
		return _productoComplementario.isNew();
	}

	public void setNew(boolean n) {
		_productoComplementario.setNew(n);
	}

	public boolean isCachedModel() {
		return _productoComplementario.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_productoComplementario.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _productoComplementario.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _productoComplementario.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_productoComplementario.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _productoComplementario.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_productoComplementario.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductoComplementarioWrapper((ProductoComplementario)_productoComplementario.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario) {
		return _productoComplementario.compareTo(productoComplementario);
	}

	@Override
	public int hashCode() {
		return _productoComplementario.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.ProductoComplementario> toCacheModel() {
		return _productoComplementario.toCacheModel();
	}

	public com.ext.portlet.halcon.model.ProductoComplementario toEscapedModel() {
		return new ProductoComplementarioWrapper(_productoComplementario.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _productoComplementario.toString();
	}

	public java.lang.String toXmlString() {
		return _productoComplementario.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_productoComplementario.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ProductoComplementario getWrappedProductoComplementario() {
		return _productoComplementario;
	}

	public ProductoComplementario getWrappedModel() {
		return _productoComplementario;
	}

	public void resetOriginalValues() {
		_productoComplementario.resetOriginalValues();
	}

	private ProductoComplementario _productoComplementario;
}