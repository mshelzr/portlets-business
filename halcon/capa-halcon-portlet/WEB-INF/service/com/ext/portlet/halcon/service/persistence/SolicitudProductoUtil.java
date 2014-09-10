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

import com.ext.portlet.halcon.model.SolicitudProducto;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the solicitud producto service. This utility wraps {@link SolicitudProductoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudProductoPersistence
 * @see SolicitudProductoPersistenceImpl
 * @generated
 */
public class SolicitudProductoUtil {
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
	public static void clearCache(SolicitudProducto solicitudProducto) {
		getPersistence().clearCache(solicitudProducto);
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
	public static List<SolicitudProducto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SolicitudProducto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SolicitudProducto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SolicitudProducto update(
		SolicitudProducto solicitudProducto, boolean merge)
		throws SystemException {
		return getPersistence().update(solicitudProducto, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SolicitudProducto update(
		SolicitudProducto solicitudProducto, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(solicitudProducto, merge, serviceContext);
	}

	/**
	* Caches the solicitud producto in the entity cache if it is enabled.
	*
	* @param solicitudProducto the solicitud producto
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto) {
		getPersistence().cacheResult(solicitudProducto);
	}

	/**
	* Caches the solicitud productos in the entity cache if it is enabled.
	*
	* @param solicitudProductos the solicitud productos
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> solicitudProductos) {
		getPersistence().cacheResult(solicitudProductos);
	}

	/**
	* Creates a new solicitud producto with the primary key. Does not add the solicitud producto to the database.
	*
	* @param idSolicitudProducto the primary key for the new solicitud producto
	* @return the new solicitud producto
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto create(
		long idSolicitudProducto) {
		return getPersistence().create(idSolicitudProducto);
	}

	/**
	* Removes the solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto that was removed
	* @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto remove(
		long idSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idSolicitudProducto);
	}

	public static com.ext.portlet.halcon.model.SolicitudProducto updateImpl(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(solicitudProducto, merge);
	}

	/**
	* Returns the solicitud producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchSolicitudProductoException} if it could not be found.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto
	* @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto findByPrimaryKey(
		long idSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idSolicitudProducto);
	}

	/**
	* Returns the solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto, or <code>null</code> if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto fetchByPrimaryKey(
		long idSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idSolicitudProducto);
	}

	/**
	* Returns all the solicitud productos.
	*
	* @return the solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud productos
	* @param end the upper bound of the range of solicitud productos (not inclusive)
	* @return the range of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud productos
	* @param end the upper bound of the range of solicitud productos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the solicitud productos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of solicitud productos.
	*
	* @return the number of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SolicitudProductoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SolicitudProductoPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					SolicitudProductoPersistence.class.getName());

			ReferenceRegistry.registerReference(SolicitudProductoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SolicitudProductoPersistence persistence) {
	}

	private static SolicitudProductoPersistence _persistence;
}