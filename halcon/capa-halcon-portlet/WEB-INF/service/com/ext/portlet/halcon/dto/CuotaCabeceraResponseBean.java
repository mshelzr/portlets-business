package com.ext.portlet.halcon.dto;

import javax.xml.datatype.XMLGregorianCalendar;

public class CuotaCabeceraResponseBean {
	
	
	Double amortizacion;
	Double comision;
	Double cuota;
	Double interes;
	Double montoPrestamo;
	Double portes;
	Double seguroBien;
	Double seguroDesgravamen;
	Double tasaCostoEfectivo;
	XMLGregorianCalendar fechaPrimerVencimiento;
	
	
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
	public Double getMontoPrestamo() {
		return montoPrestamo;
	}
	public void setMontoPrestamo(Double montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}
	public Double getPortes() {
		return portes;
	}
	public void setPortes(Double portes) {
		this.portes = portes;
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
	public Double getTasaCostoEfectivo() {
		return tasaCostoEfectivo;
	}
	public void setTasaCostoEfectivo(Double tasaCostoEfectivo) {
		this.tasaCostoEfectivo = tasaCostoEfectivo;
	}
	public XMLGregorianCalendar getFechaPrimerVencimiento() {
		return fechaPrimerVencimiento;
	}
	public void setFechaPrimerVencimiento(XMLGregorianCalendar fechaPrimerVencimiento) {
		this.fechaPrimerVencimiento = fechaPrimerVencimiento;
	}
	
	

}
