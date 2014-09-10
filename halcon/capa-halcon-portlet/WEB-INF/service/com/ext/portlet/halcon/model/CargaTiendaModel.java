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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the CargaTienda service. Represents a row in the &quot;T_CARGA_TIENDA&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.CargaTiendaModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.CargaTiendaImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaTienda
 * @see com.ext.portlet.halcon.model.impl.CargaTiendaImpl
 * @see com.ext.portlet.halcon.model.impl.CargaTiendaModelImpl
 * @generated
 */
public interface CargaTiendaModel extends BaseModel<CargaTienda> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a carga tienda model instance should use the {@link CargaTienda} interface instead.
	 */

	/**
	 * Returns the primary key of this carga tienda.
	 *
	 * @return the primary key of this carga tienda
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this carga tienda.
	 *
	 * @param primaryKey the primary key of this carga tienda
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id carga tienda of this carga tienda.
	 *
	 * @return the id carga tienda of this carga tienda
	 */
	public long getIdCargaTienda();

	/**
	 * Sets the id carga tienda of this carga tienda.
	 *
	 * @param idCargaTienda the id carga tienda of this carga tienda
	 */
	public void setIdCargaTienda(long idCargaTienda);

	/**
	 * Returns the id pto servicio of this carga tienda.
	 *
	 * @return the id pto servicio of this carga tienda
	 */
	@AutoEscape
	public String getIdPtoServicio();

	/**
	 * Sets the id pto servicio of this carga tienda.
	 *
	 * @param idPtoServicio the id pto servicio of this carga tienda
	 */
	public void setIdPtoServicio(String idPtoServicio);

	/**
	 * Returns the id canal of this carga tienda.
	 *
	 * @return the id canal of this carga tienda
	 */
	@AutoEscape
	public String getIdCanal();

	/**
	 * Sets the id canal of this carga tienda.
	 *
	 * @param idCanal the id canal of this carga tienda
	 */
	public void setIdCanal(String idCanal);

	/**
	 * Returns the id sub canal of this carga tienda.
	 *
	 * @return the id sub canal of this carga tienda
	 */
	@AutoEscape
	public String getIdSubCanal();

	/**
	 * Sets the id sub canal of this carga tienda.
	 *
	 * @param idSubCanal the id sub canal of this carga tienda
	 */
	public void setIdSubCanal(String idSubCanal);

	/**
	 * Returns the cod departamento of this carga tienda.
	 *
	 * @return the cod departamento of this carga tienda
	 */
	@AutoEscape
	public String getCodDepartamento();

	/**
	 * Sets the cod departamento of this carga tienda.
	 *
	 * @param codDepartamento the cod departamento of this carga tienda
	 */
	public void setCodDepartamento(String codDepartamento);

	/**
	 * Returns the cod provincia of this carga tienda.
	 *
	 * @return the cod provincia of this carga tienda
	 */
	@AutoEscape
	public String getCodProvincia();

	/**
	 * Sets the cod provincia of this carga tienda.
	 *
	 * @param codProvincia the cod provincia of this carga tienda
	 */
	public void setCodProvincia(String codProvincia);

	/**
	 * Returns the cod distrito of this carga tienda.
	 *
	 * @return the cod distrito of this carga tienda
	 */
	@AutoEscape
	public String getCodDistrito();

	/**
	 * Sets the cod distrito of this carga tienda.
	 *
	 * @param codDistrito the cod distrito of this carga tienda
	 */
	public void setCodDistrito(String codDistrito);

	/**
	 * Returns the nom departamento of this carga tienda.
	 *
	 * @return the nom departamento of this carga tienda
	 */
	@AutoEscape
	public String getNomDepartamento();

	/**
	 * Sets the nom departamento of this carga tienda.
	 *
	 * @param nomDepartamento the nom departamento of this carga tienda
	 */
	public void setNomDepartamento(String nomDepartamento);

	/**
	 * Returns the nom provincia of this carga tienda.
	 *
	 * @return the nom provincia of this carga tienda
	 */
	@AutoEscape
	public String getNomProvincia();

	/**
	 * Sets the nom provincia of this carga tienda.
	 *
	 * @param nomProvincia the nom provincia of this carga tienda
	 */
	public void setNomProvincia(String nomProvincia);

	/**
	 * Returns the nom distrito of this carga tienda.
	 *
	 * @return the nom distrito of this carga tienda
	 */
	@AutoEscape
	public String getNomDistrito();

	/**
	 * Sets the nom distrito of this carga tienda.
	 *
	 * @param nomDistrito the nom distrito of this carga tienda
	 */
	public void setNomDistrito(String nomDistrito);

	/**
	 * Returns the latitud of this carga tienda.
	 *
	 * @return the latitud of this carga tienda
	 */
	@AutoEscape
	public String getLatitud();

	/**
	 * Sets the latitud of this carga tienda.
	 *
	 * @param latitud the latitud of this carga tienda
	 */
	public void setLatitud(String latitud);

	/**
	 * Returns the longitud of this carga tienda.
	 *
	 * @return the longitud of this carga tienda
	 */
	@AutoEscape
	public String getLongitud();

	/**
	 * Sets the longitud of this carga tienda.
	 *
	 * @param longitud the longitud of this carga tienda
	 */
	public void setLongitud(String longitud);

	/**
	 * Returns the direccion of this carga tienda.
	 *
	 * @return the direccion of this carga tienda
	 */
	@AutoEscape
	public String getDireccion();

	/**
	 * Sets the direccion of this carga tienda.
	 *
	 * @param direccion the direccion of this carga tienda
	 */
	public void setDireccion(String direccion);

	/**
	 * Returns the horario of this carga tienda.
	 *
	 * @return the horario of this carga tienda
	 */
	@AutoEscape
	public String getHorario();

	/**
	 * Sets the horario of this carga tienda.
	 *
	 * @param horario the horario of this carga tienda
	 */
	public void setHorario(String horario);

	/**
	 * Returns the tipo locacion of this carga tienda.
	 *
	 * @return the tipo locacion of this carga tienda
	 */
	@AutoEscape
	public String getTipoLocacion();

	/**
	 * Sets the tipo locacion of this carga tienda.
	 *
	 * @param tipoLocacion the tipo locacion of this carga tienda
	 */
	public void setTipoLocacion(String tipoLocacion);

	/**
	 * Returns the cod tienda of this carga tienda.
	 *
	 * @return the cod tienda of this carga tienda
	 */
	public Integer getCodTienda();

	/**
	 * Sets the cod tienda of this carga tienda.
	 *
	 * @param codTienda the cod tienda of this carga tienda
	 */
	public void setCodTienda(Integer codTienda);

	/**
	 * Returns the id locacion of this carga tienda.
	 *
	 * @return the id locacion of this carga tienda
	 */
	public Integer getIdLocacion();

	/**
	 * Sets the id locacion of this carga tienda.
	 *
	 * @param idLocacion the id locacion of this carga tienda
	 */
	public void setIdLocacion(Integer idLocacion);

	/**
	 * Returns the locacion of this carga tienda.
	 *
	 * @return the locacion of this carga tienda
	 */
	@AutoEscape
	public String getLocacion();

	/**
	 * Sets the locacion of this carga tienda.
	 *
	 * @param locacion the locacion of this carga tienda
	 */
	public void setLocacion(String locacion);

	/**
	 * Returns the email com of this carga tienda.
	 *
	 * @return the email com of this carga tienda
	 */
	@AutoEscape
	public String getEmailCom();

	/**
	 * Sets the email com of this carga tienda.
	 *
	 * @param emailCom the email com of this carga tienda
	 */
	public void setEmailCom(String emailCom);

	/**
	 * Returns the telefono of this carga tienda.
	 *
	 * @return the telefono of this carga tienda
	 */
	@AutoEscape
	public String getTelefono();

	/**
	 * Sets the telefono of this carga tienda.
	 *
	 * @param telefono the telefono of this carga tienda
	 */
	public void setTelefono(String telefono);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(CargaTienda cargaTienda);

	public int hashCode();

	public CacheModel<CargaTienda> toCacheModel();

	public CargaTienda toEscapedModel();

	public String toString();

	public String toXmlString();
}