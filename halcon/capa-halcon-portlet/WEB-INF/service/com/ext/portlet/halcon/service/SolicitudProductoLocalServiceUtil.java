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
 * The utility for the solicitud producto local service. This utility wraps {@link com.ext.portlet.halcon.service.impl.SolicitudProductoLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudProductoLocalService
 * @see com.ext.portlet.halcon.service.base.SolicitudProductoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.impl.SolicitudProductoLocalServiceImpl
 * @generated
 */
public class SolicitudProductoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ext.portlet.halcon.service.impl.SolicitudProductoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the solicitud producto to the database. Also notifies the appropriate model listeners.
	*
	* @param solicitudProducto the solicitud producto
	* @return the solicitud producto that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto addSolicitudProducto(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addSolicitudProducto(solicitudProducto);
	}

	/**
	* Creates a new solicitud producto with the primary key. Does not add the solicitud producto to the database.
	*
	* @param idSolicitudProducto the primary key for the new solicitud producto
	* @return the new solicitud producto
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto createSolicitudProducto(
		long idSolicitudProducto) {
		return getService().createSolicitudProducto(idSolicitudProducto);
	}

	/**
	* Deletes the solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto that was removed
	* @throws PortalException if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto deleteSolicitudProducto(
		long idSolicitudProducto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSolicitudProducto(idSolicitudProducto);
	}

	/**
	* Deletes the solicitud producto from the database. Also notifies the appropriate model listeners.
	*
	* @param solicitudProducto the solicitud producto
	* @return the solicitud producto that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto deleteSolicitudProducto(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteSolicitudProducto(solicitudProducto);
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

	public static com.ext.portlet.halcon.model.SolicitudProducto fetchSolicitudProducto(
		long idSolicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchSolicitudProducto(idSolicitudProducto);
	}

	/**
	* Returns the solicitud producto with the primary key.
	*
	* @param idSolicitudProducto the primary key of the solicitud producto
	* @return the solicitud producto
	* @throws PortalException if a solicitud producto with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto getSolicitudProducto(
		long idSolicitudProducto)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getSolicitudProducto(idSolicitudProducto);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the solicitud productos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of solicitud productos
	* @param end the upper bound of the range of solicitud productos (not inclusive)
	* @return the range of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> getSolicitudProductos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSolicitudProductos(start, end);
	}

	/**
	* Returns the number of solicitud productos.
	*
	* @return the number of solicitud productos
	* @throws SystemException if a system exception occurred
	*/
	public static int getSolicitudProductosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getSolicitudProductosCount();
	}

	/**
	* Updates the solicitud producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param solicitudProducto the solicitud producto
	* @return the solicitud producto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto updateSolicitudProducto(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSolicitudProducto(solicitudProducto);
	}

	/**
	* Updates the solicitud producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param solicitudProducto the solicitud producto
	* @param merge whether to merge the solicitud producto with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the solicitud producto that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ext.portlet.halcon.model.SolicitudProducto updateSolicitudProducto(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateSolicitudProducto(solicitudProducto, merge);
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

	public static java.lang.Integer insertarSolicitud(
		com.ext.portlet.halcon.model.SolicitudProducto productoBean,
		java.util.List<com.ext.portlet.halcon.model.ProductoComplementario> lstProductos,
		java.util.List<com.ext.portlet.halcon.model.TelefonoSolicitudProducto> lstTelefonos)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .insertarSolicitud(productoBean, lstProductos, lstTelefonos);
	}

	public static com.ext.portlet.halcon.model.SolicitudProducto getInstance() {
		return getService().getInstance();
	}

	public static com.ext.portlet.halcon.model.ProductoComplementario getInstanceComplementario() {
		return getService().getInstanceComplementario();
	}

	public static com.ext.portlet.halcon.model.TelefonoSolicitudProducto getInstanceTelefono() {
		return getService().getInstanceTelefono();
	}

	public static java.lang.Long obtenerListaSolicitudProductoCount(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboProducto, java.lang.Integer respuestaADQ,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerListaSolicitudProductoCount(filas, pagina,
			cboProducto, respuestaADQ, txtFechaInicio, txtFechaFin);
	}

	public static java.util.List<com.ext.portlet.halcon.model.SolicitudProducto> obtenerListSolicitudProducto(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.Integer cboProducto, java.lang.Integer respuestaADQ,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerListSolicitudProducto(filas, pagina, cboProducto,
			respuestaADQ, txtFechaInicio, txtFechaFin);
	}

	public static java.lang.Integer obtenerDetalleSolicitudCount(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.String cboProducto, java.lang.Integer respuestaADQ,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerDetalleSolicitudCount(filas, pagina, cboProducto,
			respuestaADQ, txtFechaInicio, txtFechaFin);
	}

	public static java.util.List<java.lang.Object[]> obtenerDetalleSolicitud(
		java.lang.Integer filas, java.lang.Integer pagina,
		java.lang.String cboProducto, java.lang.Integer respuestaADQ,
		java.lang.String txtFechaInicio, java.lang.String txtFechaFin)
		throws com.ext.portlet.halcon.exception.BusinessException {
		return getService()
				   .obtenerDetalleSolicitud(filas, pagina, cboProducto,
			respuestaADQ, txtFechaInicio, txtFechaFin);
	}

	public static java.lang.String getEtiquetaProductoByFriendlyURL(
		java.lang.String urlAmigable) {
		return getService().getEtiquetaProductoByFriendlyURL(urlAmigable);
	}

	public static java.lang.String getEtiquetaSolicitudByFriendlyURL(
		java.lang.String urlAmigable) {
		return getService().getEtiquetaSolicitudByFriendlyURL(urlAmigable);
	}

	public static java.lang.String getProductoFriendlyURLbyEtiqueta(
		java.lang.String etiquetaProducto) {
		return getService().getProductoFriendlyURLbyEtiqueta(etiquetaProducto);
	}

	public static java.lang.String getSolicitudFriendlyURLbyEtiqueta(
		java.lang.String etiquetaSolicitud) {
		return getService().getSolicitudFriendlyURLbyEtiqueta(etiquetaSolicitud);
	}

	public static java.lang.String getURLSolicitudByEtiquetaContenido(
		java.lang.String etiquetaProducto) {
		return getService().getURLSolicitudByEtiquetaContenido(etiquetaProducto);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getMapaSolicitudes() {
		return getService().getMapaSolicitudes();
	}

	public static java.lang.String getPropiedadPortlet(java.lang.String clave) {
		return getService().getPropiedadPortlet(clave);
	}

	public static void clearService() {
		_service = null;
	}

	public static SolicitudProductoLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SolicitudProductoLocalService.class.getName());

			if (invokableLocalService instanceof SolicitudProductoLocalService) {
				_service = (SolicitudProductoLocalService)invokableLocalService;
			}
			else {
				_service = new SolicitudProductoLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SolicitudProductoLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(SolicitudProductoLocalService service) {
	}

	private static SolicitudProductoLocalService _service;
}