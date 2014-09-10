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
import com.ext.portlet.halcon.model.CargaSocioRemesa;
import com.ext.portlet.halcon.model.PreguntaFrecuente;
import com.ext.portlet.halcon.model.impl.CargaSocioRemesaImpl;
import com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.CargaSocioRemesaLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the carga socio remesa local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.CargaSocioRemesaLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author 
 * @see com.ext.portlet.halcon.service.base.CargaSocioRemesaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil
 */
public class CargaSocioRemesaLocalServiceImpl extends CargaSocioRemesaLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(CargaSocioRemesaLocalServiceImpl.class);
	private static final String nameClase = CargaSocioRemesaLocalServiceImpl.class.getName() ;
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil} to access the carga socio
	 * remesa local service.
	 */

	public List<CargaSocioRemesa> obtenerCargaSocioRemesa(String s) throws BusinessException {
		try {
			List<CargaSocioRemesa> remesas=cargaSocioRemesaPersistence.findAll();
			List<CargaSocioRemesa> lstCargaTienda=new ArrayList<CargaSocioRemesa>();
			
			if(remesas!=null){
				for (CargaSocioRemesa remesa : remesas) {
				    if (remesa.getEmpresa().contains(s)) {
				    	lstCargaTienda.add(remesa);
				     }
				 }
			}
			return lstCargaTienda;
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.socio.remesa.obtenerListaCargaSocioRemesaUno") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.socio.remesa", "capa.halcon.carga.socio.remesa.obtenerListaCargaSocioRemesaUno") , e.toString());
		}
	}

	public List<CargaSocioRemesa> obtenerListaCargaSocioRemesa(Integer pais, String socio) throws BusinessException {

		ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
		DynamicQuery consultaCargaTienda = DynamicQueryFactoryUtil.forClass(CargaSocioRemesa.class, classLoader);

		if (pais != null && pais > 0) {
			consultaCargaTienda.add(PropertyFactoryUtil.forName("paisCobertura").eq(String.valueOf(pais)));
		}
		if ( (!"".equals(socio))) {
			consultaCargaTienda.add(PropertyFactoryUtil.forName("empresa").isNotNull()).add(PropertyFactoryUtil.forName("empresa").eq(socio));
		}

		try {
				List<CargaSocioRemesa> lstCargaTienda = CargaSocioRemesaLocalServiceUtil.dynamicQuery(consultaCargaTienda);		
				return lstCargaTienda;
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.socio.remesa.obtenerListaCargaSocioRemesaDos") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.socio.remesa", "capa.halcon.carga.socio.remesa.obtenerListaCargaSocioRemesaDos") , e.toString());
		}
	}

	public CargaSocioRemesa insert(String empresa, String paisCobertura, String paginaweb, String telefono) throws BusinessException {

		CargaSocioRemesa cargaSocioRemesa = null;
		try {
			long preguntaId = counterLocalService.increment(PreguntaFrecuente.class.toString());
			cargaSocioRemesa = cargaSocioRemesaPersistence.create(new Long(preguntaId).intValue());

			cargaSocioRemesa.setEmpresa(empresa);
			cargaSocioRemesa.setPaisCobertura(paisCobertura);
			cargaSocioRemesa.setPaginaWeb(paginaweb);
			cargaSocioRemesa.setTelefono(telefono);

			cargaSocioRemesa = cargaSocioRemesaPersistence.update(cargaSocioRemesa, false);

		} catch (SystemException e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.socio.remesa.insert") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.socio.remesa", "capa.halcon.carga.socio.remesa.insert") , e.toString());
		}

		return cargaSocioRemesa;
	}

	public int truncateCargaSocioRemesa() throws BusinessException {
		try {

			return cargaSocioRemesaFinder.truncate();	
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.carga.socio.remesa.truncatecargasocioremesa") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.carga.socio.remesa", "capa.halcon.carga.socio.remesa.truncatecargasocioremesa") , e.toString());
		}
	}

	public Boolean insert(List<CargaSocioRemesa> lst) throws BusinessException{
		return cargaSocioRemesaFinder.insertSocioRemesa(lst);
	}
	

	public CargaSocioRemesa getInstance() {
		return new CargaSocioRemesaImpl();
	}
	
	
}