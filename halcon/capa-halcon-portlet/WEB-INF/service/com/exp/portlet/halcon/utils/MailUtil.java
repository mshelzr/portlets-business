package com.exp.portlet.halcon.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.mail.internet.InternetAddress;

import com.ext.portlet.halcon.model.LogIncidencias;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;

public class MailUtil {

	private static Log _log = LogFactoryUtil.getLog(MailUtil.class);
	private static String correo;
	private static String correoFrom;
	static ConcurrentHashMap<String, String> hashValor;
	
	public static Boolean enviarMail(String correo, String body, String asunto, String correoCapa) {
		try {

//			String correoCapa = (String) JSonUtil
//					.getValor(JSonUtil.ETIQUETA_CORREO_CONTACTANOS_REMI);

			_log.info("correo desde capa: " + correoCapa);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(body);
			mailMessage.setFrom(new InternetAddress(correoCapa));
			mailMessage.setSubject(asunto);
			mailMessage.setTo(new InternetAddress(correo));
			
			MailServiceUtil.sendEmail(mailMessage);
			
			return true;
			
		} catch (Exception e) {
			_log.error(""+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public static Boolean enviarMailError(LogIncidencias logIncidencias) {
		try {
			String mensajeError=logIncidencias.getMensajeError() ; 
			String parametros=logIncidencias.getParametro();
			String idSession=logIncidencias.getIdSessionVisitante();
			String tipoNumDoc=logIncidencias.getTipoNumDoc();
			String ip=logIncidencias.getIP();
			String fecha= TiempoUtil.getFechaActualConPatronyDate("dd/MM/yyyy hh:mm:ss",logIncidencias.getFechaHoraError());
			String trazaError=logIncidencias.getTrazaError();
			String paginaHija = logIncidencias.getPaginaHija();
			String pathLectura = "";
			pathLectura = JSonUtil.PATH_ERROR ;
			
			String template = getTemplateHTML(pathLectura);
			
			parametros = parametros.replaceAll(",",",<br/>");
			
			template = template.replaceAll("%LOG_MSJERROR%", mensajeError);
			template = template.replaceAll("%LOG_ENTRADA%",parametros);
			template = template.replaceAll("%LOG_SESSION%",idSession);
			template = template.replaceAll("%LOG_DOCUMENTO%",tipoNumDoc);
			template = template.replaceAll("%LOG_IP%",ip);
			template = template.replaceAll("%LOG_HORA%",fecha);
			template = template.replaceAll("%LOG_TRAZA%",trazaError);
			template = template.replaceAll("%LOG_PAGINAS%",paginaHija);
			
	        String body = template;
	        
			String asunto = mensajeError;
			
			correo =  getValor(JSonUtil.ETIQUETA_CORREO_ERROR_LOG);
			correoFrom = (String) getValor(JSonUtil.ETIQUETA_CORREO_ERROR_LOG_REMITENTE);
			
			_log.info("correo desde capa: " + correo);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(body);
			mailMessage.setFrom(new InternetAddress(correoFrom));
			mailMessage.setSubject(asunto);
			mailMessage.setTo(new InternetAddress(correo));
			
			MailServiceUtil.sendEmail(mailMessage);
			
			return true;
			
		} catch (Exception e) {
			_log.error(""+e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	private static String getValor(String valor){
		hashValor = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.capa.cache.util.CacheCapaUtil","hashValor");
		if (hashValor == null) {
			_log.info("*** entro en getValor null*****");

			hashValor  = new ConcurrentHashMap<String, String>();
			List<Parametro> listaValor;
			try {
				listaValor = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_VALOR);
				for (Parametro param : listaValor) {
					hashValor.put(param.getDato3(), param.getDato1());
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.capa.cache.util.CacheCapaUtil","hashValor", hashValor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hashValor.get(valor);
	}
	
	private static String getTemplateHTML(String filePath) {
		String templateHTML;

		templateHTML = "";
		try {
			BufferedReader bufferLectura;
			StringBuffer fileData;
			char[] buf;

			/* Leemos el template */
			
			
			URL pagina = new URL(filePath);
		   
			bufferLectura = new BufferedReader(new InputStreamReader(pagina.openStream()));// Buffer de lectura
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
			_log.error(""+e.getMessage());
			e.printStackTrace();
	  }
		return templateHTML;
	}
	
	
	
}
