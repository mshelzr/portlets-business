package pe.com.ibk.halcon.seccion.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SeccionBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class SeccionBean {

	/** The nombre. */
	private String nombre;
	
	/** The id contenido seccion. */
	private String idContenidoSeccion;
	
	/** The url imagen. */
	private String urlImagen;
	
	/** The id imagen. */
	private long idImagen;

	private Integer orden;
	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * Obtiene id imagen.
	 * Fecha: 18/02/2013
	 *
	 * @return id imagen
	 */
	public long getIdImagen() {
		return idImagen;
	}

	/**
	 * Establece el id imagen.
	 *
	 * @param idImagen el new id imagen
	 */
	public void setIdImagen(long idImagen) {
		this.idImagen = idImagen;
	}

	/**
	 * Obtiene nombre.
	 * Fecha: 18/02/2013
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre.
	 *
	 * @param nombre el new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene id contenido seccion.
	 * Fecha: 18/02/2013
	 *
	 * @return id contenido seccion
	 */
	public String getIdContenidoSeccion() {
		return idContenidoSeccion;
	}

	/**
	 * Establece el id contenido seccion.
	 *
	 * @param idContenidoSeccion el new id contenido seccion
	 */
	public void setIdContenidoSeccion(String idContenidoSeccion) {
		this.idContenidoSeccion = idContenidoSeccion;
	}

	/**
	 * Obtiene url imagen.
	 * Fecha: 18/02/2013
	 *
	 * @return url imagen
	 */
	public String getUrlImagen() {
		return urlImagen;
	}

	/**
	 * Establece el url imagen.
	 *
	 * @param urlImagen el new url imagen
	 */
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

}
