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
 * The utility for the carga socio remesa local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.CargaSocioRemesaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaSocioRemesaLocalService
 * @see com.ext.portlet.halcon.service.base.CargaSocioRemesaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.CargaSocioRemesaLocalServiceImpl
 * @generated
 */
public class CargaSocioRemesaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.CargaSocioRemesaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the carga socio remesa to the database. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @return the carga socio remesa that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa addCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCargaSocioRemesa(cargaSocioRemesa);
	}

	/**
	* Creates a new carga socio remesa with the primary key. Does not add the carga socio remesa to the database.
	*
	* @param idSocioRemesa the primary key for the new carga socio remesa
	* @return the new carga socio remesa
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa createCargaSocioRemesa(
		long idSocioRemesa) {
		return getService().createCargaSocioRemesa(idSocioRemesa);
	}

	/**
	* Deletes the carga socio remesa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa that was removed
	* @throws PortalException if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa deleteCargaSocioRemesa(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargaSocioRemesa(idSocioRemesa);
	}

	/**
	* Deletes the carga socio remesa from the database. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @return the carga socio remesa that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa deleteCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargaSocioRemesa(cargaSocioRemesa);
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

	public static com.ext.portlet.halcon.model.CargaSocioRemesa fetchCargaSocioRemesa(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCargaSocioRemesa(idSocioRemesa);
	}

	/**
	* Returns the carga socio remesa with the primary key.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa
	* @throws PortalException if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa getCargaSocioRemesa(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaSocioRemesa(idSocioRemesa);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the carga socio remesas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga socio remesas
	* @param end the upper bound of the range of carga socio remesas (not inclusive)
	* @return the range of carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> getCargaSocioRemesas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaSocioRemesas(start, end);
	}

	/**
	* Returns the number of carga socio remesas.
	*
	* @return the number of carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public static int getCargaSocioRemesasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaSocioRemesasCount();
	}

	/**
	* Updates the carga socio remesa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @return the carga socio remesa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa updateCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargaSocioRemesa(cargaSocioRemesa);
	}

	/**
	* Updates the carga socio remesa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @param merge whether to merge the carga socio remesa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the carga socio remesa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaSocioRemesa updateCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargaSocioRemesa(cargaSocioRemesa, merge);
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

	public static java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> obtenerCargaSocioRemesa(
		java.lang.String s)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerCargaSocioRemesa(s);
	}

	public static java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> obtenerListaCargaSocioRemesa(
		java.lang.Integer pais, java.lang.String socio)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerListaCargaSocioRemesa(pais, socio);
	}

	public static com.ext.portlet.halcon.model.CargaSocioRemesa insert(
		java.lang.String empresa, java.lang.String paisCobertura,
		java.lang.String paginaweb, java.lang.String telefono)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insert(empresa, paisCobertura, paginaweb, telefono);
	}

	public static int truncateCargaSocioRemesa()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().truncateCargaSocioRemesa();
	}

	public static java.lang.Boolean insert(
		java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> lst)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insert(lst);
	}

	public static com.ext.portlet.halcon.model.CargaSocioRemesa getInstance() {
		return getService().getInstance();
	}

	public static void clearService() {
		_service = null;
	}

	public static CargaSocioRemesaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CargaSocioRemesaLocalService.class.getName());

			if (invokableLocalService instanceof CargaSocioRemesaLocalService) {
				_service = (CargaSocioRemesaLocalService)invokableLocalService;
			}
			else {
				_service = new CargaSocioRemesaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CargaSocioRemesaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CargaSocioRemesaLocalService service) {
	}

	private static CargaSocioRemesaLocalService _service;
}