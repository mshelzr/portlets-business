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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the categoria subcategoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CategoriaSubcategoriaPersistenceImpl
 * @see CategoriaSubcategoriaUtil
 * @generated
 */
public interface CategoriaSubcategoriaPersistence extends BasePersistence<CategoriaSubcategoria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoriaSubcategoriaUtil} to access the categoria subcategoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the categoria subcategoria in the entity cache if it is enabled.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria);

	/**
	* Caches the categoria subcategorias in the entity cache if it is enabled.
	*
	* @param categoriaSubcategorias the categoria subcategorias
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> categoriaSubcategorias);

	/**
	* Creates a new categoria subcategoria with the primary key. Does not add the categoria subcategoria to the database.
	*
	* @param idCategoriaSubCat the primary key for the new categoria subcategoria
	* @return the new categoria subcategoria
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria create(
		long idCategoriaSubCat);

	/**
	* Removes the categoria subcategoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria that was removed
	* @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria remove(
		long idCategoriaSubCat)
		throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.CategoriaSubcategoria updateImpl(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categoria subcategoria with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException} if it could not be found.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria
	* @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria findByPrimaryKey(
		long idCategoriaSubCat)
		throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categoria subcategoria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria, or <code>null</code> if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria fetchByPrimaryKey(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the categoria subcategorias.
	*
	* @return the categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the categoria subcategorias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categoria subcategorias.
	*
	* @return the number of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}