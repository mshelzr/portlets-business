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
 * This class is a wrapper for {@link CargaSocioRemesaLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CargaSocioRemesaLocalService
 * @generated
 */
public class CargaSocioRemesaLocalServiceWrapper
	implements CargaSocioRemesaLocalService,
		ServiceWrapper<CargaSocioRemesaLocalService> {
	public CargaSocioRemesaLocalServiceWrapper(
		CargaSocioRemesaLocalService cargaSocioRemesaLocalService) {
		_cargaSocioRemesaLocalService = cargaSocioRemesaLocalService;
	}

	/**
	* Adds the carga socio remesa to the database. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @return the carga socio remesa that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa addCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.addCargaSocioRemesa(cargaSocioRemesa);
	}

	/**
	* Creates a new carga socio remesa with the primary key. Does not add the carga socio remesa to the database.
	*
	* @param idSocioRemesa the primary key for the new carga socio remesa
	* @return the new carga socio remesa
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa createCargaSocioRemesa(
		long idSocioRemesa) {
		return _cargaSocioRemesaLocalService.createCargaSocioRemesa(idSocioRemesa);
	}

	/**
	* Deletes the carga socio remesa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa that was removed
	* @throws PortalException if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa deleteCargaSocioRemesa(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.deleteCargaSocioRemesa(idSocioRemesa);
	}

	/**
	* Deletes the carga socio remesa from the database. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @return the carga socio remesa that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa deleteCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.deleteCargaSocioRemesa(cargaSocioRemesa);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cargaSocioRemesaLocalService.dynamicQuery();
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
		return _cargaSocioRemesaLocalService.dynamicQuery(dynamicQuery);
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
		return _cargaSocioRemesaLocalService.dynamicQuery(dynamicQuery, start,
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
		return _cargaSocioRemesaLocalService.dynamicQuery(dynamicQuery, start,
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
		return _cargaSocioRemesaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.CargaSocioRemesa fetchCargaSocioRemesa(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.fetchCargaSocioRemesa(idSocioRemesa);
	}

	/**
	* Returns the carga socio remesa with the primary key.
	*
	* @param idSocioRemesa the primary key of the carga socio remesa
	* @return the carga socio remesa
	* @throws PortalException if a carga socio remesa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa getCargaSocioRemesa(
		long idSocioRemesa)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.getCargaSocioRemesa(idSocioRemesa);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> getCargaSocioRemesas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.getCargaSocioRemesas(start, end);
	}

	/**
	* Returns the number of carga socio remesas.
	*
	* @return the number of carga socio remesas
	* @throws SystemException if a system exception occurred
	*/
	public int getCargaSocioRemesasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.getCargaSocioRemesasCount();
	}

	/**
	* Updates the carga socio remesa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @return the carga socio remesa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa updateCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.updateCargaSocioRemesa(cargaSocioRemesa);
	}

	/**
	* Updates the carga socio remesa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaSocioRemesa the carga socio remesa
	* @param merge whether to merge the carga socio remesa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the carga socio remesa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CargaSocioRemesa updateCargaSocioRemesa(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cargaSocioRemesaLocalService.updateCargaSocioRemesa(cargaSocioRemesa,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _cargaSocioRemesaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cargaSocioRemesaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cargaSocioRemesaLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> obtenerCargaSocioRemesa(
		java.lang.String s)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaSocioRemesaLocalService.obtenerCargaSocioRemesa(s);
	}

	public java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> obtenerListaCargaSocioRemesa(
		java.lang.Integer pais, java.lang.String socio)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaSocioRemesaLocalService.obtenerListaCargaSocioRemesa(pais,
			socio);
	}

	public com.ext.portlet.halcon.model.CargaSocioRemesa insert(
		java.lang.String empresa, java.lang.String paisCobertura,
		java.lang.String paginaweb, java.lang.String telefono)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaSocioRemesaLocalService.insert(empresa, paisCobertura,
			paginaweb, telefono);
	}

	public int truncateCargaSocioRemesa()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaSocioRemesaLocalService.truncateCargaSocioRemesa();
	}

	public java.lang.Boolean insert(
		java.util.List<com.ext.portlet.halcon.model.CargaSocioRemesa> lst)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _cargaSocioRemesaLocalService.insert(lst);
	}

	public com.ext.portlet.halcon.model.CargaSocioRemesa getInstance() {
		return _cargaSocioRemesaLocalService.getInstance();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CargaSocioRemesaLocalService getWrappedCargaSocioRemesaLocalService() {
		return _cargaSocioRemesaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCargaSocioRemesaLocalService(
		CargaSocioRemesaLocalService cargaSocioRemesaLocalService) {
		_cargaSocioRemesaLocalService = cargaSocioRemesaLocalService;
	}

	public CargaSocioRemesaLocalService getWrappedService() {
		return _cargaSocioRemesaLocalService;
	}

	public void setWrappedService(
		CargaSocioRemesaLocalService cargaSocioRemesaLocalService) {
		_cargaSocioRemesaLocalService = cargaSocioRemesaLocalService;
	}

	private CargaSocioRemesaLocalService _cargaSocioRemesaLocalService;
}