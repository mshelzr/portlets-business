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
 * This class is a wrapper for {@link FondosMutuosLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       FondosMutuosLocalService
 * @generated
 */
public class FondosMutuosLocalServiceWrapper implements FondosMutuosLocalService,
	ServiceWrapper<FondosMutuosLocalService> {
	public FondosMutuosLocalServiceWrapper(
		FondosMutuosLocalService fondosMutuosLocalService) {
		_fondosMutuosLocalService = fondosMutuosLocalService;
	}

	/**
	* Adds the fondos mutuos to the database. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @return the fondos mutuos that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuos addFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.addFondosMutuos(fondosMutuos);
	}

	/**
	* Creates a new fondos mutuos with the primary key. Does not add the fondos mutuos to the database.
	*
	* @param idValorCuota the primary key for the new fondos mutuos
	* @return the new fondos mutuos
	*/
	public com.ext.portlet.halcon.model.FondosMutuos createFondosMutuos(
		long idValorCuota) {
		return _fondosMutuosLocalService.createFondosMutuos(idValorCuota);
	}

	/**
	* Deletes the fondos mutuos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos that was removed
	* @throws PortalException if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuos deleteFondosMutuos(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.deleteFondosMutuos(idValorCuota);
	}

	/**
	* Deletes the fondos mutuos from the database. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @return the fondos mutuos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuos deleteFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.deleteFondosMutuos(fondosMutuos);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fondosMutuosLocalService.dynamicQuery();
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
		return _fondosMutuosLocalService.dynamicQuery(dynamicQuery);
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
		return _fondosMutuosLocalService.dynamicQuery(dynamicQuery, start, end);
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
		return _fondosMutuosLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _fondosMutuosLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.FondosMutuos fetchFondosMutuos(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.fetchFondosMutuos(idValorCuota);
	}

	/**
	* Returns the fondos mutuos with the primary key.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos
	* @throws PortalException if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuos getFondosMutuos(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.getFondosMutuos(idValorCuota);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fondos mutuoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuoses
	* @param end the upper bound of the range of fondos mutuoses (not inclusive)
	* @return the range of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.FondosMutuos> getFondosMutuoses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.getFondosMutuoses(start, end);
	}

	/**
	* Returns the number of fondos mutuoses.
	*
	* @return the number of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public int getFondosMutuosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.getFondosMutuosesCount();
	}

	/**
	* Updates the fondos mutuos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @return the fondos mutuos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuos updateFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.updateFondosMutuos(fondosMutuos);
	}

	/**
	* Updates the fondos mutuos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @param merge whether to merge the fondos mutuos with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the fondos mutuos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.FondosMutuos updateFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fondosMutuosLocalService.updateFondosMutuos(fondosMutuos, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _fondosMutuosLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_fondosMutuosLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _fondosMutuosLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	public com.ext.portlet.halcon.model.Parametro obtenerFondoMutuoZona(
		java.lang.Integer puntaje, java.lang.String moneda,
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.obtenerFondoMutuoZona(puntaje, moneda,
			etiqueta);
	}

	public java.util.List<com.ext.portlet.halcon.model.Parametro> ListarPlazozFondoMutuo(
		java.lang.String valor)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.ListarPlazozFondoMutuo(valor);
	}

	public java.util.List<com.ext.portlet.halcon.model.FondosMutuos> ListarFondoMutuo(
		java.lang.String moneda, java.util.List<java.lang.String> fechas,
		java.lang.String tipoFondo)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.ListarFondoMutuo(moneda, fechas,
			tipoFondo);
	}

	public java.lang.Boolean insertarFondoMutuo(
		java.util.List<com.ext.portlet.halcon.model.FondosMutuos> lstBeans)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.insertarFondoMutuo(lstBeans);
	}

	public com.ext.portlet.halcon.model.FondosMutuos consultarUltimaFecha()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.consultarUltimaFecha();
	}

	public java.util.List<com.ext.portlet.halcon.model.Parametro> consultarFondoMutuoTipos(
		java.lang.Integer puntaje, java.lang.String moneda,
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.consultarFondoMutuoTipos(puntaje,
			moneda, etiqueta);
	}

	public com.ext.portlet.halcon.model.Parametro obtenerFondosMutuosPuntos(
		java.lang.String numeroDias, java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.obtenerFondosMutuosPuntos(numeroDias,
			etiqueta);
	}

	public java.util.List<java.lang.Object[]> consultarFondosMutuosParte(
		java.lang.String moneda, java.lang.String fondo1,
		java.lang.String fondo2, java.lang.String fondo3,
		java.lang.Integer dias, java.util.List<java.lang.String> lista)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.consultarFondosMutuosParte(moneda,
			fondo1, fondo2, fondo3, dias, lista);
	}

	public com.ext.portlet.halcon.model.Parametro consultarDiasDesdeIdentificadorSlider(
		java.lang.String etiqueta, java.lang.String periodo)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _fondosMutuosLocalService.consultarDiasDesdeIdentificadorSlider(etiqueta,
			periodo);
	}

	public com.ext.portlet.halcon.model.FondosMutuos getInstance() {
		return _fondosMutuosLocalService.getInstance();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public FondosMutuosLocalService getWrappedFondosMutuosLocalService() {
		return _fondosMutuosLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedFondosMutuosLocalService(
		FondosMutuosLocalService fondosMutuosLocalService) {
		_fondosMutuosLocalService = fondosMutuosLocalService;
	}

	public FondosMutuosLocalService getWrappedService() {
		return _fondosMutuosLocalService;
	}

	public void setWrappedService(
		FondosMutuosLocalService fondosMutuosLocalService) {
		_fondosMutuosLocalService = fondosMutuosLocalService;
	}

	private FondosMutuosLocalService _fondosMutuosLocalService;
}