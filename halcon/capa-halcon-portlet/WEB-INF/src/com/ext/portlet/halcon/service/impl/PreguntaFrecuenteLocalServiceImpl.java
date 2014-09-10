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
import com.ext.portlet.halcon.model.PreguntaFrecuente;
import com.ext.portlet.halcon.service.base.PreguntaFrecuenteLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the pregunta frecuente local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.PreguntaFrecuenteLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.PreguntaFrecuenteLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.PreguntaFrecuenteLocalServiceUtil
 */
public class PreguntaFrecuenteLocalServiceImpl
	extends PreguntaFrecuenteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.PreguntaFrecuenteLocalServiceUtil} to access the pregunta frecuente local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(PreguntaFrecuenteLocalServiceImpl.class);
	
	private static final String nameClase = PreguntaFrecuenteLocalServiceImpl.class.getName() ;
	
	public PreguntaFrecuente insertar(int idCategoriaSubCat,String enunciado,String respuesta,boolean estado,String etiqueta) throws BusinessException {    	
		
		PreguntaFrecuente pregunta=null;
		
		try {
			/*Se obtiene el ID autoincremente del SQL server con la Clase Counter*/
			long preguntaId=counterLocalService.increment( PreguntaFrecuente.class.toString());
			_log.info("Pregunta id Long:"+preguntaId);
			_log.info("Pregunta id int:"+new Long(preguntaId).intValue());
			pregunta=preguntaFrecuentePersistence.create(new Long(preguntaId).intValue());
			
			/*Setear todos los valores*/
			pregunta.setIdCategoriaSubCat(idCategoriaSubCat);
			pregunta.setEnunciado(enunciado);
			pregunta.setRespuesta(respuesta);
			pregunta.setEstado(estado);
			pregunta.setEtiqueta(etiqueta);
			
			pregunta=preguntaFrecuentePersistence.update(pregunta,false);
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.pregunta.frecuente.insertar") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.pregunta.frecuente", "capa.halcon.pregunta.frecuente.insertar") , e.toString());
		}
			
			
		
		
		return pregunta;
	}
}