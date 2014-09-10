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
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaPerfilador;
import com.ext.portlet.halcon.model.impl.AuditoriaPerfiladorImpl;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.AuditoriaPerfiladorLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the auditoria perfilador local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.AuditoriaPerfiladorLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil
 */
public class AuditoriaPerfiladorLocalServiceImpl extends AuditoriaPerfiladorLocalServiceBaseImpl {

	private static final String nameClase = AuditoriaPerfiladorLocalServiceImpl.class.getName();
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil} to access the auditoria
	 * perfilador local service.
	 */

	
	/*****************************
	 * Juan favor de no modificar el formato.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(AuditoriaPerfiladorLocalServiceImpl.class);

	public AuditoriaPerfilador insert(AuditoriaPerfilador perfilador) throws BusinessException {

		AuditoriaPerfilador auditoriaPerfilador = null;

		try {
			/* Se obtiene el ID autoincremente del SQL server con la Clase Counter */
			long auditoriaId = counterLocalService.increment(AuditoriaPerfilador.class.toString());
			auditoriaPerfilador = auditoriaPerfiladorPersistence.create(auditoriaId);

			// /*Setear todos los valores*/
			auditoriaPerfilador.setIdAuditoriaPer(auditoriaId);
			auditoriaPerfilador.setTipoDocumento(perfilador.getTipoDocumento());
			auditoriaPerfilador.setNumeroDocumento(perfilador.getNumeroDocumento());
			auditoriaPerfilador.setPerfilador(perfilador.getPerfilador());
			auditoriaPerfilador.setSession(perfilador.getSession());
			auditoriaPerfilador.setTransaccion(perfilador.getTransaccion());
			auditoriaPerfilador.setMonto(perfilador.getMonto());
			auditoriaPerfilador.setTipoCredito(perfilador.getTipoCredito());
			auditoriaPerfilador.setIP(perfilador.getIP());
			auditoriaPerfilador.setFechaHora(perfilador.getFechaHora());
			auditoriaPerfilador.setUTMCampaing(perfilador.getUTMCampaing());
			auditoriaPerfilador.setUTMContent(perfilador.getUTMContent());
			auditoriaPerfilador.setUTMMedium(perfilador.getUTMMedium());
			auditoriaPerfilador.setUTMSource(perfilador.getUTMSource());
			auditoriaPerfilador.setSession(perfilador.getSession());
			auditoriaPerfilador.setPregunta01(perfilador.getPregunta01());
			auditoriaPerfilador.setPregunta02(perfilador.getPregunta02());
			auditoriaPerfilador.setPregunta03(perfilador.getPregunta03());
			auditoriaPerfilador.setPregunta04(perfilador.getPregunta04());
			auditoriaPerfilador.setRespuesta01(perfilador.getRespuesta01());
			auditoriaPerfilador.setRespuesta02(perfilador.getRespuesta02());
			auditoriaPerfilador.setRespuesta03(perfilador.getRespuesta03());
			auditoriaPerfilador.setRespuesta04(perfilador.getRespuesta04());

			auditoriaPerfilador = auditoriaPerfiladorPersistence.update(auditoriaPerfilador, false);

		} catch (SystemException e) {
			// TODO Auto-generated catch block
			// _log.equals("Error al insertar Pregunta Frecuente: "+e.toString());
			// throw new BusinessException(nameClase+" - insert",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.perfilador.insert") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.perfilador", "capa.halcon.auditoria.perfilador.insert"), e.toString());
		}

		return auditoriaPerfilador;
	}

	public AuditoriaPerfilador getInstance() {
		return new AuditoriaPerfiladorImpl();
	}

	public Long obtenerListaAuditoriaPerfiladorCount(Integer filas, Integer pagina, Integer cboTipoDocumento, Integer cboPerfilador, String txtFechaInicio, String txtFechaFin)
			throws BusinessException {

		_log.info(" obtenerListaAuditoriaSimulador datos cboTipoDocumento : " + cboTipoDocumento + "  cboPerfilador : " + cboPerfilador + "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaAuditoriaPerfilador = DynamicQueryFactoryUtil.forClass(AuditoriaPerfilador.class, classLoader);
			if (cboTipoDocumento != null && cboTipoDocumento > 0) {
				consultaAuditoriaPerfilador.add(PropertyFactoryUtil.forName("tipoDocumento").eq(String.valueOf(cboTipoDocumento))).add(PropertyFactoryUtil.forName("tipoDocumento").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoDocumento").eq("")));
			}
			if (cboPerfilador != null && cboPerfilador > 0) {
				consultaAuditoriaPerfilador.add(PropertyFactoryUtil.forName("perfilador").eq(String.valueOf(cboPerfilador))).add(PropertyFactoryUtil.forName("perfilador").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("perfilador").eq("")));
			}
			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio.length() > 0) && (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					consultaAuditoriaPerfilador.add(PropertyFactoryUtil.forName("fechaHora").gt(sdf.parse(txtFechaInicio+ " 00:00:00"))).add(PropertyFactoryUtil.forName("fechaHora").lt(sdf.parse(txtFechaFin+ " 23:59:59")));
				}
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}

			Long count = AuditoriaPerfiladorLocalServiceUtil.dynamicQueryCount(consultaAuditoriaPerfilador);
			return count;

		} catch (Exception e) {
			// throw new
			// BusinessException(nameClase+" - obtenerListaAuditoriaPerfiladorCount",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.perfilador.obtenerlistaauditoriaperfiladorcount") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.perfilador", "capa.halcon.auditoria.perfilador.obtenerlistaauditoriaperfiladorcount"), e.toString());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<AuditoriaPerfilador> obtenerListaAuditoriaPerfilador(Integer filas, Integer pagina, Integer cboTipoDocumento, Integer cboPerfilador, String txtFechaInicio, String txtFechaFin)
			throws BusinessException {
		_log.info(" obtenerListaAuditoriaSimulador datos cboTipoDocumento : " + cboTipoDocumento + "  cboPerfilador : " + cboPerfilador + "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaAuditoriaPerfilador = DynamicQueryFactoryUtil.forClass(AuditoriaPerfilador.class, classLoader);
			if (cboTipoDocumento != null && cboTipoDocumento > 0) {
				consultaAuditoriaPerfilador.add(PropertyFactoryUtil.forName("tipoDocumento").eq(String.valueOf(cboTipoDocumento))).add(PropertyFactoryUtil.forName("tipoDocumento").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoDocumento").eq("")));
			}
			if (cboPerfilador != null && cboPerfilador > 0) {
				consultaAuditoriaPerfilador.add(PropertyFactoryUtil.forName("perfilador").eq(String.valueOf(cboPerfilador))).add(PropertyFactoryUtil.forName("perfilador").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("perfilador").eq("")));
			}
			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio.length() > 0) && (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					consultaAuditoriaPerfilador.add(PropertyFactoryUtil.forName("fechaHora").gt(sdf.parse(txtFechaInicio+ " 00:00:00"))).add(PropertyFactoryUtil.forName("fechaHora").lt(sdf.parse(txtFechaFin+ " 23:59:59")));
				}
			} catch (Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}

			consultaAuditoriaPerfilador.addOrder( OrderFactoryUtil.desc("fechaHora") );
			if (filas > 0 && pagina > 0) {
				int init = (filas * pagina - filas);
				int fin = init + filas;

				List<AuditoriaPerfilador> lst = AuditoriaPerfiladorLocalServiceUtil.dynamicQuery(consultaAuditoriaPerfilador, init, fin);
				_log.info(" select  obtenerListaAuditoriaPerfilador lst.size() :" + lst.size());

				return lst;
			} else {
				List<AuditoriaPerfilador> lst = AuditoriaPerfiladorLocalServiceUtil.dynamicQuery(consultaAuditoriaPerfilador);
				_log.info(" select  obtenerListaAuditoriaPerfilador lst.size() :" + lst.size());
				return lst;
			}

		} catch (Exception e) {
			// throw new
			// BusinessException(nameClase+" - obtenerListaAuditoriaPerfilador",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.perfilador.obtenerlistaauditoriaperfilador") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.perfilador", "capa.halcon.auditoria.perfilador.obtenerlistaauditoriaperfilador"), e.toString());
		}
	}

}