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

import com.ext.portlet.halcon.NoSuchCargaSocioRemesaException;
import com.ext.portlet.halcon.model.CargaSocioRemesa;
import com.ext.portlet.halcon.model.impl.CargaSocioRemesaImpl;
import com.ext.portlet.halcon.model.impl.CargaSocioRemesaModelImpl;

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
 * The persistence implementation for the carga socio remesa service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaSocioRemesaPersistence
 * @see CargaSocioRemesaUtil
 * @generated
 */
public class CargaSocioRemesaPersistenceImpl extends BasePersistenceImpl<CargaSocioRemesa>
	implements CargaSocioRemesaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CargaSocioRemesaUtil} to access the carga socio remesa persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CargaSocioRemesaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
			CargaSocioRemesaModelImpl.FINDER_CACHE_ENABLED,
			CargaSocioRemesaImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
			CargaSocioRemesaModelImpl.FINDER_CACHE_ENABLED,
			CargaSocioRemesaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
			CargaSocioRemesaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the carga socio remesa in the entity cache if it is enabled.
	 *
	 * @param cargaSocioRemesa the carga socio remesa
	 */
	public void cacheResult(CargaSocioRemesa cargaSocioRemesa) {
		EntityCacheUtil.putResult(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
			CargaSocioRemesaImpl.class, cargaSocioRemesa.getPrimaryKey(),
			cargaSocioRemesa);

		cargaSocioRemesa.resetOriginalValues();
	}

	/**
	 * Caches the carga socio remesas in the entity cache if it is enabled.
	 *
	 * @param cargaSocioRemesas the carga socio remesas
	 */
	public void cacheResult(List<CargaSocioRemesa> cargaSocioRemesas) {
		for (CargaSocioRemesa cargaSocioRemesa : cargaSocioRemesas) {
			if (EntityCacheUtil.getResult(
						CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
						CargaSocioRemesaImpl.class,
						cargaSocioRemesa.getPrimaryKey()) == null) {
				cacheResult(cargaSocioRemesa);
			}
			else {
				cargaSocioRemesa.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all carga socio remesas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CargaSocioRemesaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CargaSocioRemesaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the carga socio remesa.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CargaSocioRemesa cargaSocioRemesa) {
		EntityCacheUtil.removeResult(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
			CargaSocioRemesaImpl.class, cargaSocioRemesa.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CargaSocioRemesa> cargaSocioRemesas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CargaSocioRemesa cargaSocioRemesa : cargaSocioRemesas) {
			EntityCacheUtil.removeResult(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
				CargaSocioRemesaImpl.class, cargaSocioRemesa.getPrimaryKey());
		}
	}

	/**
	 * Creates a new carga socio remesa with the primary key. Does not add the carga socio remesa to the database.
	 *
	 * @param idSocioRemesa the primary key for the new carga socio remesa
	 * @return the new carga socio remesa
	 */
	public CargaSocioRemesa create(long idSocioRemesa) {
		CargaSocioRemesa cargaSocioRemesa = new CargaSocioRemesaImpl();

		cargaSocioRemesa.setNew(true);
		cargaSocioRemesa.setPrimaryKey(idSocioRemesa);

		return cargaSocioRemesa;
	}

	/**
	 * Removes the carga socio remesa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idSocioRemesa the primary key of the carga socio remesa
	 * @return the carga socio remesa that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException if a carga socio remesa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaSocioRemesa remove(long idSocioRemesa)
		throws NoSuchCargaSocioRemesaException, SystemException {
		return remove(Long.valueOf(idSocioRemesa));
	}

	/**
	 * Removes the carga socio remesa with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the carga socio remesa
	 * @return the carga socio remesa that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException if a carga socio remesa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaSocioRemesa remove(Serializable primaryKey)
		throws NoSuchCargaSocioRemesaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CargaSocioRemesa cargaSocioRemesa = (CargaSocioRemesa)session.get(CargaSocioRemesaImpl.class,
					primaryKey);

			if (cargaSocioRemesa == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCargaSocioRemesaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cargaSocioRemesa);
		}
		catch (NoSuchCargaSocioRemesaException nsee) {
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
	protected CargaSocioRemesa removeImpl(CargaSocioRemesa cargaSocioRemesa)
		throws SystemException {
		cargaSocioRemesa = toUnwrappedModel(cargaSocioRemesa);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cargaSocioRemesa);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cargaSocioRemesa);

		return cargaSocioRemesa;
	}

	@Override
	public CargaSocioRemesa updateImpl(
		com.ext.portlet.halcon.model.CargaSocioRemesa cargaSocioRemesa,
		boolean merge) throws SystemException {
		cargaSocioRemesa = toUnwrappedModel(cargaSocioRemesa);

		boolean isNew = cargaSocioRemesa.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cargaSocioRemesa, merge);

			cargaSocioRemesa.setNew(false);
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

		EntityCacheUtil.putResult(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
			CargaSocioRemesaImpl.class, cargaSocioRemesa.getPrimaryKey(),
			cargaSocioRemesa);

		return cargaSocioRemesa;
	}

	protected CargaSocioRemesa toUnwrappedModel(
		CargaSocioRemesa cargaSocioRemesa) {
		if (cargaSocioRemesa instanceof CargaSocioRemesaImpl) {
			return cargaSocioRemesa;
		}

		CargaSocioRemesaImpl cargaSocioRemesaImpl = new CargaSocioRemesaImpl();

		cargaSocioRemesaImpl.setNew(cargaSocioRemesa.isNew());
		cargaSocioRemesaImpl.setPrimaryKey(cargaSocioRemesa.getPrimaryKey());

		cargaSocioRemesaImpl.setIdSocioRemesa(cargaSocioRemesa.getIdSocioRemesa());
		cargaSocioRemesaImpl.setEmpresa(cargaSocioRemesa.getEmpresa());
		cargaSocioRemesaImpl.setPaisCobertura(cargaSocioRemesa.getPaisCobertura());
		cargaSocioRemesaImpl.setPaginaWeb(cargaSocioRemesa.getPaginaWeb());
		cargaSocioRemesaImpl.setTelefono(cargaSocioRemesa.getTelefono());

		return cargaSocioRemesaImpl;
	}

	/**
	 * Returns the carga socio remesa with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the carga socio remesa
	 * @return the carga socio remesa
	 * @throws com.liferay.portal.NoSuchModelException if a carga socio remesa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaSocioRemesa findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the carga socio remesa with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaSocioRemesaException} if it could not be found.
	 *
	 * @param idSocioRemesa the primary key of the carga socio remesa
	 * @return the carga socio remesa
	 * @throws com.ext.portlet.halcon.NoSuchCargaSocioRemesaException if a carga socio remesa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaSocioRemesa findByPrimaryKey(long idSocioRemesa)
		throws NoSuchCargaSocioRemesaException, SystemException {
		CargaSocioRemesa cargaSocioRemesa = fetchByPrimaryKey(idSocioRemesa);

		if (cargaSocioRemesa == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idSocioRemesa);
			}

			throw new NoSuchCargaSocioRemesaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idSocioRemesa);
		}

		return cargaSocioRemesa;
	}

	/**
	 * Returns the carga socio remesa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the carga socio remesa
	 * @return the carga socio remesa, or <code>null</code> if a carga socio remesa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaSocioRemesa fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the carga socio remesa with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idSocioRemesa the primary key of the carga socio remesa
	 * @return the carga socio remesa, or <code>null</code> if a carga socio remesa with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaSocioRemesa fetchByPrimaryKey(long idSocioRemesa)
		throws SystemException {
		CargaSocioRemesa cargaSocioRemesa = (CargaSocioRemesa)EntityCacheUtil.getResult(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
				CargaSocioRemesaImpl.class, idSocioRemesa);

		if (cargaSocioRemesa == _nullCargaSocioRemesa) {
			return null;
		}

		if (cargaSocioRemesa == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cargaSocioRemesa = (CargaSocioRemesa)session.get(CargaSocioRemesaImpl.class,
						Long.valueOf(idSocioRemesa));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cargaSocioRemesa != null) {
					cacheResult(cargaSocioRemesa);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CargaSocioRemesaModelImpl.ENTITY_CACHE_ENABLED,
						CargaSocioRemesaImpl.class, idSocioRemesa,
						_nullCargaSocioRemesa);
				}

				closeSession(session);
			}
		}

		return cargaSocioRemesa;
	}

	/**
	 * Returns all the carga socio remesas.
	 *
	 * @return the carga socio remesas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaSocioRemesa> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carga socio remesas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of carga socio remesas
	 * @param end the upper bound of the range of carga socio remesas (not inclusive)
	 * @return the range of carga socio remesas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaSocioRemesa> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the carga socio remesas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of carga socio remesas
	 * @param end the upper bound of the range of carga socio remesas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of carga socio remesas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaSocioRemesa> findAll(int start, int end,
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

		List<CargaSocioRemesa> list = (List<CargaSocioRemesa>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARGASOCIOREMESA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARGASOCIOREMESA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CargaSocioRemesa>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CargaSocioRemesa>)QueryUtil.list(q,
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
	 * Removes all the carga socio remesas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CargaSocioRemesa cargaSocioRemesa : findAll()) {
			remove(cargaSocioRemesa);
		}
	}

	/**
	 * Returns the number of carga socio remesas.
	 *
	 * @return the number of carga socio remesas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CARGASOCIOREMESA);

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
	 * Initializes the carga socio remesa persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.CargaSocioRemesa")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CargaSocioRemesa>> listenersList = new ArrayList<ModelListener<CargaSocioRemesa>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CargaSocioRemesa>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CargaSocioRemesaImpl.class.getName());
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
	private static final String _SQL_SELECT_CARGASOCIOREMESA = "SELECT cargaSocioRemesa FROM CargaSocioRemesa cargaSocioRemesa";
	private static final String _SQL_COUNT_CARGASOCIOREMESA = "SELECT COUNT(cargaSocioRemesa) FROM CargaSocioRemesa cargaSocioRemesa";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cargaSocioRemesa.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CargaSocioRemesa exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CargaSocioRemesaPersistenceImpl.class);
	private static CargaSocioRemesa _nullCargaSocioRemesa = new CargaSocioRemesaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CargaSocioRemesa> toCacheModel() {
				return _nullCargaSocioRemesaCacheModel;
			}
		};

	private static CacheModel<CargaSocioRemesa> _nullCargaSocioRemesaCacheModel = new CacheModel<CargaSocioRemesa>() {
			public CargaSocioRemesa toEntityModel() {
				return _nullCargaSocioRemesa;
			}
		};
}