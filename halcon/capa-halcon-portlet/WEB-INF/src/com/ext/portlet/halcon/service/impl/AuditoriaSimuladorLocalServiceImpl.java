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

import java.text.SimpleDateFormat;
import java.util.List;

import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaSimulador;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.impl.AuditoriaSimuladorImpl;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.AuditoriaSimuladorLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the auditoria simulador local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.AuditoriaSimuladorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.AuditoriaSimuladorLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil
 */
public class AuditoriaSimuladorLocalServiceImpl
	extends AuditoriaSimuladorLocalServiceBaseImpl {
	
	private static final String nameClase = AuditoriaSimuladorLocalServiceImpl.class.getName() ;
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil} to access the auditoria simulador local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(AuditoriaSimuladorLocalServiceImpl.class);
			
	public AuditoriaSimulador getInstance(){
		return new AuditoriaSimuladorImpl();
	}
	
//	public Integer insertarAuditoriaSimulador(AuditoriaSimulador simulador) throws BusinessException {
//		return auditoriaSimuladorFinder.insertarAuditoriaSimulador(simulador);
//	}
	public SimuladorBean insertarSimulador(SimuladorBean simulador) throws BusinessException{ 
		
		AuditoriaSimulador auditoriaSimulador = getInstance();
		
		try {
		
			auditoriaSimulador.setTipoSimulador(simulador.getTipoSimulador());
			
			auditoriaSimulador.setTipoSimulador(simulador.getTipoSimulador());
	//		auditoriaSimulador.setIdTransaccion(simulador.getIdTransaccion());
			auditoriaSimulador.setTipoDocumento(simulador.getTipoDocumento());
			auditoriaSimulador.setNumDocumento(simulador.getNumeroDocumento());
			auditoriaSimulador.setMoneda(simulador.getTipoMoneda());
			auditoriaSimulador.setTipoProducto(simulador.getTipoCredito());
			auditoriaSimulador.setInvirtioFondMut(simulador.getInvirtioFondoMutuo());
			auditoriaSimulador.setNivelConocimFondMut(simulador.getNivelConocimientoFondoMutuo());
			auditoriaSimulador.setReaccionVarMerc(simulador.getReaccionVariacionMercado());
			auditoriaSimulador.setValorBien(Double.valueOf(simulador.getValorBien()));
			auditoriaSimulador.setMontoPrestamo(Double.valueOf(simulador.getMontoPrestamo()));
			auditoriaSimulador.setCuotaInicial(Double.valueOf(simulador.getCuotaInicial()));
			auditoriaSimulador.setPeriodoInvers(simulador.getPlazoCredito());
			auditoriaSimulador.setTasa(Double.valueOf(simulador.getTasa()));
			auditoriaSimulador.setSegDesgrav(simulador.getSeguroDesgravamen());
			auditoriaSimulador.setTipoCuota(simulador.getTipoCuota());
			auditoriaSimulador.setIP(simulador.getIp());
			auditoriaSimulador.setFechaHora(TiempoUtil.getFechaStringDate(simulador.getFechaHora()));
			auditoriaSimulador.setUTMCampaing(simulador.getUtmCampaing());
			auditoriaSimulador.setUTMContent(simulador.getUtmContent());
			auditoriaSimulador.setUTMMedium(simulador.getUtmMedium());
			auditoriaSimulador.setUTMSource(simulador.getUtmSource());
			
			auditoriaSimulador = insertar(auditoriaSimulador);
			
			simulador.setIdSimulador(auditoriaSimulador.getIdAuditoriaSim());
				
		} catch (Exception e) {
			//throw new BusinessException(nameClase+" - insertarSimulador",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.simulador.insertarsimulador") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.simulador", "capa.halcon.auditoria.simulador.insertarsimulador") , e.toString());
		}
		return simulador;
	}
	
	public AuditoriaSimulador insertar(AuditoriaSimulador simulador) throws BusinessException{
		AuditoriaSimulador resultado=null;
		try{
			/*Se obtiene el ID autoincremente del SQL server con la Clase Counter*/
			long auditoriaId=counterLocalService.increment( AuditoriaSimulador.class.toString());
			resultado=auditoriaSimuladorPersistence.create(auditoriaId);
			
			/*Setear todos los valores*/
			resultado.setIdAuditoriaSim(auditoriaId);
			resultado.setTipoSimulador(simulador.getTipoSimulador());
			resultado.setIdTransaccion(simulador.getIdTransaccion());
			resultado.setTipoDocumento(simulador.getTipoDocumento());
			resultado.setNumDocumento(simulador.getNumDocumento());
			resultado.setMoneda(simulador.getMoneda());
			resultado.setTipoProducto(simulador.getTipoProducto());
			resultado.setInvirtioFondMut(simulador.getInvirtioFondMut());
			resultado.setNivelConocimFondMut(simulador.getNivelConocimFondMut());
			resultado.setReaccionVarMerc(simulador.getReaccionVarMerc());
			resultado.setValorBien(simulador.getValorBien());
			resultado.setMontoPrestamo(simulador.getMontoPrestamo());
			resultado.setCuotaInicial(simulador.getCuotaInicial());
			resultado.setPeriodoInvers(simulador.getPeriodoInvers());
			resultado.setTasa(simulador.getTasa());
			resultado.setSegDesgrav(simulador.getSegDesgrav());
			resultado.setTipoCuota(simulador.getTipoCuota());
			resultado.setIP(simulador.getIP());
			resultado.setFechaHora(simulador.getFechaHora());
			resultado.setUTMCampaing(simulador.getUTMCampaing());
			resultado.setUTMContent(simulador.getUTMContent());
			resultado.setUTMMedium(simulador.getUTMMedium());
			resultado.setUTMSource(simulador.getUTMSource());
			
			resultado=auditoriaSimuladorPersistence.update(resultado,false);
			
		}catch(Exception e){
			//_log.error("Error al insertar en AuditoriaSimulador:"+e.toString());
			//throw new BusinessException(nameClase+" - insertar",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.simulador.insertar") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.simulador", "capa.halcon.auditoria.simulador.insertar") , e.toString());
		}
		
		return resultado;
	}
	
	
	public  Integer obtenerListaSimuladoresCount(Integer filas, Integer pagina, Integer cboTipoDocumento, Integer simulador, String txtFechaInicio, String txtFechaFin) throws BusinessException{
		

		_log.info(" obtenerListaSimuladoresCount datos cboTipoDocumento : " + cboTipoDocumento + "  simulador : " + simulador + "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaAuditoriaSimulador = DynamicQueryFactoryUtil.forClass(AuditoriaSimulador.class, classLoader);

			if (cboTipoDocumento != null && cboTipoDocumento > 0) {
				consultaAuditoriaSimulador.add(PropertyFactoryUtil.forName("tipoDocumento").eq(String.valueOf(cboTipoDocumento))).add(PropertyFactoryUtil.forName("tipoDocumento").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoDocumento").eq("")));
			}

			if (simulador != null && simulador > 0) {
				consultaAuditoriaSimulador
				.add(PropertyFactoryUtil.forName("tipoSimulador").eq(String.valueOf(simulador)))
				.add(PropertyFactoryUtil.forName("tipoSimulador").isNotNull())
				.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoSimulador").eq("")));
			}

			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio.length() > 0) && (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					consultaAuditoriaSimulador.add(PropertyFactoryUtil.forName("fechaHora").gt(sdf.parse(txtFechaInicio+" 00:00:00"))).add(PropertyFactoryUtil.forName("fechaHora").lt(sdf.parse(txtFechaFin+" 23:59:59")));	
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			Long count = AuditoriaPerfiladorLocalServiceUtil.dynamicQueryCount(consultaAuditoriaSimulador);
			return count.intValue();

		} catch (Exception e) {
			//System.out.println(e);
			//throw new BusinessException(nameClase+" - obtenerListaSimuladoresCount",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.simulador.obtenerlistasimuladorescount") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.simulador", "capa.halcon.auditoria.simulador.obtenerlistasimuladorescount") , e.toString());
		}
	}
	
	
	public  List<AuditoriaSimulador> obtenerListaSimuladores(Integer filas, Integer pagina, Integer cboTipoDocumento, Integer simulador, String txtFechaInicio, String txtFechaFin) throws BusinessException{
		_log.info(" obtenerListaSimuladores datos cboTipoDocumento : " + cboTipoDocumento + "  simulador : " + simulador + "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaAuditoriaSimulador = DynamicQueryFactoryUtil.forClass(AuditoriaSimulador.class, classLoader);

			if (cboTipoDocumento != null && cboTipoDocumento > 0) {
				consultaAuditoriaSimulador.add(PropertyFactoryUtil.forName("tipoDocumento").eq(String.valueOf(cboTipoDocumento))).add(PropertyFactoryUtil.forName("tipoDocumento").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoDocumento").eq("")));
			}

			if (simulador != null && simulador > 0) {
				consultaAuditoriaSimulador
				.add(PropertyFactoryUtil.forName("tipoSimulador").eq(String.valueOf(simulador)))
				.add(PropertyFactoryUtil.forName("tipoSimulador").isNotNull())
				.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoSimulador").eq("")));
			}

			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio.length() > 0) && (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					consultaAuditoriaSimulador.add(PropertyFactoryUtil.forName("fechaHora").gt(sdf.parse(txtFechaInicio+" 00:00:00"))).add(PropertyFactoryUtil.forName("fechaHora").lt(sdf.parse(txtFechaFin+" 23:59:59")));
					}
			} catch (Exception e) {
				System.out.println(e);
			}
			consultaAuditoriaSimulador.addOrder( OrderFactoryUtil.desc("fechaHora") );
			if (filas > 0 && pagina > 0) {
				int init = (filas * pagina - filas);
				int fin = init + filas;

				@SuppressWarnings("unchecked")
				List<AuditoriaSimulador> lst = AuditoriaSimuladorLocalServiceUtil.dynamicQuery(consultaAuditoriaSimulador, init, fin);
				_log.info(" select  obtenerListaAuditoriaCajaSorpresa lst.size() :" + lst.size());

				return lst;
			} else {
				@SuppressWarnings("unchecked")
				List<AuditoriaSimulador> lst = AuditoriaSimuladorLocalServiceUtil.dynamicQuery(consultaAuditoriaSimulador);
				_log.info(" select  -1 -1 obtenerListaAuditoriaCajaSorpresa lst.size() :" + lst.size());
				return lst;
			}

		} catch (Exception e) {
			//throw new BusinessException(nameClase+" - obtenerListaSimuladores",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.simulador.auditoriasimuladorlocalserviceutil") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.simulador", "capa.halcon.auditoria.simulador.auditoriasimuladorlocalserviceutil") , e.toString());
		}
	}
	
	public Parametro obtenerTarifarioDepositoPlazo(Integer monto, String moneda, String plazo, String tipoTabla) throws BusinessException {
		return auditoriaSimuladorFinder.obtenerTarifarioDepositoPlazo(monto, moneda, plazo, tipoTabla);
	}

}


