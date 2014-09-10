/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ext.portlet.halcon.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SolicitudContacto}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       SolicitudContacto
 * @generated
 */
public class SolicitudContactoWrapper implements SolicitudContacto,
	ModelWrapper<SolicitudContacto> {
	public SolicitudContactoWrapper(SolicitudContacto solicitudContacto) {
		_solicitudContacto = solicitudContacto;
	}

	public Class<?> getModelClass() {
		return SolicitudContacto.class;
	}

	public String getModelClassName() {
		return SolicitudContacto.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idSolicitudContacto", getIdSolicitudContacto());
		attributes.put("esCliente", getEsCliente());
		attributes.put("nombres", getNombres());
		attributes.put("apellidos", getApellidos());
		attributes.put("email", getEmail());
		attributes.put("tipoDocumento", getTipoDocumento());
		attributes.put("ndocumento", getNdocumento());
		attributes.put("direccion", getDireccion());
		attributes.put("departamento", getDepartamento());
		attributes.put("provincia", getProvincia());
		attributes.put("distrito", getDistrito());
		attributes.put("telefono", getTelefono());
		attributes.put("fecha", getFecha());
		attributes.put("mensaje", getMensaje());
		attributes.put("moneda", getMoneda());
		attributes.put("importe", getImporte());
		attributes.put("tipoMensaje", getTipoMensaje());
		attributes.put("tipoTema", getTipoTema());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idSolicitudContacto = (Long)attributes.get("idSolicitudContacto");

		if (idSolicitudContacto != null) {
			setIdSolicitudContacto(idSolicitudContacto);
		}

		Integer esCliente = (Integer)attributes.get("esCliente");

		if (esCliente != null) {
			setEsCliente(esCliente);
		}

		String nombres = (String)attributes.get("nombres");

		if (nombres != null) {
			setNombres(nombres);
		}

		String apellidos = (String)attributes.get("apellidos");

		if (apellidos != null) {
			setApellidos(apellidos);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String tipoDocumento = (String)attributes.get("tipoDocumento");

		if (tipoDocumento != null) {
			setTipoDocumento(tipoDocumento);
		}

		String ndocumento = (String)attributes.get("ndocumento");

		if (ndocumento != null) {
			setNdocumento(ndocumento);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		String departamento = (String)attributes.get("departamento");

		if (departamento != null) {
			setDepartamento(departamento);
		}

		String provincia = (String)attributes.get("provincia");

		if (provincia != null) {
			setProvincia(provincia);
		}

		String distrito = (String)attributes.get("distrito");

		if (distrito != null) {
			setDistrito(distrito);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		Date fecha = (Date)attributes.get("fecha");

		if (fecha != null) {
			setFecha(fecha);
		}

		String mensaje = (String)attributes.get("mensaje");

		if (mensaje != null) {
			setMensaje(mensaje);
		}

		String moneda = (String)attributes.get("moneda");

		if (moneda != null) {
			setMoneda(moneda);
		}

		String importe = (String)attributes.get("importe");

		if (importe != null) {
			setImporte(importe);
		}

		String tipoMensaje = (String)attributes.get("tipoMensaje");

		if (tipoMensaje != null) {
			setTipoMensaje(tipoMensaje);
		}

		String tipoTema = (String)attributes.get("tipoTema");

		if (tipoTema != null) {
			setTipoTema(tipoTema);
		}
	}

	/**
	* Returns the primary key of this solicitud contacto.
	*
	* @return the primary key of this solicitud contacto
	*/
	public long getPrimaryKey() {
		return _solicitudContacto.getPrimaryKey();
	}

	/**
	* Sets the primary key of this solicitud contacto.
	*
	* @param primaryKey the primary key of this solicitud contacto
	*/
	public void setPrimaryKey(long primaryKey) {
		_solicitudContacto.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id solicitud contacto of this solicitud contacto.
	*
	* @return the id solicitud contacto of this solicitud contacto
	*/
	public long getIdSolicitudContacto() {
		return _solicitudContacto.getIdSolicitudContacto();
	}

	/**
	* Sets the id solicitud contacto of this solicitud contacto.
	*
	* @param idSolicitudContacto the id solicitud contacto of this solicitud contacto
	*/
	public void setIdSolicitudContacto(long idSolicitudContacto) {
		_solicitudContacto.setIdSolicitudContacto(idSolicitudContacto);
	}

	/**
	* Returns the es cliente of this solicitud contacto.
	*
	* @return the es cliente of this solicitud contacto
	*/
	public java.lang.Integer getEsCliente() {
		return _solicitudContacto.getEsCliente();
	}

	/**
	* Sets the es cliente of this solicitud contacto.
	*
	* @param esCliente the es cliente of this solicitud contacto
	*/
	public void setEsCliente(java.lang.Integer esCliente) {
		_solicitudContacto.setEsCliente(esCliente);
	}

	/**
	* Returns the nombres of this solicitud contacto.
	*
	* @return the nombres of this solicitud contacto
	*/
	public java.lang.String getNombres() {
		return _solicitudContacto.getNombres();
	}

	/**
	* Sets the nombres of this solicitud contacto.
	*
	* @param nombres the nombres of this solicitud contacto
	*/
	public void setNombres(java.lang.String nombres) {
		_solicitudContacto.setNombres(nombres);
	}

	/**
	* Returns the apellidos of this solicitud contacto.
	*
	* @return the apellidos of this solicitud contacto
	*/
	public java.lang.String getApellidos() {
		return _solicitudContacto.getApellidos();
	}

	/**
	* Sets the apellidos of this solicitud contacto.
	*
	* @param apellidos the apellidos of this solicitud contacto
	*/
	public void setApellidos(java.lang.String apellidos) {
		_solicitudContacto.setApellidos(apellidos);
	}

	/**
	* Returns the email of this solicitud contacto.
	*
	* @return the email of this solicitud contacto
	*/
	public java.lang.String getEmail() {
		return _solicitudContacto.getEmail();
	}

	/**
	* Sets the email of this solicitud contacto.
	*
	* @param email the email of this solicitud contacto
	*/
	public void setEmail(java.lang.String email) {
		_solicitudContacto.setEmail(email);
	}

	/**
	* Returns the tipo documento of this solicitud contacto.
	*
	* @return the tipo documento of this solicitud contacto
	*/
	public java.lang.String getTipoDocumento() {
		return _solicitudContacto.getTipoDocumento();
	}

	/**
	* Sets the tipo documento of this solicitud contacto.
	*
	* @param tipoDocumento the tipo documento of this solicitud contacto
	*/
	public void setTipoDocumento(java.lang.String tipoDocumento) {
		_solicitudContacto.setTipoDocumento(tipoDocumento);
	}

	/**
	* Returns the ndocumento of this solicitud contacto.
	*
	* @return the ndocumento of this solicitud contacto
	*/
	public java.lang.String getNdocumento() {
		return _solicitudContacto.getNdocumento();
	}

	/**
	* Sets the ndocumento of this solicitud contacto.
	*
	* @param ndocumento the ndocumento of this solicitud contacto
	*/
	public void setNdocumento(java.lang.String ndocumento) {
		_solicitudContacto.setNdocumento(ndocumento);
	}

	/**
	* Returns the direccion of this solicitud contacto.
	*
	* @return the direccion of this solicitud contacto
	*/
	public java.lang.String getDireccion() {
		return _solicitudContacto.getDireccion();
	}

	/**
	* Sets the direccion of this solicitud contacto.
	*
	* @param direccion the direccion of this solicitud contacto
	*/
	public void setDireccion(java.lang.String direccion) {
		_solicitudContacto.setDireccion(direccion);
	}

	/**
	* Returns the departamento of this solicitud contacto.
	*
	* @return the departamento of this solicitud contacto
	*/
	public java.lang.String getDepartamento() {
		return _solicitudContacto.getDepartamento();
	}

	/**
	* Sets the departamento of this solicitud contacto.
	*
	* @param departamento the departamento of this solicitud contacto
	*/
	public void setDepartamento(java.lang.String departamento) {
		_solicitudContacto.setDepartamento(departamento);
	}

	/**
	* Returns the provincia of this solicitud contacto.
	*
	* @return the provincia of this solicitud contacto
	*/
	public java.lang.String getProvincia() {
		return _solicitudContacto.getProvincia();
	}

	/**
	* Sets the provincia of this solicitud contacto.
	*
	* @param provincia the provincia of this solicitud contacto
	*/
	public void setProvincia(java.lang.String provincia) {
		_solicitudContacto.setProvincia(provincia);
	}

	/**
	* Returns the distrito of this solicitud contacto.
	*
	* @return the distrito of this solicitud contacto
	*/
	public java.lang.String getDistrito() {
		return _solicitudContacto.getDistrito();
	}

	/**
	* Sets the distrito of this solicitud contacto.
	*
	* @param distrito the distrito of this solicitud contacto
	*/
	public void setDistrito(java.lang.String distrito) {
		_solicitudContacto.setDistrito(distrito);
	}

	/**
	* Returns the telefono of this solicitud contacto.
	*
	* @return the telefono of this solicitud contacto
	*/
	public java.lang.String getTelefono() {
		return _solicitudContacto.getTelefono();
	}

	/**
	* Sets the telefono of this solicitud contacto.
	*
	* @param telefono the telefono of this solicitud contacto
	*/
	public void setTelefono(java.lang.String telefono) {
		_solicitudContacto.setTelefono(telefono);
	}

	/**
	* Returns the fecha of this solicitud contacto.
	*
	* @return the fecha of this solicitud contacto
	*/
	public java.util.Date getFecha() {
		return _solicitudContacto.getFecha();
	}

	/**
	* Sets the fecha of this solicitud contacto.
	*
	* @param fecha the fecha of this solicitud contacto
	*/
	public void setFecha(java.util.Date fecha) {
		_solicitudContacto.setFecha(fecha);
	}

	/**
	* Returns the mensaje of this solicitud contacto.
	*
	* @return the mensaje of this solicitud contacto
	*/
	public java.lang.String getMensaje() {
		return _solicitudContacto.getMensaje();
	}

	/**
	* Sets the mensaje of this solicitud contacto.
	*
	* @param mensaje the mensaje of this solicitud contacto
	*/
	public void setMensaje(java.lang.String mensaje) {
		_solicitudContacto.setMensaje(mensaje);
	}

	/**
	* Returns the moneda of this solicitud contacto.
	*
	* @return the moneda of this solicitud contacto
	*/
	public java.lang.String getMoneda() {
		return _solicitudContacto.getMoneda();
	}

	/**
	* Sets the moneda of this solicitud contacto.
	*
	* @param moneda the moneda of this solicitud contacto
	*/
	public void setMoneda(java.lang.String moneda) {
		_solicitudContacto.setMoneda(moneda);
	}

	/**
	* Returns the importe of this solicitud contacto.
	*
	* @return the importe of this solicitud contacto
	*/
	public java.lang.String getImporte() {
		return _solicitudContacto.getImporte();
	}

	/**
	* Sets the importe of this solicitud contacto.
	*
	* @param importe the importe of this solicitud contacto
	*/
	public void setImporte(java.lang.String importe) {
		_solicitudContacto.setImporte(importe);
	}

	/**
	* Returns the tipo mensaje of this solicitud contacto.
	*
	* @return the tipo mensaje of this solicitud contacto
	*/
	public java.lang.String getTipoMensaje() {
		return _solicitudContacto.getTipoMensaje();
	}

	/**
	* Sets the tipo mensaje of this solicitud contacto.
	*
	* @param tipoMensaje the tipo mensaje of this solicitud contacto
	*/
	public void setTipoMensaje(java.lang.String tipoMensaje) {
		_solicitudContacto.setTipoMensaje(tipoMensaje);
	}

	/**
	* Returns the tipo tema of this solicitud contacto.
	*
	* @return the tipo tema of this solicitud contacto
	*/
	public java.lang.String getTipoTema() {
		return _solicitudContacto.getTipoTema();
	}

	/**
	* Sets the tipo tema of this solicitud contacto.
	*
	* @param tipoTema the tipo tema of this solicitud contacto
	*/
	public void setTipoTema(java.lang.String tipoTema) {
		_solicitudContacto.setTipoTema(tipoTema);
	}

	public boolean isNew() {
		return _solicitudContacto.isNew();
	}

	public void setNew(boolean n) {
		_solicitudContacto.setNew(n);
	}

	public boolean isCachedModel() {
		return _solicitudContacto.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_solicitudContacto.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _solicitudContacto.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _solicitudContacto.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_solicitudContacto.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _solicitudContacto.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_solicitudContacto.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SolicitudContactoWrapper((SolicitudContacto)_solicitudContacto.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto) {
		return _solicitudContacto.compareTo(solicitudContacto);
	}

	@Override
	public int hashCode() {
		return _solicitudContacto.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.SolicitudContacto> toCacheModel() {
		return _solicitudContacto.toCacheModel();
	}

	public com.ext.portlet.halcon.model.SolicitudContacto toEscapedModel() {
		return new SolicitudContactoWrapper(_solicitudContacto.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _solicitudContacto.toString();
	}

	public java.lang.String toXmlString() {
		return _solicitudContacto.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_solicitudContacto.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SolicitudContacto getWrappedSolicitudContacto() {
		return _solicitudContacto;
	}

	public SolicitudContacto getWrappedModel() {
		return _solicitudContacto;
	}

	public void resetOriginalValues() {
		_solicitudContacto.resetOriginalValues();
	}

	private SolicitudContacto _solicitudContacto;
}