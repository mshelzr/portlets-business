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

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.SolicitudContacto;
import com.ext.portlet.halcon.model.impl.SolicitudContactoImpl;
import com.ext.portlet.halcon.service.base.SolicitudContactoLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

/**
 * The implementation of the solicitud contacto local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.SolicitudContactoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Infonet-Consulting
 * @see com.ext.portlet.halcon.service.base.SolicitudContactoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.SolicitudContactoLocalServiceUtil
 */
public class SolicitudContactoLocalServiceImpl
	extends SolicitudContactoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.SolicitudContactoLocalServiceUtil} to access the solicitud contacto local service.
	 */
	private static Log _log = LogFactoryUtil.getLog(SolicitudContactoLocalServiceImpl.class);
	
	public static final String FINDER_CLASS_PREFIX = "Contacto";
	public static final String FINDER_SOLICITUDES = FINDER_CLASS_PREFIX + ".obtenerSolicitud";
	public static final String FINDER_SOLICITUDES_COUNT = FINDER_CLASS_PREFIX + ".obtenerSolicitudCount";
	
	public Integer insertarSolicitud(SolicitudContacto productoBean) throws BusinessException {
		SolicitudContacto solicitud = null;
		Integer registros = new Integer(1);
		try {
			long solicitudId = CounterLocalServiceUtil.increment(SolicitudContacto.class.getName());
			solicitud = solicitudContactoPersistence.create(solicitudId);
			solicitud.setEsCliente(productoBean.getEsCliente());
			solicitud.setNombres(productoBean.getNombres());
			solicitud.setApellidos(productoBean.getApellidos());
			solicitud.setEmail(productoBean.getEmail());
			solicitud.setTipoDocumento(productoBean.getTipoDocumento());
			solicitud.setNdocumento(productoBean.getNdocumento());
			solicitud.setDireccion(productoBean.getDireccion());
			solicitud.setDepartamento(productoBean.getDepartamento());
			solicitud.setProvincia(productoBean.getProvincia());
			solicitud.setDistrito(productoBean.getDistrito());
			solicitud.setTelefono(productoBean.getTelefono());
			solicitud.setFecha(productoBean.getFecha());
			solicitud.setMensaje(productoBean.getMensaje());
			solicitud.setMoneda(productoBean.getMoneda());
			solicitud.setImporte(productoBean.getImporte());
			solicitud.setTipoMensaje(productoBean.getTipoMensaje());
			solicitud.setTipoTema(productoBean.getTipoTema());

			solicitudContactoPersistence.update(solicitud,false);
		} catch (Exception e) {
			_log.error("Error en com.ext.portlet.halcon.service.SolicitudContactoLocalService" + e.toString());
			throw new BusinessException("Error en com.ext.portlet.halcon.service.SolicitudContactoLocalService.insertarSolicitud - Clase: com.ext.portlet.halcon.service.SolicitudContactoLocalService", e.toString());
		}

		return registros;
	}
	
	public SolicitudContacto getInstance() {
		return new SolicitudContactoImpl();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> obtenerSolicitud(Integer filas , Integer pagina, String fechaInicio, String fechaFinal) throws BusinessException {
		_log.info("com.ext.portlet.halcon.service.SolicitudContactoLocalService - obtenerSolicitudCount : fechainicio " + fechaInicio + " - fechafinal " + fechaFinal + " - filas " + filas.toString() + " - pagina " + pagina.toString());
		Session session = null;	
		try {			
			session = solicitudContactoPersistence.openSession();
			String sql = CustomSQLUtil.get(FINDER_SOLICITUDES);
			SQLQuery q = session.createSQLQuery(sql);
			if (filas > 0 && pagina > 0) {
				q.setFirstResult(filas * pagina - filas);
	            q.setMaxResults(filas);
			}
			
			q.addScalar("slct_IdSolicitudContacto", Type.STRING);
			q.addScalar("slct_EsCliente", Type.STRING);
			q.addScalar("slct_Nombres", Type.STRING);
			q.addScalar("slct_Apellidos", Type.STRING);
			q.addScalar("slct_Email", Type.STRING);
			q.addScalar("slct_TipoDocumento", Type.STRING);
			q.addScalar("slct_Ndocumento", Type.STRING);
			q.addScalar("slct_Direccion", Type.STRING);
			q.addScalar("slct_Departamento", Type.STRING);
			q.addScalar("slct_Provincia", Type.STRING);
			q.addScalar("slct_Distrito", Type.STRING);
			q.addScalar("slct_Telefono", Type.STRING);
			q.addScalar("slct_Fecha", Type.DATE);
			q.addScalar("slct_Mensaje", Type.STRING);
			q.addScalar("slct_Moneda", Type.STRING);
			q.addScalar("slct_Importe", Type.STRING);
			q.addScalar("slct_TipoMensaje", Type.STRING);
			q.addScalar("slct_TipoTema", Type.STRING);
			
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(fechaInicio + " 0:00:00");
			qPos.add(fechaFinal + " 23:59:59");	
			List<Object[]> out = new ArrayList<Object[]>();
			out = q.list();
			return out;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error("Error en com.ext.portlet.halcon.service.SolicitudContactoLocalService" + e.toString());
			throw new BusinessException("Error en com.ext.portlet.halcon.service.SolicitudContactoLocalService.obtenerSolicitud - Clase: com.ext.portlet.halcon.service.SolicitudContactoLocalService", e.toString());
		} finally {
			solicitudContactoPersistence.closeSession(session);
		}
	}
	
	public Integer obtenerSolicitudCount(String fechaInicio, String fechaFinal) throws BusinessException {
		_log.info("com.ext.portlet.halcon.service.SolicitudContactoLocalService - obtenerSolicitudCount : fechainicio " + fechaInicio + " - fechafinal " + fechaFinal);
		Session session = null;
		try {
			session = solicitudContactoPersistence.openSession();
			String sql = CustomSQLUtil.get(FINDER_SOLICITUDES_COUNT);
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(fechaInicio+" 00:00:00");
			qPos.add(fechaFinal+" 23:59:59");			
			Integer out = (Integer) q.uniqueResult();
			return out;
		} catch (Exception e) {
			e.printStackTrace();
			_log.error("Error en com.ext.portlet.halcon.service.SolicitudContactoLocalService" + e.toString());
			throw new BusinessException("Error en com.ext.portlet.halcon.service.SolicitudContactoLocalService.obtenerSolicitud - Clase: com.ext.portlet.halcon.service.SolicitudContactoLocalService", e.toString());
		} finally {
			solicitudContactoPersistence.closeSession(session);
		}
	}
}