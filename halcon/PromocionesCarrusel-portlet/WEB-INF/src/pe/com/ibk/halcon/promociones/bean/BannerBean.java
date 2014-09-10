package pe.com.ibk.halcon.promociones.bean;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BannerBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class BannerBean implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id. */
	int id;
	
	/** The titulo. */
	String titulo;
	
	/** The resumen. */
	String resumen;
	
	/** The url imagen. */
	String urlImagen;
	
	/** The url detalle. */
	String urlDetalle;
	
	/** The url imagen pequenia. */
	String urlImagenPequenia;
	
	/** The link imagen pequenia. */
	String linkImagenPequenia;

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

	/**
	 * Obtiene url detalle.
	 * Fecha: 18/02/2013
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
	 * Obtiene url imagen pequenia.
	 * Fecha: 08/05/2013
	 *
	 * @return url imagen pequenia
	 */
	public String getUrlImagenPequenia() {
		return urlImagenPequenia;
	}

	/**
	 * Establece el url imagen pequenia.
	 *
	 * @param urlImagenPequenia el new url imagen pequenia
	 */
	public void setUrlImagenPequenia(String urlImagenPequenia) {
		this.urlImagenPequenia = urlImagenPequenia;
	}

	/**
	 * Obtiene link imagen pequenia.
	 * Fecha: 08/05/2013
	 *
	 * @return link imagen pequenia
	 */
	public String getLinkImagenPequenia() {
		return linkImagenPequenia;
	}

	/**
	 * Establece el link imagen pequenia.
	 *
	 * @param linkImagenPequenia el new link imagen pequenia
	 */
	public void setLinkImagenPequenia(String linkImagenPequenia) {
		this.linkImagenPequenia = linkImagenPequenia;
	}

}
