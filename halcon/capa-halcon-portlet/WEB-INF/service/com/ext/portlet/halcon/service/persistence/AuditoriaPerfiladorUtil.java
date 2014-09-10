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

import com.ext.portlet.halcon.model.AuditoriaPerfilador;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the auditoria perfilador service. This utility wraps {@link AuditoriaPerfiladorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaPerfiladorPersistence
 * @see AuditoriaPerfiladorPersistenceImpl
 * @generated
 */
public class AuditoriaPerfiladorUtil {
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
	public static void clearCache(AuditoriaPerfilador auditoriaPerfilador) {
		getPersistence().clearCache(auditoriaPerfilador);
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
	public static List<AuditoriaPerfilador> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AuditoriaPerfilador> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AuditoriaPerfilador> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static AuditoriaPerfilador update(
		AuditoriaPerfilador auditoriaPerfilador, boolean merge)
		throws SystemException {
		return getPersistence().update(auditoriaPerfilador, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static AuditoriaPerfilador update(
		AuditoriaPerfilador auditoriaPerfilador, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(auditoriaPerfilador, merge, serviceContext);
	}

	/**
	* Caches the auditoria perfilador in the entity cache if it is enabled.
	*
	* @param auditoriaPerfilador the auditoria perfilador
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador) {
		getPersistence().cacheResult(auditoriaPerfilador);
	}

	/**
	* Caches the auditoria perfiladors in the entity cache if it is enabled.
	*
	* @param auditoriaPerfiladors the auditoria perfiladors
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> auditoriaPerfiladors) {
		getPersistence().cacheResult(auditoriaPerfiladors);
	}

	/**
	* Creates a new auditoria perfilador with the primary key. Does not add the auditoria perfilador to the database.
	*
	* @param idAuditoriaPer the primary key for the new auditoria perfilador
	* @return the new auditoria perfilador
	*/
	public static com.ext.portlet.halcon.model.AuditoriaPerfilador create(
		long idAuditoriaPer) {
		return getPersistence().create(idAuditoriaPer);
	}

	/**
	* Removes the auditoria perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador that was removed
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaPerfilador remove(
		long idAuditoriaPer)
		throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idAuditoriaPer);
	}

	public static com.ext.portlet.halcon.model.AuditoriaPerfilador updateImpl(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(auditoriaPerfilador, merge);
	}

	/**
	* Returns the auditoria perfilador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException} if it could not be found.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaPerfilador findByPrimaryKey(
		long idAuditoriaPer)
		throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idAuditoriaPer);
	}

	/**
	* Returns the auditoria perfilador with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador, or <code>null</code> if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaPerfilador fetchByPrimaryKey(
		long idAuditoriaPer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idAuditoriaPer);
	}

	/**
	* Returns all the auditoria perfiladors.
	*
	* @return the auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the auditoria perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria perfiladors
	* @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	* @return the range of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the auditoria perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria perfiladors
	* @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the auditoria perfiladors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of auditoria perfiladors.
	*
	* @return the number of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static AuditoriaPerfiladorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (AuditoriaPerfiladorPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					AuditoriaPerfiladorPersistence.class.getName());

			ReferenceRegistry.registerReference(AuditoriaPerfiladorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(AuditoriaPerfiladorPersistence persistence) {
	}

	private static AuditoriaPerfiladorPersistence _persistence;
}