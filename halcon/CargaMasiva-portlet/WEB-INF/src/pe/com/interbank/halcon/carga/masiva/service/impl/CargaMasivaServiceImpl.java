package pe.com.interbank.halcon.carga.masiva.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import pe.com.interbank.halcon.carga.masiva.service.CargaMasivaService;
import pe.com.interbank.halcon.carga.masiva.util.Constantes;
import pe.com.interbank.halcon.carga.masiva.util.ExcelSheetReader;

import com.exp.portlet.halcon.utils.AsciiUtils;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.JsonServletUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaSocioRemesa;
import com.ext.portlet.halcon.model.Pais;
import com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil;
import com.ext.portlet.halcon.service.PaisLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CargaMasivaServiceImpl.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
@Service("CargaMasivaService")
public class CargaMasivaServiceImpl implements CargaMasivaService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CargaMasivaServiceImpl.class);
	private JsonServletUtil jsonServletUtil = new JsonServletUtil();
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.interbank.halcon.carga.masiva.service.CargaMasivaService#cargarArchivoSocios(javax
	 * .portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public Map<String, Object> cargarArchivoSocios(ActionRequest resourceRequest, ActionResponse resourceResponse) throws Exception {
		probar();
		_log.info("CargaMasivaServiceImpl cargarArchivoSocios ingreo los datos.");
		Map<String, Object> objRespuesta = new HashMap<String, Object>();
		objRespuesta.put("mensaje", "Registro exitoso.");
		boolean filt = false;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadRequest.getFile("archivo_masivo");
		if (file != null) {
			byte[] bytes = FileUtil.getBytes(file);
			if (bytes.length <= Constantes.LIMITE) {
				file = copiarCarpetaFile(resourceRequest, file);
				if (file != null) {
					List<CargaSocioRemesa> lst = null;
					String f = file.getName();
					String thisext = f.substring(f.lastIndexOf('.') + 1).toLowerCase();
					ExcelSheetReader reader = new ExcelSheetReader();
					if (thisext.equals(Constantes.EXT_XLSX)) {
						reader.readExcelFile2007(file.getAbsolutePath());
						lst = reader.getLst();
					} else if (thisext.equals(Constantes.EXT_XLS)) {
						reader.readExcelFile2003(file.getAbsolutePath());
						lst = reader.getLst();
					} else {
						objRespuesta.put("error", 1);
						objRespuesta.put("mensaje", "");
					}
					if (lst != null && lst.size() > 0) {
						guardarExcelSocioEmpresa(lst);
						// ***************Generar Json***********************
						generarPaises(lst);
						// **************************************
						String urlPreview = instanciarListaErrores(reader.getLstErrores(), resourceRequest, resourceResponse);
						if (!urlPreview.equals("")) {
							objRespuesta.put("error", 0);
						}
						objRespuesta.put("urlPreview", urlPreview);
						objRespuesta.put("lstErrores", reader.getLstErrores());
						filt = true;
					} else {
						String urlPreview = instanciarListaErrores(reader.getLstErrores(), resourceRequest, resourceResponse);
						objRespuesta.put("urlPreview", urlPreview);
						objRespuesta.put("lstErrores", reader.getLstErrores());
						objRespuesta.put("error", 0);
						objRespuesta.put("mensaje", "Ningun fila a sido registrada.");
					}
				} else {
					_log.info("archivo no a sido encontrado o no ubicado");
					objRespuesta.put("error", 0);
					objRespuesta.put("mensaje", "");
				}
			} else {
				_log.info("archivo excede el peso ");
				objRespuesta.put("error", 2);
				objRespuesta.put("mensaje", "");
			}
		} else {
			_log.info("archivo no a sido encontrado o no ubicado");
			objRespuesta.put("error", 0);
			objRespuesta.put("mensaje", "");
		}
		objRespuesta.put("rep", filt);
		return objRespuesta;
	}
	
//	@DenyAccess(accessView="prubea",errorView="prueba12")
	public void probar() {
		
	}
	
	public void generarPaises(List<CargaSocioRemesa> listaSocios)  {

		Boolean Result = true;
		List<Pais> lista = null;
		String codigos = "(";// = "('151012','151013','151014')";
		Integer tamanio1 = listaSocios.size();
		Integer contador = 0;
		Integer tamanio = 0;
		
		for (CargaSocioRemesa cargaSocioRemesa : listaSocios) {
			contador++;
			codigos = codigos + "'" + cargaSocioRemesa.getPaisCobertura() + "'";
			if (!tamanio1.equals(contador)) {
				codigos = codigos + ",";
			} else {
				codigos = codigos + ")";
			}
		}

//		_log.info("****************codigos************:" + codigos);
		
			try {
				lista = PaisLocalServiceUtil.obtenerPaises(codigos);
			} catch (BusinessException e) {
				String asunto = Propiedades.getResourceBundle("cargar.descuentos.cargar.descuentos.serviceimpl.generar.distritos.lima.obtenerDistritosLima");
				LogErrorUtil.registrarError(String.format("{codigos:%s}", codigos) , e.getTrazaMessage(), asunto);
				_log.error(Propiedades.getResourceBundle("cargar.descuentos.cargar.descuentos.serviceimpl.generar.distritos.lima.obtenerDistritosLima")+e.toString());
			}
			_log.info("Dato:" + lista.size());

			tamanio = lista.size();
			Integer acumula = 0;
			StringBuilder query = new StringBuilder();

			query.append(JSonUtil.INICIO_UNO);
			query.append(JSonUtil.CADENA_SELECCIONE);
			query.append("\n");

			for (Pais pais : lista) {

				acumula++;
				query.append(JSonUtil.CADENA_UNO);

				query.append(Integer.valueOf(pais.getCodigo()));

				query.append(JSonUtil.CADENA_DOS);
				query.append(AsciiUtils._convertNonAscii(pais.getNombre()));
				// query.append(JSonUtil.CADENA_TRES);
				// query.append(acumula);
				query.append(JSonUtil.CADENA_CUATRO);
				query.append(acumula);
				query.append(JSonUtil.CADENA_CINCO);
				// if(acumula.equals(1)){
				// query.append(1);
				// }else {
				query.append(0);
				// }
				if (!tamanio.equals(acumula)) {
					query.append(JSonUtil.CADENA_SEIS);
					query.append("\n");
				}
			}

			query.append(JSonUtil.CADENA_FIN);
			 _log.info("Dato:"+query.toString());
			 
			 //jsonServletUtil.updateFile(JSonUtil.PAIS, query);
			 
			//Actualizamos en gestion parametro
			 try {
				 File file = new File(JSonUtil.getPathJsonWasModificada()+ JSonUtil.PAIS);
				 FileUtil.write(file, query.toString());
			 } catch (Exception e) {
				 _log.error("No se puedo guardar archivo: " + e.toString());
			 }

	}

	private File copiarCarpetaFile(ActionRequest resourceRequest, File file) {
		String nuevaRuta = "";
		PortletContext context = resourceRequest.getPortletSession().getPortletContext();
		String pathFiles = context.getRealPath("/files");
		InputStream in = null;
		try {
			in = new FileInputStream(file);

			OutputStream out = null;
			nuevaRuta = pathFiles + "/" + file.getName();
			out = new FileOutputStream(nuevaRuta);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		file = new File(nuevaRuta);
		return file;
	}

	public String instanciarListaErrores(List<String> lst, ActionRequest resourceRequest, ActionResponse resourceResponse) {
		String urlPreview = "";
		if (lst != null && lst.size() > 0) {

			PortletContext context = resourceRequest.getPortletSession().getPortletContext();
			String pathLectura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + Constantes.CARPETA_PAGE_HTML;
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long c = Calendar.getInstance().getTime().getTime();

			try {
				String pathEscritura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + "/listaErrores" + c + ".txt";
				String template = getTemplateHTML(resourceRequest, pathLectura);
				String errores = "Errores presentados en el archivo: \r\n";
				for (int i = 0; i < lst.size(); i++) {
					errores += lst.get(i) + "\r\n";
				}
				template = template.replaceAll("%ERRORES%", errores);
				generateHTML(resourceRequest, template, pathEscritura);
				urlPreview = themeDisplay.getURLPortal() + "/cargaMasiva-portlet" + Constantes.CARPETA_TEMPLATE + "/listaErrores" + c + ".txt";
				urlPreview = URLEncoder.encode(urlPreview, "UTF-8");
			} catch (Exception e) {
				_log.error(" Error en el metodo instanciarListaErrores " + e.toString());
			}
		}
		return urlPreview;
	}

	private String getTemplateHTML(ActionRequest resourceRequest, String filePath) {
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

		}

		return templateHTML;
	}

	@SuppressWarnings("unused")
	private String getTemplateHTML(ResourceRequest resourceRequest, String filePath) {
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

		}

		return templateHTML;
	}

	private void generateHTML(ActionRequest request, String html, String filePath) {

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
			
		}

	}

	/**
	 * Guardar excel socio empresa. Fecha: 31-ene-2013
	 * 
	 * @param lst the lst
	 * @throws Exception the exception
	 */
	public void guardarExcelSocioEmpresa(List<CargaSocioRemesa> lst)  {
		if (lst != null && lst.size() > 0) {
			_log.info(" guardarExcelSocioEmpresa  se tiene la cantidad de registros : " + lst.size());
			
			try {
				CargaSocioRemesaLocalServiceUtil.truncateCargaSocioRemesa();
				CargaSocioRemesaLocalServiceUtil.insert(lst);
			} catch (BusinessException e) {
				String asunto = Propiedades.getResourceBundle("carga.masiva.carga.masiva.serviceimpl.guardar.excel.socio.empresa");
				LogErrorUtil.registrarError(JSonUtil.getStringJson(lst)+" && "+ JSonUtil.NO_EXISTE_PARAMETRO, e.getTrazaMessage(), asunto);
				_log.error(Propiedades.getResourceBundle("carga.masiva.carga.masiva.serviceimpl.guardar.excel.socio.empresa")+e.toString());
			}

		} else {
			_log.info(" guardarExcelSocioEmpresa  ningun registro para guardar ");
		}
	}

	public void obtenerListaErrores(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String url = ParamUtil.getString(resourceRequest, "urlPreview");
		try {
			url = URLDecoder.decode(url, "UTF-8");
			URL u = new URL(url);
			BufferedReader in = new BufferedReader(new InputStreamReader(u.openStream()));
			String inputLine, inputText = "";
			while ((inputLine = in.readLine()) != null) {
				inputText = inputText + inputLine + "\r\n";
			}
			url = url.substring(url.lastIndexOf("/"));
			String contentType = ContentTypes.APPLICATION_TEXT;
			resourceResponse.setContentType(contentType);
			resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + url);
			HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
			PrintWriter writer;
			writer = response.getWriter();
			writer.write(inputText);
			writer.flush();
			writer.close();
		} catch (Exception e) {

		}

	}

	public static int CharToASCII(final char character) {
		return (int) character;
	}

//	public void auditoriaPrueba(HttpServletRequest request) {
//
//		try {
//
//			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
//			User user = themeDisplay.getUser();
//			PortletDisplay porlet = themeDisplay.getPortletDisplay();
//						
//			AuditMessage auditMessage = new AuditMessage(
//					//ActionKeys.ACCESS_IN_CONTROL_PANEL,
//					"Saludo XD",
//					user.getCompanyId(), 
//					user.getUserId(), 
//					user.getFullName(),
//					porlet.getTitle(),
//					porlet.getId()
//					);
//			
//			// cuando se le pone algo que no es propio de la misma auditoria dentro de sus palabras claves 
//			// pone otras palabras.
//			
//			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
//			jsonObject.put("ingresando", "datos");
//			jsonObject.put("de", "prueba");
//			jsonObject.put("json", "prueba");
//			jsonObject.put("add", "info");
//			
//			auditMessage.setAdditionalInfo(jsonObject);
//			
//			AuditRouterUtil.route(auditMessage);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}
