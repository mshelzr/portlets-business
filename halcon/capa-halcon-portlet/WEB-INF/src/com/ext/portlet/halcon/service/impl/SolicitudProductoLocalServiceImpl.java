/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ext.portlet.halcon.service.impl;

import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.ProductoComplementario;
import com.ext.portlet.halcon.model.SolicitudProducto;
import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;
import com.ext.portlet.halcon.model.impl.ProductoComplementarioImpl;
import com.ext.portlet.halcon.model.impl.SolicitudProductoImpl;
import com.ext.portlet.halcon.model.impl.TelefonoSolicitudProductoImpl;
import com.ext.portlet.halcon.service.ClpSerializer;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.ext.portlet.halcon.service.base.SolicitudProductoLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.util.portlet.PortletProps;

/**
 * The implementation of the solicitud producto local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.ext.portlet.halcon.service.SolicitudProductoLocalService}
 * interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author infonet-consulting
 * @see com.ext.portlet.halcon.service.base.SolicitudProductoLocalServiceBaseImpl
 * @see com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil
 */
public class SolicitudProductoLocalServiceImpl extends
		SolicitudProductoLocalServiceBaseImpl {

	private static final String nameClase = SolicitudProductoLocalServiceImpl.class
			.getName();
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil} to
	 * access the solicitud producto local service.
	 */

	private static Log _log = LogFactoryUtil.getLog(SolicitudProductoLocalServiceImpl.class);
	Locale locale =  new Locale("es", "ES");

	public Integer insertarSolicitud(SolicitudProducto productoBean,
			List<ProductoComplementario> lstProductos, List<TelefonoSolicitudProducto> lstTelefonos) throws BusinessException {

		SolicitudProducto solicitudProducto = null;
		Integer intReturn = 0;
		Integer intReturn1 = 0;

		try {
			/*
			 * Se obtiene el ID autoincremente del SQL server con la Clase
			 * Counter
			 */
			long solicitudProductoId = counterLocalService.increment(SolicitudProducto.class.toString());
			solicitudProducto = solicitudProductoPersistence.create(solicitudProductoId);
			//
			// /*Setear todos los valores*/
			solicitudProducto.setIdSolicitudProducto(solicitudProductoId);
			
			solicitudProducto.setIdTipoDocumento(productoBean.getIdTipoDocumento());
			if (ValidatorUtils.isNotNull(productoBean.getIdTipoDocumentoAdq())) {
				solicitudProducto.setIdTipoDocumentoAdq(Integer.valueOf(productoBean.getIdTipoDocumentoAdq()));
			}
			
			if (ValidatorUtils.isNotNull(productoBean.getTipoCredito())) {
				solicitudProducto.setTipoCredito(Integer.valueOf(productoBean.getTipoCredito()));
			}
			
			solicitudProducto.setCodigoCanal(productoBean.getCodigoCanal());
			
			solicitudProducto.setTipoEnvio(productoBean.getTipoEnvio());
			solicitudProducto.setNumeroDocumento(productoBean
					.getNumeroDocumento());
		

			solicitudProducto.setApellidoMaterno(productoBean.getApellidoMaterno());
			solicitudProducto.setApellidoPaterno(productoBean.getApellidoPaterno());
			

			solicitudProducto.setPrimerNombre(productoBean.getPrimerNombre());
			solicitudProducto.setSegundoNombre(productoBean.getSegundoNombre());
			
			solicitudProducto.setFechaNacimiento(productoBean.getFechaNacimiento());
			solicitudProducto.setSexo(productoBean.getSexo());
			
			if (ValidatorUtils.isNotNull(productoBean.getRentaMensual())) {
				solicitudProducto.setRentaMensual(Double.valueOf(productoBean
						.getRentaMensual()));
			}
			
			solicitudProducto.setCelular(productoBean.getCelular());
			solicitudProducto.setTelefonoCasa(productoBean.getTelefonoCasa());
			solicitudProducto.setTelefonoTrabajo(productoBean.getTelefonoTrabajo());
			solicitudProducto.setAnexo(productoBean.getAnexo());
			
			if (ValidatorUtils.isNotNull(productoBean.getIdEstadoCivilAdq())) {
				solicitudProducto.setIdEstadoCivilAdq(productoBean.getIdEstadoCivilAdq());
			}
			
			solicitudProducto.setIdEstadoCivil(productoBean.getIdEstadoCivil());
			solicitudProducto.setSituacionLaboral(productoBean.getSituacionLaboral());
			if (ValidatorUtils.isNotNull(productoBean.getIdSituacionLaboral())) {
				solicitudProducto.setIdSituacionLaboral(Integer.valueOf(productoBean.getIdSituacionLaboral()));
			}
			
			solicitudProducto.setRUC(productoBean.getRUC());
			solicitudProducto.setRazonSocial(productoBean.getRazonSocial());
			solicitudProducto.setIdDepartamento(productoBean
					.getIdDepartamento());
			solicitudProducto.setIdDistrito(productoBean.getIdDistrito());
			solicitudProducto.setIdProvincia(productoBean.getIdProvincia());
			solicitudProducto.setNomDepartamento(productoBean
					.getNomDepartamento());
			solicitudProducto.setNomDistrito(productoBean.getNomDistrito());
			solicitudProducto.setNomProvincia(productoBean.getNomProvincia());
			
			solicitudProducto.setCorreoElectronico(productoBean.getCorreoElectronico());
			solicitudProducto.setDireccionEnvio(productoBean.getDireccionEnvio());
			
			solicitudProducto.setPlacaVehiculo(productoBean.getPlacaVehiculo());

			solicitudProducto.setIdSession(productoBean.getIdSession());
			
			solicitudProducto.setIPCliente(productoBean.getIPCliente());
			
			solicitudProducto.setHorarioEnvio(productoBean.getHorarioEnvio());
			
			solicitudProducto.setFechaRegistro(productoBean.getFechaRegistro());
			
			solicitudProducto.setUTMCampaing(productoBean.getUTMCampaing());
			solicitudProducto.setUTMContent(productoBean.getUTMContent());
			solicitudProducto.setUTMMedium(productoBean.getUTMMedium());
			solicitudProducto.setUTMSource(productoBean.getUTMSource());

			solicitudProducto.setRespPreCalificacion(productoBean.getRespPreCalificacion());
			
			solicitudProducto.setFechaEnvioEmailing(productoBean.getFechaEnvioEmailing());
			solicitudProducto.setFechaEnvioLead(productoBean.getFechaEnvioLead());
			solicitudProducto.setFechaResultadoPreCalif(productoBean.getFechaResultadoPreCalif());
			
			solicitudProducto.setEstadoEnvCorreo(productoBean.getEstadoEnvCorreo());
			
			solicitudProducto.setEstadoPreCalificacion(productoBean.getEstadoPreCalificacion());
			solicitudProducto.setEstadoRegLead(productoBean.getEstadoRegLead());
			
			solicitudProducto.setRespPreCalificacion(productoBean.getRespPreCalificacion());
			solicitudProducto.setDescripcionLead(productoBean.getDescripcionLead());
			
			solicitudProducto.setFechaActualizacion(productoBean.getFechaActualizacion());
			
			if (ValidatorUtils.isNotNull(productoBean.getMontoProspectado())) {
				solicitudProducto.setMontoProspectado(Double.valueOf(productoBean.getMontoProspectado()));
			}
			
			solicitudProducto.setCodigoCampania(productoBean.getCodigoCampania());
			solicitudProducto.setCodigoMoneda(productoBean.getCodigoMoneda());
			solicitudProducto.setNombreSupervisor(productoBean.getNombreSupervisor());
			solicitudProducto.setRespRegLead(productoBean.getRespRegLead()); //**********adiciono
//			try {
				
			
			solicitudProducto = solicitudProductoPersistence.update(solicitudProducto, false);
			_log.info("**********solicitudProducto***********: "+ solicitudProducto.getIdSolicitudProducto());
			// id = solicitudProducto.getIdSolicitudProducto();

//			if (solicitudProducto.getIdSolicitudProducto() != 0) {
				intReturn = solicitudProductoFinder.insertProductoComplementario(lstProductos,solicitudProducto.getIdSolicitudProducto());
				_log.info("**********insertProductoComplementario***********: "+ intReturn);
				if(intReturn == 1){
					intReturn1 = solicitudProductoFinder.insertarTelefonos(lstTelefonos,solicitudProducto.getIdSolicitudProducto());
					if(intReturn1 != 1){
						 solicitudProductoFinder.eliminarSolicitud(solicitudProducto.getIdSolicitudProducto());
					}
				}else{
					//eliminar los registros insertados y eliminar el padre
					 solicitudProductoFinder.eliminarSolicitud(solicitudProducto.getIdSolicitudProducto());
				}
//			}

		} catch (Exception e) {
			//throw new BusinessException(nameClase+" - insertarSolicitud",e.toString());
			_log.error(Propiedades.getResourceBundleMetodo("capa.halcon.solicitud.producto.insertarSolicitud") + e.toString());
			throw new BusinessException(Propiedades.getResourceBundle("capa.halcon.solicitud.producto", "capa.halcon.solicitud.producto.insertarSolicitud") , e.toString());
		}

		return intReturn;

		// //SolicitudProducto solicitud1 = null;
		// /*try {
		//
		// } catch (Exception e) {
		// // 
		// _log.equals("Error al insertar solicitud:"+e.toString());
		// }*/
		// return solicitudProductoFinder.insertarSolicitud(solicitud);
		// //return solicitud1;
	}

	public SolicitudProducto getInstance() {
		return new SolicitudProductoImpl();
	}

	public ProductoComplementario getInstanceComplementario() {
		return new ProductoComplementarioImpl();
	}
	
	public TelefonoSolicitudProducto getInstanceTelefono() {
		return new TelefonoSolicitudProductoImpl();
	}

	public Long obtenerListaSolicitudProductoCount(Integer filas,
			Integer pagina, Integer cboProducto, Integer respuestaADQ,
			String txtFechaInicio, String txtFechaFin) throws BusinessException {

		_log.info(" obtenerListaSolicitudProductoCount datos cboProducto : "
				+ cboProducto + "  respuestaADQ : " + respuestaADQ
				+ "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil
					.locate(ClpSerializer.getServletContextName(),
							"portletClassLoader");
			DynamicQuery consultaSolicitudProducto = DynamicQueryFactoryUtil
					.forClass(SolicitudProducto.class, classLoader);
			if (cboProducto != null && cboProducto > 0) {
				consultaSolicitudProducto.add(
						PropertyFactoryUtil.forName("idProducto").eq(
								cboProducto)).add(
						PropertyFactoryUtil.forName("idProducto").isNotNull());
			}
			if (respuestaADQ != null && respuestaADQ > 0) {
				consultaSolicitudProducto
						.add(PropertyFactoryUtil.forName("respPreCalificacion")
								.eq(String.valueOf(respuestaADQ)))
						.add(PropertyFactoryUtil.forName("respPreCalificacion")
								.isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil
								.forName("respPreCalificacion").eq("")));
			}
			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio
						.length() > 0)
						&& (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin
								.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					consultaSolicitudProducto.add(
							PropertyFactoryUtil.forName("fechaRegistro").gt(
									sdf.parse(txtFechaInicio))).add(
							PropertyFactoryUtil.forName("fechaRegistro").lt(
									sdf.parse(txtFechaFin)));
				}
			} catch (Exception e) {
				System.out.println(e);
			}

			Long count = SolicitudProductoLocalServiceUtil
					.dynamicQueryCount(consultaSolicitudProducto);
			return count;

		} catch (Exception e) {
			throw new BusinessException(nameClase
					+ " - obtenerListaSolicitudProductoCount", e.toString());
		}

	}

	@SuppressWarnings("unchecked")
	public List<SolicitudProducto> obtenerListSolicitudProducto(Integer filas,
			Integer pagina, Integer cboProducto, Integer respuestaADQ,
			String txtFechaInicio, String txtFechaFin) throws BusinessException {
		_log.info(" obtenerListSolicitudProducto datos cboProducto : "
				+ cboProducto + "  respuestaADQ : " + respuestaADQ
				+ "  txtFechaInicio : " + txtFechaInicio + "  txtFechaFin : "
				+ txtFechaFin);
		try {

			ClassLoader classLoader = (ClassLoader) PortletBeanLocatorUtil
					.locate(ClpSerializer.getServletContextName(),
							"portletClassLoader");
			DynamicQuery consultaSolicitudProducto = DynamicQueryFactoryUtil
					.forClass(SolicitudProducto.class, classLoader);
			if (cboProducto != null && cboProducto > 0) {
				consultaSolicitudProducto.add(
						PropertyFactoryUtil.forName("idProducto").eq(
								cboProducto)).add(
						PropertyFactoryUtil.forName("idProducto").isNotNull());
			}
			if (respuestaADQ != null && respuestaADQ > 0) {
				consultaSolicitudProducto
						.add(PropertyFactoryUtil.forName("respPreCalificacion")
								.eq(String.valueOf(respuestaADQ)))
						.add(PropertyFactoryUtil.forName("respPreCalificacion")
								.isNotNull())
						.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil
								.forName("respPreCalificacion").eq("")));
			}
			try {
				if ((txtFechaInicio != null && (!txtFechaInicio.equals("")) && txtFechaInicio
						.length() > 0)
						&& (txtFechaFin != null && (!txtFechaFin.equals("")) && txtFechaFin
								.length() > 0)) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					consultaSolicitudProducto.add(
							PropertyFactoryUtil.forName("fechaRegistro").gt(
									sdf.parse(txtFechaInicio))).add(
							PropertyFactoryUtil.forName("fechaRegistro").lt(
									sdf.parse(txtFechaFin)));
				}
			} catch (Exception e) {
				throw new BusinessException(nameClase
						+ " - obtenerListSolicitudProducto", e.toString());
			}

			if (filas > 0 && pagina > 0) {
				int init = (filas * pagina - filas);
				int fin = init + filas;

				List<SolicitudProducto> lst = SolicitudProductoLocalServiceUtil
						.dynamicQuery(consultaSolicitudProducto, init, fin);
				_log.info(" select  obtenerListSolicitudProducto lst.size() :"
						+ lst.size());

				return lst;
			} else {
				List<SolicitudProducto> lst = SolicitudProductoLocalServiceUtil
						.dynamicQuery(consultaSolicitudProducto);
				_log.info(" select  obtenerListSolicitudProducto lst.size() :"
						+ lst.size());
				return lst;
			}

		} catch (Exception e) {
			throw new BusinessException(nameClase
					+ " - obtenerListSolicitudProducto", e.toString());
		}
	}
	
	public Integer obtenerDetalleSolicitudCount(Integer filas, Integer pagina, String cboProducto, Integer respuestaADQ, String txtFechaInicio, String txtFechaFin) throws BusinessException {
		return solicitudProductoFinder.obtenerDetalleSolicitudCount(cboProducto, respuestaADQ, txtFechaInicio, txtFechaFin);
	}

	public List<Object[]> obtenerDetalleSolicitud(Integer filas, Integer pagina, String cboProducto, Integer respuestaADQ, String txtFechaInicio, String txtFechaFin) throws BusinessException {
		return solicitudProductoFinder.obtenerDetalleSolicitud(filas,pagina,cboProducto, respuestaADQ, txtFechaInicio, txtFechaFin);
	}
	
	Properties propiedadesSufix=PropsUtil.getProperties("SOLICITUDES.URL.SUFIX.", true);
	 public String getEtiquetaProductoByFriendlyURL(String urlAmigable){
		 	/*Para obtener la etiqueta del producto*/
		 	String producto="";


		 	urlAmigable = urlAmigable.replaceAll("/", "");	 	
		 	producto = LanguageUtil.get(locale, urlAmigable);
					 
	            

			return producto;
	}
	 Properties propiedadesPrefix=PropsUtil.getProperties("SOLICITUDES.URL.PREFIX.", true);
	 public String getEtiquetaSolicitudByFriendlyURL(String urlAmigable){
			/*Para obtener la etiqueta del tipo de solicitud*/
		 	String etiqueta="";


		 	Enumeration<Object> llaves = propiedadesPrefix.keys();
					 
	        // Recorro llave por llave y obtengo su valor
	        while (llaves.hasMoreElements()) {
	            String llave = (String) llaves.nextElement();
	            
	            if(urlAmigable.equalsIgnoreCase(propiedadesPrefix.getProperty(llave))){
	            	etiqueta=llave;
	            	break;
	            }
	        }	        
			return etiqueta;
	}
	 
	 
	 public String getProductoFriendlyURLbyEtiqueta(String etiquetaProducto){
		 String urlAmigableProducto="";
		 
		 urlAmigableProducto=LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX."+etiquetaProducto); 
		 
		 return urlAmigableProducto;
	 }
	 
	 public String getSolicitudFriendlyURLbyEtiqueta(String etiquetaSolicitud){
		 String urlAmigableSolicitud="";
		 
		 urlAmigableSolicitud=LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX."+etiquetaSolicitud); 
		 
		 return urlAmigableSolicitud;
	 }
	 
	 public String getURLSolicitudByEtiquetaContenido(String etiquetaProducto){
		    Map<String,String> productos=getMapaSolicitudes();
			return productos.get(etiquetaProducto)+"-1";
	 }
	 
	 public Map<String,String> getMapaSolicitudes(){
		    Map<String,String> productos=new LinkedHashMap<String, String>();
			//Credito Vehicular
			productos.put("CREDITO_VEHICULAR"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_VEHICULAR"));
			productos.put("CREDITO_VEHICULAR_ESPECIAL", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_VEHICULAR_ESPECIAL"));
			productos.put("AUTO_CASI_NUEVO"           , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.AUTO_CASI_NUEVO"));
			productos.put("COMPRA_INTELIGENTE"        , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COMPRA_INTELIGENTE"));
			
			//Credito Hipotecario
			productos.put("CREDITO_HIPOTECARIO"                       , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_HIPOTECARIO"));
			productos.put("CREDITO_TECHO_PROPIO"                      , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_TECHO_PROPIO"));
			productos.put("CREDITO_NUEVO_MIVIVIENDA"                  , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_NUEVO_MIVIVIENDA"));
			productos.put("PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_PERSONAL_CON_GARANTIA_HIPOTECARIA"));
			
			//Prestamo Personal
			productos.put("PRESTAMO_EFECTIVO"                       , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_EFECTIVO"));
			productos.put("PRESTAMO_MAESTRIA_TIEMPO_COMPLETO"       , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_MAESTRIA_TIEMPO_COMPLETO"));
			productos.put("PRESTAMO_MAESTRIA_NACIONAL_PART_TIME"    , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_MAESTRIA_NACIONAL_PART_TIME"));
			productos.put("PRESTAMO_DEJANDO_EN_GARANTIA_TUS_AHORROS", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PRESTAMO_DEJANDO_EN_GARANTIA_TUS_AHORROS"));
			
			//Fondos mutuos
			productos.put("FONDOS_MUTUOS"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_FONDOS_MUTUOS")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.FONDOS_MUTUOS"));
			
			//Tarjetas
			productos.put("TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_ELITE", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_ELITE"));
			productos.put("TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_GOLD"           , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_GOLD"));
			productos.put("TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_PLATINUM"        , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_AMERICAN_EXPRESS_INTERBANK_LIFEMILES_PLATINUM"));
			productos.put("TARJETA_INTERBANK__AMERICAN_EXPRESS_GOLD", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK__AMERICAN_EXPRESS_GOLD"));
			productos.put("TARJETA_INTERBANK_AMERICAN_EXPRESS"           , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_AMERICAN_EXPRESS"));
			productos.put("TARJETA_INTERBANK_AMERICAN_EXPRESS_PLATINUM"        , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_AMERICAN_EXPRESS_PLATINUM"));
			productos.put("TARJETA_INTERBANK_CLARO_VISA_CLASICA", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_CLARO_VISA_CLASICA"));
			productos.put("TARJETA_INTERBANK_CLARO_VISA_ORO"           , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_CLARO_VISA_ORO"));
			productos.put("TARJETA_INTERBANK_CLARO_VISA_PLATINUM"        , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_CLARO_VISA_PLATINUM"));
			productos.put("TARJETA_INTERBANK_MASTERCARD_CLASICA", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_MASTERCARD_CLASICA"));
			productos.put("TARJETA_INTERBANK_MASTERCARD_ORO"           , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_MASTERCARD_ORO"));
			productos.put("TARJETA_INTERBANK_MASTERCARD_PLATINUM"        , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_MASTERCARD_PLATINUM"));
			productos.put("TARJETA_INTERBANK_MEGAPLAZA_VISA", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_MEGAPLAZA_VISA"));
			productos.put("TARJETA_INTERBANK_VISA_CLASICA"           , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_VISA_CLASICA"));
			productos.put("TARJETA_INTERBANK_VISA_ORO"        , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_VISA_ORO"));
			productos.put("TARJETA_INTERBANK_VISA_PLATINUM", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_VISA_PLATINUM"));
			productos.put("TARJETA_INTERBANK_VISA", LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_VISA"));
			//Cuenta sueldo
			productos.put("PROGRAMA_SUELDO"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_CUENTA_SUELDO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.PROGRAMA_SUELDO"));
			
			//SOAT
			productos.put("SOAT"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_SOAT")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.SOAT"));
			
			//Productos Preaprobados
			productos.put("CREDITO_POR_CONVENIO"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.CREDITO_POR_CONVENIO"));
			productos.put("TARJETAS_DE_CREDITO_GENERICO"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETAS_DE_CREDITO_GENERICO"));
			
			//***********Nuevos Productos
			productos.put("COD_SIEBEL_001"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_001"));
			productos.put("COD_SIEBEL_002"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_002"));
			productos.put("COD_SIEBEL_003"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_003"));
			productos.put("COD_SIEBEL_004"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_004"));
			productos.put("COD_SIEBEL_005"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_005"));
			productos.put("COD_SIEBEL_006"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_006"));
			productos.put("COD_SIEBEL_007"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_007"));
			productos.put("COD_SIEBEL_008"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_008"));
			productos.put("COD_SIEBEL_009"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_009"));
			productos.put("COD_SIEBEL_010"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_010"));
			productos.put("COD_SIEBEL_011"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_VEHICULAR")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_011"));
			
			productos.put("COD_SIEBEL_012 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_012"));
			productos.put("COD_SIEBEL_013 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_013"));
			productos.put("COD_SIEBEL_014 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_014"));
			productos.put("COD_SIEBEL_015 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_015"));
			productos.put("COD_SIEBEL_016 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_016"));
			productos.put("COD_SIEBEL_017 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_017"));
			productos.put("COD_SIEBEL_018 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_018"));
			productos.put("COD_SIEBEL_019 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_019"));
			productos.put("COD_SIEBEL_020 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_020"));
			productos.put("COD_SIEBEL_021 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_021"));
			productos.put("COD_SIEBEL_022 "         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_HIPOTECARIA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_022"));
			
			productos.put("COD_SIEBEL_023"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_023"));
			productos.put("COD_SIEBEL_024"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_024"));
			productos.put("COD_SIEBEL_025"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_025"));
			productos.put("COD_SIEBEL_026"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_026"));
			productos.put("COD_SIEBEL_027"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_027"));
			productos.put("COD_SIEBEL_028"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_028"));
			productos.put("COD_SIEBEL_029"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_029"));
			productos.put("COD_SIEBEL_030"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_030"));
			productos.put("COD_SIEBEL_031"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_031"));
			productos.put("COD_SIEBEL_032"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_032"));
			productos.put("COD_SIEBEL_033"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PRESTAMO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_033"));
			
			productos.put("COD_SIEBEL_034"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_FONDOS_MUTUOS")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_034"));
			productos.put("COD_SIEBEL_035"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_FONDOS_MUTUOS")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_035"));
			productos.put("COD_SIEBEL_036"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_FONDOS_MUTUOS")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_036"));
			
			productos.put("TARJETA_INTERBANK_PREMIA"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_INTERBANK_PREMIA"));
			productos.put("TARJETA_VISA_CASHBACK_ORO"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_VISA_CASHBACK_ORO"));
			productos.put("TARJETA_VISA_CASHBACK_PLATINUM"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_VISA_CASHBACK_PLATINUM"));
			productos.put("TARJETA_VISA_CASHBACK_SIGNATURE"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_VISA_CASHBACK_SIGNATURE"));
			productos.put("TARJETA_VISA_SIGNATURE"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.TARJETA_VISA_SIGNATURE"));
			
			productos.put("COD_SIEBEL_037"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_037"));
			productos.put("COD_SIEBEL_038"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_038"));
			productos.put("COD_SIEBEL_039"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_039"));
			productos.put("COD_SIEBEL_040"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_040"));
			productos.put("COD_SIEBEL_041"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_041"));
			productos.put("COD_SIEBEL_042"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_042"));
			productos.put("COD_SIEBEL_043"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_043"));
			productos.put("COD_SIEBEL_044"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_044"));
			productos.put("COD_SIEBEL_045"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_045"));
			productos.put("COD_SIEBEL_046"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_046"));
			productos.put("COD_SIEBEL_047"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_047"));
			productos.put("COD_SIEBEL_048"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_048"));
			productos.put("COD_SIEBEL_049"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_049"));
			productos.put("COD_SIEBEL_050"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_050"));
			productos.put("COD_SIEBEL_051"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_051"));
			productos.put("COD_SIEBEL_052"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_052"));
			productos.put("COD_SIEBEL_053"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_053"));
			productos.put("COD_SIEBEL_054"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_054"));
			productos.put("COD_SIEBEL_055"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_055"));
			productos.put("COD_SIEBEL_056"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_056"));
			productos.put("COD_SIEBEL_057"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_057"));
			productos.put("COD_SIEBEL_058"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_058"));
			productos.put("COD_SIEBEL_059"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_059"));
			productos.put("COD_SIEBEL_060"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_060"));
			productos.put("COD_SIEBEL_061"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_061"));
			productos.put("COD_SIEBEL_062"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_062"));
			productos.put("COD_SIEBEL_063"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_063"));
			productos.put("COD_SIEBEL_064"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_064"));
			productos.put("COD_SIEBEL_065"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_065"));
			productos.put("COD_SIEBEL_066"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_066"));
			productos.put("COD_SIEBEL_067"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_067"));
			productos.put("COD_SIEBEL_068"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_068"));
			productos.put("COD_SIEBEL_069"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_069"));
			productos.put("COD_SIEBEL_070"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_070"));
			productos.put("COD_SIEBEL_071"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_071"));
			productos.put("COD_SIEBEL_072"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_072"));
			productos.put("COD_SIEBEL_073"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_073"));
			productos.put("COD_SIEBEL_074"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_074"));
			productos.put("COD_SIEBEL_075"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_075"));
			productos.put("COD_SIEBEL_076"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_076"));
			productos.put("COD_SIEBEL_077"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_077"));
			productos.put("COD_SIEBEL_078"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_078"));
			productos.put("COD_SIEBEL_079"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_079"));
			productos.put("COD_SIEBEL_080"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_080"));
			productos.put("COD_SIEBEL_081"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_081"));
			productos.put("COD_SIEBEL_082"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_082"));
			productos.put("COD_SIEBEL_083"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_083"));
			productos.put("COD_SIEBEL_084"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_084"));
			productos.put("COD_SIEBEL_085"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_085"));
			productos.put("COD_SIEBEL_086"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_TARJETA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_086"));
			
			productos.put("COD_SIEBEL_087"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_CUENTA_SUELDO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_087"));
			productos.put("COD_SIEBEL_088"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_CUENTA_SUELDO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_088"));
			productos.put("COD_SIEBEL_089"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_CUENTA_SUELDO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_089"));
			productos.put("COD_SIEBEL_090"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_CUENTA_SUELDO")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_090"));
			
			productos.put("COD_SIEBEL_091"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_SOAT")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_091"));
			productos.put("COD_SIEBEL_092"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_SOAT")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_092"));
			productos.put("COD_SIEBEL_093"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_SOAT")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_093"));
			
			productos.put("COD_SIEBEL_094"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_094"));
			productos.put("COD_SIEBEL_095"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_095"));
			productos.put("COD_SIEBEL_096"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_096"));
			productos.put("COD_SIEBEL_097"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_097"));
			productos.put("COD_SIEBEL_098"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_098"));
			productos.put("COD_SIEBEL_099"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_099"));
			productos.put("COD_SIEBEL_100"         , LanguageUtil.get(locale, "SOLICITUDES.ALL.PREFIX")+LanguageUtil.get(locale, "SOLICITUDES.URL.PREFIX.SOLICITUD_PREAPROBADA")+LanguageUtil.get(locale, "SOLICITUDES.URL.SUFIX.COD_SIEBEL_100"));
			
			
			return productos;
	 }
	 
	 public String getPropiedadPortlet(String clave){
		 _log.info("LLamando Properties Capa Halcon:"+clave);
		 return PortletProps.get(clave);
	 }
}