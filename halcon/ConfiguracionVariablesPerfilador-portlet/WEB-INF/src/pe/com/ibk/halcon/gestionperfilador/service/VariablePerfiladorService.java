package pe.com.ibk.halcon.gestionperfilador.service;

import java.util.List;

import pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoVariables;
import pe.com.ibk.halcon.gestionperfilador.bean.VariablePerfiladorBean;

import com.ext.portlet.halcon.model.ConfiguracionPerfilador;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface VariablePerfiladorService.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
public interface VariablePerfiladorService {

	/**
	 * Obtiene bean listado preguntas. Fecha: 24/06/2013
	 * 
	 * @return bean listado preguntas
	 */
	public BeanListadoVariables getBeanListadoPreguntas();

	/**
	 * Establece el bean listado preguntas.
	 * 
	 * @param beanListadoPreguntas el new bean listado preguntas
	 */
	public void setBeanListadoPreguntas(BeanListadoVariables beanListadoPreguntas);

	/**
	 * Obtiene variable perfilador bean. Fecha: 24/06/2013
	 * 
	 * @return variable perfilador bean
	 */
	public VariablePerfiladorBean getVariablePerfiladorBean();

	/**
	 * Establece el variable perfilador bean.
	 * 
	 * @param variablePerfiladorBean el new variable perfilador bean
	 */
	public void setVariablePerfiladorBean(VariablePerfiladorBean variablePerfiladorBean);

	/**
	 * Listar variables. Fecha: 24/06/2013
	 * 
	 * @throws Exception the exception
	 */
	public void listarVariables() throws Exception;

	/**
	 * Consultar bean listado variables. Fecha: 24/06/2013
	 * 
	 * @return the bean listado variables
	 */
	public BeanListadoVariables consultarBeanListadoVariables();

	/**
	 * Guardar variable perfilador. Fecha: 24/06/2013
	 * 
	 * @param configuracionPerfilador the configuracion perfilador
	 */
	public void guardarVariablePerfilador(ConfiguracionPerfilador configuracionPerfilador);

	/**
	 * Convertir pregunta bean configuracion. Fecha: 24/06/2013
	 * 
	 * @param varBean the var bean
	 * @param flagNuevo the flag nuevo
	 * @return the configuracion perfilador
	 * @throws Exception the exception
	 */
	public ConfiguracionPerfilador convertirPreguntaBeanConfiguracion(VariablePerfiladorBean varBean, Boolean flagNuevo) throws Exception;

	/**
	 * Buscar configuracion perfilador. Fecha: 24/06/2013
	 * 
	 * @param idConfiguracionPerfilador the id configuracion perfilador
	 * @return the configuracion perfilador
	 */
	public ConfiguracionPerfilador buscarConfiguracionPerfilador(Long idConfiguracionPerfilador);

	// public BeanConfiguracionVariable getBeanConfiguracionVariable();
	// public void setBeanConfiguracionVariable(BeanConfiguracionVariable
	// beanConfiguracionVariable);
	// public void listarVariables() throws Exception;
	// public ConfiguracionPerfilador convertirBeanConfiguracion(VariablePerfiladorBean varBean);

	public List<String> validarVariablePregunta(VariablePerfiladorBean variable);
}
