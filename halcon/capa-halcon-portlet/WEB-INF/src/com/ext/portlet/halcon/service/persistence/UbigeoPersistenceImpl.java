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

import com.ext.portlet.halcon.NoSuchUbigeoException;
import com.ext.portlet.halcon.model.Ubigeo;
import com.ext.portlet.halcon.model.impl.UbigeoImpl;
import com.ext.portlet.halcon.model.impl.UbigeoModelImpl;

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
 * The persistence implementation for the ubigeo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see UbigeoPersistence
 * @see UbigeoUtil
 * @generated
 */
public class UbigeoPersistenceImpl extends BasePersistenceImpl<Ubigeo>
	implements UbigeoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UbigeoUtil} to access the ubigeo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UbigeoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
			UbigeoModelImpl.FINDER_CACHE_ENABLED, UbigeoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
			UbigeoModelImpl.FINDER_CACHE_ENABLED, UbigeoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
			UbigeoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ubigeo in the entity cache if it is enabled.
	 *
	 * @param ubigeo the ubigeo
	 */
	public void cacheResult(Ubigeo ubigeo) {
		EntityCacheUtil.putResult(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
			UbigeoImpl.class, ubigeo.getPrimaryKey(), ubigeo);

		ubigeo.resetOriginalValues();
	}

	/**
	 * Caches the ubigeos in the entity cache if it is enabled.
	 *
	 * @param ubigeos the ubigeos
	 */
	public void cacheResult(List<Ubigeo> ubigeos) {
		for (Ubigeo ubigeo : ubigeos) {
			if (EntityCacheUtil.getResult(
						UbigeoModelImpl.ENTITY_CACHE_ENABLED, UbigeoImpl.class,
						ubigeo.getPrimaryKey()) == null) {
				cacheResult(ubigeo);
			}
			else {
				ubigeo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ubigeos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UbigeoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UbigeoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ubigeo.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ubigeo ubigeo) {
		EntityCacheUtil.removeResult(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
			UbigeoImpl.class, ubigeo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Ubigeo> ubigeos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ubigeo ubigeo : ubigeos) {
			EntityCacheUtil.removeResult(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
				UbigeoImpl.class, ubigeo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ubigeo with the primary key. Does not add the ubigeo to the database.
	 *
	 * @param idUbigeo the primary key for the new ubigeo
	 * @return the new ubigeo
	 */
	public Ubigeo create(long idUbigeo) {
		Ubigeo ubigeo = new UbigeoImpl();

		ubigeo.setNew(true);
		ubigeo.setPrimaryKey(idUbigeo);

		return ubigeo;
	}

	/**
	 * Removes the ubigeo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idUbigeo the primary key of the ubigeo
	 * @return the ubigeo that was removed
	 * @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ubigeo remove(long idUbigeo)
		throws NoSuchUbigeoException, SystemException {
		return remove(Long.valueOf(idUbigeo));
	}

	/**
	 * Removes the ubigeo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ubigeo
	 * @return the ubigeo that was removed
	 * @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ubigeo remove(Serializable primaryKey)
		throws NoSuchUbigeoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Ubigeo ubigeo = (Ubigeo)session.get(UbigeoImpl.class, primaryKey);

			if (ubigeo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUbigeoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ubigeo);
		}
		catch (NoSuchUbigeoException nsee) {
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
	protected Ubigeo removeImpl(Ubigeo ubigeo) throws SystemException {
		ubigeo = toUnwrappedModel(ubigeo);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ubigeo);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ubigeo);

		return ubigeo;
	}

	@Override
	public Ubigeo updateImpl(com.ext.portlet.halcon.model.Ubigeo ubigeo,
		boolean merge) throws SystemException {
		ubigeo = toUnwrappedModel(ubigeo);

		boolean isNew = ubigeo.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ubigeo, merge);

			ubigeo.setNew(false);
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

		EntityCacheUtil.putResult(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
			UbigeoImpl.class, ubigeo.getPrimaryKey(), ubigeo);

		return ubigeo;
	}

	protected Ubigeo toUnwrappedModel(Ubigeo ubigeo) {
		if (ubigeo instanceof UbigeoImpl) {
			return ubigeo;
		}

		UbigeoImpl ubigeoImpl = new UbigeoImpl();

		ubigeoImpl.setNew(ubigeo.isNew());
		ubigeoImpl.setPrimaryKey(ubigeo.getPrimaryKey());

		ubigeoImpl.setIdUbigeo(ubigeo.getIdUbigeo());
		ubigeoImpl.setCodigo(ubigeo.getCodigo());
		ubigeoImpl.setNombre(ubigeo.getNombre());
		ubigeoImpl.setCodDepartamento(ubigeo.getCodDepartamento());
		ubigeoImpl.setCodProvincia(ubigeo.getCodProvincia());
		ubigeoImpl.setCodDistrito(ubigeo.getCodDistrito());

		return ubigeoImpl;
	}

	/**
	 * Returns the ubigeo with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ubigeo
	 * @return the ubigeo
	 * @throws com.liferay.portal.NoSuchModelException if a ubigeo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ubigeo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ubigeo with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchUbigeoException} if it could not be found.
	 *
	 * @param idUbigeo the primary key of the ubigeo
	 * @return the ubigeo
	 * @throws com.ext.portlet.halcon.NoSuchUbigeoException if a ubigeo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ubigeo findByPrimaryKey(long idUbigeo)
		throws NoSuchUbigeoException, SystemException {
		Ubigeo ubigeo = fetchByPrimaryKey(idUbigeo);

		if (ubigeo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idUbigeo);
			}

			throw new NoSuchUbigeoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idUbigeo);
		}

		return ubigeo;
	}

	/**
	 * Returns the ubigeo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ubigeo
	 * @return the ubigeo, or <code>null</code> if a ubigeo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ubigeo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ubigeo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idUbigeo the primary key of the ubigeo
	 * @return the ubigeo, or <code>null</code> if a ubigeo with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ubigeo fetchByPrimaryKey(long idUbigeo) throws SystemException {
		Ubigeo ubigeo = (Ubigeo)EntityCacheUtil.getResult(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
				UbigeoImpl.class, idUbigeo);

		if (ubigeo == _nullUbigeo) {
			return null;
		}

		if (ubigeo == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ubigeo = (Ubigeo)session.get(UbigeoImpl.class,
						Long.valueOf(idUbigeo));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ubigeo != null) {
					cacheResult(ubigeo);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(UbigeoModelImpl.ENTITY_CACHE_ENABLED,
						UbigeoImpl.class, idUbigeo, _nullUbigeo);
				}

				closeSession(session);
			}
		}

		return ubigeo;
	}

	/**
	 * Returns all the ubigeos.
	 *
	 * @return the ubigeos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ubigeo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ubigeos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ubigeos
	 * @param end the upper bound of the range of ubigeos (not inclusive)
	 * @return the range of ubigeos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ubigeo> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ubigeos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ubigeos
	 * @param end the upper bound of the range of ubigeos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ubigeos
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ubigeo> findAll(int start, int end,
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

		List<Ubigeo> list = (List<Ubigeo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UBIGEO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UBIGEO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Ubigeo>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Ubigeo>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the ubigeos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Ubigeo ubigeo : findAll()) {
			remove(ubigeo);
		}
	}

	/**
	 * Returns the number of ubigeos.
	 *
	 * @return the number of ubigeos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_UBIGEO);

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
	 * Initializes the ubigeo persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.Ubigeo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Ubigeo>> listenersList = new ArrayList<ModelListener<Ubigeo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Ubigeo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UbigeoImpl.class.getName());
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
	private static final String _SQL_SELECT_UBIGEO = "SELECT ubigeo FROM Ubigeo ubigeo";
	private static final String _SQL_COUNT_UBIGEO = "SELECT COUNT(ubigeo) FROM Ubigeo ubigeo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ubigeo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Ubigeo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UbigeoPersistenceImpl.class);
	private static Ubigeo _nullUbigeo = new UbigeoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Ubigeo> toCacheModel() {
				return _nullUbigeoCacheModel;
			}
		};

	private static CacheModel<Ubigeo> _nullUbigeoCacheModel = new CacheModel<Ubigeo>() {
			public Ubigeo toEntityModel() {
				return _nullUbigeo;
			}
		};
}