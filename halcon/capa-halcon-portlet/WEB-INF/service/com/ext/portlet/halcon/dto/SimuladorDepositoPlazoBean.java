package com.ext.portlet.halcon.dto;

public class SimuladorDepositoPlazoBean {

	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoMoneda;
	private String montoInversion;
	private String periodoInversion;
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

	public String getMontoInversion() {
		return montoInversion;
	}

	public void setMontoInversion(String montoInversion) {
		this.montoInversion = montoInversion;
	}

	public String getPeriodoInversion() {
		return periodoInversion;
	}

	public void setPeriodoInversion(String periodoInversion) {
		this.periodoInversion = periodoInversion;
	}

	public SimuladorDepositoPlazoBean() {
		super();
	}

}
