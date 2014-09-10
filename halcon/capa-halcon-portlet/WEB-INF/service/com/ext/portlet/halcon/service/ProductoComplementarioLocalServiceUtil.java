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
 * The utility for the producto complementario local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.ProductoComplementarioLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ProductoComplementarioLocalService
 * @see com.ext.portlet.halcon.service.base.ProductoComplementarioLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.ProductoComplementarioLocalServiceImpl
 * @generated
 */
public class ProductoComplementarioLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.ProductoComplementarioLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the producto complementario to the database. Also notifies the appropriate model listeners.
	*
	* @param productoComplementario the producto complementario
	* @return the producto complementario that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario addProductoComplementario(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addProductoComplementario(productoComplementario);
	}

	/**
	* Creates a new producto complementario with the primary key. Does not add the producto complementario to the database.
	*
	* @param idProductoComplementario the primary key for the new producto complementario
	* @return the new producto complementario
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario createProductoComplementario(
		long idProductoComplementario) {
		return getService()
				   .createProductoComplementario(idProductoComplementario);
	}

	/**
	* Deletes the producto complementario with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario that was removed
	* @throws PortalException if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario deleteProductoComplementario(
		long idProductoComplementario)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteProductoComplementario(idProductoComplementario);
	}

	/**
	* Deletes the producto complementario from the database. Also notifies the appropriate model listeners.
	*
	* @param productoComplementario the producto complementario
	* @return the producto complementario that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario deleteProductoComplementario(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteProductoComplementario(productoComplementario);
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

	public static com.ext.portlet.halcon.model.ProductoComplementario fetchProductoComplementario(
		long idProductoComplementario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchProductoComplementario(idProductoComplementario);
	}

	/**
	* Returns the producto complementario with the primary key.
	*
	* @param idProductoComplementario the primary key of the producto complementario
	* @return the producto complementario
	* @throws PortalException if a producto complementario with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario getProductoComplementario(
		long idProductoComplementario)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductoComplementario(idProductoComplementario);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the producto complementarios.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of producto complementarios
	* @param end the upper bound of the range of producto complementarios (not inclusive)
	* @return the range of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> getProductoComplementarios(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductoComplementarios(start, end);
	}

	/**
	* Returns the number of producto complementarios.
	*
	* @return the number of producto complementarios
	* @throws SystemException if a system exception occurred
	*/
	public static int getProductoComplementariosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProductoComplementariosCount();
	}

	/**
	* Updates the producto complementario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productoComplementario the producto complementario
	* @return the producto complementario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario updateProductoComplementario(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateProductoComplementario(productoComplementario);
	}

	/**
	* Updates the producto complementario in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productoComplementario the producto complementario
	* @param merge whether to merge the producto complementario with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the producto complementario that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ProductoComplementario updateProductoComplementario(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateProductoComplementario(productoComplementario, merge);
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

	public static java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> obtenerProductosCOmplementarioDistinct()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerProductosCOmplementarioDistinct();
	}

	public static com.ext.portlet.halcon.model.ProductoComplementario newInstance() {
		return getService().newInstance();
	}

	public static void clearService() {
		_service = null;
	}

	public static ProductoComplementarioLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ProductoComplementarioLocalService.class.getName());

			if (invokableLocalService instanceof ProductoComplementarioLocalService) {
				_service = (ProductoComplementarioLocalService)invokableLocalService;
			}
			else {
				_service = new ProductoComplementarioLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ProductoComplementarioLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ProductoComplementarioLocalService service) {
	}

	private static ProductoComplementarioLocalService _service;
}