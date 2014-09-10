package pe.com.ibk.halcon.simulacion.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.StringUtils;

import pe.com.ibk.halcon.simulacion.bean.CalculoBean;
import pe.com.ibk.halcon.simulacion.bean.GraficoBean;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.AuditoriaSimulador;
import com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil;
import com.ext.portlet.halcon.service.SeguridadLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ResultadoSimulacionUtil.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class ResultadoSimulacionUtil {

	
	public static final String CREDITO_HIPOTECARIO = PortletProps.get("credito.hipotecario");
	public static final String CREDITO_MIVIVIENDA = PortletProps.get("credito.mivivienda");
	public static final String CREDITO_TECHO_PROPIO = PortletProps.get("credito.techo.propio");
	public static final String PRESTAMO_GARANTIA_HIPOTECARIA = PortletProps.get("credito.garantia.hipotecaria");
	
	public static final Integer PLAZO_CRE_SIM_DEPOSITO_PLAZO = 150;
	public static final Integer PLAZO_SIM_FONDO_MUTUO = 276;
	public static final Integer PLAZO_CRE_SIM_PERSONAL = 129;
	public static final String etiqueta_tooltip = "tooltip";
	
	private static Locale locale =  new Locale("es", "ES");
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ResultadoSimulacionUtil.class);
	
	/** The Constant CARPETA_PORTLET. */
	public static final  String CARPETA_PORTLET = "/ResultadoSimulacion-portlet";
	
	/** The Constant CARPETA_TEMPLATE. */
	public static final  String CARPETA_TEMPLATE = "/template";
	//Templates de cada simulador
	/** The Constant TEMPLATE_SIMULADOR_VEHICULAR. */
	public static final  String TEMPLATE_SIMULADOR_VEHICULAR = "/vehicular.html";
	
	/** The Constant TEMPLATE_SIMULADOR_PERSONAL. */
	public static final  String TEMPLATE_SIMULADOR_PERSONAL = "/personal.html";
	
	/** The Constant TEMPLATE_SIMULADOR_HIPOTECARIO. */
	public static final  String TEMPLATE_SIMULADOR_HIPOTECARIO= "/hipotecario.html";
	
	/** The Constant ARCHIVO_SIMULADOR_PREFIX. */
	public static final  String ARCHIVO_SIMULADOR_PREFIX = "/simulacion";
	//Monedas
	/** The Constant CODIGO_SOLES. */
	private static final int CODIGO_SOLES = SimuladoresUtil.CODIGO_MONEDA_SOLES;
	
	/** The Constant CODIGO_DOLARES. */
	private static final int CODIGO_DOLARES = SimuladoresUtil.CODIGO_MONEDA_DOLARES;
	
	/** The Constant CODIGO_EUROS. */
	private static final int CODIGO_EUROS = SimuladoresUtil.CODIGO_MONEDA_EUROS;
	//Tipo de Seguro
	/** The Constant SEGURO_INDIVIDUAL. */
	private static final int SEGURO_INDIVIDUAL=1;
	
	/** The Constant SEGURO_MANCOMUNADO. */
	private static final int SEGURO_MANCOMUNADO=2;
	//Tipo de Seguro
	/** The Constant CUOTA_ORDINARIA. */
	private static final int CUOTA_ORDINARIA=1;
	
	/** The Constant CUOTA_EXTRAORDINARIA. */
	private static final int CUOTA_EXTRAORDINARIA=2;
		
	/**
	 * Obtiene template html.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param filePath the file path
	 * @return template html
	 */
	public static String getTemplateHTML(PortletRequest request, String filePath) {
		String templateHTML;

		templateHTML = "";
		try {
			BufferedReader bufferLectura;
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
			bufferLectura.close();

			templateHTML = fileData.toString();

		} catch (Exception e) {
			_log.error("Error al leer Template de HTML:" + e.toString());
		}

		return templateHTML;
	}

	
	/**
	 * Generate html.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param htmlVideo the html video
	 * @param filePath the file path
	 */
	public static void generateHTML(PortletRequest request, String htmlVideo, String filePath) {
		try {
			BufferedWriter bufferEscritura;
			bufferEscritura = new BufferedWriter(new FileWriter(filePath, false));	
			bufferEscritura.write(htmlVideo);
			bufferEscritura.close();
		} catch (Exception e) {
			_log.error("Error al Escribir Video de HTML:",e);
		}
	}
	
	/**
	 * Parses the xml dateto string.
	 * Fecha: 22/08/2013
	 *
	 * @param calendar the calendar
	 * @return the string
	 */
	public static String parseXMLDatetoString(XMLGregorianCalendar calendar){
		String resp="";
		if(calendar!=null){
			Date fec=calendar.toGregorianCalendar().getTime();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			resp=formato.format(fec);
		}
		return resp;
	}
	
	/**
	 * Format doubleto string.
	 * Fecha: 22/08/2013
	 *
	 * @param numero the numero
	 * @return the string
	 */
	public static String formatDoubletoString(Double numero){
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
	 * Simbolo moneda.
	 * Fecha: 22/08/2013
	 *
	 * @param moneda the moneda
	 * @return the string
	 */
	public static String simboloMoneda(String moneda) {
		String nombre = "";
		int tipoMoneda=Integer.parseInt(moneda);
		
		if(tipoMoneda== CODIGO_SOLES){
			nombre = "S/.";
		}else if(tipoMoneda==CODIGO_DOLARES){
			nombre = "US$";
		}else if(tipoMoneda==CODIGO_EUROS){
			nombre = "€";
		}
		return nombre;
	}
	
	  /**
  	 * Traer hermanos.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param lista the lista
  	 * @param valor the valor
  	 * @return the list
  	 */
  	public static List traerHermanos(List lista,Object valor){
		  List respuesta=new ArrayList();
		  if(lista!=null){
			if(!lista.isEmpty()){
				int posicionValor=0;//Posicion en el arreglo de valores
				int contadorPosicion=0;
				int tamanioLista=lista.size();
				
				for (Object object : lista) {
					if(object.equals(valor)){
						posicionValor=contadorPosicion;
						break;
					}
					contadorPosicion++;
				}

				int inicio=(posicionValor==0?0:posicionValor-1);
				int fin=(posicionValor==tamanioLista-1?tamanioLista-1:posicionValor+1);
				
				if(inicio==fin){
					respuesta.add(lista.get(inicio));
				}else{
					for(int i=inicio;i<=fin;i++){
							respuesta.add(lista.get(i));
					}
				}
			}
		  }
		  
		  return respuesta;
	  }
	  
	  /**
  	 * Obtiene carpeta diaria.
  	 * Fecha: 22/08/2013
  	 *
  	 * @return carpeta diaria
  	 */
  	public static String getCarpetaDiaria(){
		  /*Carpeta con el dia actual*/
		  Calendar fecha= Calendar.getInstance();
		  String dia=StringUtils.leftPad(String.valueOf(fecha.get(Calendar.DATE)), 2, '0');
		  String mes=StringUtils.leftPad(String.valueOf(fecha.get(Calendar.MONTH)+1), 2, '0');
		  String anio=StringUtils.leftPad(String.valueOf(fecha.get(Calendar.YEAR)), 2, '0');
		  
		  //Formato yyyyMMdd
		  return "/"+anio+mes+dia;
	  }
	  
	  /**
  	 * Verificar carpeta diaria.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param portletRequest the portlet request
  	 */
  	public static void verificarCarpetaDiaria(PortletRequest portletRequest){
		  //Creamos la carpeta del dia si no existiera y eliminamos las carpetas del dia anterior
		  String pathEscritura,carpetaDiaria;
		  PortletContext context ;
		  
		  context= portletRequest.getPortletSession().getPortletContext();
		  pathEscritura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE);	  
		  File folderTemplateLocal = new File(pathEscritura);
		  carpetaDiaria=getCarpetaDiaria();
		  
		  //_log.info("Carpeta Diaria:"+carpetaDiaria);
		  if(folderTemplateLocal.exists()&& folderTemplateLocal.isDirectory()){
			  // _log.info("LA RUTA EXISTE ELIMINAMOS LAS CARPETAS ANTIGUAS");
			  File[] contenidoCarpeta = folderTemplateLocal.listFiles();
			  for (int i = 0; i < contenidoCarpeta.length; i++) {
				  if (contenidoCarpeta[i].isDirectory() && !carpetaDiaria.equalsIgnoreCase("/"+contenidoCarpeta[i].getName())) {
					  eliminarCarpeta(contenidoCarpeta[i]);
				  }
			  }
			  //_log.info("Verificamos si existe la carpeta diaria y la creamos si fuera necesario");

			  File folderCarpetaDiariaLocal = new File(pathEscritura+carpetaDiaria);
			  //verificamos que exista la ruta y es un directorio
			  if(!(folderCarpetaDiariaLocal.exists() && folderCarpetaDiariaLocal.isDirectory())){
				  folderCarpetaDiariaLocal.mkdirs();
			  }
		  }
	  }
	  
	  /**
  	 * Eliminar carpeta.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param directory the directory
  	 */
  	private static void eliminarCarpeta(File directory) {
			if (directory.exists() && directory.isDirectory()) {
				File[] fileArray = directory.listFiles();

				for (int i = 0; i < fileArray.length; i++) {
					if (fileArray[i].isDirectory()) {
						eliminarCarpeta(fileArray[i]);
					}
					else {
						fileArray[i].delete();
					}
				}

				directory.delete();
			}
		}
	  
	  /**
  	 * Insertar historial simulador.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param simulador the simulador
  	 * @param portletRequest the portlet request
  	 * @return the simulador bean
  	 * @throws BusinessException the business exception
  	 */
  	public static SimuladorBean insertarHistorialSimulador(SimuladorBean simulador,PortletRequest portletRequest) throws BusinessException{ 
			
			AuditoriaSimulador auditoriaSimulador = AuditoriaSimuladorLocalServiceUtil.getInstance();
			
				auditoriaSimulador.setTipoSimulador(simulador.getTipoSimulador());
		//		auditoriaSimulador.setIdTransaccion(simulador.getIdTransaccion());
				auditoriaSimulador.setTipoDocumento(simulador.getTipoDocumento());
				auditoriaSimulador.setNumDocumento(simulador.getNumeroDocumento());
				auditoriaSimulador.setMoneda(simulador.getTipoMoneda());
				auditoriaSimulador.setTipoProducto(simulador.getNombreCreditoProducto());
				auditoriaSimulador.setInvirtioFondMut(simulador.getInvirtioFondoMutuo());
				auditoriaSimulador.setNivelConocimFondMut(simulador.getNivelConocimientoFondoMutuo());
				auditoriaSimulador.setReaccionVarMerc(simulador.getReaccionVariacionMercado());
				auditoriaSimulador.setInvirtioFondMut(simulador.getOpcion1());
				auditoriaSimulador.setNivelConocimFondMut(simulador.getOpcion2());
				auditoriaSimulador.setReaccionVarMerc(simulador.getOpcion3());
				if (ValidatorUtils.isNotNull(simulador.getValorBien())) {
					auditoriaSimulador.setValorBien(Double.valueOf(simulador.getValorBien()));
				}
				
				if (ValidatorUtils.isNotNull(simulador.getMontoPrestamo())) {
					auditoriaSimulador.setMontoPrestamo(Double.valueOf(simulador.getMontoPrestamo()));
				}
				if (ValidatorUtils.isNotNull(simulador.getCuotaInicial())) {
					auditoriaSimulador.setCuotaInicial(Double.valueOf(simulador.getCuotaInicial()));
				}
				
				auditoriaSimulador.setPeriodoInvers(simulador.getPlazoCredito());
				if (ValidatorUtils.isNotNull(simulador.getTasa())) {
					auditoriaSimulador.setTasa(Double.valueOf(simulador.getTasa()));
				}
				
				auditoriaSimulador.setSegDesgrav(simulador.getSeguroDesgravamen());
				auditoriaSimulador.setTipoCuota(simulador.getTipoCuota());
				auditoriaSimulador.setIP(JSonUtil.IP);
				auditoriaSimulador.setFechaHora(TiempoUtil.getTiempoActualEnDate());
				//Extraemos los utm
				PortletSession pSession=portletRequest.getPortletSession();
			    String utmSourceActual=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_SOURCE",PortletSession.APPLICATION_SCOPE);
			    String utmMediumActual=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_MEDIUM",PortletSession.APPLICATION_SCOPE);
			    String utmContentActual=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_CONTENT",PortletSession.APPLICATION_SCOPE);
			    String utmCampaignActual=(String)pSession.getAttribute( "LIFERAY_SHARED_UTM_CAMPAIGN",PortletSession.APPLICATION_SCOPE);
			    			    
				auditoriaSimulador.setUTMCampaing(utmCampaignActual);
				auditoriaSimulador.setUTMContent(utmContentActual);
				auditoriaSimulador.setUTMMedium(utmMediumActual);
				auditoriaSimulador.setUTMSource(utmSourceActual);
				
				auditoriaSimulador = AuditoriaSimuladorLocalServiceUtil.insertar(auditoriaSimulador);
				
				simulador.setIdSimulador(auditoriaSimulador.getIdAuditoriaSim());
					
			return simulador;
		}
	  
	  
	  /**
  	 * Obtener url ficha.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param codigoHPC the codigo hpc
  	 * @return the string
  	 */
  	public static String obtenerURLFicha(int codigoHPC){
			String urlFicha="";
			
			try{
				//Producto Vehicular
				if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL){
					urlFicha=PortletProps.get("simulador.vehicular.ficha.tradicional");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE){
					urlFicha=PortletProps.get("simulador.vehicular.ficha.inteligente");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO){
					urlFicha=PortletProps.get("simulador.vehicular.ficha.casinuevo");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL){
					urlFicha=PortletProps.get("simulador.vehicular.ficha.especial");
				}//Producto prestamo personal
				else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_EFECTIVO){
					urlFicha=PortletProps.get("simulador.personal.ficha.efectivo");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME){
					urlFicha=PortletProps.get("simulador.personal.ficha.parttime");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME){
					urlFicha=PortletProps.get("simulador.personal.ficha.fulltime");
				}//Producto hipotecario
				else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_REGULAR){
					urlFicha=PortletProps.get("simulador.hipotecario.ficha.regular");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_MI_VIVIENDA){
					urlFicha=PortletProps.get("simulador.hipotecario.ficha.mivivienda");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_TECHO_PROPIO){
					urlFicha=PortletProps.get("simulador.hipotecario.ficha.techopropio");
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA){
					urlFicha=PortletProps.get("simulador.hipotecario.ficha.garantiahipotecaria");
				}
				
			}catch(Exception e){
				_log.error("Ocurrió un error al obtener el la ur lde ficha del producto HPC "+codigoHPC+":"+e.toString());
			}
			return urlFicha;
		}
	  
	  /**
  	 * Obtener url solicitud.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param codigoHPC the codigo hpc
  	 * @return the string
  	 */
  	public static String obtenerURLSolicitud(int codigoHPC){
			StringBuilder urlSolicitud=new StringBuilder("");
			String prefijoSolicitud=PropsUtil.get("SOLICITUDES.ALL.PREFIX");
			try{
				//Producto Vehicular
				if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.CREDITO_VEHICULAR"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.COMPRA_INTELIGENTE"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.AUTO_CASI_NUEVO"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.CREDITO_VEHICULAR_ESPECIAL"));
				}//Producto prestamo personal
				else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_EFECTIVO){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.PRESTAMO_EFECTIVO"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.PRESTAMO_MAESTRIA_NACIONAL_PART_TIME"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.PRESTAMO_MAESTRIA_TIEMPO_COMPLETO"));
				}//Producto hipotecario
				else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_REGULAR){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.CREDITO_HIPOTECARIO"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_MI_VIVIENDA){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.CREDITO_NUEVO_MIVIVIENDA"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_TECHO_PROPIO){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.CREDITO_TECHO_PROPIO"));
					
				}else if(codigoHPC==SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA){
					urlSolicitud.append(prefijoSolicitud);
					urlSolicitud.append(PropsUtil.get("SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA"));
					urlSolicitud.append(LanguageUtil.get(locale,"SOLICITUDES.URL.SUFIX.PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA"));
				}
				
				urlSolicitud.append("-1");
			}catch(Exception e){
				_log.error("Ocurrió un error al obtener el la url de la solicitud del producto HPC "+codigoHPC+":"+e.toString());
			}
			return urlSolicitud.toString();
		}	  
	  
	  /**
  	 * Obtener url volver simular.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param request the request
  	 * @return the string
  	 */
  	public static String obtenerURLVolverSimular(HttpServletRequest request){
		  return StringUtils.substringBefore(request.getHeader("Referer"), "?") +"?vs=1";
	  }
	  
	  /**
  	 * Registrar gestion peticion.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param renderRequest the render request
  	 * @param ip the ip
  	 * @param codigoProducto the codigo producto
  	 * @param etiqueta the etiqueta
  	 * @return the boolean
  	 */
  	public static Boolean registrarGestionPeticion(RenderRequest renderRequest,
				String ip, String codigoProducto,String etiqueta) {
			Boolean pasoValidacionGestionPeticion=false;
			Object[] peticionValida=null;
			try {
				peticionValida = SeguridadLocalServiceUtil.validar(renderRequest, ip, codigoProducto,etiqueta);
				if(peticionValida!=null){
					pasoValidacionGestionPeticion = (Boolean) peticionValida[0];
					return pasoValidacionGestionPeticion;
				}
			} catch (BusinessException e) {
				String jsonError=String.format("{ip:%s,codigoProducto:%s,etiqueta:%s}", ip,codigoProducto,etiqueta);
				String asunto = Propiedades.getResourceBundle("resultado.simulacion.resultadosimulacionutil.registrargestionpeticion");
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
	  
	  /**
  	 * Nombre seguro.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param tipoSeguro the tipo seguro
  	 * @return the string
  	 */
  	public static String nombreSeguro(String tipoSeguro){
		  String nombre="";
		  
		  switch(Integer.parseInt(tipoSeguro)){
		  case SEGURO_INDIVIDUAL:
			  nombre   = "Individual";
				break;
				
			case SEGURO_MANCOMUNADO:
				nombre   = "Mancomunado";
				break;
				
		  }
		  
		  return nombre;
	  }
	  
	  
	  /**
  	 * Nombre cuota.
  	 * Fecha: 22/08/2013
  	 *
  	 * @param tipoSeguro the tipo seguro
  	 * @return the string
  	 */
  	public static String nombreCuota(String tipoSeguro){
		  String nombre="";
		  
		  switch(Integer.parseInt(tipoSeguro)){
		  case CUOTA_ORDINARIA:
			  nombre   = "Ordinaria";
				break;
				
			case CUOTA_EXTRAORDINARIA:
				nombre   = "Extraordinaria";
				break;
				
		  }
		  
		  return nombre;
	  }
	  
  	public static List<GraficoBean> getListGrafico(List<Object[]> porcentajeFondosMutuos,SimpleDateFormat dateFormat,CalculoBean calculoBean){
  		List<GraficoBean> lista = new ArrayList<GraficoBean>();
  		double mayor = 0;
  		double menor = 0;
  		try {
  			GraficoBean graficoBean;
  	  		for (Object[] valores_porcentaje : porcentajeFondosMutuos) {
  	  			graficoBean = new GraficoBean();
  	  			graficoBean.setTipoFondo1(Integer.parseInt(String.valueOf(valores_porcentaje[0])));
  	  			graficoBean.setValorCuota1(Double.parseDouble(String.valueOf(valores_porcentaje[1]))); 
  	  			graficoBean.setFecha1(dateFormat.parse(String.valueOf(valores_porcentaje[2])));
  	  			graficoBean.setRentabilidad1(Double.parseDouble(String.valueOf(valores_porcentaje[3])));
  	  			
  	  			graficoBean.setTipoFondo2(Integer.parseInt(String.valueOf(valores_porcentaje[4])));
  	  			graficoBean.setValorCuota2(Double.parseDouble(String.valueOf(valores_porcentaje[5]))); 
  	  			graficoBean.setRentabilidad2(Double.parseDouble(String.valueOf(valores_porcentaje[6])));
  	  			
  	  			if (valores_porcentaje[7] != null &&  valores_porcentaje[8] != null && valores_porcentaje[10] != null) {
  	  				graficoBean.setTipoFondo3(Integer.parseInt(String.valueOf(valores_porcentaje[7])));
  	  				graficoBean.setValorCuota3(Double.parseDouble(String.valueOf(valores_porcentaje[8]))); 
	  				graficoBean.setRentabilidad3(Double.parseDouble(String.valueOf(valores_porcentaje[10])));
				}
	  			lista.add(graficoBean);
	  			
	  			
	  			if (graficoBean.getRentabilidad1() > mayor) {
					mayor = graficoBean.getRentabilidad1();
				}
	  			if (graficoBean.getRentabilidad2() > mayor) {
					mayor = graficoBean.getRentabilidad2();
				}
	  			if (graficoBean.getRentabilidad3() > mayor) {
	  				mayor = graficoBean.getRentabilidad3();
				}
	  			if (graficoBean.getRentabilidad1() < menor) {
					menor = graficoBean.getRentabilidad1();
				}
	  			if (graficoBean.getRentabilidad2() < menor) {
	  				menor = graficoBean.getRentabilidad2();
				}
	  			if (graficoBean.getRentabilidad3() < menor) {
	  				menor = graficoBean.getRentabilidad3();
				}
	  			
  	  		}
//  	  	//	Collections.sort(lista, new Comparator<GraficoBean>() {
//				@Override
//				public int compare(GraficoBean o1, GraficoBean o2) {
//					return o1.getFecha1().compareTo(o2.getFecha1());
//				}
//			});
  	  		calculoBean.setMayor(mayor);
  	  		calculoBean.setMenor(menor);
		} catch (Exception e) {
			_log.error("Error al llenar la lista : "+e.toString());
		}
  		return lista;
  	}
	  
}
