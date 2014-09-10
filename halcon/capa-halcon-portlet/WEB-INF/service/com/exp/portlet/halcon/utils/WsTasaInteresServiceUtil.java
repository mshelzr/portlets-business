package com.exp.portlet.halcon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ext.portlet.halcon.dto.TasaInteresBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ibk.ents.creditohipotecario.simuladorhpc.refconsultartasainteres.v1.RefConsultarTasaInteres;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.enlace.v1.SimuladorHPC;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.enlace.v1.SimuladorHPC_Service;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.v1.ConsultarTasaInteres;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.v1.ConsultarTasaInteresResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

public class WsTasaInteresServiceUtil {
	
	private static Log _log = LogFactoryUtil.getLog(WsTasaInteresServiceUtil.class);
	
	private static SimuladorHPC_Service service = null;
	private static ConsultarTasaInteres consultarTasaInteres= null;
	private static RefConsultarTasaInteres refConsultarTasaInteres = null;
	private static RequestHeader requestHeader=null;
	private static UsernameToken userId=null;
	@SuppressWarnings("rawtypes")
	private static List<Handler>  chain;
	private static Holder<ConsultarTasaInteresResponse> consultarTasaInteresResponse;
	private static Holder<ResponseHeader> responseHeader;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");
	
	public static double realizarWsTasaInteres(Object tasaInteresObject) throws BusinessException{

		getChain().clear();
		
		TasaInteresBean tasaInteresBean = (TasaInteresBean) tasaInteresObject;

		SimuladorHPC port = getTasaws().getSimuladorHPC();
		
		BindingProvider bindingProvider = (BindingProvider) port;
		getChain().add(new SOAPLoggingHandlerUtil());
		bindingProvider.getBinding().setHandlerChain(getChain());
		bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT,Propiedades.getResourceBundle("ws.request.timeout"));
		bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT,Propiedades.getResourceBundle("ws.connect.timeout"));
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, Propiedades.getResourceBundle("ip.web.service.ibk"));
		
		/*HEADER*/
		getRequestHeader().setMessageId(formato.format(new Date()));
		getRequestHeader().setSystemId(Propiedades.getResourceBundle("systemId"));
		
		getUserId().setUserName(Propiedades.getResourceBundle("userName"));
		getRequestHeader().setUserId(getUserId());
		/*END HEADER*/
		
		
		/*BODY*/
		getRefConsultarTasaInteres().setCodigoGrupo(tasaInteresBean.getCodigoGrupo());
		getRefConsultarTasaInteres().setCodigoMoneda(tasaInteresBean.getCodigoMoneda());
		
		//Aqui convertimos los codigos por otros, consideramos los cambios por parte del Usuario
		if(Integer.parseInt(tasaInteresBean.getCodigoProducto()) == SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO || Integer.parseInt(tasaInteresBean.getCodigoProducto()) == SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL){
			getRefConsultarTasaInteres().setCodigoProducto(String.valueOf(SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL));
		}else if (Integer.parseInt(tasaInteresBean.getCodigoProducto()) == SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME){
			getRefConsultarTasaInteres().setCodigoProducto(String.valueOf(SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME));
		}else{
			getRefConsultarTasaInteres().setCodigoProducto(tasaInteresBean.getCodigoProducto());
		}
		
		getRefConsultarTasaInteres().setCodigoProductoSiebel(tasaInteresBean.getCodigoProductoSiebel());
		
		getRefConsultarTasaInteres().setMontoFinanciar(tasaInteresBean.getMontoFinanciar());
		getRefConsultarTasaInteres().setNumeroDocumento(tasaInteresBean.getNumeroDocumento());
		getRefConsultarTasaInteres().setPlazo(tasaInteresBean.getPlazo());
		getRefConsultarTasaInteres().setTipoDocumento(tasaInteresBean.getTipoDocumento());
		getRefConsultarTasaInteres().setCodigoCanal(tasaInteresBean.getCodigoCanal());
		getConsultarTasaInteres().setRefConsultarTasaInteres(getRefConsultarTasaInteres());
		/*END BODY*/
		
		try {
			port.consultarTasaInteres(getConsultarTasaInteres(), getRequestHeader(), getConsultarTasaInteresResponse(), getResponseHeader());
			
			ConsultarTasaInteresResponse response = getConsultarTasaInteresResponse().value;
					
			return response.getTasaInteres();
			//return 0;
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.tasa.interes.error") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.tasa.interes", "capa.halcon.auditoria.tasa.interes.error") , e.toString());
		}
	}
	
	
	private static SimuladorHPC_Service getTasaws(){
		if (null == service) {
			service = new SimuladorHPC_Service();
		}
		return service;
	}
	
	
	private static  ConsultarTasaInteres getConsultarTasaInteres() {
		if (null == consultarTasaInteres ) {
			consultarTasaInteres =new ConsultarTasaInteres();
		}
		return consultarTasaInteres;
	}
	
	private static RefConsultarTasaInteres getRefConsultarTasaInteres(){
		if (null == refConsultarTasaInteres ) {
			refConsultarTasaInteres =new RefConsultarTasaInteres();
		}
		return refConsultarTasaInteres;
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
	
	@SuppressWarnings("rawtypes")
	public static List<Handler> getChain() {
		if (null == chain ) {
			chain = new LinkedList<Handler>();
		}
		return chain;
	}
	
	public static Holder<ConsultarTasaInteresResponse> getConsultarTasaInteresResponse() {
		if (null == consultarTasaInteresResponse ) {
			consultarTasaInteresResponse = new Holder<ConsultarTasaInteresResponse>();
		}
		return consultarTasaInteresResponse;
	}
	
	public static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}
	
	
	
	

}
