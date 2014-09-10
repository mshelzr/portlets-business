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

import com.ext.portlet.halcon.NoSuchSolicitudContactoException;
import com.ext.portlet.halcon.model.SolicitudContacto;
import com.ext.portlet.halcon.model.impl.SolicitudContactoImpl;
import com.ext.portlet.halcon.model.impl.SolicitudContactoModelImpl;

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
 * The persistence implementation for the solicitud contacto service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Infonet-Consulting
 * @see SolicitudContactoPersistence
 * @see SolicitudContactoUtil
 * @generated
 */
public class SolicitudContactoPersistenceImpl extends BasePersistenceImpl<SolicitudContacto>
	implements SolicitudContactoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SolicitudContactoUtil} to access the solicitud contacto persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SolicitudContactoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudContactoModelImpl.FINDER_CACHE_ENABLED,
			SolicitudContactoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudContactoModelImpl.FINDER_CACHE_ENABLED,
			SolicitudContactoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudContactoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the solicitud contacto in the entity cache if it is enabled.
	 *
	 * @param solicitudContacto the solicitud contacto
	 */
	public void cacheResult(SolicitudContacto solicitudContacto) {
		EntityCacheUtil.putResult(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudContactoImpl.class, solicitudContacto.getPrimaryKey(),
			solicitudContacto);

		solicitudContacto.resetOriginalValues();
	}

	/**
	 * Caches the solicitud contactos in the entity cache if it is enabled.
	 *
	 * @param solicitudContactos the solicitud contactos
	 */
	public void cacheResult(List<SolicitudContacto> solicitudContactos) {
		for (SolicitudContacto solicitudContacto : solicitudContactos) {
			if (EntityCacheUtil.getResult(
						SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
						SolicitudContactoImpl.class,
						solicitudContacto.getPrimaryKey()) == null) {
				cacheResult(solicitudContacto);
			}
			else {
				solicitudContacto.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all solicitud contactos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SolicitudContactoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SolicitudContactoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the solicitud contacto.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SolicitudContacto solicitudContacto) {
		EntityCacheUtil.removeResult(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudContactoImpl.class, solicitudContacto.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SolicitudContacto> solicitudContactos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SolicitudContacto solicitudContacto : solicitudContactos) {
			EntityCacheUtil.removeResult(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
				SolicitudContactoImpl.class, solicitudContacto.getPrimaryKey());
		}
	}

	/**
	 * Creates a new solicitud contacto with the primary key. Does not add the solicitud contacto to the database.
	 *
	 * @param idSolicitudContacto the primary key for the new solicitud contacto
	 * @return the new solicitud contacto
	 */
	public SolicitudContacto create(long idSolicitudContacto) {
		SolicitudContacto solicitudContacto = new SolicitudContactoImpl();

		solicitudContacto.setNew(true);
		solicitudContacto.setPrimaryKey(idSolicitudContacto);

		return solicitudContacto;
	}

	/**
	 * Removes the solicitud contacto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param idSolicitudContacto the primary key of the solicitud contacto
	 * @return the solicitud contacto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchSolicitudContactoException if a solicitud contacto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SolicitudContacto remove(long idSolicitudContacto)
		throws NoSuchSolicitudContactoException, SystemException {
		return remove(Long.valueOf(idSolicitudContacto));
	}

	/**
	 * Removes the solicitud contacto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the solicitud contacto
	 * @return the solicitud contacto that was removed
	 * @throws com.ext.portlet.halcon.NoSuchSolicitudContactoException if a solicitud contacto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SolicitudContacto remove(Serializable primaryKey)
		throws NoSuchSolicitudContactoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SolicitudContacto solicitudContacto = (SolicitudContacto)session.get(SolicitudContactoImpl.class,
					primaryKey);

			if (solicitudContacto == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSolicitudContactoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(solicitudContacto);
		}
		catch (NoSuchSolicitudContactoException nsee) {
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
	protected SolicitudContacto removeImpl(SolicitudContacto solicitudContacto)
		throws SystemException {
		solicitudContacto = toUnwrappedModel(solicitudContacto);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, solicitudContacto);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(solicitudContacto);

		return solicitudContacto;
	}

	@Override
	public SolicitudContacto updateImpl(
		com.ext.portlet.halcon.model.SolicitudContacto solicitudContacto,
		boolean merge) throws SystemException {
		solicitudContacto = toUnwrappedModel(solicitudContacto);

		boolean isNew = solicitudContacto.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, solicitudContacto, merge);

			solicitudContacto.setNew(false);
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

		EntityCacheUtil.putResult(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
			SolicitudContactoImpl.class, solicitudContacto.getPrimaryKey(),
			solicitudContacto);

		return solicitudContacto;
	}

	protected SolicitudContacto toUnwrappedModel(
		SolicitudContacto solicitudContacto) {
		if (solicitudContacto instanceof SolicitudContactoImpl) {
			return solicitudContacto;
		}

		SolicitudContactoImpl solicitudContactoImpl = new SolicitudContactoImpl();

		solicitudContactoImpl.setNew(solicitudContacto.isNew());
		solicitudContactoImpl.setPrimaryKey(solicitudContacto.getPrimaryKey());

		solicitudContactoImpl.setIdSolicitudContacto(solicitudContacto.getIdSolicitudContacto());
		solicitudContactoImpl.setEsCliente(solicitudContacto.getEsCliente());
		solicitudContactoImpl.setNombres(solicitudContacto.getNombres());
		solicitudContactoImpl.setApellidos(solicitudContacto.getApellidos());
		solicitudContactoImpl.setEmail(solicitudContacto.getEmail());
		solicitudContactoImpl.setTipoDocumento(solicitudContacto.getTipoDocumento());
		solicitudContactoImpl.setNdocumento(solicitudContacto.getNdocumento());
		solicitudContactoImpl.setDireccion(solicitudContacto.getDireccion());
		solicitudContactoImpl.setDepartamento(solicitudContacto.getDepartamento());
		solicitudContactoImpl.setProvincia(solicitudContacto.getProvincia());
		solicitudContactoImpl.setDistrito(solicitudContacto.getDistrito());
		solicitudContactoImpl.setTelefono(solicitudContacto.getTelefono());
		solicitudContactoImpl.setFecha(solicitudContacto.getFecha());
		solicitudContactoImpl.setMensaje(solicitudContacto.getMensaje());
		solicitudContactoImpl.setMoneda(solicitudContacto.getMoneda());
		solicitudContactoImpl.setImporte(solicitudContacto.getImporte());
		solicitudContactoImpl.setTipoMensaje(solicitudContacto.getTipoMensaje());
		solicitudContactoImpl.setTipoTema(solicitudContacto.getTipoTema());

		return solicitudContactoImpl;
	}

	/**
	 * Returns the solicitud contacto with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitud contacto
	 * @return the solicitud contacto
	 * @throws com.liferay.portal.NoSuchModelException if a solicitud contacto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SolicitudContacto findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the solicitud contacto with the primary key or throws a {@link com.ext.portlet.halcon.NoSuchSolicitudContactoException} if it could not be found.
	 *
	 * @param idSolicitudContacto the primary key of the solicitud contacto
	 * @return the solicitud contacto
	 * @throws com.ext.portlet.halcon.NoSuchSolicitudContactoException if a solicitud contacto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SolicitudContacto findByPrimaryKey(long idSolicitudContacto)
		throws NoSuchSolicitudContactoException, SystemException {
		SolicitudContacto solicitudContacto = fetchByPrimaryKey(idSolicitudContacto);

		if (solicitudContacto == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					idSolicitudContacto);
			}

			throw new NoSuchSolicitudContactoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				idSolicitudContacto);
		}

		return solicitudContacto;
	}

	/**
	 * Returns the solicitud contacto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the solicitud contacto
	 * @return the solicitud contacto, or <code>null</code> if a solicitud contacto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SolicitudContacto fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the solicitud contacto with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param idSolicitudContacto the primary key of the solicitud contacto
	 * @return the solicitud contacto, or <code>null</code> if a solicitud contacto with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SolicitudContacto fetchByPrimaryKey(long idSolicitudContacto)
		throws SystemException {
		SolicitudContacto solicitudContacto = (SolicitudContacto)EntityCacheUtil.getResult(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
				SolicitudContactoImpl.class, idSolicitudContacto);

		if (solicitudContacto == _nullSolicitudContacto) {
			return null;
		}

		if (solicitudContacto == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				solicitudContacto = (SolicitudContacto)session.get(SolicitudContactoImpl.class,
						Long.valueOf(idSolicitudContacto));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (solicitudContacto != null) {
					cacheResult(solicitudContacto);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SolicitudContactoModelImpl.ENTITY_CACHE_ENABLED,
						SolicitudContactoImpl.class, idSolicitudContacto,
						_nullSolicitudContacto);
				}

				closeSession(session);
			}
		}

		return solicitudContacto;
	}

	/**
	 * Returns all the solicitud contactos.
	 *
	 * @return the solicitud contactos
	 * @throws SystemException if a system exception occurred
	 */
	public List<SolicitudContacto> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the solicitud contactos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitud contactos
	 * @param end the upper bound of the range of solicitud contactos (not inclusive)
	 * @return the range of solicitud contactos
	 * @throws SystemException if a system exception occurred
	 */
	public List<SolicitudContacto> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the solicitud contactos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of solicitud contactos
	 * @param end the upper bound of the range of solicitud contactos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of solicitud contactos
	 * @throws SystemException if a system exception occurred
	 */
	public List<SolicitudContacto> findAll(int start, int end,
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

		List<SolicitudContacto> list = (List<SolicitudContacto>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SOLICITUDCONTACTO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SOLICITUDCONTACTO;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SolicitudContacto>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SolicitudContacto>)QueryUtil.list(q,
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
	 * Removes all the solicitud contactos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SolicitudContacto solicitudContacto : findAll()) {
			remove(solicitudContacto);
		}
	}

	/**
	 * Returns the number of solicitud contactos.
	 *
	 * @return the number of solicitud contactos
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SOLICITUDCONTACTO);

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
	 * Initializes the solicitud contacto persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.halcon.model.SolicitudContacto")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SolicitudContacto>> listenersList = new ArrayList<ModelListener<SolicitudContacto>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SolicitudContacto>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SolicitudContactoImpl.class.getName());
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
	private static final String _SQL_SELECT_SOLICITUDCONTACTO = "SELECT solicitudContacto FROM SolicitudContacto solicitudContacto";
	private static final String _SQL_COUNT_SOLICITUDCONTACTO = "SELECT COUNT(solicitudContacto) FROM SolicitudContacto solicitudContacto";
	private static final String _ORDER_BY_ENTITY_ALIAS = "solicitudContacto.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SolicitudContacto exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SolicitudContactoPersistenceImpl.class);
	private static SolicitudContacto _nullSolicitudContacto = new SolicitudContactoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SolicitudContacto> toCacheModel() {
				return _nullSolicitudContactoCacheModel;
			}
		};

	private static CacheModel<SolicitudContacto> _nullSolicitudContactoCacheModel =
		new CacheModel<SolicitudContacto>() {
			public SolicitudContacto toEntityModel() {
				return _nullSolicitudContacto;
			}
		};
}