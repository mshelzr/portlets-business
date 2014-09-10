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

import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the auditoria caja sorpresa service. This utility wraps {@link AuditoriaCajaSorpresaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresaPersistence
 * @see AuditoriaCajaSorpresaPersistenceImpl
 * @generated
 */
public class AuditoriaCajaSorpresaUtil {
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
	public static void clearCache(AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		getPersistence().clearCache(auditoriaCajaSorpresa);
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
	public static List<AuditoriaCajaSorpresa> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuditoriaCajaSorpresa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuditoriaCajaSorpresa> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AuditoriaCajaSorpresa update(
		AuditoriaCajaSorpresa auditoriaCajaSorpresa, boolean merge)
		throws SystemException {
		return getPersistence().update(auditoriaCajaSorpresa, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AuditoriaCajaSorpresa update(
		AuditoriaCajaSorpresa auditoriaCajaSorpresa, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(auditoriaCajaSorpresa, merge, serviceContext);
	}

	/**
	* Caches the auditoria caja sorpresa in the entity cache if it is enabled.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		getPersistence().cacheResult(auditoriaCajaSorpresa);
	}

	/**
	* Caches the auditoria caja sorpresas in the entity cache if it is enabled.
	*
	* @param auditoriaCajaSorpresas the auditoria caja sorpresas
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> auditoriaCajaSorpresas) {
		getPersistence().cacheResult(auditoriaCajaSorpresas);
	}

	/**
	* Creates a new auditoria caja sorpresa with the primary key. Does not add the auditoria caja sorpresa to the database.
	*
	* @param idAuditoriaCajSorp the primary key for the new auditoria caja sorpresa
	* @return the new auditoria caja sorpresa
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa create(
		long idAuditoriaCajSorp) {
		return getPersistence().create(idAuditoriaCajSorp);
	}

	/**
	* Removes the auditoria caja sorpresa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was removed
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa remove(
		long idAuditoriaCajSorp)
		throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idAuditoriaCajSorp);
	}

	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa updateImpl(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(auditoriaCajaSorpresa, merge);
	}

	/**
	* Returns the auditoria caja sorpresa with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException} if it could not be found.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa findByPrimaryKey(
		long idAuditoriaCajSorp)
		throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idAuditoriaCajSorp);
	}

	/**
	* Returns the auditoria caja sorpresa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa, or <code>null</code> if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa fetchByPrimaryKey(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idAuditoriaCajSorp);
	}

	/**
	* Returns all the auditoria caja sorpresas.
	*
	* @return the auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the auditoria caja sorpresas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria caja sorpresas
	* @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	* @return the range of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the auditoria caja sorpresas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria caja sorpresas
	* @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the auditoria caja sorpresas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of auditoria caja sorpresas.
	*
	* @return the number of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AuditoriaCajaSorpresaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AuditoriaCajaSorpresaPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					AuditoriaCajaSorpresaPersistence.class.getName());

			ReferenceRegistry.registerReference(AuditoriaCajaSorpresaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AuditoriaCajaSorpresaPersistence persistence) {
	}

	private static AuditoriaCajaSorpresaPersistence _persistence;
}