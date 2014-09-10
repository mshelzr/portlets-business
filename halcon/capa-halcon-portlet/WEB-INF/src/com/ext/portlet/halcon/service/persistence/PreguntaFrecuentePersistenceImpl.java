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

import com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException;
import com.ext.portlet.halcon.model.PreguntaFrecuente;
import com.ext.portlet.halcon.model.impl.PreguntaFrecuenteImpl;
import com.ext.portlet.halcon.model.impl.PreguntaFrecuenteModelImpl;

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
 * The persistence implementation for the pregunta frecuente service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see PreguntaFrecuentePersistence
 * @see PreguntaFrecuenteUtil
 * @generated
 */
public class PreguntaFrecuentePersistenceImpl extends BasePersistenceImpl<PreguntaFrecuente>
	implements PreguntaFrecuentePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PreguntaFrecuenteUtil} to access the pregunta frecuente persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PreguntaFrecuenteImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
			PreguntaFrecuenteModelImpl.FINDER_CACHE_ENABLED,
			PreguntaFrecuenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
			PreguntaFrecuenteModelImpl.FINDER_CACHE_ENABLED,
			PreguntaFrecuenteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
			PreguntaFrecuenteModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the pregunta frecuente in the entity cache if it is enabled.
	 *
	 * @param preguntaFrecuente the pregunta frecuente
	 */
	public void cacheResult(PreguntaFrecuente preguntaFrecuente) {
		EntityCacheUtil.putResult(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
			PreguntaFrecuenteImpl.class, preguntaFrecuente.getPrimaryKey(),
			preguntaFrecuente);

		preguntaFrecuente.resetOriginalValues();
	}

	/**
	 * Caches the pregunta frecuentes in the entity cache if it is enabled.
	 *
	 * @param preguntaFrecuentes the pregunta frecuentes
	 */
	public void cacheResult(List<PreguntaFrecuente> preguntaFrecuentes) {
		for (PreguntaFrecuente preguntaFrecuente : preguntaFrecuentes) {
			if (EntityCacheUtil.getResult(
						PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
						PreguntaFrecuenteImpl.class,
						preguntaFrecuente.getPrimaryKey()) == null) {
				cacheResult(preguntaFrecuente);
			}
			else {
				preguntaFrecuente.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all pregunta frecuentes.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PreguntaFrecuenteImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PreguntaFrecuenteImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pregunta frecuente.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PreguntaFrecuente preguntaFrecuente) {
		EntityCacheUtil.removeResult(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
			PreguntaFrecuenteImpl.class, preguntaFrecuente.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PreguntaFrecuente> preguntaFrecuentes) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PreguntaFrecuente preguntaFrecuente : preguntaFrecuentes) {
			EntityCacheUtil.removeResult(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
				PreguntaFrecuenteImpl.class, preguntaFrecuente.getPrimaryKey());
		}
	}

	/**
	 * Creates a new pregunta frecuente with the primary key. Does not add the pregunta frecuente to the database.
	 *
	 * @param idPreguntaFrecuente the primary key for the new pregunta frecuente
	 * @return the new pregunta frecuente
	 */
	public PreguntaFrecuente create(int idPreguntaFrecuente) {
		PreguntaFrecuente preguntaFrecuente = new PreguntaFrecuenteImpl();

		preguntaFrecuente.setNew(true);
		preguntaFrecuente.setPrimaryKey(idPreguntaFrecuente);

		return preguntaFrecuente;
	}

	/**
	 * Removes the pregunta frecuente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idPreguntaFrecuente the primary key of the pregunta frecuente
	 * @return the pregunta frecuente that was removed
	 * @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreguntaFrecuente remove(int idPreguntaFrecuente)
		throws NoSuchPreguntaFrecuenteException, SystemException {
		return remove(Integer.valueOf(idPreguntaFrecuente));
	}

	/**
	 * Removes the pregunta frecuente with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pregunta frecuente
	 * @return the pregunta frecuente that was removed
	 * @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreguntaFrecuente remove(Serializable primaryKey)
		throws NoSuchPreguntaFrecuenteException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PreguntaFrecuente preguntaFrecuente = (PreguntaFrecuente)session.get(PreguntaFrecuenteImpl.class,
					primaryKey);

			if (preguntaFrecuente == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPreguntaFrecuenteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(preguntaFrecuente);
		}
		catch (NoSuchPreguntaFrecuenteException nsee) {
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
	protected PreguntaFrecuente removeImpl(PreguntaFrecuente preguntaFrecuente)
		throws SystemException {
		preguntaFrecuente = toUnwrappedModel(preguntaFrecuente);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, preguntaFrecuente);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(preguntaFrecuente);

		return preguntaFrecuente;
	}

	@Override
	public PreguntaFrecuente updateImpl(
		com.ext.portlet.halcon.model.PreguntaFrecuente preguntaFrecuente,
		boolean merge) throws SystemException {
		preguntaFrecuente = toUnwrappedModel(preguntaFrecuente);

		boolean isNew = preguntaFrecuente.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, preguntaFrecuente, merge);

			preguntaFrecuente.setNew(false);
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

		EntityCacheUtil.putResult(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
			PreguntaFrecuenteImpl.class, preguntaFrecuente.getPrimaryKey(),
			preguntaFrecuente);

		return preguntaFrecuente;
	}

	protected PreguntaFrecuente toUnwrappedModel(
		PreguntaFrecuente preguntaFrecuente) {
		if (preguntaFrecuente instanceof PreguntaFrecuenteImpl) {
			return preguntaFrecuente;
		}

		PreguntaFrecuenteImpl preguntaFrecuenteImpl = new PreguntaFrecuenteImpl();

		preguntaFrecuenteImpl.setNew(preguntaFrecuente.isNew());
		preguntaFrecuenteImpl.setPrimaryKey(preguntaFrecuente.getPrimaryKey());

		preguntaFrecuenteImpl.setIdPreguntaFrecuente(preguntaFrecuente.getIdPreguntaFrecuente());
		preguntaFrecuenteImpl.setIdCategoriaSubCat(preguntaFrecuente.getIdCategoriaSubCat());
		preguntaFrecuenteImpl.setEnunciado(preguntaFrecuente.getEnunciado());
		preguntaFrecuenteImpl.setRespuesta(preguntaFrecuente.getRespuesta());
		preguntaFrecuenteImpl.setEstado(preguntaFrecuente.getEstado());
		preguntaFrecuenteImpl.setEtiqueta(preguntaFrecuente.getEtiqueta());

		return preguntaFrecuenteImpl;
	}

	/**
	 * Returns the pregunta frecuente with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the pregunta frecuente
	 * @return the pregunta frecuente
	 * @throws com.liferay.portal.NoSuchModelException if a pregunta frecuente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreguntaFrecuente findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the pregunta frecuente with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException} if it could not be found.
	 *
	 * @param idPreguntaFrecuente the primary key of the pregunta frecuente
	 * @return the pregunta frecuente
	 * @throws com.ext.portlet.halcon.NoSuchPreguntaFrecuenteException if a pregunta frecuente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreguntaFrecuente findByPrimaryKey(int idPreguntaFrecuente)
		throws NoSuchPreguntaFrecuenteException, SystemException {
		PreguntaFrecuente preguntaFrecuente = fetchByPrimaryKey(idPreguntaFrecuente);

		if (preguntaFrecuente == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idPreguntaFrecuente);
			}

			throw new NoSuchPreguntaFrecuenteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idPreguntaFrecuente);
		}

		return preguntaFrecuente;
	}

	/**
	 * Returns the pregunta frecuente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pregunta frecuente
	 * @return the pregunta frecuente, or <code>null</code> if a pregunta frecuente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PreguntaFrecuente fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the pregunta frecuente with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idPreguntaFrecuente the primary key of the pregunta frecuente
	 * @return the pregunta frecuente, or <code>null</code> if a pregunta frecuente with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public PreguntaFrecuente fetchByPrimaryKey(int idPreguntaFrecuente)
		throws SystemException {
		PreguntaFrecuente preguntaFrecuente = (PreguntaFrecuente)EntityCacheUtil.getResult(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
				PreguntaFrecuenteImpl.class, idPreguntaFrecuente);

		if (preguntaFrecuente == _nullPreguntaFrecuente) {
			return null;
		}

		if (preguntaFrecuente == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				preguntaFrecuente = (PreguntaFrecuente)session.get(PreguntaFrecuenteImpl.class,
						Integer.valueOf(idPreguntaFrecuente));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (preguntaFrecuente != null) {
					cacheResult(preguntaFrecuente);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PreguntaFrecuenteModelImpl.ENTITY_CACHE_ENABLED,
						PreguntaFrecuenteImpl.class, idPreguntaFrecuente,
						_nullPreguntaFrecuente);
				}

				closeSession(session);
			}
		}

		return preguntaFrecuente;
	}

	/**
	 * Returns all the pregunta frecuentes.
	 *
	 * @return the pregunta frecuentes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreguntaFrecuente> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pregunta frecuentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of pregunta frecuentes
	 * @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	 * @return the range of pregunta frecuentes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreguntaFrecuente> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pregunta frecuentes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of pregunta frecuentes
	 * @param end the upper bound of the range of pregunta frecuentes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pregunta frecuentes
	 * @throws SystemException if a system exception occurred
	 */
	public List<PreguntaFrecuente> findAll(int start, int end,
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

		List<PreguntaFrecuente> list = (List<PreguntaFrecuente>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PREGUNTAFRECUENTE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PREGUNTAFRECUENTE;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<PreguntaFrecuente>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<PreguntaFrecuente>)QueryUtil.list(q,
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
	 * Removes all the pregunta frecuentes from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (PreguntaFrecuente preguntaFrecuente : findAll()) {
			remove(preguntaFrecuente);
		}
	}

	/**
	 * Returns the number of pregunta frecuentes.
	 *
	 * @return the number of pregunta frecuentes
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PREGUNTAFRECUENTE);

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
	 * Initializes the pregunta frecuente persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.PreguntaFrecuente")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PreguntaFrecuente>> listenersList = new ArrayList<ModelListener<PreguntaFrecuente>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PreguntaFrecuente>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PreguntaFrecuenteImpl.class.getName());
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
	private static final String _SQL_SELECT_PREGUNTAFRECUENTE = "SELECT preguntaFrecuente FROM PreguntaFrecuente preguntaFrecuente";
	private static final String _SQL_COUNT_PREGUNTAFRECUENTE = "SELECT COUNT(preguntaFrecuente) FROM PreguntaFrecuente preguntaFrecuente";
	private static final String _ORDER_BY_ENTITY_ALIAS = "preguntaFrecuente.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PreguntaFrecuente exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PreguntaFrecuentePersistenceImpl.class);
	private static PreguntaFrecuente _nullPreguntaFrecuente = new PreguntaFrecuenteImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PreguntaFrecuente> toCacheModel() {
				return _nullPreguntaFrecuenteCacheModel;
			}
		};

	private static CacheModel<PreguntaFrecuente> _nullPreguntaFrecuenteCacheModel =
		new CacheModel<PreguntaFrecuente>() {
			public PreguntaFrecuente toEntityModel() {
				return _nullPreguntaFrecuente;
			}
		};
}