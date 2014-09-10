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

import com.ext.portlet.halcon.NoSuchFondosMutuosZonasException;
import com.ext.portlet.halcon.model.FondosMutuosZonas;
import com.ext.portlet.halcon.model.impl.FondosMutuosZonasImpl;
import com.ext.portlet.halcon.model.impl.FondosMutuosZonasModelImpl;

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
 * The persistence implementation for the fondos mutuos zonas service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosZonasPersistence
 * @see FondosMutuosZonasUtil
 * @generated
 */
public class FondosMutuosZonasPersistenceImpl extends BasePersistenceImpl<FondosMutuosZonas>
	implements FondosMutuosZonasPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FondosMutuosZonasUtil} to access the fondos mutuos zonas persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FondosMutuosZonasImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosZonasModelImpl.FINDER_CACHE_ENABLED,
			FondosMutuosZonasImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosZonasModelImpl.FINDER_CACHE_ENABLED,
			FondosMutuosZonasImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosZonasModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the fondos mutuos zonas in the entity cache if it is enabled.
	 *
	 * @param fondosMutuosZonas the fondos mutuos zonas
	 */
	public void cacheResult(FondosMutuosZonas fondosMutuosZonas) {
		EntityCacheUtil.putResult(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosZonasImpl.class, fondosMutuosZonas.getPrimaryKey(),
			fondosMutuosZonas);

		fondosMutuosZonas.resetOriginalValues();
	}

	/**
	 * Caches the fondos mutuos zonases in the entity cache if it is enabled.
	 *
	 * @param fondosMutuosZonases the fondos mutuos zonases
	 */
	public void cacheResult(List<FondosMutuosZonas> fondosMutuosZonases) {
		for (FondosMutuosZonas fondosMutuosZonas : fondosMutuosZonases) {
			if (EntityCacheUtil.getResult(
						FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
						FondosMutuosZonasImpl.class,
						fondosMutuosZonas.getPrimaryKey()) == null) {
				cacheResult(fondosMutuosZonas);
			}
			else {
				fondosMutuosZonas.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fondos mutuos zonases.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FondosMutuosZonasImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FondosMutuosZonasImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fondos mutuos zonas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FondosMutuosZonas fondosMutuosZonas) {
		EntityCacheUtil.removeResult(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosZonasImpl.class, fondosMutuosZonas.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FondosMutuosZonas> fondosMutuosZonases) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FondosMutuosZonas fondosMutuosZonas : fondosMutuosZonases) {
			EntityCacheUtil.removeResult(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
				FondosMutuosZonasImpl.class, fondosMutuosZonas.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fondos mutuos zonas with the primary key. Does not add the fondos mutuos zonas to the database.
	 *
	 * @param idFondoMutuoZona the primary key for the new fondos mutuos zonas
	 * @return the new fondos mutuos zonas
	 */
	public FondosMutuosZonas create(long idFondoMutuoZona) {
		FondosMutuosZonas fondosMutuosZonas = new FondosMutuosZonasImpl();

		fondosMutuosZonas.setNew(true);
		fondosMutuosZonas.setPrimaryKey(idFondoMutuoZona);

		return fondosMutuosZonas;
	}

	/**
	 * Removes the fondos mutuos zonas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	 * @return the fondos mutuos zonas that was removed
	 * @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FondosMutuosZonas remove(long idFondoMutuoZona)
		throws NoSuchFondosMutuosZonasException, SystemException {
		return remove(Long.valueOf(idFondoMutuoZona));
	}

	/**
	 * Removes the fondos mutuos zonas with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fondos mutuos zonas
	 * @return the fondos mutuos zonas that was removed
	 * @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FondosMutuosZonas remove(Serializable primaryKey)
		throws NoSuchFondosMutuosZonasException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FondosMutuosZonas fondosMutuosZonas = (FondosMutuosZonas)session.get(FondosMutuosZonasImpl.class,
					primaryKey);

			if (fondosMutuosZonas == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFondosMutuosZonasException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fondosMutuosZonas);
		}
		catch (NoSuchFondosMutuosZonasException nsee) {
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
	protected FondosMutuosZonas removeImpl(FondosMutuosZonas fondosMutuosZonas)
		throws SystemException {
		fondosMutuosZonas = toUnwrappedModel(fondosMutuosZonas);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, fondosMutuosZonas);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(fondosMutuosZonas);

		return fondosMutuosZonas;
	}

	@Override
	public FondosMutuosZonas updateImpl(
		com.ext.portlet.halcon.model.FondosMutuosZonas fondosMutuosZonas,
		boolean merge) throws SystemException {
		fondosMutuosZonas = toUnwrappedModel(fondosMutuosZonas);

		boolean isNew = fondosMutuosZonas.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, fondosMutuosZonas, merge);

			fondosMutuosZonas.setNew(false);
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

		EntityCacheUtil.putResult(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosZonasImpl.class, fondosMutuosZonas.getPrimaryKey(),
			fondosMutuosZonas);

		return fondosMutuosZonas;
	}

	protected FondosMutuosZonas toUnwrappedModel(
		FondosMutuosZonas fondosMutuosZonas) {
		if (fondosMutuosZonas instanceof FondosMutuosZonasImpl) {
			return fondosMutuosZonas;
		}

		FondosMutuosZonasImpl fondosMutuosZonasImpl = new FondosMutuosZonasImpl();

		fondosMutuosZonasImpl.setNew(fondosMutuosZonas.isNew());
		fondosMutuosZonasImpl.setPrimaryKey(fondosMutuosZonas.getPrimaryKey());

		fondosMutuosZonasImpl.setIdFondoMutuoZona(fondosMutuosZonas.getIdFondoMutuoZona());
		fondosMutuosZonasImpl.setCodigoZona(fondosMutuosZonas.getCodigoZona());
		fondosMutuosZonasImpl.setZona(fondosMutuosZonas.getZona());
		fondosMutuosZonasImpl.setPuntajeInicial(fondosMutuosZonas.getPuntajeInicial());
		fondosMutuosZonasImpl.setPuntajeFinal(fondosMutuosZonas.getPuntajeFinal());
		fondosMutuosZonasImpl.setDescripcionZona(fondosMutuosZonas.getDescripcionZona());
		fondosMutuosZonasImpl.setMoneda(fondosMutuosZonas.getMoneda());
		fondosMutuosZonasImpl.setRiesgo(fondosMutuosZonas.getRiesgo());

		return fondosMutuosZonasImpl;
	}

	/**
	 * Returns the fondos mutuos zonas with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fondos mutuos zonas
	 * @return the fondos mutuos zonas
	 * @throws com.liferay.portal.NoSuchModelException if a fondos mutuos zonas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FondosMutuosZonas findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the fondos mutuos zonas with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchFondosMutuosZonasException} if it could not be found.
	 *
	 * @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	 * @return the fondos mutuos zonas
	 * @throws com.ext.portlet.halcon.NoSuchFondosMutuosZonasException if a fondos mutuos zonas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FondosMutuosZonas findByPrimaryKey(long idFondoMutuoZona)
		throws NoSuchFondosMutuosZonasException, SystemException {
		FondosMutuosZonas fondosMutuosZonas = fetchByPrimaryKey(idFondoMutuoZona);

		if (fondosMutuosZonas == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idFondoMutuoZona);
			}

			throw new NoSuchFondosMutuosZonasException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idFondoMutuoZona);
		}

		return fondosMutuosZonas;
	}

	/**
	 * Returns the fondos mutuos zonas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fondos mutuos zonas
	 * @return the fondos mutuos zonas, or <code>null</code> if a fondos mutuos zonas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FondosMutuosZonas fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the fondos mutuos zonas with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idFondoMutuoZona the primary key of the fondos mutuos zonas
	 * @return the fondos mutuos zonas, or <code>null</code> if a fondos mutuos zonas with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FondosMutuosZonas fetchByPrimaryKey(long idFondoMutuoZona)
		throws SystemException {
		FondosMutuosZonas fondosMutuosZonas = (FondosMutuosZonas)EntityCacheUtil.getResult(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
				FondosMutuosZonasImpl.class, idFondoMutuoZona);

		if (fondosMutuosZonas == _nullFondosMutuosZonas) {
			return null;
		}

		if (fondosMutuosZonas == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				fondosMutuosZonas = (FondosMutuosZonas)session.get(FondosMutuosZonasImpl.class,
						Long.valueOf(idFondoMutuoZona));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (fondosMutuosZonas != null) {
					cacheResult(fondosMutuosZonas);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FondosMutuosZonasModelImpl.ENTITY_CACHE_ENABLED,
						FondosMutuosZonasImpl.class, idFondoMutuoZona,
						_nullFondosMutuosZonas);
				}

				closeSession(session);
			}
		}

		return fondosMutuosZonas;
	}

	/**
	 * Returns all the fondos mutuos zonases.
	 *
	 * @return the fondos mutuos zonases
	 * @throws SystemException if a system exception occurred
	 */
	public List<FondosMutuosZonas> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fondos mutuos zonases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of fondos mutuos zonases
	 * @param end the upper bound of the range of fondos mutuos zonases (not inclusive)
	 * @return the range of fondos mutuos zonases
	 * @throws SystemException if a system exception occurred
	 */
	public List<FondosMutuosZonas> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fondos mutuos zonases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of fondos mutuos zonases
	 * @param end the upper bound of the range of fondos mutuos zonases (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fondos mutuos zonases
	 * @throws SystemException if a system exception occurred
	 */
	public List<FondosMutuosZonas> findAll(int start, int end,
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

		List<FondosMutuosZonas> list = (List<FondosMutuosZonas>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FONDOSMUTUOSZONAS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FONDOSMUTUOSZONAS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FondosMutuosZonas>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FondosMutuosZonas>)QueryUtil.list(q,
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
	 * Removes all the fondos mutuos zonases from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FondosMutuosZonas fondosMutuosZonas : findAll()) {
			remove(fondosMutuosZonas);
		}
	}

	/**
	 * Returns the number of fondos mutuos zonases.
	 *
	 * @return the number of fondos mutuos zonases
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FONDOSMUTUOSZONAS);

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
	 * Initializes the fondos mutuos zonas persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.FondosMutuosZonas")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FondosMutuosZonas>> listenersList = new ArrayList<ModelListener<FondosMutuosZonas>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FondosMutuosZonas>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FondosMutuosZonasImpl.class.getName());
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
	@BeanReference(type = FondosMutuosZonasPersistence.class)
	protected FondosMutuosZonasPersistence fondosMutuosZonasPersistence;
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
	private static final String _SQL_SELECT_FONDOSMUTUOSZONAS = "SELECT fondosMutuosZonas FROM FondosMutuosZonas fondosMutuosZonas";
	private static final String _SQL_COUNT_FONDOSMUTUOSZONAS = "SELECT COUNT(fondosMutuosZonas) FROM FondosMutuosZonas fondosMutuosZonas";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fondosMutuosZonas.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FondosMutuosZonas exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FondosMutuosZonasPersistenceImpl.class);
	private static FondosMutuosZonas _nullFondosMutuosZonas = new FondosMutuosZonasImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FondosMutuosZonas> toCacheModel() {
				return _nullFondosMutuosZonasCacheModel;
			}
		};

	private static CacheModel<FondosMutuosZonas> _nullFondosMutuosZonasCacheModel =
		new CacheModel<FondosMutuosZonas>() {
			public FondosMutuosZonas toEntityModel() {
				return _nullFondosMutuosZonas;
			}
		};
}