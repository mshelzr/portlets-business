package pe.com.ibk.halcon.contenidoweb.bean;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SolicitudBean.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 30/01/2013
 * @version Halcon 1.0
 */
public class SolicitudBean implements Serializable {

	/** Julio Hurtado 26/11/2012 Bean de solicitud de contacto con el banco Interbank. */

	private static final long serialVersionUID = 1L;

	// Campos formulario
	/** The id. */
	Integer id;

	/** The es cliente. */
	Integer esCliente;

	/** The nombres. */
	String nombres;

	/** The apellidos. */
	String apellidos;

	/** The email. */
	String email;

	/** The tipo documento. */
	String tipoDocumento;

	/** The numero documento. */
	String numeroDocumento;

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

	/** The importe */
	String importe;

	/**
	 * Obtiene es cliente. Fecha: 30/01/2013
	 * 
	 * @return es cliente
	 */
	public Integer getEsCliente() {
		return esCliente;
	}

	/**
	 * Establece el es cliente.
	 * 
	 * @param esCliente el new es cliente
	 */
	public void setEsCliente(Integer esCliente) {
		this.esCliente = esCliente;
	}

	/**
	 * Obtiene nombres. Fecha: 30/01/2013
	 * 
	 * @return nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Establece el nombres.
	 * 
	 * @param nombres el new nombres
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Obtiene apellidos. Fecha: 30/01/2013
	 * 
	 * @return apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Establece el apellidos.
	 * 
	 * @param apellidos el new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Obtiene id. Fecha: 30/01/2013
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el id.
	 * 
	 * @param id el new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene email. Fecha: 30/01/2013
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el email.
	 * 
	 * @param email el new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Obtiene tipo documento. Fecha: 30/01/2013
	 * 
	 * @return tipo documento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * Establece el tipo documento.
	 * 
	 * @param tipoDocumento el new tipo documento
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * Obtiene numero documento. Fecha: 30/01/2013
	 * 
	 * @return numero documento
	 */
	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	/**
	 * Establece el numero documento.
	 * 
	 * @param numeroDocumento el new numero documento
	 */
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	/**
	 * Obtiene direccion. Fecha: 30/01/2013
	 * 
	 * @return direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece el direccion.
	 * 
	 * @param direccion el new direccion
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el direccion.
	 * 
	 * @param direccion el new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene departamento. Fecha: 30/01/2013
	 * 
	 * @return departamento
	 */
	public String getDepartamento() {
		return departamento;
	}

	/**
	 * Establece el departamento.
	 * 
	 * @param departamento el new departamento
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	/**
	 * Obtiene provincia. Fecha: 30/01/2013
	 * 
	 * @return provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Establece el provincia.
	 * 
	 * @param provincia el new provincia
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	/**
	 * Obtiene distrito. Fecha: 30/01/2013
	 * 
	 * @return distrito
	 */
	public String getDistrito() {
		return distrito;
	}

	/**
	 * Establece el distrito.
	 * 
	 * @param distrito el new distrito
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	/**
	 * Obtiene fecha. Fecha: 30/01/2013
	 * 
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Establece el fecha.
	 * 
	 * @param fecha el new fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene tipo mensaje. Fecha: 30/01/2013
	 * 
	 * @return tipo mensaje
	 */
	public String getTipoMensaje() {
		return tipoMensaje;
	}

	/**
	 * Establece el tipo mensaje.
	 * 
	 * @param tipoMensaje el new tipo mensaje
	 */
	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	/**
	 * Obtiene tipo tema. Fecha: 30/01/2013
	 * 
	 * @return tipo tema
	 */
	public String getTipoTema() {
		return tipoTema;
	}

	/**
	 * Establece el tipo tema.
	 * 
	 * @param tipoTema el new tipo tema
	 */
	public void setTipoTema(String tipoTema) {
		this.tipoTema = tipoTema;
	}

	/**
	 * Obtiene mensaje. Fecha: 30/01/2013
	 * 
	 * @return mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece el mensaje.
	 * 
	 * @param mensaje el new mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Obtiene importe. Fecha: 25/04/2014
	 * 
	 * @return importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * Establece el importe.
	 * 
	 * @param importe el new importe
	 */
	public void setImporte(String importe) {
		this.importe = importe;
	}
	

}
