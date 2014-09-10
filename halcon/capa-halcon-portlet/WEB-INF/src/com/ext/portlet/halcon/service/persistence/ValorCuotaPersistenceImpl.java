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

import com.ext.portlet.halcon.NoSuchValorCuotaException;
import com.ext.portlet.halcon.model.ValorCuota;
import com.ext.portlet.halcon.model.impl.ValorCuotaImpl;
import com.ext.portlet.halcon.model.impl.ValorCuotaModelImpl;

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
 * The persistence implementation for the valor cuota service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ValorCuotaPersistence
 * @see ValorCuotaUtil
 * @generated
 */
public class ValorCuotaPersistenceImpl extends BasePersistenceImpl<ValorCuota>
	implements ValorCuotaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ValorCuotaUtil} to access the valor cuota persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ValorCuotaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
			ValorCuotaModelImpl.FINDER_CACHE_ENABLED, ValorCuotaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
			ValorCuotaModelImpl.FINDER_CACHE_ENABLED, ValorCuotaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
			ValorCuotaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the valor cuota in the entity cache if it is enabled.
	 *
	 * @param valorCuota the valor cuota
	 */
	public void cacheResult(ValorCuota valorCuota) {
		EntityCacheUtil.putResult(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
			ValorCuotaImpl.class, valorCuota.getPrimaryKey(), valorCuota);

		valorCuota.resetOriginalValues();
	}

	/**
	 * Caches the valor cuotas in the entity cache if it is enabled.
	 *
	 * @param valorCuotas the valor cuotas
	 */
	public void cacheResult(List<ValorCuota> valorCuotas) {
		for (ValorCuota valorCuota : valorCuotas) {
			if (EntityCacheUtil.getResult(
						ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
						ValorCuotaImpl.class, valorCuota.getPrimaryKey()) == null) {
				cacheResult(valorCuota);
			}
			else {
				valorCuota.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all valor cuotas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ValorCuotaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ValorCuotaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the valor cuota.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ValorCuota valorCuota) {
		EntityCacheUtil.removeResult(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
			ValorCuotaImpl.class, valorCuota.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ValorCuota> valorCuotas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ValorCuota valorCuota : valorCuotas) {
			EntityCacheUtil.removeResult(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
				ValorCuotaImpl.class, valorCuota.getPrimaryKey());
		}
	}

	/**
	 * Creates a new valor cuota with the primary key. Does not add the valor cuota to the database.
	 *
	 * @param IdValorCuota the primary key for the new valor cuota
	 * @return the new valor cuota
	 */
	public ValorCuota create(long IdValorCuota) {
		ValorCuota valorCuota = new ValorCuotaImpl();

		valorCuota.setNew(true);
		valorCuota.setPrimaryKey(IdValorCuota);

		return valorCuota;
	}

	/**
	 * Removes the valor cuota with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param IdValorCuota the primary key of the valor cuota
	 * @return the valor cuota that was removed
	 * @throws com.ext.portlet.halcon.NoSuchValorCuotaException if a valor cuota with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ValorCuota remove(long IdValorCuota)
		throws NoSuchValorCuotaException, SystemException {
		return remove(Long.valueOf(IdValorCuota));
	}

	/**
	 * Removes the valor cuota with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the valor cuota
	 * @return the valor cuota that was removed
	 * @throws com.ext.portlet.halcon.NoSuchValorCuotaException if a valor cuota with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ValorCuota remove(Serializable primaryKey)
		throws NoSuchValorCuotaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ValorCuota valorCuota = (ValorCuota)session.get(ValorCuotaImpl.class,
					primaryKey);

			if (valorCuota == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchValorCuotaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(valorCuota);
		}
		catch (NoSuchValorCuotaException nsee) {
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
	protected ValorCuota removeImpl(ValorCuota valorCuota)
		throws SystemException {
		valorCuota = toUnwrappedModel(valorCuota);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, valorCuota);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(valorCuota);

		return valorCuota;
	}

	@Override
	public ValorCuota updateImpl(
		com.ext.portlet.halcon.model.ValorCuota valorCuota, boolean merge)
		throws SystemException {
		valorCuota = toUnwrappedModel(valorCuota);

		boolean isNew = valorCuota.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, valorCuota, merge);

			valorCuota.setNew(false);
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

		EntityCacheUtil.putResult(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
			ValorCuotaImpl.class, valorCuota.getPrimaryKey(), valorCuota);

		return valorCuota;
	}

	protected ValorCuota toUnwrappedModel(ValorCuota valorCuota) {
		if (valorCuota instanceof ValorCuotaImpl) {
			return valorCuota;
		}

		ValorCuotaImpl valorCuotaImpl = new ValorCuotaImpl();

		valorCuotaImpl.setNew(valorCuota.isNew());
		valorCuotaImpl.setPrimaryKey(valorCuota.getPrimaryKey());

		valorCuotaImpl.setIdValorCuota(valorCuota.getIdValorCuota());
		valorCuotaImpl.setTipoFondoMutuo(valorCuota.getTipoFondoMutuo());
		valorCuotaImpl.setFecha(valorCuota.getFecha());
		valorCuotaImpl.setValorCuota(valorCuota.getValorCuota());

		return valorCuotaImpl;
	}

	/**
	 * Returns the valor cuota with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the valor cuota
	 * @return the valor cuota
	 * @throws com.liferay.portal.NoSuchModelException if a valor cuota with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ValorCuota findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the valor cuota with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchValorCuotaException} if it could not be found.
	 *
	 * @param IdValorCuota the primary key of the valor cuota
	 * @return the valor cuota
	 * @throws com.ext.portlet.halcon.NoSuchValorCuotaException if a valor cuota with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ValorCuota findByPrimaryKey(long IdValorCuota)
		throws NoSuchValorCuotaException, SystemException {
		ValorCuota valorCuota = fetchByPrimaryKey(IdValorCuota);

		if (valorCuota == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + IdValorCuota);
			}

			throw new NoSuchValorCuotaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				IdValorCuota);
		}

		return valorCuota;
	}

	/**
	 * Returns the valor cuota with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the valor cuota
	 * @return the valor cuota, or <code>null</code> if a valor cuota with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ValorCuota fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the valor cuota with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param IdValorCuota the primary key of the valor cuota
	 * @return the valor cuota, or <code>null</code> if a valor cuota with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ValorCuota fetchByPrimaryKey(long IdValorCuota)
		throws SystemException {
		ValorCuota valorCuota = (ValorCuota)EntityCacheUtil.getResult(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
				ValorCuotaImpl.class, IdValorCuota);

		if (valorCuota == _nullValorCuota) {
			return null;
		}

		if (valorCuota == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				valorCuota = (ValorCuota)session.get(ValorCuotaImpl.class,
						Long.valueOf(IdValorCuota));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (valorCuota != null) {
					cacheResult(valorCuota);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ValorCuotaModelImpl.ENTITY_CACHE_ENABLED,
						ValorCuotaImpl.class, IdValorCuota, _nullValorCuota);
				}

				closeSession(session);
			}
		}

		return valorCuota;
	}

	/**
	 * Returns all the valor cuotas.
	 *
	 * @return the valor cuotas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ValorCuota> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the valor cuotas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of valor cuotas
	 * @param end the upper bound of the range of valor cuotas (not inclusive)
	 * @return the range of valor cuotas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ValorCuota> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the valor cuotas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of valor cuotas
	 * @param end the upper bound of the range of valor cuotas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of valor cuotas
	 * @throws SystemException if a system exception occurred
	 */
	public List<ValorCuota> findAll(int start, int end,
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

		List<ValorCuota> list = (List<ValorCuota>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VALORCUOTA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VALORCUOTA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ValorCuota>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ValorCuota>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the valor cuotas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ValorCuota valorCuota : findAll()) {
			remove(valorCuota);
		}
	}

	/**
	 * Returns the number of valor cuotas.
	 *
	 * @return the number of valor cuotas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VALORCUOTA);

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
	 * Initializes the valor cuota persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.ValorCuota")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ValorCuota>> listenersList = new ArrayList<ModelListener<ValorCuota>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ValorCuota>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ValorCuotaImpl.class.getName());
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
	private static final String _SQL_SELECT_VALORCUOTA = "SELECT valorCuota FROM ValorCuota valorCuota";
	private static final String _SQL_COUNT_VALORCUOTA = "SELECT COUNT(valorCuota) FROM ValorCuota valorCuota";
	private static final String _ORDER_BY_ENTITY_ALIAS = "valorCuota.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ValorCuota exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ValorCuotaPersistenceImpl.class);
	private static ValorCuota _nullValorCuota = new ValorCuotaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ValorCuota> toCacheModel() {
				return _nullValorCuotaCacheModel;
			}
		};

	private static CacheModel<ValorCuota> _nullValorCuotaCacheModel = new CacheModel<ValorCuota>() {
			public ValorCuota toEntityModel() {
				return _nullValorCuota;
			}
		};
}