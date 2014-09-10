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

import com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorImpl;
import com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorModelImpl;

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
 * The persistence implementation for the configuracion perfilador service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ConfiguracionPerfiladorPersistence
 * @see ConfiguracionPerfiladorUtil
 * @generated
 */
public class ConfiguracionPerfiladorPersistenceImpl extends BasePersistenceImpl<ConfiguracionPerfilador>
	implements ConfiguracionPerfiladorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ConfiguracionPerfiladorUtil} to access the configuracion perfilador persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ConfiguracionPerfiladorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionPerfiladorModelImpl.FINDER_CACHE_ENABLED,
			ConfiguracionPerfiladorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionPerfiladorModelImpl.FINDER_CACHE_ENABLED,
			ConfiguracionPerfiladorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionPerfiladorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the configuracion perfilador in the entity cache if it is enabled.
	 *
	 * @param configuracionPerfilador the configuracion perfilador
	 */
	public void cacheResult(ConfiguracionPerfilador configuracionPerfilador) {
		EntityCacheUtil.putResult(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionPerfiladorImpl.class,
			configuracionPerfilador.getPrimaryKey(), configuracionPerfilador);

		configuracionPerfilador.resetOriginalValues();
	}

	/**
	 * Caches the configuracion perfiladors in the entity cache if it is enabled.
	 *
	 * @param configuracionPerfiladors the configuracion perfiladors
	 */
	public void cacheResult(
		List<ConfiguracionPerfilador> configuracionPerfiladors) {
		for (ConfiguracionPerfilador configuracionPerfilador : configuracionPerfiladors) {
			if (EntityCacheUtil.getResult(
						ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
						ConfiguracionPerfiladorImpl.class,
						configuracionPerfilador.getPrimaryKey()) == null) {
				cacheResult(configuracionPerfilador);
			}
			else {
				configuracionPerfilador.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all configuracion perfiladors.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ConfiguracionPerfiladorImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ConfiguracionPerfiladorImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the configuracion perfilador.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConfiguracionPerfilador configuracionPerfilador) {
		EntityCacheUtil.removeResult(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionPerfiladorImpl.class,
			configuracionPerfilador.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<ConfiguracionPerfilador> configuracionPerfiladors) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ConfiguracionPerfilador configuracionPerfilador : configuracionPerfiladors) {
			EntityCacheUtil.removeResult(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
				ConfiguracionPerfiladorImpl.class,
				configuracionPerfilador.getPrimaryKey());
		}
	}

	/**
	 * Creates a new configuracion perfilador with the primary key. Does not add the configuracion perfilador to the database.
	 *
	 * @param idConfiguracionPerfilador the primary key for the new configuracion perfilador
	 * @return the new configuracion perfilador
	 */
	public ConfiguracionPerfilador create(long idConfiguracionPerfilador) {
		ConfiguracionPerfilador configuracionPerfilador = new ConfiguracionPerfiladorImpl();

		configuracionPerfilador.setNew(true);
		configuracionPerfilador.setPrimaryKey(idConfiguracionPerfilador);

		return configuracionPerfilador;
	}

	/**
	 * Removes the configuracion perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	 * @return the configuracion perfilador that was removed
	 * @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ConfiguracionPerfilador remove(long idConfiguracionPerfilador)
		throws NoSuchConfiguracionPerfiladorException, SystemException {
		return remove(Long.valueOf(idConfiguracionPerfilador));
	}

	/**
	 * Removes the configuracion perfilador with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the configuracion perfilador
	 * @return the configuracion perfilador that was removed
	 * @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfiguracionPerfilador remove(Serializable primaryKey)
		throws NoSuchConfiguracionPerfiladorException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ConfiguracionPerfilador configuracionPerfilador = (ConfiguracionPerfilador)session.get(ConfiguracionPerfiladorImpl.class,
					primaryKey);

			if (configuracionPerfilador == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConfiguracionPerfiladorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(configuracionPerfilador);
		}
		catch (NoSuchConfiguracionPerfiladorException nsee) {
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
	protected ConfiguracionPerfilador removeImpl(
		ConfiguracionPerfilador configuracionPerfilador)
		throws SystemException {
		configuracionPerfilador = toUnwrappedModel(configuracionPerfilador);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, configuracionPerfilador);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(configuracionPerfilador);

		return configuracionPerfilador;
	}

	@Override
	public ConfiguracionPerfilador updateImpl(
		com.ext.portlet.halcon.model.ConfiguracionPerfilador configuracionPerfilador,
		boolean merge) throws SystemException {
		configuracionPerfilador = toUnwrappedModel(configuracionPerfilador);

		boolean isNew = configuracionPerfilador.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, configuracionPerfilador, merge);

			configuracionPerfilador.setNew(false);
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

		EntityCacheUtil.putResult(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
			ConfiguracionPerfiladorImpl.class,
			configuracionPerfilador.getPrimaryKey(), configuracionPerfilador);

		return configuracionPerfilador;
	}

	protected ConfiguracionPerfilador toUnwrappedModel(
		ConfiguracionPerfilador configuracionPerfilador) {
		if (configuracionPerfilador instanceof ConfiguracionPerfiladorImpl) {
			return configuracionPerfilador;
		}

		ConfiguracionPerfiladorImpl configuracionPerfiladorImpl = new ConfiguracionPerfiladorImpl();

		configuracionPerfiladorImpl.setNew(configuracionPerfilador.isNew());
		configuracionPerfiladorImpl.setPrimaryKey(configuracionPerfilador.getPrimaryKey());

		configuracionPerfiladorImpl.setIdConfiguracionPerfilador(configuracionPerfilador.getIdConfiguracionPerfilador());
		configuracionPerfiladorImpl.setTipoVariable(configuracionPerfilador.getTipoVariable());
		configuracionPerfiladorImpl.setNombreVariable(configuracionPerfilador.getNombreVariable());
		configuracionPerfiladorImpl.setCodigoClasificacion(configuracionPerfilador.getCodigoClasificacion());
		configuracionPerfiladorImpl.setCodigoVariablePadre(configuracionPerfilador.getCodigoVariablePadre());
		configuracionPerfiladorImpl.setValor1(configuracionPerfilador.getValor1());
		configuracionPerfiladorImpl.setValor2(configuracionPerfilador.getValor2());
		configuracionPerfiladorImpl.setValor3(configuracionPerfilador.getValor3());
		configuracionPerfiladorImpl.setEstado(configuracionPerfilador.getEstado());

		return configuracionPerfiladorImpl;
	}

	/**
	 * Returns the configuracion perfilador with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuracion perfilador
	 * @return the configuracion perfilador
	 * @throws com.liferay.portal.NoSuchModelException if a configuracion perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfiguracionPerfilador findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the configuracion perfilador with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException} if it could not be found.
	 *
	 * @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	 * @return the configuracion perfilador
	 * @throws com.ext.portlet.halcon.NoSuchConfiguracionPerfiladorException if a configuracion perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ConfiguracionPerfilador findByPrimaryKey(
		long idConfiguracionPerfilador)
		throws NoSuchConfiguracionPerfiladorException, SystemException {
		ConfiguracionPerfilador configuracionPerfilador = fetchByPrimaryKey(idConfiguracionPerfilador);

		if (configuracionPerfilador == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idConfiguracionPerfilador);
			}

			throw new NoSuchConfiguracionPerfiladorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idConfiguracionPerfilador);
		}

		return configuracionPerfilador;
	}

	/**
	 * Returns the configuracion perfilador with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the configuracion perfilador
	 * @return the configuracion perfilador, or <code>null</code> if a configuracion perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ConfiguracionPerfilador fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the configuracion perfilador with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idConfiguracionPerfilador the primary key of the configuracion perfilador
	 * @return the configuracion perfilador, or <code>null</code> if a configuracion perfilador with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ConfiguracionPerfilador fetchByPrimaryKey(
		long idConfiguracionPerfilador) throws SystemException {
		ConfiguracionPerfilador configuracionPerfilador = (ConfiguracionPerfilador)EntityCacheUtil.getResult(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
				ConfiguracionPerfiladorImpl.class, idConfiguracionPerfilador);

		if (configuracionPerfilador == _nullConfiguracionPerfilador) {
			return null;
		}

		if (configuracionPerfilador == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				configuracionPerfilador = (ConfiguracionPerfilador)session.get(ConfiguracionPerfiladorImpl.class,
						Long.valueOf(idConfiguracionPerfilador));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (configuracionPerfilador != null) {
					cacheResult(configuracionPerfilador);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ConfiguracionPerfiladorModelImpl.ENTITY_CACHE_ENABLED,
						ConfiguracionPerfiladorImpl.class,
						idConfiguracionPerfilador, _nullConfiguracionPerfilador);
				}

				closeSession(session);
			}
		}

		return configuracionPerfilador;
	}

	/**
	 * Returns all the configuracion perfiladors.
	 *
	 * @return the configuracion perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<ConfiguracionPerfilador> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the configuracion perfiladors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuracion perfiladors
	 * @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	 * @return the range of configuracion perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<ConfiguracionPerfilador> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the configuracion perfiladors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of configuracion perfiladors
	 * @param end the upper bound of the range of configuracion perfiladors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of configuracion perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public List<ConfiguracionPerfilador> findAll(int start, int end,
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

		List<ConfiguracionPerfilador> list = (List<ConfiguracionPerfilador>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CONFIGURACIONPERFILADOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CONFIGURACIONPERFILADOR;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ConfiguracionPerfilador>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ConfiguracionPerfilador>)QueryUtil.list(q,
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
	 * Removes all the configuracion perfiladors from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ConfiguracionPerfilador configuracionPerfilador : findAll()) {
			remove(configuracionPerfilador);
		}
	}

	/**
	 * Returns the number of configuracion perfiladors.
	 *
	 * @return the number of configuracion perfiladors
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONFIGURACIONPERFILADOR);

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
	 * Initializes the configuracion perfilador persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.ConfiguracionPerfilador")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ConfiguracionPerfilador>> listenersList = new ArrayList<ModelListener<ConfiguracionPerfilador>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ConfiguracionPerfilador>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ConfiguracionPerfiladorImpl.class.getName());
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
	private static final String _SQL_SELECT_CONFIGURACIONPERFILADOR = "SELECT configuracionPerfilador FROM ConfiguracionPerfilador configuracionPerfilador";
	private static final String _SQL_COUNT_CONFIGURACIONPERFILADOR = "SELECT COUNT(configuracionPerfilador) FROM ConfiguracionPerfilador configuracionPerfilador";
	private static final String _ORDER_BY_ENTITY_ALIAS = "configuracionPerfilador.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ConfiguracionPerfilador exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ConfiguracionPerfiladorPersistenceImpl.class);
	private static ConfiguracionPerfilador _nullConfiguracionPerfilador = new ConfiguracionPerfiladorImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ConfiguracionPerfilador> toCacheModel() {
				return _nullConfiguracionPerfiladorCacheModel;
			}
		};

	private static CacheModel<ConfiguracionPerfilador> _nullConfiguracionPerfiladorCacheModel =
		new CacheModel<ConfiguracionPerfilador>() {
			public ConfiguracionPerfilador toEntityModel() {
				return _nullConfiguracionPerfilador;
			}
		};
}