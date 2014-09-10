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

package com.ext.portlet.halcon.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LogIncidenciasLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       LogIncidenciasLocalService
 * @generated
 */
public class LogIncidenciasLocalServiceWrapper
	implements LogIncidenciasLocalService,
		ServiceWrapper<LogIncidenciasLocalService> {
	public LogIncidenciasLocalServiceWrapper(
		LogIncidenciasLocalService logIncidenciasLocalService) {
		_logIncidenciasLocalService = logIncidenciasLocalService;
	}

	/**
	* Adds the log incidencias to the database. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @return the log incidencias that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias addLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.addLogIncidencias(logIncidencias);
	}

	/**
	* Creates a new log incidencias with the primary key. Does not add the log incidencias to the database.
	*
	* @param idError the primary key for the new log incidencias
	* @return the new log incidencias
	*/
	public com.ext.portlet.halcon.model.LogIncidencias createLogIncidencias(
		long idError) {
		return _logIncidenciasLocalService.createLogIncidencias(idError);
	}

	/**
	* Deletes the log incidencias with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias that was removed
	* @throws PortalException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias deleteLogIncidencias(
		long idError)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.deleteLogIncidencias(idError);
	}

	/**
	* Deletes the log incidencias from the database. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @return the log incidencias that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias deleteLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.deleteLogIncidencias(logIncidencias);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _logIncidenciasLocalService.dynamicQuery();
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
		return _logIncidenciasLocalService.dynamicQuery(dynamicQuery);
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
		return _logIncidenciasLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _logIncidenciasLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _logIncidenciasLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.LogIncidencias fetchLogIncidencias(
		long idError)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.fetchLogIncidencias(idError);
	}

	/**
	* Returns the log incidencias with the primary key.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias
	* @throws PortalException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias getLogIncidencias(
		long idError)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.getLogIncidencias(idError);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the log incidenciases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of log incidenciases
	* @param end the upper bound of the range of log incidenciases (not inclusive)
	* @return the range of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.LogIncidencias> getLogIncidenciases(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.getLogIncidenciases(start, end);
	}

	/**
	* Returns the number of log incidenciases.
	*
	* @return the number of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public int getLogIncidenciasesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.getLogIncidenciasesCount();
	}

	/**
	* Updates the log incidencias in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @return the log incidencias that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias updateLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.updateLogIncidencias(logIncidencias);
	}

	/**
	* Updates the log incidencias in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @param merge whether to merge the log incidencias with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the log incidencias that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.LogIncidencias updateLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logIncidenciasLocalService.updateLogIncidencias(logIncidencias,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _logIncidenciasLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_logIncidenciasLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _logIncidenciasLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.ext.portlet.halcon.model.LogIncidencias insertarLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _logIncidenciasLocalService.insertarLogIncidencias(logIncidencias);
	}

	public com.ext.portlet.halcon.model.LogIncidencias getInstance() {
		return _logIncidenciasLocalService.getInstance();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LogIncidenciasLocalService getWrappedLogIncidenciasLocalService() {
		return _logIncidenciasLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLogIncidenciasLocalService(
		LogIncidenciasLocalService logIncidenciasLocalService) {
		_logIncidenciasLocalService = logIncidenciasLocalService;
	}

	public LogIncidenciasLocalService getWrappedService() {
		return _logIncidenciasLocalService;
	}

	public void setWrappedService(
		LogIncidenciasLocalService logIncidenciasLocalService) {
		_logIncidenciasLocalService = logIncidenciasLocalService;
	}

	private LogIncidenciasLocalService _logIncidenciasLocalService;
}