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
 * This class is a wrapper for {@link TelefonoSolicitudProductoLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       TelefonoSolicitudProductoLocalService
 * @generated
 */
public class TelefonoSolicitudProductoLocalServiceWrapper
	implements TelefonoSolicitudProductoLocalService,
		ServiceWrapper<TelefonoSolicitudProductoLocalService> {
	public TelefonoSolicitudProductoLocalServiceWrapper(
		TelefonoSolicitudProductoLocalService telefonoSolicitudProductoLocalService) {
		_telefonoSolicitudProductoLocalService = telefonoSolicitudProductoLocalService;
	}

	/**
	* Adds the telefono solicitud producto to the database. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @return the telefono solicitud producto that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto addTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.addTelefonoSolicitudProducto(telefonoSolicitudProducto);
	}

	/**
	* Creates a new telefono solicitud producto with the primary key. Does not add the telefono solicitud producto to the database.
	*
	* @param idTelefSolicitudProducto the primary key for the new telefono solicitud producto
	* @return the new telefono solicitud producto
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto createTelefonoSolicitudProducto(
		long idTelefSolicitudProducto) {
		return _telefonoSolicitudProductoLocalService.createTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Deletes the telefono solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto that was removed
	* @throws PortalException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto deleteTelefonoSolicitudProducto(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.deleteTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Deletes the telefono solicitud producto from the database. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @return the telefono solicitud producto that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto deleteTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.deleteTelefonoSolicitudProducto(telefonoSolicitudProducto);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _telefonoSolicitudProductoLocalService.dynamicQuery();
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
		return _telefonoSolicitudProductoLocalService.dynamicQuery(dynamicQuery);
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
		return _telefonoSolicitudProductoLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
		return _telefonoSolicitudProductoLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _telefonoSolicitudProductoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto fetchTelefonoSolicitudProducto(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.fetchTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	/**
	* Returns the telefono solicitud producto with the primary key.
	*
	* @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	* @return the telefono solicitud producto
	* @throws PortalException if a telefono solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto getTelefonoSolicitudProducto(
		long idTelefSolicitudProducto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.getTelefonoSolicitudProducto(idTelefSolicitudProducto);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> getTelefonoSolicitudProductos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.getTelefonoSolicitudProductos(start,
			end);
	}

	/**
	* Returns the number of telefono solicitud productos.
	*
	* @return the number of telefono solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public int getTelefonoSolicitudProductosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.getTelefonoSolicitudProductosCount();
	}

	/**
	* Updates the telefono solicitud producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @return the telefono solicitud producto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto updateTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.updateTelefonoSolicitudProducto(telefonoSolicitudProducto);
	}

	/**
	* Updates the telefono solicitud producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param telefonoSolicitudProducto the telefono solicitud producto
	* @param merge whether to merge the telefono solicitud producto with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the telefono solicitud producto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.TelefonoSolicitudProducto updateTelefonoSolicitudProducto(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _telefonoSolicitudProductoLocalService.updateTelefonoSolicitudProducto(telefonoSolicitudProducto,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _telefonoSolicitudProductoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_telefonoSolicitudProductoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _telefonoSolicitudProductoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public TelefonoSolicitudProductoLocalService getWrappedTelefonoSolicitudProductoLocalService() {
		return _telefonoSolicitudProductoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedTelefonoSolicitudProductoLocalService(
		TelefonoSolicitudProductoLocalService telefonoSolicitudProductoLocalService) {
		_telefonoSolicitudProductoLocalService = telefonoSolicitudProductoLocalService;
	}

	public TelefonoSolicitudProductoLocalService getWrappedService() {
		return _telefonoSolicitudProductoLocalService;
	}

	public void setWrappedService(
		TelefonoSolicitudProductoLocalService telefonoSolicitudProductoLocalService) {
		_telefonoSolicitudProductoLocalService = telefonoSolicitudProductoLocalService;
	}

	private TelefonoSolicitudProductoLocalService _telefonoSolicitudProductoLocalService;
}