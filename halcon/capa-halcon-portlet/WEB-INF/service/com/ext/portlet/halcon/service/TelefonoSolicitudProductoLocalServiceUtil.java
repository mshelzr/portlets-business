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
 * The utility for the telefono solicitud producto local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.TelefonoSolicitudProductoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see TelefonoSolicitudProductoLocalService
 * @see com.ext.portlet.halcon.service.base.TelefonoSolicitudProductoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.TelefonoSolicitudProductoLocalServiceImpl
 * @generated
 */
public class TelefonoSolicitudProductoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.TelefonoSolicitudProductoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the telefono solicitud producto to the database. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @return the telefono solicitud producto that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto addTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addTelefonoSolicitudProducto(telefonoSolicitudProducto);
	}

	/**
	* Creates a new telefono solicitud producto with the primary key. Does not add the telefono solicitud producto to the database.
	*
	* @param idTelefSolicitudProducto the primary key for the new telefono solicitud producto
	* @return the new telefono solicitud producto
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto createTelefonoSolicitudProducto(
		long idTelefSolicitudProducto) {
		return getService()
				   .createTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Deletes the telefono solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto that was removed
	* @throws PortalException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto deleteTelefonoSolicitudProducto(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Deletes the telefono solicitud producto from the database. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @return the telefono solicitud producto that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto deleteTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteTelefonoSolicitudProducto(telefonoSolicitudProducto);
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

	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto fetchTelefonoSolicitudProducto(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Returns the telefono solicitud producto with the primary key.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto
	* @throws PortalException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto getTelefonoSolicitudProducto(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the telefono solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of telefono solicitud productos
	* @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	* @return the range of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> getTelefonoSolicitudProductos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonoSolicitudProductos(start, end);
	}

	/**
	* Returns the number of telefono solicitud productos.
	*
	* @return the number of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static int getTelefonoSolicitudProductosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTelefonoSolicitudProductosCount();
	}

	/**
	* Updates the telefono solicitud producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @return the telefono solicitud producto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto updateTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTelefonoSolicitudProducto(telefonoSolicitudProducto);
	}

	/**
	* Updates the telefono solicitud producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @param merge whether to merge the telefono solicitud producto with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the telefono solicitud producto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto updateTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateTelefonoSolicitudProducto(telefonoSolicitudProducto,
			merge);
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

	public static TelefonoSolicitudProductoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TelefonoSolicitudProductoLocalService.class.getName());

			if (invokableLocalService instanceof TelefonoSolicitudProductoLocalService) {
				_service = (TelefonoSolicitudProductoLocalService)invokableLocalService;
			}
			else {
				_service = new TelefonoSolicitudProductoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TelefonoSolicitudProductoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(TelefonoSolicitudProductoLocalService service) {
	}

	private static TelefonoSolicitudProductoLocalService _service;
}