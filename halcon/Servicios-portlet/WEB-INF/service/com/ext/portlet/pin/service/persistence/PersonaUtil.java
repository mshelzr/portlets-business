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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the persona service. This utility wraps {@link PersonaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author arodriguez
 * @see PersonaPersistence
 * @see PersonaPersistenceImpl
 * @generated
 */
public class PersonaUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Persona persona) {
		getPersistence().clearCache(persona);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Persona> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Persona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Persona> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Persona update(Persona persona, boolean merge)
		throws SystemException {
		return getPersistence().update(persona, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Persona update(Persona persona, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(persona, merge, serviceContext);
	}

	/**
	* Caches the persona in the entity cache if it is enabled.
	*
	* @param persona the persona
	*/
	public static void cacheResult(com.ext.portlet.pin.model.Persona persona) {
		getPersistence().cacheResult(persona);
	}

	/**
	* Caches the personas in the entity cache if it is enabled.
	*
	* @param personas the personas
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.pin.model.Persona> personas) {
		getPersistence().cacheResult(personas);
	}

	/**
	* Creates a new persona with the primary key. Does not add the persona to the database.
	*
	* @param userId the primary key for the new persona
	* @return the new persona
	*/
	public static com.ext.portlet.pin.model.Persona create(long userId) {
		return getPersistence().create(userId);
	}

	/**
	* Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the persona
	* @return the persona that was removed
	* @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.pin.model.Persona remove(long userId)
		throws com.ext.portlet.pin.NoSuchPersonaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(userId);
	}

	public static com.ext.portlet.pin.model.Persona updateImpl(
		com.ext.portlet.pin.model.Persona persona, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(persona, merge);
	}

	/**
	* Returns the persona with the primary key or throws a {@link com.ext.portlet.pin.NoSuchPersonaException} if it could not be found.
	*
	* @param userId the primary key of the persona
	* @return the persona
	* @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.pin.model.Persona findByPrimaryKey(
		long userId)
		throws com.ext.portlet.pin.NoSuchPersonaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(userId);
	}

	/**
	* Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param userId the primary key of the persona
	* @return the persona, or <code>null</code> if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.pin.model.Persona fetchByPrimaryKey(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(userId);
	}

	/**
	* Returns all the personas.
	*
	* @return the personas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.pin.model.Persona> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ext.portlet.pin.model.Persona> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ext.portlet.pin.model.Persona> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the personas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of personas.
	*
	* @return the number of personas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PersonaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PersonaPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.pin.service.ClpSerializer.getServletContextName(),
					PersonaPersistence.class.getName());

			ReferenceRegistry.registerReference(PersonaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PersonaPersistence persistence) {
	}

	private static PersonaPersistence _persistence;
}