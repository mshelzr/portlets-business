package com.ext.portlet.halcon.service.criterio;

import com.exp.portlet.halcon.utils.EnteroUtil;
import com.exp.portlet.halcon.utils.TextoUtil;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Ocurrencia;
import com.ext.portlet.halcon.service.OcurrenciaLocalServiceUtil;
import com.ext.portlet.halcon.service.soporte.Soporte;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CriterioValidarPeticion.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
public class CriterioValidarPeticion {
	
	/** The limite peticiones. */
	private Integer limitePeticiones;
	
	/** The tiempo espera. */
	private Integer tiempoEspera;
	
	/** The ip. */
	private String ip;
	
	/** The codigo producto. */
	private String codigoProducto;
	
	/** The ultima peticion. */
	private Ocurrencia ultimaPeticion;
	
	/** The peticion. */
	private Ocurrencia peticion;
	
	/** The rango. */
	private RangoBean rango;
	
	/**
	 * Iniciar.
	 * Fecha: 21/08/2013
	 */
	public void iniciar() {
		limitePeticiones = 3;
		tiempoEspera = 2;
		ip = null;
		codigoProducto = null;
		ultimaPeticion = null;
		peticion = null;
		rango = null;
	}
	
	/**
	 * Instancia un nuevo criterio validar peticion.
	 */
	public CriterioValidarPeticion() {
		
	}
	
	/**
	 * Verificar.
	 * Fecha: 21/08/2013
	 *
	 * @param idPanel the id panel
	 * @return true, en caso de exito
	 * @throws BusinessException the business exception
	 */
	public boolean verificar(String idPanel) throws BusinessException {
		if (idPanel != null) {
			if (!TextoUtil.contieneAlgo(getIp())) {
				throw new BusinessException(Soporte.obtenerResourceBundle().getString("edicion.validar.ip.error"));
			} else if (!TextoUtil.contieneAlgo(getCodigoProducto())) {
				throw new BusinessException(Soporte.obtenerResourceBundle().getString("edicion.validar.codproducto.error"));
			} else if (!TextoUtil.contieneAlgo(getRango().getEtiqueta())) {
				throw new BusinessException(Soporte.obtenerResourceBundle().getString("edicion.validar.rango.error"));
			}
		}
		return true;
	}
	
	/**
	 * Cargar criterios.
	 * Fecha: 21/08/2013
	 *
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param rango the rango
	 */
	public void cargarCriterios(String ip, String codigoProducto, RangoBean rango) {
		
		if (ip != null && TextoUtil.contieneAlgo(ip)) setIp(ip);
		if (codigoProducto != null && TextoUtil.contieneAlgo(codigoProducto)) setCodigoProducto(codigoProducto);
		if (rango != null && TextoUtil.contieneAlgo(rango.getValorFinal())) setLimitePeticiones(EnteroUtil.convertirCadenaAEntero(rango.getValorFinal()));
		if (rango != null && TextoUtil.contieneAlgo(rango.getIncremento())) setTiempoEspera(EnteroUtil.convertirCadenaAEntero(rango.getIncremento()));
		if (rango != null) setRango(rango);
	}

	/**
	 * Obtiene ultima peticion.
	 * Fecha: 21/08/2013
	 *
	 * @return ultima peticion
	 */
	public Ocurrencia getUltimaPeticion() {
		if (ultimaPeticion == null) {
			ultimaPeticion = OcurrenciaLocalServiceUtil.getInstance();
		}
		return ultimaPeticion;
	}

	/**
	 * Establece el ultima peticion.
	 *
	 * @param ultimaPeticion el new ultima peticion
	 */
	public void setUltimaPeticion(Ocurrencia ultimaPeticion) {
		this.ultimaPeticion = ultimaPeticion;
	}

	/**
	 * Obtiene peticion.
	 * Fecha: 21/08/2013
	 *
	 * @return peticion
	 */
	public Ocurrencia getPeticion() {
		if (peticion == null) {
			peticion = OcurrenciaLocalServiceUtil.getInstance();
		}
		return peticion;
	}

	/**
	 * Establece el peticion.
	 *
	 * @param peticion el new peticion
	 */
	public void setPeticion(Ocurrencia peticion) {
		this.peticion = peticion;
	}

	/**
	 * Obtiene limite peticiones.
	 * Fecha: 21/08/2013
	 *
	 * @return limite peticiones
	 */
	public Integer getLimitePeticiones() {
		return limitePeticiones;
	}

	/**
	 * Establece el limite peticiones.
	 *
	 * @param limitePeticiones el new limite peticiones
	 */
	public void setLimitePeticiones(Integer limitePeticiones) {
		this.limitePeticiones = limitePeticiones;
	}

	/**
	 * Obtiene tiempo espera.
	 * Fecha: 21/08/2013
	 *
	 * @return tiempo espera
	 */
	public Integer getTiempoEspera() {
		return tiempoEspera;
	}

	/**
	 * Establece el tiempo espera.
	 *
	 * @param tiempoEspera el new tiempo espera
	 */
	public void setTiempoEspera(Integer tiempoEspera) {
		this.tiempoEspera = tiempoEspera;
	}

	/**
	 * Obtiene ip.
	 * Fecha: 21/08/2013
	 *
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Establece el ip.
	 *
	 * @param ip el new ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * Obtiene codigo producto.
	 * Fecha: 21/08/2013
	 *
	 * @return codigo producto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Establece el codigo producto.
	 *
	 * @param codigoProducto el new codigo producto
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * Obtiene rango.
	 * Fecha: 21/08/2013
	 *
	 * @return rango
	 */
	public RangoBean getRango() {
		if (rango == null) {
			rango = new RangoBean();
		}
		return rango;
	}

	/**
	 * Establece el rango.
	 *
	 * @param rango el new rango
	 */
	public void setRango(RangoBean rango) {
		this.rango = rango;
	}
	
}
