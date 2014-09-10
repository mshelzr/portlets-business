package com.ext.portlet.halcon.dto;

public class SessionBean {

	private String tipoDoc;
	private String numDoc;
	private int indicador;
	private boolean flagCambio=false;
	
	public boolean isFlagCambio() {
		return flagCambio;
	}
	public void setFlagCambio(boolean flagCambio) {
		this.flagCambio = flagCambio;
	}
	public int getIndicador() {
		return indicador;
	}
	public void setIndicador(int indicador) {
		this.indicador = indicador;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
}
