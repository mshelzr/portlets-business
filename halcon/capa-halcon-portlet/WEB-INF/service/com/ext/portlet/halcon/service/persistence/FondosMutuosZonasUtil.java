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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fondos mutuos zonas service. This utility wraps {@link FondosMutuosZonasPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosZonasPersistence
 * @see FondosMutuosZonasPersistenceImpl
 * @generated
 */
public class FondosMutuosZonasUtil {
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
	public static void clearCache(FondosMutuosZonas fondosMutuosZonas) {
		getPersistence().clearCache(fondosMutuosZonas);
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
	public static List<FondosMutuosZonas> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FondosMutuosZonas> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FondosMutuosZonas> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static FondosMutuosZonas update(
		FondosMutuosZonas fondosMutuosZonas, boolean merge)
		throws SystemException {
		return getPersistence().update(fondosMutuosZonas, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static FondosMutuosZonas update(
		FondosMutuosZonas fondosMutuosZonas, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(fondosMutuosZonas, merge, serviceContext);
	}

	/**
	* Caches the fondos mutuos zonas in the entity cache if it is enabled.
	*
	* @param fondosMutuosZonas the fondos mutuos zonas
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas) {
		getPersistence().cacheResult(fondosMutuosZonas);
	}

	/**
	* Caches the fondos mutuos zonases in the entity cache if it is enabled.
	*
	* @param fondosMutuosZonases the fondos mutuos zonases
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> fondosMutuosZonases) {
		getPersistence().cacheResult(fondosMutuosZonases);
	}

	/**
	* Creates a new fondos mutuos zonas with the primary key. Does not add the fondos mutuos zonas to the database.
	*
	* @param idFondoMutuoZona the primary key for the new fondos mutuos zonas
	* @return the new fondos mutuos zonas
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas create(
		long idFondoMutuoZona) {
		return getPersistence().create(idFondoMutuoZona);
	}

	/**
	* Removes the fondos mutuos zonas with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas that was removed
	* @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas remove(
		long idFondoMutuoZona)
		throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idFondoMutuoZona);
	}

	public static com.ext.portlet.halcon.model.FondosMutuosZonas updateImpl(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(fondosMutuosZonas, merge);
	}

	/**
	* Returns the fondos mutuos zonas with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchFondosMutuosZonasException} if it could not be found.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas
	* @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas findByPrimaryKey(
		long idFondoMutuoZona)
		throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idFondoMutuoZona);
	}

	/**
	* Returns the fondos mutuos zonas with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas, or <code>null</code> if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas fetchByPrimaryKey(
		long idFondoMutuoZona)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idFondoMutuoZona);
	}

	/**
	* Returns all the fondos mutuos zonases.
	*
	* @return the fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fondos mutuos zonases from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fondos mutuos zonases.
	*
	* @return the number of fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FondosMutuosZonasPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FondosMutuosZonasPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					FondosMutuosZonasPersistence.class.getName());

			ReferenceRegistry.registerReference(FondosMutuosZonasUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(FondosMutuosZonasPersistence persistence) {
	}

	private static FondosMutuosZonasPersistence _persistence;
}