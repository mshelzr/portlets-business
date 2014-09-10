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

import com.ext.portlet.halcon.model.CargaTienda;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the carga tienda service. This utility wraps {@link CargaTiendaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaTiendaPersistence
 * @see CargaTiendaPersistenceImpl
 * @generated
 */
public class CargaTiendaUtil {
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
	public static void clearCache(CargaTienda cargaTienda) {
		getPersistence().clearCache(cargaTienda);
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
	public static List<CargaTienda> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CargaTienda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CargaTienda> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CargaTienda update(CargaTienda cargaTienda, boolean merge)
		throws SystemException {
		return getPersistence().update(cargaTienda, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CargaTienda update(CargaTienda cargaTienda, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cargaTienda, merge, serviceContext);
	}

	/**
	* Caches the carga tienda in the entity cache if it is enabled.
	*
	* @param cargaTienda the carga tienda
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda) {
		getPersistence().cacheResult(cargaTienda);
	}

	/**
	* Caches the carga tiendas in the entity cache if it is enabled.
	*
	* @param cargaTiendas the carga tiendas
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.CargaTienda> cargaTiendas) {
		getPersistence().cacheResult(cargaTiendas);
	}

	/**
	* Creates a new carga tienda with the primary key. Does not add the carga tienda to the database.
	*
	* @param idCargaTienda the primary key for the new carga tienda
	* @return the new carga tienda
	*/
	public static com.ext.portlet.halcon.model.CargaTienda create(
		long idCargaTienda) {
		return getPersistence().create(idCargaTienda);
	}

	/**
	* Removes the carga tienda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda that was removed
	* @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda remove(
		long idCargaTienda)
		throws com.ext.portlet.halcon.NoSuchCargaTiendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idCargaTienda);
	}

	public static com.ext.portlet.halcon.model.CargaTienda updateImpl(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cargaTienda, merge);
	}

	/**
	* Returns the carga tienda with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaTiendaException} if it could not be found.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda
	* @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda findByPrimaryKey(
		long idCargaTienda)
		throws com.ext.portlet.halcon.NoSuchCargaTiendaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idCargaTienda);
	}

	/**
	* Returns the carga tienda with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda, or <code>null</code> if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda fetchByPrimaryKey(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idCargaTienda);
	}

	/**
	* Returns all the carga tiendas.
	*
	* @return the carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaTienda> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the carga tiendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga tiendas
	* @param end the upper bound of the range of carga tiendas (not inclusive)
	* @return the range of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaTienda> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the carga tiendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga tiendas
	* @param end the upper bound of the range of carga tiendas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaTienda> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the carga tiendas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of carga tiendas.
	*
	* @return the number of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CargaTiendaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CargaTiendaPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					CargaTiendaPersistence.class.getName());

			ReferenceRegistry.registerReference(CargaTiendaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CargaTiendaPersistence persistence) {
	}

	private static CargaTiendaPersistence _persistence;
}