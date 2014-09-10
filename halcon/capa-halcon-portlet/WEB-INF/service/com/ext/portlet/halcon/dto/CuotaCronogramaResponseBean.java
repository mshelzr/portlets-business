package com.ext.portlet.halcon.dto;

import java.math.BigInteger;

import javax.xml.datatype.XMLGregorianCalendar;

public class CuotaCronogramaResponseBean {
	
	
	Double amortizacion;
	Double comision;
	Double cuota;
	Double interes;
	Double portes;
	Double saldoAdeudado;
	Double saldoDeuda;
	Double seguroBien;
	Double seguroDesgravamen;
	BigInteger correlativoCuota;
	BigInteger dias;
	XMLGregorianCalendar fechaFin;
	XMLGregorianCalendar fechaInicio;
	XMLGregorianCalendar fechaVencimiento;
	XMLGregorianCalendar fechaVencimientoInicial;
	BigInteger numeroCuota;
	
	public Double getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(Double amortizacion) {
		this.amortizacion = amortizacion;
	}
	public Double getComision() {
		return comision;
	}
	public void setComision(Double comision) {
		this.comision = comision;
	}
	public Double getCuota() {
		return cuota;
	}
	public void setCuota(Double cuota) {
		this.cuota = cuota;
	}
	public Double getInteres() {
		return interes;
	}
	public void setInteres(Double interes) {
		this.interes = interes;
	}
	public Double getPortes() {
		return portes;
	}
	public void setPortes(Double portes) {
		this.portes = portes;
	}
	public Double getSaldoAdeudado() {
		return saldoAdeudado;
	}
	public void setSaldoAdeudado(Double saldoAdeudado) {
		this.saldoAdeudado = saldoAdeudado;
	}
	public Double getSaldoDeuda() {
		return saldoDeuda;
	}
	public void setSaldoDeuda(Double saldoDeuda) {
		this.saldoDeuda = saldoDeuda;
	}
	public Double getSeguroBien() {
		return seguroBien;
	}
	public void setSeguroBien(Double seguroBien) {
		this.seguroBien = seguroBien;
	}
	public Double getSeguroDesgravamen() {
		return seguroDesgravamen;
	}
	public void setSeguroDesgravamen(Double seguroDesgravamen) {
		this.seguroDesgravamen = seguroDesgravamen;
	}
	public BigInteger getCorrelativoCuota() {
		return correlativoCuota;
	}
	public void setCorrelativoCuota(BigInteger correlativoCuota) {
		this.correlativoCuota = correlativoCuota;
	}
	public BigInteger getDias() {
		return dias;
	}
	public void setDias(BigInteger dias) {
		this.dias = dias;
	}
	public XMLGregorianCalendar getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(XMLGregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	public XMLGregorianCalendar getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(XMLGregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public XMLGregorianCalendar getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(XMLGregorianCalendar fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public XMLGregorianCalendar getFechaVencimientoInicial() {
		return fechaVencimientoInicial;
	}
	public void setFechaVencimientoInicial(XMLGregorianCalendar fechaVencimientoInicial) {
		this.fechaVencimientoInicial = fechaVencimientoInicial;
	}
	public BigInteger getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(BigInteger numeroCuota) {
		this.numeroCuota = numeroCuota;
	}
	

}
