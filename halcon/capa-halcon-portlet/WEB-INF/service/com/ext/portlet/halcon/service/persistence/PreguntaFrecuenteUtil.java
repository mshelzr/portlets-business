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

import com.ext.portlet.halcon.model.PreguntaFrecuente;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the pregunta frecuente service. This utility wraps {@link PreguntaFrecuentePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see PreguntaFrecuentePersistence
 * @see PreguntaFrecuentePersistenceImpl
 * @generated
 */
public class PreguntaFrecuenteUtil {
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
	public static void clearCache(PreguntaFrecuente preguntaFrecuente) {
		getPersistence().clearCache(preguntaFrecuente);
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
	public static List<PreguntaFrecuente> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PreguntaFrecuente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PreguntaFrecuente> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static PreguntaFrecuente update(
		PreguntaFrecuente preguntaFrecuente, boolean merge)
		throws SystemException {
		return getPersistence().update(preguntaFrecuente, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static PreguntaFrecuente update(
		PreguntaFrecuente preguntaFrecuente, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(preguntaFrecuente, merge, serviceContext);
	}

	/**
	* Caches the pregunta frecuente in the entity cache if it is enabled.
	*
	* @param preguntaFrecuente the pregunta frecuente
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente) {
		getPersistence().cacheResult(preguntaFrecuente);
	}

	/**
	* Caches the pregunta frecuentes in the entity cache if it is enabled.
	*
	* @param preguntaFrecuentes the pregunta frecuentes
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> preguntaFrecuentes) {
		getPersistence().cacheResult(preguntaFrecuentes);
	}

	/**
	* Creates a new pregunta frecuente with the primary key. Does not add the pregunta frecuente to the database.
	*
	* @param idPreguntaFrecuente the primary key for the new pregunta frecuente
	* @return the new pregunta frecuente
	*/
	public static com.ext.portlet.halcon.model.PreguntaFrecuente create(
		int idPreguntaFrecuente) {
		return getPersistence().create(idPreguntaFrecuente);
	}

	/**
	* Removes the pregunta frecuente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente that was removed
	* @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.PreguntaFrecuente remove(
		int idPreguntaFrecuente)
		throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idPreguntaFrecuente);
	}

	public static com.ext.portlet.halcon.model.PreguntaFrecuente updateImpl(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(preguntaFrecuente, merge);
	}

	/**
	* Returns the pregunta frecuente with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException} if it could not be found.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente
	* @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.PreguntaFrecuente findByPrimaryKey(
		int idPreguntaFrecuente)
		throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idPreguntaFrecuente);
	}

	/**
	* Returns the pregunta frecuente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente, or <code>null</code> if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.PreguntaFrecuente fetchByPrimaryKey(
		int idPreguntaFrecuente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idPreguntaFrecuente);
	}

	/**
	* Returns all the pregunta frecuentes.
	*
	* @return the pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the pregunta frecuentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pregunta frecuentes
	* @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	* @return the range of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the pregunta frecuentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pregunta frecuentes
	* @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the pregunta frecuentes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of pregunta frecuentes.
	*
	* @return the number of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PreguntaFrecuentePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PreguntaFrecuentePersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					PreguntaFrecuentePersistence.class.getName());

			ReferenceRegistry.registerReference(PreguntaFrecuenteUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(PreguntaFrecuentePersistence persistence) {
	}

	private static PreguntaFrecuentePersistence _persistence;
}