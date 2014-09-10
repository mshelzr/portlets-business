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
 * This class is used by SOAP remote services, specifically {@link com.ext.portlet.halcon.service.http.AuditoriaSimuladorServiceSoap}.
 *
 * @author    Infonet-Consulting
 * @see       com.ext.portlet.halcon.service.http.AuditoriaSimuladorServiceSoap
 * @generated
 */
public class AuditoriaSimuladorSoap implements Serializable {
	public static AuditoriaSimuladorSoap toSoapModel(AuditoriaSimulador model) {
		AuditoriaSimuladorSoap soapModel = new AuditoriaSimuladorSoap();

		soapModel.setIdAuditoriaSim(model.getIdAuditoriaSim());
		soapModel.setTipoSimulador(model.getTipoSimulador());
		soapModel.setIdTransaccion(model.getIdTransaccion());
		soapModel.setTipoDocumento(model.getTipoDocumento());
		soapModel.setNumDocumento(model.getNumDocumento());
		soapModel.setMoneda(model.getMoneda());
		soapModel.setTipoProducto(model.getTipoProducto());
		soapModel.setInvirtioFondMut(model.getInvirtioFondMut());
		soapModel.setNivelConocimFondMut(model.getNivelConocimFondMut());
		soapModel.setReaccionVarMerc(model.getReaccionVarMerc());
		soapModel.setValorBien(model.getValorBien());
		soapModel.setMontoPrestamo(model.getMontoPrestamo());
		soapModel.setCuotaInicial(model.getCuotaInicial());
		soapModel.setPeriodoInvers(model.getPeriodoInvers());
		soapModel.setTasa(model.getTasa());
		soapModel.setSegDesgrav(model.getSegDesgrav());
		soapModel.setTipoCuota(model.getTipoCuota());
		soapModel.setIP(model.getIP());
		soapModel.setFechaHora(model.getFechaHora());
		soapModel.setUTMSource(model.getUTMSource());
		soapModel.setUTMMedium(model.getUTMMedium());
		soapModel.setUTMCampaing(model.getUTMCampaing());
		soapModel.setUTMContent(model.getUTMContent());

		return soapModel;
	}

	public static AuditoriaSimuladorSoap[] toSoapModels(
		AuditoriaSimulador[] models) {
		AuditoriaSimuladorSoap[] soapModels = new AuditoriaSimuladorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AuditoriaSimuladorSoap[][] toSoapModels(
		AuditoriaSimulador[][] models) {
		AuditoriaSimuladorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AuditoriaSimuladorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AuditoriaSimuladorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AuditoriaSimuladorSoap[] toSoapModels(
		List<AuditoriaSimulador> models) {
		List<AuditoriaSimuladorSoap> soapModels = new ArrayList<AuditoriaSimuladorSoap>(models.size());

		for (AuditoriaSimulador model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AuditoriaSimuladorSoap[soapModels.size()]);
	}

	public AuditoriaSimuladorSoap() {
	}

	public long getPrimaryKey() {
		return _idAuditoriaSim;
	}

	public void setPrimaryKey(long pk) {
		setIdAuditoriaSim(pk);
	}

	public long getIdAuditoriaSim() {
		return _idAuditoriaSim;
	}

	public void setIdAuditoriaSim(long idAuditoriaSim) {
		_idAuditoriaSim = idAuditoriaSim;
	}

	public String getTipoSimulador() {
		return _tipoSimulador;
	}

	public void setTipoSimulador(String tipoSimulador) {
		_tipoSimulador = tipoSimulador;
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

	public String getMoneda() {
		return _moneda;
	}

	public void setMoneda(String moneda) {
		_moneda = moneda;
	}

	public String getTipoProducto() {
		return _tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		_tipoProducto = tipoProducto;
	}

	public String getInvirtioFondMut() {
		return _invirtioFondMut;
	}

	public void setInvirtioFondMut(String invirtioFondMut) {
		_invirtioFondMut = invirtioFondMut;
	}

	public String getNivelConocimFondMut() {
		return _nivelConocimFondMut;
	}

	public void setNivelConocimFondMut(String nivelConocimFondMut) {
		_nivelConocimFondMut = nivelConocimFondMut;
	}

	public String getReaccionVarMerc() {
		return _reaccionVarMerc;
	}

	public void setReaccionVarMerc(String reaccionVarMerc) {
		_reaccionVarMerc = reaccionVarMerc;
	}

	public Double getValorBien() {
		return _valorBien;
	}

	public void setValorBien(Double valorBien) {
		_valorBien = valorBien;
	}

	public Double getMontoPrestamo() {
		return _montoPrestamo;
	}

	public void setMontoPrestamo(Double montoPrestamo) {
		_montoPrestamo = montoPrestamo;
	}

	public Double getCuotaInicial() {
		return _cuotaInicial;
	}

	public void setCuotaInicial(Double cuotaInicial) {
		_cuotaInicial = cuotaInicial;
	}

	public String getPeriodoInvers() {
		return _periodoInvers;
	}

	public void setPeriodoInvers(String periodoInvers) {
		_periodoInvers = periodoInvers;
	}

	public Double getTasa() {
		return _tasa;
	}

	public void setTasa(Double tasa) {
		_tasa = tasa;
	}

	public String getSegDesgrav() {
		return _segDesgrav;
	}

	public void setSegDesgrav(String segDesgrav) {
		_segDesgrav = segDesgrav;
	}

	public String getTipoCuota() {
		return _tipoCuota;
	}

	public void setTipoCuota(String tipoCuota) {
		_tipoCuota = tipoCuota;
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

	private long _idAuditoriaSim;
	private String _tipoSimulador;
	private String _idTransaccion;
	private String _tipoDocumento;
	private String _numDocumento;
	private String _moneda;
	private String _tipoProducto;
	private String _invirtioFondMut;
	private String _nivelConocimFondMut;
	private String _reaccionVarMerc;
	private Double _valorBien;
	private Double _montoPrestamo;
	private Double _cuotaInicial;
	private String _periodoInvers;
	private Double _tasa;
	private String _segDesgrav;
	private String _tipoCuota;
	private String _IP;
	private Date _fechaHora;
	private String _UTMSource;
	private String _UTMMedium;
	private String _UTMCampaing;
	private String _UTMContent;
}