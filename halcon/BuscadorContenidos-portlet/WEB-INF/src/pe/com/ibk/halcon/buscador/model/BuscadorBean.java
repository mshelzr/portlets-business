package pe.com.ibk.halcon.buscador.model;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BuscadorBean.
 *
 *Clase para el manejo de los resultados de búsqueda del portal
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class BuscadorBean {

	/** The titulo. */
	private String titulo;
	
	/** The resumen. */
	private String resumen;
	
	/** The url. */
	private String url;
	
	/** The categoria. */
	private String categoria;

	/**
	 * Obtiene categoria.
	 * Fecha: 18/02/2013
	 *
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Establece el categoria.
	 *
	 * @param categoria el new categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	 * Obtiene url.
	 * Fecha: 18/02/2013
	 *
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Establece el url.
	 *
	 * @param url el new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
