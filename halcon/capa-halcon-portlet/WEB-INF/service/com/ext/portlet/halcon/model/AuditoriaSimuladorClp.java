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

import com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil;

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
public class AuditoriaSimuladorClp extends BaseModelImpl<AuditoriaSimulador>
	implements AuditoriaSimulador {
	public AuditoriaSimuladorClp() {
	}

	public Class<?> getModelClass() {
		return AuditoriaSimulador.class;
	}

	public String getModelClassName() {
		return AuditoriaSimulador.class.getName();
	}

	public long getPrimaryKey() {
		return _idAuditoriaSim;
	}

	public void setPrimaryKey(long primaryKey) {
		setIdAuditoriaSim(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_idAuditoriaSim);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idAuditoriaSim", getIdAuditoriaSim());
		attributes.put("tipoSimulador", getTipoSimulador());
		attributes.put("idTransaccion", getIdTransaccion());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("numDocumento", getNumDocumento());
		attributes.put("moneda", getMoneda());
		attributes.put("tipoProducto", getTipoProducto());
		attributes.put("invirtioFondMut", getInvirtioFondMut());
		attributes.put("nivelConocimFondMut", getNivelConocimFondMut());
		attributes.put("reaccionVarMerc", getReaccionVarMerc());
		attributes.put("valorBien", getValorBien());
		attributes.put("montoPrestamo", getMontoPrestamo());
		attributes.put("cuotaInicial", getCuotaInicial());
		attributes.put("periodoInvers", getPeriodoInvers());
		attributes.put("tasa", getTasa());
		attributes.put("segDesgrav", getSegDesgrav());
		attributes.put("tipoCuota", getTipoCuota());
		attributes.put("IP", getIP());
		attributes.put("fechaHora", getFechaHora());
		attributes.put("UTMSource", getUTMSource());
		attributes.put("UTMMedium", getUTMMedium());
		attributes.put("UTMCampaing", getUTMCampaing());
		attributes.put("UTMContent", getUTMContent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long idAuditoriaSim = (Long)attributes.get("idAuditoriaSim");

		if (idAuditoriaSim != null) {
			setIdAuditoriaSim(idAuditoriaSim);
		}

		String tipoSimulador = (String)attributes.get("tipoSimulador");

		if (tipoSimulador != null) {
			setTipoSimulador(tipoSimulador);
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

		String moneda = (String)attributes.get("moneda");

		if (moneda != null) {
			setMoneda(moneda);
		}

		String tipoProducto = (String)attributes.get("tipoProducto");

		if (tipoProducto != null) {
			setTipoProducto(tipoProducto);
		}

		String invirtioFondMut = (String)attributes.get("invirtioFondMut");

		if (invirtioFondMut != null) {
			setInvirtioFondMut(invirtioFondMut);
		}

		String nivelConocimFondMut = (String)attributes.get(
				"nivelConocimFondMut");

		if (nivelConocimFondMut != null) {
			setNivelConocimFondMut(nivelConocimFondMut);
		}

		String reaccionVarMerc = (String)attributes.get("reaccionVarMerc");

		if (reaccionVarMerc != null) {
			setReaccionVarMerc(reaccionVarMerc);
		}

		Double valorBien = (Double)attributes.get("valorBien");

		if (valorBien != null) {
			setValorBien(valorBien);
		}

		Double montoPrestamo = (Double)attributes.get("montoPrestamo");

		if (montoPrestamo != null) {
			setMontoPrestamo(montoPrestamo);
		}

		Double cuotaInicial = (Double)attributes.get("cuotaInicial");

		if (cuotaInicial != null) {
			setCuotaInicial(cuotaInicial);
		}

		String periodoInvers = (String)attributes.get("periodoInvers");

		if (periodoInvers != null) {
			setPeriodoInvers(periodoInvers);
		}

		Double tasa = (Double)attributes.get("tasa");

		if (tasa != null) {
			setTasa(tasa);
		}

		String segDesgrav = (String)attributes.get("segDesgrav");

		if (segDesgrav != null) {
			setSegDesgrav(segDesgrav);
		}

		String tipoCuota = (String)attributes.get("tipoCuota");

		if (tipoCuota != null) {
			setTipoCuota(tipoCuota);
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

	public BaseModel<?> getAuditoriaSimuladorRemoteModel() {
		return _auditoriaSimuladorRemoteModel;
	}

	public void setAuditoriaSimuladorRemoteModel(
		BaseModel<?> auditoriaSimuladorRemoteModel) {
		_auditoriaSimuladorRemoteModel = auditoriaSimuladorRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			AuditoriaSimuladorLocalServiceUtil.addAuditoriaSimulador(this);
		}
		else {
			AuditoriaSimuladorLocalServiceUtil.updateAuditoriaSimulador(this);
		}
	}

	@Override
	public AuditoriaSimulador toEscapedModel() {
		return (AuditoriaSimulador)Proxy.newProxyInstance(AuditoriaSimulador.class.getClassLoader(),
			new Class[] { AuditoriaSimulador.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AuditoriaSimuladorClp clone = new AuditoriaSimuladorClp();

		clone.setIdAuditoriaSim(getIdAuditoriaSim());
		clone.setTipoSimulador(getTipoSimulador());
		clone.setIdTransaccion(getIdTransaccion());
		clone.setTipoDocumento(getTipoDocumento());
		clone.setNumDocumento(getNumDocumento());
		clone.setMoneda(getMoneda());
		clone.setTipoProducto(getTipoProducto());
		clone.setInvirtioFondMut(getInvirtioFondMut());
		clone.setNivelConocimFondMut(getNivelConocimFondMut());
		clone.setReaccionVarMerc(getReaccionVarMerc());
		clone.setValorBien(getValorBien());
		clone.setMontoPrestamo(getMontoPrestamo());
		clone.setCuotaInicial(getCuotaInicial());
		clone.setPeriodoInvers(getPeriodoInvers());
		clone.setTasa(getTasa());
		clone.setSegDesgrav(getSegDesgrav());
		clone.setTipoCuota(getTipoCuota());
		clone.setIP(getIP());
		clone.setFechaHora(getFechaHora());
		clone.setUTMSource(getUTMSource());
		clone.setUTMMedium(getUTMMedium());
		clone.setUTMCampaing(getUTMCampaing());
		clone.setUTMContent(getUTMContent());

		return clone;
	}

	public int compareTo(AuditoriaSimulador auditoriaSimulador) {
		long primaryKey = auditoriaSimulador.getPrimaryKey();

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

		AuditoriaSimuladorClp auditoriaSimulador = null;

		try {
			auditoriaSimulador = (AuditoriaSimuladorClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = auditoriaSimulador.getPrimaryKey();

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
		StringBundler sb = new StringBundler(47);

		sb.append("{idAuditoriaSim=");
		sb.append(getIdAuditoriaSim());
		sb.append(", tipoSimulador=");
		sb.append(getTipoSimulador());
		sb.append(", idTransaccion=");
		sb.append(getIdTransaccion());
		sb.append(", tipoDocumento=");
		sb.append(getTipoDocumento());
		sb.append(", numDocumento=");
		sb.append(getNumDocumento());
		sb.append(", moneda=");
		sb.append(getMoneda());
		sb.append(", tipoProducto=");
		sb.append(getTipoProducto());
		sb.append(", invirtioFondMut=");
		sb.append(getInvirtioFondMut());
		sb.append(", nivelConocimFondMut=");
		sb.append(getNivelConocimFondMut());
		sb.append(", reaccionVarMerc=");
		sb.append(getReaccionVarMerc());
		sb.append(", valorBien=");
		sb.append(getValorBien());
		sb.append(", montoPrestamo=");
		sb.append(getMontoPrestamo());
		sb.append(", cuotaInicial=");
		sb.append(getCuotaInicial());
		sb.append(", periodoInvers=");
		sb.append(getPeriodoInvers());
		sb.append(", tasa=");
		sb.append(getTasa());
		sb.append(", segDesgrav=");
		sb.append(getSegDesgrav());
		sb.append(", tipoCuota=");
		sb.append(getTipoCuota());
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
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.ext.portlet.halcon.model.AuditoriaSimulador");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idAuditoriaSim</column-name><column-value><![CDATA[");
		sb.append(getIdAuditoriaSim());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoSimulador</column-name><column-value><![CDATA[");
		sb.append(getTipoSimulador());
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
			"<column><column-name>moneda</column-name><column-value><![CDATA[");
		sb.append(getMoneda());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoProducto</column-name><column-value><![CDATA[");
		sb.append(getTipoProducto());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>invirtioFondMut</column-name><column-value><![CDATA[");
		sb.append(getInvirtioFondMut());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nivelConocimFondMut</column-name><column-value><![CDATA[");
		sb.append(getNivelConocimFondMut());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reaccionVarMerc</column-name><column-value><![CDATA[");
		sb.append(getReaccionVarMerc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valorBien</column-name><column-value><![CDATA[");
		sb.append(getValorBien());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>montoPrestamo</column-name><column-value><![CDATA[");
		sb.append(getMontoPrestamo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cuotaInicial</column-name><column-value><![CDATA[");
		sb.append(getCuotaInicial());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>periodoInvers</column-name><column-value><![CDATA[");
		sb.append(getPeriodoInvers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tasa</column-name><column-value><![CDATA[");
		sb.append(getTasa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>segDesgrav</column-name><column-value><![CDATA[");
		sb.append(getSegDesgrav());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tipoCuota</column-name><column-value><![CDATA[");
		sb.append(getTipoCuota());
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

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _auditoriaSimuladorRemoteModel;
}