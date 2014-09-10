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

import com.ext.portlet.halcon.model.Ubigeo;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the ubigeo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see UbigeoPersistenceImpl
 * @see UbigeoUtil
 * @generated
 */
public interface UbigeoPersistence extends BasePersistence<Ubigeo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UbigeoUtil} to access the ubigeo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the ubigeo in the entity cache if it is enabled.
	*
	* @param ubigeo the ubigeo
	*/
	public void cacheResult(com.ext.portlet.halcon.model.Ubigeo ubigeo);

	/**
	* Caches the ubigeos in the entity cache if it is enabled.
	*
	* @param ubigeos the ubigeos
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.Ubigeo> ubigeos);

	/**
	* Creates a new ubigeo with the primary key. Does not add the ubigeo to the database.
	*
	* @param idUbigeo the primary key for the new ubigeo
	* @return the new ubigeo
	*/
	public com.ext.portlet.halcon.model.Ubigeo create(long idUbigeo);

	/**
	* Removes the ubigeo with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idUbigeo the primary key of the ubigeo
	* @return the ubigeo that was removed
	* @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ubigeo remove(long idUbigeo)
		throws com.ext.portlet.halcon.NoSuchUbigeoException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.Ubigeo updateImpl(
		com.ext.portlet.halcon.model.Ubigeo ubigeo, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ubigeo with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchUbigeoException} if it could not be found.
	*
	* @param idUbigeo the primary key of the ubigeo
	* @return the ubigeo
	* @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ubigeo findByPrimaryKey(long idUbigeo)
		throws com.ext.portlet.halcon.NoSuchUbigeoException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ubigeo with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idUbigeo the primary key of the ubigeo
	* @return the ubigeo, or <code>null</code> if a ubigeo with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ubigeo fetchByPrimaryKey(long idUbigeo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the ubigeos.
	*
	* @return the ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the ubigeos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ubigeos
	* @param end the upper bound of the range of ubigeos (not inclusive)
	* @return the range of ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the ubigeos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ubigeos
	* @param end the upper bound of the range of ubigeos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Ubigeo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the ubigeos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of ubigeos.
	*
	* @return the number of ubigeos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}