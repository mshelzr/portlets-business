package pe.com.ibk.halcon.conocenos.bean;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BannerBean, bean de un banner
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class BannerBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	private int id;
	
	/** The titulo. */
	private String titulo;
	
	/** The resumen. */
	private String resumen;
	
	/** The url imagen. */
	private String urlImagen;

	/** The enlace. */
	private String enlace;
	
	/**
	 * Instancia un nuevo banner bean.
	 */
	public BannerBean() {
	}

	/**
	 * Obtiene id.
	 * Fecha: 18/02/2013
	 *
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el id.
	 *
	 * @param id el new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene titulo.
	 * Fecha: 18/02/2013
	 *
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece el titulo.
	 *
	 * @param titulo el new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene resumen.
	 * Fecha: 18/02/2013
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

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
}
