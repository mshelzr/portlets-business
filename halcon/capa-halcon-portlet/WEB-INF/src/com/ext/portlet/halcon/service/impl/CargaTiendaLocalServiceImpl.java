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

import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaTienda;
import com.ext.portlet.halcon.model.impl.CargaTiendaImpl;
import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.CargaTiendaLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the carga tienda local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.CargaTiendaLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.CargaTiendaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil
 */
public class CargaTiendaLocalServiceImpl extends CargaTiendaLocalServiceBaseImpl {

	
	private static final String nameClase = CargaTiendaLocalServiceImpl.class.getName();

	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil} to access the
	 * carga tienda local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(CargaTiendaLocalServiceImpl.class);
	/**
	 * inserta una nueva entidad carga tienda
	 */
	public Boolean insert( List<CargaTienda> lst ) 
	throws BusinessException{		
		return cargaTiendaFinder.insert(lst);
	}

	/**
	 * se obtiene la lista de tiendas
	 * la cantidad de filas 
	 * la pagina la cual se encuentra
	 */
	@SuppressWarnings("unchecked")
	public List<CargaTienda> obtenerUbicacionMapaTiendas(int filas, int page, String[] check, String distrito) throws BusinessException{
		try {
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CargaTienda.class, classLoader)
					.add(PropertyFactoryUtil.forName("codDistrito").eq(String.valueOf(distrito)))
					.add(PropertyFactoryUtil.forName("idCanal").in(check))
					.add(PropertyFactoryUtil.forName("locacion").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("locacion").eq("")))	
					.add(PropertyFactoryUtil.forName("direccion").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("direccion").eq("")))	
					.add(PropertyFactoryUtil.forName("latitud").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("latitud").eq("")))		
					.add(PropertyFactoryUtil.forName("longitud").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("longitud").eq("")))	;
			int init = (filas * page - filas);
			int fin = init + filas;
			List<CargaTienda> lstCargaTienda = CargaTiendaLocalServiceUtil.dynamicQuery(query, init , fin );
			_log.info(" select  obtenerUbicacionMapaTiendas lstCargaTienda.size() :"+ lstCargaTienda.size() );
			return lstCargaTienda;
		} catch (Exception e) {
//			_log.error(" error al select  obtenerUbicacionMapaTiendas : "+e.getMessage());
//			throw new BusinessException(nameClase+" - obtenerUbicacionMapaTiendas",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.tienda.obtenerubicacionmapatiendas") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.tienda", "capa.halcon.carga.tienda.obtenerubicacionmapatiendas") , e.toString());
		}
	}

	/**
	 * se la cantidad de registros en total
	 * la cantidad de filas 
	 * la pagina la cual se encuentra
	 */
	public Long obtenerUbicacionMapaTiendasCount(int filas, int page, String[] check, String distrito) throws BusinessException{
		try {
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(CargaTienda.class, classLoader)
					.add(PropertyFactoryUtil.forName("codDistrito").eq(String.valueOf(distrito)))
					.add(PropertyFactoryUtil.forName("idCanal").in(check))
					.add(PropertyFactoryUtil.forName("locacion").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("locacion").eq("")))	
					.add(PropertyFactoryUtil.forName("direccion").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("direccion").eq("")))	
					.add(PropertyFactoryUtil.forName("latitud").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("latitud").eq("")))		
					.add(PropertyFactoryUtil.forName("longitud").isNotNull())
					.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("longitud").eq("")))	;
			long count = CargaTiendaLocalServiceUtil.dynamicQueryCount(query);
			_log.info(" select  obtenerUbicacionMapaTiendasCount count :"+ count );
			return count;
		} catch (Exception e) {
//			_log.error(" error al obtenerUbicacionMapaCargaDescuentosCount : "+e.getMessage());
//			throw new BusinessException(nameClase+" - obtenerUbicacionMapaTiendasCount",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.tienda.obtenerubicacionmapatiendascount") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.tienda", "capa.halcon.CargaSocioRemesaLocalServiceImpl.obtenerubicacionmapatiendascount") , e.toString());
		}
	}

	public int truncateCargaTienda() 
	throws BusinessException{
		try {
			//cargaTiendaPersistence.removeAll();
			cargaTiendaFinder.truncate();
			return 1;
		} catch (Exception e) {
			//throw new BusinessException(nameClase+" - truncateCargaTienda",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.tienda.truncateCargaTienda") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.tienda", "capa.halcon.carga.tienda.truncateCargaTienda") , e.toString());
		}
	}
	
	
	public CargaTienda getInstace(){
		return new CargaTiendaImpl();
	}
	

}