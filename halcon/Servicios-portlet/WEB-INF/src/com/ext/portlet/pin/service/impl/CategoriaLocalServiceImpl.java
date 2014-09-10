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

package com.ext.portlet.pin.service.impl;

import com.ext.portlet.pin.model.Categoria;
import com.ext.portlet.pin.service.base.CategoriaLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the categoria local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.pin.service.CategoriaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.pin.service.base.CategoriaLocalServiceBaseImpl
 * @see com.ext.portlet.pin.service.CategoriaLocalServiceUtil
 */
public class CategoriaLocalServiceImpl extends CategoriaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.pin.service.CategoriaLocalServiceUtil} to access the categoria local service.
	 */
	public Categoria insertar(long idImagen,String nombre,boolean estado,String descripcion){    	
		
		Categoria categoria=null;
		try {
			long categoriaId=counterLocalService.increment( Categoria.class.toString());
			categoria=categoriaPersistence.create(categoriaId);
			
			categoria.setIdImagen(idImagen);
			categoria.setNombre(nombre);
			categoria.setEstado(estado);
			categoria.setDescripcion(descripcion);
			
			categoria=categoriaPersistence.update(categoria,false);
			
			
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categoria;
	}
}