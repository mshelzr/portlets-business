package pe.com.ibk.halcon.gestionperfilador.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class RespuestaPerfiladorBean.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
public class RespuestaPerfiladorBean {

	/** The tipo variable. */
	private String tipoVariable;

	/** The nombre. */
	private String nombre;

	/** The codigo clasificacion. */
	private int codigoClasificacion;

	/** The codigo padre. */
	private long codigoPadre;

	/**
	 * Obtiene tipo variable. Fecha: 24/06/2013
	 * 
	 * @return tipo variable
	 */
	public String getTipoVariable() {
		return tipoVariable;
	}

	/**
	 * Establece el tipo variable.
	 * 
	 * @param tipoVariable el new tipo variable
	 */
	public void setTipoVariable(String tipoVariable) {
		this.tipoVariable = tipoVariable;
	}

	/**
	 * Obtiene nombre. Fecha: 24/06/2013
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
	 * Obtiene codigo clasificacion. Fecha: 24/06/2013
	 * 
	 * @return codigo clasificacion
	 */
	public int getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * Establece el codigo clasificacion.
	 * 
	 * @param codigoClasificacion el new codigo clasificacion
	 */
	public void setCodigoClasificacion(int codigoClasificacion) {
		this.codigoClasificacion = codigoClasificacion;
	}

	/**
	 * Obtiene codigo padre. Fecha: 24/06/2013
	 * 
	 * @return codigo padre
	 */
	public long getCodigoPadre() {
		return codigoPadre;
	}

	/**
	 * Establece el codigo padre.
	 * 
	 * @param codigoPadre el new codigo padre
	 */
	public void setCodigoPadre(long codigoPadre) {
		this.codigoPadre = codigoPadre;
	}

}
