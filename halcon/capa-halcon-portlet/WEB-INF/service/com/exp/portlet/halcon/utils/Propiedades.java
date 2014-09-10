package com.exp.portlet.halcon.utils;

import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;

public class Propiedades {
	public final static String PROPERTIES_PORTLET = "com.ext.portlet.halcon.resource.Language";
	
	/*public static ResourceBundle obtenerResourceBundle() {
		return ResourceBundle.getBundle(PROPERTIES_PORTLET);
	}
	*/
	public static String getResourceBundle (String clase, String metodo){
		return "Error en:" + SolicitudProductoLocalServiceUtil.getPropiedadPortlet(metodo) + " - Clase:" + SolicitudProductoLocalServiceUtil.getPropiedadPortlet(clase);
	}

	public static String getResourceBundleMetodo (String metodo){
		return "Error en:" + SolicitudProductoLocalServiceUtil.getPropiedadPortlet(metodo);
	}
	
	public static String getResourceBundle (String valor){
		return SolicitudProductoLocalServiceUtil.getPropiedadPortlet(valor);
	}
}
