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
 * This class is a wrapper for {@link CargaSocioRemesa}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CargaSocioRemesa
 * @generated
 */
public class CargaSocioRemesaWrapper implements CargaSocioRemesa,
	ModelWrapper<CargaSocioRemesa> {
	public CargaSocioRemesaWrapper(CargaSocioRemesa cargaSocioRemesa) {
		_cargaSocioRemesa = cargaSocioRemesa;
	}

	public Class<?> getModelClass() {
		return CargaSocioRemesa.class;
	}

	public String getModelClassName() {
		return CargaSocioRemesa.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idSocioRemesa", getIdSocioRemesa());
		attributes.put("empresa", getEmpresa());
		attributes.put("paisCobertura", getPaisCobertura());
		attributes.put("paginaWeb", getPaginaWeb());
		attributes.put("telefono", getTelefono());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idSocioRemesa = (Long)attributes.get("idSocioRemesa");

		if (idSocioRemesa != null) {
			setIdSocioRemesa(idSocioRemesa);
		}

		String empresa = (String)attributes.get("empresa");

		if (empresa != null) {
			setEmpresa(empresa);
		}

		String paisCobertura = (String)attributes.get("paisCobertura");

		if (paisCobertura != null) {
			setPaisCobertura(paisCobertura);
		}

		String paginaWeb = (String)attributes.get("paginaWeb");

		if (paginaWeb != null) {
			setPaginaWeb(paginaWeb);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}
	}

	/**
	* Returns the primary key of this carga socio remesa.
	*
	* @return the primary key of this carga socio remesa
	*/
	public long getPrimaryKey() {
		return _cargaSocioRemesa.getPrimaryKey();
	}

	/**
	* Sets the primary key of this carga socio remesa.
	*
	* @param primaryKey the primary key of this carga socio remesa
	*/
	public void setPrimaryKey(long primaryKey) {
		_cargaSocioRemesa.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id socio remesa of this carga socio remesa.
	*
	* @return the id socio remesa of this carga socio remesa
	*/
	public long getIdSocioRemesa() {
		return _cargaSocioRemesa.getIdSocioRemesa();
	}

	/**
	* Sets the id socio remesa of this carga socio remesa.
	*
	* @param idSocioRemesa the id socio remesa of this carga socio remesa
	*/
	public void setIdSocioRemesa(long idSocioRemesa) {
		_cargaSocioRemesa.setIdSocioRemesa(idSocioRemesa);
	}

	/**
	* Returns the empresa of this carga socio remesa.
	*
	* @return the empresa of this carga socio remesa
	*/
	public java.lang.String getEmpresa() {
		return _cargaSocioRemesa.getEmpresa();
	}

	/**
	* Sets the empresa of this carga socio remesa.
	*
	* @param empresa the empresa of this carga socio remesa
	*/
	public void setEmpresa(java.lang.String empresa) {
		_cargaSocioRemesa.setEmpresa(empresa);
	}

	/**
	* Returns the pais cobertura of this carga socio remesa.
	*
	* @return the pais cobertura of this carga socio remesa
	*/
	public java.lang.String getPaisCobertura() {
		return _cargaSocioRemesa.getPaisCobertura();
	}

	/**
	* Sets the pais cobertura of this carga socio remesa.
	*
	* @param paisCobertura the pais cobertura of this carga socio remesa
	*/
	public void setPaisCobertura(java.lang.String paisCobertura) {
		_cargaSocioRemesa.setPaisCobertura(paisCobertura);
	}

	/**
	* Returns the pagina web of this carga socio remesa.
	*
	* @return the pagina web of this carga socio remesa
	*/
	public java.lang.String getPaginaWeb() {
		return _cargaSocioRemesa.getPaginaWeb();
	}

	/**
	* Sets the pagina web of this carga socio remesa.
	*
	* @param paginaWeb the pagina web of this carga socio remesa
	*/
	public void setPaginaWeb(java.lang.String paginaWeb) {
		_cargaSocioRemesa.setPaginaWeb(paginaWeb);
	}

	/**
	* Returns the telefono of this carga socio remesa.
	*
	* @return the telefono of this carga socio remesa
	*/
	public java.lang.String getTelefono() {
		return _cargaSocioRemesa.getTelefono();
	}

	/**
	* Sets the telefono of this carga socio remesa.
	*
	* @param telefono the telefono of this carga socio remesa
	*/
	public void setTelefono(java.lang.String telefono) {
		_cargaSocioRemesa.setTelefono(telefono);
	}

	public boolean isNew() {
		return _cargaSocioRemesa.isNew();
	}

	public void setNew(boolean n) {
		_cargaSocioRemesa.setNew(n);
	}

	public boolean isCachedModel() {
		return _cargaSocioRemesa.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cargaSocioRemesa.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cargaSocioRemesa.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cargaSocioRemesa.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cargaSocioRemesa.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cargaSocioRemesa.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cargaSocioRemesa.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CargaSocioRemesaWrapper((CargaSocioRemesa)_cargaSocioRemesa.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa) {
		return _cargaSocioRemesa.compareTo(cargaSocioRemesa);
	}

	@Override
	public int hashCode() {
		return _cargaSocioRemesa.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.CargaSocioRemesa> toCacheModel() {
		return _cargaSocioRemesa.toCacheModel();
	}

	public com.ext.portlet.halcon.model.CargaSocioRemesa toEscapedModel() {
		return new CargaSocioRemesaWrapper(_cargaSocioRemesa.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cargaSocioRemesa.toString();
	}

	public java.lang.String toXmlString() {
		return _cargaSocioRemesa.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cargaSocioRemesa.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CargaSocioRemesa getWrappedCargaSocioRemesa() {
		return _cargaSocioRemesa;
	}

	public CargaSocioRemesa getWrappedModel() {
		return _cargaSocioRemesa;
	}

	public void resetOriginalValues() {
		_cargaSocioRemesa.resetOriginalValues();
	}

	private CargaSocioRemesa _cargaSocioRemesa;
}