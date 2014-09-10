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
 * The utility for the fondos mutuos zonas local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.FondosMutuosZonasLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosZonasLocalService
 * @see com.ext.portlet.halcon.service.base.FondosMutuosZonasLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.FondosMutuosZonasLocalServiceImpl
 * @generated
 */
public class FondosMutuosZonasLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.FondosMutuosZonasLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fondos mutuos zonas to the database. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuosZonas the fondos mutuos zonas
	* @return the fondos mutuos zonas that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas addFondosMutuosZonas(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFondosMutuosZonas(fondosMutuosZonas);
	}

	/**
	* Creates a new fondos mutuos zonas with the primary key. Does not add the fondos mutuos zonas to the database.
	*
	* @param idFondoMutuoZona the primary key for the new fondos mutuos zonas
	* @return the new fondos mutuos zonas
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas createFondosMutuosZonas(
		long idFondoMutuoZona) {
		return getService().createFondosMutuosZonas(idFondoMutuoZona);
	}

	/**
	* Deletes the fondos mutuos zonas with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas that was removed
	* @throws PortalException if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas deleteFondosMutuosZonas(
		long idFondoMutuoZona)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFondosMutuosZonas(idFondoMutuoZona);
	}

	/**
	* Deletes the fondos mutuos zonas from the database. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuosZonas the fondos mutuos zonas
	* @return the fondos mutuos zonas that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas deleteFondosMutuosZonas(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFondosMutuosZonas(fondosMutuosZonas);
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

	public static com.ext.portlet.halcon.model.FondosMutuosZonas fetchFondosMutuosZonas(
		long idFondoMutuoZona)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFondosMutuosZonas(idFondoMutuoZona);
	}

	/**
	* Returns the fondos mutuos zonas with the primary key.
	*
	* @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	* @return the fondos mutuos zonas
	* @throws PortalException if a fondos mutuos zonas with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas getFondosMutuosZonas(
		long idFondoMutuoZona)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFondosMutuosZonas(idFondoMutuoZona);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fondos mutuos zonases.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuos zonases
	* @param end the upper bound of the range of fondos mutuos zonases (not inclusive)
	* @return the range of fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuosZonas> getFondosMutuosZonases(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFondosMutuosZonases(start, end);
	}

	/**
	* Returns the number of fondos mutuos zonases.
	*
	* @return the number of fondos mutuos zonases
	* @throws SystemException if a system exception occurred
	*/
	public static int getFondosMutuosZonasesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFondosMutuosZonasesCount();
	}

	/**
	* Updates the fondos mutuos zonas in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuosZonas the fondos mutuos zonas
	* @return the fondos mutuos zonas that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas updateFondosMutuosZonas(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFondosMutuosZonas(fondosMutuosZonas);
	}

	/**
	* Updates the fondos mutuos zonas in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuosZonas the fondos mutuos zonas
	* @param merge whether to merge the fondos mutuos zonas with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the fondos mutuos zonas that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuosZonas updateFondosMutuosZonas(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFondosMutuosZonas(fondosMutuosZonas, merge);
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

	public static com.ext.portlet.halcon.model.FondosMutuosZonas getInstance() {
		return getService().getInstance();
	}

	public static void clearService() {
		_service = null;
	}

	public static FondosMutuosZonasLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FondosMutuosZonasLocalService.class.getName());

			if (invokableLocalService instanceof FondosMutuosZonasLocalService) {
				_service = (FondosMutuosZonasLocalService)invokableLocalService;
			}
			else {
				_service = new FondosMutuosZonasLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FondosMutuosZonasLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(FondosMutuosZonasLocalService service) {
	}

	private static FondosMutuosZonasLocalService _service;
}