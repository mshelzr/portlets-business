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

import com.ext.portlet.halcon.model.SolicitudContacto;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the solicitud contacto service. This utility wraps {@link SolicitudContactoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudContactoPersistence
 * @see SolicitudContactoPersistenceImpl
 * @generated
 */
public class SolicitudContactoUtil {
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
	public static void clearCache(SolicitudContacto solicitudContacto) {
		getPersistence().clearCache(solicitudContacto);
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
	public static List<SolicitudContacto> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SolicitudContacto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SolicitudContacto> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static SolicitudContacto update(
		SolicitudContacto solicitudContacto, boolean merge)
		throws SystemException {
		return getPersistence().update(solicitudContacto, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static SolicitudContacto update(
		SolicitudContacto solicitudContacto, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(solicitudContacto, merge, serviceContext);
	}

	/**
	* Caches the solicitud contacto in the entity cache if it is enabled.
	*
	* @param solicitudContacto the solicitud contacto
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto) {
		getPersistence().cacheResult(solicitudContacto);
	}

	/**
	* Caches the solicitud contactos in the entity cache if it is enabled.
	*
	* @param solicitudContactos the solicitud contactos
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.SolicitudContacto> solicitudContactos) {
		getPersistence().cacheResult(solicitudContactos);
	}

	/**
	* Creates a new solicitud contacto with the primary key. Does not add the solicitud contacto to the database.
	*
	* @param idSolicitudContacto the primary key for the new solicitud contacto
	* @return the new solicitud contacto
	*/
	public static com.ext.portlet.halcon.model.SolicitudContacto create(
		long idSolicitudContacto) {
		return getPersistence().create(idSolicitudContacto);
	}

	/**
	* Removes the solicitud contacto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSolicitudContacto the primary key of the solicitud contacto
	* @return the solicitud contacto that was removed
	* @throws com.ext.portlet.halcon.NoSuchSolicitudContactoException if a solicitud contacto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudContacto remove(
		long idSolicitudContacto)
		throws com.ext.portlet.halcon.NoSuchSolicitudContactoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idSolicitudContacto);
	}

	public static com.ext.portlet.halcon.model.SolicitudContacto updateImpl(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(solicitudContacto, merge);
	}

	/**
	* Returns the solicitud contacto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchSolicitudContactoException} if it could not be found.
	*
	* @param idSolicitudContacto the primary key of the solicitud contacto
	* @return the solicitud contacto
	* @throws com.ext.portlet.halcon.NoSuchSolicitudContactoException if a solicitud contacto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudContacto findByPrimaryKey(
		long idSolicitudContacto)
		throws com.ext.portlet.halcon.NoSuchSolicitudContactoException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idSolicitudContacto);
	}

	/**
	* Returns the solicitud contacto with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idSolicitudContacto the primary key of the solicitud contacto
	* @return the solicitud contacto, or <code>null</code> if a solicitud contacto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudContacto fetchByPrimaryKey(
		long idSolicitudContacto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idSolicitudContacto);
	}

	/**
	* Returns all the solicitud contactos.
	*
	* @return the solicitud contactos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudContacto> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the solicitud contactos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud contactos
	* @param end the upper bound of the range of solicitud contactos (not inclusive)
	* @return the range of solicitud contactos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudContacto> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the solicitud contactos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud contactos
	* @param end the upper bound of the range of solicitud contactos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of solicitud contactos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudContacto> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the solicitud contactos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of solicitud contactos.
	*
	* @return the number of solicitud contactos
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SolicitudContactoPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SolicitudContactoPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					SolicitudContactoPersistence.class.getName());

			ReferenceRegistry.registerReference(SolicitudContactoUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(SolicitudContactoPersistence persistence) {
	}

	private static SolicitudContactoPersistence _persistence;
}