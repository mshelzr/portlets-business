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
 * This class is a wrapper for {@link PaisLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       PaisLocalService
 * @generated
 */
public class PaisLocalServiceWrapper implements PaisLocalService,
	ServiceWrapper<PaisLocalService> {
	public PaisLocalServiceWrapper(PaisLocalService paisLocalService) {
		_paisLocalService = paisLocalService;
	}

	/**
	* Adds the pais to the database. Also notifies the appropriate model listeners.
	*
	* @param pais the pais
	* @return the pais that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Pais addPais(
		com.ext.portlet.halcon.model.Pais pais)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.addPais(pais);
	}

	/**
	* Creates a new pais with the primary key. Does not add the pais to the database.
	*
	* @param pais_IdPais the primary key for the new pais
	* @return the new pais
	*/
	public com.ext.portlet.halcon.model.Pais createPais(long pais_IdPais) {
		return _paisLocalService.createPais(pais_IdPais);
	}

	/**
	* Deletes the pais with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param pais_IdPais the primary key of the pais
	* @return the pais that was removed
	* @throws PortalException if a pais with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Pais deletePais(long pais_IdPais)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.deletePais(pais_IdPais);
	}

	/**
	* Deletes the pais from the database. Also notifies the appropriate model listeners.
	*
	* @param pais the pais
	* @return the pais that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Pais deletePais(
		com.ext.portlet.halcon.model.Pais pais)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.deletePais(pais);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _paisLocalService.dynamicQuery();
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
		return _paisLocalService.dynamicQuery(dynamicQuery);
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
		return _paisLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _paisLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _paisLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.Pais fetchPais(long pais_IdPais)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.fetchPais(pais_IdPais);
	}

	/**
	* Returns the pais with the primary key.
	*
	* @param pais_IdPais the primary key of the pais
	* @return the pais
	* @throws PortalException if a pais with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Pais getPais(long pais_IdPais)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.getPais(pais_IdPais);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the paises.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of paises
	* @param end the upper bound of the range of paises (not inclusive)
	* @return the range of paises
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.Pais> getPaises(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.getPaises(start, end);
	}

	/**
	* Returns the number of paises.
	*
	* @return the number of paises
	* @throws SystemException if a system exception occurred
	*/
	public int getPaisesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.getPaisesCount();
	}

	/**
	* Updates the pais in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pais the pais
	* @return the pais that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Pais updatePais(
		com.ext.portlet.halcon.model.Pais pais)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.updatePais(pais);
	}

	/**
	* Updates the pais in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param pais the pais
	* @param merge whether to merge the pais with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the pais that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.Pais updatePais(
		com.ext.portlet.halcon.model.Pais pais, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _paisLocalService.updatePais(pais, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _paisLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_paisLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _paisLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* busqueda de pais segun su codigo
	*/
	public com.ext.portlet.halcon.model.Pais obtenerPaisPorCodigo(
		java.lang.String codigo)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _paisLocalService.obtenerPaisPorCodigo(codigo);
	}

	public java.util.Map<java.lang.String, java.lang.Object> obtenerListaPaises()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _paisLocalService.obtenerListaPaises();
	}

	public java.util.List<com.ext.portlet.halcon.model.Pais> obtenerPaises(
		java.lang.String codigos)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _paisLocalService.obtenerPaises(codigos);
	}

	public java.util.List<com.ext.portlet.halcon.model.Pais> obtenerPais()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _paisLocalService.obtenerPais();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PaisLocalService getWrappedPaisLocalService() {
		return _paisLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPaisLocalService(PaisLocalService paisLocalService) {
		_paisLocalService = paisLocalService;
	}

	public PaisLocalService getWrappedService() {
		return _paisLocalService;
	}

	public void setWrappedService(PaisLocalService paisLocalService) {
		_paisLocalService = paisLocalService;
	}

	private PaisLocalService _paisLocalService;
}