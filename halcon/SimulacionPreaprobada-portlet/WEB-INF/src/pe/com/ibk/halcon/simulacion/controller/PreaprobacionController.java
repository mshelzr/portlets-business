package pe.com.ibk.halcon.simulacion.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.exp.portlet.halcon.utils.WsCampaniasServiceUtil;
import com.ext.portlet.halcon.dto.CampaniaBean;
import com.ext.portlet.halcon.dto.CampaniaRequestBean;
import com.ext.portlet.halcon.dto.CampaniaResponseBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * Portlet implementation class PreaprobacionController
 */
@Controller
@RequestMapping("VIEW")
public class PreaprobacionController {
	
	private static Log _log = LogFactoryUtil.getLog(PreaprobacionController.class);
	//private static Integer indicadorPortlet=39;
	//private static Integer indicadorController=1;

	@RequestMapping
    protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse){
    	//Cargar el path
    	JSonUtil.getPath(renderRequest);
    	SimuladoresUtil.inicializarHPC();
    	
    	String nombreProducto,urlSolicitud;
		String pagina="redireccionar";
		SimuladorBean simulacionSession=SimuladoresUtil.traerSimulacion(renderRequest);
		
		
		if(Validator.isNotNull(simulacionSession)){
			if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_VEHICULAR)){
				_log.info("TIPO VEHICULAR");
				String codigoCampania=esCampania(simulacionSession);
				if(Validator.isNotNull(codigoCampania)){
					nombreProducto="Crédito Vehicular";
					urlSolicitud=obtenerURLSolicitudPreaProbada(Integer.parseInt(simulacionSession.getTipoCredito()));
					
					renderRequest.setAttribute("nombreProducto", nombreProducto);
					renderRequest.setAttribute("urlSolicitud", urlSolicitud);
					renderRequest.setAttribute("codigoCampania", codigoCampania);
					renderRequest.setAttribute("tipoSimulador", SimuladoresUtil.SIMULADOR_VEHICULAR);
					
					pagina="view";
				}else{
					pagina="vacio";
				}
				
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_HIPOTECARIO)){
				_log.info("TIPO HIPOTECARIO");
				String codigoCampania=esCampania(simulacionSession);
				if(Validator.isNotNull(codigoCampania)){
					nombreProducto="Crédito Hipotecario";
					urlSolicitud=obtenerURLSolicitudPreaProbada(Integer.parseInt(simulacionSession.getTipoCredito()));
					
					renderRequest.setAttribute("nombreProducto", nombreProducto);
					renderRequest.setAttribute("urlSolicitud", urlSolicitud);
					renderRequest.setAttribute("codigoCampania", codigoCampania);
					renderRequest.setAttribute("tipoSimulador", SimuladoresUtil.SIMULADOR_HIPOTECARIO);
				
					pagina="view";
				}else{
					pagina="vacio";
				}
				
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_PERSONAL)){
				_log.info("TIPO PERSONAL");
				String codigoCampania=esCampania(simulacionSession);
				if(Validator.isNotNull(codigoCampania)){
					nombreProducto="préstamo";
					urlSolicitud=obtenerURLSolicitudPreaProbada(Integer.parseInt(simulacionSession.getTipoCredito()));
					
					renderRequest.setAttribute("nombreProducto", nombreProducto);
					renderRequest.setAttribute("urlSolicitud", urlSolicitud);
					renderRequest.setAttribute("codigoCampania", codigoCampania);
					renderRequest.setAttribute("tipoSimulador", SimuladoresUtil.SIMULADOR_PERSONAL);
				
					pagina="view";
				}else{
					pagina="vacio";
				}
				
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_PLAZO_FIJO)){
				_log.info("TIPO PLAZO");
				pagina = "vacio";
				if (simulacionSession.getIsFondoMutuo()) {
					pagina = "viewPlazo";
				}
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS)){
				_log.info("TIPO FONDOS");

			}else{
				return "redireccionar";
			}
    	
		}else{
			ThemeDisplay theme=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			if(theme.isSignedIn()){
				return "configurar";
			}else{
				
				return "redireccionar";
			}
			
		}
    	
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		
    	return pagina;
    }
	
	@ResourceMapping("redireccionSolicitud")
	protected void volverSimular(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject json;
		json = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		try {
			String comportamientoPortlet,url,codCampaniaSol;
			comportamientoPortlet = ParamUtil.getString(resourceRequest, "tipSim");
			url = ParamUtil.getString(resourceRequest, "url","/");
			codCampaniaSol = ParamUtil.getString(resourceRequest, "codCampaniaSol");
			_log.info("Tipo simulador:"+comportamientoPortlet);
			//Buscar Cookies y cargamos el bean a session
			SimuladorBean ultimaSimulacionBeanCookie=SimuladoresUtil.traerSimulacionCookieBean(resourceRequest,comportamientoPortlet);
			
			if(Validator.isNotNull(ultimaSimulacionBeanCookie)){
				/*Agregamos el codigo de campaña al bean*/
				ultimaSimulacionBeanCookie.setCodigoCampania(codCampaniaSol);
				SimuladoresUtil.registrarSimulacion(resourceRequest, ultimaSimulacionBeanCookie);
			}
			
			json.put("url",url);

			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(json.toString());
			writer.flush();
		} catch (Exception e) {
			_log.error("Error al generar la session de simulacion:" + e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}
			
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);

	}
	private String esCampania(SimuladorBean simulacionSession){
		String codigoSiebel="";
		CampaniaRequestBean campaniaBean=new CampaniaRequestBean();
		
		//Verificamos si el producto esta en campaña
		try {
			codigoSiebel=SimuladoresUtil.obtenerSiebelbyHPC(Integer.valueOf(simulacionSession.getTipoCredito()));
		} catch (NumberFormatException e) {
			_log.error("No es un número valido a parsear: tipo de credito="+simulacionSession.getTipoCredito()+";");
		}		
		
		if(Validator.isNotNull(simulacionSession.getTipoDocumento())){
			campaniaBean.setTipoDocumento(SimuladoresUtil.obtenerDocumentoSiebel(Integer.parseInt(simulacionSession.getTipoDocumento())));
			campaniaBean.setNumeroDocumento(simulacionSession.getNumeroDocumento());
		}
		campaniaBean.setCodigoCanal(String.valueOf(SimuladoresUtil.CODIGO_CANAL));
		//campaniaBean.setCodigoGrupoProducto("");
		campaniaBean.setCodigoProducto(codigoSiebel);
		_log.info("Siebel: "+codigoSiebel);
		
		try {
			CampaniaResponseBean campanias = WsCampaniasServiceUtil.consultarCampania(campaniaBean);
			
			List<CampaniaBean> productos=campanias.getCampanias();
			
			
			if(productos!=null){
				for(int i=0;i<productos.size();i++){
					_log.info("Codigo:"+productos.get(i).getCodigoProducto()+" / "+productos.get(i).getDescripcionProducto());
					if(productos.get(i).getCodigoProducto().equalsIgnoreCase(codigoSiebel)){
						return productos.get(i).getCodigoCampania();
					}
				}
			}
		} catch (Exception e) {
			_log.info("Sucedio un erro al llamar al servicio web :  "+e.getMessage());
		}
		return "";
	}
	
	public static String obtenerURLSolicitudPreaProbada(int codigoHPC){
		Locale locale =  new Locale("es", "ES");
		StringBuilder urlSolicitud=new StringBuilder("");
		String prefijoSolicitud=LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX");
		try{
			//Producto Vehicular
			if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_VEHICULAR"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COMPRA_INTELIGENTE"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.AUTO_CASI_NUEVO"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_VEHICULAR_ESPECIAL"));
			}//Producto prestamo personal
			else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_EFECTIVO){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_EFECTIVO"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_MAESTRIA_NACIONAL_PART_TIME"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_MAESTRIA_TIEMPO_COMPLETO"));
			}//Producto hipotecario
			else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_REGULAR){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_HIPOTECARIO"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_MI_VIVIENDA){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_NUEVO_MIVIVIENDA"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_TECHO_PROPIO){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_TECHO_PROPIO"));
				
			}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA){
				urlSolicitud.append(prefijoSolicitud);
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA"));
			}
			
			urlSolicitud.append("-1");
		}catch(Exception e){
			_log.error("Ocurrió un error al obtener el la url de la solicitud preaprobada del producto HPC "+codigoHPC+":"+e.toString());
		}
		return urlSolicitud.toString();
	}	  
}
