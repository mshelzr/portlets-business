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

package com.ext.portlet.halcon.service.persistence;

import com.ext.portlet.halcon.NoSuchSolicitudProductoException;
import com.ext.portlet.halcon.model.SolicitudProducto;
import com.ext.portlet.halcon.model.impl.SolicitudProductoImpl;
import com.ext.portlet.halcon.model.impl.SolicitudProductoModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the solicitud producto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudProductoPersistence
 * @see SolicitudProductoUtil
 * @generated
 */
public class SolicitudProductoPersistenceImpl extends BasePersistenceImpl<SolicitudProducto>
	implements SolicitudProductoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SolicitudProductoUtil} to access the solicitud producto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SolicitudProductoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudProductoModelImpl.FINDER_CACHE_ENABLED,
			SolicitudProductoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudProductoModelImpl.FINDER_CACHE_ENABLED,
			SolicitudProductoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudProductoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the solicitud producto in the entity cache if it is enabled.
	 *
	 * @param solicitudProducto the solicitud producto
	 */
	public void cacheResult(SolicitudProducto solicitudProducto) {
		EntityCacheUtil.putResult(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudProductoImpl.class, solicitudProducto.getPrimaryKey(),
			solicitudProducto);

		solicitudProducto.resetOriginalValues();
	}

	/**
	 * Caches the solicitud productos in the entity cache if it is enabled.
	 *
	 * @param solicitudProductos the solicitud productos
	 */
	public void cacheResult(List<SolicitudProducto> solicitudProductos) {
		for (SolicitudProducto solicitudProducto : solicitudProductos) {
			if (EntityCacheUtil.getResult(
						SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
						SolicitudProductoImpl.class,
						solicitudProducto.getPrimaryKey()) == null) {
				cacheResult(solicitudProducto);
			}
			else {
				solicitudProducto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all solicitud productos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SolicitudProductoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SolicitudProductoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the solicitud producto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SolicitudProducto solicitudProducto) {
		EntityCacheUtil.removeResult(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudProductoImpl.class, solicitudProducto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SolicitudProducto> solicitudProductos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SolicitudProducto solicitudProducto : solicitudProductos) {
			EntityCacheUtil.removeResult(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
				SolicitudProductoImpl.class, solicitudProducto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new solicitud producto with the primary key. Does not add the solicitud producto to the database.
	 *
	 * @param idSolicitudProducto the primary key for the new solicitud producto
	 * @return the new solicitud producto
	 */
	public SolicitudProducto create(long idSolicitudProducto) {
		SolicitudProducto solicitudProducto = new SolicitudProductoImpl();

		solicitudProducto.setNew(true);
		solicitudProducto.setPrimaryKey(idSolicitudProducto);

		return solicitudProducto;
	}

	/**
	 * Removes the solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idSolicitudProducto the primary key of the solicitud producto
	 * @return the solicitud producto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SolicitudProducto remove(long idSolicitudProducto)
		throws NoSuchSolicitudProductoException, SystemException {
		return remove(Long.valueOf(idSolicitudProducto));
	}

	/**
	 * Removes the solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the solicitud producto
	 * @return the solicitud producto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SolicitudProducto remove(Serializable primaryKey)
		throws NoSuchSolicitudProductoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SolicitudProducto solicitudProducto = (SolicitudProducto)session.get(SolicitudProductoImpl.class,
					primaryKey);

			if (solicitudProducto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSolicitudProductoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(solicitudProducto);
		}
		catch (NoSuchSolicitudProductoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SolicitudProducto removeImpl(SolicitudProducto solicitudProducto)
		throws SystemException {
		solicitudProducto = toUnwrappedModel(solicitudProducto);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, solicitudProducto);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(solicitudProducto);

		return solicitudProducto;
	}

	@Override
	public SolicitudProducto updateImpl(
		com.ext.portlet.halcon.model.SolicitudProducto solicitudProducto,
		boolean merge) throws SystemException {
		solicitudProducto = toUnwrappedModel(solicitudProducto);

		boolean isNew = solicitudProducto.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, solicitudProducto, merge);

			solicitudProducto.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudProductoImpl.class, solicitudProducto.getPrimaryKey(),
			solicitudProducto);

		return solicitudProducto;
	}

	protected SolicitudProducto toUnwrappedModel(
		SolicitudProducto solicitudProducto) {
		if (solicitudProducto instanceof SolicitudProductoImpl) {
			return solicitudProducto;
		}

		SolicitudProductoImpl solicitudProductoImpl = new SolicitudProductoImpl();

		solicitudProductoImpl.setNew(solicitudProducto.isNew());
		solicitudProductoImpl.setPrimaryKey(solicitudProducto.getPrimaryKey());

		solicitudProductoImpl.setIdSolicitudProducto(solicitudProducto.getIdSolicitudProducto());
		solicitudProductoImpl.setIdTipoDocumentoAdq(solicitudProducto.getIdTipoDocumentoAdq());
		solicitudProductoImpl.setIdTipoDocumento(solicitudProducto.getIdTipoDocumento());
		solicitudProductoImpl.setTipoCredito(solicitudProducto.getTipoCredito());
		solicitudProductoImpl.setCodigoCanal(solicitudProducto.getCodigoCanal());
		solicitudProductoImpl.setTipoEnvio(solicitudProducto.getTipoEnvio());
		solicitudProductoImpl.setNumeroDocumento(solicitudProducto.getNumeroDocumento());
		solicitudProductoImpl.setApellidoPaterno(solicitudProducto.getApellidoPaterno());
		solicitudProductoImpl.setApellidoMaterno(solicitudProducto.getApellidoMaterno());
		solicitudProductoImpl.setPrimerNombre(solicitudProducto.getPrimerNombre());
		solicitudProductoImpl.setSegundoNombre(solicitudProducto.getSegundoNombre());
		solicitudProductoImpl.setFechaNacimiento(solicitudProducto.getFechaNacimiento());
		solicitudProductoImpl.setSexo(solicitudProducto.getSexo());
		solicitudProductoImpl.setRentaMensual(solicitudProducto.getRentaMensual());
		solicitudProductoImpl.setCelular(solicitudProducto.getCelular());
		solicitudProductoImpl.setTelefonoCasa(solicitudProducto.getTelefonoCasa());
		solicitudProductoImpl.setTelefonoTrabajo(solicitudProducto.getTelefonoTrabajo());
		solicitudProductoImpl.setAnexo(solicitudProducto.getAnexo());
		solicitudProductoImpl.setIdEstadoCivilAdq(solicitudProducto.getIdEstadoCivilAdq());
		solicitudProductoImpl.setIdEstadoCivil(solicitudProducto.getIdEstadoCivil());
		solicitudProductoImpl.setRUC(solicitudProducto.getRUC());
		solicitudProductoImpl.setRazonSocial(solicitudProducto.getRazonSocial());
		solicitudProductoImpl.setSituacionLaboral(solicitudProducto.getSituacionLaboral());
		solicitudProductoImpl.setIdSituacionLaboral(solicitudProducto.getIdSituacionLaboral());
		solicitudProductoImpl.setIdDepartamento(solicitudProducto.getIdDepartamento());
		solicitudProductoImpl.setIdProvincia(solicitudProducto.getIdProvincia());
		solicitudProductoImpl.setIdDistrito(solicitudProducto.getIdDistrito());
		solicitudProductoImpl.setNomDepartamento(solicitudProducto.getNomDepartamento());
		solicitudProductoImpl.setNomProvincia(solicitudProducto.getNomProvincia());
		solicitudProductoImpl.setNomDistrito(solicitudProducto.getNomDistrito());
		solicitudProductoImpl.setCorreoElectronico(solicitudProducto.getCorreoElectronico());
		solicitudProductoImpl.setDireccionEnvio(solicitudProducto.getDireccionEnvio());
		solicitudProductoImpl.setPlacaVehiculo(solicitudProducto.getPlacaVehiculo());
		solicitudProductoImpl.setIdSession(solicitudProducto.getIdSession());
		solicitudProductoImpl.setIPCliente(solicitudProducto.getIPCliente());
		solicitudProductoImpl.setHorarioEnvio(solicitudProducto.getHorarioEnvio());
		solicitudProductoImpl.setFechaRegistro(solicitudProducto.getFechaRegistro());
		solicitudProductoImpl.setUTMSource(solicitudProducto.getUTMSource());
		solicitudProductoImpl.setUTMMedium(solicitudProducto.getUTMMedium());
		solicitudProductoImpl.setUTMCampaing(solicitudProducto.getUTMCampaing());
		solicitudProductoImpl.setUTMContent(solicitudProducto.getUTMContent());
		solicitudProductoImpl.setFechaResultadoPreCalif(solicitudProducto.getFechaResultadoPreCalif());
		solicitudProductoImpl.setFechaEnvioLead(solicitudProducto.getFechaEnvioLead());
		solicitudProductoImpl.setFechaEnvioEmailing(solicitudProducto.getFechaEnvioEmailing());
		solicitudProductoImpl.setEstadoPreCalificacion(solicitudProducto.getEstadoPreCalificacion());
		solicitudProductoImpl.setEstadoRegLead(solicitudProducto.getEstadoRegLead());
		solicitudProductoImpl.setEstadoEnvCorreo(solicitudProducto.getEstadoEnvCorreo());
		solicitudProductoImpl.setRespPreCalificacion(solicitudProducto.getRespPreCalificacion());
		solicitudProductoImpl.setDescripcionLead(solicitudProducto.getDescripcionLead());
		solicitudProductoImpl.setFechaActualizacion(solicitudProducto.getFechaActualizacion());
		solicitudProductoImpl.setMontoProspectado(solicitudProducto.getMontoProspectado());
		solicitudProductoImpl.setCodigoCampania(solicitudProducto.getCodigoCampania());
		solicitudProductoImpl.setCodigoMoneda(solicitudProducto.getCodigoMoneda());
		solicitudProductoImpl.setNombreSupervisor(solicitudProducto.getNombreSupervisor());
		solicitudProductoImpl.setRespRegLead(solicitudProducto.getRespRegLead());

		return solicitudProductoImpl;
	}

	/**
	 * Returns the solicitud producto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitud producto
	 * @return the solicitud producto
	 * @throws com.liferay.portal.NoSuchModelException if a solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SolicitudProducto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the solicitud producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchSolicitudProductoException} if it could not be found.
	 *
	 * @param idSolicitudProducto the primary key of the solicitud producto
	 * @return the solicitud producto
	 * @throws com.ext.portlet.halcon.NoSuchSolicitudProductoException if a solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SolicitudProducto findByPrimaryKey(long idSolicitudProducto)
		throws NoSuchSolicitudProductoException, SystemException {
		SolicitudProducto solicitudProducto = fetchByPrimaryKey(idSolicitudProducto);

		if (solicitudProducto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idSolicitudProducto);
			}

			throw new NoSuchSolicitudProductoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idSolicitudProducto);
		}

		return solicitudProducto;
	}

	/**
	 * Returns the solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitud producto
	 * @return the solicitud producto, or <code>null</code> if a solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SolicitudProducto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idSolicitudProducto the primary key of the solicitud producto
	 * @return the solicitud producto, or <code>null</code> if a solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SolicitudProducto fetchByPrimaryKey(long idSolicitudProducto)
		throws SystemException {
		SolicitudProducto solicitudProducto = (SolicitudProducto)EntityCacheUtil.getResult(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
				SolicitudProductoImpl.class, idSolicitudProducto);

		if (solicitudProducto == _nullSolicitudProducto) {
			return null;
		}

		if (solicitudProducto == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				solicitudProducto = (SolicitudProducto)session.get(SolicitudProductoImpl.class,
						Long.valueOf(idSolicitudProducto));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (solicitudProducto != null) {
					cacheResult(solicitudProducto);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
						SolicitudProductoImpl.class, idSolicitudProducto,
						_nullSolicitudProducto);
				}

				closeSession(session);
			}
		}

		return solicitudProducto;
	}

	/**
	 * Returns all the solicitud productos.
	 *
	 * @return the solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<SolicitudProducto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SolicitudProducto> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the solicitud productos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitud productos
	 * @param end the upper bound of the range of solicitud productos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<SolicitudProducto> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SolicitudProducto> list = (List<SolicitudProducto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOLICITUDPRODUCTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOLICITUDPRODUCTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SolicitudProducto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SolicitudProducto>)QueryUtil.list(q,
							getDialect(), start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the solicitud productos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SolicitudProducto solicitudProducto : findAll()) {
			remove(solicitudProducto);
		}
	}

	/**
	 * Returns the number of solicitud productos.
	 *
	 * @return the number of solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOLICITUDPRODUCTO);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the solicitud producto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.SolicitudProducto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SolicitudProducto>> listenersList = new ArrayList<ModelListener<SolicitudProducto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SolicitudProducto>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SolicitudProductoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = AuditoriaCajaSorpresaPersistence.class)
	protected AuditoriaCajaSorpresaPersistence auditoriaCajaSorpresaPersistence;
	@BeanReference(type = AuditoriaPerfiladorPersistence.class)
	protected AuditoriaPerfiladorPersistence auditoriaPerfiladorPersistence;
	@BeanReference(type = AuditoriaSimuladorPersistence.class)
	protected AuditoriaSimuladorPersistence auditoriaSimuladorPersistence;
	@BeanReference(type = CargaDescuentoPersistence.class)
	protected CargaDescuentoPersistence cargaDescuentoPersistence;
	@BeanReference(type = CargaSocioRemesaPersistence.class)
	protected CargaSocioRemesaPersistence cargaSocioRemesaPersistence;
	@BeanReference(type = CargaTiendaPersistence.class)
	protected CargaTiendaPersistence cargaTiendaPersistence;
	@BeanReference(type = CategoriaSubcategoriaPersistence.class)
	protected CategoriaSubcategoriaPersistence categoriaSubcategoriaPersistence;
	@BeanReference(type = ConfiguracionPerfiladorPersistence.class)
	protected ConfiguracionPerfiladorPersistence configuracionPerfiladorPersistence;
	@BeanReference(type = ConfiguracionProductoPersistence.class)
	protected ConfiguracionProductoPersistence configuracionProductoPersistence;
	@BeanReference(type = FondosMutuosPersistence.class)
	protected FondosMutuosPersistence fondosMutuosPersistence;
	@BeanReference(type = LogIncidenciasPersistence.class)
	protected LogIncidenciasPersistence logIncidenciasPersistence;
	@BeanReference(type = OcurrenciaPersistence.class)
	protected OcurrenciaPersistence ocurrenciaPersistence;
	@BeanReference(type = PaisPersistence.class)
	protected PaisPersistence paisPersistence;
	@BeanReference(type = ParametroPersistence.class)
	protected ParametroPersistence parametroPersistence;
	@BeanReference(type = PreguntaFrecuentePersistence.class)
	protected PreguntaFrecuentePersistence preguntaFrecuentePersistence;
	@BeanReference(type = ProductoComplementarioPersistence.class)
	protected ProductoComplementarioPersistence productoComplementarioPersistence;
	@BeanReference(type = SolicitudContactoPersistence.class)
	protected SolicitudContactoPersistence solicitudContactoPersistence;
	@BeanReference(type = SolicitudProductoPersistence.class)
	protected SolicitudProductoPersistence solicitudProductoPersistence;
	@BeanReference(type = TelefonoSolicitudProductoPersistence.class)
	protected TelefonoSolicitudProductoPersistence telefonoSolicitudProductoPersistence;
	@BeanReference(type = UbigeoPersistence.class)
	protected UbigeoPersistence ubigeoPersistence;
	@BeanReference(type = ValorCuotaPersistence.class)
	protected ValorCuotaPersistence valorCuotaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SOLICITUDPRODUCTO = "SELECT solicitudProducto FROM SolicitudProducto solicitudProducto";
	private static final String _SQL_COUNT_SOLICITUDPRODUCTO = "SELECT COUNT(solicitudProducto) FROM SolicitudProducto solicitudProducto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "solicitudProducto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SolicitudProducto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SolicitudProductoPersistenceImpl.class);
	private static SolicitudProducto _nullSolicitudProducto = new SolicitudProductoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SolicitudProducto> toCacheModel() {
				return _nullSolicitudProductoCacheModel;
			}
		};

	private static CacheModel<SolicitudProducto> _nullSolicitudProductoCacheModel =
		new CacheModel<SolicitudProducto>() {
			public SolicitudProducto toEntityModel() {
				return _nullSolicitudProducto;
			}
		};
}