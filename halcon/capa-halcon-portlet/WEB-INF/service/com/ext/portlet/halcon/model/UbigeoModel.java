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
 * The base model interface for the Ubigeo service. Represents a row in the &quot;T_UBIGEO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.UbigeoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.UbigeoImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see Ubigeo
 * @see com.ext.portlet.halcon.model.impl.UbigeoImpl
 * @see com.ext.portlet.halcon.model.impl.UbigeoModelImpl
 * @generated
 */
public interface UbigeoModel extends BaseModel<Ubigeo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ubigeo model instance should use the {@link Ubigeo} interface instead.
	 */

	/**
	 * Returns the primary key of this ubigeo.
	 *
	 * @return the primary key of this ubigeo
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ubigeo.
	 *
	 * @param primaryKey the primary key of this ubigeo
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id ubigeo of this ubigeo.
	 *
	 * @return the id ubigeo of this ubigeo
	 */
	public long getIdUbigeo();

	/**
	 * Sets the id ubigeo of this ubigeo.
	 *
	 * @param idUbigeo the id ubigeo of this ubigeo
	 */
	public void setIdUbigeo(long idUbigeo);

	/**
	 * Returns the codigo of this ubigeo.
	 *
	 * @return the codigo of this ubigeo
	 */
	@AutoEscape
	public String getCodigo();

	/**
	 * Sets the codigo of this ubigeo.
	 *
	 * @param codigo the codigo of this ubigeo
	 */
	public void setCodigo(String codigo);

	/**
	 * Returns the nombre of this ubigeo.
	 *
	 * @return the nombre of this ubigeo
	 */
	@AutoEscape
	public String getNombre();

	/**
	 * Sets the nombre of this ubigeo.
	 *
	 * @param nombre the nombre of this ubigeo
	 */
	public void setNombre(String nombre);

	/**
	 * Returns the cod departamento of this ubigeo.
	 *
	 * @return the cod departamento of this ubigeo
	 */
	@AutoEscape
	public String getCodDepartamento();

	/**
	 * Sets the cod departamento of this ubigeo.
	 *
	 * @param codDepartamento the cod departamento of this ubigeo
	 */
	public void setCodDepartamento(String codDepartamento);

	/**
	 * Returns the cod provincia of this ubigeo.
	 *
	 * @return the cod provincia of this ubigeo
	 */
	@AutoEscape
	public String getCodProvincia();

	/**
	 * Sets the cod provincia of this ubigeo.
	 *
	 * @param codProvincia the cod provincia of this ubigeo
	 */
	public void setCodProvincia(String codProvincia);

	/**
	 * Returns the cod distrito of this ubigeo.
	 *
	 * @return the cod distrito of this ubigeo
	 */
	@AutoEscape
	public String getCodDistrito();

	/**
	 * Sets the cod distrito of this ubigeo.
	 *
	 * @param codDistrito the cod distrito of this ubigeo
	 */
	public void setCodDistrito(String codDistrito);

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

	public int compareTo(Ubigeo ubigeo);

	public int hashCode();

	public CacheModel<Ubigeo> toCacheModel();

	public Ubigeo toEscapedModel();

	public String toString();

	public String toXmlString();
}