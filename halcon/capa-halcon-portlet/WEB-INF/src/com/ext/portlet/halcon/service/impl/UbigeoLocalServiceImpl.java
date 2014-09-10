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

package com.ext.portlet.halcon.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Ubigeo;
import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.UbigeoLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

/**
 * The implementation of the ubigeo local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.UbigeoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.UbigeoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.UbigeoLocalServiceUtil
 */
public class UbigeoLocalServiceImpl extends UbigeoLocalServiceBaseImpl {
	
	private static final String nameClase = UbigeoLocalServiceImpl.class.getName() ;
	
	
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.UbigeoLocalServiceUtil} to access the ubigeo local service.
	 */

	public Ubigeo obtenerUbigeoPorCodigo(String codigo) throws BusinessException {
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaUbigeo = DynamicQueryFactoryUtil.forClass(Ubigeo.class, classLoader).add(PropertyFactoryUtil.forName("codigo").eq(codigo));
		
		consultaUbigeo.addOrder( OrderFactoryUtil.asc("nombre"));
		
		try {
			List<Ubigeo> ubigeos = CargaTiendaLocalServiceUtil.dynamicQuery(consultaUbigeo);
			if (ubigeos != null && ubigeos.size() > 0) {
				return ubigeos.get(0);
			}
		} catch (Exception e) {
			throw new BusinessException(nameClase+" - obtenerUbigeoPorCodigo",e.toString());
		}
		return null;
	}

	public List<Ubigeo> obtenerUbigeoPorCodigos(String[] ubigeos) throws BusinessException {
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaUbigeo = DynamicQueryFactoryUtil.forClass(Ubigeo.class, classLoader).add(PropertyFactoryUtil.forName("codigo").in(ubigeos));
		try {
			List<Ubigeo> u = CargaTiendaLocalServiceUtil.dynamicQuery(consultaUbigeo);
			return u;
		} catch (Exception e) {
			throw new BusinessException(nameClase+" - obtenerUbigeoPorCodigos",e.toString());
		}
	}

	public Map<String, Object> obtenerUbigeoPorCodigos() throws BusinessException {
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaUbigeo = DynamicQueryFactoryUtil.forClass(Ubigeo.class, classLoader);
		try {
			List<Ubigeo> u = CargaTiendaLocalServiceUtil.dynamicQuery(consultaUbigeo);
			Map<String, Object> lstObjects = new HashMap<String, Object>();
			for (int i = 0; i < u.size(); i++) {
				Ubigeo ub = u.get(i);
				lstObjects.put(ub.getCodigo(), true);
			}
			return lstObjects;
		} catch (Exception e) {
			throw new BusinessException(nameClase+" - obtenerUbigeoPorCodigos",e.toString());
		}
	}

	public List<Ubigeo> obtenerDepartamentos() throws BusinessException {
		return ubigeoFinder.obtenerDepartamentos();
	}

	public List<Ubigeo> obtenerProvincias() throws BusinessException {
		return ubigeoFinder.obtenerProvincias();
	}

	public List<Ubigeo> obtenerDistritos() throws BusinessException {
		return ubigeoFinder.obtenerDistritos();
	}

	public List<Ubigeo> obtenerDistritosLima(String codigos) throws BusinessException {
		return ubigeoFinder.obtenerDistritosLima(codigos);
	}
}
