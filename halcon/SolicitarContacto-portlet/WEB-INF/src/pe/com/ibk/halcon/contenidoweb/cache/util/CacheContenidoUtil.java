package pe.com.ibk.halcon.contenidoweb.cache.util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

@Service
public class CacheContenidoUtil {

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(CacheContenidoUtil.class);
	ConcurrentHashMap<String, RangoBean> hashRango;
	ConcurrentHashMap<String, String> hashValor;
	ConcurrentHashMap<String, String> hashSiebelEtiqueta;

	public RangoBean getRango(String valor) {
		try {
			hashRango = (ConcurrentHashMap<String, RangoBean>) MultiVMPoolUtil.get("pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil","hashRango");

			if (hashRango == null) {

				hashRango = new ConcurrentHashMap<String, RangoBean>();
				List<Parametro> listaRango;
				try {
					listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
					for (Parametro param : listaRango) {
						hashRango.put(param.getDato3(), new RangoBean(param.getDato3(),param.getValorMonto1(), param.getValorMonto2(), param.getValorMonto3()));
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil","hashRango", hashRango);
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

		hashValor = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil","hashValor");
		if (hashValor == null) {
			_log.info("*** entro en getValor null*****");

			hashValor  = new ConcurrentHashMap<String, String>();
			List<Parametro> listaValor;
			try {
				listaValor = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_VALOR);
				for (Parametro param : listaValor) {
					hashValor.put(param.getDato3(), param.getDato1());
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil","hashValor", hashValor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hashValor.get(valor);
	}
	
	public String getSiebelEtiqueta(String siebel) throws IOException{
			
			hashSiebelEtiqueta = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil","hashSiebelEtiqueta");
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
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.contenidoweb.cache.util.CacheContenidoUtil","hashSiebelEtiqueta", hashSiebelEtiqueta);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else{
				_log.info("***Resultado getSiebelEtiqueta**:" + siebel +" valor:"+ (hashSiebelEtiqueta.get(siebel)));
			}
			
			return hashSiebelEtiqueta.get(siebel);
	}
	

}