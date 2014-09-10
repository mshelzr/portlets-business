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

import com.ext.portlet.halcon.model.ConfiguracionPerfilador;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the configuracion perfilador service. This utility wraps {@link ConfiguracionPerfiladorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfiladorPersistence
 * @see ConfiguracionPerfiladorPersistenceImpl
 * @generated
 */
public class ConfiguracionPerfiladorUtil {
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
		ConfiguracionPerfilador configuracionPerfilador) {
		getPersistence().clearCache(configuracionPerfilador);
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
	public static List<ConfiguracionPerfilador> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ConfiguracionPerfilador> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ConfiguracionPerfilador> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ConfiguracionPerfilador update(
		ConfiguracionPerfilador configuracionPerfilador, boolean merge)
		throws SystemException {
		return getPersistence().update(configuracionPerfilador, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ConfiguracionPerfilador update(
		ConfiguracionPerfilador configuracionPerfilador, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(configuracionPerfilador, merge, serviceContext);
	}

	/**
	* Caches the configuracion perfilador in the entity cache if it is enabled.
	*
	* @param configuracionPerfilador the configuracion perfilador
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador) {
		getPersistence().cacheResult(configuracionPerfilador);
	}

	/**
	* Caches the configuracion perfiladors in the entity cache if it is enabled.
	*
	* @param configuracionPerfiladors the configuracion perfiladors
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> configuracionPerfiladors) {
		getPersistence().cacheResult(configuracionPerfiladors);
	}

	/**
	* Creates a new configuracion perfilador with the primary key. Does not add the configuracion perfilador to the database.
	*
	* @param idConfiguracionPerfilador the primary key for the new configuracion perfilador
	* @return the new configuracion perfilador
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador create(
		long idConfiguracionPerfilador) {
		return getPersistence().create(idConfiguracionPerfilador);
	}

	/**
	* Removes the configuracion perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador that was removed
	* @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador remove(
		long idConfiguracionPerfilador)
		throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idConfiguracionPerfilador);
	}

	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador updateImpl(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(configuracionPerfilador, merge);
	}

	/**
	* Returns the configuracion perfilador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException} if it could not be found.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador
	* @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador findByPrimaryKey(
		long idConfiguracionPerfilador)
		throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idConfiguracionPerfilador);
	}

	/**
	* Returns the configuracion perfilador with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador, or <code>null</code> if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador fetchByPrimaryKey(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idConfiguracionPerfilador);
	}

	/**
	* Returns all the configuracion perfiladors.
	*
	* @return the configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the configuracion perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion perfiladors
	* @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	* @return the range of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the configuracion perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion perfiladors
	* @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the configuracion perfiladors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of configuracion perfiladors.
	*
	* @return the number of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ConfiguracionPerfiladorPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ConfiguracionPerfiladorPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					ConfiguracionPerfiladorPersistence.class.getName());

			ReferenceRegistry.registerReference(ConfiguracionPerfiladorUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ConfiguracionPerfiladorPersistence persistence) {
	}

	private static ConfiguracionPerfiladorPersistence _persistence;
}