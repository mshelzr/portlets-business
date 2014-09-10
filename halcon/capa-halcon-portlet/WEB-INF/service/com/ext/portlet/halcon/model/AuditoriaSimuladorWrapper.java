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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AuditoriaSimulador}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       AuditoriaSimulador
 * @generated
 */
public class AuditoriaSimuladorWrapper implements AuditoriaSimulador,
	ModelWrapper<AuditoriaSimulador> {
	public AuditoriaSimuladorWrapper(AuditoriaSimulador auditoriaSimulador) {
		_auditoriaSimulador = auditoriaSimulador;
	}

	public Class<?> getModelClass() {
		return AuditoriaSimulador.class;
	}

	public String getModelClassName() {
		return AuditoriaSimulador.class.getName();
	}

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

	/**
	* Returns the primary key of this auditoria simulador.
	*
	* @return the primary key of this auditoria simulador
	*/
	public long getPrimaryKey() {
		return _auditoriaSimulador.getPrimaryKey();
	}

	/**
	* Sets the primary key of this auditoria simulador.
	*
	* @param primaryKey the primary key of this auditoria simulador
	*/
	public void setPrimaryKey(long primaryKey) {
		_auditoriaSimulador.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id auditoria sim of this auditoria simulador.
	*
	* @return the id auditoria sim of this auditoria simulador
	*/
	public long getIdAuditoriaSim() {
		return _auditoriaSimulador.getIdAuditoriaSim();
	}

	/**
	* Sets the id auditoria sim of this auditoria simulador.
	*
	* @param idAuditoriaSim the id auditoria sim of this auditoria simulador
	*/
	public void setIdAuditoriaSim(long idAuditoriaSim) {
		_auditoriaSimulador.setIdAuditoriaSim(idAuditoriaSim);
	}

	/**
	* Returns the tipo simulador of this auditoria simulador.
	*
	* @return the tipo simulador of this auditoria simulador
	*/
	public java.lang.String getTipoSimulador() {
		return _auditoriaSimulador.getTipoSimulador();
	}

	/**
	* Sets the tipo simulador of this auditoria simulador.
	*
	* @param tipoSimulador the tipo simulador of this auditoria simulador
	*/
	public void setTipoSimulador(java.lang.String tipoSimulador) {
		_auditoriaSimulador.setTipoSimulador(tipoSimulador);
	}

	/**
	* Returns the id transaccion of this auditoria simulador.
	*
	* @return the id transaccion of this auditoria simulador
	*/
	public java.lang.String getIdTransaccion() {
		return _auditoriaSimulador.getIdTransaccion();
	}

	/**
	* Sets the id transaccion of this auditoria simulador.
	*
	* @param idTransaccion the id transaccion of this auditoria simulador
	*/
	public void setIdTransaccion(java.lang.String idTransaccion) {
		_auditoriaSimulador.setIdTransaccion(idTransaccion);
	}

	/**
	* Returns the tipo documento of this auditoria simulador.
	*
	* @return the tipo documento of this auditoria simulador
	*/
	public java.lang.String getTipoDocumento() {
		return _auditoriaSimulador.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this auditoria simulador.
	*
	* @param tipoDocumento the tipo documento of this auditoria simulador
	*/
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_auditoriaSimulador.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the num documento of this auditoria simulador.
	*
	* @return the num documento of this auditoria simulador
	*/
	public java.lang.String getNumDocumento() {
		return _auditoriaSimulador.getNumDocumento();
	}

	/**
	* Sets the num documento of this auditoria simulador.
	*
	* @param numDocumento the num documento of this auditoria simulador
	*/
	public void setNumDocumento(java.lang.String numDocumento) {
		_auditoriaSimulador.setNumDocumento(numDocumento);
	}

	/**
	* Returns the moneda of this auditoria simulador.
	*
	* @return the moneda of this auditoria simulador
	*/
	public java.lang.String getMoneda() {
		return _auditoriaSimulador.getMoneda();
	}

	/**
	* Sets the moneda of this auditoria simulador.
	*
	* @param moneda the moneda of this auditoria simulador
	*/
	public void setMoneda(java.lang.String moneda) {
		_auditoriaSimulador.setMoneda(moneda);
	}

	/**
	* Returns the tipo producto of this auditoria simulador.
	*
	* @return the tipo producto of this auditoria simulador
	*/
	public java.lang.String getTipoProducto() {
		return _auditoriaSimulador.getTipoProducto();
	}

	/**
	* Sets the tipo producto of this auditoria simulador.
	*
	* @param tipoProducto the tipo producto of this auditoria simulador
	*/
	public void setTipoProducto(java.lang.String tipoProducto) {
		_auditoriaSimulador.setTipoProducto(tipoProducto);
	}

	/**
	* Returns the invirtio fond mut of this auditoria simulador.
	*
	* @return the invirtio fond mut of this auditoria simulador
	*/
	public java.lang.String getInvirtioFondMut() {
		return _auditoriaSimulador.getInvirtioFondMut();
	}

	/**
	* Sets the invirtio fond mut of this auditoria simulador.
	*
	* @param invirtioFondMut the invirtio fond mut of this auditoria simulador
	*/
	public void setInvirtioFondMut(java.lang.String invirtioFondMut) {
		_auditoriaSimulador.setInvirtioFondMut(invirtioFondMut);
	}

	/**
	* Returns the nivel conocim fond mut of this auditoria simulador.
	*
	* @return the nivel conocim fond mut of this auditoria simulador
	*/
	public java.lang.String getNivelConocimFondMut() {
		return _auditoriaSimulador.getNivelConocimFondMut();
	}

	/**
	* Sets the nivel conocim fond mut of this auditoria simulador.
	*
	* @param nivelConocimFondMut the nivel conocim fond mut of this auditoria simulador
	*/
	public void setNivelConocimFondMut(java.lang.String nivelConocimFondMut) {
		_auditoriaSimulador.setNivelConocimFondMut(nivelConocimFondMut);
	}

	/**
	* Returns the reaccion var merc of this auditoria simulador.
	*
	* @return the reaccion var merc of this auditoria simulador
	*/
	public java.lang.String getReaccionVarMerc() {
		return _auditoriaSimulador.getReaccionVarMerc();
	}

	/**
	* Sets the reaccion var merc of this auditoria simulador.
	*
	* @param reaccionVarMerc the reaccion var merc of this auditoria simulador
	*/
	public void setReaccionVarMerc(java.lang.String reaccionVarMerc) {
		_auditoriaSimulador.setReaccionVarMerc(reaccionVarMerc);
	}

	/**
	* Returns the valor bien of this auditoria simulador.
	*
	* @return the valor bien of this auditoria simulador
	*/
	public java.lang.Double getValorBien() {
		return _auditoriaSimulador.getValorBien();
	}

	/**
	* Sets the valor bien of this auditoria simulador.
	*
	* @param valorBien the valor bien of this auditoria simulador
	*/
	public void setValorBien(java.lang.Double valorBien) {
		_auditoriaSimulador.setValorBien(valorBien);
	}

	/**
	* Returns the monto prestamo of this auditoria simulador.
	*
	* @return the monto prestamo of this auditoria simulador
	*/
	public java.lang.Double getMontoPrestamo() {
		return _auditoriaSimulador.getMontoPrestamo();
	}

	/**
	* Sets the monto prestamo of this auditoria simulador.
	*
	* @param montoPrestamo the monto prestamo of this auditoria simulador
	*/
	public void setMontoPrestamo(java.lang.Double montoPrestamo) {
		_auditoriaSimulador.setMontoPrestamo(montoPrestamo);
	}

	/**
	* Returns the cuota inicial of this auditoria simulador.
	*
	* @return the cuota inicial of this auditoria simulador
	*/
	public java.lang.Double getCuotaInicial() {
		return _auditoriaSimulador.getCuotaInicial();
	}

	/**
	* Sets the cuota inicial of this auditoria simulador.
	*
	* @param cuotaInicial the cuota inicial of this auditoria simulador
	*/
	public void setCuotaInicial(java.lang.Double cuotaInicial) {
		_auditoriaSimulador.setCuotaInicial(cuotaInicial);
	}

	/**
	* Returns the periodo invers of this auditoria simulador.
	*
	* @return the periodo invers of this auditoria simulador
	*/
	public java.lang.String getPeriodoInvers() {
		return _auditoriaSimulador.getPeriodoInvers();
	}

	/**
	* Sets the periodo invers of this auditoria simulador.
	*
	* @param periodoInvers the periodo invers of this auditoria simulador
	*/
	public void setPeriodoInvers(java.lang.String periodoInvers) {
		_auditoriaSimulador.setPeriodoInvers(periodoInvers);
	}

	/**
	* Returns the tasa of this auditoria simulador.
	*
	* @return the tasa of this auditoria simulador
	*/
	public java.lang.Double getTasa() {
		return _auditoriaSimulador.getTasa();
	}

	/**
	* Sets the tasa of this auditoria simulador.
	*
	* @param tasa the tasa of this auditoria simulador
	*/
	public void setTasa(java.lang.Double tasa) {
		_auditoriaSimulador.setTasa(tasa);
	}

	/**
	* Returns the seg desgrav of this auditoria simulador.
	*
	* @return the seg desgrav of this auditoria simulador
	*/
	public java.lang.String getSegDesgrav() {
		return _auditoriaSimulador.getSegDesgrav();
	}

	/**
	* Sets the seg desgrav of this auditoria simulador.
	*
	* @param segDesgrav the seg desgrav of this auditoria simulador
	*/
	public void setSegDesgrav(java.lang.String segDesgrav) {
		_auditoriaSimulador.setSegDesgrav(segDesgrav);
	}

	/**
	* Returns the tipo cuota of this auditoria simulador.
	*
	* @return the tipo cuota of this auditoria simulador
	*/
	public java.lang.String getTipoCuota() {
		return _auditoriaSimulador.getTipoCuota();
	}

	/**
	* Sets the tipo cuota of this auditoria simulador.
	*
	* @param tipoCuota the tipo cuota of this auditoria simulador
	*/
	public void setTipoCuota(java.lang.String tipoCuota) {
		_auditoriaSimulador.setTipoCuota(tipoCuota);
	}

	/**
	* Returns the i p of this auditoria simulador.
	*
	* @return the i p of this auditoria simulador
	*/
	public java.lang.String getIP() {
		return _auditoriaSimulador.getIP();
	}

	/**
	* Sets the i p of this auditoria simulador.
	*
	* @param IP the i p of this auditoria simulador
	*/
	public void setIP(java.lang.String IP) {
		_auditoriaSimulador.setIP(IP);
	}

	/**
	* Returns the fecha hora of this auditoria simulador.
	*
	* @return the fecha hora of this auditoria simulador
	*/
	public java.util.Date getFechaHora() {
		return _auditoriaSimulador.getFechaHora();
	}

	/**
	* Sets the fecha hora of this auditoria simulador.
	*
	* @param fechaHora the fecha hora of this auditoria simulador
	*/
	public void setFechaHora(java.util.Date fechaHora) {
		_auditoriaSimulador.setFechaHora(fechaHora);
	}

	/**
	* Returns the u t m source of this auditoria simulador.
	*
	* @return the u t m source of this auditoria simulador
	*/
	public java.lang.String getUTMSource() {
		return _auditoriaSimulador.getUTMSource();
	}

	/**
	* Sets the u t m source of this auditoria simulador.
	*
	* @param UTMSource the u t m source of this auditoria simulador
	*/
	public void setUTMSource(java.lang.String UTMSource) {
		_auditoriaSimulador.setUTMSource(UTMSource);
	}

	/**
	* Returns the u t m medium of this auditoria simulador.
	*
	* @return the u t m medium of this auditoria simulador
	*/
	public java.lang.String getUTMMedium() {
		return _auditoriaSimulador.getUTMMedium();
	}

	/**
	* Sets the u t m medium of this auditoria simulador.
	*
	* @param UTMMedium the u t m medium of this auditoria simulador
	*/
	public void setUTMMedium(java.lang.String UTMMedium) {
		_auditoriaSimulador.setUTMMedium(UTMMedium);
	}

	/**
	* Returns the u t m campaing of this auditoria simulador.
	*
	* @return the u t m campaing of this auditoria simulador
	*/
	public java.lang.String getUTMCampaing() {
		return _auditoriaSimulador.getUTMCampaing();
	}

	/**
	* Sets the u t m campaing of this auditoria simulador.
	*
	* @param UTMCampaing the u t m campaing of this auditoria simulador
	*/
	public void setUTMCampaing(java.lang.String UTMCampaing) {
		_auditoriaSimulador.setUTMCampaing(UTMCampaing);
	}

	/**
	* Returns the u t m content of this auditoria simulador.
	*
	* @return the u t m content of this auditoria simulador
	*/
	public java.lang.String getUTMContent() {
		return _auditoriaSimulador.getUTMContent();
	}

	/**
	* Sets the u t m content of this auditoria simulador.
	*
	* @param UTMContent the u t m content of this auditoria simulador
	*/
	public void setUTMContent(java.lang.String UTMContent) {
		_auditoriaSimulador.setUTMContent(UTMContent);
	}

	public boolean isNew() {
		return _auditoriaSimulador.isNew();
	}

	public void setNew(boolean n) {
		_auditoriaSimulador.setNew(n);
	}

	public boolean isCachedModel() {
		return _auditoriaSimulador.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_auditoriaSimulador.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _auditoriaSimulador.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _auditoriaSimulador.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_auditoriaSimulador.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _auditoriaSimulador.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_auditoriaSimulador.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AuditoriaSimuladorWrapper((AuditoriaSimulador)_auditoriaSimulador.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.AuditoriaSimulador auditoriaSimulador) {
		return _auditoriaSimulador.compareTo(auditoriaSimulador);
	}

	@Override
	public int hashCode() {
		return _auditoriaSimulador.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.AuditoriaSimulador> toCacheModel() {
		return _auditoriaSimulador.toCacheModel();
	}

	public com.ext.portlet.halcon.model.AuditoriaSimulador toEscapedModel() {
		return new AuditoriaSimuladorWrapper(_auditoriaSimulador.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _auditoriaSimulador.toString();
	}

	public java.lang.String toXmlString() {
		return _auditoriaSimulador.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_auditoriaSimulador.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public AuditoriaSimulador getWrappedAuditoriaSimulador() {
		return _auditoriaSimulador;
	}

	public AuditoriaSimulador getWrappedModel() {
		return _auditoriaSimulador;
	}

	public void resetOriginalValues() {
		_auditoriaSimulador.resetOriginalValues();
	}

	private AuditoriaSimulador _auditoriaSimulador;
}