package pe.com.interbank.halcon.buscar.descuento.bean;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CargarDescuentosBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
@SuppressWarnings("serial")
public class CargarDescuentosBean implements Serializable {

	/** The id carga desc. */
	long idCargaDesc;
	
	/** The local. */
	String local;
	
	/** The descuento general. */
	String descuentoGeneral;
	
	/** The condiciones restricciones. */
	String condicionesRestricciones;
	
	/** The direccion. */
	String direccion;
	
	/** The id distrito. */
	String idDistrito;
	
	/** The telefono. */
	String telefono;
	
	/** The web. */
	String web;
	
	/** The fin vigencia. */
	Date finVigencia;
	
	/** The idcategoria. */
	String idcategoria;
	
	/** The u rl imagen. */
	String uRLImagen;
	
	/** The latitud. */
	String latitud;
	
	/** The longitud. */
	String longitud;
	
	/**
	 * Obtiene id carga desc.
	 * Fecha: 21/08/2013
	 *
	 * @return id carga desc
	 */
	public long getIdCargaDesc() {
		return idCargaDesc;
	}
	
	/**
	 * Establece el id carga desc.
	 *
	 * @param idCargaDesc el new id carga desc
	 */
	public void setIdCargaDesc(long idCargaDesc) {
		this.idCargaDesc = idCargaDesc;
	}
	
	/**
	 * Obtiene local.
	 * Fecha: 21/08/2013
	 *
	 * @return local
	 */
	public String getLocal() {
		return local;
	}
	
	/**
	 * Establece el local.
	 *
	 * @param local el new local
	 */
	public void setLocal(String local) {
		this.local = local;
	}
	
	/**
	 * Obtiene descuento general.
	 * Fecha: 21/08/2013
	 *
	 * @return descuento general
	 */
	public String getDescuentoGeneral() {
		return descuentoGeneral;
	}
	
	/**
	 * Establece el descuento general.
	 *
	 * @param descuentoGeneral el new descuento general
	 */
	public void setDescuentoGeneral(String descuentoGeneral) {
		this.descuentoGeneral = descuentoGeneral;
	}
	
	/**
	 * Obtiene condiciones restricciones.
	 * Fecha: 21/08/2013
	 *
	 * @return condiciones restricciones
	 */
	public String getCondicionesRestricciones() {
		return condicionesRestricciones;
	}
	
	/**
	 * Establece el condiciones restricciones.
	 *
	 * @param condicionesRestricciones el new condiciones restricciones
	 */
	public void setCondicionesRestricciones(String condicionesRestricciones) {
		this.condicionesRestricciones = condicionesRestricciones;
	}
	
	/**
	 * Obtiene direccion.
	 * Fecha: 21/08/2013
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
	 * Obtiene id distrito.
	 * Fecha: 21/08/2013
	 *
	 * @return id distrito
	 */
	public String getIdDistrito() {
		return idDistrito;
	}
	
	/**
	 * Establece el id distrito.
	 *
	 * @param idDistrito el new id distrito
	 */
	public void setIdDistrito(String idDistrito) {
		this.idDistrito = idDistrito;
	}
	
	/**
	 * Obtiene telefono.
	 * Fecha: 21/08/2013
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
	
	/**
	 * Obtiene web.
	 * Fecha: 21/08/2013
	 *
	 * @return web
	 */
	public String getWeb() {
		return web;
	}
	
	/**
	 * Establece el web.
	 *
	 * @param web el new web
	 */
	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * Obtiene fin vigencia.
	 * Fecha: 21/08/2013
	 *
	 * @return fin vigencia
	 */
	public Date getFinVigencia() {
		return finVigencia;
	}
	
	/**
	 * Establece el fin vigencia.
	 *
	 * @param finVigencia el new fin vigencia
	 */
	public void setFinVigencia(Date finVigencia) {
		this.finVigencia = finVigencia;
	}	
	
	/**
	 * Obtiene u rl imagen.
	 * Fecha: 21/08/2013
	 *
	 * @return u rl imagen
	 */
	public String getuRLImagen() {
		return uRLImagen;
	}
	
	/**
	 * Establece el u rl imagen.
	 *
	 * @param uRLImagen el new u rl imagen
	 */
	public void setuRLImagen(String uRLImagen) {
		this.uRLImagen = uRLImagen;
	}
	
	/**
	 * Obtiene latitud.
	 * Fecha: 21/08/2013
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
	 * Obtiene longitud.
	 * Fecha: 21/08/2013
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
	 * Obtiene idcategoria.
	 * Fecha: 21/08/2013
	 *
	 * @return idcategoria
	 */
	public String getIdcategoria() {
		return idcategoria;
	}
	
	/**
	 * Establece el idcategoria.
	 *
	 * @param idcategoria el new idcategoria
	 */
	public void setIdcategoria(String idcategoria) {
		this.idcategoria = idcategoria;
	}
	
	
	
	
}



