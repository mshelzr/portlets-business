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

import com.ext.portlet.halcon.model.AuditoriaSimulador;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the auditoria simulador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaSimuladorPersistenceImpl
 * @see AuditoriaSimuladorUtil
 * @generated
 */
public interface AuditoriaSimuladorPersistence extends BasePersistence<AuditoriaSimulador> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditoriaSimuladorUtil} to access the auditoria simulador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the auditoria simulador in the entity cache if it is enabled.
	*
	* @param auditoriaSimulador the auditoria simulador
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.AuditoriaSimulador auditoriaSimulador);

	/**
	* Caches the auditoria simuladors in the entity cache if it is enabled.
	*
	* @param auditoriaSimuladors the auditoria simuladors
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.AuditoriaSimulador> auditoriaSimuladors);

	/**
	* Creates a new auditoria simulador with the primary key. Does not add the auditoria simulador to the database.
	*
	* @param idAuditoriaSim the primary key for the new auditoria simulador
	* @return the new auditoria simulador
	*/
	public com.ext.portlet.halcon.model.AuditoriaSimulador create(
		long idAuditoriaSim);

	/**
	* Removes the auditoria simulador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaSim the primary key of the auditoria simulador
	* @return the auditoria simulador that was removed
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException if a auditoria simulador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaSimulador remove(
		long idAuditoriaSim)
		throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.AuditoriaSimulador updateImpl(
		com.ext.portlet.halcon.model.AuditoriaSimulador auditoriaSimulador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria simulador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException} if it could not be found.
	*
	* @param idAuditoriaSim the primary key of the auditoria simulador
	* @return the auditoria simulador
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException if a auditoria simulador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaSimulador findByPrimaryKey(
		long idAuditoriaSim)
		throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria simulador with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idAuditoriaSim the primary key of the auditoria simulador
	* @return the auditoria simulador, or <code>null</code> if a auditoria simulador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaSimulador fetchByPrimaryKey(
		long idAuditoriaSim)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the auditoria simuladors.
	*
	* @return the auditoria simuladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaSimulador> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the auditoria simuladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria simuladors
	* @param end the upper bound of the range of auditoria simuladors (not inclusive)
	* @return the range of auditoria simuladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaSimulador> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the auditoria simuladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria simuladors
	* @param end the upper bound of the range of auditoria simuladors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria simuladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaSimulador> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the auditoria simuladors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of auditoria simuladors.
	*
	* @return the number of auditoria simuladors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}