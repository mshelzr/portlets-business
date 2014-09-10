package com.exp.portlet.halcon.utils;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.ext.portlet.halcon.dto.SessionBean;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class SessionUtil {

	private static Log _log = LogFactoryUtil.getLog(SessionUtil.class);
	
	public static SessionBean traerSession(PortletRequest portletRequest){
		//Si el campo indicador es 0 no haya nada en session invalidar y no leer nada , si es 1 si leeer todo.
		PortletSession session;
		SessionBean objeto;
		String tipDoc,numDoc;
		Boolean flagCambio;
		
		session=portletRequest.getPortletSession();
		tipDoc=(String)session.getAttribute("LIFERAY_SHARED_TIPO_DOC", PortletSession.APPLICATION_SCOPE);
		numDoc=(String)session.getAttribute("LIFERAY_SHARED_NUM_DOC", PortletSession.APPLICATION_SCOPE);
		flagCambio=(Boolean)session.getAttribute("LIFERAY_SHARED_FLAG_CAMBIO", PortletSession.APPLICATION_SCOPE);
		
		objeto=new SessionBean();
		
		if(Validator.isNull(tipDoc) || Validator.isNull(numDoc) ){
			objeto.setIndicador(0);
		}else{
			objeto.setIndicador(1);
			objeto.setTipoDoc(tipDoc);
			objeto.setNumDoc(numDoc);
			//Indica si el Documento fue cambiado en algun formulario
			if(Validator.isNotNull(flagCambio)){
				objeto.setFlagCambio(flagCambio);
			}else{
				objeto.setFlagCambio(false);
			}
		}
		return objeto;
	}
	
	public static void registrarSession(SessionBean session,PortletRequest portletRequest,boolean cambio){
		PortletSession pSession;
		
		pSession=portletRequest.getPortletSession();
		pSession.setAttribute("LIFERAY_SHARED_TIPO_DOC",session.getTipoDoc(), PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_NUM_DOC",session.getNumDoc(), PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_FLAG_CAMBIO",cambio, PortletSession.APPLICATION_SCOPE);
		_log.info("Session Registrada");
	}	
}
