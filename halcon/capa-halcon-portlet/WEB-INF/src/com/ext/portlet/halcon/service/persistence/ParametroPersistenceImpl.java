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

import com.ext.portlet.halcon.NoSuchParametroException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.impl.ParametroImpl;
import com.ext.portlet.halcon.model.impl.ParametroModelImpl;

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
 * The persistence implementation for the parametro service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see ParametroPersistence
 * @see ParametroUtil
 * @generated
 */
public class ParametroPersistenceImpl extends BasePersistenceImpl<Parametro>
	implements ParametroPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ParametroUtil} to access the parametro persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ParametroImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, ParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, ParametroImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the parametro in the entity cache if it is enabled.
	 *
	 * @param parametro the parametro
	 */
	public void cacheResult(Parametro parametro) {
		EntityCacheUtil.putResult(ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroImpl.class, parametro.getPrimaryKey(), parametro);

		parametro.resetOriginalValues();
	}

	/**
	 * Caches the parametros in the entity cache if it is enabled.
	 *
	 * @param parametros the parametros
	 */
	public void cacheResult(List<Parametro> parametros) {
		for (Parametro parametro : parametros) {
			if (EntityCacheUtil.getResult(
						ParametroModelImpl.ENTITY_CACHE_ENABLED,
						ParametroImpl.class, parametro.getPrimaryKey()) == null) {
				cacheResult(parametro);
			}
			else {
				parametro.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all parametros.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ParametroImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ParametroImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the parametro.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Parametro parametro) {
		EntityCacheUtil.removeResult(ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroImpl.class, parametro.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Parametro> parametros) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Parametro parametro : parametros) {
			EntityCacheUtil.removeResult(ParametroModelImpl.ENTITY_CACHE_ENABLED,
				ParametroImpl.class, parametro.getPrimaryKey());
		}
	}

	/**
	 * Creates a new parametro with the primary key. Does not add the parametro to the database.
	 *
	 * @param idParametro the primary key for the new parametro
	 * @return the new parametro
	 */
	public Parametro create(int idParametro) {
		Parametro parametro = new ParametroImpl();

		parametro.setNew(true);
		parametro.setPrimaryKey(idParametro);

		return parametro;
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idParametro the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws com.ext.portlet.halcon.NoSuchParametroException if a parametro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parametro remove(int idParametro)
		throws NoSuchParametroException, SystemException {
		return remove(Integer.valueOf(idParametro));
	}

	/**
	 * Removes the parametro with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro that was removed
	 * @throws com.ext.portlet.halcon.NoSuchParametroException if a parametro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parametro remove(Serializable primaryKey)
		throws NoSuchParametroException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Parametro parametro = (Parametro)session.get(ParametroImpl.class,
					primaryKey);

			if (parametro == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchParametroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(parametro);
		}
		catch (NoSuchParametroException nsee) {
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
	protected Parametro removeImpl(Parametro parametro)
		throws SystemException {
		parametro = toUnwrappedModel(parametro);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, parametro);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(parametro);

		return parametro;
	}

	@Override
	public Parametro updateImpl(
		com.ext.portlet.halcon.model.Parametro parametro, boolean merge)
		throws SystemException {
		parametro = toUnwrappedModel(parametro);

		boolean isNew = parametro.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, parametro, merge);

			parametro.setNew(false);
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

		EntityCacheUtil.putResult(ParametroModelImpl.ENTITY_CACHE_ENABLED,
			ParametroImpl.class, parametro.getPrimaryKey(), parametro);

		return parametro;
	}

	protected Parametro toUnwrappedModel(Parametro parametro) {
		if (parametro instanceof ParametroImpl) {
			return parametro;
		}

		ParametroImpl parametroImpl = new ParametroImpl();

		parametroImpl.setNew(parametro.isNew());
		parametroImpl.setPrimaryKey(parametro.getPrimaryKey());

		parametroImpl.setIdParametro(parametro.getIdParametro());
		parametroImpl.setIdParametroPadre(parametro.getIdParametroPadre());
		parametroImpl.setValorMonto1(parametro.getValorMonto1());
		parametroImpl.setValorMonto2(parametro.getValorMonto2());
		parametroImpl.setValorMonto3(parametro.getValorMonto3());
		parametroImpl.setDato1(parametro.getDato1());
		parametroImpl.setDato2(parametro.getDato2());
		parametroImpl.setDato3(parametro.getDato3());
		parametroImpl.setDato4(parametro.getDato4());
		parametroImpl.setNum1(parametro.getNum1());
		parametroImpl.setNum2(parametro.getNum2());
		parametroImpl.setNum3(parametro.getNum3());

		return parametroImpl;
	}

	/**
	 * Returns the parametro with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro
	 * @throws com.liferay.portal.NoSuchModelException if a parametro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parametro findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the parametro with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchParametroException} if it could not be found.
	 *
	 * @param idParametro the primary key of the parametro
	 * @return the parametro
	 * @throws com.ext.portlet.halcon.NoSuchParametroException if a parametro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parametro findByPrimaryKey(int idParametro)
		throws NoSuchParametroException, SystemException {
		Parametro parametro = fetchByPrimaryKey(idParametro);

		if (parametro == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + idParametro);
			}

			throw new NoSuchParametroException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idParametro);
		}

		return parametro;
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Parametro fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Integer)primaryKey).intValue());
	}

	/**
	 * Returns the parametro with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idParametro the primary key of the parametro
	 * @return the parametro, or <code>null</code> if a parametro with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Parametro fetchByPrimaryKey(int idParametro)
		throws SystemException {
		Parametro parametro = (Parametro)EntityCacheUtil.getResult(ParametroModelImpl.ENTITY_CACHE_ENABLED,
				ParametroImpl.class, idParametro);

		if (parametro == _nullParametro) {
			return null;
		}

		if (parametro == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				parametro = (Parametro)session.get(ParametroImpl.class,
						Integer.valueOf(idParametro));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (parametro != null) {
					cacheResult(parametro);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ParametroModelImpl.ENTITY_CACHE_ENABLED,
						ParametroImpl.class, idParametro, _nullParametro);
				}

				closeSession(session);
			}
		}

		return parametro;
	}

	/**
	 * Returns all the parametros.
	 *
	 * @return the parametros
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parametro> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @return the range of parametros
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parametro> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the parametros.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of parametros
	 * @param end the upper bound of the range of parametros (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of parametros
	 * @throws SystemException if a system exception occurred
	 */
	public List<Parametro> findAll(int start, int end,
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

		List<Parametro> list = (List<Parametro>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PARAMETRO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PARAMETRO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Parametro>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Parametro>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the parametros from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Parametro parametro : findAll()) {
			remove(parametro);
		}
	}

	/**
	 * Returns the number of parametros.
	 *
	 * @return the number of parametros
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PARAMETRO);

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
	 * Initializes the parametro persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.Parametro")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Parametro>> listenersList = new ArrayList<ModelListener<Parametro>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Parametro>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ParametroImpl.class.getName());
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
	private static final String _SQL_SELECT_PARAMETRO = "SELECT parametro FROM Parametro parametro";
	private static final String _SQL_COUNT_PARAMETRO = "SELECT COUNT(parametro) FROM Parametro parametro";
	private static final String _ORDER_BY_ENTITY_ALIAS = "parametro.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Parametro exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ParametroPersistenceImpl.class);
	private static Parametro _nullParametro = new ParametroImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Parametro> toCacheModel() {
				return _nullParametroCacheModel;
			}
		};

	private static CacheModel<Parametro> _nullParametroCacheModel = new CacheModel<Parametro>() {
			public Parametro toEntityModel() {
				return _nullParametro;
			}
		};
}