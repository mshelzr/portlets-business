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
 * This class is a wrapper for {@link SolicitudContactoLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       SolicitudContactoLocalService
 * @generated
 */
public class SolicitudContactoLocalServiceWrapper
	implements SolicitudContactoLocalService,
		ServiceWrapper<SolicitudContactoLocalService> {
	public SolicitudContactoLocalServiceWrapper(
		SolicitudContactoLocalService solicitudContactoLocalService) {
		_solicitudContactoLocalService = solicitudContactoLocalService;
	}

	/**
	* Adds the solicitud contacto to the database. Also notifies the appropriate model listeners.
	*
	* @param solicitudContacto the solicitud contacto
	* @return the solicitud contacto that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto addSolicitudContacto(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.addSolicitudContacto(solicitudContacto);
	}

	/**
	* Creates a new solicitud contacto with the primary key. Does not add the solicitud contacto to the database.
	*
	* @param idSolicitudContacto the primary key for the new solicitud contacto
	* @return the new solicitud contacto
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto createSolicitudContacto(
		long idSolicitudContacto) {
		return _solicitudContactoLocalService.createSolicitudContacto(idSolicitudContacto);
	}

	/**
	* Deletes the solicitud contacto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSolicitudContacto the primary key of the solicitud contacto
	* @return the solicitud contacto that was removed
	* @throws PortalException if a solicitud contacto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto deleteSolicitudContacto(
		long idSolicitudContacto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.deleteSolicitudContacto(idSolicitudContacto);
	}

	/**
	* Deletes the solicitud contacto from the database. Also notifies the appropriate model listeners.
	*
	* @param solicitudContacto the solicitud contacto
	* @return the solicitud contacto that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto deleteSolicitudContacto(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.deleteSolicitudContacto(solicitudContacto);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _solicitudContactoLocalService.dynamicQuery();
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
		return _solicitudContactoLocalService.dynamicQuery(dynamicQuery);
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
		return _solicitudContactoLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _solicitudContactoLocalService.dynamicQuery(dynamicQuery, start,
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
		return _solicitudContactoLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.SolicitudContacto fetchSolicitudContacto(
		long idSolicitudContacto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.fetchSolicitudContacto(idSolicitudContacto);
	}

	/**
	* Returns the solicitud contacto with the primary key.
	*
	* @param idSolicitudContacto the primary key of the solicitud contacto
	* @return the solicitud contacto
	* @throws PortalException if a solicitud contacto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto getSolicitudContacto(
		long idSolicitudContacto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.getSolicitudContacto(idSolicitudContacto);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the solicitud contactos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud contactos
	* @param end the upper bound of the range of solicitud contactos (not inclusive)
	* @return the range of solicitud contactos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.SolicitudContacto> getSolicitudContactos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.getSolicitudContactos(start, end);
	}

	/**
	* Returns the number of solicitud contactos.
	*
	* @return the number of solicitud contactos
	* @throws SystemException if a system exception occurred
	*/
	public int getSolicitudContactosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.getSolicitudContactosCount();
	}

	/**
	* Updates the solicitud contacto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param solicitudContacto the solicitud contacto
	* @return the solicitud contacto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto updateSolicitudContacto(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.updateSolicitudContacto(solicitudContacto);
	}

	/**
	* Updates the solicitud contacto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param solicitudContacto the solicitud contacto
	* @param merge whether to merge the solicitud contacto with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the solicitud contacto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.SolicitudContacto updateSolicitudContacto(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _solicitudContactoLocalService.updateSolicitudContacto(solicitudContacto,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _solicitudContactoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_solicitudContactoLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _solicitudContactoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public java.lang.Integer insertarSolicitud(
		com.ext.portlet.halcon.model.SolicitudContacto productoBean)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _solicitudContactoLocalService.insertarSolicitud(productoBean);
	}

	public com.ext.portlet.halcon.model.SolicitudContacto getInstance() {
		return _solicitudContactoLocalService.getInstance();
	}

	public java.util.List<java.lang.Object[]> obtenerSolicitud(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.String fechaInicio, java.lang.String fechaFinal)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _solicitudContactoLocalService.obtenerSolicitud(filas, pagina,
			fechaInicio, fechaFinal);
	}

	public java.lang.Integer obtenerSolicitudCount(
		java.lang.String fechaInicio, java.lang.String fechaFinal)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _solicitudContactoLocalService.obtenerSolicitudCount(fechaInicio,
			fechaFinal);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SolicitudContactoLocalService getWrappedSolicitudContactoLocalService() {
		return _solicitudContactoLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSolicitudContactoLocalService(
		SolicitudContactoLocalService solicitudContactoLocalService) {
		_solicitudContactoLocalService = solicitudContactoLocalService;
	}

	public SolicitudContactoLocalService getWrappedService() {
		return _solicitudContactoLocalService;
	}

	public void setWrappedService(
		SolicitudContactoLocalService solicitudContactoLocalService) {
		_solicitudContactoLocalService = solicitudContactoLocalService;
	}

	private SolicitudContactoLocalService _solicitudContactoLocalService;
}