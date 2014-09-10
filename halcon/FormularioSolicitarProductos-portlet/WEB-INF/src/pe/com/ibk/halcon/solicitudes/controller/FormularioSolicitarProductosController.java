package pe.com.ibk.halcon.solicitudes.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil;
import pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService;
import pe.com.ibk.halcon.solicitudes.utils.Constantes;
import pe.com.ibk.halcon.solicitudes.utils.Util;

import com.exp.portlet.halcon.utils.AsciiUtils;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.TextoUtil;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.dto.ProductoComplementarioBean;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.dto.SolicitudProductoBean;
import com.ext.portlet.halcon.dto.TelefonoLeadBean;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.util.portlet.PortletProps;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;


/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class FormularioSolicitarProductosController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class FormularioSolicitarProductosController {
	
	//Declaración de variables globales
	/** The solicitud producto bean. */
	List<SolicitudProductoBean> solicitudProductoBean = new ArrayList<SolicitudProductoBean>();
	
	
	/** The paginas hijas. */
	public static String paginasHijas = "";
	
	/** The indicador mailing. */
	public  Integer indicadorMailing = 0;
	
	/** The etiqueta producto siebel. */
	public static String etiquetaProductoSiebel = "";
	//private static Integer indicadorPortlet = 23;
	//private static Integer indicadorController = 1;
	/** The nombre_producto. */
	private static String nombre_producto = "";
	//private static String CARPETA_TEMPLATE = "/template";
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(FormularioSolicitarProductosController.class);
	
	/** The obtener url. */
	private String obtenerURL = "";
	
	private String obtenerURLCH = "";
	private String obtenerURLCV = "";
	private String obtenerURLCS = "";
	private String obtenerURLFM = "";
	private String obtenerURLPP = "";
	private String obtenerURLPPA = "";
	private String obtenerURLSS = "";
	private String obtenerURLTC = "";
	
	/** The mensaje confirmacion. */
	private String mensajeConfirmacion = "";
	

	
	private Integer numeroPaso1 = 1;
	private Integer numeroPaso2 = 2;
	private Integer numeroPaso3 = 3;
	private Integer numeroPaso4 = 4;
	
	private Boolean  estadoPaso1Credito = false;
	private Boolean  estadoPaso2Credito = false;
	
	private Boolean  estadoPaso1Vehicular = false;
	private Boolean  estadoPaso2Vehicular = false;
	
	private Boolean  estadoPaso1Hipotecario = false;
	private Boolean  estadoPaso2Hipotecario = false;
	
	private Boolean  estadoPaso1Personal = false;
	private Boolean  estadoPaso2Personal = false;
	
	private Boolean  estadoPaso1Mutuos = false;
	private Boolean  estadoPaso2Mutuos = false;
	
	private Boolean  estadoPaso1Sueldo = false;
	private Boolean  estadoPaso2Sueldo = false;
	
	private Boolean  estadoPaso1Soat = false;
	private Boolean  estadoPaso2soat = false;
	
	private Boolean  estadoPaso1Aprobado = false;
	private Boolean  estadoPaso2Aprobado = false;
	
	/** The json util. */
	//JSonUtil jSonUtil=new JSonUtil();
	
	/** The captcha service. */
	@Autowired
	private GenericManageableCaptchaService captchaService;
	
	/** The formulario solicitar productos service. */
	@Autowired
	private FormularioSolicitarProductosService formularioSolicitarProductosService;
	
 	@Autowired
	private CacheSolicitudesUtil cachejsonUtil;
	

	//Metodo que se muestra al inicializar el portlet.
	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(Model model, RenderRequest renderRequest, RenderResponse renderResponse) {
	
		//*****Linea por default para todos los portlet******
		JSonUtil.getPath(renderRequest);
		Util.verificarCarpetaDiaria(renderRequest);
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String nombre_producto_url = HtmlUtil.escape(HtmlUtil.extractText(ParamUtil.getString(httpReq, "sol")));
		renderRequest.getPortletSession().setAttribute("nombre_producto_url",nombre_producto_url,PortletSession.PORTLET_SCOPE);
		renderRequest.setAttribute("nombre_producto_url", nombre_producto_url);
		nombre_producto = HtmlUtil.escape(HtmlUtil.extractText(ParamUtil.getString(httpReq, "sol")));
		validarTipoDocumento(renderRequest);
		//***************************************************
		//AuditoriaHalcon.auditar(auditMessage);
		//AuditoriaHalcon.auditar(evento, message, infoAdicional, resq);
		//AuditoriaHalcon.auditar(evento, clase, clasePK, message, infoAdicional, resq);		
		//formularioSolicitarProductosService.(solicitud, resourceRequest););				
			
		//Extraemos los valores de UTM en la URL
		PortletSession pSession=renderRequest.getPortletSession();
		String utm_source=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_SOURCE",PortletSession.APPLICATION_SCOPE);
		String utm_medium=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_MEDIUM",PortletSession.APPLICATION_SCOPE);
		String utm_content=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_CONTENT",PortletSession.APPLICATION_SCOPE);
		String utm_campaign=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_CAMPAIGN",PortletSession.APPLICATION_SCOPE);
				
		if (ValidatorUtils.isNotNull(utm_source) && ValidatorUtils.isNotNull(utm_medium) && ValidatorUtils.isNotNull(utm_content) && ValidatorUtils.isNotNull(utm_campaign)) {
			getSolicitud(renderRequest.getPortletSession()).setUtmSource(utm_source);
			getSolicitud(renderRequest.getPortletSession()).setUtmContent(utm_content);
			getSolicitud(renderRequest.getPortletSession()).setUtmMedium(utm_medium);
			getSolicitud(renderRequest.getPortletSession()).setUtmCampaing(utm_campaign);
			
		}else{
			getSolicitud(renderRequest.getPortletSession()).setUtmSource("");
			getSolicitud(renderRequest.getPortletSession()).setUtmContent("");
			getSolicitud(renderRequest.getPortletSession()).setUtmMedium("");
			getSolicitud(renderRequest.getPortletSession()).setUtmCampaing("");
		}
		
		//Ingresamos el producto principal
		ProductoComplementarioBean productoPrincipal = new ProductoComplementarioBean();
		productoPrincipal.setPrincipalidad(PortletProps.get("valor.ws.principalidadProducto"));

		String tipoSolicitudProducto = nombre_producto;
		
		String urlProducto = HtmlUtil.escape(HtmlUtil.extractText(StringUtils.substringBefore(ParamUtil.getString(httpReq, "pro"), "?"))) ;
		
		etiquetaProductoSiebel=SolicitudProductoLocalServiceUtil.getEtiquetaProductoByFriendlyURL("/"+urlProducto);

		String siebel="";
		try {
			 siebel = cachejsonUtil.getSiebel(etiquetaProductoSiebel);
			 productoPrincipal.setIdProducto(siebel);

		} catch (IOException e1) {
			return "error";
		}
		getSolicitud(renderRequest.getPortletSession()).setEtiqueta(etiquetaProductoSiebel);
		getSolicitud(renderRequest.getPortletSession()).setSiebel(siebel);
		
		renderRequest.setAttribute("formato", Util.obtenerValueProducto(nombre_producto));

		cargaMensajes(model, renderRequest);
		
		Integer paso = ParamUtil.getInteger(httpReq, "paso");
//		_log.info("Paso obtenido: "+paso);

		String solicitudValor=null;
		
		formularioSolicitarProductosService.listarComplementario(renderRequest, model, getSolicitud(renderRequest.getPortletSession()),productoPrincipal);			
		
		nombre_producto = nombre_producto.replaceAll("-", "_");
		nombre_producto = nombre_producto.toUpperCase();

		//Verificar si existe en sesion el dni
		SessionBean sBean;
		sBean=SessionUtil.traerSession(renderRequest);
		String numeroDocumento=sBean.getNumDoc();
		String tipoDocumento=sBean.getTipoDoc();
		String numeroActDocumento=(String) pSession.getAttribute("ndocumento",PortletSession.PORTLET_SCOPE);
			
		if (ValidatorUtils.isNull(numeroDocumento)) {
			numeroDocumento="";
		}else if (ValidatorUtils.isNull(numeroActDocumento)) {
			numeroActDocumento="";
		}						
		
		if(sBean.getIndicador()==1 && ValidatorUtils.isNotNull(getSolicitud(renderRequest.getPortletSession())))
		{
			if (!numeroDocumento.equals(numeroActDocumento)) {
				
				limpiarSesion(renderRequest);	
				pSession.setAttribute("tipDoc", tipoDocumento, PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("ndocumento", numeroDocumento, PortletSession.PORTLET_SCOPE);
			}else {
				pSession.setAttribute("tipDoc", tipoDocumento, PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("ndocumento", numeroDocumento, PortletSession.PORTLET_SCOPE);
		}
		}
		
		String prefijo = "SOLICITUDES.ALL.PREFIX"; 
		obtenerURL = PropsUtil.get(prefijo) + "/" + tipoSolicitudProducto + "/" + urlProducto + "-";

//		_log.info("obtenerURL  :" + obtenerURL);
		renderRequest.setAttribute("obtenerURL",obtenerURL);
		
		renderRequest.setAttribute("paso",paso);
		renderRequest.setAttribute("numeroPaso1",numeroPaso1);
		renderRequest.setAttribute("numeroPaso2",numeroPaso2);
		renderRequest.setAttribute("numeroPaso3",numeroPaso3);
		renderRequest.setAttribute("numeroPaso4",numeroPaso4);
		
		renderRequest.setAttribute("estadoPaso1Credito",estadoPaso1Credito);
		renderRequest.setAttribute("estadoPaso2Credito",estadoPaso2Credito);
		
		renderRequest.setAttribute("estadoPaso1Vehicular",estadoPaso1Vehicular);
		renderRequest.setAttribute("estadoPaso2Vehicular",estadoPaso2Vehicular);
		
		renderRequest.setAttribute("estadoPaso1Hipotecario",estadoPaso1Hipotecario);
		renderRequest.setAttribute("estadoPaso2Hipotecario",estadoPaso2Hipotecario);
		
		renderRequest.setAttribute("estadoPaso1Personal",estadoPaso1Personal);
		renderRequest.setAttribute("estadoPaso2Personal",estadoPaso2Personal);
		
		renderRequest.setAttribute("estadoPaso1Mutuos",estadoPaso1Mutuos);
		renderRequest.setAttribute("estadoPaso2Mutuos",estadoPaso2Mutuos);
		
		renderRequest.setAttribute("estadoPaso1Sueldo",estadoPaso1Sueldo);
		renderRequest.setAttribute("estadoPaso2Sueldo",estadoPaso2Sueldo);
		
		renderRequest.setAttribute("estadoPaso1Soat",estadoPaso1Soat);
		renderRequest.setAttribute("estadoPaso2soat",estadoPaso2soat);
		
		renderRequest.setAttribute("estadoPaso1Aprobado",estadoPaso1Aprobado);
		renderRequest.setAttribute("estadoPaso2Aprobado",estadoPaso2Aprobado);
		renderRequest.setAttribute("anhoActual",TiempoUtil.getAnoActual());
		formularioSolicitarProductosService.traerBeanSimulador(renderRequest, getSolicitud(renderRequest.getPortletSession()));
		
		/* ############################### CREDITO HIPOTECARIO ############################### */
		if (nombre_producto.equals(Util.CREDITO_HIPOTECARIO)) {
			obtenerURLCH=obtenerURL;
			indicadorMailing = 1;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarCreditoHipotecario/creditoHipotecario";
			RangoBean RANGO_SLIDER_PERFILADOR_HIPOTECARIO;
			try {
				RANGO_SLIDER_PERFILADOR_HIPOTECARIO = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_SOLICITAR_CREDITO_HIPOTECARIO_SLIDER);
				renderRequest.setAttribute("RANGO_SLIDER_PERFILADOR_HIPOTECARIO"  , getJSONValues(RANGO_SLIDER_PERFILADOR_HIPOTECARIO));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/* ############################### CREDITO VEHICULAR ################################## */
		else if (nombre_producto.equals(Util.CREDITO_VEHICULAR)) {
			obtenerURLCV=obtenerURL;
			indicadorMailing = 2;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarCreditoVehicular/creditoVehicular";
			RangoBean RANGO_SLIDER_PERFILADOR_VEHICULAR;
			try {
				RANGO_SLIDER_PERFILADOR_VEHICULAR = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_SOLICITAR_CREDITO_VEHICULAR_SLIDER);
				renderRequest.setAttribute("RANGO_SLIDER_PERFILADOR_VEHICULAR"  , getJSONValues(RANGO_SLIDER_PERFILADOR_VEHICULAR));
			} catch (Exception e) {
				_log.error(e);
			}
		}
		/* ################################# CUENTA SUELDO #################################### */
		else if (nombre_producto.equals(Util.CUENTA_SUELDO)) {
			obtenerURLCS=obtenerURL;
			indicadorMailing = 3;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarCuentaSueldo/cuentaSueldo";
		}
		/* ################################# FONDOS MUTUOS #################################### */
		else if (nombre_producto.equals(Util.FONDO_MUTUO)) {
			obtenerURLFM=obtenerURL;
			indicadorMailing = 4;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarFondosMutuos/fondosMutuos";
		}
		/* ################################## PRESTAMO PERSONAL ############################### */
		else if (nombre_producto.equals(Util.PRESTAMO_PERSONAL)) {
			obtenerURLPP=obtenerURL;
			indicadorMailing = 5;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarPrestamoPersonal/prestamoPersonal";
			RangoBean RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER;
			try {
				RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER);
				renderRequest.setAttribute("RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER"  , getJSONValues(RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER));
			} catch (Exception e) {
				_log.error(e);
			}
		}
		/* ############################## PRODUCTO PRE APROBADO ############################### */
		else if (nombre_producto.equals(Util.PRODUCTO_PREAPROBADO)) {
			obtenerURLPPA=obtenerURL;
			indicadorMailing = 6;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarProductoPreAprobado/productoPreAprobado";
		}
		/* ################################ SEGURO SOAT ####################################### */
		else if (nombre_producto.equals(Util.SEGURO_SOAT)) {
			obtenerURLSS=obtenerURL;
			indicadorMailing = 7;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarSeguroSoat/seguroSoat";
		}
		/* ################################ TARJETA DE CREDITO ################################ */
		else if (nombre_producto.equals(Util.TARJETA_CREDITO)) {
			obtenerURLTC=obtenerURL;
			indicadorMailing = 8;
			getSolicitud(renderRequest.getPortletSession()).setIndicadorMailing(indicadorMailing);

			solicitudValor="SolicitarTarjetaCredito/tarjetaCredito";
			RangoBean RANGO_SLIDER_PERFILADOR_TARJETA;
			try {
				RANGO_SLIDER_PERFILADOR_TARJETA = (RangoBean) cachejsonUtil.getRango(JSonUtil.ETIQUETA_RANGO_SOLICITAR_TARJETA_DE_CREDITO_SLIDER);
				renderRequest.setAttribute("RANGO_SLIDER_PERFILADOR_TARJETA"  , getJSONValues(RANGO_SLIDER_PERFILADOR_TARJETA));
			} catch (Exception e) {
				_log.error(e);
			}
		}
		/* ################################## DEFAULT ######################################### */
		else {
			indicadorMailing = 99;
		}
		if(indicadorMailing.equals(99)){
			return "view";
		}else{
			paginasHijas=obtenerTree(renderRequest);
			
			return obtenerViewPagina(solicitudValor,paso, renderRequest,productoPrincipal);
		}
	}
	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en tarjeta de credito
	/**
	 * Seguir paso1 tarjeta credito.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_tj")
	protected void seguirPaso1TarjetaCredito(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//		_log.info("entro a paso1_tj");
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo", "cboestadocivil",
						"cboestadocivilTexto", "cbosituacionlaboral", "cbosituacionlaboralTexto", "ruc", "valorRenta","checkCodProducto");

				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setIdEstadoCivil(mapCampos.get("cboestadocivil"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoCivil(mapCampos.get("cboestadocivilTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdSituacionLaboral(mapCampos.get("cbosituacionlaboral"));
				getSolicitud(resourceRequest.getPortletSession()).setSituacionLaboral(mapCampos.get("cbosituacionlaboralTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setRuc(mapCampos.get("ruc"));
				getSolicitud(resourceRequest.getPortletSession()).setRentaMensual(mapCampos.get("valorRenta"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoCredito(Constantes.TIPO_CREDITO_TARJETA_CREDITO);
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Credito(true);
				estadoPaso1Credito = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Credito();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
			  // cuando si hay error
			  o.put("resp", 0);
			  o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_tj");
			e.printStackTrace();
		}
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}


	/**
	 * Seguir paso2 tarjeta credito.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_tj")
	protected void seguirPaso2TarjetaCredito(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			PortletSession pSession = resourceRequest.getPortletSession();

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto", "celular", "telFijo", "telTrabajo", "anexo", "email", "confEmail" , "checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),"","");
				
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Credito(true);				
				estadoPaso2Credito = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Credito();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_tj");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso3 tarjeta credito.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_tj")
	protected void seguirPaso3TarjetaCredito(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		try {
			List<String> strErrors = new ArrayList<String>();

			String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
			
			setListProductComplementarios(checkCodProducto, resourceRequest);

			PortletSession pSession = resourceRequest.getPortletSession();
			guardarEnSession(resourceRequest, "checkCodProducto");

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.TARJETA_CREDITO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_TAR_CREDITO);
				
				if (validarPeticion) {
					//Creamos el pintado para los productos complementarios
					if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
						List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
						List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
						for (int i = 1; i < lista.size(); i++) {
							listaUltima.add(lista.get(i));
						}
						pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
					}else {
						pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
					}
				
					Integer codigoRespCalificacion = formularioSolicitarProductosService.comprobarPrecalificacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,Util.TARJETA_CREDITO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_TAR_CREDITO);
					
					if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PRE_CALIFICA) {
						// pre-califico
						
						mensajeConfirmacion=Constantes.MSJ_TARJETA_CREDITO;
						pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLTC+1, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
				
					} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_NO_PROCEDE) {	
						mensajeConfirmacion=Constantes.MSJ_RECHAZO;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", "", PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 0, PortletSession.PORTLET_SCOPE);
				
					} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE) {	
						mensajeConfirmacion=Constantes.MSJ_ERROR;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLTC+1, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
				
					} else if(codigoRespCalificacion == Constantes.ESTADO_ADQ_ERROR){
						//Mandamos a la pagina de error
						
						getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
						inicializarEstadosFormulario();
						//limpiarSesion(resourceRequest);
						//limpiarVariablesTema(resourceRequest);
						o.put("resp", 2);
						resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLTC, PortletSession.APPLICATION_SCOPE);
					}
				}else{
					getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
					
					inicializarEstadosFormulario();
					//limpiarSesion(resourceRequest);
					//limpiarVariablesTema(resourceRequest);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLTC, PortletSession.APPLICATION_SCOPE);
					o.put("resp", 2);
				}
			}
			else {
				// cuando si hay error de validacion cliente
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
		
		}catch (Exception e) {
			getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
			inicializarEstadosFormulario();
			//limpiarSesion(resourceRequest);
			//limpiarVariablesTema(resourceRequest);
			o.put("resp", 2);
			resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLTC, PortletSession.APPLICATION_SCOPE);
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			// 
			_log.error("Error en paso3_tj : "+e.getMessage());
		}
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}

	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en cuenta sueldo
	/**
	 * Seguir paso1 cuenta sueldo.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_cs")
	protected void seguirPaso1CuentaSueldo(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo", "razonSocial", "checkCodProducto");
				
				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setRazonSocial(mapCampos.get("razonSocial"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Sueldo(true);				
				estadoPaso1Sueldo = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Sueldo();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_cs");
			e.printStackTrace();
		}
	}
	
	/**
	 * Seguir paso2 cuenta sueldo.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_cs")
	protected void seguirPaso2CuentaSueldo(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				PortletSession pSession = resourceRequest.getPortletSession();
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto", "celular", "telFijo", "telTrabajo", "anexo", "email", "confEmail", "checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),"","");
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Sueldo(true);				
				estadoPaso2Sueldo = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Sueldo();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_cs");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso3 cuenta sueldo.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_cs")
	protected void seguirPaso3CuentaSueldo(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		List<String> strErrors = new ArrayList<String>();
		
		String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
		setListProductComplementarios(checkCodProducto, resourceRequest);

				
		PortletSession pSession = resourceRequest.getPortletSession();
		guardarEnSession(resourceRequest, "checkCodProducto");
		
		if (strErrors.size() == 0) {
			o.put("resp", 1);
			Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.CUENTA_SUELDO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_CUE_SUELDO);
			if (validarPeticion) {
				//Creamos el pintado para los productos complementarios
				if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
					List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
					List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
					for (int i = 1; i < lista.size(); i++) {
						listaUltima.add(lista.get(i));
					}
					pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
				}else {
					pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
				}
			
				Integer respInfoCS = formularioSolicitarProductosService.guardarInformacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,true,Util.CUENTA_SUELDO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_CUE_SUELDO);
				// 0 = INCORRECTO - false
				// 1 = CORRECTO - true
				mensajeConfirmacion=Constantes.MSJ_CUENTA_SUELDO;
				pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("urlRedireccionar",(respInfoCS == 1) ? obtenerURLCS+1 : "",PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("error", respInfoCS, PortletSession.PORTLET_SCOPE);
				if (respInfoCS == 0) {
					mensajeConfirmacion=Constantes.MSJ_ERROR;
					pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("urlRedireccionar", obtenerURLCS+1, PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
					LogErrorUtil.registrarError(JSonUtil.getStringJson(getSolicitud(resourceRequest.getPortletSession())),PortletProps.get("mensaje.error.exception") , PortletProps.get("mensaje.error.exception"));
				}
			} else {
				getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
				inicializarEstadosFormulario();
				//limpiarSesion(resourceRequest); 
				//limpiarVariablesTema(resourceRequest);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCS, PortletSession.APPLICATION_SCOPE);
				o.put("resp", "2");
			}
		} else {
			// cuando si hay error en el cliente
			o.put("resp", 0);
			o.put("strErrors", strErrors);
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			// 
			_log.error("Error en paso3_cs : "+e.getMessage());
		}
	}

	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en credito vehicular
	/**
	 * Seguir paso1 credito vehicular.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_cv")
	protected void seguirPaso1CreditoVehicular(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors =  validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo", "cboestadocivil",
						"cboestadocivilTexto", "cbosituacionlaboral", "cbosituacionlaboralTexto", "ruc", "valorRenta","checkCodProducto");

				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setIdEstadoCivil(mapCampos.get("cboestadocivil"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoCivil(mapCampos.get("cboestadocivilTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdSituacionLaboral(mapCampos.get("cbosituacionlaboral"));
				getSolicitud(resourceRequest.getPortletSession()).setSituacionLaboral(mapCampos.get("cbosituacionlaboralTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setRuc(mapCampos.get("ruc"));
				getSolicitud(resourceRequest.getPortletSession()).setRentaMensual(mapCampos.get("valorRenta"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoCredito(Constantes.TIPO_CREDITO_CREDITO_VEHICULAR);
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Vehicular(true);				
				estadoPaso1Vehicular = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Vehicular();							
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_cv");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso2 credito vehicular.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_cv")
	protected void seguirPaso2CreditoVehicular(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			PortletSession pSession = resourceRequest.getPortletSession();

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto", "celular", "telFijo", "telTrabajo", 
						"anexo", "email", "confEmail", "cboprovincia", "cboprovinciaTexto","checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),mapCampos.get("cboprovincia"),"");
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdProvincia(mapCampos.get("cboprovincia"));
				getSolicitud(resourceRequest.getPortletSession()).setProvincia(mapCampos.get("cboprovinciaTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Vehicular(true);
				estadoPaso2Vehicular = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Vehicular();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_cv");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso3 credito vehicular.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_cv")
	protected void seguirPaso3CreditoVehicular(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		try {
			
			List<String> strErrors = new ArrayList<String>();
			
			String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
			setListProductComplementarios(checkCodProducto, resourceRequest);
			
			PortletSession pSession = resourceRequest.getPortletSession();
			guardarEnSession(resourceRequest, "checkCodProducto");
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				
				//Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.CREDITO_VEHICULAR,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_CRE_VEHICULAR);
				Boolean validarPeticion =true;
				
				if (validarPeticion) {
					// cuando no hay error
					//Creamos el pintado para los productos complementarios
					
					if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
						List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
						List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
						for (int i = 1; i < lista.size(); i++) {
							listaUltima.add(lista.get(i));
						}
						pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
					}else {
						pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
					}
					
					// Aqui se daria el ingreso de la info
					// Obtenemos el codigo que nos indica que es lo que debemos realizar
					Integer codigoRespCalificacion = formularioSolicitarProductosService.comprobarPrecalificacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,Util.TARJETA_CREDITO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_TAR_CREDITO);
					
					if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PRE_CALIFICA) {
						// pre-califico
						mensajeConfirmacion=Constantes.MSJ_CREDITO_VEHICULAR;
						pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLCV+1,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
				
					} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_NO_PROCEDE) {
						mensajeConfirmacion=Constantes.MSJ_RECHAZO;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", "", PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 0, PortletSession.PORTLET_SCOPE);
			
						} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE) {	
						mensajeConfirmacion=Constantes.MSJ_ERROR;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLCV+1, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
				
						} else if(codigoRespCalificacion == Constantes.ESTADO_ADQ_ERROR){
						//Mandamos a la pagina de error
						getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
						inicializarEstadosFormulario();
						//limpiarSesion(resourceRequest);
						//limpiarVariablesTema(resourceRequest);
						o.put("resp", 2);
						resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCV, PortletSession.APPLICATION_SCOPE);
					}
				} else {
					getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
					inicializarEstadosFormulario();
					//limpiarSesion(resourceRequest);
					//limpiarVariablesTema(resourceRequest);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCV, PortletSession.APPLICATION_SCOPE);
					o.put("resp", 2);
				}
			}
			else {
				// cuando si hay error de validacion cliente
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			
		} catch (Exception e) {
			getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
			//inicializarEstadosFormulario();
			//limpiarSesion(resourceRequest);
			limpiarVariablesTema(resourceRequest);
			o.put("resp", 2);
			resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCV, PortletSession.APPLICATION_SCOPE);
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			// 
			_log.error("Error en paso3_cv : " + e.getMessage());
		}
	}
		
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en fondos mutuos
	/**
	 * Seguir paso1 fondos mutuos.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_fm")
	protected void seguirPaso1FondosMutuos(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo", "checkCodProducto");

				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Mutuos(true);
				estadoPaso1Mutuos = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Mutuos();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_fm");
			e.printStackTrace();
		}
		//JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
	}
	
	/**
	 * Seguir paso2 fondos mutuos.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_fm")
	protected void seguirPaso2FondosMutuos(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//		_log.info("entro a paso2_fm");
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			String idDepartamento = "";
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				PortletSession pSession = resourceRequest.getPortletSession();
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto",
						"celular", "telFijo", "telTrabajo", "anexo", "email", "confEmail", "checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),"","");
				
				if(mapCampos.get("cbodepartamento").length() == 1)
				    idDepartamento = "0"+mapCampos.get("cbodepartamento");
				else
					idDepartamento = mapCampos.get("cbodepartamento");
								
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(idDepartamento);
                                //getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Mutuos(true);
				estadoPaso2Mutuos = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Mutuos();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_fm");
			e.printStackTrace();
		}
	}


	
	/**
	 * Seguir paso3 fondos mutuos.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_fm")
	protected void seguirPaso3FondosMutuos(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		List<String> strErrors = new ArrayList<String>();
		
		String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
		setListProductComplementarios(checkCodProducto, resourceRequest);

		PortletSession pSession = resourceRequest.getPortletSession();
		guardarEnSession(resourceRequest, "checkCodProducto");
		
		if (strErrors.size() == 0) {
			o.put("resp", 1);
			
			Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.FONDO_MUTUO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_FON_MUTUO);
			
			if (validarPeticion) {
				// cuando no hay error en el cliente Registramos
				//Creamos el pintado para los productos complementarios
				if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
					List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
					List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
					for (int i = 1; i < lista.size(); i++) {
						listaUltima.add(lista.get(i));
					}
					pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
				}else {
					pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
				}
				
				Integer respInfoCS = formularioSolicitarProductosService.guardarInformacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,true,Util.FONDO_MUTUO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_FON_MUTUO);
				// 0 = INCORRECTO - false
				// 1 = CORRECTO - true
				mensajeConfirmacion=Constantes.MSJ_FONDOS_MUTUOS;
				pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("urlRedireccionar",(respInfoCS == 1) ? obtenerURLFM+1 : "",PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("error", respInfoCS, PortletSession.PORTLET_SCOPE);
				if (respInfoCS == 0) {
					mensajeConfirmacion=Constantes.MSJ_ERROR;
					pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("urlRedireccionar", obtenerURLFM+1, PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
					LogErrorUtil.registrarError(JSonUtil.getStringJson(getSolicitud(resourceRequest.getPortletSession())),PortletProps.get("mensaje.error.exception") , PortletProps.get("mensaje.error.exception"));
				}
			} else {
				getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
				inicializarEstadosFormulario();
				//limpiarSesion(resourceRequest);
				//limpiarVariablesTema(resourceRequest);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLFM, PortletSession.APPLICATION_SCOPE);
				o.put("resp", "2");
			}
		} else {
			// cuando si hay error en el cliente
			o.put("resp", "0");
			o.put("strErrors", strErrors);
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			// 
			_log.error("Error en paso3_fm : " +e.getMessage());
		}
	}

	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en credito hipotecario
	/**
	 * Seguir paso1 credito hipotecario.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_ch")
	protected void seguirPaso1CreditoHipotecario(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo", 
					"cboestadocivil", "cboestadocivilTexto", "cbosituacionlaboral", "cbosituacionlaboralTexto", "ruc", "valorRenta","checkCodProducto");

				
				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setIdEstadoCivil(mapCampos.get("cboestadocivil"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoCivil(mapCampos.get("cboestadocivilTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdSituacionLaboral(mapCampos.get("cbosituacionlaboral"));
				getSolicitud(resourceRequest.getPortletSession()).setSituacionLaboral(mapCampos.get("cbosituacionlaboralTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setRuc(mapCampos.get("ruc"));
				getSolicitud(resourceRequest.getPortletSession()).setRentaMensual(mapCampos.get("valorRenta"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoCredito(Constantes.TIPO_CREDITO_CREDITO_HIPOTECARIO);
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Hipotecario(true);
				estadoPaso1Hipotecario = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Hipotecario();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_ch");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso2 credito hipotecario.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_ch")
	protected void seguirPaso2CreditoHipotecario(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//		_log.info("entro a paso2_ch");
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			PortletSession pSession = resourceRequest.getPortletSession();

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto", "celular", "telFijo", "telTrabajo", "anexo", 
						"email", "confEmail", "cboprovincia", "cboprovinciaTexto","checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),mapCampos.get("cboprovincia"),"");
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdProvincia(mapCampos.get("cboprovincia"));
				getSolicitud(resourceRequest.getPortletSession()).setProvincia(mapCampos.get("cboprovinciaTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Hipotecario(true);				
				estadoPaso2Hipotecario = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Hipotecario();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_ch");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso3 credito hipotecario.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_ch")
	protected void seguirPaso3CreditoHipotecario(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		try {
			
			List<String> strErrors = new ArrayList<String>();
			
			String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
			setListProductComplementarios(checkCodProducto, resourceRequest);

			PortletSession pSession = resourceRequest.getPortletSession();
			guardarEnSession(resourceRequest, "checkCodProducto");
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				
			//	Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.CREDITO_HIPOTECARIO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_CRE_HIPOTECARIO);
				Boolean validarPeticion = true;
				if (validarPeticion) {
					// cuando no hay error
					//Creamos el pintado para los productos complementarios
					if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
						List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
						List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
						for (int i = 1; i < lista.size(); i++) {
							listaUltima.add(lista.get(i));
						}
						pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
					}else {
						pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
					}
					
					// Aqui se daria el ingreso de la info
					// Obtenemos el codigo que nos indica que es lo que debemos realizar
					Integer codigoRespCalificacion = formularioSolicitarProductosService.comprobarPrecalificacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,Util.TARJETA_CREDITO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_TAR_CREDITO);
				
					if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PRE_CALIFICA) {
						// pre-califico
						if (getSolicitud(pSession).getEtiqueta().contains("PRESTAMO_PERSONAL")) {
							mensajeConfirmacion=Constantes.MSJ_PRESTAMO_PERSONAL;
						} else {
							mensajeConfirmacion=Constantes.MSJ_CREDITO_HIPOTECARIO;
						}
						
						pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLCH+1, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
				
					} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_NO_PROCEDE) {
						mensajeConfirmacion=Constantes.MSJ_RECHAZO;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", "", PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 0, PortletSession.PORTLET_SCOPE);
				
					} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE) {
						mensajeConfirmacion=Constantes.MSJ_ERROR;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLCH+1, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
				
					} else if(codigoRespCalificacion == Constantes.ESTADO_ADQ_ERROR){
						//Mandamos a la pagina de error
						getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
						inicializarEstadosFormulario();
						//limpiarSesion(resourceRequest);
						//limpiarVariablesTema(resourceRequest);
						o.put("resp", 2);
						resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCH, PortletSession.APPLICATION_SCOPE);
					}
				} else {
					getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
					inicializarEstadosFormulario();
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
					o.put("resp", 2);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCH, PortletSession.APPLICATION_SCOPE);
					//limpiarSesion(resourceRequest);
					//limpiarVariablesTema(resourceRequest);
				}
			}
			else {
				// cuando si hay error de validacion cliente
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			
		} catch (Exception e) {
			getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
			inicializarEstadosFormulario();
			//limpiarSesion(resourceRequest);
			//limpiarVariablesTema(resourceRequest);
			o.put("resp", 2);
			resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLCH, PortletSession.APPLICATION_SCOPE);
			_log.error("Error en paso3_ch - No controlado "+e.getMessage());
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			// 
			_log.error("Error en paso3_ch : " +e.getMessage());
		}

	}
	
	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en prestamo personal
	/**
	 * Seguir paso1 prestamo personal.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_pp")
	protected void seguirPaso1PrestamoPersonal(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors =  validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo",
						"cboestadocivil", "cboestadocivilTexto", "cbosituacionlaboral", "cbosituacionlaboralTexto", "ruc", "valorRenta","checkCodProducto");

				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setIdEstadoCivil(mapCampos.get("cboestadocivil"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoCivil(mapCampos.get("cboestadocivilTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdSituacionLaboral(mapCampos.get("cbosituacionlaboral"));
				getSolicitud(resourceRequest.getPortletSession()).setSituacionLaboral(mapCampos.get("cbosituacionlaboralTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setRuc(mapCampos.get("ruc"));
				getSolicitud(resourceRequest.getPortletSession()).setRentaMensual(mapCampos.get("valorRenta"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoCredito(Constantes.TIPO_CREDITO_PRESTAMO_FACIL);
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Personal(true);
				estadoPaso1Personal = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Personal();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_pp");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso2 prestamo personal.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_pp")
	protected void seguirPaso2PrestamoPersonal(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			PortletSession pSession = resourceRequest.getPortletSession();

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto", "celular", "telFijo", "telTrabajo", "anexo",
						"email", "confEmail", "cboprovincia", "cboprovinciaTexto","checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),mapCampos.get("cboprovincia"),"");
				
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setIdProvincia(mapCampos.get("cboprovincia"));
				getSolicitud(resourceRequest.getPortletSession()).setProvincia(mapCampos.get("cboprovinciaTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Personal(true);
				estadoPaso2Personal = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Personal();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_pp");
			e.printStackTrace();
		}
	}

	/**
	 * Seguir paso3 prestamo personal.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_pp")
	protected void seguirPaso3PrestamoPersonal(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
	//	String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		try {
			
			List<String> strErrors = new ArrayList<String>();
			
			String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
			setListProductComplementarios(checkCodProducto, resourceRequest);

			PortletSession pSession = resourceRequest.getPortletSession();
			guardarEnSession(resourceRequest, "checkCodProducto");
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
			
				Boolean validarPeticion = true;
				if (validarPeticion) {
					// cuando no hay error Registramos
					//Creamos el pintado para los productos complementarios
					if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
						List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
						List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
						for (int i = 1; i < lista.size(); i++) {
							listaUltima.add(lista.get(i));
						}
						pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
					}else {
						pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
					}
					// Obtenemos el codigo que nos indica que es lo que debemos realizar
					Integer codigoRespCalificacion = formularioSolicitarProductosService.comprobarPrecalificacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,Util.TARJETA_CREDITO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_TAR_CREDITO);									
					
					  if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PRE_CALIFICA) {
						// pre-califico
						mensajeConfirmacion=Constantes.MSJ_PRESTAMO_PERSONAL;
						pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLPP+1 ,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
					  } else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_NO_PROCEDE) {
						mensajeConfirmacion=Constantes.MSJ_RECHAZO;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", "", PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 0, PortletSession.PORTLET_SCOPE);
				
						} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE) {
						mensajeConfirmacion=Constantes.MSJ_ERROR;
						pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("urlRedireccionar", obtenerURLPP+1, PortletSession.PORTLET_SCOPE);
						pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
					
						} else if(codigoRespCalificacion == Constantes.ESTADO_ADQ_ERROR){
						//Mandamos a la pagina de error
						o.put("resp", 2);
						resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLPP, PortletSession.APPLICATION_SCOPE);
						getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
						inicializarEstadosFormulario();
						//limpiarSesion(resourceRequest);
						//limpiarVariablesTema(resourceRequest);
					}
				} else {
					getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
					inicializarEstadosFormulario();
					//limpiarSesion(resourceRequest);
					//limpiarVariablesTema(resourceRequest);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLPP, PortletSession.APPLICATION_SCOPE);
					o.put("resp", 2);
				}
			}
			else {
				// cuando si hay error de validacion cliente
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
		} 
		catch (Exception e) {
			getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
			inicializarEstadosFormulario();
			//limpiarSesion(resourceRequest);
			//limpiarVariablesTema(resourceRequest);
			_log.error("Error en paso3_pp - No controlado "+e.getMessage());
			o.put("resp", 2);
			resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLPP, PortletSession.APPLICATION_SCOPE);
			e.printStackTrace();
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso3_pp : " +e.getMessage());
		}
	}
	
	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en producto pre aprobado
	/**
	 * Seguir paso1 producto pre aprobado.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_ppa")
	protected void seguirPaso1ProductoPreAprobado(Model model, ResourceRequest resourceRequest,	ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario1(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
			
			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				guardarEnSession(resourceRequest, "tipDoc", "ndocumento", "apePater", "apeMater", "priNombre", "segNombre", "fecNacimiento", "tipsexo", "checkCodProducto");

				ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
				getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
				getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
				getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
				getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
				getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Aprobado(true);				
				estadoPaso1Aprobado = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Aprobado();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				// cuando si hay error
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso1_ppa");
			e.printStackTrace();
		}
	}
	
	/**
	 * Seguir paso2 producto pre aprobado.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso2_ppa")
	protected void seguirPaso2ProductoPreAprobado(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		
		try {
			Map<String, Object> o = new HashMap<String, Object>();
			Map<String, String> mapCampos = obtenerCampos(resourceRequest);
			List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));

			if (strErrors.size() == 0) {
				o.put("resp", 1);
				// cuando no hay error Registramos
				PortletSession pSession = resourceRequest.getPortletSession();
				guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto", "celular", "telFijo", "telTrabajo", "anexo", "email", "confEmail", "checkCodProducto");
				
				setearUbigeo(mapCampos.get("cbodepartamento"),"","");
				getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
				getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
				getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
				getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
				getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
				getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
				getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2Aprobado(true);
				estadoPaso2Aprobado = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2Aprobado();
				solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
				model.addAttribute("lstSolicitud", solicitudProductoBean);
			} else {
				o.put("resp", 0);
				o.put("strErrors", strErrors);
			}
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso2_ppa");
			e.printStackTrace();
		}

	}

	/**
	 * Seguir paso3 producto pre aprobado.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso3_ppa")
	protected void seguirPaso3ProductoPreAprobado(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("resp", 2);
		resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
		
		List<String> strErrors = new ArrayList<String>();
		
		String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
		setListProductComplementarios(checkCodProducto, resourceRequest);

		PortletSession pSession = resourceRequest.getPortletSession();
		guardarEnSession(resourceRequest, "checkCodProducto");
		
		if (strErrors.size() == 0) {
			o.put("resp", 1);
			Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.PRODUCTO_PREAPROBADO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_PRE_APROBADO);
			
			if (validarPeticion) {
				//Creamos el pintado para los productos complementarios
				if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
					List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
					List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
					for (int i = 1; i < lista.size(); i++) {
						listaUltima.add(lista.get(i));
					}
					pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
				}else {
					pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
				}
				Integer respInfoCS = formularioSolicitarProductosService.guardarInformacion(getSolicitud(resourceRequest.getPortletSession()), resourceRequest,true,Util.PRODUCTO_PREAPROBADO,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_PRE_APROBADO);
				// 0 = INCORRECTO - false
				// 1 = CORRECTO - true
				mensajeConfirmacion=Constantes.MSJ_PRODUCTO_PRE_APROBADO;
				pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("urlRedireccionar",(respInfoCS == 1) ? obtenerURLPPA+1 : "",PortletSession.PORTLET_SCOPE);
				pSession.setAttribute("error", respInfoCS, PortletSession.PORTLET_SCOPE);
				if (respInfoCS == 0) {
					
					mensajeConfirmacion=Constantes.MSJ_ERROR;
					pSession.setAttribute("mensajeConfirmacion", mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("urlRedireccionar", obtenerURLPPA+1, PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("error", 1, PortletSession.PORTLET_SCOPE);
					LogErrorUtil.registrarError(JSonUtil.getStringJson(getSolicitud(resourceRequest.getPortletSession())),PortletProps.get("mensaje.error.exception") , PortletProps.get("mensaje.error.exception"));
				}
			} else {
				getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
				inicializarEstadosFormulario();
				//limpiarSesion(resourceRequest);
				//limpiarVariablesTema(resourceRequest);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLPPA, PortletSession.APPLICATION_SCOPE);
				o.put("resp", "2");
			}
		} else {
			// cuando si hay error en el cliente
			o.put("resp", 0);
			o.put("strErrors", strErrors);
		}
		try {
			Util.returnJson(o, resourceResponse);
		} catch (IOException e) {
			_log.error("Error en paso3_ppa " +e.getMessage());
		}
	}
	
	
	//Metodo que controla las acciones del paso 1 (¿Quién eres?) en seguro soat
		/**
	 * Seguir paso1 seguro soat.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("paso1_ss")
		protected void seguirPaso1SeguroSoat(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
			
			try {
				Map<String, Object> o = new HashMap<String, Object>();
				Map<String, String> mapCampos = obtenerCampos(resourceRequest);
				List<String> strErrors =  validarFormulario1(mapCampos,ParamUtil.getString(resourceRequest, "nombre_producto_url"));
	
				if (strErrors.size() == 0) {
					o.put("resp", 1);
					// cuando no hay error Registramos
					guardarEnSession(resourceRequest, "tipDoc","ndocumento","apePater","apeMater","priNombre","segNombre","fecNacimiento","tipsexo","checkCodProducto");
	
					ponerEnSesionDNI(resourceRequest, mapCampos.get("tipDoc"), mapCampos.get("ndocumento"));
					getSolicitud(resourceRequest.getPortletSession()).setIdTipoDocumento(mapCampos.get("tipDoc"));
					getSolicitud(resourceRequest.getPortletSession()).setNumeroDocumento(mapCampos.get("ndocumento"));
					getSolicitud(resourceRequest.getPortletSession()).setApellidoPaterno(mapCampos.get("apePater"));
					getSolicitud(resourceRequest.getPortletSession()).setApellidoMaterno(mapCampos.get("apeMater"));
					getSolicitud(resourceRequest.getPortletSession()).setPrimerNombre(mapCampos.get("priNombre"));
					getSolicitud(resourceRequest.getPortletSession()).setSegundoNombre(mapCampos.get("segNombre"));
					getSolicitud(resourceRequest.getPortletSession()).setFechaNacimiento(mapCampos.get("fecNacimiento"));
					getSolicitud(resourceRequest.getPortletSession()).setTipoSexo(mapCampos.get("tipsexo"));
					getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso1Soat(true);					
					estadoPaso1Soat = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso1Soat();
					solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
					model.addAttribute("lstSolicitud", solicitudProductoBean);
				} else {
					// cuando si hay error
					o.put("resp", 0);
					o.put("strErrors", strErrors);
				}
				Util.returnJson(o, resourceResponse);
			} catch (IOException e) {
				_log.error("Error en paso1_ss");
				e.printStackTrace();
			}
		}
		
		/**
		 * Seguir paso2 seguro soat.
		 * Fecha: 22/08/2013
		 *
		 * @param model the model
		 * @param resourceRequest the resource request
		 * @param resourceResponse the resource response
		 */
		@ResourceMapping("paso2_ss")
		protected void seguirPaso2SeguroSoat(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
			
			try {
				Map<String, Object> o = new HashMap<String, Object>();
				Map<String, String> mapCampos = obtenerCampos(resourceRequest);
				List<String> strErrors = validarFormulario2(mapCampos, ParamUtil.getString(resourceRequest, "nombre_producto_url"));
				
				if (strErrors.size() == 0) {
					o.put("resp", 1);
					// cuando no hay error Registramos
					PortletSession pSession = resourceRequest.getPortletSession();
					guardarEnSession(resourceRequest, "cbodepartamento", "cbodepartamentoTexto","cboprovincia", "cboprovinciaTexto", "cbodistrito", "cbodistritoTexto",
							"celular", "telFijo", "telTrabajo", "anexo", "email", "confEmail", "direccion", "horario", "placa", "checkCodProducto");
					
					setearUbigeo(mapCampos.get("cbodepartamento"),mapCampos.get("cboprovincia"),mapCampos.get("cbodistrito"));
					
					getSolicitud(resourceRequest.getPortletSession()).setIdDepartamento(mapCampos.get("cbodepartamento"));
					getSolicitud(resourceRequest.getPortletSession()).setDepartamento(mapCampos.get("cbodepartamentoTexto"));
					getSolicitud(resourceRequest.getPortletSession()).setIdProvincia(mapCampos.get("cboprovincia"));
					getSolicitud(resourceRequest.getPortletSession()).setProvincia(mapCampos.get("cboprovinciaTexto"));
					getSolicitud(resourceRequest.getPortletSession()).setIdDistrito(mapCampos.get("cbodistrito"));
					getSolicitud(resourceRequest.getPortletSession()).setDistrito(mapCampos.get("cbodistritoTexto"));
					getSolicitud(resourceRequest.getPortletSession()).setCelular(mapCampos.get("celular"));
					getSolicitud(resourceRequest.getPortletSession()).setTelefonoCasa(mapCampos.get("telFijo"));
					getSolicitud(resourceRequest.getPortletSession()).setTelefonoTrabajo(mapCampos.get("telTrabajo"));
					getSolicitud(resourceRequest.getPortletSession()).setAnexo(mapCampos.get("anexo"));
					getSolicitud(resourceRequest.getPortletSession()).setEmail(mapCampos.get("email"));
					getSolicitud(resourceRequest.getPortletSession()).setDireccionEnvio(mapCampos.get("direccion"));
					getSolicitud(resourceRequest.getPortletSession()).setHorarioEnvio(mapCampos.get("horario"));
					getSolicitud(resourceRequest.getPortletSession()).setPlacaVehiculo(mapCampos.get("placa"));
					getSolicitud(resourceRequest.getPortletSession()).setEstadoPaso2soat(true);
					estadoPaso2soat = getSolicitud(resourceRequest.getPortletSession()).getEstadoPaso2soat();
					solicitudProductoBean.add(getSolicitud(resourceRequest.getPortletSession()));
					model.addAttribute("lstSolicitud", solicitudProductoBean);
				} else {
					o.put("resp", 0);
					o.put("strErrors", strErrors);
				}
				Util.returnJson(o, resourceResponse);
			} catch (IOException e) {
				_log.error("Error en paso2_ss");
				e.printStackTrace();
			}
		}
		
			/**
			 * Seguir paso3 seguro soat.
			 * Fecha: 22/08/2013
			 *
			 * @param model the model
			 * @param resourceRequest the resource request
			 * @param resourceResponse the resource response
			 */
			@ResourceMapping("paso3_ss")
			protected void seguirPaso3SeguroSoat(Model model, ResourceRequest resourceRequest, ResourceResponse resourceResponse) {	
				//String nombre_producto_url = ParamUtil.getString(resourceRequest, "nombre_producto_url");
				Map<String, Object> o = new HashMap<String, Object>();
				o.put("resp", 2);
				resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
				
				List<String> strErrors = new ArrayList<String>();
				
				String checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");
				setListProductComplementarios(checkCodProducto, resourceRequest);

				PortletSession pSession = resourceRequest.getPortletSession();
				guardarEnSession(resourceRequest, "checkCodProducto");
				
				if (strErrors.size() == 0) {
				o.put("resp", 1);
				Boolean validarPeticion = formularioSolicitarProductosService.validarGestionPeticion(resourceRequest, JSonUtil.IP,Util.SEGURO_SOAT,JSonUtil.ETIQUETA_RANGO_PETICION_SOL_SEG_SOAT);
				
				if (validarPeticion) {
					// cuando no hay error en el cliente
					//Creamos el pintado para los productos complementarios
					if (getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
						List<ProductoComplementarioBean> lista = getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios();
						List<ProductoComplementarioBean> listaUltima = new ArrayList<ProductoComplementarioBean>();
						for (int i = 1; i < lista.size(); i++) {
							listaUltima.add(lista.get(i));
						}
						pSession.setAttribute("listProductComplCheck",listaUltima,PortletSession.APPLICATION_SCOPE);
					}else {
						pSession.setAttribute("listProductComplCheck", new ArrayList<ProductoComplementarioBean>(),PortletSession.APPLICATION_SCOPE);
					}
							
					TelefonoLeadBean telefonoLeads1 = new TelefonoLeadBean(JSonUtil.TELEFONO_CELULAR,getSolicitud(resourceRequest.getPortletSession()).getCelular(),"" );
					TelefonoLeadBean telefonoLeads2 = new TelefonoLeadBean(JSonUtil.TELEFONO_DE_RESIDENCIA,getSolicitud(resourceRequest.getPortletSession()).getTelefonoCasa(),"" );
					TelefonoLeadBean telefonoLeads3 = new TelefonoLeadBean(JSonUtil.TELEFONO_DE_TRABAJO,getSolicitud(resourceRequest.getPortletSession()).getTelefonoTrabajo(),getSolicitud(resourceRequest.getPortletSession()).getAnexo());
					getSolicitud(resourceRequest.getPortletSession()).getTelefonoLeads().add(telefonoLeads1);
					getSolicitud(resourceRequest.getPortletSession()).getTelefonoLeads().add(telefonoLeads2);
					getSolicitud(resourceRequest.getPortletSession()).getTelefonoLeads().add(telefonoLeads3);			
					getSolicitud(resourceRequest.getPortletSession()).setEstadoEnvCorreo(true);
					
					formularioSolicitarProductosService.enviarCorreoInterbank(getSolicitud(resourceRequest.getPortletSession()), resourceRequest);
					
					Integer respInfoCS = formularioSolicitarProductosService.enviarCorreo(getSolicitud(resourceRequest.getPortletSession()), resourceRequest);
					if (respInfoCS == 0) {
						// Incorrecto email - Error al enviar el email
						getSolicitud(resourceRequest.getPortletSession()).setEstadoEnvCorreo(false);
					} else {
						// Correcto email
						getSolicitud(resourceRequest.getPortletSession()).setEstadoEnvCorreo(true);
					}
					getSolicitud(resourceRequest.getPortletSession()).setFechaEnvioEmailing(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
					getSolicitud(resourceRequest.getPortletSession()).setFechaRegistro(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
					getSolicitud(resourceRequest.getPortletSession()).setHorarioEnvio(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy HH:mm:ss"));
					getSolicitud(resourceRequest.getPortletSession()).setEstadoPreCalificacion(true);
					getSolicitud(resourceRequest.getPortletSession()).setEstadoRegLead(true);
					
					formularioSolicitarProductosService.registrarSolicitud(getSolicitud(resourceRequest.getPortletSession()));
					
					mensajeConfirmacion=Constantes.MSJ_SEGURO_SOAT;
					pSession.setAttribute("mensajeConfirmacion",mensajeConfirmacion,PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("urlRedireccionar",(respInfoCS == 1) ? obtenerURLSS+1 : "",PortletSession.PORTLET_SCOPE);
					pSession.setAttribute("error", respInfoCS, PortletSession.PORTLET_SCOPE);
				} else {
					getSolicitud(resourceRequest.getPortletSession()).inicializarSolicitud();
					inicializarEstadosFormulario();
					//limpiarSesion(resourceRequest);
					//limpiarVariablesTema(resourceRequest);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_SOLICITUD","true", PortletSession.APPLICATION_SCOPE);
					o.put("resp", 2);
					resourceRequest.getPortletSession().setAttribute("LIFERAY_SHARED_ERROR_FORMULARIO",obtenerURLSS, PortletSession.APPLICATION_SCOPE);
				}
					} else {
				// cuando si hay error en el cliente
				o.put("resp", 0);
				o.put("strErrors", strErrors);
					}
				try {
					Util.returnJson(o, resourceResponse);
				} catch (IOException e) {
					_log.error("Error en paso3_ss : " + e.getMessage());
				}
		}
		
	
	/**
	 * #######################################################################################
	 * ############################## METODOS COMUNES ########################################
	 * #######################################################################################.
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws Exception the exception
	 */
	
	//Metodo que trae la imagen del captcha
	@ResourceMapping("traerImagen")
	public void obtenerImagen(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {

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
	
	//Validacion del texto captcha en todos los formularios de solicitudes, durante el paso 2
	/**
	 * Json.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("validarCaptchaSolicitudes")
	protected void json(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String cadRetorno;
		PrintWriter writer;
		try {
			String captcha = ParamUtil.getString(resourceRequest, "codigo");
			boolean captchaPassed = captchaService.validateResponseForID(resourceRequest.getPortletSession().getId(), captcha);
			//con esto no valida el captcha
			//boolean captchaPassed = true;
			JSONObject json = JSONFactoryUtil.createJSONObject();

			if (captchaPassed) {
				json.put("error", "true");
			} else {
				json.put("error", "false");
			}

			cadRetorno = json.toString();
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(cadRetorno);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			_log.error("Error al validar Captcha de Solicitudes:" + e.toString());
			e.printStackTrace();
		}
	}

	//Validacion de la fecha de nacimiento en el calendario en todos los formularios de solicitudes, durante el paso 1
	/**
	 * Validar edad.
	 * Fecha: 22/08/2013
	 *
	 * @param fecNacimiento the fec nacimiento
	 * @return true, en caso de exito
	 */
	private boolean validarEdad(String fecNacimiento) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar fechaNac = null;
		try {
			Date fechaAux = sdf.parse(fecNacimiento);
			fechaNac = Calendar.getInstance();
			fechaNac.setTime(fechaAux);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}

		int dia = fechaNac.get(Calendar.DAY_OF_MONTH);
		int mes = fechaNac.get(Calendar.MONTH) + 1;
		int anio = fechaNac.get(Calendar.YEAR);
		Calendar fechaActual = Calendar.getInstance();
		int diaActual = fechaActual.get(Calendar.DAY_OF_MONTH);
		int mesActual = fechaActual.get(Calendar.MONTH) + 1;
		int annoActual = fechaActual.get(Calendar.YEAR);
		int edad = annoActual - anio;

		if (mesActual < mes) {
			edad--;
		} else if (mesActual == mes) {
			if (diaActual < dia)
				edad--;
		}

		if (edad < 18 || edad > 100) {
//			_log.error("ERROR -- TIENES :" + edad + " años");
			return false;
		} else {
//			_log.info("OK -- TIENES :" + edad + " años");
		}
		return true;
	}
	 
	//Validacion del formato de fecha
	/**
	 * Valida sies fecha.
	 * Fecha: 22/08/2013
	 *
	 * @param fechax the fechax
	 * @return true, en caso de exito
	 */
	public boolean validaSiesFecha(String fechax) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.parse(fechax);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Son los meensajes de error que se mostraran en los diferentes pasos de cada formulario
	/**
	 * Carga mensajes.
	 * Fecha: 22/08/2013
	 *
	 * @param model the model
	 */
	private void cargaMensajes(Model model, PortletRequest portletRequest){
	  	
		model.addAttribute("MSJ_TERMINOS", Constantes.MSJ_TERMINOS);
		model.addAttribute("MSJ_DNI", Constantes.MSJ_DNI);
		model.addAttribute("MSJ_CARNET_EXTRANJERIA", Constantes.MSJ_CARNET_EXTRANJERIA);
		model.addAttribute("MSJ_APELLIDO_PATERNO", Constantes.MSJ_APELLIDO_PATERNO);
		model.addAttribute("MSJ_APELLIDO_MATERNO", Constantes.MSJ_APELLIDO_MATERNO);
		model.addAttribute("MSJ_PRIMER_NOMBRE", Constantes.MSJ_PRIMER_NOMBRE);
		model.addAttribute("MSJ_FECHA_NACIMIENTO1", Constantes.MSJ_FECHA_NACIMIENTO1);
		model.addAttribute("MSJ_FECHA_NACIMIENTO2", Constantes.MSJ_FECHA_NACIMIENTO2);
		model.addAttribute("MSJ_ESTADO_CIVIL", Constantes.MSJ_ESTADO_CIVIL);
		model.addAttribute("MSJ_SITUACION_LABORAL", Constantes.MSJ_SITUACION_LABORAL);
		model.addAttribute("MSJ_RUC", Constantes.MSJ_RUC);
		model.addAttribute("MSJ_SEGUNDO_NOMBRE", Constantes.MSJ_SEGUNDO_NOMBRE);

		model.addAttribute("MSJ_DEPARTAMENTO", Constantes.MSJ_DEPARTAMENTO);
		model.addAttribute("MSJ_CELULAR", Constantes.MSJ_CELULAR);
		model.addAttribute("MSJ_TELEFONO_DOMICILIO", Constantes.MSJ_TELEFONO_DOMICILIO);
		model.addAttribute("MSJ_TELEFONO_TRABAJO", Constantes.MSJ_TELEFONO_TRABAJO);
		model.addAttribute("MSJ_ANEXO", Constantes.MSJ_ANEXO);
		model.addAttribute("MSJ_CORREO_ELECTRONICO", Constantes.MSJ_CORREO_ELECTRONICO);
		model.addAttribute("MSJ_CONFIRMACION_CORREO_ELECTRONICO", Constantes.MSJ_CONFIRMACION_CORREO_ELECTRONICO);
		model.addAttribute("MSJ_CAPTCHA", Constantes.MSJ_CAPTCHA);

		model.addAttribute("MSJ_RAZON_SOCIAL", Constantes.MSJ_RAZON_SOCIAL);
		model.addAttribute("MSJ_PROVINCIA", Constantes.MSJ_PROVINCIA);
		model.addAttribute("MSJ_DISTRITO", Constantes.MSJ_DISTRITO);
		model.addAttribute("MSJ_DIRECCION", Constantes.MSJ_DIRECCION);
		model.addAttribute("MSJ_PLACA", Constantes.MSJ_PLACA);

	}
	

	//Guarda los valores de cada paso del formulario en Sesion
	/**
	 * Guardar en session.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param valores the valores
	 */
	
	private void guardarEnSession(ResourceRequest resourceRequest, String... valores) {
		PortletSession pSession = resourceRequest.getPortletSession();
		for (String valor : valores) {
			// "apePater", "apeMater", "priNombre", "segNombre"
			if(valor.indexOf("apePater")!=-1)
			{
				pSession.setAttribute(valor,convInicialMay(ParamUtil.getString(resourceRequest, valor)), PortletSession.PORTLET_SCOPE);	
			}else if(valor.indexOf("apeMater")!=-1)
			{
				pSession.setAttribute(valor,convInicialMay(ParamUtil.getString(resourceRequest, valor)), PortletSession.PORTLET_SCOPE);	
			}else if(valor.indexOf("priNombre")!=-1)
			{
				pSession.setAttribute(valor,convInicialMay(ParamUtil.getString(resourceRequest, valor)), PortletSession.PORTLET_SCOPE);	
			}else if(valor.indexOf("segNombre")!=-1)
			{
				
				if (ParamUtil.getString(resourceRequest, valor).equals("")) {
			pSession.setAttribute(valor, ParamUtil.getString(resourceRequest, valor), PortletSession.PORTLET_SCOPE);
				}else
				{
					pSession.setAttribute(valor,convInicialMay(ParamUtil.getString(resourceRequest, valor)), PortletSession.PORTLET_SCOPE);		
				}
			}
			else
			{
				pSession.setAttribute(valor, ParamUtil.getString(resourceRequest, valor), PortletSession.PORTLET_SCOPE);
		}
	}
	}

	//Obtiene los valores de cada campo en cada paso de la solicitud
	/**
	 * Obtener campos.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 */
	private Map<String, String> obtenerCampos(ResourceRequest resourceRequest){
		Map<String, String> mapCampos = new HashMap<String, String>();
		
		/*tipDoc = ParamUtil.getString(resourceRequest, "tipDoc");
		ndocumento = ParamUtil.getString(resourceRequest, "ndocumento");
		apePater = TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "apePater"));
		apeMater = TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "apeMater"));
		priNombre = TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "priNombre"));
		segNombre = TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "segNombre"));
		fecNacimiento = ParamUtil.getString(resourceRequest, "fecNacimiento");
		tipsexo = ParamUtil.getString(resourceRequest, "tipsexo");
		cboestadocivil = ParamUtil.getString(resourceRequest, "cboestadocivil");
		cboestadocivilTexto = ParamUtil.getString(resourceRequest, "cboestadocivilTexto");
		cbosituacionlaboral = ParamUtil.getString(resourceRequest, "cbosituacionlaboral");
		cbosituacionlaboralTexto = ParamUtil.getString(resourceRequest, "cbosituacionlaboralTexto");
		ruc = ParamUtil.getString(resourceRequest, "ruc");
		valorRenta = ParamUtil.getString(resourceRequest, "valorRenta");
		razonSocial = ParamUtil.getString(resourceRequest, "razonSocial");		
		
		cbodepartamento = ParamUtil.getString(resourceRequest, "cbodepartamento");
		cbodepartamentoTexto = ParamUtil.getString(resourceRequest, "cbodepartamentoTexto");
		cboprovincia = ParamUtil.getString(resourceRequest, "cboprovincia");
		cboprovinciaTexto = ParamUtil.getString(resourceRequest, "cboprovinciaTexto");
		cbodistrito = ParamUtil.getString(resourceRequest, "cbodistrito");
		cbodistritoTexto = ParamUtil.getString(resourceRequest, "cbodistritoTexto");
		celular = ParamUtil.getString(resourceRequest, "celular");
		telFijo = ParamUtil.getString(resourceRequest, "telFijo");
		telTrabajo = ParamUtil.getString(resourceRequest, "telTrabajo");
		anexo = ParamUtil.getString(resourceRequest, "anexo");
		email = ParamUtil.getString(resourceRequest, "email");
		confEmail = ParamUtil.getString(resourceRequest, "confEmail");
		direccion = ParamUtil.getString(resourceRequest, "direccion");
		horario = ParamUtil.getString(resourceRequest, "horario");
		placa = ParamUtil.getString(resourceRequest, "placa");
		captcha = ParamUtil.getString(resourceRequest, "txtCaptcha");
		
		checkCondiciones = ParamUtil.getBoolean(resourceRequest, "checkCondiciones");
		checkCodProducto = ParamUtil.getString(resourceRequest, "checkCodProducto");*/
		mapCampos.put("tipDoc",ParamUtil.getString(resourceRequest, "tipDoc") );
		mapCampos.put("ndocumento", ParamUtil.getString(resourceRequest, "ndocumento"));
		mapCampos.put("apePater", TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "apePater")));
		mapCampos.put("apeMater", TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "apeMater")));
		mapCampos.put("priNombre",TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "priNombre")));
		mapCampos.put("segNombre", TextoUtil.primerasMayuscula(ParamUtil.getString(resourceRequest, "segNombre")));
		mapCampos.put("fecNacimiento",ParamUtil.getString(resourceRequest, "fecNacimiento") );
		mapCampos.put("tipsexo", ParamUtil.getString(resourceRequest, "tipsexo"));
		mapCampos.put("cboestadocivil",ParamUtil.getString(resourceRequest, "cboestadocivil") );
		mapCampos.put("cboestadocivilTexto", ParamUtil.getString(resourceRequest, "cboestadocivilTexto"));
		mapCampos.put("cbosituacionlaboral", ParamUtil.getString(resourceRequest, "cbosituacionlaboral"));
		mapCampos.put("cbosituacionlaboralTexto", ParamUtil.getString(resourceRequest, "cbosituacionlaboralTexto"));
		mapCampos.put("ruc", ParamUtil.getString(resourceRequest, "ruc"));
		mapCampos.put("valorRenta", ParamUtil.getString(resourceRequest, "valorRenta"));
		mapCampos.put("razonSocial",  ParamUtil.getString(resourceRequest, "razonSocial"));
		mapCampos.put("cbodepartamento", ParamUtil.getString(resourceRequest, "cbodepartamento"));
		mapCampos.put("cbodepartamentoTexto", ParamUtil.getString(resourceRequest, "cbodepartamentoTexto"));
		mapCampos.put("cboprovincia",ParamUtil.getString(resourceRequest, "cboprovincia") );
		
		mapCampos.put("cboprovinciaTexto", ParamUtil.getString(resourceRequest, "cboprovinciaTexto"));
		mapCampos.put("cbodistrito", ParamUtil.getString(resourceRequest, "cbodistrito"));
		mapCampos.put("cbodistritoTexto",ParamUtil.getString(resourceRequest, "cbodistritoTexto") );
		mapCampos.put("celular", ParamUtil.getString(resourceRequest, "celular"));
		mapCampos.put("telFijo", ParamUtil.getString(resourceRequest, "telFijo"));
		mapCampos.put("telTrabajo", ParamUtil.getString(resourceRequest, "telTrabajo"));
		
		mapCampos.put("anexo",  ParamUtil.getString(resourceRequest, "anexo"));
		mapCampos.put("email",  ParamUtil.getString(resourceRequest, "email"));
		mapCampos.put("confEmail", ParamUtil.getString(resourceRequest, "confEmail"));
		mapCampos.put("direccion", ParamUtil.getString(resourceRequest, "direccion"));
		mapCampos.put("horario",  ParamUtil.getString(resourceRequest, "horario"));
		
		mapCampos.put("placa",  ParamUtil.getString(resourceRequest, "placa"));
		mapCampos.put("captcha",ParamUtil.getString(resourceRequest, "txtCaptcha") );
		//mapCampos.put("checkCondiciones", ParamUtil.getBoolean(resourceRequest, "checkCondiciones"));
		
		mapCampos.put("checkCodProducto",ParamUtil.getString(resourceRequest, "checkCodProducto") );
		return mapCampos;
	}	
	
	//Con el indicador(int) de mail se convertira a su valor en texto correspondiente(String), esto con la finalidad del envio de Mailing
	/**
	 * Convertir.
	 * Fecha: 22/08/2013
	 *
	 * @param indicadorMailing the indicador mailing
	 * @return the string
	 */
	public String convertir(Integer indicadorMailing){
		String producto="";
		try {
			switch (indicadorMailing) {
			case 1:
				producto="Crédito Hipotecario";
				break;
			case 2:
				producto="Crédito Vehicular";
				break;
			case 3:
				producto="Cuenta Sueldo";
				break;
			case 4:
				producto="Fondos Mutuos";
				break;
			case 5:
				producto="Préstamo Personal";
				break;
			case 6:
				producto="Producto Pre Aprobado";
				break;
			case 7:
				producto="Seguro SOAT";
				break;
			case 8:
				producto="Tarjeta de Crédito";
				break;
			default:
				break;
			}
		} catch (Exception e) {
			_log.info("indicador de mailing vacio");
		}
		return producto;
	}
	
	//Validacion de todos los formularios en el primer paso
	/**
	 * Validar formulario1.
	 * Fecha: 22/08/2013
	 *
	 * @return the list
	 */
	private List<String> validarFormulario1(Map<String, String> mapCampos,String nombre_producto) {
		List<String> strErrors = new ArrayList<String>();
		//Para todos los formularios
		if (mapCampos.get("tipDoc").equalsIgnoreCase("1")) {
			// DNI
			if (!ValidatorUtils.solicitud_isDNI(mapCampos.get("ndocumento"))) {
				strErrors.add("ndocumento");
			}
			if (!ValidatorUtils.solicitud_isNombre(AsciiUtils.convertNonAscii(mapCampos.get("apeMater")))) {
				strErrors.add("apeMater");
			}
		} else {
			// Carne de extranjeria
			if (!ValidatorUtils.solicitud_isCarneExtranjeria(mapCampos.get("ndocumento"))) {
				strErrors.add("ndocumento");
			}
		}
		if (!ValidatorUtils.solicitud_isNombre(AsciiUtils.convertNonAscii(mapCampos.get("apePater")))) {
			strErrors.add("apePater");
		}
		if (!ValidatorUtils.solicitud_isNombre(AsciiUtils.convertNonAscii(mapCampos.get("priNombre")))) {
			strErrors.add("priNombre");
		}
		if (ValidatorUtils.isNotNull(mapCampos.get("segNombre"))) {
			if (!ValidatorUtils.solicitud_isNombre(AsciiUtils.convertNonAscii(mapCampos.get("segNombre")))) {
				strErrors.add("segNombre");
			}
		}
		if (mapCampos.get("fecNacimiento").equals("dd/mm/aaaa")) {
			strErrors.add("fecNacimiento");
		} else {
			if (!validarEdad(mapCampos.get("fecNacimiento"))) {
				strErrors.add("fecNacimiento");
			}
		}
		//Para formularios especficos
		if (nombre_producto.equals(Util.TARJETA_CREDITO) || nombre_producto.equals(Util.CREDITO_VEHICULAR) ||
				nombre_producto.equals(Util.CREDITO_HIPOTECARIO) || nombre_producto.equals(Util.PRESTAMO_PERSONAL)) {
			if (mapCampos.get("cboestadocivil").equals("0")) {
				strErrors.add("cboestadocivil");
			}
			if (mapCampos.get("cbosituacionlaboral").equals("0")) {
				strErrors.add("cbosituacionlaboral");
			}
			if (!ValidatorUtils.solicitud_isRUC(AsciiUtils.convertNonAscii(mapCampos.get("ruc")))) {
				strErrors.add("ruc");
			}
		}else if (nombre_producto.equals(Util.CUENTA_SUELDO)) {
			if (!ValidatorUtils.solicitud_isRUC(AsciiUtils.convertNonAscii(mapCampos.get("ruc")))) {
				strErrors.add("ruc");
			}
			if (!ValidatorUtils.solicitud_isRazonSocial(AsciiUtils.convertNonAscii(mapCampos.get("razonSocial")))) {
				strErrors.add("razonSocial");
			}
		}
		return strErrors;
	}
	
	//Validacion de los formularios en el segundo paso
	/**
	 * Validar formulario2.
	 * Fecha: 22/08/2013
	 *
	 * @return the list
	 */
	private List<String> validarFormulario2(Map<String, String> mapCampos,String nombre_producto) {
		List<String> strErrors = new ArrayList<String>();
		if (mapCampos.get("cbodepartamento").equals("0")) {
			strErrors.add("cbodepartamento");
		}
		if (!ValidatorUtils.solicitud_isCelular(mapCampos.get("celular"))) {
			strErrors.add("celular");
		}
		/*if (!ValidatorUtils.solicitud_isTelefono(mapCampos.get("telFijo"))) {
			strErrors.add("telFijo");
		}
		if (!ValidatorUtils.solicitud_isTelefono(mapCampos.get("telTrabajo"))) {
			strErrors.add("telTrabajo");
		}
		if (!ValidatorUtils.solicitud_isAnexo(mapCampos.get("anexo"))) {
			strErrors.add("anexo");
		}*/
		if (!ValidatorUtils.solicitud_isEmail(mapCampos.get("email"))) {
			strErrors.add("email");
		}
		if (!mapCampos.get("email").equals(mapCampos.get("confEmail")) || mapCampos.get("confEmail") == ""	|| !ValidatorUtils.solicitud_isEmail(mapCampos.get("confEmail"))) {
			strErrors.add("confEmail");
		}
		if (mapCampos.get("captcha").length() > 5) {
			strErrors.add("captcha");
		}
		
		//Para formularios especficos
		if (nombre_producto.equals(Util.CREDITO_VEHICULAR) || nombre_producto.equals(Util.CREDITO_HIPOTECARIO) || nombre_producto.equals(Util.PRESTAMO_PERSONAL)) {
			if (mapCampos.get("cboprovincia").equals("0")) {
				strErrors.add("cboprovincia");
			}
		}else if (nombre_producto.equals(Util.SEGURO_SOAT)) {
			if (mapCampos.get("cboprovincia").equals("0")) {
				strErrors.add("cboprovincia");
			}
			if (mapCampos.get("cbodistrito").equals("0")) {
				strErrors.add("cbodistrito");
			}
			if (!ValidatorUtils.solicitud_isDireccion(AsciiUtils.convertNonAscii(mapCampos.get("direccion")))) {
				strErrors.add("direccion");
			}
			if (!ValidatorUtils.solicitud_isPlaca(AsciiUtils.convertNonAscii(mapCampos.get("placa")))) {
				strErrors.add("placa");
			}
		}
		return strErrors;
	}
	
	//Metodo que genera la plantilla y funcionalidad de impresion
	/**
	 * Prints the report.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the string[]
	 */
	private String[] printReport(RenderRequest renderRequest,ProductoComplementarioBean productoPrincipal){
			PortletSession pSession = renderRequest.getPortletSession();
			PortletContext context;
			String urlArchivo, pathLectura, pathEscritura, template;
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			setListProductComplementarios((String)pSession.getAttribute("checkCodProducto"), renderRequest);
			
			String tipDoc = (String) pSession.getAttribute("tipDoc");
			String ndocumento = (String) pSession.getAttribute("ndocumento");
			String apePater = (String) pSession.getAttribute("apePater");
			String apeMater = (String) pSession.getAttribute("apeMater");
			String priNombre = (String) pSession.getAttribute("priNombre");
			String segNombre = (String) pSession.getAttribute("segNombre");
			String fecNacimiento = (String) pSession.getAttribute("fecNacimiento");
			String tipsexo = (String) pSession.getAttribute("tipsexo");
			String cbodepartamento = (String) pSession.getAttribute("cbodepartamentoTexto");
			String celular = pSession.getAttribute("celular") == null ? "NULO" : (String) pSession.getAttribute("celular");
			String telFijo = (String) pSession.getAttribute("telFijo");
			String telTrabajo = (String) pSession.getAttribute("telTrabajo");
			String anexo = (String) pSession.getAttribute("anexo");
			String email = (String) pSession.getAttribute("email");
			String nombreApellido = priNombre + " " + apePater;
			String mensaje = mensajeConfirmacion;
			String card = productoPrincipal.getProducto();
			String tipo = "Producto";
			String ruc = pSession.getAttribute("ruc") == null?"":(String)pSession.getAttribute("ruc");
			String razonSocial = pSession.getAttribute("razonSocial") == null?"":(String)pSession.getAttribute("razonSocial");
			String valorRenta = pSession.getAttribute("valorRenta") == null?"":(String)pSession.getAttribute("valorRenta");
			String cboestadocivil = pSession.getAttribute("cboestadocivilTexto") == null?"":(String)pSession.getAttribute("cboestadocivilTexto");
			String cbosituacionlaboral = pSession.getAttribute("cbosituacionlaboralTexto") == null?"":(String)pSession.getAttribute("cbosituacionlaboralTexto");
			String cboprovincia = pSession.getAttribute("cboprovinciaTexto") == null?"":(String)pSession.getAttribute("cboprovinciaTexto");
			
			int height = 1100;
			StringBuilder html = new StringBuilder();

			if (tipDoc.equals("2")) {
				tipDoc = "Carné Ext.";
			} else {
				tipDoc = "DNI";
			}

			if (tipsexo.equals("2")) {
				tipsexo = "Femenino";
			} else {
				tipsexo = "Masculino";
			}

			if (getSolicitud(renderRequest.getPortletSession()).getProductoComplementarios().size() > 1) {
				height = (30 * getSolicitud(renderRequest.getPortletSession()).getProductoComplementarios().size() - 1) + (75 + height);
				html.append("<div class=\"resul-soli\">");
				html.append("<h3 style='overflow: hidden; width: 407px !important; height: 42px !important; padding: 0px !important;'> <img src='/halcon-theme/images/halcon/detalle_productos_complementarios.jpg' border='0'></img></h3> ");
				for (ProductoComplementarioBean p : getSolicitud(renderRequest.getPortletSession()).getProductoComplementarios()) {
					if (p.getPrincipalidad().equals("N")) {
						html.append("<div class=\"campos-oblig-dos tus-datos\" style='height:auto !important'>");
						html.append("<label>Tipo</label>");
						html.append(String.format("<p>%s</p>", p.getProducto()));
						html.append("<div class='both'></div>");
						html.append("</div>");
						html.append("<div class='both'></div>");
					}
				}
				html.append("</div>");
			}

			context = renderRequest.getPortletSession().getPortletContext();
			pathLectura = context.getRealPath(Util.CARPETA_TEMPLATE) + "/imprimir.html";
			urlArchivo = "#";

			try {
				Date fecha = new Date();
				long horaActual = fecha.getTime();
				String productos = (getSolicitud(renderRequest.getPortletSession()).getProductoComplementarios().size() != 0) ? html.toString() : "";
				
				pathEscritura = context.getRealPath(Util.CARPETA_TEMPLATE) + Util.getCarpetaDiaria()+ "/" + horaActual+ ".html";
				
				template = Util.getTemplateHTML(renderRequest, pathLectura);
				StringBuilder cadena = new StringBuilder();

				template = template.replaceAll("%FULLNAME%", nombreApellido);
				template = template.replaceAll("%MENSAJE%", mensaje);

				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Tipo de Documento", tipDoc));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Número de Documento", ndocumento));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Apellido Paterno", apePater));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Apellido Materno", apeMater));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Primer Nombre", priNombre));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Segundo Nombre", segNombre));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Fecha de Nacimiento", fecNacimiento));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Sexo", tipsexo));
				if (nombre_producto.equals(Util.TARJETA_CREDITO) || nombre_producto.equals(Util.CREDITO_VEHICULAR) || nombre_producto.equals(Util.CREDITO_HIPOTECARIO) || nombre_producto.equals(Util.PRESTAMO_PERSONAL)) {
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Estado Civil", cboestadocivil));
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Situación Laboral", cbosituacionlaboral));
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","RUC", ruc));
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Renta Mensual", valorRenta));
				}else if (nombre_producto.equals(Util.CUENTA_SUELDO)) {
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","RUC", ruc));
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Razón Social", razonSocial));
				}
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Departamento", cbodepartamento));
				if (nombre_producto.equals(Util.CREDITO_VEHICULAR) || nombre_producto.equals(Util.CREDITO_HIPOTECARIO) || nombre_producto.equals(Util.PRESTAMO_PERSONAL)) {
					cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Provincia", cboprovincia));
				}
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Celular", celular));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Teléfono de Casa", telFijo));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Teléfono de Trabajo", telTrabajo));
				cadena.append(String.format("<div class='campos-oblig-dos tus-datos'><label>%s</label><p>%s</p></div>","Anexo", anexo));
				cadena.append(String.format("<div class='campos-oblig-dos final'><label>%s</label><p>%s</p></div>","Correo Electrónico", email));
				cadena.append(String.format("<br class='both'/>"));
				
				template = template.replaceAll("%ATRIBUTOS%", cadena.toString());
				template = template.replaceAll("%TIPO%", tipo);
				template = template.replaceAll("%CARD%", card);
				template = template.replaceAll("%PRODUCT%", productos);
				template = template.replaceAll("%RUTA_CSS%", themeDisplay.getPathThemeCss());

				//Generamos la url de descarga
				String urlDetalle="/" + horaActual + ".html";
				/*Creamos la URL Tipos de Operacion*/
				PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
				String portletName=portletDisplay.getId();
				long plid=themeDisplay.getPlid();
				  
				LiferayPortletURL urlDescarga=PortletURLFactoryUtil.create(renderRequest, portletName, plid, PortletRequest.RESOURCE_PHASE);
				urlDescarga.setResourceID("descargarPDF");
				urlDescarga.setParameter("file", urlDetalle);
				template = template.replaceAll("%URL_DESCARGA%", urlDescarga.toString());
				
				Util.generateHTML(renderRequest, template, pathEscritura);
				urlArchivo = themeDisplay.getURLPortal() + "/FormularioSolicitarProductos-portlet/template"+Util.getCarpetaDiaria()+ "/"  + horaActual + ".html";
			} catch (Exception e) {
				_log.error("Error al crear template:" + e.toString());
				e.printStackTrace();
			}
			String[] data = { urlArchivo, Integer.toString(height) };
			return data;
		}
	
	//Metodo para la impresion en PDF, utilizado para las versiones de navegadores ie6, ie7, ie8
	/**
	 * Server resource.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param response the response
	 */
	@ResourceMapping("descargarPDF")
	public void serverResource(ResourceRequest request,ResourceResponse response) {
			try {
					
				String filename = ParamUtil.getString(request, "file");
					 
				PortletContext context = request.getPortletSession().getPortletContext();
					
				String html=Util.getTemplateHTML(request, context.getRealPath(Util.CARPETA_TEMPLATE) +Util.getCarpetaDiaria()+ filename);
				html=HtmlUtil.stripBetween(html, "meta");
				html=HtmlUtil.stripBetween(html, "a");
				html=HtmlUtil.stripBetween(html, "em");
				html=HtmlUtil.stripBetween(html, "script");
				html=HtmlUtil.stripComments(html);
				html=html.replaceFirst("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">", "");
				html=html.replaceFirst("<html xmlns=\"http://www.w3.org/1999/xhtml\">", "<html>");
				html=html.replaceFirst("</head>", "<style type=\"text/css\">@page {	margin: 2px;} </style></head>");
				    
				ITextRenderer iTextRenderer = new ITextRenderer();
				iTextRenderer.setDocumentFromString(html);
				iTextRenderer.layout();
					
		   		response.setContentType("application/pdf");
		   		response.addProperty(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=formulario.pdf");
				OutputStream elFichero =response.getPortletOutputStream(); 
				iTextRenderer.createPDF(elFichero);
			    elFichero.flush();
			    elFichero.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}				
			}

	//Metodo para validar en que se pagina se encuentra el usuario, si permitira avanzar o retroceder	
	 /**
	 * Obtener view pagina.
	 * Fecha: 22/08/2013
	 *
	 * @param viewPagina the view pagina
	 * @param paso the paso
	 * @param renderRequest the render request
	 * @param productoPrincipal the producto principal
	 * @return the string
	 */
	private String obtenerViewPagina(String viewPagina,int paso,RenderRequest renderRequest,ProductoComplementarioBean productoPrincipal){
		String view = "";
		switch (paso) {
		case 1:
			getSolicitud(renderRequest.getPortletSession()).getProductoComplementarios().clear();
			getSolicitud(renderRequest.getPortletSession()).getProductoComplementarios().add(productoPrincipal);
			return viewPagina+numeroPaso1;
		case 2:
			if (nombre_producto.equals(Util.CREDITO_HIPOTECARIO)) {
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Hipotecario()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			} else if(nombre_producto.equals(Util.CREDITO_VEHICULAR)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Vehicular()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.CUENTA_SUELDO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Sueldo()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.FONDO_MUTUO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Mutuos()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.PRESTAMO_PERSONAL)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Personal()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.PRODUCTO_PREAPROBADO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Aprobado()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.SEGURO_SOAT)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Soat()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.TARJETA_CREDITO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Credito()) {
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}
			return view;
		case 3:
			if (nombre_producto.equals(Util.CREDITO_HIPOTECARIO)) {
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Hipotecario() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Hipotecario()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Hipotecario()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			} else if(nombre_producto.equals(Util.CREDITO_VEHICULAR)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Vehicular() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Vehicular()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Vehicular()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.CUENTA_SUELDO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Sueldo() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Sueldo()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Sueldo()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.FONDO_MUTUO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Mutuos() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Mutuos()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Mutuos()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.PRESTAMO_PERSONAL)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Personal() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Personal()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Personal()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.PRODUCTO_PREAPROBADO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Aprobado() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Aprobado()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Aprobado()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.SEGURO_SOAT)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Soat() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2soat()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Soat()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.TARJETA_CREDITO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Credito() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Credito()) {
					view  = viewPagina+numeroPaso3;
				}else if(getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Credito()){
					view = viewPagina+numeroPaso2;
				}else{
					view = viewPagina+numeroPaso1;
				}
			}
			return view;
		case 4:
			if (nombre_producto.equals(Util.CREDITO_HIPOTECARIO)) {
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Hipotecario() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Hipotecario()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Hipotecario()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			} else if(nombre_producto.equals(Util.CREDITO_VEHICULAR)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Vehicular() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Vehicular()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Vehicular()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.CUENTA_SUELDO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Sueldo() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Sueldo()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Sueldo()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.FONDO_MUTUO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Mutuos() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Mutuos()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Mutuos()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.PRESTAMO_PERSONAL)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Personal() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Personal()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Personal()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.PRODUCTO_PREAPROBADO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Aprobado() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Aprobado()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Aprobado()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.SEGURO_SOAT)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Soat() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2soat()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Soat()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}else if(nombre_producto.equals(Util.TARJETA_CREDITO)){
				if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Credito() && getSolicitud(renderRequest.getPortletSession()).getEstadoPaso2Credito()) {
					String[] url = printReport(renderRequest,productoPrincipal);
					renderRequest.setAttribute("urlPrint", url);
					view = viewPagina+numeroPaso4;
					getSolicitud(renderRequest.getPortletSession()).inicializarSolicitud();
					return view;
				} else if (getSolicitud(renderRequest.getPortletSession()).getEstadoPaso1Credito()) {
					view = viewPagina+numeroPaso2;
				} else {
					view = viewPagina+numeroPaso1;
				}
			}
			return view;		
		}
		return viewPagina+numeroPaso1;
	}
	
	//Se obtiene el arbol de paginas donde se encuentra el portlet
	/**
	 * Obtener tree.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	public String obtenerTree(RenderRequest renderRequest){
		String cadena=JSonUtil.NAME_ARBOL;
		String solicitudes="Solicitudes";
		String breadCrumb="Solicitar > ";
		cadena=cadena.replaceAll(";", "");
		if(cadena.indexOf(solicitudes)!=-1){
			//entra si encuentra la palabra solicitudes, hara lo siguiente
			String producto=convertir(indicadorMailing);
			cadena=cadena+producto;
			cadena=cadena.replaceAll("Solicitudes", breadCrumb);

			PortletSession pSession = renderRequest.getPortletSession();
			pSession.setAttribute("producto", producto);	
		}
		return cadena;
	}
	
	//Actualiza el DNI en sesion, enviado desde otros portlets como por ejemplo simuladores
	/**
	 * Poner en sesion dni.
	 * Fecha: 22/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @param tipo the tipo
	 * @param numero the numero
	 */
	public void ponerEnSesionDNI(ResourceRequest resourceRequest, String tipo, String numero){
		
			//Registramos el DNI en sesion
			SessionBean session=new SessionBean();
			session.setTipoDoc(tipo);
			session.setNumDoc(numero);
			SessionUtil.registrarSession(session, resourceRequest,true);			
	}
	
	//Llena los productos complementarios que se encuentran en sesion
	/**
	 * Sets the list product complementarios.
	 * Fecha: 22/08/2013
	 *
	 * @param codFormateados the cod formateados
	 * @param resourceRequest the resource request
	 */
	@SuppressWarnings("unchecked")
    private void setListProductComplementarios(String codFormateados,PortletRequest resourceRequest){
		
		String[] codigos = codFormateados.trim().split(",");
		List<ProductoComplementarioBean> listaSesion = (List<ProductoComplementarioBean>) resourceRequest.getPortletSession().getAttribute("listComplementarios", PortletSession.PORTLET_SCOPE);
		
		//Aqui limpiamos los productos complementaros despues del primero
	if(getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().size() > 0){	
                getSolicitud(resourceRequest.getPortletSession()).setProductoComplementarios(getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().subList(0, 1));
	}else{
		getSolicitud(resourceRequest.getPortletSession()).setProductoComplementarios(new ArrayList<ProductoComplementarioBean>());
	}	
        if (ValidatorUtils.isNotNull(listaSesion)) {
			if(!listaSesion.isEmpty()){
			  for (ProductoComplementarioBean p : listaSesion) {
				if (isContains(p.getIdContenidoWeb(), codigos)) {
					getSolicitud(resourceRequest.getPortletSession()).getProductoComplementarios().add(p);
				}
			}
		  }
		}
	}
	
	//Valida si las variables son constantes
	/**
	 * Comprueba si es contains.
	 * Fecha: 22/08/2013
	 *
	 * @param codActual the cod actual
	 * @param codigos the codigos
	 * @return true, si es contains
	 */
	private boolean isContains(String codActual,String[] codigos){
		for (int i = 0; i < codigos.length; i++) {
			if (codActual.equals(codigos[i])) {
				return true;
			}
		}
		return false;
	}
	
	//Obtiene los valores de cada JSON para renta mensual
	/**
	 * Obtiene jSON values.
	 * Fecha: 22/08/2013
	 *
	 * @param rango the rango
	 * @return jSON values
	 */
	private String getJSONValues(RangoBean rango){
		JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
		try{
			jsonObject.put("inicio", rango.getValorInicial());
			jsonObject.put("fin", rango.getValorFinal());
			jsonObject.put("incremento", rango.getIncremento());
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	//Limpia todos los valores en sesion de los formularios de solicitud
	/**
	 * Limpiar sesion.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 */
	public void limpiarSesion(PortletRequest portletRequest){
		PortletSession pSession = portletRequest.getPortletSession();
		
		pSession.removeAttribute("tipDoc");
		pSession.removeAttribute("ndocumento");
		pSession.removeAttribute("apePater");
		pSession.removeAttribute("apeMater");
		pSession.removeAttribute("priNombre");
		pSession.removeAttribute("segNombre");
		pSession.removeAttribute("fecNacimiento");
		pSession.removeAttribute("tipsexo");
		pSession.removeAttribute("ruc");
		pSession.removeAttribute("razonSocial");
		pSession.removeAttribute("valorRenta");

		pSession.removeAttribute("cbodepartamento");
		pSession.removeAttribute("cboprovincia");
		pSession.removeAttribute("cbodistrito");
		pSession.removeAttribute("celular");
		pSession.removeAttribute("telFijo");
		pSession.removeAttribute("telTrabajo");
		pSession.removeAttribute("anexo");
		pSession.removeAttribute("email");
		pSession.removeAttribute("confEmail");
		pSession.removeAttribute("distrito");
		pSession.removeAttribute("horario");
		pSession.removeAttribute("placa");
		pSession.removeAttribute("nombreApellido");
		pSession.removeAttribute("urlRedireccionar");
		pSession.removeAttribute("checkCodProducto");
		pSession.removeAttribute("mensajeConfirmacion");
		pSession.removeAttribute("error");
		
		pSession.removeAttribute("utm_source");
		pSession.removeAttribute("utm_medium");
		pSession.removeAttribute("utm_content");
		pSession.removeAttribute("utm_campaign");
		
		pSession.removeAttribute("listProductComplCheck");
		pSession.removeAttribute("listComplementarios");
		
		pSession.removeAttribute("cboestadocivil");
		pSession.removeAttribute("cboestadocivilTexto");
		pSession.removeAttribute("cbosituacionlaboral");
		pSession.removeAttribute("cbosituacionlaboralTexto");
		
		getSolicitud(pSession).setEstadoPaso1Aprobado(false);
		getSolicitud(pSession).setEstadoPaso1Credito(false);
		getSolicitud(pSession).setEstadoPaso1Hipotecario(false);
		getSolicitud(pSession).setEstadoPaso1Mutuos(false); 
		getSolicitud(pSession).setEstadoPaso1Personal(false);
		getSolicitud(pSession).setEstadoPaso1Soat(false);
		getSolicitud(pSession).setEstadoPaso1Sueldo(false);
		getSolicitud(pSession).setEstadoPaso1Vehicular(false);

		getSolicitud(pSession).setEstadoPaso2Aprobado(false);
		getSolicitud(pSession).setEstadoPaso2Credito(false);
		getSolicitud(pSession).setEstadoPaso2Hipotecario(false);
		getSolicitud(pSession).setEstadoPaso2Mutuos(false); 
		getSolicitud(pSession).setEstadoPaso2Personal(false);
		getSolicitud(pSession).setEstadoPaso2soat(false);
		getSolicitud(pSession).setEstadoPaso2Sueldo(false);
		getSolicitud(pSession).setEstadoPaso2Vehicular(false);
		
		getSolicitud(pSession).setProductoComplementarios(new ArrayList<ProductoComplementarioBean>());
	}
	
	public void validarTipoDocumento(RenderRequest renderRequest){
		
		//Primero verificamos si se encuentra en sesion
		//Verificar si existe en sesion el dni
		SessionBean sBean;
		sBean=SessionUtil.traerSession(renderRequest);
		String nd=sBean.getNumDoc();
		String td=sBean.getTipoDoc();
		//Integer i=sBean.getIndicador();
		
		if(sBean.getIndicador()==1 ){
			getSolicitud(renderRequest.getPortletSession()).setIdTipoDocumento(td);
			getSolicitud(renderRequest.getPortletSession()).setNumeroDocumento(nd);
		}
		
		
		String longitud="";
		String valorHiddenTipoDoc="1";
		
		if(getSolicitud(renderRequest.getPortletSession()).getIdTipoDocumento()==null || getSolicitud(renderRequest.getPortletSession()).getIdTipoDocumento().equals("") || getSolicitud(renderRequest.getPortletSession()).getIdTipoDocumento().equals("1")){	
			longitud="8";	
		}else{
				valorHiddenTipoDoc="2";
				longitud="12";						
		}
		renderRequest.setAttribute("longitud",longitud);		
		renderRequest.setAttribute("valorHiddenTipoDoc",valorHiddenTipoDoc);
	}
	
	
	public SolicitudProductoBean getSolicitud(PortletSession portletSession){
		String nombreProducto=SolicitudProductoLocalServiceUtil.getEtiquetaSolicitudByFriendlyURL("/"+String.valueOf(portletSession.getAttribute("nombre_producto_url",PortletSession.PORTLET_SCOPE)));
		if (nombreProducto.equals(Util.CREDITO_HIPOTECARIO)) {
			SolicitudProductoBean solicitudCreditoHipotecario = (SolicitudProductoBean) portletSession.getAttribute("solicitudCreditoHipotecario",PortletSession.PORTLET_SCOPE);
			if (solicitudCreditoHipotecario ==  null) {
				solicitudCreditoHipotecario = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudCreditoHipotecario",solicitudCreditoHipotecario, PortletSession.PORTLET_SCOPE);
			}
			return solicitudCreditoHipotecario;
		} else if(nombreProducto.equals(Util.CREDITO_VEHICULAR)){
			SolicitudProductoBean solicitudCreditoVehicular = (SolicitudProductoBean) portletSession.getAttribute("solicitudCreditoVehicular",PortletSession.PORTLET_SCOPE);
			if (solicitudCreditoVehicular ==  null) {
				solicitudCreditoVehicular = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudCreditoVehicular",solicitudCreditoVehicular, PortletSession.PORTLET_SCOPE);
			}
			return solicitudCreditoVehicular;
		}else if(nombreProducto.equals(Util.CUENTA_SUELDO)){
			SolicitudProductoBean solicitudCuentaSueldo = (SolicitudProductoBean) portletSession.getAttribute("solicitudCuentaSueldo",PortletSession.PORTLET_SCOPE);
			if (solicitudCuentaSueldo ==  null) {
				solicitudCuentaSueldo = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudCuentaSueldo",solicitudCuentaSueldo, PortletSession.PORTLET_SCOPE);
			}
			
			return solicitudCuentaSueldo;
		}else if(nombreProducto.equals(Util.FONDO_MUTUO)){
			SolicitudProductoBean solicitudFondosMutuos = (SolicitudProductoBean) portletSession.getAttribute("solicitudFondosMutuos",PortletSession.PORTLET_SCOPE);
			if (solicitudFondosMutuos ==  null) {
				solicitudFondosMutuos = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudFondosMutuos",solicitudFondosMutuos, PortletSession.PORTLET_SCOPE);
			}
			return solicitudFondosMutuos;
		}else if(nombreProducto.equals(Util.PRESTAMO_PERSONAL)){
			SolicitudProductoBean solicitudPrestamoPersonal = (SolicitudProductoBean) portletSession.getAttribute("solicitudPrestamoPersonal",PortletSession.PORTLET_SCOPE);
			if (solicitudPrestamoPersonal ==  null) {
				solicitudPrestamoPersonal = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudPrestamoPersonal",solicitudPrestamoPersonal, PortletSession.PORTLET_SCOPE);
			}
			return solicitudPrestamoPersonal;
		}else if(nombreProducto.equals(Util.PRODUCTO_PREAPROBADO)){
			SolicitudProductoBean solicitudPreAprobado = (SolicitudProductoBean) portletSession.getAttribute("solicitudPreAprobado",PortletSession.PORTLET_SCOPE);
			if (solicitudPreAprobado ==  null) {
				solicitudPreAprobado = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudPreAprobado",solicitudPreAprobado, PortletSession.PORTLET_SCOPE);
			}
			return solicitudPreAprobado;
		}else if(nombreProducto.equals(Util.SEGURO_SOAT)){
			SolicitudProductoBean solicitudSeguroSoat = (SolicitudProductoBean) portletSession.getAttribute("solicitudSeguroSoat",PortletSession.PORTLET_SCOPE);
			if (solicitudSeguroSoat ==  null) {
				solicitudSeguroSoat = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudSeguroSoat",solicitudSeguroSoat, PortletSession.PORTLET_SCOPE);
			}
			return solicitudSeguroSoat;
		}else if(nombreProducto.equals(Util.TARJETA_CREDITO)){
			SolicitudProductoBean solicitudTarjetaCredito = (SolicitudProductoBean) portletSession.getAttribute("solicitudTarjetaCredito",PortletSession.PORTLET_SCOPE);
			if (solicitudTarjetaCredito ==  null) {
				solicitudTarjetaCredito = new SolicitudProductoBean();
				portletSession.setAttribute("solicitudTarjetaCredito",solicitudTarjetaCredito, PortletSession.PORTLET_SCOPE);
			}
			return solicitudTarjetaCredito;
		}
		return null;
	}
	
	private void inicializarEstadosFormulario(){
		
		this.estadoPaso1Credito = false;
		this.estadoPaso2Credito = false;
		
		this.estadoPaso1Vehicular = false;
		this.estadoPaso2Vehicular = false;
		
		this.estadoPaso1Hipotecario = false;
		this.estadoPaso2Hipotecario = false;
		
		this.estadoPaso1Personal = false;
		this.estadoPaso2Personal = false;
		
		this.estadoPaso1Mutuos = false;
		this.estadoPaso2Mutuos = false;
		
		this.estadoPaso1Sueldo = false;
		this.estadoPaso2Sueldo = false;
		
		this.estadoPaso1Soat = false;
		this.estadoPaso2soat = false;
		
		this.estadoPaso1Aprobado = false;
		this.estadoPaso2Aprobado = false;
	}
	
	public void limpiarVariablesTema(ResourceRequest resourceRequest){
		String utm_source="";
		String utm_medium="";
		String utm_content="";
		String utm_campaign="";
		
		PortletSession pSession=resourceRequest.getPortletSession();
		pSession.setAttribute("LIFERAY_SHARED_UTM_SOURCE", utm_source,PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_UTM_MEDIUM", utm_medium,PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_UTM_CONTENT", utm_content,PortletSession.APPLICATION_SCOPE);
		pSession.setAttribute("LIFERAY_SHARED_UTM_CAMPAIGN", utm_campaign,PortletSession.APPLICATION_SCOPE);
	}
		
	public void setearUbigeo(String cbodepartamento,String cboprovincia,String cbodistrito){
		//seteando ubigeo para la bd
		int longitudDepartamento = cbodepartamento.length();
		int longitudProvincia = cboprovincia.length();
		int longitudDistrito = cbodistrito.length();
		
		if(longitudDepartamento>0){
			if(longitudDepartamento==1){
				cbodepartamento="0"+cbodepartamento;
			}			
		}

		if(longitudProvincia>0){
			if(longitudProvincia==3){
				cboprovincia="0"+cboprovincia;
			}
		}
		
		if(longitudDistrito>0){
			if(longitudDistrito==1){
				cbodistrito=cboprovincia+"0"+cbodistrito;
			}else{
				cbodistrito=cboprovincia+cbodistrito;
			}
		}
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

	
}	