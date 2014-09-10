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
import com.ext.portlet.halcon.model.ProductoComplementario;
import com.ext.portlet.halcon.model.impl.ProductoComplementarioImpl;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.ProductoComplementarioLocalServiceUtil;
import com.ext.portlet.halcon.service.base.ProductoComplementarioLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the producto complementario local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.ProductoComplementarioLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see com.ext.portlet.halcon.service.base.ProductoComplementarioLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.ProductoComplementarioLocalServiceUtil
 */
public class ProductoComplementarioLocalServiceImpl
	extends ProductoComplementarioLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(ProductoComplementarioLocalServiceImpl.class);
	
	private static final String nameClase = ProductoComplementarioLocalServiceImpl.class.getName() ;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.ProductoComplementarioLocalServiceUtil} to access the producto complementario local service.
	 */
	
	public List<ProductoComplementario> obtenerProductosCOmplementarioDistinct() throws BusinessException {		
		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaProductoComplementario = DynamicQueryFactoryUtil.forClass(ProductoComplementario.class, classLoader);		
		DynamicQuery consultaProductoComplementarioDict = consultaProductoComplementario.setProjection(ProjectionFactoryUtil.distinct(PropertyFactoryUtil.forName("idProductoComplementario")));
		try {
			
//			List<ProductoComplementario > l =ProductoComplementarioLocalServiceUtil.dynamicQuery(consultaProductoComplementarioDict);
			List<ProductoComplementario > l = solicitudProductoFinder.obtenerLstProductosComplementariosDistinc();
			//List<ProductoComplementario > l = consultaProductoComplementario.list(); 
			if(l!=null){
				return l;
			}
		} catch (Exception e) {
			//_log.error("Error e:"+e.getLocalizedMessage() + " e: "+e.getMessage()  );
//			throw new BusinessException(nameClase+" - obtenerProductosCOmplementarioDistinct",e.toString());
			//e.printStackTrace();
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.producto.complementario.obtenerproductoscomplementariodistinct") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.producto.complementario", "capa.halcon.producto.complementario.obtenerproductoscomplementariodistinct") , e.toString());
		}		
//		List<ProductoComplementario > l1 = new ArrayList<ProductoComplementario>();
//		ProductoComplementario pc1 = newInstance();
//		pc1.setIdProductoComplementario(1);
//		pc1.setIdSolicitudProducto(1);
//		pc1.setIdProducto("1");
//		pc1.setProducto("pro1");
//		l1.add(pc1);
//		
//		ProductoComplementario pc2 = newInstance();
//		pc2.setIdProductoComplementario(2);
//		pc2.setIdSolicitudProducto(2);
//		pc2.setIdProducto("2");
//		pc2.setProducto("pro2");
//		l1.add(pc2);
//
//		ProductoComplementario pc3 = newInstance();
//		pc3.setIdProductoComplementario(3);
//		pc3.setIdSolicitudProducto(3);
//		pc3.setIdProducto("3");
//		pc3.setProducto("pro3");
//		l1.add(pc3);
//		
//		return l1;		
		return null;
	}
	
	
	public ProductoComplementario newInstance(){
		return new ProductoComplementarioImpl();
	}
	
	
}