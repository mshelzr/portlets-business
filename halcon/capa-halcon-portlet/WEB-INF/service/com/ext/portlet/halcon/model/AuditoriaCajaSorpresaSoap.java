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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.AuditoriaCajaSorpresaServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.AuditoriaCajaSorpresaServiceSoap
 * @generated
 */
public class AuditoriaCajaSorpresaSoap implements Serializable {
	public static AuditoriaCajaSorpresaSoap toSoapModel(
		AuditoriaCajaSorpresa model) {
		AuditoriaCajaSorpresaSoap soapModel = new AuditoriaCajaSorpresaSoap();

		soapModel.setIdAuditoriaCajSorp(model.getIdAuditoriaCajSorp());
		soapModel.setIdTransaccion(model.getIdTransaccion());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNumDocumento(model.getNumDocumento());
		soapModel.setProducto1(model.getProducto1());
		soapModel.setProducto2(model.getProducto2());
		soapModel.setProducto3(model.getProducto3());
		soapModel.setProducto4(model.getProducto4());
		soapModel.setCodProducto1(model.getCodProducto1());
		soapModel.setCodProducto2(model.getCodProducto2());
		soapModel.setCodProducto3(model.getCodProducto3());
		soapModel.setCodProducto4(model.getCodProducto4());
		soapModel.setIP(model.getIP());
		soapModel.setSession(model.getSession());
		soapModel.setFechaHora(model.getFechaHora());
		soapModel.setUTMSource(model.getUTMSource());
		soapModel.setUTMMedium(model.getUTMMedium());
		soapModel.setUTMCampaing(model.getUTMCampaing());
		soapModel.setUTMContent(model.getUTMContent());

		return soapModel;
	}

	public static AuditoriaCajaSorpresaSoap[] toSoapModels(
		AuditoriaCajaSorpresa[] models) {
		AuditoriaCajaSorpresaSoap[] soapModels = new AuditoriaCajaSorpresaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuditoriaCajaSorpresaSoap[][] toSoapModels(
		AuditoriaCajaSorpresa[][] models) {
		AuditoriaCajaSorpresaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuditoriaCajaSorpresaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuditoriaCajaSorpresaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuditoriaCajaSorpresaSoap[] toSoapModels(
		List<AuditoriaCajaSorpresa> models) {
		List<AuditoriaCajaSorpresaSoap> soapModels = new ArrayList<AuditoriaCajaSorpresaSoap>(models.size());

		for (AuditoriaCajaSorpresa model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuditoriaCajaSorpresaSoap[soapModels.size()]);
	}

	public AuditoriaCajaSorpresaSoap() {
	}

	public long getPrimaryKey() {
		return _idAuditoriaCajSorp;
	}

	public void setPrimaryKey(long pk) {
		setIdAuditoriaCajSorp(pk);
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
}