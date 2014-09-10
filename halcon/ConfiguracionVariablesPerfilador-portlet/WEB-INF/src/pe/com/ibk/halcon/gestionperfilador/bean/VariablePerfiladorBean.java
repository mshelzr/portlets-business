package pe.com.ibk.halcon.gestionperfilador.bean;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class VariablePerfiladorBean.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
public class VariablePerfiladorBean {

	/** The id variable perfilador. */
	private Long idVariablePerfilador;

	/** The tipo variable. */
	private String tipoVariable;

	/** The nombre. */
	private String nombre;

	/** The codigo clasificacion. */
	private Integer codigoClasificacion;

	/** The tipo respuesta texto. */
	private String tipoRespuestaTexto;

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

	private List<String> listaErrores;

	/** The respuesta asociada. */
	private VariablePerfiladorBean respuestaAsociada;

	/** The Constant COD_PERFILADOR_ACTIVO. */
	private static final String COD_PERFILADOR_ACTIVO = PortletProps.get("variable.perfilador.code.estado.activo");

	/**
	 * Iniciar. Fecha: 24/06/2013
	 */
	public void iniciar() {
		this.setEstado(Integer.valueOf(COD_PERFILADOR_ACTIVO));
	}

	/**
	 * Instancia un nuevo variable perfilador bean.
	 */
	public VariablePerfiladorBean() {

	}

	/**
	 * Obtiene id variable perfilador. Fecha: 24/06/2013
	 * 
	 * @return id variable perfilador
	 */
	public Long getIdVariablePerfilador() {
		return idVariablePerfilador;
	}

	/**
	 * Establece el id variable perfilador.
	 * 
	 * @param idVariablePerfilador el new id variable perfilador
	 */
	public void setIdVariablePerfilador(Long idVariablePerfilador) {
		this.idVariablePerfilador = idVariablePerfilador;
	}

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
	public Integer getCodigoClasificacion() {
		return codigoClasificacion;
	}

	/**
	 * Establece el codigo clasificacion.
	 * 
	 * @param codigoClasificacion el new codigo clasificacion
	 */
	public void setCodigoClasificacion(Integer codigoClasificacion) {
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

	/**
	 * Obtiene valor1. Fecha: 24/06/2013
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
	 * Obtiene valor2. Fecha: 24/06/2013
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
	 * Obtiene valor3. Fecha: 24/06/2013
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
	 * Obtiene estado. Fecha: 24/06/2013
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
	 * Obtiene respuesta asociada. Fecha: 24/06/2013
	 * 
	 * @return respuesta asociada
	 */
	public VariablePerfiladorBean getRespuestaAsociada() {
		return respuestaAsociada;
	}

	/**
	 * Establece el respuesta asociada.
	 * 
	 * @param respuestaAsociada el new respuesta asociada
	 */
	public void setRespuestaAsociada(VariablePerfiladorBean respuestaAsociada) {
		this.respuestaAsociada = respuestaAsociada;
	}

	/**
	 * Obtiene tipo respuesta texto. Fecha: 24/06/2013
	 * 
	 * @return tipo respuesta texto
	 */
	public String getTipoRespuestaTexto() {
		if (this.codigoClasificacion != null) {
			if (this.codigoClasificacion == 10) {
				tipoRespuestaTexto = "Slider";
			} else if (codigoClasificacion == 20) {
				tipoRespuestaTexto = "Combo";
			} else if (codigoClasificacion == 30) {
				tipoRespuestaTexto = "Lista con imagen";
			} else if (codigoClasificacion == 40) {
				tipoRespuestaTexto = "Lista";
			}
		}
		return tipoRespuestaTexto;
	}

	/**
	 * Establece el tipo respuesta texto.
	 * 
	 * @param tipoRespuestaTexto el new tipo respuesta texto
	 */
	public void setTipoRespuestaTexto(String tipoRespuestaTexto) {
		this.tipoRespuestaTexto = tipoRespuestaTexto;
	}

	public List<String> getListaErrores() {
		if (listaErrores == null) {
			listaErrores = new ArrayList<String>();
		}
		return listaErrores;
	}

	public void setListaErrores(List<String> listaErrores) {
		this.listaErrores = listaErrores;
	}

}
