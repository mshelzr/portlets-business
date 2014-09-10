package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "row", namespace = "#RowsetSchema")
public class Credito {

	private String grupo;
	private String producto;
	private String moneda;
	private String tasaInteres;
	private String montoFinanciar;
	private String montoValorBien;
	private String tipoCuota;
	private String plazo;
	private String plazoGracia;
	private String tasaCostoEfectivo;
	private String tasaSeguroDesgravamen;
	private String tasaSeguroBien;
	private String tasaComision;
	private String montoCuotaOrdinaria;
	private String montoCuotaExtraOrdinaria;
	private String tipoReporte;
	private String tituloReporte;

	@XmlAttribute(name = "Grupo")
	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@XmlAttribute(name = "Producto")
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@XmlAttribute(name = "Moneda")
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@XmlAttribute(name = "TasaInteres")
	public String getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(String tasaInteres) {
		this.tasaInteres = tasaInteres;
	}

	@XmlAttribute(name = "MontoFinanciar")
	public String getMontoFinanciar() {
		return montoFinanciar;
	}

	public void setMontoFinanciar(String montoFinanciar) {
		this.montoFinanciar = montoFinanciar;
	}

	@XmlAttribute(name = "MontoValorBien")
	public String getMontoValorBien() {
		return montoValorBien;
	}

	public void setMontoValorBien(String montoValorBien) {
		this.montoValorBien = montoValorBien;
	}

	@XmlAttribute(name = "TipoCuota")
	public String getTipoCuota() {
		return tipoCuota;
	}

	public void setTipoCuota(String tipoCuota) {
		this.tipoCuota = tipoCuota;
	}

	@XmlAttribute(name = "Plazo")
	public String getPlazo() {
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	@XmlAttribute(name = "PlazoGracia")
	public String getPlazoGracia() {
		return plazoGracia;
	}

	public void setPlazoGracia(String plazoGracia) {
		this.plazoGracia = plazoGracia;
	}

	@XmlAttribute(name = "TasaCostoEfectivo")
	public String getTasaCostoEfectivo() {
		return tasaCostoEfectivo;
	}

	public void setTasaCostoEfectivo(String tasaCostoEfectivo) {
		this.tasaCostoEfectivo = tasaCostoEfectivo;
	}

	@XmlAttribute(name = "TasaSeguroDesgravamen")
	public String getTasaSeguroDesgravamen() {
		return tasaSeguroDesgravamen;
	}

	public void setTasaSeguroDesgravamen(String tasaSeguroDesgravamen) {
		this.tasaSeguroDesgravamen = tasaSeguroDesgravamen;
	}

	@XmlAttribute(name = "TasaSeguroBien")
	public String getTasaSeguroBien() {
		return tasaSeguroBien;
	}

	public void setTasaSeguroBien(String tasaSeguroBien) {
		this.tasaSeguroBien = tasaSeguroBien;
	}

	@XmlAttribute(name = "TasaComision")
	public String getTasaComision() {
		return tasaComision;
	}

	public void setTasaComision(String tasaComision) {
		this.tasaComision = tasaComision;
	}

	@XmlAttribute(name = "MontoCuotaOrdinaria")
	public String getMontoCuotaOrdinaria() {
		return montoCuotaOrdinaria;
	}

	public void setMontoCuotaOrdinaria(String montoCuotaOrdinaria) {
		this.montoCuotaOrdinaria = montoCuotaOrdinaria;
	}

	@XmlAttribute(name = "MontoCuotaExtraOrdinaria")
	public String getMontoCuotaExtraOrdinaria() {
		return montoCuotaExtraOrdinaria;
	}

	public void setMontoCuotaExtraOrdinaria(String montoCuotaExtraOrdinaria) {
		this.montoCuotaExtraOrdinaria = montoCuotaExtraOrdinaria;
	}

	@XmlAttribute(name = "TipoReporte")
	public String getTipoReporte() {
		return tipoReporte;
	}

	public void setTipoReporte(String tipoReporte) {
		this.tipoReporte = tipoReporte;
	}

	@XmlAttribute(name = "TituloReporte")
	public String getTituloReporte() {
		return tituloReporte;
	}

	public void setTituloReporte(String tituloReporte) {
		this.tituloReporte = tituloReporte;
	}

	public Credito() {

	}

}
