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

import com.ext.portlet.halcon.model.Ubigeo;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the ubigeo service. This utility wraps {@link UbigeoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see UbigeoPersistence
 * @see UbigeoPersistenceImpl
 * @generated
 */
public class UbigeoUtil {
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
	public static void clearCache(Ubigeo ubigeo) {
		getPersistence().clearCache(ubigeo);
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
	public static List<Ubigeo> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ubigeo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ubigeo> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Ubigeo update(Ubigeo ubigeo, boolean merge)
		throws SystemException {
		return getPersistence().update(ubigeo, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Ubigeo update(Ubigeo ubigeo, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ubigeo, merge, serviceContext);
	}

	/**
	* Caches the ubigeo in the entity cache if it is enabled.
	*
	* @param ubigeo the ubigeo
	*/
	public static void cacheResult(com.ext.portlet.halcon.model.Ubigeo ubigeo) {
		getPersistence().cacheResult(ubigeo);
	}

	/**
	* Caches the ubigeos in the entity cache if it is enabled.
	*
	* @param ubigeos the ubigeos
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.Ubigeo> ubigeos) {
		getPersistence().cacheResult(ubigeos);
	}

	/**
	* Creates a new ubigeo with the primary key. Does not add the ubigeo to the database.
	*
	* @param idUbigeo the primary key for the new ubigeo
	* @return the new ubigeo
	*/
	public static com.ext.portlet.halcon.model.Ubigeo create(long idUbigeo) {
		return getPersistence().create(idUbigeo);
	}

	/**
	* Removes the ubigeo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idUbigeo the primary key of the ubigeo
	* @return the ubigeo that was removed
	* @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ubigeo remove(long idUbigeo)
		throws com.ext.portlet.halcon.NoSuchUbigeoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idUbigeo);
	}

	public static com.ext.portlet.halcon.model.Ubigeo updateImpl(
		com.ext.portlet.halcon.model.Ubigeo ubigeo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ubigeo, merge);
	}

	/**
	* Returns the ubigeo with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchUbigeoException} if it could not be found.
	*
	* @param idUbigeo the primary key of the ubigeo
	* @return the ubigeo
	* @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ubigeo findByPrimaryKey(
		long idUbigeo)
		throws com.ext.portlet.halcon.NoSuchUbigeoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idUbigeo);
	}

	/**
	* Returns the ubigeo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idUbigeo the primary key of the ubigeo
	* @return the ubigeo, or <code>null</code> if a ubigeo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ubigeo fetchByPrimaryKey(
		long idUbigeo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idUbigeo);
	}

	/**
	* Returns all the ubigeos.
	*
	* @return the ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ubigeos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ubigeos
	* @param end the upper bound of the range of ubigeos (not inclusive)
	* @return the range of ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ubigeos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ubigeos
	* @param end the upper bound of the range of ubigeos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.Ubigeo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ubigeos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ubigeos.
	*
	* @return the number of ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UbigeoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UbigeoPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					UbigeoPersistence.class.getName());

			ReferenceRegistry.registerReference(UbigeoUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(UbigeoPersistence persistence) {
	}

	private static UbigeoPersistence _persistence;
}