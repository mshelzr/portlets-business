package pe.com.ibk.halcon.simulacion.controller;

import java.awt.Color;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletContext;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.core.Config;

import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil;
import pe.com.ibk.halcon.simulacion.service.SimuladorDepositoService;
import pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService;
import pe.com.ibk.halcon.simulacion.service.SimuladorHipotecarioService;
import pe.com.ibk.halcon.simulacion.service.SimuladorPersonalService;
import pe.com.ibk.halcon.simulacion.service.SimuladorVehicularService;
import pe.com.ibk.halcon.simulacion.utils.ResultadoSimulacionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.SeguridadUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class ResultadoSimulacionViewController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */

@Controller
@RequestMapping("view")
public class ResultadoSimulacionViewController{

    
    /** The _log. */
    private static Log _log = LogFactoryUtil.getLog(ResultadoSimulacionViewController.class);
    
    /** The j son util. */
    @Autowired
    private CacheSimulacionUtil cacheSimulacionUtil;
	//private static Integer indicadorPortlet=37;
	//private static Integer indicadorController=2;
    /** The simulador vehicular service. */
	@Autowired
	private SimuladorVehicularService simuladorVehicularService;
    
    /** The simulador personal service. */
    @Autowired
    private SimuladorPersonalService simuladorPersonalService;

    /** The simulador deposito service. */
    @Autowired
    private SimuladorDepositoService simuladorDepositoService;
    
    /** The simulador fondos mutuos service. */
    @Autowired
    private SimuladorFondosMutuosService simuladorFondosMutuosService;
    
    /** The simulador hipotecario service. */
    @Autowired
    private SimuladorHipotecarioService simuladorHipotecarioService;
    
    private static Locale locale =  new Locale("es", "ES");
    /**
     * Default view.
     * Fecha: 22/08/2013
     *
     * @param renderRequest the render request
     * @param renderResponse the render response
     * @return the string
     */
    @RequestMapping
    protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse){
    	//Cargar el path
    	JSonUtil.getPath(renderRequest);
    	SimuladoresUtil.inicializarHPC();
    	ResultadoSimulacionUtil.verificarCarpetaDiaria(renderRequest);
    	   	
		String pagina="redireccionar";
		SimuladorBean simulacionSession=SimuladoresUtil.traerSimulacion(renderRequest);
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
		
		if(Validator.isNotNull(simulacionSession)){
			
			//Eliminamos de session
			if (!simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS)) {
				SimuladoresUtil.eliminarSimulacion(renderRequest);
			}
			ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			renderRequest.setAttribute("simPaginaActual",themeDisplay.getLayout().getName(themeDisplay.getLocale()));
			
			Config.set(request.getSession(), Config.FMT_LOCALE, Locale.US);
			if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_VEHICULAR)){
				try {
					_log.info("TIPO VEHICULAR");
					simuladorVehicularService.init();
					simuladorVehicularService.simular(renderRequest,renderResponse,simulacionSession);
					//Generamose el JSON para la cookie
					try{
						String jsonSimulador=SeguridadUtil.encripta(JSONFactoryUtil.serialize(simulacionSession));
						renderRequest.setAttribute("simuladorCookie", jsonSimulador.replaceAll("[\n\r]", ""));
					}catch(Exception e){
						_log.info("Error al encryptar simulacion:"+e.toString());
					}
					pagina="simuladores/vehicular";
					renderRequest.setAttribute("urlSolicitud", ResultadoSimulacionUtil.obtenerURLSolicitud(Integer.parseInt(simulacionSession.getTipoCredito())));
					renderRequest.setAttribute("urlFicha", ResultadoSimulacionUtil.obtenerURLFicha(Integer.parseInt(simulacionSession.getTipoCredito())));
					//Aqui obtenemos la url la cual se envio la info eliminando los paramtros
					renderRequest.setAttribute("urlVolver", ResultadoSimulacionUtil.obtenerURLVolverSimular(request));
					ResultadoSimulacionUtil.registrarGestionPeticion(renderRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.vehicular"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_CRE_VEHICULAR);
				} catch (BusinessException e) {
					String asunto = Propiedades.getResourceBundle("resultado.simulacion.view.controller.vehicular.defaultView");
					LogErrorUtil.registrarError(JSonUtil.getStringJson(simulacionSession), e.getTrazaMessage(), asunto);
					_log.error(asunto,e);
					pagina = "paginaError";
				}
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_HIPOTECARIO)){
				try {
					_log.info("TIPO HIPOTECARIO");
					simuladorHipotecarioService.init();
					simuladorHipotecarioService.simular(renderRequest,renderResponse,simulacionSession);
					//Generamose el JSON para la cookie
					try{
						String jsonSimulador=SeguridadUtil.encripta(JSONFactoryUtil.serialize(simulacionSession));
						renderRequest.setAttribute("simuladorCookie", jsonSimulador.replaceAll("[\n\r]", ""));
					}catch(Exception e){
						_log.error("Error al encryptar simulacion:",e);
					}
					pagina="simuladores/hipotecario";
					renderRequest.setAttribute("urlSolicitud",  ResultadoSimulacionUtil.obtenerURLSolicitud(Integer.parseInt(simulacionSession.getTipoCredito())));
					renderRequest.setAttribute("urlFicha", ResultadoSimulacionUtil.obtenerURLFicha(Integer.parseInt(simulacionSession.getTipoCredito())));
					//Aqui obtenemos la url la cual se envio la info eliminando los paramtros
					renderRequest.setAttribute("urlVolver", ResultadoSimulacionUtil.obtenerURLVolverSimular(request));
					ResultadoSimulacionUtil.registrarGestionPeticion(renderRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.hipotecario"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_CRE_HIPOTECARIO);
				} catch (BusinessException e) {
					String asunto = Propiedades.getResourceBundle("resultado.simulacion.view.controller.hipotecario.defaultView");
					LogErrorUtil.registrarError(JSonUtil.getStringJson(simulacionSession), e.getTrazaMessage(), asunto);
					_log.error(asunto,e);
					pagina = "paginaError";
				}
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_PERSONAL)){
				try {
					simuladorPersonalService.init();
					simuladorPersonalService.simular(renderRequest, renderResponse, simulacionSession);
					//Generamose el JSON para la cookie
					try{
						String jsonSimulador=SeguridadUtil.encripta(JSONFactoryUtil.serialize(simulacionSession));
						renderRequest.setAttribute("simuladorCookie", jsonSimulador.replaceAll("[\n\r]", ""));
					}catch(Exception e){
						_log.error("Error al encryptar simulacion:"+e.toString());
					}
					pagina="simuladores/personal";
					renderRequest.setAttribute("urlSolicitud",  ResultadoSimulacionUtil.obtenerURLSolicitud(Integer.parseInt(simulacionSession.getTipoCredito())));
					renderRequest.setAttribute("urlFicha", ResultadoSimulacionUtil.obtenerURLFicha(Integer.parseInt(simulacionSession.getTipoCredito())));
					//Aqui obtenemos la url la cual se envio la info eliminando los paramtros
					renderRequest.setAttribute("urlVolver", ResultadoSimulacionUtil.obtenerURLVolverSimular(request));
					ResultadoSimulacionUtil.registrarGestionPeticion(renderRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.personal"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_PRESTAMO);
				} catch (BusinessException e) {
					String asunto = Propiedades.getResourceBundle("resultado.simulacion.view.controller.personal.defaultView");
					LogErrorUtil.registrarError(JSonUtil.getStringJson(simulacionSession), e.getTrazaMessage(), asunto);
					_log.error(asunto+e.toString());
					pagina = "paginaError";
				}
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_PLAZO_FIJO)){
				simuladorDepositoService.simular(renderRequest, renderResponse, simulacionSession);
				//Generamos el JSON para la cookie
				try{
					String jsonSimulador=SeguridadUtil.encripta(JSONFactoryUtil.serialize(simulacionSession));
					renderRequest.setAttribute("simuladorCookie", jsonSimulador.replaceAll("[\n\r]", ""));
				}catch(Exception e){
					_log.error("Error al encryptar simulacion:"+e.toString());
				}
				//Aqui termina el json para la cookie
				pagina="simuladores/deposito";
				renderRequest.setAttribute("urlFicha", PortletProps.get("simulador.plazofijo.ficha"));
				//Aqui obtenemos la url la cual se envio la info eliminando los paramtros
				renderRequest.setAttribute("urlVolver", ResultadoSimulacionUtil.obtenerURLVolverSimular(request));
				ResultadoSimulacionUtil.registrarGestionPeticion(renderRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.deposito"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_DEP_PLAZO);
			}else if(simulacionSession.getTipoSimulador().equalsIgnoreCase(SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS)){
				simuladorFondosMutuosService.simular(renderRequest, renderResponse, simulacionSession);
				pagina="simuladores/fondosmutuos";
				ResultadoSimulacionUtil.registrarGestionPeticion(renderRequest, JSonUtil.IP, PortletProps.get("codigo.grupo.fondos"), JSonUtil.ETIQUETA_RANGO_PETICION_SIM_FON_MUTUOS);
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

    /**
     * Server resource.
     * Fecha: 22/08/2013
     *
     * @param request the request
     * @param response the response
     */
    @ResourceMapping("descargarPDF")
	public void serverResource(ResourceRequest request,ResourceResponse response) {
    	OutputStream elFichero = null;
		try {
			
			String filename = ParamUtil.getString(request, "file");
			String name = ParamUtil.getString(request, "name","");
			String ipServer;
			int puertoServer;
			
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			
			ipServer = httpReq.getLocalAddr();
			puertoServer = httpReq.getLocalPort();
			
			PortletContext context = request.getPortletSession().getPortletContext();
									
		    String html=ResultadoSimulacionUtil.getTemplateHTML(request, context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) +ResultadoSimulacionUtil.getCarpetaDiaria()+ filename);
		    html=HtmlUtil.stripBetween(html, "meta");
		    html=HtmlUtil.stripBetween(html, "a");
		    html=HtmlUtil.stripComments(html);
		    html=html.replaceFirst("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">", "");
		    html=html.replaceFirst("<html xmlns=\"http://www.w3.org/1999/xhtml\">", "<html>");
		    html=html.replaceFirst("</head>", "<style type=\"text/css\">@page {	margin: 2px;} </style></head>");
		    
		    ThemeDisplay themeDisplay=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		    
		    html = html.replaceAll(themeDisplay.getPortalURL(), "http://"+ipServer+":"+puertoServer);
		    		  
			ITextRenderer iTextRenderer = new ITextRenderer();
			iTextRenderer.setDocumentFromString(html);
			iTextRenderer.layout();
			
   		 	response.setContentType("application/pdf");
   		 	response.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=simulacion"+name+".pdf");
			elFichero =response.getPortletOutputStream(); 
			iTextRenderer.createPDF(elFichero);
	        elFichero.flush();
	        elFichero.close();
			
		} catch (Exception e) {
			_log.error(e);
		} finally{
			IOUtils.closeQuietly(elFichero);
		}
		
		//JSonUtil.LogAuditoria(request, indicadorPortlet, indicadorController);
	}
    
    
	/**
	 * Volver simular.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("redireccionSimulador")
	protected void volverSimular(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		JSONObject json;
		json = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		try {
			String comportamientoPortlet,url;
			comportamientoPortlet = ParamUtil.getString(resourceRequest, "tipSim");
			url = ParamUtil.getString(resourceRequest, "url","/");
			//Buscar Cookies y cargamos el bean a session
			SimuladorBean ultimaSimulacionBeanCookie=SimuladoresUtil.traerSimulacionCookieBean(resourceRequest,comportamientoPortlet);
			
			if(Validator.isNotNull(ultimaSimulacionBeanCookie)){
				
				if(Validator.isNotNull(ultimaSimulacionBeanCookie.getCuotaInicial())){
					Double montoFinanciar=Double.parseDouble(ultimaSimulacionBeanCookie.getValorBien())*(1.0D-Double.parseDouble(ultimaSimulacionBeanCookie.getCuotaInicial())/100.0D);
					ultimaSimulacionBeanCookie.setMontoPrestamo(montoFinanciar+"");
				}
				SimuladoresUtil.registrarSimulacion(resourceRequest, ultimaSimulacionBeanCookie);
			}
			
			json.put("url",url);

			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(json.toString());
			writer.flush();
		} catch (Exception e) {
			_log.error("Error al generar la session de simulacion:",e);
		} finally{
			IOUtils.closeQuietly(writer);
		}
			
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);

	}
	
	/*METODOS DE FONDOS MIGRAR GOHAN A SERVICE*/
	/**
	 * Cambiar_periodo.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("cambiar_periodo")	
	public void cambiarPeriodo(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	{
		
		SimuladorBean simulacionSession=SimuladoresUtil.traerSimulacion(resourceRequest);
		JSONObject json = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;			
		json.put("url", "");
		
		if(Validator.isNotNull(simulacionSession))
		{
			int totalPuntos = simulacionSession.getTotalPuntos();
			totalPuntos = getTotalPuntos(totalPuntos, Integer.parseInt(simulacionSession.getPlazoCredito()), -1);
			int tiempoInversion = Integer.parseInt(resourceRequest.getParameter("periodo"));
			totalPuntos =  getTotalPuntos(totalPuntos, tiempoInversion, 1);
			
			simulacionSession.setPlazoCredito(String.valueOf(tiempoInversion));		
			simulacionSession.setTotalPuntos(totalPuntos);
			simuladorFondosMutuosService.simular(resourceRequest,resourceResponse,simulacionSession);
			SimuladoresUtil.registrarSimulacion(resourceRequest, simulacionSession);
			json.put("flg", "1");
		}
		else
		{
			json.put("flg", "2");		
		}		
		String retorno = json.toString();
			
		try 
		{
			writer = resourceResponse.getWriter();

			writer.write(retorno);
			writer.flush();
		}
		catch (IOException e) 
		{
			_log.error(e);
		} finally{
			IOUtils.closeQuietly(writer);
		}
		
	}	
	
	private int getTotalPuntos(int totalPuntos,int tiempoInvertir,int signo){
		switch (tiempoInvertir) {
		case 1:
			totalPuntos = totalPuntos + (2*signo);
			break;
		case 2:
		case 3:
		case 4:
			totalPuntos = totalPuntos + (4*signo) ;
			break;
		case 5:
		case 6:
			totalPuntos = totalPuntos + (6*signo);
			break;
		default:
			totalPuntos = totalPuntos + (8*signo);
		}
		return totalPuntos;
	}
	
	/**
	 * Calcular_solicitud.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("form_lightbox")
	public void calcularSolicitud(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	{
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String retorno = StringPool.BLANK;
		PrintWriter writer = null;	
		//String urlDetalle = "******";
		
		int tipoMoneda = Integer.parseInt(resourceRequest.getParameter("tipoMoneda_light"));
		double valorInversion = Double.parseDouble(resourceRequest.getParameter("monto_inversion_light"));
		
		
		Double valorInversionDb;		
		
			if(tipoMoneda == 1)
			{				
				valorInversionDb = Double.parseDouble(cacheSimulacionUtil.getValor(JSonUtil.VALOR_MONTO_SOLES_FONDOS_MUTUOS).toString());				
			}
			else
			{
				valorInversionDb = Double.parseDouble(cacheSimulacionUtil.getValor(JSonUtil.VALOR_MONTO_DOLARES_FONDOS_MUTUOS).toString());
			}
			
			
			if(valorInversion < valorInversionDb)			 
			{
				json.put("flag", "enlace");	
			}
			else if(valorInversion >= valorInversionDb)
			{
				json.put("flag", "nueva");
				StringBuilder urlSolicitud=new StringBuilder();
				urlSolicitud.append(PropsUtil.get("SOLICITUDES.ALL.PREFIX"));
				urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_FONDOS_MUTUOS"));
				urlSolicitud.append(LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.FONDOS_MUTUOS"));
				urlSolicitud.append("-1");
				
				//Aqui se pasa los datos para simulador
				json.put("urlSolicitud", urlSolicitud.toString());
			}
		
		
		retorno = json.toString();
		try {
			writer = resourceResponse.getWriter();
			
			writer.write(retorno);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error de Formulario de Solicitud",e);
		} finally{
			IOUtils.closeQuietly(writer);
		}
		
	}
	
	/**
	 * Crear_pdf.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("crearPDF")
	public void crearPdf(ResourceRequest resourceRequest, ResourceResponse resourceResponse) 
	{			 
		JSONObject json = JSONFactoryUtil.createJSONObject();
		String retorno = StringPool.BLANK;
		PrintWriter writer = null;			
		String _svg = resourceRequest.getParameter("diseno[0]");
		String title = resourceRequest.getParameter("title");
		String datos = resourceRequest.getParameter("datos");
		String urlImagenChart = resourceRequest.getParameter("urlImagenChart");
		String optionGroup = resourceRequest.getParameter("optionGroup");
				
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);				
		String urlDetalle = StringPool.BLANK;
		Document documento = null;
		java.io.OutputStream pngOstream = null;
		try 
		{
			PortletContext context;
			context = resourceRequest.getPortletSession().getPortletContext();
			Date fechaActual = new Date();
			long codigo = fechaActual.getTime();			
			ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			urlDetalle = themeDisplay.getURLPortal()+ResultadoSimulacionUtil.CARPETA_PORTLET+ResultadoSimulacionUtil.CARPETA_TEMPLATE+ResultadoSimulacionUtil.getCarpetaDiaria()+"/graf_"+codigo+".pdf";
			String pathEscritura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.getCarpetaDiaria()+ "/graf_" + codigo;
			String pathEscrituraImagen = context.getRealPath("/grafico");
			
			String imagen = "";
			if (_svg != null) {
				String contenidoSVG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.0//EN' 'http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd'>"+_svg;
				//Si es el navegador es Mozilla quitamos el dominio que produce un error.
				String puerto = "";
				if (resourceRequest.getServerPort() != 80) {
					puerto = ":" + resourceRequest.getServerPort();
				}
				String ruta = resourceRequest.getScheme() + "://" + resourceRequest.getServerName() + puerto +"/"+StringUtils.substringBefore(themeDisplay.getURLCurrent(), "?").replaceAll("/web/guest/", "");
				
				contenidoSVG = contenidoSVG.replaceAll("web/guest/", "").replaceAll(ruta, "");
				ResultadoSimulacionUtil.generateHTML(resourceRequest, contenidoSVG, pathEscritura+".svg");
				String svgURIInput = new File(pathEscritura+".svg").toURI().toURL().toString();
				TranscoderInput inputSvgImage = new TranscoderInput(svgURIInput);
				imagen = pathEscritura+".png";
				
				pngOstream = new FileOutputStream(imagen);
				TranscoderOutput outputPNGImage = new TranscoderOutput(pngOstream);
				PNGTranscoder myConverter = new PNGTranscoder();        
				myConverter.transcode(inputSvgImage, outputPNGImage);
				pngOstream.flush();
			} else {
				imagen = urlImagenChart;
			}
			
			documento = new Document();
			String fileNamePdf = pathEscritura+".pdf";
			FileOutputStream archivo = new FileOutputStream(fileNamePdf);
		    
		    PdfWriter.getInstance(documento, archivo);
		    documento.open();
		    
		    Paragraph tituloDocumento = new Paragraph("Resultado de Simulación Fondos Mutuos",new Font(Font.HELVETICA, 16f, Font.NORMAL, new Color(70, 118,179)));		    
		    documento.add(tituloDocumento);
		    simuladorFondosMutuosService.addEmptyLine(documento, 3);
		    simuladorFondosMutuosService.createTableHeader(documento, title ,optionGroup,pathEscrituraImagen);
			
		    
		    Image grafico = Image.getInstance(imagen);
		    grafico.scaleAbsolute(520,220);		    
		    documento.add(grafico);
		    
		    simuladorFondosMutuosService.createTableListaFondosMutuos(documento , datos);
		    
		} catch (IOException e) {
			_log.error("No se pudo leer los recursos",e);
		} catch (TranscoderException e) {
			_log.error(e);
		} catch (DocumentException e) {
			_log.error(e);
		}finally{
			if (documento != null) {
				documento.close();
			}
			IOUtils.closeQuietly(pngOstream);
		}	
		json.put("url", urlDetalle);
		retorno = json.toString();
		try {
			writer = resourceResponse.getWriter();
			
			writer.write(retorno);
			writer.flush();
		} catch (IOException e) {
			_log.error("Error de FM",e);
		} finally{
			IOUtils.closeQuietly(writer);
		}
	}	
	
	@ResourceMapping("forzarDescargaPDF")
	public void forzarDescargaPDF(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException{
		
		String paramUrl = resourceRequest.getParameter("url"); //el URL enviado como parametro
		
        URL url = new URL(paramUrl);

        resourceResponse.setContentType("application/octet-strem");
        resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename="+url.getFile());
        
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream(); //conectando para descargar
        OutputStream out = new DataOutputStream(resourceResponse.getPortletOutputStream());

        byte[] buffer = new byte[1024];
        int sizeRead = 0;
        while ((sizeRead = in.read(buffer)) >= 0) { //leyendo del host
            out.write(buffer, 0, sizeRead); //escribiendo para el navegador
        }
        in.close(); // y cerrando
        out.close(); // todo
		
	}
}
