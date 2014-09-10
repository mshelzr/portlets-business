package com.ext.portlet.halcon.dto;

public class LogErroresBean {
	
	private String parametros;
	private String idSesion;
	private String tipoDocumento;
	private String numeroDocumento;
	private String ip;
	private String fechaHora;
	private String mensajeError;
	private String trazaError;
	private String paginaHijas;
	
	public LogErroresBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LogErroresBean(String parametros, String tipoDocumento, String numeroDocumento, String ip,
			String fechaHora, String mensajeError, String trazaError, String paginaHijas) {
		super();
		this.parametros = parametros;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.ip = ip;
		this.fechaHora = fechaHora;
		this.mensajeError = mensajeError;
		this.trazaError = trazaError;
		this.paginaHijas = paginaHijas;
	}
	
	public String getParametros() {
		return parametros;
	}
	public void setParametros(String parametros) {
		this.parametros = parametros;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getMensajeError() {
		return mensajeError;
	}
	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	public String getTrazaError() {
		return trazaError;
	}
	public void setTrazaError(String trazaError) {
		this.trazaError = trazaError;
	}
	public String getPaginaHijas() {
		return paginaHijas;
	}
	public void setPaginaHijas(String paginaHijas) {
		this.paginaHijas = paginaHijas;
	}
	
	
	
	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}

	public String getBodyCorreo() {
		
		return "Mensaje de Error:<br/>"
				+ this.mensajeError
				+ "<br/>"
				+ "Parámetros de entrada: "
				+ "<br/>"
				+ this.parametros
				+ "<br/>"
				+ "Identificador de sesión: "
				+ "<br/>"
				+ this.idSesion
				+ "<br/>"
				+ this.tipoDocumento
				+ "<br/>"
				+ this.numeroDocumento
				+ "<br/>"
				+ "IP: "
				+ "<br/>"
				+ this.ip
				+ "<br/>"
				+ "Fecha y hora: "
				+ "<br/>"
				+ this.fechaHora
				+ "<br/>"
				+ "Traza de error: "
				+ "<br/>"
				+ this.trazaError
				+ "<br/>"
				+ "Paginas hijas: "
				+ "<br/>"
				+ this.paginaHijas
				+ "<br/>";
		
	}
	
	
}
