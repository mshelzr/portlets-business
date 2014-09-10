package com.ext.portlet.halcon.dto;

import java.io.Serializable;


public class ProductoComplementarioBean implements Serializable{
	
	private static final long serialVersionUID = -4658308305234326740L;
	private String 	 principalidad;
	private String 	 producto;
	private String 	 idProducto;
	private String 	 idGrupoProducto;
//	private String 	 comentario;
//	private String 	 idCampana;
//	private String 	 monto;
//	private String 	 moneda;
//	private String 	 nombreSupervisor;
	private String 	 siebel;
	private String 	 emailSupervisor;
	private String 	 idContenidoWeb;
	
	public ProductoComplementarioBean() {
		super();
	}
	public ProductoComplementarioBean(String principalidad,
			String producto, String idProducto, String idGrupoProducto, String comentario,
			String idCampana, String monto, String moneda, String nombreSupervisor,
			String emailSupervisor, String siebel) {
		super();
		
		this.principalidad = principalidad;
		this.producto = producto;
		this.idProducto = idProducto;
		this.idGrupoProducto = idGrupoProducto;
//		this.comentario = comentario;
//		this.idCampana = idCampana;
//		this.monto = monto;
//		this.moneda = moneda;
//		this.nombreSupervisor = nombreSupervisor;
		this.emailSupervisor = emailSupervisor;
		this.siebel = siebel;
	}
	
	public String getPrincipalidad() {
		return principalidad;
	}
	public void setPrincipalidad(String principalidad) {
		this.principalidad = principalidad;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getIdGrupoProducto() {
		return idGrupoProducto;
	}
	public void setIdGrupoProducto(String idGrupoProducto) {
		this.idGrupoProducto = idGrupoProducto;
	}
//	public String getComentario() {
//		return comentario;
//	}
//	public void setComentario(String comentario) {
//		this.comentario = comentario;
//	}
//	public String getIdCampana() {
//		return idCampana;
//	}
//	public void setIdCampana(String idCampana) {
//		this.idCampana = idCampana;
//	}
//	public String getMonto() {
//		return monto;
//	}
//	public void setMonto(String monto) {
//		this.monto = monto;
//	}
//	public String getMoneda() {
//		return moneda;
//	}
//	public void setMoneda(String moneda) {
//		this.moneda = moneda;
//	}
//	public String getNombreSupervisor() {
//		return nombreSupervisor;
//	}
//	public void setNombreSupervisor(String nombreSupervisor) {
//		this.nombreSupervisor = nombreSupervisor;
//	}

	public String getEmailSupervisor() {
		return emailSupervisor;
	}
	public void setEmailSupervisor(String emailSupervisor) {
		this.emailSupervisor = emailSupervisor;
	}
	public String getSiebel() {
		return siebel;
	}
	public void setSiebel(String siebel) {
		this.siebel = siebel;
	}
	public String getIdContenidoWeb() {
		return idContenidoWeb;
	}
	public void setIdContenidoWeb(String idContenidoWeb) {
		this.idContenidoWeb = idContenidoWeb;
	}
}
