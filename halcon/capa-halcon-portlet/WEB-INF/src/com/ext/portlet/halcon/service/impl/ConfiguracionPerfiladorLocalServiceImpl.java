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

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.ConfiguracionPerfilador;
import com.ext.portlet.halcon.model.impl.ConfiguracionPerfiladorImpl;
import com.ext.portlet.halcon.service.base.ConfiguracionPerfiladorLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the configuracion perfilador local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.ConfiguracionPerfiladorLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil
 */
public class ConfiguracionPerfiladorLocalServiceImpl
	extends ConfiguracionPerfiladorLocalServiceBaseImpl {
	
	
	private static final String nameClase = ConfiguracionPerfiladorLocalServiceImpl.class.getName() ;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil} to access the configuracion perfilador local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(ConfiguracionPerfiladorLocalServiceImpl.class);
	
	public Long obtenerRangoValorConfiguracionPerfilador(Long idConfiguracionPerfiladorPadre, Long valor) throws BusinessException{
		return configuracionPerfiladorFinder.obtenerRangoValor(idConfiguracionPerfiladorPadre, valor);
	}
	
	public Long obtenerCorrelativoConfiguracionPerfilador() throws BusinessException{
		try {
			return counterLocalService.increment( ConfiguracionPerfilador.class.toString());
		} catch (SystemException e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.configuracion.perfilador.obtenercorrelativoconfiguracionperfilador") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.configuracion.perfilador ", "capa.halcon.configuracion.perfilador.obtenercorrelativoconfiguracionperfilador") , e.toString());
		}
	}
	
	public ConfiguracionPerfilador getInstance() {
		return new ConfiguracionPerfiladorImpl();
	}
	
	public ConfiguracionPerfilador insert(ConfiguracionPerfilador configuracionPerfilador) throws BusinessException{
		try {
			return configuracionPerfiladorPersistence.update(configuracionPerfilador, false);
		} catch (SystemException e) {
			//throw new BusinessException(nameClase+" - insert",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.configuracion.perfilador.insert") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.configuracion.perfilador", "capa.halcon.configuracion.perfilador.insert") , e.toString());
		}
	}
	
	public ConfiguracionPerfilador update(ConfiguracionPerfilador configuracionPerfilador) throws BusinessException{
		try {
			ConfiguracionPerfilador c=configuracionPerfiladorPersistence.findByPrimaryKey(configuracionPerfilador.getIdConfiguracionPerfilador());
			c.setNombreVariable(configuracionPerfilador.getNombreVariable());
			c.setEstado(configuracionPerfilador.getEstado());
			c.setCodigoClasificacion(configuracionPerfilador.getCodigoClasificacion());
			c.setValor1(configuracionPerfilador.getValor1());
			c.setValor2(configuracionPerfilador.getValor2());
			c.setValor3(configuracionPerfilador.getValor3());
			
			return configuracionPerfiladorPersistence.update(c, false);
		} catch (Exception e) {
			//throw new BusinessException(nameClase+" - insert",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.configuracion.perfilador.update") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.configuracion.perfilador", "capa.halcon.configuracion.perfilador.update") , e.toString());
		}
	}
	
}