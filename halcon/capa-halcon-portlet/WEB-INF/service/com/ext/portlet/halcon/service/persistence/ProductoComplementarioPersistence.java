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

import com.ext.portlet.halcon.model.ProductoComplementario;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the producto complementario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ProductoComplementarioPersistenceImpl
 * @see ProductoComplementarioUtil
 * @generated
 */
public interface ProductoComplementarioPersistence extends BasePersistence<ProductoComplementario> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductoComplementarioUtil} to access the producto complementario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the producto complementario in the entity cache if it is enabled.
	*
	* @param productoComplementario the producto complementario
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario);

	/**
	* Caches the producto complementarios in the entity cache if it is enabled.
	*
	* @param productoComplementarios the producto complementarios
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> productoComplementarios);

	/**
	* Creates a new producto complementario with the primary key. Does not add the producto complementario to the database.
	*
	* @param idProductoComplementario the primary key for the new producto complementario
	* @return the new producto complementario
	*/
	public com.ext.portlet.halcon.model.ProductoComplementario create(
		long idProductoComplementario);

	/**
	* Removes the producto complementario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario that was removed
	* @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ProductoComplementario remove(
		long idProductoComplementario)
		throws com.ext.portlet.halcon.NoSuchProductoComplementarioException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.ProductoComplementario updateImpl(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producto complementario with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchProductoComplementarioException} if it could not be found.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario
	* @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ProductoComplementario findByPrimaryKey(
		long idProductoComplementario)
		throws com.ext.portlet.halcon.NoSuchProductoComplementarioException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the producto complementario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario, or <code>null</code> if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ProductoComplementario fetchByPrimaryKey(
		long idProductoComplementario)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the producto complementarios.
	*
	* @return the producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the producto complementarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of producto complementarios
	* @param end the upper bound of the range of producto complementarios (not inclusive)
	* @return the range of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the producto complementarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of producto complementarios
	* @param end the upper bound of the range of producto complementarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the producto complementarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of producto complementarios.
	*
	* @return the number of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}