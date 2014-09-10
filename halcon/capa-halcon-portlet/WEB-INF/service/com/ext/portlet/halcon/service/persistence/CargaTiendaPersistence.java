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

import com.ext.portlet.halcon.model.CargaTienda;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the carga tienda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaTiendaPersistenceImpl
 * @see CargaTiendaUtil
 * @generated
 */
public interface CargaTiendaPersistence extends BasePersistence<CargaTienda> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CargaTiendaUtil} to access the carga tienda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the carga tienda in the entity cache if it is enabled.
	*
	* @param cargaTienda the carga tienda
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda);

	/**
	* Caches the carga tiendas in the entity cache if it is enabled.
	*
	* @param cargaTiendas the carga tiendas
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.CargaTienda> cargaTiendas);

	/**
	* Creates a new carga tienda with the primary key. Does not add the carga tienda to the database.
	*
	* @param idCargaTienda the primary key for the new carga tienda
	* @return the new carga tienda
	*/
	public com.ext.portlet.halcon.model.CargaTienda create(long idCargaTienda);

	/**
	* Removes the carga tienda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda that was removed
	* @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda remove(long idCargaTienda)
		throws com.ext.portlet.halcon.NoSuchCargaTiendaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.CargaTienda updateImpl(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the carga tienda with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaTiendaException} if it could not be found.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda
	* @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda findByPrimaryKey(
		long idCargaTienda)
		throws com.ext.portlet.halcon.NoSuchCargaTiendaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the carga tienda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda, or <code>null</code> if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda fetchByPrimaryKey(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the carga tiendas.
	*
	* @return the carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaTienda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the carga tiendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga tiendas
	* @param end the upper bound of the range of carga tiendas (not inclusive)
	* @return the range of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaTienda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the carga tiendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga tiendas
	* @param end the upper bound of the range of carga tiendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaTienda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the carga tiendas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of carga tiendas.
	*
	* @return the number of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}