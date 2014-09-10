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
import com.ext.portlet.halcon.model.Pais;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.PaisLocalServiceUtil;
import com.ext.portlet.halcon.service.base.PaisLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the pais local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.PaisLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.PaisLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.PaisLocalServiceUtil
 */
public class PaisLocalServiceImpl extends PaisLocalServiceBaseImpl {
	

	private static final String nameClase = PaisLocalServiceImpl.class.getName() ;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.PaisLocalServiceUtil} to access the pais local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(PaisLocalServiceImpl.class);
	/**
	 * busqueda de pais segun su codigo
	 */
	public Pais obtenerPaisPorCodigo(String codigo)throws BusinessException {
//		_log.info(" ingreso al metodo obtenerPaisPorCodigo codigo:"+codigo);
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaPais = DynamicQueryFactoryUtil.forClass(Pais.class, classLoader)
			    .add(PropertyFactoryUtil.forName("codigo").eq(codigo));
		try {
			@SuppressWarnings("unchecked")
			List<Pais> paises = PaisLocalServiceUtil.dynamicQuery(consultaPais);
			if( paises!=null&& paises.size() >0){
				_log.info(" pais buscado :"+paises.get(0).getNombre());
				return paises.get(0);
			}		
		} catch (Exception e) {
			throw new BusinessException(nameClase+" - obtenerPaisPorCodigo",e.toString());
		}
		return null;		
	}
	
	public Map<String, Object> obtenerListaPaises()throws BusinessException {
		Map<String, Object> lst = new HashMap<String, Object>();
					
			List<Pais> paises = paisFinder.obtenerPais();
			for (int i = 0; i < paises.size() ; i++) {
				lst.put(paises.get(i).getCodigo(), true);
			}	
						
		
		return lst;
	}
	
	public List<Pais> obtenerPaises(String codigos) throws BusinessException {
		return paisFinder.obtenerPaises(codigos);
	}
	
	
	public List<Pais> obtenerPais() throws BusinessException{
		return paisFinder.obtenerPais();
	}
	
	
}