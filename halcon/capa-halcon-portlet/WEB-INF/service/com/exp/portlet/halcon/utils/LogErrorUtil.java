package com.exp.portlet.halcon.utils;

import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.LogIncidencias;
import com.ext.portlet.halcon.service.LogIncidenciasLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class LogErrorUtil {
	
	private static Log _log = LogFactoryUtil.getLog(LogErrorUtil.class);
	
	public  static void registrarError(String parametroJson, String trazaError, String mensajeError) {
		
		LogIncidencias logIncidencias = LogIncidenciasLocalServiceUtil.getInstance();
		try {
		//****Seteo de valores por defecto*************	
		logIncidencias.setParametro(parametroJson);
		logIncidencias.setTrazaError(trazaError);
		logIncidencias.setMensajeError(mensajeError);
		//*****Para los demas portlets
		JSonUtil.setValoresAll(logIncidencias);
		
		//*****Registro en la base de datos del error*******
		logIncidencias = LogIncidenciasLocalServiceUtil.insertarLogIncidencias(logIncidencias);
		
		//*****Envio email correo*****
		MailUtil.enviarMailError(logIncidencias);
		
		} catch (BusinessException e1) {
			_log.error(Propiedades.getResourceBundle("error.informacion") + e1.toString());
		}
		
	}
	
	public  static void registrarError (String parametroJson, String trazaError, String mensajeError, String paginasHijas) {
		
		LogIncidencias logIncidencias = LogIncidenciasLocalServiceUtil.getInstance();
		try {
		//****Seteo de valores por defecto*************	
		logIncidencias.setParametro(parametroJson);
		logIncidencias.setTrazaError(trazaError);
		logIncidencias.setMensajeError(mensajeError);
		//****Solamente para el caso de Solicitudes******
		logIncidencias.setPaginaHija(paginasHijas);
		JSonUtil.setValores(logIncidencias);
		//*****Registro en la base de datos del error*******
		logIncidencias = LogIncidenciasLocalServiceUtil.insertarLogIncidencias(logIncidencias);
		
		//*****Envio email correo*****
		MailUtil.enviarMailError(logIncidencias);
		
		} catch (BusinessException e1) {
			_log.error(Propiedades.getResourceBundle("error.informacion") + e1.toString());
		}
		
	}
}
