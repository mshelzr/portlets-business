package com.exp.portlet.halcon.utils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.servlet.http.Cookie;

import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.liferay.portal.kernel.cache.MultiVMPoolUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;


public class SimuladoresUtil {
	

	private static Log _log = LogFactoryUtil.getLog(SimuladoresUtil.class);
	//Claves unicas manejados en los simuladores
	private static final String SIMULADOR_SESSION_PREFIX     ="LIFERAY_SHARED_SIMULADORES";
	private static final String SIMULADOR_COOKIES_PREFIX     ="LFR_COOKIE_SIMULADORES_";
	//Codigos de identificacion de Tipo de Simulador
	public static final String SIMULADOR_VEHICULAR     ="SIM-VEH";
	public static final String SIMULADOR_PLAZO_FIJO    ="SIM-PF";
	public static final String SIMULADOR_FONDOS_MUTUOS ="SIM-FONDOS";
	public static final String SIMULADOR_HIPOTECARIO   ="SIM-HIP";
	public static final String SIMULADOR_PERSONAL      ="SIM-PER";
	
	static ConcurrentHashMap<String, String> hashSiebel;
			  
	
	//Codigo Monedas de simulacion - Codigos Internos
		public static  Integer CODIGO_MONEDA_SOLES = 1;
		public static  Integer CODIGO_MONEDA_DOLARES = 2;
		public static  Integer CODIGO_MONEDA_EUROS = 3;
		public static  Integer CODIGO_CANAL = 4;
		public static  Integer CODIGO_APLICATIVO = 4;
		//Tipo de documentos de simulador 
		public static  Integer CODIGO_DNI = 1;
		public static  Integer CODIGO_CARNE_EXTRANJERIA = 2;
		
		//Codigos de productos de Simuladores
		//VEHICULAR
		public static int PRODUCTO_VEHICULAR_TRADICIONAL = 46;//46;
		public static int PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE = 53;//=53;
		public static int PRODUCTO_VEHICULAR_CASI_NUEVO = 51;//=51;
		public static int PRODUCTO_VEHICULAR_ESPECIAL = 52;//=52;
		//PRESTAMO
		public static int PRODUCTO_PRESTAMO_EFECTIVO = 21; //= 21;
		public static int PRODUCTO_PRESTAMO_PART_TIME = 30; //= 30;
		public static int PRODUCTO_PRESTAMO_FULL_TIME = 33; //= 33;
		
		//HIPOTECARIO
		public static int PRODUCTO_HIPOTECARIO_REGULAR  = 1; //= 1;
		public static int PRODUCTO_HIPOTECARIO_MI_VIVIENDA = 12; //= 12;
		public static int PRODUCTO_HIPOTECARIO_TECHO_PROPIO = 5; //= 5;
		public static int PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA = 6; //= 6;
		
		public static void inicializarHPC(){
			try {
				  				  
				} catch (Exception e) {
					// TODO Auto-generated catch block
					_log.error("Error al inicializar valores de productos HPC de Parametros:"+e.toString());
					
				}
		}
	
	
	public static boolean registrarSimulacion(PortletRequest portletRequest,SimuladorBean beanSimulacion){
		
		boolean esCorrecto=true;
		
		if(Validator.isNotNull(beanSimulacion)){
			String json=JSONFactoryUtil.serialize(beanSimulacion);
			PortletSession pSession;
			pSession=portletRequest.getPortletSession();
			pSession.setAttribute(SIMULADOR_SESSION_PREFIX,json, PortletSession.APPLICATION_SCOPE);
			
			
		}else{
			esCorrecto=false;
		}
		
		return esCorrecto;
	}
	
	
	public static SimuladorBean traerSimulacion(PortletRequest portletRequest){
		
		SimuladorBean respuesta=null;
		
		PortletSession pSession;
		pSession=portletRequest.getPortletSession();
		
		Object fondosJSON=pSession.getAttribute(SIMULADOR_SESSION_PREFIX,PortletSession.APPLICATION_SCOPE);
		
		if(Validator.isNotNull(fondosJSON)){
			SimuladorBean beanSimulacion=(SimuladorBean)JSONFactoryUtil.looseDeserialize((String)fondosJSON,SimuladorBean.class);
			respuesta=beanSimulacion;
		}
		
		return respuesta;
	}
	
	public static SimuladorBean traerSimulacionCookieBean(PortletRequest portletRequest,String tipoSimulador){
		
		SimuladorBean respuesta=null;
		
		String vehicularJSON=null;
		
		if(tipoSimulador.equalsIgnoreCase(SIMULADOR_VEHICULAR)){
			vehicularJSON=traerCookie(portletRequest,SIMULADOR_COOKIES_PREFIX+SIMULADOR_VEHICULAR);
			
		}else if(tipoSimulador.equalsIgnoreCase(SIMULADOR_PLAZO_FIJO)){
			vehicularJSON=traerCookie(portletRequest,SIMULADOR_COOKIES_PREFIX+SIMULADOR_PLAZO_FIJO);
			
		}else if(tipoSimulador.equalsIgnoreCase(SIMULADOR_FONDOS_MUTUOS)){
			vehicularJSON=traerCookie(portletRequest,SIMULADOR_COOKIES_PREFIX+SIMULADOR_FONDOS_MUTUOS);
			
		}else if(tipoSimulador.equalsIgnoreCase(SIMULADOR_HIPOTECARIO)){
			vehicularJSON=traerCookie(portletRequest,SIMULADOR_COOKIES_PREFIX+SIMULADOR_HIPOTECARIO);
			
		}else if(tipoSimulador.equalsIgnoreCase(SIMULADOR_PERSONAL)){
			vehicularJSON=traerCookie(portletRequest,SIMULADOR_COOKIES_PREFIX+SIMULADOR_PERSONAL);
			
		}
		
		if(Validator.isNotNull(vehicularJSON)){
			try{
				vehicularJSON=SeguridadUtil.desencripta(vehicularJSON+"=");
			}catch(Exception e){
				_log.info("Error al desencriptar simulacion:"+e.toString());
			}
			
			SimuladorBean simVehicular=(SimuladorBean)JSONFactoryUtil.looseDeserialize(vehicularJSON,SimuladorBean.class);
			respuesta=simVehicular;
		}
		
		return respuesta;
	}
	

	public static String traerCookie(PortletRequest portletRequest,String key){
		Cookie[] cookies;
		String cookie;
		
		cookie="";
		cookies = portletRequest.getCookies();
	    if(Validator.isNotNull(cookies)){
	    	for (int i = 0; i < cookies.length; i++) {
		    	Cookie c = cookies[i];
				if(c.getName().equalsIgnoreCase(key)){
					cookie=c.getValue();
					break;
				}
			} 
	    }
	    return cookie;
	}
	
	
	public static void eliminarSimulacion(PortletRequest portletRequest){
		
		PortletSession pSession;
		pSession=portletRequest.getPortletSession();
		pSession.removeAttribute(SIMULADOR_SESSION_PREFIX,PortletSession.APPLICATION_SCOPE);
	}
	
	@SuppressWarnings("static-access")
	public static String obtenerSiebelbyHPC(int codigoHPC){
		String siebel="";
		JSonUtil JSonUtil=new JSonUtil();
		try{
			//Producto Vehicular
			if(codigoHPC==PRODUCTO_VEHICULAR_TRADICIONAL){
				siebel=getSiebel(JSonUtil.CREDITO_VEHICULAR);
				
			}else if(codigoHPC==PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE){
				siebel=getSiebel(JSonUtil.COMPRA_INTELIGENTE);
				
			}else if(codigoHPC==PRODUCTO_VEHICULAR_CASI_NUEVO){
				siebel=getSiebel(JSonUtil.AUTO_CASI_NUEVO);
				
			}else if(codigoHPC==PRODUCTO_VEHICULAR_ESPECIAL){
				siebel=getSiebel(JSonUtil.CREDITO_VEHICULAR_ESPECIAL);
			}//Producto prestamo personal
			else if(codigoHPC==PRODUCTO_PRESTAMO_EFECTIVO){
				siebel=getSiebel(JSonUtil.PRESTAMO_EFECTIVO);
				
			}else if(codigoHPC==PRODUCTO_PRESTAMO_PART_TIME){
				siebel=getSiebel(JSonUtil.PRESTAMO_MAESTRIA_NACIONAL_PART_TIME);
				
			}else if(codigoHPC==PRODUCTO_PRESTAMO_FULL_TIME){
				siebel=getSiebel(JSonUtil.PRESTAMO_MAESTRIA_TIEMPO_COMPLETO);
			}//Producto hipotecario
			else if(codigoHPC==PRODUCTO_HIPOTECARIO_REGULAR){
				siebel=getSiebel(JSonUtil.CREDITO_HIPOTECARIO);
				
			}else if(codigoHPC==PRODUCTO_HIPOTECARIO_MI_VIVIENDA){
				siebel=getSiebel(JSonUtil.CREDITO_NUEVO_MIVIVIENDA);
				
			}else if(codigoHPC==PRODUCTO_HIPOTECARIO_TECHO_PROPIO){
				siebel=getSiebel(JSonUtil.CREDITO_TECHO_PROPIO);
				
			}else if(codigoHPC==PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA){
				siebel=getSiebel(JSonUtil.PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA);
			}
			
		}catch(Exception e){
			_log.error("Ocurrió un error al obtener el código Siebel del producto HPC "+codigoHPC+":"+e.toString());
		}
		return siebel;
	}
	
	public static String getSiebel(String etiqueta) throws IOException{
		
		hashSiebel = (ConcurrentHashMap<String, String>) MultiVMPoolUtil.get("pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil","hashSiebelEtiqueta");
		if (hashSiebel == null) {
			_log.info("*** entro en getEtiquetaSiebel null*****");
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
		} else{
			_log.info("***Resultado getSiebelEtiqueta**:" + etiqueta +" valor:"+ (hashSiebel.get(etiqueta)));
		}
		
		return hashSiebel.get(etiqueta);
}
	
	public static String obtenerDocumentoSiebel(int tipoDoc){
		String tipoSiebel="00";//Sin documento
		if(tipoDoc==CODIGO_DNI){
			tipoSiebel="01";
		}else if(tipoDoc==CODIGO_CARNE_EXTRANJERIA){
			tipoSiebel="03";
		}
		return tipoSiebel;
	}
	
	public static String obtenerEtiquetabyHPC(int codigoHPC){
		String etiqueta="";
		
		try{
			//Producto Vehicular
			if(codigoHPC==PRODUCTO_VEHICULAR_TRADICIONAL){
				etiqueta=JSonUtil.CREDITO_VEHICULAR;
				
			}else if(codigoHPC==PRODUCTO_VEHICULAR_COMPRA_INTELIGENTE){
				etiqueta=JSonUtil.COMPRA_INTELIGENTE;
				
			}else if(codigoHPC==PRODUCTO_VEHICULAR_CASI_NUEVO){
				etiqueta=JSonUtil.AUTO_CASI_NUEVO;
				
			}else if(codigoHPC==PRODUCTO_VEHICULAR_ESPECIAL){
				etiqueta=JSonUtil.CREDITO_VEHICULAR_ESPECIAL;
			}//Producto prestamo personal
			else if(codigoHPC==PRODUCTO_PRESTAMO_EFECTIVO){
				etiqueta=JSonUtil.PRESTAMO_EFECTIVO;
				
			}else if(codigoHPC==PRODUCTO_PRESTAMO_PART_TIME){
				etiqueta=JSonUtil.PRESTAMO_MAESTRIA_NACIONAL_PART_TIME;
				
			}else if(codigoHPC==PRODUCTO_PRESTAMO_FULL_TIME){
				etiqueta=JSonUtil.PRESTAMO_MAESTRIA_TIEMPO_COMPLETO;
			}//Producto hipotecario
			else if(codigoHPC==PRODUCTO_HIPOTECARIO_REGULAR){
				etiqueta=JSonUtil.CREDITO_HIPOTECARIO;
				
			}else if(codigoHPC==PRODUCTO_HIPOTECARIO_MI_VIVIENDA){
				etiqueta=JSonUtil.CREDITO_NUEVO_MIVIVIENDA;
				
			}else if(codigoHPC==PRODUCTO_HIPOTECARIO_TECHO_PROPIO){
				etiqueta=JSonUtil.CREDITO_TECHO_PROPIO;
				
			}else if(codigoHPC==PRODUCTO_HIPOTECARIO_GARANTIA_HIPOTECARIA){
				etiqueta=JSonUtil.PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA;
			}
			
		}catch(Exception e){
			_log.error("Ocurrió un error al obtener el código Siebel del producto HPC "+codigoHPC+":"+e.toString());
		}
		return etiqueta;
	}
	
	public static String getBancaByURL(Layout paginActual){
			
			String banca="NB";
			try {
				List<Layout> padres=paginActual.getAncestors();
				
				if(padres!=null && padres.size()>0){
					boolean isCorrect = false;
					for (Layout padre : padres) {
						String urlAmigable=padre.getFriendlyURL();
						
						if(urlAmigable.equalsIgnoreCase("/personas")){
							banca= "BP";isCorrect = true;
						}else if(urlAmigable.equalsIgnoreCase("/empresas")){
							banca= "BE";isCorrect = true;
						}else if(urlAmigable.equalsIgnoreCase("/pequena-empresa")){
							banca= "BPE";isCorrect = true;
						}else if(urlAmigable.equalsIgnoreCase("/corporativo")){
							banca= "BC";isCorrect = true;
						}else if(urlAmigable.equalsIgnoreCase("/institucional")){
							banca= "BI";isCorrect = true;
						}
						
						if(isCorrect){
							break;
						}
					}
				}else{
					String urlAmigable=paginActual.getFriendlyURL();
					
					if(urlAmigable.equalsIgnoreCase("/personas")){
						banca= "BP";
					}else if(urlAmigable.equalsIgnoreCase("/empresas")){
						banca= "BE";
					}else if(urlAmigable.equalsIgnoreCase("/pequena-empresa")){
						banca= "BPE";
					}else if(urlAmigable.equalsIgnoreCase("/corporativo")){
						banca= "BC";
					}else if(urlAmigable.equalsIgnoreCase("/institucional")){
						banca= "BI";
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				_log.warn("Verificar las url de las bancas:"+e.toString());
			}
			return banca;
		}
}
