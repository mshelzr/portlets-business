package com.ext.portlet.halcon.dto;

import java.math.BigInteger;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SolicitudProductoResponseBean.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  30/04/2013
 * @version Halcon 1.0
 */
public class SolicitudProductoResponseBean {
	
	/** The calificacion. */
	private BigInteger calificacion; //Usado en Precalificacion
	
	/** The codigo atencion. */
	private BigInteger codigoAtencion;  //Usado en Precalificacion
	
	/** The codigo oportunidad. */
	private String codigoOportunidad; //Usado en Registro Leads
	
	/** The codigo error. */
	private String codigoError;  //Usado en Registro Leads
	
	/** The motivo error. */
	private String motivoError;  //Usado en Registro Leads
	
	/**
	 * Instancia un nuevo solicitud producto response bean.
	 */
	public SolicitudProductoResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Obtiene calificacion.
	 * Fecha: 30/04/2013
	 *
	 * @return calificacion
	 */
	public BigInteger getCalificacion() {
		return calificacion;
	}
	
	/**
	 * Establece el calificacion.
	 *
	 * @param calificacion el new calificacion
	 */
	public void setCalificacion(BigInteger calificacion) {
		this.calificacion = calificacion;
	}
	
	/**
	 * Obtiene codigo atencion.
	 * Fecha: 30/04/2013
	 *
	 * @return codigo atencion
	 */
	public BigInteger getCodigoAtencion() {
		return codigoAtencion;
	}
	
	/**
	 * Establece el codigo atencion.
	 *
	 * @param codigoAtencion el new codigo atencion
	 */
	public void setCodigoAtencion(BigInteger codigoAtencion) {
		this.codigoAtencion = codigoAtencion;
	}

	/**
	 * Obtiene codigo oportunidad.
	 * Fecha: 30/04/2013
	 *
	 * @return codigo oportunidad
	 */
	public String getCodigoOportunidad() {
		return codigoOportunidad;
	}

	/**
	 * Establece el codigo oportunidad.
	 *
	 * @param codigoOportunidad el new codigo oportunidad
	 */
	public void setCodigoOportunidad(String codigoOportunidad) {
		this.codigoOportunidad = codigoOportunidad;
	}

	/**
	 * Obtiene codigo error.
	 * Fecha: 30/04/2013
	 *
	 * @return codigo error
	 */
	public String getCodigoError() {
		return codigoError;
	}

	/**
	 * Establece el codigo error.
	 *
	 * @param codigoError el new codigo error
	 */
	public void setCodigoError(String codigoError) {
		this.codigoError = codigoError;
	}

	/**
	 * Obtiene motivo error.
	 * Fecha: 30/04/2013
	 *
	 * @return motivo error
	 */
	public String getMotivoError() {
		return motivoError;
	}

	/**
	 * Establece el motivo error.
	 *
	 * @param motivoError el new motivo error
	 */
	public void setMotivoError(String motivoError) {
		this.motivoError = motivoError;
	}
	
	
}
