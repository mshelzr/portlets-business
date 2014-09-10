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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the configuracion perfilador local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfiladorLocalServiceUtil
 * @see com.ext.portlet.halcon.service.base.ConfiguracionPerfiladorLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.ConfiguracionPerfiladorLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ConfiguracionPerfiladorLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfiguracionPerfiladorLocalServiceUtil} to access the configuracion perfilador local service. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.ConfiguracionPerfiladorLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the configuracion perfilador to the database. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @return the configuracion perfilador that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador addConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new configuracion perfilador with the primary key. Does not add the configuracion perfilador to the database.
	*
	* @param idConfiguracionPerfilador the primary key for the new configuracion perfilador
	* @return the new configuracion perfilador
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador createConfiguracionPerfilador(
		long idConfiguracionPerfilador);

	/**
	* Deletes the configuracion perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador that was removed
	* @throws PortalException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador deleteConfiguracionPerfilador(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the configuracion perfilador from the database. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @return the configuracion perfilador that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador deleteConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador fetchConfiguracionPerfilador(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuracion perfilador with the primary key.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador
	* @throws PortalException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador getConfiguracionPerfilador(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configuracion perfiladors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of configuracion perfiladors
	* @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	* @return the range of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> getConfiguracionPerfiladors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configuracion perfiladors.
	*
	* @return the number of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getConfiguracionPerfiladorsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the configuracion perfilador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @return the configuracion perfilador that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador updateConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the configuracion perfilador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @param merge whether to merge the configuracion perfilador with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the configuracion perfilador that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador updateConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public java.lang.Long obtenerRangoValorConfiguracionPerfilador(
		java.lang.Long idConfiguracionPerfiladorPadre, java.lang.Long valor)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public java.lang.Long obtenerCorrelativoConfiguracionPerfilador()
		throws com.ext.portlet.halcon.exception.BusinessException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ext.portlet.halcon.model.ConfiguracionPerfilador getInstance();

	public com.ext.portlet.halcon.model.ConfiguracionPerfilador insert(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.ext.portlet.halcon.exception.BusinessException;

	public com.ext.portlet.halcon.model.ConfiguracionPerfilador update(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.ext.portlet.halcon.exception.BusinessException;
}