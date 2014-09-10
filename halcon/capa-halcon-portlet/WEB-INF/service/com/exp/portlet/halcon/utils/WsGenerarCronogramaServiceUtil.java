package com.exp.portlet.halcon.utils;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;
import javax.xml.ws.handler.Handler;

import com.ext.portlet.halcon.dto.CronogramaBean;
import com.ext.portlet.halcon.dto.CronogramaResponseBean;
import com.ext.portlet.halcon.dto.CuotaCabeceraResponseBean;
import com.ext.portlet.halcon.dto.CuotaCronogramaResponseBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ibk.ents.creditohipotecario.simuladorhpc.credito.v1.Credito;
import com.ibk.ents.creditohipotecario.simuladorhpc.cronograma.v1.Cronograma;
import com.ibk.ents.creditohipotecario.simuladorhpc.cronograma.v1.Cronograma.Cuotas;
import com.ibk.ents.creditohipotecario.simuladorhpc.cronogramacuota.v1.CronogramaCuota;
import com.ibk.ents.creditohipotecario.simuladorhpc.cronogramacuotascabecera.v1.CronogramaCuotasCabecera;
import com.ibk.ents.creditohipotecario.simuladorhpc.refgenerarcronograma.v1.RefGenerarCronograma;
import com.ibk.ents.soi.coreextensions.v2.UsernameToken;
import com.ibk.ents.soi.messageformat.v2.RequestHeader;
import com.ibk.ents.soi.messageformat.v2.ResponseHeader;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.enlace.v1.SimuladorHPC;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.enlace.v1.SimuladorHPC_Service;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.v1.GenerarCronograma;
import com.ibk.intf.financiacion.creditohipotecario.simuladorhpc.v1.GenerarCronogramaResponse;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sun.xml.internal.ws.client.BindingProviderProperties;

public class WsGenerarCronogramaServiceUtil {
	
	private static Log _log = LogFactoryUtil.getLog(WsGenerarCronogramaServiceUtil.class);
	
	private static SimuladorHPC_Service service = null;
	private static GenerarCronograma generarCronograma = null;
	private static RefGenerarCronograma refGenerarCronograma = null;
	private static RequestHeader requestHeader=null;
	private static UsernameToken userId=null;
	@SuppressWarnings("rawtypes")
	private static List<Handler>  chain;
	private static Holder<GenerarCronogramaResponse> generarCronogramaResponse;
	private static Holder<ResponseHeader> responseHeader;
	private static CronogramaResponseBean cronogramaResponseBean;
	private static CuotaCabeceraResponseBean cuotaCabeceraResponseBean;
	private static ArrayList<CuotaCronogramaResponseBean> listCuotaCronogramaResponseBeans;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("yyyyMMddHHmmss.SSSSS");
	
	public static CronogramaResponseBean realizarWsGenerarCronograma(Object cronogramaObject) throws BusinessException{
		
		getChain().clear();
		
		CronogramaBean cronogramaBean = (CronogramaBean) cronogramaObject;
		
		
		SimuladorHPC port = getTasaws().getSimuladorHPC();
		
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
		
		
		/*BODY*/
		
		getRefGenerarCronograma().setCodigoGrupo(cronogramaBean.getCodigoGrupo());
		
		//Aqui convertimos los codigos por otros, consideramos los cambios por parte del Usuario
		if(cronogramaBean.getCodigoProducto().intValue() == SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO || cronogramaBean.getCodigoProducto().intValue() == SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL){
			getRefGenerarCronograma().setCodigoProducto(BigInteger.valueOf(SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL));
		}else if (cronogramaBean.getCodigoProducto().intValue() == SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME){
			getRefGenerarCronograma().setCodigoProducto(BigInteger.valueOf(SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME));
		}else{
			getRefGenerarCronograma().setCodigoProducto(cronogramaBean.getCodigoProducto());
		}
		
		getRefGenerarCronograma().setCodigoMoneda(cronogramaBean.getCodigoMoneda());
		getRefGenerarCronograma().setValorBien(cronogramaBean.getValorBien());
		getRefGenerarCronograma().setMontoFinanciar(cronogramaBean.getMontoFinanciar());
		getRefGenerarCronograma().setCodigoTipoSeguroDesgravamen(cronogramaBean.getCodigoTipoSeguroDesgravamen());
		getRefGenerarCronograma().setCodigoTipoCuota(cronogramaBean.getCodigoTipoCuota());
		getRefGenerarCronograma().setPlazo(cronogramaBean.getPlazo());
		getRefGenerarCronograma().setPlazoGracia(cronogramaBean.getPlazoGracia());
		getRefGenerarCronograma().setTasaInteres(cronogramaBean.getTasaInteres());
		getRefGenerarCronograma().setCodigoAplicativo(cronogramaBean.getCodigoAplicativo());
		
		getGenerarCronograma().setRefGenerarCronograma(getRefGenerarCronograma());
		/*END BODY*/
		
		try {
			//limpiamos
			getListCuotaCronogramaResponseBeans().clear();
			
			port.generarCronograma(getGenerarCronograma(), getRequestHeader(), getGenerarCronogramaResponse(), getResponseHeader());
			
			GenerarCronogramaResponse response = getGenerarCronogramaResponse().value;
			
			Cronograma	cron=response.getCronogramaHPC();
			Credito credito= cron.getCreditos().getCredito().get(0);
			
			getCronogramaResponseBean().setDescripcionGrupo(credito.getDescripcionGrupo());
			getCronogramaResponseBean().setDescripcionMoneda(credito.getDescripcionMoneda());
			getCronogramaResponseBean().setDescripcionProducto(credito.getDescripcionProducto());
			getCronogramaResponseBean().setDescripcionTipoCuota(credito.getDescripcionTipoCuota());
			getCronogramaResponseBean().setMontoCuotaExtraOrdinaria(credito.getMontoCuotaExtraOrdinaria());
			getCronogramaResponseBean().setMontoCuotaOrdinaria(credito.getMontoCuotaOrdinaria());
			getCronogramaResponseBean().setMontoFinanciar(credito.getMontoFinanciar());
			getCronogramaResponseBean().setTasaComision(credito.getTasaComision());
			getCronogramaResponseBean().setTasaCostoEfectivo(credito.getTasaCostoEfectivo());
			getCronogramaResponseBean().setTasaInteres(credito.getTasaInteres());
			getCronogramaResponseBean().setTasaSeguroBien(credito.getTasaSeguroBien());
			getCronogramaResponseBean().setTasaSeguroDesgravamen(credito.getTasaSeguroDesgravamen());
			getCronogramaResponseBean().setValorBien(credito.getValorBien());
			getCronogramaResponseBean().setPlazo(credito.getPlazo());
			getCronogramaResponseBean().setPlazoGracia(credito.getPlazoGracia());
			
			
			
			CronogramaCuotasCabecera	cuotaCabecera=cron.getCuotaCabecera();

			getCuotaCabeceraResponseBean().setAmortizacion(cuotaCabecera.getAmortizacion());
			getCuotaCabeceraResponseBean().setComision(cuotaCabecera.getComision());
			getCuotaCabeceraResponseBean().setCuota(cuotaCabecera.getCuota());
			getCuotaCabeceraResponseBean().setInteres(cuotaCabecera.getInteres());
			getCuotaCabeceraResponseBean().setMontoPrestamo(cuotaCabecera.getMontoPrestamo());
			getCuotaCabeceraResponseBean().setPortes(cuotaCabecera.getPortes());
			getCuotaCabeceraResponseBean().setSeguroBien(cuotaCabecera.getSeguroBien());
			getCuotaCabeceraResponseBean().setSeguroDesgravamen(cuotaCabecera.getSeguroDesgravamen());
			getCuotaCabeceraResponseBean().setTasaCostoEfectivo(cuotaCabecera.getTasaCostoEfectivo());
			getCuotaCabeceraResponseBean().setFechaPrimerVencimiento(cuotaCabecera.getFechaPrimerVencimiento());
			getCronogramaResponseBean().setCuotaCabeceraResponseBean(getCuotaCabeceraResponseBean());
			
			Cuotas  cuotas=cron.getCuotas();

			
			for (CronogramaCuota cuotaCronogramaHPC : cuotas.getCuota()) {
				
				CuotaCronogramaResponseBean bean = new CuotaCronogramaResponseBean();
				bean.setAmortizacion(cuotaCronogramaHPC.getAmortizacion());
				bean.setComision(cuotaCronogramaHPC.getComision());
				bean.setCuota(cuotaCronogramaHPC.getCuota());
				bean.setInteres(cuotaCronogramaHPC.getInteres());
				bean.setPortes(cuotaCronogramaHPC.getPortes());
				bean.setSaldoAdeudado(cuotaCronogramaHPC.getSaldoAdeudado());
				bean.setSaldoDeuda(cuotaCronogramaHPC.getSaldoDeuda());
				bean.setSeguroBien(cuotaCronogramaHPC.getSeguroBien());
				bean.setSeguroDesgravamen(cuotaCronogramaHPC.getSeguroDesgravamen());
				bean.setCorrelativoCuota(cuotaCronogramaHPC.getCorrelativoCuota());
				bean.setDias(cuotaCronogramaHPC.getDias());
				bean.setFechaFin(cuotaCronogramaHPC.getFechaFin());
				bean.setFechaInicio(cuotaCronogramaHPC.getFechaInicio());
				bean.setFechaVencimiento(cuotaCronogramaHPC.getFechaVencimiento());
				bean.setFechaVencimientoInicial(cuotaCronogramaHPC.getFechaVencimientoInicial());
				bean.setNumeroCuota(cuotaCronogramaHPC.getNumeroCuota());
				
				getListCuotaCronogramaResponseBeans().add(bean);
			}
			getCronogramaResponseBean().setListCuotaCronogramaResponseBeans(getListCuotaCronogramaResponseBeans());
		} catch (Exception e) {
			cronogramaResponseBean = null;
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.auditoria.generar.cronograma.error") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.auditoria.generar.cronograma", "capa.halcon.auditoria.generar.cronograma.error") , e.toString());
		}
		return  getCronogramaResponseBean();
	}
	
	private static SimuladorHPC_Service getTasaws(){
		if (null == service) {
			service = new SimuladorHPC_Service();
		}
		return service;
	}
	
	
	private static  GenerarCronograma getGenerarCronograma() {
		if (null == generarCronograma ) {
			generarCronograma =new GenerarCronograma();
		}
		return generarCronograma;
	}
	
	private static RefGenerarCronograma getRefGenerarCronograma(){
		if (null == refGenerarCronograma ) {
			refGenerarCronograma =new RefGenerarCronograma();
		}
		return refGenerarCronograma;
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
	
	
	private static Holder<GenerarCronogramaResponse> getGenerarCronogramaResponse() {
		if (null == generarCronogramaResponse ) {
			generarCronogramaResponse = new Holder<GenerarCronogramaResponse>();
		}
		return generarCronogramaResponse;
	}
	
	private static Holder<ResponseHeader> getResponseHeader() {
		if (null == responseHeader ) {
			responseHeader = new Holder<ResponseHeader>();
		}
		return responseHeader;
	}
	
	public static CronogramaResponseBean getCronogramaResponseBean() {
		if (cronogramaResponseBean == null) {
			cronogramaResponseBean = new CronogramaResponseBean();
		}
		return cronogramaResponseBean;
	}
	
	public static CuotaCabeceraResponseBean getCuotaCabeceraResponseBean() {
		if (cuotaCabeceraResponseBean == null) {
			cuotaCabeceraResponseBean = new CuotaCabeceraResponseBean();
		}
		return cuotaCabeceraResponseBean;
	}
	
	public static ArrayList<CuotaCronogramaResponseBean> getListCuotaCronogramaResponseBeans() {
		if (listCuotaCronogramaResponseBeans == null) {
			listCuotaCronogramaResponseBeans = new ArrayList<CuotaCronogramaResponseBean>();
		}
		return listCuotaCronogramaResponseBeans;
	}
	

}
