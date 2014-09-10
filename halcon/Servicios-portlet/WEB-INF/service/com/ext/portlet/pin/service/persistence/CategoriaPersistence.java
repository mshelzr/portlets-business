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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author arodriguez
 * @see CategoriaPersistenceImpl
 * @see CategoriaUtil
 * @generated
 */
public interface CategoriaPersistence extends BasePersistence<Categoria> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CategoriaUtil} to access the categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the categoria in the entity cache if it is enabled.
	*
	* @param categoria the categoria
	*/
	public void cacheResult(com.ext.portlet.pin.model.Categoria categoria);

	/**
	* Caches the categorias in the entity cache if it is enabled.
	*
	* @param categorias the categorias
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.pin.model.Categoria> categorias);

	/**
	* Creates a new categoria with the primary key. Does not add the categoria to the database.
	*
	* @param categoriaId the primary key for the new categoria
	* @return the new categoria
	*/
	public com.ext.portlet.pin.model.Categoria create(long categoriaId);

	/**
	* Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoriaId the primary key of the categoria
	* @return the categoria that was removed
	* @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Categoria remove(long categoriaId)
		throws com.ext.portlet.pin.NoSuchCategoriaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.pin.model.Categoria updateImpl(
		com.ext.portlet.pin.model.Categoria categoria, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categoria with the primary key or throws a {@link com.ext.portlet.pin.NoSuchCategoriaException} if it could not be found.
	*
	* @param categoriaId the primary key of the categoria
	* @return the categoria
	* @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Categoria findByPrimaryKey(
		long categoriaId)
		throws com.ext.portlet.pin.NoSuchCategoriaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the categoria with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoriaId the primary key of the categoria
	* @return the categoria, or <code>null</code> if a categoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Categoria fetchByPrimaryKey(
		long categoriaId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the categorias.
	*
	* @return the categorias
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.pin.model.Categoria> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ext.portlet.pin.model.Categoria> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ext.portlet.pin.model.Categoria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the categorias from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of categorias.
	*
	* @return the number of categorias
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}