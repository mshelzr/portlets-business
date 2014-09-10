package pe.com.ibk.halcon.gestionparametros.criterio;

import java.io.Serializable;

import pe.com.ibk.halcon.gestionparametros.bean.soporte.Soporte;

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
 * The Class CriterioListarParametro.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class CriterioListarParametro implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CriterioListarParametro.class);
	
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
	
	/** The parametro. */
	private Parametro parametro;
	
	/** The desc parametro padre. */
	private String descParametroPadre;
	
	/**
	 * Iniciar.
	 * Fecha: 22/08/2013
	 */
	public void iniciar() {
		tipoBusqueda = null;
		codParametroPadre = null;
		codParametro = null;
		descParametro = null;
		//parametro = null;
		descParametroPadre = null;
	}
	
	/**
	 * Instancia un nuevo criterio listar parametro.
	 */
	public CriterioListarParametro() {
		
	}
	
	/**
	 * Verificar.
	 * Fecha: 22/08/2013
	 *
	 * @param idPanel the id panel
	 * @return true, en caso de exito
	 * @throws BusinessException the business exception
	 */
	public boolean verificar(String idPanel) throws BusinessException {
		if (idPanel != null) {
			if (!TextoUtil.contieneAlgo(getDescParametro()) && !TextoUtil.contieneAlgo(getDescParametroPadre())) {
				throw new BusinessException(Soporte.obtenerResourceBundle().getString("parametro.listar.descripcion.error"));
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
	 * Obtiene cod parametro padre.
	 * Fecha: 22/08/2013
	 *
	 * @return cod parametro padre
	 */
	public Integer getCodParametroPadre() {
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
	 * Obtiene desc parametro padre.
	 * Fecha: 22/08/2013
	 *
	 * @return desc parametro padre
	 */
	public String getDescParametroPadre() {
		return descParametroPadre;
	}

	/**
	 * Establece el desc parametro padre.
	 *
	 * @param descParametroPadre el new desc parametro padre
	 */
	public void setDescParametroPadre(String descParametroPadre) {
		this.descParametroPadre = descParametroPadre;
	}
		
}
