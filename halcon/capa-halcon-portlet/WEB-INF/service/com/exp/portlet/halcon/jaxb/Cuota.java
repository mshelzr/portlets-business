package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row", namespace = "#RowsetSchema")
public class Cuota {

	private String nroCuota;
	private String fechaVencimiento;
	private String saldoDeuda;
	private String amortizacion;
	private String interes;
	private String seguroDesgravamen;
	private String seguroBien;
	private String cuota;
	private String portes;
	private String correlativoCuota;
	private String fechaVencimientoInicial;
	private String dias;
	private String comision;
	private String estado;
	private String saldoAdeudado;
	private String fechaIni;
	private String fechaFin;

	@XmlAttribute(name = "nroCuota")
	public String getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(String nroCuota) {
		this.nroCuota = nroCuota;
	}

	@XmlAttribute(name = "fechaVencimiento")
	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@XmlAttribute(name = "saldoDeuda")
	public String getSaldoDeuda() {
		return saldoDeuda;
	}

	public void setSaldoDeuda(String saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}

	@XmlAttribute(name = "amortizacion")
	public String getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(String amortizacion) {
		this.amortizacion = amortizacion;
	}

	@XmlAttribute(name = "Interes")
	public String getInteres() {
		return interes;
	}

	public void setInteres(String interes) {
		this.interes = interes;
	}

	@XmlAttribute(name = "seguroDesgravamen")
	public String getSeguroDesgravamen() {
		return seguroDesgravamen;
	}

	public void setSeguroDesgravamen(String seguroDesgravamen) {
		this.seguroDesgravamen = seguroDesgravamen;
	}

	@XmlAttribute(name = "SeguroBien")
	public String getSeguroBien() {
		return seguroBien;
	}

	public void setSeguroBien(String seguroBien) {
		this.seguroBien = seguroBien;
	}

	@XmlAttribute(name = "Cuota")
	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	@XmlAttribute(name = "Portes")
	public String getPortes() {
		return portes;
	}

	public void setPortes(String portes) {
		this.portes = portes;
	}

	@XmlAttribute(name = "CorrelativoCuota")
	public String getCorrelativoCuota() {
		return correlativoCuota;
	}

	public void setCorrelativoCuota(String correlativoCuota) {
		this.correlativoCuota = correlativoCuota;
	}

	@XmlAttribute(name = "fechaVencimientoInicial")
	public String getFechaVencimientoInicial() {
		return fechaVencimientoInicial;
	}

	public void setFechaVencimientoInicial(String fechaVencimientoInicial) {
		this.fechaVencimientoInicial = fechaVencimientoInicial;
	}

	@XmlAttribute(name = "Dias")
	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
	}

	@XmlAttribute(name = "Comision")
	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	@XmlAttribute(name = "Estado")
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@XmlAttribute(name = "SaldoAdeudado")
	public String getSaldoAdeudado() {
		return saldoAdeudado;
	}

	public void setSaldoAdeudado(String saldoAdeudado) {
		this.saldoAdeudado = saldoAdeudado;
	}

	@XmlAttribute(name = "FechaIni")
	public String getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(String fechaIni) {
		this.fechaIni = fechaIni;
	}

	@XmlAttribute(name = "FechaFin")
	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Cuota() {

	}

}
