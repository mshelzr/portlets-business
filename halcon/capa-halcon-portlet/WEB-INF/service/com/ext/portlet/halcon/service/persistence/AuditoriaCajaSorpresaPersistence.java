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

import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the auditoria caja sorpresa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresaPersistenceImpl
 * @see AuditoriaCajaSorpresaUtil
 * @generated
 */
public interface AuditoriaCajaSorpresaPersistence extends BasePersistence<AuditoriaCajaSorpresa> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditoriaCajaSorpresaUtil} to access the auditoria caja sorpresa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the auditoria caja sorpresa in the entity cache if it is enabled.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa);

	/**
	* Caches the auditoria caja sorpresas in the entity cache if it is enabled.
	*
	* @param auditoriaCajaSorpresas the auditoria caja sorpresas
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> auditoriaCajaSorpresas);

	/**
	* Creates a new auditoria caja sorpresa with the primary key. Does not add the auditoria caja sorpresa to the database.
	*
	* @param idAuditoriaCajSorp the primary key for the new auditoria caja sorpresa
	* @return the new auditoria caja sorpresa
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa create(
		long idAuditoriaCajSorp);

	/**
	* Removes the auditoria caja sorpresa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was removed
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa remove(
		long idAuditoriaCajSorp)
		throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa updateImpl(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria caja sorpresa with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException} if it could not be found.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa findByPrimaryKey(
		long idAuditoriaCajSorp)
		throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria caja sorpresa with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa, or <code>null</code> if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa fetchByPrimaryKey(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the auditoria caja sorpresas.
	*
	* @return the auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the auditoria caja sorpresas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria caja sorpresas
	* @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	* @return the range of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the auditoria caja sorpresas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria caja sorpresas
	* @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the auditoria caja sorpresas from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of auditoria caja sorpresas.
	*
	* @return the number of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}