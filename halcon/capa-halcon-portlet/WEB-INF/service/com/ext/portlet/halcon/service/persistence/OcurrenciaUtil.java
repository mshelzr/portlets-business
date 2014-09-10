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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the ocurrencia service. This utility wraps {@link OcurrenciaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see OcurrenciaPersistence
 * @see OcurrenciaPersistenceImpl
 * @generated
 */
public class OcurrenciaUtil {
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
	public static void clearCache(Ocurrencia ocurrencia) {
		getPersistence().clearCache(ocurrencia);
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
	public static List<Ocurrencia> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ocurrencia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ocurrencia> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Ocurrencia update(Ocurrencia ocurrencia, boolean merge)
		throws SystemException {
		return getPersistence().update(ocurrencia, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Ocurrencia update(Ocurrencia ocurrencia, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ocurrencia, merge, serviceContext);
	}

	/**
	* Caches the ocurrencia in the entity cache if it is enabled.
	*
	* @param ocurrencia the ocurrencia
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia) {
		getPersistence().cacheResult(ocurrencia);
	}

	/**
	* Caches the ocurrencias in the entity cache if it is enabled.
	*
	* @param ocurrencias the ocurrencias
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.Ocurrencia> ocurrencias) {
		getPersistence().cacheResult(ocurrencias);
	}

	/**
	* Creates a new ocurrencia with the primary key. Does not add the ocurrencia to the database.
	*
	* @param idGestionPeticion the primary key for the new ocurrencia
	* @return the new ocurrencia
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia create(
		long idGestionPeticion) {
		return getPersistence().create(idGestionPeticion);
	}

	/**
	* Removes the ocurrencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia that was removed
	* @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia remove(
		long idGestionPeticion)
		throws com.ext.portlet.halcon.NoSuchOcurrenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idGestionPeticion);
	}

	public static com.ext.portlet.halcon.model.Ocurrencia updateImpl(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ocurrencia, merge);
	}

	/**
	* Returns the ocurrencia with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchOcurrenciaException} if it could not be found.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia
	* @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia findByPrimaryKey(
		long idGestionPeticion)
		throws com.ext.portlet.halcon.NoSuchOcurrenciaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idGestionPeticion);
	}

	/**
	* Returns the ocurrencia with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia, or <code>null</code> if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia fetchByPrimaryKey(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idGestionPeticion);
	}

	/**
	* Returns all the ocurrencias.
	*
	* @return the ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.Ocurrencia> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.Ocurrencia> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.Ocurrencia> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the ocurrencias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ocurrencias.
	*
	* @return the number of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static OcurrenciaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (OcurrenciaPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					OcurrenciaPersistence.class.getName());

			ReferenceRegistry.registerReference(OcurrenciaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(OcurrenciaPersistence persistence) {
	}

	private static OcurrenciaPersistence _persistence;
}