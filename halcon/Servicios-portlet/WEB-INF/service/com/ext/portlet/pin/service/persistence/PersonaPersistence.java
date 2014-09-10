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

package com.ext.portlet.pin.service.persistence;

import com.ext.portlet.pin.model.Persona;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the persona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author arodriguez
 * @see PersonaPersistenceImpl
 * @see PersonaUtil
 * @generated
 */
public interface PersonaPersistence extends BasePersistence<Persona> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersonaUtil} to access the persona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the persona in the entity cache if it is enabled.
	*
	* @param persona the persona
	*/
	public void cacheResult(com.ext.portlet.pin.model.Persona persona);

	/**
	* Caches the personas in the entity cache if it is enabled.
	*
	* @param personas the personas
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.pin.model.Persona> personas);

	/**
	* Creates a new persona with the primary key. Does not add the persona to the database.
	*
	* @param userId the primary key for the new persona
	* @return the new persona
	*/
	public com.ext.portlet.pin.model.Persona create(long userId);

	/**
	* Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the persona
	* @return the persona that was removed
	* @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona remove(long userId)
		throws com.ext.portlet.pin.NoSuchPersonaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.pin.model.Persona updateImpl(
		com.ext.portlet.pin.model.Persona persona, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persona with the primary key or throws a {@link com.ext.portlet.pin.NoSuchPersonaException} if it could not be found.
	*
	* @param userId the primary key of the persona
	* @return the persona
	* @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona findByPrimaryKey(long userId)
		throws com.ext.portlet.pin.NoSuchPersonaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the persona
	* @return the persona, or <code>null</code> if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona fetchByPrimaryKey(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the personas.
	*
	* @return the personas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.pin.model.Persona> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @return the range of personas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.pin.model.Persona> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of personas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.pin.model.Persona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the personas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of personas.
	*
	* @return the number of personas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}