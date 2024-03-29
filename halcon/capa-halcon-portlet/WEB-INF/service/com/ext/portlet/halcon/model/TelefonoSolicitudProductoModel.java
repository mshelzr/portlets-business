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
 * The base model interface for the TelefonoSolicitudProducto service. Represents a row in the &quot;T_TELEFONO_SOLICITUD_PRODUCTO&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see TelefonoSolicitudProducto
 * @see com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoImpl
 * @see com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoModelImpl
 * @generated
 */
public interface TelefonoSolicitudProductoModel extends BaseModel<TelefonoSolicitudProducto> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a telefono solicitud producto model instance should use the {@link TelefonoSolicitudProducto} interface instead.
	 */

	/**
	 * Returns the primary key of this telefono solicitud producto.
	 *
	 * @return the primary key of this telefono solicitud producto
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this telefono solicitud producto.
	 *
	 * @param primaryKey the primary key of this telefono solicitud producto
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the id telef solicitud producto of this telefono solicitud producto.
	 *
	 * @return the id telef solicitud producto of this telefono solicitud producto
	 */
	public long getIdTelefSolicitudProducto();

	/**
	 * Sets the id telef solicitud producto of this telefono solicitud producto.
	 *
	 * @param idTelefSolicitudProducto the id telef solicitud producto of this telefono solicitud producto
	 */
	public void setIdTelefSolicitudProducto(long idTelefSolicitudProducto);

	/**
	 * Returns the id solicitud producto of this telefono solicitud producto.
	 *
	 * @return the id solicitud producto of this telefono solicitud producto
	 */
	public long getIdSolicitudProducto();

	/**
	 * Sets the id solicitud producto of this telefono solicitud producto.
	 *
	 * @param idSolicitudProducto the id solicitud producto of this telefono solicitud producto
	 */
	public void setIdSolicitudProducto(long idSolicitudProducto);

	/**
	 * Returns the tipo telefono of this telefono solicitud producto.
	 *
	 * @return the tipo telefono of this telefono solicitud producto
	 */
	@AutoEscape
	public String getTipoTelefono();

	/**
	 * Sets the tipo telefono of this telefono solicitud producto.
	 *
	 * @param tipoTelefono the tipo telefono of this telefono solicitud producto
	 */
	public void setTipoTelefono(String tipoTelefono);

	/**
	 * Returns the numero telefono of this telefono solicitud producto.
	 *
	 * @return the numero telefono of this telefono solicitud producto
	 */
	@AutoEscape
	public String getNumeroTelefono();

	/**
	 * Sets the numero telefono of this telefono solicitud producto.
	 *
	 * @param numeroTelefono the numero telefono of this telefono solicitud producto
	 */
	public void setNumeroTelefono(String numeroTelefono);

	/**
	 * Returns the anexo of this telefono solicitud producto.
	 *
	 * @return the anexo of this telefono solicitud producto
	 */
	@AutoEscape
	public String getAnexo();

	/**
	 * Sets the anexo of this telefono solicitud producto.
	 *
	 * @param anexo the anexo of this telefono solicitud producto
	 */
	public void setAnexo(String anexo);

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

	public int compareTo(TelefonoSolicitudProducto telefonoSolicitudProducto);

	public int hashCode();

	public CacheModel<TelefonoSolicitudProducto> toCacheModel();

	public TelefonoSolicitudProducto toEscapedModel();

	public String toString();

	public String toXmlString();
}