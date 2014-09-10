package pe.com.ibk.halcon.perfilador.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import pe.com.ibk.halcon.perfilador.bean.ProductoBean;
import pe.com.ibk.halcon.perfilador.bean.RangoPerfiladorBean;
import pe.com.ibk.halcon.perfilador.bean.VariablePerfiladorBean;
import pe.com.ibk.halcon.perfilador.service.PerfiladorProductoService;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.SessionUtil;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class PerfiladorProductosController.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 24/06/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class PerfiladorProductosController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(PerfiladorProductosController.class);

	/** The indicador portlet. */
	// private static Integer indicadorPortlet = 26;

	/** The indicador controller. */
	// private static Integer indicadorController = 1;

	/** The Constant COD_PERFILADOR_HIPOTECARIO. */
	private static final String COD_PERFILADOR_HIPOTECARIO = PortletProps.get("parametros.code.perfilador.hipotecario");

	/** The rango slider1 t. */
	private Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Hipotecario = new HashMap<Integer, List<RangoPerfiladorBean>>();
	
	private Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Seguros = new HashMap<Integer, List<RangoPerfiladorBean>>();
	
	private Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Tarjetas = new HashMap<Integer, List<RangoPerfiladorBean>>();
	
	private Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Ahorros = new HashMap<Integer, List<RangoPerfiladorBean>>();

	/** The valor bien hipotecario. */
	private String valorBienHipotecario;

	/** The tipo credito hipotecario. */
	private String tipoCreditoHipotecario;

	/** The perfilador producto service. */
	@Autowired
	private PerfiladorProductoService perfiladorProductoService;
	
	private String montoOr = "0";

	/**
	 * Default view. Fecha: 24/06/2013
	 * 
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {
		JSonUtil.getPath(renderRequest);
		// JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}

	/**
	 * Llenado componentes perfilador. Fecha: 24/06/2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("obtenerComponentes")
	protected void llenadoComponentesPerfilador(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		List<VariablePerfiladorBean> lstVariable = new ArrayList<VariablePerfiladorBean>();
		Map<String, Object> objRespuesta = new HashMap<String, Object>();
		String codTipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");
		_log.info(codTipoPerfilador);
		this.setTipoCreditoHipotecario("");
		this.setValorBienHipotecario("");

		int topLevel = 3;
		PrintWriter writer = null;

		try {

			String tipoPerfilador, idPerfilador;
			tipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");
			idPerfilador = resourceRequest.getPreferences().getValue("idPerfilador", "");
			Long idPerfiladorProd = idPerfilador == null ? 0 : Long.valueOf(idPerfilador);

			lstVariable = perfiladorProductoService.obtenerListadoPreguntasPerfilador(idPerfiladorProd, topLevel);
			perfiladorProductoService.convertirListadoPerfilador(lstVariable, codTipoPerfilador);

			setearRangosSliderControlador(lstVariable, tipoPerfilador);

			objRespuesta.put("listaVar", lstVariable);
			objRespuesta.put("tipoPerfilador", tipoPerfilador);

			Gson gson = new Gson();
			String gsonString = "";
			gsonString = gson.toJson(objRespuesta);
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(gsonString);
			writer.flush();
		} catch (Exception e) {
			_log.error(e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}
	}

	/**
	 * Actualizar perfilador. Fecha: 24/06/2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("actualizarPerfilador")
	protected void actualizarPerfilador(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		Map<String, Object> objRespuesta = new HashMap<String, Object>();
		_log.info("Renderizar Perfilador");
		List<VariablePerfiladorBean> lstVariable = new ArrayList<VariablePerfiladorBean>();
		String codTipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");

		if (ParamUtil.getString(resourceRequest, "valSeleccionado").equals("")) {
			return;
		}
		Long idVariable = Long.valueOf(ParamUtil.getString(resourceRequest, "valSeleccionado"));
		String gsonString = "";
		PrintWriter writer = null;
		try {
			Gson gson = new Gson();
			if (idVariable == 0) {
				objRespuesta.put("listaVar", new ArrayList<VariablePerfiladorBean>());
				
			} else {
				int nivel = Integer.valueOf(ParamUtil.getString(resourceRequest, "nivelActual"));
				lstVariable = perfiladorProductoService.actualizarListadoPreguntasPerfilador(idVariable, nivel);
				setearRangosSliderControlador(lstVariable, codTipoPerfilador);
				perfiladorProductoService.convertirListadoPerfilador(lstVariable, codTipoPerfilador);
				objRespuesta.put("listaVar", lstVariable);
				
			}
			gsonString = gson.toJson(objRespuesta);
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			_log.info("gsonString " + gsonString);
			writer = resourceResponse.getWriter();
			writer.write(gsonString);
			writer.flush();
		} catch (Exception e) {
			_log.error("Error en actualizar Perfilador: " + e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}
	}

	/**
	 * Enviar perfilador. Fecha: 24/06/2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("enviarPerfilador")
	protected void enviarPerfilador(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String tipoDoc = "";
		String numeroDoc = "";
		String valor1 = ParamUtil.getString(resourceRequest, "valor1");
		String valor2 = ParamUtil.getString(resourceRequest, "valor2");
		String valor3 = ParamUtil.getString(resourceRequest, "valor3");
		String valor4 = ParamUtil.getString(resourceRequest, "valor4");
		String tipo1 = ParamUtil.getString(resourceRequest, "tipo1");
		String tipo2 = ParamUtil.getString(resourceRequest, "tipo2");
		String tipo3 = ParamUtil.getString(resourceRequest, "tipo3");
		String tipo4 = ParamUtil.getString(resourceRequest, "tipo4");
		String utm_campaign = ParamUtil.get(resourceRequest, "stringUTM[utm_campaign]", "");
		String utm_source = ParamUtil.get(resourceRequest, "stringUTM[utm_source]", "");
		String utm_medium = ParamUtil.get(resourceRequest, "stringUTM[utm_medium]", "");
		String utm_content = ParamUtil.get(resourceRequest, "stringUTM[utm_content]", "");
		String codTipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");
		String pregunta1 = ParamUtil.getString(resourceRequest, "preg1[0]");
		String pregunta2 = ParamUtil.getString(resourceRequest, "preg2[0]");
		String pregunta3 = ParamUtil.getString(resourceRequest, "preg3[0]");
		String pregunta4 = ParamUtil.getString(resourceRequest, "preg4[0]");
		String respuesta1, respuesta2, respuesta3, respuesta4;
		
		this.setMontoOr(ParamUtil.getString(resourceRequest, "monto"));

		respuesta1 = ParamUtil.getString(resourceRequest, "resp1");
		respuesta2 = ParamUtil.getString(resourceRequest, "resp2");
		respuesta3 = ParamUtil.getString(resourceRequest, "resp3");
		respuesta4 = ParamUtil.getString(resourceRequest, "resp4");

		_log.info(tipo1 + " " + valor1 + " " + tipo2 + " " + valor2 + " " + tipo3 + " " + valor3 + " " + tipo4 + " " + valor4
		/* + " MONTO: " + monto */+ " UTM_CAMPAIGN: " + utm_campaign + " UTM_SOURCE: " + utm_source + " UTM_MEDIUM: " + utm_medium + " UTM_CONTENT: " + utm_content + " CODPERFILADOR: "
				+ codTipoPerfilador /* + " montoOr " + montoOr */+ " pregunta1 " + pregunta1 + " pregunta2 " + pregunta2 + " pregunta3 " + pregunta3 + " pregunta4 " + pregunta4 + " respuesta1 "
				+ respuesta1 + " respuesta2 " + respuesta2 + " respuesta3 " + respuesta3 + " respuesta4 " + respuesta4);

		String ip = "";

		if (SessionUtil.traerSession(resourceRequest).getIndicador() == 1) {
			tipoDoc = SessionUtil.traerSession(resourceRequest).getTipoDoc();
			numeroDoc = SessionUtil.traerSession(resourceRequest).getNumDoc();
		}

		// Obtener IP
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = httpServletRequest.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = httpServletRequest.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = httpServletRequest.getRemoteAddr();
		}

		_log.info("Tipo Perfilador " + codTipoPerfilador);

		String idSesion = SimuladoresUtil.traerCookie(resourceRequest, "JSESSIONID");
		PrintWriter writer = null;
		try {

			perfiladorProductoService.guardarDatosPerfilador(tipoDoc, numeroDoc, codTipoPerfilador, idSesion, "", 0, "", ip, pregunta1, pregunta2, pregunta3, pregunta4, respuesta1, respuesta2,
					respuesta3, respuesta4, new Date(), utm_source, utm_medium, utm_campaign, utm_content);
			/*
			 * Obtener resultados de Productos para el Perfilador
			 */

			Long idConfiguracionPerfilador = 0L;
			if (valor4 != null && !valor4.equals("")) {
				idConfiguracionPerfilador = Long.valueOf(valor4);
				if (tipo4.equals("slider")) {
					String config = ParamUtil.getString(resourceRequest, "idConfiguracion");
					idConfiguracionPerfilador = perfiladorProductoService.obtenerIdRangoRegistrar(config, valor4);
					_log.info("Convertir componente 4 del tipo Slider" + config + " : " + idConfiguracionPerfilador);
				}
			} else if (valor3 != null && !valor3.equals("")) {
				idConfiguracionPerfilador = Long.valueOf(valor3);
				if (tipo3.equals("slider")) {
					String config = ParamUtil.getString(resourceRequest, "idConfiguracion");
					idConfiguracionPerfilador = perfiladorProductoService.obtenerIdRangoRegistrar(config, valor3);
					_log.info("Convertir componente 3 del tipo Slider" + config + " : " + idConfiguracionPerfilador);
				}
			} else if (valor2 != null && !valor2.equals("")) {
				idConfiguracionPerfilador = Long.valueOf(valor2);
				if (tipo2.equals("slider")) {
					String config = ParamUtil.getString(resourceRequest, "idConfiguracion");
					idConfiguracionPerfilador = perfiladorProductoService.obtenerIdRangoRegistrar(config, valor2);
					_log.info("Convertir componente 2 del tipo Slider" + config + " : " + idConfiguracionPerfilador);
				}
			} else if (valor1 != null && !valor1.equals("")) {
				idConfiguracionPerfilador = Long.valueOf(valor1);
				if (tipo1.equals("slider")) {
					String config = ParamUtil.getString(resourceRequest, "idConfiguracion");
					idConfiguracionPerfilador = perfiladorProductoService.obtenerIdRangoRegistrar(config, valor1);
					_log.info("Convertir componente 1 del tipo Slider" + config + " : " + idConfiguracionPerfilador);
				}
			}

			List<ProductoBean> listaProd = perfiladorProductoService.obtenerListadoProductos(idConfiguracionPerfilador, resourceRequest);
			boolean flagSimular = false;
			for (ProductoBean pr : listaProd) {
				if (pr.isFlagSimulador()) {
					flagSimular = true;
					break;
				}
			}
			if (flagSimular) {
				if (codTipoPerfilador.equals(COD_PERFILADOR_HIPOTECARIO)) {
					SimuladorBean sim = new SimuladorBean();
					sim.setValorBien(this.getValorBienHipotecario());
					sim.setTipoCredito(this.getTipoCreditoHipotecario());
					sim.setTipoSimulador(SimuladoresUtil.SIMULADOR_HIPOTECARIO);
					sim.setTipoMoneda(SimuladoresUtil.CODIGO_MONEDA_SOLES+"");
					SimuladoresUtil.registrarSimulacion(resourceRequest, sim);
				} else {
					SimuladoresUtil.eliminarSimulacion(resourceRequest);
				}
			}

			Gson gson = new Gson();
			String gsonString = "";
			gsonString = gson.toJson(listaProd);
			
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(gsonString);
			writer.flush();

		} catch (Exception e) {
			_log.error("Error enviando datos perfilador " + e.toString());
		}finally{
			IOUtils.closeQuietly(writer);
		}

		// JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);

	}

	/**
	 * Calcular rango slider. Fecha: 24/06/2013
	 * 
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping("calcularRangoSlider")
	protected void calcularRangoSlider(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		String codTipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");
		Long monto = Long.valueOf(ParamUtil.getString(resourceRequest, "monto"));
		Integer iter = Integer.valueOf(ParamUtil.getString(resourceRequest, "iter"));
		Long idConfiguracionPerfilador = 0L;
		_log.info("Calcular Rango Slider " + monto);
		PrintWriter writer = null;
		try {
			List<RangoPerfiladorBean> lstRango = new ArrayList<RangoPerfiladorBean>();
			if(codTipoPerfilador.equals("1")){
				lstRango = rangoSlider1T_Ahorros.get(iter);
			} else if(codTipoPerfilador.equals("2")){
				lstRango = rangoSlider1T_Hipotecario.get(iter);
			}else if(codTipoPerfilador.equals("3")){
				lstRango = rangoSlider1T_Tarjetas.get(iter);
			}else if(codTipoPerfilador.equals("4")){
				lstRango = rangoSlider1T_Seguros.get(iter);
			}
			
			
			for (RangoPerfiladorBean rn : lstRango) {
				if (monto <= Long.valueOf(rn.getFinRango()) && monto >= Long.valueOf(rn.getInicioRango())) {
					idConfiguracionPerfilador = rn.getIdConfiguracionPerfilador();
					_log.info("Se encuentra en el rango del configurador Perfilador " + rn.getIdConfiguracionPerfilador());
					break;
				}

			}

			_log.info("el id del conf es " + idConfiguracionPerfilador);
			Gson gson = new Gson();
			String gsonString = "";
			gsonString = gson.toJson(idConfiguracionPerfilador);
			
			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
			writer = resourceResponse.getWriter();
			writer.write(gsonString);
			writer.flush();

		} catch (Exception e) {
			_log.error("Ocurrio un error al obtener el Rango del Slider " + e.toString());
		} finally{
			IOUtils.closeQuietly(writer);
		}

		// JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);

	}

	/**
	 * Establece el ear rangos slider controlador.
	 * 
	 * @param lstVariable el new ear rangos slider controlador
	 */
	private void setearRangosSliderControlador(List<VariablePerfiladorBean> lstVariable, String tipoPer) {

		
		for (VariablePerfiladorBean varP : lstVariable) {
			if (varP.getCodigoClasificacion() == 10) {
				Integer nivelA = varP.getNivel();
				List<RangoPerfiladorBean> lstRango = new ArrayList<RangoPerfiladorBean>();
				//
				int i = 0;
				for (VariablePerfiladorBean var : varP.getVarAsociadas()) {
					if (++i == 1) {
						long idRangoActual = var.getIdVariablePerfilador();
						_log.info("idRangoActual = " + idRangoActual);
					}
					RangoPerfiladorBean rango = new RangoPerfiladorBean();
					rango.setIdConfiguracionPerfilador(var.getIdVariablePerfilador());
					rango.setInicioRango(var.getValor1() != null ? Long.valueOf(var.getValor1()) : 0);
					rango.setFinRango(var.getValor2() != null ? Long.valueOf(var.getValor2()) : 0);
					lstRango.add(rango);
				}
//				this.getRangoSlider1T().put(nivelA, lstRango);
				if(tipoPer.equals("1")){
					this.getRangoSlider1T_Ahorros().put(nivelA, lstRango);
				} else if(tipoPer.equals("2")){
					this.getRangoSlider1T_Hipotecario().put(nivelA, lstRango);
				} else if(tipoPer.equals("3")){
					this.getRangoSlider1T_Tarjetas().put(nivelA, lstRango);
				} else if(tipoPer.equals("4")){
					this.getRangoSlider1T_Seguros().put(nivelA, lstRango);
				}
				
			}
		}
	}

	

	public Map<Integer, List<RangoPerfiladorBean>> getRangoSlider1T_Hipotecario() {
		return rangoSlider1T_Hipotecario;
	}

	public void setRangoSlider1T_Hipotecario(Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Hipotecario) {
		this.rangoSlider1T_Hipotecario = rangoSlider1T_Hipotecario;
	}

	public Map<Integer, List<RangoPerfiladorBean>> getRangoSlider1T_Seguros() {
		return rangoSlider1T_Seguros;
	}

	public void setRangoSlider1T_Seguros(Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Seguros) {
		this.rangoSlider1T_Seguros = rangoSlider1T_Seguros;
	}

	public Map<Integer, List<RangoPerfiladorBean>> getRangoSlider1T_Tarjetas() {
		return rangoSlider1T_Tarjetas;
	}

	public void setRangoSlider1T_Tarjetas(Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Tarjetas) {
		this.rangoSlider1T_Tarjetas = rangoSlider1T_Tarjetas;
	}

	public Map<Integer, List<RangoPerfiladorBean>> getRangoSlider1T_Ahorros() {
		return rangoSlider1T_Ahorros;
	}

	public void setRangoSlider1T_Ahorros(Map<Integer, List<RangoPerfiladorBean>> rangoSlider1T_Ahorros) {
		this.rangoSlider1T_Ahorros = rangoSlider1T_Ahorros;
	}

	/**
	 * Obtiene valor bien hipotecario. Fecha: 24/06/2013
	 * 
	 * @return valor bien hipotecario
	 */
	public String getValorBienHipotecario() {
		return valorBienHipotecario;
	}

	/**
	 * Establece el valor bien hipotecario.
	 * 
	 * @param valorBienHipotecario el new valor bien hipotecario
	 */
	public void setValorBienHipotecario(String valorBienHipotecario) {
		this.valorBienHipotecario = valorBienHipotecario;
	}

	/**
	 * Obtiene tipo credito hipotecario. Fecha: 24/06/2013
	 * 
	 * @return tipo credito hipotecario
	 */
	public String getTipoCreditoHipotecario() {
		return tipoCreditoHipotecario;
	}

	/**
	 * Establece el tipo credito hipotecario.
	 * 
	 * @param tipoCreditoHipotecario el new tipo credito hipotecario
	 */
	public void setTipoCreditoHipotecario(String tipoCreditoHipotecario) {
		this.tipoCreditoHipotecario = tipoCreditoHipotecario;
	}

//	@ResourceMapping("simularCreditoHipotecario")
//	protected void simularCreditoHipotecario(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//
//		String codTipoPerfilador = resourceRequest.getPreferences().getValue("tipoPerfilador", "");
//		String url = ParamUtil.getString(resourceRequest, "url");
//		String tipoCredito = ParamUtil.getString(resourceRequest, "producto");
//		JSonUtil jsonUtil = new JSonUtil();
//
//		_log.info("Ingreso a simularCreditoHipotecario " + codTipoPerfilador + " URL " + url + " tipo de Credito " + tipoCredito +  " monto " + this.getMontoOr());
//
//		try {
//			if (codTipoPerfilador.equals(COD_PERFILADOR_HIPOTECARIO)) {
//				SimuladorBean sim = new SimuladorBean();
//				sim.setValorBien(this.getMontoOr());
////				sim.setTipoCredito(tipoCredito);
//				jsonUtil.getSiebelHPC(tipoCredito);
//				_log.info("COFIGO " + jsonUtil.getSiebelHPC(tipoCredito));
//				SimuladoresUtil.registrarSimulacion(resourceRequest, sim);
//			}
//
//			JSONObject json;
//			json = JSONFactoryUtil.createJSONObject();
//			json.put("url", url);
//			resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
//			PrintWriter writer = resourceResponse.getWriter();
//			writer.write(json.toString());
//			writer.flush();
//			writer.close();
//
//		} catch (Exception e) {
//			_log.error("Error en simularCreditoHipotecario " + e.toString());
//		}
//
//		// JSonUtil.LogAuditoria(resourceRequest, indicadorPortlet, indicadorController);
//	}

	public String getMontoOr() {
		return montoOr;
	}

	public void setMontoOr(String montoOr) {
		this.montoOr = montoOr;
	}

	
}
