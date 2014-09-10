package com.ext.portlet.halcon.dto;

public class TelefonoLeadBean {
	
	private String 	 tipoTelefono;
	private String 	 numeroTelefono;
	private String 	 anexo;
		
	public TelefonoLeadBean(String tipoTelefono, String numeroTelefono, String anexo) {
		super();
		this.tipoTelefono = tipoTelefono;
		this.numeroTelefono = numeroTelefono;
		this.anexo = anexo;
	}
	
	public String getTipoTelefono() {
		return tipoTelefono;
	}
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getAnexo() {
		return anexo;
	}

	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	
	
}
