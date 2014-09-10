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

import com.ext.portlet.halcon.model.ValorCuota;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the valor cuota service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ValorCuotaPersistenceImpl
 * @see ValorCuotaUtil
 * @generated
 */
public interface ValorCuotaPersistence extends BasePersistence<ValorCuota> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ValorCuotaUtil} to access the valor cuota persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the valor cuota in the entity cache if it is enabled.
	*
	* @param valorCuota the valor cuota
	*/
	public void cacheResult(com.ext.portlet.halcon.model.ValorCuota valorCuota);

	/**
	* Caches the valor cuotas in the entity cache if it is enabled.
	*
	* @param valorCuotas the valor cuotas
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.ValorCuota> valorCuotas);

	/**
	* Creates a new valor cuota with the primary key. Does not add the valor cuota to the database.
	*
	* @param IdValorCuota the primary key for the new valor cuota
	* @return the new valor cuota
	*/
	public com.ext.portlet.halcon.model.ValorCuota create(long IdValorCuota);

	/**
	* Removes the valor cuota with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param IdValorCuota the primary key of the valor cuota
	* @return the valor cuota that was removed
	* @throws com.ext.portlet.halcon.NoSuchValorCuotaException if a valor cuota with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ValorCuota remove(long IdValorCuota)
		throws com.ext.portlet.halcon.NoSuchValorCuotaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.ValorCuota updateImpl(
		com.ext.portlet.halcon.model.ValorCuota valorCuota, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the valor cuota with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchValorCuotaException} if it could not be found.
	*
	* @param IdValorCuota the primary key of the valor cuota
	* @return the valor cuota
	* @throws com.ext.portlet.halcon.NoSuchValorCuotaException if a valor cuota with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ValorCuota findByPrimaryKey(
		long IdValorCuota)
		throws com.ext.portlet.halcon.NoSuchValorCuotaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the valor cuota with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param IdValorCuota the primary key of the valor cuota
	* @return the valor cuota, or <code>null</code> if a valor cuota with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ValorCuota fetchByPrimaryKey(
		long IdValorCuota)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the valor cuotas.
	*
	* @return the valor cuotas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ValorCuota> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the valor cuotas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of valor cuotas
	* @param end the upper bound of the range of valor cuotas (not inclusive)
	* @return the range of valor cuotas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ValorCuota> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the valor cuotas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of valor cuotas
	* @param end the upper bound of the range of valor cuotas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of valor cuotas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ValorCuota> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the valor cuotas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of valor cuotas.
	*
	* @return the number of valor cuotas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}