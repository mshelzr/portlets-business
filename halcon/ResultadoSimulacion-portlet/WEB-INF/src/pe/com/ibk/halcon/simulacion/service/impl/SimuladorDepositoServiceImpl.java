package pe.com.ibk.halcon.simulacion.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil;
import pe.com.ibk.halcon.simulacion.service.SimuladorDepositoService;
import pe.com.ibk.halcon.simulacion.utils.ResultadoSimulacionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.dto.CronogramaResponseBean;
import com.ext.portlet.halcon.dto.PlazoBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.service.AuditoriaSimuladorLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SimuladorDepositoServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorDepositoServiceImpl implements SimuladorDepositoService {
	
	/** The Constant CODIGO_GRUPO. */
	public static final String CODIGO_GRUPO="2";
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SimuladorDepositoServiceImpl.class);
	
	/** The plazo actual. */
	private String plazoActual;
	
	/** The tasa actual. */
	private String tasaActual;
	
	/** The j son util. */
	 @Autowired
	 private CacheSimulacionUtil cacheSimulacionUtil;

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorDepositoService#obtenerTasaInteres(com.ext.portlet.halcon.dto.SimuladorBean, java.lang.String)
	 */
	@Override
	public Double obtenerTasaInteres(SimuladorBean simulador,String plazo) throws BusinessException {
		return Double.parseDouble(AuditoriaSimuladorLocalServiceUtil.obtenerTarifarioDepositoPlazo(Integer.valueOf(simulador.getValorBien()), 
								simulador.getTipoMoneda(), plazo,JSonUtil.TARIFARIO_DEPOSITO_PLAZO).getDato2());
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorDepositoService#simular(javax.portlet.PortletRequest, javax.portlet.PortletResponse, com.ext.portlet.halcon.dto.SimuladorBean)
	 */
	@Override
	public void simular(PortletRequest portletRequest,
						PortletResponse portletResponse, SimuladorBean simulador) {
		SimuladorBean historico=new SimuladorBean(simulador);
		
		List<CronogramaResponseBean> simulaciones = plazosParciales(portletRequest, portletResponse,simulador);
		
		portletRequest.setAttribute("simulaciones",simulaciones);
		portletRequest.setAttribute("plazoSimulacion", getPlazoCreditoxId(Integer.valueOf(simulador.getPlazoCredito())));
		portletRequest.setAttribute("simboloMoneda", ResultadoSimulacionUtil.simboloMoneda(simulador.getTipoMoneda()));
		
		try {
			historico.setTipoSimulador(CODIGO_GRUPO);
			historico.setPlazoCredito(plazoActual);
			historico.setTasa(tasaActual); 
			ResultadoSimulacionUtil.insertarHistorialSimulador(historico,portletRequest);
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.deposito.serviceimpl.simular");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		}
	}
	
	/**
	 * Plazos parciales.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 * @param portletResponse the portlet response
	 * @param simulador the simulador
	 * @return the list
	 */
	private List<CronogramaResponseBean> plazosParciales(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador){
		List<CronogramaResponseBean> resultados = new ArrayList<CronogramaResponseBean>();
		
		List<String> plazos= plazosSimulacion(getPlazoCreditoxId(Integer.valueOf(simulador.getPlazoCredito())));
		
		
		try {
			for (int i=0;i<plazos.size();i++) {
				String plazo = plazos.get(i);
				double tasaInteres = obtenerTasaInteres(simulador,plazo);
				
				if (getPlazoCreditoxId(Integer.valueOf(simulador.getPlazoCredito())) == Integer.parseInt(plazo)) {
					plazoActual  = plazo;
					tasaActual = String.valueOf(tasaInteres);
				}
				
				CronogramaResponseBean responseAUX = new CronogramaResponseBean();
				//Calculamos el interes ganado
				double valorBien = Double.parseDouble(simulador.getValorBien());
				double plazoActual = Double.parseDouble(plazo);
				double interesGanado = valorBien*(Math.pow( 1.0D+ tasaInteres/100.0D, plazoActual/360.0D) - 1.0D );
				double montoTotal = valorBien + interesGanado;
				
				//Seteamos los valores
				responseAUX.setPlazo(new BigInteger(plazo));
				responseAUX.setTasaComision(interesGanado);
				responseAUX.setMontoFinanciar(montoTotal);
				responseAUX.setTasaCostoEfectivo(tasaInteres);
				
				resultados.add(responseAUX);
			}
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.deposito.serviceimpl.plazos.parciales");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("resultado.simulacion.simulador.deposito.serviceimpl.plazos.parciales")+e.toString());
		}
		return resultados;
	}
	
	/**
	 * Plazos simulacion.
	 * Fecha: 22/08/2013
	 *
	 * @param plazoCredito the plazo credito
	 * @return the list
	 */
	private List<String> plazosSimulacion(int plazoCredito) {
		List<String> plazos = null;
		try {
			// plazo del credito
			List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo(ResultadoSimulacionUtil.PLAZO_CRE_SIM_DEPOSITO_PLAZO);
			List<String> autoPlazos = new ArrayList<String>();
			for (int i = 0; i < listaPlazos.size(); i++) {
				autoPlazos.add(String.valueOf(listaPlazos.get(i).getEtiqueta()));
			}
			plazos = traerHermanos(autoPlazos, String.valueOf(plazoCredito));
		} catch (Exception e) {
			_log.error("Error en plazosSimulacion :" + e.toString());
		}
		return plazos;
	}
	
	
	/**
	 * Traer hermanos.
	 * Fecha: 22/08/2013
	 *
	 * @param lista the lista
	 * @param valor the valor
	 * @return the list
	 */
	public List<String> traerHermanos(List<String> lista, String valor) {
		List<String> respuesta = new ArrayList<String>();
		if (lista != null) {
			if (!lista.isEmpty()) {
				int posicionValor = 0;// Posicion en el arreglo de valores
				int contadorPosicion = 0;
				int tamanioLista = lista.size();
				
				for (String object : lista) {
					if (object.equals(valor)) {
						posicionValor = contadorPosicion;
						break;
					}
					contadorPosicion++;
				}

				int inicio = (posicionValor == 0 ? 0 : posicionValor - 1);
				int fin = (posicionValor == tamanioLista - 1 ? tamanioLista - 1
						: posicionValor + 1);

				if (inicio == fin) {
					respuesta.add(lista.get(inicio));
				} else {
					for (int i = inicio; i <= fin; i++) {
						respuesta.add(lista.get(i));
					}
				}
			}
		}

		return respuesta;
	}	
	
	/**
	 * Obtiene plazo creditox id.
	 * Fecha: 22/08/2013
	 *
	 * @param id the id
	 * @return plazo creditox id
	 */
	private int getPlazoCreditoxId(int id){
		try {
			List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo(ResultadoSimulacionUtil.PLAZO_CRE_SIM_DEPOSITO_PLAZO);
			for (PlazoBean p : listaPlazos) {
				if (p.getId().intValue() == id) {
					return p.getEtiqueta().intValue();
				}
			}
		} catch (Exception e) {
			_log.error("Error en getPlazoCreditoxId :" + e.toString());
		}
		return 0;
	}

}
