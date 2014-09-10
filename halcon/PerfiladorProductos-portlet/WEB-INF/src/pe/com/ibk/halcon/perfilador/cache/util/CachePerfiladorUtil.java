package pe.com.ibk.halcon.perfilador.cache.util;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Service
public class CachePerfiladorUtil {

	/** The Constant _log. */
	private static final Log _log = LogFactoryUtil.getLog(CachePerfiladorUtil.class);
	ConcurrentHashMap<String, String> hashValor;
	
	@SuppressWarnings("unchecked")
	public Object getValor(String valor) {

		hashValor = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.perfilador.cache.util.CachePerfiladorUtil","hashValor");
		if (hashValor == null) {
			_log.info("*** entro en getValor null*****");

			hashValor  = new ConcurrentHashMap<String, String>();
			List<Parametro> listaValor;
			try {
				listaValor = ParametroLocalServiceUtil.obtenerRangoValor(JSonUtil.TIPO_VALOR);
				for (Parametro param : listaValor) {
					hashValor.put(param.getDato3(), param.getDato1());
				}
				MultiVMPoolUtil.put("pe.com.ibk.halcon.perfilador.cache.util.CachePerfiladorUtil","hashValor", hashValor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return hashValor.get(valor);
	}
	

}