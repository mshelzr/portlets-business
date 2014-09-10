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
 * The utility for the configuracion perfilador local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.ConfiguracionPerfiladorLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfiladorLocalService
 * @see com.ext.portlet.halcon.service.base.ConfiguracionPerfiladorLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.ConfiguracionPerfiladorLocalServiceImpl
 * @generated
 */
public class ConfiguracionPerfiladorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.ConfiguracionPerfiladorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the configuracion perfilador to the database. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @return the configuracion perfilador that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador addConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addConfiguracionPerfilador(configuracionPerfilador);
	}

	/**
	* Creates a new configuracion perfilador with the primary key. Does not add the configuracion perfilador to the database.
	*
	* @param idConfiguracionPerfilador the primary key for the new configuracion perfilador
	* @return the new configuracion perfilador
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador createConfiguracionPerfilador(
		long idConfiguracionPerfilador) {
		return getService()
				   .createConfiguracionPerfilador(idConfiguracionPerfilador);
	}

	/**
	* Deletes the configuracion perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador that was removed
	* @throws PortalException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador deleteConfiguracionPerfilador(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteConfiguracionPerfilador(idConfiguracionPerfilador);
	}

	/**
	* Deletes the configuracion perfilador from the database. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @return the configuracion perfilador that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador deleteConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .deleteConfiguracionPerfilador(configuracionPerfilador);
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

	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador fetchConfiguracionPerfilador(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .fetchConfiguracionPerfilador(idConfiguracionPerfilador);
	}

	/**
	* Returns the configuracion perfilador with the primary key.
	*
	* @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	* @return the configuracion perfilador
	* @throws PortalException if a configuracion perfilador with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador getConfiguracionPerfilador(
		long idConfiguracionPerfilador)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfiguracionPerfilador(idConfiguracionPerfilador);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

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
	public static java.util.List<com.ext.portlet.halcon.model.ConfiguracionPerfilador> getConfiguracionPerfiladors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfiguracionPerfiladors(start, end);
	}

	/**
	* Returns the number of configuracion perfiladors.
	*
	* @return the number of configuracion perfiladors
	* @throws SystemException if a system exception occurred
	*/
	public static int getConfiguracionPerfiladorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getConfiguracionPerfiladorsCount();
	}

	/**
	* Updates the configuracion perfilador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @return the configuracion perfilador that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador updateConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConfiguracionPerfilador(configuracionPerfilador);
	}

	/**
	* Updates the configuracion perfilador in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param configuracionPerfilador the configuracion perfilador
	* @param merge whether to merge the configuracion perfilador with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the configuracion perfilador that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador updateConfiguracionPerfilador(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateConfiguracionPerfilador(configuracionPerfilador, merge);
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

	public static java.lang.Long obtenerRangoValorConfiguracionPerfilador(
		java.lang.Long idConfiguracionPerfiladorPadre, java.lang.Long valor)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerRangoValorConfiguracionPerfilador(idConfiguracionPerfiladorPadre,
			valor);
	}

	public static java.lang.Long obtenerCorrelativoConfiguracionPerfilador()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerCorrelativoConfiguracionPerfilador();
	}

	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador getInstance() {
		return getService().getInstance();
	}

	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador insert(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insert(configuracionPerfilador);
	}

	public static com.ext.portlet.halcon.model.ConfiguracionPerfilador update(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().update(configuracionPerfilador);
	}

	public static void clearService() {
		_service = null;
	}

	public static ConfiguracionPerfiladorLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ConfiguracionPerfiladorLocalService.class.getName());

			if (invokableLocalService instanceof ConfiguracionPerfiladorLocalService) {
				_service = (ConfiguracionPerfiladorLocalService)invokableLocalService;
			}
			else {
				_service = new ConfiguracionPerfiladorLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ConfiguracionPerfiladorLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ConfiguracionPerfiladorLocalService service) {
	}

	private static ConfiguracionPerfiladorLocalService _service;
}