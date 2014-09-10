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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.AuditoriaPerfiladorServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.AuditoriaPerfiladorServiceSoap
 * @generated
 */
public class AuditoriaPerfiladorSoap implements Serializable {
	public static AuditoriaPerfiladorSoap toSoapModel(AuditoriaPerfilador model) {
		AuditoriaPerfiladorSoap soapModel = new AuditoriaPerfiladorSoap();

		soapModel.setIdAuditoriaPer(model.getIdAuditoriaPer());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNumeroDocumento(model.getNumeroDocumento());
		soapModel.setPerfilador(model.getPerfilador());
		soapModel.setSession(model.getSession());
		soapModel.setTransaccion(model.getTransaccion());
		soapModel.setMonto(model.getMonto());
		soapModel.setTipoCredito(model.getTipoCredito());
		soapModel.setIP(model.getIP());
		soapModel.setFechaHora(model.getFechaHora());
		soapModel.setUTMSource(model.getUTMSource());
		soapModel.setUTMMedium(model.getUTMMedium());
		soapModel.setUTMCampaing(model.getUTMCampaing());
		soapModel.setUTMContent(model.getUTMContent());
		soapModel.setPregunta01(model.getPregunta01());
		soapModel.setPregunta02(model.getPregunta02());
		soapModel.setPregunta03(model.getPregunta03());
		soapModel.setPregunta04(model.getPregunta04());
		soapModel.setRespuesta01(model.getRespuesta01());
		soapModel.setRespuesta02(model.getRespuesta02());
		soapModel.setRespuesta03(model.getRespuesta03());
		soapModel.setRespuesta04(model.getRespuesta04());

		return soapModel;
	}

	public static AuditoriaPerfiladorSoap[] toSoapModels(
		AuditoriaPerfilador[] models) {
		AuditoriaPerfiladorSoap[] soapModels = new AuditoriaPerfiladorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuditoriaPerfiladorSoap[][] toSoapModels(
		AuditoriaPerfilador[][] models) {
		AuditoriaPerfiladorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuditoriaPerfiladorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuditoriaPerfiladorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuditoriaPerfiladorSoap[] toSoapModels(
		List<AuditoriaPerfilador> models) {
		List<AuditoriaPerfiladorSoap> soapModels = new ArrayList<AuditoriaPerfiladorSoap>(models.size());

		for (AuditoriaPerfilador model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuditoriaPerfiladorSoap[soapModels.size()]);
	}

	public AuditoriaPerfiladorSoap() {
	}

	public long getPrimaryKey() {
		return _idAuditoriaPer;
	}

	public void setPrimaryKey(long pk) {
		setIdAuditoriaPer(pk);
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
}