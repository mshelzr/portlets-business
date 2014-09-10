package pe.com.interbank.halcon.carga.masiva.util;

//en la validacion del excel observar la doble validacion de id pais.

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.exp.portlet.halcon.utils.JSonUtil;
import com.exp.portlet.halcon.utils.LogErrorUtil;
import com.exp.portlet.halcon.utils.Propiedades;
import com.exp.portlet.halcon.utils.TextoUtil;
import com.exp.portlet.halcon.utils.ValidatorUtils;
import com.ext.portlet.halcon.exception.BusinessException;
import com.ext.portlet.halcon.model.CargaSocioRemesa;
import com.ext.portlet.halcon.service.CargaSocioRemesaLocalServiceUtil;
import com.ext.portlet.halcon.service.PaisLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ExcelSheetReader.
 * 
 * @author Infonet Consulting S.A.C. Fecha: 31-ene-2013
 * @version Halcon 1.0
 */
@SuppressWarnings({ "rawtypes" })
public class ExcelSheetReader {

	private Log _log = LogFactoryUtil.getLog(ExcelSheetReader.class);

	List<CargaSocioRemesa> lst;

	Map<String, Object> objFila;

	String columna = "";

	int fila = 1;

	List<String> lstErrores = null;

	Map<String, Object> paises = null;

	/**
	 * se intancia las variables para la lectura del excel.
	 */
	public ExcelSheetReader() {
		lst = new ArrayList<CargaSocioRemesa>();
		objFila = new LinkedHashMap<String, Object>();
		lstErrores = new ArrayList<String>();
	}

	/**
	 * lectura del archivo 2007 xlsx.
	 * 
	 * @param filename the filename
	 * @throws Exception the exception
	 */
	public void readExcelFile2007(String filename){
		if (filename != null && !filename.equals("")) {
			List<Map<String, Object>> cellDataList = new ArrayList<Map<String, Object>>();
			File file = new File(filename);
			InputStream st = null;
			try {
				st = new FileInputStream(file);
			Workbook wb1 = new XSSFWorkbook(st);// con la clase Workbook lee el libro
			Sheet sheet = wb1.getSheetAt(0);// con la clase Sheet lee la pŕimera hija
			int rows = sheet.getPhysicalNumberOfRows();// cantidad de filas
			Row r = sheet.getRow(0);// obtenermos la primera fila la cual validamos la cabecera
			Map<String, Object> celda = null;
			Iterator it = null;
			Integer col = null;
			Cell cell = null;
			Map.Entry e = null;
			String stringCellValue = "";
			if (validarCabeceras(r)) {
				for (int r1 = 1; r1 < rows; r1++) {// iteracion de las filas sin contar la cabecera
					Row row = sheet.getRow(r1);

					if(isRowEmpty(row)){
						continue;
					}
					
					if (row != null) {
						celda = new LinkedHashMap<String, Object>();// mapa de celdas
						it = objFila.entrySet().iterator();
						while (it.hasNext()) {
							e = (Map.Entry) it.next();// cabecera
							col = Integer.parseInt(e.getValue().toString());// columna
							cell = row.getCell(Integer.parseInt(String.valueOf(col)));// se obtiene
																						// la celda
							if (cell != null) {
								try {
									stringCellValue = (cell.toString()).trim();
								} catch (Exception eex) {
									stringCellValue = "";
								}
							} else {
								stringCellValue = "";
							}
							celda.put(e.getKey().toString(), stringCellValue);// se intancia la
							// celda segun la
							// cabecera dentro
							// del map
						}
						cellDataList.add(celda);// el map celda se instancia dentro de un lista
					}
				}
				instanciaList(cellDataList);// se invoca el metodo donde se almecena en un bean y
											// valida
											// sus campos.
			}
			} catch (IOException e) {
				_log.error("No se pudo leer el archivo : " + e.toString());
			} finally{
				IOUtils.closeQuietly(st);
			}
		}
	}

	/**
	 * Read excel file2003. Fecha: 31-ene-2013
	 * 
	 * @param filename the filename
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public void readExcelFile2003(String filename) throws Exception {
		List cellDataList = new ArrayList();
		FileInputStream fileInputStream = new FileInputStream(filename);
		POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
		HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);// con la clase Workbook lee el libro
		Sheet sheet = workBook.getSheetAt(0);// con la clase Sheet lee la pŕimera hija
		int rows = sheet.getPhysicalNumberOfRows();// cantidad de filas
		Row r = sheet.getRow(0);// obtenermos la primera fila la cual validamos la cabecera
		Map<String, Object> celda = null;
		Iterator it = null;
		Integer col = null;
		Cell cell = null;
		Map.Entry e = null;
		String stringCellValue = "";
		if (validarCabeceras(r)) {
			for (int r1 = 1; r1 < rows; r1++) {// iteracion de las filas sin contar la cabecera
				Row row = sheet.getRow(r1);

				if(isRowEmpty(row)){
					continue;
				}
				
				if (row != null) {
					celda = new LinkedHashMap<String, Object>();// mapa de celdas					
					it = objFila.entrySet().iterator();
					while (it.hasNext()) {
						e = (Map.Entry) it.next();// cabecera
						col = Integer.parseInt(e.getValue().toString());// columna
						cell = row.getCell(Integer.parseInt(String.valueOf(col)));// se obtiene la
																					// celda
						if (cell != null) {
							try {
								stringCellValue = (cell.toString()).trim();
							} catch (Exception eex) {
								stringCellValue = "";
							}
						} else {
							stringCellValue = "";
						}
						celda.put(e.getKey().toString(), stringCellValue);// se intancia la
						// celda segun la
						// cabecera dentro
						// del map
					}
					cellDataList.add(celda);// el map celda se instancia dentro de un lista
				}
			}
			instanciaList(cellDataList);// se invoca el metodo donde se almecena en un bean y valida
										// sus campos.
		}

	}


	private boolean isRowEmpty(Row row) {
	    for (int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
	        Cell cell = row.getCell(c);
	        if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
	            return false;
	    }
	    return true;
	}
	
	
	
	/**
	 * validamos la cabecera segun sea neceario (las cabeceras estan asignadas a un archivo de
	 * configuracion e instanciadas a las constantes) para poder hacer las lecturas he instanciarlas
	 * para q sea mas sencillo la lectura del archivo sin importar el orden de las colmunas teniendo
	 * en cuenta de que las cabeceras deben estar en mayusculas.
	 * 
	 * @param row the row
	 * @return true, en caso de exito
	 */
	private boolean validarCabeceras(Row row) {
		lstErrores = new ArrayList<String>();
		boolean isCorrect = false;
		Integer cantidadRequeridos = 0;
		Integer cols = 0;
		String stringCellValue = null;
		String temMayus = null;
		if (row != null) {
			cols = Integer.parseInt(String.valueOf(row.getLastCellNum()));
			for (int c = 0; c < cols; c++) {
				Cell cell = row.getCell((Integer) c);
				if (cell != null) {
					// stringCellValue = (cell.toString()).trim();
					temMayus = (cell.toString()).trim();
					stringCellValue = temMayus.toLowerCase();
					if (stringCellValue != null && !stringCellValue.equals("")) {
						if (stringCellValue.equals(Constantes.CABECERA_EMPRESA.trim().toLowerCase()) || stringCellValue.equals(Constantes.CABECERA_ID_PAIS.trim().toLowerCase())
								|| stringCellValue.equals(Constantes.CABECERA_PAGINA_WEB.trim().toLowerCase()) || stringCellValue.equals(Constantes.CABECERA_TELEFONO.trim().toLowerCase())) {
							if (temMayus.matches("[A-Z\\s-]{1,100}")) {
								// for (int i = 0; i < Constantes.CABECERA_OBLIGATORIOS.length; i++)
								// {
								// String str = Constantes.CABECERA_OBLIGATORIOS[i];
								// if (str.equals(temMayus)) {
								cantidadRequeridos++;
								// }
								// }
								objFila.put(stringCellValue, c);
								isCorrect = true;
							} else {
								return false;
							}
						}
					}
				}
			}// fin del for por columnas
			if (cantidadRequeridos < Constantes.CABECERA_OBLIGATORIOS) {
				if (objFila.get(Constantes.CABECERA_EMPRESA.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_EMPRESA);
				} else if (objFila.get(Constantes.CABECERA_ID_PAIS.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_ID_PAIS);
				} else if (objFila.get(Constantes.CABECERA_PAGINA_WEB.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_PAGINA_WEB);
				} else if (objFila.get(Constantes.CABECERA_TELEFONO.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_TELEFONO);
				}
				return false;
			}
		}
		_log.info("la cabecera es valida :" + isCorrect);
		return isCorrect;
	}

	public void instanciaList(List<Map<String, Object>> cellDataList) {
		paises = obtnerListaPaises();
		if (paises != null) {
			Map<String, Object> cellTempList = null;
			CargaSocioRemesa b = null;
			for (int i = 0; i < cellDataList.size(); i++) {
				cellTempList = cellDataList.get(i);
				b = obtenerCelda(cellTempList);
				if (b != null) {
					lst.add(b);
				}
				fila++;
			}
		}
	}

	private Map<String, Object> obtnerListaPaises() {
		try {
			return PaisLocalServiceUtil.obtenerListaPaises();
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("carga.masiva.excel.sheet.reader.obtener.lista.paises");
			LogErrorUtil.registrarError(JSonUtil.NO_EXISTE_PARAMETRO, e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("carga.masiva.excel.sheet.reader.obtener.lista.paises")+e.toString());
		}
		return null;
	}

	private boolean validarPais(String paisCobertura) {
		if (paisCobertura == null || paisCobertura.equals("")) {
			return false;
		}
		try {
			Boolean p = (Boolean) paises.get(paisCobertura);
			if (p != null && p) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(" e :" + e.getLocalizedMessage());
		}
		return false;
	}

	/**
	 * Obtener celda. Fecha: 31-ene-2013
	 * 
	 * @param cellTempList the cell temp list
	 * @return the cargar socio empresa bean
	 */
	public CargaSocioRemesa obtenerCelda(Map<String, Object> cellTempList) {
		int cantCampos = cellTempList.size();
		boolean resp = true;
		CargaSocioRemesa b = CargaSocioRemesaLocalServiceUtil.getInstance();
		Iterator it2 = cellTempList.entrySet().iterator();
		String strErFila;
		String strEr;
		Map.Entry e = null;
		String strKey = "";
		String strValue = "";
		if (cantCampos > 0) {
			while (it2.hasNext()) {
				strErFila = "";
				strEr = "";
				e = (Map.Entry) it2.next();
				strKey = e.getKey().toString();
				strValue = e.getValue().toString();
				columna = strKey;
				strValue = strValue.trim();
				if (strKey != null && !strKey.equals("") && !strKey.equals("NULL") && !strKey.equals("null")) {
					if (strKey.equals(Constantes.CABECERA_EMPRESA.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if (strValue.length() <= Constantes.validLengthEmpresa) {
								// if (Pattern.compile("[a-zA-Z0-9\\s-]{1," +
								// Constantes.validLengthEmpresa + "}").matcher(strValue).matches())
								// {
								b.setEmpresa(Util.capitalizarFrase(strValue));
								continue;
								// } else {
								// strEr = Constantes.MENSAJE_EMPRESA;
								// }
							} else {
								strEr = Constantes.MENSAJE_EMPRESA_LONGITUD;
							}
						} else {
							strEr = Constantes.MENSAJE_EMPRESA_REQUERIDO;
						}
						resp = false;
						strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
						lstErrores.add(strErFila);
					} else if (strKey.equals(Constantes.CABECERA_ID_PAIS.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if (strValue.length() == Constantes.validLengthPaisCobertura) {
								try {
									Integer.parseInt(strValue);
									if (validarPais(strValue)) {
										b.setPaisCobertura(strValue);
										continue;
									} else {
										strEr = Constantes.MENSAJE_ID_PAIS_VALIDACION;
									}
								} catch (Exception e2) {
									strEr = Constantes.MENSAJE_ID_PAIS_VALIDACION;
								}
							} else {
								strEr = Constantes.MENSAJE_ID_PAIS_LONGITUD;
							}
						} else {
							strEr = Constantes.MENSAJE_ID_PAIS_REQUERIDO;
						}
						resp = false;
						strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
						lstErrores.add(strErFila);
					} else if (strKey.equals(Constantes.CABECERA_PAGINA_WEB.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if ((strValue.length() <= Constantes.validLengthPaginaWeb)) {
								b.setPaginaWeb(strValue);
								continue;
							} else {
								strEr = Constantes.MENSAJE_PAGINA_WEB_LONGITUD;
							}
							strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
							lstErrores.add(strErFila);
						}
					} else if (strKey.equals(Constantes.CABECERA_TELEFONO.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if(strValue.endsWith(".0")){
								strValue = strValue.substring(0, strValue.length()-2);
							}
							if (strValue.length() >= Constantes.validLengthminTelefono && strValue.length() <= Constantes.validLengthTelefono) {								
								strValue = TextoUtil.formatearTelefonoCargas(strValue);
								b.setTelefono(strValue);
								continue;
							} else {
								strEr = Constantes.MENSAJE_TELEFONO_LONGITUD;
							}
							strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
							lstErrores.add(strErFila);
						}
					}
				}

			}
			if (!resp) {
				return null;
			}
			return b;
		} else {
			return null;
		}
	}

	/**
	 * Obtiene lst. Fecha: 31-ene-2013
	 * 
	 * @return lst
	 */
	public List<CargaSocioRemesa> getLst() {
		return lst;
	}

	/**
	 * Obtiene columna. Fecha: 31-ene-2013
	 * 
	 * @return columna
	 */
	public String getColumna() {
		return columna;
	}

	/**
	 * Obtiene fila. Fecha: 31-ene-2013
	 * 
	 * @return fila
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Obtiene lst errores. Fecha: 31-ene-2013
	 * 
	 * @return lst errores
	 */
	public List<String> getLstErrores() {
		return lstErrores;
	}

}