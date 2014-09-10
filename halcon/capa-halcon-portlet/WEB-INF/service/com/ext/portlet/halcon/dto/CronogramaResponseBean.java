package com.ext.portlet.halcon.dto;

import java.math.BigInteger;
import java.util.ArrayList;

public class CronogramaResponseBean {
	
	private String descripcionGrupo;
	private String descripcionMoneda;
	private String descripcionProducto;
	private String descripcionTipoCuota;
	private Double montoCuotaExtraOrdinaria;
	private Double montoCuotaOrdinaria;
	private Double montoFinanciar;
	private Double tasaComision;
	private Double tasaCostoEfectivo;
	private Double tasaInteres;
	private Double tasaSeguroBien;
	private Double tasaSeguroDesgravamen;
	private Double valorBien;
	private BigInteger plazo;
	private BigInteger plazoGracia;
	private CuotaCabeceraResponseBean cuotaCabeceraResponseBean;
	private ArrayList<CuotaCronogramaResponseBean> listCuotaCronogramaResponseBeans;
	//Manejar url del detalle 
	private String urlDetalle;
	
	public String getUrlDetalle() {
		return urlDetalle;
	}
	public void setUrlDetalle(String urlDetalle) {
		this.urlDetalle = urlDetalle;
	}
	public String getDescripcionGrupo() {
		return descripcionGrupo;
	}
	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}
	public String getDescripcionMoneda() {
		return descripcionMoneda;
	}
	public void setDescripcionMoneda(String descripcionMoneda) {
		this.descripcionMoneda = descripcionMoneda;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	public String getDescripcionTipoCuota() {
		return descripcionTipoCuota;
	}
	public void setDescripcionTipoCuota(String descripcionTipoCuota) {
		this.descripcionTipoCuota = descripcionTipoCuota;
	}
	public Double getMontoCuotaOrdinaria() {
		return montoCuotaOrdinaria;
	}
	public void setMontoCuotaOrdinaria(Double montoCuotaOrdinaria) {
		this.montoCuotaOrdinaria = montoCuotaOrdinaria;
	}
	public Double getMontoCuotaExtraOrdinaria() {
		return montoCuotaExtraOrdinaria;
	}
	public void setMontoCuotaExtraOrdinaria(Double montoCuotaExtraOrdinaria) {
		this.montoCuotaExtraOrdinaria = montoCuotaExtraOrdinaria;
	}
	public Double getMontoFinanciar() {
		return montoFinanciar;
	}
	public void setMontoFinanciar(Double montoFinanciar) {
		this.montoFinanciar = montoFinanciar;
	}
	public Double getTasaComision() {
		return tasaComision;
	}
	public void setTasaComision(Double tasaComision) {
		this.tasaComision = tasaComision;
	}
	public Double getTasaCostoEfectivo() {
		return tasaCostoEfectivo;
	}
	public void setTasaCostoEfectivo(Double tasaCostoEfectivo) {
		this.tasaCostoEfectivo = tasaCostoEfectivo;
	}
	public Double getTasaInteres() {
		return tasaInteres;
	}
	public void setTasaInteres(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	public Double getTasaSeguroBien() {
		return tasaSeguroBien;
	}
	public void setTasaSeguroBien(Double tasaSeguroBien) {
		this.tasaSeguroBien = tasaSeguroBien;
	}
	public Double getTasaSeguroDesgravamen() {
		return tasaSeguroDesgravamen;
	}
	public void setTasaSeguroDesgravamen(Double tasaSeguroDesgravamen) {
		this.tasaSeguroDesgravamen = tasaSeguroDesgravamen;
	}
	public Double getValorBien() {
		return valorBien;
	}
	public void setValorBien(Double valorBien) {
		this.valorBien = valorBien;
	}
	public BigInteger getPlazo() {
		return plazo;
	}
	public void setPlazo(BigInteger plazo) {
		this.plazo = plazo;
	}
	public BigInteger getPlazoGracia() {
		return plazoGracia;
	}
	public void setPlazoGracia(BigInteger plazoGracia) {
		this.plazoGracia = plazoGracia;
	}
	public CuotaCabeceraResponseBean getCuotaCabeceraResponseBean() {
		return cuotaCabeceraResponseBean;
	}
	public void setCuotaCabeceraResponseBean(CuotaCabeceraResponseBean cuotaCabeceraResponseBean) {
		this.cuotaCabeceraResponseBean = cuotaCabeceraResponseBean;
	}
	public ArrayList<CuotaCronogramaResponseBean> getListCuotaCronogramaResponseBeans() {
		return listCuotaCronogramaResponseBeans;
	}
	public void setListCuotaCronogramaResponseBeans(
			ArrayList<CuotaCronogramaResponseBean> listCuotaCronogramaResponseBeans) {
		this.listCuotaCronogramaResponseBeans = listCuotaCronogramaResponseBeans;
	}
	
	
	
}
