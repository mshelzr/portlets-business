package com.ext.portlet.halcon.dto;

import java.io.Serializable;
import java.util.Date;

public class SolicitudContactoBean implements Serializable {
	/** Marco Risco 27/04/2014 Bean de solicitud de contacto con el banco Interbank. */

	private static final long serialVersionUID = 1L;

	// Campos formulario
	/** The id. */
	String id;

	/** The es cliente. */
	String esCliente;

	/** The nombres. */
	String nombres;

	/** The apellidos. */
	String apellidos;

	/** The email. */
	String email;

	/** The tipo documento. */
	String tipoDocumento;

	/** The numero documento. */
	String ndocumento;

	/** The direccion. */
	String direccion;
	
	/** The telefono. */
	String telefono;

	/** The departamento. */
	String departamento;

	/** The provincia. */
	String provincia;

	/** The distrito. */
	String distrito;

	/** The fecha. */
	String fecha;
	
	/** The tipo mensaje. */
	String tipoMensaje;

	/** The tipo tema. */
	String tipoTema;

	/** The mensaje. */
	String mensaje;
	
	/** The tipo mensaje. */
	String moneda;
	
	/** The importe */
	String importe;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the esCliente
	 */
	public String getEsCliente() {
		return esCliente;
	}

	/**
	 * @param esCliente the esCliente to set
	 */
	public void setEsCliente(String esCliente) {
		this.esCliente = esCliente;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the distrito
	 */
	public String getDistrito() {
		return distrito;
	}

	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the tipoMensaje
	 */
	public String getTipoMensaje() {
		return tipoMensaje;
	}

	/**
	 * @param tipoMensaje the tipoMensaje to set
	 */
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	/**
	 * @return the tipoTema
	 */
	public String getTipoTema() {
		return tipoTema;
	}

	/**
	 * @param tipoTema the tipoTema to set
	 */
	public void setTipoTema(String tipoTema) {
		this.tipoTema = tipoTema;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(String importe) {
		this.importe = importe;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the ndocumento
	 */
	public String getNdocumento() {
		return ndocumento;
	}

	/**
	 * @param ndocumento the ndocumento to set
	 */
	public void setNdocumento(String ndocumento) {
		this.ndocumento = ndocumento;
	}
}