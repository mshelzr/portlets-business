package com.exp.portlet.halcon.utils;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import com.ext.portlet.halcon.dto.RangoBean;
import com.ext.portlet.halcon.dto.SessionBean;
import com.ext.portlet.halcon.dto.ValorBean;
import com.ext.portlet.halcon.model.LogIncidencias;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ServerDetector;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class JSonUtil {
	
	private static Log _log = LogFactoryUtil.getLog(JSonUtil.class);
	
	public static Gson gson = new Gson();
	
	public static final String NO_EXISTE_PARAMETRO = "No existe parametro";
	JsonServletUtil jsonServletUtil = new JsonServletUtil();
	
	public static final String CADENA_SELECCIONE = "{\"id\":0,\"etiqueta\":\"Seleccione\",\"orden\":\"0\",\"defecto\":\"1\"},";
	public static final String CADENA_TODOS = "{\"id\":0,\"etiqueta\":\"Todos\",\"orden\":\"0\",\"defecto\":\"1\"},";
	public static final String INICIO_UNO = "[";
	public static final String CADENA_UNO = "{\"id\":"; //"{\"id\":\"";
	public static final String CADENA_DOS = ",\"etiqueta\":\""; //"\",\"etiqueta\":\"";
	public static final String CADENA_TRES = "\",\"tool\":\"";
	public static final String CADENA_CUATRO = "\",\"orden\":\"";
	public static final String CADENA_CINCO = "\",\"defecto\":\"";
	public static final String CADENA_DEPARTAMENTO = ",\"id_departamento\":";
	public static final String CADENA_PROVINCIA = ",\"id_provincia\":";
	
	public static final String CADENA_SEIS = "\"},";
	public static final String CADENA_FIN = "\"}]";
	public static final String SESSION_ID = "JSESSIONID";
	
	public static final String COMA = "%";
	
	public static final Integer TIPO_RANGO=10;
	public static final Integer TIPO_LISTA=21;
	public static final Integer TIPO_VALOR=30;
	
	public static final String KEY_RANGO = "KEY_RANGO";
	public static final String KEY_VALOR = "KEY_VALOR";
	
	public static final Integer TIPO_VALOR_NUMERO = 1;
	public static final Integer TIPO_VALOR_DATO = 2;
	
	public static final String PRODUCTO_DEFAULT_CAJA_SORPRESA = "PRODUCTO_DEFAULT_CAJA_SORPRESA";
	public static final String PRODUCTO_PRIORIDAD_CAJA_SORPRESA = "PRODUCTO_PRIORIDAD_CAJA_SORPRESA";
	public static final String REPORTE_MONEDAS_SIMULADOR = "REPORTE_MONEDAS_SIMULADOR";
	

	//*******************************************************************
	//Etiquetas de VALOR
	public static final String ETIQUETA_VALOR_01 = "VALOR_EJEMPLO_01";
	public static final String ETIQUETA_VALOR_02 = "VALOR_EJEMPLO_02";
	public static final String ETIQUETA_CORREO_CONTACTANOS = "CORREO_CONTACTANOS";
	public static final String ETIQUETA_CORREO_CONTACTANOS_REMI = "CORREO_CONTACTANOS_REMI";
	public static final String ETIQUETA_CORREO_DENUNCIA = "CORREO_DENUNCIA";
	public static final String ETIQUETA_CORREO_DENUNCIA_REMI = "CORREO_DENUNCIA_REMI";
	
	public static final String ETIQUETA_CORREO_SOLICITUDES_DESTINATARIO = "CORREO_SOLICITUDES_DESTINATARIO";
	public static final String ETIQUETA_CORREO_ERROR_LOG = "CORREO_ERROR_LOG";
	
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_HIPOTECARIA = "CORREO_SOLICITUDES_REMITENTE_HIPOTECARIA";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_VEHICULAR = "CORREO_SOLICITUDES_REMITENTE_VEHICULAR";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_CUENTA_SUELDO = "CORREO_SOLICITUDES_REMITENTE_CUENTA_SUELDO";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_FONDOS_MUTUOS = "CORREO_SOLICITUDES_REMITENTE_FONDOS_MUTUOS";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_PRESTAMO = "CORREO_SOLICITUDES_REMITENTE_PRESTAMO";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_PREAPROBADA = "CORREO_SOLICITUDES_REMITENTE_PREAPROBADA";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_SOAT = "CORREO_SOLICITUDES_REMITENTE_SOAT";
	public static final String ETIQUETA_CORREO_SOLICITUDES_REMITENTE_TARJETA = "CORREO_SOLICITUDES_REMITENTE_TARJETA";
	public static final String ETIQUETA_CORREO_SOLICITUDES_ASUNTO_SOAT = "CORREO_SOLICITUDES_ASUNTO_SOAT";
	
	
	public static final String ETIQUETA_TIPO_GRAFICO_FONDO_MUTUO = "TIPO_GRAFICO_FONDO_MUTUO";
	public static final String ETIQUETA_ZONAS_RIESGO_FONDOS_MUTUOS = "ZONAS_RIESGO_FONDOS_MUTUOS";
	public static final String ETIQUETA_CORREO_ERROR_LOG_REMITENTE = "CORREO_ERROR_LOG_REMITENTE";
	public static final String VALOR_MONTO_SOLES_FONDOS_MUTUOS = "VALOR_MONTO_SOLES_FONDOS_MUTUOS";
	public static final String VALOR_MONTO_DOLARES_FONDOS_MUTUOS = "VALOR_MONTO_DOLARES_FONDOS_MUTUOS";
	
	//Nuevo
	public static final String ETIQUETA_PREGUNTA1_FONDOS_MUTUOS = "PREGUNTA1_FONDOS_MUTUOS";
	public static final String ETIQUETA_PREGUNTA2_FONDOS_MUTUOS = "PREGUNTA2_FONDOS_MUTUOS";
	public static final String ETIQUETA_PREGUNTA3_FONDOS_MUTUOS = "PREGUNTA3_FONDOS_MUTUOS";
	
	
	//*******************************************************************
	//Etiquetas de RANGO
	public static final String ETIQUETA_RANGO_01 = "RANGO_EJEMPLO_01";
	public static final String ETIQUETA_RANGO_02 = "RANGO_EJEMPLO_02";
	/*Credito Vehicular*/
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES   = "RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES = "RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES   = "RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES = "RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES   = "RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES = "RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES   = "RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES = "RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES";
	
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES   = "RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES = "RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES   = "RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES = "RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES   = "RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES = "RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES   = "RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES = "RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES";
	
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES   = "RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES = "RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES   = "RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES = "RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES   = "RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES = "RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES   = "RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES";
	public static final String ETIQUETA_RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES = "RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES";
	
	public static final String ETIQUETA_RANGO_PETICION_SIM_DEP_PLAZO 		= "PETICION_SIMULADOR_DEPOSITO_PLAZO";
	public static final String ETIQUETA_RANGO_PETICION_SIM_FON_MUTUOS 		= "PETICION_SIMULADOR_FONDOS_MUTUOS";
	public static final String ETIQUETA_RANGO_PETICION_SIM_PRESTAMO 		= "PETICION_SIMULADOR_PRESTAMO";
	public static final String ETIQUETA_RANGO_PETICION_SIM_CRE_HIPOTECARIO 	= "PETICION_SIMULADOR_CREDITO_HIPOTECARIO";
	public static final String ETIQUETA_RANGO_PETICION_SIM_CRE_VEHICULAR 	= "PETICION_SIMULADOR_CREDITO_VEHICULAR";
	public static final String ETIQUETA_RANGO_PETICION_SOL_TAR_CREDITO 		= "PETICION_SOLICITUD_TARJETA_CREDITO";
	public static final String ETIQUETA_RANGO_PETICION_SOL_CRE_VEHICULAR 	= "PETICION_SOLICITUD_CREDITO_VEHICULAR";
	public static final String ETIQUETA_RANGO_PETICION_SOL_CRE_HIPOTECARIO 	= "PETICION_SOLICITUD_CREDITO_HIPOTECARIO";
	public static final String ETIQUETA_RANGO_PETICION_SOL_PRESTAMO 		= "PETICION_SOLICITUD_PRESTAMO";
	public static final String ETIQUETA_RANGO_PETICION_SOL_FON_MUTUO 		= "PETICION_SOLICITUD_FONDO_MUTUO";
	public static final String ETIQUETA_RANGO_PETICION_SOL_CUE_SUELDO 		= "PETICION_SOLICITUD_CUENTA_SUELDO";
	public static final String ETIQUETA_RANGO_PETICION_SOL_SEG_SOAT 		= "PETICION_SOLICITUD_SEGURO_SOAT";
	public static final String ETIQUETA_RANGO_PETICION_SOL_PRE_APROBADO 	= "PETICION_SOLICITUD_PRE_APROBADO";
	public static final String ETIQUETA_RANGO_PETICION_CAJASORPRESA 	= "PETICION_CAJA_SORPRESA";
	
	public static final String PLAZO_TABLA_FONDO_MUTUO = "PLAZO_TABLA_FONDO_MUTUO";
	public static final String ETIQUETA_RANGO_SOLICITAR_TARJETA_DE_CREDITO_SLIDER 	= "ETIQUETA_RANGO_SOLICITAR_TARJETA_DE_CREDITO_SLIDER";
	public static final String ETIQUETA_RANGO_SOLICITAR_CREDITO_VEHICULAR_SLIDER 	= "ETIQUETA_RANGO_SOLICITAR_CREDITO_VEHICULAR_SLIDER";
	public static final String ETIQUETA_RANGO_SOLICITAR_CREDITO_HIPOTECARIO_SLIDER 	= "ETIQUETA_RANGO_SOLICITAR_CREDITO_HIPOTECARIO_SLIDER";
	public static final String ETIQUETA_RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER 	= "ETIQUETA_RANGO_SOLICITAR_PRESTAMO_PERSONAL_SLIDER";
	/*Reportes*/
	public static final String REPORTE_CBO_DOC_IDEN="REPORTE_CBO_DOC_IDEN"; //10
	public static final String REPORTE_CBO_SIMULADOR="REPORTE_CBO_SIMULADOR"; //502
	public static final String REPORTE_CBO_ADQ="REPORTE_CBO_ADQ";  //496
	public static final String REPORTE_CBO_PERFILADOR="REPORTE_CBO_PERFILADOR";  //488
	public static final String REPORTE_CBO_PERFILADOR_TODOS ="REPORTE_CBO_PERFILADOR_TODOS";  //488
	public static final String REPORTE_ETIQUETAS_ESTADO_CIVIL = "CBO_ESTADO_CIVIL";
	
	
	/* Rangos relacionados a Codigos siebel*/
	public static final String AHORRO_AUTO="AHORRO_AUTO";
	public static final String AHORRO_CASA="AHORRO_CASA";
	public static final String AHORRO_EMPRESARIO="AHORRO_EMPRESARIO";
	public static final String AHORRO_EUROS="AHORRO_EUROS";
	public static final String AHORRO_TECHO="AHORRO_TECHO";
	public static final String ASISTENCIA_COMPLETA="ASISTENCIA_COMPLETA";
	public static final String ASISTENCIA_DENTAL="ASISTENCIA_DENTAL";
	public static final String ASISTENCIA_VIAJERO="ASISTENCIA_VIAJERO";
	public static final String AUTO_CASI_NUEVO="AUTO_CASI_NUEVO";
	public static final String COMPRA_DE_DEUDA="COMPRA_DE_DEUDA";
	public static final String COMPRA_INTELIGENTE="COMPRA_INTELIGENTE";
	public static final String CONSUMO_VEA="CONSUMO_VEA";
	public static final String CREDITO_HIPOTECARIO="CREDITO_HIPOTECARIO";
	public static final String CREDITO_NUEVO_MIVIVIENDA="CREDITO_NUEVO_MIVIVIENDA";
	public static final String CREDITO_POR_CONVENIO="CREDITO_POR_CONVENIO";
	public static final String CREDITO_TECHO_PROPIO="CREDITO_TECHO_PROPIO";
	public static final String CREDITO_VEHICULAR="CREDITO_VEHICULAR";
	public static final String CREDITO_VEHICULAR_ESPECIAL="CREDITO_VEHICULAR_ESPECIAL";
	public static final String CUENTA_AGIL="CUENTA_AGIL";
	public static final String CUENTA_CTS="CUENTA_CTS";
	public static final String CUENTA_MAXIMA="CUENTA_MAXIMA";
	public static final String CUENTA_MILLONARIA="CUENTA_MILLONARIA";
	public static final String CUENTA_SIMPLE="CUENTA_SIMPLE";
	public static final String DEPOSITOS_A_PLAZO="DEPOSITOS_PLAZO";
	public static final String EXTRACASH="EXTRACASH";
	public static final String FONDOS_MUTUOS="FONDOS_MUTUOS";
	public static final String HIPOTECARIO_ALQUILER="HIPOTECARIO_ALQUILER";
	public static final String HIPOTECARIO_NOVIOS="HIPOTECARIO_NOVIOS";
	public static final String HIPOTECARIO_RESIDENTES_EN_EL_EXTRANJERO="HIPOTECARIO_RESIDENTES_EN_EL_EXTRANJERO";
	public static final String PLAN_DE_PROTECCION_BLINDAJE_PARA_TARJETA_DE_CREDITO="PLAN_DE_PROTECCION_BLINDAJE_PARA_TARJETA_DE_CREDITO";
	public static final String PLAN_DE_PROTECCION_PARA_TARJETA_DE_DEBITO="PLAN_DE_PROTECCION_PARA_TARJETA_DE_DEBITO";
	public static final String PLAN_DE_PROTECCION_POR_ACCIDENTES="PLAN_DE_PROTECCION_POR_ACCIDENTES";
	public static final String PRESTAMO_DEJANDO_EN_GARANTIA_TUS_AHORROS="PRESTAMO_DEJANDO_EN_GARANTIA_TUS_AHORROS";
	public static final String PRESTAMO_EFECTIVO="PRESTAMO_EFECTIVO";
	public static final String PRESTAMO_MAESTRIA_TIEMPO_COMPLETO="PRESTAMO_MAESTRIA_TIEMPO_COMPLETO";
	public static final String PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA="PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA";
	public static final String PROGRAMA_ONCOCLASICO="PROGRAMA_ONCOCLASICO";
	public static final String PROGRAMA_ONCOSALUD_PLUS="PROGRAMA_ONCOSALUD_PLUS";
	public static final String PROGRAMA_SUELDO="PROGRAMA_SUELDO";
	public static final String RENTA_HOSPITALARIA="RENTA_HOSPITALARIA";
	public static final String SEGURO_MULTIRIESGO_EXTRACASH_PROTEGIDO="SEGURO_MULTIRIESGO_EXTRACASH_PROTEGIDO";
	public static final String SEGURO_VEHICULAR_AUTOFACIL="SEGURO_VEHICULAR_AUTOFACIL";
	public static final String SOAT="SOAT";
	public static final String TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_ELITE="TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_ELITE";
	public static final String TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_GOLD="TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_GOLD";
	public static final String TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_PLATINUM="TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_PLATINUM";
	public static final String TARJETA_INTERBANK__AMERICAN_EXPRESS_GOLD="TARJETA_INTERBANK__AMERICAN_EXPRESS_GOLD";
	public static final String TARJETA_INTERBANK_AMERICAN_EXPRESS="TARJETA_INTERBANK_AMERICAN_EXPRESS";
	public static final String TARJETA_INTERBANK_AMERICAN_EXPRESS_PLATINUM="TARJETA_INTERBANK_AMERICAN_EXPRESS_PLATINUM";
	public static final String TARJETA_INTERBANK_CLARO_VISA_CLASICA="TARJETA_INTERBANK_CLARO_VISA_CLASICA";
	public static final String TARJETA_INTERBANK_CLARO_VISA_ORO="TARJETA_INTERBANK_CLARO_VISA_ORO";
	public static final String TARJETA_INTERBANK_CLARO_VISA_PLATINUM="TARJETA_INTERBANK_CLARO_VISA_PLATINUM";
	public static final String TARJETA_INTERBANK_DEBITO_VISA="TARJETA_INTERBANK_DEBITO_VISA";
	public static final String TARJETA_INTERBANK_MASTERCARD_CLASICA="TARJETA_INTERBANK_MASTERCARD_CLASICA";
	public static final String TARJETA_INTERBANK_MASTERCARD_ORO="TARJETA_INTERBANK_MASTERCARD_ORO";
	public static final String TARJETA_INTERBANK_MASTERCARD_PLATINUM="TARJETA_INTERBANK_MASTERCARD_PLATINUM";
	public static final String TARJETA_INTERBANK_MEGAPLAZA_VISA="TARJETA_INTERBANK_MEGAPLAZA_VISA";
	public static final String TARJETA_INTERBANK_VEA_VISA_CLASICA="TARJETA_INTERBANK_VEA_VISA_CLASICA";
	public static final String TARJETA_INTERBANK_VEA_VISA_ORO="TARJETA_INTERBANK_VEA_VISA_ORO";
	public static final String TARJETA_INTERBANK_VISA_CLASICA="TARJETA_INTERBANK_VISA_CLASICA";
	public static final String TARJETA_INTERBANK_VISA_ORO="TARJETA_INTERBANK_VISA_ORO";
	public static final String TARJETA_INTERBANK_VISA_PLATINUM="TARJETA_INTERBANK_VISA_PLATINUM";
	public static final String PRESTAMO_MAESTRIA_NACIONAL_PART_TIME="PRESTAMO_MAESTRIA_NACIONAL_PART_TIME";
	public static final String TARJETAS_DE_CREDITO_GENERICO="TARJETAS_DE_CREDITO_GENERICO";
	/*credito Personal*/
	
	public static final String ETIQUETA_RANGO_VALOR_PERSONAL_SIM_PER_SOLES   = "RANGO_VALOR_PERSONAL_SIM_PER_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_PERSONAL_SIM_PER_DOLARES = "RANGO_VALOR_PERSONAL_SIM_PER_DOLARES";
	
	/*credito Fondos Mutuos*/
	
	public static final String ETIQUETA_RANGO_PLAZO_FONDOS_MUTUOS_SOLES  = "RANGO_PLAZO_FONDOS_MUTUOS_SOLES";
	public static final String ETIQUETA_RANGO_PLAZO_FONDOS_MUTUOS_DOLARES = "RANGO_PLAZO_FONDOS_MUTUOS_DOLARES";

	/* Simulador Credito a Plazos */
	
	public static final  String TARIFARIO_DEPOSITO_PLAZO = "TARIFARIO_DEPOSITO_PLAZO";
	public static final String ETIQUETA_RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES   = "RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES = "RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES";
	public static final String ETIQUETA_RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS = "RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS";
	
	
	/* Credito Hipotecario*/
	
	public static final String ETIQUETA_RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES   = "RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES   = "RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES";
	public static final String ETIQUETA_RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES   = "RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES   = "RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES   = "RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES   = "RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES";
	
	public static final String ETIQUETA_RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES = "RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES = "RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES";
	public static final String ETIQUETA_RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES = "RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES = "RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES = "RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES";
	public static final String ETIQUETA_RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES = "RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES";
	
	public static final String ETIQUETA_RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO = "RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO";
	public static final String ETIQUETA_RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO = "RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO";
	public static final String ETIQUETA_RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO = "RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO";
	public static final String ETIQUETA_RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO = "RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO";
	
	//public static final String ETIQUETA_RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO_DOLARES = "RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO_DOLARES";
	//public static final String ETIQUETA_RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES ="RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES";
	
	/*DESTACADO PRINCIPAL*/
	public static final String PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PERSONA   = "PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PERSONA";
	public static final String PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_INSTITUCIONAL   = "PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_INSTITUCIONAL";
	public static final String PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_CORPORATIVO   = "PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_CORPORATIVO";
	public static final String PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PEQUENIA_EMPRESA   = "PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_PEQUENIA_EMPRESA";
	public static final String PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_EMPRESA   = "PRODUCTO_DEFECTO_DESTACADO_PRINCIPAL_EMPRESA";
	public static final String PRODUCTO_PRIORIDAD_DESTACADO_PRINCIPAL_PERSONA   = "PRODUCTO_PRIORIDAD_DESTACADO_PRINCIPAL_PERSONA";
	
	public static final String TIEMPO_TRANSICION_DESTACADO="TIEMPO_TRANSICION_DESTACADO";

	//*******************Tipo telefonos Registro Lead - Solicitudes**********************
	public static final String TELEFONO_CELULAR = "C";
	public static final String TELEFONO_DE_FAX = "F";
	public static final String TELEFONO_DE_REFERENCIA = "G";
	public static final String TELEFONO_DE_RESIDENCIA = "R";
	public static final String TELEFONO_DE_TRABAJO = "T";
	public static final String TELEFONO_RECIENTE = "O";
	public static final String TELEFONO_NO_INFORMADO = "9";
	public static final String TELEFONO_SIN_IDENTIFICACION = "S";
	public static final String TELEFONO_COMERCIAL = "N";

	//*******************************************************************
	
	/** Perfiladores **/
	public static final String ETIQUETA_DEFAULT_SLIDER_PERFILADOR_AHORRRO = "SLIDER_VALOR_DEFECTO_PERFILADOR_AHORRO";
	public static final String ETIQUETA_DEFAULT_SLIDER_PERFILADOR_HIPOTECARIO = "SLIDER_VALOR_DEFECTO_PERFILADOR_HIPOTECARIO";
	public static final String ETIQUETA_DEFAULT_SLIDER_PERFILADOR_SEGURO = "SLIDER_VALOR_DEFECTO_PERFILADOR_SEGURO";
	public static final String ETIQUETA_DEFAULT_SLIDER_PERFILADOR_TARJETA = "SLIDER_VALOR_DEFECTO_PERFILADOR_TARJETA";
	
	//*******************************************************************
	
	public static final String RANGO = "rango.txt";
	public static final String VALOR = "valor.txt";
	
	public static final Integer RANGO_ = 44;
	public static final Integer VALOR_ = 45;
	//*******************************************************************
	public static final String DEPARTAMENTO = "departamento.json";
	public static final String PROVINCIA = "provincia.json";
	public static final String DISTRITO = "distrito.json";
	public static final String DISTRITOLIMA = "distrito_lima.json";
	public static final String PAIS = "pais.json";

	//*******************************************************************
	
	/** Claves Twitter **/
	public static final String TWITTER_CONSUMER_KEY = "CONSUMER_KEY_TWITTER";
	public static final String TWITTER_CONSUMER_SECRET = "CONSUMER_SECRET_TWITTER";
	public static final String TWITTER_ACCESS_TOKEN = "ACCESS_TOKEN_TWITTER";
	public static final String TWITTER_ACCESS_TOKEN_SECRET = "ACCESS_TOKEN_SECRET_TWITTER";
		
	//*******************************************************************
	
	/** Pagina Error 404**/
	public static final String NUMERO_RESULTADOS_PAGINA_ERROR404 = "NUMERO_RESULTADOS_PAGINA_ERROR404";
	
	//*******************************************************************
	
	
	/** Ubigeo Tiendas **/
	
	public static final String DEPARTAMENTO_TIENDAS = "departamento_tiendas.json";
	public static final String PROVINCIA_TIENDAS = "provincia_tiendas.json";
	public static final String DISTRITO_TIENDAS = "distrito_tiendas.json";
	
	//*******************************************************************
	
	public static String PATH_BASE;
	public static String PATH;
	public static String PATH_JSON_WAS;
	public static String PATH_ERROR;
	public static String IP;
	public static String TIPO_NUM_DOC;
	public static String ID_USER;
	public static String USER;
	public static String ID_SESSION_USER;
	
	public static final String PATH_CARPETA = "/GestionParametros-portlet/js/resources/";
	public static final String PATH_CARPETA_ERROR = "/GestionParametros-portlet/template/mailError.html";
	public static final String PATH_JSON = "/js/resources/";
	public static final String EXTENSION = ".txt";
	public static String NAME_ARBOL;
	
	private List<ValorBean> listaValor;
	private List<RangoBean> listaRango;
	
	public static void getPath(RenderRequest request){
		ThemeDisplay theme = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PATH_BASE = theme.getURLPortal()+ PATH_CARPETA;
		PortletContext context = request.getPortletSession().getPortletContext();
		PATH = context.getRealPath(JSonUtil.PATH_JSON);
		PATH_JSON_WAS = context.getRealPath("");
		NAME_ARBOL=obtenerArbol(request);
		PATH_ERROR = theme.getURLPortal()+ PATH_CARPETA_ERROR;
		getLogError(request);
	}
	
	public String getPahURL(RenderRequest request) {
		ThemeDisplay theme = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		return theme.getURLPortal()+ PATH_CARPETA;
	}
	
	public static void getLogError (RenderRequest request){
		getIp(request);
		getDNI(request);
		getUser(request);
	}
	
	public static void getIp(RenderRequest request){
		IP = com.liferay.portal.util.PortalUtil.getHttpServletRequest(request).getRemoteAddr();
	}
	
	public static void getDNI(RenderRequest request){
		SessionBean sBean;
		sBean=SessionUtil.traerSession(request);
		if(sBean.getIndicador()==1){
			TIPO_NUM_DOC=sBean.getTipoDoc() + " - " +  sBean.getNumDoc();
		}else{
			TIPO_NUM_DOC="";
		}
	}
	
	public static void getUser(RenderRequest request){
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		ID_SESSION_USER = SimuladoresUtil.traerCookie(request, SESSION_ID);
		ID_USER = String.valueOf(user.getUserId()); 
		USER = user.getFullName();

	}
	
	public static String getStringJson(Object obj) {
		return gson.toJson(obj);
	}
	
	
	private static String obtenerArbol(RenderRequest renderRequest){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Layout paginaActual = themeDisplay.getLayout();
		int i=1;
		String cadena="";
		String n1="";
		String n2="";
		String n3="";
		String nActual=TextoUtil.primerasMayuscula(paginaActual.getName(themeDisplay.getLocale()));	
		cadena=nActual;
		
		try {
			List<Layout> abuelos=paginaActual.getAncestors();
			Collections.reverse(abuelos);
			for (Layout layout : abuelos) {
				switch (i) {
				case 1:
					n1=TextoUtil.primerasMayuscula(layout.getName(themeDisplay.getLocale()));
					cadena=n1+" > "+nActual;
					break;
					
				case 2:
					n2=TextoUtil.primerasMayuscula(layout.getName(themeDisplay.getLocale()));
					cadena=n1+" > "+n2+" > "+nActual;
					break;
					
				case 3:
					n3=TextoUtil.primerasMayuscula(layout.getName(themeDisplay.getLocale()));
					cadena=n1+" > "+n2+" > "+n3+" > "+nActual;
					break;
				}
				i++;
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cadena=cadena.replaceAll(";", "");
		//_log.info("cadena..." + cadena);
		return cadena;
	}
	
	public static LogIncidencias setValores(LogIncidencias logIncidencias){
		
		logIncidencias.setIdSessionVisitante(JSonUtil.ID_SESSION_USER);
		logIncidencias.setIP(JSonUtil.IP);
		logIncidencias.setTipoNumDoc(JSonUtil.TIPO_NUM_DOC);
		logIncidencias.setFechaHoraError(TiempoUtil.getTiempoActualEnDate());
		
		return logIncidencias;
	}
	
	public static LogIncidencias setValoresAll(LogIncidencias logIncidencias){
		logIncidencias = setValores(logIncidencias);
		logIncidencias.setPaginaHija(JSonUtil.NAME_ARBOL);
		return logIncidencias;
	}
	
	public static void LogAuditoria(PortletRequest request, int indicadorPortlet, int indicadorController){
				
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		
		String parametro1="";
		long parametro2=0;

		switch (indicadorPortlet) {
		case 1: //BuscadorContenidos-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.buscador.controller.BuscadorController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.buscador.controller.BuscadorController"));
		break;
		case 2: //BuscarDescuento-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.buscar.descuento.controller.BuscarDescuentoController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.buscar.descuento.controller.BuscarDescuentoController"));
			break;
		case 3: //BuscarTienda-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.buscar.tienda.controller.BuscarTiendaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.buscar.tienda.controller.BuscarTiendaController"));
			break;
		case 4: //BusquedaReporteAnalisisMercado-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.contenidoweb.controller.BusquedaReporteController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.contenidoweb.controller.BusquedaReporteController"));
			break;
		case 5: //CajaSorpresas-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.caja.sorpresas.controller.CajaSorpresasController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.caja.sorpresas.controller.CajaSorpresasController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.caja.sorpresas.controller.CajaSorpresasEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.caja.sorpresas.controller.CajaSorpresasEditController"));
			}
			break;
		case 6: //CargaMasiva-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.carga.masiva.controller.CargaMasivaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.carga.masiva.controller.CargaMasivaController"));
			break;
		case 7: //cargarDescuentos-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.cargar.descuentos.controller.CargarDescuentosController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.cargar.descuentos.controller.CargarDescuentosController"));
			break;
		case 8: //cargarTiendas-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.cargar.tiendas.controller.CargarTiendasController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.cargar.tiendas.controller.CargarTiendasController"));
			break;
		case 9: //ConfiguracionProductoPerfilador-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.gestionperfilador.controller.ConfiguracionProductoPerfiladorController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.gestionperfilador.controller.ConfiguracionProductoPerfiladorController"));
			break;
		case 10: //ConfiguracionVariablesPerfilador-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.gestionperfilador.controller.ConfiguracionVariablesPerfiladorController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.gestionperfilador.controller.ConfiguracionVariablesPerfiladorController"));		
		case 11: //ConocenosBanner-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.ConocenosBannerController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.ConocenosBannerController"));
			break;
		case 12: //ConocenosEventos-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.ConocenosEventosController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.ConocenosEventosController"));	
			break;
		case 13: //ConocenosNoticias-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.ConocenosNoticiasController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.ConocenosNoticiasController"));	
			break;
		case 14: //contentmilkbox-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.com.ext.test.controllers.DemoController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.com.ext.test.controllers.DemoController"));	
			break;
		case 15: //DestacadoPrincipal-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.principal.controller.PrincipalController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.principal.controller.PrincipalController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.principal.controller.PrincipalEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.principal.controller.PrincipalEditController"));
			}
			break;
		case 16: //DestacadoSecundario-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.home.controller.DestacadoSecundarioController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.home.controller.DestacadoSecundarioController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.home.controller.DestacadoSecundarioEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.home.controller.DestacadoSecundarioEditController"));
			}
			break;
		case 17: //DestacadosPorNivel1-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.home.controller.DestacadosPorNivel1Controller");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.home.controller.DestacadosPorNivel1Controller"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.home.controller.DestacadosPorNivel1EditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.home.controller.DestacadosPorNivel1EditController"));
			}
			break;
		case 18: //DestacadosPorNivel2-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.home.controller.DestacadosPorNivel2Controller");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.home.controller.DestacadosPorNivel2Controller"));	
			break;
		case 19: //DetalleEvento-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.DetalleEventoController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.DetalleEventoController"));	
			break;
		case 20: //DetalleNoticia-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.DetalleNoticiaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.DetalleNoticiaController"));	
			break;			
		case 21://DetallePromocion-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.promociones.controller.DetallePromocionController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.promociones.controller.DetallePromocionController"));	
			break;
		case 22: //FondoMutuoJob-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.fondomutuo.service.impl.FondoMutuoJobServiceImpl");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.fondomutuo.service.impl.FondoMutuoJobServiceImpl"));	
			break;
		case 23: //FormularioSolicitarProductos-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.solicitudes.controller.FormularioSolicitarProductosController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.solicitudes.controller.FormularioSolicitarProductosController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.solicitudes.controller.FormularioSolicitarProductosEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.solicitudes.controller.FormularioSolicitarProductosEditController"));
			}
			break;
		case 24: //MapaSitio-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.mapa.controller.MapaSitioController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.mapa.controller.MapaSitioController"));	
			break;
		case 25: //PaginaError404-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.contenidoweb.controller.Error404Controller");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.contenidoweb.controller.Error404Controller"));	
			break;			
		case 26: //PerfiladorProductos-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.perfilador.controller.PerfiladorProductosController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.perfilador.controller.PerfiladorProductosController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.perfilador.controller.PerfiladorProductosEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.perfilador.controller.PerfiladorProductosEditController"));
			}
			break;
		case 27: //PreguntasFrecuentes-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.preguntasfrecuentes.controller.PreguntasFrecuentesController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.preguntasfrecuentes.controller.PreguntasFrecuentesController"));
			break;
		case 28: //ProductoComplementario-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.productosysecciones.controller.ProductoComplementarioController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.productosysecciones.controller.ProductoComplementarioController"));	
			break;
		case 29: //ProductosSimilares-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.similar.controller.SimilarController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.similar.controller.SimilarController"));	
			break;
		case 30: //PromocionesCarrusel-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.CarruselPromocionesController.CarruselPromocionesController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.CarruselPromocionesController.CarruselPromocionesController"));
			break;
		case 31: //RealizarDenuncia-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.realizar.denuncia.controller.RealizarDenunciaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.realizar.denuncia.controller.RealizarDenunciaController"));
			break;
		case 32: //ReporteCajaSorpresa-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.reporte.caja.sorpresa.controller.ReporteCajaSorpresaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.reporte.caja.sorpresa.controller.ReporteCajaSorpresaController"));	
			break;
		case 33: //ReportePerfilador-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.reporte.perfilador.controller.ReportePerfiladorController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.reporte.perfilador.controller.ReportePerfiladorController"));	
			break;
		case 34: //ReporteSolicitudProducto-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.reporte.solicitud.producto.controller.ReporteSolicitudProductoController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.reporte.solicitud.producto.controller.ReporteSolicitudProductoController"));
			break;
		case 35: //ReporteTransaccionesSimuladores-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.reporte.transacciones.simulador.controller.ReporteTransaccionesSimuladoresController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.reporte.transacciones.simulador.controller.ReporteTransaccionesSimuladoresController"));
			break;
		case 36: //ResultadosCategoriasPF-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.categorias.controller.ResultadoCategoriaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.categorias.controller.ResultadoCategoriaController"));
			break;
		case 37: //ResultadoSimulacion-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.simulacion.controller.ResultadoSimulacionEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.simulacion.controller.ResultadoSimulacionEditController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.simulacion.controller.ResultadoSimulacionViewController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.simulacion.controller.ResultadoSimulacionViewController"));
			}
			break;
		case 38: //ResultadosPreguntasFrecuentes-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.resultados.controller.ResultadoBuscadorController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.resultados.controller.ResultadoBuscadorController"));
			break;
		case 39: //SimulacionPreaprobada-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.simulacion.controller.PreaprobacionController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.simulacion.controller.PreaprobacionController"));
			break;
		case 40: //SocialInterbank-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.contenidoweb.controller.SocialInterbank");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.contenidoweb.controller.SocialInterbank"));
			break;
		case 41: //SolicitarContacto-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.contenidoweb.controller.SolicitarContactoController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.contenidoweb.controller.SolicitarContactoController"));
			break;
		case 42: //UltimaNoticia-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.noticia.controller.UltimaNoticiaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.noticia.controller.UltimaNoticiaController"));
			break;
		case 43:  //UltimaSimulacion-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.simulacion.bean.TipoSimuladorBean");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.simulacion.bean.TipoSimuladorBean"));
			break;
		case 44: //VisualizarBanner-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.banner.controller.VisualizarBannerController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.banner.controller.VisualizarBannerController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.banner.controller.VisualizarBannerEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.banner.controller.VisualizarBannerEditController"));
			}
			break;
		case 45: //VisualizarCajaSorpresas-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.visualizar.caja.sorpresas.controller.VisuarlizarCajaSorpresasController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.visualizar.caja.sorpresas.controller.VisuarlizarCajaSorpresasController"));	
			break;
		case 46: //VisualizarListadoEventos-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.VisualizarListadoEventosController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.VisualizarListadoEventosController"));
			break;
		case 47: //VisualizarListadoNoticias-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.conocenos.controller.VisualizarListadoNoticiasController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.conocenos.controller.VisualizarListadoNoticiasController"));	
			break;
		case 48: //VisualizarListadoPromociones-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.promociones.controller.VisualizarPromocionesController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.promociones.controller.VisualizarPromocionesController"));
			break;
		case 49: //VisualizarProductosSeccion-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.seccion.controller.SeccionController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.seccion.controller.SeccionController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.seccion.controller.SeccionEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.seccion.controller.SeccionEditController"));
			}
			break;
		case 50: //VisualizarVideos-portlet
			if(indicadorController == 1){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.videos.controller.VisualizarVideosController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.videos.controller.VisualizarVideosController"));
			}else if(indicadorController == 2){
				parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.videos.controller.VisualizarVideosEditController");
				parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.videos.controller.VisualizarVideosEditController"));
			}
			break;
		case 51: //VizualizarSociosRemesa-portlet
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.interbank.halcon.vizualizar.socios.remesa.controller.VizualizarSociosRemesaController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.interbank.halcon.vizualizar.socios.remesa.controller.VizualizarSociosRemesaController"));
			break;
		case 52:
			parametro1=LanguageUtil.get(locale, "model.resource.pe.com.ibk.halcon.gestionparametros.controller.ParametrosController");
			parametro2=Long.parseLong(LanguageUtil.get(locale, "resource.id.pe.com.ibk.halcon.gestionparametros.controller.ParametrosController"));
			break;
		default:
			break;
		}
		
		/***INICIO AUDITORIA***/
		//ESTE METODO DEBER SER UTILIZADO EN LA CAPA CONTROLLER
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), parametro1, parametro2, null, PortalUtil.getHttpServletRequest(request));
		//ESTE METODO DEBE SER UTILIZADO EN LA CAPA MODELO/SERVICIO
		AuditoriaHalconUtil.auditar(new Exception().getStackTrace()[0].getMethodName(), parametro1, parametro2, null);
		/***FIN AUDITORIA***/
	}
	
	//**************************************************
		
		public static String getPathJsonWasModificada(){
			if (!ServerDetector.isTomcat()) {
				String pathCarpeta = PATH_JSON.substring(1, PATH_JSON.length());
				String nuevaRuta = PATH_JSON_WAS.replaceAll("[A-Za-z0-9]+-portlet", "GestionParametros-portlet");
				return nuevaRuta+pathCarpeta;
			}else{
				return "";
			}
		}
}
