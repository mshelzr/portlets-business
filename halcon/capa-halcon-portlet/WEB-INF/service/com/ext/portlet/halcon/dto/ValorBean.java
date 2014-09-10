package com.ext.portlet.halcon.dto;

public class ValorBean {
	
	private String etiqueta;
	private String dato;
	private Integer tipoDato;
	
	public ValorBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValorBean(String etiqueta, String dato, Integer tipoDato) {
		super();
		this.etiqueta = etiqueta;
		this.dato = dato;
		this.tipoDato = tipoDato;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getDato() {
		return dato;
	}
	public void setDato(String dato) {
		this.dato = dato;
	}
	public Integer getTipoDato() {
		return tipoDato;
	}
	public void setTipoDato(Integer tipoDato) {
		this.tipoDato = tipoDato;
	}

	
	
}
