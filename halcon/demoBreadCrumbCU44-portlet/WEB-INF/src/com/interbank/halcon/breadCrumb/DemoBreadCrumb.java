package com.interbank.halcon.breadCrumb;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletContext;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * The Class DemoBreadCrumb. Clase controladora para la edicion de encabezado de paginas
 * 
 * @author Infonet Consulting S.A.C. 
 * Fecha: 29/01/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class DemoBreadCrumb {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(DemoBreadCrumb.class);

	/** The carpeta template. */
	private static String CARPETA_TEMPLATE = "/template";

	/**
	 * Defaul view Fecha: 29/01/2013.
	 * 
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	public String defaulView(RenderRequest renderRequest, RenderResponse renderResponse) {
		JSonUtil.getPath(renderRequest);
		
		ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String PAGINA_ACTUAL = themeDisplay.getLayout().getName(themeDisplay.getLocale());
		
		renderRequest.setAttribute("PAGINA_ACTUAL",PAGINA_ACTUAL);
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
				.getHttpServletRequest(renderRequest));
		

		String url = themeDisplay.getURLCurrent();
		
		//Verificamos que no sea formulario de denuncias de candaneil
		//_log.info("URL_ACTUAL...." + url);
		if (url.contains("_RealizarDenuncia_WAR_RealizarDenunciaportlet_javax.portlet.action=guardarDocumentoIdentidad") || url.contains("_RealizarDenuncia_WAR_RealizarDenunciaportlet_javax.portlet.action=guardarDocumento")) {
			//_log.info("URL IFRAME DE DENUNCIAS");
			return "vacio";
		}
		
		String pk = "";
		Long groupId = themeDisplay.getScopeGroupId();
		String titlePortlet = "";
		String urlActual = "";

		String sloganExt = renderRequest.getPreferences().getValue("sloganExt", "");
		String title = renderRequest.getPreferences().getValue("tituloPagina", "");
		if (title != null && !title.equals("")) {
			titlePortlet = title;
			urlActual = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
		}

		else if (url.contains("detalle-promocion?idArticle=")
				|| url.contains("detalle-noticia?idArticle=")
				|| url.contains("detalle-de-notas-de-prensa?idArticle=")) {
			int index = url.lastIndexOf("=");
			//_log.info(index);
			pk = String.valueOf(url.substring(index + 1));
			//_log.info(url.substring(index + 1));
			
		} else if (url.contains("solicitudes?sol=")) {
			
			
			String urlTipoSolicitud = ParamUtil.getString(httpReq, "sol");
			String urlProductoSolicitud = ParamUtil.getString(httpReq, "pro");
			String etiquetaSolicitudProducto = SolicitudProductoLocalServiceUtil.getEtiquetaSolicitudByFriendlyURL("/" + urlTipoSolicitud);
			
			//_log.info("etiquetaSolicitudProducto " + etiquetaSolicitudProducto + " urlProductoSolicitud " + urlProductoSolicitud);

			urlActual = themeDisplay.getURLPortal() + PropsUtil.get("SOLICITUDES.ALL.PREFIX") + "/"
					+ urlTipoSolicitud + "/" + urlProductoSolicitud + "-1";
			
			if(etiquetaSolicitudProducto.contains("SOLICITUD_PREAPROBADA")){
				titlePortlet = PortletProps.get("SOLICITUDES.TITULO.SOLICITUD_PREAPROBADA." + urlProductoSolicitud);
			} else {
				if(urlProductoSolicitud.contains("tarjeta") || urlProductoSolicitud.contains("credito") || urlProductoSolicitud.contains("prestamo-personal") ||
						urlProductoSolicitud.contains("prestamo")){
					titlePortlet = PortletProps.get("SOLICITUDES.TITULO." + urlProductoSolicitud);
				}else {
					titlePortlet = PortletProps.get("SOLICITUDES.TITULO." + etiquetaSolicitudProducto);
				}
			}
			
			//_log.info("titlePortlet " + titlePortlet);
			sloganExt = PortletProps.get("SOLICITUDES.SLOGAN." + etiquetaSolicitudProducto);
			PortalUtil.setPageTitle(titlePortlet, httpReq);
			PortalUtil.setPageDescription(sloganExt, httpReq);
			
			if(titlePortlet == null || titlePortlet.equals("")){
				titlePortlet = PortletProps.get("SOLICITUDES.TITULO.SOLICITUD_DEFAULT");	
			}
			if(sloganExt == null || sloganExt.equals("")){
				sloganExt = PortletProps.get("SOLICITUDES.SLOGAN.SOLICITUD_DEFAULT");
			}
			

		} else {
			titlePortlet = themeDisplay.getLayout().getName(themeDisplay.getLocale());
			urlActual = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
		}
		if (pk.length()>0) {
			try {
				JournalArticle articulo = JournalArticleLocalServiceUtil.getArticle(groupId,
						String.valueOf(pk));
				titlePortlet = articulo.getTitle(themeDisplay.getLocale());
				urlActual = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String contenidoPage = renderRequest.getPreferences().getValue("contenidoPage", "");

		renderRequest.setAttribute("contenidoPage", contenidoPage);
		renderRequest.setAttribute("title", titlePortlet);
		PortalUtil.setPageTitle(titlePortlet, httpReq);
		renderRequest.setAttribute("titleSnippet", "<span itemprop='title'>" + titlePortlet
				+ "</span>");
		renderRequest.setAttribute("urlActual", urlActual);
		renderRequest.setAttribute("sloganExt", sloganExt);

		return "view";
	}

	/**
	 * Enviar recomendacion. Fecha: 29/01/2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws Exception the exception
	 */
	@ResourceMapping("enviarRecomendacion")
	public void enviarRecomendacion(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws Exception {

		String respuesta = "";

		String emailR = (String) resourceRequest.getParameter("correoR");
		String nombreR = (String) resourceRequest.getParameter("nombreR");
		String emailAR = (String) resourceRequest.getParameter("correoD");
		String nombreAR = (String) resourceRequest.getParameter("nombreD");
		String comentarioR = (String) resourceRequest.getParameter("comentario");
		String urlRecomendar = (String) resourceRequest.getParameter("url");

		resourceResponse.setContentType("application/json");

		if (nombreAR.trim().equals("") && nombreR.trim().equals("")) {
			respuesta = "2";
		} else if (nombreR.trim().equals("")) {
			respuesta += "nombreR";
		} else if (nombreAR.trim().equals("")) {
			respuesta = "nombreAR";
		} else {
			respuesta = "ok";
		}

		if (respuesta.equals("ok") && emailR != null && emailAR != null && !emailR.equals("")
				&& !emailAR.equals("") && ValidatorUtils.isEmail(emailR)
				&& ValidatorUtils.isEmail(emailAR)) {

			enviarMail(emailR, nombreR, emailAR, nombreAR, urlRecomendar, comentarioR,
					resourceRequest);

		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		jsonObj.put("valor", respuesta);
		try {
			PrintWriter writer = resourceResponse.getWriter();
			writer.write(jsonObj.toString());
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Enviar mail. Fecha: 29/01/2013
	 * 
	 * @param correoR the correo r
	 * @param nombreR the nombre r
	 * @param correoD the correo d
	 * @param nombreD the nombre d
	 * @param urlRecomendar the url recomendar
	 * @param comentario the comentario
	 * @param resourceRequest the resource request
	 */
	private void enviarMail(String correoR, String nombreR, String correoD, String nombreD,
			String urlRecomendar, String comentario, ResourceRequest resourceRequest) {
		try {

			String body1 = obtenerBodyMail(resourceRequest, nombreD, correoR, nombreR, comentario,
					urlRecomendar);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(body1);
			mailMessage.setFrom(new InternetAddress(correoR));
			mailMessage.setSubject("Mira lo que encontr� en Interbank");
			mailMessage.setTo(new InternetAddress(correoD));

			MailServiceUtil.sendEmail(mailMessage);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Obtener body mail. Fecha: 29/01/2013
	 *
	 * @param resourceRequest the resource request
	 * @param nombreD the nombre d
	 * @param correoR the correo r
	 * @param nombreR the nombre r
	 * @param comentario the comentario
	 * @param urlRecomendar the url recomendar
	 * @return the string
	 * @throws Exception the exception
	 */
	private String obtenerBodyMail(ResourceRequest resourceRequest, String nombreD, String correoR,
			String nombreR, String comentario, String urlRecomendar) throws Exception {
		PortletContext context;
		String pathLectura;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		/* Leemos el template */
		context = resourceRequest.getPortletSession().getPortletContext();
		pathLectura = context.getRealPath(CARPETA_TEMPLATE) + "/MailingSolicitudes.html";
		String template = getTemplateHTML(resourceRequest, pathLectura);

		template = template.replaceAll("%URL_IMG%", themeDisplay.getPathThemeImages() + "/halcon");
		template = template.replaceAll("%NOMBRE_DES%", nombreD);
		template = template.replaceAll("%NOMBRE_REM%", nombreR);
		template = template.replaceAll("%CORREO_REM%", correoR);
		template = template.replaceAll("%COMENTARIO%", comentario);
		template = template.replaceAll("%URL_RECOM%", urlRecomendar);

		return template;
	}

	/**
	 * Obtiene template html.
	 * 
	 * @param request the request
	 * @param filePath the file path
	 * @return template html
	 */
	private String getTemplateHTML(ResourceRequest request, String filePath) {
		String templateHTML;

		templateHTML = "";
		BufferedReader bufferLectura = null;
		try {
			
			StringBuffer fileData;
			char[] buf;

			/* Leemos el template */
			bufferLectura = new BufferedReader(new FileReader(filePath));// Buffer
																			// de
																			// lectura
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
			_log.error("Error al leer Template de HTML:" + e.toString());
		} finally{
			IOUtils.closeQuietly(bufferLectura);
		}

		return templateHTML;
	}

}
