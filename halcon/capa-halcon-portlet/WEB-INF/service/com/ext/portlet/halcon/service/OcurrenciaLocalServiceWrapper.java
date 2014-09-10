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
 * This class is a wrapper for {@link OcurrenciaLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       OcurrenciaLocalService
 * @generated
 */
public class OcurrenciaLocalServiceWrapper implements OcurrenciaLocalService,
	ServiceWrapper<OcurrenciaLocalService> {
	public OcurrenciaLocalServiceWrapper(
		OcurrenciaLocalService ocurrenciaLocalService) {
		_ocurrenciaLocalService = ocurrenciaLocalService;
	}

	/**
	* Adds the ocurrencia to the database. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @return the ocurrencia that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia addOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.addOcurrencia(ocurrencia);
	}

	/**
	* Creates a new ocurrencia with the primary key. Does not add the ocurrencia to the database.
	*
	* @param idGestionPeticion the primary key for the new ocurrencia
	* @return the new ocurrencia
	*/
	public com.ext.portlet.halcon.model.Ocurrencia createOcurrencia(
		long idGestionPeticion) {
		return _ocurrenciaLocalService.createOcurrencia(idGestionPeticion);
	}

	/**
	* Deletes the ocurrencia with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia that was removed
	* @throws PortalException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia deleteOcurrencia(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.deleteOcurrencia(idGestionPeticion);
	}

	/**
	* Deletes the ocurrencia from the database. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @return the ocurrencia that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia deleteOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.deleteOcurrencia(ocurrencia);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ocurrenciaLocalService.dynamicQuery();
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
		return _ocurrenciaLocalService.dynamicQuery(dynamicQuery);
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
		return _ocurrenciaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _ocurrenciaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _ocurrenciaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.Ocurrencia fetchOcurrencia(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.fetchOcurrencia(idGestionPeticion);
	}

	/**
	* Returns the ocurrencia with the primary key.
	*
	* @param idGestionPeticion the primary key of the ocurrencia
	* @return the ocurrencia
	* @throws PortalException if a ocurrencia with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia getOcurrencia(
		long idGestionPeticion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.getOcurrencia(idGestionPeticion);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ext.portlet.halcon.model.Ocurrencia> getOcurrencias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.getOcurrencias(start, end);
	}

	/**
	* Returns the number of ocurrencias.
	*
	* @return the number of ocurrencias
	* @throws SystemException if a system exception occurred
	*/
	public int getOcurrenciasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.getOcurrenciasCount();
	}

	/**
	* Updates the ocurrencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @return the ocurrencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia updateOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.updateOcurrencia(ocurrencia);
	}

	/**
	* Updates the ocurrencia in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ocurrencia the ocurrencia
	* @param merge whether to merge the ocurrencia with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the ocurrencia that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Ocurrencia updateOcurrencia(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ocurrenciaLocalService.updateOcurrencia(ocurrencia, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _ocurrenciaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ocurrenciaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ocurrenciaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.ext.portlet.halcon.model.Ocurrencia> obtenerUltimaPeticion(
		java.lang.String ip, java.lang.String codigoProducto,
		java.lang.Integer estado, java.lang.String fecha)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _ocurrenciaLocalService.obtenerUltimaPeticion(ip,
			codigoProducto, estado, fecha);
	}

	public java.lang.Integer cambiarPeticionEstado(java.lang.Long id,
		java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _ocurrenciaLocalService.cambiarPeticionEstado(id, estado);
	}

	public com.ext.portlet.halcon.model.Ocurrencia getInstance() {
		return _ocurrenciaLocalService.getInstance();
	}

	public com.ext.portlet.halcon.model.Ocurrencia insertar(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _ocurrenciaLocalService.insertar(ocurrencia);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public OcurrenciaLocalService getWrappedOcurrenciaLocalService() {
		return _ocurrenciaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedOcurrenciaLocalService(
		OcurrenciaLocalService ocurrenciaLocalService) {
		_ocurrenciaLocalService = ocurrenciaLocalService;
	}

	public OcurrenciaLocalService getWrappedService() {
		return _ocurrenciaLocalService;
	}

	public void setWrappedService(OcurrenciaLocalService ocurrenciaLocalService) {
		_ocurrenciaLocalService = ocurrenciaLocalService;
	}

	private OcurrenciaLocalService _ocurrenciaLocalService;
}