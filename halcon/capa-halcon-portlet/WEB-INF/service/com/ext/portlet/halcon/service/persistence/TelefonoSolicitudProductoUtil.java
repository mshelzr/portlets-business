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

import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the telefono solicitud producto service. This utility wraps {@link TelefonoSolicitudProductoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see TelefonoSolicitudProductoPersistence
 * @see TelefonoSolicitudProductoPersistenceImpl
 * @generated
 */
public class TelefonoSolicitudProductoUtil {
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
	public static void clearCache(
		TelefonoSolicitudProducto telefonoSolicitudProducto) {
		getPersistence().clearCache(telefonoSolicitudProducto);
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
	public static List<TelefonoSolicitudProducto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TelefonoSolicitudProducto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TelefonoSolicitudProducto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static TelefonoSolicitudProducto update(
		TelefonoSolicitudProducto telefonoSolicitudProducto, boolean merge)
		throws SystemException {
		return getPersistence().update(telefonoSolicitudProducto, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static TelefonoSolicitudProducto update(
		TelefonoSolicitudProducto telefonoSolicitudProducto, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(telefonoSolicitudProducto, merge, serviceContext);
	}

	/**
	* Caches the telefono solicitud producto in the entity cache if it is enabled.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto) {
		getPersistence().cacheResult(telefonoSolicitudProducto);
	}

	/**
	* Caches the telefono solicitud productos in the entity cache if it is enabled.
	*
	* @param telefonoSolicitudProductos the telefono solicitud productos
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> telefonoSolicitudProductos) {
		getPersistence().cacheResult(telefonoSolicitudProductos);
	}

	/**
	* Creates a new telefono solicitud producto with the primary key. Does not add the telefono solicitud producto to the database.
	*
	* @param idTelefSolicitudProducto the primary key for the new telefono solicitud producto
	* @return the new telefono solicitud producto
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto create(
		long idTelefSolicitudProducto) {
		return getPersistence().create(idTelefSolicitudProducto);
	}

	/**
	* Removes the telefono solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto that was removed
	* @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto remove(
		long idTelefSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idTelefSolicitudProducto);
	}

	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto updateImpl(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(telefonoSolicitudProducto, merge);
	}

	/**
	* Returns the telefono solicitud producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException} if it could not be found.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto
	* @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto findByPrimaryKey(
		long idTelefSolicitudProducto)
		throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idTelefSolicitudProducto);
	}

	/**
	* Returns the telefono solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto, or <code>null</code> if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto fetchByPrimaryKey(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idTelefSolicitudProducto);
	}

	/**
	* Returns all the telefono solicitud productos.
	*
	* @return the telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the telefono solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefono solicitud productos
	* @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	* @return the range of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the telefono solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefono solicitud productos
	* @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the telefono solicitud productos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of telefono solicitud productos.
	*
	* @return the number of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TelefonoSolicitudProductoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TelefonoSolicitudProductoPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					TelefonoSolicitudProductoPersistence.class.getName());

			ReferenceRegistry.registerReference(TelefonoSolicitudProductoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(TelefonoSolicitudProductoPersistence persistence) {
	}

	private static TelefonoSolicitudProductoPersistence _persistence;
}