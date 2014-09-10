package com.exp.portlet.halcon.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.tempuri.WSHpcIntranet.Cronograma.CronogramaSoapProxy;

import com.exp.portlet.halcon.jaxb.Cabecera;
import com.exp.portlet.halcon.jaxb.Credito;
import com.exp.portlet.halcon.jaxb.Cuota;
import com.exp.portlet.halcon.jaxb.RootCabecera;
import com.exp.portlet.halcon.jaxb.RootCredito;
import com.exp.portlet.halcon.jaxb.RootCronograma;
import com.ext.portlet.halcon.dto.FormularioReplicadorBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class WsReplicadorServiceUtil {
	private static Log _log = LogFactoryUtil.getLog(WsPrecalificacionServiceUtil.class);
	
	public static int validarCredito(int nroCredito, int grupoCredito, int moneda) throws BusinessException{
		

		int resultado = 0;

		
		try {
			CronogramaSoapProxy cronogramaSoapProxy =  new CronogramaSoapProxy();
			cronogramaSoapProxy.setEndpoint(Propiedades.getResourceBundle("replicadores.ip.web.service.ibk"));
			resultado = cronogramaSoapProxy.validarCredito(nroCredito, grupoCredito, moneda);
			
		} catch(Exception e) {
			resultado = 2;
			_log.info("error: " + e.toString());
			e.printStackTrace();
		}
		
		return resultado;
	}
	
	public static Object[] generarNuevoReplicador(FormularioReplicadorBean formulario) throws BusinessException{

		Object[] datos = new Object[4];
		String[] resultadoWs = new String[3]; 
		
		try {
			CronogramaSoapProxy cronogramaSoapProxy =  new CronogramaSoapProxy();
			cronogramaSoapProxy.setEndpoint(Propiedades.getResourceBundle("replicadores.ip.web.service.ibk"));

			resultadoWs = cronogramaSoapProxy.generarNuevoReplicadorWeb(formulario.getNroCredito(), formulario.getGrupoPrestamo(), formulario.getMoneda(), formulario.getMontoFinanciar(), formulario.getPlazoMeses(), formulario.getPeriodoGracia(), formulario.getTea(), formulario.getSeguroDesgravamen(), formulario.getPorcentajeSeguro(), formulario.getValorBien(), formulario.getTipoCuota(), formulario.getFechaDesembolso(), formulario.getDiaVencimiento(), formulario.getEnvioInforme(), formulario.getCuotaBalon(), formulario.getAplicativo());
			datos[0] = getCredito(resultadoWs[0]);
			datos[1] = getListadoCuotas(resultadoWs[1]);
			datos[2] = getCabecera(resultadoWs[2]);
			
		} catch(Exception e) {
			_log.info("error: " + e.toString());
			e.printStackTrace();
		}
		
		return datos;
	}
	
	public static Credito getCredito(String creditoXml) throws BusinessException{
		JAXBContext jaxbContext;
		RootCredito root= new RootCredito();
		try {
			jaxbContext = JAXBContext.newInstance(RootCredito.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			InputStream is = new ByteArrayInputStream(creditoXml.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		 
			root = (RootCredito) jaxbUnmarshaller.unmarshal(br);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return root.getData().getRow();
	}
	
	static List<Cuota> getListadoCuotas(String cuotasXml){
		
		JAXBContext jaxbContext;
		RootCronograma root= new RootCronograma();
		
		try {
			jaxbContext = JAXBContext.newInstance(RootCronograma.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			InputStream is = new ByteArrayInputStream(cuotasXml.getBytes());
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		 
			root = (RootCronograma) jaxbUnmarshaller.unmarshal(br);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return root.getData().getListaRow();
	}
	
	public static Cabecera getCabecera(String cabeceraXml) throws BusinessException{
		JAXBContext jaxbContext;
		RootCabecera root= new RootCabecera();
		try {
			jaxbContext = JAXBContext.newInstance(RootCabecera.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			// convert String into InputStream
			InputStream is = new ByteArrayInputStream(cabeceraXml.getBytes());
		 
			// read it with BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		 
			root = (RootCabecera) jaxbUnmarshaller.unmarshal(br);
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return root.getData().getRow();
	}
	
}
