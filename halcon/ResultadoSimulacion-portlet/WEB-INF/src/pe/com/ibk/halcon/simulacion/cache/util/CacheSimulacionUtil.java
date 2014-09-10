package pe.com.ibk.halcon.simulacion.cache.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.simulacion.utils.ResultadoSimulacionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.ext.portlet.halcon.dto.PlazoBean;
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

@Service
public class CacheSimulacionUtil {

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(CacheSimulacionUtil.class);
	ConcurrentHashMap<String, RangoBean> hashRango;
	ConcurrentHashMap<String, String> hashValor;
	ConcurrentHashMap<String, String> hashSiebelEtiqueta;
	ConcurrentHashMap<Integer, List<PlazoBean> > hashListaPlazo;

	public RangoBean getRango(String valor) {
		try {
			hashRango = (ConcurrentHashMap<String, RangoBean>) MultiVMPoolUtil.get("pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashRango");

			if (hashRango == null) {

				hashRango = new ConcurrentHashMap<String, RangoBean>();
				List<Parametro> listaRango;
				try {
					listaRango = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_RANGO);
					for (Parametro param : listaRango) {
						hashRango.put(param.getDato3(), new RangoBean(param.getDato3(),param.getValorMonto1(), param.getValorMonto2(), param.getValorMonto3()));
					}
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashRango", hashRango);
				} catch (Exception e) {
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

		hashValor = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashValor");
		if (hashValor == null) {
			_log.info("*** entro en getValor null*****");

			hashValor  = new ConcurrentHashMap<String, String>();
			List<Parametro> listaValor;
			try {
				listaValor = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_VALOR);
				for (Parametro param : listaValor) {
					hashValor.put(param.getDato3(), param.getDato1());
				}
				MultiVMPoolUtil.put( "pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashValor", hashValor);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return hashValor.get(valor);
	}
	
	public String getSiebelEtiqueta(String siebel) throws IOException{
			
			hashSiebelEtiqueta = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashSiebelEtiqueta");
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
					MultiVMPoolUtil.put( "pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashSiebelEtiqueta", hashSiebelEtiqueta);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else{
				_log.info("***Resultado getSiebelEtiqueta**:" + siebel +" valor:"+ (hashSiebelEtiqueta.get(siebel)));
			}
			
			return hashSiebelEtiqueta.get(siebel);
	}
	
	public List<PlazoBean> getListPlazo(Integer idParametroPadre) throws BusinessException{
		hashListaPlazo =  (ConcurrentHashMap<Integer, List<PlazoBean>>) MultiVMPoolUtil.get("pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashListaPlazo");
		if (hashListaPlazo == null) {
			hashListaPlazo = new ConcurrentHashMap<Integer, List<PlazoBean>>();
		} 
		
		if (!hashListaPlazo.containsKey(idParametroPadre)) {
			List<PlazoBean> lista = new ArrayList<PlazoBean>();
			List<Parametro> listaParametro = ParametroLocalServiceUtil.listarHijosPadresJson(idParametroPadre);
			
			Parametro parametro; 
			for (int i = 0; i < listaParametro.size(); i++) {
				parametro =  listaParametro.get(i);
				PlazoBean bean = new PlazoBean();
				bean.setId(Integer.valueOf(i+1));
				bean.setEtiqueta(Integer.valueOf(parametro.getDato1().split(" ")[0]));
				if (parametro.getDato2().equals(ResultadoSimulacionUtil.etiqueta_tooltip)) {
					bean.setTool("");
				}else{
					bean.setTool(parametro.getDato2());
				}
				
				bean.setOrden(parametro.getNum2());
				bean.setDefecto(parametro.getNum3());
				lista.add(bean);
			}
			hashListaPlazo.put(idParametroPadre, lista);
			MultiVMPoolUtil.put( "pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil","hashListaPlazo", hashListaPlazo);
		}
		return hashListaPlazo.get(idParametroPadre);
	}
	
	

}