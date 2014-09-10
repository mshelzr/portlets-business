package pe.com.ibk.halcon.solicitudes.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class Util.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
public class Util {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(Util.class);
	
	//Constantes para saber en que pagina se encuentra
	/** The Constant CREDITO_HIPOTECARIO. */
	public static final String CREDITO_HIPOTECARIO = "SOLICITUD_HIPOTECARIA";
	
	/** The Constant CREDITO_VEHICULAR. */
	public static final String CREDITO_VEHICULAR = "SOLICITUD_VEHICULAR";
	
	/** The Constant CUENTA_SUELDO. */
	public static final String CUENTA_SUELDO = "SOLICITUD_CUENTA_SUELDO";
	
	/** The Constant FONDO_MUTUO. */
	public static final String FONDO_MUTUO = "SOLICITUD_FONDOS_MUTUOS";
	
	/** The Constant PRESTAMO_PERSONAL. */
	public static final String PRESTAMO_PERSONAL = "SOLICITUD_PRESTAMO";
	
	/** The Constant PRODUCTO_PREAPROBADO. */
	public static final String PRODUCTO_PREAPROBADO = "SOLICITUD_PREAPROBADA";
	
	/** The Constant SEGURO_SOAT. */
	public static final String SEGURO_SOAT = "SOLICITUD_SOAT";
	
	/** The Constant TARJETA_CREDITO. */
	public static final String TARJETA_CREDITO = "SOLICITUD_TARJETA";
	
	/**
	 * Obtener temp tomcat.
	 * Fecha: 22/08/2013
	 *
	 * @param temp the temp
	 * @return the string
	 */
	public static String obtenerTempTomcat(String temp) {
		temp = temp.substring(0, temp.indexOf("temp") + "temp".length());
		return temp;
	}

	
	/**
	 * Return json.
	 * Fecha: 22/08/2013
	 *
	 * @param o the o
	 * @param resourceResponse the resource response
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public static void returnJson(Object o, ResourceResponse resourceResponse) throws IOException {
		Gson gson = new Gson();
		String gsonString = gson.toJson(o);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
		writer.write(gsonString);
		writer.flush();
		} catch (IOException e) {
			throw e;
		} finally{
			IOUtils.closeQuietly(writer);
		}
	}

	
	/**
	 * Obtener value producto.
	 * Fecha: 22/08/2013
	 *
	 * @param urlAmigableSolicitud the url amigable solicitud
	 * @return the int
	 */
	public static int obtenerValueProducto(String urlAmigableSolicitud){
		
		String nombreProducto=SolicitudProductoLocalServiceUtil.getEtiquetaSolicitudByFriendlyURL("/"+urlAmigableSolicitud);
				
		if (nombreProducto.equals(CREDITO_HIPOTECARIO)) {
			return 1;
		} else if(nombreProducto.equals(CREDITO_VEHICULAR)){
			return 2;
		}else if(nombreProducto.equals(CUENTA_SUELDO)){
			return 3;
		}else if(nombreProducto.equals(FONDO_MUTUO)){
			return 4;
		}else if(nombreProducto.equals(PRESTAMO_PERSONAL)){
			return 5;
		}else if(nombreProducto.equals(PRODUCTO_PREAPROBADO)){
			return 6;
		}else if(nombreProducto.equals(SEGURO_SOAT)){
			return 7;
		}else if(nombreProducto.equals(TARJETA_CREDITO)){
			return 8;
		}else{
			return 0;
		}
	}
	
	
	/**
	 * Obtener mensaje report producto.
	 * Fecha: 22/08/2013
	 *
	 * @param nombreProducto the nombre producto
	 * @return the string[]
	 */
	public static String[] obtenerMensajeReportProducto(String nombreProducto){
		String[] mensajes = new String[2];
		if (nombreProducto.equals(CREDITO_HIPOTECARIO)) {
			mensajes[0] = Constantes.MSJ_CREDITO_HIPOTECARIO;
			mensajes[1] = "Credito Hipotecario";
		} else if(nombreProducto.equals(CREDITO_VEHICULAR)){
			mensajes[0] = Constantes.MSJ_CREDITO_VEHICULAR;
			mensajes[1] = "Credito Vehicular";
		}else if(nombreProducto.equals(CUENTA_SUELDO)){
			mensajes[0] = Constantes.MSJ_CUENTA_SUELDO;
			mensajes[1] = "Cuenta Sueldo";
		}else if(nombreProducto.equals(FONDO_MUTUO)){
			mensajes[0] = Constantes.MSJ_FONDOS_MUTUOS;
			mensajes[1] = "Fondos Mutuos";
		}else if(nombreProducto.equals(PRESTAMO_PERSONAL)){
			mensajes[0] = Constantes.MSJ_PRESTAMO_PERSONAL;
			mensajes[1] = "Préstamo Personal";
		}else if(nombreProducto.equals(PRODUCTO_PREAPROBADO)){
			mensajes[0] = Constantes.MSJ_PRODUCTO_PRE_APROBADO;
			mensajes[1] = "Producto Pre Aprobado";
		}else if(nombreProducto.equals(SEGURO_SOAT)){
			mensajes[0] = Constantes.MSJ_SEGURO_SOAT;
			mensajes[1] = "Seguro SOAT";
		}else if(nombreProducto.equals(TARJETA_CREDITO)){
			mensajes[0] = Constantes.MSJ_TARJETA_CREDITO;
			mensajes[1] = "Tarjeta Crédito";
		}
		return mensajes;
	}
	
	
	/**
	 * Mensaje web service.
	 * Fecha: 22/08/2013
	 *
	 * @param codigo the codigo
	 * @param tipoServicioWeb the tipo servicio web
	 * @return the string
	 */
	public static String mensajeWebService (Integer codigo, Integer tipoServicioWeb){
		
		String mensaje=null;
		switch (tipoServicioWeb) {
		case 1://precalificacion
			switch (codigo) {
			case Constantes.ESTADO_ADQ_ERROR:// error
				mensaje= "ERROR " + codigo + " al precalificar en servicio web - error ";
				break;
			case Constantes.ESTADO_ADQ_PENDIENTE:// Servicio no Disponible
				mensaje= "ERROR " + codigo + " al precalificar en servicio web - Servicio no Disponible o cuota separada";
				break;
			default:
				mensaje = " ERROR " + codigo + " al precalificar en servicio web - error desconocido ";
				break;
			}
			break;
		case 2://registro lead
			switch (codigo) {
			case 99://
				mensaje= " NO HAY ERROR ";
				break;
	
			default:
				mensaje = " ERROR " + codigo + " al registro de lead servicio web - error desconocido ";
				break;
			}
			break;

		default:
			break;
		}
		return mensaje;
	}

	
	/** The Constant CARPETA_TEMPLATE. */
	public static final  String CARPETA_TEMPLATE = "/template";
	
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
		} finally{
			IOUtils.closeQuietly(bufferLectura);
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

		BufferedWriter bufferEscritura = null;
		try {
			
			Boolean CleanFileContent;

			/* Leemos el template */
			CleanFileContent = true;// Eliminar archivos SI
			bufferEscritura = new BufferedWriter(new FileWriter(filePath, !CleanFileContent));// Buffer
																								// de
																								// lectura
			bufferEscritura.write(htmlVideo);
		} catch (Exception e) {
			_log.error("Error al Escribir Video de HTML:" + e.toString());
		} finally{
			IOUtils.closeQuietly(bufferEscritura);
		}

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
		  pathEscritura = context.getRealPath(Util.CARPETA_TEMPLATE);	  
		  File folderTemplateLocal = new File(pathEscritura);
		  carpetaDiaria=getCarpetaDiaria();
		  
		  if(folderTemplateLocal.exists()&& folderTemplateLocal.isDirectory()){
      		File[] contenidoCarpeta = folderTemplateLocal.listFiles();
      		for (int i = 0; i < contenidoCarpeta.length; i++) {
				if (contenidoCarpeta[i].isDirectory()) {
					
					if(!carpetaDiaria.equalsIgnoreCase("/"+contenidoCarpeta[i].getName())){
						eliminarCarpeta(contenidoCarpeta[i]);
					}
				}
				
				
			}
      		
      		File folderCarpetaDiariaLocal = new File(pathEscritura+carpetaDiaria);
        	//verificamos que exista la ruta y es un directorio
        	if(folderCarpetaDiariaLocal.exists()&& folderCarpetaDiariaLocal.isDirectory()){
        		//_log.info("LA RUTA DIARIA EXISTE");
        	}else{
        		
        		folderCarpetaDiariaLocal.mkdirs();//Creamos toda la ruta
        	}
      		
      	}else{
      		_log.error("El directorio de archivos no encuentra la ruta:"+pathEscritura);
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

}
	
