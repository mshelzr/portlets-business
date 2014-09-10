package pe.com.ibk.halcon.gestionparametros.service;

import pe.com.ibk.halcon.gestionparametros.bean.BeanListarParametro;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface ParametroListarService.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public interface ParametroListarService {
	
	/**
	 * Listar parametros.
	 * Fecha: 22/08/2013
	 *
	 * @param idPanel the id panel
	 * @throws Exception the exception
	 */
	public void listarParametros(String idPanel) throws Exception;
	
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
	 * Obtiene bean listar parametro.
	 * Fecha: 22/08/2013
	 *
	 * @return bean listar parametro
	 */
	public BeanListarParametro getBeanListarParametro();

	/**
	 * Establece el bean listar parametro.
	 *
	 * @param beanListarParametro el new bean listar parametro
	 */
	public void setBeanListarParametro(BeanListarParametro beanListarParametro);

}
