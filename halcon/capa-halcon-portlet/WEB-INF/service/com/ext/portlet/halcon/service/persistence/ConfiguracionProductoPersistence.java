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

import com.ext.portlet.halcon.model.ConfiguracionProducto;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the configuracion producto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionProductoPersistenceImpl
 * @see ConfiguracionProductoUtil
 * @generated
 */
public interface ConfiguracionProductoPersistence extends BasePersistence<ConfiguracionProducto> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfiguracionProductoUtil} to access the configuracion producto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the configuracion producto in the entity cache if it is enabled.
	*
	* @param configuracionProducto the configuracion producto
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.ConfiguracionProducto configuracionProducto);

	/**
	* Caches the configuracion productos in the entity cache if it is enabled.
	*
	* @param configuracionProductos the configuracion productos
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.ConfiguracionProducto> configuracionProductos);

	/**
	* Creates a new configuracion producto with the primary key. Does not add the configuracion producto to the database.
	*
	* @param idConfiguracionProducto the primary key for the new configuracion producto
	* @return the new configuracion producto
	*/
	public com.ext.portlet.halcon.model.ConfiguracionProducto create(
		long idConfiguracionProducto);

	/**
	* Removes the configuracion producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idConfiguracionProducto the primary key of the configuracion producto
	* @return the configuracion producto that was removed
	* @throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException if a configuracion producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionProducto remove(
		long idConfiguracionProducto)
		throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.ConfiguracionProducto updateImpl(
		com.ext.portlet.halcon.model.ConfiguracionProducto configuracionProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuracion producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchConfiguracionProductoException} if it could not be found.
	*
	* @param idConfiguracionProducto the primary key of the configuracion producto
	* @return the configuracion producto
	* @throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException if a configuracion producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionProducto findByPrimaryKey(
		long idConfiguracionProducto)
		throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuracion producto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idConfiguracionProducto the primary key of the configuracion producto
	* @return the configuracion producto, or <code>null</code> if a configuracion producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionProducto fetchByPrimaryKey(
		long idConfiguracionProducto)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configuracion productos.
	*
	* @return the configuracion productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionProducto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configuracion productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion productos
	* @param end the upper bound of the range of configuracion productos (not inclusive)
	* @return the range of configuracion productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionProducto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configuracion productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion productos
	* @param end the upper bound of the range of configuracion productos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configuracion productos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionProducto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configuracion productos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configuracion productos.
	*
	* @return the number of configuracion productos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}