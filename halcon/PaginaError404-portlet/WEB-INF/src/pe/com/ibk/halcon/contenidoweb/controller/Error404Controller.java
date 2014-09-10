package pe.com.ibk.halcon.contenidoweb.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletContext;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.ibk.halcon.contenidoweb.cache.util.CacheErrorUtil;
import pe.com.ibk.halcon.contenidoweb.model.BuscadorBean;
import pe.com.ibk.halcon.contenidoweb.service.impl.BuscadorUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class Error404Controller.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("VIEW")
public class Error404Controller {
	
	//private static Integer indicadorPortlet=25;
	//private static Integer indicadorController=1;
	/** The carpeta template. */
	private static String CARPETA_TEMPLATE = "/template";
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(Error404Controller.class);
	
	@Autowired
	private CacheErrorUtil cacheErrorUtil;
	
	/**
	 * Defaul view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaulView(RenderRequest renderRequest, RenderResponse renderResponse) {
		JSonUtil.getPath(renderRequest);
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		String palabraClave = httpReq.getParameter("key") == null ? null : String.valueOf(httpReq.getParameter("key"));// Operacion
		
		if(ValidatorUtils.isNotNull(palabraClave)){
		palabraClave = palabraClave.replaceAll("-", " ");

		long companyId, groupId;
		String pagina="";
		List<Layout> lstLayout;
		List<BuscadorBean> resultados;

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		resultados = new ArrayList<BuscadorBean>();

		try {
			String categoriasExcluidas[] = { "Banners Promocionales"/* ,"Productos" */};
			String nivelPadreExcluidas[] = { "/empresas", "/personas", "/pequena-empresa", "/corporativo", "/institucional" };
			List<Long> idCategorias = BuscadorUtil.getCategoriasExcepto(companyId, groupId, categoriasExcluidas);

			List<Long> lstExc = BuscadorUtil.getNivelDosExcepto(nivelPadreExcluidas);
			lstLayout = BuscadorUtil.getListUrlSearch(palabraClave, lstExc);
			
			if (lstLayout != null && lstLayout.size() > 0) {
				for (Layout la : lstLayout) {
					boolean flagRep = true;

					if (resultados != null) {
						for (BuscadorBean bb : resultados) {
							if (bb.getUrl().equals(
									themeDisplay.getURLPortal() + la.getFriendlyURL())) {
								flagRep = false;
								break;
							}
						}
					}
					if (flagRep == true) {
						BuscadorBean bb = new BuscadorBean();
						bb.setTitulo(la.getName(Locale.getDefault()));
						bb.setUrl(themeDisplay.getURLPortal() + la.getFriendlyURL());
						resultados.add(bb);
					}
				}
				String tipoPer =  (String) cacheErrorUtil.getValor(JSonUtil.NUMERO_RESULTADOS_PAGINA_ERROR404); 
				Integer numResultados = tipoPer.equals("")?0:Integer.valueOf(tipoPer);
				_log.info("MAX Resultados " + numResultados);
				_log.info("numResultados " + resultados.size());
				
				//Solo debo elegir numResultados=4 valores como maximo
				Collections.shuffle(resultados);
				
				if(resultados.size() > numResultados){
					resultados=ListUtil.subList(resultados, 0, numResultados);
				}
				
				renderRequest.setAttribute("resultado", resultados);
			} else {
				// Tarjeta de Credito
				BuscadorBean bb = new BuscadorBean();
				bb.setTitulo("Tarjeta de Crédito");
				bb.setUrl("tarjeta-credito");
				resultados.add(bb);
				
				// Programa Sueldo 
				bb = new BuscadorBean();
				bb.setTitulo("Programa Sueldo");
				bb.setUrl("programa-sueldo");
				resultados.add(bb);
				
				// Cuentas de Ahorros  
				bb = new BuscadorBean();
				bb.setTitulo("Cuentas de Ahorros");
				bb.setUrl("cuentas-para-transaccionar");
				resultados.add(bb);
				
				// Servicio al Cliente
				bb = new BuscadorBean();
				bb.setTitulo("Servicio al Cliente");
				bb.setUrl("servicio-al-cliente");
				resultados.add(bb);
				
				renderRequest.setAttribute("resultado", resultados);
			}

			

		} catch (Exception e) {
			_log.error("Error buscando resultados para la busqueda de URL - Error 404  "
					+ e.toString());
			e.printStackTrace();
			pagina = "error";
		}
			return "view";
		} else{
			renderRequest.setAttribute("errorMSG", cargarTemplateError(renderRequest));
			return "error";
		}	   
	}

	
	/**
	 * Cargar template error.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	private String cargarTemplateError(RenderRequest renderRequest) {
		String pathLectura;// , pathEscritura;
		String template = null;
		PortletContext context;
		context = renderRequest.getPortletSession().getPortletContext();
		pathLectura = context.getRealPath(CARPETA_TEMPLATE) + "/error.html";
		
		template = getTemplateHTML(renderRequest, pathLectura);
		//Seteamos los valores dependiendo de donde vino
		//String contenidoWeb = (String)renderRequest.getPortletSession().getAttribute("LIFERAY_SHARED_ERROR1", PortletSession.APPLICATION_SCOPE);
		String contenidoSolicitud = (String)renderRequest.getPortletSession().getAttribute("LIFERAY_SHARED_ERROR_SOLICITUD", PortletSession.APPLICATION_SCOPE);
		String contenidoSimulador = (String)renderRequest.getPortletSession().getAttribute("LIFERAY_SHARED_ERROR_SIMULADOR", PortletSession.APPLICATION_SCOPE);
		String contenidoCajaSorpresa = (String)renderRequest.getPortletSession().getAttribute("LIFERAY_SHARED_ERROR_CAJASORPRESA", PortletSession.APPLICATION_SCOPE);
		String urlAnteriorFormulario = (String)renderRequest.getPortletSession().getAttribute("LIFERAY_SHARED_ERROR_FORMULARIO", PortletSession.APPLICATION_SCOPE);
		
		if(contenidoSolicitud != null && contenidoSolicitud.equalsIgnoreCase("true")){
			template = template.replaceAll("%URL_ANTERIOR%", urlAnteriorFormulario+1).replaceAll("%TITULO%", PortletProps.get("mensaje1.pagina.error.limite.solicitud")).replaceAll("%MENSAJE%", PortletProps.get("mensaje2.pagina.error.limite.solicitud")).replaceAll("%SUBMENSAJE%", PortletProps.get("mensaje3.pagina.error.limite.solicitud"));
			renderRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","false", PortletSession.APPLICATION_SCOPE);
		}else if(contenidoSimulador != null && contenidoSimulador.equalsIgnoreCase("true")){
			template = template.replaceAll("%URL_ANTERIOR%", "javascript:history.back(1)").replaceAll("%TITULO%", PortletProps.get("mensaje1.pagina.error.limite.simulador")).replaceAll("%MENSAJE%", PortletProps.get("mensaje2.pagina.error.limite.simulador")).replaceAll("%SUBMENSAJE%", PortletProps.get("mensaje3.pagina.error.limite.simulador"));
			renderRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SIMULADOR","false", PortletSession.APPLICATION_SCOPE);
		}else if(contenidoCajaSorpresa != null && contenidoCajaSorpresa.equalsIgnoreCase("true")){
			template = template.replaceAll("%URL_ANTERIOR%", "javascript:history.back(1)").replaceAll("%TITULO%", PortletProps.get("mensaje1.pagina.error.limite.cajasorpresa")).replaceAll("%MENSAJE%", PortletProps.get("mensaje2.pagina.error.limite.cajasorpresa")).replaceAll("%SUBMENSAJE%", PortletProps.get("mensaje3.pagina.error.limite.cajasorpresa"));
			renderRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_CAJASORPRESA","false", PortletSession.APPLICATION_SCOPE);
		}else{
			//Pagina por defecto
			template = template.replaceAll("%TITULO%", PortletProps.get("mensaje1.pagina.error.web")).replaceAll("%MENSAJE%", PortletProps.get("mensaje2.pagina.error.web")).replaceAll("%SUBMENSAJE%", PortletProps.get("mensaje3.pagina.error.web"));
			if (urlAnteriorFormulario != null && !urlAnteriorFormulario.equalsIgnoreCase("")) {
				template = template.replaceAll("%URL_ANTERIOR%", urlAnteriorFormulario+1);
				renderRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO","", PortletSession.APPLICATION_SCOPE);
			} else {
				template = template.replaceAll("%URL_ANTERIOR%", "javascript:history.back(1)");
			}
		}

		return template;
	}
	
	
	/**
	 * Obtiene template html.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param filePath the file path
	 * @return template html
	 */
	private String getTemplateHTML(RenderRequest request, String filePath) {
		String templateHTML;

		templateHTML = "";
		BufferedReader bufferLectura = null;
		try {
			StringBuffer fileData;
			char[] buf;

			/* Leemos el template */
			bufferLectura = new BufferedReader(new FileReader(filePath));// Buffer de lectura
			fileData = new StringBuffer(1000);// Buffer de Escritura en cadena

			buf = new char[1024];
			int numRead = 0;
			while ((numRead = bufferLectura.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			

			templateHTML = fileData.toString();

		} catch (Exception e) {
			_log.error(e.toString());
		}finally{
			IOUtils.closeQuietly(bufferLectura);
	  }
		return templateHTML;
	}

}
