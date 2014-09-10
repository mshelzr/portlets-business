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

import com.ext.portlet.halcon.NoSuchCargaTiendaException;
import com.ext.portlet.halcon.model.CargaTienda;
import com.ext.portlet.halcon.model.impl.CargaTiendaImpl;
import com.ext.portlet.halcon.model.impl.CargaTiendaModelImpl;

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
 * The persistence implementation for the carga tienda service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see CargaTiendaPersistence
 * @see CargaTiendaUtil
 * @generated
 */
public class CargaTiendaPersistenceImpl extends BasePersistenceImpl<CargaTienda>
	implements CargaTiendaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CargaTiendaUtil} to access the carga tienda persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CargaTiendaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
			CargaTiendaModelImpl.FINDER_CACHE_ENABLED, CargaTiendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
			CargaTiendaModelImpl.FINDER_CACHE_ENABLED, CargaTiendaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
			CargaTiendaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the carga tienda in the entity cache if it is enabled.
	 *
	 * @param cargaTienda the carga tienda
	 */
	public void cacheResult(CargaTienda cargaTienda) {
		EntityCacheUtil.putResult(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
			CargaTiendaImpl.class, cargaTienda.getPrimaryKey(), cargaTienda);

		cargaTienda.resetOriginalValues();
	}

	/**
	 * Caches the carga tiendas in the entity cache if it is enabled.
	 *
	 * @param cargaTiendas the carga tiendas
	 */
	public void cacheResult(List<CargaTienda> cargaTiendas) {
		for (CargaTienda cargaTienda : cargaTiendas) {
			if (EntityCacheUtil.getResult(
						CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
						CargaTiendaImpl.class, cargaTienda.getPrimaryKey()) == null) {
				cacheResult(cargaTienda);
			}
			else {
				cargaTienda.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all carga tiendas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CargaTiendaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CargaTiendaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the carga tienda.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CargaTienda cargaTienda) {
		EntityCacheUtil.removeResult(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
			CargaTiendaImpl.class, cargaTienda.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CargaTienda> cargaTiendas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CargaTienda cargaTienda : cargaTiendas) {
			EntityCacheUtil.removeResult(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
				CargaTiendaImpl.class, cargaTienda.getPrimaryKey());
		}
	}

	/**
	 * Creates a new carga tienda with the primary key. Does not add the carga tienda to the database.
	 *
	 * @param idCargaTienda the primary key for the new carga tienda
	 * @return the new carga tienda
	 */
	public CargaTienda create(long idCargaTienda) {
		CargaTienda cargaTienda = new CargaTiendaImpl();

		cargaTienda.setNew(true);
		cargaTienda.setPrimaryKey(idCargaTienda);

		return cargaTienda;
	}

	/**
	 * Removes the carga tienda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idCargaTienda the primary key of the carga tienda
	 * @return the carga tienda that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaTienda remove(long idCargaTienda)
		throws NoSuchCargaTiendaException, SystemException {
		return remove(Long.valueOf(idCargaTienda));
	}

	/**
	 * Removes the carga tienda with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the carga tienda
	 * @return the carga tienda that was removed
	 * @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaTienda remove(Serializable primaryKey)
		throws NoSuchCargaTiendaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CargaTienda cargaTienda = (CargaTienda)session.get(CargaTiendaImpl.class,
					primaryKey);

			if (cargaTienda == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCargaTiendaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cargaTienda);
		}
		catch (NoSuchCargaTiendaException nsee) {
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
	protected CargaTienda removeImpl(CargaTienda cargaTienda)
		throws SystemException {
		cargaTienda = toUnwrappedModel(cargaTienda);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, cargaTienda);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(cargaTienda);

		return cargaTienda;
	}

	@Override
	public CargaTienda updateImpl(
		com.ext.portlet.halcon.model.CargaTienda cargaTienda, boolean merge)
		throws SystemException {
		cargaTienda = toUnwrappedModel(cargaTienda);

		boolean isNew = cargaTienda.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, cargaTienda, merge);

			cargaTienda.setNew(false);
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

		EntityCacheUtil.putResult(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
			CargaTiendaImpl.class, cargaTienda.getPrimaryKey(), cargaTienda);

		return cargaTienda;
	}

	protected CargaTienda toUnwrappedModel(CargaTienda cargaTienda) {
		if (cargaTienda instanceof CargaTiendaImpl) {
			return cargaTienda;
		}

		CargaTiendaImpl cargaTiendaImpl = new CargaTiendaImpl();

		cargaTiendaImpl.setNew(cargaTienda.isNew());
		cargaTiendaImpl.setPrimaryKey(cargaTienda.getPrimaryKey());

		cargaTiendaImpl.setIdCargaTienda(cargaTienda.getIdCargaTienda());
		cargaTiendaImpl.setIdPtoServicio(cargaTienda.getIdPtoServicio());
		cargaTiendaImpl.setIdCanal(cargaTienda.getIdCanal());
		cargaTiendaImpl.setIdSubCanal(cargaTienda.getIdSubCanal());
		cargaTiendaImpl.setCodDepartamento(cargaTienda.getCodDepartamento());
		cargaTiendaImpl.setCodProvincia(cargaTienda.getCodProvincia());
		cargaTiendaImpl.setCodDistrito(cargaTienda.getCodDistrito());
		cargaTiendaImpl.setNomDepartamento(cargaTienda.getNomDepartamento());
		cargaTiendaImpl.setNomProvincia(cargaTienda.getNomProvincia());
		cargaTiendaImpl.setNomDistrito(cargaTienda.getNomDistrito());
		cargaTiendaImpl.setLatitud(cargaTienda.getLatitud());
		cargaTiendaImpl.setLongitud(cargaTienda.getLongitud());
		cargaTiendaImpl.setDireccion(cargaTienda.getDireccion());
		cargaTiendaImpl.setHorario(cargaTienda.getHorario());
		cargaTiendaImpl.setTipoLocacion(cargaTienda.getTipoLocacion());
		cargaTiendaImpl.setCodTienda(cargaTienda.getCodTienda());
		cargaTiendaImpl.setIdLocacion(cargaTienda.getIdLocacion());
		cargaTiendaImpl.setLocacion(cargaTienda.getLocacion());
		cargaTiendaImpl.setEmailCom(cargaTienda.getEmailCom());
		cargaTiendaImpl.setTelefono(cargaTienda.getTelefono());

		return cargaTiendaImpl;
	}

	/**
	 * Returns the carga tienda with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the carga tienda
	 * @return the carga tienda
	 * @throws com.liferay.portal.NoSuchModelException if a carga tienda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaTienda findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the carga tienda with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchCargaTiendaException} if it could not be found.
	 *
	 * @param idCargaTienda the primary key of the carga tienda
	 * @return the carga tienda
	 * @throws com.ext.portlet.halcon.NoSuchCargaTiendaException if a carga tienda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaTienda findByPrimaryKey(long idCargaTienda)
		throws NoSuchCargaTiendaException, SystemException {
		CargaTienda cargaTienda = fetchByPrimaryKey(idCargaTienda);

		if (cargaTienda == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idCargaTienda);
			}

			throw new NoSuchCargaTiendaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idCargaTienda);
		}

		return cargaTienda;
	}

	/**
	 * Returns the carga tienda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the carga tienda
	 * @return the carga tienda, or <code>null</code> if a carga tienda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CargaTienda fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the carga tienda with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idCargaTienda the primary key of the carga tienda
	 * @return the carga tienda, or <code>null</code> if a carga tienda with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CargaTienda fetchByPrimaryKey(long idCargaTienda)
		throws SystemException {
		CargaTienda cargaTienda = (CargaTienda)EntityCacheUtil.getResult(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
				CargaTiendaImpl.class, idCargaTienda);

		if (cargaTienda == _nullCargaTienda) {
			return null;
		}

		if (cargaTienda == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				cargaTienda = (CargaTienda)session.get(CargaTiendaImpl.class,
						Long.valueOf(idCargaTienda));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (cargaTienda != null) {
					cacheResult(cargaTienda);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CargaTiendaModelImpl.ENTITY_CACHE_ENABLED,
						CargaTiendaImpl.class, idCargaTienda, _nullCargaTienda);
				}

				closeSession(session);
			}
		}

		return cargaTienda;
	}

	/**
	 * Returns all the carga tiendas.
	 *
	 * @return the carga tiendas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaTienda> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the carga tiendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of carga tiendas
	 * @param end the upper bound of the range of carga tiendas (not inclusive)
	 * @return the range of carga tiendas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaTienda> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the carga tiendas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of carga tiendas
	 * @param end the upper bound of the range of carga tiendas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of carga tiendas
	 * @throws SystemException if a system exception occurred
	 */
	public List<CargaTienda> findAll(int start, int end,
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

		List<CargaTienda> list = (List<CargaTienda>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CARGATIENDA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CARGATIENDA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CargaTienda>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CargaTienda>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the carga tiendas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CargaTienda cargaTienda : findAll()) {
			remove(cargaTienda);
		}
	}

	/**
	 * Returns the number of carga tiendas.
	 *
	 * @return the number of carga tiendas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CARGATIENDA);

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
	 * Initializes the carga tienda persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.CargaTienda")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CargaTienda>> listenersList = new ArrayList<ModelListener<CargaTienda>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CargaTienda>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CargaTiendaImpl.class.getName());
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
	private static final String _SQL_SELECT_CARGATIENDA = "SELECT cargaTienda FROM CargaTienda cargaTienda";
	private static final String _SQL_COUNT_CARGATIENDA = "SELECT COUNT(cargaTienda) FROM CargaTienda cargaTienda";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cargaTienda.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CargaTienda exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CargaTiendaPersistenceImpl.class);
	private static CargaTienda _nullCargaTienda = new CargaTiendaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CargaTienda> toCacheModel() {
				return _nullCargaTiendaCacheModel;
			}
		};

	private static CacheModel<CargaTienda> _nullCargaTiendaCacheModel = new CacheModel<CargaTienda>() {
			public CargaTienda toEntityModel() {
				return _nullCargaTienda;
			}
		};
}