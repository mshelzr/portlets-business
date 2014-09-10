package pe.com.ibk.halcon.seccion.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SeccionEditBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
public class SeccionEditBean {

	/** The codigo. */
	private String codigo;
	
	/** The nombre. */
	private String nombre;
	
	/** The regitrado. */
	private boolean regitrado;
	
	private Integer orden;

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * Comprueba si es regitrado.
	 * Fecha: 18/02/2013
	 *
	 * @return true, si es regitrado
	 */
	public boolean isRegitrado() {
		return regitrado;
	}

	/**
	 * Establece el regitrado.
	 *
	 * @param regitrado el new regitrado
	 */
	public void setRegitrado(boolean regitrado) {
		this.regitrado = regitrado;
	}

	/**
	 * Obtiene codigo.
	 * Fecha: 18/02/2013
	 *
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece el codigo.
	 *
	 * @param codigo el new codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

}
