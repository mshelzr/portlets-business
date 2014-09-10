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

import com.ext.portlet.halcon.model.SolicitudProducto;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the solicitud producto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudProductoPersistenceImpl
 * @see SolicitudProductoUtil
 * @generated
 */
public interface SolicitudProductoPersistence extends BasePersistence<SolicitudProducto> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SolicitudProductoUtil} to access the solicitud producto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the solicitud producto in the entity cache if it is enabled.
	*
	* @param solicitudProducto the solicitud producto
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto);

	/**
	* Caches the solicitud productos in the entity cache if it is enabled.
	*
	* @param solicitudProductos the solicitud productos
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> solicitudProductos);

	/**
	* Creates a new solicitud producto with the primary key. Does not add the solicitud producto to the database.
	*
	* @param idSolicitudProducto the primary key for the new solicitud producto
	* @return the new solicitud producto
	*/
	public com.ext.portlet.halcon.model.SolicitudProducto create(
		long idSolicitudProducto);

	/**
	* Removes the solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto that was removed
	* @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudProducto remove(
		long idSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.SolicitudProducto updateImpl(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the solicitud producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchSolicitudProductoException} if it could not be found.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto
	* @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudProducto findByPrimaryKey(
		long idSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto, or <code>null</code> if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudProducto fetchByPrimaryKey(
		long idSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the solicitud productos.
	*
	* @return the solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud productos
	* @param end the upper bound of the range of solicitud productos (not inclusive)
	* @return the range of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud productos
	* @param end the upper bound of the range of solicitud productos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the solicitud productos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of solicitud productos.
	*
	* @return the number of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}