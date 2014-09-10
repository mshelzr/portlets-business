package pe.com.ibk.halcon.perfilador.bean;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class RangoPerfiladorBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  24/06/2013
 * @version Halcon 1.0
 */
public class RangoPerfiladorBean {

	/** The id configuracion perfilador. */
	private Long idConfiguracionPerfilador;
	
	/** The inicio rango. */
	private Long inicioRango;
	
	/** The fin rango. */
	private Long finRango;

	/**
	 * Obtiene id configuracion perfilador.
	 * Fecha: 24/06/2013
	 *
	 * @return id configuracion perfilador
	 */
	public Long getIdConfiguracionPerfilador() {
		return idConfiguracionPerfilador;
	}

	/**
	 * Establece el id configuracion perfilador.
	 *
	 * @param idConfiguracionPerfilador el new id configuracion perfilador
	 */
	public void setIdConfiguracionPerfilador(Long idConfiguracionPerfilador) {
		this.idConfiguracionPerfilador = idConfiguracionPerfilador;
	}

	/**
	 * Obtiene inicio rango.
	 * Fecha: 24/06/2013
	 *
	 * @return inicio rango
	 */
	public Long getInicioRango() {
		return inicioRango;
	}

	/**
	 * Establece el inicio rango.
	 *
	 * @param inicioRango el new inicio rango
	 */
	public void setInicioRango(Long inicioRango) {
		this.inicioRango = inicioRango;
	}

	/**
	 * Obtiene fin rango.
	 * Fecha: 24/06/2013
	 *
	 * @return fin rango
	 */
	public Long getFinRango() {
		return finRango;
	}

	/**
	 * Establece el fin rango.
	 *
	 * @param finRango el new fin rango
	 */
	public void setFinRango(Long finRango) {
		this.finRango = finRango;
	}

}
