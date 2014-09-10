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
import pe.com.ibk.halcon.simulacion.service.SimuladorVehicularService;
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
import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.dto.TasaInteresBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
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
 * The Class SimuladorVehicularServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorVehicularServiceImpl implements SimuladorVehicularService{

  /** The Constant CODIGO_GRUPO. */
  private static final String CODIGO_GRUPO="4";
  
  /** The codigo aplicativo. */
  private static  String CODIGO_APLICATIVO;
  
  /** The codigo canal. */
  private static  int CODIGO_CANAL;
  
  /** The Constant CODIGO_SOLES. */
  private static  final int CODIGO_SOLES=SimuladoresUtil.CODIGO_MONEDA_SOLES;;
  
  /** The Constant CODIGO_DOLARES. */
  private static  final int CODIGO_DOLARES=SimuladoresUtil.CODIGO_MONEDA_DOLARES;;
  
  /** The producto tradicional. */
  private static  int PRODUCTO_TRADICIONAL;
  
  /** The producto compra inteligente. */
  private static  int PRODUCTO_COMPRA_INTELIGENTE;
  
  /** The producto casi nuevo. */
  private static  int PRODUCTO_CASI_NUEVO;
  
  /** The producto especial. */
  private static  int PRODUCTO_ESPECIAL;
 
  /** The _log. */
  private static Log _log = LogFactoryUtil.getLog(SimuladorVehicularServiceImpl.class);
  
  /** The j son util. */
  @Autowired
	 private CacheSimulacionUtil cacheSimulacionUtil;
  
  /* (non-Javadoc)
   * @see pe.com.ibk.halcon.simulacion.service.SimuladorVehicularService#init()
   */
  public void init(){
	  CODIGO_CANAL = SimuladoresUtil.CODIGO_CANAL;
	  CODIGO_APLICATIVO=String.valueOf(SimuladoresUtil.CODIGO_APLICATIVO);
	  PRODUCTO_TRADICIONAL=SimuladoresUtil.PRODUCTO_VEHICULAR_TRADICIONAL;
	  PRODUCTO_COMPRA_INTELIGENTE=SimuladoresUtil.PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE;
	  PRODUCTO_CASI_NUEVO=SimuladoresUtil.PRODUCTO_VEHICULAR_CASI_NUEVO;
	  PRODUCTO_ESPECIAL=SimuladoresUtil.PRODUCTO_VEHICULAR_ESPECIAL;
  }
  
  /* (non-Javadoc)
   * @see pe.com.ibk.halcon.simulacion.service.SimuladorVehicularService#obtenerTasaInteres(com.ext.portlet.halcon.dto.TasaInteresBean)
   */
  public double obtenerTasaInteres(TasaInteresBean tasa) throws BusinessException {
	  
	 return WsTasaInteresServiceUtil.realizarWsTasaInteres(tasa);
  }
  
  /* (non-Javadoc)
   * @see pe.com.ibk.halcon.simulacion.service.SimuladorVehicularService#simular(javax.portlet.PortletRequest, javax.portlet.PortletResponse, com.ext.portlet.halcon.dto.SimuladorBean)
   */
  public void simular(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador) throws BusinessException {
	  SimuladorBean historico=new SimuladorBean(simulador);
	  
	  Double montoFinanciar = (double) 0;
	  try{
	    montoFinanciar=Double.parseDouble(simulador.getValorBien())*(1.0D-Double.parseDouble(simulador.getCuotaInicial())/100.0D);
	  } catch (NumberFormatException e) {
		_log.error("No es un número valido: valor del bien="+simulador.getValorBien()+";"+"valor de cuota inicial="+simulador.getCuotaInicial()+";");
	  }
	  //Obtener tasa de interes
	  TasaInteresBean tasa=new TasaInteresBean();
	  tasa.setCodigoGrupo(new BigInteger(CODIGO_GRUPO));
	  tasa.setCodigoMoneda(new BigInteger(simulador.getTipoMoneda()));
	  tasa.setCodigoProducto(simulador.getTipoCredito());
	  tasa.setCodigoProductoSiebel(SimuladoresUtil.obtenerSiebelbyHPC(Integer.parseInt(simulador.getTipoCredito())));
	  tasa.setMontoFinanciar(new Double(montoFinanciar));
	  tasa.setCodigoCanal(String.valueOf(CODIGO_CANAL));
	  tasa.setPlazo(new BigInteger(simulador.getPlazoCredito()));
	  
	  if(Validator.isNotNull(simulador.getTipoDocumento())){
		  tasa.setTipoDocumento(SimuladoresUtil.obtenerDocumentoSiebel(Integer.parseInt(simulador.getTipoDocumento())));
		  tasa.setNumeroDocumento(simulador.getNumeroDocumento());
	  }
	  
	  double tasaHistorica=obtenerTasaInteres(tasa);
	  
	  //Obtener Cronograma de simulacion
	  CronogramaBean cronogramaBean=new CronogramaBean();
	  cronogramaBean.setCodigoGrupo(new BigInteger(CODIGO_GRUPO));
	  cronogramaBean.setCodigoProducto(new BigInteger(simulador.getTipoCredito()));
	  cronogramaBean.setCodigoMoneda(new BigInteger(simulador.getTipoMoneda()));
	  
	  cronogramaBean.setValorBien(new Double(simulador.getValorBien()));
	  cronogramaBean.setMontoFinanciar(new Double(montoFinanciar));
	  
	  cronogramaBean.setCodigoTipoSeguroDesgravamen(new BigInteger(simulador.getSeguroDesgravamen()));
	  cronogramaBean.setCodigoTipoCuota(new BigInteger(simulador.getTipoCuota()));
	  //cronogramaBean.setPlazo(new BigInteger(simVehicular.getPlazoCredito()));
	  cronogramaBean.setPlazoGracia(new BigInteger("0"));//DEFAULT
	  //cronogramaBean.setTasaInteres(tasaInteres);
	  cronogramaBean.setCodigoAplicativo(new BigInteger(CODIGO_APLICATIVO));
	  
	  Map<String,List<CronogramaResponseBean>> simulaciones=new LinkedHashMap<String, List<CronogramaResponseBean>>();
	  
	  //Si es tradicional
	  if(simulador.getTipoCredito().equalsIgnoreCase(PRODUCTO_TRADICIONAL+"")){
		  //Obtenemos las 3 simulaciones tradicionales
		  //Realizo la simulacion
		  long tInicio,tFin,tTotal;
		  _log.info("Simulacion 1 :");
		  tInicio=System.currentTimeMillis();
		  simulaciones.put(nombreCredito(simulador.getTipoCredito()), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean,simulador.getTipoCredito()));
		  tFin=System.currentTimeMillis();
		  tTotal=tFin-tInicio;
		  _log.info("Tiempo de ejecucion:"+(tTotal/1000L));
		  //Obtenemos las 3 simulaciones inteligentes
		  _log.info("Simulacion 2 :");
		  tInicio=System.currentTimeMillis();
		  simulaciones.put(nombreCredito(PRODUCTO_COMPRA_INTELIGENTE+""), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean,PRODUCTO_COMPRA_INTELIGENTE+""));
		  tFin=System.currentTimeMillis();
		  tTotal=tFin-tInicio;
		  _log.info("Tiempo de ejecucion:"+(tTotal/1000L));
		  portletRequest.setAttribute("comparar","Inteligente");
		  
	  }else if(simulador.getTipoCredito().equalsIgnoreCase(PRODUCTO_COMPRA_INTELIGENTE+"")){
		  //Obtenemos las 3 simulaciones inteligentes
		  simulaciones.put(nombreCredito(simulador.getTipoCredito()), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean,simulador.getTipoCredito()));
		  
		  //Obtenemos las 3 simulaciones tradicionales
		  simulaciones.put(nombreCredito(PRODUCTO_TRADICIONAL+""), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean,PRODUCTO_TRADICIONAL+""));
		  
		  portletRequest.setAttribute("comparar","Tradicional");
		  
	  }else{
		//Obtenemos las 3 simulaciones normales
		  simulaciones.put(nombreCredito(simulador.getTipoCredito()), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean,simulador.getTipoCredito()));
	  }
	  
	  portletRequest.setAttribute("simulaciones",simulaciones);
	  portletRequest.setAttribute("plazoSimulacion",simulador.getPlazoCredito()); 
	  portletRequest.setAttribute("simboloMoneda",ResultadoSimulacionUtil.simboloMoneda(simulador.getTipoMoneda())); 
	  //Registramos el historial
	  
	  historico.setTipoSimulador(CODIGO_GRUPO);
	  historico.setMontoPrestamo(montoFinanciar+"");
	  historico.setTasa(tasaHistorica+"");
	  //Cambios de textos para reporte
	  historico.setTipoCredito(nombreCredito(simulador.getTipoCredito()));
	  historico.setSeguroDesgravamen(ResultadoSimulacionUtil.nombreSeguro(simulador.getSeguroDesgravamen()));
	  historico.setTipoCuota(ResultadoSimulacionUtil.nombreCuota(simulador.getTipoCuota()));
	  
	  try {
		  ResultadoSimulacionUtil.insertarHistorialSimulador(historico,portletRequest);
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.vehicular.serviceimpl.simular");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("resultado.simulacion.simulador.vehicular.serviceimpl.simular")+e.toString());
		}
  }
  
  /**
   * Plazos simulacion.
   * Fecha: 22/08/2013
   *
   * @param tipoMoneda the tipo moneda
   * @param tipoCredito the tipo credito
   * @param plazoCredito the plazo credito
   * @return the list
   */
  private List<String> plazosSimulacion(int tipoMoneda,int tipoCredito,int plazoCredito){
	  List<String> plazos=null;
	  
	  	try{
	  		//plazo del credito
	  		RangoBean plazoElegido=null;
	  		
			//Segun moneda
			if(tipoMoneda== CODIGO_SOLES){
					if(tipoCredito==PRODUCTO_TRADICIONAL){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES);
					}else if(tipoCredito==PRODUCTO_COMPRA_INTELIGENTE){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES);
					}else if(tipoCredito==PRODUCTO_CASI_NUEVO){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES);
					}else if(tipoCredito==PRODUCTO_ESPECIAL){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES);
					}
			}if(tipoMoneda==CODIGO_DOLARES){
					if(tipoCredito==PRODUCTO_TRADICIONAL){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES);
					}else if(tipoCredito==PRODUCTO_COMPRA_INTELIGENTE){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES);
					}else if(tipoCredito==PRODUCTO_CASI_NUEVO){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES);
					}else if(tipoCredito==PRODUCTO_ESPECIAL){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES);
					}					
			}

			if(plazoElegido!=null){
				
				List autoPlazos= new ArrayList();
				int inicio=Integer.parseInt(plazoElegido.getValorInicial());
				int fin=Integer.parseInt(plazoElegido.getValorFinal());
				int incremento=Integer.parseInt(plazoElegido.getIncremento());
				

				for(int i=inicio; i<=fin;i=i+incremento){
					//Generamos los plazos de la BD
					autoPlazos.add(i);
				}
				
				plazos=ResultadoSimulacionUtil.traerHermanos(autoPlazos,plazoCredito);		
			}
			
	  	}catch(Exception e){
	  		_log.error("Error en plazosSimulacion :"+e.toString());
	  	}
	  
	  return plazos;
	  
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
   * @param tipoCredito the tipo credito
   * @return the list
   * @throws BusinessException the business exception
   */
  private List<CronogramaResponseBean> plazosParciales(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador,TasaInteresBean tasa,CronogramaBean cronogramaBean,String tipoCredito) throws BusinessException{
	  
	  SimuladorBean simuladorCopia=new SimuladorBean(simulador);
	  
	  //Seteamos con el tipo Credito
	  simuladorCopia.setTipoCredito(tipoCredito);
	  tasa.setCodigoProducto(tipoCredito);
	  tasa.setCodigoProductoSiebel(SimuladoresUtil.obtenerSiebelbyHPC(Integer.parseInt(simuladorCopia.getTipoCredito())));
	  
	  cronogramaBean.setCodigoProducto(new BigInteger(tipoCredito));
	  
	  List<String> plazos=plazosSimulacion(Integer.parseInt(simuladorCopia.getTipoMoneda()),Integer.parseInt(simuladorCopia.getTipoCredito()),Integer.parseInt(simuladorCopia.getPlazoCredito()));
	  
	  List<CronogramaResponseBean> resultados=null;

	  ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	  
	  for (int i=0;i<plazos.size();i++) {
		  String plazo;
		  plazo=String.valueOf(plazos.get(i));
		 
			 
				  
		  double tasaInteres;
		  CronogramaResponseBean responseWS;

		  //Seteamos los plazos
		  tasa.setPlazo(new BigInteger(plazo));
		  tasaInteres=obtenerTasaInteres(tasa);
		  //Seteo el nuevo valor
		  cronogramaBean.setTasaInteres(tasaInteres);
		  cronogramaBean.setPlazo(new BigInteger(plazo));

		  //Realizo la simulacion
		  responseWS= WsGenerarCronogramaServiceUtil.realizarWsGenerarCronograma(cronogramaBean);
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
		  String nombreArchivo=generarHTMLDetalle(portletRequest,portletResponse,responseAUX,simuladorCopia.getTipoCredito(),simuladorCopia.getSeguroDesgravamen());
		  String urlDetalle=themeDisplay.getURLPortal()+ResultadoSimulacionUtil.CARPETA_PORTLET+ResultadoSimulacionUtil.CARPETA_TEMPLATE+ResultadoSimulacionUtil.getCarpetaDiaria()+nombreArchivo;
		  responseAUX.setUrlDetalle(urlDetalle);

		  if(resultados==null)resultados=new ArrayList<CronogramaResponseBean>();

		  resultados.add(responseAUX);
				
		  
	  }
	  return resultados;
  }
  
  /**
   * Nombre credito.
   * Fecha: 22/08/2013
   *
   * @param tipoCredito the tipo credito
   * @return the string
   */
  private String nombreCredito(String tipoCredito){
	  String nombre="";
	  
	    if(Integer.parseInt(tipoCredito)==PRODUCTO_TRADICIONAL){
		  nombre   = "Tradicional";
		}else if(Integer.parseInt(tipoCredito)==PRODUCTO_COMPRA_INTELIGENTE){
			nombre   = "Compra Inteligente";
		}else if(Integer.parseInt(tipoCredito)==PRODUCTO_CASI_NUEVO){
			nombre   = "Casi Nuevo";
		}else if(Integer.parseInt(tipoCredito)==PRODUCTO_ESPECIAL){
			nombre   = "Especial";
		}
	  
	  return nombre;
  }
  
  /**
   * Generar html detalle.
   * Fecha: 22/08/2013
   *
   * @param portletRequest the portlet request
   * @param portletResponse the portlet response
   * @param respuesta the respuesta
   * @param tipoCredito the tipo credito
   * @param tipoSeguro the tipo seguro
   * @return the string
   */
  private String generarHTMLDetalle(PortletRequest portletRequest,PortletResponse portletResponse,CronogramaResponseBean respuesta,String tipoCredito,String tipoSeguro){
	  String pathLectura;
	  String pathEscritura;
	  String template;
	  String urlDetalle;
	  PortletContext context ;
	  	  	
	  ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	  context= portletRequest.getPortletSession().getPortletContext();
	  pathLectura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.TEMPLATE_SIMULADOR_VEHICULAR;
	  Date fechaActual= new Date();
	  long codigo=fechaActual.getTime();
	  pathEscritura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.getCarpetaDiaria()+ ResultadoSimulacionUtil.ARCHIVO_SIMULADOR_PREFIX + codigo+ ".html";
	  template = ResultadoSimulacionUtil.getTemplateHTML(portletRequest, pathLectura);
	  //Reemplazamos la cabecera
	  template = template.replaceAll("%PRODUCTO%", "Vehicular "+nombreCredito(tipoCredito));
	  template = template.replaceAll("%MONEDA%", TextoUtil.primerasMayuscula(respuesta.getDescripcionMoneda()));
	  template = template.replaceAll("%VALOR_VEHICULO%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getValorBien()));
	  template = template.replaceAll("%MONTO_FINANCIAR%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getMontoFinanciar()));
	  template = template.replaceAll("%TCEA%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaCostoEfectivo()));
	  template = template.replaceAll("%TEA%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaInteres()));
	  template = template.replaceAll("%TIPO_CUOTA%", TextoUtil.primerasMayuscula(respuesta.getDescripcionTipoCuota()));
	  template = template.replaceAll("%MONTO_CUOTA_ORDINARIA%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getMontoCuotaOrdinaria()));
	  template = template.replaceAll("%PLAZO%", respuesta.getPlazo()+"");
	  template = template.replaceAll("%TIPO_SEGURO%",ResultadoSimulacionUtil.nombreSeguro(tipoSeguro));
	  template = template.replaceAll("%TASA_SEGURO_DES%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaSeguroDesgravamen()));
	  template = template.replaceAll("%TASA_VEHICULO%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaSeguroBien()));
	  template = template.replaceAll("%PERIODO_GRACIA%", respuesta.getPlazoGracia()+"");
	  template = template.replaceAll("%COMISION%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaComision()));
	  template = template.replaceAll("%RUTA_CSS%", themeDisplay.getPathThemeCss());
	  template = template.replaceAll("%RUTA_IMG%", themeDisplay.getPathThemeImages());
	  
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
			  template = template.replaceAll("%DETALLE_SIMULACION%", htmlDetalle.toString());
			  
			  template = template.replaceAll("%TOTAL_AMOTIZACIONES%", ResultadoSimulacionUtil.formatDoubletoString(totalAmortizaciones));
			  template = template.replaceAll("%TOTAL_INTERESES%", ResultadoSimulacionUtil.formatDoubletoString(totalInteres));
			  template = template.replaceAll("%TOTAL_SEGURO_DESGRAVAMEN%", ResultadoSimulacionUtil.formatDoubletoString(totalSeguroDesgravamen));
			  template = template.replaceAll("%TOTAL_SEGURO_BIEN%", ResultadoSimulacionUtil.formatDoubletoString(totalSeguroBien));
			  template = template.replaceAll("%TOTAL_COMISION%", ResultadoSimulacionUtil.formatDoubletoString(totalComision));
			  template = template.replaceAll("%TOTAL_MONTO_CUOTA%", ResultadoSimulacionUtil.formatDoubletoString(totalMontoCuota));
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
	  urlDescarga.setParameter("name",nombreCredito(tipoCredito).trim());

	  template = template.replaceAll("%URL_DESCARGA%", urlDescarga.toString());
	  ResultadoSimulacionUtil.generateHTML(portletRequest, template, pathEscritura);
	 
	  
	  return urlDetalle;
  }
}