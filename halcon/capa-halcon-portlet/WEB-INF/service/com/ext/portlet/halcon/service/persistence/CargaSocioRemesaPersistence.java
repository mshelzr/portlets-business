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

import com.ext.portlet.halcon.model.CargaSocioRemesa;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the carga socio remesa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaSocioRemesaPersistenceImpl
 * @see CargaSocioRemesaUtil
 * @generated
 */
public interface CargaSocioRemesaPersistence extends BasePersistence<CargaSocioRemesa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CargaSocioRemesaUtil} to access the carga socio remesa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the carga socio remesa in the entity cache if it is enabled.
	*
	* @param cargaSocioRemesa the carga socio remesa
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa);

	/**
	* Caches the carga socio remesas in the entity cache if it is enabled.
	*
	* @param cargaSocioRemesas the carga socio remesas
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> cargaSocioRemesas);

	/**
	* Creates a new carga socio remesa with the primary key. Does not add the carga socio remesa to the database.
	*
	* @param idSocioRemesa the primary key for the new carga socio remesa
	* @return the new carga socio remesa
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa create(
		long idSocioRemesa);

	/**
	* Removes the carga socio remesa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa that was removed
	* @throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa remove(
		long idSocioRemesa)
		throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.CargaSocioRemesa updateImpl(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the carga socio remesa with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaSocioRemesaException} if it could not be found.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa
	* @throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa findByPrimaryKey(
		long idSocioRemesa)
		throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the carga socio remesa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa, or <code>null</code> if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa fetchByPrimaryKey(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the carga socio remesas.
	*
	* @return the carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the carga socio remesas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga socio remesas
	* @param end the upper bound of the range of carga socio remesas (not inclusive)
	* @return the range of carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the carga socio remesas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga socio remesas
	* @param end the upper bound of the range of carga socio remesas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the carga socio remesas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of carga socio remesas.
	*
	* @return the number of carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}