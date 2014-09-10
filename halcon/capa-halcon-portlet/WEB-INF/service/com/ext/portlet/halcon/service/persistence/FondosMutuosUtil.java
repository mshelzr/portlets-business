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

import com.ext.portlet.halcon.model.FondosMutuos;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the fondos mutuos service. This utility wraps {@link FondosMutuosPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosPersistence
 * @see FondosMutuosPersistenceImpl
 * @generated
 */
public class FondosMutuosUtil {
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
	public static void clearCache(FondosMutuos fondosMutuos) {
		getPersistence().clearCache(fondosMutuos);
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
	public static List<FondosMutuos> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FondosMutuos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FondosMutuos> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static FondosMutuos update(FondosMutuos fondosMutuos, boolean merge)
		throws SystemException {
		return getPersistence().update(fondosMutuos, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static FondosMutuos update(FondosMutuos fondosMutuos, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(fondosMutuos, merge, serviceContext);
	}

	/**
	* Caches the fondos mutuos in the entity cache if it is enabled.
	*
	* @param fondosMutuos the fondos mutuos
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos) {
		getPersistence().cacheResult(fondosMutuos);
	}

	/**
	* Caches the fondos mutuoses in the entity cache if it is enabled.
	*
	* @param fondosMutuoses the fondos mutuoses
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.FondosMutuos> fondosMutuoses) {
		getPersistence().cacheResult(fondosMutuoses);
	}

	/**
	* Creates a new fondos mutuos with the primary key. Does not add the fondos mutuos to the database.
	*
	* @param idValorCuota the primary key for the new fondos mutuos
	* @return the new fondos mutuos
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos create(
		long idValorCuota) {
		return getPersistence().create(idValorCuota);
	}

	/**
	* Removes the fondos mutuos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos that was removed
	* @throws com.ext.portlet.halcon.NoSuchFondosMutuosException if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos remove(
		long idValorCuota)
		throws com.ext.portlet.halcon.NoSuchFondosMutuosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idValorCuota);
	}

	public static com.ext.portlet.halcon.model.FondosMutuos updateImpl(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(fondosMutuos, merge);
	}

	/**
	* Returns the fondos mutuos with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchFondosMutuosException} if it could not be found.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos
	* @throws com.ext.portlet.halcon.NoSuchFondosMutuosException if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos findByPrimaryKey(
		long idValorCuota)
		throws com.ext.portlet.halcon.NoSuchFondosMutuosException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idValorCuota);
	}

	/**
	* Returns the fondos mutuos with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos, or <code>null</code> if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos fetchByPrimaryKey(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idValorCuota);
	}

	/**
	* Returns all the fondos mutuoses.
	*
	* @return the fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuos> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the fondos mutuoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuoses
	* @param end the upper bound of the range of fondos mutuoses (not inclusive)
	* @return the range of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuos> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the fondos mutuoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuoses
	* @param end the upper bound of the range of fondos mutuoses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuos> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the fondos mutuoses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of fondos mutuoses.
	*
	* @return the number of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static FondosMutuosPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (FondosMutuosPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					FondosMutuosPersistence.class.getName());

			ReferenceRegistry.registerReference(FondosMutuosUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(FondosMutuosPersistence persistence) {
	}

	private static FondosMutuosPersistence _persistence;
}