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

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.impl.ParametroImpl;
import com.ext.portlet.halcon.service.base.ParametroLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the parametro local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.ParametroLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.ParametroLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.ParametroLocalServiceUtil
 */
public class ParametroLocalServiceImpl extends ParametroLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.ParametroLocalServiceUtil} to access the parametro local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(ParametroLocalServiceImpl.class);
	
	public List<Parametro> listarParametro() throws BusinessException {
		return parametroFinder.listarParametro();
	}
	
	public Parametro obtenerParametroPadre(java.lang.Integer idParametro)  throws BusinessException {
		return parametroFinder.obtenerParametroPadre(idParametro);
	}
	
	public List<Parametro> obtenerParametrosHijos(java.lang.Integer idParametro) throws BusinessException {
		return  parametroFinder.obtenerParametrosHijos(idParametro);
	}
	
	public List<Parametro> obtenerParametrosHijos(String etiqueta) throws BusinessException {
		return  parametroFinder.obtenerParametrosHijos(etiqueta);
	}
	
	public List<Parametro> obtenerParametrosPorTipo(java.lang.Integer id) throws BusinessException {
		return parametroFinder.obtenerParametrosPorTipo(id);
	}
	
	public List<Parametro> obtenerParametrosPorDescripcion(java.lang.String descripcion)throws BusinessException  {
		return  parametroFinder.obtenerParametrosPorDescripcion(descripcion);
	}
	
	public List<Parametro> obtenerParametrosPorDescripcion(java.lang.String descripcionParametro, java.lang.String descripcionParametroPadre) throws BusinessException {
	return parametroFinder.obtenerParametrosPorDescripcion(descripcionParametro, descripcionParametroPadre);
	}
	
	public java.lang.Integer cambiarParametroEstado(java.lang.Integer id, java.lang.Integer estado) throws BusinessException {
		return parametroFinder.cambiarParametroEstado(id, estado);
	}
	
	public List<Parametro> obtenerParametroListaPadre() throws BusinessException {
		return parametroFinder.obtenerParametroListaPadre();
	}
	
	public List<Parametro> obtenerRangoValor(Integer id)  throws Exception {
		return parametroFinder.obtenerRangoValor(id);
	}
	
	public Integer validarTipo(Integer idParametro) throws BusinessException{
		return parametroFinder.validarTipo(idParametro);
	}
	
	public List<Parametro> obtenerParametrosHijosDos(Integer idParametro) throws BusinessException {
		return parametroFinder.obtenerParametrosHijosDos(idParametro);
	}
	
	public List<Parametro> listarPadresJson(Integer idParametro)  throws BusinessException {
		return parametroFinder.listarPadresJson(idParametro);
	}
	
	public List<Parametro> listarHijosPadresJson(Integer tipoLista)  throws BusinessException {
		return parametroFinder.listarHijosPadresJson(tipoLista);
	}
	
	public int registrarCabeceraDetalle(Parametro parametroCab,Parametro parametroDet) throws BusinessException{
		return parametroFinder.registrarCabeceraDetalle(parametroCab, parametroDet);
	}
	
	public Parametro getInstance() {
		return new ParametroImpl();
	}
}