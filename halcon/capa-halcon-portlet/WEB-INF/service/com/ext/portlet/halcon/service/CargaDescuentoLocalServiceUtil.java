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
 * The utility for the carga descuento local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.CargaDescuentoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaDescuentoLocalService
 * @see com.ext.portlet.halcon.service.base.CargaDescuentoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.CargaDescuentoLocalServiceImpl
 * @generated
 */
public class CargaDescuentoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.CargaDescuentoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the carga descuento to the database. Also notifies the appropriate model listeners.
	*
	* @param cargaDescuento the carga descuento
	* @return the carga descuento that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento addCargaDescuento(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCargaDescuento(cargaDescuento);
	}

	/**
	* Creates a new carga descuento with the primary key. Does not add the carga descuento to the database.
	*
	* @param idCargaDesc the primary key for the new carga descuento
	* @return the new carga descuento
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento createCargaDescuento(
		long idCargaDesc) {
		return getService().createCargaDescuento(idCargaDesc);
	}

	/**
	* Deletes the carga descuento with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCargaDesc the primary key of the carga descuento
	* @return the carga descuento that was removed
	* @throws PortalException if a carga descuento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento deleteCargaDescuento(
		long idCargaDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargaDescuento(idCargaDesc);
	}

	/**
	* Deletes the carga descuento from the database. Also notifies the appropriate model listeners.
	*
	* @param cargaDescuento the carga descuento
	* @return the carga descuento that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento deleteCargaDescuento(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCargaDescuento(cargaDescuento);
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

	public static com.ext.portlet.halcon.model.CargaDescuento fetchCargaDescuento(
		long idCargaDesc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCargaDescuento(idCargaDesc);
	}

	/**
	* Returns the carga descuento with the primary key.
	*
	* @param idCargaDesc the primary key of the carga descuento
	* @return the carga descuento
	* @throws PortalException if a carga descuento with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento getCargaDescuento(
		long idCargaDesc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaDescuento(idCargaDesc);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the carga descuentos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of carga descuentos
	* @param end the upper bound of the range of carga descuentos (not inclusive)
	* @return the range of carga descuentos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaDescuento> getCargaDescuentos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaDescuentos(start, end);
	}

	/**
	* Returns the number of carga descuentos.
	*
	* @return the number of carga descuentos
	* @throws SystemException if a system exception occurred
	*/
	public static int getCargaDescuentosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCargaDescuentosCount();
	}

	/**
	* Updates the carga descuento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaDescuento the carga descuento
	* @return the carga descuento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento updateCargaDescuento(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargaDescuento(cargaDescuento);
	}

	/**
	* Updates the carga descuento in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cargaDescuento the carga descuento
	* @param merge whether to merge the carga descuento with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the carga descuento that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CargaDescuento updateCargaDescuento(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCargaDescuento(cargaDescuento, merge);
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
	* inserta nueva entidad de cargaDescuento
	*/
	public static java.lang.Boolean insert(
		java.util.List<com.ext.portlet.halcon.model.CargaDescuento> lst)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insert(lst);
	}

	/**
	* se obtiene la lista de descuentos la cantidad de filas la pagina la cual se encuentra
	*
	* @throws BusinessException
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CargaDescuento> obtenerUbicacionMapaDescuentos(
		java.lang.String buscar, java.lang.String distrito,
		java.lang.Integer categoria, int pagina, int filas)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerUbicacionMapaDescuentos(buscar, distrito, categoria,
			pagina, filas);
	}

	/**
	* se la cantidad de registros en total
	* la cantidad de filas
	* la pagina la cual se encuentra
	*
	* @throws BusinessException
	*/
	public static java.lang.Long obtenerUbicacionMapaCargaDescuentosCount(
		java.lang.String buscar, java.lang.String distrito,
		java.lang.Integer categoria, int pagina, int filas)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerUbicacionMapaCargaDescuentosCount(buscar, distrito,
			categoria, pagina, filas);
	}

	public static int truncateCargaDescuento()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().truncateCargaDescuento();
	}

	public static com.ext.portlet.halcon.model.CargaDescuento getInstace() {
		return getService().getInstace();
	}

	public static void clearService() {
		_service = null;
	}

	public static CargaDescuentoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CargaDescuentoLocalService.class.getName());

			if (invokableLocalService instanceof CargaDescuentoLocalService) {
				_service = (CargaDescuentoLocalService)invokableLocalService;
			}
			else {
				_service = new CargaDescuentoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CargaDescuentoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CargaDescuentoLocalService service) {
	}

	private static CargaDescuentoLocalService _service;
}