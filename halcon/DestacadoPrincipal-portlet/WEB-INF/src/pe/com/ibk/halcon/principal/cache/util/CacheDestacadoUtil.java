package pe.com.ibk.halcon.principal.cache.util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

@Service
public class CacheDestacadoUtil {

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(CacheDestacadoUtil.class);
	ConcurrentHashMap<String, RangoBean> hashRango;
	ConcurrentHashMap<String, String> hashValor;
	ConcurrentHashMap<String, String> hashSiebelEtiqueta;

	public RangoBean getRango(String valor) {
		try {
			hashRango = (ConcurrentHashMap<String, RangoBean>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","hashRango");

			if (hashRango == null) {

				hashRango = new ConcurrentHashMap<String, RangoBean>();
				List<Parametro> listaRango;
				try {
					listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
					for (Parametro param : listaRango) {
						hashRango.put(param.getDato3(), new RangoBean(param.getDato3(),param.getValorMonto1(), param.getValorMonto2(), param.getValorMonto3()));
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","hashRango", hashRango);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hashRango.get(valor);
		
	}

	
	@SuppressWarnings("unchecked")
	public Object getValor(String valor) {

		hashValor = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","hashValor");
		if (hashValor == null) {
			_log.info("*** entro en getValor null*****");

			hashValor  = new ConcurrentHashMap<String, String>();
			List<Parametro> listaValor;
			try {
				listaValor = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_VALOR);
				for (Parametro param : listaValor) {
					hashValor.put(param.getDato3(), param.getDato1());
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","hashValor", hashValor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hashValor.get(valor);
	}
	
	public String getSiebelEtiqueta(String siebel) throws IOException{
			
			hashSiebelEtiqueta = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","hashSiebelEtiqueta");
			if (hashSiebelEtiqueta == null) {
				_log.info("*** entro en getEtiquetaSiebel null*****");
				hashSiebelEtiqueta = new ConcurrentHashMap<String, String>();
				List<Parametro> listaRango;
				try {
					listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
					for (Parametro param : listaRango) {
						if(Validator.isNotNull(param.getValorMonto1())){
							hashSiebelEtiqueta.put(param.getValorMonto1(), param.getDato3());
						}
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","hashSiebelEtiqueta", hashSiebelEtiqueta);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else{
				_log.info("***Resultado getSiebelEtiqueta**:" + siebel +" valor:"+ (hashSiebelEtiqueta.get(siebel)));
			}
			
			return hashSiebelEtiqueta.get(siebel);
	}
	
	// Acceso a BD
//	List<Parametro> parametrosWS;
	List<Parametro> parametrosPrioridadPersona;
	List<Parametro> parametrosDefectoPersona;
	List<Parametro> parametrosDefectoInstitucional;
	List<Parametro> parametrosDefectoCorporativo;
	List<Parametro> parametrosDefectoPequeniaEmpresa;
	List<Parametro> parametrosDefectoEmpresa;
	

	
	public List<Parametro> getProductobyBanca(boolean esWS,String banca){
		
		if(esWS){
			parametrosPrioridadPersona = (List<Parametro>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosPrioridadPersona");
			if (parametrosPrioridadPersona == null) {
				_log.info("*** entro en parametrosPrioridadPersona null*****");
				try {
					parametrosPrioridadPersona = ParametroLocalServiceUtil.obtenerParametrosHijos(JSonUtil.PRODUCTO_PRIORIDAD_DESTACADO_PRINCIPAL_PERSONA);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosPrioridadPersona", parametrosPrioridadPersona);
			}
			return parametrosPrioridadPersona;
		}else{
			if(banca.equalsIgnoreCase("BP")){
				parametrosDefectoPersona = (List<Parametro>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoPersona");
				if (parametrosDefectoPersona == null) {
					_log.info("*** entro en parametrosDefectoPersona null*****");
					try {
						parametrosDefectoPersona = ParametroLocalServiceUtil.obtenerParametrosHijos(JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PERSONA);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoPersona", parametrosDefectoPersona);
				} 
				return parametrosDefectoPersona;
			}else if(banca.equalsIgnoreCase("BI")){
				parametrosDefectoInstitucional = (List<Parametro>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoInstitucional");
				if (parametrosDefectoInstitucional == null) {
					_log.info("*** entro en parametrosDefectoInstitucional null*****");
					try {
						parametrosDefectoInstitucional = ParametroLocalServiceUtil.obtenerParametrosHijos(JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_INSTITUCIONAL);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoInstitucional", parametrosDefectoInstitucional);
				}
				return parametrosDefectoInstitucional;
			}else if(banca.equalsIgnoreCase("BC")){
				parametrosDefectoCorporativo = (List<Parametro>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoCorporativo");
				if (parametrosDefectoCorporativo == null) {
					_log.info("*** entro en parametrosDefectoCorporativo null*****");
					try {
						parametrosDefectoCorporativo = ParametroLocalServiceUtil.obtenerParametrosHijos(JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_CORPORATIVO);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoCorporativo", parametrosDefectoCorporativo);
				}
				return parametrosDefectoCorporativo;
			}else if(banca.equalsIgnoreCase("BPE")){
				parametrosDefectoPequeniaEmpresa = (List<Parametro>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoPequeniaEmpresa");
				if (parametrosDefectoPequeniaEmpresa == null) {
					_log.info("*** entro en parametrosDefectoPequeniaEmpresa null*****");
					try {
						parametrosDefectoPequeniaEmpresa = ParametroLocalServiceUtil.obtenerParametrosHijos(JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PEQUENIA_EMPRESA);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoPequeniaEmpresa", parametrosDefectoPequeniaEmpresa);
				} 
				return parametrosDefectoPequeniaEmpresa;
			}else if(banca.equalsIgnoreCase("BE")){
				parametrosDefectoEmpresa = (List<Parametro>) MultiVMPoolUtil.get("pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoEmpresa");
				if (parametrosDefectoInstitucional == null) {
					_log.info("*** entro en parametrosDefectoInstitucional null*****");
					try {
						parametrosDefectoEmpresa = ParametroLocalServiceUtil.obtenerParametrosHijos(JSonUtil.PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_EMPRESA);
					} catch (BusinessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.principal.cache.util.CacheDestacadoUtil","parametrosDefectoEmpresa", parametrosDefectoEmpresa);
				} 
				return parametrosDefectoEmpresa;
			} else {
				return null;
			}
		}
	}

}