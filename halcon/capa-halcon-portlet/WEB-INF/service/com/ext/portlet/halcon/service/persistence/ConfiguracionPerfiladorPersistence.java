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

import com.ext.portlet.halcon.model.ConfiguracionPerfilador;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the configuracion perfilador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfiladorPersistenceImpl
 * @see ConfiguracionPerfiladorUtil
 * @generated
 */
public interface ConfiguracionPerfiladorPersistence extends BasePersistence<ConfiguracionPerfilador> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfiguracionPerfiladorUtil} to access the configuracion perfilador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the configuracion perfilador in the entity cache if it is enabled.
	*
	* @param configuracionPerfilador the configuracion perfilador
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador);

	/**
	* Caches the configuracion perfiladors in the entity cache if it is enabled.
	*
	* @param configuracionPerfiladors the configuracion perfiladors
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> configuracionPerfiladors);

	/**
	* Creates a new configuracion perfilador with the primary key. Does not add the configuracion perfilador to the database.
	*
	* @param idConfiguracionPerfilador the primary key for the new configuracion perfilador
	* @return the new configuracion perfilador
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador create(
		long idConfiguracionPerfilador);

	/**
	* Removes the configuracion perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador that was removed
	* @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador remove(
		long idConfiguracionPerfilador)
		throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.ConfiguracionPerfilador updateImpl(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuracion perfilador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException} if it could not be found.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador
	* @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador findByPrimaryKey(
		long idConfiguracionPerfilador)
		throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuracion perfilador with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador, or <code>null</code> if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador fetchByPrimaryKey(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configuracion perfiladors.
	*
	* @return the configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configuracion perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion perfiladors
	* @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	* @return the range of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configuracion perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion perfiladors
	* @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configuracion perfiladors from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configuracion perfiladors.
	*
	* @return the number of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}