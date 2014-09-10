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

import com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException;
import com.ext.portlet.halcon.model.AuditoriaSimulador;
import com.ext.portlet.halcon.model.impl.AuditoriaSimuladorImpl;
import com.ext.portlet.halcon.model.impl.AuditoriaSimuladorModelImpl;

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
 * The persistence implementation for the auditoria simulador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see AuditoriaSimuladorPersistence
 * @see AuditoriaSimuladorUtil
 * @generated
 */
public class AuditoriaSimuladorPersistenceImpl extends BasePersistenceImpl<AuditoriaSimulador>
	implements AuditoriaSimuladorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AuditoriaSimuladorUtil} to access the auditoria simulador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AuditoriaSimuladorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaSimuladorModelImpl.FINDER_CACHE_ENABLED,
			AuditoriaSimuladorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaSimuladorModelImpl.FINDER_CACHE_ENABLED,
			AuditoriaSimuladorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaSimuladorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the auditoria simulador in the entity cache if it is enabled.
	 *
	 * @param auditoriaSimulador the auditoria simulador
	 */
	public void cacheResult(AuditoriaSimulador auditoriaSimulador) {
		EntityCacheUtil.putResult(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaSimuladorImpl.class, auditoriaSimulador.getPrimaryKey(),
			auditoriaSimulador);

		auditoriaSimulador.resetOriginalValues();
	}

	/**
	 * Caches the auditoria simuladors in the entity cache if it is enabled.
	 *
	 * @param auditoriaSimuladors the auditoria simuladors
	 */
	public void cacheResult(List<AuditoriaSimulador> auditoriaSimuladors) {
		for (AuditoriaSimulador auditoriaSimulador : auditoriaSimuladors) {
			if (EntityCacheUtil.getResult(
						AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
						AuditoriaSimuladorImpl.class,
						auditoriaSimulador.getPrimaryKey()) == null) {
				cacheResult(auditoriaSimulador);
			}
			else {
				auditoriaSimulador.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all auditoria simuladors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(AuditoriaSimuladorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(AuditoriaSimuladorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the auditoria simulador.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AuditoriaSimulador auditoriaSimulador) {
		EntityCacheUtil.removeResult(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaSimuladorImpl.class, auditoriaSimulador.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AuditoriaSimulador> auditoriaSimuladors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AuditoriaSimulador auditoriaSimulador : auditoriaSimuladors) {
			EntityCacheUtil.removeResult(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
				AuditoriaSimuladorImpl.class, auditoriaSimulador.getPrimaryKey());
		}
	}

	/**
	 * Creates a new auditoria simulador with the primary key. Does not add the auditoria simulador to the database.
	 *
	 * @param idAuditoriaSim the primary key for the new auditoria simulador
	 * @return the new auditoria simulador
	 */
	public AuditoriaSimulador create(long idAuditoriaSim) {
		AuditoriaSimulador auditoriaSimulador = new AuditoriaSimuladorImpl();

		auditoriaSimulador.setNew(true);
		auditoriaSimulador.setPrimaryKey(idAuditoriaSim);

		return auditoriaSimulador;
	}

	/**
	 * Removes the auditoria simulador with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idAuditoriaSim the primary key of the auditoria simulador
	 * @return the auditoria simulador that was removed
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException if a auditoria simulador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaSimulador remove(long idAuditoriaSim)
		throws NoSuchAuditoriaSimuladorException, SystemException {
		return remove(Long.valueOf(idAuditoriaSim));
	}

	/**
	 * Removes the auditoria simulador with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the auditoria simulador
	 * @return the auditoria simulador that was removed
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException if a auditoria simulador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaSimulador remove(Serializable primaryKey)
		throws NoSuchAuditoriaSimuladorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			AuditoriaSimulador auditoriaSimulador = (AuditoriaSimulador)session.get(AuditoriaSimuladorImpl.class,
					primaryKey);

			if (auditoriaSimulador == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAuditoriaSimuladorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(auditoriaSimulador);
		}
		catch (NoSuchAuditoriaSimuladorException nsee) {
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
	protected AuditoriaSimulador removeImpl(
		AuditoriaSimulador auditoriaSimulador) throws SystemException {
		auditoriaSimulador = toUnwrappedModel(auditoriaSimulador);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, auditoriaSimulador);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(auditoriaSimulador);

		return auditoriaSimulador;
	}

	@Override
	public AuditoriaSimulador updateImpl(
		com.ext.portlet.halcon.model.AuditoriaSimulador auditoriaSimulador,
		boolean merge) throws SystemException {
		auditoriaSimulador = toUnwrappedModel(auditoriaSimulador);

		boolean isNew = auditoriaSimulador.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, auditoriaSimulador, merge);

			auditoriaSimulador.setNew(false);
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

		EntityCacheUtil.putResult(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
			AuditoriaSimuladorImpl.class, auditoriaSimulador.getPrimaryKey(),
			auditoriaSimulador);

		return auditoriaSimulador;
	}

	protected AuditoriaSimulador toUnwrappedModel(
		AuditoriaSimulador auditoriaSimulador) {
		if (auditoriaSimulador instanceof AuditoriaSimuladorImpl) {
			return auditoriaSimulador;
		}

		AuditoriaSimuladorImpl auditoriaSimuladorImpl = new AuditoriaSimuladorImpl();

		auditoriaSimuladorImpl.setNew(auditoriaSimulador.isNew());
		auditoriaSimuladorImpl.setPrimaryKey(auditoriaSimulador.getPrimaryKey());

		auditoriaSimuladorImpl.setIdAuditoriaSim(auditoriaSimulador.getIdAuditoriaSim());
		auditoriaSimuladorImpl.setTipoSimulador(auditoriaSimulador.getTipoSimulador());
		auditoriaSimuladorImpl.setIdTransaccion(auditoriaSimulador.getIdTransaccion());
		auditoriaSimuladorImpl.setTipoDocumento(auditoriaSimulador.getTipoDocumento());
		auditoriaSimuladorImpl.setNumDocumento(auditoriaSimulador.getNumDocumento());
		auditoriaSimuladorImpl.setMoneda(auditoriaSimulador.getMoneda());
		auditoriaSimuladorImpl.setTipoProducto(auditoriaSimulador.getTipoProducto());
		auditoriaSimuladorImpl.setInvirtioFondMut(auditoriaSimulador.getInvirtioFondMut());
		auditoriaSimuladorImpl.setNivelConocimFondMut(auditoriaSimulador.getNivelConocimFondMut());
		auditoriaSimuladorImpl.setReaccionVarMerc(auditoriaSimulador.getReaccionVarMerc());
		auditoriaSimuladorImpl.setValorBien(auditoriaSimulador.getValorBien());
		auditoriaSimuladorImpl.setMontoPrestamo(auditoriaSimulador.getMontoPrestamo());
		auditoriaSimuladorImpl.setCuotaInicial(auditoriaSimulador.getCuotaInicial());
		auditoriaSimuladorImpl.setPeriodoInvers(auditoriaSimulador.getPeriodoInvers());
		auditoriaSimuladorImpl.setTasa(auditoriaSimulador.getTasa());
		auditoriaSimuladorImpl.setSegDesgrav(auditoriaSimulador.getSegDesgrav());
		auditoriaSimuladorImpl.setTipoCuota(auditoriaSimulador.getTipoCuota());
		auditoriaSimuladorImpl.setIP(auditoriaSimulador.getIP());
		auditoriaSimuladorImpl.setFechaHora(auditoriaSimulador.getFechaHora());
		auditoriaSimuladorImpl.setUTMSource(auditoriaSimulador.getUTMSource());
		auditoriaSimuladorImpl.setUTMMedium(auditoriaSimulador.getUTMMedium());
		auditoriaSimuladorImpl.setUTMCampaing(auditoriaSimulador.getUTMCampaing());
		auditoriaSimuladorImpl.setUTMContent(auditoriaSimulador.getUTMContent());

		return auditoriaSimuladorImpl;
	}

	/**
	 * Returns the auditoria simulador with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria simulador
	 * @return the auditoria simulador
	 * @throws com.liferay.portal.NoSuchModelException if a auditoria simulador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaSimulador findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria simulador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException} if it could not be found.
	 *
	 * @param idAuditoriaSim the primary key of the auditoria simulador
	 * @return the auditoria simulador
	 * @throws com.ext.portlet.halcon.NoSuchAuditoriaSimuladorException if a auditoria simulador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaSimulador findByPrimaryKey(long idAuditoriaSim)
		throws NoSuchAuditoriaSimuladorException, SystemException {
		AuditoriaSimulador auditoriaSimulador = fetchByPrimaryKey(idAuditoriaSim);

		if (auditoriaSimulador == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idAuditoriaSim);
			}

			throw new NoSuchAuditoriaSimuladorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idAuditoriaSim);
		}

		return auditoriaSimulador;
	}

	/**
	 * Returns the auditoria simulador with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the auditoria simulador
	 * @return the auditoria simulador, or <code>null</code> if a auditoria simulador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public AuditoriaSimulador fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the auditoria simulador with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idAuditoriaSim the primary key of the auditoria simulador
	 * @return the auditoria simulador, or <code>null</code> if a auditoria simulador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public AuditoriaSimulador fetchByPrimaryKey(long idAuditoriaSim)
		throws SystemException {
		AuditoriaSimulador auditoriaSimulador = (AuditoriaSimulador)EntityCacheUtil.getResult(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
				AuditoriaSimuladorImpl.class, idAuditoriaSim);

		if (auditoriaSimulador == _nullAuditoriaSimulador) {
			return null;
		}

		if (auditoriaSimulador == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				auditoriaSimulador = (AuditoriaSimulador)session.get(AuditoriaSimuladorImpl.class,
						Long.valueOf(idAuditoriaSim));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (auditoriaSimulador != null) {
					cacheResult(auditoriaSimulador);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(AuditoriaSimuladorModelImpl.ENTITY_CACHE_ENABLED,
						AuditoriaSimuladorImpl.class, idAuditoriaSim,
						_nullAuditoriaSimulador);
				}

				closeSession(session);
			}
		}

		return auditoriaSimulador;
	}

	/**
	 * Returns all the auditoria simuladors.
	 *
	 * @return the auditoria simuladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaSimulador> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the auditoria simuladors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria simuladors
	 * @param end the upper bound of the range of auditoria simuladors (not inclusive)
	 * @return the range of auditoria simuladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaSimulador> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the auditoria simuladors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of auditoria simuladors
	 * @param end the upper bound of the range of auditoria simuladors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auditoria simuladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<AuditoriaSimulador> findAll(int start, int end,
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

		List<AuditoriaSimulador> list = (List<AuditoriaSimulador>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_AUDITORIASIMULADOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_AUDITORIASIMULADOR;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<AuditoriaSimulador>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<AuditoriaSimulador>)QueryUtil.list(q,
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
	 * Removes all the auditoria simuladors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (AuditoriaSimulador auditoriaSimulador : findAll()) {
			remove(auditoriaSimulador);
		}
	}

	/**
	 * Returns the number of auditoria simuladors.
	 *
	 * @return the number of auditoria simuladors
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_AUDITORIASIMULADOR);

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
	 * Initializes the auditoria simulador persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.AuditoriaSimulador")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<AuditoriaSimulador>> listenersList = new ArrayList<ModelListener<AuditoriaSimulador>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<AuditoriaSimulador>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(AuditoriaSimuladorImpl.class.getName());
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
	private static final String _SQL_SELECT_AUDITORIASIMULADOR = "SELECT auditoriaSimulador FROM AuditoriaSimulador auditoriaSimulador";
	private static final String _SQL_COUNT_AUDITORIASIMULADOR = "SELECT COUNT(auditoriaSimulador) FROM AuditoriaSimulador auditoriaSimulador";
	private static final String _ORDER_BY_ENTITY_ALIAS = "auditoriaSimulador.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AuditoriaSimulador exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(AuditoriaSimuladorPersistenceImpl.class);
	private static AuditoriaSimulador _nullAuditoriaSimulador = new AuditoriaSimuladorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<AuditoriaSimulador> toCacheModel() {
				return _nullAuditoriaSimuladorCacheModel;
			}
		};

	private static CacheModel<AuditoriaSimulador> _nullAuditoriaSimuladorCacheModel =
		new CacheModel<AuditoriaSimulador>() {
			public AuditoriaSimulador toEntityModel() {
				return _nullAuditoriaSimulador;
			}
		};
}