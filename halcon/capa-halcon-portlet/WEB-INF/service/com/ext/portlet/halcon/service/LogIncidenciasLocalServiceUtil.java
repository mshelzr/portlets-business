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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the log incidencias local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.LogIncidenciasLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see LogIncidenciasLocalService
 * @see com.ext.portlet.halcon.service.base.LogIncidenciasLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.LogIncidenciasLocalServiceImpl
 * @generated
 */
public class LogIncidenciasLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.LogIncidenciasLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the log incidencias to the database. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @return the log incidencias that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias addLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addLogIncidencias(logIncidencias);
	}

	/**
	* Creates a new log incidencias with the primary key. Does not add the log incidencias to the database.
	*
	* @param idError the primary key for the new log incidencias
	* @return the new log incidencias
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias createLogIncidencias(
		long idError) {
		return getService().createLogIncidencias(idError);
	}

	/**
	* Deletes the log incidencias with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias that was removed
	* @throws PortalException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias deleteLogIncidencias(
		long idError)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLogIncidencias(idError);
	}

	/**
	* Deletes the log incidencias from the database. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @return the log incidencias that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias deleteLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLogIncidencias(logIncidencias);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.ext.portlet.halcon.model.LogIncidencias fetchLogIncidencias(
		long idError)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchLogIncidencias(idError);
	}

	/**
	* Returns the log incidencias with the primary key.
	*
	* @param idError the primary key of the log incidencias
	* @return the log incidencias
	* @throws PortalException if a log incidencias with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias getLogIncidencias(
		long idError)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLogIncidencias(idError);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ext.portlet.halcon.model.LogIncidencias> getLogIncidenciases(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLogIncidenciases(start, end);
	}

	/**
	* Returns the number of log incidenciases.
	*
	* @return the number of log incidenciases
	* @throws SystemException if a system exception occurred
	*/
	public static int getLogIncidenciasesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLogIncidenciasesCount();
	}

	/**
	* Updates the log incidencias in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @return the log incidencias that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias updateLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLogIncidencias(logIncidencias);
	}

	/**
	* Updates the log incidencias in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param logIncidencias the log incidencias
	* @param merge whether to merge the log incidencias with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the log incidencias that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.LogIncidencias updateLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLogIncidencias(logIncidencias, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.ext.portlet.halcon.model.LogIncidencias insertarLogIncidencias(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insertarLogIncidencias(logIncidencias);
	}

	public static com.ext.portlet.halcon.model.LogIncidencias getInstance() {
		return getService().getInstance();
	}

	public static void clearService() {
		_service = null;
	}

	public static LogIncidenciasLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LogIncidenciasLocalService.class.getName());

			if (invokableLocalService instanceof LogIncidenciasLocalService) {
				_service = (LogIncidenciasLocalService)invokableLocalService;
			}
			else {
				_service = new LogIncidenciasLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(LogIncidenciasLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LogIncidenciasLocalService service) {
	}

	private static LogIncidenciasLocalService _service;
}