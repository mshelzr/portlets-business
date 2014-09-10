package pe.com.ibk.halcon.replicadores.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ReplicadorPrestamosUtil.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  05/11/2013
 * @version Halcon 1.0
 */
public class ReplicadorPrestamosUtil {

	/** The Constant CARPETA_TEMPLATE. */
	public static final String CARPETA_TEMPLATE = "/template";
	
	/** The Constant TEMPLATE_REPLICADOR_HIPOTECARIO. */
	public static final String TEMPLATE_REPLICADOR_HIPOTECARIO = "/resultadoReplicadorHipotecario.html";
	
	/** The Constant TEMPLATE_REPLICADOR_PERSONAL. */
	public static final String TEMPLATE_REPLICADOR_PERSONAL = "/resultadoReplicadorPersonal.html";
	
	/** The Constant TEMPLATE_REPLICADOR_VEHICULAR. */
	public static final String TEMPLATE_REPLICADOR_VEHICULAR = "/resultadoReplicadorVehicular.html";
	
	/** The Constant ARCHIVO_REPLICADOR_PREFIX. */
	public static final String ARCHIVO_REPLICADOR_PREFIX = "/replicador";
	
	/** The Constant CARPETA_PORTLET. */
	public static final String CARPETA_PORTLET = "/ReplicadorPrestamo-portlet";
	
	/** The Constant CODIGO_APLICATIVO. */
	public static final String CODIGO_APLICATIVO = "4";

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ReplicadorPrestamosUtil.class);

	/**
	 * Obtiene template html.
	 * Fecha: 05/11/2013
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
	 * Obtiene carpeta diaria.
	 * Fecha: 05/11/2013
	 *
	 * @return carpeta diaria
	 */
	public static String getCarpetaDiaria() {
		/* Carpeta con el dia actual */
		Calendar fecha = Calendar.getInstance();
		String dia = StringUtils.leftPad(String.valueOf(fecha.get(Calendar.DATE)), 2, '0');
		String mes = StringUtils.leftPad(String.valueOf(fecha.get(Calendar.MONTH) + 1), 2, '0');
		String anio = StringUtils.leftPad(String.valueOf(fecha.get(Calendar.YEAR)), 2, '0');

		// Formato yyyyMMdd
		return "/" + anio + mes + dia;
	}

	/**
	 * Generate html.
	 * Fecha: 05/11/2013
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
	 * Verificar carpeta diaria.
	 * Fecha: 05/11/2013
	 *
	 * @param portletRequest the portlet request
	 */
	public static void verificarCarpetaDiaria(PortletRequest portletRequest) {
		// Creamos la carpeta del dia si no existiera y eliminamos las carpetas del dia anterior
		String pathEscritura, carpetaDiaria;
		PortletContext context;

		context = portletRequest.getPortletSession().getPortletContext();
		pathEscritura = context.getRealPath(ReplicadorPrestamosUtil.CARPETA_TEMPLATE);
		File folderTemplateLocal = new File(pathEscritura);
		carpetaDiaria = getCarpetaDiaria();

		// _log.info("Carpeta Diaria:"+carpetaDiaria);
		if (folderTemplateLocal.exists() && folderTemplateLocal.isDirectory()) {
			// _log.info("LA RUTA EXISTE ELIMINAMOS LAS CARPETAS ANTIGUAS");
			File[] contenidoCarpeta = folderTemplateLocal.listFiles();
			for (int i = 0; i < contenidoCarpeta.length; i++) {
				if (contenidoCarpeta[i].isDirectory()) {
					// _log.info("Carpeta en Template:"+contenidoCarpeta[i].getName());

					if (!carpetaDiaria.equalsIgnoreCase("/" + contenidoCarpeta[i].getName())) {
						eliminarCarpeta(contenidoCarpeta[i]);
					}
				} else {
					// _log.info("Archivo en Template:"+contenidoCarpeta[i].getName());
				}

			}
			// _log.info("Verificamos si existe la carpeta diaria y la creamos si fuera necesario");

			File folderCarpetaDiariaLocal = new File(pathEscritura + carpetaDiaria);
			// verificamos que exista la ruta y es un directorio
			if (folderCarpetaDiariaLocal.exists() && folderCarpetaDiariaLocal.isDirectory()) {
				// _log.info("LA RUTA DIARIA EXISTE");
			} else {
				// _log.info("LA RUTA DIARIA NO EXISTE LA CREAMOS");
				folderCarpetaDiariaLocal.mkdirs();// Creamos toda la ruta
			}

		} else {
			_log.error("El directorio de archivos no encuentra la ruta:" + pathEscritura);
		}
	}

	/**
	 * Eliminar carpeta.
	 * Fecha: 05/11/2013
	 *
	 * @param directory the directory
	 */
	private static void eliminarCarpeta(File directory) {
		if (directory.exists() && directory.isDirectory()) {
			File[] fileArray = directory.listFiles();

			for (int i = 0; i < fileArray.length; i++) {
				if (fileArray[i].isDirectory()) {
					eliminarCarpeta(fileArray[i]);
				} else {
					fileArray[i].delete();
				}
			}

			directory.delete();
		}
	}
}
