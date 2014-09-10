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

import java.util.Date;
import java.util.List;


import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.FondosMutuos;
import com.ext.portlet.halcon.model.FondosMutuosZonas;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.impl.FondosMutuosImpl;
import com.ext.portlet.halcon.service.base.FondosMutuosLocalServiceBaseImpl;

/**
 * The implementation of the fondos mutuos local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.FondosMutuosLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see com.ext.portlet.halcon.service.base.FondosMutuosLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.FondosMutuosLocalServiceUtil
 */
public class FondosMutuosLocalServiceImpl
	extends FondosMutuosLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.FondosMutuosLocalServiceUtil} to access the fondos mutuos local service.
	 */
	public Parametro obtenerFondoMutuoZona(Integer puntaje, String moneda, String etiqueta)  throws BusinessException{
		return fondosMutuosFinder.obtenerFondoMutuoZona(puntaje, moneda, etiqueta);
	}
	
	public List<Parametro> ListarPlazozFondoMutuo(String valor)  throws BusinessException {
		return fondosMutuosFinder.listarPlazozFondoMutuo(valor);
	}
	
	public List<FondosMutuos> ListarFondoMutuo(String moneda,  List<String> fechas, String tipoFondo)  throws BusinessException {
		return fondosMutuosFinder.listarFondoMutuo(moneda, fechas, tipoFondo);
	}
	
	public Boolean insertarFondoMutuo( List<FondosMutuos> lstBeans ) throws BusinessException {
		return fondosMutuosFinder.insertarFondoMutuo(lstBeans);
	}
	
	
	public FondosMutuos consultarUltimaFecha() throws BusinessException {
		return fondosMutuosFinder.consultarUltimaFecha();
	}
	
	public List<Parametro> consultarFondoMutuoTipos(Integer puntaje, String moneda, String etiqueta)  throws BusinessException {
		return fondosMutuosFinder.consultarFondoMutuoTipos(puntaje, moneda, etiqueta);
	}
	
	public Parametro obtenerFondosMutuosPuntos(String numeroDias, String etiqueta)  throws BusinessException {
		return fondosMutuosFinder.obtenerFondosMutuosPuntos(numeroDias, etiqueta);
	}
	
	public List<Object[]> consultarFondosMutuosParte (String moneda, String fondo1,  String fondo2,  String fondo3, 
			Integer dias, List<String> lista) throws BusinessException {
		return fondosMutuosFinder.consultarFondosMutuosParte( moneda,fondo1, fondo2, fondo3,  dias, lista);
	}
	
	public Parametro consultarDiasDesdeIdentificadorSlider(String etiqueta, String periodo) throws BusinessException {
		return fondosMutuosFinder.consultarDiasDesdeIdentificadorSlider(etiqueta,periodo);
	}
	
	public FondosMutuos getInstance() {
		return new FondosMutuosImpl();
	}
}