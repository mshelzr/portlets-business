package pe.com.ibk.halcon.gestionparametros.service.impl;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.ibk.halcon.gestionparametros.bean.BeanNuevoRango;
import pe.com.ibk.halcon.gestionparametros.service.ParametroService;

import com.exp.portlet.halcon.utils.AsciiUtils;
import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.Pais;
import com.ext.portlet.halcon.model.Parametro;
import com.ext.portlet.halcon.model.Ubigeo;
import com.ext.portlet.halcon.service.PaisLocalServiceUtil;
import com.ext.portlet.halcon.service.ParametroLocalServiceUtil;
import com.ext.portlet.halcon.service.UbigeoLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ParametroServiceImpl.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Service
public class ParametroServiceImpl implements ParametroService {
	
	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ParametroServiceImpl.class);
	
	/** The etiqueta_tooltip. */
	private static String etiqueta_tooltip = "tooltip";
	
	FileWriter file;
	BufferedWriter writer;
	
	private static String etiqueta_siebel = " - CODIGO SIEBEL";
	
	private static String etiqueta_etiquetas_siebel = "[{\"parm_Dato1\":\"Descripción\",\"parm_Dato2\":\"NONE\",\"parm_Num2\":\"NONE\",\"parm_Num3\":\"Por Defecto\",\"parm_Num1\":\"Estado\",\"parm_ValorMonto1\":\"Código Siebel\",\"parm_ValorMonto2\":\"Código HPC\",\"parm_ValorMonto3\":\"NONE\",\"parm_Dato4\":\"Código\"}]";
	
	private static int etiqueta_num1_siebel = 1;
	
	private static int etiqueta_num2_siebel_cabecera = 10;
	
	private static int etiqueta_num2_siebel_detalle = 0;
	
	private static int etiqueta_num3_siebel = 0;
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroService#generarArchivo(java.lang.Integer)
	 */
	public void generarArchivo(Integer idParametro)  throws Exception {

		Integer valor = ParametroLocalServiceUtil.validarTipo(idParametro);
		generarJSon(idParametro);
		
	}
	


	/**
	 * Generar j son.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @throws Exception the exception
	 */
	public void generarJSonMasivo() throws Exception {

		try {
			
			List<Parametro> lista;
			
			List<Parametro> listaPadres = ParametroLocalServiceUtil.listarPadresJson(20);
//			_log.info(" ***** numero de padres ****:"+listaPadres.size());
			
			for (Parametro param : listaPadres) {
				if(!param.getDato2().equals("ninguno.json")){
					lista = new ArrayList<Parametro>();
					lista = ParametroLocalServiceUtil.listarHijosPadresJson(param.getIdParametro());

					Integer tamanio = lista.size();
					Integer acumula = 0;
					StringBuilder query = new StringBuilder();
		
					query.append(JSonUtil.INICIO_UNO);
		
					for (Parametro parametro : lista) {
		
						acumula++;
						query.append(JSonUtil.CADENA_UNO);
						query.append(parametro.getDato4());
						query.append(JSonUtil.CADENA_DOS);
						query.append(AsciiUtils
								._convertNonAscii(parametro.getDato1()));
						query.append(JSonUtil.CADENA_TRES);
						if(parametro.getDato2().equals(etiqueta_tooltip)){
							query.append("");
						}else{
							query.append(parametro.getDato2());
						}
						query.append(JSonUtil.CADENA_CUATRO);
						query.append(parametro.getNum2());
						query.append(JSonUtil.CADENA_CINCO);
						query.append(parametro.getNum3());
		
						if (!tamanio.equals(acumula)) {
							query.append(JSonUtil.CADENA_SEIS);
							query.append("\n");
						}
					}
		
					query.append(JSonUtil.CADENA_FIN);
					String pathWasJson = JSonUtil.getPathJsonWasModificada();
					String FilePath = pathWasJson + param.getDato2();
					
					_log.info("****generarJSon PATH***:"+FilePath);
				
					Boolean CleanFileContent = true;

					file = new FileWriter(FilePath, !CleanFileContent);
					writer = new BufferedWriter(file);
					writer.write(query.toString());
		
					writer.close();
					file.close();
				}
			}	
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(writer!=null)
				writer.close();
			if(file!=null)
				file.close();
		}
	}

	/**
	 * Generar j son.
	 * Fecha: 22/08/2013
	 *
	 * @param idParametro the id parametro
	 * @throws Exception the exception
	 */
	private void generarJSon(Integer idParametro)
			throws Exception {

		
		try {

			Parametro param = ParametroLocalServiceUtil.obtenerParametroPadre(idParametro);
			List<Parametro> lista = ParametroLocalServiceUtil.obtenerParametrosHijosDos(idParametro);
			
			Integer tamanio = lista.size();
			Integer acumula = 0;
			StringBuilder query = new StringBuilder();

			query.append(JSonUtil.INICIO_UNO);

			for (Parametro parametro : lista) {

				acumula++;
				query.append(JSonUtil.CADENA_UNO);
				query.append(parametro.getDato4());
				query.append(JSonUtil.CADENA_DOS);
				query.append(AsciiUtils
						._convertNonAscii(parametro.getDato1()));
				query.append(JSonUtil.CADENA_TRES);
				if(parametro.getDato2().equals(etiqueta_tooltip)){
					query.append("");
				}else{
					query.append(parametro.getDato2());
				}
				query.append(JSonUtil.CADENA_CUATRO);
				query.append(parametro.getNum2());
				query.append(JSonUtil.CADENA_CINCO);
				query.append(parametro.getNum3());

				if (!tamanio.equals(acumula)) {
					query.append(JSonUtil.CADENA_SEIS);
					query.append("\n");
				}
			}

			query.append(JSonUtil.CADENA_FIN);
			// JSonUtil.getPathJsonWasModificada();// linea adicionada por requerimiento de Julio
			
			String pathWasJson = JSonUtil.getPathJsonWasModificada();
			
			String FilePath = pathWasJson + param.getDato2();
			_log.info("****generarJSon PATH***:"+FilePath);
			
			Boolean CleanFileContent = true;

			file = new FileWriter(FilePath, !CleanFileContent);
			writer = new BufferedWriter(file);
			writer.write(query.toString());
						
		} catch (IOException ex) {
			//Result = false;
			ex.printStackTrace();
		} finally {
			if(writer!=null)
				writer.close();
			if(file!=null)
				file.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see pe.com.ibk.halcon.gestionparametros.service.ParametroService#ubigeo()
	 */
	@Override
	public void ubigeo()  {
		
		try {
			
			List<Ubigeo> listaDepartamento = UbigeoLocalServiceUtil.obtenerDepartamentos();
			List<Ubigeo> listaProvincia = UbigeoLocalServiceUtil.obtenerProvincias();
			List<Ubigeo> listaDistrito = UbigeoLocalServiceUtil.obtenerDistritos();
			
			generarUbigeo(listaDepartamento,JSonUtil.DEPARTAMENTO);
			generarUbigeo(listaProvincia,JSonUtil.PROVINCIA);
			generarUbigeo(listaDistrito,JSonUtil.DISTRITO);
			//generarPais();
			
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("gestion.parametros.parametro.serviceimpl.ubigeo");
			LogErrorUtil.registrarError(JSonUtil.NO_EXISTE_PARAMETRO, e.getTrazaMessage(), asunto);
			_log.error(asunto+e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Generar ubigeo.
	 * Fecha: 22/08/2013
	 *
	 * @param lista the lista
	 * @param nombreUbigeo the nombre ubigeo
	 * @throws Exception the exception
	 */
	@SuppressWarnings("resource")
	public void generarUbigeo(List<Ubigeo> lista,String nombreUbigeo) throws Exception {

		try {
			
			Integer tamanio = lista.size();
			Integer acumula = 0;
			StringBuilder query = new StringBuilder();

			query.append(JSonUtil.INICIO_UNO);
			query.append(JSonUtil.CADENA_SELECCIONE);
			query.append("\n");

			for (Ubigeo ubigeo : lista) {

				acumula++;
				query.append(JSonUtil.CADENA_UNO);
				if(nombreUbigeo.equals(JSonUtil.DEPARTAMENTO)){
					query.append(Integer.valueOf(ubigeo.getCodDepartamento()));
				} else if(nombreUbigeo.equals(JSonUtil.PROVINCIA)){

					query.append(String.valueOf(Integer.valueOf(ubigeo.getCodDepartamento())).concat(String.valueOf(ubigeo.getCodProvincia())));

					query.append(JSonUtil.CADENA_DEPARTAMENTO);
					query.append(Integer.valueOf(ubigeo.getCodDepartamento()));
				} else if(nombreUbigeo.equals(JSonUtil.DISTRITO)){
					query.append(Integer.valueOf(ubigeo.getCodDistrito()));
					query.append(JSonUtil.CADENA_PROVINCIA);
					query.append(String.valueOf(Integer.valueOf(ubigeo.getCodDepartamento())).concat(String.valueOf(ubigeo.getCodProvincia())));
					
				}
				
				query.append(JSonUtil.CADENA_DOS);
				query.append(AsciiUtils
						._convertNonAscii(ubigeo.getNombre()));

				query.append(JSonUtil.CADENA_CUATRO);
				query.append(acumula);
				query.append(JSonUtil.CADENA_CINCO);

				query.append(0);

				if (!tamanio.equals(acumula)) {
					query.append(JSonUtil.CADENA_SEIS);
					query.append("\n");
				
				}
			}

			query.append(JSonUtil.CADENA_FIN);
			
			String pathWasJson = JSonUtil.getPathJsonWasModificada();
			String FilePath = pathWasJson + nombreUbigeo;
			
			FileWriter file;
			BufferedWriter writer;
			Boolean CleanFileContent = true;

			file = new FileWriter(FilePath, !CleanFileContent);
			writer = new BufferedWriter(file);
			writer.write(query.toString());
			
			if(writer!=null)
				writer.close();
			if(file!=null)
				file.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if(writer!=null)
				writer.close();
			if(file!=null)
				file.close();
		}
	}
	
		public int guardarNuevoRangoSiebel(BeanNuevoRango beanRango) throws Exception {
		int reg =0;
		
		try {
			
			Parametro cabecera = ParametroLocalServiceUtil.getInstance();
			cabecera.setDato1(beanRango.getNombreProducto() + etiqueta_siebel);
			cabecera.setDato3(beanRango.getEtiquetaProducto());
			cabecera.setDato2(etiqueta_tooltip);
			cabecera.setDato4(etiqueta_etiquetas_siebel);	
			cabecera.setNum1(etiqueta_num1_siebel);
			cabecera.setNum2(etiqueta_num2_siebel_cabecera);
			cabecera.setNum3(etiqueta_num3_siebel);
			cabecera.setValorMonto1(null);
			cabecera.setValorMonto2(null);
			cabecera.setValorMonto3(null);
						
			Parametro detalle = ParametroLocalServiceUtil.getInstance();
			detalle.setDato1(beanRango.getNombreProducto());
			detalle.setValorMonto1(beanRango.getCodigoSiebel());
			detalle.setValorMonto2(beanRango.getCodigoHPC());
			detalle.setValorMonto3(beanRango.getCodigoHPC());
			detalle.setDato2(etiqueta_tooltip);
			detalle.setNum1(etiqueta_num1_siebel);
			detalle.setNum2(etiqueta_num2_siebel_detalle);
			detalle.setNum3(etiqueta_num3_siebel);
						
			reg = ParametroLocalServiceUtil.registrarCabeceraDetalle(cabecera, detalle);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}
		
		return reg;
	}
	
	/**
	 * Generar pais.
	 * Fecha: 22/08/2013
	 *
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private void generarPais() throws Exception {

		try {

			List<Pais> lista =PaisLocalServiceUtil.obtenerPais();
			
			Integer tamanio = lista.size();
			Integer acumula = 0;
			StringBuilder query = new StringBuilder();

			query.append(JSonUtil.INICIO_UNO);
			query.append(JSonUtil.CADENA_TODOS);
			query.append("\n");
			
			for (Pais pais : lista) {

				acumula++;
				query.append(JSonUtil.CADENA_UNO);
				query.append(Integer.valueOf(pais.getCodigo()));
				
				query.append(JSonUtil.CADENA_DOS);
				query.append(AsciiUtils
						._convertNonAscii(pais.getNombre()));

				query.append(JSonUtil.CADENA_CUATRO);
				query.append(acumula);
				query.append(JSonUtil.CADENA_CINCO);

					query.append(0);

				if (!tamanio.equals(acumula)) {
					query.append(JSonUtil.CADENA_SEIS);
					query.append("\n");
				
				}
			}

			query.append(JSonUtil.CADENA_FIN);
			String pathWasJson = JSonUtil.getPathJsonWasModificada();
			String FilePath = pathWasJson + JSonUtil.PAIS;
			
			FileWriter file;
			BufferedWriter writer;
			Boolean CleanFileContent = true;
	
			file = new FileWriter(FilePath, !CleanFileContent);
			writer = new BufferedWriter(file);
			writer.write(query.toString());
			writer.close();
			file.close();
			
		} catch (Exception ex) {
			_log.error("");
		} finally {
			if(writer!=null)
				writer.close();
			if(file!=null)
				file.close();
		}
	}

}
