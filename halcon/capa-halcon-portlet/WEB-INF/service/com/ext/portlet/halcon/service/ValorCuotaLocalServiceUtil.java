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
 * The utility for the valor cuota local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.ValorCuotaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ValorCuotaLocalService
 * @see com.ext.portlet.halcon.service.base.ValorCuotaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.ValorCuotaLocalServiceImpl
 * @generated
 */
public class ValorCuotaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.ValorCuotaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the valor cuota to the database. Also notifies the appropriate model listeners.
	*
	* @param valorCuota the valor cuota
	* @return the valor cuota that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ValorCuota addValorCuota(
		com.ext.portlet.halcon.model.ValorCuota valorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addValorCuota(valorCuota);
	}

	/**
	* Creates a new valor cuota with the primary key. Does not add the valor cuota to the database.
	*
	* @param IdValorCuota the primary key for the new valor cuota
	* @return the new valor cuota
	*/
	public static com.ext.portlet.halcon.model.ValorCuota createValorCuota(
		long IdValorCuota) {
		return getService().createValorCuota(IdValorCuota);
	}

	/**
	* Deletes the valor cuota with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param IdValorCuota the primary key of the valor cuota
	* @return the valor cuota that was removed
	* @throws PortalException if a valor cuota with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ValorCuota deleteValorCuota(
		long IdValorCuota)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteValorCuota(IdValorCuota);
	}

	/**
	* Deletes the valor cuota from the database. Also notifies the appropriate model listeners.
	*
	* @param valorCuota the valor cuota
	* @return the valor cuota that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ValorCuota deleteValorCuota(
		com.ext.portlet.halcon.model.ValorCuota valorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteValorCuota(valorCuota);
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

	public static com.ext.portlet.halcon.model.ValorCuota fetchValorCuota(
		long IdValorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchValorCuota(IdValorCuota);
	}

	/**
	* Returns the valor cuota with the primary key.
	*
	* @param IdValorCuota the primary key of the valor cuota
	* @return the valor cuota
	* @throws PortalException if a valor cuota with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ValorCuota getValorCuota(
		long IdValorCuota)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getValorCuota(IdValorCuota);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the valor cuotas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of valor cuotas
	* @param end the upper bound of the range of valor cuotas (not inclusive)
	* @return the range of valor cuotas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ValorCuota> getValorCuotas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getValorCuotas(start, end);
	}

	/**
	* Returns the number of valor cuotas.
	*
	* @return the number of valor cuotas
	* @throws SystemException if a system exception occurred
	*/
	public static int getValorCuotasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getValorCuotasCount();
	}

	/**
	* Updates the valor cuota in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param valorCuota the valor cuota
	* @return the valor cuota that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ValorCuota updateValorCuota(
		com.ext.portlet.halcon.model.ValorCuota valorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateValorCuota(valorCuota);
	}

	/**
	* Updates the valor cuota in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param valorCuota the valor cuota
	* @param merge whether to merge the valor cuota with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the valor cuota that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ValorCuota updateValorCuota(
		com.ext.portlet.halcon.model.ValorCuota valorCuota, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateValorCuota(valorCuota, merge);
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

	public static void clearService() {
		_service = null;
	}

	public static ValorCuotaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ValorCuotaLocalService.class.getName());

			if (invokableLocalService instanceof ValorCuotaLocalService) {
				_service = (ValorCuotaLocalService)invokableLocalService;
			}
			else {
				_service = new ValorCuotaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ValorCuotaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ValorCuotaLocalService service) {
	}

	private static ValorCuotaLocalService _service;
}