package pe.com.ibk.halcon.gestionparametros.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pe.com.ibk.halcon.gestionparametros.bean.soporte.Soporte;
import pe.com.ibk.halcon.gestionparametros.bean.soporte.SoporteListarParametro;
import pe.com.ibk.halcon.gestionparametros.criterio.CriterioListarParametro;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BeanListarParametro.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class BeanListarParametro implements Serializable {
	
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;	

	/** The criterio listar parametro. */
	private CriterioListarParametro criterioListarParametro;

	/** The soporte listar parametro. */
	private SoporteListarParametro soporteListarParametro;
	
	/**
	 * Instancia un nuevo bean listar parametro.
	 */
	public BeanListarParametro() {
	
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
		iniciarLista();
		if (getCriterioListarParametro().verificar("")) {
			setLista(getSoporteListarParametro().obtenerParametrosPorDescripcion(getCriterioListarParametro().getDescParametro(), getCriterioListarParametro().getDescParametroPadre()));
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
			getCriterioListarParametro().setValorTipo(String.valueOf(parametro.getValorMonto1()));
		} else if (parametro.getNum2() == Soporte.PARAMETRO_TIPO_VALOR_CADENA) {
			getCriterioListarParametro().setValorTipo(parametro.getDato2());
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
		return getSoporteListarParametro().obtenerParametroNuevo();
	}
	
	/**
	 * Eliminar.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void eliminar() throws Exception {
		if (getCriterioListarParametro().verificar("idPanel")) {
			iniciarLista();
			getSoporteListarParametro().eliminarParametro(getCriterioListarParametro().getParametro().getPrimaryKey());
			setLista(getSoporteListarParametro().obtenerListaParametro());
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
		getCriterioListarParametro().setCodParametro(Integer.parseInt(id));
		getSoporteListarParametro().cambiarParametroEstado(getCriterioListarParametro().getCodParametro(), Soporte.PARAMETRO_INACTIVO);
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
		getCriterioListarParametro().setCodParametro(Integer.parseInt(id));
		getSoporteListarParametro().cambiarParametroEstado(getCriterioListarParametro().getCodParametro(), Soporte.PARAMETRO_ACTIVO);
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
		getCriterioListarParametro().iniciar();
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
	 * Obtiene criterio listar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return criterio listar parametro
	 */
	public CriterioListarParametro getCriterioListarParametro() {
		if (criterioListarParametro == null) {
			criterioListarParametro = new CriterioListarParametro();
		}
		return criterioListarParametro;
	}

	/**
	 * Establece el criterio listar parametro.
	 *
	 * @param criterioListarParametro el new criterio listar parametro
	 */
	public void setCriterioListarParametro(
			CriterioListarParametro criterioListarParametro) {
		this.criterioListarParametro = criterioListarParametro;
	}

	/**
	 * Obtiene soporte listar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return soporte listar parametro
	 */
	public SoporteListarParametro getSoporteListarParametro() {
		if (soporteListarParametro == null) {
			soporteListarParametro = new SoporteListarParametro();
		}
		return soporteListarParametro;
	}

	/**
	 * Establece el soporte listar parametro.
	 *
	 * @param soporteListarParametro el new soporte listar parametro
	 */
	public void setSoporteListarParametro(
			SoporteListarParametro soporteListarParametro) {
		this.soporteListarParametro = soporteListarParametro;
	}
	
}
