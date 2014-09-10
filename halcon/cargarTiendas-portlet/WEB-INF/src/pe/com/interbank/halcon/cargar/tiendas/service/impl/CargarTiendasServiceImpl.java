package pe.com.interbank.halcon.cargar.tiendas.service.impl;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import pe.com.interbank.halcon.cargar.tiendas.service.CargarTiendasService;
import pe.com.interbank.halcon.cargar.tiendas.util.Constantes;
import pe.com.interbank.halcon.cargar.tiendas.util.ExcelSheetReader;

import com.exp.portlet.halcon.utils.AsciiUtils;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaTienda;
import com.ext.portlet.halcon.model.Ubigeo;
import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;
import com.ext.portlet.halcon.service.UbigeoLocalServiceUtil;
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

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class CargarTiendasServiceImpl.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
@Service("CargarTiendasService")
public class CargarTiendasServiceImpl implements CargarTiendasService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(CargarTiendasServiceImpl.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pe.com.interbank.halcon.cargar.descuentos.service.CargarDescuentosService#cargarDescuentos
	 * (javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	public Map<String, Object> cargarTiendas(ActionRequest resourceRequest, ActionResponse resourceResponse) {
		_log.info("CargaMasivaServiceImpl cargarArchivoSocios ingreo los datos.");
		Map<String, Object> objRespuesta = new HashMap<String, Object>();
		objRespuesta.put("mensaje", "Registro exitoso.");
		boolean filt = false;
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadRequest.getFile("archivo_masivo");
		try {
			if (file != null) {
				byte[] bytes = null;

				bytes = FileUtil.getBytes(file);

				if (bytes.length <= Constantes.LIMITE) {

					file = copiarCarpetaFile(resourceRequest, file);
					if (file != null) {
						List<CargaTienda> lst = null;
						String f = file.getName();
						String thisext = f.substring(f.lastIndexOf('.') + 1).toLowerCase();
						ExcelSheetReader reader = new ExcelSheetReader();

						if (thisext.equals(Constantes.EXT_XLSX)) {
							try {
								reader.readExcelFile2007(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
							lst = reader.getLst();
						} else if (thisext.equals(Constantes.EXT_XLS)) {
							try {
								reader.readExcelFile2003(file);
							} catch (Exception e) {
								e.printStackTrace();
							}
							lst = reader.getLst();
						} else {
							objRespuesta.put("error", 1);
							objRespuesta.put("mensaje", "");
						}
						file = null;

						if (lst != null && lst.size() > 0) {
							guardarExcelCargarTienda(lst);
							generarUbigeoPOrExcelTiendas(lst);
							String urlPreview = instanciarListaErrores(reader.getLstErrores(), resourceRequest, resourceResponse);
							if(!urlPreview.equals("")){
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
							objRespuesta.put("mensaje", "Ningun fila ha sido registrada.");
						}
					} else {
						objRespuesta.put("error", 0);
						objRespuesta.put("mensaje", "");
					}

				} else {
					objRespuesta.put("error", 2);
					objRespuesta.put("mensaje", "");
				}

			} else {
				objRespuesta.put("error", 0);
				objRespuesta.put("mensaje", "");
			}
			objRespuesta.put("rep", filt);

		} catch (IOException e) {
			objRespuesta.put("rep", false);
			objRespuesta.put("error", 0);
			objRespuesta.put("mensaje", e.getLocalizedMessage());
			e.printStackTrace();
		}
		return objRespuesta;
	}

	private File copiarCarpetaFile(ActionRequest resourceRequest, File file) {
		String nuevaRuta = "";
		PortletContext context = resourceRequest.getPortletSession().getPortletContext();
		String pathFiles = context.getRealPath("/files");
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(file);

			nuevaRuta = pathFiles + "/" + file.getName();
			out = new FileOutputStream(nuevaRuta);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally{
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
		file = null;
		System.gc();
		file = new File(nuevaRuta);
		return file;
	}

	private void generarUbigeoPOrExcelTiendas(List<CargaTienda> lst) {

		if (lst != null) {
			if (lst.size() > 0) {
				List<String> lstCodigoUbigeo = new ArrayList<String>();
				for (int i = 0; i < lst.size(); i++) {
					CargaTienda ct = lst.get(i);
					lstCodigoUbigeo.add(ct.getCodDistrito());
				}
				// con todos los codigos obtenidos se filtran los duplcados.
				lstCodigoUbigeo = uniqueSinOrdenar(lstCodigoUbigeo);

				// obtener codigos de departamentos
				List<String> lstCodigosDepartamentos = new ArrayList<String>();
				for (int i = 0; i < lstCodigoUbigeo.size(); i++) {
					String tsr = lstCodigoUbigeo.get(i);
					// if(tsr.substring(2,6).equals("0000")){
					tsr = tsr.substring(0, 2) + "0000";
					lstCodigosDepartamentos.add(tsr);
					// }
				}
				lstCodigosDepartamentos = uniqueSinOrdenar(lstCodigosDepartamentos);

				List<String> lstCodigosProvincias = new ArrayList<String>();
				for (int i = 0; i < lstCodigoUbigeo.size(); i++) {
					String tsr = lstCodigoUbigeo.get(i);
					tsr = tsr.substring(0, 4) + "00";
					lstCodigosProvincias.add(tsr);
				}
				lstCodigosProvincias = uniqueSinOrdenar(lstCodigosProvincias);

				List<String> lstCodigosDistritos = new ArrayList<String>();
				for (int i = 0; i < lstCodigoUbigeo.size(); i++) {
					String tsr = lstCodigoUbigeo.get(i);
					lstCodigosDistritos.add(tsr);
				}
				lstCodigosDistritos = uniqueSinOrdenar(lstCodigosDistritos);

				String[] codigosDepartamentos = lstCodigosDepartamentos.toArray(new String[lstCodigosDepartamentos.size()]);
				generarJSON(false, null, codigosDepartamentos, JSonUtil.DEPARTAMENTO_TIENDAS);
				String[] codigosProvincias = lstCodigosProvincias.toArray(new String[lstCodigosProvincias.size()]);
				generarJSON(true, "id_departamento", codigosProvincias, JSonUtil.PROVINCIA_TIENDAS);
				String[] codigosDistritos = lstCodigosDistritos.toArray(new String[lstCodigosDistritos.size()]);
				generarJSON(true, "id_provincia", codigosDistritos, JSonUtil.DISTRITO_TIENDAS);

			}
		}

	}

	public void generarJSON(boolean isHijo, String padre, String[] codigos, String nombreFile) {
		
			List<Ubigeo> lista = null;
		try {
			lista = UbigeoLocalServiceUtil.obtenerUbigeoPorCodigos(codigos);
			
			_log.info("Dato:" + lista.size());

			
			 StringBuilder query = new StringBuilder();

			 query.append(JSonUtil.INICIO_UNO);
			 query.append(JSonUtil.CADENA_SELECCIONE);
			 query.append("\n");

			for (int i = 0; i < lista.size(); i++) {
				Ubigeo ubi = lista.get(i);
				
				if (nombreFile.equals(JSonUtil.DEPARTAMENTO_TIENDAS)) {
					query.append(JSonUtil.CADENA_UNO);
					query.append(Integer.parseInt(ubi.getCodigo().substring(0, 2)));
				} else if (nombreFile.equals(JSonUtil.PROVINCIA_TIENDAS)) {				
					query.append(JSonUtil.CADENA_UNO);
					query.append(Integer.parseInt(String.valueOf(Integer.parseInt(ubi.getCodigo().substring(0, 2))).concat(ubi.getCodigo().substring(2, 4))));			
				} else if (nombreFile.equals(JSonUtil.DISTRITO_TIENDAS)) {
					query.append(JSonUtil.CADENA_UNO);
					query.append(Integer.parseInt(ubi.getCodigo().substring(4, 6)));
				}
				if (isHijo) {
					if (padre.equals("id_departamento")) {
						query.append(JSonUtil.CADENA_DEPARTAMENTO);
						query.append(Integer.parseInt(ubi.getCodigo().substring(0, 2)));
					} else if (padre.equals("id_provincia")) {
						query.append(JSonUtil.CADENA_PROVINCIA);
						query.append(Integer.parseInt(ubi.getCodigo().substring(0, 4)));
					}
				}				

				query.append(JSonUtil.CADENA_DOS);
				query.append( AsciiUtils._convertNonAscii(ubi.getNombre()) );
				query.append(JSonUtil.CADENA_CUATRO);
				query.append( i + 1 );
				query.append(JSonUtil.CADENA_CINCO);
				query.append( 0 );
				
				if ( i < lista.size()-1 ) {
					query.append(JSonUtil.CADENA_SEIS);
					query.append("\n");				
				}			
			}
			query.append(JSonUtil.CADENA_FIN);
			_log.info(nombreFile  + query.toString());
			
			//jsonServletUtil.updateFile(nombreFile, query);
			//Actualizamos en gestion parametro
			File file = new File(JSonUtil.getPathJsonWasModificada() + nombreFile);
			FileUtil.write(file, query.toString());
			
			
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("cargar.tiendas.cargar.tiendas.serviceimpl.generar.json");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(codigos), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("cargar.tiendas.cargar.tiendas.serviceimpl.generar.json")+e.toString());
		} catch (IOException e) {
			_log.error("No se pudo guardar el archivo: " +e.toString());
		} 
	}

	public List<String> uniqueSinOrdenar(List<String> lista) {
		Set<String> s = new LinkedHashSet<String>(lista);
		lista.clear();
		lista.addAll(s);
		return lista;
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
				String errores = "Errores presentados en el archivo:\r\n";

				for (int i = 0; i < lst.size(); i++) {
					errores += lst.get(i).trim() + "\r\n";
				}
				template = template.replaceAll("%ERRORES%", errores);
				generateHTML(resourceRequest, template, pathEscritura);
				urlPreview = themeDisplay.getURLPortal() + "/cargarTiendas-portlet" + Constantes.CARPETA_TEMPLATE + "/listaErrores" + c + ".txt";
				urlPreview = URLEncoder.encode(urlPreview, "UTF-8");
			} catch (Exception e) {
				_log.error("Error al instanciarListaErrores" + e.toString());
			}
		}
		return urlPreview;
	}

	private String getTemplateHTML(ActionRequest resourceRequest, String filePath) {
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

		} finally{
			IOUtils.closeQuietly(bufferLectura);
		}

		return templateHTML;
	}

	private String getTemplateHTML(ResourceRequest resourceRequest, String filePath) {
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

		} finally{
			IOUtils.closeQuietly(bufferLectura);
		}

		return templateHTML;
	}

	private void generateHTML(ActionRequest request, String html, String filePath) {

		BufferedWriter bufferEscritura = null;
		try {
		
			Boolean CleanFileContent;

			/* Leemos el template */
			CleanFileContent = true;// Eliminar archivos SI
			bufferEscritura = new BufferedWriter(new FileWriter(filePath, !CleanFileContent));// Buffer
																								// de
																								// lectura
			bufferEscritura.write(html);
			

		} catch (Exception e) {
		}finally{
			IOUtils.closeQuietly(bufferEscritura);
		}

	}

	/**
	 * Guardar excel cargar tienda. Fecha: 31-ene-2013
	 * 
	 * @param lst the lst
	 */
	public void guardarExcelCargarTienda(List<CargaTienda> lst) {
		if (lst != null && lst.size() > 0) {
			_log.info(" guardarExcelCargarTienda  se tiene la cantidad de registros : " + lst.size());
		
			try {
				CargaTiendaLocalServiceUtil.truncateCargaTienda();	
				CargaTiendaLocalServiceUtil.insert(lst);
			} catch (BusinessException e) {
				String asunto = Propiedades.getResourceBundle("cargar.tiendas.cargar.tiendas.serviceimpl.guardar.excel.cargar.tienda");
				LogErrorUtil.registrarError(JSonUtil.getStringJson(lst), e.getTrazaMessage(), asunto);
				_log.error(Propiedades.getResourceBundle("cargar.tiendas.cargar.tiendas.serviceimpl.guardar.excel.cargar.tienda")+e.toString());
			}			
			
		} else {
			_log.info(" guardarExcelCargarTienda  ningun registro para guardar ");
		}

	}

	public void obtenerListaErrores(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String url = ParamUtil.getString(resourceRequest, "urlPreview");
		PrintWriter writer = null; 
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
			
			writer = response.getWriter();
			writer.write(inputText);
			writer.flush();
		} catch (Exception e) {

		}finally{
			IOUtils.closeQuietly(writer);
		}
	}

}
