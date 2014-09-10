package pe.com.ibk.halcon.solicitudes.cache.util;

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
public class CacheSolicitudesUtil {

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(CacheSolicitudesUtil.class);
	ConcurrentHashMap<String, RangoBean> hashRango;
	ConcurrentHashMap<String, String> hashValor;
	ConcurrentHashMap<String, String> hashSiebelEtiqueta;
	ConcurrentHashMap<String, String> hashSiebel;

	public RangoBean getRango(String valor) {
		try {
			hashRango = (ConcurrentHashMap<String, RangoBean>) MultiVMPoolUtil.get("pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashRango");

			if (hashRango == null) {

				hashRango = new ConcurrentHashMap<String, RangoBean>();
				List<Parametro> listaRango;
				try {
					listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
					for (Parametro param : listaRango) {
						hashRango.put(param.getDato3(), new RangoBean(param.getDato3(),param.getValorMonto1(), param.getValorMonto2(), param.getValorMonto3()));
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashRango", hashRango);
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

		hashValor = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashValor");
		if (hashValor == null) {
			_log.info("*** entro en getValor null*****");

			hashValor  = new ConcurrentHashMap<String, String>();
			List<Parametro> listaValor;
			try {
				listaValor = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_VALOR);
				for (Parametro param : listaValor) {
					hashValor.put(param.getDato3(), param.getDato1());
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashValor", hashValor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hashValor.get(valor);
	}
	
	public String getSiebelEtiqueta(String siebel) throws IOException{
			
			hashSiebelEtiqueta = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashSiebelEtiqueta");
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
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashSiebelEtiqueta", hashSiebelEtiqueta);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else{
				_log.info("***Resultado getSiebelEtiqueta**:" + siebel +" valor:"+ (hashSiebelEtiqueta.get(siebel)));
			}
			
			return hashSiebelEtiqueta.get(siebel);
	}
	
	public String getSiebel(String etiqueta) throws IOException{
		
		hashSiebel = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashSiebelEtiqueta");
		if (hashSiebel == null) {
			hashSiebel = new ConcurrentHashMap<String, String>();
			List<Parametro> listaRango;
			try {
				listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
				for (Parametro param : listaRango) {
					if(Validator.isNotNull( param.getDato3())){
						hashSiebel.put( param.getDato3(), param.getValorMonto1());
					}
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashSiebelEtiqueta", hashSiebel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 		
		
		return hashSiebel.get(etiqueta);
}
	
	// Acceso a BD
	List<Parametro> parametrosPrioridadPersona;
	List<Parametro> parametrosDefectoPersona;
	List<Parametro> parametrosDefectoInstitucional;
	List<Parametro> parametrosDefectoCorporativo;
	List<Parametro> parametrosDefectoPequeniaEmpresa;
	List<Parametro> parametrosDefectoEmpresa;
	
}