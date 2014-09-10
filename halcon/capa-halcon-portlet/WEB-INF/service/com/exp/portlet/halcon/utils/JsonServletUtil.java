package com.exp.portlet.halcon.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.ext.portlet.halcon.dto.BeanFile;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

public class JsonServletUtil {

	private static Log _log = LogFactoryUtil.getLog(JsonServletUtil.class);
	
	
	public ServletOutputStream obtenerFileDocumentLibrary(Integer param,
			HttpServletResponse response) throws ServletException, IOException {

		String nameJson = getNameJson(param);
		FileEntry fileEntry = null;
		Folder folderPadre = null;
		Long groupId = null;
		ServletOutputStream stream = null;
		BufferedInputStream buf = null;
		
		try {
			stream = response.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long companyId = PortalUtil.getDefaultCompanyId();
		Group guestGroup;

		try {

			guestGroup = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			groupId = guestGroup.getGroupId();

			folderPadre = DLAppLocalServiceUtil.getFolder(groupId, 0L,
					"Archivos");
			fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId,
					folderPadre.getFolderId(), nameJson);

			FileVersion version;

			version = fileEntry.getFileVersion();

			if (version.getStatus() != WorkflowConstants.STATUS_APPROVED) {
				/* Si no esta aprobado continua */
				fileEntry = null;
			}

			InputStream inputStream;

			inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(
					fileEntry.getUserId(), fileEntry.getFileEntryId(),
					fileEntry.getVersion());

			File file = inputStreamAFile(inputStream, nameJson);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.setContentLength((int) file.length());
			FileInputStream inputJsonText = new FileInputStream(file);

			buf = new BufferedInputStream(inputJsonText);
			int readBytes = 0;
			while ((readBytes = buf.read()) != -1)
				stream.write(readBytes);

		} catch (IOException ioe) {

		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (stream != null)
				stream.close();
			if (buf != null)
				buf.close();
		}

		return stream;

	}

	public String getNameJson(Integer id) {
		String json = "";
		switch (id) {

		case 1:
			json = "categoria.json";
			break;
		case 2:
			json = "cboPerfilador-todos.json";
			break;
		case 3:
			json = "cboPerfilador.json";
			break;
		case 4:
			json = "cboTipoPerfilador.json";
			break;
		case 5:
			json = "cbo_horario.json";
			break;
		case 6:
			json = "cbo_tiempo.json";
			break;
		case 7:
			json = "cbo_tipoDocumento.json";
			break;
		case 8:
			json = "conocimiento_sim_fondos_mutuos.json";
			break;
		case 9:
			json = "departamento.json";
			break;
		case 10:
			json = "desvalorizara_sim_fondos_mutuos.json";
			break;
		case 11:
			json = "distrito.json";
			break;
		case 12:
			json = "distrito_lima.json";
			break;
		case 13:
			json = "invertido_sim_fondos_mutuos.json";
			break;
		case 14:
			json = "pais.json";
			break;
		case 15:
			json = "plazo_cre_sim_credito_hipotecario.json";
			break;
		case 16:
			json = "plazo_cre_sim_deposito_plazo.json";
			break;
		case 17:
			json = "plazo_cre_sim_personal.json";
			break;
		case 18:
			json = "plazo_sim_fondo_mutuo.json";
			break;
		case 19:
			json = "producto.json";
			break;
		case 20:
			json = "provincia.json";
			break;
		case 21:
			json = "respuestaADQ.json";
			break;
		case 22:
			json = "simulador.json";
			break;
		case 23:
			json = "solicitudes_estado_civil.json";
			break;
		case 24:
			json = "solicitudes_situacion_laboral.json";
			break;
		case 25:
			json = "tema_solicitar_contacto.json";
			break;
		case 26:
			json = "tip_credito_sim_credito_hipotecario.json";
			break;
		case 27:
			json = "tip_credito_sim_vehicular.json";
			break;
		case 28:
			json = "tip_cre_sim_personal.json";
			break;
		case 29:
			json = "tip_cuota_sim_credito_hipotecario.json";
			break;
		case 30:
			json = "tip_cuota_sim_personal.json";
			break;
		case 31:
			json = "tip_cuota_sim_vehicular.json";
			break;
		case 32:
			json = "tip_doc_caja_sorpresa.json";
			break;
		case 33:
			json = "tip_doc_sim_credito_hipotecario.json";
			break;
		case 34:
			json = "tip_doc_sim_deposito_plazo.json";
			break;
		case 35:
			json = "tip_doc_sim_fondos_mutuos.json";
			break;
		case 36:
			json = "tip_doc_sim_personal.json";
			break;
		case 37:
			json = "tip_doc_sim_vehicular.json";
			break;
		case 38:
			json = "tip_moneda_sim_credito_hipotecario.json";
			break;
		case 39:
			json = "tip_moneda_sim_deposito_plazo.json";
			break;
		case 40:
			json = "tip_moneda_sim_personal.json";
			break;
		case 41:
			json = "tip_moneda_sim_vehicular.json";
			break;
		case 42:
			json = "tip_seg_desgravamen_credito_hipotecario.json";
			break;
		case 43:
			json = "tip_seg_desgravamen_sim_vehicular.json";
			break;
		case 44:
			json = "rango.txt";
			break;
		case 45:
			json = "valor.txt";
			break;
		case 46:
			json = "tipo_documento_denuncia.json";
			break;
		case 47:
			json = "tipo_documento_solicitud_credito_hipotecario.json";
			break;
		case 48:
			json = "tipo_documento_solicitud_credito_vehicular.json";
			break;
		case 49:
			json = "tipo_documento_solicitud_cuenta_sueldo.json";
			break;
		case 50:
			json = "tipo_documento_solicitud_fondos_mutuos.json";
			break;
		case 51:
			json = "tipo_documento_solicitud_prestamo_personal.json";
			break;
		case 52:
			json = "tipo_documento_solicitud_producto_pre_aprobado.json";
			break;
		case 53:
			json = "tipo_documento_solicitud_seguro_soat.json";
			break;
		case 54:
			json = "tipo_documento_solicitud_tarjeta_credito.json";
			break;
		case 55:
			json = "departamento_tiendas.json";
			break;
		case 56:
			json = "provincia_tiendas.json";
			break;
		case 57:
			json = "distrito_tiendas.json";
			break;
		default:
			json = "nada.json";
			break;
		}

		return json;
	}

	
	private File inputStreamAFile(InputStream entrada, String nameFile) {
		File f = new File(JSonUtil.getPathJsonWasModificada() + nameFile);// Aqui le dan el nombre y/o con la ruta del

		// salida
		OutputStream salida = null;
		try {

			salida = new FileOutputStream(f);
			byte[] buf = new byte[1024];// Actualizado me olvide del 1024
			int len;
			while ((len = entrada.read(buf)) > 0) {
				salida.write(buf, 0, len);
			}
			salida.flush();
		} catch (IOException e) {
			_log.error("inputStreamAFile: " + e.getMessage());
		} finally {
			try {
				if (salida != null) {
					salida.close();
				}
				entrada.close();
			} catch (IOException e2) {
				_log.error("inputStreamAFile: " + e2.getMessage());
			}
		}

		return f;
	}
	
	
	public void updateFile(String nameJson, StringBuilder data) {

		FileEntry fileEntry = null;
		Folder folderPadre = null;
		Long groupId = null;
		Integer tamanioArchivo = 0;

		long companyId = PortalUtil.getDefaultCompanyId();
		Group guestGroup;

		try {

			guestGroup = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			groupId = guestGroup.getGroupId();

			folderPadre = DLAppLocalServiceUtil.getFolder(groupId, 0L,
					"Archivos");

			fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId,
					folderPadre.getFolderId(), nameJson);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			fileEntry = null;
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(fileEntry != null){

			FileVersion version = null;

			try {
				version = fileEntry.getFileVersion();
			} catch (PortalException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SystemException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			if (version.getStatus() != WorkflowConstants.STATUS_APPROVED) {
				/* Si no esta aprobado continua */
				fileEntry = null;
			}

		}
			
		
		File file = new File(JSonUtil.getPathJsonWasModificada() + nameJson);

		try {
			FileUtil.write(file, data.toString());

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file);
			
		} catch (FileNotFoundException e1) {

			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ServiceContext serviceContext = new ServiceContext();
		
		try {
			tamanioArchivo = inputStream.available();
		} catch (Exception e) {
			_log.error("Error al obtener el tamaño del archivo" + e.toString());
		}
		
		if(fileEntry != null){
			try {

				DLAppLocalServiceUtil.updateFileEntry(fileEntry.getUserId(),
						fileEntry.getFileEntryId(), nameJson, "text/plain",
						fileEntry.getTitle(), fileEntry.getDescription(),
						null, true, inputStream, tamanioArchivo, serviceContext);
				
				inputStream.close();
			} catch (PortalException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				DLAppLocalServiceUtil.addFileEntry(folderPadre.getUserId(), folderPadre.getRepositoryId(), folderPadre.getFolderId(), nameJson, "text/plain", nameJson, nameJson, "", inputStream, tamanioArchivo, serviceContext);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		

	}

	public File obtenerFile(Integer param) throws ServletException, IOException {

		String nameJson = getNameJson(param);
		File file = null;
		FileEntry fileEntry = null;
		Folder folderPadre = null;
		Long groupId = null;

		long companyId = PortalUtil.getDefaultCompanyId();
		Group guestGroup;

		try {

			guestGroup = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			groupId = guestGroup.getGroupId();

			folderPadre = DLAppLocalServiceUtil.getFolder(groupId, 0L,
					"Archivos");
			fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId,
					folderPadre.getFolderId(), nameJson);

			FileVersion version;

			version = fileEntry.getFileVersion();

			if (version.getStatus() != WorkflowConstants.STATUS_APPROVED) {
				/* Si no esta aprobado continua */
				fileEntry = null;
			}

			InputStream inputStream;
			inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(
					fileEntry.getUserId(), fileEntry.getFileEntryId(),
					fileEntry.getVersion());
			file = inputStreamAFile(inputStream, nameJson);

		} catch (Exception ioe) {
			ioe.printStackTrace();
		} finally {

		}

		return file;

	}

	public BeanFile obtenerFileVersion(Integer param) throws ServletException,
			IOException {

		String nameJson = getNameJson(param);
		File file = null;
		FileEntry fileEntry = null;
		Folder folderPadre = null;
		Long groupId = null;
		BeanFile beanFile = new BeanFile();

		long companyId = PortalUtil.getDefaultCompanyId();
		Group guestGroup;

		try {

			guestGroup = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			groupId = guestGroup.getGroupId();

			folderPadre = DLAppLocalServiceUtil.getFolder(groupId, 0L,
					"Archivos");
			fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId,
					folderPadre.getFolderId(), nameJson);

			FileVersion version;

			version = fileEntry.getFileVersion();
			beanFile.setVersion(version.getVersion());
			if (version.getStatus() != WorkflowConstants.STATUS_APPROVED) {
				/* Si no esta aprobado continua */
				fileEntry = null;
			}

			InputStream inputStream;

			inputStream = DLFileEntryLocalServiceUtil.getFileAsStream(
					fileEntry.getUserId(), fileEntry.getFileEntryId(),
					fileEntry.getVersion());

			file = inputStreamAFile(inputStream, nameJson);
			beanFile.setFile(file);

		} catch (Exception ioe) {

		} finally {

		}

		return beanFile;

	}

	public String getVersion(Integer param) {

		FileEntry fileEntry = null;
		Folder folderPadre = null;
		Long groupId = null;
		FileVersion version = null;

		String nameJson = getNameJson(param);
		long companyId = PortalUtil.getDefaultCompanyId();
		Group guestGroup = null;

		try {
			guestGroup = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		groupId = guestGroup.getGroupId();

		try {

			folderPadre = DLAppLocalServiceUtil.getFolder(groupId, 0L,
					"Archivos");
			fileEntry = DLAppLocalServiceUtil.getFileEntry(groupId,
					folderPadre.getFolderId(), nameJson);
			version = fileEntry.getFileVersion();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return version.getVersion();
	}

	public Integer getNumeroApartirName(String nombre) {
		Integer valorNum = 0;
		if (nombre.equals("categoria.json")) {
			valorNum = 1;
		} else if (nombre.equals("cboPerfilador-todos.json")) {
			valorNum = 2;
		} else if (nombre.equals("cboPerfilador.json")) {
			valorNum = 3;
		} else if (nombre.equals("cboTipoPerfilador.json")) {
			valorNum = 4;
		} else if (nombre.equals("cbo_horario.json")) {
			valorNum = 5;
		} else if (nombre.equals("cbo_tiempo.json")) {
			valorNum = 6;
		} else if (nombre.equals("cbo_tipoDocumento.json")) {
			valorNum = 7;
		} else if (nombre.equals("conocimiento_sim_fondos_mutuos.json")) {
			valorNum = 8;
		} else if (nombre.equals("departamento.json")) {
			valorNum = 9;
		} else if (nombre.equals("desvalorizara_sim_fondos_mutuos.json")) {
			valorNum = 10;
		} else if (nombre.equals("distrito.json")) {
			valorNum = 11;
		} else if (nombre.equals("distrito_lima.json")) {
			valorNum = 12;
		} else if (nombre.equals("invertido_sim_fondos_mutuos.json")) {
			valorNum = 13;
		} else if (nombre.equals("pais.json")) {
			valorNum = 14;
		} else if (nombre.equals("plazo_cre_sim_credito_hipotecario.json")) {
			valorNum = 15;
		} else if (nombre.equals("plazo_cre_sim_deposito_plazo.json")) {
			valorNum = 16;
		} else if (nombre.equals("plazo_cre_sim_personal.json")) {
			valorNum = 17;
		} else if (nombre.equals("plazo_sim_fondo_mutuo.json")) {
			valorNum = 18;
		} else if (nombre.equals("producto.json")) {
			valorNum = 19;
		} else if (nombre.equals("provincia.json")) {
			valorNum = 20;
		} else if (nombre.equals("respuestaADQ.json")) {
			valorNum = 21;
		} else if (nombre.equals("simulador.json")) {
			valorNum = 22;
		} else if (nombre.equals("solicitudes_estado_civil.json")) {
			valorNum = 23;
		} else if (nombre.equals("solicitudes_situacion_laboral.json")) {
			valorNum = 24;
		} else if (nombre.equals("tema_solicitar_contacto.json")) {
			valorNum = 25;
		} else if (nombre.equals("tip_credito_sim_credito_hipotecario.json")) {
			valorNum = 26;
		} else if (nombre.equals("tip_credito_sim_vehicular.json")) {
			valorNum = 27;
		} else if (nombre.equals("tip_cre_sim_personal.json")) {
			valorNum = 28;
		} else if (nombre.equals("tip_cuota_sim_credito_hipotecario.json")) {
			valorNum = 29;
		} else if (nombre.equals("tip_cuota_sim_personal.json")) {
			valorNum = 30;
		} else if (nombre.equals("tip_cuota_sim_vehicular.json")) {
			valorNum = 31;
		} else if (nombre.equals("tip_doc_caja_sorpresa.json")) {
			valorNum = 32;
		} else if (nombre.equals("tip_doc_sim_credito_hipotecario.json")) {
			valorNum = 33;
		} else if (nombre.equals("tip_doc_sim_deposito_plazo.json")) {
			valorNum = 34;
		} else if (nombre.equals("tip_doc_sim_fondos_mutuos.json")) {
			valorNum = 35;
		} else if (nombre.equals("tip_doc_sim_personal.json")) {
			valorNum = 36;
		} else if (nombre.equals("tip_doc_sim_vehicular.json")) {
			valorNum = 37;
		} else if (nombre.equals("tip_moneda_sim_credito_hipotecario.json")) {
			valorNum = 38;
		} else if (nombre.equals("tip_moneda_sim_deposito_plazo.json")) {
			valorNum = 39;
		} else if (nombre.equals("tip_moneda_sim_personal.json")) {
			valorNum = 40;
		} else if (nombre.equals("tip_moneda_sim_vehicular.json")) {
			valorNum = 41;
		} else if (nombre.equals("tip_seg_desgravamen_credito_hipotecario.json")) {
			valorNum = 42;
		} else if (nombre.equals("tip_seg_desgravamen_sim_vehicular.json")) {
			valorNum = 43;
		} else if (nombre.equals("tipo_documento_denuncia.json")) {
			valorNum = 46;
		} else if (nombre.equals("tipo_documento_solicitud_credito_hipotecario.json")) {
			valorNum = 47;
		} else if (nombre.equals("tipo_documento_solicitud_credito_vehicular.json")) {
			valorNum = 48;
		} else if (nombre.equals("tipo_documento_solicitud_cuenta_sueldo.json")) {
			valorNum = 49;
		} else if (nombre.equals("tipo_documento_solicitud_fondos_mutuos.json")) {
			valorNum = 50;
		} else if (nombre.equals("tipo_documento_solicitud_prestamo_personal.json")) {
			valorNum = 51;
		} else if (nombre.equals("tipo_documento_solicitud_producto_pre_aprobado.json")) {
			valorNum = 52;
		} else if (nombre.equals("tipo_documento_solicitud_seguro_soat.json")) {
			valorNum = 53;
		} else if (nombre.equals("tipo_documento_solicitud_tarjeta_credito.json")) {
			valorNum = 54;
		} else if (nombre.equals("departamento_tiendas.json")) {
			valorNum = 55;
		} else if (nombre.equals("provincia_tiendas.json")) {
			valorNum = 56;
		} else if (nombre.equals("distrito_tiendas.json")) {
			valorNum = 57;
		}

		return valorNum;

	}

}
