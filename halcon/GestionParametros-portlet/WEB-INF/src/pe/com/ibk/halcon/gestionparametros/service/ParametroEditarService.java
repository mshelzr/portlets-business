package pe.com.ibk.halcon.gestionparametros.service;

import pe.com.ibk.halcon.gestionparametros.bean.BeanEditarParametro;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface ParametroEditarService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface ParametroEditarService {
	
	/**
	 * Listar parametros.
	 * Fecha: 22/08/2013
	 *
	 * @param idPanel the id panel
	 * @throws Exception the exception
	 */
	public void listarParametros(String idPanel) throws Exception;
	
	/**
	 * Guardar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void guardarParametro() throws Exception;
	
	/**
	 * Eliminar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void eliminarParametro() throws Exception;
	
	/**
	 * Limpiar lista parametro.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void limpiarListaParametro() throws Exception;
	
	/**
	 * Mostrar formulario editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	public void mostrarFormularioEditarParametro() throws Exception;

	/**
	 * Obtiene bean editar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return bean editar parametro
	 */
	public BeanEditarParametro getBeanEditarParametro();

	/**
	 * Establece el bean editar parametro.
	 *
	 * @param beanEditarParametro el new bean editar parametro
	 */
	public void setBeanEditarParametro(BeanEditarParametro beanEditarParametro);

}
