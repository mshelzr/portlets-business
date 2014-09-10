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

import com.ext.portlet.halcon.NoSuchProductoComplementarioException;
import com.ext.portlet.halcon.model.ProductoComplementario;
import com.ext.portlet.halcon.model.impl.ProductoComplementarioImpl;
import com.ext.portlet.halcon.model.impl.ProductoComplementarioModelImpl;

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
 * The persistence implementation for the producto complementario service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ProductoComplementarioPersistence
 * @see ProductoComplementarioUtil
 * @generated
 */
public class ProductoComplementarioPersistenceImpl extends BasePersistenceImpl<ProductoComplementario>
	implements ProductoComplementarioPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ProductoComplementarioUtil} to access the producto complementario persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ProductoComplementarioImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
			ProductoComplementarioModelImpl.FINDER_CACHE_ENABLED,
			ProductoComplementarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
			ProductoComplementarioModelImpl.FINDER_CACHE_ENABLED,
			ProductoComplementarioImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
			ProductoComplementarioModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the producto complementario in the entity cache if it is enabled.
	 *
	 * @param productoComplementario the producto complementario
	 */
	public void cacheResult(ProductoComplementario productoComplementario) {
		EntityCacheUtil.putResult(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
			ProductoComplementarioImpl.class,
			productoComplementario.getPrimaryKey(), productoComplementario);

		productoComplementario.resetOriginalValues();
	}

	/**
	 * Caches the producto complementarios in the entity cache if it is enabled.
	 *
	 * @param productoComplementarios the producto complementarios
	 */
	public void cacheResult(
		List<ProductoComplementario> productoComplementarios) {
		for (ProductoComplementario productoComplementario : productoComplementarios) {
			if (EntityCacheUtil.getResult(
						ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
						ProductoComplementarioImpl.class,
						productoComplementario.getPrimaryKey()) == null) {
				cacheResult(productoComplementario);
			}
			else {
				productoComplementario.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all producto complementarios.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ProductoComplementarioImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ProductoComplementarioImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the producto complementario.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductoComplementario productoComplementario) {
		EntityCacheUtil.removeResult(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
			ProductoComplementarioImpl.class,
			productoComplementario.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ProductoComplementario> productoComplementarios) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProductoComplementario productoComplementario : productoComplementarios) {
			EntityCacheUtil.removeResult(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
				ProductoComplementarioImpl.class,
				productoComplementario.getPrimaryKey());
		}
	}

	/**
	 * Creates a new producto complementario with the primary key. Does not add the producto complementario to the database.
	 *
	 * @param idProductoComplementario the primary key for the new producto complementario
	 * @return the new producto complementario
	 */
	public ProductoComplementario create(long idProductoComplementario) {
		ProductoComplementario productoComplementario = new ProductoComplementarioImpl();

		productoComplementario.setNew(true);
		productoComplementario.setPrimaryKey(idProductoComplementario);

		return productoComplementario;
	}

	/**
	 * Removes the producto complementario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idProductoComplementario the primary key of the producto complementario
	 * @return the producto complementario that was removed
	 * @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductoComplementario remove(long idProductoComplementario)
		throws NoSuchProductoComplementarioException, SystemException {
		return remove(Long.valueOf(idProductoComplementario));
	}

	/**
	 * Removes the producto complementario with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the producto complementario
	 * @return the producto complementario that was removed
	 * @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductoComplementario remove(Serializable primaryKey)
		throws NoSuchProductoComplementarioException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ProductoComplementario productoComplementario = (ProductoComplementario)session.get(ProductoComplementarioImpl.class,
					primaryKey);

			if (productoComplementario == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductoComplementarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(productoComplementario);
		}
		catch (NoSuchProductoComplementarioException nsee) {
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
	protected ProductoComplementario removeImpl(
		ProductoComplementario productoComplementario)
		throws SystemException {
		productoComplementario = toUnwrappedModel(productoComplementario);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, productoComplementario);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(productoComplementario);

		return productoComplementario;
	}

	@Override
	public ProductoComplementario updateImpl(
		com.ext.portlet.halcon.model.ProductoComplementario productoComplementario,
		boolean merge) throws SystemException {
		productoComplementario = toUnwrappedModel(productoComplementario);

		boolean isNew = productoComplementario.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, productoComplementario, merge);

			productoComplementario.setNew(false);
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

		EntityCacheUtil.putResult(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
			ProductoComplementarioImpl.class,
			productoComplementario.getPrimaryKey(), productoComplementario);

		return productoComplementario;
	}

	protected ProductoComplementario toUnwrappedModel(
		ProductoComplementario productoComplementario) {
		if (productoComplementario instanceof ProductoComplementarioImpl) {
			return productoComplementario;
		}

		ProductoComplementarioImpl productoComplementarioImpl = new ProductoComplementarioImpl();

		productoComplementarioImpl.setNew(productoComplementario.isNew());
		productoComplementarioImpl.setPrimaryKey(productoComplementario.getPrimaryKey());

		productoComplementarioImpl.setIdProductoComplementario(productoComplementario.getIdProductoComplementario());
		productoComplementarioImpl.setIdSolicitudProducto(productoComplementario.getIdSolicitudProducto());
		productoComplementarioImpl.setPrincipalidad(productoComplementario.getPrincipalidad());
		productoComplementarioImpl.setProducto(productoComplementario.getProducto());
		productoComplementarioImpl.setIdProducto(productoComplementario.getIdProducto());
		productoComplementarioImpl.setIdGrupoProducto(productoComplementario.getIdGrupoProducto());
		productoComplementarioImpl.setEmailSupervisor(productoComplementario.getEmailSupervisor());

		return productoComplementarioImpl;
	}

	/**
	 * Returns the producto complementario with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the producto complementario
	 * @return the producto complementario
	 * @throws com.liferay.portal.NoSuchModelException if a producto complementario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductoComplementario findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the producto complementario with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchProductoComplementarioException} if it could not be found.
	 *
	 * @param idProductoComplementario the primary key of the producto complementario
	 * @return the producto complementario
	 * @throws com.ext.portlet.halcon.NoSuchProductoComplementarioException if a producto complementario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductoComplementario findByPrimaryKey(
		long idProductoComplementario)
		throws NoSuchProductoComplementarioException, SystemException {
		ProductoComplementario productoComplementario = fetchByPrimaryKey(idProductoComplementario);

		if (productoComplementario == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idProductoComplementario);
			}

			throw new NoSuchProductoComplementarioException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idProductoComplementario);
		}

		return productoComplementario;
	}

	/**
	 * Returns the producto complementario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the producto complementario
	 * @return the producto complementario, or <code>null</code> if a producto complementario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ProductoComplementario fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the producto complementario with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idProductoComplementario the primary key of the producto complementario
	 * @return the producto complementario, or <code>null</code> if a producto complementario with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ProductoComplementario fetchByPrimaryKey(
		long idProductoComplementario) throws SystemException {
		ProductoComplementario productoComplementario = (ProductoComplementario)EntityCacheUtil.getResult(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
				ProductoComplementarioImpl.class, idProductoComplementario);

		if (productoComplementario == _nullProductoComplementario) {
			return null;
		}

		if (productoComplementario == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				productoComplementario = (ProductoComplementario)session.get(ProductoComplementarioImpl.class,
						Long.valueOf(idProductoComplementario));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (productoComplementario != null) {
					cacheResult(productoComplementario);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ProductoComplementarioModelImpl.ENTITY_CACHE_ENABLED,
						ProductoComplementarioImpl.class,
						idProductoComplementario, _nullProductoComplementario);
				}

				closeSession(session);
			}
		}

		return productoComplementario;
	}

	/**
	 * Returns all the producto complementarios.
	 *
	 * @return the producto complementarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductoComplementario> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the producto complementarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto complementarios
	 * @param end the upper bound of the range of producto complementarios (not inclusive)
	 * @return the range of producto complementarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductoComplementario> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the producto complementarios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of producto complementarios
	 * @param end the upper bound of the range of producto complementarios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of producto complementarios
	 * @throws SystemException if a system exception occurred
	 */
	public List<ProductoComplementario> findAll(int start, int end,
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

		List<ProductoComplementario> list = (List<ProductoComplementario>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PRODUCTOCOMPLEMENTARIO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTOCOMPLEMENTARIO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ProductoComplementario>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ProductoComplementario>)QueryUtil.list(q,
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
	 * Removes all the producto complementarios from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ProductoComplementario productoComplementario : findAll()) {
			remove(productoComplementario);
		}
	}

	/**
	 * Returns the number of producto complementarios.
	 *
	 * @return the number of producto complementarios
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PRODUCTOCOMPLEMENTARIO);

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
	 * Initializes the producto complementario persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.ProductoComplementario")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ProductoComplementario>> listenersList = new ArrayList<ModelListener<ProductoComplementario>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ProductoComplementario>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ProductoComplementarioImpl.class.getName());
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
	private static final String _SQL_SELECT_PRODUCTOCOMPLEMENTARIO = "SELECT productoComplementario FROM ProductoComplementario productoComplementario";
	private static final String _SQL_COUNT_PRODUCTOCOMPLEMENTARIO = "SELECT COUNT(productoComplementario) FROM ProductoComplementario productoComplementario";
	private static final String _ORDER_BY_ENTITY_ALIAS = "productoComplementario.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ProductoComplementario exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ProductoComplementarioPersistenceImpl.class);
	private static ProductoComplementario _nullProductoComplementario = new ProductoComplementarioImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ProductoComplementario> toCacheModel() {
				return _nullProductoComplementarioCacheModel;
			}
		};

	private static CacheModel<ProductoComplementario> _nullProductoComplementarioCacheModel =
		new CacheModel<ProductoComplementario>() {
			public ProductoComplementario toEntityModel() {
				return _nullProductoComplementario;
			}
		};
}