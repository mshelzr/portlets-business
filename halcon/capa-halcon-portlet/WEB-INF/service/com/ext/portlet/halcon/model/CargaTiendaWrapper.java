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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CargaTienda}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CargaTienda
 * @generated
 */
public class CargaTiendaWrapper implements CargaTienda,
	ModelWrapper<CargaTienda> {
	public CargaTiendaWrapper(CargaTienda cargaTienda) {
		_cargaTienda = cargaTienda;
	}

	public Class<?> getModelClass() {
		return CargaTienda.class;
	}

	public String getModelClassName() {
		return CargaTienda.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idCargaTienda", getIdCargaTienda());
		attributes.put("idPtoServicio", getIdPtoServicio());
		attributes.put("idCanal", getIdCanal());
		attributes.put("idSubCanal", getIdSubCanal());
		attributes.put("codDepartamento", getCodDepartamento());
		attributes.put("codProvincia", getCodProvincia());
		attributes.put("codDistrito", getCodDistrito());
		attributes.put("nomDepartamento", getNomDepartamento());
		attributes.put("nomProvincia", getNomProvincia());
		attributes.put("nomDistrito", getNomDistrito());
		attributes.put("latitud", getLatitud());
		attributes.put("longitud", getLongitud());
		attributes.put("direccion", getDireccion());
		attributes.put("horario", getHorario());
		attributes.put("tipoLocacion", getTipoLocacion());
		attributes.put("codTienda", getCodTienda());
		attributes.put("idLocacion", getIdLocacion());
		attributes.put("locacion", getLocacion());
		attributes.put("emailCom", getEmailCom());
		attributes.put("telefono", getTelefono());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long idCargaTienda = (Long)attributes.get("idCargaTienda");

		if (idCargaTienda != null) {
			setIdCargaTienda(idCargaTienda);
		}

		String idPtoServicio = (String)attributes.get("idPtoServicio");

		if (idPtoServicio != null) {
			setIdPtoServicio(idPtoServicio);
		}

		String idCanal = (String)attributes.get("idCanal");

		if (idCanal != null) {
			setIdCanal(idCanal);
		}

		String idSubCanal = (String)attributes.get("idSubCanal");

		if (idSubCanal != null) {
			setIdSubCanal(idSubCanal);
		}

		String codDepartamento = (String)attributes.get("codDepartamento");

		if (codDepartamento != null) {
			setCodDepartamento(codDepartamento);
		}

		String codProvincia = (String)attributes.get("codProvincia");

		if (codProvincia != null) {
			setCodProvincia(codProvincia);
		}

		String codDistrito = (String)attributes.get("codDistrito");

		if (codDistrito != null) {
			setCodDistrito(codDistrito);
		}

		String nomDepartamento = (String)attributes.get("nomDepartamento");

		if (nomDepartamento != null) {
			setNomDepartamento(nomDepartamento);
		}

		String nomProvincia = (String)attributes.get("nomProvincia");

		if (nomProvincia != null) {
			setNomProvincia(nomProvincia);
		}

		String nomDistrito = (String)attributes.get("nomDistrito");

		if (nomDistrito != null) {
			setNomDistrito(nomDistrito);
		}

		String latitud = (String)attributes.get("latitud");

		if (latitud != null) {
			setLatitud(latitud);
		}

		String longitud = (String)attributes.get("longitud");

		if (longitud != null) {
			setLongitud(longitud);
		}

		String direccion = (String)attributes.get("direccion");

		if (direccion != null) {
			setDireccion(direccion);
		}

		String horario = (String)attributes.get("horario");

		if (horario != null) {
			setHorario(horario);
		}

		String tipoLocacion = (String)attributes.get("tipoLocacion");

		if (tipoLocacion != null) {
			setTipoLocacion(tipoLocacion);
		}

		Integer codTienda = (Integer)attributes.get("codTienda");

		if (codTienda != null) {
			setCodTienda(codTienda);
		}

		Integer idLocacion = (Integer)attributes.get("idLocacion");

		if (idLocacion != null) {
			setIdLocacion(idLocacion);
		}

		String locacion = (String)attributes.get("locacion");

		if (locacion != null) {
			setLocacion(locacion);
		}

		String emailCom = (String)attributes.get("emailCom");

		if (emailCom != null) {
			setEmailCom(emailCom);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}
	}

	/**
	* Returns the primary key of this carga tienda.
	*
	* @return the primary key of this carga tienda
	*/
	public long getPrimaryKey() {
		return _cargaTienda.getPrimaryKey();
	}

	/**
	* Sets the primary key of this carga tienda.
	*
	* @param primaryKey the primary key of this carga tienda
	*/
	public void setPrimaryKey(long primaryKey) {
		_cargaTienda.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the id carga tienda of this carga tienda.
	*
	* @return the id carga tienda of this carga tienda
	*/
	public long getIdCargaTienda() {
		return _cargaTienda.getIdCargaTienda();
	}

	/**
	* Sets the id carga tienda of this carga tienda.
	*
	* @param idCargaTienda the id carga tienda of this carga tienda
	*/
	public void setIdCargaTienda(long idCargaTienda) {
		_cargaTienda.setIdCargaTienda(idCargaTienda);
	}

	/**
	* Returns the id pto servicio of this carga tienda.
	*
	* @return the id pto servicio of this carga tienda
	*/
	public java.lang.String getIdPtoServicio() {
		return _cargaTienda.getIdPtoServicio();
	}

	/**
	* Sets the id pto servicio of this carga tienda.
	*
	* @param idPtoServicio the id pto servicio of this carga tienda
	*/
	public void setIdPtoServicio(java.lang.String idPtoServicio) {
		_cargaTienda.setIdPtoServicio(idPtoServicio);
	}

	/**
	* Returns the id canal of this carga tienda.
	*
	* @return the id canal of this carga tienda
	*/
	public java.lang.String getIdCanal() {
		return _cargaTienda.getIdCanal();
	}

	/**
	* Sets the id canal of this carga tienda.
	*
	* @param idCanal the id canal of this carga tienda
	*/
	public void setIdCanal(java.lang.String idCanal) {
		_cargaTienda.setIdCanal(idCanal);
	}

	/**
	* Returns the id sub canal of this carga tienda.
	*
	* @return the id sub canal of this carga tienda
	*/
	public java.lang.String getIdSubCanal() {
		return _cargaTienda.getIdSubCanal();
	}

	/**
	* Sets the id sub canal of this carga tienda.
	*
	* @param idSubCanal the id sub canal of this carga tienda
	*/
	public void setIdSubCanal(java.lang.String idSubCanal) {
		_cargaTienda.setIdSubCanal(idSubCanal);
	}

	/**
	* Returns the cod departamento of this carga tienda.
	*
	* @return the cod departamento of this carga tienda
	*/
	public java.lang.String getCodDepartamento() {
		return _cargaTienda.getCodDepartamento();
	}

	/**
	* Sets the cod departamento of this carga tienda.
	*
	* @param codDepartamento the cod departamento of this carga tienda
	*/
	public void setCodDepartamento(java.lang.String codDepartamento) {
		_cargaTienda.setCodDepartamento(codDepartamento);
	}

	/**
	* Returns the cod provincia of this carga tienda.
	*
	* @return the cod provincia of this carga tienda
	*/
	public java.lang.String getCodProvincia() {
		return _cargaTienda.getCodProvincia();
	}

	/**
	* Sets the cod provincia of this carga tienda.
	*
	* @param codProvincia the cod provincia of this carga tienda
	*/
	public void setCodProvincia(java.lang.String codProvincia) {
		_cargaTienda.setCodProvincia(codProvincia);
	}

	/**
	* Returns the cod distrito of this carga tienda.
	*
	* @return the cod distrito of this carga tienda
	*/
	public java.lang.String getCodDistrito() {
		return _cargaTienda.getCodDistrito();
	}

	/**
	* Sets the cod distrito of this carga tienda.
	*
	* @param codDistrito the cod distrito of this carga tienda
	*/
	public void setCodDistrito(java.lang.String codDistrito) {
		_cargaTienda.setCodDistrito(codDistrito);
	}

	/**
	* Returns the nom departamento of this carga tienda.
	*
	* @return the nom departamento of this carga tienda
	*/
	public java.lang.String getNomDepartamento() {
		return _cargaTienda.getNomDepartamento();
	}

	/**
	* Sets the nom departamento of this carga tienda.
	*
	* @param nomDepartamento the nom departamento of this carga tienda
	*/
	public void setNomDepartamento(java.lang.String nomDepartamento) {
		_cargaTienda.setNomDepartamento(nomDepartamento);
	}

	/**
	* Returns the nom provincia of this carga tienda.
	*
	* @return the nom provincia of this carga tienda
	*/
	public java.lang.String getNomProvincia() {
		return _cargaTienda.getNomProvincia();
	}

	/**
	* Sets the nom provincia of this carga tienda.
	*
	* @param nomProvincia the nom provincia of this carga tienda
	*/
	public void setNomProvincia(java.lang.String nomProvincia) {
		_cargaTienda.setNomProvincia(nomProvincia);
	}

	/**
	* Returns the nom distrito of this carga tienda.
	*
	* @return the nom distrito of this carga tienda
	*/
	public java.lang.String getNomDistrito() {
		return _cargaTienda.getNomDistrito();
	}

	/**
	* Sets the nom distrito of this carga tienda.
	*
	* @param nomDistrito the nom distrito of this carga tienda
	*/
	public void setNomDistrito(java.lang.String nomDistrito) {
		_cargaTienda.setNomDistrito(nomDistrito);
	}

	/**
	* Returns the latitud of this carga tienda.
	*
	* @return the latitud of this carga tienda
	*/
	public java.lang.String getLatitud() {
		return _cargaTienda.getLatitud();
	}

	/**
	* Sets the latitud of this carga tienda.
	*
	* @param latitud the latitud of this carga tienda
	*/
	public void setLatitud(java.lang.String latitud) {
		_cargaTienda.setLatitud(latitud);
	}

	/**
	* Returns the longitud of this carga tienda.
	*
	* @return the longitud of this carga tienda
	*/
	public java.lang.String getLongitud() {
		return _cargaTienda.getLongitud();
	}

	/**
	* Sets the longitud of this carga tienda.
	*
	* @param longitud the longitud of this carga tienda
	*/
	public void setLongitud(java.lang.String longitud) {
		_cargaTienda.setLongitud(longitud);
	}

	/**
	* Returns the direccion of this carga tienda.
	*
	* @return the direccion of this carga tienda
	*/
	public java.lang.String getDireccion() {
		return _cargaTienda.getDireccion();
	}

	/**
	* Sets the direccion of this carga tienda.
	*
	* @param direccion the direccion of this carga tienda
	*/
	public void setDireccion(java.lang.String direccion) {
		_cargaTienda.setDireccion(direccion);
	}

	/**
	* Returns the horario of this carga tienda.
	*
	* @return the horario of this carga tienda
	*/
	public java.lang.String getHorario() {
		return _cargaTienda.getHorario();
	}

	/**
	* Sets the horario of this carga tienda.
	*
	* @param horario the horario of this carga tienda
	*/
	public void setHorario(java.lang.String horario) {
		_cargaTienda.setHorario(horario);
	}

	/**
	* Returns the tipo locacion of this carga tienda.
	*
	* @return the tipo locacion of this carga tienda
	*/
	public java.lang.String getTipoLocacion() {
		return _cargaTienda.getTipoLocacion();
	}

	/**
	* Sets the tipo locacion of this carga tienda.
	*
	* @param tipoLocacion the tipo locacion of this carga tienda
	*/
	public void setTipoLocacion(java.lang.String tipoLocacion) {
		_cargaTienda.setTipoLocacion(tipoLocacion);
	}

	/**
	* Returns the cod tienda of this carga tienda.
	*
	* @return the cod tienda of this carga tienda
	*/
	public java.lang.Integer getCodTienda() {
		return _cargaTienda.getCodTienda();
	}

	/**
	* Sets the cod tienda of this carga tienda.
	*
	* @param codTienda the cod tienda of this carga tienda
	*/
	public void setCodTienda(java.lang.Integer codTienda) {
		_cargaTienda.setCodTienda(codTienda);
	}

	/**
	* Returns the id locacion of this carga tienda.
	*
	* @return the id locacion of this carga tienda
	*/
	public java.lang.Integer getIdLocacion() {
		return _cargaTienda.getIdLocacion();
	}

	/**
	* Sets the id locacion of this carga tienda.
	*
	* @param idLocacion the id locacion of this carga tienda
	*/
	public void setIdLocacion(java.lang.Integer idLocacion) {
		_cargaTienda.setIdLocacion(idLocacion);
	}

	/**
	* Returns the locacion of this carga tienda.
	*
	* @return the locacion of this carga tienda
	*/
	public java.lang.String getLocacion() {
		return _cargaTienda.getLocacion();
	}

	/**
	* Sets the locacion of this carga tienda.
	*
	* @param locacion the locacion of this carga tienda
	*/
	public void setLocacion(java.lang.String locacion) {
		_cargaTienda.setLocacion(locacion);
	}

	/**
	* Returns the email com of this carga tienda.
	*
	* @return the email com of this carga tienda
	*/
	public java.lang.String getEmailCom() {
		return _cargaTienda.getEmailCom();
	}

	/**
	* Sets the email com of this carga tienda.
	*
	* @param emailCom the email com of this carga tienda
	*/
	public void setEmailCom(java.lang.String emailCom) {
		_cargaTienda.setEmailCom(emailCom);
	}

	/**
	* Returns the telefono of this carga tienda.
	*
	* @return the telefono of this carga tienda
	*/
	public java.lang.String getTelefono() {
		return _cargaTienda.getTelefono();
	}

	/**
	* Sets the telefono of this carga tienda.
	*
	* @param telefono the telefono of this carga tienda
	*/
	public void setTelefono(java.lang.String telefono) {
		_cargaTienda.setTelefono(telefono);
	}

	public boolean isNew() {
		return _cargaTienda.isNew();
	}

	public void setNew(boolean n) {
		_cargaTienda.setNew(n);
	}

	public boolean isCachedModel() {
		return _cargaTienda.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_cargaTienda.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _cargaTienda.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _cargaTienda.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cargaTienda.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cargaTienda.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cargaTienda.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CargaTiendaWrapper((CargaTienda)_cargaTienda.clone());
	}

	public int compareTo(com.ext.portlet.halcon.model.CargaTienda cargaTienda) {
		return _cargaTienda.compareTo(cargaTienda);
	}

	@Override
	public int hashCode() {
		return _cargaTienda.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.ext.portlet.halcon.model.CargaTienda> toCacheModel() {
		return _cargaTienda.toCacheModel();
	}

	public com.ext.portlet.halcon.model.CargaTienda toEscapedModel() {
		return new CargaTiendaWrapper(_cargaTienda.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cargaTienda.toString();
	}

	public java.lang.String toXmlString() {
		return _cargaTienda.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cargaTienda.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CargaTienda getWrappedCargaTienda() {
		return _cargaTienda;
	}

	public CargaTienda getWrappedModel() {
		return _cargaTienda;
	}

	public void resetOriginalValues() {
		_cargaTienda.resetOriginalValues();
	}

	private CargaTienda _cargaTienda;
}