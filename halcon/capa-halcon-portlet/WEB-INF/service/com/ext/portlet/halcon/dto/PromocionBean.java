package com.ext.portlet.halcon.dto;

import java.io.Serializable;

public class PromocionBean implements Serializable{
	
	private static final long serialVersionUID = -5050844433016184981L;
	private String tipoDocumento;
	private String numDocumento;
	private String canal;
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}

}
