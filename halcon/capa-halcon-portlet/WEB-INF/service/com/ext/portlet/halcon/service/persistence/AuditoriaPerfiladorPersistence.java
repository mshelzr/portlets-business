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

import com.ext.portlet.halcon.model.AuditoriaPerfilador;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the auditoria perfilador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaPerfiladorPersistenceImpl
 * @see AuditoriaPerfiladorUtil
 * @generated
 */
public interface AuditoriaPerfiladorPersistence extends BasePersistence<AuditoriaPerfilador> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuditoriaPerfiladorUtil} to access the auditoria perfilador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the auditoria perfilador in the entity cache if it is enabled.
	*
	* @param auditoriaPerfilador the auditoria perfilador
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador);

	/**
	* Caches the auditoria perfiladors in the entity cache if it is enabled.
	*
	* @param auditoriaPerfiladors the auditoria perfiladors
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> auditoriaPerfiladors);

	/**
	* Creates a new auditoria perfilador with the primary key. Does not add the auditoria perfilador to the database.
	*
	* @param idAuditoriaPer the primary key for the new auditoria perfilador
	* @return the new auditoria perfilador
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador create(
		long idAuditoriaPer);

	/**
	* Removes the auditoria perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador that was removed
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador remove(
		long idAuditoriaPer)
		throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.AuditoriaPerfilador updateImpl(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria perfilador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException} if it could not be found.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador
	* @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador findByPrimaryKey(
		long idAuditoriaPer)
		throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the auditoria perfilador with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador, or <code>null</code> if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador fetchByPrimaryKey(
		long idAuditoriaPer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the auditoria perfiladors.
	*
	* @return the auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the auditoria perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria perfiladors
	* @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	* @return the range of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the auditoria perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria perfiladors
	* @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the auditoria perfiladors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of auditoria perfiladors.
	*
	* @return the number of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}