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

package com.ext.portlet.halcon.service.persistence;

import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the telefono solicitud producto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see TelefonoSolicitudProductoPersistenceImpl
 * @see TelefonoSolicitudProductoUtil
 * @generated
 */
public interface TelefonoSolicitudProductoPersistence extends BasePersistence<TelefonoSolicitudProducto> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TelefonoSolicitudProductoUtil} to access the telefono solicitud producto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the telefono solicitud producto in the entity cache if it is enabled.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto);

	/**
	* Caches the telefono solicitud productos in the entity cache if it is enabled.
	*
	* @param telefonoSolicitudProductos the telefono solicitud productos
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> telefonoSolicitudProductos);

	/**
	* Creates a new telefono solicitud producto with the primary key. Does not add the telefono solicitud producto to the database.
	*
	* @param idTelefSolicitudProducto the primary key for the new telefono solicitud producto
	* @return the new telefono solicitud producto
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto create(
		long idTelefSolicitudProducto);

	/**
	* Removes the telefono solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto that was removed
	* @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto remove(
		long idTelefSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto updateImpl(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefono solicitud producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException} if it could not be found.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto
	* @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto findByPrimaryKey(
		long idTelefSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the telefono solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto, or <code>null</code> if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto fetchByPrimaryKey(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the telefono solicitud productos.
	*
	* @return the telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the telefono solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefono solicitud productos
	* @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	* @return the range of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the telefono solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefono solicitud productos
	* @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the telefono solicitud productos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of telefono solicitud productos.
	*
	* @return the number of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}