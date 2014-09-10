package com.ext.portlet.halcon.dto;

public class RangoBean {
	
	private String etiqueta;
	private String valorInicial;
	private String valorFinal;
	private String incremento;
	private Integer intReturn;
	
	
	public RangoBean() {
		super();
	}
	
	public RangoBean(String etiqueta, String valorInicial, String valorFinal,
			String incremento) {
		super();
		this.etiqueta = etiqueta;
		this.valorInicial = valorInicial;
		this.valorFinal = valorFinal;
		this.incremento = incremento;
		
		
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getValorInicial() {
		return valorInicial;
	}
	public void setValorInicial(String valorInicial) {
		this.valorInicial = valorInicial;
	}
	public String getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}
	public String getIncremento() {
		return incremento;
	}
	public void setIncremento(String incremento) {
		this.incremento = incremento;
	}

	public Integer getIntReturn() {
		return intReturn;
	}

	public void setIntReturn(Integer intReturn) {
		this.intReturn = intReturn;
	}
	
}
