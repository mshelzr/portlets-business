package com.exp.portlet.halcon.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ext.portlet.halcon.dto.CampaniaBean;
import com.ext.portlet.halcon.dto.CampaniaRequestBean;
import com.ext.portlet.halcon.dto.CampaniaResponseBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ibk.ents.informacioneventos.contactosvisitas.campanias.campania.v1.Campania;
import com.ibk.ents.informacioneventos.contactosvisitas.campanias.refconsultarcampanias.v1.RefConsultarCampanias;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.informacioneventos.contactosvisitas.campanias.enlace.v1.Campanias;
import com.ibk.intf.informacioneventos.contactosvisitas.campanias.enlace.v1.Campanias_Service;
import com.ibk.intf.informacioneventos.contactosvisitas.campanias.v1.ConsultarCampanias;
import com.ibk.intf.informacioneventos.contactosvisitas.campanias.v1.ConsultarCampaniasResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

@SuppressWarnings("rawtypes")
public class WsCampaniasServiceUtil {
	private static Log _log = LogFactoryUtil.getLog(WsPrecalificacionServiceUtil.class);

	private static  Campanias_Service service = null;
	
	private static RefConsultarCampanias refConsultarCampanias = null;
	private static ConsultarCampanias consultarCampanias = null;
	private static RequestHeader requestHeader = null;
	private static UsernameToken userId = null;
	private static List<Handler>  chain;
	
	
	private static Holder<ConsultarCampaniasResponse> consultarCampaniasResponse;// = new Holder<ConsultarCalificacionRiesgoResponse>();
	private static Holder<ResponseHeader> responseHeader;
	private static CampaniaResponseBean campaniaResponseBean;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");
	
	public static CampaniaResponseBean consultarCampania(CampaniaRequestBean campaniaRequestBean) throws BusinessException{
	
		Campanias port = getCampaniaws().getCampanias();
		BindingProvider bindingProvider = (BindingProvider) port;

		getChain().clear();
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
		
		getRefConsultarCampanias().setTipoDocumento(campaniaRequestBean.getTipoDocumento());
		getRefConsultarCampanias().setNumeroDocumento(campaniaRequestBean.getNumeroDocumento());
		getRefConsultarCampanias().setCodigoCanal(campaniaRequestBean.getCodigoCanal());
		getRefConsultarCampanias().setCodigoProducto(campaniaRequestBean.getCodigoProducto());
		if (ValidatorUtils.isNotNull(campaniaRequestBean.getCodigoGrupoProducto())) {
			getRefConsultarCampanias().setCodigoGrupoProducto(campaniaRequestBean.getCodigoGrupoProducto());
		}
		/*if (ValidatorUtils.isNotNull(campaniaRequestBean.getCodigoProducto())) {
			getRefConsultarCampanias().setCodigoProducto(campaniaRequestBean.getCodigoProducto());
		}		
		*/	
		getConsultarCampanias().setRefConsultarCampanias(getRefConsultarCampanias());
		try {
			port.consultarCampanias(getConsultarCampanias(), getRequestHeader(), getConsultarCampaniasResponse(), getResponseHeader());
			ConsultarCampaniasResponse consultarCampaniasResponse = getConsultarCampaniasResponse().value;
			ConsultarCampaniasResponse.Campanias  campanias = consultarCampaniasResponse.getCampanias();
			
			getCampaniaResponseBean().getCampanias().clear();
			for (Campania campania : campanias.getCampania()) {
				CampaniaBean cb = new CampaniaBean();
				cb.setCodigoLineaProducto(campania.getCodigoLineaProducto());
				cb.setCodigoProducto(campania.getCodigoProducto());
				cb.setDescripcionProducto(campania.getDescripcionProducto());
				cb.setPrioridad(campania.getPrioridad());
				cb.setCodigoCampania(campania.getCodigoCampania());
				cb.setTipoCampania(campania.getTipoCampania());
				cb.setTasa1(campania.getTasa1());
				cb.setTasa2(campania.getTasa2());
				cb.setDescripcionCampania(campania.getDescripcionCampania());
				cb.setOfertaCampania(campania.getOfertaCampania());
				cb.setFechaInicio(campania.getFechaInicio());
				cb.setFechaFin(campania.getFechaFin());
				
				getCampaniaResponseBean().getCampanias().add(cb);
			}
		} 
		catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.ws.campanias.service.util.consultar.campania") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.ws.campanias.service.util.consultar.campania.ubicacion", "capa.halcon.ws.campanias.service.util.consultar.campania") , e.toString());
		}
		return getCampaniaResponseBean();
	}
	
	private static CampaniaResponseBean getCampaniaResponseBean(){
		
		if (null == campaniaResponseBean ) {
			campaniaResponseBean = new CampaniaResponseBean();
		}
		return campaniaResponseBean;
	}
	
	
	private static Holder<ConsultarCampaniasResponse> getConsultarCampaniasResponse() {
		if (null == consultarCampaniasResponse ) {
			consultarCampaniasResponse = new Holder<ConsultarCampaniasResponse>();
		}
		return consultarCampaniasResponse;
	}
	
	private static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}
	

	
	public static Campanias_Service getCampaniaws() {
		if (null == service) {
			service = new Campanias_Service();
		}
		return service;
	}

	public static ConsultarCampanias getConsultarCampanias() {
		if (null == consultarCampanias) {
			consultarCampanias = new ConsultarCampanias();
		}
		return consultarCampanias;
	}

	public static RefConsultarCampanias getRefConsultarCampanias() {
		if (null == refConsultarCampanias) {
			refConsultarCampanias = new RefConsultarCampanias();
		}
		return refConsultarCampanias;
	}

	public static RequestHeader getRequestHeader() {
		if (null == requestHeader) {
			requestHeader = new RequestHeader();
		}
		return requestHeader;
	}

	public static UsernameToken getUserId() {
		if (null == userId) {
			userId = new UsernameToken();
		}
		return userId;
	}
	
	private static List<Handler> getChain() {
		if (null == chain ) {
			chain = new LinkedList<Handler>();
		}
		return chain;
	}
	
}
