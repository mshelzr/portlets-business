package pe.com.ibk.halcon.solicitudes.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pe.com.ibk.halcon.solicitudes.cache.util.CacheSolicitudesUtil;
import pe.com.ibk.halcon.solicitudes.controller.FormularioSolicitarProductosController;
import pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService;
import pe.com.ibk.halcon.solicitudes.utils.Constantes;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.MailUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.SimuladoresUtil;
import com.exp.portlet.halcon.utils.TiempoUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.exp.portlet.halcon.utils.WsPrecalificacionServiceUtil;
import com.exp.portlet.halcon.utils.WsRegistroLeadsServiceUtil;
import com.ext.portlet.halcon.dto.ProductoComplementarioBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.dto.SolicitudProductoBean;
import com.ext.portlet.halcon.dto.SolicitudProductoResponseBean;
import com.ext.portlet.halcon.dto.TelefonoLeadBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.ProductoComplementario;
import com.ext.portlet.halcon.model.SolicitudProducto;
import com.ext.portlet.halcon.model.TelefonoSolicitudProducto;
import com.ext.portlet.halcon.service.SeguridadLocalServiceUtil;
import com.ext.portlet.halcon.service.SolicitudProductoLocalServiceUtil;
import com.liferay.mail.service.MailService;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleResource;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;


/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class FormularioSolicitarProductosServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service("formularioSolicitarProductosService")
public class FormularioSolicitarProductosServiceImpl implements FormularioSolicitarProductosService {

	private static String asuntoMail = "";
	private static String body1Mail = "";
	private static String body2Mail = "";
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(FormularioSolicitarProductosServiceImpl.class);
	
	/** The j son util. */
	//JSonUtil jSonUtil=new JSonUtil();
	
 	@Autowired
	private CacheSolicitudesUtil cachejsonUtil;
 	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#enviarCorreo(com.ext.portlet.halcon.dto.SolicitudProductoBean, javax.portlet.ResourceRequest)
	 */
	public int enviarCorreo(SolicitudProductoBean solicitud,
			ResourceRequest resourceRequest) {

		try {
			PortletContext context;
			ThemeDisplay themeDisplay;
			String template = null;
			String pathLectura;// , pathEscritura;
			long c = Calendar.getInstance().getTime().getTime();
			context = resourceRequest.getPortletSession().getPortletContext();
			pathLectura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + Constantes.CARPETA_PAGE_HTML;
			themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String rutaImagenes = themeDisplay.getPathThemeImages();
			String pathEscritura = context.getRealPath(Constantes.CARPETA_TEMPLATE) + "/MailingSolicitudesC" + c + ".html";
			StringBuilder cadena = new StringBuilder();
			String asunto = "";
			String nombres = "";
			String body1 = "";
			String body2 = "";
			String nombre=PortletProps.get("msj.mailing.nombre");
			nombres = solicitud.getPrimerNombre() + ",";
			
			if(ValidatorUtils.isNotNull(solicitud.getSegundoNombre())){
				nombres = solicitud.getPrimerNombre() + " "+ solicitud.getSegundoNombre()+ ",";
			}
			
			template = getTemplateHTML(resourceRequest, pathLectura);
			template = template.replaceAll("%NOMBRES%", nombres);
			template = template.replaceAll("%RUTA_IMAGEN%",(rutaImagenes + "/halcon"));
			template = template.replaceAll("%RUTA_CSS%",themeDisplay.getPathThemeCss());

			String correoREMI = "";
			String mensajeFelicitaciones = "";

			
			switch (solicitud.getIndicadorMailing()) {
			case 1:
				asunto = Constantes.ASUNTO_MAILING_CREDITO_HIPOTECARIO.replaceAll(",", ", "); 
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_HIPOTECARIA);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_CREDITO_HIPOTECARIO_1));
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_CREDITO_HIPOTECARIO_2));
				break;
			case 2:
				asunto = Constantes.ASUNTO_MAILING_CREDITO_VEHICULAR.replaceAll(",", ", ");
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_VEHICULAR);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_CREDITO_VEHICULAR_1,Constantes.MSJ_MAILING_PLAZO_48));
				break;
			case 3:
				asunto = Constantes.ASUNTO_MAILING_CUENTA_SUELDO.replaceAll(",", ", ");
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_CUENTA_SUELDO);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_CUENTA_SUELDO_1,Constantes.MSJ_MAILING_LINEA_2));
				break;
			case 4:
				asunto = Constantes.ASUNTO_MAILING_FONDOS_MUTUOS.replaceAll(",", ", ");
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_FONDOS_MUTUOS);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_FONDOS_MUTUOS_1,Constantes.MSJ_MAILING_LINEA_2));
				break;
			case 5:
				asunto = Constantes.ASUNTO_MAILING_PRESTAMO_PERSONAL.replaceAll(",", ", ");
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_PRESTAMO);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_PRESTAMO_PERSONAL_1,Constantes.MSJ_MAILING_PLAZO_72));
				break;
			case 6:
				buscarPatronPreAprobado(resourceRequest);
				asunto = asuntoMail;
				body1=body1Mail;
				body2=body2Mail;
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_PREAPROBADA);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",body1,body2));
				break;
			case 7:
				asunto = Constantes.ASUNTO_MAILING_SEGURO_SOAT.replaceAll(",", ", "); 
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_SOAT);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_SEGURO_SOAT_1,Constantes.MSJ_MAILING_LINEA_2));
				break;
			case 8:
				asunto = Constantes.ASUNTO_MAILING_TARJETA_CREDITO.replaceAll(",", ", ");
				mensajeFelicitaciones = Constantes.FELICITACIONES;
				correoREMI = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_TARJETA);
				cadena.append(String.format("<p style='font-size:13px; color:#747678;'>%s</p><p style='font-size:13px; color:#747678;'>%s</p>",Constantes.MSJ_MAILING_TARJETA_CREDITO_1,Constantes.MSJ_MAILING_PLAZO_48));
				break;
			default:
				break;
			}
			template = template.replaceAll("%ATRIBUTOS%", cadena.toString());
			template = template.replaceAll("%FELICITACIONES%",
					mensajeFelicitaciones);

			generateHTML(resourceRequest, template, pathEscritura);

			MailMessage mailMessage = new MailMessage();
			mailMessage.setHTMLFormat(true);
			mailMessage.setBody(template);
			mailMessage.setSubject(asunto);
			mailMessage.setFrom(new InternetAddress(nombre+"<"+correoREMI+">"));
			mailMessage.setTo(new InternetAddress(solicitud.getEmail()));
			MailService mailService = MailServiceUtil.getService();

			Thread.sleep(2000);
			mailService.sendEmail(mailMessage);

			return 1;
		} catch (Exception e) {
			_log.error("error:" + e);
			e.printStackTrace();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#enviarCorreoInterbank(com.ext.portlet.halcon.dto.SolicitudProductoBean, javax.portlet.ResourceRequest)
	 */
	public int enviarCorreoInterbank(SolicitudProductoBean solicitud,
			ResourceRequest resourceRequest) {
		try {
			// • Apellidos (Apellido Paterno y Apellido Materno)
			// • Nombres (Primer Nombre y Segundo Nombre)
			// • Tipo Documento
			// • Número Documento
			// • Teléfono (Celular / Teléfono de casa / Teléfono de trabajo/
			// Anexo)
			String apellidos = solicitud.getApellidoPaterno() + " " + solicitud.getApellidoMaterno();
			String nombres = solicitud.getPrimerNombre() + " " + solicitud.getSegundoNombre();
			String tipoDocumento = solicitud.getIdTipoDocumento().toString();
			String numeroDocumento = solicitud.getNumeroDocumento().toString();
			
			String telefono = solicitud.getCelular() + " / "
					+ solicitud.getTelefonoCasa() + " / "
					+ solicitud.getTelefonoTrabajo() + " / "
					+ solicitud.getAnexo();

			if (tipoDocumento.equals("2")) {
				tipoDocumento = "Carné Ext";
			} else {
				tipoDocumento = "DNI";
			}

			String correo = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_DESTINATARIO);
			String body = "<br/>" + "Apellidos: " + apellidos + "<br/>"
					+ "Nombres: " + nombres + "<br/>" + "Tipo Documento: "
					+ tipoDocumento + "<br/>" + "Número de Documento: "
					+ numeroDocumento + "<br/>" + "Teléfono: " + telefono
					+ "<br/>";
			String asunto = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_ASUNTO_SOAT);
			String correoCapa = (String) cachejsonUtil.getValor(JSonUtil.ETIQUETA_CORREO_SOLICITUDES_REMITENTE_SOAT);

			MailUtil.enviarMail(correo, body, asunto, correoCapa);

			return 1;
		} catch (Exception e) {
			_log.error("error:" + e);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * Obtiene template html.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param filePath the file path
	 * @return template html
	 */
	private String getTemplateHTML(ResourceRequest request, String filePath) {
		String templateHTML;

		templateHTML = "";
		try {
			BufferedReader bufferLectura;
			StringBuffer fileData;
			char[] buf;

			/* Leemos el template */
			bufferLectura = new BufferedReader(new FileReader(filePath));// Buffer
																			// de
																			// lectura
			fileData = new StringBuffer(1000);// Buffer de Escritura en cadena

			buf = new char[1024];
			int numRead = 0;
			while ((numRead = bufferLectura.read(buf)) != -1) {
				String readData = String.valueOf(buf, 0, numRead);
				fileData.append(readData);
				buf = new char[1024];
			}
			bufferLectura.close();

			templateHTML = fileData.toString();

		} catch (Exception e) {
		}
		return templateHTML;
	}

	/**
	 * Generate html.
	 * Fecha: 22/08/2013
	 *
	 * @param request the request
	 * @param html the html
	 * @param filePath the file path
	 */
	private void generateHTML(ResourceRequest request, String html, String filePath) {
		try {
			BufferedWriter bufferEscritura;
			Boolean CleanFileContent;

			/* Leemos el template */
			CleanFileContent = true;// Eliminar archivos SI
			bufferEscritura = new BufferedWriter(new FileWriter(filePath,
					!CleanFileContent));// Buffer de lectura
			bufferEscritura.write(html);
			bufferEscritura.close();

		} catch (Exception e) {
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#precalificacion(com.ext.portlet.halcon.dto.SolicitudProductoBean)
	 */
	public SolicitudProductoResponseBean precalificacion(
			SolicitudProductoBean productoBean) throws BusinessException {
		SolicitudProductoResponseBean solicitudProductoResponseBean;
		Integer estadoCivil = Integer.parseInt(productoBean.getIdEstadoCivil().toString());
		Integer situacionLaboral = Integer.parseInt(productoBean.getIdSituacionLaboral().toString());

		// se hace la convercion de algunos valores porque se necesitaran para
		// el ws de pre-calificacion
		// si existe tipo de documento
		if (ValidatorUtils.isNotNull(productoBean.getIdTipoDocumento())) {
			if (productoBean.getIdTipoDocumento().equals("2")) {
				productoBean.setIdTipoDocumentoAqd(Integer.valueOf(4));
				productoBean.setIdTipoDocumento("03");
			} else {
				productoBean.setIdTipoDocumentoAqd(Integer.valueOf(2));
				productoBean.setIdTipoDocumento("01");
			}
		}

		// si existe estado civil
		if (ValidatorUtils.isNotNull(estadoCivil)) {
			switch (estadoCivil) {
			case 1:
				break;
			case 2:
				estadoCivil = 4;
				break;
			case 3:
				estadoCivil = 5;
				break;
			case 4:
				estadoCivil = 6;
				break;
			case 5:
				estadoCivil = 7;
				break;
			default:
				break;
			}
			productoBean.setIdEstadoCivilAdq(estadoCivil);
		}

		// si existe situacion laboral
		if (ValidatorUtils.isNotNull(situacionLaboral)) {
			switch (situacionLaboral) {
			case 1:
				break;
			case 2:
				situacionLaboral = 3;
				break;
			case 3:
				situacionLaboral = 4;
				break;
			case 4:
				situacionLaboral = 5;
				break;
			case 5:
				situacionLaboral = 6;
				break;
			case 6:
				situacionLaboral = 7;
				break;
			case 7:
				situacionLaboral = 9;
				break;
			case 8:
				situacionLaboral = 10;
				break;
			case 9:
				situacionLaboral = 11;
				break;
			default:
				break;
			}
			productoBean.setIdSituacionLaboral(situacionLaboral + "");
		}

		solicitudProductoResponseBean = WsPrecalificacionServiceUtil.realizarWsPrecalificacion(productoBean);

		_log.info("***getCalificacion***:" + solicitudProductoResponseBean.getCalificacion());
		_log.info("***getCodigoAtencion****:" + solicitudProductoResponseBean.getCodigoAtencion());
		return solicitudProductoResponseBean;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#registroLeads(com.ext.portlet.halcon.dto.SolicitudProductoBean)
	 */
	@Override
	public SolicitudProductoResponseBean registroLeads(
			SolicitudProductoBean productoBean) throws BusinessException {
		SolicitudProductoResponseBean solicitudProductoResponseBean;
		// Aqui se cambia los datos que piden el servicio web
		// Tipo de Documento
		if (productoBean.getIdTipoDocumento().equals("2")) {
			productoBean.setIdTipoDocumento("03");
		} else {
			productoBean.setIdTipoDocumento("01");
		}
		setSexoLead(productoBean);
		setEstadoCivil(productoBean);

		solicitudProductoResponseBean = WsRegistroLeadsServiceUtil.registroLeads(productoBean);

		productoBean.setRespRegLead(String.valueOf(solicitudProductoResponseBean.getCodigoOportunidad()));
		return solicitudProductoResponseBean;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#registrarSolicitud(com.ext.portlet.halcon.dto.SolicitudProductoBean)
	 */
	public Integer registrarSolicitud(SolicitudProductoBean productoBean) {
		Integer intReturn = 0;
		List<ProductoComplementario> lista = new ArrayList<ProductoComplementario>();
		ProductoComplementario prod;
		for (ProductoComplementarioBean p : productoBean
				.getProductoComplementarios()) {
			prod = SolicitudProductoLocalServiceUtil
					.getInstanceComplementario();
			prod.setEmailSupervisor(p.getEmailSupervisor());
			prod.setIdGrupoProducto(p.getIdGrupoProducto());
			prod.setProducto(p.getProducto());
			prod.setIdProducto(p.getIdProducto());
			prod.setPrincipalidad(p.getPrincipalidad());
			lista.add(prod);
		}

		List<TelefonoSolicitudProducto> listaTelefono = new ArrayList<TelefonoSolicitudProducto>();
		TelefonoSolicitudProducto telefonoSolicitudProducto;

		for (TelefonoLeadBean telefonoLeadBean : productoBean.getTelefonoLeads()) {
			telefonoSolicitudProducto = SolicitudProductoLocalServiceUtil.getInstanceTelefono();
			telefonoSolicitudProducto.setTipoTelefono(telefonoLeadBean.getTipoTelefono());
			telefonoSolicitudProducto.setNumeroTelefono(telefonoLeadBean.getNumeroTelefono());
			telefonoSolicitudProducto.setAnexo(telefonoLeadBean.getAnexo());
			listaTelefono.add(telefonoSolicitudProducto);

		}

		try {
			intReturn = SolicitudProductoLocalServiceUtil.insertarSolicitud(setSolicitudProducto(productoBean), lista, listaTelefono);
		} catch (BusinessException e) {

			String asunto = Propiedades.getResourceBundle("formulario.solicitar.productos.formulario.solicitar.productos.serviceimpl.registrar.solicitud");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(productoBean),e.getTrazaMessage(), asunto,FormularioSolicitarProductosController.paginasHijas);
			_log.error(Propiedades.getResourceBundle("formulario.solicitar.productos.formulario.solicitar.productos.serviceimpl.registrar.solicitud")+ e.toString());
			
		}
		return intReturn;
	}

	/**
	 * Sets the solicitud producto.
	 * Fecha: 22/08/2013
	 *
	 * @param productoBean the producto bean
	 * @return the solicitud producto
	 */
	private SolicitudProducto setSolicitudProducto(SolicitudProductoBean productoBean) {
		setSexoLead(productoBean);
		setEstadoCivil(productoBean);
		
		
		SolicitudProducto solicitudProducto = SolicitudProductoLocalServiceUtil.getInstance();

		solicitudProducto.setCodigoCanal(productoBean.getCodigoCanal());
		if (ValidatorUtils.isNotNull(productoBean.getTipoEnvio())) {
			solicitudProducto.setTipoEnvio(String.valueOf(productoBean.getTipoEnvio()));
		}
		if (ValidatorUtils.isNotNull(productoBean.getIdTipoDocumentoAqd())) {
			solicitudProducto.setIdTipoDocumentoAdq(productoBean.getIdTipoDocumentoAqd());
		}

		if (ValidatorUtils.isNotNull(productoBean.getIdEstadoCivilAdq())) {
			solicitudProducto.setIdEstadoCivilAdq(productoBean.getIdEstadoCivilAdq());
		}

		if (ValidatorUtils.isNotNull(productoBean.getTipoCredito())) {
			solicitudProducto.setTipoCredito(productoBean.getTipoCredito());
		}

		solicitudProducto.setAnexo(productoBean.getAnexo());
		solicitudProducto.setApellidoMaterno(productoBean.getApellidoMaterno());
		solicitudProducto.setApellidoPaterno(productoBean.getApellidoPaterno());
		solicitudProducto.setCelular(productoBean.getCelular());
		solicitudProducto.setCorreoElectronico(productoBean.getEmail());
		solicitudProducto.setPrimerNombre(productoBean.getPrimerNombre());
		solicitudProducto.setDireccionEnvio(productoBean.getDireccionEnvio());
		solicitudProducto.setEstadoEnvCorreo(productoBean.isEstadoEnvCorreo());
		solicitudProducto.setEstadoPreCalificacion(productoBean.isEstadoPreCalificacion());
		solicitudProducto.setEstadoRegLead(productoBean.isEstadoRegLead());
		solicitudProducto.setFechaEnvioEmailing(TiempoUtil.getFechaStringDateSlashSQL(productoBean.getFechaEnvioEmailing()));
		//si es vacio o nulo
		if(ValidatorUtils.isNotNull(productoBean.getFechaEnvioLead())){
			solicitudProducto.setFechaEnvioLead(TiempoUtil.getFechaStringDateSlashSQL(productoBean.getFechaEnvioLead()));
		}
		solicitudProducto.setFechaNacimiento(TiempoUtil.getFechaStringDateSlash(productoBean.getFechaNacimiento()));
		solicitudProducto.setFechaRegistro(TiempoUtil.getTiempoActualEnDate());
		//si es vacio o nulo
		if(ValidatorUtils.isNotNull(productoBean.getFechaResultadoPreCalif())){
			solicitudProducto.setFechaResultadoPreCalif(TiempoUtil.getFechaStringDateSlashSQL(productoBean.getFechaResultadoPreCalif()));
		}
		solicitudProducto.setHorarioEnvio(TiempoUtil.getFechaStringDateSlashSQL(TiempoUtil.getFechaActualConPatronyDate("MM/dd/yyyy HH:mm:ss",new Date()), "MM/dd/yyyy HH:mm:ss"));
		solicitudProducto.setIdDepartamento(productoBean.getIdDepartamento());
		solicitudProducto.setIdDistrito(productoBean.getIdDistrito());
		if (ValidatorUtils.isNotNull(productoBean.getIdEstadoCivil())) {
			solicitudProducto.setIdEstadoCivil(productoBean.getIdEstadoCivil());
		}
		solicitudProducto.setIdProvincia(productoBean.getIdProvincia());
		if (ValidatorUtils.isNotNull(productoBean.getIdSituacionLaboral())) {
			solicitudProducto.setIdSituacionLaboral(Integer
					.valueOf(productoBean.getIdSituacionLaboral()));
		}
		solicitudProducto.setNomDepartamento(productoBean.getDepartamento());
		solicitudProducto.setNomDistrito(productoBean.getDistrito());
		solicitudProducto.setNomProvincia(productoBean.getProvincia());

		solicitudProducto.setNumeroDocumento(productoBean.getNumeroDocumento());
		solicitudProducto.setPlacaVehiculo(productoBean.getPlacaVehiculo());
		solicitudProducto.setRazonSocial(productoBean.getRazonSocial());
		if (ValidatorUtils.isNotNull(productoBean.getRentaMensual())) {
			solicitudProducto.setRentaMensual(Double.valueOf(productoBean.getRentaMensual()));
		}
//		_log.info("Respuesta de Precalificacion de Base de datos : " + productoBean.getRespuestaPreCalificacion());
		solicitudProducto.setRespPreCalificacion(productoBean.getRespuestaPreCalificacion());

		solicitudProducto.setRUC(productoBean.getRuc());
		solicitudProducto.setSegundoNombre(productoBean.getSegundoNombre());
		
		solicitudProducto.setSexo(productoBean.getTipoSexo());
	
		solicitudProducto.setSituacionLaboral(productoBean.getSituacionLaboral());
		solicitudProducto.setTelefonoCasa(productoBean.getTelefonoCasa());
		solicitudProducto.setTelefonoTrabajo(productoBean.getTelefonoTrabajo());
		solicitudProducto.setIdTipoDocumento(productoBean.getIdTipoDocumento());
		solicitudProducto.setUTMCampaing(productoBean.getUtmCampaing());
		solicitudProducto.setUTMContent(productoBean.getUtmContent());
		solicitudProducto.setIPCliente(JSonUtil.IP);
		solicitudProducto.setUTMMedium(productoBean.getUtmMedium());
		solicitudProducto.setUTMSource(productoBean.getUtmSource());
		solicitudProducto.setNombreSupervisor(productoBean.getResponsableAsignacion());
		solicitudProducto.setRespRegLead(productoBean.getRespRegLead());
		solicitudProducto.setIdSession(JSonUtil.ID_SESSION_USER);
		solicitudProducto.setCodigoCampania(productoBean.getCodigoCampana()); 
	
		return solicitudProducto;
	}

	// ***************************

	// *********CREADO POR GOHAN********/
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#guardarInformacion(com.ext.portlet.halcon.dto.SolicitudProductoBean, javax.portlet.ResourceRequest, boolean, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer guardarInformacion(SolicitudProductoBean solicitud,
			ResourceRequest resourceRequest, boolean registrarSolicitud,
			String codigoProducto, String etiqueta) {
		
		
		if (solicitud.getTelefonoLeads().isEmpty()) {
			TelefonoLeadBean telefonoLeads1 = new TelefonoLeadBean(JSonUtil.TELEFONO_CELULAR, solicitud.getCelular(), "");
			solicitud.getTelefonoLeads().add(telefonoLeads1);
			if (!solicitud.getTelefonoCasa().isEmpty()) {
				TelefonoLeadBean telefonoLeads2 = new TelefonoLeadBean(JSonUtil.TELEFONO_DE_RESIDENCIA,solicitud.getTelefonoCasa(), "");
			solicitud.getTelefonoLeads().add(telefonoLeads2);
			}else if (!solicitud.getAnexo().isEmpty()) {
				TelefonoLeadBean telefonoLeads3 = new TelefonoLeadBean(JSonUtil.TELEFONO_DE_TRABAJO,solicitud.getTelefonoTrabajo(), solicitud.getAnexo());
			solicitud.getTelefonoLeads().add(telefonoLeads3);
		}
		}

		//Integer valorRetorno = 0;
		Integer valorRetorno = 1;

		try {
			// 0 = INCORRECTO - false
			// 1 = CORRECTO - true
			// Primero se manda al servicio web la informacion
			SolicitudProductoResponseBean bean = registroLeads(solicitud);
			solicitud.setFechaEnvioLead(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
			
			if (!bean.getCodigoOportunidad().equalsIgnoreCase("")) {
				// CORRECTO
				solicitud.setEstadoRegLead(true);
				// Mandamos un email al cliente
				Integer respEmail = enviarCorreo(solicitud, resourceRequest);
				
				solicitud.setFechaEnvioEmailing(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
				if (respEmail == 0) {
					// Incorrecto email - Error al enviar el email
					solicitud.setEstadoEnvCorreo(false);
				} else {
					// Correcto email
					solicitud.setEstadoEnvCorreo(true);
				}
				valorRetorno = 1;
			} else {
				// INCORRECTO
				solicitud.setEstadoRegLead(false);
				// Registramos el error en el log
				LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),"", PortletProps.get("mensaje.error.lead"));
				//valorRetorno = 0;

				
				//CODIGO
				// Mandamos un email al cliente
				Integer respEmail = enviarCorreo(solicitud, resourceRequest);
				
				
				solicitud.setFechaEnvioEmailing(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
				if (respEmail == 0) {
					// Incorrecto email - Error al enviar el email
					solicitud.setEstadoEnvCorreo(false);
				} else {
					// Correcto email
					solicitud.setEstadoEnvCorreo(true);
				}
				valorRetorno = 0;
			}
			if (registrarSolicitud) {
				registrarGestionPeticion(resourceRequest, JSonUtil.IP,codigoProducto, etiqueta);
			}
		} catch (BusinessException e) {
			valorRetorno = 0;
			_log.error("Sucedio un error no controlado en el servicio web Registro de Leads");
			String asunto = Propiedades.getResourceBundle("formulario.solicitar.productos.formulario.solicitar.productos.serviceimpl.guardarInformacion");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),e.getTrazaMessage(), asunto+etiqueta);
			_log.error(Propiedades.getResourceBundle("formulario.solicitar.productos.formulario.solicitar.productos.serviceimpl.guardarInformacion")+ e.toString());
		}
		// Al final registramos la solicitud con sus estados
		// Seteamos los valores
		solicitud.setFechaRegistro(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
		solicitud.setHorarioEnvio(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy HH:mm:ss"));
		if (registrarSolicitud) {
			//solicitud.setRespuestaPreCalificacion("");
			solicitud.setRespuestaPreCalificacion("100"); //100: no es un código de ADQ, es un cpodigo para diferenciar producto que no pasan por ADQ 
			solicitud.setEstadoPreCalificacion(true);
			registrarSolicitud(solicitud);
		}
		return valorRetorno;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#comprobarPrecalificacion(com.ext.portlet.halcon.dto.SolicitudProductoBean, javax.portlet.ResourceRequest, java.lang.String, java.lang.String)
	 */
	@Override
	public Integer comprobarPrecalificacion(SolicitudProductoBean solicitud,
			ResourceRequest resourceRequest, String codigoProducto,
			String etiqueta) {
		TelefonoLeadBean telefonoLeads1 = new TelefonoLeadBean(JSonUtil.TELEFONO_CELULAR, solicitud.getCelular(), "");
		solicitud.getTelefonoLeads().add(telefonoLeads1);
		if (!solicitud.getTelefonoCasa().isEmpty()) {
			TelefonoLeadBean telefonoLeads2 = new TelefonoLeadBean(JSonUtil.TELEFONO_DE_RESIDENCIA, solicitud.getTelefonoCasa(),"");
		solicitud.getTelefonoLeads().add(telefonoLeads2);
		}else if(!solicitud.getTelefonoTrabajo().isEmpty()){

			TelefonoLeadBean telefonoLeads3 = new TelefonoLeadBean(JSonUtil.TELEFONO_DE_TRABAJO, solicitud.getTelefonoTrabajo(),solicitud.getAnexo());
		solicitud.getTelefonoLeads().add(telefonoLeads3);
		}
		
		/*
		int codigoRespCalificacion = Constantes.PRECALIFICACION_ERROR;
				
		try {
			SolicitudProductoResponseBean bean = precalificacion(solicitud);
			codigoRespCalificacion = bean.getCalificacion().intValue();
			solicitud.setFechaResultadoPreCalif(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
		*/
		int codigoRespCalificacion = Constantes.ESTADO_ADQ_ERROR;
		
				
		try {
			SolicitudProductoResponseBean bean = precalificacion(solicitud);
			int codigoEstadoADQ = bean.getCalificacion().intValue();
			codigoRespCalificacion = mapearEstadoADQ(codigoEstadoADQ);
			
			solicitud.setFechaResultadoPreCalif(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
			
			
			_log.info("Codigo de Precalificacion "+ codigoRespCalificacion);
			//if (codigoRespCalificacion == Constantes.PRECALIFICACION_PRE_CALIFICA) {
			if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PRE_CALIFICA) {
				// pre-califico
				solicitud.setRespuestaPreCalificacion(String.valueOf(codigoRespCalificacion));
				solicitud.setEstadoPreCalificacion(true);
				// se manda al servicio web registro leads la informacion
				int valorRetorno = guardarInformacion(solicitud,resourceRequest, false, codigoProducto, etiqueta);
				if (valorRetorno == 0) {
					//codigoRespCalificacion = Constantes.PRECALIFICACION_NO_DISPONIBLE;
					codigoRespCalificacion = Constantes.ESTADO_ADQ_PENDIENTE;
					LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),PortletProps.get("mensaje.error.exception"),PortletProps.get("mensaje.error.exception"));
				}
			//} else if (codigoRespCalificacion == Constantes.PRECALIFICACION_NO_PROCEDE) {
			} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_NO_PROCEDE) {
				// No procede
				solicitud.setRespuestaPreCalificacion(String.valueOf(codigoRespCalificacion));
				solicitud.setEstadoPreCalificacion(true);
				//Nueov cambio  05/11/2013
				solicitud.setEstadoRegLead(true);
			//} else if (codigoRespCalificacion == Constantes.PRECALIFICACION_NO_DISPONIBLE
			//		|| codigoRespCalificacion == Constantes.PRECALIFICACION_CUOTA_SEPARADA) {
			} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE) {
				solicitud.setRespuestaPreCalificacion(String.valueOf(codigoRespCalificacion));
				solicitud.setEstadoPreCalificacion(false);
				// Llamada a punto de extension
				//LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),(codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE)?PortletProps.get("mensaje.error.tres"):PortletProps.get("mensaje.error.cuatro"), (codigoRespCalificacion == Constantes.PRECALIFICACION_NO_DISPONIBLE)?PortletProps.get("mensaje.error.tres"):PortletProps.get("mensaje.error.cuatro"));
				LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),(codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE)?PortletProps.get("mensaje.error.tres"):PortletProps.get("mensaje.error.cuatro"), (codigoRespCalificacion == Constantes.ESTADO_ADQ_PENDIENTE)?PortletProps.get("mensaje.error.tres"):PortletProps.get("mensaje.error.cuatro"));
			} else if (codigoRespCalificacion == Constantes.ESTADO_ADQ_ERROR) {
				solicitud.setRespuestaPreCalificacion(String.valueOf(codigoRespCalificacion));
				solicitud.setEstadoPreCalificacion(true);
				//Nueov cambio  24/10/2013
				solicitud.setEstadoRegLead(true);
				LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),"", PortletProps.get("mensaje.error.precalificacion"));
			}
			registrarGestionPeticion(resourceRequest, JSonUtil.IP,codigoProducto, etiqueta);
		} catch (BusinessException e) {
			//Nueov cambio  24/10/2013
			solicitud.setEstadoRegLead(true);
			// Error no controlado
			_log.info("Sucedio un error no controlado en el servicio web Precalificacion");
			// LOG***************************************
			String asunto = Propiedades.getResourceBundle("formulario.solicitar.productos.formulario.solicitar.productos.serviceimpl.comprobarPrecalificacion");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(solicitud),e.getTrazaMessage(), asunto+etiqueta);// con este metodo graba el error
			_log.error(Propiedades.getResourceBundle("formulario.solicitar.productos.formulario.solicitar.productos.serviceimpl.comprobarPrecalificacion")+ e.toString());
		}

		// Seteamos los valores
		solicitud.setFechaRegistro(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy"));
		solicitud.setHorarioEnvio(TiempoUtil.getFechaActualConPatron("MM/dd/yyyy HH:mm:ss"));
		registrarSolicitud(solicitud);
		return codigoRespCalificacion;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#listarComplementario(javax.portlet.RenderRequest, org.springframework.ui.Model, com.ext.portlet.halcon.dto.SolicitudProductoBean, com.ext.portlet.halcon.dto.ProductoComplementarioBean)
	 */
	public void listarComplementario(RenderRequest renderRequest, Model model,
			SolicitudProductoBean solicitud,
			ProductoComplementarioBean productoPrincipal) {

		buscarPatronPreAprobado(renderRequest);
		
		JournalArticle articuloProducto;
		ThemeDisplay themeDisplay;
		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String responsableAsignacion = "";
		String idContenidoProdCompl = "";
		String emailSupervisor = "";
		String titulo = "";
		String siebel = "";
		String principalidad = Constantes.VALOR_WS_PRINCIPALIDAD;
		List<ProductoComplementarioBean> contenido =Collections.synchronizedList( new ArrayList<ProductoComplementarioBean>());
		try {
			// buscarProducto(renderRequest);
			articuloProducto = getArticulo(renderRequest, solicitud,productoPrincipal);

			if (Validator.isNotNull(articuloProducto)) {
				// Lista de Asset Entry de productos complementarios
				List<String> listAECodProCompl = getParseValueList("listaComplementarios", articuloProducto, themeDisplay.getLanguageId());
				responsableAsignacion = getParseValue("responsableAsignacion", articuloProducto, themeDisplay.getLanguageId());
				emailSupervisor = getParseValue("emailSupervisor",articuloProducto, themeDisplay.getLanguageId());

				solicitud.setResponsableAsignacion(responsableAsignacion);
				productoPrincipal.setEmailSupervisor(emailSupervisor);

				// _log.info("listAECodProCompl.." + listAECodProCompl);

				if (Validator.isNotNull(listAECodProCompl)) {
					Iterator<String> iter = listAECodProCompl.iterator();
					// recorrer la lista que contiene los codigos de Asset Entry
					// de productos complementarios
					while (iter.hasNext()) {
						String codProCompl = iter.next();

						// Realizar la busqueda de su codigo de producto
						// complementario
						AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(Long.parseLong(codProCompl));
						JournalArticleResource recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
						JournalArticle articuloComplementario = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(),recurso.getArticleId());

						// Id de contenido de productos complementarios
						idContenidoProdCompl = getParseValue("idContenidoComplementario",articuloComplementario,themeDisplay.getLanguageId());
						emailSupervisor = getParseValue("emailSupervisor",articuloComplementario,themeDisplay.getLanguageId());

						siebel = getParseValue("codigoSiebel",articuloComplementario,themeDisplay.getLanguageId());
						// _log.info("siebel.. " + siebel);
						siebel = cachejsonUtil.getSiebel(siebel);

						if (Validator.isNotNull(idContenidoProdCompl)) {
							try {
								articuloComplementario = JournalArticleLocalServiceUtil.getLatestArticle(themeDisplay.getScopeGroupId(),idContenidoProdCompl + "",WorkflowConstants.STATUS_APPROVED);
							

							} catch (Exception e) {
								_log.error("error al traer los complementarios");
							}
						}

						ProductoComplementarioBean c1 = new ProductoComplementarioBean();
						titulo = assetEntry.getTitle(themeDisplay.getLocale());

						c1.setIdContenidoWeb(idContenidoProdCompl); // ok
						c1.setPrincipalidad(principalidad); // ok
						c1.setProducto(titulo); // ok
						c1.setEmailSupervisor(emailSupervisor); // ok
						c1.setIdProducto(siebel); // ok
						c1.setSiebel(siebel);
						contenido.add(c1);

					}
					renderRequest.getPortletSession().setAttribute("listComplementarios", contenido,PortletSession.PORTLET_SCOPE);
					
					model.addAttribute("lstContenido", contenido);
				}
			}
		} catch (Exception e) {
			_log.error("error controlado, en listarComplementario");
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#traerBeanSimulador(javax.portlet.RenderRequest, com.ext.portlet.halcon.dto.SolicitudProductoBean)
	 */
	public void traerBeanSimulador(RenderRequest renderRequest, SolicitudProductoBean solicitud) {
		try {
			SimuladorBean nuevo = SimuladoresUtil.traerSimulacion(renderRequest);
			
			if (Validator.isNotNull(nuevo)) {
				String codigoCampania = "";
				String tipoMoneda = "";
				String montoPrestamo = "";

				codigoCampania = nuevo.getCodigoCampania();
				tipoMoneda = nuevo.getTipoMoneda();
				montoPrestamo = nuevo.getMontoPrestamo();

				solicitud.setCodigoCampana(codigoCampania);
				if ("1".equalsIgnoreCase(tipoMoneda)) {
					solicitud.setCodigoMoneda(PortletProps.get("moneda.soles"));
				} else {
					solicitud.setCodigoMoneda(PortletProps.get("moneda.dolares"));
				}
				solicitud.setMontoProspectado(montoPrestamo);
			}
		} catch (Exception e) {
			_log.info("Error - Devolucion de bean vacio",e);
		}
	}

	/**
	 * Obtiene articulo.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param solicitud the solicitud
	 * @param productoPrincipal the producto principal
	 * @return articulo
	 */
	public JournalArticle getArticulo(RenderRequest renderRequest, SolicitudProductoBean solicitud, ProductoComplementarioBean productoPrincipal) {
		long categoryId;
		long companyId;
		long groupId;
		
		JournalArticle resultado;
		JournalArticleResource recurso;
		List<Document> documentos;
		ThemeDisplay themeDisplay;
		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		categoryId = getCategoryIdbyName(companyId, groupId, "Productos");
		resultado = null;
		FormularioSolicitarProductosController.etiquetaProductoSiebel = solicitud.getEtiqueta();
		String etiqueta = FormularioSolicitarProductosController.etiquetaProductoSiebel;

		try {
			documentos = getLuceneContentSearch(renderRequest, categoryId, etiqueta);
			
			if (documentos != null && !documentos.isEmpty()) {
				JournalArticle articuloPadre = null;
				for (Document docs : documentos) {
					Document doc = docs;
					Long classPK;
					AssetEntry assetEntry;

					classPK = Long.parseLong(doc.get(Field.ENTRY_CLASS_PK));
					assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);
					recurso = JournalArticleResourceLocalServiceUtil.getArticleResource(assetEntry.getClassPK());
					resultado = JournalArticleLocalServiceUtil.getArticle(assetEntry.getGroupId(), recurso.getArticleId());
					String titulo = assetEntry.getTitle(themeDisplay.getLocale());

					productoPrincipal.setProducto(titulo);
					PortletSession pSession = renderRequest.getPortletSession();
					pSession.setAttribute("tituloProducto", titulo,PortletSession.PORTLET_SCOPE);

					String etiquetaDocumento = getParseValue("codigoSiebel",resultado,themeDisplay.getLanguageId());
					if(etiquetaDocumento.equalsIgnoreCase(solicitud.getEtiqueta())){
						articuloPadre = resultado;
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error("Error al obtener getArticuloRamdom:" + e.toString());
		}
		return resultado;
	}

	/**
	 * Obtiene category idby name.
	 * Fecha: 22/08/2013
	 *
	 * @param companyId the company id
	 * @param groupId the group id
	 * @param nombreCategoria the nombre categoria
	 * @return category idby name
	 */
	public static long getCategoryIdbyName(long companyId, long groupId,
			String nombreCategoria) {
		long categoryId = 0;
		/* Obtenemos la categoria desde el nombre */
		try {
			DynamicQuery queryCategoria = DynamicQueryFactoryUtil
					.forClass(AssetCategory.class,
							PortalClassLoaderUtil.getClassLoader())
					.add(PropertyFactoryUtil.forName("companyId").eq(companyId))
					.add(PropertyFactoryUtil.forName("groupId").eq(groupId))
					.add(PropertyFactoryUtil.forName("name").like(
							nombreCategoria));

			AssetCategory codassset = (AssetCategory) AssetCategoryLocalServiceUtil
					.dynamicQuery(queryCategoria).get(0);

			categoryId = codassset.getCategoryId();

		} catch (Exception e) {
			_log.error("Error al obetener el Id de Categoria:" + e.toString());
		}
		return categoryId;
	}

	/**
	 * Obtiene lucene content search.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @param categoryId the category id
	 * @param etiqueta the etiqueta
	 * @return lucene content search
	 */
	public static List<Document> getLuceneContentSearch(RenderRequest renderRequest, long categoryId, String etiqueta) {
		long companyId, groupId;
		ThemeDisplay themeDisplay;

		themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		companyId = themeDisplay.getCompanyId();
		groupId = themeDisplay.getScopeGroupId();
		List<Document> documentos = null;
		Hits resultados;

		try {
			SearchContext searchContext = SearchContextFactory.getInstance(PortalUtil.getHttpServletRequest(renderRequest));
			// Query que busca en el portal que deseemos
			BooleanQuery contextQuery = BooleanQueryFactoryUtil.create(searchContext);
			contextQuery.addRequiredTerm(Field.COMPANY_ID, companyId);
			contextQuery.addRequiredTerm(Field.GROUP_ID, groupId);
			// Query que busca que la cadena introducida por el usuairo está en
			// uno de los campos principales
			BooleanQuery searchQuery = BooleanQueryFactoryUtil.create(searchContext);
			// searchQuery.addTerm(Field.TITLE, palabraClave);
			// searchQuery.addTerm(Field.DESCRIPTION, palabraClave);
			searchQuery.addTerm(Field.CONTENT, etiqueta);
			// searchQuery.addTerm(Field.PROPERTIES, palabraClave);

			// Querypara buscador solo JournalContents
			BooleanQuery JCQuery = BooleanQueryFactoryUtil.create(searchContext);
			JCQuery.addRequiredTerm(Field.ENTRY_CLASS_NAME, JournalArticle.class.getName());
			JCQuery.addRequiredTerm(Field.STATUS, 0);

			// Querypara buscador solo Ciertas categorias
			BooleanQuery categoriaQuery = BooleanQueryFactoryUtil.create(searchContext);
			categoriaQuery.addRequiredTerm(Field.ASSET_CATEGORY_IDS, categoryId);

			// Query
			// expandoQuery=StringQueryFactoryUtil.create("expando/custom_fields/destacado:si");
			// Creamos query completa para enlazar las demás obligando a que el
			// enlace sea un AND en lugar de un OR
			BooleanQuery fullQuery = BooleanQueryFactoryUtil.create(searchContext);
			fullQuery.add(contextQuery, BooleanClauseOccur.MUST);
			fullQuery.add(searchQuery, BooleanClauseOccur.MUST);
			fullQuery.add(JCQuery, BooleanClauseOccur.MUST);
			fullQuery.add(categoriaQuery, BooleanClauseOccur.MUST);
			
			// Añadimos ordenación (nombre descendente)
			Sort sort = new Sort();
			sort.setFieldName(Field.CREATE_DATE);
			sort.setType(Sort.STRING_TYPE);
			sort.setReverse(true);
			
			// Recorremos resultados
			resultados = SearchEngineUtil.search(SearchEngineUtil.getDefaultSearchEngineId(), companyId, fullQuery, sort, -1, -1);
			documentos = resultados.toList();
		} catch (Exception e) {
			_log.error("Error al realizar la busqueda Lucene:" + e.toString());
		}
		return documentos;
	}

	/**
	 * Obtiene parses the value.
	 * Fecha: 22/08/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parses the value
	 */
	public String getParseValue(String fieldname, JournalArticle article, String languageID) {
		String value = null;
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil
					.read(article.getContentByLocale(languageID));
			Node node = document
					.selectSingleNode("/root/dynamic-element[@name='"
							+ fieldname + "']/dynamic-content");

			value = node.getText();
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return value;
	}

	/**
	 * Obtiene parses the value list.
	 * Fecha: 22/08/2013
	 *
	 * @param fieldname the fieldname
	 * @param article the article
	 * @param languageID the language id
	 * @return parses the value list
	 */
	public List<String> getParseValueList(String fieldname,
			JournalArticle article, String languageID) {
		List<String> value = null;
		try {
			com.liferay.portal.kernel.xml.Document document = SAXReaderUtil
					.read(article.getContentByLocale(languageID));
			List<Node> node = document
					.selectNodes("/root/dynamic-element[@name='" + fieldname
							+ "']/dynamic-content");
			for (Node nodo : node) {
				if (value == null)
					value = new ArrayList<String>();
				String valor = nodo.getText();
				if (ValidatorUtils.isNotNull(valor)) {
					value.add(valor);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return value;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#validarGestionPeticion(javax.portlet.ResourceRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean validarGestionPeticion(ResourceRequest renderRequest,
			String ip, String codigoProducto, String etiqueta) {
		Boolean pasoValidacionGestionPeticion = false;
		Object[] peticionValida = null;
		try {
			peticionValida = SeguridadLocalServiceUtil.validar(renderRequest,
					ip, codigoProducto, etiqueta);
			if (peticionValida != null) {
				pasoValidacionGestionPeticion = (Boolean) peticionValida[0];
				return pasoValidacionGestionPeticion;
			}
		} catch (BusinessException e) {
			String jsonError = "{ip:" + JSonUtil.IP + ", codigoProducto"
					+ codigoProducto + "}";
			String asunto = Propiedades
					.getResourceBundle("formulario.solicitar.producto.formulario.solicitar.productos.serviceimpl.validar.gestion.peticion");
			LogErrorUtil.registrarError(jsonError, e.getTrazaMessage(), asunto);
			_log.error(asunto + e.toString());
			return pasoValidacionGestionPeticion;
		} catch (Exception e) {
			_log.info("Error Exception - Gestion Peticiones");
			e.printStackTrace();
			return pasoValidacionGestionPeticion;
		}
		return pasoValidacionGestionPeticion;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.solicitudes.service.FormularioSolicitarProductosService#registrarGestionPeticion(javax.portlet.ResourceRequest, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Boolean registrarGestionPeticion(ResourceRequest renderRequest,
			String ip, String codigoProducto, String etiqueta) {
		Boolean pasoValidacionGestionPeticion = false;
		Object[] peticionValida = null;
		try {
			peticionValida = SeguridadLocalServiceUtil.validar(renderRequest,
					ip, codigoProducto, etiqueta);
			if (peticionValida != null) {
				pasoValidacionGestionPeticion = (Boolean) peticionValida[0];
				return pasoValidacionGestionPeticion;
			}
		} catch (BusinessException e) {
			String jsonError = "{ip:" + JSonUtil.IP + ", codigoProducto"
					+ codigoProducto + "}";
			String asunto = Propiedades
					.getResourceBundle("formulario.solicitar.producto.formulario.solicitar.productos.serviceimpl.registrar.gestion.peticion");
			LogErrorUtil.registrarError(jsonError, e.getTrazaMessage(), asunto);
			return pasoValidacionGestionPeticion;
		} catch (Exception e) {
			_log.info("Error Exception - Gestion Peticiones");
			e.printStackTrace();
			return pasoValidacionGestionPeticion;
		}
		return pasoValidacionGestionPeticion;
	}
	
	
	/**
	 * Establece el sexo lead.
	 *
	 * @param productoBean el new sexo lead
	 */
	private void setSexoLead(SolicitudProductoBean productoBean){
		if (productoBean.getTipoSexo().equals("1")) {
			productoBean.setTipoSexo("Masculino");
		} else if(productoBean.getTipoSexo().equals("2")){
			productoBean.setTipoSexo("Femenino");
		}
	}
	
	/**
	 * Establece el estado civil.
	 *
	 * @param productoBean el new estado civil
	 */
	private void setEstadoCivil(SolicitudProductoBean productoBean){
		if (ValidatorUtils.isNotNull(productoBean.getIdEstadoCivil())) {
			try {
				Integer estadoCivil = Integer.parseInt(productoBean.getIdEstadoCivil().toString());
				switch (estadoCivil) {
				case 1:
					productoBean.setIdEstadoCivil("Soltero");
					break;
				case 2:
					productoBean.setIdEstadoCivil("Divorciado");
					break;
				case 3:
					productoBean.setIdEstadoCivil("Conviviente");
					break;
				case 4:
					productoBean.setIdEstadoCivil("Viudo");
					break;
				case 5:
					productoBean.setIdEstadoCivil("Casado");
					break;
				default:
					productoBean.setIdEstadoCivil("Sin Valor");
					break;
				}
			} catch (Exception e) {
				_log.error("ya paso por lead " + e.getMessage());
			}
		}
	}
	
	private void buscarPatronPreAprobado(PortletRequest portletRequest){
		
		HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(portletRequest));
//		HIPOTECARI, VIVIENDA, TECHO, 	HIPOTECARIO
//		TARJETA							TARJETA
//		SUELDO							SUELDO
//		FONDOS 							MUTUOS	FONDOS MUTUOS
//		PRESTAMO  						HIPOTECA	PRESTAMO
//		auto, vehicul, compra inteligente
		
		String urlProductoSolicitud = ParamUtil.getString(httpReq, "pro");
		
		
		String urlTipoSolicitud = ParamUtil.getString(httpReq, "sol");
		
		
		String etiquetaSolicitudProducto = SolicitudProductoLocalServiceUtil.getEtiquetaSolicitudByFriendlyURL("/" + urlTipoSolicitud);

		
		//trae asuntos
		if(etiquetaSolicitudProducto.contains("SOLICITUD_PREAPROBADA")){

			
			asuntoMail = PortletProps.get("SOLICITUDES.TITULO.SOLICITUD_PREAPROBADA." + urlProductoSolicitud);
			asuntoMail = asuntoMail.replaceAll(",", ", ");

		

			body1Mail = PortletProps.get("SOLICITUDES.BODY1.SOLICITUD_PREAPROBADA." + urlProductoSolicitud);
			body1Mail = body1Mail.replaceAll(",", ", ");

			
			body2Mail = PortletProps.get("SOLICITUDES.BODY2.SOLICITUD_PREAPROBADA." + urlProductoSolicitud);
			body2Mail = body2Mail.replaceAll(",", ", ");

		}
		

  }
	
	public int mapearEstadoADQ(int codigoBus) {
		//	String FilePath = JSonUtil.PATH_CARPETA + File.separator + "estados_adq.json";
			String FilePath = JSonUtil.getPathJsonWasModificada() +  "estados_adq.json";
		//	String FilePath= "D:/Utilidades/liferay-portal-6.1.20-ee-ga2/tomcat-7.0.27/webapps/GestionParametros-portlet/js/resources/estados_adq.json";
			_log.info("Marco Risco - JSON PATH: " + FilePath);
			String strEstadoADQ = "";
			int estadoADQ = Constantes.ESTADO_ADQ_ERROR;
			
			try {
				FileInputStream in = new FileInputStream(FilePath);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String strLine; 

				StringBuilder buf = new StringBuilder();
				while((strLine = br.readLine())!= null)	{
					buf.append(strLine);
				}
				
				_log.info("MRM - " + buf.toString());
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray(buf.toString());
				for (int i=0; i<jsonArray.length(); i++) {
					JSONObject jobj = jsonArray.getJSONObject(i);
					
					if (codigoBus == jobj.getInt("id")) {
						strEstadoADQ = jobj.getString("etiqueta");
						break;
					}
				}
				
				if (strEstadoADQ.equals("ESTADO_ADQ_ERROR")){
					estadoADQ = Constantes.ESTADO_ADQ_ERROR;
				} else if (strEstadoADQ.equals("ESTADO_ADQ_NO_PROCEDE")){
					estadoADQ = Constantes.ESTADO_ADQ_NO_PROCEDE;
				} else if (strEstadoADQ.equals("ESTADO_ADQ_PRE_CALIFICA")){
					estadoADQ = Constantes.ESTADO_ADQ_PRE_CALIFICA;
				} else if (strEstadoADQ.equals("ESTADO_ADQ_PENDIENTE")){
					estadoADQ = Constantes.ESTADO_ADQ_PENDIENTE;
				} else {
					estadoADQ = Constantes.ESTADO_ADQ_ERROR;
				}
				
			} catch(Exception e){
				//_log.error("buscarEstadoADQ " + e.getMessage());
				//	System.out.println(e.getStackTrace());
				e.printStackTrace(System.out);
			}
			
			_log.info("resultado : " + estadoADQ);
			return estadoADQ;
		}

	
}