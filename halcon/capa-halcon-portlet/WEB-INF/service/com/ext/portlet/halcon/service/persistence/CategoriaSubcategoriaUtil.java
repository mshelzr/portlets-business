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

import com.ext.portlet.halcon.model.CategoriaSubcategoria;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the categoria subcategoria service. This utility wraps {@link CategoriaSubcategoriaPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CategoriaSubcategoriaPersistence
 * @see CategoriaSubcategoriaPersistenceImpl
 * @generated
 */
public class CategoriaSubcategoriaUtil {
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
	public static void clearCache(CategoriaSubcategoria categoriaSubcategoria) {
		getPersistence().clearCache(categoriaSubcategoria);
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
	public static List<CategoriaSubcategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CategoriaSubcategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CategoriaSubcategoria> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CategoriaSubcategoria update(
		CategoriaSubcategoria categoriaSubcategoria, boolean merge)
		throws SystemException {
		return getPersistence().update(categoriaSubcategoria, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CategoriaSubcategoria update(
		CategoriaSubcategoria categoriaSubcategoria, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence()
				   .update(categoriaSubcategoria, merge, serviceContext);
	}

	/**
	* Caches the categoria subcategoria in the entity cache if it is enabled.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	*/
	public static void cacheResult(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria) {
		getPersistence().cacheResult(categoriaSubcategoria);
	}

	/**
	* Caches the categoria subcategorias in the entity cache if it is enabled.
	*
	* @param categoriaSubcategorias the categoria subcategorias
	*/
	public static void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> categoriaSubcategorias) {
		getPersistence().cacheResult(categoriaSubcategorias);
	}

	/**
	* Creates a new categoria subcategoria with the primary key. Does not add the categoria subcategoria to the database.
	*
	* @param idCategoriaSubCat the primary key for the new categoria subcategoria
	* @return the new categoria subcategoria
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria create(
		long idCategoriaSubCat) {
		return getPersistence().create(idCategoriaSubCat);
	}

	/**
	* Removes the categoria subcategoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria that was removed
	* @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria remove(
		long idCategoriaSubCat)
		throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(idCategoriaSubCat);
	}

	public static com.ext.portlet.halcon.model.CategoriaSubcategoria updateImpl(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(categoriaSubcategoria, merge);
	}

	/**
	* Returns the categoria subcategoria with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException} if it could not be found.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria
	* @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria findByPrimaryKey(
		long idCategoriaSubCat)
		throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(idCategoriaSubCat);
	}

	/**
	* Returns the categoria subcategoria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria, or <code>null</code> if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria fetchByPrimaryKey(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(idCategoriaSubCat);
	}

	/**
	* Returns all the categoria subcategorias.
	*
	* @return the categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the categoria subcategorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categoria subcategorias
	* @param end the upper bound of the range of categoria subcategorias (not inclusive)
	* @return the range of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the categoria subcategorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categoria subcategorias
	* @param end the upper bound of the range of categoria subcategorias (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the categoria subcategorias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of categoria subcategorias.
	*
	* @return the number of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CategoriaSubcategoriaPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CategoriaSubcategoriaPersistence)PortletBeanLocatorUtil.locate(com.ext.portlet.halcon.service.ClpSerializer.getServletContextName(),
					CategoriaSubcategoriaPersistence.class.getName());

			ReferenceRegistry.registerReference(CategoriaSubcategoriaUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CategoriaSubcategoriaPersistence persistence) {
	}

	private static CategoriaSubcategoriaPersistence _persistence;
}