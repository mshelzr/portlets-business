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

import com.ext.portlet.halcon.model.FondosMutuosZonas;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the fondos mutuos zonas service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosZonasPersistenceImpl
 * @see FondosMutuosZonasUtil
 * @generated
 */
public interface FondosMutuosZonasPersistence extends BasePersistence<FondosMutuosZonas> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FondosMutuosZonasUtil} to access the fondos mutuos zonas persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the fondos mutuos zonas in the entity cache if it is enabled.
	*
	* @param fondosMutuosZonas the fondos mutuos zonas
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas);

	/**
	* Caches the fondos mutuos zonases in the entity cache if it is enabled.
	*
	* @param fondosMutuosZonases the fondos mutuos zonases
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> fondosMutuosZonases);

	/**
	* Creates a new fondos mutuos zonas with the primary key. Does not add the fondos mutuos zonas to the database.
	*
	* @param idFondoMutuoZona the primary key for the new fondos mutuos zonas
	* @return the new fondos mutuos zonas
	*/
	public com.ext.portlet.halcon.model.FondosMutuosZonas create(
		long idFondoMutuoZona);

	/**
	* Removes the fondos mutuos zonas with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas that was removed
	* @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuosZonas remove(
		long idFondoMutuoZona)
		throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.FondosMutuosZonas updateImpl(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fondos mutuos zonas with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchFondosMutuosZonasException} if it could not be found.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas
	* @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuosZonas findByPrimaryKey(
		long idFondoMutuoZona)
		throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the fondos mutuos zonas with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas, or <code>null</code> if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuosZonas fetchByPrimaryKey(
		long idFondoMutuoZona)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the fondos mutuos zonases.
	*
	* @return the fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the fondos mutuos zonases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuos zonases
	* @param end the upper bound of the range of fondos mutuos zonases (not inclusive)
	* @return the range of fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the fondos mutuos zonases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuos zonases
	* @param end the upper bound of the range of fondos mutuos zonases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the fondos mutuos zonases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of fondos mutuos zonases.
	*
	* @return the number of fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}