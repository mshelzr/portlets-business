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

package com.ext.portlet.halcon.service.messaging;

import com.ext.portlet.halcon.service.AuditoriaCajaSorpresaLocalServiceUtil;
import com.ext.portlet.halcon.service.AuditoriaCajaSorpresaServiceUtil;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.AuditoriaPerfiladorServiceUtil;
import com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil;
import com.ext.portlet.halcon.service.AuditoriaSimuladorServiceUtil;
import com.ext.portlet.halcon.service.CargaDescuentoLocalServiceUtil;
import com.ext.portlet.halcon.service.CargaDescuentoServiceUtil;
import com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil;
import com.ext.portlet.halcon.service.CargaSocioRemesaServiceUtil;
import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;
import com.ext.portlet.halcon.service.CargaTiendaServiceUtil;
import com.ext.portlet.halcon.service.CategoriaSubcategoriaLocalServiceUtil;
import com.ext.portlet.halcon.service.CategoriaSubcategoriaServiceUtil;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorLocalServiceUtil;
import com.ext.portlet.halcon.service.ConfiguracionPerfiladorServiceUtil;
import com.ext.portlet.halcon.service.ConfiguracionProductoLocalServiceUtil;
import com.ext.portlet.halcon.service.ConfiguracionProductoServiceUtil;
import com.ext.portlet.halcon.service.FondosMutuosLocalServiceUtil;
import com.ext.portlet.halcon.service.FondosMutuosServiceUtil;
import com.ext.portlet.halcon.service.LogIncidenciasLocalServiceUtil;
import com.ext.portlet.halcon.service.LogIncidenciasServiceUtil;
import com.ext.portlet.halcon.service.OcurrenciaLocalServiceUtil;
import com.ext.portlet.halcon.service.OcurrenciaServiceUtil;
import com.ext.portlet.halcon.service.PaisLocalServiceUtil;
import com.ext.portlet.halcon.service.PaisServiceUtil;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.ext.portlet.halcon.service.ParametroServiceUtil;
import com.ext.portlet.halcon.service.PreguntaFrecuenteLocalServiceUtil;
import com.ext.portlet.halcon.service.PreguntaFrecuenteServiceUtil;
import com.ext.portlet.halcon.service.ProductoComplementarioLocalServiceUtil;
import com.ext.portlet.halcon.service.ProductoComplementarioServiceUtil;
import com.ext.portlet.halcon.service.SolicitudContactoLocalServiceUtil;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.ext.portlet.halcon.service.SolicitudProductoServiceUtil;
import com.ext.portlet.halcon.service.TelefonoSolicitudProductoLocalServiceUtil;
import com.ext.portlet.halcon.service.TelefonoSolicitudProductoServiceUtil;
import com.ext.portlet.halcon.service.UbigeoLocalServiceUtil;
import com.ext.portlet.halcon.service.UbigeoServiceUtil;
import com.ext.portlet.halcon.service.ValorCuotaLocalServiceUtil;
import com.ext.portlet.halcon.service.ValorCuotaServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			AuditoriaCajaSorpresaLocalServiceUtil.clearService();

			AuditoriaCajaSorpresaServiceUtil.clearService();
			AuditoriaPerfiladorLocalServiceUtil.clearService();

			AuditoriaPerfiladorServiceUtil.clearService();
			AuditoriaSimuladorLocalServiceUtil.clearService();

			AuditoriaSimuladorServiceUtil.clearService();
			CargaDescuentoLocalServiceUtil.clearService();

			CargaDescuentoServiceUtil.clearService();
			CargaSocioRemesaLocalServiceUtil.clearService();

			CargaSocioRemesaServiceUtil.clearService();
			CargaTiendaLocalServiceUtil.clearService();

			CargaTiendaServiceUtil.clearService();
			CategoriaSubcategoriaLocalServiceUtil.clearService();

			CategoriaSubcategoriaServiceUtil.clearService();
			ConfiguracionPerfiladorLocalServiceUtil.clearService();

			ConfiguracionPerfiladorServiceUtil.clearService();
			ConfiguracionProductoLocalServiceUtil.clearService();

			ConfiguracionProductoServiceUtil.clearService();
			FondosMutuosLocalServiceUtil.clearService();

			FondosMutuosServiceUtil.clearService();
			LogIncidenciasLocalServiceUtil.clearService();

			LogIncidenciasServiceUtil.clearService();
			OcurrenciaLocalServiceUtil.clearService();

			OcurrenciaServiceUtil.clearService();
			PaisLocalServiceUtil.clearService();

			PaisServiceUtil.clearService();
			ParametroLocalServiceUtil.clearService();

			ParametroServiceUtil.clearService();
			PreguntaFrecuenteLocalServiceUtil.clearService();

			PreguntaFrecuenteServiceUtil.clearService();
			ProductoComplementarioLocalServiceUtil.clearService();

			ProductoComplementarioServiceUtil.clearService();
			SolicitudContactoLocalServiceUtil.clearService();

			SolicitudProductoLocalServiceUtil.clearService();

			SolicitudProductoServiceUtil.clearService();
			TelefonoSolicitudProductoLocalServiceUtil.clearService();

			TelefonoSolicitudProductoServiceUtil.clearService();
			UbigeoLocalServiceUtil.clearService();

			UbigeoServiceUtil.clearService();
			ValorCuotaLocalServiceUtil.clearService();

			ValorCuotaServiceUtil.clearService();
		}
	}
}