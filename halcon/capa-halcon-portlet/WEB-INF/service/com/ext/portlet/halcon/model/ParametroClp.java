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

import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class ParametroClp extends BaseModelImpl<Parametro> implements Parametro {
	public ParametroClp() {
	}

	public Class<?> getModelClass() {
		return Parametro.class;
	}

	public String getModelClassName() {
		return Parametro.class.getName();
	}

	public int getPrimaryKey() {
		return _idParametro;
	}

	public void setPrimaryKey(int primaryKey) {
		setIdParametro(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_idParametro);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
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

	@Override
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

	public int getIdParametro() {
		return _idParametro;
	}

	public void setIdParametro(int idParametro) {
		_idParametro = idParametro;
	}

	public Integer getIdParametroPadre() {
		return _idParametroPadre;
	}

	public void setIdParametroPadre(Integer idParametroPadre) {
		_idParametroPadre = idParametroPadre;
	}

	public String getValorMonto1() {
		return _valorMonto1;
	}

	public void setValorMonto1(String valorMonto1) {
		_valorMonto1 = valorMonto1;
	}

	public String getValorMonto2() {
		return _valorMonto2;
	}

	public void setValorMonto2(String valorMonto2) {
		_valorMonto2 = valorMonto2;
	}

	public String getValorMonto3() {
		return _valorMonto3;
	}

	public void setValorMonto3(String valorMonto3) {
		_valorMonto3 = valorMonto3;
	}

	public String getDato1() {
		return _dato1;
	}

	public void setDato1(String dato1) {
		_dato1 = dato1;
	}

	public String getDato2() {
		return _dato2;
	}

	public void setDato2(String dato2) {
		_dato2 = dato2;
	}

	public String getDato3() {
		return _dato3;
	}

	public void setDato3(String dato3) {
		_dato3 = dato3;
	}

	public String getDato4() {
		return _dato4;
	}

	public void setDato4(String dato4) {
		_dato4 = dato4;
	}

	public Integer getNum1() {
		return _num1;
	}

	public void setNum1(Integer num1) {
		_num1 = num1;
	}

	public Integer getNum2() {
		return _num2;
	}

	public void setNum2(Integer num2) {
		_num2 = num2;
	}

	public Integer getNum3() {
		return _num3;
	}

	public void setNum3(Integer num3) {
		_num3 = num3;
	}

	public BaseModel<?> getParametroRemoteModel() {
		return _parametroRemoteModel;
	}

	public void setParametroRemoteModel(BaseModel<?> parametroRemoteModel) {
		_parametroRemoteModel = parametroRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ParametroLocalServiceUtil.addParametro(this);
		}
		else {
			ParametroLocalServiceUtil.updateParametro(this);
		}
	}

	@Override
	public Parametro toEscapedModel() {
		return (Parametro)Proxy.newProxyInstance(Parametro.class.getClassLoader(),
			new Class[] { Parametro.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ParametroClp clone = new ParametroClp();

		clone.setIdParametro(getIdParametro());
		clone.setIdParametroPadre(getIdParametroPadre());
		clone.setValorMonto1(getValorMonto1());
		clone.setValorMonto2(getValorMonto2());
		clone.setValorMonto3(getValorMonto3());
		clone.setDato1(getDato1());
		clone.setDato2(getDato2());
		clone.setDato3(getDato3());
		clone.setDato4(getDato4());
		clone.setNum1(getNum1());
		clone.setNum2(getNum2());
		clone.setNum3(getNum3());

		return clone;
	}

	public int compareTo(Parametro parametro) {
		int primaryKey = parametro.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		ParametroClp parametro = null;

		try {
			parametro = (ParametroClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = parametro.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{idParametro=");
		sb.append(getIdParametro());
		sb.append(", idParametroPadre=");
		sb.append(getIdParametroPadre());
		sb.append(", valorMonto1=");
		sb.append(getValorMonto1());
		sb.append(", valorMonto2=");
		sb.append(getValorMonto2());
		sb.append(", valorMonto3=");
		sb.append(getValorMonto3());
		sb.append(", dato1=");
		sb.append(getDato1());
		sb.append(", dato2=");
		sb.append(getDato2());
		sb.append(", dato3=");
		sb.append(getDato3());
		sb.append(", dato4=");
		sb.append(getDato4());
		sb.append(", num1=");
		sb.append(getNum1());
		sb.append(", num2=");
		sb.append(getNum2());
		sb.append(", num3=");
		sb.append(getNum3());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.Parametro");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idParametro</column-name><column-value><![CDATA[");
		sb.append(getIdParametro());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idParametroPadre</column-name><column-value><![CDATA[");
		sb.append(getIdParametroPadre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorMonto1</column-name><column-value><![CDATA[");
		sb.append(getValorMonto1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorMonto2</column-name><column-value><![CDATA[");
		sb.append(getValorMonto2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorMonto3</column-name><column-value><![CDATA[");
		sb.append(getValorMonto3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dato1</column-name><column-value><![CDATA[");
		sb.append(getDato1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dato2</column-name><column-value><![CDATA[");
		sb.append(getDato2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dato3</column-name><column-value><![CDATA[");
		sb.append(getDato3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dato4</column-name><column-value><![CDATA[");
		sb.append(getDato4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>num1</column-name><column-value><![CDATA[");
		sb.append(getNum1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>num2</column-name><column-value><![CDATA[");
		sb.append(getNum2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>num3</column-name><column-value><![CDATA[");
		sb.append(getNum3());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _idParametro;
	private Integer _idParametroPadre;
	private String _valorMonto1;
	private String _valorMonto2;
	private String _valorMonto3;
	private String _dato1;
	private String _dato2;
	private String _dato3;
	private String _dato4;
	private Integer _num1;
	private Integer _num2;
	private Integer _num3;
	private BaseModel<?> _parametroRemoteModel;
}