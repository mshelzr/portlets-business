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

package com.ext.portlet.pin.service.persistence;

import com.ext.portlet.pin.NoSuchCategoriaException;
import com.ext.portlet.pin.model.Categoria;
import com.ext.portlet.pin.model.impl.CategoriaImpl;
import com.ext.portlet.pin.model.impl.CategoriaModelImpl;

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
 * The persistence implementation for the categoria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author arodriguez
 * @see CategoriaPersistence
 * @see CategoriaUtil
 * @generated
 */
public class CategoriaPersistenceImpl extends BasePersistenceImpl<Categoria>
	implements CategoriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CategoriaUtil} to access the categoria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CategoriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaModelImpl.FINDER_CACHE_ENABLED, CategoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaModelImpl.FINDER_CACHE_ENABLED, CategoriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the categoria in the entity cache if it is enabled.
	 *
	 * @param categoria the categoria
	 */
	public void cacheResult(Categoria categoria) {
		EntityCacheUtil.putResult(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaImpl.class, categoria.getPrimaryKey(), categoria);

		categoria.resetOriginalValues();
	}

	/**
	 * Caches the categorias in the entity cache if it is enabled.
	 *
	 * @param categorias the categorias
	 */
	public void cacheResult(List<Categoria> categorias) {
		for (Categoria categoria : categorias) {
			if (EntityCacheUtil.getResult(
						CategoriaModelImpl.ENTITY_CACHE_ENABLED,
						CategoriaImpl.class, categoria.getPrimaryKey()) == null) {
				cacheResult(categoria);
			}
			else {
				categoria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all categorias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CategoriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CategoriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the categoria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Categoria categoria) {
		EntityCacheUtil.removeResult(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaImpl.class, categoria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Categoria> categorias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Categoria categoria : categorias) {
			EntityCacheUtil.removeResult(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
				CategoriaImpl.class, categoria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new categoria with the primary key. Does not add the categoria to the database.
	 *
	 * @param categoriaId the primary key for the new categoria
	 * @return the new categoria
	 */
	public Categoria create(long categoriaId) {
		Categoria categoria = new CategoriaImpl();

		categoria.setNew(true);
		categoria.setPrimaryKey(categoriaId);

		return categoria;
	}

	/**
	 * Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoriaId the primary key of the categoria
	 * @return the categoria that was removed
	 * @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Categoria remove(long categoriaId)
		throws NoSuchCategoriaException, SystemException {
		return remove(Long.valueOf(categoriaId));
	}

	/**
	 * Removes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the categoria
	 * @return the categoria that was removed
	 * @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Categoria remove(Serializable primaryKey)
		throws NoSuchCategoriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Categoria categoria = (Categoria)session.get(CategoriaImpl.class,
					primaryKey);

			if (categoria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(categoria);
		}
		catch (NoSuchCategoriaException nsee) {
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
	protected Categoria removeImpl(Categoria categoria)
		throws SystemException {
		categoria = toUnwrappedModel(categoria);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, categoria);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(categoria);

		return categoria;
	}

	@Override
	public Categoria updateImpl(com.ext.portlet.pin.model.Categoria categoria,
		boolean merge) throws SystemException {
		categoria = toUnwrappedModel(categoria);

		boolean isNew = categoria.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, categoria, merge);

			categoria.setNew(false);
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

		EntityCacheUtil.putResult(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
			CategoriaImpl.class, categoria.getPrimaryKey(), categoria);

		return categoria;
	}

	protected Categoria toUnwrappedModel(Categoria categoria) {
		if (categoria instanceof CategoriaImpl) {
			return categoria;
		}

		CategoriaImpl categoriaImpl = new CategoriaImpl();

		categoriaImpl.setNew(categoria.isNew());
		categoriaImpl.setPrimaryKey(categoria.getPrimaryKey());

		categoriaImpl.setCategoriaId(categoria.getCategoriaId());
		categoriaImpl.setIdImagen(categoria.getIdImagen());
		categoriaImpl.setNombre(categoria.getNombre());
		categoriaImpl.setEstado(categoria.isEstado());
		categoriaImpl.setDescripcion(categoria.getDescripcion());

		return categoriaImpl;
	}

	/**
	 * Returns the categoria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the categoria
	 * @return the categoria
	 * @throws com.liferay.portal.NoSuchModelException if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Categoria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the categoria with the primary key or throws a {@link com.ext.portlet.pin.NoSuchCategoriaException} if it could not be found.
	 *
	 * @param categoriaId the primary key of the categoria
	 * @return the categoria
	 * @throws com.ext.portlet.pin.NoSuchCategoriaException if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Categoria findByPrimaryKey(long categoriaId)
		throws NoSuchCategoriaException, SystemException {
		Categoria categoria = fetchByPrimaryKey(categoriaId);

		if (categoria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoriaId);
			}

			throw new NoSuchCategoriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoriaId);
		}

		return categoria;
	}

	/**
	 * Returns the categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the categoria
	 * @return the categoria, or <code>null</code> if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Categoria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the categoria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoriaId the primary key of the categoria
	 * @return the categoria, or <code>null</code> if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Categoria fetchByPrimaryKey(long categoriaId)
		throws SystemException {
		Categoria categoria = (Categoria)EntityCacheUtil.getResult(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
				CategoriaImpl.class, categoriaId);

		if (categoria == _nullCategoria) {
			return null;
		}

		if (categoria == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				categoria = (Categoria)session.get(CategoriaImpl.class,
						Long.valueOf(categoriaId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (categoria != null) {
					cacheResult(categoria);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CategoriaModelImpl.ENTITY_CACHE_ENABLED,
						CategoriaImpl.class, categoriaId, _nullCategoria);
				}

				closeSession(session);
			}
		}

		return categoria;
	}

	/**
	 * Returns all the categorias.
	 *
	 * @return the categorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Categoria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @return the range of categorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Categoria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of categorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Categoria> findAll(int start, int end,
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

		List<Categoria> list = (List<Categoria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CATEGORIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CATEGORIA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Categoria>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Categoria>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the categorias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Categoria categoria : findAll()) {
			remove(categoria);
		}
	}

	/**
	 * Returns the number of categorias.
	 *
	 * @return the number of categorias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CATEGORIA);

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
	 * Initializes the categoria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.pin.model.Categoria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Categoria>> listenersList = new ArrayList<ModelListener<Categoria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Categoria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CategoriaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoriaPersistence.class)
	protected CategoriaPersistence categoriaPersistence;
	@BeanReference(type = PersonaPersistence.class)
	protected PersonaPersistence personaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_CATEGORIA = "SELECT categoria FROM Categoria categoria";
	private static final String _SQL_COUNT_CATEGORIA = "SELECT COUNT(categoria) FROM Categoria categoria";
	private static final String _ORDER_BY_ENTITY_ALIAS = "categoria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Categoria exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CategoriaPersistenceImpl.class);
	private static Categoria _nullCategoria = new CategoriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Categoria> toCacheModel() {
				return _nullCategoriaCacheModel;
			}
		};

	private static CacheModel<Categoria> _nullCategoriaCacheModel = new CacheModel<Categoria>() {
			public Categoria toEntityModel() {
				return _nullCategoria;
			}
		};
}