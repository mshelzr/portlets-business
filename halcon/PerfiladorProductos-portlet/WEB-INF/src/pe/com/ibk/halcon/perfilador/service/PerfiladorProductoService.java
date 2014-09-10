package pe.com.ibk.halcon.perfilador.service;

import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;

import pe.com.ibk.halcon.perfilador.bean.ProductoBean;
import pe.com.ibk.halcon.perfilador.bean.VariablePerfiladorBean;

import com.ext.portlet.halcon.model.ConfiguracionPerfilador;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Interface PerfiladorProductoService.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
public interface PerfiladorProductoService {

	/**
	 * Convertir bean variable. Fecha: 24/06/2013
	 * 
	 * @param conf the conf
	 * @return the variable perfilador bean
	 */
	public VariablePerfiladorBean convertirBeanVariable(ConfiguracionPerfilador conf);

	/**
	 * Convertir listado perfilador. Fecha: 24/06/2013
	 * 
	 * @param listaVariables the lista variables
	 * @param codTipoPerfilador the cod tipo perfilador
	 */
	public void convertirListadoPerfilador(List<VariablePerfiladorBean> listaVariables, String codTipoPerfilador);

	/**
	 * Obtener listado productos. Fecha: 24/06/2013
	 * 
	 * @param idConfiguracionPerfilador the id configuracion perfilador
	 * @param resourceRequest the resource request
	 * @return the list
	 */
	public List<ProductoBean> obtenerListadoProductos(Long idConfiguracionPerfilador, ResourceRequest resourceRequest);

	/**
	 * Guardar datos perfilador. Fecha: 24/06/2013
	 * 
	 * @param tipoDoc the tipo doc
	 * @param numeroDoc the numero doc
	 * @param perfilador the perfilador
	 * @param sesion the sesion
	 * @param transaccion the transaccion
	 * @param monto the monto
	 * @param tipoCredito the tipo credito
	 * @param ip the ip
	 * @param fechaHora the fecha hora
	 * @param UTMSource the uTM source
	 * @param UTMMedium the uTM medium
	 * @param UTMCampaign the uTM campaign
	 * @param UTMContent the uTM content
	 */
	public void guardarDatosPerfilador(String tipoDoc, String numeroDoc, String perfilador, String sesion, String transaccion, double monto, String tipoCredito, String ip, String pregunta1,
			String pregunta2, String pregunta3, String pregunta4, String respuesta1, String respuesta2, String respuesta3, String respuesta4, Date fechaHora, String UTMSource, String UTMMedium,
			String UTMCampaign, String UTMContent);

	/**
	 * Obtener listado preguntas perfilador. Fecha: 24/06/2013
	 * 
	 * @param idPerfiladorProd the id perfilador prod
	 * @param topLevel the top level
	 * @return the list
	 */
	public List<VariablePerfiladorBean> obtenerListadoPreguntasPerfilador(Long idPerfiladorProd, int topLevel);

	/**
	 * Actualizar listado preguntas perfilador. Fecha: 24/06/2013
	 * 
	 * @param idVariable the id variable
	 * @param nivel the nivel
	 * @return the list
	 */
	public List<VariablePerfiladorBean> actualizarListadoPreguntasPerfilador(Long idVariable, int nivel);

	/**
	 * Obtener id rango registrar. Fecha: 24/06/2013
	 * 
	 * @param config the config
	 * @param valor3 the valor3
	 * @return the long
	 */
	public Long obtenerIdRangoRegistrar(String config, String valor3);
}
