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
 * The utility for the parametro local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.ParametroLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see ParametroLocalService
 * @see com.ext.portlet.halcon.service.base.ParametroLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.ParametroLocalServiceImpl
 * @generated
 */
public class ParametroLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.ParametroLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the parametro to the database. Also notifies the appropriate model listeners.
	*
	* @param parametro the parametro
	* @return the parametro that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Parametro addParametro(
		com.ext.portlet.halcon.model.Parametro parametro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addParametro(parametro);
	}

	/**
	* Creates a new parametro with the primary key. Does not add the parametro to the database.
	*
	* @param idParametro the primary key for the new parametro
	* @return the new parametro
	*/
	public static com.ext.portlet.halcon.model.Parametro createParametro(
		int idParametro) {
		return getService().createParametro(idParametro);
	}

	/**
	* Deletes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idParametro the primary key of the parametro
	* @return the parametro that was removed
	* @throws PortalException if a parametro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Parametro deleteParametro(
		int idParametro)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteParametro(idParametro);
	}

	/**
	* Deletes the parametro from the database. Also notifies the appropriate model listeners.
	*
	* @param parametro the parametro
	* @return the parametro that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Parametro deleteParametro(
		com.ext.portlet.halcon.model.Parametro parametro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteParametro(parametro);
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

	public static com.ext.portlet.halcon.model.Parametro fetchParametro(
		int idParametro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchParametro(idParametro);
	}

	/**
	* Returns the parametro with the primary key.
	*
	* @param idParametro the primary key of the parametro
	* @return the parametro
	* @throws PortalException if a parametro with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Parametro getParametro(
		int idParametro)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getParametro(idParametro);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the parametros.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of parametros
	* @param end the upper bound of the range of parametros (not inclusive)
	* @return the range of parametros
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.Parametro> getParametros(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getParametros(start, end);
	}

	/**
	* Returns the number of parametros.
	*
	* @return the number of parametros
	* @throws SystemException if a system exception occurred
	*/
	public static int getParametrosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getParametrosCount();
	}

	/**
	* Updates the parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parametro the parametro
	* @return the parametro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Parametro updateParametro(
		com.ext.portlet.halcon.model.Parametro parametro)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateParametro(parametro);
	}

	/**
	* Updates the parametro in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param parametro the parametro
	* @param merge whether to merge the parametro with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the parametro that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.Parametro updateParametro(
		com.ext.portlet.halcon.model.Parametro parametro, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateParametro(parametro, merge);
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

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> listarParametro()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().listarParametro();
	}

	public static com.ext.portlet.halcon.model.Parametro obtenerParametroPadre(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametroPadre(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijos(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametrosHijos(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijos(
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametrosHijos(etiqueta);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorTipo(
		java.lang.Integer id)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametrosPorTipo(id);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorDescripcion(
		java.lang.String descripcion)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametrosPorDescripcion(descripcion);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosPorDescripcion(
		java.lang.String descripcionParametro,
		java.lang.String descripcionParametroPadre)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerParametrosPorDescripcion(descripcionParametro,
			descripcionParametroPadre);
	}

	public static java.lang.Integer cambiarParametroEstado(
		java.lang.Integer id, java.lang.Integer estado)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().cambiarParametroEstado(id, estado);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametroListaPadre()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametroListaPadre();
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerRangoValor(
		java.lang.Integer id) throws java.lang.Exception {
		return getService().obtenerRangoValor(id);
	}

	public static java.lang.Integer validarTipo(java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().validarTipo(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> obtenerParametrosHijosDos(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerParametrosHijosDos(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> listarPadresJson(
		java.lang.Integer idParametro)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().listarPadresJson(idParametro);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> listarHijosPadresJson(
		java.lang.Integer tipoLista)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().listarHijosPadresJson(tipoLista);
	}

	public static int registrarCabeceraDetalle(
		com.ext.portlet.halcon.model.Parametro parametroCab,
		com.ext.portlet.halcon.model.Parametro parametroDet)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().registrarCabeceraDetalle(parametroCab, parametroDet);
	}

	public static com.ext.portlet.halcon.model.Parametro getInstance() {
		return getService().getInstance();
	}

	public static void clearService() {
		_service = null;
	}

	public static ParametroLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ParametroLocalService.class.getName());

			if (invokableLocalService instanceof ParametroLocalService) {
				_service = (ParametroLocalService)invokableLocalService;
			}
			else {
				_service = new ParametroLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ParametroLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ParametroLocalService service) {
	}

	private static ParametroLocalService _service;
}