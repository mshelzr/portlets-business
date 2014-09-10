package com.ext.portlet.halcon.dto;

public class SimuladorCreditoPersonalBean {

	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoMoneda;
	private String tipoCredito;
	private String montoCredito;
	private String plazoCredito;
	private String tipoCuota;
	private String montoSimulacion;
	
	public String getMontoSimulacion() {
		return montoSimulacion;
	}

	public void setMontoSimulacion(String montoSimulacion) {
		this.montoSimulacion = montoSimulacion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public String getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public String getMontoCredito() {
		return montoCredito;
	}

	public void setMontoCredito(String montoCredito) {
		this.montoCredito = montoCredito;
	}

	public String getPlazoCredito() {
		return plazoCredito;
	}

	public void setPlazoCredito(String plazoCredito) {
		this.plazoCredito = plazoCredito;
	}

	public String getTipoCuota() {
		return tipoCuota;
	}

	public void setTipoCuota(String tipoCuota) {
		this.tipoCuota = tipoCuota;
	}

	public SimuladorCreditoPersonalBean() {
		super();
	}

}
