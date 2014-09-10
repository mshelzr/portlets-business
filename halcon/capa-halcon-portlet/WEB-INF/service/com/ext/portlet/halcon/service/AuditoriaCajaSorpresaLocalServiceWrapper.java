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
 * This class is a wrapper for {@link AuditoriaCajaSorpresaLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       AuditoriaCajaSorpresaLocalService
 * @generated
 */
public class AuditoriaCajaSorpresaLocalServiceWrapper
	implements AuditoriaCajaSorpresaLocalService,
		ServiceWrapper<AuditoriaCajaSorpresaLocalService> {
	public AuditoriaCajaSorpresaLocalServiceWrapper(
		AuditoriaCajaSorpresaLocalService auditoriaCajaSorpresaLocalService) {
		_auditoriaCajaSorpresaLocalService = auditoriaCajaSorpresaLocalService;
	}

	/**
	* Adds the auditoria caja sorpresa to the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa addAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.addAuditoriaCajaSorpresa(auditoriaCajaSorpresa);
	}

	/**
	* Creates a new auditoria caja sorpresa with the primary key. Does not add the auditoria caja sorpresa to the database.
	*
	* @param idAuditoriaCajSorp the primary key for the new auditoria caja sorpresa
	* @return the new auditoria caja sorpresa
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa createAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp) {
		return _auditoriaCajaSorpresaLocalService.createAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	/**
	* Deletes the auditoria caja sorpresa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was removed
	* @throws PortalException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa deleteAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.deleteAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	/**
	* Deletes the auditoria caja sorpresa from the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa deleteAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.deleteAuditoriaCajaSorpresa(auditoriaCajaSorpresa);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _auditoriaCajaSorpresaLocalService.dynamicQuery();
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
		return _auditoriaCajaSorpresaLocalService.dynamicQuery(dynamicQuery);
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
		return _auditoriaCajaSorpresaLocalService.dynamicQuery(dynamicQuery,
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
		return _auditoriaCajaSorpresaLocalService.dynamicQuery(dynamicQuery,
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
		return _auditoriaCajaSorpresaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa fetchAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.fetchAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	/**
	* Returns the auditoria caja sorpresa with the primary key.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa
	* @throws PortalException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa getAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.getAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the auditoria caja sorpresas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of auditoria caja sorpresas
	* @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	* @return the range of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> getAuditoriaCajaSorpresas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.getAuditoriaCajaSorpresas(start,
			end);
	}

	/**
	* Returns the number of auditoria caja sorpresas.
	*
	* @return the number of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public int getAuditoriaCajaSorpresasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.getAuditoriaCajaSorpresasCount();
	}

	/**
	* Updates the auditoria caja sorpresa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa updateAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.updateAuditoriaCajaSorpresa(auditoriaCajaSorpresa);
	}

	/**
	* Updates the auditoria caja sorpresa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @param merge whether to merge the auditoria caja sorpresa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the auditoria caja sorpresa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa updateAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _auditoriaCajaSorpresaLocalService.updateAuditoriaCajaSorpresa(auditoriaCajaSorpresa,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _auditoriaCajaSorpresaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_auditoriaCajaSorpresaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _auditoriaCajaSorpresaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* Se obtiene la cantidad maxima de registros segun la consulta
	*
	* @throws BusinessException
	*/
	public java.lang.Long obtenerListaCajaSorpresaCount(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboTipoDocumento, java.lang.String producto,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _auditoriaCajaSorpresaLocalService.obtenerListaCajaSorpresaCount(filas,
			pagina, cboTipoDocumento, producto, txtFechaInicio, txtFechaFin);
	}

	/**
	* Se obtiene los registros del reporte de caja sorpresa.
	*
	* @throws BusinessException
	*/
	public java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> obtenerListaAuditoriaCajaSorpresa(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboTipoDocumento, java.lang.String producto,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _auditoriaCajaSorpresaLocalService.obtenerListaAuditoriaCajaSorpresa(filas,
			pagina, cboTipoDocumento, producto, txtFechaInicio, txtFechaFin);
	}

	public java.lang.Boolean insert(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa bean)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _auditoriaCajaSorpresaLocalService.insert(bean);
	}

	public com.ext.portlet.halcon.model.AuditoriaCajaSorpresa getInstace() {
		return _auditoriaCajaSorpresaLocalService.getInstace();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public AuditoriaCajaSorpresaLocalService getWrappedAuditoriaCajaSorpresaLocalService() {
		return _auditoriaCajaSorpresaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedAuditoriaCajaSorpresaLocalService(
		AuditoriaCajaSorpresaLocalService auditoriaCajaSorpresaLocalService) {
		_auditoriaCajaSorpresaLocalService = auditoriaCajaSorpresaLocalService;
	}

	public AuditoriaCajaSorpresaLocalService getWrappedService() {
		return _auditoriaCajaSorpresaLocalService;
	}

	public void setWrappedService(
		AuditoriaCajaSorpresaLocalService auditoriaCajaSorpresaLocalService) {
		_auditoriaCajaSorpresaLocalService = auditoriaCajaSorpresaLocalService;
	}

	private AuditoriaCajaSorpresaLocalService _auditoriaCajaSorpresaLocalService;
}