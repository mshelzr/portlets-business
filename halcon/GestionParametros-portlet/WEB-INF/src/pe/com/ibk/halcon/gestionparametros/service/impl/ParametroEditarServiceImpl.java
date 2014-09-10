package pe.com.ibk.halcon.gestionparametros.service.impl;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.gestionparametros.bean.BeanEditarParametro;
import pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ParametroEditarServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class ParametroEditarServiceImpl implements ParametroEditarService {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ParametroEditarServiceImpl.class);
	
	/** The bean editar parametro. */
	protected BeanEditarParametro beanEditarParametro;
	
	/**
	 * Instancia un nuevo parametro editar service impl.
	 */
	public ParametroEditarServiceImpl() {
	
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#listarParametros(java.lang.String)
	 */
	public void listarParametros(String idPanel) throws Exception {
		getBeanEditarParametro().listar();
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#guardarParametro()
	 */
	public void guardarParametro() throws Exception {
		getBeanEditarParametro().guardar();
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#eliminarParametro()
	 */
	public void eliminarParametro() throws Exception {
		getBeanEditarParametro().eliminar();
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#limpiarListaParametro()
	 */
	public void limpiarListaParametro() throws Exception {
		getBeanEditarParametro().limpiarListaParametro();
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#mostrarFormularioEditarParametro()
	 */
	public void mostrarFormularioEditarParametro() throws Exception {
		getBeanEditarParametro().mostrarFormularioEditarParametro();
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#getBeanEditarParametro()
	 */
	public BeanEditarParametro getBeanEditarParametro() {
		if (beanEditarParametro == null) {
			beanEditarParametro = new BeanEditarParametro();
		}
		return beanEditarParametro;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroEditarService#setBeanEditarParametro(pe.com.ibk.halcon.gestionparametros.bean.BeanEditarParametro)
	 */
	public void setBeanEditarParametro(BeanEditarParametro beanEditarParametro) {
		this.beanEditarParametro = beanEditarParametro;
	}

}
