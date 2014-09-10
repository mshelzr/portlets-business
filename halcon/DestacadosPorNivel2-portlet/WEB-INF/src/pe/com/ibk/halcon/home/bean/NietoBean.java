package pe.com.ibk.halcon.home.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class NietoBean, bean de un nieto
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class NietoBean {

	/** The titulo. */
	private String titulo;
	
	/** The url. */
	private String url;
	
	private Integer orden;
	
	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
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
