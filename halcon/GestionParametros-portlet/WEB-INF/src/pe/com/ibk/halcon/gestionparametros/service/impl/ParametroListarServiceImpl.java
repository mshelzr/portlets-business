package pe.com.ibk.halcon.gestionparametros.service.impl;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.gestionparametros.bean.BeanListarParametro;
import pe.com.ibk.halcon.gestionparametros.service.ParametroListarService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ParametroListarServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class ParametroListarServiceImpl implements ParametroListarService {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ParametroListarServiceImpl.class);
	
	/** The bean listar parametro. */
	protected BeanListarParametro beanListarParametro;
	
	/**
	 * Instancia un nuevo parametro listar service impl.
	 */
	public ParametroListarServiceImpl() {
	
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroListarService#listarParametros(java.lang.String)
	 */
	public void listarParametros(String idPanel) throws Exception {
		getBeanListarParametro().listar();
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroListarService#eliminarParametro()
	 */
	public void eliminarParametro() throws Exception {
		getBeanListarParametro().eliminar();
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroListarService#limpiarListaParametro()
	 */
	public void limpiarListaParametro() throws Exception {
		getBeanListarParametro().limpiarListaParametro();
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroListarService#getBeanListarParametro()
	 */
	public BeanListarParametro getBeanListarParametro() {
		if (beanListarParametro == null) {
			beanListarParametro = new BeanListarParametro();
		}
		return beanListarParametro;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroListarService#setBeanListarParametro(pe.com.ibk.halcon.gestionparametros.bean.BeanListarParametro)
	 */
	public void setBeanListarParametro(BeanListarParametro beanListarParametro) {
		this.beanListarParametro = beanListarParametro;
	}


}
