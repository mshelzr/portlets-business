package com.ext.portlet.halcon.service.soporte;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Ocurrencia;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.OcurrenciaLocalServiceUtil;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class Soporte.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public class Soporte {

	/** The Constant PETICION_ACTIVO. */
	public final static int PETICION_ACTIVO = 1;
	
	/** The Constant PETICION_INACTIVO. */
	public final static int PETICION_INACTIVO = 0;
	
	/** The Constant MASK_PORCENTAJE. */
	public final static String MASK_PORCENTAJE = "%";
	
	/** The Constant PROPERTIES_PORTLET. */
	public final static String PROPERTIES_PORTLET = "com.ext.portlet.halcon.resource.Language";
	
	/** The Constant PATRON_FECHA_CORTA. */
	public final static String PATRON_FECHA_CORTA = "dd/MM/yyyy";
	
	/** The Constant PATRON_FECHA_LARGA. */
	public final static String PATRON_FECHA_LARGA = "yyyy-mm-dd hh:mm:ss.SSS";
	
	/** The Constant PRIMERA_OCURRENCIA. */
	public final static int PRIMERA_OCURRENCIA = 1;
	
	/** The Constant OCURRENCIA_INTERVALO_INCREMENTO. */
	public final static int OCURRENCIA_INTERVALO_INCREMENTO = 1;
	
	/** The Constant PARAMETRO_ACTIVO. */
	public final static int PARAMETRO_ACTIVO = 1;
	
	/** The Constant PARAMETRO_INACTIVO. */
	public final static int PARAMETRO_INACTIVO = 0;
	
	/** The j son util. */
	//JSonUtil jSonUtil=new JSonUtil();
	
	ConcurrentHashMap<String, RangoBean> hashRango;
	/**
	 * Obtener resource bundle.
	 * Fecha: 21/08/2013
	 *
	 * @return the resource bundle
	 */
	public static ResourceBundle obtenerResourceBundle() {
		return ResourceBundle.getBundle(PROPERTIES_PORTLET);
	}
	
	/**
	 * Obtener ultima peticion.
	 * Fecha: 21/08/2013
	 *
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param estado the estado
	 * @param fecha the fecha
	 * @return the ocurrencia
	 * @throws BusinessException the business exception
	 */
	public Ocurrencia obtenerUltimaPeticion(String ip, String codigoProducto, Integer estado, String fecha) throws BusinessException  {
		List<Ocurrencia> listaPeticion = new ArrayList<Ocurrencia>();
	
		listaPeticion = OcurrenciaLocalServiceUtil.obtenerUltimaPeticion(ip, codigoProducto, estado, fecha);
		
		return (listaPeticion.size()!=0 ? listaPeticion.get(0) : OcurrenciaLocalServiceUtil.getInstance());
	}
	
	/**
	 * Cambiar peticion estado.
	 * Fecha: 21/08/2013
	 *
	 * @param idPeticion the id peticion
	 * @param estado the estado
	 * @throws BusinessException the business exception
	 */
	public void cambiarPeticionEstado(Long idPeticion, Integer estado) throws BusinessException {
		
		OcurrenciaLocalServiceUtil.cambiarPeticionEstado(idPeticion, estado);
		
	}
	
	/**
	 * Obtener fecha actual con patron.
	 * Fecha: 21/08/2013
	 *
	 * @param patron the patron
	 * @return the string
	 */
	public String obtenerFechaActualConPatron(String patron)  {
		return TiempoUtil.getFechaActualConPatron(patron);
	}
	
	/*public Peticion insertarPeticion(Peticion peticion) throws Exception {
		return PeticionLocalServiceUtil.insertarPeticion(peticion.getIp(), peticion.getCodigoProducto(), TiempoUtil.getTiempoActualEnTimestamp().toString(), peticion.getEstado(), peticion.getOcurrencia());
	}*/
	
	/**
	 * Adicionar peticion.
	 * Fecha: 21/08/2013
	 *
	 * @param peticion the peticion
	 * @return the ocurrencia
	 * @throws Exception the exception
	 */
	public Ocurrencia adicionarPeticion(Ocurrencia peticion) throws Exception  {
		return OcurrenciaLocalServiceUtil.insertar(peticion);
	}

	/**
	 * Obtener rango.
	 * Fecha: 21/08/2013
	 *
	 * @param etiqueta the etiqueta
	 * @param request the request
	 * @return the rango bean
	 * @throws Exception the exception
	 */
	public RangoBean obtenerRango(String etiqueta, RenderRequest request) throws Exception {
		return getRango(etiqueta, request);
	}
	
	/**
	 * Obtener rango.
	 * Fecha: 21/08/2013
	 *
	 * @param etiqueta the etiqueta
	 * @param request the request
	 * @return the rango bean
	 * @throws Exception the exception
	 */
	public RangoBean obtenerRango(String etiqueta, ResourceRequest request) throws Exception {
		return getRango(etiqueta, request);
	}
	

	private RangoBean getRango(String valor, ResourceRequest request) {
		return cargarHash(valor);
	}
	
	private RangoBean getRango(String valor, RenderRequest request) {
		return cargarHash(valor);
	}
	
	@SuppressWarnings("unchecked")
	private RangoBean cargarHash(String valor){
		try {
			//hashRango = (ConcurrentHashMap<String, RangoBean>) MultiVMPoolUtil.get("pe.com.ibk.halcon.soporte.cache.util.CacheSoporteUtil","hashRango");

			//if (hashRango == null) {

				hashRango = new ConcurrentHashMap<String, RangoBean>();
				List<Parametro> listaRango;
				try {
					listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
					for (Parametro param : listaRango) {
						hashRango.put(param.getDato3(), new RangoBean(param.getDato3(),param.getValorMonto1(), param.getValorMonto2(), param.getValorMonto3()));
					}
					//MultiVMPoolUtil.put( "pe.com.ibk.halcon.soporte.cache.util.CacheSoporteUtil","hashRango", hashRango);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return hashRango.get(valor);
	}
	
}
