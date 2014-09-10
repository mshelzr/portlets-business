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

import com.ext.portlet.halcon.model.PreguntaFrecuente;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the pregunta frecuente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see PreguntaFrecuentePersistenceImpl
 * @see PreguntaFrecuenteUtil
 * @generated
 */
public interface PreguntaFrecuentePersistence extends BasePersistence<PreguntaFrecuente> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PreguntaFrecuenteUtil} to access the pregunta frecuente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the pregunta frecuente in the entity cache if it is enabled.
	*
	* @param preguntaFrecuente the pregunta frecuente
	*/
	public void cacheResult(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente);

	/**
	* Caches the pregunta frecuentes in the entity cache if it is enabled.
	*
	* @param preguntaFrecuentes the pregunta frecuentes
	*/
	public void cacheResult(
		java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> preguntaFrecuentes);

	/**
	* Creates a new pregunta frecuente with the primary key. Does not add the pregunta frecuente to the database.
	*
	* @param idPreguntaFrecuente the primary key for the new pregunta frecuente
	* @return the new pregunta frecuente
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente create(
		int idPreguntaFrecuente);

	/**
	* Removes the pregunta frecuente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente that was removed
	* @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente remove(
		int idPreguntaFrecuente)
		throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ext.portlet.halcon.model.PreguntaFrecuente updateImpl(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pregunta frecuente with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException} if it could not be found.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente
	* @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente findByPrimaryKey(
		int idPreguntaFrecuente)
		throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the pregunta frecuente with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente, or <code>null</code> if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente fetchByPrimaryKey(
		int idPreguntaFrecuente)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the pregunta frecuentes.
	*
	* @return the pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the pregunta frecuentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pregunta frecuentes
	* @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	* @return the range of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the pregunta frecuentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pregunta frecuentes
	* @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the pregunta frecuentes from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of pregunta frecuentes.
	*
	* @return the number of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}