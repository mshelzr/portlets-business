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
 * This class is a wrapper for {@link ConfiguracionProducto}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       ConfiguracionProducto
 * @generated
 */
public class ConfiguracionProductoWrapper implements ConfiguracionProducto,
	ModelWrapper<ConfiguracionProducto> {
	public ConfiguracionProductoWrapper(
		ConfiguracionProducto configuracionProducto) {
		_configuracionProducto = configuracionProducto;
	}

	public Class<?> getModelClass() {
		return ConfiguracionProducto.class;
	}

	public String getModelClassName() {
		return ConfiguracionProducto.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idConfiguracionProducto", getIdConfiguracionProducto());
		attributes.put("idConfiguracionPerfilador",
			getIdConfiguracionPerfilador());
		attributes.put("idProducto", getIdProducto());
		attributes.put("nombreProducto", getNombreProducto());
		attributes.put("codigoSiebelProducto", getCodigoSiebelProducto());
		attributes.put("estadoConfiguracion", getEstadoConfiguracion());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idConfiguracionProducto = (Long)attributes.get(
				"idConfiguracionProducto");

		if (idConfiguracionProducto != null) {
			setIdConfiguracionProducto(idConfiguracionProducto);
		}

		Long idConfiguracionPerfilador = (Long)attributes.get(
				"idConfiguracionPerfilador");

		if (idConfiguracionPerfilador != null) {
			setIdConfiguracionPerfilador(idConfiguracionPerfilador);
		}

		Long idProducto = (Long)attributes.get("idProducto");

		if (idProducto != null) {
			setIdProducto(idProducto);
		}

		String nombreProducto = (String)attributes.get("nombreProducto");

		if (nombreProducto != null) {
			setNombreProducto(nombreProducto);
		}

		String codigoSiebelProducto = (String)attributes.get(
				"codigoSiebelProducto");

		if (codigoSiebelProducto != null) {
			setCodigoSiebelProducto(codigoSiebelProducto);
		}

		Integer estadoConfiguracion = (Integer)attributes.get(
				"estadoConfiguracion");

		if (estadoConfiguracion != null) {
			setEstadoConfiguracion(estadoConfiguracion);
		}
	}

	/**
	* Returns the primary key of this configuracion producto.
	*
	* @return the primary key of this configuracion producto
	*/
	public long getPrimaryKey() {
		return _configuracionProducto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this configuracion producto.
	*
	* @param primaryKey the primary key of this configuracion producto
	*/
	public void setPrimaryKey(long primaryKey) {
		_configuracionProducto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id configuracion producto of this configuracion producto.
	*
	* @return the id configuracion producto of this configuracion producto
	*/
	public long getIdConfiguracionProducto() {
		return _configuracionProducto.getIdConfiguracionProducto();
	}

	/**
	* Sets the id configuracion producto of this configuracion producto.
	*
	* @param idConfiguracionProducto the id configuracion producto of this configuracion producto
	*/
	public void setIdConfiguracionProducto(long idConfiguracionProducto) {
		_configuracionProducto.setIdConfiguracionProducto(idConfiguracionProducto);
	}

	/**
	* Returns the id configuracion perfilador of this configuracion producto.
	*
	* @return the id configuracion perfilador of this configuracion producto
	*/
	public java.lang.Long getIdConfiguracionPerfilador() {
		return _configuracionProducto.getIdConfiguracionPerfilador();
	}

	/**
	* Sets the id configuracion perfilador of this configuracion producto.
	*
	* @param idConfiguracionPerfilador the id configuracion perfilador of this configuracion producto
	*/
	public void setIdConfiguracionPerfilador(
		java.lang.Long idConfiguracionPerfilador) {
		_configuracionProducto.setIdConfiguracionPerfilador(idConfiguracionPerfilador);
	}

	/**
	* Returns the id producto of this configuracion producto.
	*
	* @return the id producto of this configuracion producto
	*/
	public java.lang.Long getIdProducto() {
		return _configuracionProducto.getIdProducto();
	}

	/**
	* Sets the id producto of this configuracion producto.
	*
	* @param idProducto the id producto of this configuracion producto
	*/
	public void setIdProducto(java.lang.Long idProducto) {
		_configuracionProducto.setIdProducto(idProducto);
	}

	/**
	* Returns the nombre producto of this configuracion producto.
	*
	* @return the nombre producto of this configuracion producto
	*/
	public java.lang.String getNombreProducto() {
		return _configuracionProducto.getNombreProducto();
	}

	/**
	* Sets the nombre producto of this configuracion producto.
	*
	* @param nombreProducto the nombre producto of this configuracion producto
	*/
	public void setNombreProducto(java.lang.String nombreProducto) {
		_configuracionProducto.setNombreProducto(nombreProducto);
	}

	/**
	* Returns the codigo siebel producto of this configuracion producto.
	*
	* @return the codigo siebel producto of this configuracion producto
	*/
	public java.lang.String getCodigoSiebelProducto() {
		return _configuracionProducto.getCodigoSiebelProducto();
	}

	/**
	* Sets the codigo siebel producto of this configuracion producto.
	*
	* @param codigoSiebelProducto the codigo siebel producto of this configuracion producto
	*/
	public void setCodigoSiebelProducto(java.lang.String codigoSiebelProducto) {
		_configuracionProducto.setCodigoSiebelProducto(codigoSiebelProducto);
	}

	/**
	* Returns the estado configuracion of this configuracion producto.
	*
	* @return the estado configuracion of this configuracion producto
	*/
	public java.lang.Integer getEstadoConfiguracion() {
		return _configuracionProducto.getEstadoConfiguracion();
	}

	/**
	* Sets the estado configuracion of this configuracion producto.
	*
	* @param estadoConfiguracion the estado configuracion of this configuracion producto
	*/
	public void setEstadoConfiguracion(java.lang.Integer estadoConfiguracion) {
		_configuracionProducto.setEstadoConfiguracion(estadoConfiguracion);
	}

	public boolean isNew() {
		return _configuracionProducto.isNew();
	}

	public void setNew(boolean n) {
		_configuracionProducto.setNew(n);
	}

	public boolean isCachedModel() {
		return _configuracionProducto.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_configuracionProducto.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _configuracionProducto.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _configuracionProducto.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_configuracionProducto.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _configuracionProducto.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_configuracionProducto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfiguracionProductoWrapper((ConfiguracionProducto)_configuracionProducto.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.ConfiguracionProducto configuracionProducto) {
		return _configuracionProducto.compareTo(configuracionProducto);
	}

	@Override
	public int hashCode() {
		return _configuracionProducto.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.ConfiguracionProducto> toCacheModel() {
		return _configuracionProducto.toCacheModel();
	}

	public com.ext.portlet.halcon.model.ConfiguracionProducto toEscapedModel() {
		return new ConfiguracionProductoWrapper(_configuracionProducto.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _configuracionProducto.toString();
	}

	public java.lang.String toXmlString() {
		return _configuracionProducto.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_configuracionProducto.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ConfiguracionProducto getWrappedConfiguracionProducto() {
		return _configuracionProducto;
	}

	public ConfiguracionProducto getWrappedModel() {
		return _configuracionProducto;
	}

	public void resetOriginalValues() {
		_configuracionProducto.resetOriginalValues();
	}

	private ConfiguracionProducto _configuracionProducto;
}