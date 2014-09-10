package pe.com.ibk.halcon.simulacion.controller;

import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class UltimaSimulacionController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class UltimaSimulacionViewController{
 
	

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(UltimaSimulacionViewController.class);
	//private static Integer indicadorPortlet=44;
	//private static Integer indicadorController=2;
	
	
	/**
	 * Default view.
	 * Fecha: 21/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {
		
		String comportamientoPortlet;
		comportamientoPortlet = renderRequest.getPreferences().getValue("tipoSimulador", "");
		
		if(Validator.isNull(comportamientoPortlet)){
			return "configurar";
		}
		
		//Verificar si existe en sesion el dni
		SessionBean sBean;
		String pagina="view";
		
		sBean=SessionUtil.traerSession(renderRequest);
		//sBean.setIndicador(1);
		if(sBean.getIndicador()==1){
			//Buscar Cookies 
			SimuladorBean ultimaSimulacionBeanCookie=SimuladoresUtil.traerSimulacionCookieBean(renderRequest,comportamientoPortlet);
			String valorUltimaSimulacion="";
			if(Validator.isNotNull(ultimaSimulacionBeanCookie)){
				if (comportamientoPortlet.equals(SimuladoresUtil.SIMULADOR_PERSONAL)) {
					valorUltimaSimulacion=ultimaSimulacionBeanCookie.getMontoPrestamo();
				} else {
					valorUltimaSimulacion=ultimaSimulacionBeanCookie.getValorBien();
				}
			}

			if(Validator.isNotNull(valorUltimaSimulacion)){
				renderRequest.setAttribute("ultimaSimulacion", formatDoubletoString(Double.parseDouble(valorUltimaSimulacion)));
				renderRequest.setAttribute("ultimaSimulacionMoneda", nombreMoneda(ultimaSimulacionBeanCookie.getTipoMoneda()));
			}else{
				pagina="vacio";
			}
			
		}else{
			pagina="vacio";
		}
		//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return pagina;
	}
	
	
	/**
	 * Volver simular.
	 * Fecha: 21/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("volverSimular")
	protected void volverSimular(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		ThemeDisplay themeDisplay;
		JSONObject json;

		themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		json = JSONFactoryUtil.createJSONObject();
		try {
			String comportamientoPortlet;
			comportamientoPortlet = resourceRequest.getPreferences().getValue("tipoSimulador", "");
			
			
			//Buscar Cookies y cargamos el bean a session
			SimuladorBean ultimaSimulacionBeanCookie=SimuladoresUtil.traerSimulacionCookieBean(resourceRequest,comportamientoPortlet);
			
			if(Validator.isNotNull(ultimaSimulacionBeanCookie)){
				SimuladoresUtil.registrarSimulacion(resourceRequest, ultimaSimulacionBeanCookie);
			}
			
			json.put("url",StringUtils.substringBefore(themeDisplay.getURLCurrent(),"?")+"?vs=1");
			
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(json.toString());
			writer.flush();
			writer.close();
			
			//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
		} catch (Exception e) {
			_log.error("Error al generar la session de simulacion:" + e.toString());
		}

	}
	

	/**
	 * Format doubleto string.
	 * Fecha: 21/08/2013
	 *
	 * @param numero the numero
	 * @return the string
	 */
	private String formatDoubletoString(Double numero){
		String formateado="";
		if(numero!=null){
			DecimalFormatSymbols simbolos= new DecimalFormatSymbols();
			simbolos.setDecimalSeparator('.');
			simbolos.setGroupingSeparator(',');
			
			DecimalFormat f = new DecimalFormat("###,##0.00",simbolos);
			formateado=f.format(numero);
		}
		
		return formateado;
	}
	
	/**
	 * Nombre moneda.
	 * Fecha: 21/08/2013
	 *
	 * @param tipoMoneda the tipo moneda
	 * @return the string
	 */
	private String nombreMoneda(String tipoMoneda){
		String moneda="";
		
		if(tipoMoneda.equalsIgnoreCase(SimuladoresUtil.CODIGO_MONEDA_SOLES+"")){
			moneda="S/.";
		}else if(tipoMoneda.equalsIgnoreCase(SimuladoresUtil.CODIGO_MONEDA_DOLARES+"")){
			moneda="US$";
		}else if(tipoMoneda.equalsIgnoreCase(SimuladoresUtil.CODIGO_MONEDA_EUROS+"")){
			moneda="&#8364;";
		}
		
		return moneda;
	}
}
