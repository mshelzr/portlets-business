package pe.com.ibk.halcon.perfilador.bean;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class VariablePerfiladorBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  24/06/2013
 * @version Halcon 1.0
 */
public class VariablePerfiladorBean {

	/** The id variable perfilador. */
	private long idVariablePerfilador;
	
	/** The tipo variable. */
	private String tipoVariable;
	
	/** The nombre. */
	private String nombre;
	
	/** The codigo clasificacion. */
	private int codigoClasificacion;
	
	/** The codigo padre. */
	private long codigoPadre;
	
	/** The valor1. */
	private String valor1;
	
	/** The valor2. */
	private String valor2;
	
	/** The valor3. */
	private String valor3;
	
	/** The estado. */
	private int estado;
	
	/** The nivel. */
	private int nivel;
	
	/** The var asociadas. */
	private List<VariablePerfiladorBean> varAsociadas;
	
	/** The respuestas json. */
	private List<VariableJsonBean> respuestasJson;
	
	/** The id rango actual. */
	private long idRangoActual;

	/**
	 * Obtiene id variable perfilador.
	 * Fecha: 24/06/2013
	 *
	 * @return id variable perfilador
	 */
	public long getIdVariablePerfilador() {
		return idVariablePerfilador;
	}

	/**
	 * Establece el id variable perfilador.
	 *
	 * @param idVariablePerfilador el new id variable perfilador
	 */
	public void setIdVariablePerfilador(long idVariablePerfilador) {
		this.idVariablePerfilador = idVariablePerfilador;
	}

	/**
	 * Obtiene tipo variable.
	 * Fecha: 24/06/2013
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
	 * Obtiene nombre.
	 * Fecha: 24/06/2013
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
	 * Obtiene codigo clasificacion.
	 * Fecha: 24/06/2013
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
	 * Obtiene codigo padre.
	 * Fecha: 24/06/2013
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

	/**
	 * Obtiene valor1.
	 * Fecha: 24/06/2013
	 *
	 * @return valor1
	 */
	public String getValor1() {
		return valor1;
	}

	/**
	 * Establece el valor1.
	 *
	 * @param valor1 el new valor1
	 */
	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	/**
	 * Obtiene valor2.
	 * Fecha: 24/06/2013
	 *
	 * @return valor2
	 */
	public String getValor2() {
		return valor2;
	}

	/**
	 * Establece el valor2.
	 *
	 * @param valor2 el new valor2
	 */
	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}

	/**
	 * Obtiene valor3.
	 * Fecha: 24/06/2013
	 *
	 * @return valor3
	 */
	public String getValor3() {
		return valor3;
	}

	/**
	 * Establece el valor3.
	 *
	 * @param valor3 el new valor3
	 */
	public void setValor3(String valor3) {
		this.valor3 = valor3;
	}

	/**
	 * Obtiene estado.
	 * Fecha: 24/06/2013
	 *
	 * @return estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * Establece el estado.
	 *
	 * @param estado el new estado
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene var asociadas.
	 * Fecha: 24/06/2013
	 *
	 * @return var asociadas
	 */
	public List<VariablePerfiladorBean> getVarAsociadas() {
		return varAsociadas;
	}

	/**
	 * Establece el var asociadas.
	 *
	 * @param varAsociadas el new var asociadas
	 */
	public void setVarAsociadas(List<VariablePerfiladorBean> varAsociadas) {
		this.varAsociadas = varAsociadas;
	}

	/**
	 * Obtiene nivel.
	 * Fecha: 24/06/2013
	 *
	 * @return nivel
	 */
	public int getNivel() {
		return nivel;
	}

	/**
	 * Establece el nivel.
	 *
	 * @param nivel el new nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Obtiene respuestas json.
	 * Fecha: 24/06/2013
	 *
	 * @return respuestas json
	 */
	public List<VariableJsonBean> getRespuestasJson() {
		return respuestasJson;
	}

	/**
	 * Establece el respuestas json.
	 *
	 * @param respuestasJson el new respuestas json
	 */
	public void setRespuestasJson(List<VariableJsonBean> respuestasJson) {
		this.respuestasJson = respuestasJson;
	}

	/**
	 * Obtiene id rango actual.
	 * Fecha: 24/06/2013
	 *
	 * @return id rango actual
	 */
	public long getIdRangoActual() {
		return idRangoActual;
	}

	/**
	 * Establece el id rango actual.
	 *
	 * @param idRangoActual el new id rango actual
	 */
	public void setIdRangoActual(long idRangoActual) {
		this.idRangoActual = idRangoActual;
	}

}
