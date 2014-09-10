package com.exp.portlet.halcon.utils;

import java.math.BigInteger;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ext.portlet.halcon.dto.SolicitudProductoBean;
import com.ext.portlet.halcon.dto.SolicitudProductoResponseBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ibk.ents.riesgos.credito.precalificacionhalcon.calificacionriesgo.v1.CalificacionRiesgo;
import com.ibk.ents.riesgos.credito.precalificacionhalcon.refconsultarcalificacionriesgo.v1.RefConsultarCalificacionRiesgo;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.riesgos.credito.precalificacionhalcon.enlace.v1.PreCalificacionHalcon;
import com.ibk.intf.riesgos.credito.precalificacionhalcon.enlace.v1.PreCalificacionHalcon_Service;
import com.ibk.intf.riesgos.credito.precalificacionhalcon.v1.ConsultarCalificacionRiesgo;
import com.ibk.intf.riesgos.credito.precalificacionhalcon.v1.ConsultarCalificacionRiesgoResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

public class WsPrecalificacionServiceUtil {

	private static Log _log = LogFactoryUtil.getLog(WsPrecalificacionServiceUtil.class);
	
	private static  PreCalificacionHalcon_Service service = null;
	private static ConsultarCalificacionRiesgo consultarCalificacionRiesgo= null;
	private static RefConsultarCalificacionRiesgo refConsultarCalificacionRiesgo = null;
	private static RequestHeader requestHeader=null;
	private static UsernameToken userId=null;
	@SuppressWarnings("rawtypes")
	private static List<Handler>  chain;
	private static Holder<ConsultarCalificacionRiesgoResponse> consultarCalificacionRiesgoResponse;// = new Holder<ConsultarCalificacionRiesgoResponse>();
	private static Holder<ResponseHeader> responseHeader;
	private static SolicitudProductoResponseBean productoResponseBean;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");
		
	public static SolicitudProductoResponseBean realizarWsPrecalificacion(SolicitudProductoBean productoBean) throws BusinessException {
		getChain().clear();
//		SolicitudProductoBean productoBean = (SolicitudProductoBean) productoBeanObject;
		PreCalificacionHalcon port = getPrecalws().getPreCalificacionHalcon();
		
		BindingProvider bindingProvider = (BindingProvider) port;
//		List<Handler>  chain = new LinkedList<Handler>();
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
		getRefConsultarCalificacionRiesgo().setTipoCredito(BigInteger.valueOf(productoBean.getTipoCredito()));
		getRefConsultarCalificacionRiesgo().setTipoDocumento( BigInteger.valueOf(productoBean.getIdTipoDocumentoAqd()));
		getRefConsultarCalificacionRiesgo().setNumeroDocumento(productoBean.getNumeroDocumento());
		getRefConsultarCalificacionRiesgo().setCodigoSituacionLaboral( BigInteger.valueOf(Integer.valueOf(productoBean.getIdSituacionLaboral())));
		getRefConsultarCalificacionRiesgo().setNumeroRUC(productoBean.getRuc());
		getRefConsultarCalificacionRiesgo().setCodigoEstadoCivil(BigInteger.valueOf(Integer.valueOf(productoBean.getIdEstadoCivilAdq())));
		getRefConsultarCalificacionRiesgo().setRentaBruta(Double.valueOf(productoBean.getRentaMensual()));
		
		getConsultarCalificacionRiesgo().setRefConsultarCalificacionRiesgo(getRefConsultarCalificacionRiesgo());

	
		try {
			port.consultarCalificacionRiesgo(consultarCalificacionRiesgo, requestHeader, getConsultarCalificacionRiesgoResponse(), getResponseHeader());
			
			ConsultarCalificacionRiesgoResponse response = getConsultarCalificacionRiesgoResponse().value;
			CalificacionRiesgo calificacion=response.getCalificacionRiesgo();
			
			if (ValidatorUtils.isNull(calificacion) || ValidatorUtils.isNull(calificacion.getCalificacion())) {
				getProductoResponseBean().setCalificacion(BigInteger.valueOf(3));
				getProductoResponseBean().setCodigoAtencion(calificacion.getCodigoAtencion());
			}else{
				getProductoResponseBean().setCalificacion(calificacion.getCalificacion());
				getProductoResponseBean().setCodigoAtencion(calificacion.getCodigoAtencion());
			}
			
		}catch (Exception e) {
			if (e instanceof SocketTimeoutException) {
				getProductoResponseBean().setCalificacion(BigInteger.valueOf(3));
			}else {
				_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.ws.precalificacion.service.util.consultar.precalificacion") + e.toString());
				throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.ws.precalificacion.service.util.consultar.precalificacion.ubicacion", "capa.halcon.ws.precalificacion.service.util.consultar.precalificacion") , e.toString());
			}
		}
		return getProductoResponseBean();
		
	}
	
	private  static PreCalificacionHalcon_Service getPrecalws() {
		if (null == service ) {
			service = new PreCalificacionHalcon_Service();
		}
		return service;
	}
	
	private  static ConsultarCalificacionRiesgo getConsultarCalificacionRiesgo() {
		if (null == consultarCalificacionRiesgo ) {
			consultarCalificacionRiesgo =new ConsultarCalificacionRiesgo();
		}
		return consultarCalificacionRiesgo;
	}

	

	private  static RefConsultarCalificacionRiesgo getRefConsultarCalificacionRiesgo() {
		if (null == refConsultarCalificacionRiesgo ) {
			refConsultarCalificacionRiesgo = new RefConsultarCalificacionRiesgo();
		}
		return refConsultarCalificacionRiesgo;
	}
	
	private static  RequestHeader getRequestHeader() {
		if (null == requestHeader ) {
			requestHeader = new RequestHeader();
		}
		return requestHeader;
	}
	private  static UsernameToken getUserId() {
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

	private static Holder<ConsultarCalificacionRiesgoResponse> getConsultarCalificacionRiesgoResponse() {
		if (null == consultarCalificacionRiesgoResponse ) {
			consultarCalificacionRiesgoResponse = new Holder<ConsultarCalificacionRiesgoResponse>();
		}
		return consultarCalificacionRiesgoResponse;
	}

	private static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}

	private static SolicitudProductoResponseBean getProductoResponseBean() {
		if (null == productoResponseBean ) {
			productoResponseBean = new SolicitudProductoResponseBean();
		}
		return productoResponseBean;
	}
	
	
	
}
