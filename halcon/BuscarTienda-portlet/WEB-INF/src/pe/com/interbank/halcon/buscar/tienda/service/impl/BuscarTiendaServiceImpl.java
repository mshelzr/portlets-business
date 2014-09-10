package pe.com.interbank.halcon.buscar.tienda.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Service;

import pe.com.interbank.halcon.buscar.tienda.service.BuscarTiendaService;
import pe.com.interbank.halcon.buscar.tienda.util.Util;

import com.ext.portlet.halcon.model.CargaTienda;
import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class BuscarTiendaServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service("BuscarTiendaService")
public class BuscarTiendaServiceImpl implements BuscarTiendaService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(BuscarTiendaServiceImpl.class);

	/**
	 * retorna una objeto List<Map<String, Object>> de tiendas en formato json y paginado.
	 *
	 * @param distrito the distrito
	 * @param checkTipoLocal the check tipo local
	 * @param resourceRequest the resource request
	 * @param pagina the pagina
	 * @param filas the filas
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	@Override
	public void obtListaSucursales(String distrito, String[] checkTipoLocal, ResourceResponse resourceRequest, int pagina, int filas) throws IOException {
		_log.info("BuscarMapasServiceImpl obtListaSucursales ingresados[ distrito :" + distrito + ", tipo de cajero(checks) seleccionados: " + checkTipoLocal.length + ", pagina : " + pagina
				+ ", filas : " + filas + "]");

		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> lstSucursales = new ArrayList<Map<String, Object>>();
		try {
			Integer count = CargaTiendaLocalServiceUtil.obtenerUbicacionMapaTiendasCount(filas, pagina, checkTipoLocal, distrito).intValue();
			_log.info("CargaTienda count :" + count);
			if (count != null && count > 0) {
				int total = 0;
				int records = 0;
				if (count > 0) {
					total = count / filas + 1;
				}

				// Se descompone cada regsitro en un Map y cada uno de esto se agrega a un lista
				// para mantener el orden de la base de datos
				// Para validar cada campo si a sido hardcodeado el excel ingresado
				List<CargaTienda> lstCargaTienda = CargaTiendaLocalServiceUtil.obtenerUbicacionMapaTiendas(filas, pagina, checkTipoLocal, distrito);

				_log.debug("CargaTienda lstCargaTienda :" + lstCargaTienda);
				for (int i = 0; i < lstCargaTienda.size(); i++) {
					CargaTienda ct = lstCargaTienda.get(i);
					Map<String, Object> o = new HashMap<String, Object>();
					o.put("id", ct.getIdCargaTienda());

					if (ct.getLocacion() == null || ct.getLocacion().equals(""))
						o.put("titulo", "No disponible");
					else
						o.put("titulo", ct.getLocacion());

					if (ct.getDireccion() == null || ct.getDireccion().equals(""))
						o.put("direccion", "Direcci&oacute;n No disponible");
					else
						o.put("direccion", ct.getDireccion());

					if (ct.getLongitud() == null || ct.getLongitud().equals(""))
						o.put("longitud", null);
					else
						o.put("longitud", ct.getLongitud());

					if (ct.getLatitud() == null || ct.getLatitud().equals(""))
						o.put("latitud", null);
					else
						o.put("latitud", ct.getLatitud());

					if (ct.getIdCanal() != null) {

						switch (Integer.parseInt(ct.getIdCanal())) {
						case 1:
							o.put("etiquetaImg", "interbank-tienda.png");
							break;
						case 2:
							o.put("etiquetaImg", "interbank-agente.png");
							break;

						case 3:
							o.put("etiquetaImg", "cajeroglobalnet.png");
							break;
						case 4:
							o.put("etiquetaImg", "monederoglobalnet.png");
							break;
						case 5:
							o.put("etiquetaImg", "cajeroplusglobalnet.png");
							break;
						default:
							break;
						}

					}

					if (ct.getHorario() == null || ct.getHorario().equals(""))
						o.put("horario", "Horario No disponible");
					else
						o.put("horario", ct.getHorario());

					if (ct.getTelefono() == null || ct.getTelefono().equals("")) {
						o.put("telefono", "Tel&eacute;fono No disponible");
					} else
						o.put("telefono", ct.getTelefono());

					o.put("ico", "ico-interbank.gif");
					_log.debug("Se inserto a la lista lstSucursales el objeto :" + o);
					lstSucursales.add(o);
				}
				result.put("pagina", pagina);
				result.put("total", total);
				if (lstCargaTienda != null) {
					records = lstCargaTienda.size();
				}
				result.put("records", records);
				result.put("lstSucursales", lstSucursales);

				_log.info("CargaTienda return en Json de los datos obtenidos  :" + result);

			}

		} catch (Exception e) {
			_log.error("Se entontro un error en BuscarMapasServiceImpl obtListaSucursales :" + e.getMessage());
			e.printStackTrace();
		}

		Util.returnJson(result, resourceRequest);
	}

}
