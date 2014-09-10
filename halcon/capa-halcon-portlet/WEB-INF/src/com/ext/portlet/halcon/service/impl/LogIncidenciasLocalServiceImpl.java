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
import com.ext.portlet.halcon.model.LogIncidencias;
import com.ext.portlet.halcon.model.SolicitudProducto;
import com.ext.portlet.halcon.model.impl.LogIncidenciasImpl;
import com.ext.portlet.halcon.model.impl.SolicitudProductoImpl;
import com.ext.portlet.halcon.service.base.LogIncidenciasLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the log incidencias local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ext.portlet.halcon.service.LogIncidenciasLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author arodriguez
 * @see com.ext.portlet.halcon.service.base.LogIncidenciasLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.LogIncidenciasLocalServiceUtil
 */
public class LogIncidenciasLocalServiceImpl
	extends LogIncidenciasLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ext.portlet.halcon.service.LogIncidenciasLocalServiceUtil} to access the log incidencias local service.
	 */
	
	private static Log _log = LogFactoryUtil.getLog(LogIncidenciasLocalServiceImpl.class);
	
	
	public LogIncidencias insertarLogIncidencias(LogIncidencias logIncidencias) throws BusinessException {
		return logIncidenciasFinder.insertarLogIncidencias(logIncidencias);
	}
	
	public LogIncidencias getInstance() {
		return new LogIncidenciasImpl();
	}
	
}