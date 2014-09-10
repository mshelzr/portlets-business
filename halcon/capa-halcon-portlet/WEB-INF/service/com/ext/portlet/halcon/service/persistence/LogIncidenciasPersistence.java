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

import com.ext.portlet.halcon.model.LogIncidencias;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the log incidencias service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see LogIncidenciasPersistenceImpl
 * @see LogIncidenciasUtil
 * @generated
 */
public interface LogIncidenciasPersistence extends BasePersistence<LogIncidencias> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LogIncidenciasUtil} to access the log incidencias persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the log incidencias in the entity cache if it is enabled.
	*
	* @param logIncidencias the log incidencias
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias);

	/**
	* Caches the log incidenciases in the entity cache if it is enabled.
	*
	* @param logIncidenciases the log incidenciases
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.LogIncidencias> logIncidenciases);

	/**
	* Creates a new log incidencias with the primary key. Does not add the log incidencias to the database.
	*
	* @param idError the primary key for the new log incidencias
	* @return the new log incidencias
	*/
	public com.ext.portlet.halcon.model.LogIncidencias create(long idError);

	/**
	* Removes the log incidencias with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias that was removed
	* @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias remove(long idError)
		throws com.ext.portlet.halcon.NoSuchLogIncidenciasException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.LogIncidencias updateImpl(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the log incidencias with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchLogIncidenciasException} if it could not be found.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias
	* @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias findByPrimaryKey(
		long idError)
		throws com.ext.portlet.halcon.NoSuchLogIncidenciasException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the log incidencias with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias, or <code>null</code> if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias fetchByPrimaryKey(
		long idError)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the log incidenciases.
	*
	* @return the log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.LogIncidencias> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the log incidenciases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of log incidenciases
	* @param end the upper bound of the range of log incidenciases (not inclusive)
	* @return the range of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.LogIncidencias> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the log incidenciases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of log incidenciases
	* @param end the upper bound of the range of log incidenciases (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.LogIncidencias> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the log incidenciases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of log incidenciases.
	*
	* @return the number of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}