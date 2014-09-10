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

import java.util.ArrayList;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaPerfilador;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.ext.portlet.halcon.model.ConfiguracionProducto;
import com.ext.portlet.halcon.model.impl.AuditoriaPerfiladorImpl;
import com.ext.portlet.halcon.model.impl.ConfiguracionProductoImpl;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.ConfiguracionProductoLocalServiceUtil;
import com.ext.portlet.halcon.service.base.ConfiguracionProductoLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the configuracion producto local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.ConfiguracionProductoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.ConfiguracionProductoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.ConfiguracionProductoLocalServiceUtil
 */
public class ConfiguracionProductoLocalServiceImpl extends
		ConfiguracionProductoLocalServiceBaseImpl {
	
	

	private static final String nameClase = ConfiguracionProductoLocalServiceImpl.class.getName() ;
	
	private static Log _log = LogFactoryUtil.getLog(ConfiguracionProductoLocalServiceImpl.class);
	
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.ConfiguracionProductoLocalServiceUtil} to access the
	 * configuracion producto local service.
	 */

	public List<ConfiguracionProducto> obtenerProductoConfiguracionPerfilador(
			Long idConfiguracionPerfilador) throws BusinessException{

		List<ConfiguracionProducto> listaProductos = new ArrayList<ConfiguracionProducto>();

		try {
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(
					ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaConfiguracionProducto = DynamicQueryFactoryUtil.forClass(
					ConfiguracionProducto.class, classLoader);
			consultaConfiguracionProducto.add(
					PropertyFactoryUtil.forName("idConfiguracionPerfilador").eq(
							idConfiguracionPerfilador)).add(
					PropertyFactoryUtil.forName("estadoConfiguracion").eq(1));

			listaProductos = ConfiguracionProductoLocalServiceUtil
					.dynamicQuery(consultaConfiguracionProducto);

		} catch (SystemException e) {
			//throw new BusinessException(nameClase+" - obtenerProductoConfiguracionPerfilador",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.configuracion.producto.obtenerCorrelativoConfiguracionPerfilador") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.configuracion.producto ", "capa.halcon.configuracion.producto.obtenerCorrelativoConfiguracionPerfilador") , e.toString());
		}

		return listaProductos;
	}
	
	public ConfiguracionProducto insert(ConfiguracionProducto configuracionProducto) throws BusinessException{
		try {
			return configuracionProductoPersistence.update(configuracionProducto, false);
		} catch (SystemException e) {
			throw new BusinessException(nameClase+" - insert",e.toString());
		}
	}
	
	public ConfiguracionProducto update(ConfiguracionProducto configuracionProducto) throws BusinessException{
		try {
			ConfiguracionProducto c = configuracionProductoPersistence.findByPrimaryKey(configuracionProducto.getIdConfiguracionProducto());
			c.setEstadoConfiguracion(configuracionProducto.getEstadoConfiguracion());
			
			return configuracionProductoPersistence.update(c, false);
		} catch (Exception e) {
			throw new BusinessException(nameClase+" - update",e.toString());
		}
	}
	
	public ConfiguracionProducto getInstance() {
		return new ConfiguracionProductoImpl();
	}

}