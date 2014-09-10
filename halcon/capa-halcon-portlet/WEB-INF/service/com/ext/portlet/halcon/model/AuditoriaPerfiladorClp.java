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

import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil;

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
public class AuditoriaPerfiladorClp extends BaseModelImpl<AuditoriaPerfilador>
	implements AuditoriaPerfilador {
	public AuditoriaPerfiladorClp() {
	}

	public Class<?> getModelClass() {
		return AuditoriaPerfilador.class;
	}

	public String getModelClassName() {
		return AuditoriaPerfilador.class.getName();
	}

	public long getPrimaryKey() {
		return _idAuditoriaPer;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdAuditoriaPer(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idAuditoriaPer);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAuditoriaPer", getIdAuditoriaPer());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numeroDocumento", getNumeroDocumento());
		attributes.put("perfilador", getPerfilador());
		attributes.put("session", getSession());
		attributes.put("transaccion", getTransaccion());
		attributes.put("monto", getMonto());
		attributes.put("tipoCredito", getTipoCredito());
		attributes.put("IP", getIP());
		attributes.put("fechaHora", getFechaHora());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());
		attributes.put("pregunta01", getPregunta01());
		attributes.put("pregunta02", getPregunta02());
		attributes.put("pregunta03", getPregunta03());
		attributes.put("pregunta04", getPregunta04());
		attributes.put("respuesta01", getRespuesta01());
		attributes.put("respuesta02", getRespuesta02());
		attributes.put("respuesta03", getRespuesta03());
		attributes.put("respuesta04", getRespuesta04());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAuditoriaPer = (Long)attributes.get("idAuditoriaPer");

		if (idAuditoriaPer != null) {
			setIdAuditoriaPer(idAuditoriaPer);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String numeroDocumento = (String)attributes.get("numeroDocumento");

		if (numeroDocumento != null) {
			setNumeroDocumento(numeroDocumento);
		}

		String perfilador = (String)attributes.get("perfilador");

		if (perfilador != null) {
			setPerfilador(perfilador);
		}

		String session = (String)attributes.get("session");

		if (session != null) {
			setSession(session);
		}

		String transaccion = (String)attributes.get("transaccion");

		if (transaccion != null) {
			setTransaccion(transaccion);
		}

		Double monto = (Double)attributes.get("monto");

		if (monto != null) {
			setMonto(monto);
		}

		String tipoCredito = (String)attributes.get("tipoCredito");

		if (tipoCredito != null) {
			setTipoCredito(tipoCredito);
		}

		String IP = (String)attributes.get("IP");

		if (IP != null) {
			setIP(IP);
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

		String pregunta01 = (String)attributes.get("pregunta01");

		if (pregunta01 != null) {
			setPregunta01(pregunta01);
		}

		String pregunta02 = (String)attributes.get("pregunta02");

		if (pregunta02 != null) {
			setPregunta02(pregunta02);
		}

		String pregunta03 = (String)attributes.get("pregunta03");

		if (pregunta03 != null) {
			setPregunta03(pregunta03);
		}

		String pregunta04 = (String)attributes.get("pregunta04");

		if (pregunta04 != null) {
			setPregunta04(pregunta04);
		}

		String respuesta01 = (String)attributes.get("respuesta01");

		if (respuesta01 != null) {
			setRespuesta01(respuesta01);
		}

		String respuesta02 = (String)attributes.get("respuesta02");

		if (respuesta02 != null) {
			setRespuesta02(respuesta02);
		}

		String respuesta03 = (String)attributes.get("respuesta03");

		if (respuesta03 != null) {
			setRespuesta03(respuesta03);
		}

		String respuesta04 = (String)attributes.get("respuesta04");

		if (respuesta04 != null) {
			setRespuesta04(respuesta04);
		}
	}

	public long getIdAuditoriaPer() {
		return _idAuditoriaPer;
	}

	public void setIdAuditoriaPer(long idAuditoriaPer) {
		_idAuditoriaPer = idAuditoriaPer;
	}

	public String getTipoDocumento() {
		return _tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		_tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return _numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		_numeroDocumento = numeroDocumento;
	}

	public String getPerfilador() {
		return _perfilador;
	}

	public void setPerfilador(String perfilador) {
		_perfilador = perfilador;
	}

	public String getSession() {
		return _session;
	}

	public void setSession(String session) {
		_session = session;
	}

	public String getTransaccion() {
		return _transaccion;
	}

	public void setTransaccion(String transaccion) {
		_transaccion = transaccion;
	}

	public Double getMonto() {
		return _monto;
	}

	public void setMonto(Double monto) {
		_monto = monto;
	}

	public String getTipoCredito() {
		return _tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		_tipoCredito = tipoCredito;
	}

	public String getIP() {
		return _IP;
	}

	public void setIP(String IP) {
		_IP = IP;
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

	public String getPregunta01() {
		return _pregunta01;
	}

	public void setPregunta01(String pregunta01) {
		_pregunta01 = pregunta01;
	}

	public String getPregunta02() {
		return _pregunta02;
	}

	public void setPregunta02(String pregunta02) {
		_pregunta02 = pregunta02;
	}

	public String getPregunta03() {
		return _pregunta03;
	}

	public void setPregunta03(String pregunta03) {
		_pregunta03 = pregunta03;
	}

	public String getPregunta04() {
		return _pregunta04;
	}

	public void setPregunta04(String pregunta04) {
		_pregunta04 = pregunta04;
	}

	public String getRespuesta01() {
		return _respuesta01;
	}

	public void setRespuesta01(String respuesta01) {
		_respuesta01 = respuesta01;
	}

	public String getRespuesta02() {
		return _respuesta02;
	}

	public void setRespuesta02(String respuesta02) {
		_respuesta02 = respuesta02;
	}

	public String getRespuesta03() {
		return _respuesta03;
	}

	public void setRespuesta03(String respuesta03) {
		_respuesta03 = respuesta03;
	}

	public String getRespuesta04() {
		return _respuesta04;
	}

	public void setRespuesta04(String respuesta04) {
		_respuesta04 = respuesta04;
	}

	public BaseModel<?> getAuditoriaPerfiladorRemoteModel() {
		return _auditoriaPerfiladorRemoteModel;
	}

	public void setAuditoriaPerfiladorRemoteModel(
		BaseModel<?> auditoriaPerfiladorRemoteModel) {
		_auditoriaPerfiladorRemoteModel = auditoriaPerfiladorRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AuditoriaPerfiladorLocalServiceUtil.addAuditoriaPerfilador(this);
		}
		else {
			AuditoriaPerfiladorLocalServiceUtil.updateAuditoriaPerfilador(this);
		}
	}

	@Override
	public AuditoriaPerfilador toEscapedModel() {
		return (AuditoriaPerfilador)Proxy.newProxyInstance(AuditoriaPerfilador.class.getClassLoader(),
			new Class[] { AuditoriaPerfilador.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuditoriaPerfiladorClp clone = new AuditoriaPerfiladorClp();

		clone.setIdAuditoriaPer(getIdAuditoriaPer());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setNumeroDocumento(getNumeroDocumento());
		clone.setPerfilador(getPerfilador());
		clone.setSession(getSession());
		clone.setTransaccion(getTransaccion());
		clone.setMonto(getMonto());
		clone.setTipoCredito(getTipoCredito());
		clone.setIP(getIP());
		clone.setFechaHora(getFechaHora());
		clone.setUTMSource(getUTMSource());
		clone.setUTMMedium(getUTMMedium());
		clone.setUTMCampaing(getUTMCampaing());
		clone.setUTMContent(getUTMContent());
		clone.setPregunta01(getPregunta01());
		clone.setPregunta02(getPregunta02());
		clone.setPregunta03(getPregunta03());
		clone.setPregunta04(getPregunta04());
		clone.setRespuesta01(getRespuesta01());
		clone.setRespuesta02(getRespuesta02());
		clone.setRespuesta03(getRespuesta03());
		clone.setRespuesta04(getRespuesta04());

		return clone;
	}

	public int compareTo(AuditoriaPerfilador auditoriaPerfilador) {
		long primaryKey = auditoriaPerfilador.getPrimaryKey();

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

		AuditoriaPerfiladorClp auditoriaPerfilador = null;

		try {
			auditoriaPerfilador = (AuditoriaPerfiladorClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = auditoriaPerfilador.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{idAuditoriaPer=");
		sb.append(getIdAuditoriaPer());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", numeroDocumento=");
		sb.append(getNumeroDocumento());
		sb.append(", perfilador=");
		sb.append(getPerfilador());
		sb.append(", session=");
		sb.append(getSession());
		sb.append(", transaccion=");
		sb.append(getTransaccion());
		sb.append(", monto=");
		sb.append(getMonto());
		sb.append(", tipoCredito=");
		sb.append(getTipoCredito());
		sb.append(", IP=");
		sb.append(getIP());
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
		sb.append(", pregunta01=");
		sb.append(getPregunta01());
		sb.append(", pregunta02=");
		sb.append(getPregunta02());
		sb.append(", pregunta03=");
		sb.append(getPregunta03());
		sb.append(", pregunta04=");
		sb.append(getPregunta04());
		sb.append(", respuesta01=");
		sb.append(getRespuesta01());
		sb.append(", respuesta02=");
		sb.append(getRespuesta02());
		sb.append(", respuesta03=");
		sb.append(getRespuesta03());
		sb.append(", respuesta04=");
		sb.append(getRespuesta04());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.AuditoriaPerfilador");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idAuditoriaPer</column-name><column-value><![CDATA[");
		sb.append(getIdAuditoriaPer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoDocumento</column-name><column-value><![CDATA[");
		sb.append(getTipoDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numeroDocumento</column-name><column-value><![CDATA[");
		sb.append(getNumeroDocumento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perfilador</column-name><column-value><![CDATA[");
		sb.append(getPerfilador());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>session</column-name><column-value><![CDATA[");
		sb.append(getSession());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transaccion</column-name><column-value><![CDATA[");
		sb.append(getTransaccion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monto</column-name><column-value><![CDATA[");
		sb.append(getMonto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoCredito</column-name><column-value><![CDATA[");
		sb.append(getTipoCredito());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>IP</column-name><column-value><![CDATA[");
		sb.append(getIP());
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
		sb.append(
			"<column><column-name>pregunta01</column-name><column-value><![CDATA[");
		sb.append(getPregunta01());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pregunta02</column-name><column-value><![CDATA[");
		sb.append(getPregunta02());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pregunta03</column-name><column-value><![CDATA[");
		sb.append(getPregunta03());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pregunta04</column-name><column-value><![CDATA[");
		sb.append(getPregunta04());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respuesta01</column-name><column-value><![CDATA[");
		sb.append(getRespuesta01());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respuesta02</column-name><column-value><![CDATA[");
		sb.append(getRespuesta02());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respuesta03</column-name><column-value><![CDATA[");
		sb.append(getRespuesta03());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>respuesta04</column-name><column-value><![CDATA[");
		sb.append(getRespuesta04());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _idAuditoriaPer;
	private String _tipoDocumento;
	private String _numeroDocumento;
	private String _perfilador;
	private String _session;
	private String _transaccion;
	private Double _monto;
	private String _tipoCredito;
	private String _IP;
	private Date _fechaHora;
	private String _UTMSource;
	private String _UTMMedium;
	private String _UTMCampaing;
	private String _UTMContent;
	private String _pregunta01;
	private String _pregunta02;
	private String _pregunta03;
	private String _pregunta04;
	private String _respuesta01;
	private String _respuesta02;
	private String _respuesta03;
	private String _respuesta04;
	private BaseModel<?> _auditoriaPerfiladorRemoteModel;
}