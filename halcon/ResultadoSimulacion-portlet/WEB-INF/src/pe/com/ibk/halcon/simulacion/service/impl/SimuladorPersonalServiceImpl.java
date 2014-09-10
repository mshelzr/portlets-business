package pe.com.ibk.halcon.simulacion.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil;
import pe.com.ibk.halcon.simulacion.service.SimuladorPersonalService;
import pe.com.ibk.halcon.simulacion.utils.ResultadoSimulacionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.exp.portlet.halcon.utils.TextoUtil;
import com.exp.portlet.halcon.utils.WsGenerarCronogramaServiceUtil;
import com.exp.portlet.halcon.utils.WsTasaInteresServiceUtil;
import com.ext.portlet.halcon.dto.CronogramaBean;
import com.ext.portlet.halcon.dto.CronogramaResponseBean;
import com.ext.portlet.halcon.dto.CuotaCronogramaResponseBean;
import com.ext.portlet.halcon.dto.PlazoBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.dto.TasaInteresBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SimuladorPersonalServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorPersonalServiceImpl implements SimuladorPersonalService {

	/** The Constant CODIGO_GRUPO. */
	private static final String CODIGO_GRUPO = "3";
	
	/** The codigo aplicativo. */
	private static  String CODIGO_APLICATIVO;
	
	/** The codigo canal. */
	private static  int CODIGO_CANAL;
	
	/** The prestamo efectivo. */
	private static  int PRESTAMO_EFECTIVO;
	
	/** The prestamo part time. */
	private static  int PRESTAMO_PART_TIME;
	
	/** The prestamo full time. */
	private static  int PRESTAMO_FULL_TIME;
	
	/** The plazo actual. */
	private String plazoActual;
	
	/** The tasa actual. */
	private String tasaActual;
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SimuladorPersonalServiceImpl.class);
	
	/** The j son util. */
	@Autowired
	 private CacheSimulacionUtil cacheSimulacionUtil;

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorPersonalService#init()
	 */
	public void init(){
		CODIGO_CANAL = SimuladoresUtil.CODIGO_CANAL;
		CODIGO_APLICATIVO=String.valueOf(SimuladoresUtil.CODIGO_APLICATIVO);
		PRESTAMO_EFECTIVO = SimuladoresUtil.PRODUCTO_PRESTAMO_EFECTIVO;
		PRESTAMO_PART_TIME = SimuladoresUtil.PRODUCTO_PRESTAMO_PART_TIME;
		PRESTAMO_FULL_TIME = SimuladoresUtil.PRODUCTO_PRESTAMO_FULL_TIME;
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorPersonalService#obtenerTasaInteres(com.ext.portlet.halcon.dto.TasaInteresBean)
	 */
	@Override
	public double obtenerTasaInteres(TasaInteresBean tasa) throws BusinessException {
		return WsTasaInteresServiceUtil.realizarWsTasaInteres(tasa);
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorPersonalService#simular(javax.portlet.PortletRequest, javax.portlet.PortletResponse, com.ext.portlet.halcon.dto.SimuladorBean)
	 */
	@Override
	public void simular(PortletRequest portletRequest,
			PortletResponse portletResponse, SimuladorBean simulador) throws BusinessException {
		SimuladorBean historico=new SimuladorBean(simulador);

		// Obtener tasa de interes
		TasaInteresBean tasa = new TasaInteresBean();
		tasa.setCodigoGrupo(new BigInteger(CODIGO_GRUPO));
		tasa.setCodigoProducto(simulador.getTipoCredito());
		tasa.setCodigoMoneda(new BigInteger(simulador.getTipoMoneda()));
		if(Validator.isNotNull(simulador.getTipoDocumento())){
			  tasa.setTipoDocumento(SimuladoresUtil.obtenerDocumentoSiebel(Integer.parseInt(simulador.getTipoDocumento())));
			  tasa.setNumeroDocumento(simulador.getNumeroDocumento());
		}
		
		tasa.setMontoFinanciar(new Double(simulador.getMontoPrestamo()));
		tasa.setCodigoCanal(String.valueOf(CODIGO_CANAL));
		tasa.setCodigoProductoSiebel(SimuladoresUtil.obtenerSiebelbyHPC(Integer.valueOf(simulador.getTipoCredito())));
		
		//Obtener Cronograma de simulacion
		CronogramaBean cronogramaBean=new CronogramaBean();
		cronogramaBean.setCodigoGrupo(BigInteger.valueOf(Long.valueOf(CODIGO_GRUPO)));
		cronogramaBean.setCodigoProducto(new BigInteger(simulador.getTipoCredito()));
		cronogramaBean.setCodigoMoneda(new BigInteger(simulador.getTipoMoneda()));
		cronogramaBean.setMontoFinanciar(new Double(simulador.getMontoPrestamo()));
		cronogramaBean.setCodigoTipoCuota(new BigInteger(simulador.getTipoCuota()));
		cronogramaBean.setCodigoAplicativo(new BigInteger(CODIGO_APLICATIVO));
		cronogramaBean.setValorBien(Double.valueOf(0));//NO APLICA
		cronogramaBean.setCodigoTipoSeguroDesgravamen(BigInteger.valueOf(1));//NO APLICA
		cronogramaBean.setPlazoGracia(BigInteger.valueOf(0));//NO APLICA
		
		Map<String,List<CronogramaResponseBean>> simulaciones=new LinkedHashMap<String, List<CronogramaResponseBean>>();
		
		//Obtenemos las 3 simulaciones normales
		simulaciones.put(nombreCredito(simulador.getTipoCredito()), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean));
		
		portletRequest.setAttribute("simulaciones",simulaciones);
	    portletRequest.setAttribute("plazoSimulacion",getPlazoCreditoxId(Integer.parseInt(simulador.getPlazoCredito()))); 
	    portletRequest.setAttribute("simboloMoneda", ResultadoSimulacionUtil.simboloMoneda(simulador.getTipoMoneda()));
	    
	    try {
			historico.setTipoSimulador(CODIGO_GRUPO);
			historico.setPlazoCredito(plazoActual);
			historico.setTasa(tasaActual); 
			//Cambios de textos para reporte
			historico.setTipoCredito(nombreCredito(simulador.getTipoCredito()));
			historico.setTipoCuota(ResultadoSimulacionUtil.nombreCuota(simulador.getTipoCuota()));
			  
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
 	 * @param tasa the tasa
 	 * @param cronogramaBean the cronograma bean
 	 * @return the list
 	 * @throws BusinessException the business exception
 	 */
 	private List<CronogramaResponseBean> plazosParciales(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador,TasaInteresBean tasa,CronogramaBean cronogramaBean) throws BusinessException{
		  
		  SimuladorBean simuladorCopia=new SimuladorBean(simulador);
		  
		  List<String> plazos= plazosSimulacion(getPlazoCreditoxId(Integer.valueOf(simuladorCopia.getPlazoCredito())));
		  List<CronogramaResponseBean> resultados=null;
		  ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		  
		  for (int i=0;i<plazos.size();i++) {

			  String plazo =String.valueOf(plazos.get(i));
			  
			
			  //Seteamos los plazos en la tasa
			  tasa.setPlazo(new BigInteger(plazo));

			  double tasaInteres = obtenerTasaInteres(tasa);

			  if (getPlazoCreditoxId(Integer.valueOf(simuladorCopia.getPlazoCredito())) == Integer.parseInt(plazo)) {
				  plazoActual = plazo;
				  tasaActual = String.valueOf(tasaInteres);
			  }

			  //Seteo el nuevo valor e el cronograma
			  cronogramaBean.setTasaInteres(tasaInteres);
			  cronogramaBean.setPlazo(new BigInteger(plazo));

			  //Realizo la simulacion
			  CronogramaResponseBean responseWS = WsGenerarCronogramaServiceUtil.realizarWsGenerarCronograma(getCronogramaBean(cronogramaBean));
			  if (responseWS.getListCuotaCronogramaResponseBeans().isEmpty()) {
				  throw new BusinessException("Lista vacia del servicio web","Lista vacia del servicio web");
			  }

			  CronogramaResponseBean responseAUX=new CronogramaResponseBean();
			  responseAUX.setCuotaCabeceraResponseBean(responseWS.getCuotaCabeceraResponseBean());
			  responseAUX.setDescripcionGrupo(TextoUtil.primerasMayuscula(responseWS.getDescripcionGrupo()));
			  responseAUX.setDescripcionMoneda(TextoUtil.primerasMayuscula(responseWS.getDescripcionMoneda()));
			  responseAUX.setDescripcionProducto(TextoUtil.primerasMayuscula(responseWS.getDescripcionProducto()));
			  responseAUX.setDescripcionTipoCuota(TextoUtil.primerasMayuscula(responseWS.getDescripcionTipoCuota()));
			  responseAUX.setListCuotaCronogramaResponseBeans(responseWS.getListCuotaCronogramaResponseBeans());
			  responseAUX.setMontoCuotaExtraOrdinaria(responseWS.getMontoCuotaExtraOrdinaria());
			  responseAUX.setMontoCuotaOrdinaria(responseWS.getMontoCuotaOrdinaria());
			  responseAUX.setMontoFinanciar(responseWS.getMontoFinanciar());
			  responseAUX.setPlazo(responseWS.getPlazo());
			  responseAUX.setPlazoGracia(responseWS.getPlazoGracia());
			  responseAUX.setTasaComision(responseWS.getTasaComision());
			  responseAUX.setTasaCostoEfectivo(responseWS.getTasaCostoEfectivo());
			  responseAUX.setTasaInteres(responseWS.getTasaInteres());
			  responseAUX.setTasaSeguroBien(responseWS.getTasaSeguroBien());
			  responseAUX.setTasaSeguroDesgravamen(responseWS.getTasaSeguroDesgravamen());
			  responseAUX.setValorBien(responseWS.getValorBien());
			  //Generamos las url asociadas 
			  /* Leemos el template */
			  String nombreArchivo=generarHTMLDetalle(portletRequest,portletResponse,responseAUX);
			  String urlDetalle=themeDisplay.getURLPortal()+ResultadoSimulacionUtil.CARPETA_PORTLET+ResultadoSimulacionUtil.CARPETA_TEMPLATE+ResultadoSimulacionUtil.getCarpetaDiaria()+nombreArchivo;
			  responseAUX.setUrlDetalle(urlDetalle);

			  if(resultados==null)resultados=new ArrayList<CronogramaResponseBean>();

			  resultados.add(responseAUX);

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
			//List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo("plazo_cre_sim_personal");
			List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo(ResultadoSimulacionUtil.PLAZO_CRE_SIM_PERSONAL);
			
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
 	 * Generar html detalle.
 	 * Fecha: 22/08/2013
 	 *
 	 * @param portletRequest the portlet request
 	 * @param portletResponse the portlet response
 	 * @param respuesta the respuesta
 	 * @return the string
 	 */
 	private String generarHTMLDetalle(PortletRequest portletRequest,PortletResponse portletResponse,CronogramaResponseBean respuesta){
		  String pathLectura;
		  String pathEscritura;
		  String template;
		  String urlDetalle;
		  
		  PortletContext context ;
		  	  	  
		  ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		  context= portletRequest.getPortletSession().getPortletContext();
		  pathLectura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.TEMPLATE_SIMULADOR_PERSONAL;
		  Date fechaActual= new Date();
		  long codigo=fechaActual.getTime();
		  pathEscritura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.getCarpetaDiaria()+ResultadoSimulacionUtil.ARCHIVO_SIMULADOR_PREFIX + codigo+ ".html";
		  template = ResultadoSimulacionUtil.getTemplateHTML(portletRequest, pathLectura);
		  //Reemplazamos la cabecera
		  
		  template = StringUtil.replace(template, new String[]{"%PRODUCTO%",
				  "%MONEDA%","%MONTO_FINANCIAR%","%TCEA%","%TEA%","%TIPO_CUOTA%","%MONTO_CUOTA_ORDINARIA%","%PLAZO%","%TIPO_SEGURO%",
				  "%TASA_SEGURO_DES%","%PERIODO_GRACIA%","%COMISION%","%RUTA_CSS%","%RUTA_IMG%"}
		  				, new String[]{TextoUtil.primerasMayuscula(respuesta.getDescripcionGrupo()),
				  TextoUtil.primerasMayuscula(respuesta.getDescripcionMoneda()), ResultadoSimulacionUtil.formatDoubletoString(respuesta.getMontoFinanciar()),
				  ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaCostoEfectivo()),
				  ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaInteres()),
				  TextoUtil.primerasMayuscula(respuesta.getDescripcionTipoCuota()),
				  ResultadoSimulacionUtil.formatDoubletoString(respuesta.getMontoCuotaOrdinaria()),
				  String.valueOf(respuesta.getPlazo()),"Individual",
				  ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaSeguroDesgravamen()),
				  String.valueOf(respuesta.getPlazoGracia()),
				  ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaComision()),
				  themeDisplay.getPathThemeCss(),
				  themeDisplay.getPathThemeImages()});
		  
		  //Reemplazamos el detalle
		  if(respuesta.getListCuotaCronogramaResponseBeans()!=null ){
			  if(!respuesta.getListCuotaCronogramaResponseBeans().isEmpty()){
				  String clase;
				  Double totalAmortizaciones,totalInteres,totalSeguroDesgravamen,totalSeguroBien,totalComision,totalMontoCuota;
				  StringBuilder htmlDetalle;
				  
				  totalAmortizaciones=0.0D;
				  totalInteres=0.0D;
				  totalSeguroDesgravamen=0.0D;
				  totalSeguroBien=0.0D;
				  totalComision=0.0D;
				  totalMontoCuota=0.0D;
				  htmlDetalle=new StringBuilder();
				  clase="CH-simple";
				  
				  for (CuotaCronogramaResponseBean item : respuesta.getListCuotaCronogramaResponseBeans()) {
					  if(item.getCorrelativoCuota().intValue()%2==0){
						  clase="CH-destacados";
					  }else{
						  clase="CH-simple";
					  }
					  htmlDetalle.append(String.format("<div class='%s'>",clase));
					  htmlDetalle.append(String.format("<span class='cuota'>%s</span>",item.getCorrelativoCuota()));
					  htmlDetalle.append(String.format("<span class='vencimiento'>%s</span>",ResultadoSimulacionUtil.parseXMLDatetoString(item.getFechaVencimiento())));
					  htmlDetalle.append(String.format("<span class='s-inicial'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getSaldoDeuda())));
					  htmlDetalle.append(String.format("<span class='amortizacion'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getAmortizacion())));
					  htmlDetalle.append(String.format("<span class='interes'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getInteres())));
					  htmlDetalle.append(String.format("<span class='s-desgra'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getSeguroDesgravamen())));
					  htmlDetalle.append(String.format("<span class='s-bien'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getSeguroBien())));
					  htmlDetalle.append(String.format("<span class='comision'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getComision())));
					  htmlDetalle.append(String.format("<span class='m-cuota'>%s</span>",ResultadoSimulacionUtil.formatDoubletoString(item.getCuota())));
					  htmlDetalle.append("<div class='both'></div></div>");
					  
					  totalAmortizaciones=totalAmortizaciones+item.getAmortizacion();
					  totalInteres=totalInteres+item.getInteres();
					  totalSeguroDesgravamen=totalSeguroDesgravamen+item.getSeguroDesgravamen();
					  totalSeguroBien=totalSeguroBien+item.getSeguroBien();
					  totalComision=totalComision+item.getComision();
					  totalMontoCuota=totalMontoCuota+item.getCuota();
				  }
				  
				  template = StringUtil.replace(template, new String[]{"%DETALLE_SIMULACION%","%TOTAL_AMOTIZACIONES%","%TOTAL_INTERESES%",
						  "%TOTAL_SEGURO_DESGRAVAMEN%","%TOTAL_SEGURO_BIEN%","%TOTAL_COMISION%","%TOTAL_MONTO_CUOTA%"}, new String[]{
						  htmlDetalle.toString(),ResultadoSimulacionUtil.formatDoubletoString(totalAmortizaciones),ResultadoSimulacionUtil.formatDoubletoString(totalInteres),
						  ResultadoSimulacionUtil.formatDoubletoString(totalSeguroDesgravamen),ResultadoSimulacionUtil.formatDoubletoString(totalSeguroBien),ResultadoSimulacionUtil.formatDoubletoString(totalComision),
						  ResultadoSimulacionUtil.formatDoubletoString(totalMontoCuota)
				  });
				  
			  }
			  
			  
		  }
		  
		  //Generamos la url de descarga
		  urlDetalle=ResultadoSimulacionUtil.ARCHIVO_SIMULADOR_PREFIX + codigo + ".html";
		  /*Creamos la URL Tipos de Operacion*/
		  PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		  String portletName=portletDisplay.getId();
		  long plid=themeDisplay.getPlid();
		  
		  LiferayPortletURL urlDescarga=PortletURLFactoryUtil.create(portletRequest, portletName, plid, PortletRequest.RESOURCE_PHASE);
		  urlDescarga.setResourceID("descargarPDF");
		  urlDescarga.setParameter("file", urlDetalle);
		  urlDescarga.setParameter("name",TextoUtil.primerasMayuscula(respuesta.getDescripcionGrupo()).trim());
		  

		  template = template.replaceAll("%URL_DESCARGA%", urlDescarga.toString());
		  ResultadoSimulacionUtil.generateHTML(portletRequest, template, pathEscritura);
		 
		  
		  return urlDetalle;
	  }

	/**
	 * Nombre credito.
	 * Fecha: 22/08/2013
	 *
	 * @param tipoCredito the tipo credito
	 * @return the string
	 */
	private String nombreCredito(String tipoCredito) {
		String nombre = "";
		
		if(Integer.parseInt(tipoCredito)==PRESTAMO_EFECTIVO){
			nombre = "Préstamo Efectivo";
		}else if(Integer.parseInt(tipoCredito)==PRESTAMO_PART_TIME){
			nombre = "Préstamo Maestría Part Time";
		}else if(Integer.parseInt(tipoCredito)==PRESTAMO_FULL_TIME){
			nombre = "Préstamo Maestría Full Time";
		}
		return nombre;
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
			//List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo("plazo_cre_sim_personal");
			List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo(ResultadoSimulacionUtil.PLAZO_CRE_SIM_PERSONAL);
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
		
	/**
	 * Obtiene cronograma bean.
	 * Fecha: 22/08/2013
	 *
	 * @param cronogramaBean the cronograma bean
	 * @return cronograma bean
	 */
	private CronogramaBean getCronogramaBean(CronogramaBean cronogramaBean){
		CronogramaBean bean = new CronogramaBean();
		bean.setCodigoGrupo(BigInteger.valueOf(3));
		bean.setCodigoProducto(BigInteger.valueOf(30));
		bean.setCodigoMoneda(BigInteger.valueOf(1));
		bean.setValorBien(0.0);
		bean.setMontoFinanciar(4000);
		bean.setCodigoTipoSeguroDesgravamen(BigInteger.valueOf(1));
		bean.setCodigoTipoCuota(BigInteger.valueOf(1));
		bean.setPlazo(BigInteger.valueOf(6));
		bean.setPlazoGracia(BigInteger.valueOf(0));
		bean.setTasaInteres(15);
		bean.setCodigoAplicativo(BigInteger.valueOf(4));
		
		return cronogramaBean;
	}
}
