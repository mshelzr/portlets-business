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

import com.ext.portlet.halcon.NoSuchFondosMutuosException;
import com.ext.portlet.halcon.model.FondosMutuos;
import com.ext.portlet.halcon.model.impl.FondosMutuosImpl;
import com.ext.portlet.halcon.model.impl.FondosMutuosModelImpl;

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
 * The persistence implementation for the fondos mutuos service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see FondosMutuosPersistence
 * @see FondosMutuosUtil
 * @generated
 */
public class FondosMutuosPersistenceImpl extends BasePersistenceImpl<FondosMutuos>
	implements FondosMutuosPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FondosMutuosUtil} to access the fondos mutuos persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FondosMutuosImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosModelImpl.FINDER_CACHE_ENABLED, FondosMutuosImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosModelImpl.FINDER_CACHE_ENABLED, FondosMutuosImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the fondos mutuos in the entity cache if it is enabled.
	 *
	 * @param fondosMutuos the fondos mutuos
	 */
	public void cacheResult(FondosMutuos fondosMutuos) {
		EntityCacheUtil.putResult(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosImpl.class, fondosMutuos.getPrimaryKey(), fondosMutuos);

		fondosMutuos.resetOriginalValues();
	}

	/**
	 * Caches the fondos mutuoses in the entity cache if it is enabled.
	 *
	 * @param fondosMutuoses the fondos mutuoses
	 */
	public void cacheResult(List<FondosMutuos> fondosMutuoses) {
		for (FondosMutuos fondosMutuos : fondosMutuoses) {
			if (EntityCacheUtil.getResult(
						FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
						FondosMutuosImpl.class, fondosMutuos.getPrimaryKey()) == null) {
				cacheResult(fondosMutuos);
			}
			else {
				fondosMutuos.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all fondos mutuoses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FondosMutuosImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FondosMutuosImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the fondos mutuos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FondosMutuos fondosMutuos) {
		EntityCacheUtil.removeResult(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosImpl.class, fondosMutuos.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FondosMutuos> fondosMutuoses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FondosMutuos fondosMutuos : fondosMutuoses) {
			EntityCacheUtil.removeResult(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
				FondosMutuosImpl.class, fondosMutuos.getPrimaryKey());
		}
	}

	/**
	 * Creates a new fondos mutuos with the primary key. Does not add the fondos mutuos to the database.
	 *
	 * @param idValorCuota the primary key for the new fondos mutuos
	 * @return the new fondos mutuos
	 */
	public FondosMutuos create(long idValorCuota) {
		FondosMutuos fondosMutuos = new FondosMutuosImpl();

		fondosMutuos.setNew(true);
		fondosMutuos.setPrimaryKey(idValorCuota);

		return fondosMutuos;
	}

	/**
	 * Removes the fondos mutuos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idValorCuota the primary key of the fondos mutuos
	 * @return the fondos mutuos that was removed
	 * @throws com.ext.portlet.halcon.NoSuchFondosMutuosException if a fondos mutuos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FondosMutuos remove(long idValorCuota)
		throws NoSuchFondosMutuosException, SystemException {
		return remove(Long.valueOf(idValorCuota));
	}

	/**
	 * Removes the fondos mutuos with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the fondos mutuos
	 * @return the fondos mutuos that was removed
	 * @throws com.ext.portlet.halcon.NoSuchFondosMutuosException if a fondos mutuos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FondosMutuos remove(Serializable primaryKey)
		throws NoSuchFondosMutuosException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FondosMutuos fondosMutuos = (FondosMutuos)session.get(FondosMutuosImpl.class,
					primaryKey);

			if (fondosMutuos == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFondosMutuosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(fondosMutuos);
		}
		catch (NoSuchFondosMutuosException nsee) {
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
	protected FondosMutuos removeImpl(FondosMutuos fondosMutuos)
		throws SystemException {
		fondosMutuos = toUnwrappedModel(fondosMutuos);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, fondosMutuos);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(fondosMutuos);

		return fondosMutuos;
	}

	@Override
	public FondosMutuos updateImpl(
		com.ext.portlet.halcon.model.FondosMutuos fondosMutuos, boolean merge)
		throws SystemException {
		fondosMutuos = toUnwrappedModel(fondosMutuos);

		boolean isNew = fondosMutuos.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, fondosMutuos, merge);

			fondosMutuos.setNew(false);
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

		EntityCacheUtil.putResult(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
			FondosMutuosImpl.class, fondosMutuos.getPrimaryKey(), fondosMutuos);

		return fondosMutuos;
	}

	protected FondosMutuos toUnwrappedModel(FondosMutuos fondosMutuos) {
		if (fondosMutuos instanceof FondosMutuosImpl) {
			return fondosMutuos;
		}

		FondosMutuosImpl fondosMutuosImpl = new FondosMutuosImpl();

		fondosMutuosImpl.setNew(fondosMutuos.isNew());
		fondosMutuosImpl.setPrimaryKey(fondosMutuos.getPrimaryKey());

		fondosMutuosImpl.setIdValorCuota(fondosMutuos.getIdValorCuota());
		fondosMutuosImpl.setCodigoMoneda(fondosMutuos.getCodigoMoneda());
		fondosMutuosImpl.setTipoFondo(fondosMutuos.getTipoFondo());
		fondosMutuosImpl.setValorCuota(fondosMutuos.getValorCuota());
		fondosMutuosImpl.setFecha(fondosMutuos.getFecha());

		return fondosMutuosImpl;
	}

	/**
	 * Returns the fondos mutuos with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the fondos mutuos
	 * @return the fondos mutuos
	 * @throws com.liferay.portal.NoSuchModelException if a fondos mutuos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FondosMutuos findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the fondos mutuos with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchFondosMutuosException} if it could not be found.
	 *
	 * @param idValorCuota the primary key of the fondos mutuos
	 * @return the fondos mutuos
	 * @throws com.ext.portlet.halcon.NoSuchFondosMutuosException if a fondos mutuos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FondosMutuos findByPrimaryKey(long idValorCuota)
		throws NoSuchFondosMutuosException, SystemException {
		FondosMutuos fondosMutuos = fetchByPrimaryKey(idValorCuota);

		if (fondosMutuos == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idValorCuota);
			}

			throw new NoSuchFondosMutuosException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idValorCuota);
		}

		return fondosMutuos;
	}

	/**
	 * Returns the fondos mutuos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the fondos mutuos
	 * @return the fondos mutuos, or <code>null</code> if a fondos mutuos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FondosMutuos fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the fondos mutuos with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idValorCuota the primary key of the fondos mutuos
	 * @return the fondos mutuos, or <code>null</code> if a fondos mutuos with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public FondosMutuos fetchByPrimaryKey(long idValorCuota)
		throws SystemException {
		FondosMutuos fondosMutuos = (FondosMutuos)EntityCacheUtil.getResult(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
				FondosMutuosImpl.class, idValorCuota);

		if (fondosMutuos == _nullFondosMutuos) {
			return null;
		}

		if (fondosMutuos == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				fondosMutuos = (FondosMutuos)session.get(FondosMutuosImpl.class,
						Long.valueOf(idValorCuota));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (fondosMutuos != null) {
					cacheResult(fondosMutuos);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(FondosMutuosModelImpl.ENTITY_CACHE_ENABLED,
						FondosMutuosImpl.class, idValorCuota, _nullFondosMutuos);
				}

				closeSession(session);
			}
		}

		return fondosMutuos;
	}

	/**
	 * Returns all the fondos mutuoses.
	 *
	 * @return the fondos mutuoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<FondosMutuos> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the fondos mutuoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of fondos mutuoses
	 * @param end the upper bound of the range of fondos mutuoses (not inclusive)
	 * @return the range of fondos mutuoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<FondosMutuos> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the fondos mutuoses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of fondos mutuoses
	 * @param end the upper bound of the range of fondos mutuoses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of fondos mutuoses
	 * @throws SystemException if a system exception occurred
	 */
	public List<FondosMutuos> findAll(int start, int end,
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

		List<FondosMutuos> list = (List<FondosMutuos>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FONDOSMUTUOS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FONDOSMUTUOS;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<FondosMutuos>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<FondosMutuos>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the fondos mutuoses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (FondosMutuos fondosMutuos : findAll()) {
			remove(fondosMutuos);
		}
	}

	/**
	 * Returns the number of fondos mutuoses.
	 *
	 * @return the number of fondos mutuoses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_FONDOSMUTUOS);

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
	 * Initializes the fondos mutuos persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.FondosMutuos")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FondosMutuos>> listenersList = new ArrayList<ModelListener<FondosMutuos>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FondosMutuos>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FondosMutuosImpl.class.getName());
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
	private static final String _SQL_SELECT_FONDOSMUTUOS = "SELECT fondosMutuos FROM FondosMutuos fondosMutuos";
	private static final String _SQL_COUNT_FONDOSMUTUOS = "SELECT COUNT(fondosMutuos) FROM FondosMutuos fondosMutuos";
	private static final String _ORDER_BY_ENTITY_ALIAS = "fondosMutuos.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FondosMutuos exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FondosMutuosPersistenceImpl.class);
	private static FondosMutuos _nullFondosMutuos = new FondosMutuosImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FondosMutuos> toCacheModel() {
				return _nullFondosMutuosCacheModel;
			}
		};

	private static CacheModel<FondosMutuos> _nullFondosMutuosCacheModel = new CacheModel<FondosMutuos>() {
			public FondosMutuos toEntityModel() {
				return _nullFondosMutuos;
			}
		};
}