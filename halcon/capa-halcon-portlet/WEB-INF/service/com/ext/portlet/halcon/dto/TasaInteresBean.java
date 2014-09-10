package com.ext.portlet.halcon.dto;

import java.math.BigInteger;

public class TasaInteresBean {
	
	private BigInteger codigoGrupo;
	private BigInteger codigoMoneda;
	private String codigoProducto;
	
	private String codigoProductoSiebel;
	private double montoFinanciar;
	private String numeroDocumento;
	private BigInteger plazo;
	private String tipoDocumento;
	private String codigoCanal;
	
	
	
	public String getCodigoCanal() {
		return codigoCanal;
	}
	public void setCodigoCanal(String codigoCanal) {
		this.codigoCanal = codigoCanal;
	}
	public BigInteger getCodigoGrupo() {
		return codigoGrupo;
	}
	public void setCodigoGrupo(BigInteger codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	public BigInteger getCodigoMoneda() {
		return codigoMoneda;
	}
	public void setCodigoMoneda(BigInteger codigoMoneda) {
		this.codigoMoneda = codigoMoneda;
	}
	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public double getMontoFinanciar() {
		return montoFinanciar;
	}
	public void setMontoFinanciar(double montoFinanciar) {
		this.montoFinanciar = montoFinanciar;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public BigInteger getPlazo() {
		return plazo;
	}
	public void setPlazo(BigInteger plazo) {
		this.plazo = plazo;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getCodigoProductoSiebel() {
		return codigoProductoSiebel;
	}
	public void setCodigoProductoSiebel(String codigoProductoSiebel) {
		this.codigoProductoSiebel = codigoProductoSiebel;
	}
	
}
