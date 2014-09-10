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
 * This class is a wrapper for {@link AuditoriaPerfiladorLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       AuditoriaPerfiladorLocalService
 * @generated
 */
public class AuditoriaPerfiladorLocalServiceWrapper
	implements AuditoriaPerfiladorLocalService,
		ServiceWrapper<AuditoriaPerfiladorLocalService> {
	public AuditoriaPerfiladorLocalServiceWrapper(
		AuditoriaPerfiladorLocalService auditoriaPerfiladorLocalService) {
		_auditoriaPerfiladorLocalService = auditoriaPerfiladorLocalService;
	}

	/**
	* Adds the auditoria perfilador to the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaPerfilador the auditoria perfilador
	* @return the auditoria perfilador that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador addAuditoriaPerfilador(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.addAuditoriaPerfilador(auditoriaPerfilador);
	}

	/**
	* Creates a new auditoria perfilador with the primary key. Does not add the auditoria perfilador to the database.
	*
	* @param idAuditoriaPer the primary key for the new auditoria perfilador
	* @return the new auditoria perfilador
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador createAuditoriaPerfilador(
		long idAuditoriaPer) {
		return _auditoriaPerfiladorLocalService.createAuditoriaPerfilador(idAuditoriaPer);
	}

	/**
	* Deletes the auditoria perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador that was removed
	* @throws PortalException if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador deleteAuditoriaPerfilador(
		long idAuditoriaPer)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.deleteAuditoriaPerfilador(idAuditoriaPer);
	}

	/**
	* Deletes the auditoria perfilador from the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaPerfilador the auditoria perfilador
	* @return the auditoria perfilador that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador deleteAuditoriaPerfilador(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.deleteAuditoriaPerfilador(auditoriaPerfilador);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditoriaPerfiladorLocalService.dynamicQuery();
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
		return _auditoriaPerfiladorLocalService.dynamicQuery(dynamicQuery);
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
		return _auditoriaPerfiladorLocalService.dynamicQuery(dynamicQuery,
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
		return _auditoriaPerfiladorLocalService.dynamicQuery(dynamicQuery,
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
		return _auditoriaPerfiladorLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.AuditoriaPerfilador fetchAuditoriaPerfilador(
		long idAuditoriaPer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.fetchAuditoriaPerfilador(idAuditoriaPer);
	}

	/**
	* Returns the auditoria perfilador with the primary key.
	*
	* @param idAuditoriaPer the primary key of the auditoria perfilador
	* @return the auditoria perfilador
	* @throws PortalException if a auditoria perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador getAuditoriaPerfilador(
		long idAuditoriaPer)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.getAuditoriaPerfilador(idAuditoriaPer);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the auditoria perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria perfiladors
	* @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	* @return the range of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> getAuditoriaPerfiladors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.getAuditoriaPerfiladors(start,
			end);
	}

	/**
	* Returns the number of auditoria perfiladors.
	*
	* @return the number of auditoria perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public int getAuditoriaPerfiladorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.getAuditoriaPerfiladorsCount();
	}

	/**
	* Updates the auditoria perfilador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaPerfilador the auditoria perfilador
	* @return the auditoria perfilador that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador updateAuditoriaPerfilador(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.updateAuditoriaPerfilador(auditoriaPerfilador);
	}

	/**
	* Updates the auditoria perfilador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaPerfilador the auditoria perfilador
	* @param merge whether to merge the auditoria perfilador with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the auditoria perfilador that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaPerfilador updateAuditoriaPerfilador(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaPerfiladorLocalService.updateAuditoriaPerfilador(auditoriaPerfilador,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _auditoriaPerfiladorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_auditoriaPerfiladorLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _auditoriaPerfiladorLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public com.ext.portlet.halcon.model.AuditoriaPerfilador insert(
		com.ext.portlet.halcon.model.AuditoriaPerfilador perfilador)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _auditoriaPerfiladorLocalService.insert(perfilador);
	}

	public com.ext.portlet.halcon.model.AuditoriaPerfilador getInstance() {
		return _auditoriaPerfiladorLocalService.getInstance();
	}

	public java.lang.Long obtenerListaAuditoriaPerfiladorCount(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboTipoDocumento, java.lang.Integer cboPerfilador,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _auditoriaPerfiladorLocalService.obtenerListaAuditoriaPerfiladorCount(filas,
			pagina, cboTipoDocumento, cboPerfilador, txtFechaInicio, txtFechaFin);
	}

	public java.util.List<com.ext.portlet.halcon.model.AuditoriaPerfilador> obtenerListaAuditoriaPerfilador(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboTipoDocumento, java.lang.Integer cboPerfilador,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _auditoriaPerfiladorLocalService.obtenerListaAuditoriaPerfilador(filas,
			pagina, cboTipoDocumento, cboPerfilador, txtFechaInicio, txtFechaFin);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AuditoriaPerfiladorLocalService getWrappedAuditoriaPerfiladorLocalService() {
		return _auditoriaPerfiladorLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAuditoriaPerfiladorLocalService(
		AuditoriaPerfiladorLocalService auditoriaPerfiladorLocalService) {
		_auditoriaPerfiladorLocalService = auditoriaPerfiladorLocalService;
	}

	public AuditoriaPerfiladorLocalService getWrappedService() {
		return _auditoriaPerfiladorLocalService;
	}

	public void setWrappedService(
		AuditoriaPerfiladorLocalService auditoriaPerfiladorLocalService) {
		_auditoriaPerfiladorLocalService = auditoriaPerfiladorLocalService;
	}

	private AuditoriaPerfiladorLocalService _auditoriaPerfiladorLocalService;
}