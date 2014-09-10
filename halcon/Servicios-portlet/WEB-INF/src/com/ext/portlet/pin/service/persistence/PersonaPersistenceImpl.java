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

package com.ext.portlet.pin.service.persistence;

import com.ext.portlet.pin.NoSuchPersonaException;
import com.ext.portlet.pin.model.Persona;
import com.ext.portlet.pin.model.impl.PersonaImpl;
import com.ext.portlet.pin.model.impl.PersonaModelImpl;

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
 * The persistence implementation for the persona service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author arodriguez
 * @see PersonaPersistence
 * @see PersonaUtil
 * @generated
 */
public class PersonaPersistenceImpl extends BasePersistenceImpl<Persona>
	implements PersonaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PersonaUtil} to access the persona persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PersonaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaModelImpl.FINDER_CACHE_ENABLED, PersonaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaModelImpl.FINDER_CACHE_ENABLED, PersonaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the persona in the entity cache if it is enabled.
	 *
	 * @param persona the persona
	 */
	public void cacheResult(Persona persona) {
		EntityCacheUtil.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaImpl.class, persona.getPrimaryKey(), persona);

		persona.resetOriginalValues();
	}

	/**
	 * Caches the personas in the entity cache if it is enabled.
	 *
	 * @param personas the personas
	 */
	public void cacheResult(List<Persona> personas) {
		for (Persona persona : personas) {
			if (EntityCacheUtil.getResult(
						PersonaModelImpl.ENTITY_CACHE_ENABLED,
						PersonaImpl.class, persona.getPrimaryKey()) == null) {
				cacheResult(persona);
			}
			else {
				persona.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all personas.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PersonaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PersonaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persona.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Persona persona) {
		EntityCacheUtil.removeResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaImpl.class, persona.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Persona> personas) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Persona persona : personas) {
			EntityCacheUtil.removeResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
				PersonaImpl.class, persona.getPrimaryKey());
		}
	}

	/**
	 * Creates a new persona with the primary key. Does not add the persona to the database.
	 *
	 * @param userId the primary key for the new persona
	 * @return the new persona
	 */
	public Persona create(long userId) {
		Persona persona = new PersonaImpl();

		persona.setNew(true);
		persona.setPrimaryKey(userId);

		return persona;
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the persona
	 * @return the persona that was removed
	 * @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Persona remove(long userId)
		throws NoSuchPersonaException, SystemException {
		return remove(Long.valueOf(userId));
	}

	/**
	 * Removes the persona with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona that was removed
	 * @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Persona remove(Serializable primaryKey)
		throws NoSuchPersonaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Persona persona = (Persona)session.get(PersonaImpl.class, primaryKey);

			if (persona == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersonaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(persona);
		}
		catch (NoSuchPersonaException nsee) {
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
	protected Persona removeImpl(Persona persona) throws SystemException {
		persona = toUnwrappedModel(persona);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, persona);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(persona);

		return persona;
	}

	@Override
	public Persona updateImpl(com.ext.portlet.pin.model.Persona persona,
		boolean merge) throws SystemException {
		persona = toUnwrappedModel(persona);

		boolean isNew = persona.isNew();

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, persona, merge);

			persona.setNew(false);
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

		EntityCacheUtil.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
			PersonaImpl.class, persona.getPrimaryKey(), persona);

		return persona;
	}

	protected Persona toUnwrappedModel(Persona persona) {
		if (persona instanceof PersonaImpl) {
			return persona;
		}

		PersonaImpl personaImpl = new PersonaImpl();

		personaImpl.setNew(persona.isNew());
		personaImpl.setPrimaryKey(persona.getPrimaryKey());

		personaImpl.setUserId(persona.getUserId());
		personaImpl.setNombres(persona.getNombres());
		personaImpl.setApellidoPaterno(persona.getApellidoPaterno());
		personaImpl.setApellidoMaterno(persona.getApellidoMaterno());
		personaImpl.setDni(persona.getDni());
		personaImpl.setTipoDocumento(persona.getTipoDocumento());

		return personaImpl;
	}

	/**
	 * Returns the persona with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona
	 * @throws com.liferay.portal.NoSuchModelException if a persona with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Persona findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the persona with the primary key or throws a {@link com.ext.portlet.pin.NoSuchPersonaException} if it could not be found.
	 *
	 * @param userId the primary key of the persona
	 * @return the persona
	 * @throws com.ext.portlet.pin.NoSuchPersonaException if a persona with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Persona findByPrimaryKey(long userId)
		throws NoSuchPersonaException, SystemException {
		Persona persona = fetchByPrimaryKey(userId);

		if (persona == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + userId);
			}

			throw new NoSuchPersonaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				userId);
		}

		return persona;
	}

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Persona fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the persona with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the persona
	 * @return the persona, or <code>null</code> if a persona with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Persona fetchByPrimaryKey(long userId) throws SystemException {
		Persona persona = (Persona)EntityCacheUtil.getResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
				PersonaImpl.class, userId);

		if (persona == _nullPersona) {
			return null;
		}

		if (persona == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				persona = (Persona)session.get(PersonaImpl.class,
						Long.valueOf(userId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (persona != null) {
					cacheResult(persona);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(PersonaModelImpl.ENTITY_CACHE_ENABLED,
						PersonaImpl.class, userId, _nullPersona);
				}

				closeSession(session);
			}
		}

		return persona;
	}

	/**
	 * Returns all the personas.
	 *
	 * @return the personas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Persona> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @return the range of personas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Persona> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the personas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of personas
	 * @param end the upper bound of the range of personas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of personas
	 * @throws SystemException if a system exception occurred
	 */
	public List<Persona> findAll(int start, int end,
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

		List<Persona> list = (List<Persona>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PERSONA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSONA;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Persona>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Persona>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the personas from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Persona persona : findAll()) {
			remove(persona);
		}
	}

	/**
	 * Returns the number of personas.
	 *
	 * @return the number of personas
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSONA);

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
	 * Initializes the persona persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ext.portlet.pin.model.Persona")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Persona>> listenersList = new ArrayList<ModelListener<Persona>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Persona>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PersonaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CategoriaPersistence.class)
	protected CategoriaPersistence categoriaPersistence;
	@BeanReference(type = PersonaPersistence.class)
	protected PersonaPersistence personaPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_PERSONA = "SELECT persona FROM Persona persona";
	private static final String _SQL_COUNT_PERSONA = "SELECT COUNT(persona) FROM Persona persona";
	private static final String _ORDER_BY_ENTITY_ALIAS = "persona.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Persona exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PersonaPersistenceImpl.class);
	private static Persona _nullPersona = new PersonaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Persona> toCacheModel() {
				return _nullPersonaCacheModel;
			}
		};

	private static CacheModel<Persona> _nullPersonaCacheModel = new CacheModel<Persona>() {
			public Persona toEntityModel() {
				return _nullPersona;
			}
		};
}