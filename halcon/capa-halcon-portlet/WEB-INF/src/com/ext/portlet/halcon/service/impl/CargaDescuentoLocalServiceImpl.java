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
import com.ext.portlet.halcon.model.CargaDescuento;
import com.ext.portlet.halcon.model.impl.CargaDescuentoImpl;
import com.ext.portlet.halcon.service.CargaDescuentoLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.CargaDescuentoLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the carga descuento local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.CargaDescuentoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.CargaDescuentoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.CargaDescuentoLocalServiceUtil
 */
public class CargaDescuentoLocalServiceImpl extends CargaDescuentoLocalServiceBaseImpl {
	
	
	private static final String nameClase = CargaDescuentoLocalServiceImpl.class.getName() ;
	
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.CargaDescuentoLocalServiceUtil} to access
	 * the carga descuento local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(CargaDescuentoLocalServiceImpl.class);
	/**
	 * inserta nueva entidad de cargaDescuento
	 */
	public Boolean insert(List<CargaDescuento> lst) throws BusinessException{
		return cargaDescuentoFinder.insertCargaDescuentos(lst);

	}

	/**
	 * se obtiene la lista de descuentos la cantidad de filas la pagina la cual se encuentra
	 * @throws BusinessException 
	 */
	public List<CargaDescuento> obtenerUbicacionMapaDescuentos(String buscar, String distrito, Integer categoria, int pagina, int filas) throws BusinessException {
		
		_log.info(" obtenerUbicacionMapaDescuentos datos ingresados[ buscar :" + buscar + ", distrito: " + distrito + ", categoria: " + categoria + ", pagina : " + pagina + ", filas : " + filas + "]");
		
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaCargaTienda = DynamicQueryFactoryUtil.forClass(CargaDescuento.class, classLoader);
		
		if(!buscar.equals("")&&buscar.length()>0){
			consultaCargaTienda.add(PropertyFactoryUtil.forName("local").like("%" + buscar + "%"));			
		}
		if(distrito!=null && distrito.length()>0){
			consultaCargaTienda.add(PropertyFactoryUtil.forName("idDistrito").eq(distrito));			
		}
		if(categoria!=null && categoria>0){
			consultaCargaTienda.add(PropertyFactoryUtil.forName("categoria").eq(String.valueOf(categoria)));			
		}		
		consultaCargaTienda.add(PropertyFactoryUtil.forName("latitud").isNotNull());
		consultaCargaTienda.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("latitud").eq("")));
		consultaCargaTienda.add(PropertyFactoryUtil.forName("longitud").isNotNull());
		consultaCargaTienda.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("longitud").eq("")));
		try {
			int init = (filas * pagina - filas);
			int fin = init + filas;
			@SuppressWarnings("unchecked")
			List<CargaDescuento> lstDescuento = CargaDescuentoLocalServiceUtil.dynamicQuery(consultaCargaTienda, init, fin);
			_log.info(" select  obtenerUbicacionMapaDescuentos stDescuento.size() :" + lstDescuento.size());
			return lstDescuento;
		} catch (Exception e) {
//			_log.error(" error al select  obtenerUbicacionMapaDescuentos : " + e.getMessage());
//			throw new BusinessException(nameClase+" - obtenerUbicacionMapaDescuentos",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.descuento.obtenerubicacionmapadescuentos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.descuento", "capa.halcon.carga.descuento.obtenerubicacionmapadescuentos") , e.toString());
		}
	}
	/**
	 * se la cantidad de registros en total
	 * la cantidad de filas 
	 * la pagina la cual se encuentra
	 * @throws BusinessException 
	 */
	public Long obtenerUbicacionMapaCargaDescuentosCount(String buscar, String distrito, Integer categoria, int pagina, int filas) throws BusinessException {

		try {
			_log.info(" obtenerUbicacionMapaCargaDescuentosCount datos ingresados[ buscar :" + buscar + ", distrito: " + distrito + ", categoria: " + categoria + ", pagina : " + pagina + ", filas : " + filas + "]");
			
			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaCargaDescuento = DynamicQueryFactoryUtil.forClass(CargaDescuento.class, classLoader);
		
			if(!buscar.equals("")&&buscar.length()>0){
				consultaCargaDescuento.add(PropertyFactoryUtil.forName("local").like("%" + buscar + "%"));			
			}
			
			if(distrito!=null && distrito.length()>0){
				consultaCargaDescuento.add(PropertyFactoryUtil.forName("idDistrito").eq(String.valueOf(distrito)));			
			}
			
			if(categoria!=null && categoria>0){
				consultaCargaDescuento.add(PropertyFactoryUtil.forName("categoria").eq(String.valueOf(categoria)));			
			}
			
			consultaCargaDescuento.add(PropertyFactoryUtil.forName("latitud").isNotNull());
			consultaCargaDescuento.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("latitud").eq("")));
			consultaCargaDescuento.add(PropertyFactoryUtil.forName("longitud").isNotNull());
			consultaCargaDescuento.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("longitud").eq("")));
			
			Long count = CargaDescuentoLocalServiceUtil.dynamicQueryCount(consultaCargaDescuento);

			_log.info(" select  obtenerUbicacionMapaCargaDescuentosCount count :"+ count );
			return count;
		} catch (Exception e) {
//			_log.error(" error al obtenerUbicacionMapaCargaDescuentosCount : "+e.getMessage());
//			throw new BusinessException(nameClase+" - obtenerUbicacionMapaCargaDescuentosCount",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.descuento.obtenerubicacionmapacargadescuentoscount") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.descuento", "capa.halcon.carga.descuento.obtenerubicacionmapacargadescuentoscount") , e.toString());
		}
	}
	
	
	public int truncateCargaDescuento() throws BusinessException{
		return cargaDescuentoFinder.truncate();				
	}

	
	public CargaDescuento getInstace(){
		return new CargaDescuentoImpl();
	}
	

}
