package pe.com.ibk.halcon.gestionparametros.criterio;

import java.io.Serializable;

import pe.com.ibk.halcon.gestionparametros.bean.BeanNuevoRango;
import pe.com.ibk.halcon.gestionparametros.bean.soporte.Soporte;

import com.exp.portlet.halcon.utils.EnteroUtil;
import com.exp.portlet.halcon.utils.NumeroUtil;
import com.exp.portlet.halcon.utils.TextoUtil;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CriterioEditarParametro.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class CriterioEditarParametro implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CriterioEditarParametro.class);
	
	/** The tipo busqueda. */
	private Integer tipoBusqueda;
	
	/** The cod parametro padre. */
	private Integer codParametroPadre;
	
	/** The cod parametro. */
	private Integer codParametro;
	
	/** The desc parametro. */
	private String descParametro;
	
	/** The valor tipo. */
	private String valorTipo;
	
	/** The panel valor. */
	private Boolean panelValor;
	
	/** The panel rango. */
	private Boolean panelRango;
	
	/** The panel lista. */
	private Boolean panelLista;
	
	/** The parametro. */
	private Parametro parametro;
	
	/** The parametro padre. */
	private Parametro parametroPadre;
	
	/** The label form parametros. */
	private LabelFormParametros labelFormParametros;
	
	/** The lista valor por defecto. */
	private boolean listaValorPorDefecto;
	
	private boolean nuevoRango;
	
	private BeanNuevoRango beanNuevoRango;
	
	/**
	 * Iniciar.
	 * Fecha: 22/08/2013
	 */
	public void iniciar() {
		tipoBusqueda = null;
		codParametroPadre = null;
		codParametro = null;
		descParametro = null;
		valorTipo = null;
		
		panelValor = false;
		panelRango =false;
		panelLista = false;
		
		parametro = null;
		parametroPadre = null;
		
		listaValorPorDefecto = false;
		nuevoRango = false;
	}
	
	/**
	 * Instancia un nuevo criterio editar parametro.
	 */
	public CriterioEditarParametro() {
		
	}
	
	/**
	 * Verificar.
	 * Fecha: 22/08/2013
	 *
	 * @param idPanel the id panel
	 * @return true, en caso de exito
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public boolean verificar(String idPanel) throws BusinessException, Exception {
		if (idPanel != null) {
			if (getParametroPadre().getNum2() == Soporte.PARAMETRO_TIPO_RANGO) {
				if (!EnteroUtil.isEnteroNoCero(getParametro().getIdParametroPadre())) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.contenedor.error"));
				} else if (!TextoUtil.contieneAlgo(TextoUtil.corregir(getParametro().getDato1()))) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.descripcion.error"));
				} else if (!TextoUtil.contieneAlgo(getParametro().getValorMonto1().toString())) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.inicial.error"));
				}
			} else if (getParametroPadre().getNum2() == Soporte.PARAMETRO_TIPO_LISTA) {
				if (!EnteroUtil.isEnteroNoCero(getParametro().getIdParametroPadre())) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.contenedor.error"));
				} else if (!TextoUtil.contieneAlgo(TextoUtil.corregir(getParametro().getDato1()))) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.descripcion.error"));
				} else if (!TextoUtil.contieneAlgo(getParametro().getDato2())) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.tooltip.error"));
				} else if (!EnteroUtil.isEnteroPositivo(String.valueOf(getParametro().getNum2()))) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.orden.error"));
				}
			} else if (getParametroPadre().getNum2() == Soporte.PARAMETRO_TIPO_VALOR) {
				if (!EnteroUtil.isEnteroNoCero(getParametro().getIdParametroPadre())) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.contenedor.error"));
				} else if (!TextoUtil.contieneAlgo(TextoUtil.corregir(getParametro().getDato1()))) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.descripcion.error"));
				} else if (!EnteroUtil.isIdValido(getParametro().getNum2())) {
					throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.tipo.error"));
				} else if (TextoUtil.contieneAlgo(getValorTipo())) {
					if (getParametro().getNum2() == Soporte.PARAMETRO_TIPO_VALOR_NUMERICO) {
						if (!NumeroUtil.isDecimal(getValorTipo())) {
							throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.valor.numerico.error"));
						}
					} else if (getParametro().getNum2() == Soporte.PARAMETRO_TIPO_VALOR_CADENA) {
						if (!TextoUtil.contieneAlgo(getValorTipo())) {
							throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.editar.valor.cadena.error"));
						}
					}
				}
			}
		}
		return true;
	}

	/**
	 * Obtiene tipo busqueda.
	 * Fecha: 22/08/2013
	 *
	 * @return tipo busqueda
	 */
	public Integer getTipoBusqueda() {
		return tipoBusqueda;
	}

	/**
	 * Establece el tipo busqueda.
	 *
	 * @param tipoBusqueda el new tipo busqueda
	 */
	public void setTipoBusqueda(Integer tipoBusqueda) {
		this.tipoBusqueda = tipoBusqueda;
	}

	/**
	 * Obtiene cod parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return cod parametro
	 */
	public Integer getCodParametro() {
		return codParametro;
	}

	/**
	 * Establece el cod parametro.
	 *
	 * @param codParametro el new cod parametro
	 */
	public void setCodParametro(Integer codParametro) {
		this.codParametro = codParametro;
	}

	/**
	 * Obtiene desc parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return desc parametro
	 */
	public String getDescParametro() {
		return descParametro;
	}

	/**
	 * Establece el desc parametro.
	 *
	 * @param descParametro el new desc parametro
	 */
	public void setDescParametro(String descParametro) {
		this.descParametro = descParametro;
	}
	
	/**
	 * Obtiene parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return parametro
	 */
	public Parametro getParametro() {
		if (parametro == null) {
			parametro = ParametroLocalServiceUtil.getInstance() ;
		}
		return parametro;
	}

	/**
	 * Establece el parametro.
	 *
	 * @param parametro el new parametro
	 */
	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}
	
	/**
	 * Obtiene parametro padre.
	 * Fecha: 22/08/2013
	 *
	 * @return parametro padre
	 * @throws Exception the exception
	 */
	public Parametro getParametroPadre() throws Exception {
		if (parametroPadre == null) {
			parametroPadre = ParametroLocalServiceUtil.getInstance();
		}
		/*if (getParametro().getIdParametroPadre() != 0) {
			parametroPadre = ParametroLocalServiceUtil.getParametro(getParametro().getIdParametroPadre());
		}*/
		return parametroPadre;
	}

	/**
	 * Establece el parametro padre.
	 *
	 * @param parametroPadre el new parametro padre
	 */
	public void setParametroPadre(Parametro parametroPadre) {
		this.parametroPadre = parametroPadre;
	}

	/**
	 * Obtiene cod parametro padre.
	 * Fecha: 22/08/2013
	 *
	 * @return cod parametro padre
	 */
	public Integer getCodParametroPadre() {
		if (codParametroPadre == null) {
			codParametroPadre = new Integer(0);
		}
		return codParametroPadre;
	}

	/**
	 * Establece el cod parametro padre.
	 *
	 * @param codParametroPadre el new cod parametro padre
	 */
	public void setCodParametroPadre(Integer codParametroPadre) {
		this.codParametroPadre = codParametroPadre;
	}
	
	/**
	 * Obtiene valor tipo.
	 * Fecha: 22/08/2013
	 *
	 * @return valor tipo
	 */
	public String getValorTipo() {
		if (valorTipo == null) {
			valorTipo = "";
		}
		return valorTipo;
	}

	/**
	 * Establece el valor tipo.
	 *
	 * @param valorTipo el new valor tipo
	 */
	public void setValorTipo(String valorTipo) {
		this.valorTipo = valorTipo;
	}

	/**
	 * Obtiene panel valor.
	 * Fecha: 22/08/2013
	 *
	 * @return panel valor
	 */
	public Boolean getPanelValor() {
		return panelValor;
	}

	/**
	 * Establece el panel valor.
	 *
	 * @param panelValor el new panel valor
	 */
	public void setPanelValor(Boolean panelValor) {
		this.panelValor = panelValor;
	}

	/**
	 * Obtiene panel rango.
	 * Fecha: 22/08/2013
	 *
	 * @return panel rango
	 */
	public Boolean getPanelRango() {
		return panelRango;
	}

	/**
	 * Establece el panel rango.
	 *
	 * @param panelRango el new panel rango
	 */
	public void setPanelRango(Boolean panelRango) {
		this.panelRango = panelRango;
	}

	/**
	 * Obtiene panel lista.
	 * Fecha: 22/08/2013
	 *
	 * @return panel lista
	 */
	public Boolean getPanelLista() {
		return panelLista;
	}

	/**
	 * Establece el panel lista.
	 *
	 * @param panelLista el new panel lista
	 */
	public void setPanelLista(Boolean panelLista) {
		this.panelLista = panelLista;
	}

	/**
	 * Obtiene lista valor por defecto.
	 * Fecha: 22/08/2013
	 *
	 * @return lista valor por defecto
	 */
	public boolean getListaValorPorDefecto() {
		if (getParametro().getIdParametro() != 0) {
			if (getParametro().getNum3() == 1) { listaValorPorDefecto = true; }
			if (getParametro().getNum3() == 0) { listaValorPorDefecto = false; }
		}
		return listaValorPorDefecto;
	}

	/**
	 * Establece el lista valor por defecto.
	 *
	 * @param listaValorPorDefecto el new lista valor por defecto
	 */
	public void setListaValorPorDefecto(boolean listaValorPorDefecto) {
		if (listaValorPorDefecto == true) { getParametro().setNum3(1); }
		if (listaValorPorDefecto == false) { getParametro().setNum3(0); }
		this.listaValorPorDefecto = listaValorPorDefecto;
	}

	/**
	 * Obtiene label form parametros.
	 * Fecha: 22/08/2013
	 *
	 * @return label form parametros
	 */
	public LabelFormParametros getLabelFormParametros() {
		return labelFormParametros;
	}

	/**
	 * Establece el label form parametros.
	 *
	 * @param labelFormParametros el new label form parametros
	 */
	public void setLabelFormParametros(LabelFormParametros labelFormParametros) {
		this.labelFormParametros = labelFormParametros;
	}
	
	public boolean isNuevoRango() {
		return nuevoRango;
	}

	public void setNuevoRango(boolean nuevoRango) {
		this.nuevoRango = nuevoRango;
	}

	public BeanNuevoRango getBeanNuevoRango() {
		return beanNuevoRango;
	}

	public void setBeanNuevoRango(BeanNuevoRango beanNuevoRango) {
		this.beanNuevoRango = beanNuevoRango;
	}
	
	public Integer validarNuevoRango(){
		Integer error = 0;
		if(beanNuevoRango.getEtiquetaProducto().equals("")){
			error = 1;
		}
		else if(beanNuevoRango.getNombreProducto().equals("")){
			error = 2;
		}
		else if(beanNuevoRango.getCodigoSiebel().equals("")){
			error = 3;
		}
		return error;
	}
	
	
}
