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
 * The utility for the carga tienda local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.CargaTiendaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaTiendaLocalService
 * @see com.ext.portlet.halcon.service.base.CargaTiendaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.CargaTiendaLocalServiceImpl
 * @generated
 */
public class CargaTiendaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.CargaTiendaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the carga tienda to the database. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @return the carga tienda that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda addCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCargaTienda(cargaTienda);
	}

	/**
	* Creates a new carga tienda with the primary key. Does not add the carga tienda to the database.
	*
	* @param idCargaTienda the primary key for the new carga tienda
	* @return the new carga tienda
	*/
	public static com.ext.portlet.halcon.model.CargaTienda createCargaTienda(
		long idCargaTienda) {
		return getService().createCargaTienda(idCargaTienda);
	}

	/**
	* Deletes the carga tienda with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda that was removed
	* @throws PortalException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda deleteCargaTienda(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargaTienda(idCargaTienda);
	}

	/**
	* Deletes the carga tienda from the database. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @return the carga tienda that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda deleteCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargaTienda(cargaTienda);
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

	public static com.ext.portlet.halcon.model.CargaTienda fetchCargaTienda(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCargaTienda(idCargaTienda);
	}

	/**
	* Returns the carga tienda with the primary key.
	*
	* @param idCargaTienda the primary key of the carga tienda
	* @return the carga tienda
	* @throws PortalException if a carga tienda with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda getCargaTienda(
		long idCargaTienda)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaTienda(idCargaTienda);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ext.portlet.halcon.model.CargaTienda> getCargaTiendas(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaTiendas(start, end);
	}

	/**
	* Returns the number of carga tiendas.
	*
	* @return the number of carga tiendas
	* @throws SystemException if a system exception occurred
	*/
	public static int getCargaTiendasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaTiendasCount();
	}

	/**
	* Updates the carga tienda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @return the carga tienda that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda updateCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargaTienda(cargaTienda);
	}

	/**
	* Updates the carga tienda in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaTienda the carga tienda
	* @param merge whether to merge the carga tienda with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the carga tienda that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaTienda updateCargaTienda(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargaTienda(cargaTienda, merge);
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
	* inserta una nueva entidad carga tienda
	*/
	public static java.lang.Boolean insert(
		java.util.List<com.ext.portlet.halcon.model.CargaTienda> lst)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insert(lst);
	}

	/**
	* se obtiene la lista de tiendas
	* la cantidad de filas
	* la pagina la cual se encuentra
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaTienda> obtenerUbicacionMapaTiendas(
		int filas, int page, java.lang.String[] check, java.lang.String distrito)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerUbicacionMapaTiendas(filas, page, check, distrito);
	}

	/**
	* se la cantidad de registros en total
	* la cantidad de filas
	* la pagina la cual se encuentra
	*/
	public static java.lang.Long obtenerUbicacionMapaTiendasCount(int filas,
		int page, java.lang.String[] check, java.lang.String distrito)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerUbicacionMapaTiendasCount(filas, page, check,
			distrito);
	}

	public static int truncateCargaTienda()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().truncateCargaTienda();
	}

	public static com.ext.portlet.halcon.model.CargaTienda getInstace() {
		return getService().getInstace();
	}

	public static void clearService() {
		_service = null;
	}

	public static CargaTiendaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CargaTiendaLocalService.class.getName());

			if (invokableLocalService instanceof CargaTiendaLocalService) {
				_service = (CargaTiendaLocalService)invokableLocalService;
			}
			else {
				_service = new CargaTiendaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CargaTiendaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CargaTiendaLocalService service) {
	}

	private static CargaTiendaLocalService _service;
}