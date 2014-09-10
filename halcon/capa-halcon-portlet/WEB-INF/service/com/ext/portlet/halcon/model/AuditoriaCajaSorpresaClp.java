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

import com.ext.portlet.halcon.service.AuditoriaCajaSorpresaLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Infonet-Consulting
 */
public class AuditoriaCajaSorpresaClp extends BaseModelImpl<AuditoriaCajaSorpresa>
	implements AuditoriaCajaSorpresa {
	public AuditoriaCajaSorpresaClp() {
	}

	public Class<?> getModelClass() {
		return AuditoriaCajaSorpresa.class;
	}

	public String getModelClassName() {
		return AuditoriaCajaSorpresa.class.getName();
	}

	public long getPrimaryKey() {
		return _idAuditoriaCajSorp;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdAuditoriaCajSorp(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idAuditoriaCajSorp);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAuditoriaCajSorp", getIdAuditoriaCajSorp());
		attributes.put("idTransaccion", getIdTransaccion());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numDocumento", getNumDocumento());
		attributes.put("producto1", getProducto1());
		attributes.put("producto2", getProducto2());
		attributes.put("producto3", getProducto3());
		attributes.put("producto4", getProducto4());
		attributes.put("codProducto1", getCodProducto1());
		attributes.put("codProducto2", getCodProducto2());
		attributes.put("codProducto3", getCodProducto3());
		attributes.put("codProducto4", getCodProducto4());
		attributes.put("IP", getIP());
		attributes.put("session", getSession());
		attributes.put("fechaHora", getFechaHora());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAuditoriaCajSorp = (Long)attributes.get("idAuditoriaCajSorp");

		if (idAuditoriaCajSorp != null) {
			setIdAuditoriaCajSorp(idAuditoriaCajSorp);
		}

		String idTransaccion = (String)attributes.get("idTransaccion");

		if (idTransaccion != null) {
			setIdTransaccion(idTransaccion);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String numDocumento = (String)attributes.get("numDocumento");

		if (numDocumento != null) {
			setNumDocumento(numDocumento);
		}

		String producto1 = (String)attributes.get("producto1");

		if (producto1 != null) {
			setProducto1(producto1);
		}

		String producto2 = (String)attributes.get("producto2");

		if (producto2 != null) {
			setProducto2(producto2);
		}

		String producto3 = (String)attributes.get("producto3");

		if (producto3 != null) {
			setProducto3(producto3);
		}

		String producto4 = (String)attributes.get("producto4");

		if (producto4 != null) {
			setProducto4(producto4);
		}

		String codProducto1 = (String)attributes.get("codProducto1");

		if (codProducto1 != null) {
			setCodProducto1(codProducto1);
		}

		String codProducto2 = (String)attributes.get("codProducto2");

		if (codProducto2 != null) {
			setCodProducto2(codProducto2);
		}

		String codProducto3 = (String)attributes.get("codProducto3");

		if (codProducto3 != null) {
			setCodProducto3(codProducto3);
		}

		String codProducto4 = (String)attributes.get("codProducto4");

		if (codProducto4 != null) {
			setCodProducto4(codProducto4);
		}

		String IP = (String)attributes.get("IP");

		if (IP != null) {
			setIP(IP);
		}

		String session = (String)attributes.get("session");

		if (session != null) {
			setSession(session);
		}

		Date fechaHora = (Date)attributes.get("fechaHora");

		if (fechaHora != null) {
			setFechaHora(fechaHora);
		}

		String UTMSource = (String)attributes.get("UTMSource");

		if (UTMSource != null) {
			setUTMSource(UTMSource);
		}

		String UTMMedium = (String)attributes.get("UTMMedium");

		if (UTMMedium != null) {
			setUTMMedium(UTMMedium);
		}

		String UTMCampaing = (String)attributes.get("UTMCampaing");

		if (UTMCampaing != null) {
			setUTMCampaing(UTMCampaing);
		}

		String UTMContent = (String)attributes.get("UTMContent");

		if (UTMContent != null) {
			setUTMContent(UTMContent);
		}
	}

	public long getIdAuditoriaCajSorp() {
		return _idAuditoriaCajSorp;
	}

	public void setIdAuditoriaCajSorp(long idAuditoriaCajSorp) {
		_idAuditoriaCajSorp = idAuditoriaCajSorp;
	}

	public String getIdTransaccion() {
		return _idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		_idTransaccion = idTransaccion;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return _numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		_numDocumento = numDocumento;
	}

	public String getProducto1() {
		return _producto1;
	}

	public void setProducto1(String producto1) {
		_producto1 = producto1;
	}

	public String getProducto2() {
		return _producto2;
	}

	public void setProducto2(String producto2) {
		_producto2 = producto2;
	}

	public String getProducto3() {
		return _producto3;
	}

	public void setProducto3(String producto3) {
		_producto3 = producto3;
	}

	public String getProducto4() {
		return _producto4;
	}

	public void setProducto4(String producto4) {
		_producto4 = producto4;
	}

	public String getCodProducto1() {
		return _codProducto1;
	}

	public void setCodProducto1(String codProducto1) {
		_codProducto1 = codProducto1;
	}

	public String getCodProducto2() {
		return _codProducto2;
	}

	public void setCodProducto2(String codProducto2) {
		_codProducto2 = codProducto2;
	}

	public String getCodProducto3() {
		return _codProducto3;
	}

	public void setCodProducto3(String codProducto3) {
		_codProducto3 = codProducto3;
	}

	public String getCodProducto4() {
		return _codProducto4;
	}

	public void setCodProducto4(String codProducto4) {
		_codProducto4 = codProducto4;
	}

	public String getIP() {
		return _IP;
	}

	public void setIP(String IP) {
		_IP = IP;
	}

	public String getSession() {
		return _session;
	}

	public void setSession(String session) {
		_session = session;
	}

	public Date getFechaHora() {
		return _fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		_fechaHora = fechaHora;
	}

	public String getUTMSource() {
		return _UTMSource;
	}

	public void setUTMSource(String UTMSource) {
		_UTMSource = UTMSource;
	}

	public String getUTMMedium() {
		return _UTMMedium;
	}

	public void setUTMMedium(String UTMMedium) {
		_UTMMedium = UTMMedium;
	}

	public String getUTMCampaing() {
		return _UTMCampaing;
	}

	public void setUTMCampaing(String UTMCampaing) {
		_UTMCampaing = UTMCampaing;
	}

	public String getUTMContent() {
		return _UTMContent;
	}

	public void setUTMContent(String UTMContent) {
		_UTMContent = UTMContent;
	}

	public BaseModel<?> getAuditoriaCajaSorpresaRemoteModel() {
		return _auditoriaCajaSorpresaRemoteModel;
	}

	public void setAuditoriaCajaSorpresaRemoteModel(
		BaseModel<?> auditoriaCajaSorpresaRemoteModel) {
		_auditoriaCajaSorpresaRemoteModel = auditoriaCajaSorpresaRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AuditoriaCajaSorpresaLocalServiceUtil.addAuditoriaCajaSorpresa(this);
		}
		else {
			AuditoriaCajaSorpresaLocalServiceUtil.updateAuditoriaCajaSorpresa(this);
		}
	}

	@Override
	public AuditoriaCajaSorpresa toEscapedModel() {
		return (AuditoriaCajaSorpresa)Proxy.newProxyInstance(AuditoriaCajaSorpresa.class.getClassLoader(),
			new Class[] { AuditoriaCajaSorpresa.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuditoriaCajaSorpresaClp clone = new AuditoriaCajaSorpresaClp();

		clone.setIdAuditoriaCajSorp(getIdAuditoriaCajSorp());
		clone.setIdTransaccion(getIdTransaccion());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setNumDocumento(getNumDocumento());
		clone.setProducto1(getProducto1());
		clone.setProducto2(getProducto2());
		clone.setProducto3(getProducto3());
		clone.setProducto4(getProducto4());
		clone.setCodProducto1(getCodProducto1());
		clone.setCodProducto2(getCodProducto2());
		clone.setCodProducto3(getCodProducto3());
		clone.setCodProducto4(getCodProducto4());
		clone.setIP(getIP());
		clone.setSession(getSession());
		clone.setFechaHora(getFechaHora());
		clone.setUTMSource(getUTMSource());
		clone.setUTMMedium(getUTMMedium());
		clone.setUTMCampaing(getUTMCampaing());
		clone.setUTMContent(getUTMContent());

		return clone;
	}

	public int compareTo(AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		long primaryKey = auditoriaCajaSorpresa.getPrimaryKey();

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

		AuditoriaCajaSorpresaClp auditoriaCajaSorpresa = null;

		try {
			auditoriaCajaSorpresa = (AuditoriaCajaSorpresaClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = auditoriaCajaSorpresa.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{idAuditoriaCajSorp=");
		sb.append(getIdAuditoriaCajSorp());
		sb.append(", idTransaccion=");
		sb.append(getIdTransaccion());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", numDocumento=");
		sb.append(getNumDocumento());
		sb.append(", producto1=");
		sb.append(getProducto1());
		sb.append(", producto2=");
		sb.append(getProducto2());
		sb.append(", producto3=");
		sb.append(getProducto3());
		sb.append(", producto4=");
		sb.append(getProducto4());
		sb.append(", codProducto1=");
		sb.append(getCodProducto1());
		sb.append(", codProducto2=");
		sb.append(getCodProducto2());
		sb.append(", codProducto3=");
		sb.append(getCodProducto3());
		sb.append(", codProducto4=");
		sb.append(getCodProducto4());
		sb.append(", IP=");
		sb.append(getIP());
		sb.append(", session=");
		sb.append(getSession());
		sb.append(", fechaHora=");
		sb.append(getFechaHora());
		sb.append(", UTMSource=");
		sb.append(getUTMSource());
		sb.append(", UTMMedium=");
		sb.append(getUTMMedium());
		sb.append(", UTMCampaing=");
		sb.append(getUTMCampaing());
		sb.append(", UTMContent=");
		sb.append(getUTMContent());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.AuditoriaCajaSorpresa");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idAuditoriaCajSorp</column-name><column-value><![CDATA[");
		sb.append(getIdAuditoriaCajSorp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idTransaccion</column-name><column-value><![CDATA[");
		sb.append(getIdTransaccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto1</column-name><column-value><![CDATA[");
		sb.append(getProducto1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto2</column-name><column-value><![CDATA[");
		sb.append(getProducto2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto3</column-name><column-value><![CDATA[");
		sb.append(getProducto3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>producto4</column-name><column-value><![CDATA[");
		sb.append(getProducto4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto1</column-name><column-value><![CDATA[");
		sb.append(getCodProducto1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto2</column-name><column-value><![CDATA[");
		sb.append(getCodProducto2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto3</column-name><column-value><![CDATA[");
		sb.append(getCodProducto3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>codProducto4</column-name><column-value><![CDATA[");
		sb.append(getCodProducto4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IP</column-name><column-value><![CDATA[");
		sb.append(getIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>session</column-name><column-value><![CDATA[");
		sb.append(getSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fechaHora</column-name><column-value><![CDATA[");
		sb.append(getFechaHora());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMSource</column-name><column-value><![CDATA[");
		sb.append(getUTMSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMMedium</column-name><column-value><![CDATA[");
		sb.append(getUTMMedium());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMCampaing</column-name><column-value><![CDATA[");
		sb.append(getUTMCampaing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>UTMContent</column-name><column-value><![CDATA[");
		sb.append(getUTMContent());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idAuditoriaCajSorp;
	private String _idTransaccion;
	private String _tipoDocumento;
	private String _numDocumento;
	private String _producto1;
	private String _producto2;
	private String _producto3;
	private String _producto4;
	private String _codProducto1;
	private String _codProducto2;
	private String _codProducto3;
	private String _codProducto4;
	private String _IP;
	private String _session;
	private Date _fechaHora;
	private String _UTMSource;
	private String _UTMMedium;
	private String _UTMCampaing;
	private String _UTMContent;
	private BaseModel<?> _auditoriaCajaSorpresaRemoteModel;
}