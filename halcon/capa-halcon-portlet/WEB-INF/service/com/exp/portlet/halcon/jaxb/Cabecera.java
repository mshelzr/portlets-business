package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row", namespace = "#RowsetSchema")
public class Cabecera {

	private String amortizacion;
	private String interes;
	private String seguroDesgravamen;
	private String seguroBien;
	private String comision;
	private String portes;
	private String cuota;
	private String prestamo;
	private String fechaPrimerVencimiento;
	private String tce;

	@XmlAttribute(name = "Amortizacion")
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

	@XmlAttribute(name = "SeguroDesgravamen")
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

	@XmlAttribute(name = "Comision")
	public String getComision() {
		return comision;
	}

	public void setComision(String comision) {
		this.comision = comision;
	}

	@XmlAttribute(name = "Portes")
	public String getPortes() {
		return portes;
	}

	public void setPortes(String portes) {
		this.portes = portes;
	}

	@XmlAttribute(name = "Cuota")
	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	@XmlAttribute(name = "Prestamo")
	public String getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(String prestamo) {
		this.prestamo = prestamo;
	}

	@XmlAttribute(name = "FechaPrimerVencimiento")
	public String getFechaPrimerVencimiento() {
		return fechaPrimerVencimiento;
	}

	public void setFechaPrimerVencimiento(String fechaPrimerVencimiento) {
		this.fechaPrimerVencimiento = fechaPrimerVencimiento;
	}

	@XmlAttribute(name = "Tce")
	public String getTce() {
		return tce;
	}

	public void setTce(String tce) {
		this.tce = tce;
	}

	public Cabecera() {

	}

}
