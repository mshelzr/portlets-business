package com.exp.portlet.halcon.utils;


import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ext.portlet.halcon.dto.ProductoComplementarioBean;
import com.ext.portlet.halcon.dto.SolicitudProductoBean;
import com.ext.portlet.halcon.dto.SolicitudProductoResponseBean;
import com.ext.portlet.halcon.dto.TelefonoLeadBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ibk.ents.informacioneventos.transacciones.solicitudlead.refguardarsolicitud.v1.RefGuardarSolicitud;
import com.ibk.ents.informacioneventos.transacciones.solicitudlead.refguardarsolicitud.v1.RefGuardarSolicitud.Productos;
import com.ibk.ents.informacioneventos.transacciones.solicitudlead.refguardarsolicitud.v1.RefGuardarSolicitud.Productos.Producto;
import com.ibk.ents.informacioneventos.transacciones.solicitudlead.refguardarsolicitud.v1.RefGuardarSolicitud.Telefonos;
import com.ibk.ents.informacioneventos.transacciones.solicitudlead.refguardarsolicitud.v1.RefGuardarSolicitud.Telefonos.Telefono;
import com.ibk.ents.informacioneventos.transacciones.solicitudlead.solicitud.v1.Solicitud;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.informacioneventos.transacciones.solicitudlead.enlace.v1.SolicitudLead;
import com.ibk.intf.informacioneventos.transacciones.solicitudlead.enlace.v1.SolicitudLead_Service;
import com.ibk.intf.informacioneventos.transacciones.solicitudlead.v1.GuardarSolicitud;
import com.ibk.intf.informacioneventos.transacciones.solicitudlead.v1.GuardarSolicitudResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

public class WsRegistroLeadsServiceUtil {

	private static Log _log = LogFactoryUtil.getLog(WsRegistroLeadsServiceUtil.class);
	
	private static SolicitudLead_Service service = null;
	private static RequestHeader requestHeader=null;
	private static UsernameToken userId=null;
	private static Holder<ResponseHeader> responseHeader;
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");
	
	
	public static SolicitudProductoResponseBean registroLeads(Object productoBeanObject) throws BusinessException {
		RefGuardarSolicitud refGuardarSolicitud = new RefGuardarSolicitud();;
		SolicitudProductoResponseBean productoResponseBean = new SolicitudProductoResponseBean();
		List<Handler> chain = new ArrayList<Handler>();
		Holder<GuardarSolicitudResponse> guardarSolicitudResponse = new Holder<GuardarSolicitudResponse>();
		GuardarSolicitud guardarSolicitud= new GuardarSolicitud();
		
		
		SolicitudProductoBean productoBean = (SolicitudProductoBean) productoBeanObject;

		SolicitudLead port = getService().getSolicitudLead();

		BindingProvider bindingProvider = (BindingProvider) port;
		
		
		chain.add(new SOAPLoggingHandlerUtil());
		bindingProvider.getBinding().setHandlerChain(chain);
		bindingProvider.getRequestContext().put(BindingProviderProperties.REQUEST_TIMEOUT,Propiedades.getResourceBundle("ws.request.timeout"));
		bindingProvider.getRequestContext().put(BindingProviderProperties.CONNECT_TIMEOUT,Propiedades.getResourceBundle("ws.connect.timeout"));
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,Propiedades.getResourceBundle("ip.web.service.ibk"));


		refGuardarSolicitud.setTipoDocumento(productoBean.getIdTipoDocumento());//
		refGuardarSolicitud.setNumeroDocumento(productoBean.getNumeroDocumento());//
		refGuardarSolicitud.setPrimerNombre(productoBean.getPrimerNombre().toUpperCase());//
		if (!productoBean.getSegundoNombre().isEmpty()) {
			refGuardarSolicitud.setSegundoNombre(productoBean.getSegundoNombre().toUpperCase());//
		}
		
		refGuardarSolicitud.setApellidoPaterno(productoBean.getApellidoPaterno().toUpperCase());//
		if (!productoBean.getApellidoMaterno().isEmpty()) {
			refGuardarSolicitud.setApellidoMaterno(productoBean.getApellidoMaterno().toUpperCase());//
		}
		refGuardarSolicitud.setSexo(productoBean.getTipoSexo());//
		if (!productoBean.getIdEstadoCivil().isEmpty()) {
			refGuardarSolicitud.setEstadoCivil(productoBean.getIdEstadoCivil());//
		}
		
		Date fecha = TiempoUtil.getFechaStringDateSlash(productoBean.getFechaNacimiento());//
		try {
			
			XMLGregorianCalendar fechaNacimiento = DatatypeFactory.newInstance().newXMLGregorianCalendar();
			
			fechaNacimiento.setDay(TiempoUtil.getDia(fecha));
			fechaNacimiento.setMonth(TiempoUtil.getMes(fecha));
			fechaNacimiento.setYear(TiempoUtil.getAno(fecha));
			
			refGuardarSolicitud.setFechaNacimiento(fechaNacimiento);
		} catch (Exception e) {
			_log.info(e);
			e.printStackTrace();
		}
		
		
		refGuardarSolicitud.setCodigoDepartamento(productoBean.getIdDepartamento());
		
		if (!productoBean.getIdProvincia().isEmpty()) {
			refGuardarSolicitud.setCodigoProvincia(productoBean.getIdProvincia());
		}
		if (!productoBean.getIdDistrito().isEmpty()) {
			refGuardarSolicitud.setCodigoDistrito(productoBean.getIdDistrito());
		}
		
		Telefonos telefonos = new Telefonos();
		Telefono telefono;
		for (TelefonoLeadBean telefonoLeadBean : productoBean.getTelefonoLeads()) {
			telefono = new Telefono();
			telefono.setTipoTelefono(telefonoLeadBean.getTipoTelefono());
			telefono.setNumeroTelefono(telefonoLeadBean.getNumeroTelefono());
			if (ValidatorUtils.isNotNull(telefonoLeadBean.getAnexo())) {
				telefono.setAnexoTelefono(telefonoLeadBean.getAnexo());
			}
			telefonos.getTelefono().add(telefono);
		}
		refGuardarSolicitud.setTelefonos(telefonos);
		
		refGuardarSolicitud.setCodigoCanal(String.valueOf(SimuladoresUtil.CODIGO_CANAL));
		productoBean.setCodigoCanal(String.valueOf(SimuladoresUtil.CODIGO_CANAL));
		refGuardarSolicitud.setEmail(productoBean.getEmail());
		refGuardarSolicitud.setRuc(productoBean.getRuc());
		if (!productoBean.getRazonSocial().isEmpty()) {
			refGuardarSolicitud.setRazonSocial(productoBean.getRazonSocial());
		}
		//Para el caso de Fondos mutuos 
		if(productoBean.getIndicadorMailing().equals(4)){
			refGuardarSolicitud.setTipoEnvio(BigInteger.valueOf(Long.valueOf(Propiedades.getResourceBundle("tipo.envio.lead.fondosmutuos"))));
			productoBean.setTipoEnvio(Integer.valueOf(Propiedades.getResourceBundle("tipo.envio.lead.fondosmutuos")));
		} else {
			refGuardarSolicitud.setTipoEnvio(BigInteger.valueOf(Long.valueOf(Propiedades.getResourceBundle("tipo.envio.lead"))));
			productoBean.setTipoEnvio(Integer.valueOf(Propiedades.getResourceBundle("tipo.envio.lead")));
		}
		
		refGuardarSolicitud.setCodigoCampania(productoBean.getCodigoCampana());//DATO EN DURO
		refGuardarSolicitud.setCodigoMoneda(productoBean.getCodigoMoneda());//DATO EN DURO
		if (Validator.isNotNull(productoBean.getMontoProspectado())) {
			refGuardarSolicitud.setMontoProspectado(Double.valueOf(productoBean.getMontoProspectado()));//DATO EN DURO
		}
		
		if (Validator.isNotNull(productoBean.getResponsableAsignacion()) && !productoBean.getResponsableAsignacion().isEmpty()) {
		refGuardarSolicitud.setResponsable(productoBean.getResponsableAsignacion());
		}
		
		
		//refGuardarSolicitud.setResponsable("S17860");
		
		Productos productos = new Productos();
		Producto producto;
		for (ProductoComplementarioBean beanProducto : productoBean.getProductoComplementarios()) {
			producto = new Producto();
			producto.setPrincipalidad(beanProducto.getPrincipalidad());
			producto.setCodigoGrupoProducto(beanProducto.getIdGrupoProducto());
			producto.setCodigoProducto(beanProducto.getIdProducto());
			producto.setDescripcionProducto(beanProducto.getProducto());
			
			if (Validator.isNotNull(beanProducto.getEmailSupervisor()) && !beanProducto.getEmailSupervisor().isEmpty()) {
			producto.setEmailResponsable(beanProducto.getEmailSupervisor());
			}
			
			//producto.setEmailResponsable("otrillo@proveedor.intercorp.com.pe");
			productos.getProducto().add(producto);
		}

		
		
		refGuardarSolicitud.setProductos(productos);

		guardarSolicitud.setRefGuardarSolicitud(refGuardarSolicitud);

		/*HEADER*/
		getRequestHeader().setMessageId(formato.format(new Date()));
		getRequestHeader().setSystemId(Propiedades.getResourceBundle("systemId"));
		
		getUserId().setUserName(Propiedades.getResourceBundle("userName"));
		getRequestHeader().setUserId(getUserId());
		/*END HEADER*/
		
		GuardarSolicitudResponse response;
		Solicitud solicitud = null;
		
		try {
			port.guardarSolicitud(guardarSolicitud, getRequestHeader(), guardarSolicitudResponse, getResponseHeader());

			response = guardarSolicitudResponse.value;
			solicitud= response.getSolicitud();
			
			productoResponseBean.setCodigoOportunidad(solicitud.getCodigoOportunidad());
			
			if (solicitud.getCodigoOportunidad() == null) {
				throw new Exception();
			}
			
			refGuardarSolicitud = null;
		} catch (Exception e) {
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.ws.registrolead.service.util.consultar.lead") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.ws.registrolead.service.util.consultar.lead.ubicacion", "capa.halcon.ws.registrolead.service.util.consultar.lead") , e.toString());
		}
		
		return productoResponseBean;

	}
	
	private static SolicitudLead_Service getService() {
		if (null == service ) {
			service = new SolicitudLead_Service();
		}
		return service;
	}




	private static UsernameToken getUserId() {
		if (null == userId ) {
			userId = new UsernameToken();
		}
		return userId;
	}
	

	private static RequestHeader getRequestHeader() {
		if (null == requestHeader ) {
			requestHeader = new RequestHeader();
		}
		return requestHeader;
	}
	
	public static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}

	
	
}