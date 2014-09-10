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
 * This class is a wrapper for {@link Parametro}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       Parametro
 * @generated
 */
public class ParametroWrapper implements Parametro, ModelWrapper<Parametro> {
	public ParametroWrapper(Parametro parametro) {
		_parametro = parametro;
	}

	public Class<?> getModelClass() {
		return Parametro.class;
	}

	public String getModelClassName() {
		return Parametro.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idParametro", getIdParametro());
		attributes.put("idParametroPadre", getIdParametroPadre());
		attributes.put("valorMonto1", getValorMonto1());
		attributes.put("valorMonto2", getValorMonto2());
		attributes.put("valorMonto3", getValorMonto3());
		attributes.put("dato1", getDato1());
		attributes.put("dato2", getDato2());
		attributes.put("dato3", getDato3());
		attributes.put("dato4", getDato4());
		attributes.put("num1", getNum1());
		attributes.put("num2", getNum2());
		attributes.put("num3", getNum3());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idParametro = (Integer)attributes.get("idParametro");

		if (idParametro != null) {
			setIdParametro(idParametro);
		}

		Integer idParametroPadre = (Integer)attributes.get("idParametroPadre");

		if (idParametroPadre != null) {
			setIdParametroPadre(idParametroPadre);
		}

		String valorMonto1 = (String)attributes.get("valorMonto1");

		if (valorMonto1 != null) {
			setValorMonto1(valorMonto1);
		}

		String valorMonto2 = (String)attributes.get("valorMonto2");

		if (valorMonto2 != null) {
			setValorMonto2(valorMonto2);
		}

		String valorMonto3 = (String)attributes.get("valorMonto3");

		if (valorMonto3 != null) {
			setValorMonto3(valorMonto3);
		}

		String dato1 = (String)attributes.get("dato1");

		if (dato1 != null) {
			setDato1(dato1);
		}

		String dato2 = (String)attributes.get("dato2");

		if (dato2 != null) {
			setDato2(dato2);
		}

		String dato3 = (String)attributes.get("dato3");

		if (dato3 != null) {
			setDato3(dato3);
		}

		String dato4 = (String)attributes.get("dato4");

		if (dato4 != null) {
			setDato4(dato4);
		}

		Integer num1 = (Integer)attributes.get("num1");

		if (num1 != null) {
			setNum1(num1);
		}

		Integer num2 = (Integer)attributes.get("num2");

		if (num2 != null) {
			setNum2(num2);
		}

		Integer num3 = (Integer)attributes.get("num3");

		if (num3 != null) {
			setNum3(num3);
		}
	}

	/**
	* Returns the primary key of this parametro.
	*
	* @return the primary key of this parametro
	*/
	public int getPrimaryKey() {
		return _parametro.getPrimaryKey();
	}

	/**
	* Sets the primary key of this parametro.
	*
	* @param primaryKey the primary key of this parametro
	*/
	public void setPrimaryKey(int primaryKey) {
		_parametro.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id parametro of this parametro.
	*
	* @return the id parametro of this parametro
	*/
	public int getIdParametro() {
		return _parametro.getIdParametro();
	}

	/**
	* Sets the id parametro of this parametro.
	*
	* @param idParametro the id parametro of this parametro
	*/
	public void setIdParametro(int idParametro) {
		_parametro.setIdParametro(idParametro);
	}

	/**
	* Returns the id parametro padre of this parametro.
	*
	* @return the id parametro padre of this parametro
	*/
	public java.lang.Integer getIdParametroPadre() {
		return _parametro.getIdParametroPadre();
	}

	/**
	* Sets the id parametro padre of this parametro.
	*
	* @param idParametroPadre the id parametro padre of this parametro
	*/
	public void setIdParametroPadre(java.lang.Integer idParametroPadre) {
		_parametro.setIdParametroPadre(idParametroPadre);
	}

	/**
	* Returns the valor monto1 of this parametro.
	*
	* @return the valor monto1 of this parametro
	*/
	public java.lang.String getValorMonto1() {
		return _parametro.getValorMonto1();
	}

	/**
	* Sets the valor monto1 of this parametro.
	*
	* @param valorMonto1 the valor monto1 of this parametro
	*/
	public void setValorMonto1(java.lang.String valorMonto1) {
		_parametro.setValorMonto1(valorMonto1);
	}

	/**
	* Returns the valor monto2 of this parametro.
	*
	* @return the valor monto2 of this parametro
	*/
	public java.lang.String getValorMonto2() {
		return _parametro.getValorMonto2();
	}

	/**
	* Sets the valor monto2 of this parametro.
	*
	* @param valorMonto2 the valor monto2 of this parametro
	*/
	public void setValorMonto2(java.lang.String valorMonto2) {
		_parametro.setValorMonto2(valorMonto2);
	}

	/**
	* Returns the valor monto3 of this parametro.
	*
	* @return the valor monto3 of this parametro
	*/
	public java.lang.String getValorMonto3() {
		return _parametro.getValorMonto3();
	}

	/**
	* Sets the valor monto3 of this parametro.
	*
	* @param valorMonto3 the valor monto3 of this parametro
	*/
	public void setValorMonto3(java.lang.String valorMonto3) {
		_parametro.setValorMonto3(valorMonto3);
	}

	/**
	* Returns the dato1 of this parametro.
	*
	* @return the dato1 of this parametro
	*/
	public java.lang.String getDato1() {
		return _parametro.getDato1();
	}

	/**
	* Sets the dato1 of this parametro.
	*
	* @param dato1 the dato1 of this parametro
	*/
	public void setDato1(java.lang.String dato1) {
		_parametro.setDato1(dato1);
	}

	/**
	* Returns the dato2 of this parametro.
	*
	* @return the dato2 of this parametro
	*/
	public java.lang.String getDato2() {
		return _parametro.getDato2();
	}

	/**
	* Sets the dato2 of this parametro.
	*
	* @param dato2 the dato2 of this parametro
	*/
	public void setDato2(java.lang.String dato2) {
		_parametro.setDato2(dato2);
	}

	/**
	* Returns the dato3 of this parametro.
	*
	* @return the dato3 of this parametro
	*/
	public java.lang.String getDato3() {
		return _parametro.getDato3();
	}

	/**
	* Sets the dato3 of this parametro.
	*
	* @param dato3 the dato3 of this parametro
	*/
	public void setDato3(java.lang.String dato3) {
		_parametro.setDato3(dato3);
	}

	/**
	* Returns the dato4 of this parametro.
	*
	* @return the dato4 of this parametro
	*/
	public java.lang.String getDato4() {
		return _parametro.getDato4();
	}

	/**
	* Sets the dato4 of this parametro.
	*
	* @param dato4 the dato4 of this parametro
	*/
	public void setDato4(java.lang.String dato4) {
		_parametro.setDato4(dato4);
	}

	/**
	* Returns the num1 of this parametro.
	*
	* @return the num1 of this parametro
	*/
	public java.lang.Integer getNum1() {
		return _parametro.getNum1();
	}

	/**
	* Sets the num1 of this parametro.
	*
	* @param num1 the num1 of this parametro
	*/
	public void setNum1(java.lang.Integer num1) {
		_parametro.setNum1(num1);
	}

	/**
	* Returns the num2 of this parametro.
	*
	* @return the num2 of this parametro
	*/
	public java.lang.Integer getNum2() {
		return _parametro.getNum2();
	}

	/**
	* Sets the num2 of this parametro.
	*
	* @param num2 the num2 of this parametro
	*/
	public void setNum2(java.lang.Integer num2) {
		_parametro.setNum2(num2);
	}

	/**
	* Returns the num3 of this parametro.
	*
	* @return the num3 of this parametro
	*/
	public java.lang.Integer getNum3() {
		return _parametro.getNum3();
	}

	/**
	* Sets the num3 of this parametro.
	*
	* @param num3 the num3 of this parametro
	*/
	public void setNum3(java.lang.Integer num3) {
		_parametro.setNum3(num3);
	}

	public boolean isNew() {
		return _parametro.isNew();
	}

	public void setNew(boolean n) {
		_parametro.setNew(n);
	}

	public boolean isCachedModel() {
		return _parametro.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_parametro.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _parametro.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _parametro.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_parametro.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _parametro.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_parametro.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ParametroWrapper((Parametro)_parametro.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.Parametro parametro) {
		return _parametro.compareTo(parametro);
	}

	@Override
	public int hashCode() {
		return _parametro.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.Parametro> toCacheModel() {
		return _parametro.toCacheModel();
	}

	public com.ext.portlet.halcon.model.Parametro toEscapedModel() {
		return new ParametroWrapper(_parametro.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _parametro.toString();
	}

	public java.lang.String toXmlString() {
		return _parametro.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_parametro.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Parametro getWrappedParametro() {
		return _parametro;
	}

	public Parametro getWrappedModel() {
		return _parametro;
	}

	public void resetOriginalValues() {
		_parametro.resetOriginalValues();
	}

	private Parametro _parametro;
}