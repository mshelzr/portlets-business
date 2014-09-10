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
 * This class is a wrapper for {@link PreguntaFrecuenteLocalService}.
 * </p>
 *
 * @author    Infonet-Consulting
 * @see       PreguntaFrecuenteLocalService
 * @generated
 */
public class PreguntaFrecuenteLocalServiceWrapper
	implements PreguntaFrecuenteLocalService,
		ServiceWrapper<PreguntaFrecuenteLocalService> {
	public PreguntaFrecuenteLocalServiceWrapper(
		PreguntaFrecuenteLocalService preguntaFrecuenteLocalService) {
		_preguntaFrecuenteLocalService = preguntaFrecuenteLocalService;
	}

	/**
	* Adds the pregunta frecuente to the database. Also notifies the appropriate model listeners.
	*
	* @param preguntaFrecuente the pregunta frecuente
	* @return the pregunta frecuente that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente addPreguntaFrecuente(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.addPreguntaFrecuente(preguntaFrecuente);
	}

	/**
	* Creates a new pregunta frecuente with the primary key. Does not add the pregunta frecuente to the database.
	*
	* @param idPreguntaFrecuente the primary key for the new pregunta frecuente
	* @return the new pregunta frecuente
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente createPreguntaFrecuente(
		int idPreguntaFrecuente) {
		return _preguntaFrecuenteLocalService.createPreguntaFrecuente(idPreguntaFrecuente);
	}

	/**
	* Deletes the pregunta frecuente with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente that was removed
	* @throws PortalException if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente deletePreguntaFrecuente(
		int idPreguntaFrecuente)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.deletePreguntaFrecuente(idPreguntaFrecuente);
	}

	/**
	* Deletes the pregunta frecuente from the database. Also notifies the appropriate model listeners.
	*
	* @param preguntaFrecuente the pregunta frecuente
	* @return the pregunta frecuente that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente deletePreguntaFrecuente(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.deletePreguntaFrecuente(preguntaFrecuente);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _preguntaFrecuenteLocalService.dynamicQuery();
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
		return _preguntaFrecuenteLocalService.dynamicQuery(dynamicQuery);
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
		return _preguntaFrecuenteLocalService.dynamicQuery(dynamicQuery, start,
			end);
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
		return _preguntaFrecuenteLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _preguntaFrecuenteLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.ext.portlet.halcon.model.PreguntaFrecuente fetchPreguntaFrecuente(
		int idPreguntaFrecuente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.fetchPreguntaFrecuente(idPreguntaFrecuente);
	}

	/**
	* Returns the pregunta frecuente with the primary key.
	*
	* @param idPreguntaFrecuente the primary key of the pregunta frecuente
	* @return the pregunta frecuente
	* @throws PortalException if a pregunta frecuente with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente getPreguntaFrecuente(
		int idPreguntaFrecuente)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.getPreguntaFrecuente(idPreguntaFrecuente);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the pregunta frecuentes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of pregunta frecuentes
	* @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	* @return the range of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ext.portlet.halcon.model.PreguntaFrecuente> getPreguntaFrecuentes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.getPreguntaFrecuentes(start, end);
	}

	/**
	* Returns the number of pregunta frecuentes.
	*
	* @return the number of pregunta frecuentes
	* @throws SystemException if a system exception occurred
	*/
	public int getPreguntaFrecuentesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.getPreguntaFrecuentesCount();
	}

	/**
	* Updates the pregunta frecuente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param preguntaFrecuente the pregunta frecuente
	* @return the pregunta frecuente that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente updatePreguntaFrecuente(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.updatePreguntaFrecuente(preguntaFrecuente);
	}

	/**
	* Updates the pregunta frecuente in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param preguntaFrecuente the pregunta frecuente
	* @param merge whether to merge the pregunta frecuente with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the pregunta frecuente that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.PreguntaFrecuente updatePreguntaFrecuente(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _preguntaFrecuenteLocalService.updatePreguntaFrecuente(preguntaFrecuente,
			merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _preguntaFrecuenteLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_preguntaFrecuenteLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _preguntaFrecuenteLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	public com.ext.portlet.halcon.model.PreguntaFrecuente insertar(
		int idCategoriaSubCat, java.lang.String enunciado,
		java.lang.String respuesta, boolean estado, java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return _preguntaFrecuenteLocalService.insertar(idCategoriaSubCat,
			enunciado, respuesta, estado, etiqueta);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public PreguntaFrecuenteLocalService getWrappedPreguntaFrecuenteLocalService() {
		return _preguntaFrecuenteLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedPreguntaFrecuenteLocalService(
		PreguntaFrecuenteLocalService preguntaFrecuenteLocalService) {
		_preguntaFrecuenteLocalService = preguntaFrecuenteLocalService;
	}

	public PreguntaFrecuenteLocalService getWrappedService() {
		return _preguntaFrecuenteLocalService;
	}

	public void setWrappedService(
		PreguntaFrecuenteLocalService preguntaFrecuenteLocalService) {
		_preguntaFrecuenteLocalService = preguntaFrecuenteLocalService;
	}

	private PreguntaFrecuenteLocalService _preguntaFrecuenteLocalService;
}