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

package com.ext.portlet.pin.service.base;

import com.ext.portlet.pin.model.Categoria;
import com.ext.portlet.pin.service.CategoriaLocalService;
import com.ext.portlet.pin.service.CategoriaService;
import com.ext.portlet.pin.service.PersonaLocalService;
import com.ext.portlet.pin.service.PersonaService;
import com.ext.portlet.pin.service.persistence.CategoriaPersistence;
import com.ext.portlet.pin.service.persistence.PersonaPersistence;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the categoria local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ext.portlet.pin.service.impl.CategoriaLocalServiceImpl}.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.pin.service.impl.CategoriaLocalServiceImpl
 * @see com.ext.portlet.pin.service.CategoriaLocalServiceUtil
 * @generated
 */
public abstract class CategoriaLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CategoriaLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.ext.portlet.pin.service.CategoriaLocalServiceUtil} to access the categoria local service.
	 */

	/**
	 * Adds the categoria to the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoria the categoria
	 * @return the categoria that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Categoria addCategoria(Categoria categoria)
		throws SystemException {
		categoria.setNew(true);

		return categoriaPersistence.update(categoria, false);
	}

	/**
	 * Creates a new categoria with the primary key. Does not add the categoria to the database.
	 *
	 * @param categoriaId the primary key for the new categoria
	 * @return the new categoria
	 */
	public Categoria createCategoria(long categoriaId) {
		return categoriaPersistence.create(categoriaId);
	}

	/**
	 * Deletes the categoria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoriaId the primary key of the categoria
	 * @return the categoria that was removed
	 * @throws PortalException if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Categoria deleteCategoria(long categoriaId)
		throws PortalException, SystemException {
		return categoriaPersistence.remove(categoriaId);
	}

	/**
	 * Deletes the categoria from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoria the categoria
	 * @return the categoria that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public Categoria deleteCategoria(Categoria categoria)
		throws SystemException {
		return categoriaPersistence.remove(categoria);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Categoria.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return categoriaPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return categoriaPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return categoriaPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return categoriaPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public Categoria fetchCategoria(long categoriaId) throws SystemException {
		return categoriaPersistence.fetchByPrimaryKey(categoriaId);
	}

	/**
	 * Returns the categoria with the primary key.
	 *
	 * @param categoriaId the primary key of the categoria
	 * @return the categoria
	 * @throws PortalException if a categoria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Categoria getCategoria(long categoriaId)
		throws PortalException, SystemException {
		return categoriaPersistence.findByPrimaryKey(categoriaId);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return categoriaPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the categorias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of categorias
	 * @param end the upper bound of the range of categorias (not inclusive)
	 * @return the range of categorias
	 * @throws SystemException if a system exception occurred
	 */
	public List<Categoria> getCategorias(int start, int end)
		throws SystemException {
		return categoriaPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of categorias.
	 *
	 * @return the number of categorias
	 * @throws SystemException if a system exception occurred
	 */
	public int getCategoriasCount() throws SystemException {
		return categoriaPersistence.countAll();
	}

	/**
	 * Updates the categoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoria the categoria
	 * @return the categoria that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Categoria updateCategoria(Categoria categoria)
		throws SystemException {
		return updateCategoria(categoria, true);
	}

	/**
	 * Updates the categoria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param categoria the categoria
	 * @param merge whether to merge the categoria with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the categoria that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Categoria updateCategoria(Categoria categoria, boolean merge)
		throws SystemException {
		categoria.setNew(false);

		return categoriaPersistence.update(categoria, merge);
	}

	/**
	 * Returns the categoria local service.
	 *
	 * @return the categoria local service
	 */
	public CategoriaLocalService getCategoriaLocalService() {
		return categoriaLocalService;
	}

	/**
	 * Sets the categoria local service.
	 *
	 * @param categoriaLocalService the categoria local service
	 */
	public void setCategoriaLocalService(
		CategoriaLocalService categoriaLocalService) {
		this.categoriaLocalService = categoriaLocalService;
	}

	/**
	 * Returns the categoria remote service.
	 *
	 * @return the categoria remote service
	 */
	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	/**
	 * Sets the categoria remote service.
	 *
	 * @param categoriaService the categoria remote service
	 */
	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	/**
	 * Returns the categoria persistence.
	 *
	 * @return the categoria persistence
	 */
	public CategoriaPersistence getCategoriaPersistence() {
		return categoriaPersistence;
	}

	/**
	 * Sets the categoria persistence.
	 *
	 * @param categoriaPersistence the categoria persistence
	 */
	public void setCategoriaPersistence(
		CategoriaPersistence categoriaPersistence) {
		this.categoriaPersistence = categoriaPersistence;
	}

	/**
	 * Returns the persona local service.
	 *
	 * @return the persona local service
	 */
	public PersonaLocalService getPersonaLocalService() {
		return personaLocalService;
	}

	/**
	 * Sets the persona local service.
	 *
	 * @param personaLocalService the persona local service
	 */
	public void setPersonaLocalService(PersonaLocalService personaLocalService) {
		this.personaLocalService = personaLocalService;
	}

	/**
	 * Returns the persona remote service.
	 *
	 * @return the persona remote service
	 */
	public PersonaService getPersonaService() {
		return personaService;
	}

	/**
	 * Sets the persona remote service.
	 *
	 * @param personaService the persona remote service
	 */
	public void setPersonaService(PersonaService personaService) {
		this.personaService = personaService;
	}

	/**
	 * Returns the persona persistence.
	 *
	 * @return the persona persistence
	 */
	public PersonaPersistence getPersonaPersistence() {
		return personaPersistence;
	}

	/**
	 * Sets the persona persistence.
	 *
	 * @param personaPersistence the persona persistence
	 */
	public void setPersonaPersistence(PersonaPersistence personaPersistence) {
		this.personaPersistence = personaPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		PersistedModelLocalServiceRegistryUtil.register("com.ext.portlet.pin.model.Categoria",
			categoriaLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.ext.portlet.pin.model.Categoria");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
	}

	protected Class<?> getModelClass() {
		return Categoria.class;
	}

	protected String getModelClassName() {
		return Categoria.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = categoriaPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CategoriaLocalService.class)
	protected CategoriaLocalService categoriaLocalService;
	@BeanReference(type = CategoriaService.class)
	protected CategoriaService categoriaService;
	@BeanReference(type = CategoriaPersistence.class)
	protected CategoriaPersistence categoriaPersistence;
	@BeanReference(type = PersonaLocalService.class)
	protected PersonaLocalService personaLocalService;
	@BeanReference(type = PersonaService.class)
	protected PersonaService personaService;
	@BeanReference(type = PersonaPersistence.class)
	protected PersonaPersistence personaPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private CategoriaLocalServiceClpInvoker _clpInvoker = new CategoriaLocalServiceClpInvoker();
}