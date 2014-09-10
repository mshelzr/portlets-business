package com.ext.portlet.halcon.service.impl;

import java.util.Date;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;

import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.service.criterio.CriterioValidarPeticion;
import com.ext.portlet.halcon.service.soporte.Soporte;
import com.ext.portlet.halcon.service.soporte.SoporteValidarPeticion;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SeguridadLocalServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public class SeguridadLocalServiceImpl {
	
	/** The criterio validar peticion. */
	private CriterioValidarPeticion criterioValidarPeticion;
	
	/** The soporte validar peticion. */
	private SoporteValidarPeticion soporteValidarPeticion;
	
	/**
	 * Instancia un nuevo seguridad local service impl.
	 */
	public SeguridadLocalServiceImpl () {
		
	}
	
	/**
	 * Validar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public Object[] validar(RenderRequest request, String ip, String codigoProducto, String etiqueta) throws BusinessException, Exception {
		Object[] objRetorno = new Object[2];
		
		String mensaje = new String("");
		Boolean valido = new Boolean(false);
		
		getCriterioValidarPeticion().iniciar();
		getCriterioValidarPeticion().cargarCriterios(ip, codigoProducto, getSoporteValidarPeticion().obtenerRango(etiqueta, request));
		
		if (getCriterioValidarPeticion().verificar("")) {
			getCriterioValidarPeticion().setUltimaPeticion(getSoporteValidarPeticion().obtenerUltimaPeticion(ip, codigoProducto, Soporte.PETICION_ACTIVO, getSoporteValidarPeticion().obtenerFechaActualConPatron(Soporte.PATRON_FECHA_CORTA)));
			if (getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion()!=0) {
				if ((getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO) <= getCriterioValidarPeticion().getLimitePeticiones()) {		
					cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO);
					getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
					getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
					mensaje = "";
					valido = true;
				} else {
					if (SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()) <= getCriterioValidarPeticion().getTiempoEspera()) {
						int tiempoRestante = getCriterioValidarPeticion().getTiempoEspera() - SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()); 
						mensaje = "" + String.valueOf(tiempoRestante);
						valido = false;
					} else {						
						cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
						getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
						getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
						mensaje = "";
						valido = true;
					}
				}
			} else {
				cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
				getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
				mensaje = "";
				valido = true;
			}
		}
		
		objRetorno[0] = valido;
		objRetorno[1] = mensaje;
		
		return objRetorno;
	}
	
	/**
	 * Consultar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public Object[] consultar(RenderRequest request, String ip, String codigoProducto, String etiqueta) throws BusinessException, Exception {
		Object[] objRetorno = new Object[2];
		
		String mensaje = new String("");
		Boolean valido = new Boolean(false);
		
		getCriterioValidarPeticion().iniciar();
		getCriterioValidarPeticion().cargarCriterios(ip, codigoProducto, getSoporteValidarPeticion().obtenerRango(etiqueta, request));
		
		if (getCriterioValidarPeticion().verificar("")) {
			getCriterioValidarPeticion().setUltimaPeticion(getSoporteValidarPeticion().obtenerUltimaPeticion(ip, codigoProducto, Soporte.PETICION_ACTIVO, getSoporteValidarPeticion().obtenerFechaActualConPatron(Soporte.PATRON_FECHA_CORTA)));
			if (getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion()!=0) {
				if ((getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO) <= getCriterioValidarPeticion().getLimitePeticiones()) {		
					cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO);
					//getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
					//getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
					mensaje = "";
					valido = true;
				} else {
					if (SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()) <= getCriterioValidarPeticion().getTiempoEspera()) {
						int tiempoRestante = getCriterioValidarPeticion().getTiempoEspera() - SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()); 
						mensaje = "" + String.valueOf(tiempoRestante);
						valido = false;
					} else {						
						cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
						//getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
						//getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
						mensaje = "";
						valido = true;
					}
				}
			} else {
				cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
				//getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
				mensaje = "";
				valido = true;
			}
		}
		
		objRetorno[0] = valido;
		objRetorno[1] = mensaje;
		
		if (!valido) {
			String asunto = Propiedades.getResourceBundle("soporte.seguridad.local.service.impl.consultar");
			LogErrorUtil.registrarError(String.format("{ip:%s,codigoProducto:%s,etiqueta:%s}", ip,codigoProducto,etiqueta), "", asunto+" "+etiqueta);
		}
		
		return objRetorno;
	}
	/*RONALD*/
	/**
	 * Validar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public Object[] validar(ResourceRequest request, String ip, String codigoProducto, String etiqueta) throws BusinessException, Exception {
		Object[] objRetorno = new Object[2];
		
		String mensaje = new String("");
		Boolean valido = new Boolean(false);
		
		getCriterioValidarPeticion().iniciar();
		getCriterioValidarPeticion().cargarCriterios(ip, codigoProducto, getSoporteValidarPeticion().obtenerRango(etiqueta, request));
		
		if (getCriterioValidarPeticion().verificar("")) {
			getCriterioValidarPeticion().setUltimaPeticion(getSoporteValidarPeticion().obtenerUltimaPeticion(ip, codigoProducto, Soporte.PETICION_ACTIVO, getSoporteValidarPeticion().obtenerFechaActualConPatron(Soporte.PATRON_FECHA_CORTA)));
			if (getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion()!=0) {
				if ((getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO) <= getCriterioValidarPeticion().getLimitePeticiones()) {		
					cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO);
					getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
					getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
					mensaje = "";
					valido = true;
				} else {
					if (SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()) <= getCriterioValidarPeticion().getTiempoEspera()) {
						int tiempoRestante = getCriterioValidarPeticion().getTiempoEspera() - SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()); 
						mensaje = "" + String.valueOf(tiempoRestante);
						valido = false;
					} else {						
						cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
						getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
						getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
						mensaje = "";
						valido = true;
					}
				}
			} else {
				cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
				getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
				mensaje = "";
				valido = true;
			}
		}
		
		objRetorno[0] = valido;
		objRetorno[1] = mensaje;
		
		return objRetorno;
	}
	
	/**
	 * Consultar.
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the object[]
	 * @throws BusinessException the business exception
	 * @throws Exception the exception
	 */
	public Object[] consultar(ResourceRequest request, String ip, String codigoProducto, String etiqueta) throws BusinessException, Exception {
		Object[] objRetorno = new Object[2];
		
		String mensaje = new String("");
		Boolean valido = new Boolean(false);
		
		getCriterioValidarPeticion().iniciar();
		getCriterioValidarPeticion().cargarCriterios(ip, codigoProducto, getSoporteValidarPeticion().obtenerRango(etiqueta, request));
		
		if (getCriterioValidarPeticion().verificar("")) {
			getCriterioValidarPeticion().setUltimaPeticion(getSoporteValidarPeticion().obtenerUltimaPeticion(ip, codigoProducto, Soporte.PETICION_ACTIVO, getSoporteValidarPeticion().obtenerFechaActualConPatron(Soporte.PATRON_FECHA_CORTA)));
			if (getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion()!=0) {
				if ((getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO) <= getCriterioValidarPeticion().getLimitePeticiones()) {		
					cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, getCriterioValidarPeticion().getUltimaPeticion().getOcurrencia() + Soporte.OCURRENCIA_INTERVALO_INCREMENTO);
					//getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
					//getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
					mensaje = "";
					valido = true;
				} else {
					if (SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()) <= getCriterioValidarPeticion().getTiempoEspera()) {
						int tiempoRestante = getCriterioValidarPeticion().getTiempoEspera() - SoporteValidarPeticion.obtenerMinutosTranscurridos(getCriterioValidarPeticion().getUltimaPeticion().getFecha()); 
						mensaje = "" + String.valueOf(tiempoRestante);
						valido = false;
					} else {						
						cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
						//getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
						//getSoporteValidarPeticion().cambiarPeticionEstado(getCriterioValidarPeticion().getUltimaPeticion().getIdGestionPeticion(), Soporte.PETICION_INACTIVO);
						mensaje = "";
						valido = true;
					}
				}
			} else {
				cargarPeticion(ip, codigoProducto, TiempoUtil.getTiempoActualEnDate(), Soporte.PETICION_ACTIVO, Soporte.PRIMERA_OCURRENCIA);
				//getSoporteValidarPeticion().adicionarPeticion(getCriterioValidarPeticion().getPeticion());
				mensaje = "";
				valido = true;
			}
		}
		
		objRetorno[0] = valido;
		objRetorno[1] = mensaje;
		
		if (!valido) {
			String asunto = Propiedades.getResourceBundle("soporte.seguridad.local.service.impl.consultar");
			LogErrorUtil.registrarError(String.format("{ip:%s,codigoProducto:%s,etiqueta:%s}", ip,codigoProducto,etiqueta), "", asunto+" "+etiqueta);
		}
		
		return objRetorno;
	}
	/*TERMINA RONALD*/
	
	/**
	 * Cargar peticion.
	 * Fecha: 21/08/2013
	 *
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param fecha the fecha
	 * @param estado the estado
	 * @param ocurrencia the ocurrencia
	 */
	private void cargarPeticion(String ip, String codigoProducto, Date fecha, Integer estado, Integer ocurrencia) {
		getCriterioValidarPeticion().getPeticion().setIp(ip);
		getCriterioValidarPeticion().getPeticion().setCodigoProducto(codigoProducto);
		getCriterioValidarPeticion().getPeticion().setFecha(fecha);
		getCriterioValidarPeticion().getPeticion().setEstado(estado);
		getCriterioValidarPeticion().getPeticion().setOcurrencia(ocurrencia);
	}
	
	/**
	 * Obtiene la instancia de SeguridadLocalServiceImpl.
	 * Fecha: 21/08/2013
	 *
	 * @return instancia de SeguridadLocalServiceImpl
	 */
	public SeguridadLocalServiceImpl getInstance() {
		return new SeguridadLocalServiceImpl();
	}

	/**
	 * Obtiene soporte validar peticion.
	 * Fecha: 21/08/2013
	 *
	 * @return soporte validar peticion
	 */
	public SoporteValidarPeticion getSoporteValidarPeticion() {
		if (soporteValidarPeticion == null) {
			soporteValidarPeticion = new SoporteValidarPeticion();
		}
		return soporteValidarPeticion;
	}

	/**
	 * Establece el soporte validar peticion.
	 *
	 * @param soporteValidarPeticion el new soporte validar peticion
	 */
	public void setSoporteValidarPeticion(
			SoporteValidarPeticion soporteValidarPeticion) {
		this.soporteValidarPeticion = soporteValidarPeticion;
	}

	/**
	 * Obtiene criterio validar peticion.
	 * Fecha: 21/08/2013
	 *
	 * @return criterio validar peticion
	 */
	public CriterioValidarPeticion getCriterioValidarPeticion() {
		if (criterioValidarPeticion == null) {
			criterioValidarPeticion = new CriterioValidarPeticion();
		}
		return criterioValidarPeticion;
	}

	/**
	 * Establece el criterio validar peticion.
	 *
	 * @param criterioValidarPeticion el new criterio validar peticion
	 */
	public void setCriterioValidarPeticion(
			CriterioValidarPeticion criterioValidarPeticion) {
		this.criterioValidarPeticion = criterioValidarPeticion;
	}
	
}
