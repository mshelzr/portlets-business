package pe.com.ibk.halcon.replicadores.service.impl;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.replicadores.service.ReplicadorPrestamoService;
import pe.com.ibk.halcon.replicadores.utils.ReplicadorPrestamosUtil;

import com.exp.portlet.halcon.jaxb.Cabecera;
import com.exp.portlet.halcon.jaxb.Credito;
import com.exp.portlet.halcon.jaxb.Cuota;
import com.exp.portlet.halcon.utils.WsReplicadorServiceUtil;
import com.ext.portlet.halcon.dto.FormularioReplicadorBean;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.PortletDisplay;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.octo.captcha.service.multitype.GenericManageableCaptchaService;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ReplicadorPrestamoServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  05/11/2013
 * @version Halcon 1.0
 */
@Service("replicadorPrestamoServiceImpl")
public class ReplicadorPrestamoServiceImpl implements ReplicadorPrestamoService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ReplicadorPrestamoServiceImpl.class);

	/** The captcha service. */
	@Autowired
	private GenericManageableCaptchaService captchaService;

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.replicadores.service.ReplicadorPrestamoService#validarCaptcha(javax.portlet.ResourceRequest, java.lang.String)
	 */
	public boolean validarCaptcha(ResourceRequest request, String captcha) {
		boolean captchaPassed = captchaService.validateResponseForID(request.getPortletSession().getId(), captcha);

		return captchaPassed;

	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.replicadores.service.ReplicadorPrestamoService#validarCredito(int, int, int)
	 */
	public int validarCredito(int grupoCredito, int numCredito, int moneda) {
		int res = 0;

		try {
			res = WsReplicadorServiceUtil.validarCredito(numCredito, grupoCredito, moneda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.replicadores.service.ReplicadorPrestamoService#generarCronograma(javax.portlet.PortletRequest, com.ext.portlet.halcon.dto.FormularioReplicadorBean)
	 */
	public Object[] generarCronograma(PortletRequest portletRequest, FormularioReplicadorBean form) {
		Object[] val = new Object[4];
		try {
			val = WsReplicadorServiceUtil.generarNuevoReplicador(form);

			Credito cred = (Credito) val[0];
			List<Cuota> cuota = (List<Cuota>) val[1];
			Cabecera cabec = (Cabecera) val[2];

			String nombreFile = generarHTMLCronograma(portletRequest, cred, cuota, cabec, form);
			val[3] = nombreFile;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * Generar html cronograma.
	 * Fecha: 05/11/2013
	 *
	 * @param portletRequest the portlet request
	 * @param credito the credito
	 * @param cuotas the cuotas
	 * @param cabecera the cabecera
	 * @param form the form
	 * @return the string
	 */
	private String generarHTMLCronograma(PortletRequest portletRequest, Credito credito, List<Cuota> cuotas, Cabecera cabecera, FormularioReplicadorBean form) {
		String pathLectura, pathEscritura, template, urlDetalle;
		PortletContext context;

		String nombreTemplate = "";
		String nombreCredito = "";
		String grupoReplicador = String.valueOf(form.getGrupoPrestamo());
		if (grupoReplicador.equals("1")) {
			nombreCredito = "Crédito Hipotecario";
			nombreTemplate = ReplicadorPrestamosUtil.TEMPLATE_REPLICADOR_HIPOTECARIO;
		} else if (grupoReplicador.equals("2")) {
			nombreCredito = "Préstamo Personal con Garantía Hipotecaria";
			nombreTemplate = ReplicadorPrestamosUtil.TEMPLATE_REPLICADOR_HIPOTECARIO;
		} else if (grupoReplicador.equals("3")) {
			nombreCredito = "Préstamo Personal";
			nombreTemplate = ReplicadorPrestamosUtil.TEMPLATE_REPLICADOR_PERSONAL;
		} else {
			nombreCredito = "Préstamo Vehicular";
			nombreTemplate = ReplicadorPrestamosUtil.TEMPLATE_REPLICADOR_VEHICULAR;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
		context = portletRequest.getPortletSession().getPortletContext();
		pathLectura = context.getRealPath(ReplicadorPrestamosUtil.CARPETA_TEMPLATE) + nombreTemplate;
		Date fechaActual = new Date();
		long codigo = fechaActual.getTime();
		pathEscritura = context.getRealPath(ReplicadorPrestamosUtil.CARPETA_TEMPLATE) + ReplicadorPrestamosUtil.getCarpetaDiaria() + ReplicadorPrestamosUtil.ARCHIVO_REPLICADOR_PREFIX + codigo
				+ ".html";
		_log.info(" pathEscritura " + pathEscritura);
		template = ReplicadorPrestamosUtil.getTemplateHTML(portletRequest, pathLectura);
		// //Reemplazamos la cabecera

		DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
		simbolo.setDecimalSeparator('.');
		simbolo.setGroupingSeparator(',');
		DecimalFormat format = new DecimalFormat("###,##0.00", simbolo);
		DecimalFormat format4 = new DecimalFormat("###,##0.0000", simbolo);

		template = template.replaceAll("%NRO_CREDITO%", String.valueOf(form.getNroCredito()));
		template = template.replaceAll("%PRODUCTO%", nombreCredito);
		template = template.replaceAll("%MONEDA%", credito.getMoneda());
		template = template.replaceAll("%MONTO_FINANCIAR%", format.format(Double.valueOf(credito.getMontoFinanciar())));
		template = template.replaceAll("%TASA_INTERES%", format.format(Double.valueOf(credito.getTasaInteres())));
		template = template.replaceAll("%TCEA%", format.format(Double.valueOf(credito.getTasaCostoEfectivo())));
		template = template.replaceAll("%TIPO_CUOTA%", credito.getTipoCuota());
		template = template.replaceAll("%PLAZO%", credito.getPlazo() + "");
		template = template.replaceAll("%PERIODO_GRACIA%", credito.getPlazoGracia() + "");
		template = template.replaceAll("%TASA_SEGURO_DES%", format4.format(Double.valueOf(credito.getTasaSeguroDesgravamen())));
		template = template.replaceAll("%FECHA_DESEMBOLSO%", form.getFechaDesembolso());
		template = template.replaceAll("%DIA_VENCIMIENTO%", String.valueOf(form.getDiaVencimiento()));
		template = template.replaceAll("%RUTA_CSS%", themeDisplay.getPathThemeCss());
		template = template.replaceAll("%RUTA_IMG%", themeDisplay.getPathThemeImages());

		template = template.replaceAll("%VALOR_INMUEBLE%", format.format(Double.valueOf(credito.getMontoValorBien())));
		template = template.replaceAll("%TASA_SEGURO_BIEN%", format4.format(Double.valueOf(credito.getTasaSeguroBien())));
		template = template.replaceAll("%CUOTA_BALON%", format.format(Double.valueOf(form.getCuotaBalon())));
		template = template.replaceAll("%INFORME_PAGO%", form.getEnvioInforme().equals("1") ? "Sí" : "No");
		template = template.replaceAll("%COMPRA_INTELIGENTE%", form.getCompraInteligente().equals("1") ? "Sí" : "No");

		String clase;
		StringBuilder htmlDetalle;

		htmlDetalle = new StringBuilder();
		clase = "CH-simple";

		int i = 0;
		for (Cuota cuota : cuotas) {

			if (i % 2 == 0) {
				clase = "CH-destacados";
			} else {
				clase = "CH-simple";
			}

			htmlDetalle.append(String.format("<div class='%s'>", clase));
			htmlDetalle.append(String.format("<span class='cuota'>%s</span>", cuota.getCorrelativoCuota()));
			htmlDetalle.append(String.format("<span class='vencimiento'>%s</span>", cuota.getFechaVencimiento()));
			htmlDetalle.append(String.format("<span class='s-inicial'>%s</span>", format.format(Double.valueOf(cuota.getSaldoDeuda()))));
			htmlDetalle.append(String.format("<span class='amortizacion'>%s</span>", format.format(Double.valueOf(cuota.getAmortizacion()))));
			htmlDetalle.append(String.format("<span class='interes'>%s</span>", format.format(Double.valueOf(cuota.getInteres()))));
			htmlDetalle.append(String.format("<span class='s-desgra'>%s</span>", format.format(Double.valueOf(cuota.getSeguroDesgravamen()))));
			htmlDetalle.append(String.format("<span class='s-bien'>%s</span>", format.format(Double.valueOf(cuota.getSeguroBien()))));
			htmlDetalle.append(String.format("<span class='comision'>%s</span>", format.format(Double.valueOf(cuota.getComision()))));
			htmlDetalle.append(String.format("<span class='m-cuota'>%s</span>", format.format(Double.valueOf(cuota.getCuota()))));
			htmlDetalle.append("<div class='both'></div></div>");

		}
		template = template.replaceAll("%DETALLE_SIMULACION%", htmlDetalle.toString());

		template = template.replaceAll("%TOTAL_AMOTIZACIONES%", format.format(Double.valueOf(cabecera.getAmortizacion())));
		template = template.replaceAll("%TOTAL_INTERESES%", format.format(Double.valueOf(cabecera.getInteres())));
		template = template.replaceAll("%TOTAL_SEGURO_DESGRAVAMEN%", format.format(Double.valueOf(cabecera.getSeguroDesgravamen())));
		template = template.replaceAll("%TOTAL_SEGURO_BIEN%", format.format(Double.valueOf(cabecera.getSeguroBien())));
		template = template.replaceAll("%TOTAL_COMISION%", format.format(Double.valueOf(cabecera.getComision())));
		template = template.replaceAll("%TOTAL_MONTO_CUOTA%", format.format(Double.valueOf(cabecera.getCuota())));

		//
		// //Generamos la url de descarga
		urlDetalle = ReplicadorPrestamosUtil.ARCHIVO_REPLICADOR_PREFIX + codigo + ".html";
		// /*Creamos la URL Tipos de Operacion*/
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
		String portletName = portletDisplay.getId();
		long plid = themeDisplay.getPlid();
		LiferayPortletURL urlDescarga = PortletURLFactoryUtil.create(portletRequest, portletName, plid, PortletRequest.RESOURCE_PHASE);
		urlDescarga.setResourceID("descargarPDF");
		urlDescarga.setParameter("file", urlDetalle);
		urlDescarga.setParameter("name", nombreCredito.trim());
		template = template.replaceAll("%URL_DESCARGA%", urlDescarga.toString());
		ReplicadorPrestamosUtil.generateHTML(portletRequest, template, pathEscritura);

		return urlDetalle;
	}
}
