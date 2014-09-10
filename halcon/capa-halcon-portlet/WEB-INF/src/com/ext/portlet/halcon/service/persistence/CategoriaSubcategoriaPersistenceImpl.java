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

import com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException;
import com.ext.portlet.halcon.model.CategoriaSubcategoria;
import com.ext.portlet.halcon.model.impl.CategoriaSubcategoriaImpl;
import com.ext.portlet.halcon.model.impl.CategoriaSubcategoriaModelImpl;

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
 * The persistence implementation for the categoria subcategoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CategoriaSubcategoriaPersistence
 * @see CategoriaSubcategoriaUtil
 * @generated
 */
public class CategoriaSubcategoriaPersistenceImpl extends BasePersistenceImpl<CategoriaSubcategoria>
	implements CategoriaSubcategoriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoriaSubcategoriaUtil} to access the categoria subcategoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoriaSubcategoriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaSubcategoriaModelImpl.FINDER_CACHE_ENABLED,
			CategoriaSubcategoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaSubcategoriaModelImpl.FINDER_CACHE_ENABLED,
			CategoriaSubcategoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaSubcategoriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the categoria subcategoria in the entity cache if it is enabled.
	 *
	 * @param categoriaSubcategoria the categoria subcategoria
	 */
	public void cacheResult(CategoriaSubcategoria categoriaSubcategoria) {
		EntityCacheUtil.putResult(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaSubcategoriaImpl.class,
			categoriaSubcategoria.getPrimaryKey(), categoriaSubcategoria);

		categoriaSubcategoria.resetOriginalValues();
	}

	/**
	 * Caches the categoria subcategorias in the entity cache if it is enabled.
	 *
	 * @param categoriaSubcategorias the categoria subcategorias
	 */
	public void cacheResult(List<CategoriaSubcategoria> categoriaSubcategorias) {
		for (CategoriaSubcategoria categoriaSubcategoria : categoriaSubcategorias) {
			if (EntityCacheUtil.getResult(
						CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
						CategoriaSubcategoriaImpl.class,
						categoriaSubcategoria.getPrimaryKey()) == null) {
				cacheResult(categoriaSubcategoria);
			}
			else {
				categoriaSubcategoria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all categoria subcategorias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoriaSubcategoriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoriaSubcategoriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the categoria subcategoria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CategoriaSubcategoria categoriaSubcategoria) {
		EntityCacheUtil.removeResult(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaSubcategoriaImpl.class,
			categoriaSubcategoria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CategoriaSubcategoria> categoriaSubcategorias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CategoriaSubcategoria categoriaSubcategoria : categoriaSubcategorias) {
			EntityCacheUtil.removeResult(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
				CategoriaSubcategoriaImpl.class,
				categoriaSubcategoria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new categoria subcategoria with the primary key. Does not add the categoria subcategoria to the database.
	 *
	 * @param idCategoriaSubCat the primary key for the new categoria subcategoria
	 * @return the new categoria subcategoria
	 */
	public CategoriaSubcategoria create(long idCategoriaSubCat) {
		CategoriaSubcategoria categoriaSubcategoria = new CategoriaSubcategoriaImpl();

		categoriaSubcategoria.setNew(true);
		categoriaSubcategoria.setPrimaryKey(idCategoriaSubCat);

		return categoriaSubcategoria;
	}

	/**
	 * Removes the categoria subcategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idCategoriaSubCat the primary key of the categoria subcategoria
	 * @return the categoria subcategoria that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoriaSubcategoria remove(long idCategoriaSubCat)
		throws NoSuchCategoriaSubcategoriaException, SystemException {
		return remove(Long.valueOf(idCategoriaSubCat));
	}

	/**
	 * Removes the categoria subcategoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the categoria subcategoria
	 * @return the categoria subcategoria that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoriaSubcategoria remove(Serializable primaryKey)
		throws NoSuchCategoriaSubcategoriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CategoriaSubcategoria categoriaSubcategoria = (CategoriaSubcategoria)session.get(CategoriaSubcategoriaImpl.class,
					primaryKey);

			if (categoriaSubcategoria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoriaSubcategoriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoriaSubcategoria);
		}
		catch (NoSuchCategoriaSubcategoriaException nsee) {
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
	protected CategoriaSubcategoria removeImpl(
		CategoriaSubcategoria categoriaSubcategoria) throws SystemException {
		categoriaSubcategoria = toUnwrappedModel(categoriaSubcategoria);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, categoriaSubcategoria);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(categoriaSubcategoria);

		return categoriaSubcategoria;
	}

	@Override
	public CategoriaSubcategoria updateImpl(
		com.ext.portlet.halcon.model.CategoriaSubcategoria categoriaSubcategoria,
		boolean merge) throws SystemException {
		categoriaSubcategoria = toUnwrappedModel(categoriaSubcategoria);

		boolean isNew = categoriaSubcategoria.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, categoriaSubcategoria, merge);

			categoriaSubcategoria.setNew(false);
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

		EntityCacheUtil.putResult(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaSubcategoriaImpl.class,
			categoriaSubcategoria.getPrimaryKey(), categoriaSubcategoria);

		return categoriaSubcategoria;
	}

	protected CategoriaSubcategoria toUnwrappedModel(
		CategoriaSubcategoria categoriaSubcategoria) {
		if (categoriaSubcategoria instanceof CategoriaSubcategoriaImpl) {
			return categoriaSubcategoria;
		}

		CategoriaSubcategoriaImpl categoriaSubcategoriaImpl = new CategoriaSubcategoriaImpl();

		categoriaSubcategoriaImpl.setNew(categoriaSubcategoria.isNew());
		categoriaSubcategoriaImpl.setPrimaryKey(categoriaSubcategoria.getPrimaryKey());

		categoriaSubcategoriaImpl.setIdCategoriaSubCat(categoriaSubcategoria.getIdCategoriaSubCat());
		categoriaSubcategoriaImpl.setIdCategoriaSubCatPadre(categoriaSubcategoria.getIdCategoriaSubCatPadre());
		categoriaSubcategoriaImpl.setDescripcion(categoriaSubcategoria.getDescripcion());

		return categoriaSubcategoriaImpl;
	}

	/**
	 * Returns the categoria subcategoria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the categoria subcategoria
	 * @return the categoria subcategoria
	 * @throws com.liferay.portal.NoSuchModelException if a categoria subcategoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoriaSubcategoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the categoria subcategoria with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException} if it could not be found.
	 *
	 * @param idCategoriaSubCat the primary key of the categoria subcategoria
	 * @return the categoria subcategoria
	 * @throws com.ext.portlet.halcon.NoSuchCategoriaSubcategoriaException if a categoria subcategoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoriaSubcategoria findByPrimaryKey(long idCategoriaSubCat)
		throws NoSuchCategoriaSubcategoriaException, SystemException {
		CategoriaSubcategoria categoriaSubcategoria = fetchByPrimaryKey(idCategoriaSubCat);

		if (categoriaSubcategoria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idCategoriaSubCat);
			}

			throw new NoSuchCategoriaSubcategoriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idCategoriaSubCat);
		}

		return categoriaSubcategoria;
	}

	/**
	 * Returns the categoria subcategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the categoria subcategoria
	 * @return the categoria subcategoria, or <code>null</code> if a categoria subcategoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CategoriaSubcategoria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the categoria subcategoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idCategoriaSubCat the primary key of the categoria subcategoria
	 * @return the categoria subcategoria, or <code>null</code> if a categoria subcategoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CategoriaSubcategoria fetchByPrimaryKey(long idCategoriaSubCat)
		throws SystemException {
		CategoriaSubcategoria categoriaSubcategoria = (CategoriaSubcategoria)EntityCacheUtil.getResult(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
				CategoriaSubcategoriaImpl.class, idCategoriaSubCat);

		if (categoriaSubcategoria == _nullCategoriaSubcategoria) {
			return null;
		}

		if (categoriaSubcategoria == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				categoriaSubcategoria = (CategoriaSubcategoria)session.get(CategoriaSubcategoriaImpl.class,
						Long.valueOf(idCategoriaSubCat));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (categoriaSubcategoria != null) {
					cacheResult(categoriaSubcategoria);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CategoriaSubcategoriaModelImpl.ENTITY_CACHE_ENABLED,
						CategoriaSubcategoriaImpl.class, idCategoriaSubCat,
						_nullCategoriaSubcategoria);
				}

				closeSession(session);
			}
		}

		return categoriaSubcategoria;
	}

	/**
	 * Returns all the categoria subcategorias.
	 *
	 * @return the categoria subcategorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoriaSubcategoria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categoria subcategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of categoria subcategorias
	 * @param end the upper bound of the range of categoria subcategorias (not inclusive)
	 * @return the range of categoria subcategorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoriaSubcategoria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categoria subcategorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of categoria subcategorias
	 * @param end the upper bound of the range of categoria subcategorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categoria subcategorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<CategoriaSubcategoria> findAll(int start, int end,
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

		List<CategoriaSubcategoria> list = (List<CategoriaSubcategoria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORIASUBCATEGORIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORIASUBCATEGORIA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CategoriaSubcategoria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CategoriaSubcategoria>)QueryUtil.list(q,
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
	 * Removes all the categoria subcategorias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CategoriaSubcategoria categoriaSubcategoria : findAll()) {
			remove(categoriaSubcategoria);
		}
	}

	/**
	 * Returns the number of categoria subcategorias.
	 *
	 * @return the number of categoria subcategorias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORIASUBCATEGORIA);

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
	 * Initializes the categoria subcategoria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.CategoriaSubcategoria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CategoriaSubcategoria>> listenersList = new ArrayList<ModelListener<CategoriaSubcategoria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CategoriaSubcategoria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CategoriaSubcategoriaImpl.class.getName());
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
	private static final String _SQL_SELECT_CATEGORIASUBCATEGORIA = "SELECT categoriaSubcategoria FROM CategoriaSubcategoria categoriaSubcategoria";
	private static final String _SQL_COUNT_CATEGORIASUBCATEGORIA = "SELECT COUNT(categoriaSubcategoria) FROM CategoriaSubcategoria categoriaSubcategoria";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoriaSubcategoria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CategoriaSubcategoria exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoriaSubcategoriaPersistenceImpl.class);
	private static CategoriaSubcategoria _nullCategoriaSubcategoria = new CategoriaSubcategoriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CategoriaSubcategoria> toCacheModel() {
				return _nullCategoriaSubcategoriaCacheModel;
			}
		};

	private static CacheModel<CategoriaSubcategoria> _nullCategoriaSubcategoriaCacheModel =
		new CacheModel<CategoriaSubcategoria>() {
			public CategoriaSubcategoria toEntityModel() {
				return _nullCategoriaSubcategoria;
			}
		};
}