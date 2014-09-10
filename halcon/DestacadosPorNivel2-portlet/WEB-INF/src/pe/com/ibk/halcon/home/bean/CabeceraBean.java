package pe.com.ibk.halcon.home.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CabeceraBean, bean de una cabecera.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class CabeceraBean {

	/** The titulo. */
	private String titulo;
	
	/** The url imagen. */
	private String urlImagen;

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
		titulo=titulo.replaceAll(";", "");
		this.titulo = titulo;
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
