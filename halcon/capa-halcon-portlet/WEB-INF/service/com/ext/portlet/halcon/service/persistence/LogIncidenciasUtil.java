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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the log incidencias service. This utility wraps {@link LogIncidenciasPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see LogIncidenciasPersistence
 * @see LogIncidenciasPersistenceImpl
 * @generated
 */
public class LogIncidenciasUtil {
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
	public static void clearCache(LogIncidencias logIncidencias) {
		getPersistence().clearCache(logIncidencias);
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
	public static List<LogIncidencias> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LogIncidencias> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LogIncidencias> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LogIncidencias update(LogIncidencias logIncidencias,
		boolean merge) throws SystemException {
		return getPersistence().update(logIncidencias, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LogIncidencias update(LogIncidencias logIncidencias,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(logIncidencias, merge, serviceContext);
	}

	/**
	* Caches the log incidencias in the entity cache if it is enabled.
	*
	* @param logIncidencias the log incidencias
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias) {
		getPersistence().cacheResult(logIncidencias);
	}

	/**
	* Caches the log incidenciases in the entity cache if it is enabled.
	*
	* @param logIncidenciases the log incidenciases
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.LogIncidencias> logIncidenciases) {
		getPersistence().cacheResult(logIncidenciases);
	}

	/**
	* Creates a new log incidencias with the primary key. Does not add the log incidencias to the database.
	*
	* @param idError the primary key for the new log incidencias
	* @return the new log incidencias
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias create(
		long idError) {
		return getPersistence().create(idError);
	}

	/**
	* Removes the log incidencias with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias that was removed
	* @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias remove(
		long idError)
		throws com.ext.portlet.halcon.NoSuchLogIncidenciasException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idError);
	}

	public static com.ext.portlet.halcon.model.LogIncidencias updateImpl(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(logIncidencias, merge);
	}

	/**
	* Returns the log incidencias with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchLogIncidenciasException} if it could not be found.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias
	* @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias findByPrimaryKey(
		long idError)
		throws com.ext.portlet.halcon.NoSuchLogIncidenciasException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idError);
	}

	/**
	* Returns the log incidencias with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias, or <code>null</code> if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias fetchByPrimaryKey(
		long idError)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idError);
	}

	/**
	* Returns all the log incidenciases.
	*
	* @return the log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.LogIncidencias> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.LogIncidencias> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.LogIncidencias> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the log incidenciases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of log incidenciases.
	*
	* @return the number of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LogIncidenciasPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LogIncidenciasPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					LogIncidenciasPersistence.class.getName());

			ReferenceRegistry.registerReference(LogIncidenciasUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LogIncidenciasPersistence persistence) {
	}

	private static LogIncidenciasPersistence _persistence;
}