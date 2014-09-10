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

import com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException;
import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;
import com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaImpl;
import com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaModelImpl;

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
 * The persistence implementation for the auditoria caja sorpresa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaCajaSorpresaPersistence
 * @see AuditoriaCajaSorpresaUtil
 * @generated
 */
public class AuditoriaCajaSorpresaPersistenceImpl extends BasePersistenceImpl<AuditoriaCajaSorpresa>
	implements AuditoriaCajaSorpresaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuditoriaCajaSorpresaUtil} to access the auditoria caja sorpresa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuditoriaCajaSorpresaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaCajaSorpresaModelImpl.FINDER_CACHE_ENABLED,
			AuditoriaCajaSorpresaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaCajaSorpresaModelImpl.FINDER_CACHE_ENABLED,
			AuditoriaCajaSorpresaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaCajaSorpresaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the auditoria caja sorpresa in the entity cache if it is enabled.
	 *
	 * @param auditoriaCajaSorpresa the auditoria caja sorpresa
	 */
	public void cacheResult(AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		EntityCacheUtil.putResult(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaCajaSorpresaImpl.class,
			auditoriaCajaSorpresa.getPrimaryKey(), auditoriaCajaSorpresa);

		auditoriaCajaSorpresa.resetOriginalValues();
	}

	/**
	 * Caches the auditoria caja sorpresas in the entity cache if it is enabled.
	 *
	 * @param auditoriaCajaSorpresas the auditoria caja sorpresas
	 */
	public void cacheResult(List<AuditoriaCajaSorpresa> auditoriaCajaSorpresas) {
		for (AuditoriaCajaSorpresa auditoriaCajaSorpresa : auditoriaCajaSorpresas) {
			if (EntityCacheUtil.getResult(
						AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
						AuditoriaCajaSorpresaImpl.class,
						auditoriaCajaSorpresa.getPrimaryKey()) == null) {
				cacheResult(auditoriaCajaSorpresa);
			}
			else {
				auditoriaCajaSorpresa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auditoria caja sorpresas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuditoriaCajaSorpresaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuditoriaCajaSorpresaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auditoria caja sorpresa.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		EntityCacheUtil.removeResult(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaCajaSorpresaImpl.class,
			auditoriaCajaSorpresa.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AuditoriaCajaSorpresa> auditoriaCajaSorpresas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuditoriaCajaSorpresa auditoriaCajaSorpresa : auditoriaCajaSorpresas) {
			EntityCacheUtil.removeResult(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
				AuditoriaCajaSorpresaImpl.class,
				auditoriaCajaSorpresa.getPrimaryKey());
		}
	}

	/**
	 * Creates a new auditoria caja sorpresa with the primary key. Does not add the auditoria caja sorpresa to the database.
	 *
	 * @param idAuditoriaCajSorp the primary key for the new auditoria caja sorpresa
	 * @return the new auditoria caja sorpresa
	 */
	public AuditoriaCajaSorpresa create(long idAuditoriaCajSorp) {
		AuditoriaCajaSorpresa auditoriaCajaSorpresa = new AuditoriaCajaSorpresaImpl();

		auditoriaCajaSorpresa.setNew(true);
		auditoriaCajaSorpresa.setPrimaryKey(idAuditoriaCajSorp);

		return auditoriaCajaSorpresa;
	}

	/**
	 * Removes the auditoria caja sorpresa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	 * @return the auditoria caja sorpresa that was removed
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaCajaSorpresa remove(long idAuditoriaCajSorp)
		throws NoSuchAuditoriaCajaSorpresaException, SystemException {
		return remove(Long.valueOf(idAuditoriaCajSorp));
	}

	/**
	 * Removes the auditoria caja sorpresa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditoria caja sorpresa
	 * @return the auditoria caja sorpresa that was removed
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaCajaSorpresa remove(Serializable primaryKey)
		throws NoSuchAuditoriaCajaSorpresaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AuditoriaCajaSorpresa auditoriaCajaSorpresa = (AuditoriaCajaSorpresa)session.get(AuditoriaCajaSorpresaImpl.class,
					primaryKey);

			if (auditoriaCajaSorpresa == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditoriaCajaSorpresaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(auditoriaCajaSorpresa);
		}
		catch (NoSuchAuditoriaCajaSorpresaException nsee) {
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
	protected AuditoriaCajaSorpresa removeImpl(
		AuditoriaCajaSorpresa auditoriaCajaSorpresa) throws SystemException {
		auditoriaCajaSorpresa = toUnwrappedModel(auditoriaCajaSorpresa);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, auditoriaCajaSorpresa);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(auditoriaCajaSorpresa);

		return auditoriaCajaSorpresa;
	}

	@Override
	public AuditoriaCajaSorpresa updateImpl(
		com.ext.portlet.halcon.model.AuditoriaCajaSorpresa auditoriaCajaSorpresa,
		boolean merge) throws SystemException {
		auditoriaCajaSorpresa = toUnwrappedModel(auditoriaCajaSorpresa);

		boolean isNew = auditoriaCajaSorpresa.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, auditoriaCajaSorpresa, merge);

			auditoriaCajaSorpresa.setNew(false);
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

		EntityCacheUtil.putResult(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaCajaSorpresaImpl.class,
			auditoriaCajaSorpresa.getPrimaryKey(), auditoriaCajaSorpresa);

		return auditoriaCajaSorpresa;
	}

	protected AuditoriaCajaSorpresa toUnwrappedModel(
		AuditoriaCajaSorpresa auditoriaCajaSorpresa) {
		if (auditoriaCajaSorpresa instanceof AuditoriaCajaSorpresaImpl) {
			return auditoriaCajaSorpresa;
		}

		AuditoriaCajaSorpresaImpl auditoriaCajaSorpresaImpl = new AuditoriaCajaSorpresaImpl();

		auditoriaCajaSorpresaImpl.setNew(auditoriaCajaSorpresa.isNew());
		auditoriaCajaSorpresaImpl.setPrimaryKey(auditoriaCajaSorpresa.getPrimaryKey());

		auditoriaCajaSorpresaImpl.setIdAuditoriaCajSorp(auditoriaCajaSorpresa.getIdAuditoriaCajSorp());
		auditoriaCajaSorpresaImpl.setIdTransaccion(auditoriaCajaSorpresa.getIdTransaccion());
		auditoriaCajaSorpresaImpl.setTipoDocumento(auditoriaCajaSorpresa.getTipoDocumento());
		auditoriaCajaSorpresaImpl.setNumDocumento(auditoriaCajaSorpresa.getNumDocumento());
		auditoriaCajaSorpresaImpl.setProducto1(auditoriaCajaSorpresa.getProducto1());
		auditoriaCajaSorpresaImpl.setProducto2(auditoriaCajaSorpresa.getProducto2());
		auditoriaCajaSorpresaImpl.setProducto3(auditoriaCajaSorpresa.getProducto3());
		auditoriaCajaSorpresaImpl.setProducto4(auditoriaCajaSorpresa.getProducto4());
		auditoriaCajaSorpresaImpl.setCodProducto1(auditoriaCajaSorpresa.getCodProducto1());
		auditoriaCajaSorpresaImpl.setCodProducto2(auditoriaCajaSorpresa.getCodProducto2());
		auditoriaCajaSorpresaImpl.setCodProducto3(auditoriaCajaSorpresa.getCodProducto3());
		auditoriaCajaSorpresaImpl.setCodProducto4(auditoriaCajaSorpresa.getCodProducto4());
		auditoriaCajaSorpresaImpl.setIP(auditoriaCajaSorpresa.getIP());
		auditoriaCajaSorpresaImpl.setSession(auditoriaCajaSorpresa.getSession());
		auditoriaCajaSorpresaImpl.setFechaHora(auditoriaCajaSorpresa.getFechaHora());
		auditoriaCajaSorpresaImpl.setUTMSource(auditoriaCajaSorpresa.getUTMSource());
		auditoriaCajaSorpresaImpl.setUTMMedium(auditoriaCajaSorpresa.getUTMMedium());
		auditoriaCajaSorpresaImpl.setUTMCampaing(auditoriaCajaSorpresa.getUTMCampaing());
		auditoriaCajaSorpresaImpl.setUTMContent(auditoriaCajaSorpresa.getUTMContent());

		return auditoriaCajaSorpresaImpl;
	}

	/**
	 * Returns the auditoria caja sorpresa with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria caja sorpresa
	 * @return the auditoria caja sorpresa
	 * @throws com.liferay.portal.NoSuchModelException if a auditoria caja sorpresa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaCajaSorpresa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria caja sorpresa with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException} if it could not be found.
	 *
	 * @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	 * @return the auditoria caja sorpresa
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaCajaSorpresaException if a auditoria caja sorpresa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaCajaSorpresa findByPrimaryKey(long idAuditoriaCajSorp)
		throws NoSuchAuditoriaCajaSorpresaException, SystemException {
		AuditoriaCajaSorpresa auditoriaCajaSorpresa = fetchByPrimaryKey(idAuditoriaCajSorp);

		if (auditoriaCajaSorpresa == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idAuditoriaCajSorp);
			}

			throw new NoSuchAuditoriaCajaSorpresaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idAuditoriaCajSorp);
		}

		return auditoriaCajaSorpresa;
	}

	/**
	 * Returns the auditoria caja sorpresa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria caja sorpresa
	 * @return the auditoria caja sorpresa, or <code>null</code> if a auditoria caja sorpresa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaCajaSorpresa fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria caja sorpresa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idAuditoriaCajSorp the primary key of the auditoria caja sorpresa
	 * @return the auditoria caja sorpresa, or <code>null</code> if a auditoria caja sorpresa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaCajaSorpresa fetchByPrimaryKey(long idAuditoriaCajSorp)
		throws SystemException {
		AuditoriaCajaSorpresa auditoriaCajaSorpresa = (AuditoriaCajaSorpresa)EntityCacheUtil.getResult(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
				AuditoriaCajaSorpresaImpl.class, idAuditoriaCajSorp);

		if (auditoriaCajaSorpresa == _nullAuditoriaCajaSorpresa) {
			return null;
		}

		if (auditoriaCajaSorpresa == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				auditoriaCajaSorpresa = (AuditoriaCajaSorpresa)session.get(AuditoriaCajaSorpresaImpl.class,
						Long.valueOf(idAuditoriaCajSorp));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (auditoriaCajaSorpresa != null) {
					cacheResult(auditoriaCajaSorpresa);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AuditoriaCajaSorpresaModelImpl.ENTITY_CACHE_ENABLED,
						AuditoriaCajaSorpresaImpl.class, idAuditoriaCajSorp,
						_nullAuditoriaCajaSorpresa);
				}

				closeSession(session);
			}
		}

		return auditoriaCajaSorpresa;
	}

	/**
	 * Returns all the auditoria caja sorpresas.
	 *
	 * @return the auditoria caja sorpresas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaCajaSorpresa> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditoria caja sorpresas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria caja sorpresas
	 * @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	 * @return the range of auditoria caja sorpresas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaCajaSorpresa> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditoria caja sorpresas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria caja sorpresas
	 * @param end the upper bound of the range of auditoria caja sorpresas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditoria caja sorpresas
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaCajaSorpresa> findAll(int start, int end,
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

		List<AuditoriaCajaSorpresa> list = (List<AuditoriaCajaSorpresa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDITORIACAJASORPRESA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITORIACAJASORPRESA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AuditoriaCajaSorpresa>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AuditoriaCajaSorpresa>)QueryUtil.list(q,
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
	 * Removes all the auditoria caja sorpresas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AuditoriaCajaSorpresa auditoriaCajaSorpresa : findAll()) {
			remove(auditoriaCajaSorpresa);
		}
	}

	/**
	 * Returns the number of auditoria caja sorpresas.
	 *
	 * @return the number of auditoria caja sorpresas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDITORIACAJASORPRESA);

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
	 * Initializes the auditoria caja sorpresa persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.AuditoriaCajaSorpresa")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AuditoriaCajaSorpresa>> listenersList = new ArrayList<ModelListener<AuditoriaCajaSorpresa>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AuditoriaCajaSorpresa>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuditoriaCajaSorpresaImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDITORIACAJASORPRESA = "SELECT auditoriaCajaSorpresa FROM AuditoriaCajaSorpresa auditoriaCajaSorpresa";
	private static final String _SQL_COUNT_AUDITORIACAJASORPRESA = "SELECT COUNT(auditoriaCajaSorpresa) FROM AuditoriaCajaSorpresa auditoriaCajaSorpresa";
	private static final String _ORDER_BY_ENTITY_ALIAS = "auditoriaCajaSorpresa.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuditoriaCajaSorpresa exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuditoriaCajaSorpresaPersistenceImpl.class);
	private static AuditoriaCajaSorpresa _nullAuditoriaCajaSorpresa = new AuditoriaCajaSorpresaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AuditoriaCajaSorpresa> toCacheModel() {
				return _nullAuditoriaCajaSorpresaCacheModel;
			}
		};

	private static CacheModel<AuditoriaCajaSorpresa> _nullAuditoriaCajaSorpresaCacheModel =
		new CacheModel<AuditoriaCajaSorpresa>() {
			public AuditoriaCajaSorpresa toEntityModel() {
				return _nullAuditoriaCajaSorpresa;
			}
		};
}