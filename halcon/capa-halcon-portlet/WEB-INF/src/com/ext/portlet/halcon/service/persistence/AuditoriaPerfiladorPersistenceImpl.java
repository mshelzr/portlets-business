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

import com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException;
import com.ext.portlet.halcon.model.AuditoriaPerfilador;
import com.ext.portlet.halcon.model.impl.AuditoriaPerfiladorImpl;
import com.ext.portlet.halcon.model.impl.AuditoriaPerfiladorModelImpl;

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
 * The persistence implementation for the auditoria perfilador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaPerfiladorPersistence
 * @see AuditoriaPerfiladorUtil
 * @generated
 */
public class AuditoriaPerfiladorPersistenceImpl extends BasePersistenceImpl<AuditoriaPerfilador>
	implements AuditoriaPerfiladorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuditoriaPerfiladorUtil} to access the auditoria perfilador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuditoriaPerfiladorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaPerfiladorModelImpl.FINDER_CACHE_ENABLED,
			AuditoriaPerfiladorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaPerfiladorModelImpl.FINDER_CACHE_ENABLED,
			AuditoriaPerfiladorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaPerfiladorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the auditoria perfilador in the entity cache if it is enabled.
	 *
	 * @param auditoriaPerfilador the auditoria perfilador
	 */
	public void cacheResult(AuditoriaPerfilador auditoriaPerfilador) {
		EntityCacheUtil.putResult(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaPerfiladorImpl.class, auditoriaPerfilador.getPrimaryKey(),
			auditoriaPerfilador);

		auditoriaPerfilador.resetOriginalValues();
	}

	/**
	 * Caches the auditoria perfiladors in the entity cache if it is enabled.
	 *
	 * @param auditoriaPerfiladors the auditoria perfiladors
	 */
	public void cacheResult(List<AuditoriaPerfilador> auditoriaPerfiladors) {
		for (AuditoriaPerfilador auditoriaPerfilador : auditoriaPerfiladors) {
			if (EntityCacheUtil.getResult(
						AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
						AuditoriaPerfiladorImpl.class,
						auditoriaPerfilador.getPrimaryKey()) == null) {
				cacheResult(auditoriaPerfilador);
			}
			else {
				auditoriaPerfilador.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auditoria perfiladors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuditoriaPerfiladorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuditoriaPerfiladorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auditoria perfilador.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditoriaPerfilador auditoriaPerfilador) {
		EntityCacheUtil.removeResult(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaPerfiladorImpl.class, auditoriaPerfilador.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AuditoriaPerfilador> auditoriaPerfiladors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuditoriaPerfilador auditoriaPerfilador : auditoriaPerfiladors) {
			EntityCacheUtil.removeResult(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
				AuditoriaPerfiladorImpl.class,
				auditoriaPerfilador.getPrimaryKey());
		}
	}

	/**
	 * Creates a new auditoria perfilador with the primary key. Does not add the auditoria perfilador to the database.
	 *
	 * @param idAuditoriaPer the primary key for the new auditoria perfilador
	 * @return the new auditoria perfilador
	 */
	public AuditoriaPerfilador create(long idAuditoriaPer) {
		AuditoriaPerfilador auditoriaPerfilador = new AuditoriaPerfiladorImpl();

		auditoriaPerfilador.setNew(true);
		auditoriaPerfilador.setPrimaryKey(idAuditoriaPer);

		return auditoriaPerfilador;
	}

	/**
	 * Removes the auditoria perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idAuditoriaPer the primary key of the auditoria perfilador
	 * @return the auditoria perfilador that was removed
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaPerfilador remove(long idAuditoriaPer)
		throws NoSuchAuditoriaPerfiladorException, SystemException {
		return remove(Long.valueOf(idAuditoriaPer));
	}

	/**
	 * Removes the auditoria perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditoria perfilador
	 * @return the auditoria perfilador that was removed
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaPerfilador remove(Serializable primaryKey)
		throws NoSuchAuditoriaPerfiladorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AuditoriaPerfilador auditoriaPerfilador = (AuditoriaPerfilador)session.get(AuditoriaPerfiladorImpl.class,
					primaryKey);

			if (auditoriaPerfilador == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditoriaPerfiladorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(auditoriaPerfilador);
		}
		catch (NoSuchAuditoriaPerfiladorException nsee) {
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
	protected AuditoriaPerfilador removeImpl(
		AuditoriaPerfilador auditoriaPerfilador) throws SystemException {
		auditoriaPerfilador = toUnwrappedModel(auditoriaPerfilador);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, auditoriaPerfilador);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(auditoriaPerfilador);

		return auditoriaPerfilador;
	}

	@Override
	public AuditoriaPerfilador updateImpl(
		com.ext.portlet.halcon.model.AuditoriaPerfilador auditoriaPerfilador,
		boolean merge) throws SystemException {
		auditoriaPerfilador = toUnwrappedModel(auditoriaPerfilador);

		boolean isNew = auditoriaPerfilador.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, auditoriaPerfilador, merge);

			auditoriaPerfilador.setNew(false);
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

		EntityCacheUtil.putResult(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaPerfiladorImpl.class, auditoriaPerfilador.getPrimaryKey(),
			auditoriaPerfilador);

		return auditoriaPerfilador;
	}

	protected AuditoriaPerfilador toUnwrappedModel(
		AuditoriaPerfilador auditoriaPerfilador) {
		if (auditoriaPerfilador instanceof AuditoriaPerfiladorImpl) {
			return auditoriaPerfilador;
		}

		AuditoriaPerfiladorImpl auditoriaPerfiladorImpl = new AuditoriaPerfiladorImpl();

		auditoriaPerfiladorImpl.setNew(auditoriaPerfilador.isNew());
		auditoriaPerfiladorImpl.setPrimaryKey(auditoriaPerfilador.getPrimaryKey());

		auditoriaPerfiladorImpl.setIdAuditoriaPer(auditoriaPerfilador.getIdAuditoriaPer());
		auditoriaPerfiladorImpl.setTipoDocumento(auditoriaPerfilador.getTipoDocumento());
		auditoriaPerfiladorImpl.setNumeroDocumento(auditoriaPerfilador.getNumeroDocumento());
		auditoriaPerfiladorImpl.setPerfilador(auditoriaPerfilador.getPerfilador());
		auditoriaPerfiladorImpl.setSession(auditoriaPerfilador.getSession());
		auditoriaPerfiladorImpl.setTransaccion(auditoriaPerfilador.getTransaccion());
		auditoriaPerfiladorImpl.setMonto(auditoriaPerfilador.getMonto());
		auditoriaPerfiladorImpl.setTipoCredito(auditoriaPerfilador.getTipoCredito());
		auditoriaPerfiladorImpl.setIP(auditoriaPerfilador.getIP());
		auditoriaPerfiladorImpl.setFechaHora(auditoriaPerfilador.getFechaHora());
		auditoriaPerfiladorImpl.setUTMSource(auditoriaPerfilador.getUTMSource());
		auditoriaPerfiladorImpl.setUTMMedium(auditoriaPerfilador.getUTMMedium());
		auditoriaPerfiladorImpl.setUTMCampaing(auditoriaPerfilador.getUTMCampaing());
		auditoriaPerfiladorImpl.setUTMContent(auditoriaPerfilador.getUTMContent());
		auditoriaPerfiladorImpl.setPregunta01(auditoriaPerfilador.getPregunta01());
		auditoriaPerfiladorImpl.setPregunta02(auditoriaPerfilador.getPregunta02());
		auditoriaPerfiladorImpl.setPregunta03(auditoriaPerfilador.getPregunta03());
		auditoriaPerfiladorImpl.setPregunta04(auditoriaPerfilador.getPregunta04());
		auditoriaPerfiladorImpl.setRespuesta01(auditoriaPerfilador.getRespuesta01());
		auditoriaPerfiladorImpl.setRespuesta02(auditoriaPerfilador.getRespuesta02());
		auditoriaPerfiladorImpl.setRespuesta03(auditoriaPerfilador.getRespuesta03());
		auditoriaPerfiladorImpl.setRespuesta04(auditoriaPerfilador.getRespuesta04());

		return auditoriaPerfiladorImpl;
	}

	/**
	 * Returns the auditoria perfilador with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria perfilador
	 * @return the auditoria perfilador
	 * @throws com.liferay.portal.NoSuchModelException if a auditoria perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaPerfilador findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria perfilador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException} if it could not be found.
	 *
	 * @param idAuditoriaPer the primary key of the auditoria perfilador
	 * @return the auditoria perfilador
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaPerfiladorException if a auditoria perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaPerfilador findByPrimaryKey(long idAuditoriaPer)
		throws NoSuchAuditoriaPerfiladorException, SystemException {
		AuditoriaPerfilador auditoriaPerfilador = fetchByPrimaryKey(idAuditoriaPer);

		if (auditoriaPerfilador == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idAuditoriaPer);
			}

			throw new NoSuchAuditoriaPerfiladorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idAuditoriaPer);
		}

		return auditoriaPerfilador;
	}

	/**
	 * Returns the auditoria perfilador with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria perfilador
	 * @return the auditoria perfilador, or <code>null</code> if a auditoria perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaPerfilador fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria perfilador with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idAuditoriaPer the primary key of the auditoria perfilador
	 * @return the auditoria perfilador, or <code>null</code> if a auditoria perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaPerfilador fetchByPrimaryKey(long idAuditoriaPer)
		throws SystemException {
		AuditoriaPerfilador auditoriaPerfilador = (AuditoriaPerfilador)EntityCacheUtil.getResult(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
				AuditoriaPerfiladorImpl.class, idAuditoriaPer);

		if (auditoriaPerfilador == _nullAuditoriaPerfilador) {
			return null;
		}

		if (auditoriaPerfilador == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				auditoriaPerfilador = (AuditoriaPerfilador)session.get(AuditoriaPerfiladorImpl.class,
						Long.valueOf(idAuditoriaPer));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (auditoriaPerfilador != null) {
					cacheResult(auditoriaPerfilador);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AuditoriaPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
						AuditoriaPerfiladorImpl.class, idAuditoriaPer,
						_nullAuditoriaPerfilador);
				}

				closeSession(session);
			}
		}

		return auditoriaPerfilador;
	}

	/**
	 * Returns all the auditoria perfiladors.
	 *
	 * @return the auditoria perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaPerfilador> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditoria perfiladors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria perfiladors
	 * @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	 * @return the range of auditoria perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaPerfilador> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditoria perfiladors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria perfiladors
	 * @param end the upper bound of the range of auditoria perfiladors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditoria perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaPerfilador> findAll(int start, int end,
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

		List<AuditoriaPerfilador> list = (List<AuditoriaPerfilador>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDITORIAPERFILADOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITORIAPERFILADOR;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AuditoriaPerfilador>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AuditoriaPerfilador>)QueryUtil.list(q,
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
	 * Removes all the auditoria perfiladors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AuditoriaPerfilador auditoriaPerfilador : findAll()) {
			remove(auditoriaPerfilador);
		}
	}

	/**
	 * Returns the number of auditoria perfiladors.
	 *
	 * @return the number of auditoria perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDITORIAPERFILADOR);

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
	 * Initializes the auditoria perfilador persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.AuditoriaPerfilador")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AuditoriaPerfilador>> listenersList = new ArrayList<ModelListener<AuditoriaPerfilador>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AuditoriaPerfilador>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuditoriaPerfiladorImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDITORIAPERFILADOR = "SELECT auditoriaPerfilador FROM AuditoriaPerfilador auditoriaPerfilador";
	private static final String _SQL_COUNT_AUDITORIAPERFILADOR = "SELECT COUNT(auditoriaPerfilador) FROM AuditoriaPerfilador auditoriaPerfilador";
	private static final String _ORDER_BY_ENTITY_ALIAS = "auditoriaPerfilador.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuditoriaPerfilador exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuditoriaPerfiladorPersistenceImpl.class);
	private static AuditoriaPerfilador _nullAuditoriaPerfilador = new AuditoriaPerfiladorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AuditoriaPerfilador> toCacheModel() {
				return _nullAuditoriaPerfiladorCacheModel;
			}
		};

	private static CacheModel<AuditoriaPerfilador> _nullAuditoriaPerfiladorCacheModel =
		new CacheModel<AuditoriaPerfilador>() {
			public AuditoriaPerfilador toEntityModel() {
				return _nullAuditoriaPerfilador;
			}
		};
}