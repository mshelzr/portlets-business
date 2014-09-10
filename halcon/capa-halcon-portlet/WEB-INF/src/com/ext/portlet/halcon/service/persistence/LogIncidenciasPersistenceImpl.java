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

import com.ext.portlet.halcon.NoSuchLogIncidenciasException;
import com.ext.portlet.halcon.model.LogIncidencias;
import com.ext.portlet.halcon.model.impl.LogIncidenciasImpl;
import com.ext.portlet.halcon.model.impl.LogIncidenciasModelImpl;

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
 * The persistence implementation for the log incidencias service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see LogIncidenciasPersistence
 * @see LogIncidenciasUtil
 * @generated
 */
public class LogIncidenciasPersistenceImpl extends BasePersistenceImpl<LogIncidencias>
	implements LogIncidenciasPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LogIncidenciasUtil} to access the log incidencias persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LogIncidenciasImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
			LogIncidenciasModelImpl.FINDER_CACHE_ENABLED,
			LogIncidenciasImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
			LogIncidenciasModelImpl.FINDER_CACHE_ENABLED,
			LogIncidenciasImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
			LogIncidenciasModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the log incidencias in the entity cache if it is enabled.
	 *
	 * @param logIncidencias the log incidencias
	 */
	public void cacheResult(LogIncidencias logIncidencias) {
		EntityCacheUtil.putResult(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
			LogIncidenciasImpl.class, logIncidencias.getPrimaryKey(),
			logIncidencias);

		logIncidencias.resetOriginalValues();
	}

	/**
	 * Caches the log incidenciases in the entity cache if it is enabled.
	 *
	 * @param logIncidenciases the log incidenciases
	 */
	public void cacheResult(List<LogIncidencias> logIncidenciases) {
		for (LogIncidencias logIncidencias : logIncidenciases) {
			if (EntityCacheUtil.getResult(
						LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
						LogIncidenciasImpl.class, logIncidencias.getPrimaryKey()) == null) {
				cacheResult(logIncidencias);
			}
			else {
				logIncidencias.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all log incidenciases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LogIncidenciasImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LogIncidenciasImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the log incidencias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LogIncidencias logIncidencias) {
		EntityCacheUtil.removeResult(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
			LogIncidenciasImpl.class, logIncidencias.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<LogIncidencias> logIncidenciases) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LogIncidencias logIncidencias : logIncidenciases) {
			EntityCacheUtil.removeResult(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
				LogIncidenciasImpl.class, logIncidencias.getPrimaryKey());
		}
	}

	/**
	 * Creates a new log incidencias with the primary key. Does not add the log incidencias to the database.
	 *
	 * @param idError the primary key for the new log incidencias
	 * @return the new log incidencias
	 */
	public LogIncidencias create(long idError) {
		LogIncidencias logIncidencias = new LogIncidenciasImpl();

		logIncidencias.setNew(true);
		logIncidencias.setPrimaryKey(idError);

		return logIncidencias;
	}

	/**
	 * Removes the log incidencias with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idError the primary key of the log incidencias
	 * @return the log incidencias that was removed
	 * @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogIncidencias remove(long idError)
		throws NoSuchLogIncidenciasException, SystemException {
		return remove(Long.valueOf(idError));
	}

	/**
	 * Removes the log incidencias with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the log incidencias
	 * @return the log incidencias that was removed
	 * @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogIncidencias remove(Serializable primaryKey)
		throws NoSuchLogIncidenciasException, SystemException {
		Session session = null;

		try {
			session = openSession();

			LogIncidencias logIncidencias = (LogIncidencias)session.get(LogIncidenciasImpl.class,
					primaryKey);

			if (logIncidencias == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLogIncidenciasException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(logIncidencias);
		}
		catch (NoSuchLogIncidenciasException nsee) {
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
	protected LogIncidencias removeImpl(LogIncidencias logIncidencias)
		throws SystemException {
		logIncidencias = toUnwrappedModel(logIncidencias);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, logIncidencias);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(logIncidencias);

		return logIncidencias;
	}

	@Override
	public LogIncidencias updateImpl(
		com.ext.portlet.halcon.model.LogIncidencias logIncidencias,
		boolean merge) throws SystemException {
		logIncidencias = toUnwrappedModel(logIncidencias);

		boolean isNew = logIncidencias.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, logIncidencias, merge);

			logIncidencias.setNew(false);
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

		EntityCacheUtil.putResult(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
			LogIncidenciasImpl.class, logIncidencias.getPrimaryKey(),
			logIncidencias);

		return logIncidencias;
	}

	protected LogIncidencias toUnwrappedModel(LogIncidencias logIncidencias) {
		if (logIncidencias instanceof LogIncidenciasImpl) {
			return logIncidencias;
		}

		LogIncidenciasImpl logIncidenciasImpl = new LogIncidenciasImpl();

		logIncidenciasImpl.setNew(logIncidencias.isNew());
		logIncidenciasImpl.setPrimaryKey(logIncidencias.getPrimaryKey());

		logIncidenciasImpl.setIdError(logIncidencias.getIdError());
		logIncidenciasImpl.setMensajeError(logIncidencias.getMensajeError());
		logIncidenciasImpl.setParametro(logIncidencias.getParametro());
		logIncidenciasImpl.setIdSessionVisitante(logIncidencias.getIdSessionVisitante());
		logIncidenciasImpl.setTipoNumDoc(logIncidencias.getTipoNumDoc());
		logIncidenciasImpl.setIP(logIncidencias.getIP());
		logIncidenciasImpl.setFechaHoraError(logIncidencias.getFechaHoraError());
		logIncidenciasImpl.setTrazaError(logIncidencias.getTrazaError());
		logIncidenciasImpl.setPaginaHija(logIncidencias.getPaginaHija());
		logIncidenciasImpl.setUserId(logIncidencias.getUserId());
		logIncidenciasImpl.setUserName(logIncidencias.getUserName());
		logIncidenciasImpl.setRecursoId(logIncidencias.getRecursoId());
		logIncidenciasImpl.setRecursoName(logIncidencias.getRecursoName());
		logIncidenciasImpl.setRecursoAction(logIncidencias.getRecursoAction());
		logIncidenciasImpl.setCreateDate(logIncidencias.getCreateDate());
		logIncidenciasImpl.setClienteHost(logIncidencias.getClienteHost());
		logIncidenciasImpl.setServerName(logIncidencias.getServerName());
		logIncidenciasImpl.setServerId(logIncidencias.getServerId());
		logIncidenciasImpl.setAdditionalInformation(logIncidencias.getAdditionalInformation());

		return logIncidenciasImpl;
	}

	/**
	 * Returns the log incidencias with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the log incidencias
	 * @return the log incidencias
	 * @throws com.liferay.portal.NoSuchModelException if a log incidencias with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogIncidencias findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the log incidencias with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchLogIncidenciasException} if it could not be found.
	 *
	 * @param idError the primary key of the log incidencias
	 * @return the log incidencias
	 * @throws com.ext.portlet.halcon.NoSuchLogIncidenciasException if a log incidencias with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogIncidencias findByPrimaryKey(long idError)
		throws NoSuchLogIncidenciasException, SystemException {
		LogIncidencias logIncidencias = fetchByPrimaryKey(idError);

		if (logIncidencias == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idError);
			}

			throw new NoSuchLogIncidenciasException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idError);
		}

		return logIncidencias;
	}

	/**
	 * Returns the log incidencias with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the log incidencias
	 * @return the log incidencias, or <code>null</code> if a log incidencias with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public LogIncidencias fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the log incidencias with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idError the primary key of the log incidencias
	 * @return the log incidencias, or <code>null</code> if a log incidencias with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public LogIncidencias fetchByPrimaryKey(long idError)
		throws SystemException {
		LogIncidencias logIncidencias = (LogIncidencias)EntityCacheUtil.getResult(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
				LogIncidenciasImpl.class, idError);

		if (logIncidencias == _nullLogIncidencias) {
			return null;
		}

		if (logIncidencias == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				logIncidencias = (LogIncidencias)session.get(LogIncidenciasImpl.class,
						Long.valueOf(idError));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (logIncidencias != null) {
					cacheResult(logIncidencias);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LogIncidenciasModelImpl.ENTITY_CACHE_ENABLED,
						LogIncidenciasImpl.class, idError, _nullLogIncidencias);
				}

				closeSession(session);
			}
		}

		return logIncidencias;
	}

	/**
	 * Returns all the log incidenciases.
	 *
	 * @return the log incidenciases
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogIncidencias> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the log incidenciases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of log incidenciases
	 * @param end the upper bound of the range of log incidenciases (not inclusive)
	 * @return the range of log incidenciases
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogIncidencias> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the log incidenciases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of log incidenciases
	 * @param end the upper bound of the range of log incidenciases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of log incidenciases
	 * @throws SystemException if a system exception occurred
	 */
	public List<LogIncidencias> findAll(int start, int end,
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

		List<LogIncidencias> list = (List<LogIncidencias>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LOGINCIDENCIAS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LOGINCIDENCIAS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<LogIncidencias>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<LogIncidencias>)QueryUtil.list(q,
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
	 * Removes all the log incidenciases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (LogIncidencias logIncidencias : findAll()) {
			remove(logIncidencias);
		}
	}

	/**
	 * Returns the number of log incidenciases.
	 *
	 * @return the number of log incidenciases
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LOGINCIDENCIAS);

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
	 * Initializes the log incidencias persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.LogIncidencias")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<LogIncidencias>> listenersList = new ArrayList<ModelListener<LogIncidencias>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<LogIncidencias>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LogIncidenciasImpl.class.getName());
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
	private static final String _SQL_SELECT_LOGINCIDENCIAS = "SELECT logIncidencias FROM LogIncidencias logIncidencias";
	private static final String _SQL_COUNT_LOGINCIDENCIAS = "SELECT COUNT(logIncidencias) FROM LogIncidencias logIncidencias";
	private static final String _ORDER_BY_ENTITY_ALIAS = "logIncidencias.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LogIncidencias exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LogIncidenciasPersistenceImpl.class);
	private static LogIncidencias _nullLogIncidencias = new LogIncidenciasImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<LogIncidencias> toCacheModel() {
				return _nullLogIncidenciasCacheModel;
			}
		};

	private static CacheModel<LogIncidencias> _nullLogIncidenciasCacheModel = new CacheModel<LogIncidencias>() {
			public LogIncidencias toEntityModel() {
				return _nullLogIncidencias;
			}
		};
}