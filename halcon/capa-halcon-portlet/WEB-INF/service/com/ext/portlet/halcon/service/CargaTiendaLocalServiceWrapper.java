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
 * This class is a wrapper for {@link CargaTiendaLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CargaTiendaLocalService
 * @generated
 */
public class CargaTiendaLocalServiceWrapper implements CargaTiendaLocalService,
	ServiceWrapper<CargaTiendaLocalService> {
	public CargaTiendaLocalServiceWrapper(
		CargaTiendaLocalService cargaTiendaLocalService) {
		_cargaTiendaLocalService = cargaTiendaLocalService;
	}

	/**
	* Adds the carga tienda to the database. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @return the carga tienda that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda addCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.addCargaTienda(cargaTienda);
	}

	/**
	* Creates a new carga tienda with the primary key. Does not add the carga tienda to the database.
	*
	* @param idCargaTienda the primary key for the new carga tienda
	* @return the new carga tienda
	*/
	public com.ext.portlet.halcon.model.CargaTienda createCargaTienda(
		long idCargaTienda) {
		return _cargaTiendaLocalService.createCargaTienda(idCargaTienda);
	}

	/**
	* Deletes the carga tienda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda that was removed
	* @throws PortalException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda deleteCargaTienda(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.deleteCargaTienda(idCargaTienda);
	}

	/**
	* Deletes the carga tienda from the database. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @return the carga tienda that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda deleteCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.deleteCargaTienda(cargaTienda);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cargaTiendaLocalService.dynamicQuery();
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
		return _cargaTiendaLocalService.dynamicQuery(dynamicQuery);
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
		return _cargaTiendaLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _cargaTiendaLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _cargaTiendaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.CargaTienda fetchCargaTienda(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.fetchCargaTienda(idCargaTienda);
	}

	/**
	* Returns the carga tienda with the primary key.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda
	* @throws PortalException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda getCargaTienda(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.getCargaTienda(idCargaTienda);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the carga tiendas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga tiendas
	* @param end the upper bound of the range of carga tiendas (not inclusive)
	* @return the range of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaTienda> getCargaTiendas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.getCargaTiendas(start, end);
	}

	/**
	* Returns the number of carga tiendas.
	*
	* @return the number of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public int getCargaTiendasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.getCargaTiendasCount();
	}

	/**
	* Updates the carga tienda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @return the carga tienda that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda updateCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.updateCargaTienda(cargaTienda);
	}

	/**
	* Updates the carga tienda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @param merge whether to merge the carga tienda with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the carga tienda that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaTienda updateCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaTiendaLocalService.updateCargaTienda(cargaTienda, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cargaTiendaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cargaTiendaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cargaTiendaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	* inserta una nueva entidad carga tienda
	*/
	public java.lang.Boolean insert(
		java.util.List<com.ext.portlet.halcon.model.CargaTienda> lst)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaTiendaLocalService.insert(lst);
	}

	/**
	* se obtiene la lista de tiendas
	* la cantidad de filas
	* la pagina la cual se encuentra
	*/
	public java.util.List<com.ext.portlet.halcon.model.CargaTienda> obtenerUbicacionMapaTiendas(
		int filas, int page, java.lang.String[] check, java.lang.String distrito)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaTiendaLocalService.obtenerUbicacionMapaTiendas(filas,
			page, check, distrito);
	}

	/**
	* se la cantidad de registros en total
	* la cantidad de filas
	* la pagina la cual se encuentra
	*/
	public java.lang.Long obtenerUbicacionMapaTiendasCount(int filas, int page,
		java.lang.String[] check, java.lang.String distrito)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaTiendaLocalService.obtenerUbicacionMapaTiendasCount(filas,
			page, check, distrito);
	}

	public int truncateCargaTienda()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaTiendaLocalService.truncateCargaTienda();
	}

	public com.ext.portlet.halcon.model.CargaTienda getInstace() {
		return _cargaTiendaLocalService.getInstace();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CargaTiendaLocalService getWrappedCargaTiendaLocalService() {
		return _cargaTiendaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCargaTiendaLocalService(
		CargaTiendaLocalService cargaTiendaLocalService) {
		_cargaTiendaLocalService = cargaTiendaLocalService;
	}

	public CargaTiendaLocalService getWrappedService() {
		return _cargaTiendaLocalService;
	}

	public void setWrappedService(
		CargaTiendaLocalService cargaTiendaLocalService) {
		_cargaTiendaLocalService = cargaTiendaLocalService;
	}

	private CargaTiendaLocalService _cargaTiendaLocalService;
}