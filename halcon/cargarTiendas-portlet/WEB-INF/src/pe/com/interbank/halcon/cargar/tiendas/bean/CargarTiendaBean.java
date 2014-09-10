package pe.com.interbank.halcon.cargar.tiendas.bean;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CargarTiendaBean.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
@SuppressWarnings("serial")
public class CargarTiendaBean implements Serializable  {

	/** The idcargatienda. */
	int idcargatienda;

	/** The canal. */
	String canal;

	/** The ubigeo. */
	String ubigeo;

	/** The latitud. */
	String latitud;

	/** The longitud. */
	String longitud;

	/** The direccion. */
	String direccion;

	/** The horario. */
	String horario;

	/** The locacion. */
	String id_locacion;
	
	String locacion;

	/** The telefono. */
	String telefono;

	/**
	 * Obtiene idcargatienda. Fecha: 31-ene-2013
	 * 
	 * @return idcargatienda
	 */
	public int getIdcargatienda() {
		return idcargatienda;
	}

	/**
	 * Establece el idcargatienda.
	 * 
	 * @param idcargatienda el new idcargatienda
	 */
	public void setIdcargatienda(int idcargatienda) {
		this.idcargatienda = idcargatienda;
	}

	/**
	 * Obtiene canal. Fecha: 31-ene-2013
	 * 
	 * @return canal
	 */
	public String getCanal() {
		return canal;
	}

	/**
	 * Establece el canal.
	 * 
	 * @param canal el new canal
	 */
	public void setCanal(String canal) {
		this.canal = canal;
	}

	/**
	 * Obtiene ubigeo. Fecha: 31-ene-2013
	 * 
	 * @return ubigeo
	 */
	public String getUbigeo() {
		return ubigeo;
	}

	/**
	 * Establece el ubigeo.
	 * 
	 * @param ubigeo el new ubigeo
	 */
	public void setUbigeo(String ubigeo) {
		this.ubigeo = ubigeo;
	}

	/**
	 * Obtiene latitud. Fecha: 31-ene-2013
	 * 
	 * @return latitud
	 */
	public String getLatitud() {
		return latitud;
	}

	/**
	 * Establece el latitud.
	 * 
	 * @param latitud el new latitud
	 */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	/**
	 * Obtiene longitud. Fecha: 31-ene-2013
	 * 
	 * @return longitud
	 */
	public String getLongitud() {
		return longitud;
	}

	/**
	 * Establece el longitud.
	 * 
	 * @param longitud el new longitud
	 */
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/**
	 * Obtiene direccion. Fecha: 31-ene-2013
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
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene horario. Fecha: 31-ene-2013
	 * 
	 * @return horario
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * Establece el horario.
	 * 
	 * @param horario el new horario
	 */
	public void setHorario(String horario) {
		this.horario = horario;
	}

	/**
	 * Obtiene locacion. Fecha: 31-ene-2013
	 * 
	 * @return locacion
	 */
	public String getLocacion() {
		return locacion;
	}

	/**
	 * Establece el locacion.
	 * 
	 * @param locacion el new locacion
	 */
	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	/**
	 * Obtiene telefono. Fecha: 31-ene-2013
	 * 
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el telefono.
	 * 
	 * @param telefono el new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getId_locacion() {
		return id_locacion;
	}

	public void setId_locacion(String id_locacion) {
		this.id_locacion = id_locacion;
	}

	
}
