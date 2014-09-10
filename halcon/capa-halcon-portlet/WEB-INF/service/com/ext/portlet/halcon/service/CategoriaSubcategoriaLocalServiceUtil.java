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
 * The utility for the categoria subcategoria local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.CategoriaSubcategoriaLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see CategoriaSubcategoriaLocalService
 * @see com.ext.portlet.halcon.service.base.CategoriaSubcategoriaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.CategoriaSubcategoriaLocalServiceImpl
 * @generated
 */
public class CategoriaSubcategoriaLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.CategoriaSubcategoriaLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the categoria subcategoria to the database. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @return the categoria subcategoria that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria addCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCategoriaSubcategoria(categoriaSubcategoria);
	}

	/**
	* Creates a new categoria subcategoria with the primary key. Does not add the categoria subcategoria to the database.
	*
	* @param idCategoriaSubCat the primary key for the new categoria subcategoria
	* @return the new categoria subcategoria
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria createCategoriaSubcategoria(
		long idCategoriaSubCat) {
		return getService().createCategoriaSubcategoria(idCategoriaSubCat);
	}

	/**
	* Deletes the categoria subcategoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria that was removed
	* @throws PortalException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria deleteCategoriaSubcategoria(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCategoriaSubcategoria(idCategoriaSubCat);
	}

	/**
	* Deletes the categoria subcategoria from the database. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @return the categoria subcategoria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria deleteCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCategoriaSubcategoria(categoriaSubcategoria);
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

	public static com.ext.portlet.halcon.model.CategoriaSubcategoria fetchCategoriaSubcategoria(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCategoriaSubcategoria(idCategoriaSubCat);
	}

	/**
	* Returns the categoria subcategoria with the primary key.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria
	* @throws PortalException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria getCategoriaSubcategoria(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoriaSubcategoria(idCategoriaSubCat);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the categoria subcategorias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of categoria subcategorias
	* @param end the upper bound of the range of categoria subcategorias (not inclusive)
	* @return the range of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> getCategoriaSubcategorias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoriaSubcategorias(start, end);
	}

	/**
	* Returns the number of categoria subcategorias.
	*
	* @return the number of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public static int getCategoriaSubcategoriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCategoriaSubcategoriasCount();
	}

	/**
	* Updates the categoria subcategoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @return the categoria subcategoria that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria updateCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCategoriaSubcategoria(categoriaSubcategoria);
	}

	/**
	* Updates the categoria subcategoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @param merge whether to merge the categoria subcategoria with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the categoria subcategoria that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.CategoriaSubcategoria updateCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCategoriaSubcategoria(categoriaSubcategoria, merge);
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

	public static int insertar(java.lang.Integer idCategoriaSubCatPadre,
		java.lang.String descripcion)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insertar(idCategoriaSubCatPadre, descripcion);
	}

	public static void clearService() {
		_service = null;
	}

	public static CategoriaSubcategoriaLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CategoriaSubcategoriaLocalService.class.getName());

			if (invokableLocalService instanceof CategoriaSubcategoriaLocalService) {
				_service = (CategoriaSubcategoriaLocalService)invokableLocalService;
			}
			else {
				_service = new CategoriaSubcategoriaLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CategoriaSubcategoriaLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(CategoriaSubcategoriaLocalService service) {
	}

	private static CategoriaSubcategoriaLocalService _service;
}