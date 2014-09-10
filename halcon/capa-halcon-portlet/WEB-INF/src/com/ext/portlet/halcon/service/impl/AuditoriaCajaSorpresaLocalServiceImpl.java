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
import com.ext.portlet.halcon.model.AuditoriaCajaSorpresa;
import com.ext.portlet.halcon.model.impl.AuditoriaCajaSorpresaImpl;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.base.AuditoriaCajaSorpresaLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the auditoria caja sorpresa local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.AuditoriaCajaSorpresaLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the
 * propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.AuditoriaCajaSorpresaLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.AuditoriaCajaSorpresaLocalServiceUtil
 */
public class AuditoriaCajaSorpresaLocalServiceImpl extends AuditoriaCajaSorpresaLocalServiceBaseImpl {
	
	private static final String nameClase = AuditoriaCajaSorpresaLocalServiceImpl.class.getName() ;
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.AuditoriaCajaSorpresaLocalServiceUtil} to access the auditoria
	 * caja sorpresa local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(AuditoriaCajaSorpresaLocalServiceImpl.class);

	/**
	 * Se obtiene la cantidad maxima de registros segun la consulta
	 * @throws BusinessException 
	 */
	public Long obtenerListaCajaSorpresaCount(Integer filas, Integer pagina, Integer cboTipoDocumento, String producto, String txtFechaInicio, String txtFechaFin) throws BusinessException {

		_log.info(" obtenerListaCajaSorpresaCount datos cboTipoDocumento : " + cboTipoDocumento + "  producto : " + producto + "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaAuditoriaCajaSorpresa = DynamicQueryFactoryUtil.forClass(AuditoriaCajaSorpresa.class, classLoader);

			if (cboTipoDocumento != null && cboTipoDocumento > 0) {
				consultaAuditoriaCajaSorpresa.add(PropertyFactoryUtil.forName("tipoDocumento").eq(String.valueOf(cboTipoDocumento))).add(PropertyFactoryUtil.forName("tipoDocumento").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoDocumento").eq("")));
			}

			if (producto != null && !producto.equals("0")) {
				Disjunction funcionOr = RestrictionsFactoryUtil.disjunction();
				funcionOr.add(PropertyFactoryUtil.forName("codProducto1").eq(producto));
				funcionOr.add(PropertyFactoryUtil.forName("codProducto2").eq(producto));
				funcionOr.add(PropertyFactoryUtil.forName("codProducto3").eq(producto));
				consultaAuditoriaCajaSorpresa.add(funcionOr);
			}

			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio.length() > 0) && (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					consultaAuditoriaCajaSorpresa.add(PropertyFactoryUtil.forName("fechaHora").gt(sdf.parse(txtFechaInicio+ " 00:00:00"))).add(PropertyFactoryUtil.forName("fechaHora").lt(sdf.parse(txtFechaFin+ " 23:59:59")));
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			Long count = AuditoriaPerfiladorLocalServiceUtil.dynamicQueryCount(consultaAuditoriaCajaSorpresa);
			return count;

		} catch (Exception e) {
			//System.out.println(e);
			//throw new BusinessException(nameClase+" - obtenerListaCajaSorpresaCount",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.cajasorpresa.obtenerlistacajasorpresacount") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.cajasorpresa", "capa.halcon.auditoria.cajasorpresa.obtenerlistacajasorpresacount") , e.toString());
			
		}
	}

	/**
	 * Se obtiene los registros del reporte de caja sorpresa.
	 * @throws BusinessException 
	 */
	@SuppressWarnings("unchecked")
	public List<AuditoriaCajaSorpresa> obtenerListaAuditoriaCajaSorpresa(Integer filas, Integer pagina, Integer cboTipoDocumento, String producto, String txtFechaInicio, String txtFechaFin) throws BusinessException {
		_log.info(" obtenerListaAuditoriaCajaSorpresa datos cboTipoDocumento : " + cboTipoDocumento + "  producto : " + producto + "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
			DynamicQuery consultaAuditoriaCajaSorpresa = DynamicQueryFactoryUtil.forClass(AuditoriaCajaSorpresa.class, classLoader);
			if (cboTipoDocumento != null && cboTipoDocumento > 0) {
				consultaAuditoriaCajaSorpresa.add(PropertyFactoryUtil.forName("tipoDocumento").eq(String.valueOf(cboTipoDocumento))).add(PropertyFactoryUtil.forName("tipoDocumento").isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("tipoDocumento").eq("")));
			}

			if (producto != null && !producto.equals("0")) {
				Disjunction funcionOr = RestrictionsFactoryUtil.disjunction();
				funcionOr.add(PropertyFactoryUtil.forName("codProducto1").eq(producto));
				funcionOr.add(PropertyFactoryUtil.forName("codProducto2").eq(producto));
				funcionOr.add(PropertyFactoryUtil.forName("codProducto3").eq(producto));
				consultaAuditoriaCajaSorpresa.add(funcionOr);
			}

			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio.length() > 0) && (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					consultaAuditoriaCajaSorpresa.add(PropertyFactoryUtil.forName("fechaHora").gt(sdf.parse(txtFechaInicio+ " 00:00:00"))).add(PropertyFactoryUtil.forName("fechaHora").lt(sdf.parse(txtFechaFin+ " 23:59:59")));
			}
			} catch (Exception e) {
				System.out.println(e);
			}
			consultaAuditoriaCajaSorpresa.addOrder( OrderFactoryUtil.desc("fechaHora") );

			if (filas > 0 && pagina > 0) {
				int init = (filas * pagina - filas);
				int fin = init + filas;

				List<AuditoriaCajaSorpresa> lst = AuditoriaPerfiladorLocalServiceUtil.dynamicQuery(consultaAuditoriaCajaSorpresa, init, fin);
				_log.info(" select  obtenerListaAuditoriaCajaSorpresa lst.size() :" + lst.size());

				return lst;
			} else {
				List<AuditoriaCajaSorpresa> lst = AuditoriaPerfiladorLocalServiceUtil.dynamicQuery(consultaAuditoriaCajaSorpresa);
				_log.info(" select  -1 -1 obtenerListaAuditoriaCajaSorpresa lst.size() :" + lst.size());
				return lst;
			}

		} catch (Exception e) {
			//throw new BusinessException(nameClase+" - obtenerListaAuditoriaCajaSorpresa",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.cajasorpresa.obtenerlistaauditoriacajasorpresa") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.cajasorpresa", "capa.halcon.auditoria.cajasorpresa.obtenerlistaauditoriacajasorpresa") , e.toString());
		}
	}

	// *****************Uso de Seccion de Caja Sorpresa**********
	public Boolean insert(AuditoriaCajaSorpresa bean) throws BusinessException{
		return auditoriaCajaSorpresaFinder.insert(bean);
	}

	public AuditoriaCajaSorpresa getInstace() {
		return new AuditoriaCajaSorpresaImpl();
	}

}
