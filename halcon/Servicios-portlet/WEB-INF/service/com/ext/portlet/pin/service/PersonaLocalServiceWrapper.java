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

package com.ext.portlet.pin.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link PersonaLocalService}.
 * </p>
 *
 * @author    arodriguez
 * @see       PersonaLocalService
 * @generated
 */
public class PersonaLocalServiceWrapper implements PersonaLocalService,
	ServiceWrapper<PersonaLocalService> {
	public PersonaLocalServiceWrapper(PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	/**
	* Adds the persona to the database. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @return the persona that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona addPersona(
		com.ext.portlet.pin.model.Persona persona)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.addPersona(persona);
	}

	/**
	* Creates a new persona with the primary key. Does not add the persona to the database.
	*
	* @param userId the primary key for the new persona
	* @return the new persona
	*/
	public com.ext.portlet.pin.model.Persona createPersona(long userId) {
		return _personaLocalService.createPersona(userId);
	}

	/**
	* Deletes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the persona
	* @return the persona that was removed
	* @throws PortalException if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona deletePersona(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.deletePersona(userId);
	}

	/**
	* Deletes the persona from the database. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @return the persona that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona deletePersona(
		com.ext.portlet.pin.model.Persona persona)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.deletePersona(persona);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _personaLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.pin.model.Persona fetchPersona(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.fetchPersona(userId);
	}

	/**
	* Returns the persona with the primary key.
	*
	* @param userId the primary key of the persona
	* @return the persona
	* @throws PortalException if a persona with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona getPersona(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.getPersona(userId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the personas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of personas
	* @param end the upper bound of the range of personas (not inclusive)
	* @return the range of personas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.pin.model.Persona> getPersonas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.getPersonas(start, end);
	}

	/**
	* Returns the number of personas.
	*
	* @return the number of personas
	* @throws SystemException if a system exception occurred
	*/
	public int getPersonasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.getPersonasCount();
	}

	/**
	* Updates the persona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @return the persona that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona updatePersona(
		com.ext.portlet.pin.model.Persona persona)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.updatePersona(persona);
	}

	/**
	* Updates the persona in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param persona the persona
	* @param merge whether to merge the persona with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the persona that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.pin.model.Persona updatePersona(
		com.ext.portlet.pin.model.Persona persona, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaLocalService.updatePersona(persona, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _personaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_personaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _personaLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	public java.lang.String getNombre(long personaID) {
		return _personaLocalService.getNombre(personaID);
	}

	public java.lang.String getApellidos(long personaID) {
		return _personaLocalService.getApellidos(personaID);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PersonaLocalService getWrappedPersonaLocalService() {
		return _personaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPersonaLocalService(
		PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	public PersonaLocalService getWrappedService() {
		return _personaLocalService;
	}

	public void setWrappedService(PersonaLocalService personaLocalService) {
		_personaLocalService = personaLocalService;
	}

	private PersonaLocalService _personaLocalService;
}