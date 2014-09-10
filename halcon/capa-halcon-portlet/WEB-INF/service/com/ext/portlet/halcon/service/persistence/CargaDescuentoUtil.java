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

import com.ext.portlet.halcon.model.CargaDescuento;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the carga descuento service. This utility wraps {@link CargaDescuentoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaDescuentoPersistence
 * @see CargaDescuentoPersistenceImpl
 * @generated
 */
public class CargaDescuentoUtil {
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
	public static void clearCache(CargaDescuento cargaDescuento) {
		getPersistence().clearCache(cargaDescuento);
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
	public static List<CargaDescuento> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CargaDescuento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CargaDescuento> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CargaDescuento update(CargaDescuento cargaDescuento,
		boolean merge) throws SystemException {
		return getPersistence().update(cargaDescuento, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CargaDescuento update(CargaDescuento cargaDescuento,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(cargaDescuento, merge, serviceContext);
	}

	/**
	* Caches the carga descuento in the entity cache if it is enabled.
	*
	* @param cargaDescuento the carga descuento
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento) {
		getPersistence().cacheResult(cargaDescuento);
	}

	/**
	* Caches the carga descuentos in the entity cache if it is enabled.
	*
	* @param cargaDescuentos the carga descuentos
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.CargaDescuento> cargaDescuentos) {
		getPersistence().cacheResult(cargaDescuentos);
	}

	/**
	* Creates a new carga descuento with the primary key. Does not add the carga descuento to the database.
	*
	* @param idCargaDesc the primary key for the new carga descuento
	* @return the new carga descuento
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento create(
		long idCargaDesc) {
		return getPersistence().create(idCargaDesc);
	}

	/**
	* Removes the carga descuento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCargaDesc the primary key of the carga descuento
	* @return the carga descuento that was removed
	* @throws com.ext.portlet.halcon.NoSuchCargaDescuentoException if a carga descuento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento remove(
		long idCargaDesc)
		throws com.ext.portlet.halcon.NoSuchCargaDescuentoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idCargaDesc);
	}

	public static com.ext.portlet.halcon.model.CargaDescuento updateImpl(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(cargaDescuento, merge);
	}

	/**
	* Returns the carga descuento with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaDescuentoException} if it could not be found.
	*
	* @param idCargaDesc the primary key of the carga descuento
	* @return the carga descuento
	* @throws com.ext.portlet.halcon.NoSuchCargaDescuentoException if a carga descuento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento findByPrimaryKey(
		long idCargaDesc)
		throws com.ext.portlet.halcon.NoSuchCargaDescuentoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idCargaDesc);
	}

	/**
	* Returns the carga descuento with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idCargaDesc the primary key of the carga descuento
	* @return the carga descuento, or <code>null</code> if a carga descuento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento fetchByPrimaryKey(
		long idCargaDesc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idCargaDesc);
	}

	/**
	* Returns all the carga descuentos.
	*
	* @return the carga descuentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaDescuento> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the carga descuentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga descuentos
	* @param end the upper bound of the range of carga descuentos (not inclusive)
	* @return the range of carga descuentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaDescuento> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the carga descuentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga descuentos
	* @param end the upper bound of the range of carga descuentos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of carga descuentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaDescuento> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the carga descuentos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of carga descuentos.
	*
	* @return the number of carga descuentos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CargaDescuentoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CargaDescuentoPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					CargaDescuentoPersistence.class.getName());

			ReferenceRegistry.registerReference(CargaDescuentoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CargaDescuentoPersistence persistence) {
	}

	private static CargaDescuentoPersistence _persistence;
}