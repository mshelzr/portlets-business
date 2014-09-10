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

import com.ext.portlet.halcon.NoSuchConfiguracionProductoException;
import com.ext.portlet.halcon.model.ConfiguracionProducto;
import com.ext.portlet.halcon.model.impl.ConfiguracionProductoImpl;
import com.ext.portlet.halcon.model.impl.ConfiguracionProductoModelImpl;

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
 * The persistence implementation for the configuracion producto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionProductoPersistence
 * @see ConfiguracionProductoUtil
 * @generated
 */
public class ConfiguracionProductoPersistenceImpl extends BasePersistenceImpl<ConfiguracionProducto>
	implements ConfiguracionProductoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConfiguracionProductoUtil} to access the configuracion producto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConfiguracionProductoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionProductoModelImpl.FINDER_CACHE_ENABLED,
			ConfiguracionProductoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionProductoModelImpl.FINDER_CACHE_ENABLED,
			ConfiguracionProductoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionProductoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the configuracion producto in the entity cache if it is enabled.
	 *
	 * @param configuracionProducto the configuracion producto
	 */
	public void cacheResult(ConfiguracionProducto configuracionProducto) {
		EntityCacheUtil.putResult(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionProductoImpl.class,
			configuracionProducto.getPrimaryKey(), configuracionProducto);

		configuracionProducto.resetOriginalValues();
	}

	/**
	 * Caches the configuracion productos in the entity cache if it is enabled.
	 *
	 * @param configuracionProductos the configuracion productos
	 */
	public void cacheResult(List<ConfiguracionProducto> configuracionProductos) {
		for (ConfiguracionProducto configuracionProducto : configuracionProductos) {
			if (EntityCacheUtil.getResult(
						ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
						ConfiguracionProductoImpl.class,
						configuracionProducto.getPrimaryKey()) == null) {
				cacheResult(configuracionProducto);
			}
			else {
				configuracionProducto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all configuracion productos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConfiguracionProductoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConfiguracionProductoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the configuracion producto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConfiguracionProducto configuracionProducto) {
		EntityCacheUtil.removeResult(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionProductoImpl.class,
			configuracionProducto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ConfiguracionProducto> configuracionProductos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConfiguracionProducto configuracionProducto : configuracionProductos) {
			EntityCacheUtil.removeResult(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
				ConfiguracionProductoImpl.class,
				configuracionProducto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new configuracion producto with the primary key. Does not add the configuracion producto to the database.
	 *
	 * @param idConfiguracionProducto the primary key for the new configuracion producto
	 * @return the new configuracion producto
	 */
	public ConfiguracionProducto create(long idConfiguracionProducto) {
		ConfiguracionProducto configuracionProducto = new ConfiguracionProductoImpl();

		configuracionProducto.setNew(true);
		configuracionProducto.setPrimaryKey(idConfiguracionProducto);

		return configuracionProducto;
	}

	/**
	 * Removes the configuracion producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idConfiguracionProducto the primary key of the configuracion producto
	 * @return the configuracion producto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException if a configuracion producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ConfiguracionProducto remove(long idConfiguracionProducto)
		throws NoSuchConfiguracionProductoException, SystemException {
		return remove(Long.valueOf(idConfiguracionProducto));
	}

	/**
	 * Removes the configuracion producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the configuracion producto
	 * @return the configuracion producto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException if a configuracion producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfiguracionProducto remove(Serializable primaryKey)
		throws NoSuchConfiguracionProductoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConfiguracionProducto configuracionProducto = (ConfiguracionProducto)session.get(ConfiguracionProductoImpl.class,
					primaryKey);

			if (configuracionProducto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfiguracionProductoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(configuracionProducto);
		}
		catch (NoSuchConfiguracionProductoException nsee) {
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
	protected ConfiguracionProducto removeImpl(
		ConfiguracionProducto configuracionProducto) throws SystemException {
		configuracionProducto = toUnwrappedModel(configuracionProducto);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, configuracionProducto);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(configuracionProducto);

		return configuracionProducto;
	}

	@Override
	public ConfiguracionProducto updateImpl(
		com.ext.portlet.halcon.model.ConfiguracionProducto configuracionProducto,
		boolean merge) throws SystemException {
		configuracionProducto = toUnwrappedModel(configuracionProducto);

		boolean isNew = configuracionProducto.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, configuracionProducto, merge);

			configuracionProducto.setNew(false);
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

		EntityCacheUtil.putResult(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionProductoImpl.class,
			configuracionProducto.getPrimaryKey(), configuracionProducto);

		return configuracionProducto;
	}

	protected ConfiguracionProducto toUnwrappedModel(
		ConfiguracionProducto configuracionProducto) {
		if (configuracionProducto instanceof ConfiguracionProductoImpl) {
			return configuracionProducto;
		}

		ConfiguracionProductoImpl configuracionProductoImpl = new ConfiguracionProductoImpl();

		configuracionProductoImpl.setNew(configuracionProducto.isNew());
		configuracionProductoImpl.setPrimaryKey(configuracionProducto.getPrimaryKey());

		configuracionProductoImpl.setIdConfiguracionProducto(configuracionProducto.getIdConfiguracionProducto());
		configuracionProductoImpl.setIdConfiguracionPerfilador(configuracionProducto.getIdConfiguracionPerfilador());
		configuracionProductoImpl.setIdProducto(configuracionProducto.getIdProducto());
		configuracionProductoImpl.setNombreProducto(configuracionProducto.getNombreProducto());
		configuracionProductoImpl.setCodigoSiebelProducto(configuracionProducto.getCodigoSiebelProducto());
		configuracionProductoImpl.setEstadoConfiguracion(configuracionProducto.getEstadoConfiguracion());

		return configuracionProductoImpl;
	}

	/**
	 * Returns the configuracion producto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuracion producto
	 * @return the configuracion producto
	 * @throws com.liferay.portal.NoSuchModelException if a configuracion producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfiguracionProducto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the configuracion producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchConfiguracionProductoException} if it could not be found.
	 *
	 * @param idConfiguracionProducto the primary key of the configuracion producto
	 * @return the configuracion producto
	 * @throws com.ext.portlet.halcon.NoSuchConfiguracionProductoException if a configuracion producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ConfiguracionProducto findByPrimaryKey(long idConfiguracionProducto)
		throws NoSuchConfiguracionProductoException, SystemException {
		ConfiguracionProducto configuracionProducto = fetchByPrimaryKey(idConfiguracionProducto);

		if (configuracionProducto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idConfiguracionProducto);
			}

			throw new NoSuchConfiguracionProductoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idConfiguracionProducto);
		}

		return configuracionProducto;
	}

	/**
	 * Returns the configuracion producto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuracion producto
	 * @return the configuracion producto, or <code>null</code> if a configuracion producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfiguracionProducto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the configuracion producto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idConfiguracionProducto the primary key of the configuracion producto
	 * @return the configuracion producto, or <code>null</code> if a configuracion producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ConfiguracionProducto fetchByPrimaryKey(long idConfiguracionProducto)
		throws SystemException {
		ConfiguracionProducto configuracionProducto = (ConfiguracionProducto)EntityCacheUtil.getResult(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
				ConfiguracionProductoImpl.class, idConfiguracionProducto);

		if (configuracionProducto == _nullConfiguracionProducto) {
			return null;
		}

		if (configuracionProducto == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				configuracionProducto = (ConfiguracionProducto)session.get(ConfiguracionProductoImpl.class,
						Long.valueOf(idConfiguracionProducto));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (configuracionProducto != null) {
					cacheResult(configuracionProducto);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ConfiguracionProductoModelImpl.ENTITY_CACHE_ENABLED,
						ConfiguracionProductoImpl.class,
						idConfiguracionProducto, _nullConfiguracionProducto);
				}

				closeSession(session);
			}
		}

		return configuracionProducto;
	}

	/**
	 * Returns all the configuracion productos.
	 *
	 * @return the configuracion productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ConfiguracionProducto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuracion productos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuracion productos
	 * @param end the upper bound of the range of configuracion productos (not inclusive)
	 * @return the range of configuracion productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ConfiguracionProducto> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuracion productos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuracion productos
	 * @param end the upper bound of the range of configuracion productos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of configuracion productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<ConfiguracionProducto> findAll(int start, int end,
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

		List<ConfiguracionProducto> list = (List<ConfiguracionProducto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONFIGURACIONPRODUCTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONFIGURACIONPRODUCTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ConfiguracionProducto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ConfiguracionProducto>)QueryUtil.list(q,
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
	 * Removes all the configuracion productos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ConfiguracionProducto configuracionProducto : findAll()) {
			remove(configuracionProducto);
		}
	}

	/**
	 * Returns the number of configuracion productos.
	 *
	 * @return the number of configuracion productos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONFIGURACIONPRODUCTO);

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
	 * Initializes the configuracion producto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.ConfiguracionProducto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConfiguracionProducto>> listenersList = new ArrayList<ModelListener<ConfiguracionProducto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConfiguracionProducto>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConfiguracionProductoImpl.class.getName());
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
	private static final String _SQL_SELECT_CONFIGURACIONPRODUCTO = "SELECT configuracionProducto FROM ConfiguracionProducto configuracionProducto";
	private static final String _SQL_COUNT_CONFIGURACIONPRODUCTO = "SELECT COUNT(configuracionProducto) FROM ConfiguracionProducto configuracionProducto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "configuracionProducto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConfiguracionProducto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConfiguracionProductoPersistenceImpl.class);
	private static ConfiguracionProducto _nullConfiguracionProducto = new ConfiguracionProductoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConfiguracionProducto> toCacheModel() {
				return _nullConfiguracionProductoCacheModel;
			}
		};

	private static CacheModel<ConfiguracionProducto> _nullConfiguracionProductoCacheModel =
		new CacheModel<ConfiguracionProducto>() {
			public ConfiguracionProducto toEntityModel() {
				return _nullConfiguracionProducto;
			}
		};
}