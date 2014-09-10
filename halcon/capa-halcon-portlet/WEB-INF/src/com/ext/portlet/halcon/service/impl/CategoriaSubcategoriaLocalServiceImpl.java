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

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CategoriaSubcategoria;
import com.ext.portlet.halcon.service.base.CategoriaSubcategoriaLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the categoria subcategoria local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.CategoriaSubcategoriaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalServiceUtil
 */
public class CategoriaSubcategoriaLocalServiceImpl
	extends CategoriaSubcategoriaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalServiceUtil} to access the categoria subcategoria local service.
	 */
private static Log _log = LogFactoryUtil.getLog(CategoriaSubcategoriaLocalServiceImpl.class);
	
	public int insertar(Integer idCategoriaSubCatPadre,String descripcion) throws BusinessException{    	
		return categoriaSubcategoriaFinder.insertar(idCategoriaSubCatPadre, descripcion);
	}
}