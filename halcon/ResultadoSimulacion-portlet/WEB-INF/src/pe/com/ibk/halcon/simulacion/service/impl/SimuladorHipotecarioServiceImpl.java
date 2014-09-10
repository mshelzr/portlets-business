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
import pe.com.ibk.halcon.simulacion.service.SimuladorHipotecarioService;
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
 * The Class SimuladorHipotecarioServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorHipotecarioServiceImpl implements SimuladorHipotecarioService{

  /** The Constant CODIGO_GRUPO. */
  private static final String CODIGO_GRUPO="1";
  
  /** The codigo aplicativo. */
  private static  String CODIGO_APLICATIVO;
  
  /** The codigo canal. */
  private static  int CODIGO_CANAL;
  
  /** The Constant CODIGO_SOLES. */
  private static  final int CODIGO_SOLES=SimuladoresUtil.CODIGO_MONEDA_SOLES;;
  
  /** The Constant CODIGO_DOLARES. */
  private static  final int CODIGO_DOLARES=SimuladoresUtil.CODIGO_MONEDA_DOLARES;;
  
  /** The producto regular. */
  private static  int PRODUCTO_REGULAR;
  
  /** The producto mi vivienda. */
  private static  int PRODUCTO_MI_VIVIENDA;
  
  /** The producto techo propio. */
  private static  int PRODUCTO_TECHO_PROPIO;
  
  /** The producto garantia hipotecaria. */
  private static  int PRODUCTO_GARANTIA_HIPOTECARIA;
 
  /** The _log. */
  private static Log _log = LogFactoryUtil.getLog(SimuladorHipotecarioServiceImpl.class);
  
  /** The j son util. */
  @Autowired
  private CacheSimulacionUtil cacheSimulacionUtil;
  
  /* (non-Javadoc)
   * @see pe.com.ibk.halcon.simulacion.service.SimuladorHipotecarioService#init()
   */
  public void init(){
	  CODIGO_CANAL = SimuladoresUtil.CODIGO_CANAL;
	  CODIGO_APLICATIVO=String.valueOf(SimuladoresUtil.CODIGO_APLICATIVO);
	  PRODUCTO_REGULAR=SimuladoresUtil.PRODUCTO_HIPOTECARIO_REGULAR;
	  PRODUCTO_MI_VIVIENDA=SimuladoresUtil.PRODUCTO_HIPOTECARIO_MI_VIVIENDA;
	  PRODUCTO_TECHO_PROPIO=SimuladoresUtil.PRODUCTO_HIPOTECARIO_TECHO_PROPIO;
	  PRODUCTO_GARANTIA_HIPOTECARIA=SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA;
  }
  
  /* (non-Javadoc)
   * @see pe.com.ibk.halcon.simulacion.service.SimuladorHipotecarioService#obtenerTasaInteres(com.ext.portlet.halcon.dto.TasaInteresBean)
   */
  public double obtenerTasaInteres(TasaInteresBean tasa) throws BusinessException{
	 return WsTasaInteresServiceUtil.realizarWsTasaInteres(tasa);
  }
  
  /* (non-Javadoc)
   * @see pe.com.ibk.halcon.simulacion.service.SimuladorHipotecarioService#simular(javax.portlet.PortletRequest, javax.portlet.PortletResponse, com.ext.portlet.halcon.dto.SimuladorBean)
   */
  public void simular(PortletRequest portletRequest,PortletResponse portletResponse,SimuladorBean simulador) throws BusinessException{
	  SimuladorBean historico=new SimuladorBean(simulador);
	  
	  Double montoFinanciar=Double.parseDouble(simulador.getValorBien())*(1.0D-Double.parseDouble(simulador.getCuotaInicial())/100.0D);
	  
	  //Obtener tasa de interes
	  TasaInteresBean tasa=new TasaInteresBean();
	  if (simulador.getTipoCredito().trim().equalsIgnoreCase(String.valueOf(SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA))) {
		  tasa.setCodigoGrupo(BigInteger.valueOf(Long.valueOf(SimuladorDepositoServiceImpl.CODIGO_GRUPO)));
	  } else {
		  tasa.setCodigoGrupo(BigInteger.valueOf(Long.valueOf(CODIGO_GRUPO)));
	  }
	  
	  tasa.setCodigoMoneda(BigInteger.valueOf(Long.valueOf(simulador.getTipoMoneda())));
	  tasa.setCodigoProducto(simulador.getTipoCredito());
	  tasa.setCodigoProductoSiebel(SimuladoresUtil.obtenerSiebelbyHPC(Integer.parseInt(simulador.getTipoCredito())));
	  tasa.setMontoFinanciar(montoFinanciar);
	  tasa.setCodigoCanal(String.valueOf(CODIGO_CANAL));
	  //Convertimos años a meses
	  BigInteger plazoMeses=BigInteger.valueOf(Long.valueOf(simulador.getPlazoCredito())).multiply(BigInteger.valueOf(12));
	  tasa.setPlazo(plazoMeses);
	  if(Validator.isNotNull(simulador.getTipoDocumento())){
		  tasa.setTipoDocumento(SimuladoresUtil.obtenerDocumentoSiebel(Integer.parseInt(simulador.getTipoDocumento())));
		  tasa.setNumeroDocumento(simulador.getNumeroDocumento());
	  }

	  double tasaHistorica=obtenerTasaInteres(tasa);
	  
	  //Obtener Cronograma de simulacion
	  CronogramaBean cronogramaBean=new CronogramaBean();
	  
	  if (simulador.getTipoCredito().trim().equalsIgnoreCase(String.valueOf(SimuladoresUtil.PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA))) {
		  cronogramaBean.setCodigoGrupo(BigInteger.valueOf(Long.valueOf(SimuladorDepositoServiceImpl.CODIGO_GRUPO)));
	  } else {
		  cronogramaBean.setCodigoGrupo(BigInteger.valueOf(Long.valueOf(CODIGO_GRUPO))); 
	  }

	  cronogramaBean.setCodigoProducto(BigInteger.valueOf(Long.valueOf(simulador.getTipoCredito())));
	  cronogramaBean.setCodigoMoneda(BigInteger.valueOf(Long.valueOf(simulador.getTipoMoneda())));
	  
	  cronogramaBean.setValorBien(Double.parseDouble(simulador.getValorBien()));
	  cronogramaBean.setMontoFinanciar(montoFinanciar);
	  
	  cronogramaBean.setCodigoTipoSeguroDesgravamen(BigInteger.valueOf(Long.valueOf(simulador.getSeguroDesgravamen())));
	  cronogramaBean.setCodigoTipoCuota(BigInteger.valueOf(Long.valueOf(simulador.getTipoCuota())));
	  //cronogramaBean.setPlazo(new BigInteger(simVehicular.getPlazoCredito()));
	  cronogramaBean.setPlazoGracia(BigInteger.valueOf(Long.valueOf("0")));//DEFAULT
	  //cronogramaBean.setTasaInteres(tasaInteres);
	  cronogramaBean.setCodigoAplicativo(BigInteger.valueOf(Long.valueOf(CODIGO_APLICATIVO)));
	  
	  Map<String,List<CronogramaResponseBean>> simulaciones=new LinkedHashMap<String, List<CronogramaResponseBean>>();
	  
	  //Obtenemos las 3 simulaciones normales
	  simulaciones.put(nombreCredito(simulador.getTipoCredito()), plazosParciales(portletRequest,portletResponse,simulador, tasa, cronogramaBean,simulador.getTipoCredito()));

	  portletRequest.setAttribute("simulaciones",simulaciones);
	  portletRequest.setAttribute("plazoSimulacion",Integer.parseInt(simulador.getPlazoCredito())*12); 
	  portletRequest.setAttribute("simboloMoneda",ResultadoSimulacionUtil.simboloMoneda(simulador.getTipoMoneda()));
	  portletRequest.setAttribute("nombreProducto", nombreCredito(simulador.getTipoCredito()));
	  //Registramos el historial
	  
	  historico.setTipoSimulador(CODIGO_GRUPO);
	  historico.setMontoPrestamo(montoFinanciar+"");
	  historico.setTasa(tasaHistorica+"");
	  
	  //Cambios de textos para reporte
	  historico.setTipoCredito(nombreCredito(simulador.getTipoCredito()).replaceFirst("Crédito", ""));
	  historico.setSeguroDesgravamen(ResultadoSimulacionUtil.nombreSeguro(simulador.getSeguroDesgravamen()));
	  historico.setTipoCuota(ResultadoSimulacionUtil.nombreCuota(simulador.getTipoCuota()));
	  
	  try {
		  ResultadoSimulacionUtil.insertarHistorialSimulador(historico,portletRequest);
	  } catch (BusinessException e) {
		  String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.hipotecario.serviceimpl.simular");
		  LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
		  _log.error(Propiedades.getResourceBundle("resultado.simulacion.simulador.hipotecario.serviceimpl.simular")+e.toString());
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
					if(tipoCredito==PRODUCTO_REGULAR){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO);
					}else if(tipoCredito==PRODUCTO_MI_VIVIENDA){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO);
					}else if(tipoCredito==PRODUCTO_TECHO_PROPIO){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO);
					}else if(tipoCredito==PRODUCTO_GARANTIA_HIPOTECARIA){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO);
					}
			}else if(tipoMoneda==CODIGO_DOLARES){
				
					if(tipoCredito==PRODUCTO_REGULAR){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO);
					}else if(tipoCredito==PRODUCTO_MI_VIVIENDA){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO);
					}else if(tipoCredito==PRODUCTO_TECHO_PROPIO){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO);
					}else if(tipoCredito==PRODUCTO_GARANTIA_HIPOTECARIA){
						plazoElegido   = (RangoBean) cacheSimulacionUtil.getRango(JSonUtil.ETIQUETA_RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO);
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
	  
	  cronogramaBean.setCodigoProducto(BigInteger.valueOf(Long.valueOf(tipoCredito)));
	  
	  List<String> plazos=plazosSimulacion(Integer.parseInt(simuladorCopia.getTipoMoneda()),Integer.parseInt(simuladorCopia.getTipoCredito()),Integer.parseInt(simuladorCopia.getPlazoCredito()));
	  
	  List<CronogramaResponseBean> resultados=null;

	  ThemeDisplay themeDisplay=(ThemeDisplay)portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

	  for (int i=0;i<plazos.size();i++) {
		  String plazo;
		  plazo=String.valueOf(plazos.get(i));
		  
		  double tasaInteres;
		  CronogramaResponseBean responseWS;

		  //Seteamos los plazos convirtiendoles de años a meses
		  BigInteger plazoMeses=BigInteger.valueOf(Long.valueOf(plazo)).multiply(BigInteger.valueOf(12));
		  tasa.setPlazo(plazoMeses);
		  tasaInteres=obtenerTasaInteres(tasa);
		  //Seteo el nuevo valor
		  cronogramaBean.setTasaInteres(tasaInteres);
		  cronogramaBean.setPlazo(plazoMeses);

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

		  if(resultados==null)
			  resultados=new ArrayList<CronogramaResponseBean>();

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
	  _log.info("NOMBRE "+tipoCredito);
	  String nombre="";
	  
	    if(Integer.parseInt(tipoCredito)==PRODUCTO_REGULAR){
		  nombre   = ResultadoSimulacionUtil.CREDITO_HIPOTECARIO;
		}else if(Integer.parseInt(tipoCredito)==PRODUCTO_MI_VIVIENDA){
			nombre   = ResultadoSimulacionUtil.CREDITO_MIVIVIENDA;
		}else if(Integer.parseInt(tipoCredito)==PRODUCTO_TECHO_PROPIO){
			nombre   = ResultadoSimulacionUtil.CREDITO_TECHO_PROPIO;
		}else if(Integer.parseInt(tipoCredito)==PRODUCTO_GARANTIA_HIPOTECARIA){
			nombre   = ResultadoSimulacionUtil.PRESTAMO_GARANTIA_HIPOTECARIA;
		}
	    _log.info("NOMBRE "+nombre);
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
	  pathLectura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.TEMPLATE_SIMULADOR_HIPOTECARIO;
	  Date fechaActual= new Date();
	  long codigo=fechaActual.getTime();
	  pathEscritura = context.getRealPath(ResultadoSimulacionUtil.CARPETA_TEMPLATE) + ResultadoSimulacionUtil.getCarpetaDiaria()+ ResultadoSimulacionUtil.ARCHIVO_SIMULADOR_PREFIX + codigo+ ".html";
	  template = ResultadoSimulacionUtil.getTemplateHTML(portletRequest, pathLectura);
	  //Reemplazamos la cabecera
	  template = template.replaceAll("%PRODUCTO%", nombreCredito(tipoCredito).replaceFirst("Crédito", ""));
	  template = template.replaceAll("%MONEDA%", TextoUtil.primerasMayuscula(respuesta.getDescripcionMoneda()));
	  template = template.replaceAll("%VALOR_INMUEBLE%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getValorBien()));
	  template = template.replaceAll("%MONTO_FINANCIAR%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getMontoFinanciar()));
	  template = template.replaceAll("%TCEA%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaCostoEfectivo()));
	  template = template.replaceAll("%TEA%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaInteres()));
	  template = template.replaceAll("%TIPO_CUOTA%", TextoUtil.primerasMayuscula(respuesta.getDescripcionTipoCuota()));
	  template = template.replaceAll("%MONTO_CUOTA_ORDINARIA%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getMontoCuotaOrdinaria()));
	  template = template.replaceAll("%PLAZO%", respuesta.getPlazo()+"");
	  template = template.replaceAll("%TIPO_SEGURO%",ResultadoSimulacionUtil.nombreSeguro(tipoSeguro));
	  template = template.replaceAll("%TASA_SEGURO_DES%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaSeguroDesgravamen()));
	  template = template.replaceAll("%TASA_INMUEBLE%", ResultadoSimulacionUtil.formatDoubletoString(respuesta.getTasaSeguroBien()));
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