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

import com.ext.portlet.halcon.model.Parametro;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ParametroPersistenceImpl
 * @see ParametroUtil
 * @generated
 */
public interface ParametroPersistence extends BasePersistence<Parametro> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ParametroUtil} to access the parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the parametro in the entity cache if it is enabled.
	*
	* @param parametro the parametro
	*/
	public void cacheResult(com.ext.portlet.halcon.model.Parametro parametro);

	/**
	* Caches the parametros in the entity cache if it is enabled.
	*
	* @param parametros the parametros
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.Parametro> parametros);

	/**
	* Creates a new parametro with the primary key. Does not add the parametro to the database.
	*
	* @param idParametro the primary key for the new parametro
	* @return the new parametro
	*/
	public com.ext.portlet.halcon.model.Parametro create(int idParametro);

	/**
	* Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idParametro the primary key of the parametro
	* @return the parametro that was removed
	* @throws com.ext.portlet.halcon.NoSuchParametroException if a parametro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Parametro remove(int idParametro)
		throws com.ext.portlet.halcon.NoSuchParametroException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.Parametro updateImpl(
		com.ext.portlet.halcon.model.Parametro parametro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parametro with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchParametroException} if it could not be found.
	*
	* @param idParametro the primary key of the parametro
	* @return the parametro
	* @throws com.ext.portlet.halcon.NoSuchParametroException if a parametro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Parametro findByPrimaryKey(
		int idParametro)
		throws com.ext.portlet.halcon.NoSuchParametroException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idParametro the primary key of the parametro
	* @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Parametro fetchByPrimaryKey(
		int idParametro)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the parametros.
	*
	* @return the parametros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Parametro> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the parametros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of parametros
	* @param end the upper bound of the range of parametros (not inclusive)
	* @return the range of parametros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Parametro> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the parametros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of parametros
	* @param end the upper bound of the range of parametros (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of parametros
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Parametro> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the parametros from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of parametros.
	*
	* @return the number of parametros
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}