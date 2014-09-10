package pe.com.ibk.halcon.principal.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class TipoFichaSimuladorBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class TipoFichaSimuladorBean {
	
	/** The nombre. */
	private String nombre;
	
	/** The codigo. */
	private String codigo;
	
	/** The tipo simulador. */
	private String tipoSimulador;
	
	/**
	 * Obtiene tipo simulador.
	 * Fecha: 22/08/2013
	 *
	 * @return tipo simulador
	 */
	public String getTipoSimulador() {
		return tipoSimulador;
	}
	
	/**
	 * Establece el tipo simulador.
	 *
	 * @param tipoSimulador el new tipo simulador
	 */
	public void setTipoSimulador(String tipoSimulador) {
		this.tipoSimulador = tipoSimulador;
	}
	
	/**
	 * Obtiene nombre.
	 * Fecha: 22/08/2013
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
	 * Obtiene codigo.
	 * Fecha: 22/08/2013
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
}
