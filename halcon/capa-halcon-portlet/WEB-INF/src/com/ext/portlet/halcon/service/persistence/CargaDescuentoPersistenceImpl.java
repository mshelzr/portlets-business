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

import com.ext.portlet.halcon.NoSuchCargaDescuentoException;
import com.ext.portlet.halcon.model.CargaDescuento;
import com.ext.portlet.halcon.model.impl.CargaDescuentoImpl;
import com.ext.portlet.halcon.model.impl.CargaDescuentoModelImpl;

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
 * The persistence implementation for the carga descuento service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaDescuentoPersistence
 * @see CargaDescuentoUtil
 * @generated
 */
public class CargaDescuentoPersistenceImpl extends BasePersistenceImpl<CargaDescuento>
	implements CargaDescuentoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CargaDescuentoUtil} to access the carga descuento persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CargaDescuentoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
			CargaDescuentoModelImpl.FINDER_CACHE_ENABLED,
			CargaDescuentoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
			CargaDescuentoModelImpl.FINDER_CACHE_ENABLED,
			CargaDescuentoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
			CargaDescuentoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the carga descuento in the entity cache if it is enabled.
	 *
	 * @param cargaDescuento the carga descuento
	 */
	public void cacheResult(CargaDescuento cargaDescuento) {
		EntityCacheUtil.putResult(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
			CargaDescuentoImpl.class, cargaDescuento.getPrimaryKey(),
			cargaDescuento);

		cargaDescuento.resetOriginalValues();
	}

	/**
	 * Caches the carga descuentos in the entity cache if it is enabled.
	 *
	 * @param cargaDescuentos the carga descuentos
	 */
	public void cacheResult(List<CargaDescuento> cargaDescuentos) {
		for (CargaDescuento cargaDescuento : cargaDescuentos) {
			if (EntityCacheUtil.getResult(
						CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
						CargaDescuentoImpl.class, cargaDescuento.getPrimaryKey()) == null) {
				cacheResult(cargaDescuento);
			}
			else {
				cargaDescuento.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all carga descuentos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CargaDescuentoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CargaDescuentoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the carga descuento.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CargaDescuento cargaDescuento) {
		EntityCacheUtil.removeResult(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
			CargaDescuentoImpl.class, cargaDescuento.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CargaDescuento> cargaDescuentos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CargaDescuento cargaDescuento : cargaDescuentos) {
			EntityCacheUtil.removeResult(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
				CargaDescuentoImpl.class, cargaDescuento.getPrimaryKey());
		}
	}

	/**
	 * Creates a new carga descuento with the primary key. Does not add the carga descuento to the database.
	 *
	 * @param idCargaDesc the primary key for the new carga descuento
	 * @return the new carga descuento
	 */
	public CargaDescuento create(long idCargaDesc) {
		CargaDescuento cargaDescuento = new CargaDescuentoImpl();

		cargaDescuento.setNew(true);
		cargaDescuento.setPrimaryKey(idCargaDesc);

		return cargaDescuento;
	}

	/**
	 * Removes the carga descuento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idCargaDesc the primary key of the carga descuento
	 * @return the carga descuento that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCargaDescuentoException if a carga descuento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaDescuento remove(long idCargaDesc)
		throws NoSuchCargaDescuentoException, SystemException {
		return remove(Long.valueOf(idCargaDesc));
	}

	/**
	 * Removes the carga descuento with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the carga descuento
	 * @return the carga descuento that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCargaDescuentoException if a carga descuento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaDescuento remove(Serializable primaryKey)
		throws NoSuchCargaDescuentoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CargaDescuento cargaDescuento = (CargaDescuento)session.get(CargaDescuentoImpl.class,
					primaryKey);

			if (cargaDescuento == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCargaDescuentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cargaDescuento);
		}
		catch (NoSuchCargaDescuentoException nsee) {
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
	protected CargaDescuento removeImpl(CargaDescuento cargaDescuento)
		throws SystemException {
		cargaDescuento = toUnwrappedModel(cargaDescuento);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cargaDescuento);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cargaDescuento);

		return cargaDescuento;
	}

	@Override
	public CargaDescuento updateImpl(
		com.ext.portlet.halcon.model.CargaDescuento cargaDescuento,
		boolean merge) throws SystemException {
		cargaDescuento = toUnwrappedModel(cargaDescuento);

		boolean isNew = cargaDescuento.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cargaDescuento, merge);

			cargaDescuento.setNew(false);
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

		EntityCacheUtil.putResult(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
			CargaDescuentoImpl.class, cargaDescuento.getPrimaryKey(),
			cargaDescuento);

		return cargaDescuento;
	}

	protected CargaDescuento toUnwrappedModel(CargaDescuento cargaDescuento) {
		if (cargaDescuento instanceof CargaDescuentoImpl) {
			return cargaDescuento;
		}

		CargaDescuentoImpl cargaDescuentoImpl = new CargaDescuentoImpl();

		cargaDescuentoImpl.setNew(cargaDescuento.isNew());
		cargaDescuentoImpl.setPrimaryKey(cargaDescuento.getPrimaryKey());

		cargaDescuentoImpl.setIdCargaDesc(cargaDescuento.getIdCargaDesc());
		cargaDescuentoImpl.setLocal(cargaDescuento.getLocal());
		cargaDescuentoImpl.setDescuentoGeneral(cargaDescuento.getDescuentoGeneral());
		cargaDescuentoImpl.setCondicionesRestricciones(cargaDescuento.getCondicionesRestricciones());
		cargaDescuentoImpl.setDireccion(cargaDescuento.getDireccion());
		cargaDescuentoImpl.setIdDistrito(cargaDescuento.getIdDistrito());
		cargaDescuentoImpl.setDistrito(cargaDescuento.getDistrito());
		cargaDescuentoImpl.setTelefono(cargaDescuento.getTelefono());
		cargaDescuentoImpl.setWeb(cargaDescuento.getWeb());
		cargaDescuentoImpl.setFinVigencia(cargaDescuento.getFinVigencia());
		cargaDescuentoImpl.setCategoria(cargaDescuento.getCategoria());
		cargaDescuentoImpl.setCoordenada(cargaDescuento.getCoordenada());
		cargaDescuentoImpl.setURLImagen(cargaDescuento.getURLImagen());
		cargaDescuentoImpl.setLatitud(cargaDescuento.getLatitud());
		cargaDescuentoImpl.setLongitud(cargaDescuento.getLongitud());

		return cargaDescuentoImpl;
	}

	/**
	 * Returns the carga descuento with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the carga descuento
	 * @return the carga descuento
	 * @throws com.liferay.portal.NoSuchModelException if a carga descuento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaDescuento findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the carga descuento with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaDescuentoException} if it could not be found.
	 *
	 * @param idCargaDesc the primary key of the carga descuento
	 * @return the carga descuento
	 * @throws com.ext.portlet.halcon.NoSuchCargaDescuentoException if a carga descuento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaDescuento findByPrimaryKey(long idCargaDesc)
		throws NoSuchCargaDescuentoException, SystemException {
		CargaDescuento cargaDescuento = fetchByPrimaryKey(idCargaDesc);

		if (cargaDescuento == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idCargaDesc);
			}

			throw new NoSuchCargaDescuentoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idCargaDesc);
		}

		return cargaDescuento;
	}

	/**
	 * Returns the carga descuento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the carga descuento
	 * @return the carga descuento, or <code>null</code> if a carga descuento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaDescuento fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the carga descuento with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idCargaDesc the primary key of the carga descuento
	 * @return the carga descuento, or <code>null</code> if a carga descuento with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaDescuento fetchByPrimaryKey(long idCargaDesc)
		throws SystemException {
		CargaDescuento cargaDescuento = (CargaDescuento)EntityCacheUtil.getResult(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
				CargaDescuentoImpl.class, idCargaDesc);

		if (cargaDescuento == _nullCargaDescuento) {
			return null;
		}

		if (cargaDescuento == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cargaDescuento = (CargaDescuento)session.get(CargaDescuentoImpl.class,
						Long.valueOf(idCargaDesc));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cargaDescuento != null) {
					cacheResult(cargaDescuento);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CargaDescuentoModelImpl.ENTITY_CACHE_ENABLED,
						CargaDescuentoImpl.class, idCargaDesc,
						_nullCargaDescuento);
				}

				closeSession(session);
			}
		}

		return cargaDescuento;
	}

	/**
	 * Returns all the carga descuentos.
	 *
	 * @return the carga descuentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaDescuento> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carga descuentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of carga descuentos
	 * @param end the upper bound of the range of carga descuentos (not inclusive)
	 * @return the range of carga descuentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaDescuento> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the carga descuentos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of carga descuentos
	 * @param end the upper bound of the range of carga descuentos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of carga descuentos
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaDescuento> findAll(int start, int end,
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

		List<CargaDescuento> list = (List<CargaDescuento>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARGADESCUENTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARGADESCUENTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CargaDescuento>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CargaDescuento>)QueryUtil.list(q,
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
	 * Removes all the carga descuentos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CargaDescuento cargaDescuento : findAll()) {
			remove(cargaDescuento);
		}
	}

	/**
	 * Returns the number of carga descuentos.
	 *
	 * @return the number of carga descuentos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CARGADESCUENTO);

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
	 * Initializes the carga descuento persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.CargaDescuento")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CargaDescuento>> listenersList = new ArrayList<ModelListener<CargaDescuento>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CargaDescuento>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CargaDescuentoImpl.class.getName());
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
	private static final String _SQL_SELECT_CARGADESCUENTO = "SELECT cargaDescuento FROM CargaDescuento cargaDescuento";
	private static final String _SQL_COUNT_CARGADESCUENTO = "SELECT COUNT(cargaDescuento) FROM CargaDescuento cargaDescuento";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cargaDescuento.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CargaDescuento exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CargaDescuentoPersistenceImpl.class);
	private static CargaDescuento _nullCargaDescuento = new CargaDescuentoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CargaDescuento> toCacheModel() {
				return _nullCargaDescuentoCacheModel;
			}
		};

	private static CacheModel<CargaDescuento> _nullCargaDescuentoCacheModel = new CacheModel<CargaDescuento>() {
			public CargaDescuento toEntityModel() {
				return _nullCargaDescuento;
			}
		};
}