package com.exp.portlet.halcon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ibk.ents.productosservicios.fondomutuo.refconsultarvalorcuota.v1.RefConsultarValorCuota;
import com.ibk.ents.productosservicios.fondomutuo.valorcuota.v1.ValorCuota;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.productos.corebancario.fondomutuo.enlace.v1.FondoMutuo;
import com.ibk.intf.productos.corebancario.fondomutuo.enlace.v1.FondoMutuo_Service;
import com.ibk.intf.productos.corebancario.fondomutuo.v1.ConsultarValorCuota;
import com.ibk.intf.productos.corebancario.fondomutuo.v1.ConsultarValorCuotaResponse;
import com.ibk.intf.productos.corebancario.fondomutuo.v1.ConsultarValorCuotaResponse.ValoresCuota;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

@SuppressWarnings("rawtypes")
public class WsFondosMutuos_ConsultarValorCuota {
	
	private static Log _log = LogFactoryUtil.getLog(WsFondosMutuos_ConsultarValorCuota.class);

	private static FondoMutuo_Service service = null;
	private static ConsultarValorCuota consultarValorCuota = null;
	private static RefConsultarValorCuota refConsultarValorCuota = null;
	private static RequestHeader requestHeader=null;
	private static UsernameToken userId=null;
	
	private static List<Handler>  chain;
	private static Holder<ConsultarValorCuotaResponse> consultarValorCuotaResponse;
	private static Holder<ResponseHeader> responseHeader;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");
	

	public static List<ValorCuota> obtenerValoresCuotas(String ultimaFecha)  {

		FondoMutuo port = getValorCuotaws().getFondoMutuo();
		BindingProvider bindingProvider = (BindingProvider) port;
		getChain().add(new SOAPLoggingHandlerUtil());
		bindingProvider.getBinding().setHandlerChain(getChain());
		
		bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT,Propiedades.getResourceBundle("ws.request.timeout"));
		bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT,Propiedades.getResourceBundle("ws.connect.timeout"));
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,Propiedades.getResourceBundle("ip.web.service.ibk"));
		
		/*HEADER*/
		getRequestHeader().setMessageId(formato.format(new Date()));
		getRequestHeader().setSystemId(Propiedades.getResourceBundle("systemId"));
		
		getUserId().setUserName(Propiedades.getResourceBundle("userName"));
		getRequestHeader().setUserId(getUserId());
		/*END HEADER*/
		Date fecha = TiempoUtil.getFechaStringDateAMD(ultimaFecha);
		
		XMLGregorianCalendar fechaValorCuota;
		try {
			fechaValorCuota = DatatypeFactory.newInstance().newXMLGregorianCalendar();
		
			fechaValorCuota.setDay(TiempoUtil.getDia(fecha));
			fechaValorCuota.setMonth(TiempoUtil.getMes(fecha));
			fechaValorCuota.setYear(TiempoUtil.getAno(fecha));
			
			getRefConsultarValorCuota().setFechaValorCuota(fechaValorCuota);
			getConsultarValorCuota().setRefConsultarValorCuota(getRefConsultarValorCuota());
		} catch (DatatypeConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*END BODY*/
		ConsultarValorCuotaResponse response=null;
		ValoresCuota valoresCuota = new ValoresCuota();
		try {
			
			port.consultarValorCuota(getConsultarValorCuota(), getRequestHeader(), getConsultarValorCuotaResponse(), getResponseHeader());
			
			response = getConsultarValorCuotaResponse().value;
			
			valoresCuota = response.getValoresCuota();

		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return valoresCuota.getValorCuota();
	}
	
	private static FondoMutuo_Service getValorCuotaws(){
		if (null == service) {
			service = new FondoMutuo_Service();
		}
		return service;
	}
	
	
	private static  ConsultarValorCuota getConsultarValorCuota() {
		if (null == consultarValorCuota ) {
			consultarValorCuota =new ConsultarValorCuota();
		}
		return consultarValorCuota;
	}
	
	private static RefConsultarValorCuota getRefConsultarValorCuota(){
		if (null == refConsultarValorCuota ) {
			refConsultarValorCuota =new RefConsultarValorCuota();
		}
		return refConsultarValorCuota;
	}
	
	private static  RequestHeader getRequestHeader() {
		if (null == requestHeader ) {
			requestHeader = new RequestHeader();
		}
		return requestHeader;
	}
	private static  UsernameToken getUserId() {
		if (null == userId ) {
			userId = new UsernameToken();
		}
		return userId;
	}
	
	public static List<Handler> getChain() {
		if (null == chain ) {
			chain = new LinkedList<Handler>();
		}
		return chain;
	}
	
	
	public static Holder<ConsultarValorCuotaResponse> getConsultarValorCuotaResponse() {
		if (null == consultarValorCuotaResponse ) {
			consultarValorCuotaResponse = new Holder<ConsultarValorCuotaResponse>();
		}
		return consultarValorCuotaResponse;
	}
	
	public static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}
	
}
