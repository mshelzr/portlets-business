package com.exp.portlet.halcon.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ext.portlet.halcon.dto.PromocionBean;
import com.ext.portlet.halcon.dto.PromocionResponseBean;
import com.ibk.ents.informacioneventos.contactosvisitas.promociones.promocion.v1.Promocion;
import com.ibk.ents.informacioneventos.contactosvisitas.promociones.refconsultarpromociones.v1.RefConsultarPromociones;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.informacioneventos.contactosvisitas.promociones.enlace.v1.Promociones;
import com.ibk.intf.informacioneventos.contactosvisitas.promociones.enlace.v1.Promociones_Service;
import com.ibk.intf.informacioneventos.contactosvisitas.promociones.v1.ConsultarPromociones;
import com.ibk.intf.informacioneventos.contactosvisitas.promociones.v1.ConsultarPromocionesResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

public class WsPromocionServiceUtil {
	
	private static Log _log = LogFactoryUtil.getLog(WsPromocionServiceUtil.class);
	
	private static Promociones_Service service = null;
	private static ConsultarPromociones consultarPromociones= null;
	private static RefConsultarPromociones refConsultarPromociones = null;
	private static RequestHeader requestHeader=null;
	private static UsernameToken userId=null;
	@SuppressWarnings("rawtypes")
	private static List<Handler>  chain;
	private static Holder<ConsultarPromocionesResponse> consultarPromocionesResponse;
	private static Holder<ResponseHeader> responseHeader;
	private static List<PromocionResponseBean> listPromocionResponseBean;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");

	
	public static List<PromocionResponseBean> realizarWsPromocion(Object identidadBean) {
		getChain().clear();
		
		PromocionBean bean = (PromocionBean) identidadBean;
		
		Promociones port = getProws().getPromociones();
		
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
		getRefConsultarPromociones().setTipoDocumento(bean.getTipoDocumento());
		getRefConsultarPromociones().setNumeroDocumento(bean.getNumDocumento());
		getRefConsultarPromociones().setCodigoCanal(bean.getCanal());
		getConsultarPromociones().setRefConsultarPromociones(getRefConsultarPromociones());
		/*END BODY*/
		try {
			/*Limpiamos el valor*/
			getListPromocionResponseBean().clear();
			
			port.consultarPromociones(getConsultarPromociones(), getRequestHeader(), getConsultarPromocionesResponse(), getResponseHeader());
			
			ConsultarPromocionesResponse response = getConsultarPromocionesResponse().value;
			ConsultarPromocionesResponse.Promociones promociones =  response.getPromociones();
			List<Promocion> listPromocion = promociones.getPromocion();
			_log.info("Tamaño de la lista de promociones : "+listPromocion.size());
			for (Promocion p : listPromocion) {
				PromocionResponseBean promocionResponseBean = new PromocionResponseBean();
				promocionResponseBean.setCodigoPromocion(p.getCodigoProducto());
				getListPromocionResponseBean().add(promocionResponseBean);
			}
		} catch (Exception e) {
			listPromocionResponseBean=null;
			_log.error(e.getMessage());
		}
		
		return getListPromocionResponseBean();
	}

	private static Promociones_Service getProws(){
		if (null == service) {
			service = new Promociones_Service();
		}
		return service;
	}
	
	
	private static  ConsultarPromociones getConsultarPromociones() {
		if (null == consultarPromociones ) {
			consultarPromociones =new ConsultarPromociones();
		}
		return consultarPromociones;
	}
	
	private static RefConsultarPromociones getRefConsultarPromociones(){
		if (null == refConsultarPromociones ) {
			refConsultarPromociones =new RefConsultarPromociones();
		}
		return refConsultarPromociones;
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
	private static List<Handler> getChain() {
		if (null == chain ) {
			chain = new LinkedList<Handler>();
		}
		return chain;
	}
	
	
	private static Holder<ConsultarPromocionesResponse> getConsultarPromocionesResponse() {
		if (null == consultarPromocionesResponse ) {
			consultarPromocionesResponse = new Holder<ConsultarPromocionesResponse>();
		}
		return consultarPromocionesResponse;
	}
	
	private static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}
	
	
	private static List<PromocionResponseBean> getListPromocionResponseBean(){
		if (null == listPromocionResponseBean ) {
			listPromocionResponseBean = new ArrayList<PromocionResponseBean>();
		}
		return listPromocionResponseBean;
	}
	
	

}
