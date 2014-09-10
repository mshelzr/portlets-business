package com.ext.portlet.halcon.dto;

public class SimuladorHipotecarioBean {

	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoMoneda;
	private String tipoCredito;
	private String valorInmueble;
	private String cuotaInicial;
	private String plazoCredito;
	private String tipoSeguro;
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

	public String getValorInmueble() {
		return valorInmueble;
	}

	public void setValorInmueble(String valorInmueble) {
		this.valorInmueble = valorInmueble;
	}

	public String getCuotaInicial() {
		return cuotaInicial;
	}

	public void setCuotaInicial(String cuotaInicial) {
		this.cuotaInicial = cuotaInicial;
	}

	public String getPlazoCredito() {
		return plazoCredito;
	}

	public void setPlazoCredito(String plazoCredito) {
		this.plazoCredito = plazoCredito;
	}

	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getTipoCuota() {
		return tipoCuota;
	}

	public void setTipoCuota(String tipoCuota) {
		this.tipoCuota = tipoCuota;
	}

	public SimuladorHipotecarioBean() {
		super();
	}

}
