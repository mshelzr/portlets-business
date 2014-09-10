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
 * The utility for the auditoria caja sorpresa local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.AuditoriaCajaSorpresaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresaLocalService
 * @see com.ext.portlet.halcon.service.base.AuditoriaCajaSorpresaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.AuditoriaCajaSorpresaLocalServiceImpl
 * @generated
 */
public class AuditoriaCajaSorpresaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.AuditoriaCajaSorpresaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the auditoria caja sorpresa to the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa addAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAuditoriaCajaSorpresa(auditoriaCajaSorpresa);
	}

	/**
	* Creates a new auditoria caja sorpresa with the primary key. Does not add the auditoria caja sorpresa to the database.
	*
	* @param idAuditoriaCajSorp the primary key for the new auditoria caja sorpresa
	* @return the new auditoria caja sorpresa
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa createAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp) {
		return getService().createAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	/**
	* Deletes the auditoria caja sorpresa with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was removed
	* @throws PortalException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa deleteAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	/**
	* Deletes the auditoria caja sorpresa from the database. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa deleteAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteAuditoriaCajaSorpresa(auditoriaCajaSorpresa);
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

	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa fetchAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	/**
	* Returns the auditoria caja sorpresa with the primary key.
	*
	* @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	* @return the auditoria caja sorpresa
	* @throws PortalException if a auditoria caja sorpresa with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa getAuditoriaCajaSorpresa(
		long idAuditoriaCajSorp)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuditoriaCajaSorpresa(idAuditoriaCajSorp);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> getAuditoriaCajaSorpresas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuditoriaCajaSorpresas(start, end);
	}

	/**
	* Returns the number of auditoria caja sorpresas.
	*
	* @return the number of auditoria caja sorpresas
	* @throws SystemException if a system exception occurred
	*/
	public static int getAuditoriaCajaSorpresasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAuditoriaCajaSorpresasCount();
	}

	/**
	* Updates the auditoria caja sorpresa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @return the auditoria caja sorpresa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa updateAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAuditoriaCajaSorpresa(auditoriaCajaSorpresa);
	}

	/**
	* Updates the auditoria caja sorpresa in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param auditoriaCajaSorpresa the auditoria caja sorpresa
	* @param merge whether to merge the auditoria caja sorpresa with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the auditoria caja sorpresa that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa updateAuditoriaCajaSorpresa(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateAuditoriaCajaSorpresa(auditoriaCajaSorpresa, merge);
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

	/**
	* Se obtiene la cantidad maxima de registros segun la consulta
	*
	* @throws BusinessException
	*/
	public static java.lang.Long obtenerListaCajaSorpresaCount(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboTipoDocumento, java.lang.String producto,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerListaCajaSorpresaCount(filas, pagina,
			cboTipoDocumento, producto, txtFechaInicio, txtFechaFin);
	}

	/**
	* Se obtiene los registros del reporte de caja sorpresa.
	*
	* @throws BusinessException
	*/
	public static java.util.List<com.ext.portlet.halcon.model.AuditoriaCajaSorpresa> obtenerListaAuditoriaCajaSorpresa(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboTipoDocumento, java.lang.String producto,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerListaAuditoriaCajaSorpresa(filas, pagina,
			cboTipoDocumento, producto, txtFechaInicio, txtFechaFin);
	}

	public static java.lang.Boolean insert(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa bean)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insert(bean);
	}

	public static com.ext.portlet.halcon.model.AuditoriaCajaSorpresa getInstace() {
		return getService().getInstace();
	}

	public static void clearService() {
		_service = null;
	}

	public static AuditoriaCajaSorpresaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AuditoriaCajaSorpresaLocalService.class.getName());

			if (invokableLocalService instanceof AuditoriaCajaSorpresaLocalService) {
				_service = (AuditoriaCajaSorpresaLocalService)invokableLocalService;
			}
			else {
				_service = new AuditoriaCajaSorpresaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(AuditoriaCajaSorpresaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(AuditoriaCajaSorpresaLocalService service) {
	}

	private static AuditoriaCajaSorpresaLocalService _service;
}