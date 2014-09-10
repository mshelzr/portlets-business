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

import com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException;
import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;
import com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoImpl;
import com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoModelImpl;

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
 * The persistence implementation for the telefono solicitud producto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see TelefonoSolicitudProductoPersistence
 * @see TelefonoSolicitudProductoUtil
 * @generated
 */
public class TelefonoSolicitudProductoPersistenceImpl
	extends BasePersistenceImpl<TelefonoSolicitudProducto>
	implements TelefonoSolicitudProductoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TelefonoSolicitudProductoUtil} to access the telefono solicitud producto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TelefonoSolicitudProductoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			TelefonoSolicitudProductoModelImpl.FINDER_CACHE_ENABLED,
			TelefonoSolicitudProductoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			TelefonoSolicitudProductoModelImpl.FINDER_CACHE_ENABLED,
			TelefonoSolicitudProductoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			TelefonoSolicitudProductoModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	/**
	 * Caches the telefono solicitud producto in the entity cache if it is enabled.
	 *
	 * @param telefonoSolicitudProducto the telefono solicitud producto
	 */
	public void cacheResult(TelefonoSolicitudProducto telefonoSolicitudProducto) {
		EntityCacheUtil.putResult(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			TelefonoSolicitudProductoImpl.class,
			telefonoSolicitudProducto.getPrimaryKey(), telefonoSolicitudProducto);

		telefonoSolicitudProducto.resetOriginalValues();
	}

	/**
	 * Caches the telefono solicitud productos in the entity cache if it is enabled.
	 *
	 * @param telefonoSolicitudProductos the telefono solicitud productos
	 */
	public void cacheResult(
		List<TelefonoSolicitudProducto> telefonoSolicitudProductos) {
		for (TelefonoSolicitudProducto telefonoSolicitudProducto : telefonoSolicitudProductos) {
			if (EntityCacheUtil.getResult(
						TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
						TelefonoSolicitudProductoImpl.class,
						telefonoSolicitudProducto.getPrimaryKey()) == null) {
				cacheResult(telefonoSolicitudProducto);
			}
			else {
				telefonoSolicitudProducto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all telefono solicitud productos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TelefonoSolicitudProductoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TelefonoSolicitudProductoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the telefono solicitud producto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TelefonoSolicitudProducto telefonoSolicitudProducto) {
		EntityCacheUtil.removeResult(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			TelefonoSolicitudProductoImpl.class,
			telefonoSolicitudProducto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<TelefonoSolicitudProducto> telefonoSolicitudProductos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TelefonoSolicitudProducto telefonoSolicitudProducto : telefonoSolicitudProductos) {
			EntityCacheUtil.removeResult(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
				TelefonoSolicitudProductoImpl.class,
				telefonoSolicitudProducto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new telefono solicitud producto with the primary key. Does not add the telefono solicitud producto to the database.
	 *
	 * @param idTelefSolicitudProducto the primary key for the new telefono solicitud producto
	 * @return the new telefono solicitud producto
	 */
	public TelefonoSolicitudProducto create(long idTelefSolicitudProducto) {
		TelefonoSolicitudProducto telefonoSolicitudProducto = new TelefonoSolicitudProductoImpl();

		telefonoSolicitudProducto.setNew(true);
		telefonoSolicitudProducto.setPrimaryKey(idTelefSolicitudProducto);

		return telefonoSolicitudProducto;
	}

	/**
	 * Removes the telefono solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	 * @return the telefono solicitud producto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TelefonoSolicitudProducto remove(long idTelefSolicitudProducto)
		throws NoSuchTelefonoSolicitudProductoException, SystemException {
		return remove(Long.valueOf(idTelefSolicitudProducto));
	}

	/**
	 * Removes the telefono solicitud producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the telefono solicitud producto
	 * @return the telefono solicitud producto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TelefonoSolicitudProducto remove(Serializable primaryKey)
		throws NoSuchTelefonoSolicitudProductoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TelefonoSolicitudProducto telefonoSolicitudProducto = (TelefonoSolicitudProducto)session.get(TelefonoSolicitudProductoImpl.class,
					primaryKey);

			if (telefonoSolicitudProducto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTelefonoSolicitudProductoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(telefonoSolicitudProducto);
		}
		catch (NoSuchTelefonoSolicitudProductoException nsee) {
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
	protected TelefonoSolicitudProducto removeImpl(
		TelefonoSolicitudProducto telefonoSolicitudProducto)
		throws SystemException {
		telefonoSolicitudProducto = toUnwrappedModel(telefonoSolicitudProducto);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, telefonoSolicitudProducto);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(telefonoSolicitudProducto);

		return telefonoSolicitudProducto;
	}

	@Override
	public TelefonoSolicitudProducto updateImpl(
		com.ext.portlet.halcon.model.TelefonoSolicitudProducto telefonoSolicitudProducto,
		boolean merge) throws SystemException {
		telefonoSolicitudProducto = toUnwrappedModel(telefonoSolicitudProducto);

		boolean isNew = telefonoSolicitudProducto.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, telefonoSolicitudProducto, merge);

			telefonoSolicitudProducto.setNew(false);
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

		EntityCacheUtil.putResult(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
			TelefonoSolicitudProductoImpl.class,
			telefonoSolicitudProducto.getPrimaryKey(), telefonoSolicitudProducto);

		return telefonoSolicitudProducto;
	}

	protected TelefonoSolicitudProducto toUnwrappedModel(
		TelefonoSolicitudProducto telefonoSolicitudProducto) {
		if (telefonoSolicitudProducto instanceof TelefonoSolicitudProductoImpl) {
			return telefonoSolicitudProducto;
		}

		TelefonoSolicitudProductoImpl telefonoSolicitudProductoImpl = new TelefonoSolicitudProductoImpl();

		telefonoSolicitudProductoImpl.setNew(telefonoSolicitudProducto.isNew());
		telefonoSolicitudProductoImpl.setPrimaryKey(telefonoSolicitudProducto.getPrimaryKey());

		telefonoSolicitudProductoImpl.setIdTelefSolicitudProducto(telefonoSolicitudProducto.getIdTelefSolicitudProducto());
		telefonoSolicitudProductoImpl.setIdSolicitudProducto(telefonoSolicitudProducto.getIdSolicitudProducto());
		telefonoSolicitudProductoImpl.setTipoTelefono(telefonoSolicitudProducto.getTipoTelefono());
		telefonoSolicitudProductoImpl.setNumeroTelefono(telefonoSolicitudProducto.getNumeroTelefono());
		telefonoSolicitudProductoImpl.setAnexo(telefonoSolicitudProducto.getAnexo());

		return telefonoSolicitudProductoImpl;
	}

	/**
	 * Returns the telefono solicitud producto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the telefono solicitud producto
	 * @return the telefono solicitud producto
	 * @throws com.liferay.portal.NoSuchModelException if a telefono solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TelefonoSolicitudProducto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the telefono solicitud producto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException} if it could not be found.
	 *
	 * @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	 * @return the telefono solicitud producto
	 * @throws com.ext.portlet.halcon.NoSuchTelefonoSolicitudProductoException if a telefono solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TelefonoSolicitudProducto findByPrimaryKey(
		long idTelefSolicitudProducto)
		throws NoSuchTelefonoSolicitudProductoException, SystemException {
		TelefonoSolicitudProducto telefonoSolicitudProducto = fetchByPrimaryKey(idTelefSolicitudProducto);

		if (telefonoSolicitudProducto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idTelefSolicitudProducto);
			}

			throw new NoSuchTelefonoSolicitudProductoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idTelefSolicitudProducto);
		}

		return telefonoSolicitudProducto;
	}

	/**
	 * Returns the telefono solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the telefono solicitud producto
	 * @return the telefono solicitud producto, or <code>null</code> if a telefono solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TelefonoSolicitudProducto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the telefono solicitud producto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idTelefSolicitudProducto the primary key of the telefono solicitud producto
	 * @return the telefono solicitud producto, or <code>null</code> if a telefono solicitud producto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public TelefonoSolicitudProducto fetchByPrimaryKey(
		long idTelefSolicitudProducto) throws SystemException {
		TelefonoSolicitudProducto telefonoSolicitudProducto = (TelefonoSolicitudProducto)EntityCacheUtil.getResult(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
				TelefonoSolicitudProductoImpl.class, idTelefSolicitudProducto);

		if (telefonoSolicitudProducto == _nullTelefonoSolicitudProducto) {
			return null;
		}

		if (telefonoSolicitudProducto == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				telefonoSolicitudProducto = (TelefonoSolicitudProducto)session.get(TelefonoSolicitudProductoImpl.class,
						Long.valueOf(idTelefSolicitudProducto));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (telefonoSolicitudProducto != null) {
					cacheResult(telefonoSolicitudProducto);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(TelefonoSolicitudProductoModelImpl.ENTITY_CACHE_ENABLED,
						TelefonoSolicitudProductoImpl.class,
						idTelefSolicitudProducto, _nullTelefonoSolicitudProducto);
				}

				closeSession(session);
			}
		}

		return telefonoSolicitudProducto;
	}

	/**
	 * Returns all the telefono solicitud productos.
	 *
	 * @return the telefono solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TelefonoSolicitudProducto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the telefono solicitud productos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of telefono solicitud productos
	 * @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	 * @return the range of telefono solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TelefonoSolicitudProducto> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the telefono solicitud productos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of telefono solicitud productos
	 * @param end the upper bound of the range of telefono solicitud productos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of telefono solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public List<TelefonoSolicitudProducto> findAll(int start, int end,
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

		List<TelefonoSolicitudProducto> list = (List<TelefonoSolicitudProducto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TELEFONOSOLICITUDPRODUCTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TELEFONOSOLICITUDPRODUCTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<TelefonoSolicitudProducto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<TelefonoSolicitudProducto>)QueryUtil.list(q,
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
	 * Removes all the telefono solicitud productos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (TelefonoSolicitudProducto telefonoSolicitudProducto : findAll()) {
			remove(telefonoSolicitudProducto);
		}
	}

	/**
	 * Returns the number of telefono solicitud productos.
	 *
	 * @return the number of telefono solicitud productos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TELEFONOSOLICITUDPRODUCTO);

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
	 * Initializes the telefono solicitud producto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.TelefonoSolicitudProducto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TelefonoSolicitudProducto>> listenersList = new ArrayList<ModelListener<TelefonoSolicitudProducto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TelefonoSolicitudProducto>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TelefonoSolicitudProductoImpl.class.getName());
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
	private static final String _SQL_SELECT_TELEFONOSOLICITUDPRODUCTO = "SELECT telefonoSolicitudProducto FROM TelefonoSolicitudProducto telefonoSolicitudProducto";
	private static final String _SQL_COUNT_TELEFONOSOLICITUDPRODUCTO = "SELECT COUNT(telefonoSolicitudProducto) FROM TelefonoSolicitudProducto telefonoSolicitudProducto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "telefonoSolicitudProducto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TelefonoSolicitudProducto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TelefonoSolicitudProductoPersistenceImpl.class);
	private static TelefonoSolicitudProducto _nullTelefonoSolicitudProducto = new TelefonoSolicitudProductoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TelefonoSolicitudProducto> toCacheModel() {
				return _nullTelefonoSolicitudProductoCacheModel;
			}
		};

	private static CacheModel<TelefonoSolicitudProducto> _nullTelefonoSolicitudProductoCacheModel =
		new CacheModel<TelefonoSolicitudProducto>() {
			public TelefonoSolicitudProducto toEntityModel() {
				return _nullTelefonoSolicitudProducto;
			}
		};
}