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
 * This class is a wrapper for {@link ConfiguracionPerfilador}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       ConfiguracionPerfilador
 * @generated
 */
public class ConfiguracionPerfiladorWrapper implements ConfiguracionPerfilador,
	ModelWrapper<ConfiguracionPerfilador> {
	public ConfiguracionPerfiladorWrapper(
		ConfiguracionPerfilador configuracionPerfilador) {
		_configuracionPerfilador = configuracionPerfilador;
	}

	public Class<?> getModelClass() {
		return ConfiguracionPerfilador.class;
	}

	public String getModelClassName() {
		return ConfiguracionPerfilador.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idConfiguracionPerfilador",
			getIdConfiguracionPerfilador());
		attributes.put("tipoVariable", getTipoVariable());
		attributes.put("nombreVariable", getNombreVariable());
		attributes.put("codigoClasificacion", getCodigoClasificacion());
		attributes.put("codigoVariablePadre", getCodigoVariablePadre());
		attributes.put("valor1", getValor1());
		attributes.put("valor2", getValor2());
		attributes.put("valor3", getValor3());
		attributes.put("estado", getEstado());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idConfiguracionPerfilador = (Long)attributes.get(
				"idConfiguracionPerfilador");

		if (idConfiguracionPerfilador != null) {
			setIdConfiguracionPerfilador(idConfiguracionPerfilador);
		}

		Long tipoVariable = (Long)attributes.get("tipoVariable");

		if (tipoVariable != null) {
			setTipoVariable(tipoVariable);
		}

		String nombreVariable = (String)attributes.get("nombreVariable");

		if (nombreVariable != null) {
			setNombreVariable(nombreVariable);
		}

		Long codigoClasificacion = (Long)attributes.get("codigoClasificacion");

		if (codigoClasificacion != null) {
			setCodigoClasificacion(codigoClasificacion);
		}

		Long codigoVariablePadre = (Long)attributes.get("codigoVariablePadre");

		if (codigoVariablePadre != null) {
			setCodigoVariablePadre(codigoVariablePadre);
		}

		String valor1 = (String)attributes.get("valor1");

		if (valor1 != null) {
			setValor1(valor1);
		}

		String valor2 = (String)attributes.get("valor2");

		if (valor2 != null) {
			setValor2(valor2);
		}

		String valor3 = (String)attributes.get("valor3");

		if (valor3 != null) {
			setValor3(valor3);
		}

		Integer estado = (Integer)attributes.get("estado");

		if (estado != null) {
			setEstado(estado);
		}
	}

	/**
	* Returns the primary key of this configuracion perfilador.
	*
	* @return the primary key of this configuracion perfilador
	*/
	public long getPrimaryKey() {
		return _configuracionPerfilador.getPrimaryKey();
	}

	/**
	* Sets the primary key of this configuracion perfilador.
	*
	* @param primaryKey the primary key of this configuracion perfilador
	*/
	public void setPrimaryKey(long primaryKey) {
		_configuracionPerfilador.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id configuracion perfilador of this configuracion perfilador.
	*
	* @return the id configuracion perfilador of this configuracion perfilador
	*/
	public long getIdConfiguracionPerfilador() {
		return _configuracionPerfilador.getIdConfiguracionPerfilador();
	}

	/**
	* Sets the id configuracion perfilador of this configuracion perfilador.
	*
	* @param idConfiguracionPerfilador the id configuracion perfilador of this configuracion perfilador
	*/
	public void setIdConfiguracionPerfilador(long idConfiguracionPerfilador) {
		_configuracionPerfilador.setIdConfiguracionPerfilador(idConfiguracionPerfilador);
	}

	/**
	* Returns the tipo variable of this configuracion perfilador.
	*
	* @return the tipo variable of this configuracion perfilador
	*/
	public java.lang.Long getTipoVariable() {
		return _configuracionPerfilador.getTipoVariable();
	}

	/**
	* Sets the tipo variable of this configuracion perfilador.
	*
	* @param tipoVariable the tipo variable of this configuracion perfilador
	*/
	public void setTipoVariable(java.lang.Long tipoVariable) {
		_configuracionPerfilador.setTipoVariable(tipoVariable);
	}

	/**
	* Returns the nombre variable of this configuracion perfilador.
	*
	* @return the nombre variable of this configuracion perfilador
	*/
	public java.lang.String getNombreVariable() {
		return _configuracionPerfilador.getNombreVariable();
	}

	/**
	* Sets the nombre variable of this configuracion perfilador.
	*
	* @param nombreVariable the nombre variable of this configuracion perfilador
	*/
	public void setNombreVariable(java.lang.String nombreVariable) {
		_configuracionPerfilador.setNombreVariable(nombreVariable);
	}

	/**
	* Returns the codigo clasificacion of this configuracion perfilador.
	*
	* @return the codigo clasificacion of this configuracion perfilador
	*/
	public java.lang.Long getCodigoClasificacion() {
		return _configuracionPerfilador.getCodigoClasificacion();
	}

	/**
	* Sets the codigo clasificacion of this configuracion perfilador.
	*
	* @param codigoClasificacion the codigo clasificacion of this configuracion perfilador
	*/
	public void setCodigoClasificacion(java.lang.Long codigoClasificacion) {
		_configuracionPerfilador.setCodigoClasificacion(codigoClasificacion);
	}

	/**
	* Returns the codigo variable padre of this configuracion perfilador.
	*
	* @return the codigo variable padre of this configuracion perfilador
	*/
	public java.lang.Long getCodigoVariablePadre() {
		return _configuracionPerfilador.getCodigoVariablePadre();
	}

	/**
	* Sets the codigo variable padre of this configuracion perfilador.
	*
	* @param codigoVariablePadre the codigo variable padre of this configuracion perfilador
	*/
	public void setCodigoVariablePadre(java.lang.Long codigoVariablePadre) {
		_configuracionPerfilador.setCodigoVariablePadre(codigoVariablePadre);
	}

	/**
	* Returns the valor1 of this configuracion perfilador.
	*
	* @return the valor1 of this configuracion perfilador
	*/
	public java.lang.String getValor1() {
		return _configuracionPerfilador.getValor1();
	}

	/**
	* Sets the valor1 of this configuracion perfilador.
	*
	* @param valor1 the valor1 of this configuracion perfilador
	*/
	public void setValor1(java.lang.String valor1) {
		_configuracionPerfilador.setValor1(valor1);
	}

	/**
	* Returns the valor2 of this configuracion perfilador.
	*
	* @return the valor2 of this configuracion perfilador
	*/
	public java.lang.String getValor2() {
		return _configuracionPerfilador.getValor2();
	}

	/**
	* Sets the valor2 of this configuracion perfilador.
	*
	* @param valor2 the valor2 of this configuracion perfilador
	*/
	public void setValor2(java.lang.String valor2) {
		_configuracionPerfilador.setValor2(valor2);
	}

	/**
	* Returns the valor3 of this configuracion perfilador.
	*
	* @return the valor3 of this configuracion perfilador
	*/
	public java.lang.String getValor3() {
		return _configuracionPerfilador.getValor3();
	}

	/**
	* Sets the valor3 of this configuracion perfilador.
	*
	* @param valor3 the valor3 of this configuracion perfilador
	*/
	public void setValor3(java.lang.String valor3) {
		_configuracionPerfilador.setValor3(valor3);
	}

	/**
	* Returns the estado of this configuracion perfilador.
	*
	* @return the estado of this configuracion perfilador
	*/
	public java.lang.Integer getEstado() {
		return _configuracionPerfilador.getEstado();
	}

	/**
	* Sets the estado of this configuracion perfilador.
	*
	* @param estado the estado of this configuracion perfilador
	*/
	public void setEstado(java.lang.Integer estado) {
		_configuracionPerfilador.setEstado(estado);
	}

	public boolean isNew() {
		return _configuracionPerfilador.isNew();
	}

	public void setNew(boolean n) {
		_configuracionPerfilador.setNew(n);
	}

	public boolean isCachedModel() {
		return _configuracionPerfilador.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_configuracionPerfilador.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _configuracionPerfilador.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _configuracionPerfilador.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_configuracionPerfilador.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _configuracionPerfilador.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_configuracionPerfilador.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfiguracionPerfiladorWrapper((ConfiguracionPerfilador)_configuracionPerfilador.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador) {
		return _configuracionPerfilador.compareTo(configuracionPerfilador);
	}

	@Override
	public int hashCode() {
		return _configuracionPerfilador.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.ConfiguracionPerfilador> toCacheModel() {
		return _configuracionPerfilador.toCacheModel();
	}

	public com.ext.portlet.halcon.model.ConfiguracionPerfilador toEscapedModel() {
		return new ConfiguracionPerfiladorWrapper(_configuracionPerfilador.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _configuracionPerfilador.toString();
	}

	public java.lang.String toXmlString() {
		return _configuracionPerfilador.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_configuracionPerfilador.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ConfiguracionPerfilador getWrappedConfiguracionPerfilador() {
		return _configuracionPerfilador;
	}

	public ConfiguracionPerfilador getWrappedModel() {
		return _configuracionPerfilador;
	}

	public void resetOriginalValues() {
		_configuracionPerfilador.resetOriginalValues();
	}

	private ConfiguracionPerfilador _configuracionPerfilador;
}