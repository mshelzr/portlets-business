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
 * The utility for the fondos mutuos local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.FondosMutuosLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosLocalService
 * @see com.ext.portlet.halcon.service.base.FondosMutuosLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.FondosMutuosLocalServiceImpl
 * @generated
 */
public class FondosMutuosLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.FondosMutuosLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the fondos mutuos to the database. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @return the fondos mutuos that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos addFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addFondosMutuos(fondosMutuos);
	}

	/**
	* Creates a new fondos mutuos with the primary key. Does not add the fondos mutuos to the database.
	*
	* @param idValorCuota the primary key for the new fondos mutuos
	* @return the new fondos mutuos
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos createFondosMutuos(
		long idValorCuota) {
		return getService().createFondosMutuos(idValorCuota);
	}

	/**
	* Deletes the fondos mutuos with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos that was removed
	* @throws PortalException if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos deleteFondosMutuos(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFondosMutuos(idValorCuota);
	}

	/**
	* Deletes the fondos mutuos from the database. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @return the fondos mutuos that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos deleteFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteFondosMutuos(fondosMutuos);
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

	public static com.ext.portlet.halcon.model.FondosMutuos fetchFondosMutuos(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchFondosMutuos(idValorCuota);
	}

	/**
	* Returns the fondos mutuos with the primary key.
	*
	* @param idValorCuota the primary key of the fondos mutuos
	* @return the fondos mutuos
	* @throws PortalException if a fondos mutuos with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos getFondosMutuos(
		long idValorCuota)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFondosMutuos(idValorCuota);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the fondos mutuoses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of fondos mutuoses
	* @param end the upper bound of the range of fondos mutuoses (not inclusive)
	* @return the range of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuos> getFondosMutuoses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFondosMutuoses(start, end);
	}

	/**
	* Returns the number of fondos mutuoses.
	*
	* @return the number of fondos mutuoses
	* @throws SystemException if a system exception occurred
	*/
	public static int getFondosMutuosesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getFondosMutuosesCount();
	}

	/**
	* Updates the fondos mutuos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @return the fondos mutuos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos updateFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFondosMutuos(fondosMutuos);
	}

	/**
	* Updates the fondos mutuos in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fondosMutuos the fondos mutuos
	* @param merge whether to merge the fondos mutuos with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the fondos mutuos that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.FondosMutuos updateFondosMutuos(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateFondosMutuos(fondosMutuos, merge);
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

	public static com.ext.portlet.halcon.model.Parametro obtenerFondoMutuoZona(
		java.lang.Integer puntaje, java.lang.String moneda,
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerFondoMutuoZona(puntaje, moneda, etiqueta);
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> ListarPlazozFondoMutuo(
		java.lang.String valor)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().ListarPlazozFondoMutuo(valor);
	}

	public static java.util.List<com.ext.portlet.halcon.model.FondosMutuos> ListarFondoMutuo(
		java.lang.String moneda, java.util.List<java.lang.String> fechas,
		java.lang.String tipoFondo)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().ListarFondoMutuo(moneda, fechas, tipoFondo);
	}

	public static java.lang.Boolean insertarFondoMutuo(
		java.util.List<com.ext.portlet.halcon.model.FondosMutuos> lstBeans)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().insertarFondoMutuo(lstBeans);
	}

	public static com.ext.portlet.halcon.model.FondosMutuos consultarUltimaFecha()
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().consultarUltimaFecha();
	}

	public static java.util.List<com.ext.portlet.halcon.model.Parametro> consultarFondoMutuoTipos(
		java.lang.Integer puntaje, java.lang.String moneda,
		java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().consultarFondoMutuoTipos(puntaje, moneda, etiqueta);
	}

	public static com.ext.portlet.halcon.model.Parametro obtenerFondosMutuosPuntos(
		java.lang.String numeroDias, java.lang.String etiqueta)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService().obtenerFondosMutuosPuntos(numeroDias, etiqueta);
	}

	public static java.util.List<java.lang.Object[]> consultarFondosMutuosParte(
		java.lang.String moneda, java.lang.String fondo1,
		java.lang.String fondo2, java.lang.String fondo3,
		java.lang.Integer dias, java.util.List<java.lang.String> lista)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .consultarFondosMutuosParte(moneda, fondo1, fondo2, fondo3,
			dias, lista);
	}

	public static com.ext.portlet.halcon.model.Parametro consultarDiasDesdeIdentificadorSlider(
		java.lang.String etiqueta, java.lang.String periodo)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .consultarDiasDesdeIdentificadorSlider(etiqueta, periodo);
	}

	public static com.ext.portlet.halcon.model.FondosMutuos getInstance() {
		return getService().getInstance();
	}

	public static void clearService() {
		_service = null;
	}

	public static FondosMutuosLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					FondosMutuosLocalService.class.getName());

			if (invokableLocalService instanceof FondosMutuosLocalService) {
				_service = (FondosMutuosLocalService)invokableLocalService;
			}
			else {
				_service = new FondosMutuosLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(FondosMutuosLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(FondosMutuosLocalService service) {
	}

	private static FondosMutuosLocalService _service;
}