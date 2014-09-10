package pe.com.ibk.halcon.simulacion.service.impl;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.print.PrintTranscoder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.simulacion.bean.CalculoBean;
import pe.com.ibk.halcon.simulacion.bean.GraficoBean;
import pe.com.ibk.halcon.simulacion.cache.util.CacheSimulacionUtil;
import pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService;
import pe.com.ibk.halcon.simulacion.utils.ResultadoSimulacionUtil;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.dto.PlazoBean;
import com.ext.portlet.halcon.dto.SimuladorBean;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.FondosMutuos;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.service.FondosMutuosLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.ImgTemplate;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTemplate;
import com.lowagie.text.pdf.PdfWriter;

/* Agregado por Jaime */


/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class SimuladorFondosMutuosServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class SimuladorFondosMutuosServiceImpl implements
		SimuladorFondosMutuosService {

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(SimuladorFondosMutuosServiceImpl.class);	
	//private static final String CODIGO_GRUPO="5";
	/** The j son util. */
	@Autowired
	 private CacheSimulacionUtil cacheSimulacionUtil;

	/** The meses. */
	private String[] meses = { "Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago",
			"Sep", "Oct", "Nov", "Dic" };
	
	/** The tiempos. */
	private String[] tiempos = {"30 días","90 días","180 días","1 año","2 años","3 años","5 años"};
	
	/** The tipo moneda. */
	private String tipoMoneda;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#simular(javax.portlet.PortletRequest, javax.portlet.PortletResponse, com.ext.portlet.halcon.dto.SimuladorBean)
	 */
	@Override
	public void simular(PortletRequest portletRequest,PortletResponse portletResponse, SimuladorBean simulador) 
	{	
		boolean showGraficoJchar 		= false;
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
		//Verificamos el navegador para utilizar el jfreechart
		if (BrowserSnifferUtil.isIe(httpServletRequest) && (BrowserSnifferUtil.getMajorVersion(httpServletRequest) <= 8)) {
			showGraficoJchar = true;
		}
		
		String flagGrafico 			= "1";
		String tipoMoneda 				= simulador.getTipoMonedaFondosMutuos();
		int totalPuntos 				= simulador.getTotalPuntos();
		String plazoCredito 			= simulador.getPlazoCredito();
		double cuotaInicial 			= Double.parseDouble(simulador.getValorBien());
		
		
		String simboloMoneda 			= "US$ ";

		Parametro getPlazoParametro;
		List<Parametro> listFondosMutuos = null;
		Calendar fechaInicio = null;
		Integer separacion 	= 0;
		Integer numeroDias = 0;
		FondosMutuos fondosMutuos = null;

		String flagTotalFechas = "PLAZO_TABLA_FONDO_MUTUO";
		
		if (tipoMoneda.equals("00")) {
			simboloMoneda = "S/. ";
			tipoMoneda = "S/.";
		}else{
			tipoMoneda = "US$";
		}

		try {
			getPlazoParametro = FondosMutuosLocalServiceUtil.consultarDiasDesdeIdentificadorSlider(flagTotalFechas, plazoCredito);
			
			listFondosMutuos = FondosMutuosLocalServiceUtil.consultarFondoMutuoTipos(Integer.valueOf(totalPuntos), tipoMoneda,JSonUtil.ETIQUETA_ZONAS_RIESGO_FONDOS_MUTUOS);
			
			separacion 	= Integer.parseInt(getPlazoParametro.getValorMonto2()); 
			
			numeroDias = Integer.parseInt(getPlazoParametro.getValorMonto1());
			
			fechaInicio = Calendar.getInstance();
			fechaInicio.add(Calendar.DAY_OF_MONTH, -1);
			
			//fechaInicio = Calendar.getInstance();//observación obtener la última fecha de registro de la BD
			fondosMutuos = FondosMutuosLocalServiceUtil.consultarUltimaFecha();
			
			if(fondosMutuos != null && fondosMutuos.getFecha() != null){
				try {
					fechaInicio.setTime(dateFormat.parse(fondosMutuos.getFecha()));
				} catch (ParseException e) {
					_log.error("Error convirtiendo formato de fecha : ",e);
				}
			}
			
			fechaInicio.add(Calendar.DAY_OF_MONTH,-numeroDias);
		}
		catch (BusinessException e) 
		{
			String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.fondosmutuos.serviceimpl.simular1");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
			_log.error(asunto,e);
		}		
		
		
		
		String jsonAbreHeader 	= "[['Año'";
		String jsonCierraHeader 	= "],";
		String cierreJson 			= "]";
		List<String> fechaLista 	= new ArrayList<String>();
		
		int recorrido = numeroDias/separacion;
		
		for (int i = 0; i < recorrido + 1; i++) 
		{
			fechaLista.add(fechaInicio.get(Calendar.YEAR)+"-"+rellenarMes(fechaInicio)+"-"+rellenar_dia(fechaInicio));
			fechaInicio.add(Calendar.DAY_OF_MONTH, separacion);
		}
		
		try {
			//Verificamos que la ultima fecha sea del ultimo registro
			fechaInicio = Calendar.getInstance();
			fechaInicio.add(Calendar.DAY_OF_MONTH, -1); // fecha último registro en BD
			
			if(fondosMutuos != null && fondosMutuos.getFecha() != null){
				try {
					fechaInicio.setTime(dateFormat.parse(fondosMutuos.getFecha()));
				} catch (ParseException e) {
					_log.error("Error convirtiendo formato de fecha : ",e);
				}
			}
			
			Date ultimaFechaLista = dateFormat.parse(fechaLista.get(fechaLista.size()-1));
			Date ultimaFechaRegistrada = dateFormat.parse(fechaInicio.get(Calendar.YEAR)+"-"+rellenarMes(fechaInicio)+"-"+rellenar_dia(fechaInicio));
			if (ultimaFechaLista.compareTo(ultimaFechaRegistrada)  > 0) {
				fechaLista.set(fechaLista.size()-1, fechaInicio.get(Calendar.YEAR)+"-"+rellenarMes(fechaInicio)+"-"+rellenar_dia(fechaInicio));
			} else if(ultimaFechaLista.compareTo(ultimaFechaRegistrada)  < 0){
				fechaLista.add(fechaInicio.get(Calendar.YEAR)+"-"+rellenarMes(fechaInicio)+"-"+rellenar_dia(fechaInicio));
			}
		} catch (ParseException e) {
			_log.error("Error al convertir fecha: ",e);
		}
		
		
		int contador = 0;
		String tipoFondo1 = "";
		String tipoFondo2 = "";
		String tipoFondo3 = "";

		Integer tipoFondo = listFondosMutuos.size();
		
		for (Parametro valores : listFondosMutuos) 
		{
			if (contador == 0) 
			{			
				tipoFondo1 = valores.getDato4();
				jsonAbreHeader += ",'" + valores.getDato1() + "'";
			}
			if (contador == 1) 
			{			
				tipoFondo2 = valores.getDato4();
				jsonAbreHeader += ",'" + valores.getDato1() + "'";
			}
			if (contador >= 2) 
			{				
				tipoFondo3 = valores.getDato4();
				jsonAbreHeader += ",'" + valores.getDato1() + "'";
			}			
			contador++;
		}

		String templateJson = jsonAbreHeader + jsonCierraHeader;

		List<Object[]> porcentajeFondosMutuos;
		
		String rFechaFondo = "";
		
		Double rRentabilidad1 = 0.0;

		Double rRentabilidad2 = 0.0;

		Double rRentabilidad3 = 0.0;

		double rentabilidadTotal1 = 0.0;
		double rentabilidadTotal2 = 0.0;
		double rentabilidadTotal3 = 0.0;

		String pathLectura = "";
		String rutaArchivo = "";

		
		try 
		{
			
			porcentajeFondosMutuos = FondosMutuosLocalServiceUtil.consultarFondosMutuosParte(tipoMoneda, tipoFondo1,
							tipoFondo2, tipoFondo3, separacion, fechaLista);
			
			CalculoBean calculoBean = new CalculoBean();
			List<GraficoBean> lista = ResultadoSimulacionUtil.getListGrafico(porcentajeFondosMutuos, dateFormat,calculoBean);
			

			rentabilidadTotal1 = (lista.get(lista.size()-1).getValorCuota1()/lista.get(0).getValorCuota1())-1 ;
			rentabilidadTotal2 = (lista.get(lista.size()-1).getValorCuota2()/lista.get(0).getValorCuota2())-1 ;

			rentabilidadTotal1 = rentabilidadTotal1 * cuotaInicial + cuotaInicial;
			rentabilidadTotal2 = rentabilidadTotal2 * cuotaInicial + cuotaInicial;
			if (tipoFondo > 2) {
				rentabilidadTotal3 = (lista.get(lista.size()-1).getValorCuota3()/lista.get(0).getValorCuota3())-1 ;
				rentabilidadTotal3 = rentabilidadTotal3 * cuotaInicial + cuotaInicial;
			}
			
			for (GraficoBean valores_porcentaje : lista) 
			{

				rFechaFondo = dateFormat.format(valores_porcentaje.getFecha1());
				
				rRentabilidad1 = valores_porcentaje.getRentabilidad1();
				rRentabilidad2 = valores_porcentaje.getRentabilidad2();
				rRentabilidad3 = valores_porcentaje.getRentabilidad3();
				

				String[] fechaSplit;
				String fechaJson = "";

				if (rFechaFondo != null) 
				{
					fechaSplit = rFechaFondo.split("-");
					if (fechaSplit[1] != null && fechaSplit[0] != null) 
					{
						if(separacion < 30)
						{
							fechaJson = fechaSplit[2]+" "+meses[Integer.parseInt(fechaSplit[1]) - 1] + " " + fechaSplit[0];							
						}
						else
						{
							fechaJson = meses[Integer.parseInt(fechaSplit[1]) - 1] + " " + fechaSplit[0];	
						}
					}
				}

					templateJson += " ['" + fechaJson + "' ";				
					templateJson += "," + Math.round((rRentabilidad1  * cuotaInicial)+cuotaInicial);
					templateJson += "," + Math.round((rRentabilidad2 * cuotaInicial)+cuotaInicial);
					if (tipoFondo > 2) {
						templateJson += "," +Math.round((rRentabilidad3   * cuotaInicial)+cuotaInicial);
					}
				templateJson += "],";
			}
			templateJson = templateJson.substring(0,templateJson.length()-1);
			templateJson += cierreJson;
			portletRequest.setAttribute("file_name_pdf", "javascript:void(0)");
			if(!showGraficoJchar){				
				portletRequest.setAttribute("file_name_pdf", "javascript:void(0)");
			}else{
				flagGrafico = "2";	
				PortletContext context;
				context = portletRequest.getPortletSession().getPortletContext();
				
				String nombre_grafico = "Gra_" + new Date().getTime();				
				pathLectura = context.getRealPath("/grafico") + "/"+ nombre_grafico + ".jpg";				
				rutaArchivo = "grafico/" + nombre_grafico + ".jpg";
				crearGrafico(pathLectura, lista, nombre_grafico , separacion,tipoFondo,cuotaInicial,calculoBean);
				
			}			

		} catch (BusinessException e) 
		{
			String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.fondosmutuos.serviceimpl.simular2");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
			_log.error(asunto,e);
		}		
		
		portletRequest.setAttribute("grafico_json", templateJson);
		
		portletRequest.setAttribute("grafico", rutaArchivo);
		portletRequest.setAttribute("pathLectura", pathLectura);
		portletRequest.setAttribute("flag_grafico", flagGrafico);
		portletRequest.setAttribute("lista", listFondosMutuos);
		portletRequest.setAttribute("simbolo", simboloMoneda);		
		portletRequest.setAttribute("rentabilidad1", rentabilidadTotal1);		
		portletRequest.setAttribute("rentabilidad2", rentabilidadTotal2);		
		portletRequest.setAttribute("rentabilidad3", rentabilidadTotal3);
		portletRequest.setAttribute("cuotaInicial", cuotaInicial);
		portletRequest.setAttribute("plazoCredito", plazoCredito);
		portletRequest.setAttribute("tipoMoneda", tipoMoneda);
		
		guardarHistorialSimulador(portletRequest, simulador);
	}

	/**
	 * Round_r.
	 * Fecha: 22/08/2013
	 *
	 * @param numero the numero
	 * @return the double
	 */
	public double round_r(double numero){
		return Math.round(numero*Math.pow(10,2))/Math.pow(10,2);
	}
	
	/**
	 * Restar dias.
	 * Fecha: 22/08/2013
	 *
	 * @param fecha the fecha
	 * @param dias the dias
	 * @return the calendar
	 */
	public Calendar restarDias(Calendar fecha, int dias) 
	{
		fecha.add(Calendar.DATE,-dias);
		return fecha;		
	}

	/**
	 * Creates the dataset.
	 * Fecha: 22/08/2013
	 *
	 * @param PorcentajeFondosMutuos the porcentaje fondos mutuos
	 * @param separacion the separacion
	 * @param cantidadFondos the cantidad fondos
	 * @param cuotaInicial the cuotaInicial
	 * @return the category dataset
	 */
	public CategoryDataset createDataset(List<GraficoBean> porcentajeFondosMutuos ,int separacion,int cantidadFondos,double cuotaInicial) {
	
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		Integer rTipoFondo1 = 0;
		String rFechaFondo = "";
		Double rRentabilidad1 = 0.0;
		Integer rTipoFondo2 = 0;
		Double rRentabilidad2 = 0.0;
		Integer rTipoFondo3 = 0;
		Double rRentabilidad3 = 0.0;

		for (GraficoBean valores_porcentaje : porcentajeFondosMutuos) {
			rTipoFondo1 = valores_porcentaje.getTipoFondo1();
			rFechaFondo = dateFormat.format(valores_porcentaje.getFecha1());
			rRentabilidad1 = valores_porcentaje.getRentabilidad1();

			rTipoFondo2 =  valores_porcentaje.getTipoFondo2();
			rRentabilidad2 = valores_porcentaje.getRentabilidad2();

			rTipoFondo3 = valores_porcentaje.getTipoFondo3();
			rRentabilidad3 = valores_porcentaje.getRentabilidad3();

			String[] fechaSplit;
			String fechaJson = "";

			if (rFechaFondo != null && rFechaFondo != "") {
				fechaSplit = rFechaFondo.split("-");
				if (fechaSplit[1] != null && fechaSplit[0] != null) 
				{	
					if(separacion < 30)
					{
						fechaJson = fechaSplit[2]+" "+meses[Integer.parseInt(fechaSplit[1]) - 1] + " " + fechaSplit[0];							
					}
					else
					{
						fechaJson = meses[Integer.parseInt(fechaSplit[1]) - 1] + " " + fechaSplit[0];	
					}
				}
			}
			
			dataset.addValue(Math.round((rRentabilidad1  * cuotaInicial)+cuotaInicial), rTipoFondo1, fechaJson);
			dataset.addValue(Math.round((rRentabilidad2  * cuotaInicial)+cuotaInicial), rTipoFondo2, fechaJson);
			if(cantidadFondos > 2){
				dataset.addValue(Math.round((rRentabilidad3 * cuotaInicial)+cuotaInicial), rTipoFondo3, fechaJson);
			}
		}
		return dataset;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#createChart(org.jfree.data.category.CategoryDataset)
	 */
	
	public JFreeChart createChart(CategoryDataset dataset,double cuotaInicial,CalculoBean calculoBean) {
		JFreeChart chart = ChartFactory.createLineChart("", "", "Rentabilidad   ("+tipoMoneda+")", dataset,PlotOrientation.VERTICAL, false, false, false);

		chart.setBackgroundPaint(Color.white);
		chart.setBorderVisible(false);
		

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
	    plot.setBackgroundPaint(Color.white);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.lightGray);
		plot.setOutlineVisible(false);

		
		plot.getRangeAxis().setRange((calculoBean.getMenor() * cuotaInicial + cuotaInicial),(calculoBean.getMayor() * cuotaInicial + cuotaInicial));
		
		
		final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
		Stroke stroke = new BasicStroke(2f, BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
		renderer.setBaseOutlineStroke(stroke);
		
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		   
		//Dar color a cada barra
	    GradientPaint gp0= new GradientPaint(0.0f,0.0f,Color.RED,0.0f,0.0f,new Color(0,0,64));
	    GradientPaint gp1= new GradientPaint(0.0f,0.0f,Color.GREEN,0.0f,0.0f,new Color(0,64,0));
	    GradientPaint gp2= new GradientPaint(0.0f,0.0f,new Color(247, 190, 122),0.0f,0.0f,new Color(64,0,0));
	    renderer.setSeriesPaint(0,gp0);
	    renderer.setSeriesPaint(1,gp1);
	    renderer.setSeriesPaint(2,gp2);
	    
		
		return chart;
	}

	/**
	 * Crear grafico.
	 * Fecha: 22/08/2013
	 *
	 * @param name_grafico the name_grafico
	 * @param PorcentajeFondosMutuos the porcentaje fondos mutuos
	 * @param nombre_grafico the nombre_grafico
	 * @param separacion the separacion
	 * @param cantidadFondos the cantidad fondos
	 * @param cuotaInicial the cuotaInicial
	 */
	public void crearGrafico(String name_grafico,
			List<GraficoBean> PorcentajeFondosMutuos, String nombre_grafico,
			int separacion,int cantidadFondos,double cuotaInicial,CalculoBean calculoBean) {
		CategoryDataset dataset = createDataset(PorcentajeFondosMutuos,separacion,cantidadFondos,cuotaInicial);
		JFreeChart chart = createChart(dataset,cuotaInicial,calculoBean);
		try {
			File grafico = new File(name_grafico);
			ChartUtilities.saveChartAsJPEG(grafico, chart, 580, 310);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * rellenarMes.
	 * Fecha: 22/08/2013
	 *
	 * @param mes the mes
	 * @return the string
	 */
	public String rellenarMes(Calendar mes){
		
		String mesCurrent = String.valueOf(mes.get(Calendar.MONTH)+1).trim();	
		if(mesCurrent.length() == 1)
		{
			return "0"+mesCurrent;
		}
		return mesCurrent;
	}
	
	/**
	 * Rellenar_dia.
	 * Fecha: 22/08/2013
	 *
	 * @param dia the dia
	 * @return the string
	 */
	public String rellenar_dia(Calendar dia)
	{		
		String diaCurrent = String.valueOf(dia.get(Calendar.DAY_OF_MONTH)).trim();	
		if(diaCurrent.length() == 1)
		{
			return "0"+diaCurrent;
		}
		return diaCurrent;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#createDataset(java.util.List)
	 */
	@Override
	public CategoryDataset createDataset(List<Object[]> PorcentajeFondosMutuos) {
		return null;
	}
	
	/**
	 * Crear_pdf2.
	 * Fecha: 22/08/2013
	 *
	 * @param portletRequest the portlet request
	 */
	@SuppressWarnings("deprecation")
	public void crear_pdf2(PortletRequest portletRequest) 
	{
		
		Document document = new Document();
		
		try 
		{	
			PortletContext context;
			context = portletRequest.getPortletSession().getPortletContext();			
			String pathCurrent = context.getRealPath("/pdf");			
					
					
			String svgURIInput = new File(pathCurrent+"/test.svg").toURL().toString();
			
			PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(pathCurrent+"/exportar2.pdf"));

			document.open();
			float width = 500;
			float height = 500;
			PdfContentByte cb = writer.getDirectContent();
			
			PdfTemplate template = cb.createTemplate(width, height);
			Graphics2D g2 = template.createGraphics(width, height);
			
			PrintTranscoder prm = new PrintTranscoder();
			TranscoderInput ti = new TranscoderInput(svgURIInput);			
			prm.transcode(ti, null);

			PageFormat pg = new PageFormat();
			Paper pp = new Paper();
			pp.setImageableArea(0, 0, width, height);
			pg.setPaper(pp);
			prm.print(g2, pg, 0);			
			g2.dispose();

			ImgTemplate img = new ImgTemplate(template);
			document.add(img);
			
		} catch (DocumentException e) {
			System.err.println(e);
		} catch (IOException e) {
			System.err.println(e);
		}
		document.close();
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#createTableHeader(com.lowagie.text.Document, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createTableHeader(Document documento, String title,String optionGroup,String pathEscrituraImagen)
			throws BadElementException {
		try {
			//Aqui crea los productos
			String[] titulos;
			titulos = title.trim().split("\\|");
			int rows;
			if (titulos.length == 2) {
				rows = 4;
			} else {
				rows = 6;
			}
			PdfPTable table = new PdfPTable(rows);
			PdfPCell c1;

			for (int i = 0; i < titulos.length; i++) {
				Image grafico = Image.getInstance(pathEscrituraImagen+"/"+(i+1)+".jpg");
				c1 = new PdfPCell(grafico);
				c1.setFixedHeight(30);
				c1.setBackgroundColor(new Color(241, 241, 241));
				c1.setBorder(0);
				c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				if (i == 0) {
					c1.setPaddingLeft(2);
				}
				table.addCell(c1);
				
				c1 = new PdfPCell(new Phrase(titulos[i], new Font(Font.HELVETICA,
						9f, Font.NORMAL, new Color(149, 149, 149))));
				c1.setFixedHeight(30);
				c1.setHorizontalAlignment(Element.ALIGN_LEFT);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c1.setBackgroundColor(new Color(241, 241, 241));
				c1.setBorder(0);
				table.addCell(c1);
			}
			if (titulos.length == 2) {
				table.setWidths(new int[]{10,100,10,100});
			} else {
				table.setWidths(new int[]{10,100,10,100,10,100});
			}

			documento.add(table);
			
			//Aqui crea los option de dias
			documento.add(new Paragraph(" "));
			
			
			
			PdfPTable table2 = new PdfPTable(tiempos.length+1);
			table2.setHorizontalAlignment(Element.ALIGN_RIGHT);

			for (int i = 0; i < tiempos.length; i++) {
				if (optionGroup.split(" ")[0].trim().equalsIgnoreCase(tiempos[i].split(" ")[0].trim())) {
					c1 = new PdfPCell(new Phrase(tiempos[i], new Font(Font.HELVETICA,9f, Font.NORMAL, Color.white)));
					c1.setBackgroundColor(new Color(0, 155, 61));
				} else {
					c1 = new PdfPCell(new Phrase(tiempos[i], new Font(Font.HELVETICA,9f, Font.NORMAL, new Color(149, 149, 149))));
					c1.setBackgroundColor(new Color(178, 232, 206));
				}
				if(i != tiempos.length-1){
					c1.setBorderColorRight(new Color(96, 183, 140));
					c1.setBorderWidthRight(1);
				}else{
					c1.setBorderWidthRight(0);
				}
				c1.setFixedHeight(20);
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c1.setBorderWidthBottom(0);
				c1.setBorderWidthLeft(0);
				c1.setBorderWidthTop(0);
				
				table2.addCell(c1);
			}
			//Una fila para dar espacio
			c1 = new PdfPCell(new Phrase("", new Font(Font.HELVETICA,9f, Font.NORMAL, Color.WHITE)));
			c1.setBackgroundColor(Color.WHITE);
			c1.setBorder(0);
			table2.addCell(c1);
			
			
			table2.setWidths(new int[]{20,20,25,20,20,20,20,20});
			documento.add(table2);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#createTableListaFondosMutuos(com.lowagie.text.Document, java.lang.String)
	 */
	@Override
	public void createTableListaFondosMutuos(Document documento, String datos)
			throws BadElementException {
		String[] contenido;
		contenido = datos.trim().split("\\-");

		PdfPTable table = new PdfPTable(4);
		PdfPCell c1;

		addEmptyLine(documento, 3);

		c1 = new PdfPCell(
				new Phrase("Tipo de Inversión", new Font(
						Font.HELVETICA, 9f, Font.NORMAL, new Color(85, 84, 84))));
		c1.setFixedHeight(50);
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setBackgroundColor(new Color(241, 241, 241));
		c1.setBorderWidthBottom(1);
		c1.setBorderWidthLeft(0);
		c1.setBorderWidthRight(0);
		c1.setBorderWidthTop(0);
		c1.setBorderColor(new Color(220, 221, 222));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Partirías con", new Font(Font.HELVETICA,
				9f, Font.NORMAL, new Color(85, 84, 84))));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setBackgroundColor(new Color(241, 241, 241));
		c1.setBorderWidthBottom(1);
		c1.setBorderWidthLeft(0);
		c1.setBorderWidthRight(0);
		c1.setBorderWidthTop(0);
		c1.setBorderColor(new Color(220, 221, 222));
		table.addCell(c1);

		c1 = new PdfPCell(new Phrase("Hoy tendrías*", new Font(Font.HELVETICA,
				9f, Font.NORMAL, new Color(85, 84, 84))));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setBackgroundColor(new Color(241, 241, 241));
		c1.setBorderWidthBottom(1);
		c1.setBorderWidthLeft(0);
		c1.setBorderWidthRight(0);
		c1.setBorderWidthTop(0);
		c1.setBorderColor(new Color(220, 221, 222));
		table.addCell(c1);

		c1 = new PdfPCell(
				new Phrase("Nivel de Riesgo", new Font(
						Font.HELVETICA, 9f, Font.NORMAL, new Color(85, 84, 84))));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
		c1.setBackgroundColor(new Color(241, 241, 241));
		c1.setBorderWidthBottom(1);
		c1.setBorderWidthLeft(0);
		c1.setBorderWidthRight(0);
		c1.setBorderWidthTop(0);
		c1.setBorderColor(new Color(220, 221, 222));
		table.addCell(c1);

		table.setHeaderRows(1);

		for (int i = 0; i < contenido.length; i++) {
			String[] contenido_interno;
			contenido_interno = contenido[i].trim().split("\\|");
			for (int j = 0; j < contenido_interno.length; j++) {
				c1 = new PdfPCell(new Phrase(contenido_interno[j], new Font(
						Font.HELVETICA, 9f, Font.NORMAL, new Color(149, 149,
								149))));

				if (j == 0) {
					c1 = new PdfPCell(new Phrase(contenido_interno[j],
							new Font(Font.HELVETICA, 9f, Font.NORMAL,
									new Color(0, 152, 195))));
				}
				c1.setFixedHeight(30);
				c1.setHorizontalAlignment(Element.ALIGN_CENTER);
				c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c1.setBackgroundColor(new Color(241, 241, 241));
				c1.setBorderWidthBottom(1);
				c1.setBorderWidthLeft(0);
				c1.setBorderWidthRight(0);
				c1.setBorderWidthTop(0);
				c1.setBorderColor(new Color(220, 221, 222));

				table.addCell(c1);
			}
		}
		
		
		try {
			documento.add(table);
			
			
			PdfPTable table1 = new PdfPTable(1);
			PdfPCell c10;
			c10 = new PdfPCell(new Phrase("*Cálculo realizado en base a la rentabilidad del periodo anterior.", new Font(Font.HELVETICA,
					7f, Font.NORMAL, new Color(149, 149, 149))));
			c10.setFixedHeight(30);
			c10.setHorizontalAlignment(Element.ALIGN_LEFT);
			c10.setVerticalAlignment(Element.ALIGN_MIDDLE);
			c10.setBorder(0);
			table1.addCell(c10);
			documento.add(table1);
		} catch (DocumentException e) {
			_log.error(e);
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#addEmptyLine(com.lowagie.text.Document, int)
	 */
	@Override
	public void addEmptyLine(Document doc, int number) {
		for (int i = 0; i < number; i++) {
			try {
				doc.add(new Paragraph(" "));
			} catch (DocumentException e) {
				_log.error(e);
			}
		}
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#obtenerMontoPortal()
	 */
	@Override
	public Double obtenerMontoPortal() {
		Double monto = Double.valueOf(0);
		try {
			monto  = Double.valueOf(cacheSimulacionUtil.getValor("VALOR_MONTO_FONDOS_MUTUOS").toString());
		} catch (NumberFormatException e) {
			_log.error("Sucedio error al obtener monto : ",e);
		}
		return monto;
	}

	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.simulacion.service.SimuladorFondosMutuosService#guardarHistorialSimulador(javax.portlet.PortletRequest, com.ext.portlet.halcon.dto.SimuladorBean)
	 */
	@Override
	public void guardarHistorialSimulador(PortletRequest portletRequest,
			SimuladorBean simulador) {
		SimuladorBean historico=new SimuladorBean(simulador);
		
		try {
			historico.setTipoSimulador(PortletProps.get("codigo.grupo.fondos"));
			historico.setPlazoCredito(String.valueOf(getPlazoCreditoxId(Integer.valueOf(simulador.getPlazoCredito()))));
			ResultadoSimulacionUtil.insertarHistorialSimulador(historico,portletRequest);
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("resultado.simulacion.simulador.fondosmutuos.serviceimpl.guardarHistorialSimulador");
			LogErrorUtil.registrarError(JSonUtil.getStringJson(simulador), e.getTrazaMessage(), asunto);
			_log.error(asunto,e);
		}
		
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
			List<PlazoBean> listaPlazos = cacheSimulacionUtil.getListPlazo(ResultadoSimulacionUtil.PLAZO_SIM_FONDO_MUTUO);
			for (PlazoBean p : listaPlazos) {
				if (p.getId().intValue() == id) {
					return p.getEtiqueta().intValue();
				}
			}
		} catch (Exception e) {
			_log.error("Error en getPlazoCreditoxId :",e);
		}
		return GetterUtil.DEFAULT_INTEGER;
	}
	
}
