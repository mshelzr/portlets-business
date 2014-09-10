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
 * The utility for the ocurrencia local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.OcurrenciaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see OcurrenciaLocalService
 * @see com.ext.portlet.halcon.service.base.OcurrenciaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.OcurrenciaLocalServiceImpl
 * @generated
 */
public class OcurrenciaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.OcurrenciaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ocurrencia to the database. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @return the ocurrencia that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia addOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addOcurrencia(ocurrencia);
	}

	/**
	* Creates a new ocurrencia with the primary key. Does not add the ocurrencia to the database.
	*
	* @param idGestionPeticion the primary key for the new ocurrencia
	* @return the new ocurrencia
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia createOcurrencia(
		long idGestionPeticion) {
		return getService().createOcurrencia(idGestionPeticion);
	}

	/**
	* Deletes the ocurrencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia that was removed
	* @throws PortalException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia deleteOcurrencia(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOcurrencia(idGestionPeticion);
	}

	/**
	* Deletes the ocurrencia from the database. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @return the ocurrencia that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia deleteOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteOcurrencia(ocurrencia);
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

	public static com.ext.portlet.halcon.model.Ocurrencia fetchOcurrencia(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchOcurrencia(idGestionPeticion);
	}

	/**
	* Returns the ocurrencia with the primary key.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia
	* @throws PortalException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia getOcurrencia(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getOcurrencia(idGestionPeticion);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the ocurrencias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of ocurrencias
	* @param end the upper bound of the range of ocurrencias (not inclusive)
	* @return the range of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.Ocurrencia> getOcurrencias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOcurrencias(start, end);
	}

	/**
	* Returns the number of ocurrencias.
	*
	* @return the number of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public static int getOcurrenciasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getOcurrenciasCount();
	}

	/**
	* Updates the ocurrencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @return the ocurrencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia updateOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOcurrencia(ocurrencia);
	}

	/**
	* Updates the ocurrencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @param merge whether to merge the ocurrencia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ocurrencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Ocurrencia updateOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateOcurrencia(ocurrencia, merge);
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

	public static java.util.List<com.ext.portlet.halcon.model.Ocurrencia> obtenerUltimaPeticion(
		java.lang.String ip, java.lang.String codigoProducto,
		java.lang.Integer estado, java.lang.String fecha)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerUltimaPeticion(ip, codigoProducto, estado, fecha);
	}

	public static java.lang.Integer cambiarPeticionEstado(java.lang.Long id,
		java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().cambiarPeticionEstado(id, estado);
	}

	public static com.ext.portlet.halcon.model.Ocurrencia getInstance() {
		return getService().getInstance();
	}

	public static com.ext.portlet.halcon.model.Ocurrencia insertar(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insertar(ocurrencia);
	}

	public static void clearService() {
		_service = null;
	}

	public static OcurrenciaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					OcurrenciaLocalService.class.getName());

			if (invokableLocalService instanceof OcurrenciaLocalService) {
				_service = (OcurrenciaLocalService)invokableLocalService;
			}
			else {
				_service = new OcurrenciaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(OcurrenciaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(OcurrenciaLocalService service) {
	}

	private static OcurrenciaLocalService _service;
}