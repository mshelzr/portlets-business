package pe.com.ibk.halcon.principal.util;

import javax.portlet.ResourceRequest;

import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.service.SeguridadLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ValidarPeticionUtil.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class ValidarPeticionUtil {
	
	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(ValidarPeticionUtil.class);
	
	/** The Constant PAGINA_ERROR. */
	public static final String PAGINA_ERROR = "error";
	
	/**
	 * Validar gestion peticion.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param ip the ip
	 * @param codigoProducto the codigo producto
	 * @param etiqueta the etiqueta
	 * @return the boolean
	 */
	public static Boolean validarGestionPeticion(ResourceRequest resourceRequest,
			String ip, String codigoProducto,String etiqueta) {
		Boolean pasoValidacionGestionPeticion=false;
		Object[] peticionValida=null;
		try {
			peticionValida = SeguridadLocalServiceUtil.consultar(resourceRequest, ip, codigoProducto,etiqueta);
			if(peticionValida!=null){
				pasoValidacionGestionPeticion = (Boolean) peticionValida[0];
				return pasoValidacionGestionPeticion;
			}
		} catch (BusinessException e) {
			String jsonError=String.format("{ip:%s,codigoProducto:%s,etiqueta:%s}", ip,codigoProducto,etiqueta);
			String asunto = Propiedades.getResourceBundle("destacado.principal.validarpeticionutil.validargestionpeticion");
			LogErrorUtil.registrarError(jsonError, e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
			return pasoValidacionGestionPeticion;
		} catch (Exception e) {
			_log.info("Error Exception - Gestion Peticiones");
			e.printStackTrace();
			return pasoValidacionGestionPeticion;
		}
		return pasoValidacionGestionPeticion;
	}

}
