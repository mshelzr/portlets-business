package pe.com.ibk.halcon.conocenos.controller;

import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class NoticiaBean.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 18/02/2013
 * @version Halcon 1.0
 */
public class NoticiaBean implements Comparable<NoticiaBean> {

	/** The id article. */
	private long idArticle;

	/** The title. */
	private String title;

	/** The resumen. */
	private String resumen;

	/** The url detalle. */
	private String urlDetalle;

	/** The fecha creacion. */
	private String fechaCreacion;

	/** The url imagen. */
	private String urlImagen;

	/** The fecha modificacion. */
	private Date fechaModificacion;

	/**
	 * Obtiene id article. Fecha: 18/02/2013
	 * 
	 * @return id article
	 */
	public long getIdArticle() {
		return idArticle;
	}

	/**
	 * Establece el id article.
	 * 
	 * @param idArticle el new id article
	 */
	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	/**
	 * Obtiene title. Fecha: 18/02/2013
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Establece el title.
	 * 
	 * @param title el new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Obtiene resumen. Fecha: 18/02/2013
	 * 
	 * @return resumen
	 */
	public String getResumen() {
		return resumen;
	}

	/**
	 * Establece el resumen.
	 * 
	 * @param resumen el new resumen
	 */
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	/**
	 * Obtiene url detalle. Fecha: 18/02/2013
	 * 
	 * @return url detalle
	 */
	public String getUrlDetalle() {
		return urlDetalle;
	}

	/**
	 * Establece el url detalle.
	 * 
	 * @param urlDetalle el new url detalle
	 */
	public void setUrlDetalle(String urlDetalle) {
		this.urlDetalle = urlDetalle;
	}

	/**
	 * Obtiene fecha creacion. Fecha: 18/02/2013
	 * 
	 * @return fecha creacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Establece el fecha creacion.
	 * 
	 * @param fechaCreacion el new fecha creacion
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Obtiene url imagen. Fecha: 18/02/2013
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

	/**
	 * Obtiene fecha modificacion.
	 * Fecha: 23/10/2013
	 *
	 * @return fecha modificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Establece el fecha modificacion.
	 *
	 * @param fechaModificacion el new fecha modificacion
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(NoticiaBean o) {
		return o.getFechaModificacion().compareTo(getFechaModificacion());
		// return 0;
	}

}
