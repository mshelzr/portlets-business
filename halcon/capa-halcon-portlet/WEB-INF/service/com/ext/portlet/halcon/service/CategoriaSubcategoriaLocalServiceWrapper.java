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
 * This class is a wrapper for {@link CategoriaSubcategoriaLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       CategoriaSubcategoriaLocalService
 * @generated
 */
public class CategoriaSubcategoriaLocalServiceWrapper
	implements CategoriaSubcategoriaLocalService,
		ServiceWrapper<CategoriaSubcategoriaLocalService> {
	public CategoriaSubcategoriaLocalServiceWrapper(
		CategoriaSubcategoriaLocalService categoriaSubcategoriaLocalService) {
		_categoriaSubcategoriaLocalService = categoriaSubcategoriaLocalService;
	}

	/**
	* Adds the categoria subcategoria to the database. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @return the categoria subcategoria that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria addCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.addCategoriaSubcategoria(categoriaSubcategoria);
	}

	/**
	* Creates a new categoria subcategoria with the primary key. Does not add the categoria subcategoria to the database.
	*
	* @param idCategoriaSubCat the primary key for the new categoria subcategoria
	* @return the new categoria subcategoria
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria createCategoriaSubcategoria(
		long idCategoriaSubCat) {
		return _categoriaSubcategoriaLocalService.createCategoriaSubcategoria(idCategoriaSubCat);
	}

	/**
	* Deletes the categoria subcategoria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria that was removed
	* @throws PortalException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria deleteCategoriaSubcategoria(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.deleteCategoriaSubcategoria(idCategoriaSubCat);
	}

	/**
	* Deletes the categoria subcategoria from the database. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @return the categoria subcategoria that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria deleteCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.deleteCategoriaSubcategoria(categoriaSubcategoria);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _categoriaSubcategoriaLocalService.dynamicQuery();
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
		return _categoriaSubcategoriaLocalService.dynamicQuery(dynamicQuery);
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
		return _categoriaSubcategoriaLocalService.dynamicQuery(dynamicQuery,
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
		return _categoriaSubcategoriaLocalService.dynamicQuery(dynamicQuery,
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
		return _categoriaSubcategoriaLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.CategoriaSubcategoria fetchCategoriaSubcategoria(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.fetchCategoriaSubcategoria(idCategoriaSubCat);
	}

	/**
	* Returns the categoria subcategoria with the primary key.
	*
	* @param idCategoriaSubCat the primary key of the categoria subcategoria
	* @return the categoria subcategoria
	* @throws PortalException if a categoria subcategoria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria getCategoriaSubcategoria(
		long idCategoriaSubCat)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.getCategoriaSubcategoria(idCategoriaSubCat);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.getPersistedModel(primaryKeyObj);
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
	public java.util.List<com.ext.portlet.halcon.model.CategoriaSubcategoria> getCategoriaSubcategorias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.getCategoriaSubcategorias(start,
			end);
	}

	/**
	* Returns the number of categoria subcategorias.
	*
	* @return the number of categoria subcategorias
	* @throws SystemException if a system exception occurred
	*/
	public int getCategoriaSubcategoriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.getCategoriaSubcategoriasCount();
	}

	/**
	* Updates the categoria subcategoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @return the categoria subcategoria that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria updateCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.updateCategoriaSubcategoria(categoriaSubcategoria);
	}

	/**
	* Updates the categoria subcategoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param categoriaSubcategoria the categoria subcategoria
	* @param merge whether to merge the categoria subcategoria with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the categoria subcategoria that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.CategoriaSubcategoria updateCategoriaSubcategoria(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _categoriaSubcategoriaLocalService.updateCategoriaSubcategoria(categoriaSubcategoria,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _categoriaSubcategoriaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_categoriaSubcategoriaLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _categoriaSubcategoriaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public int insertar(java.lang.Integer idCategoriaSubCatPadre,
		java.lang.String descripcion)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _categoriaSubcategoriaLocalService.insertar(idCategoriaSubCatPadre,
			descripcion);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public CategoriaSubcategoriaLocalService getWrappedCategoriaSubcategoriaLocalService() {
		return _categoriaSubcategoriaLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedCategoriaSubcategoriaLocalService(
		CategoriaSubcategoriaLocalService categoriaSubcategoriaLocalService) {
		_categoriaSubcategoriaLocalService = categoriaSubcategoriaLocalService;
	}

	public CategoriaSubcategoriaLocalService getWrappedService() {
		return _categoriaSubcategoriaLocalService;
	}

	public void setWrappedService(
		CategoriaSubcategoriaLocalService categoriaSubcategoriaLocalService) {
		_categoriaSubcategoriaLocalService = categoriaSubcategoriaLocalService;
	}

	private CategoriaSubcategoriaLocalService _categoriaSubcategoriaLocalService;
}