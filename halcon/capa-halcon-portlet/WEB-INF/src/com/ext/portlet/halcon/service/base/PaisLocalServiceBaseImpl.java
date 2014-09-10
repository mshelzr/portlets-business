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

package com.ext.portlet.halcon.service.base;

import com.ext.portlet.halcon.model.Pais;
import com.ext.portlet.halcon.service.AuditoriaCajaSorpresaLocalService;
import com.ext.portlet.halcon.service.AuditoriaCajaSorpresaService;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalService;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorService;
import com.ext.portlet.halcon.service.AuditoriaSimuladorLocalService;
import com.ext.portlet.halcon.service.AuditoriaSimuladorService;
import com.ext.portlet.halcon.service.CargaDescuentoLocalService;
import com.ext.portlet.halcon.service.CargaDescuentoService;
import com.ext.portlet.halcon.service.CargaSocioRemesaLocalService;
import com.ext.portlet.halcon.service.CargaSocioRemesaService;
import com.ext.portlet.halcon.service.CargaTiendaLocalService;
import com.ext.portlet.halcon.service.CargaTiendaService;
import com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalService;
import com.ext.portlet.halcon.service.CategoriaSubcategoriaService;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalService;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorService;
import com.ext.portlet.halcon.service.ConfiguracionProductoLocalService;
import com.ext.portlet.halcon.service.ConfiguracionProductoService;
import com.ext.portlet.halcon.service.FondosMutuosLocalService;
import com.ext.portlet.halcon.service.FondosMutuosService;
import com.ext.portlet.halcon.service.LogIncidenciasLocalService;
import com.ext.portlet.halcon.service.LogIncidenciasService;
import com.ext.portlet.halcon.service.OcurrenciaLocalService;
import com.ext.portlet.halcon.service.OcurrenciaService;
import com.ext.portlet.halcon.service.PaisLocalService;
import com.ext.portlet.halcon.service.PaisService;
import com.ext.portlet.halcon.service.ParametroLocalService;
import com.ext.portlet.halcon.service.ParametroService;
import com.ext.portlet.halcon.service.PreguntaFrecuenteLocalService;
import com.ext.portlet.halcon.service.PreguntaFrecuenteService;
import com.ext.portlet.halcon.service.ProductoComplementarioLocalService;
import com.ext.portlet.halcon.service.ProductoComplementarioService;
import com.ext.portlet.halcon.service.SolicitudContactoLocalService;
import com.ext.portlet.halcon.service.SolicitudProductoLocalService;
import com.ext.portlet.halcon.service.SolicitudProductoService;
import com.ext.portlet.halcon.service.TelefonoSolicitudProductoLocalService;
import com.ext.portlet.halcon.service.TelefonoSolicitudProductoService;
import com.ext.portlet.halcon.service.UbigeoLocalService;
import com.ext.portlet.halcon.service.UbigeoService;
import com.ext.portlet.halcon.service.ValorCuotaLocalService;
import com.ext.portlet.halcon.service.ValorCuotaService;
import com.ext.portlet.halcon.service.persistence.AuditoriaCajaSorpresaFinder;
import com.ext.portlet.halcon.service.persistence.AuditoriaCajaSorpresaPersistence;
import com.ext.portlet.halcon.service.persistence.AuditoriaPerfiladorPersistence;
import com.ext.portlet.halcon.service.persistence.AuditoriaSimuladorFinder;
import com.ext.portlet.halcon.service.persistence.AuditoriaSimuladorPersistence;
import com.ext.portlet.halcon.service.persistence.CargaDescuentoFinder;
import com.ext.portlet.halcon.service.persistence.CargaDescuentoPersistence;
import com.ext.portlet.halcon.service.persistence.CargaSocioRemesaFinder;
import com.ext.portlet.halcon.service.persistence.CargaSocioRemesaPersistence;
import com.ext.portlet.halcon.service.persistence.CargaTiendaFinder;
import com.ext.portlet.halcon.service.persistence.CargaTiendaPersistence;
import com.ext.portlet.halcon.service.persistence.CategoriaSubcategoriaFinder;
import com.ext.portlet.halcon.service.persistence.CategoriaSubcategoriaPersistence;
import com.ext.portlet.halcon.service.persistence.ConfiguracionPerfiladorFinder;
import com.ext.portlet.halcon.service.persistence.ConfiguracionPerfiladorPersistence;
import com.ext.portlet.halcon.service.persistence.ConfiguracionProductoPersistence;
import com.ext.portlet.halcon.service.persistence.FondosMutuosFinder;
import com.ext.portlet.halcon.service.persistence.FondosMutuosPersistence;
import com.ext.portlet.halcon.service.persistence.LogIncidenciasFinder;
import com.ext.portlet.halcon.service.persistence.LogIncidenciasPersistence;
import com.ext.portlet.halcon.service.persistence.OcurrenciaFinder;
import com.ext.portlet.halcon.service.persistence.OcurrenciaPersistence;
import com.ext.portlet.halcon.service.persistence.PaisFinder;
import com.ext.portlet.halcon.service.persistence.PaisPersistence;
import com.ext.portlet.halcon.service.persistence.ParametroFinder;
import com.ext.portlet.halcon.service.persistence.ParametroPersistence;
import com.ext.portlet.halcon.service.persistence.PreguntaFrecuentePersistence;
import com.ext.portlet.halcon.service.persistence.ProductoComplementarioPersistence;
import com.ext.portlet.halcon.service.persistence.SolicitudContactoPersistence;
import com.ext.portlet.halcon.service.persistence.SolicitudProductoFinder;
import com.ext.portlet.halcon.service.persistence.SolicitudProductoPersistence;
import com.ext.portlet.halcon.service.persistence.TelefonoSolicitudProductoPersistence;
import com.ext.portlet.halcon.service.persistence.UbigeoFinder;
import com.ext.portlet.halcon.service.persistence.UbigeoPersistence;
import com.ext.portlet.halcon.service.persistence.ValorCuotaPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the pais local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ext.portlet.halcon.service.impl.PaisLocalServiceImpl}.
 * </p>
 *
 * @author Infonet-Consulting
 * @see com.ext.portlet.halcon.service.impl.PaisLocalServiceImpl
 * @see com.ext.portlet.halcon.service.PaisLocalServiceUtil
 * @generated
 */
public abstract class PaisLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements PaisLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.ext.portlet.halcon.service.PaisLocalServiceUtil} to access the pais local service.
	 */

	/**
	 * Adds the pais to the database. Also notifies the appropriate model listeners.
	 *
	 * @param pais the pais
	 * @return the pais that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pais addPais(Pais pais) throws SystemException {
		pais.setNew(true);

		return paisPersistence.update(pais, false);
	}

	/**
	 * Creates a new pais with the primary key. Does not add the pais to the database.
	 *
	 * @param pais_IdPais the primary key for the new pais
	 * @return the new pais
	 */
	public Pais createPais(long pais_IdPais) {
		return paisPersistence.create(pais_IdPais);
	}

	/**
	 * Deletes the pais with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pais_IdPais the primary key of the pais
	 * @return the pais that was removed
	 * @throws PortalException if a pais with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Pais deletePais(long pais_IdPais)
		throws PortalException, SystemException {
		return paisPersistence.remove(pais_IdPais);
	}

	/**
	 * Deletes the pais from the database. Also notifies the appropriate model listeners.
	 *
	 * @param pais the pais
	 * @return the pais that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Pais deletePais(Pais pais) throws SystemException {
		return paisPersistence.remove(pais);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Pais.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return paisPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return paisPersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return paisPersistence.findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return paisPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Pais fetchPais(long pais_IdPais) throws SystemException {
		return paisPersistence.fetchByPrimaryKey(pais_IdPais);
	}

	/**
	 * Returns the pais with the primary key.
	 *
	 * @param pais_IdPais the primary key of the pais
	 * @return the pais
	 * @throws PortalException if a pais with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Pais getPais(long pais_IdPais)
		throws PortalException, SystemException {
		return paisPersistence.findByPrimaryKey(pais_IdPais);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return paisPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the paises.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of paises
	 * @param end the upper bound of the range of paises (not inclusive)
	 * @return the range of paises
	 * @throws SystemException if a system exception occurred
	 */
	public List<Pais> getPaises(int start, int end) throws SystemException {
		return paisPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of paises.
	 *
	 * @return the number of paises
	 * @throws SystemException if a system exception occurred
	 */
	public int getPaisesCount() throws SystemException {
		return paisPersistence.countAll();
	}

	/**
	 * Updates the pais in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param pais the pais
	 * @return the pais that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pais updatePais(Pais pais) throws SystemException {
		return updatePais(pais, true);
	}

	/**
	 * Updates the pais in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param pais the pais
	 * @param merge whether to merge the pais with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the pais that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Pais updatePais(Pais pais, boolean merge) throws SystemException {
		pais.setNew(false);

		return paisPersistence.update(pais, merge);
	}

	/**
	 * Returns the auditoria caja sorpresa local service.
	 *
	 * @return the auditoria caja sorpresa local service
	 */
	public AuditoriaCajaSorpresaLocalService getAuditoriaCajaSorpresaLocalService() {
		return auditoriaCajaSorpresaLocalService;
	}

	/**
	 * Sets the auditoria caja sorpresa local service.
	 *
	 * @param auditoriaCajaSorpresaLocalService the auditoria caja sorpresa local service
	 */
	public void setAuditoriaCajaSorpresaLocalService(
		AuditoriaCajaSorpresaLocalService auditoriaCajaSorpresaLocalService) {
		this.auditoriaCajaSorpresaLocalService = auditoriaCajaSorpresaLocalService;
	}

	/**
	 * Returns the auditoria caja sorpresa remote service.
	 *
	 * @return the auditoria caja sorpresa remote service
	 */
	public AuditoriaCajaSorpresaService getAuditoriaCajaSorpresaService() {
		return auditoriaCajaSorpresaService;
	}

	/**
	 * Sets the auditoria caja sorpresa remote service.
	 *
	 * @param auditoriaCajaSorpresaService the auditoria caja sorpresa remote service
	 */
	public void setAuditoriaCajaSorpresaService(
		AuditoriaCajaSorpresaService auditoriaCajaSorpresaService) {
		this.auditoriaCajaSorpresaService = auditoriaCajaSorpresaService;
	}

	/**
	 * Returns the auditoria caja sorpresa persistence.
	 *
	 * @return the auditoria caja sorpresa persistence
	 */
	public AuditoriaCajaSorpresaPersistence getAuditoriaCajaSorpresaPersistence() {
		return auditoriaCajaSorpresaPersistence;
	}

	/**
	 * Sets the auditoria caja sorpresa persistence.
	 *
	 * @param auditoriaCajaSorpresaPersistence the auditoria caja sorpresa persistence
	 */
	public void setAuditoriaCajaSorpresaPersistence(
		AuditoriaCajaSorpresaPersistence auditoriaCajaSorpresaPersistence) {
		this.auditoriaCajaSorpresaPersistence = auditoriaCajaSorpresaPersistence;
	}

	/**
	 * Returns the auditoria caja sorpresa finder.
	 *
	 * @return the auditoria caja sorpresa finder
	 */
	public AuditoriaCajaSorpresaFinder getAuditoriaCajaSorpresaFinder() {
		return auditoriaCajaSorpresaFinder;
	}

	/**
	 * Sets the auditoria caja sorpresa finder.
	 *
	 * @param auditoriaCajaSorpresaFinder the auditoria caja sorpresa finder
	 */
	public void setAuditoriaCajaSorpresaFinder(
		AuditoriaCajaSorpresaFinder auditoriaCajaSorpresaFinder) {
		this.auditoriaCajaSorpresaFinder = auditoriaCajaSorpresaFinder;
	}

	/**
	 * Returns the auditoria perfilador local service.
	 *
	 * @return the auditoria perfilador local service
	 */
	public AuditoriaPerfiladorLocalService getAuditoriaPerfiladorLocalService() {
		return auditoriaPerfiladorLocalService;
	}

	/**
	 * Sets the auditoria perfilador local service.
	 *
	 * @param auditoriaPerfiladorLocalService the auditoria perfilador local service
	 */
	public void setAuditoriaPerfiladorLocalService(
		AuditoriaPerfiladorLocalService auditoriaPerfiladorLocalService) {
		this.auditoriaPerfiladorLocalService = auditoriaPerfiladorLocalService;
	}

	/**
	 * Returns the auditoria perfilador remote service.
	 *
	 * @return the auditoria perfilador remote service
	 */
	public AuditoriaPerfiladorService getAuditoriaPerfiladorService() {
		return auditoriaPerfiladorService;
	}

	/**
	 * Sets the auditoria perfilador remote service.
	 *
	 * @param auditoriaPerfiladorService the auditoria perfilador remote service
	 */
	public void setAuditoriaPerfiladorService(
		AuditoriaPerfiladorService auditoriaPerfiladorService) {
		this.auditoriaPerfiladorService = auditoriaPerfiladorService;
	}

	/**
	 * Returns the auditoria perfilador persistence.
	 *
	 * @return the auditoria perfilador persistence
	 */
	public AuditoriaPerfiladorPersistence getAuditoriaPerfiladorPersistence() {
		return auditoriaPerfiladorPersistence;
	}

	/**
	 * Sets the auditoria perfilador persistence.
	 *
	 * @param auditoriaPerfiladorPersistence the auditoria perfilador persistence
	 */
	public void setAuditoriaPerfiladorPersistence(
		AuditoriaPerfiladorPersistence auditoriaPerfiladorPersistence) {
		this.auditoriaPerfiladorPersistence = auditoriaPerfiladorPersistence;
	}

	/**
	 * Returns the auditoria simulador local service.
	 *
	 * @return the auditoria simulador local service
	 */
	public AuditoriaSimuladorLocalService getAuditoriaSimuladorLocalService() {
		return auditoriaSimuladorLocalService;
	}

	/**
	 * Sets the auditoria simulador local service.
	 *
	 * @param auditoriaSimuladorLocalService the auditoria simulador local service
	 */
	public void setAuditoriaSimuladorLocalService(
		AuditoriaSimuladorLocalService auditoriaSimuladorLocalService) {
		this.auditoriaSimuladorLocalService = auditoriaSimuladorLocalService;
	}

	/**
	 * Returns the auditoria simulador remote service.
	 *
	 * @return the auditoria simulador remote service
	 */
	public AuditoriaSimuladorService getAuditoriaSimuladorService() {
		return auditoriaSimuladorService;
	}

	/**
	 * Sets the auditoria simulador remote service.
	 *
	 * @param auditoriaSimuladorService the auditoria simulador remote service
	 */
	public void setAuditoriaSimuladorService(
		AuditoriaSimuladorService auditoriaSimuladorService) {
		this.auditoriaSimuladorService = auditoriaSimuladorService;
	}

	/**
	 * Returns the auditoria simulador persistence.
	 *
	 * @return the auditoria simulador persistence
	 */
	public AuditoriaSimuladorPersistence getAuditoriaSimuladorPersistence() {
		return auditoriaSimuladorPersistence;
	}

	/**
	 * Sets the auditoria simulador persistence.
	 *
	 * @param auditoriaSimuladorPersistence the auditoria simulador persistence
	 */
	public void setAuditoriaSimuladorPersistence(
		AuditoriaSimuladorPersistence auditoriaSimuladorPersistence) {
		this.auditoriaSimuladorPersistence = auditoriaSimuladorPersistence;
	}

	/**
	 * Returns the auditoria simulador finder.
	 *
	 * @return the auditoria simulador finder
	 */
	public AuditoriaSimuladorFinder getAuditoriaSimuladorFinder() {
		return auditoriaSimuladorFinder;
	}

	/**
	 * Sets the auditoria simulador finder.
	 *
	 * @param auditoriaSimuladorFinder the auditoria simulador finder
	 */
	public void setAuditoriaSimuladorFinder(
		AuditoriaSimuladorFinder auditoriaSimuladorFinder) {
		this.auditoriaSimuladorFinder = auditoriaSimuladorFinder;
	}

	/**
	 * Returns the carga descuento local service.
	 *
	 * @return the carga descuento local service
	 */
	public CargaDescuentoLocalService getCargaDescuentoLocalService() {
		return cargaDescuentoLocalService;
	}

	/**
	 * Sets the carga descuento local service.
	 *
	 * @param cargaDescuentoLocalService the carga descuento local service
	 */
	public void setCargaDescuentoLocalService(
		CargaDescuentoLocalService cargaDescuentoLocalService) {
		this.cargaDescuentoLocalService = cargaDescuentoLocalService;
	}

	/**
	 * Returns the carga descuento remote service.
	 *
	 * @return the carga descuento remote service
	 */
	public CargaDescuentoService getCargaDescuentoService() {
		return cargaDescuentoService;
	}

	/**
	 * Sets the carga descuento remote service.
	 *
	 * @param cargaDescuentoService the carga descuento remote service
	 */
	public void setCargaDescuentoService(
		CargaDescuentoService cargaDescuentoService) {
		this.cargaDescuentoService = cargaDescuentoService;
	}

	/**
	 * Returns the carga descuento persistence.
	 *
	 * @return the carga descuento persistence
	 */
	public CargaDescuentoPersistence getCargaDescuentoPersistence() {
		return cargaDescuentoPersistence;
	}

	/**
	 * Sets the carga descuento persistence.
	 *
	 * @param cargaDescuentoPersistence the carga descuento persistence
	 */
	public void setCargaDescuentoPersistence(
		CargaDescuentoPersistence cargaDescuentoPersistence) {
		this.cargaDescuentoPersistence = cargaDescuentoPersistence;
	}

	/**
	 * Returns the carga descuento finder.
	 *
	 * @return the carga descuento finder
	 */
	public CargaDescuentoFinder getCargaDescuentoFinder() {
		return cargaDescuentoFinder;
	}

	/**
	 * Sets the carga descuento finder.
	 *
	 * @param cargaDescuentoFinder the carga descuento finder
	 */
	public void setCargaDescuentoFinder(
		CargaDescuentoFinder cargaDescuentoFinder) {
		this.cargaDescuentoFinder = cargaDescuentoFinder;
	}

	/**
	 * Returns the carga socio remesa local service.
	 *
	 * @return the carga socio remesa local service
	 */
	public CargaSocioRemesaLocalService getCargaSocioRemesaLocalService() {
		return cargaSocioRemesaLocalService;
	}

	/**
	 * Sets the carga socio remesa local service.
	 *
	 * @param cargaSocioRemesaLocalService the carga socio remesa local service
	 */
	public void setCargaSocioRemesaLocalService(
		CargaSocioRemesaLocalService cargaSocioRemesaLocalService) {
		this.cargaSocioRemesaLocalService = cargaSocioRemesaLocalService;
	}

	/**
	 * Returns the carga socio remesa remote service.
	 *
	 * @return the carga socio remesa remote service
	 */
	public CargaSocioRemesaService getCargaSocioRemesaService() {
		return cargaSocioRemesaService;
	}

	/**
	 * Sets the carga socio remesa remote service.
	 *
	 * @param cargaSocioRemesaService the carga socio remesa remote service
	 */
	public void setCargaSocioRemesaService(
		CargaSocioRemesaService cargaSocioRemesaService) {
		this.cargaSocioRemesaService = cargaSocioRemesaService;
	}

	/**
	 * Returns the carga socio remesa persistence.
	 *
	 * @return the carga socio remesa persistence
	 */
	public CargaSocioRemesaPersistence getCargaSocioRemesaPersistence() {
		return cargaSocioRemesaPersistence;
	}

	/**
	 * Sets the carga socio remesa persistence.
	 *
	 * @param cargaSocioRemesaPersistence the carga socio remesa persistence
	 */
	public void setCargaSocioRemesaPersistence(
		CargaSocioRemesaPersistence cargaSocioRemesaPersistence) {
		this.cargaSocioRemesaPersistence = cargaSocioRemesaPersistence;
	}

	/**
	 * Returns the carga socio remesa finder.
	 *
	 * @return the carga socio remesa finder
	 */
	public CargaSocioRemesaFinder getCargaSocioRemesaFinder() {
		return cargaSocioRemesaFinder;
	}

	/**
	 * Sets the carga socio remesa finder.
	 *
	 * @param cargaSocioRemesaFinder the carga socio remesa finder
	 */
	public void setCargaSocioRemesaFinder(
		CargaSocioRemesaFinder cargaSocioRemesaFinder) {
		this.cargaSocioRemesaFinder = cargaSocioRemesaFinder;
	}

	/**
	 * Returns the carga tienda local service.
	 *
	 * @return the carga tienda local service
	 */
	public CargaTiendaLocalService getCargaTiendaLocalService() {
		return cargaTiendaLocalService;
	}

	/**
	 * Sets the carga tienda local service.
	 *
	 * @param cargaTiendaLocalService the carga tienda local service
	 */
	public void setCargaTiendaLocalService(
		CargaTiendaLocalService cargaTiendaLocalService) {
		this.cargaTiendaLocalService = cargaTiendaLocalService;
	}

	/**
	 * Returns the carga tienda remote service.
	 *
	 * @return the carga tienda remote service
	 */
	public CargaTiendaService getCargaTiendaService() {
		return cargaTiendaService;
	}

	/**
	 * Sets the carga tienda remote service.
	 *
	 * @param cargaTiendaService the carga tienda remote service
	 */
	public void setCargaTiendaService(CargaTiendaService cargaTiendaService) {
		this.cargaTiendaService = cargaTiendaService;
	}

	/**
	 * Returns the carga tienda persistence.
	 *
	 * @return the carga tienda persistence
	 */
	public CargaTiendaPersistence getCargaTiendaPersistence() {
		return cargaTiendaPersistence;
	}

	/**
	 * Sets the carga tienda persistence.
	 *
	 * @param cargaTiendaPersistence the carga tienda persistence
	 */
	public void setCargaTiendaPersistence(
		CargaTiendaPersistence cargaTiendaPersistence) {
		this.cargaTiendaPersistence = cargaTiendaPersistence;
	}

	/**
	 * Returns the carga tienda finder.
	 *
	 * @return the carga tienda finder
	 */
	public CargaTiendaFinder getCargaTiendaFinder() {
		return cargaTiendaFinder;
	}

	/**
	 * Sets the carga tienda finder.
	 *
	 * @param cargaTiendaFinder the carga tienda finder
	 */
	public void setCargaTiendaFinder(CargaTiendaFinder cargaTiendaFinder) {
		this.cargaTiendaFinder = cargaTiendaFinder;
	}

	/**
	 * Returns the categoria subcategoria local service.
	 *
	 * @return the categoria subcategoria local service
	 */
	public CategoriaSubcategoriaLocalService getCategoriaSubcategoriaLocalService() {
		return categoriaSubcategoriaLocalService;
	}

	/**
	 * Sets the categoria subcategoria local service.
	 *
	 * @param categoriaSubcategoriaLocalService the categoria subcategoria local service
	 */
	public void setCategoriaSubcategoriaLocalService(
		CategoriaSubcategoriaLocalService categoriaSubcategoriaLocalService) {
		this.categoriaSubcategoriaLocalService = categoriaSubcategoriaLocalService;
	}

	/**
	 * Returns the categoria subcategoria remote service.
	 *
	 * @return the categoria subcategoria remote service
	 */
	public CategoriaSubcategoriaService getCategoriaSubcategoriaService() {
		return categoriaSubcategoriaService;
	}

	/**
	 * Sets the categoria subcategoria remote service.
	 *
	 * @param categoriaSubcategoriaService the categoria subcategoria remote service
	 */
	public void setCategoriaSubcategoriaService(
		CategoriaSubcategoriaService categoriaSubcategoriaService) {
		this.categoriaSubcategoriaService = categoriaSubcategoriaService;
	}

	/**
	 * Returns the categoria subcategoria persistence.
	 *
	 * @return the categoria subcategoria persistence
	 */
	public CategoriaSubcategoriaPersistence getCategoriaSubcategoriaPersistence() {
		return categoriaSubcategoriaPersistence;
	}

	/**
	 * Sets the categoria subcategoria persistence.
	 *
	 * @param categoriaSubcategoriaPersistence the categoria subcategoria persistence
	 */
	public void setCategoriaSubcategoriaPersistence(
		CategoriaSubcategoriaPersistence categoriaSubcategoriaPersistence) {
		this.categoriaSubcategoriaPersistence = categoriaSubcategoriaPersistence;
	}

	/**
	 * Returns the categoria subcategoria finder.
	 *
	 * @return the categoria subcategoria finder
	 */
	public CategoriaSubcategoriaFinder getCategoriaSubcategoriaFinder() {
		return categoriaSubcategoriaFinder;
	}

	/**
	 * Sets the categoria subcategoria finder.
	 *
	 * @param categoriaSubcategoriaFinder the categoria subcategoria finder
	 */
	public void setCategoriaSubcategoriaFinder(
		CategoriaSubcategoriaFinder categoriaSubcategoriaFinder) {
		this.categoriaSubcategoriaFinder = categoriaSubcategoriaFinder;
	}

	/**
	 * Returns the configuracion perfilador local service.
	 *
	 * @return the configuracion perfilador local service
	 */
	public ConfiguracionPerfiladorLocalService getConfiguracionPerfiladorLocalService() {
		return configuracionPerfiladorLocalService;
	}

	/**
	 * Sets the configuracion perfilador local service.
	 *
	 * @param configuracionPerfiladorLocalService the configuracion perfilador local service
	 */
	public void setConfiguracionPerfiladorLocalService(
		ConfiguracionPerfiladorLocalService configuracionPerfiladorLocalService) {
		this.configuracionPerfiladorLocalService = configuracionPerfiladorLocalService;
	}

	/**
	 * Returns the configuracion perfilador remote service.
	 *
	 * @return the configuracion perfilador remote service
	 */
	public ConfiguracionPerfiladorService getConfiguracionPerfiladorService() {
		return configuracionPerfiladorService;
	}

	/**
	 * Sets the configuracion perfilador remote service.
	 *
	 * @param configuracionPerfiladorService the configuracion perfilador remote service
	 */
	public void setConfiguracionPerfiladorService(
		ConfiguracionPerfiladorService configuracionPerfiladorService) {
		this.configuracionPerfiladorService = configuracionPerfiladorService;
	}

	/**
	 * Returns the configuracion perfilador persistence.
	 *
	 * @return the configuracion perfilador persistence
	 */
	public ConfiguracionPerfiladorPersistence getConfiguracionPerfiladorPersistence() {
		return configuracionPerfiladorPersistence;
	}

	/**
	 * Sets the configuracion perfilador persistence.
	 *
	 * @param configuracionPerfiladorPersistence the configuracion perfilador persistence
	 */
	public void setConfiguracionPerfiladorPersistence(
		ConfiguracionPerfiladorPersistence configuracionPerfiladorPersistence) {
		this.configuracionPerfiladorPersistence = configuracionPerfiladorPersistence;
	}

	/**
	 * Returns the configuracion perfilador finder.
	 *
	 * @return the configuracion perfilador finder
	 */
	public ConfiguracionPerfiladorFinder getConfiguracionPerfiladorFinder() {
		return configuracionPerfiladorFinder;
	}

	/**
	 * Sets the configuracion perfilador finder.
	 *
	 * @param configuracionPerfiladorFinder the configuracion perfilador finder
	 */
	public void setConfiguracionPerfiladorFinder(
		ConfiguracionPerfiladorFinder configuracionPerfiladorFinder) {
		this.configuracionPerfiladorFinder = configuracionPerfiladorFinder;
	}

	/**
	 * Returns the configuracion producto local service.
	 *
	 * @return the configuracion producto local service
	 */
	public ConfiguracionProductoLocalService getConfiguracionProductoLocalService() {
		return configuracionProductoLocalService;
	}

	/**
	 * Sets the configuracion producto local service.
	 *
	 * @param configuracionProductoLocalService the configuracion producto local service
	 */
	public void setConfiguracionProductoLocalService(
		ConfiguracionProductoLocalService configuracionProductoLocalService) {
		this.configuracionProductoLocalService = configuracionProductoLocalService;
	}

	/**
	 * Returns the configuracion producto remote service.
	 *
	 * @return the configuracion producto remote service
	 */
	public ConfiguracionProductoService getConfiguracionProductoService() {
		return configuracionProductoService;
	}

	/**
	 * Sets the configuracion producto remote service.
	 *
	 * @param configuracionProductoService the configuracion producto remote service
	 */
	public void setConfiguracionProductoService(
		ConfiguracionProductoService configuracionProductoService) {
		this.configuracionProductoService = configuracionProductoService;
	}

	/**
	 * Returns the configuracion producto persistence.
	 *
	 * @return the configuracion producto persistence
	 */
	public ConfiguracionProductoPersistence getConfiguracionProductoPersistence() {
		return configuracionProductoPersistence;
	}

	/**
	 * Sets the configuracion producto persistence.
	 *
	 * @param configuracionProductoPersistence the configuracion producto persistence
	 */
	public void setConfiguracionProductoPersistence(
		ConfiguracionProductoPersistence configuracionProductoPersistence) {
		this.configuracionProductoPersistence = configuracionProductoPersistence;
	}

	/**
	 * Returns the fondos mutuos local service.
	 *
	 * @return the fondos mutuos local service
	 */
	public FondosMutuosLocalService getFondosMutuosLocalService() {
		return fondosMutuosLocalService;
	}

	/**
	 * Sets the fondos mutuos local service.
	 *
	 * @param fondosMutuosLocalService the fondos mutuos local service
	 */
	public void setFondosMutuosLocalService(
		FondosMutuosLocalService fondosMutuosLocalService) {
		this.fondosMutuosLocalService = fondosMutuosLocalService;
	}

	/**
	 * Returns the fondos mutuos remote service.
	 *
	 * @return the fondos mutuos remote service
	 */
	public FondosMutuosService getFondosMutuosService() {
		return fondosMutuosService;
	}

	/**
	 * Sets the fondos mutuos remote service.
	 *
	 * @param fondosMutuosService the fondos mutuos remote service
	 */
	public void setFondosMutuosService(FondosMutuosService fondosMutuosService) {
		this.fondosMutuosService = fondosMutuosService;
	}

	/**
	 * Returns the fondos mutuos persistence.
	 *
	 * @return the fondos mutuos persistence
	 */
	public FondosMutuosPersistence getFondosMutuosPersistence() {
		return fondosMutuosPersistence;
	}

	/**
	 * Sets the fondos mutuos persistence.
	 *
	 * @param fondosMutuosPersistence the fondos mutuos persistence
	 */
	public void setFondosMutuosPersistence(
		FondosMutuosPersistence fondosMutuosPersistence) {
		this.fondosMutuosPersistence = fondosMutuosPersistence;
	}

	/**
	 * Returns the fondos mutuos finder.
	 *
	 * @return the fondos mutuos finder
	 */
	public FondosMutuosFinder getFondosMutuosFinder() {
		return fondosMutuosFinder;
	}

	/**
	 * Sets the fondos mutuos finder.
	 *
	 * @param fondosMutuosFinder the fondos mutuos finder
	 */
	public void setFondosMutuosFinder(FondosMutuosFinder fondosMutuosFinder) {
		this.fondosMutuosFinder = fondosMutuosFinder;
	}

	/**
	 * Returns the log incidencias local service.
	 *
	 * @return the log incidencias local service
	 */
	public LogIncidenciasLocalService getLogIncidenciasLocalService() {
		return logIncidenciasLocalService;
	}

	/**
	 * Sets the log incidencias local service.
	 *
	 * @param logIncidenciasLocalService the log incidencias local service
	 */
	public void setLogIncidenciasLocalService(
		LogIncidenciasLocalService logIncidenciasLocalService) {
		this.logIncidenciasLocalService = logIncidenciasLocalService;
	}

	/**
	 * Returns the log incidencias remote service.
	 *
	 * @return the log incidencias remote service
	 */
	public LogIncidenciasService getLogIncidenciasService() {
		return logIncidenciasService;
	}

	/**
	 * Sets the log incidencias remote service.
	 *
	 * @param logIncidenciasService the log incidencias remote service
	 */
	public void setLogIncidenciasService(
		LogIncidenciasService logIncidenciasService) {
		this.logIncidenciasService = logIncidenciasService;
	}

	/**
	 * Returns the log incidencias persistence.
	 *
	 * @return the log incidencias persistence
	 */
	public LogIncidenciasPersistence getLogIncidenciasPersistence() {
		return logIncidenciasPersistence;
	}

	/**
	 * Sets the log incidencias persistence.
	 *
	 * @param logIncidenciasPersistence the log incidencias persistence
	 */
	public void setLogIncidenciasPersistence(
		LogIncidenciasPersistence logIncidenciasPersistence) {
		this.logIncidenciasPersistence = logIncidenciasPersistence;
	}

	/**
	 * Returns the log incidencias finder.
	 *
	 * @return the log incidencias finder
	 */
	public LogIncidenciasFinder getLogIncidenciasFinder() {
		return logIncidenciasFinder;
	}

	/**
	 * Sets the log incidencias finder.
	 *
	 * @param logIncidenciasFinder the log incidencias finder
	 */
	public void setLogIncidenciasFinder(
		LogIncidenciasFinder logIncidenciasFinder) {
		this.logIncidenciasFinder = logIncidenciasFinder;
	}

	/**
	 * Returns the ocurrencia local service.
	 *
	 * @return the ocurrencia local service
	 */
	public OcurrenciaLocalService getOcurrenciaLocalService() {
		return ocurrenciaLocalService;
	}

	/**
	 * Sets the ocurrencia local service.
	 *
	 * @param ocurrenciaLocalService the ocurrencia local service
	 */
	public void setOcurrenciaLocalService(
		OcurrenciaLocalService ocurrenciaLocalService) {
		this.ocurrenciaLocalService = ocurrenciaLocalService;
	}

	/**
	 * Returns the ocurrencia remote service.
	 *
	 * @return the ocurrencia remote service
	 */
	public OcurrenciaService getOcurrenciaService() {
		return ocurrenciaService;
	}

	/**
	 * Sets the ocurrencia remote service.
	 *
	 * @param ocurrenciaService the ocurrencia remote service
	 */
	public void setOcurrenciaService(OcurrenciaService ocurrenciaService) {
		this.ocurrenciaService = ocurrenciaService;
	}

	/**
	 * Returns the ocurrencia persistence.
	 *
	 * @return the ocurrencia persistence
	 */
	public OcurrenciaPersistence getOcurrenciaPersistence() {
		return ocurrenciaPersistence;
	}

	/**
	 * Sets the ocurrencia persistence.
	 *
	 * @param ocurrenciaPersistence the ocurrencia persistence
	 */
	public void setOcurrenciaPersistence(
		OcurrenciaPersistence ocurrenciaPersistence) {
		this.ocurrenciaPersistence = ocurrenciaPersistence;
	}

	/**
	 * Returns the ocurrencia finder.
	 *
	 * @return the ocurrencia finder
	 */
	public OcurrenciaFinder getOcurrenciaFinder() {
		return ocurrenciaFinder;
	}

	/**
	 * Sets the ocurrencia finder.
	 *
	 * @param ocurrenciaFinder the ocurrencia finder
	 */
	public void setOcurrenciaFinder(OcurrenciaFinder ocurrenciaFinder) {
		this.ocurrenciaFinder = ocurrenciaFinder;
	}

	/**
	 * Returns the pais local service.
	 *
	 * @return the pais local service
	 */
	public PaisLocalService getPaisLocalService() {
		return paisLocalService;
	}

	/**
	 * Sets the pais local service.
	 *
	 * @param paisLocalService the pais local service
	 */
	public void setPaisLocalService(PaisLocalService paisLocalService) {
		this.paisLocalService = paisLocalService;
	}

	/**
	 * Returns the pais remote service.
	 *
	 * @return the pais remote service
	 */
	public PaisService getPaisService() {
		return paisService;
	}

	/**
	 * Sets the pais remote service.
	 *
	 * @param paisService the pais remote service
	 */
	public void setPaisService(PaisService paisService) {
		this.paisService = paisService;
	}

	/**
	 * Returns the pais persistence.
	 *
	 * @return the pais persistence
	 */
	public PaisPersistence getPaisPersistence() {
		return paisPersistence;
	}

	/**
	 * Sets the pais persistence.
	 *
	 * @param paisPersistence the pais persistence
	 */
	public void setPaisPersistence(PaisPersistence paisPersistence) {
		this.paisPersistence = paisPersistence;
	}

	/**
	 * Returns the pais finder.
	 *
	 * @return the pais finder
	 */
	public PaisFinder getPaisFinder() {
		return paisFinder;
	}

	/**
	 * Sets the pais finder.
	 *
	 * @param paisFinder the pais finder
	 */
	public void setPaisFinder(PaisFinder paisFinder) {
		this.paisFinder = paisFinder;
	}

	/**
	 * Returns the parametro local service.
	 *
	 * @return the parametro local service
	 */
	public ParametroLocalService getParametroLocalService() {
		return parametroLocalService;
	}

	/**
	 * Sets the parametro local service.
	 *
	 * @param parametroLocalService the parametro local service
	 */
	public void setParametroLocalService(
		ParametroLocalService parametroLocalService) {
		this.parametroLocalService = parametroLocalService;
	}

	/**
	 * Returns the parametro remote service.
	 *
	 * @return the parametro remote service
	 */
	public ParametroService getParametroService() {
		return parametroService;
	}

	/**
	 * Sets the parametro remote service.
	 *
	 * @param parametroService the parametro remote service
	 */
	public void setParametroService(ParametroService parametroService) {
		this.parametroService = parametroService;
	}

	/**
	 * Returns the parametro persistence.
	 *
	 * @return the parametro persistence
	 */
	public ParametroPersistence getParametroPersistence() {
		return parametroPersistence;
	}

	/**
	 * Sets the parametro persistence.
	 *
	 * @param parametroPersistence the parametro persistence
	 */
	public void setParametroPersistence(
		ParametroPersistence parametroPersistence) {
		this.parametroPersistence = parametroPersistence;
	}

	/**
	 * Returns the parametro finder.
	 *
	 * @return the parametro finder
	 */
	public ParametroFinder getParametroFinder() {
		return parametroFinder;
	}

	/**
	 * Sets the parametro finder.
	 *
	 * @param parametroFinder the parametro finder
	 */
	public void setParametroFinder(ParametroFinder parametroFinder) {
		this.parametroFinder = parametroFinder;
	}

	/**
	 * Returns the pregunta frecuente local service.
	 *
	 * @return the pregunta frecuente local service
	 */
	public PreguntaFrecuenteLocalService getPreguntaFrecuenteLocalService() {
		return preguntaFrecuenteLocalService;
	}

	/**
	 * Sets the pregunta frecuente local service.
	 *
	 * @param preguntaFrecuenteLocalService the pregunta frecuente local service
	 */
	public void setPreguntaFrecuenteLocalService(
		PreguntaFrecuenteLocalService preguntaFrecuenteLocalService) {
		this.preguntaFrecuenteLocalService = preguntaFrecuenteLocalService;
	}

	/**
	 * Returns the pregunta frecuente remote service.
	 *
	 * @return the pregunta frecuente remote service
	 */
	public PreguntaFrecuenteService getPreguntaFrecuenteService() {
		return preguntaFrecuenteService;
	}

	/**
	 * Sets the pregunta frecuente remote service.
	 *
	 * @param preguntaFrecuenteService the pregunta frecuente remote service
	 */
	public void setPreguntaFrecuenteService(
		PreguntaFrecuenteService preguntaFrecuenteService) {
		this.preguntaFrecuenteService = preguntaFrecuenteService;
	}

	/**
	 * Returns the pregunta frecuente persistence.
	 *
	 * @return the pregunta frecuente persistence
	 */
	public PreguntaFrecuentePersistence getPreguntaFrecuentePersistence() {
		return preguntaFrecuentePersistence;
	}

	/**
	 * Sets the pregunta frecuente persistence.
	 *
	 * @param preguntaFrecuentePersistence the pregunta frecuente persistence
	 */
	public void setPreguntaFrecuentePersistence(
		PreguntaFrecuentePersistence preguntaFrecuentePersistence) {
		this.preguntaFrecuentePersistence = preguntaFrecuentePersistence;
	}

	/**
	 * Returns the producto complementario local service.
	 *
	 * @return the producto complementario local service
	 */
	public ProductoComplementarioLocalService getProductoComplementarioLocalService() {
		return productoComplementarioLocalService;
	}

	/**
	 * Sets the producto complementario local service.
	 *
	 * @param productoComplementarioLocalService the producto complementario local service
	 */
	public void setProductoComplementarioLocalService(
		ProductoComplementarioLocalService productoComplementarioLocalService) {
		this.productoComplementarioLocalService = productoComplementarioLocalService;
	}

	/**
	 * Returns the producto complementario remote service.
	 *
	 * @return the producto complementario remote service
	 */
	public ProductoComplementarioService getProductoComplementarioService() {
		return productoComplementarioService;
	}

	/**
	 * Sets the producto complementario remote service.
	 *
	 * @param productoComplementarioService the producto complementario remote service
	 */
	public void setProductoComplementarioService(
		ProductoComplementarioService productoComplementarioService) {
		this.productoComplementarioService = productoComplementarioService;
	}

	/**
	 * Returns the producto complementario persistence.
	 *
	 * @return the producto complementario persistence
	 */
	public ProductoComplementarioPersistence getProductoComplementarioPersistence() {
		return productoComplementarioPersistence;
	}

	/**
	 * Sets the producto complementario persistence.
	 *
	 * @param productoComplementarioPersistence the producto complementario persistence
	 */
	public void setProductoComplementarioPersistence(
		ProductoComplementarioPersistence productoComplementarioPersistence) {
		this.productoComplementarioPersistence = productoComplementarioPersistence;
	}

	/**
	 * Returns the solicitud contacto local service.
	 *
	 * @return the solicitud contacto local service
	 */
	public SolicitudContactoLocalService getSolicitudContactoLocalService() {
		return solicitudContactoLocalService;
	}

	/**
	 * Sets the solicitud contacto local service.
	 *
	 * @param solicitudContactoLocalService the solicitud contacto local service
	 */
	public void setSolicitudContactoLocalService(
		SolicitudContactoLocalService solicitudContactoLocalService) {
		this.solicitudContactoLocalService = solicitudContactoLocalService;
	}

	/**
	 * Returns the solicitud contacto persistence.
	 *
	 * @return the solicitud contacto persistence
	 */
	public SolicitudContactoPersistence getSolicitudContactoPersistence() {
		return solicitudContactoPersistence;
	}

	/**
	 * Sets the solicitud contacto persistence.
	 *
	 * @param solicitudContactoPersistence the solicitud contacto persistence
	 */
	public void setSolicitudContactoPersistence(
		SolicitudContactoPersistence solicitudContactoPersistence) {
		this.solicitudContactoPersistence = solicitudContactoPersistence;
	}

	/**
	 * Returns the solicitud producto local service.
	 *
	 * @return the solicitud producto local service
	 */
	public SolicitudProductoLocalService getSolicitudProductoLocalService() {
		return solicitudProductoLocalService;
	}

	/**
	 * Sets the solicitud producto local service.
	 *
	 * @param solicitudProductoLocalService the solicitud producto local service
	 */
	public void setSolicitudProductoLocalService(
		SolicitudProductoLocalService solicitudProductoLocalService) {
		this.solicitudProductoLocalService = solicitudProductoLocalService;
	}

	/**
	 * Returns the solicitud producto remote service.
	 *
	 * @return the solicitud producto remote service
	 */
	public SolicitudProductoService getSolicitudProductoService() {
		return solicitudProductoService;
	}

	/**
	 * Sets the solicitud producto remote service.
	 *
	 * @param solicitudProductoService the solicitud producto remote service
	 */
	public void setSolicitudProductoService(
		SolicitudProductoService solicitudProductoService) {
		this.solicitudProductoService = solicitudProductoService;
	}

	/**
	 * Returns the solicitud producto persistence.
	 *
	 * @return the solicitud producto persistence
	 */
	public SolicitudProductoPersistence getSolicitudProductoPersistence() {
		return solicitudProductoPersistence;
	}

	/**
	 * Sets the solicitud producto persistence.
	 *
	 * @param solicitudProductoPersistence the solicitud producto persistence
	 */
	public void setSolicitudProductoPersistence(
		SolicitudProductoPersistence solicitudProductoPersistence) {
		this.solicitudProductoPersistence = solicitudProductoPersistence;
	}

	/**
	 * Returns the solicitud producto finder.
	 *
	 * @return the solicitud producto finder
	 */
	public SolicitudProductoFinder getSolicitudProductoFinder() {
		return solicitudProductoFinder;
	}

	/**
	 * Sets the solicitud producto finder.
	 *
	 * @param solicitudProductoFinder the solicitud producto finder
	 */
	public void setSolicitudProductoFinder(
		SolicitudProductoFinder solicitudProductoFinder) {
		this.solicitudProductoFinder = solicitudProductoFinder;
	}

	/**
	 * Returns the telefono solicitud producto local service.
	 *
	 * @return the telefono solicitud producto local service
	 */
	public TelefonoSolicitudProductoLocalService getTelefonoSolicitudProductoLocalService() {
		return telefonoSolicitudProductoLocalService;
	}

	/**
	 * Sets the telefono solicitud producto local service.
	 *
	 * @param telefonoSolicitudProductoLocalService the telefono solicitud producto local service
	 */
	public void setTelefonoSolicitudProductoLocalService(
		TelefonoSolicitudProductoLocalService telefonoSolicitudProductoLocalService) {
		this.telefonoSolicitudProductoLocalService = telefonoSolicitudProductoLocalService;
	}

	/**
	 * Returns the telefono solicitud producto remote service.
	 *
	 * @return the telefono solicitud producto remote service
	 */
	public TelefonoSolicitudProductoService getTelefonoSolicitudProductoService() {
		return telefonoSolicitudProductoService;
	}

	/**
	 * Sets the telefono solicitud producto remote service.
	 *
	 * @param telefonoSolicitudProductoService the telefono solicitud producto remote service
	 */
	public void setTelefonoSolicitudProductoService(
		TelefonoSolicitudProductoService telefonoSolicitudProductoService) {
		this.telefonoSolicitudProductoService = telefonoSolicitudProductoService;
	}

	/**
	 * Returns the telefono solicitud producto persistence.
	 *
	 * @return the telefono solicitud producto persistence
	 */
	public TelefonoSolicitudProductoPersistence getTelefonoSolicitudProductoPersistence() {
		return telefonoSolicitudProductoPersistence;
	}

	/**
	 * Sets the telefono solicitud producto persistence.
	 *
	 * @param telefonoSolicitudProductoPersistence the telefono solicitud producto persistence
	 */
	public void setTelefonoSolicitudProductoPersistence(
		TelefonoSolicitudProductoPersistence telefonoSolicitudProductoPersistence) {
		this.telefonoSolicitudProductoPersistence = telefonoSolicitudProductoPersistence;
	}

	/**
	 * Returns the ubigeo local service.
	 *
	 * @return the ubigeo local service
	 */
	public UbigeoLocalService getUbigeoLocalService() {
		return ubigeoLocalService;
	}

	/**
	 * Sets the ubigeo local service.
	 *
	 * @param ubigeoLocalService the ubigeo local service
	 */
	public void setUbigeoLocalService(UbigeoLocalService ubigeoLocalService) {
		this.ubigeoLocalService = ubigeoLocalService;
	}

	/**
	 * Returns the ubigeo remote service.
	 *
	 * @return the ubigeo remote service
	 */
	public UbigeoService getUbigeoService() {
		return ubigeoService;
	}

	/**
	 * Sets the ubigeo remote service.
	 *
	 * @param ubigeoService the ubigeo remote service
	 */
	public void setUbigeoService(UbigeoService ubigeoService) {
		this.ubigeoService = ubigeoService;
	}

	/**
	 * Returns the ubigeo persistence.
	 *
	 * @return the ubigeo persistence
	 */
	public UbigeoPersistence getUbigeoPersistence() {
		return ubigeoPersistence;
	}

	/**
	 * Sets the ubigeo persistence.
	 *
	 * @param ubigeoPersistence the ubigeo persistence
	 */
	public void setUbigeoPersistence(UbigeoPersistence ubigeoPersistence) {
		this.ubigeoPersistence = ubigeoPersistence;
	}

	/**
	 * Returns the ubigeo finder.
	 *
	 * @return the ubigeo finder
	 */
	public UbigeoFinder getUbigeoFinder() {
		return ubigeoFinder;
	}

	/**
	 * Sets the ubigeo finder.
	 *
	 * @param ubigeoFinder the ubigeo finder
	 */
	public void setUbigeoFinder(UbigeoFinder ubigeoFinder) {
		this.ubigeoFinder = ubigeoFinder;
	}

	/**
	 * Returns the valor cuota local service.
	 *
	 * @return the valor cuota local service
	 */
	public ValorCuotaLocalService getValorCuotaLocalService() {
		return valorCuotaLocalService;
	}

	/**
	 * Sets the valor cuota local service.
	 *
	 * @param valorCuotaLocalService the valor cuota local service
	 */
	public void setValorCuotaLocalService(
		ValorCuotaLocalService valorCuotaLocalService) {
		this.valorCuotaLocalService = valorCuotaLocalService;
	}

	/**
	 * Returns the valor cuota remote service.
	 *
	 * @return the valor cuota remote service
	 */
	public ValorCuotaService getValorCuotaService() {
		return valorCuotaService;
	}

	/**
	 * Sets the valor cuota remote service.
	 *
	 * @param valorCuotaService the valor cuota remote service
	 */
	public void setValorCuotaService(ValorCuotaService valorCuotaService) {
		this.valorCuotaService = valorCuotaService;
	}

	/**
	 * Returns the valor cuota persistence.
	 *
	 * @return the valor cuota persistence
	 */
	public ValorCuotaPersistence getValorCuotaPersistence() {
		return valorCuotaPersistence;
	}

	/**
	 * Sets the valor cuota persistence.
	 *
	 * @param valorCuotaPersistence the valor cuota persistence
	 */
	public void setValorCuotaPersistence(
		ValorCuotaPersistence valorCuotaPersistence) {
		this.valorCuotaPersistence = valorCuotaPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.ext.portlet.halcon.model.Pais",
			paisLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.ext.portlet.halcon.model.Pais");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Pais.class;
	}

	protected String getModelClassName() {
		return Pais.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = paisPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = AuditoriaCajaSorpresaLocalService.class)
	protected AuditoriaCajaSorpresaLocalService auditoriaCajaSorpresaLocalService;
	@BeanReference(type = AuditoriaCajaSorpresaService.class)
	protected AuditoriaCajaSorpresaService auditoriaCajaSorpresaService;
	@BeanReference(type = AuditoriaCajaSorpresaPersistence.class)
	protected AuditoriaCajaSorpresaPersistence auditoriaCajaSorpresaPersistence;
	@BeanReference(type = AuditoriaCajaSorpresaFinder.class)
	protected AuditoriaCajaSorpresaFinder auditoriaCajaSorpresaFinder;
	@BeanReference(type = AuditoriaPerfiladorLocalService.class)
	protected AuditoriaPerfiladorLocalService auditoriaPerfiladorLocalService;
	@BeanReference(type = AuditoriaPerfiladorService.class)
	protected AuditoriaPerfiladorService auditoriaPerfiladorService;
	@BeanReference(type = AuditoriaPerfiladorPersistence.class)
	protected AuditoriaPerfiladorPersistence auditoriaPerfiladorPersistence;
	@BeanReference(type = AuditoriaSimuladorLocalService.class)
	protected AuditoriaSimuladorLocalService auditoriaSimuladorLocalService;
	@BeanReference(type = AuditoriaSimuladorService.class)
	protected AuditoriaSimuladorService auditoriaSimuladorService;
	@BeanReference(type = AuditoriaSimuladorPersistence.class)
	protected AuditoriaSimuladorPersistence auditoriaSimuladorPersistence;
	@BeanReference(type = AuditoriaSimuladorFinder.class)
	protected AuditoriaSimuladorFinder auditoriaSimuladorFinder;
	@BeanReference(type = CargaDescuentoLocalService.class)
	protected CargaDescuentoLocalService cargaDescuentoLocalService;
	@BeanReference(type = CargaDescuentoService.class)
	protected CargaDescuentoService cargaDescuentoService;
	@BeanReference(type = CargaDescuentoPersistence.class)
	protected CargaDescuentoPersistence cargaDescuentoPersistence;
	@BeanReference(type = CargaDescuentoFinder.class)
	protected CargaDescuentoFinder cargaDescuentoFinder;
	@BeanReference(type = CargaSocioRemesaLocalService.class)
	protected CargaSocioRemesaLocalService cargaSocioRemesaLocalService;
	@BeanReference(type = CargaSocioRemesaService.class)
	protected CargaSocioRemesaService cargaSocioRemesaService;
	@BeanReference(type = CargaSocioRemesaPersistence.class)
	protected CargaSocioRemesaPersistence cargaSocioRemesaPersistence;
	@BeanReference(type = CargaSocioRemesaFinder.class)
	protected CargaSocioRemesaFinder cargaSocioRemesaFinder;
	@BeanReference(type = CargaTiendaLocalService.class)
	protected CargaTiendaLocalService cargaTiendaLocalService;
	@BeanReference(type = CargaTiendaService.class)
	protected CargaTiendaService cargaTiendaService;
	@BeanReference(type = CargaTiendaPersistence.class)
	protected CargaTiendaPersistence cargaTiendaPersistence;
	@BeanReference(type = CargaTiendaFinder.class)
	protected CargaTiendaFinder cargaTiendaFinder;
	@BeanReference(type = CategoriaSubcategoriaLocalService.class)
	protected CategoriaSubcategoriaLocalService categoriaSubcategoriaLocalService;
	@BeanReference(type = CategoriaSubcategoriaService.class)
	protected CategoriaSubcategoriaService categoriaSubcategoriaService;
	@BeanReference(type = CategoriaSubcategoriaPersistence.class)
	protected CategoriaSubcategoriaPersistence categoriaSubcategoriaPersistence;
	@BeanReference(type = CategoriaSubcategoriaFinder.class)
	protected CategoriaSubcategoriaFinder categoriaSubcategoriaFinder;
	@BeanReference(type = ConfiguracionPerfiladorLocalService.class)
	protected ConfiguracionPerfiladorLocalService configuracionPerfiladorLocalService;
	@BeanReference(type = ConfiguracionPerfiladorService.class)
	protected ConfiguracionPerfiladorService configuracionPerfiladorService;
	@BeanReference(type = ConfiguracionPerfiladorPersistence.class)
	protected ConfiguracionPerfiladorPersistence configuracionPerfiladorPersistence;
	@BeanReference(type = ConfiguracionPerfiladorFinder.class)
	protected ConfiguracionPerfiladorFinder configuracionPerfiladorFinder;
	@BeanReference(type = ConfiguracionProductoLocalService.class)
	protected ConfiguracionProductoLocalService configuracionProductoLocalService;
	@BeanReference(type = ConfiguracionProductoService.class)
	protected ConfiguracionProductoService configuracionProductoService;
	@BeanReference(type = ConfiguracionProductoPersistence.class)
	protected ConfiguracionProductoPersistence configuracionProductoPersistence;
	@BeanReference(type = FondosMutuosLocalService.class)
	protected FondosMutuosLocalService fondosMutuosLocalService;
	@BeanReference(type = FondosMutuosService.class)
	protected FondosMutuosService fondosMutuosService;
	@BeanReference(type = FondosMutuosPersistence.class)
	protected FondosMutuosPersistence fondosMutuosPersistence;
	@BeanReference(type = FondosMutuosFinder.class)
	protected FondosMutuosFinder fondosMutuosFinder;
	@BeanReference(type = LogIncidenciasLocalService.class)
	protected LogIncidenciasLocalService logIncidenciasLocalService;
	@BeanReference(type = LogIncidenciasService.class)
	protected LogIncidenciasService logIncidenciasService;
	@BeanReference(type = LogIncidenciasPersistence.class)
	protected LogIncidenciasPersistence logIncidenciasPersistence;
	@BeanReference(type = LogIncidenciasFinder.class)
	protected LogIncidenciasFinder logIncidenciasFinder;
	@BeanReference(type = OcurrenciaLocalService.class)
	protected OcurrenciaLocalService ocurrenciaLocalService;
	@BeanReference(type = OcurrenciaService.class)
	protected OcurrenciaService ocurrenciaService;
	@BeanReference(type = OcurrenciaPersistence.class)
	protected OcurrenciaPersistence ocurrenciaPersistence;
	@BeanReference(type = OcurrenciaFinder.class)
	protected OcurrenciaFinder ocurrenciaFinder;
	@BeanReference(type = PaisLocalService.class)
	protected PaisLocalService paisLocalService;
	@BeanReference(type = PaisService.class)
	protected PaisService paisService;
	@BeanReference(type = PaisPersistence.class)
	protected PaisPersistence paisPersistence;
	@BeanReference(type = PaisFinder.class)
	protected PaisFinder paisFinder;
	@BeanReference(type = ParametroLocalService.class)
	protected ParametroLocalService parametroLocalService;
	@BeanReference(type = ParametroService.class)
	protected ParametroService parametroService;
	@BeanReference(type = ParametroPersistence.class)
	protected ParametroPersistence parametroPersistence;
	@BeanReference(type = ParametroFinder.class)
	protected ParametroFinder parametroFinder;
	@BeanReference(type = PreguntaFrecuenteLocalService.class)
	protected PreguntaFrecuenteLocalService preguntaFrecuenteLocalService;
	@BeanReference(type = PreguntaFrecuenteService.class)
	protected PreguntaFrecuenteService preguntaFrecuenteService;
	@BeanReference(type = PreguntaFrecuentePersistence.class)
	protected PreguntaFrecuentePersistence preguntaFrecuentePersistence;
	@BeanReference(type = ProductoComplementarioLocalService.class)
	protected ProductoComplementarioLocalService productoComplementarioLocalService;
	@BeanReference(type = ProductoComplementarioService.class)
	protected ProductoComplementarioService productoComplementarioService;
	@BeanReference(type = ProductoComplementarioPersistence.class)
	protected ProductoComplementarioPersistence productoComplementarioPersistence;
	@BeanReference(type = SolicitudContactoLocalService.class)
	protected SolicitudContactoLocalService solicitudContactoLocalService;
	@BeanReference(type = SolicitudContactoPersistence.class)
	protected SolicitudContactoPersistence solicitudContactoPersistence;
	@BeanReference(type = SolicitudProductoLocalService.class)
	protected SolicitudProductoLocalService solicitudProductoLocalService;
	@BeanReference(type = SolicitudProductoService.class)
	protected SolicitudProductoService solicitudProductoService;
	@BeanReference(type = SolicitudProductoPersistence.class)
	protected SolicitudProductoPersistence solicitudProductoPersistence;
	@BeanReference(type = SolicitudProductoFinder.class)
	protected SolicitudProductoFinder solicitudProductoFinder;
	@BeanReference(type = TelefonoSolicitudProductoLocalService.class)
	protected TelefonoSolicitudProductoLocalService telefonoSolicitudProductoLocalService;
	@BeanReference(type = TelefonoSolicitudProductoService.class)
	protected TelefonoSolicitudProductoService telefonoSolicitudProductoService;
	@BeanReference(type = TelefonoSolicitudProductoPersistence.class)
	protected TelefonoSolicitudProductoPersistence telefonoSolicitudProductoPersistence;
	@BeanReference(type = UbigeoLocalService.class)
	protected UbigeoLocalService ubigeoLocalService;
	@BeanReference(type = UbigeoService.class)
	protected UbigeoService ubigeoService;
	@BeanReference(type = UbigeoPersistence.class)
	protected UbigeoPersistence ubigeoPersistence;
	@BeanReference(type = UbigeoFinder.class)
	protected UbigeoFinder ubigeoFinder;
	@BeanReference(type = ValorCuotaLocalService.class)
	protected ValorCuotaLocalService valorCuotaLocalService;
	@BeanReference(type = ValorCuotaService.class)
	protected ValorCuotaService valorCuotaService;
	@BeanReference(type = ValorCuotaPersistence.class)
	protected ValorCuotaPersistence valorCuotaPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private PaisLocalServiceClpInvoker _clpInvoker = new PaisLocalServiceClpInvoker();
}