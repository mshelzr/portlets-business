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

import com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil;

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
public class CargaSocioRemesaClp extends BaseModelImpl<CargaSocioRemesa>
	implements CargaSocioRemesa {
	public CargaSocioRemesaClp() {
	}

	public Class<?> getModelClass() {
		return CargaSocioRemesa.class;
	}

	public String getModelClassName() {
		return CargaSocioRemesa.class.getName();
	}

	public long getPrimaryKey() {
		return _idSocioRemesa;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdSocioRemesa(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idSocioRemesa);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idSocioRemesa", getIdSocioRemesa());
		attributes.put("empresa", getEmpresa());
		attributes.put("paisCobertura", getPaisCobertura());
		attributes.put("paginaWeb", getPaginaWeb());
		attributes.put("telefono", getTelefono());

		return attributes;
	}

	@Override
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

	public long getIdSocioRemesa() {
		return _idSocioRemesa;
	}

	public void setIdSocioRemesa(long idSocioRemesa) {
		_idSocioRemesa = idSocioRemesa;
	}

	public String getEmpresa() {
		return _empresa;
	}

	public void setEmpresa(String empresa) {
		_empresa = empresa;
	}

	public String getPaisCobertura() {
		return _paisCobertura;
	}

	public void setPaisCobertura(String paisCobertura) {
		_paisCobertura = paisCobertura;
	}

	public String getPaginaWeb() {
		return _paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		_paginaWeb = paginaWeb;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public BaseModel<?> getCargaSocioRemesaRemoteModel() {
		return _cargaSocioRemesaRemoteModel;
	}

	public void setCargaSocioRemesaRemoteModel(
		BaseModel<?> cargaSocioRemesaRemoteModel) {
		_cargaSocioRemesaRemoteModel = cargaSocioRemesaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CargaSocioRemesaLocalServiceUtil.addCargaSocioRemesa(this);
		}
		else {
			CargaSocioRemesaLocalServiceUtil.updateCargaSocioRemesa(this);
		}
	}

	@Override
	public CargaSocioRemesa toEscapedModel() {
		return (CargaSocioRemesa)Proxy.newProxyInstance(CargaSocioRemesa.class.getClassLoader(),
			new Class[] { CargaSocioRemesa.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CargaSocioRemesaClp clone = new CargaSocioRemesaClp();

		clone.setIdSocioRemesa(getIdSocioRemesa());
		clone.setEmpresa(getEmpresa());
		clone.setPaisCobertura(getPaisCobertura());
		clone.setPaginaWeb(getPaginaWeb());
		clone.setTelefono(getTelefono());

		return clone;
	}

	public int compareTo(CargaSocioRemesa cargaSocioRemesa) {
		long primaryKey = cargaSocioRemesa.getPrimaryKey();

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

		CargaSocioRemesaClp cargaSocioRemesa = null;

		try {
			cargaSocioRemesa = (CargaSocioRemesaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = cargaSocioRemesa.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idSocioRemesa=");
		sb.append(getIdSocioRemesa());
		sb.append(", empresa=");
		sb.append(getEmpresa());
		sb.append(", paisCobertura=");
		sb.append(getPaisCobertura());
		sb.append(", paginaWeb=");
		sb.append(getPaginaWeb());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.CargaSocioRemesa");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idSocioRemesa</column-name><column-value><![CDATA[");
		sb.append(getIdSocioRemesa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empresa</column-name><column-value><![CDATA[");
		sb.append(getEmpresa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paisCobertura</column-name><column-value><![CDATA[");
		sb.append(getPaisCobertura());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paginaWeb</column-name><column-value><![CDATA[");
		sb.append(getPaginaWeb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idSocioRemesa;
	private String _empresa;
	private String _paisCobertura;
	private String _paginaWeb;
	private String _telefono;
	private BaseModel<?> _cargaSocioRemesaRemoteModel;
}