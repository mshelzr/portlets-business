package pe.com.ibk.halcon.videos.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class VisualizarVideosController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  18/02/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class VisualizarVideosController {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(VisualizarVideosController.class);
	
	//private static Integer indicadorPortlet=50;
	//private static Integer indicadorController=1;
	
	/** The carpeta video central. */
	private static String CARPETA_VIDEO_CENTRAL = "Videos";
	
	/** The carpeta video local. */
	private static String CARPETA_VIDEO_LOCAL = "";
	
	/** The carpeta template. */
	private static String CARPETA_TEMPLATE = "/template";

	/**
	 * Default view.
	 * Fecha: 18/02/2013
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest, RenderResponse renderResponse) {

		ThemeDisplay themeDisplay;
		long groupId;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		groupId = themeDisplay.getScopeGroupId();

		//Leemos el properties
		String nombreCarpeta;
		nombreCarpeta = renderRequest.getPreferences().getValue("nombreCarpeta", "");
		CARPETA_VIDEO_LOCAL=nombreCarpeta;
		
		if(Validator.isNotNull(CARPETA_VIDEO_LOCAL)){
			List<Folder> folderCategorias = getCategorias(groupId);
			_log.info("Categorias:" + folderCategorias.size());
			//Ordenar los folders
			if(folderCategorias!=null){
				//Ordenar las carpetas
				Comparator<Folder> c = 
					    new Comparator<Folder>()
					    {
					        @Override
					        public int compare( Folder o1, Folder o2 )
					        {
					        	Integer ordeno1=(Integer)o1.getExpandoBridge().getAttribute("orden");
					        	Integer ordeno2=(Integer)o2.getExpandoBridge().getAttribute("orden");
					        	//0= Son iguales     -1: o1 <o2     1: o1>o2
					        	//Para hacer que si no tiene orden vaya al ultimo
					            if(ordeno1==0)ordeno1=9999;
					            if(ordeno2==0)ordeno2=9999;
					            
					            if(ordeno1<ordeno2) return -1;
					            else if (ordeno1>ordeno2) return 1;
					            else return 0;
					        }
					    };

				ListUtil.sort(folderCategorias, c);
			}
			
			if (folderCategorias != null)
				for (int i = 0; i < folderCategorias.size(); i++) {
					Folder ct = folderCategorias.get(i);
					if (i == 0) {
						renderRequest.setAttribute("idCabeceraActiva", ct.getFolderId());
						break;
					}
				}
			
			//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
			
			renderRequest.setAttribute("snipetVideo", themeDisplay.getLayout().getName(themeDisplay.getLocale()));
			return "view";
		}else{
			//JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
			return "error";
			
		}
	}

	/**
	 * Traer cabeceras.
	 * Fecha: 18/02/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("traerCabeceras")
	protected void traerCabeceras(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		ThemeDisplay themeDisplay;
		long groupId;
		JSONArray jsonArr;
		PrintWriter writer = null;

		themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		groupId = themeDisplay.getScopeGroupId();
		jsonArr = JSONFactoryUtil.createJSONArray();
		
		try {
			List<Folder> folderCategorias = getCategorias(groupId);
			_log.info("Categorias:" + folderCategorias.size());
			
			if(folderCategorias!=null){
				//Ordenar las carpetas
				Comparator<Folder> c = 
					    new Comparator<Folder>()
					    {
					        @Override
					        public int compare( Folder o1, Folder o2 )
					        {
					        	Integer ordeno1=(Integer)o1.getExpandoBridge().getAttribute("orden");
					        	Integer ordeno2=(Integer)o2.getExpandoBridge().getAttribute("orden");
					        	//0= Son iguales     -1: o1 <o2     1: o1>o2
					        	//Para hacer que si no tiene orden vaya al ultimo
					            if(ordeno1==0)ordeno1=9999;
					            if(ordeno2==0)ordeno2=9999;
					            
					            if(ordeno1<ordeno2) return -1;
					            else if (ordeno1>ordeno2) return 1;
					            else return 0;
					        }
					    };

				ListUtil.sort(folderCategorias, c);
			}
			
			for (int i = 0; i < folderCategorias.size(); i++) {
							
				Folder ct = folderCategorias.get(i);
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put("id", ct.getFolderId());
				jsonObj.put("titulo", ct.getName());
				jsonObj.put("isDL", StringUtil.count(ct.getName(),"-"));
				jsonArr.put(jsonObj);
			}

			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(jsonArr.toString());
			writer.flush();

			
		} catch (Exception e) {
			_log.error("Error al generar las cabeceras:" + e.toString());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

	/**
	 * Traer detalle.
	 * Fecha: 18/02/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("traerDetalle")
	protected void traerDetalle(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		ThemeDisplay themeDisplay;
		long groupId, folderId, idArchivo;
		JSONArray jsonArr;
		JSONObject jsonObjeto;
		String url, titulo, template;

		PortletContext context;
		String pathLectura, pathEscritura;
		String videoHTMLHeader,videoHTMLFooter;

		/* Leemos el template */
		context = resourceRequest.getPortletSession().getPortletContext();
		pathLectura = context.getRealPath(CARPETA_TEMPLATE) + "/template.html";

		themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		groupId = themeDisplay.getScopeGroupId();
		jsonArr = JSONFactoryUtil.createJSONArray();
		folderId = ParamUtil.getLong(resourceRequest, "folderId");
		videoHTMLHeader="";
		videoHTMLFooter="";
		PrintWriter writer = null;
		
		try {
			int numArchivos = DLAppLocalServiceUtil.getFileEntriesCount(groupId, folderId);
			List<FileEntry> archivos = DLAppLocalServiceUtil.getFileEntries(groupId, folderId, 0,
					numArchivos, null);

			List<FileEntry> archivosOrdenados;
			/* Datos adicionales del Folder */
			Folder folderVideo = DLAppLocalServiceUtil.getFolder(folderId);
			
			/*Extraemos el Journal Article necesario*/
			
			try{
				String idHeader = folderVideo.getExpandoBridge().getAttribute(
						"idHeader").toString();
				String idFooter = folderVideo.getExpandoBridge().getAttribute(
						"idFooter").toString();
				
				
				if(Validator.isNotNull(idHeader)){
					JournalArticle articuloHeader = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(),
							idHeader, WorkflowConstants.STATUS_APPROVED);
					
					videoHTMLHeader = getParseContentValue(articuloHeader.getContentByLocale(themeDisplay.getLanguageId()));
				}
				
				if(Validator.isNotNull(idFooter)){
					JournalArticle articuloFooter = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(),
							idFooter, WorkflowConstants.STATUS_APPROVED);
					videoHTMLFooter = getParseContentValue(articuloFooter.getContentByLocale(themeDisplay.getLanguageId()));
				}

			}catch(Exception e){
				_log.warn("No se tienen Header ni footer:" + e.toString());
				e.printStackTrace();
			}
			_log.info("archivos" + archivos.size());
			
				//Ordenar el archivo 
				Comparator<FileEntry> c = 
					    new Comparator<FileEntry>()
					    {
					        @Override
					        public int compare( FileEntry o1, FileEntry o2 )
					        {
					        	Integer ordeno1=(Integer)o1.getExpandoBridge().getAttribute("orden");
					        	Integer ordeno2=(Integer)o2.getExpandoBridge().getAttribute("orden");
					        	//0= Son iguales     -1: o1 <o2     1: o1>o2
					        	//Para hacer que si no tiene orden vaya al ultimo
					            if(ordeno1==0)ordeno1=9999;
					            if(ordeno2==0)ordeno2=9999;
					            
					            if(ordeno1<ordeno2) return -1;
					            else if (ordeno1>ordeno2) return 1;
					            else return 0;
					        }
					    };

			archivosOrdenados=ListUtil.sort(archivos, c);
			
			for (int i = 0; i < archivosOrdenados.size(); i++) {
				FileEntry fileEntry = archivosOrdenados.get(i);
				FileVersion latestFileVersion = fileEntry.getFileVersion();
				if (latestFileVersion.getStatus() != WorkflowConstants.STATUS_APPROVED) {
					/* Si no esta aprobado continua */
					continue;
				}
				url = DLUtil.getPreviewURL(fileEntry, latestFileVersion, themeDisplay,
						StringPool.BLANK);
				titulo = fileEntry.getTitle();
				idArchivo = fileEntry.getFileEntryId();
				pathEscritura = context.getRealPath(CARPETA_TEMPLATE) + "/video" + idArchivo
						+ ".html";

				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put("id", idArchivo);
				jsonObj.put("url", url);
				jsonObj.put("titulo", titulo);
				
				template = getTemplateHTML(resourceRequest, pathLectura);
				template = template.replaceAll("%TITULO%", titulo);
				template = template.replaceAll("%URL%", url);
				template = template.replaceAll("%RUTA_CSS%", themeDisplay.getPathThemeCss());

				generateVideoHTML(resourceRequest, template, pathEscritura);

				jsonObj.put("urlPreview", themeDisplay.getURLPortal()
						+ "/VisualizarVideos-portlet/template/video" + idArchivo + ".html");
				jsonArr.put(jsonObj);
			}
			
			jsonObjeto=JSONFactoryUtil.createJSONObject();
			jsonObjeto.put("videos", jsonArr);
			jsonObjeto.put("videoHTMLHeader", videoHTMLHeader);
			jsonObjeto.put("videoHTMLFooter", videoHTMLFooter);
			
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(jsonObjeto.toString());
			writer.flush();

		} catch (Exception e) {
			_log.error("Error al traer videos:" + e.toString());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}

	/**
	 * Obtiene template html.
	 * Fecha: 18/02/2013
	 *
	 * @param request the request
	 * @param filePath the file path
	 * @return template html
	 */
	private String getTemplateHTML(ResourceRequest request, String filePath) throws IOException {
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
			if(bufferLectura!=null){
				bufferLectura.close();
			}
		}

		return templateHTML;
	}

	/**
	 * Generate video html.
	 * Fecha: 18/02/2013
	 *
	 * @param request the request
	 * @param htmlVideo the html video
	 * @param filePath the file path
	 */
	private void generateVideoHTML(ResourceRequest request, String htmlVideo, String filePath) {

		try {
			BufferedWriter bufferEscritura;
			Boolean CleanFileContent;

			/* Leemos el template */
			CleanFileContent = true;// Eliminar archivos SI
			bufferEscritura = new BufferedWriter(new FileWriter(filePath, !CleanFileContent));// Buffer
																								// de
																								// lectura
			bufferEscritura.write(htmlVideo);
			bufferEscritura.close();

		} catch (Exception e) {
			_log.error("Error al Escribir Video de HTML:" + e.toString());
		}

	}

	/**
	 * Obtiene categorias.
	 * Fecha: 18/02/2013
	 *
	 * @param groupId the group id
	 * @return categorias
	 */
	private List<Folder> getCategorias(long groupId) {
		List<Folder> folderCategorias = null;
		try {
			Folder folderVideo = DLAppLocalServiceUtil.getFolder(groupId, 0, CARPETA_VIDEO_CENTRAL);
			Folder folderBeneficio = DLAppLocalServiceUtil.getFolder(groupId,
					folderVideo.getFolderId(), CARPETA_VIDEO_LOCAL);
			folderCategorias = DLAppLocalServiceUtil.getFolders(groupId,
					folderBeneficio.getFolderId());
		} catch (Exception e) {
			_log.error("No se pudo obtener las categorias de carpetas de video:" + e.toString());
		}
		return folderCategorias;
	}
	
	public String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(article
					.getContentByLocale(languageID));
			Node node = document.selectSingleNode("/root/dynamic-element[@name='" + fieldname
					+ "']/dynamic-content");
			value = node.getText();
		} catch (Exception e) {

			_log.error(e.getMessage());
		}

		return value;
	}
	
	public static String getParseContentValue(String localeContent) {
		String value = "";
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil.read(localeContent);
			Node node = document.selectSingleNode("/root/static-content");
			if (node != null) {
				value = node.getText();
			}
		} catch (Exception e) {

			_log.error("Error en getParseValue:" + e.toString());
		}

		return value;
	}
}
