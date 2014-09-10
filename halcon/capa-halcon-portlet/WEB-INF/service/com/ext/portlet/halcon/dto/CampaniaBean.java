package com.ext.portlet.halcon.dto;

import java.math.BigInteger;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author rlopez
 *
 */
public class CampaniaBean {

	private String etiquetaPortal;
	private Boolean isFromPortal;
	private String descripcionProducto;
	private Integer orden;
	private String tituloProducto;
	private String urlImagenProducto;
	private String altImagenProducto;
	private String urlFicha;
	private String urlSolicitud;
	private String urlUbicacion;
	private String urlSimulador;
	
	private String codigoLineaProducto;
	private String tipoCampania;
	private BigInteger prioridad;
	private String codigoCampania;
	private String codigoProducto;
	private String tasa1;
	private String tasa2;
	private String descripcionCampania;
	private String ofertaCampania;
	private XMLGregorianCalendar fechaInicio;
	private XMLGregorianCalendar fechaFin;
	
	public String getOfertaCampania() {
		return ofertaCampania;
	}
	public void setOfertaCampania(String ofertaCampania) {
		this.ofertaCampania = ofertaCampania;
	}
	public String getTasa1() {
		return tasa1;
	}
	public void setTasa1(String tasa1) {
		this.tasa1 = tasa1;
	}
	public String getTasa2() {
		return tasa2;
	}
	public void setTasa2(String tasa2) {
		this.tasa2 = tasa2;
	}
	public String getTipoCampania() {
		return tipoCampania;
	}
	public void setTipoCampania(String tipoCampania) {
		this.tipoCampania = tipoCampania;
	}
	public String getCodigoLineaProducto() {
		return codigoLineaProducto;
	}
	public void setCodigoLineaProducto(String codigoLineaProducto) {
		this.codigoLineaProducto = codigoLineaProducto;
	}
	public String getUrlSimulador() {
		return urlSimulador;
	}
	public void setUrlSimulador(String urlSimulador) {
		this.urlSimulador = urlSimulador;
	}
	public String getUrlUbicacion() {
		return urlUbicacion;
	}
	public void setUrlUbicacion(String urlUbicacion) {
		this.urlUbicacion = urlUbicacion;
	}
	public String getUrlFicha() {
		return urlFicha;
	}
	public void setUrlFicha(String urlFicha) {
		this.urlFicha = urlFicha;
	}
	public String getUrlSolicitud() {
		return urlSolicitud;
	}
	public void setUrlSolicitud(String urlSolicitud) {
		this.urlSolicitud = urlSolicitud;
	}
	public String getUrlImagenProducto() {
		return urlImagenProducto;
	}
	public void setUrlImagenProducto(String urlImagenProducto) {
		this.urlImagenProducto = urlImagenProducto;
	}
	public String getAltImagenProducto() {
		return altImagenProducto;
	}
	public void setAltImagenProducto(String altImagenProducto) {
		this.altImagenProducto = altImagenProducto;
	}
	public String getTituloProducto() {
		return tituloProducto;
	}
	public void setTituloProducto(String tituloProducto) {
		this.tituloProducto = tituloProducto;
	}
	public BigInteger getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(BigInteger prioridad) {
		this.prioridad = prioridad;
	}
	public String getCodigoCampania() {
		return codigoCampania;
	}
	public void setCodigoCampania(String codigoCampania) {
		this.codigoCampania = codigoCampania;
	}
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	public XMLGregorianCalendar getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(XMLGregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public XMLGregorianCalendar getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(XMLGregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getDescripcionCampania() {
		return descripcionCampania;
	}
	public void setDescripcionCampania(String descripcionCampania) {
		this.descripcionCampania = descripcionCampania;
	}
	
	public Boolean getIsFromPortal() {
		return isFromPortal;
	}
	public void setIsFromPortal(Boolean isFromPortal) {
		this.isFromPortal = isFromPortal;
	}
	public String getEtiquetaPortal() {
		return etiquetaPortal;
	}
	public void setEtiquetaPortal(String etiquetaPortal) {
		this.etiquetaPortal = etiquetaPortal;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	
}
