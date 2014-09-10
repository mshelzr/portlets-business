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

import com.ext.portlet.halcon.NoSuchOcurrenciaException;
import com.ext.portlet.halcon.model.Ocurrencia;
import com.ext.portlet.halcon.model.impl.OcurrenciaImpl;
import com.ext.portlet.halcon.model.impl.OcurrenciaModelImpl;

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
 * The persistence implementation for the ocurrencia service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see OcurrenciaPersistence
 * @see OcurrenciaUtil
 * @generated
 */
public class OcurrenciaPersistenceImpl extends BasePersistenceImpl<Ocurrencia>
	implements OcurrenciaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OcurrenciaUtil} to access the ocurrencia persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OcurrenciaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
			OcurrenciaModelImpl.FINDER_CACHE_ENABLED, OcurrenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
			OcurrenciaModelImpl.FINDER_CACHE_ENABLED, OcurrenciaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
			OcurrenciaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the ocurrencia in the entity cache if it is enabled.
	 *
	 * @param ocurrencia the ocurrencia
	 */
	public void cacheResult(Ocurrencia ocurrencia) {
		EntityCacheUtil.putResult(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
			OcurrenciaImpl.class, ocurrencia.getPrimaryKey(), ocurrencia);

		ocurrencia.resetOriginalValues();
	}

	/**
	 * Caches the ocurrencias in the entity cache if it is enabled.
	 *
	 * @param ocurrencias the ocurrencias
	 */
	public void cacheResult(List<Ocurrencia> ocurrencias) {
		for (Ocurrencia ocurrencia : ocurrencias) {
			if (EntityCacheUtil.getResult(
						OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
						OcurrenciaImpl.class, ocurrencia.getPrimaryKey()) == null) {
				cacheResult(ocurrencia);
			}
			else {
				ocurrencia.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ocurrencias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OcurrenciaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OcurrenciaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ocurrencia.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ocurrencia ocurrencia) {
		EntityCacheUtil.removeResult(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
			OcurrenciaImpl.class, ocurrencia.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Ocurrencia> ocurrencias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ocurrencia ocurrencia : ocurrencias) {
			EntityCacheUtil.removeResult(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
				OcurrenciaImpl.class, ocurrencia.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ocurrencia with the primary key. Does not add the ocurrencia to the database.
	 *
	 * @param idGestionPeticion the primary key for the new ocurrencia
	 * @return the new ocurrencia
	 */
	public Ocurrencia create(long idGestionPeticion) {
		Ocurrencia ocurrencia = new OcurrenciaImpl();

		ocurrencia.setNew(true);
		ocurrencia.setPrimaryKey(idGestionPeticion);

		return ocurrencia;
	}

	/**
	 * Removes the ocurrencia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idGestionPeticion the primary key of the ocurrencia
	 * @return the ocurrencia that was removed
	 * @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ocurrencia remove(long idGestionPeticion)
		throws NoSuchOcurrenciaException, SystemException {
		return remove(Long.valueOf(idGestionPeticion));
	}

	/**
	 * Removes the ocurrencia with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ocurrencia
	 * @return the ocurrencia that was removed
	 * @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ocurrencia remove(Serializable primaryKey)
		throws NoSuchOcurrenciaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Ocurrencia ocurrencia = (Ocurrencia)session.get(OcurrenciaImpl.class,
					primaryKey);

			if (ocurrencia == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOcurrenciaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ocurrencia);
		}
		catch (NoSuchOcurrenciaException nsee) {
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
	protected Ocurrencia removeImpl(Ocurrencia ocurrencia)
		throws SystemException {
		ocurrencia = toUnwrappedModel(ocurrencia);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, ocurrencia);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(ocurrencia);

		return ocurrencia;
	}

	@Override
	public Ocurrencia updateImpl(
		com.ext.portlet.halcon.model.Ocurrencia ocurrencia, boolean merge)
		throws SystemException {
		ocurrencia = toUnwrappedModel(ocurrencia);

		boolean isNew = ocurrencia.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, ocurrencia, merge);

			ocurrencia.setNew(false);
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

		EntityCacheUtil.putResult(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
			OcurrenciaImpl.class, ocurrencia.getPrimaryKey(), ocurrencia);

		return ocurrencia;
	}

	protected Ocurrencia toUnwrappedModel(Ocurrencia ocurrencia) {
		if (ocurrencia instanceof OcurrenciaImpl) {
			return ocurrencia;
		}

		OcurrenciaImpl ocurrenciaImpl = new OcurrenciaImpl();

		ocurrenciaImpl.setNew(ocurrencia.isNew());
		ocurrenciaImpl.setPrimaryKey(ocurrencia.getPrimaryKey());

		ocurrenciaImpl.setIdGestionPeticion(ocurrencia.getIdGestionPeticion());
		ocurrenciaImpl.setIp(ocurrencia.getIp());
		ocurrenciaImpl.setCodigoProducto(ocurrencia.getCodigoProducto());
		ocurrenciaImpl.setFecha(ocurrencia.getFecha());
		ocurrenciaImpl.setEstado(ocurrencia.getEstado());
		ocurrenciaImpl.setOcurrencia(ocurrencia.getOcurrencia());

		return ocurrenciaImpl;
	}

	/**
	 * Returns the ocurrencia with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ocurrencia
	 * @return the ocurrencia
	 * @throws com.liferay.portal.NoSuchModelException if a ocurrencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ocurrencia findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ocurrencia with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchOcurrenciaException} if it could not be found.
	 *
	 * @param idGestionPeticion the primary key of the ocurrencia
	 * @return the ocurrencia
	 * @throws com.ext.portlet.halcon.NoSuchOcurrenciaException if a ocurrencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ocurrencia findByPrimaryKey(long idGestionPeticion)
		throws NoSuchOcurrenciaException, SystemException {
		Ocurrencia ocurrencia = fetchByPrimaryKey(idGestionPeticion);

		if (ocurrencia == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idGestionPeticion);
			}

			throw new NoSuchOcurrenciaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idGestionPeticion);
		}

		return ocurrencia;
	}

	/**
	 * Returns the ocurrencia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ocurrencia
	 * @return the ocurrencia, or <code>null</code> if a ocurrencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ocurrencia fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the ocurrencia with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idGestionPeticion the primary key of the ocurrencia
	 * @return the ocurrencia, or <code>null</code> if a ocurrencia with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Ocurrencia fetchByPrimaryKey(long idGestionPeticion)
		throws SystemException {
		Ocurrencia ocurrencia = (Ocurrencia)EntityCacheUtil.getResult(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
				OcurrenciaImpl.class, idGestionPeticion);

		if (ocurrencia == _nullOcurrencia) {
			return null;
		}

		if (ocurrencia == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				ocurrencia = (Ocurrencia)session.get(OcurrenciaImpl.class,
						Long.valueOf(idGestionPeticion));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (ocurrencia != null) {
					cacheResult(ocurrencia);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(OcurrenciaModelImpl.ENTITY_CACHE_ENABLED,
						OcurrenciaImpl.class, idGestionPeticion, _nullOcurrencia);
				}

				closeSession(session);
			}
		}

		return ocurrencia;
	}

	/**
	 * Returns all the ocurrencias.
	 *
	 * @return the ocurrencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ocurrencia> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ocurrencias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ocurrencias
	 * @param end the upper bound of the range of ocurrencias (not inclusive)
	 * @return the range of ocurrencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ocurrencia> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ocurrencias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of ocurrencias
	 * @param end the upper bound of the range of ocurrencias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ocurrencias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Ocurrencia> findAll(int start, int end,
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

		List<Ocurrencia> list = (List<Ocurrencia>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_OCURRENCIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_OCURRENCIA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Ocurrencia>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Ocurrencia>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ocurrencias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Ocurrencia ocurrencia : findAll()) {
			remove(ocurrencia);
		}
	}

	/**
	 * Returns the number of ocurrencias.
	 *
	 * @return the number of ocurrencias
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_OCURRENCIA);

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
	 * Initializes the ocurrencia persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.Ocurrencia")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Ocurrencia>> listenersList = new ArrayList<ModelListener<Ocurrencia>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Ocurrencia>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(OcurrenciaImpl.class.getName());
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
	private static final String _SQL_SELECT_OCURRENCIA = "SELECT ocurrencia FROM Ocurrencia ocurrencia";
	private static final String _SQL_COUNT_OCURRENCIA = "SELECT COUNT(ocurrencia) FROM Ocurrencia ocurrencia";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ocurrencia.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Ocurrencia exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OcurrenciaPersistenceImpl.class);
	private static Ocurrencia _nullOcurrencia = new OcurrenciaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Ocurrencia> toCacheModel() {
				return _nullOcurrenciaCacheModel;
			}
		};

	private static CacheModel<Ocurrencia> _nullOcurrenciaCacheModel = new CacheModel<Ocurrencia>() {
			public Ocurrencia toEntityModel() {
				return _nullOcurrencia;
			}
		};
}