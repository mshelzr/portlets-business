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

import com.ext.portlet.halcon.model.Ocurrencia;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the ocurrencia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see OcurrenciaPersistenceImpl
 * @see OcurrenciaUtil
 * @generated
 */
public interface OcurrenciaPersistence extends BasePersistence<Ocurrencia> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OcurrenciaUtil} to access the ocurrencia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ocurrencia in the entity cache if it is enabled.
	*
	* @param ocurrencia the ocurrencia
	*/
	public void cacheResult(com.ext.portlet.halcon.model.Ocurrencia ocurrencia);

	/**
	* Caches the ocurrencias in the entity cache if it is enabled.
	*
	* @param ocurrencias the ocurrencias
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.Ocurrencia> ocurrencias);

	/**
	* Creates a new ocurrencia with the primary key. Does not add the ocurrencia to the database.
	*
	* @param idGestionPeticion the primary key for the new ocurrencia
	* @return the new ocurrencia
	*/
	public com.ext.portlet.halcon.model.Ocurrencia create(
		long idGestionPeticion);

	/**
	* Removes the ocurrencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia that was removed
	* @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia remove(
		long idGestionPeticion)
		throws com.ext.portlet.halcon.NoSuchOcurrenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.Ocurrencia updateImpl(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ocurrencia with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchOcurrenciaException} if it could not be found.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia
	* @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia findByPrimaryKey(
		long idGestionPeticion)
		throws com.ext.portlet.halcon.NoSuchOcurrenciaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ocurrencia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia, or <code>null</code> if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia fetchByPrimaryKey(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ocurrencias.
	*
	* @return the ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Ocurrencia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ocurrencias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ocurrencias
	* @param end the upper bound of the range of ocurrencias (not inclusive)
	* @return the range of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Ocurrencia> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ocurrencias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ocurrencias
	* @param end the upper bound of the range of ocurrencias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Ocurrencia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ocurrencias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ocurrencias.
	*
	* @return the number of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}