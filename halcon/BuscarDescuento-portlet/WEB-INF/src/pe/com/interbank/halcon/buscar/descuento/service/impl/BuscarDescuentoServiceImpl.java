package pe.com.interbank.halcon.buscar.descuento.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Service;

import pe.com.interbank.halcon.buscar.descuento.service.BuscarDescuentoService;
import pe.com.interbank.halcon.buscar.descuento.util.Constantes;
import pe.com.interbank.halcon.buscar.descuento.util.Util;

import com.ext.portlet.halcon.model.CargaDescuento;
import com.ext.portlet.halcon.service.CargaDescuentoLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BuscarDescuentoServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  21/08/2013
 * @version Halcon 1.0
 */
@Service("BuscarDescuentoService")
public class BuscarDescuentoServiceImpl implements BuscarDescuentoService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscarDescuentoServiceImpl.class);
	
	/** The carpeta descuentos central. */
	private static String CARPETA_DESCUENTOS_CENTRAL = "Imagenes";
	
	/** The carpeta descuentos local. */
	private static String CARPETA_DESCUENTOS_LOCAL = "Visualizar Descuentos";

	/**
	 * Lista Sucursales Descuentos<br>
	 * Retorna una objeto List<Map<String, Object>> de descuentos en formato json y paginado.<br>
	 * Fecha:  21/08/2013
	 *
	 * @param buscar the buscar
	 * @param distrito the distrito
	 * @param categoria the categoria
	 * @param pagina the pagina
	 * @param filas the filas
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public void obtListaSucursalesDescuentos(String buscar, String distrito, Integer categoria, int pagina, int filas, ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException {

		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> lstDescuentosMap = new ArrayList<Map<String, Object>>();
		try {
			String url ="";
			String globo_url ="";
			Integer count = CargaDescuentoLocalServiceUtil.obtenerUbicacionMapaCargaDescuentosCount(buscar, distrito, categoria, pagina, filas).intValue();

			if (count != null && count > 0) {
				int total = 0;
				int records = 0;
				if (count > 0) {
					total = count / filas + 1;
				}
				// Se descompone cada registro en un Map y se agrega a un lista
				// Para validar cada campo si a sido hardcodeado el excel ingresado
				List<CargaDescuento> lstDescuentos = CargaDescuentoLocalServiceUtil.obtenerUbicacionMapaDescuentos(buscar, distrito, categoria, pagina, filas);
				Map<String, String> listaImagenesCMS = instanciarlistaImagenesCMS(resourceRequest);

				if (listaImagenesCMS != null && listaImagenesCMS.size() > 0) {
					CargaDescuento cd = null;
					Map<String, Object> o = null;
					for (int i = 0; i < lstDescuentos.size(); i++) {
						cd = lstDescuentos.get(i);
						//Nuevo Metodo para transformar todas las extensiones a minusculas
						String adicional = cd.getURLImagen();
						adicional = adicional.replace("JPG", "jpg");
						cd.setURLImagen(adicional);					
						o = new HashMap<String, Object>();
						o.put("id", cd.getIdCargaDesc());
						o.put("titulo", cd.getLocal());
						o.put("descripcion", cd.getDescuentoGeneral());
						o.put("longitud", cd.getLongitud());
						o.put("latitud", cd.getLatitud());
						url = existeImagenCMS(listaImagenesCMS, cd.getURLImagen());	
						globo_url = existeImagenCMS(listaImagenesCMS, Constantes.TOKEN+cd.getURLImagen());	
						o.put("etiquetaImg", url);
						o.put("globo_etiquetaImg", globo_url);
						o.put("direccion", cd.getDireccion());
						if (cd.getTelefono() == null || cd.getTelefono().equals("")) {
							o.put("telefono", "No disponible");
						} else
							o.put("telefono", cd.getTelefono());
						o.put("ico", url);
						PortletContext context;
						ThemeDisplay themeDisplay;
						String template;

						String pathLectura, pathEscritura;
						context = resourceRequest.getPortletSession().getPortletContext();
						pathLectura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + Constantes.CARPETA_PAGE_HTML;
						themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

						try {
							pathEscritura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + "/descuento" + cd.getIdCargaDesc() + ".html";
							template = getTemplateHTML(resourceRequest, pathLectura);
							template = template.replaceAll("%LOGO%",globo_url);
							template = template.replaceAll("%TITULO%", cd.getLocal());
							template = template.replaceAll("%DIRECCION%", cd.getDireccion());
							if (cd.getTelefono() == null || cd.getTelefono().equals("")) {
								template = template.replaceAll("%TELEFONO%", "No disponible.");
							} else
								template = template.replaceAll("%TELEFONO%", cd.getTelefono());
							template = template.replaceAll("%WEB%", cd.getWeb());
							template = template.replaceAll("%DESCUENTO%", cd.getDescuentoGeneral());

							if (cd.getCondicionesRestricciones() == null || cd.getCondicionesRestricciones().equals("")) {
								template = template.replace("%RESTRICCIONESCONDICIONES%", "No disponible.");
							} else {
								template = template.replace("%RESTRICCIONESCONDICIONES%", cd.getCondicionesRestricciones());
							}
							template = template.replaceAll("%RUTA_CSS%", themeDisplay.getPathThemeCss());
							generateHTML(resourceRequest, template, pathEscritura);

							o.put("urlPreview", themeDisplay.getURLPortal() + "/BuscarDescuento-portlet" + Constantes.CARPETA_TEMPLATE + "/descuento" + cd.getIdCargaDesc() + ".html");

						} catch (Exception e) {
							_log.error(" Error al obtListaSucursalesDescuentos " + e.toString());
						}
						
						if(url!=null){
							lstDescuentosMap.add(o);
						}
						
					}

				}

				result.put("pagina", pagina);
				result.put("total", total);
				if (lstDescuentos != null) {
					records = lstDescuentos.size();
				}
				result.put("records", records);
				result.put("lstDescuentos", lstDescuentosMap);

			}

		} catch (Exception e) {
			_log.error("Error al instanciarlistaImagenesCMS " + e.toString());
		}

		Util.returnJson(result, resourceResponse);
	}

	/**
	 * Instanciarlista imagenes cms.<br>
	 * Obtiene un mapa de todas las imagenes CMS <br>
	 * Fecha: 21/08/2013
	 *
	 * @param resourceRequest the resource request
	 * @return the map
	 */
	private Map<String, String> instanciarlistaImagenesCMS(ResourceRequest resourceRequest) {
		long groupId;
		Folder folder;
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		groupId = themeDisplay.getScopeGroupId();
		int numArchivos = 0;
		List<FileEntry> archivos = null;
		FileEntry fileEntry = null;
		FileVersion latestFileVersion = null;
		String url;
		String titulo;
		try {
			folder = DLAppLocalServiceUtil.getFolder(groupId, 0, CARPETA_DESCUENTOS_CENTRAL);
			folder = DLAppLocalServiceUtil.getFolder(groupId, folder.getFolderId(), CARPETA_DESCUENTOS_LOCAL);
			numArchivos = DLAppLocalServiceUtil.getFileEntriesCount(groupId, folder.getFolderId());
			archivos = DLAppLocalServiceUtil.getFileEntries(groupId, folder.getFolderId(), 0, numArchivos, null);
			Map<String, String> listaImagenesCMS = new HashMap<String, String>();
			for (int i = 0; i < archivos.size(); i++) {
				fileEntry = archivos.get(i);
				latestFileVersion = fileEntry.getFileVersion();
				if (latestFileVersion.getStatus() != WorkflowConstants.STATUS_APPROVED) {
					continue;
				}
				url = DLUtil.getPreviewURL(fileEntry, latestFileVersion, themeDisplay, StringPool.BLANK);
				titulo = fileEntry.getTitle();
				listaImagenesCMS.put(titulo, url);
			}
			return listaImagenesCMS;
		} catch (Exception e) {
			_log.error("Error al instanciarlistaImagenesCMS " + e.toString());
		}
		return null;
	}

	/**
	 * Existe imagen cms.<br>
	 * Verifica si existe imagen en CMS.<br>
	 * Fecha: 21/08/2013
	 *
	 * @param listaImagenesCMS the lista imagenes cms
	 * @param img the img
	 * @return the string
	 */
	private String existeImagenCMS(Map<String, String> listaImagenesCMS,String img) {
		String i = null;
		if(listaImagenesCMS!=null && listaImagenesCMS.size()>0){
			i = listaImagenesCMS.get(img);
			if(i!=null && !i.equals("")){
				return i;
			}			
		}		
		return null;
	}

	/**
	 * Obtiene template html.<br>
	 * Obtiene el contenido de un html que se encuentra fisicamente en el portlet.<br>
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param filePath the file path
	 * @return template html
	 */
	private String getTemplateHTML(ResourceRequest request, String filePath) {
		String templateHTML;

		templateHTML = "";
		try {
			BufferedReader bufferLectura;
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
			bufferLectura.close();

			templateHTML = fileData.toString();

		} catch (Exception e) {
			_log.error("Error al generar el template HTML " + e.toString());
		}

		return templateHTML;
	}

	/**
	 * Generate html.<br>
	 * Generate de un contenido un arhivo html físicamente.<br>
	 * Fecha: 21/08/2013
	 *
	 * @param request the request
	 * @param html the html
	 * @param filePath the file path
	 */
	private void generateHTML(ResourceRequest request, String html, String filePath) {
	
		try {
			BufferedWriter bufferEscritura;
			Boolean CleanFileContent;
	
			/* Leemos el template */
			CleanFileContent = true;// Eliminar archivos SI
			bufferEscritura = new BufferedWriter(new FileWriter(filePath, !CleanFileContent));// Buffer
																								// de
																								// lectura
			bufferEscritura.write(html);
			bufferEscritura.close();
	
		} catch (Exception e) {
			_log.error("Error al generar el HTML " + e.toString());
		}
	
	}

}
