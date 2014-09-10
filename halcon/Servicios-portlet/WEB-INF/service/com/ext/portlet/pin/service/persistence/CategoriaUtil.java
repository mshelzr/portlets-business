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

package com.ext.portlet.pin.service.persistence;

import com.ext.portlet.pin.model.Categoria;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the categoria service. This utility wraps {@link CategoriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author arodriguez
 * @see CategoriaPersistence
 * @see CategoriaPersistenceImpl
 * @generated
 */
public class CategoriaUtil {
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
	public static void clearCache(Categoria categoria) {
		getPersistence().clearCache(categoria);
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
	public static List<Categoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Categoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Categoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Categoria update(Categoria categoria, boolean merge)
		throws SystemException {
		return getPersistence().update(categoria, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Categoria update(Categoria categoria, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(categoria, merge, serviceContext);
	}

	/**
	* Caches the categoria in the entity cache if it is enabled.
	*
	* @param categoria the categoria
	*/
	public static void cacheResult(
		com.ext.portlet.pin.model.Categoria categoria) {
		getPersistence().cacheResult(categoria);
	}

	/**
	* Caches the categorias in the entity cache if it is enabled.
	*
	* @param categorias the categorias
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.pin.model.Categoria> categorias) {
		getPersistence().cacheResult(categorias);
	}

	/**
	* Creates a new categoria with the primary key. Does not add the categoria to the database.
	*
	* @param categoriaId the primary key for the new categoria
	* @return the new categoria
	*/
	public static com.ext.portlet.pin.model.Categoria create(long categoriaId) {
		return getPersistence().create(categoriaId);
	}

	/**
	* Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoriaId the primary key of the categoria
	* @return the categoria that was removed
	* @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.pin.model.Categoria remove(long categoriaId)
		throws com.ext.portlet.pin.NoSuchCategoriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(categoriaId);
	}

	public static com.ext.portlet.pin.model.Categoria updateImpl(
		com.ext.portlet.pin.model.Categoria categoria, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(categoria, merge);
	}

	/**
	* Returns the categoria with the primary key or throws a {@link com.ext.portlet.pin.NoSuchCategoriaException} if it could not be found.
	*
	* @param categoriaId the primary key of the categoria
	* @return the categoria
	* @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.pin.model.Categoria findByPrimaryKey(
		long categoriaId)
		throws com.ext.portlet.pin.NoSuchCategoriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(categoriaId);
	}

	/**
	* Returns the categoria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoriaId the primary key of the categoria
	* @return the categoria, or <code>null</code> if a categoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.pin.model.Categoria fetchByPrimaryKey(
		long categoriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoriaId);
	}

	/**
	* Returns all the categorias.
	*
	* @return the categorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.pin.model.Categoria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the categorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categorias
	* @param end the upper bound of the range of categorias (not inclusive)
	* @return the range of categorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.pin.model.Categoria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the categorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categorias
	* @param end the upper bound of the range of categorias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.pin.model.Categoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the categorias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of categorias.
	*
	* @return the number of categorias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoriaPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.pin.service.ClpSerializer.getServletContextName(),
					CategoriaPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CategoriaPersistence persistence) {
	}

	private static CategoriaPersistence _persistence;
}