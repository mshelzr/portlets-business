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
 * This class is a wrapper for {@link CargaDescuento}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CargaDescuento
 * @generated
 */
public class CargaDescuentoWrapper implements CargaDescuento,
	ModelWrapper<CargaDescuento> {
	public CargaDescuentoWrapper(CargaDescuento cargaDescuento) {
		_cargaDescuento = cargaDescuento;
	}

	public Class<?> getModelClass() {
		return CargaDescuento.class;
	}

	public String getModelClassName() {
		return CargaDescuento.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCargaDesc", getIdCargaDesc());
		attributes.put("local", getLocal());
		attributes.put("descuentoGeneral", getDescuentoGeneral());
		attributes.put("condicionesRestricciones", getCondicionesRestricciones());
		attributes.put("direccion", getDireccion());
		attributes.put("idDistrito", getIdDistrito());
		attributes.put("distrito", getDistrito());
		attributes.put("telefono", getTelefono());
		attributes.put("web", getWeb());
		attributes.put("finVigencia", getFinVigencia());
		attributes.put("categoria", getCategoria());
		attributes.put("coordenada", getCoordenada());
		attributes.put("URLImagen", getURLImagen());
		attributes.put("latitud", getLatitud());
		attributes.put("longitud", getLongitud());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCargaDesc = (Long)attributes.get("idCargaDesc");

		if (idCargaDesc != null) {
			setIdCargaDesc(idCargaDesc);
		}

		String local = (String)attributes.get("local");

		if (local != null) {
			setLocal(local);
		}

		String descuentoGeneral = (String)attributes.get("descuentoGeneral");

		if (descuentoGeneral != null) {
			setDescuentoGeneral(descuentoGeneral);
		}

		String condicionesRestricciones = (String)attributes.get(
				"condicionesRestricciones");

		if (condicionesRestricciones != null) {
			setCondicionesRestricciones(condicionesRestricciones);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		String idDistrito = (String)attributes.get("idDistrito");

		if (idDistrito != null) {
			setIdDistrito(idDistrito);
		}

		String distrito = (String)attributes.get("distrito");

		if (distrito != null) {
			setDistrito(distrito);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		String web = (String)attributes.get("web");

		if (web != null) {
			setWeb(web);
		}

		Date finVigencia = (Date)attributes.get("finVigencia");

		if (finVigencia != null) {
			setFinVigencia(finVigencia);
		}

		String categoria = (String)attributes.get("categoria");

		if (categoria != null) {
			setCategoria(categoria);
		}

		String coordenada = (String)attributes.get("coordenada");

		if (coordenada != null) {
			setCoordenada(coordenada);
		}

		String URLImagen = (String)attributes.get("URLImagen");

		if (URLImagen != null) {
			setURLImagen(URLImagen);
		}

		String latitud = (String)attributes.get("latitud");

		if (latitud != null) {
			setLatitud(latitud);
		}

		String longitud = (String)attributes.get("longitud");

		if (longitud != null) {
			setLongitud(longitud);
		}
	}

	/**
	* Returns the primary key of this carga descuento.
	*
	* @return the primary key of this carga descuento
	*/
	public long getPrimaryKey() {
		return _cargaDescuento.getPrimaryKey();
	}

	/**
	* Sets the primary key of this carga descuento.
	*
	* @param primaryKey the primary key of this carga descuento
	*/
	public void setPrimaryKey(long primaryKey) {
		_cargaDescuento.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id carga desc of this carga descuento.
	*
	* @return the id carga desc of this carga descuento
	*/
	public long getIdCargaDesc() {
		return _cargaDescuento.getIdCargaDesc();
	}

	/**
	* Sets the id carga desc of this carga descuento.
	*
	* @param idCargaDesc the id carga desc of this carga descuento
	*/
	public void setIdCargaDesc(long idCargaDesc) {
		_cargaDescuento.setIdCargaDesc(idCargaDesc);
	}

	/**
	* Returns the local of this carga descuento.
	*
	* @return the local of this carga descuento
	*/
	public java.lang.String getLocal() {
		return _cargaDescuento.getLocal();
	}

	/**
	* Sets the local of this carga descuento.
	*
	* @param local the local of this carga descuento
	*/
	public void setLocal(java.lang.String local) {
		_cargaDescuento.setLocal(local);
	}

	/**
	* Returns the descuento general of this carga descuento.
	*
	* @return the descuento general of this carga descuento
	*/
	public java.lang.String getDescuentoGeneral() {
		return _cargaDescuento.getDescuentoGeneral();
	}

	/**
	* Sets the descuento general of this carga descuento.
	*
	* @param descuentoGeneral the descuento general of this carga descuento
	*/
	public void setDescuentoGeneral(java.lang.String descuentoGeneral) {
		_cargaDescuento.setDescuentoGeneral(descuentoGeneral);
	}

	/**
	* Returns the condiciones restricciones of this carga descuento.
	*
	* @return the condiciones restricciones of this carga descuento
	*/
	public java.lang.String getCondicionesRestricciones() {
		return _cargaDescuento.getCondicionesRestricciones();
	}

	/**
	* Sets the condiciones restricciones of this carga descuento.
	*
	* @param condicionesRestricciones the condiciones restricciones of this carga descuento
	*/
	public void setCondicionesRestricciones(
		java.lang.String condicionesRestricciones) {
		_cargaDescuento.setCondicionesRestricciones(condicionesRestricciones);
	}

	/**
	* Returns the direccion of this carga descuento.
	*
	* @return the direccion of this carga descuento
	*/
	public java.lang.String getDireccion() {
		return _cargaDescuento.getDireccion();
	}

	/**
	* Sets the direccion of this carga descuento.
	*
	* @param direccion the direccion of this carga descuento
	*/
	public void setDireccion(java.lang.String direccion) {
		_cargaDescuento.setDireccion(direccion);
	}

	/**
	* Returns the id distrito of this carga descuento.
	*
	* @return the id distrito of this carga descuento
	*/
	public java.lang.String getIdDistrito() {
		return _cargaDescuento.getIdDistrito();
	}

	/**
	* Sets the id distrito of this carga descuento.
	*
	* @param idDistrito the id distrito of this carga descuento
	*/
	public void setIdDistrito(java.lang.String idDistrito) {
		_cargaDescuento.setIdDistrito(idDistrito);
	}

	/**
	* Returns the distrito of this carga descuento.
	*
	* @return the distrito of this carga descuento
	*/
	public java.lang.String getDistrito() {
		return _cargaDescuento.getDistrito();
	}

	/**
	* Sets the distrito of this carga descuento.
	*
	* @param distrito the distrito of this carga descuento
	*/
	public void setDistrito(java.lang.String distrito) {
		_cargaDescuento.setDistrito(distrito);
	}

	/**
	* Returns the telefono of this carga descuento.
	*
	* @return the telefono of this carga descuento
	*/
	public java.lang.String getTelefono() {
		return _cargaDescuento.getTelefono();
	}

	/**
	* Sets the telefono of this carga descuento.
	*
	* @param telefono the telefono of this carga descuento
	*/
	public void setTelefono(java.lang.String telefono) {
		_cargaDescuento.setTelefono(telefono);
	}

	/**
	* Returns the web of this carga descuento.
	*
	* @return the web of this carga descuento
	*/
	public java.lang.String getWeb() {
		return _cargaDescuento.getWeb();
	}

	/**
	* Sets the web of this carga descuento.
	*
	* @param web the web of this carga descuento
	*/
	public void setWeb(java.lang.String web) {
		_cargaDescuento.setWeb(web);
	}

	/**
	* Returns the fin vigencia of this carga descuento.
	*
	* @return the fin vigencia of this carga descuento
	*/
	public java.util.Date getFinVigencia() {
		return _cargaDescuento.getFinVigencia();
	}

	/**
	* Sets the fin vigencia of this carga descuento.
	*
	* @param finVigencia the fin vigencia of this carga descuento
	*/
	public void setFinVigencia(java.util.Date finVigencia) {
		_cargaDescuento.setFinVigencia(finVigencia);
	}

	/**
	* Returns the categoria of this carga descuento.
	*
	* @return the categoria of this carga descuento
	*/
	public java.lang.String getCategoria() {
		return _cargaDescuento.getCategoria();
	}

	/**
	* Sets the categoria of this carga descuento.
	*
	* @param categoria the categoria of this carga descuento
	*/
	public void setCategoria(java.lang.String categoria) {
		_cargaDescuento.setCategoria(categoria);
	}

	/**
	* Returns the coordenada of this carga descuento.
	*
	* @return the coordenada of this carga descuento
	*/
	public java.lang.String getCoordenada() {
		return _cargaDescuento.getCoordenada();
	}

	/**
	* Sets the coordenada of this carga descuento.
	*
	* @param coordenada the coordenada of this carga descuento
	*/
	public void setCoordenada(java.lang.String coordenada) {
		_cargaDescuento.setCoordenada(coordenada);
	}

	/**
	* Returns the u r l imagen of this carga descuento.
	*
	* @return the u r l imagen of this carga descuento
	*/
	public java.lang.String getURLImagen() {
		return _cargaDescuento.getURLImagen();
	}

	/**
	* Sets the u r l imagen of this carga descuento.
	*
	* @param URLImagen the u r l imagen of this carga descuento
	*/
	public void setURLImagen(java.lang.String URLImagen) {
		_cargaDescuento.setURLImagen(URLImagen);
	}

	/**
	* Returns the latitud of this carga descuento.
	*
	* @return the latitud of this carga descuento
	*/
	public java.lang.String getLatitud() {
		return _cargaDescuento.getLatitud();
	}

	/**
	* Sets the latitud of this carga descuento.
	*
	* @param latitud the latitud of this carga descuento
	*/
	public void setLatitud(java.lang.String latitud) {
		_cargaDescuento.setLatitud(latitud);
	}

	/**
	* Returns the longitud of this carga descuento.
	*
	* @return the longitud of this carga descuento
	*/
	public java.lang.String getLongitud() {
		return _cargaDescuento.getLongitud();
	}

	/**
	* Sets the longitud of this carga descuento.
	*
	* @param longitud the longitud of this carga descuento
	*/
	public void setLongitud(java.lang.String longitud) {
		_cargaDescuento.setLongitud(longitud);
	}

	public boolean isNew() {
		return _cargaDescuento.isNew();
	}

	public void setNew(boolean n) {
		_cargaDescuento.setNew(n);
	}

	public boolean isCachedModel() {
		return _cargaDescuento.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cargaDescuento.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cargaDescuento.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cargaDescuento.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cargaDescuento.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cargaDescuento.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cargaDescuento.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CargaDescuentoWrapper((CargaDescuento)_cargaDescuento.clone());
	}

	public int compareTo(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento) {
		return _cargaDescuento.compareTo(cargaDescuento);
	}

	@Override
	public int hashCode() {
		return _cargaDescuento.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.CargaDescuento> toCacheModel() {
		return _cargaDescuento.toCacheModel();
	}

	public com.ext.portlet.halcon.model.CargaDescuento toEscapedModel() {
		return new CargaDescuentoWrapper(_cargaDescuento.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cargaDescuento.toString();
	}

	public java.lang.String toXmlString() {
		return _cargaDescuento.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cargaDescuento.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CargaDescuento getWrappedCargaDescuento() {
		return _cargaDescuento;
	}

	public CargaDescuento getWrappedModel() {
		return _cargaDescuento;
	}

	public void resetOriginalValues() {
		_cargaDescuento.resetOriginalValues();
	}

	private CargaDescuento _cargaDescuento;
}