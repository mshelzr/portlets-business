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

import com.ext.portlet.halcon.model.ProductoComplementario;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the producto complementario service. This utility wraps {@link ProductoComplementarioPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ProductoComplementarioPersistence
 * @see ProductoComplementarioPersistenceImpl
 * @generated
 */
public class ProductoComplementarioUtil {
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
	public static void clearCache(ProductoComplementario productoComplementario) {
		getPersistence().clearCache(productoComplementario);
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
	public static List<ProductoComplementario> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProductoComplementario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProductoComplementario> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ProductoComplementario update(
		ProductoComplementario productoComplementario, boolean merge)
		throws SystemException {
		return getPersistence().update(productoComplementario, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ProductoComplementario update(
		ProductoComplementario productoComplementario, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(productoComplementario, merge, serviceContext);
	}

	/**
	* Caches the producto complementario in the entity cache if it is enabled.
	*
	* @param productoComplementario the producto complementario
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario) {
		getPersistence().cacheResult(productoComplementario);
	}

	/**
	* Caches the producto complementarios in the entity cache if it is enabled.
	*
	* @param productoComplementarios the producto complementarios
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> productoComplementarios) {
		getPersistence().cacheResult(productoComplementarios);
	}

	/**
	* Creates a new producto complementario with the primary key. Does not add the producto complementario to the database.
	*
	* @param idProductoComplementario the primary key for the new producto complementario
	* @return the new producto complementario
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario create(
		long idProductoComplementario) {
		return getPersistence().create(idProductoComplementario);
	}

	/**
	* Removes the producto complementario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario that was removed
	* @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario remove(
		long idProductoComplementario)
		throws com.ext.portlet.halcon.NoSuchProductoComplementarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idProductoComplementario);
	}

	public static com.ext.portlet.halcon.model.ProductoComplementario updateImpl(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(productoComplementario, merge);
	}

	/**
	* Returns the producto complementario with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchProductoComplementarioException} if it could not be found.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario
	* @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario findByPrimaryKey(
		long idProductoComplementario)
		throws com.ext.portlet.halcon.NoSuchProductoComplementarioException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idProductoComplementario);
	}

	/**
	* Returns the producto complementario with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario, or <code>null</code> if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario fetchByPrimaryKey(
		long idProductoComplementario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idProductoComplementario);
	}

	/**
	* Returns all the producto complementarios.
	*
	* @return the producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the producto complementarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of producto complementarios
	* @param end the upper bound of the range of producto complementarios (not inclusive)
	* @return the range of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the producto complementarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of producto complementarios
	* @param end the upper bound of the range of producto complementarios (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the producto complementarios from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of producto complementarios.
	*
	* @return the number of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ProductoComplementarioPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ProductoComplementarioPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					ProductoComplementarioPersistence.class.getName());

			ReferenceRegistry.registerReference(ProductoComplementarioUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ProductoComplementarioPersistence persistence) {
	}

	private static ProductoComplementarioPersistence _persistence;
}