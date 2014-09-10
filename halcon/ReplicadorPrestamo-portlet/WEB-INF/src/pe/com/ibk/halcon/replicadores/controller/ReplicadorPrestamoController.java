/*
 * 
 */
package pe.com.ibk.halcon.replicadores.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.xhtmlrenderer.pdf.ITextRenderer;

import pe.com.ibk.halcon.replicadores.service.ReplicadorPrestamoService;
import pe.com.ibk.halcon.replicadores.utils.ReplicadorPrestamosUtil;

import com.exp.portlet.halcon.jaxb.Cabecera;
import com.exp.portlet.halcon.jaxb.Credito;
import com.exp.portlet.halcon.jaxb.Cuota;
import com.ext.portlet.halcon.dto.FormularioReplicadorBean;
import com.google.gson.Gson;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;
import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

// TODO: Auto-generated Javadoc
/**
 * Portlet implementation class ReplicadorPrestamoController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  05/11/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class ReplicadorPrestamoController {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ReplicadorPrestamoController.class);

	/** The captcha service. */
	@Autowired
	private GenericManageableCaptchaService captchaService;

	/** The replicador prestamo service. */
	@Autowired
	private ReplicadorPrestamoService replicadorPrestamoService;

	/**
	 * Default view.
	 * Fecha: 05/11/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {

		String tipoReplicador = renderRequest.getPreferences().getValue("tipoReplicador", "");
		_log.info(tipoReplicador);
		String page = "";
		if (tipoReplicador.equals("1")) {
			page = "replicadorCreditoHipotecario";
		} else if (tipoReplicador.equals("2")) {
			page = "replicadorCreditoPersonalGarantiaHipotecaria";
		} else if (tipoReplicador.equals("3")) {
			page = "replicadorCreditoPersonal";
		} else if (tipoReplicador.equals("4")) {
			page = "replicadorCreditoVehicular";
		} else {
			page = "view";
		}

		Date date = new java.util.Date();
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/yyyy");
		String fechaAc = sdf.format(date);
		renderRequest.setAttribute("fechaActual", fechaAc);

		return page;
	}

	/* Ejemplo del uso del metodo Action */
	/**
	 * Response action.
	 * Fecha: 05/11/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 */
	@ResourceMapping(value = "actionEnviar")
	protected void responseAction(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		ReplicadorPrestamosUtil.verificarCarpetaDiaria(resourceRequest);

		_log.info("responseAction");
		// Campos Comunes
		String numCredito = ParamUtil.getString(resourceRequest, "numCredito");
		String moneda = ParamUtil.getString(resourceRequest, "moneda");
		String montoFinanc = ParamUtil.getString(resourceRequest, "montoFinanciar");
		String tasaInteres = ParamUtil.getString(resourceRequest, "tasaInteres");
		String tipoCuota = ParamUtil.getString(resourceRequest, "cmbTipoCuotaHidden");
		String plazoMeses = ParamUtil.getString(resourceRequest, "plazoMeses");
		String periodoGracia = ParamUtil.getString(resourceRequest, "periodoGracia");
		String seguroDesgravamen = ParamUtil.getString(resourceRequest, "seguroDesg");
		String fechaDes = ParamUtil.getString(resourceRequest, "fechaDes");
		String diaVencim = ParamUtil.getString(resourceRequest, "diaVencim");
		String captcha = resourceRequest.getParameter("ingresacodigo");
		String tipoReplicador = resourceRequest.getParameter("tipoReplicador");


		// Otros
		String valorBien = ParamUtil.getString(resourceRequest, "valorBien");
		String porcentajeSeguro = ParamUtil.getString(resourceRequest, "porcSeguro");
		String montoSeguro = ParamUtil.getString(resourceRequest, "montoSeguro");
		String envioInforme = ParamUtil.getString(resourceRequest, "envioInforme");
	
		String cuotaBalon = ParamUtil.getString(resourceRequest, "cuotaBalon");
		String inteligente = ParamUtil.getString(resourceRequest, "inteligente");
		String result = "ok";

		// Vehicular
		String valorBienV = ParamUtil.getString(resourceRequest, "valorBienv");
		String montoFinanciarv = ParamUtil.getString(resourceRequest, "montoFinanciarv");

		Map<String, Object> data = new HashMap<String, Object>();

		try {

			// Validar Captcha
			boolean resCaptcha = replicadorPrestamoService.validarCaptcha(resourceRequest, captcha);
			//boolean resCaptcha = true;
			if (resCaptcha) {

				// Validar Credito
				int tipo = Integer.valueOf(tipoReplicador);
				int nume = Integer.valueOf(numCredito);
				int mone = Integer.valueOf(moneda);
				int resultadoWS = replicadorPrestamoService.validarCredito(tipo, nume, mone);

				ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
				String urlNueva = themeDisplay.getURLPortal() + themeDisplay.getURLCurrent();
				int indice = urlNueva.indexOf('?');
				urlNueva = urlNueva.substring(0, indice);

				// Generar Cronograma
				if (resultadoWS == 1) {

					FormularioReplicadorBean formulario = new FormularioReplicadorBean();
					formulario.setNroCredito(Integer.valueOf(numCredito));
					formulario.setMoneda(Integer.valueOf(moneda));
					formulario.setMontoFinanciar(Double.valueOf(montoFinanc));
					formulario.setTea(Double.valueOf(tasaInteres));
					formulario.setTipoCuota(Integer.valueOf(tipoCuota));
					formulario.setPlazoMeses(Integer.valueOf(plazoMeses));
					formulario.setPeriodoGracia(Integer.valueOf(periodoGracia));
					formulario.setSeguroDesgravamen(Double.valueOf(seguroDesgravamen));
					formulario.setFechaDesembolso(fechaDes);
					formulario.setDiaVencimiento(Integer.valueOf(diaVencim));
					formulario.setAplicativo(Integer.valueOf(ReplicadorPrestamosUtil.CODIGO_APLICATIVO));
					formulario.setGrupoPrestamo(tipo);

					// llenado datos no comunes
					formulario.setValorBien(0);
					formulario.setPorcentajeSeguro(0);
					formulario.setMontoSeguroBien(0);
					formulario.setEnvioInforme("0");
					formulario.setCuotaBalon(0);
					formulario.setCompraInteligente("0");

					if (!tipoReplicador.equals("3")) {
						if (Double.valueOf(montoSeguro) > 0) {
							formulario.setValorBien(Double.valueOf(montoSeguro));
						} else {
							formulario.setValorBien(Double.valueOf(valorBien));
						}
						formulario.setPorcentajeSeguro(Double.valueOf(porcentajeSeguro));
					}
					if (tipoReplicador.equals("4")) {
						formulario.setCompraInteligente(inteligente);
						if (cuotaBalon != null && !cuotaBalon.equals("")) {
							formulario.setCuotaBalon(Double.valueOf(cuotaBalon));
						}

					}
					if (tipoReplicador.equals("3") || tipoReplicador.equals("4")) {
						formulario.setEnvioInforme(envioInforme);
					}

					Object[] val = replicadorPrestamoService.generarCronograma(resourceRequest, formulario);

					Credito cred = (Credito) val[0];
					List<Cuota> cuota = (List<Cuota>) val[1];
					Cabecera cabec = (Cabecera) val[2];
					_log.info("val[3] " + val[3]);
					data.put("credito", cred);
					data.put("cuotas", cuota);
					data.put("cabecera", cabec);
					data.put("cabecera", cabec);

					PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
					String portletName = portletDisplay.getId();
					long plid = themeDisplay.getPlid();

					LiferayPortletURL urlDescarga = PortletURLFactoryUtil.create(resourceRequest, portletName, plid, PortletRequest.RESOURCE_PHASE);
					urlDescarga.setResourceID("descargarPDF");
					urlDescarga.setParameter("file", (String) val[3]);

					String nombrePDF = "CréditoHipotecario";

					if (tipoReplicador.equals("2")) {
						nombrePDF = "PréstamoPersonalconGarantía";
					} else if (tipoReplicador.equals("3")) {
						nombrePDF = "PréstamoPersonal";
					} else if (tipoReplicador.equals("4")) {
						nombrePDF = "CréditoVehicular";
					}

					data.put("result", "ok");
					urlDescarga.setParameter("name", nombrePDF);
					data.put("urlPDF", urlDescarga.toString());
					data.put("urlNuevaSim", urlNueva);

				} else if (resultadoWS == 2) {
					data.put("result", "error");
					data.put("strErrors", "errorWs");

				} else {
					data.put("result", "error");
					data.put("strErrors", "datosIncorrectos");
					data.put("urlNuevaSim", urlNueva);
				}

			} else {

				data.put("result", "error");
				data.put("strErrors", "ingresaCaptcha");
				_log.info(data.get("strErrors"));
			}

		} catch (Exception e) {
			data.put("result", "error");
			e.printStackTrace();
		}

		try {
			returnJson(data, resourceResponse);
		} catch (Exception e) {
			e.printStackTrace();
		}

		_log.info("DATOS ENVIAR " + "numCredito: " + numCredito + " moneda: " + moneda + " montoFinanc " + montoFinanc + " tasaInteres " + tasaInteres + " tipoCuota " + tipoCuota
				+ " plazoMeses " + plazoMeses + " periodoGracia " + periodoGracia + " seguroDesgravamen " + seguroDesgravamen + " fechaDes " + fechaDes + " diaVencim " + diaVencim);

	}

	/**
	 * Result wiev.
	 * Fecha: 05/11/2013
	 *
	 * @param model the model
	 * @param respuesta the respuesta
	 * @return the string
	 */
	@RequestMapping(params = "action=verResultado")
	protected String resultWiev(Model model, @RequestParam("respuesta") String respuesta) {
		model.addAttribute("respuesta", respuesta);
		return "replicadorCreditoVehicular";
	}

	/**
	 * Obtener imagen.
	 * Fecha: 05/11/2013
	 *
	 * @param resourceRequest the resource request
	 * @param resourceResponse the resource response
	 * @throws ImageFormatException the image format exception
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	@ResourceMapping("captcha")
	public void obtenerImagen(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws ImageFormatException, IOException {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		String captchaId = resourceRequest.getPortletSession().getId();
		BufferedImage challenge = captchaService.getImageChallengeForID(captchaId, resourceRequest.getLocale());
		JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(jpegOutputStream);
		jpegEncoder.encode(challenge);
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		resourceResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = (ServletOutputStream) resourceResponse.getPortletOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

	/**
	 * Return json.
	 * Fecha: 05/11/2013
	 *
	 * @param o the o
	 * @param resourceResponse the resource response
	 * @throws IOException Señales de que una excepción de E / S se ha producido.
	 */
	public static void returnJson(Object o, ResourceResponse resourceResponse) throws IOException {
		Gson gson = new Gson();
		String gsonString = gson.toJson(o);
		resourceResponse.setContentType(ContentTypes.APPLICATION_JSON);
		PrintWriter writer = resourceResponse.getWriter();
		writer.write(gsonString);
		writer.flush();
		writer.close();
	}

	/**
	 * Server resource.
	 * Fecha: 05/11/2013
	 *
	 * @param request the request
	 * @param response the response
	 */
	@ResourceMapping("descargarPDF")
	public void serverResource(ResourceRequest request, ResourceResponse response) {
		try {

			String filename = ParamUtil.getString(request, "file");
			_log.info("FILE " + filename);
			String name = ParamUtil.getString(request, "name", "");

			PortletContext context = request.getPortletSession().getPortletContext();

			String html = ReplicadorPrestamosUtil.getTemplateHTML(request, context.getRealPath(ReplicadorPrestamosUtil.CARPETA_TEMPLATE) + ReplicadorPrestamosUtil.getCarpetaDiaria() + filename);
			html = HtmlUtil.stripBetween(html, "meta");
			html = HtmlUtil.stripBetween(html, "a");
			html = HtmlUtil.stripComments(html);
			html = html.replaceFirst("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">", "");
			html = html.replaceFirst("<html xmlns=\"http://www.w3.org/1999/xhtml\">", "<html>");
			html = html.replaceFirst("</head>", "<style type=\"text/css\">@page {	margin: 2px;} </style></head>");

			ITextRenderer iTextRenderer = new ITextRenderer();
			// _log.info(html);
			iTextRenderer.setDocumentFromString(html);
			iTextRenderer.layout();

			response.setContentType("application/pdf");
			response.addProperty(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=replicador" + name + ".pdf");
			OutputStream elFichero = response.getPortletOutputStream();
			iTextRenderer.createPDF(elFichero);
			elFichero.flush();
			elFichero.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
