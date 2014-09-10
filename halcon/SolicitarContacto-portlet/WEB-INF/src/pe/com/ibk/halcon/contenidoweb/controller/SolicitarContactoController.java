package pe.com.ibk.halcon.contenidoweb.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil;
import pe.com.ibk.halcon.contenidoweb.utils.Constantes;
import pe.com.ibk.halcon.contenidoweb.utils.MailEngine;
import pe.com.ibk.halcon.contenidoweb.utils.ValidatorUtils;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.ext.portlet.halcon.model.SolicitudContacto;
import com.ext.portlet.halcon.service.SolicitudContactoLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SolicitarContacto.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 30/01/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class SolicitarContactoController {

	/** The //_log. */
	private static Log _log = LogFactoryUtil.getLog(SolicitarContactoController.class);

	/** The f. */
	private static String f = "";
	
	/** The indicador js. */
	private static String indicadorJS="0";
	
	private static String pathTemplate = "";
	private static String pathImagenes = "";

	@Autowired
	private CacheContenidoUtil cacheContenidoUtil;
	
	/** The captcha service. */
	@Autowired
	private GenericManageableCaptchaService captchaService;
	/**
	 * Instancia un nuevo solicitar contacto.
	 */
	public SolicitarContactoController() {
	}

	/**
	 * Default view, metodo que carga por defecto inicialmente
	 * Fecha: 30/01/2013.
	 *
	 * @param model the model
	 * @param request the request
	 * @param response the response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(Model model, RenderRequest request, RenderResponse response) {
		JSonUtil.getPath(request);
		String fecha = cargarFecha(f);
		request.setAttribute("fecha", fecha);
        String page="view";
	
        if(indicadorJS.equals("1")){
        	indicadorJS="0";
        }
        
		if(Validator.isNotNull(request.getParameter("isERROR"))){
			if (request.getParameter("isERROR").equalsIgnoreCase("true")) {
				model.addAttribute("avisoNombre", request.getParameter("avisoNombre"));
				model.addAttribute("avisoApellido", request.getParameter("avisoApellido"));
				model.addAttribute("avisoEmail", request.getParameter("avisoEmail"));
				model.addAttribute("avisoConfirmacionEmail",request.getParameter("avisoConfirmacionEmail"));
				model.addAttribute("avisoNumeroDocumento", request.getParameter("avisoNumeroDocumento"));
				model.addAttribute("avisoTelefono", request.getParameter("avisoTelefono"));
				//model.addAttribute("avisoImporte", request.getParameter("avisoImporte"));
				model.addAttribute("avisoDepartamento", request.getParameter("avisoDepartamento"));
				model.addAttribute("avisoProvincia", request.getParameter("avisoProvincia"));
				model.addAttribute("avisoDistrito", request.getParameter("avisoDistrito"));
				model.addAttribute("avisoDireccion", request.getParameter("avisoDireccion"));
				model.addAttribute("avisoMensaje", request.getParameter("avisoMensaje"));		
				model.addAttribute("avisocaptcha", request.getParameter("avisocaptcha"));
				request.setAttribute("isERROR", true);
				request.setAttribute("rpta", true);
			} else {
				// Seteamos el pathTemplate
				PortletContext context=request.getPortletSession().getPortletContext();
				pathTemplate = context.getRealPath(Constantes.CARPETA_TEMPLATE) + "/imprimir.html";
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				pathImagenes = themeDisplay.getPathThemeImages();

				page="resultado";
				indicadorJS="1";
			}
		}
    	request.setAttribute("indicadorJS", indicadorJS);
		
		
		return page;
	}

	//Metodo que genera la plantilla y funcionalidad de impresion
	@ResourceMapping("descargarPDF")
	public void descargarPDF(ResourceRequest request,ResourceResponse response) {		
		try {
			String templatePdf = getTemplateHTML(pathTemplate);
			//_log.info("pathTemplate: "+ pathTemplate);
			//_log.info("pathImagenes: "+ pathImagenes);
			templatePdf = templatePdf.replaceAll("%RUTA_IMAGEN%",(pathImagenes + "/halcon"));
			templatePdf = templatePdf.replaceAll("%NOMBRES%", HtmlUtil.escape(request.getParameter("pNombres")));
			templatePdf = templatePdf.replaceAll("%APELLIDOS%",HtmlUtil.escape(request.getParameter("pApellidos")));
			templatePdf = templatePdf.replaceAll("%EMAIL%",HtmlUtil.escape(request.getParameter("pEmail")));
			templatePdf = templatePdf.replaceAll("%DOCUMENTO%",HtmlUtil.escape(request.getParameter("pTipodocumento") + ", " + request.getParameter("pNdocumento")));
			templatePdf = templatePdf.replaceAll("%DIRECCION%",HtmlUtil.escape(request.getParameter("pDireccion")));
			templatePdf = templatePdf.replaceAll("%DEPARTAMENTO%",HtmlUtil.escape(request.getParameter("pDepart")));
			templatePdf = templatePdf.replaceAll("%PROVINCIA%",HtmlUtil.escape(request.getParameter("pProv")));
			templatePdf = templatePdf.replaceAll("%DISTRITO%",HtmlUtil.escape(request.getParameter("pDist")));
			templatePdf = templatePdf.replaceAll("%TELEFONO%",HtmlUtil.escape(request.getParameter("pTelefono")));
			templatePdf = templatePdf.replaceAll("%TIPOINGRESO%",HtmlUtil.escape(request.getParameter("pTipoingreso")));
			templatePdf = templatePdf.replaceAll("%FECHAHORA%",HtmlUtil.escape(request.getParameter("pFechahora")));
			templatePdf = templatePdf.replaceAll("%TIPOTEMA%",HtmlUtil.escape(request.getParameter("pTipotema")));
			templatePdf = templatePdf.replaceAll("%IMPORTE%",HtmlUtil.escape(request.getParameter("pTipomoneda") + " " + request.getParameter("pImporte")));
			templatePdf = templatePdf.replaceAll("%MENSAJE%",HtmlUtil.escape(request.getParameter("pMensaje")));

			ITextRenderer iTextRenderer = new ITextRenderer();
			iTextRenderer.setDocumentFromString(templatePdf);
			iTextRenderer.layout();

			response.setContentType("application/pdf");
			response.setProperty("Content-Disposition", "attachment; filename=formulario.pdf");
			OutputStream elFichero = new FileOutputStream("/tmp/abc.pdf");  //response.getPortletOutputStream(); 
			iTextRenderer.createPDF(elFichero);
			elFichero.flush();
			elFichero.close();System.out.println("Gaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Solicitar contacto, obtiene y valida todos los campos del jsp
	 * Fecha: 30/01/2013.
	 *
	 * @param status the status
	 * @param request the request
	 * @param response the response
	 */
	@ActionMapping
	public void solicitarContacto(SessionStatus status, ActionRequest request, ActionResponse response) {
			String avisoNombre = "";
			String avisoApellido = "";
			String avisoEmail = "";
			String avisoConfirmacionEmail = "";
			String avisoNumeroDocumento = "";
			String avisoDepartamento = "";
			String avisoProvincia = "";
			String avisoDistrito = "";
			String avisoDireccion = "";
		String avisoTelefono = "";
		String avisoImporte = "";
			String avisoMensaje = "";
			String avisocaptcha = "";
			String compara = "";
			String resultado = "";
			String nombreApellido= "";
		
		try {
			
			response.setRenderParameter("isERROR", "false");
			
			int esCliente = ParamUtil.getInteger(request, "check");
			String nombres = HtmlUtil.escape(ParamUtil.getString(request, "Nombres"));
			String apellidos = HtmlUtil.escape(ParamUtil.getString(request, "Apellidos"));
			String email = HtmlUtil.escape(ParamUtil.getString(request, "email"));
			String confmail = HtmlUtil.escape(ParamUtil.getString(request, "confmail"));
			String tipoDocumento = HtmlUtil.escape(ParamUtil.getString(request, "tipoDocumento"));
			String telefono = HtmlUtil.escape(ParamUtil.getString(request, "telefono"));
			String importe =  HtmlUtil.escape(ParamUtil.getString(request, "importe"));
			String numDocumento = HtmlUtil.escape(ParamUtil.getString(request, "ndocumento"));
			String direccion = HtmlUtil.escape(ParamUtil.getString(request, "direccion"));
			String departamento = HtmlUtil.escape(ParamUtil.getString(request, "cboDepartamentoHidden"));
			String provincia = HtmlUtil.escape(ParamUtil.getString(request, "cboProvinciaHidden"));
			String distrito = HtmlUtil.escape(ParamUtil.getString(request, "cboDistritoHidden"));
			String fecha = cargarFecha(f);
			String tipoMensaje = HtmlUtil.escape(ParamUtil.getString(request, "msg"));
			String tipoTema = HtmlUtil.escape(ParamUtil.getString(request, "cboTipoTemaHidden"));
			String mensaje = HtmlUtil.escape(ParamUtil.getString(request, "mensaje"));
			String captcha = request.getParameter("txtCaptcha");
			String tipomoneda = HtmlUtil.escape(ParamUtil.getString(request, "tipoMonedaDepositoHidden"));
			String ubigeos = HtmlUtil.escape(ParamUtil.getString(request, "ubigeo"));
			
			nombreApellido= nombres +" " + convInicialMay(apellidos);			
			request.setAttribute("esCliente", esCliente);
			request.setAttribute("nombreApellido", convInicialMay(nombreApellido));
			request.setAttribute("nombres", convInicialMay(nombres));
			request.setAttribute("apellidos", convInicialMay(apellidos));
			request.setAttribute("email", email);
			request.setAttribute("confmail", confmail);
			request.setAttribute("tipoDocumento", tipoDocumento);
			request.setAttribute("numDocumento", numDocumento);
			request.setAttribute("direccion", direccion);
			request.setAttribute("telefono", telefono);
			request.setAttribute("importe", importe);
			request.setAttribute("departamento", convInicialMay(departamento));
			request.setAttribute("provincia", convInicialMay(provincia));
			request.setAttribute("distrito", convInicialMay(distrito));
			request.setAttribute("fecha", fecha);
			request.setAttribute("tipoMensaje", tipoMensaje);
			request.setAttribute("tipoTema", tipoTema);
			request.setAttribute("mensaje", mensaje);
			
			  if (!ValidatorUtils.isNombre(nombres)) {
				avisoNombre = Constantes.MSJ_NOMBRES;
			}

			if (!ValidatorUtils.isApellido(apellidos)) {
				avisoApellido = Constantes.MSJ_APELLIDOS;
			}

			if (!ValidatorUtils.isEmail(email)) {
				avisoEmail = Constantes.MSJ_EMAIL;
			}

			if (!email.equals(confmail)) {
				avisoConfirmacionEmail = Constantes.MSJ_CONFEMAIL;
			}


			if (tipoDocumento.equalsIgnoreCase("1")) {
				// DNI
				if (!ValidatorUtils.isDNI(numDocumento)) {
					avisoNumeroDocumento = Constantes.MSJ_DNI;
				}
			} else{
				// Carne de extranjeria
				if (!ValidatorUtils.isCarneExtranjeria(numDocumento)) {
					avisoNumeroDocumento = Constantes.MSJ_CARNET_EXTRANJERIA;
				}
			}

			if (ValidatorUtils.isNull(departamento)) {
				avisoDepartamento = Constantes.MSJ_DEPARTAMENTO;
			} else if (departamento.equalsIgnoreCase("0")) {
				avisoDepartamento = Constantes.MSJ_DEPARTAMENTO;
			}

			if (ValidatorUtils.isNull(provincia)) {
				avisoProvincia = Constantes.MSJ_PROVINCIA;
			} else if (provincia.equalsIgnoreCase("0")) {
				avisoProvincia = Constantes.MSJ_PROVINCIA;
			}

			if (ValidatorUtils.isNull(distrito)) {
				avisoDistrito = Constantes.MSJ_DISTRITO;
			} else if (distrito.equalsIgnoreCase("0")) {
				avisoDistrito = Constantes.MSJ_DISTRITO;
			}

			if (!ValidatorUtils.isDireccion(direccion)) {
				avisoDireccion = Constantes.MSJ_DIRECCION;
			}
			
			if (!ValidatorUtils.isTelefono(telefono)) {
				avisoTelefono = Constantes.MSJ_TELEFONO;
			}


			if (!ValidatorUtils.isImporte(importe)) {
				//avisoImporte = Constantes.MSJ_IMPORTE;
			}

			int longitudMensaje=0;
			longitudMensaje=mensaje.length();
			
			if (!ValidatorUtils.isMensaje(mensaje)) {
				if(longitudMensaje==0)
					avisoMensaje = Constantes.MSJ_MENSAJE1;	
				if(longitudMensaje>1000)
					avisoMensaje = Constantes.MSJ_MENSAJE2;	
			}	
			
			if(captcha.length()>7){
				avisocaptcha = Constantes.MSJ_CAPTCHA;	
			}
			
			if (captcha.length() > 5) {
				avisocaptcha = Constantes.MSJ_CAPTCHA;
			}
			
			request.setAttribute("avisoNombre", avisoNombre);
			request.setAttribute("avisoApellido", avisoApellido);
			request.setAttribute("avisoEmail", avisoEmail);
			request.setAttribute("avisoConfirmacionEmail", avisoConfirmacionEmail);
			request.setAttribute("avisoNumeroDocumento", avisoNumeroDocumento);
			request.setAttribute("avisoDepartamento", avisoDepartamento);
			request.setAttribute("avisoProvincia", avisoProvincia);
			request.setAttribute("avisoDistrito", avisoDistrito);
			request.setAttribute("avisoDireccion", avisoDireccion);
			request.setAttribute("avisoTelefono", avisoTelefono);
			request.setAttribute("avisoImporte", avisoImporte);
			request.setAttribute("avisoMensaje", avisoMensaje);
			request.setAttribute("avisocaptcha", avisocaptcha);

			resultado = avisoNombre + avisoApellido + avisoEmail + avisoConfirmacionEmail + avisoConfirmacionEmail + avisoNumeroDocumento + avisoDepartamento + avisoProvincia + avisoDistrito + avisoDireccion + avisoMensaje + avisocaptcha;

			if (compara.equals(resultado)) {
				/*
				 * Envio de email con los datos previamente validados
				 * Este snipped se ejecuta antes de renderizar resultado.jsp
				 */ 
				String pNombres = convInicialMay(nombres);
				String pApellidos = convInicialMay(apellidos);
				String pEmail = email;
				String pNdocumento = numDocumento;
				String pDireccion = direccion;
				String pTelefono = telefono;
				String pMensaje = mensaje;
				String pImporte = importe;
				String pTipoingreso = tipoMensaje;
				
				String pTipodocumento = "";
				if (tipoDocumento.equals("1")) {
					pTipodocumento = "DNI";
				} else if (tipoDocumento.equals("2")) {
					//pTipodocumento = "Carn&eacute; Ext";
					pTipodocumento = "CE";
				}
				
				String ubigeo[]= ubigeos.split("%");
				String pDepart = ubigeo[0];
				String pProv = ubigeo[1];
				String pDist = ubigeo[2];
				
				String pTipomoneda = "";
				if (!pImporte.equals("")) {
				if (tipomoneda.equals("1")) {
						pTipomoneda = "S/.";
				} else if (tipomoneda.equals("2")) {
						pTipomoneda = "US&#36";
				} else if (tipomoneda.equals("3")) {
						pTipomoneda = "&#8364";
				}
				}
				
				String pTipotema = "";
				if (!pTipoingreso.equalsIgnoreCase("sugerencia")) {
					if (tipoTema.equals("1")) {
						pTipotema = "Tarjetas de Credito";
					} else if (tipoTema.equals("2")) {
						pTipotema = "Cuentas de Deposito";
					} else if (tipoTema.equals("3")) {
						pTipotema = "Banca Electronica";
					} else if (tipoTema.equals("4")) {
						pTipotema = "Creditos Personales";
					} else if (tipoTema.equals("5")) {
						pTipotema = "Seguros";
					} else if (tipoTema.equals("6")) {
						pTipotema = "Fondos Mutuos";
					} else if (tipoTema.equals("7")) {
						pTipotema = "Otros";
					}
				}

				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy, hh:mm aaa");
				String pFechahora = formato.format(new Date());
				
				request.setAttribute("pNombres", pNombres);
				request.setAttribute("pApellidos", pApellidos);
				request.setAttribute("pEmail", pEmail);
				request.setAttribute("pTipodocumento", pTipodocumento);
				request.setAttribute("pNdocumento", pNdocumento);
				request.setAttribute("pDireccion", pDireccion);
				request.setAttribute("pTelefono", pTelefono);
				request.setAttribute("pMensaje", pMensaje);
				request.setAttribute("pImporte", pImporte);
				request.setAttribute("pTipoingreso", pTipoingreso);
				request.setAttribute("pDepart", pDepart);
				request.setAttribute("pProv", pProv);
				request.setAttribute("pDist", pDist);
				request.setAttribute("pTipomoneda", pTipomoneda);
				request.setAttribute("pTipotema", pTipotema);
				request.setAttribute("pFechahora", pFechahora);
				
				// envio de correo
				enviarMail(esCliente, pNombres, pApellidos, pEmail, pTipodocumento, pNdocumento, pDireccion, pDepart, pProv, pDist, 
						pTelefono, pFechahora, pMensaje, pTipomoneda, pImporte, pTipoingreso, pTipotema, request);

				/*SolicitudBean s1 = new SolicitudBean();
				s1.setId(1);
				s1.setEsCliente(esCliente);
				s1.setNombres(nombres);
				s1.setApellidos(apellidos);
				s1.setEmail(email);
				s1.setTipoDocumento(tipoDocumento);
				s1.setNumeroDocumento(numDocumento);
				s1.setDireccion(direccion);
				s1.setTelefono(telefono);
				s1.setDepartamento(departamento);
				s1.setProvincia(provincia);
				s1.setDistrito(distrito);
				s1.setFecha(fecha);
				s1.setTipoMensaje(tipoMensaje);
				s1.setTipoTema(tipoTema);
				s1.setMensaje(mensaje);
				lSolicitudBean.add(s1);*/

			} else {
				if(_log.isDebugEnabled()){
					_log.debug("****no se pudo enviar correo, debido a que hay no se ha completado el formulario correctamente.***");
				}
				
				response.setRenderParameter("avisoNombre", avisoNombre);
				response.setRenderParameter("avisoApellido", avisoApellido);
				response.setRenderParameter("avisoEmail", avisoEmail);
				response.setRenderParameter("avisoConfirmacionEmail", avisoConfirmacionEmail);
				response.setRenderParameter("avisoNumeroDocumento", avisoNumeroDocumento);
				response.setRenderParameter("avisoDepartamento", avisoDepartamento);
				response.setRenderParameter("avisoProvincia", avisoProvincia);
				response.setRenderParameter("avisoDistrito", avisoDistrito);
				response.setRenderParameter("avisoDireccion", avisoDireccion);
				response.setRenderParameter("avisoTelefono", avisoTelefono);
				response.setRenderParameter("avisoImporte", avisoImporte);
				response.setRenderParameter("avisoMensaje", avisoMensaje);
				response.setRenderParameter("avisocaptcha", avisocaptcha);
				response.setRenderParameter("isERROR", "true");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void enviarMail(int esCliente, String nombres, String apellidos,
			String email, String tipodocumento, String ndocumento, String direccion, String departamento, 
			String provincia, String distrito, String telefono, String fechahora, String mensaje, String tipomoneda, String importe,
			String tipoingreso, String tipotema, ActionRequest request) {

		String cliente = "";
		//seteando si es cliente
		if (esCliente == 1) {
			cliente = "No";
		} else {
			cliente = "Si";
		}
		
		// Creamos el bean de la solicitud
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy, hh:mm aaa");
		SolicitudContacto solicitud = SolicitudContactoLocalServiceUtil.getInstance();
		solicitud.setEsCliente(esCliente);
		solicitud.setNombres(nombres);
		solicitud.setApellidos(apellidos);
		solicitud.setEmail(email);
		solicitud.setTipoDocumento(tipodocumento);
		solicitud.setNdocumento(ndocumento);
		solicitud.setDireccion(direccion);
		solicitud.setDepartamento(departamento);
		solicitud.setProvincia(provincia);
		solicitud.setDistrito(distrito);
		solicitud.setTelefono(telefono);
		try {
			solicitud.setFecha(formato.parse(fechahora));
		} catch (ParseException pe) {
			_log.error("Error parsing parametro fechahora, asignando el valor actual");
			solicitud.setFecha(new Date());
		} 
		solicitud.setMensaje(mensaje);
		solicitud.setMoneda(tipomoneda);
		solicitud.setImporte(importe);
		solicitud.setTipoMensaje(tipoingreso);
		solicitud.setTipoTema(tipotema);
		
		// Ejecutando el envio de correo
		try {
			// Registramos el envio de correo
			SolicitudContactoLocalServiceUtil.insertarSolicitud(solicitud);

			String correo = (String) cacheContenidoUtil.getValor(JSonUtil.ETIQUETA_CORREO_CONTACTANOS);
			//String correoCapa = (String) cacheContenidoUtil.getValor(JSonUtil.ETIQUETA_CORREO_CONTACTANOS_REMI);
			//String asunto=PortletProps.get("asunto.mailing.contacto");
			String asunto = tipoingreso + " - " + nombres + " " + apellidos + " - " + tipodocumento + " " + ndocumento;
			//String nombre=PortletProps.get("nombre.mailing.contacto");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String rutaImagenes = themeDisplay.getPathThemeImages();

			PortletContext context;
			String template = null;
			String pathLectura;
			context = request.getPortletSession().getPortletContext();
			pathLectura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + Constantes.CARPETA_PAGE_HTML;
			template = getTemplateHTML(request, pathLectura);
			
			template = template.replaceAll("%RUTA_IMAGEN%",(rutaImagenes + "/halcon"));
			template = template.replaceAll("%ESCLIENTE%",cliente);
			template = template.replaceAll("%NOMBRES%",nombres);
			template = template.replaceAll("%APELLIDOS%",apellidos);
			template = template.replaceAll("%EMAIL%",email);
			template = template.replaceAll("%TIPODOCUMENTO%",tipodocumento);
			template = template.replaceAll("%NUMERODOCUMENTO%",ndocumento);
			template = template.replaceAll("%DIRECCION%",direccion);
			template = template.replaceAll("%DEPARTAMENTO%",departamento);
			template = template.replaceAll("%PROVINCIA%",provincia);
			template = template.replaceAll("%DISTRITO%",distrito);
			template = template.replaceAll("%TELEFONO%",telefono);
			template = template.replaceAll("%FECHAHORA%",fechahora);
			template = template.replaceAll("%TIPOMENSAJE%",tipoingreso);
			template = template.replaceAll("%TIPOTEMA%",tipotema);
			template = template.replaceAll("%IMPORTE%",tipomoneda + " " + importe);
			template = template.replaceAll("%MENSAJE%",mensaje);
		    
			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(template);
			//mailMessage.setFrom(new InternetAddress(nombre+"<"+correoCapa+">"));
			mailMessage.setFrom(new InternetAddress("<"+email+">"));
			
			mailMessage.setSubject(asunto);
			mailMessage.setTo(new InternetAddress(correo));
			 
			MailEngine.send(mailMessage);
			
		} catch (Exception e) {
			// Log de error de envio de correo
			_log.info(Constantes.ERROR_MSJ_CORREO);
			LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud), e.getMessage(), Constantes.ERROR_MSJ_CORREO);
		}
	}
	
	
	/**
	 * Obtener imagen.
	 * Fecha: 21/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("traerImagen")
	public void obtenerImagen(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws ImageFormatException, IOException{
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		String captchaId = resourceRequest.getPortletSession().getId();
		
		
		BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, resourceRequest.getLocale());
		JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
		jpegEncoder.encode(challenge);
		
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		resourceResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = (ServletOutputStream) resourceResponse.getPortletOutputStream();
		
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}
	

	/**
	 * Json. Fecha: 21/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("validarCaptcha")
	 protected void json(ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {	
		String cadRetorno;
		PrintWriter writer = null;

		try {
		String captcha = ParamUtil.getString(resourceRequest, "codigo");
		boolean captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);		
		//con esto no valida el captcha
		//boolean captchaPassed = true;
		JSONObject json = JSONFactoryUtil.createJSONObject();;
		
		if (captchaPassed) {
			json.put("error",  "true");
		} else {
			json.put("error",  "false");
		}
		
		cadRetorno = json.toString();
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);

			writer = resourceResponse.getWriter();
			writer.write(cadRetorno);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error al devolver json " + e.toString());
		} finally {
			if(writer != null) {
				writer.close();
			}
		}	
	 }
	
	/**
	 * Cargar fecha, establece la fecha del formulario desde el servidor donde se encuentra
	 * Fecha: 30/01/2013.
	 *
	 * @param f the f
	 * @return the string
	 */
	private String cargarFecha(String f) {
		Date resultado = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String fecha = formato.format(resultado);

		return fecha;
	}
	private String convInicialMay(String entrada)
	{
		String miEntrada=entrada.toLowerCase();
		String[] parts = miEntrada.split(" ");		 
	    StringBuilder unir=new StringBuilder();
	    for (String palabra:parts)
	    	{
	    	 unir.append(palabra.substring(0, 1).toUpperCase() + palabra.substring(1, palabra.length())+" ");
	    	}
		return unir.toString();
	}
	
	private String getTemplateHTML(ActionRequest request, String filePath) throws IOException {
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

		} catch (IOException e) {
			throw e;
		} finally {
			if(bufferLectura != null){
				bufferLectura.close();
		       }		
		}	
		return templateHTML;
	}

	public static String getTemplateHTML(String filePath) throws IOException {
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
			_log.error("Error al leer Template de HTML:" + e.toString());
		} finally {
			if(bufferLectura != null){
				bufferLectura.close();
			}
		}

		return templateHTML;
	}
}
