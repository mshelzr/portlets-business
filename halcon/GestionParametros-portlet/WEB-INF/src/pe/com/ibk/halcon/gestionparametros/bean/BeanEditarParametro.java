package pe.com.ibk.halcon.gestionparametros.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.com.ibk.halcon.gestionparametros.bean.soporte.Soporte;
import pe.com.ibk.halcon.gestionparametros.bean.soporte.SoporteEditarParametro;
import pe.com.ibk.halcon.gestionparametros.criterio.CriterioEditarParametro;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BeanEditarParametro.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class BeanEditarParametro implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The criterio editar parametro. */
	private CriterioEditarParametro criterioEditarParametro;
	
	/** The soporte editar parametro. */
	private SoporteEditarParametro soporteEditarParametro;
	
	/**
	 * Instancia un nuevo bean editar parametro.
	 */
	public BeanEditarParametro() {
	
	}
	
	/** The lista. */
	private List<Parametro> lista;
	
	/**
	 * Iniciar.
	 * Fecha: 22/08/2013
	 */
	public void iniciar() {
		//criterioListarParametro.iniciar();
		//soporteListarParametro.iniciar();
	}
	
	/**
	 * Iniciar lista.
	 * Fecha: 22/08/2013
	 */
	private void iniciarLista() {
		setLista(null);
	}
	
	
	/**
	 * Listar.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void listar() throws Exception {
		if (getCriterioEditarParametro().verificar("")) {
			iniciarLista();
			setLista(getSoporteEditarParametro().obtenerParametrosHijos(getCriterioEditarParametro().getParametro().getIdParametroPadre()));
		}
		
 	}
	
	/**
	 * Cargar tipo valor.
	 * Fecha: 22/08/2013
	 *
	 * @param parametro the parametro
	 * @return the parametro
	 */
	public Parametro cargarTipoValor(Parametro parametro) {
		if (parametro.getNum2() == Soporte.PARAMETRO_TIPO_VALOR_NUMERICO) {
			getCriterioEditarParametro().setValorTipo(String.valueOf(parametro.getValorMonto1()));
		} else if (parametro.getNum2() == Soporte.PARAMETRO_TIPO_VALOR_CADENA) {
			getCriterioEditarParametro().setValorTipo(parametro.getDato2());
		}
		return parametro;
	}
	
	/**
	 * Obtener parametro lista.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @return the parametro
	 * @throws Exception the exception
	 */
	public Parametro obtenerParametroLista(String idParametro) throws Exception {
		for (Parametro parametro : getLista()) {
			if (parametro.getIdParametro() == Integer.parseInt(idParametro)) {				
				return cargarTipoValor(parametro);
			}
		}
		return getSoporteEditarParametro().obtenerParametroNuevo();
	}
	
	/**
	 * Guardar.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void guardar() throws Exception {
		if (getCriterioEditarParametro().verificar("")) {
			iniciarLista();
			Parametro adicionarParametro;
			
			if (getCriterioEditarParametro().getParametro().getIdParametroPadre() != 0 && getCriterioEditarParametro().getParametroPadre().getNum2() == Soporte.PARAMETRO_TIPO_RANGO) {
				
			}
			
			if (getCriterioEditarParametro().getParametro().getIdParametroPadre() != 0 && getCriterioEditarParametro().getParametroPadre().getNum2() == Soporte.PARAMETRO_TIPO_LISTA) {
				
			}
			
			if (getCriterioEditarParametro().getParametro().getIdParametroPadre() != 0 && getCriterioEditarParametro().getParametroPadre().getNum2() == Soporte.PARAMETRO_TIPO_VALOR) {
				if (getCriterioEditarParametro().getParametro().getNum2() == Soporte.PARAMETRO_TIPO_VALOR_NUMERICO) {
					getCriterioEditarParametro().getParametro().setValorMonto1(getCriterioEditarParametro().getValorTipo());
					getCriterioEditarParametro().getParametro().setDato2(new String(""));
				} else if (getCriterioEditarParametro().getParametro().getNum2() == Soporte.PARAMETRO_TIPO_VALOR_CADENA) {
					getCriterioEditarParametro().getParametro().setDato2(getCriterioEditarParametro().getValorTipo());
					getCriterioEditarParametro().getParametro().setValorMonto1("");
				}
			}
			
			
			
			if (String.valueOf(getCriterioEditarParametro().getParametro().getPrimaryKey()).length() == 0) {
				adicionarParametro = getSoporteEditarParametro().adicionarParametro(getCriterioEditarParametro().getParametro());
			} else {
				adicionarParametro = getSoporteEditarParametro().actualizarParametro(getCriterioEditarParametro().getParametro());
			}
			getCriterioEditarParametro().setParametro(adicionarParametro);
			setLista(getSoporteEditarParametro().obtenerParametrosHijos(getCriterioEditarParametro().getParametro().getIdParametroPadre()));
			limpiarParametrosObtenidosEnListarParametros();
		}
		
	}
	
	/**
	 * Limpiar parametros obtenidos en listar parametros.
	 * Fecha: 22/08/2013
	 */
	private void limpiarParametrosObtenidosEnListarParametros() {
		getCriterioEditarParametro().getParametro().setDato3("");
//		getCriterioEditarParametro().getParametro().setDato4("");
	}

	/**
	 * Eliminar.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void eliminar() throws Exception {
		if (getCriterioEditarParametro().verificar("")) {
			iniciarLista();
			getSoporteEditarParametro().eliminarParametro(getCriterioEditarParametro().getParametro().getPrimaryKey());
			setLista(getSoporteEditarParametro().obtenerListaParametro());
		}
		
	}
	
	/**
	 * Desactivar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void desactivarParametro(String id) throws Exception {
		getCriterioEditarParametro().setCodParametro(Integer.parseInt(id));
		getSoporteEditarParametro().cambiarParametroEstado(getCriterioEditarParametro().getCodParametro(), Soporte.PARAMETRO_INACTIVO);
		if (getCriterioEditarParametro().getParametro().getIdParametro() == getCriterioEditarParametro().getCodParametro()) {
			getCriterioEditarParametro().getParametro().setNum1(Soporte.PARAMETRO_INACTIVO);
		}
		listar();
	}

	/**
	 * Activar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @throws Exception the exception
	 */
	public void activarParametro(String id) throws Exception {
		getCriterioEditarParametro().setCodParametro(Integer.parseInt(id));
		getSoporteEditarParametro().cambiarParametroEstado(getCriterioEditarParametro().getCodParametro(), Soporte.PARAMETRO_ACTIVO);
		if (getCriterioEditarParametro().getParametro().getIdParametro() == getCriterioEditarParametro().getCodParametro()) {
			getCriterioEditarParametro().getParametro().setNum1(Soporte.PARAMETRO_ACTIVO);
		}
		listar();
	}
	
	/**
	 * Limpiar lista parametro.
	 * Fecha: 22/08/2013
	 *
	 * @throws BusinessException the business exception
	 */
	public void limpiarListaParametro() throws BusinessException {
		iniciarLista();
		getCriterioEditarParametro().iniciar();
	}
	
	/**
	 * Mostrar formulario editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void mostrarFormularioEditarParametro() throws Exception {
		getCriterioEditarParametro().setParametroPadre(getSoporteEditarParametro().obtenerParametro(getCriterioEditarParametro().getParametro().getIdParametroPadre()));
		setLista(getSoporteEditarParametro().obtenerParametrosHijos(getCriterioEditarParametro().getParametroPadre().getIdParametro()));
	}

	/**
	 * Obtiene lista.
	 * Fecha: 22/08/2013
	 *
	 * @return lista
	 */
	public List<Parametro> getLista() {
		if (lista == null) {
			lista = new ArrayList<Parametro>();
		}
		return lista;
	}

	/**
	 * Establece el lista.
	 *
	 * @param lista el new lista
	 */
	public void setLista(List<Parametro> lista) {
		this.lista = lista;
	}

	/**
	 * Obtiene criterio editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return criterio editar parametro
	 */
	public CriterioEditarParametro getCriterioEditarParametro() {
		if (criterioEditarParametro == null) {
			criterioEditarParametro = new CriterioEditarParametro();
		}
		return criterioEditarParametro;
	}

	/**
	 * Establece el criterio editar parametro.
	 *
	 * @param criterioEditarParametro el new criterio editar parametro
	 */
	public void setCriterioEditarParametro(
			CriterioEditarParametro criterioEditarParametro) {
		this.criterioEditarParametro = criterioEditarParametro;
	}

	/**
	 * Obtiene soporte editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return soporte editar parametro
	 */
	public SoporteEditarParametro getSoporteEditarParametro() {
		if (soporteEditarParametro == null) {
			soporteEditarParametro = new SoporteEditarParametro();
		}
		return soporteEditarParametro;
	}

	/**
	 * Establece el soporte editar parametro.
	 *
	 * @param soporteEditarParametro el new soporte editar parametro
	 */
	public void setSoporteEditarParametro(
			SoporteEditarParametro soporteEditarParametro) {
		this.soporteEditarParametro = soporteEditarParametro;
	}
	
}
