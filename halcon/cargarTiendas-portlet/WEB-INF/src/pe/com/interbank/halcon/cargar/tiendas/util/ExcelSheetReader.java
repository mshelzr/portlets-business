package pe.com.interbank.halcon.cargar.tiendas.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

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
import com.ext.portlet.halcon.model.CargaTienda;
import com.ext.portlet.halcon.service.CargaTiendaLocalServiceUtil;
import com.ext.portlet.halcon.service.UbigeoLocalServiceUtil;
import com.google.gson.Gson;
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

	/** The _log. */
	private static Log _log = LogFactoryUtil.getLog(ExcelSheetReader.class);

	/** The a. */
	Gson a = new Gson();

	/** The lst. */
	List<CargaTienda> lst;

	/** The obj fila. */
	Map<String, Object> objFila;

	/** The columna. */
	String columna = "";

	/** The fila. */
	int fila = 1;

	/** The lst errores. */
	List<String> lstErrores = null;

	
	Map<String, Object> listUbigeos = null;

	/**
	 * se intancia las variables para la lectura del excel.
	 */
	public ExcelSheetReader() {
		lst = new ArrayList<CargaTienda>();
		objFila = new LinkedHashMap<String, Object>();
	}

	/**
	 * lectura del archivo 2007 xlsx.
	 * 
	 * @param filename the filename
	 * @throws Exception the exception
	 */
	public void readExcelFile2007(File file) {
		if (file != null) {
			List<Map<String, Object>> cellDataList = new ArrayList<Map<String, Object>>();
			Workbook wb1 = null;
			try {
				wb1 = new XSSFWorkbook(file.getAbsoluteFile().getAbsolutePath()); // con la clase
																					// Workbook lee
																					// el libro
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			if (wb1 != null) {
				Sheet sheet = wb1.getSheetAt(0);// con la clase Sheet lee la primera hoja				
				int rows = sheet.getPhysicalNumberOfRows();// cantidad de filas
				Row r = sheet.getRow(0);// obtenermos la primera fila la cual validamos la cabecera
				Map<String, Object> celda = null;
				Iterator it = null;
				Integer col = null;
				Cell cell = null;
				Map.Entry e = null;
				String stringCellValue = "";
				if (validarCabeceras(r)) {
					for (int r1 = 1; r1 < rows; r1++) {// iteracion de las filas sin contar la
														// cabecera
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
								
								cell = row.getCell(Integer.parseInt(String.valueOf(col)));// se
																							// obtiene
																							// la celda	
								if (cell != null) {
									try {
										stringCellValue = (cell.toString()).trim();
									} catch (Exception eex) {
										stringCellValue = "";
									}
								}else {
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
					instanciaList(cellDataList);// se invoca el metodo donde se almecena en un bean
												// y valida
												// sus campos.
				}

			} else {
				_log.info("Error al abrir el libro esta en null");
				lst = null;
			}

		} else {
			_log.info("filename esta vacio");
			lst = null;
		}

	}

	
	/**
	 * Read excel file2003. Fecha: 31-ene-2013
	 * 
	 * @param filename the filename
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public void readExcelFile2003(File file) {
		List cellDataList = new ArrayList();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		if (fileInputStream != null) {
			POIFSFileSystem fsFileSystem = null;
			try {
				fsFileSystem = new POIFSFileSystem(fileInputStream);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			if (fsFileSystem != null) {

				HSSFWorkbook workBook = null;
				try {
					workBook = new HSSFWorkbook(fsFileSystem);
				} catch (IOException e1) {
					e1.printStackTrace();
				}// con la clase Workbook lee el libro

				if (workBook != null) {
					Sheet sheet = workBook.getSheetAt(0);// con la clase Sheet lee la primera hoja
					int rows = sheet.getPhysicalNumberOfRows();// cantidad de filas
					Row r = sheet.getRow(0);// obtenermos la primera fila la cual validamos la
											// cabecera
					Map<String, Object> celda = null;
					Iterator it = null;
					Integer col = null;
					Cell cell = null;
					Map.Entry e = null;
					String stringCellValue = "";
					Row row = null;
					if (validarCabeceras(r)) {
						for (int r1 = 1; r1 < rows; r1++) {// iteracion de las filas sin contar la
															// cabecera
							row = sheet.getRow(r1);
							
							if(isRowEmpty(row)){
								continue;
							}
							
							if (row != null) {
								celda = new LinkedHashMap<String, Object>();// mapa de celdas
								it = objFila.entrySet().iterator();
								while (it.hasNext()) {
									e = (Map.Entry) it.next();// cabecera
									col = Integer.parseInt(e.getValue().toString());// columna
									cell = row.getCell(Integer.parseInt(String.valueOf(col)));// se
																								// obtiene
																								// la
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
									celda.put(e.getKey().toString(), stringCellValue);// se intancia
																						// la
									// celda segun la
									// cabecera dentro
									// del map
								}
								cellDataList.add(celda);// el map celda se instancia dentro de un
														// lista
							}
						}
						instanciaList(cellDataList);// se invoca el metodo donde se almecena en un
													// bean y valida
													// sus campos.
					}

				} else {
					lst = null;
				}

			} else {
				lst = null;
			}

		} else {
			lst = null;
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

	public Map<String, Object> leerLineaPorOrdenDeCabecera(String strLinea) {
		Map<String, Object> splitLinea = new LinkedHashMap<String, Object>();
		Iterator it = objFila.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			StringTokenizer linea = new StringTokenizer(strLinea, Constantes.tokenSeparador);
			linea.hasMoreElements();
			int cantidad = linea.countTokens();
			int columna = Integer.parseInt(e.getValue().toString());
			for (int i = 0; i < cantidad; i++) {
				String celda = (String) linea.nextElement();
				if (i == columna) {
					splitLinea.put(e.getKey().toString().trim(), celda.trim());
				}
			}
		}
		return splitLinea;
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
		Cell cell = null;
		if (row != null) {
			cols = Integer.parseInt(String.valueOf(row.getLastCellNum()));
			for (int c = 0; c < cols; c++) {
				cell = row.getCell((short) c);
				if (cell != null) {
					temMayus = (cell.toString()).trim();
					stringCellValue = temMayus.toLowerCase();
					if (stringCellValue != null && !stringCellValue.equals("")) {
						if (stringCellValue.equals(Constantes.CABECERA_Canal.trim().toLowerCase()) || stringCellValue.equals(Constantes.CABECERA_UBIGE.trim().toLowerCase())
								|| stringCellValue.equals(Constantes.CABECERA_Latitud.trim().toLowerCase()) || stringCellValue.equals(Constantes.CABECERA_Longitud.trim().toLowerCase())
								|| stringCellValue.equals(Constantes.CABECERA_Direccion.trim().toLowerCase()) || stringCellValue.equals(Constantes.CABECERA_Horario.trim().toLowerCase())
								|| stringCellValue.equals(Constantes.CABECERA_locacion.trim().toLowerCase()) || stringCellValue.equals(Constantes.CABECERA_id_Locacion.trim().toLowerCase())
								|| stringCellValue.equals(Constantes.CABECERA_Telefono.trim().toLowerCase())) {
							if (temMayus.matches("[A-Z\\s-]{1,100}")) {
								objFila.put(stringCellValue, c);
								isCorrect = true;
								cantidadRequeridos++;
							} else {
								return false;
							}
						}
					}
				}
			}

			if (cantidadRequeridos < Constantes.CABECERA_OBLIGATORIOS) {
				if (objFila.get(Constantes.CABECERA_Canal.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_CANAL);
					
				} else if (objFila.get(Constantes.CABECERA_UBIGE.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_UBIGEO);
					
				} else if (objFila.get(Constantes.CABECERA_Latitud.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_LATITUD);
					
				} else if (objFila.get(Constantes.CABECERA_Direccion.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_DIRECCION);
					
				} else if (objFila.get(Constantes.CABECERA_Horario.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_HORARIO);
					
				} else if (objFila.get(Constantes.CABECERA_locacion.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_LOCACION);
					
				} else if (objFila.get(Constantes.CABECERA_id_Locacion.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_IDLOCACION);
					
				} else if (objFila.get(Constantes.CABECERA_Longitud.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_LONGITUD);
					
				} else if (objFila.get(Constantes.CABECERA_Telefono.toLowerCase()) == null) {
					lstErrores.add(Constantes.MENSAJE_COLUMNA_TELEFONO);
					
				}
				return false;
			}

		}

		return isCorrect;
	}

	/**
	 * se inscia en una lista si el registro pasa la validacion correspondiente.
	 * 
	 * @param cellDataList the cell data list
	 */
	public void instanciaList(List<Map<String, Object>> cellDataList) {
		try {
			listUbigeos = UbigeoLocalServiceUtil.obtenerUbigeoPorCodigos();
		} catch (BusinessException e) {
			String asunto = Propiedades.getResourceBundle("cargar.tiendas.excel.sheet.reader.instanciaList");
			LogErrorUtil.registrarError(JSonUtil.NO_EXISTE_PARAMETRO, e.getTrazaMessage(), asunto);
			_log.error(Propiedades.getResourceBundle("cargar.tiendas.excel.sheet.reader.instanciaList")+e.toString());
		}
		Map<String, Object> cellTempList = null;
		CargaTienda b = null;
		for (int i = 0; i < cellDataList.size(); i++) {
			cellTempList = cellDataList.get(i);
			b = obtenerCelda(cellTempList);
			if (b != null) {
				lst.add(b);
			}
			fila++;
		}
	}

	/**
	 * Validar ubigeo. Fecha: 31-ene-2013
	 * 
	 * @param b the b
	 * @return true, en caso de exito
	 */
	private boolean validarUbigeo(String ubigeo) {
		if (ubigeo == null || ubigeo.equals("")) {
			return false;
		}
		try {
			Boolean p = (Boolean) listUbigeos.get(ubigeo);
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
	 * @return the cargar tienda bean
	 */
	public CargaTienda obtenerCelda(Map<String, Object> cellTempList) {
		
		int cantCampos = cellTempList.size();
		boolean resp = true;
		CargaTienda b = CargaTiendaLocalServiceUtil.getInstace();
		Iterator it2 = cellTempList.entrySet().iterator();
		String strErFila;
		String strEr;
		Map.Entry e = null;
		String strKey = "";
		String strValue = "";
		if (cantCampos > 0) {
			strErFila = "";
			while (it2.hasNext()) {
				strEr = "";
				e = (Map.Entry) it2.next();
				strKey = e.getKey().toString();
				strValue = e.getValue().toString();
				strValue = strValue.trim();
				if (strKey != null && !strKey.equals("")) {
					if (strKey.equals(Constantes.CABECERA_Canal.trim().toLowerCase())) {
						
						if (ValidatorUtils.isNotNull(strValue)) {							
							try {
								strValue = String.valueOf( Double.valueOf(strValue).intValue() );
								if (strValue.length() == Constantes.VALID_LENGTH_CANAL) {
									b.setIdCanal(strValue);
									continue;
								} else {
									strEr = Constantes.MENSAJE_LONGITUD_CANAL;
								}
							} catch (Exception e2) {
								strEr = Constantes.MENSAJE_CANAL;
								e2.printStackTrace();
							}

						} else {
							strEr = Constantes.MENSAJE_REQUERIDO_CANAL;
						}
						resp = false;
						columna = strKey;
						strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
						lstErrores.add(strErFila);
					} else if (strKey.equals(Constantes.CABECERA_UBIGE.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if (Pattern.compile("\\d*").matcher(strValue).matches()) {
								if (strValue.length() == Constantes.VALID_LENGTH_UBIGEO) {
									if (validarUbigeo(strValue)) {
										b.setCodDistrito(strValue);
										continue;
									} else {
										strEr = Constantes.MENSAJE_REQUERIDO_UBIGEO;
									}
								} else {
									strEr = Constantes.MENSAJE_LONGITUD_UBIGEO;
								}
							} else {
								strEr = Constantes.MENSAJE_UBIGEO;
							}
						} else {
							strEr = Constantes.MENSAJE_REQUERIDO_UBIGEO;
						}
						resp = false;
						columna = strKey;
						strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
						lstErrores.add(strErFila);
					} else if (strKey.equals(Constantes.CABECERA_Latitud.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							try {
								Double.parseDouble(strValue);
								if (strValue.length() >= Constantes.VALID_LENGTH_MIN_LATITUD && strValue.length() <= Constantes.VALID_LENGTH_LATITUD) {
									b.setLatitud(strValue);
									continue;
								} else {
									b.setLatitud(null);
									strEr = Constantes.MENSAJE_LONGITUD_LATITUD;
								}
							} catch (Exception e2) {
								strEr = Constantes.MENSAJE_LATITUD;
								b.setLatitud(null);
							}
							columna = strKey;
							strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
							lstErrores.add(strErFila);
						}
					} else if (strKey.equals(Constantes.CABECERA_Longitud.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							try {
								Double.parseDouble(strValue);
								if (strValue.length() >= Constantes.VALID_LENGTH_MIN_LONGITUD && strValue.length() <= Constantes.VALID_LENGTH_LONGITUD) {
									b.setLongitud(strValue);
									continue;
								} else {
									b.setLongitud(null);
									strEr = Constantes.MENSAJE_LONGITUD_LONGITUD;
								}
							} catch (Exception e2) {
								b.setLongitud(null);
								strEr = Constantes.MENSAJE_LONGITUD;
							}
							columna = strKey;
							strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
							lstErrores.add(strErFila);
						}
					} else if (strKey.equals(Constantes.CABECERA_Direccion.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if (strValue.length() <= Constantes.VALID_LENGTH_DIRECCION) {
								b.setDireccion(Util.capitalizarFrase(strValue));
								continue;
							} else {
								strEr = Constantes.MENSAJE_LONGITUD_DIRECCION;
							}
							columna = strKey;
							b.setDireccion(null);
							strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
							lstErrores.add(strErFila);
						}
					} else if (strKey.equals(Constantes.CABECERA_Horario.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if (strValue.length() <= Constantes.VALID_LENGTH_HORARIO) {
								b.setHorario(strValue);
								continue;
							} else {
								strEr = Constantes.MENSAJE_LONGITUD_HORARIO;
							}
							columna = strKey;
							resp = false;
							strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
							lstErrores.add(strErFila);
						}
					} else if (strKey.equals(Constantes.CABECERA_id_Locacion.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							try {
								strValue = String.valueOf((new Double(strValue).intValue()));
								if (Pattern.compile("\\d*").matcher(strValue).matches()) {
									if (strValue.length() <= 5) {
										b.setIdLocacion(Integer.parseInt(strValue));
										continue;
									} else {
										strEr = Constantes.MENSAJE_LOGITUD_ID_LOCACION;
									}
								} else {
									strEr = Constantes.MENSAJE_ID_LOCACION;
								}
							} catch (Exception e2) {
								strEr = Constantes.MENSAJE_ID_LOCACION;
							}
						} else {
							strEr = Constantes.MENSAJE_REQUERIDO_ID_LOCACION;
						}
						columna = strKey;
						resp = false;
						strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
						lstErrores.add(strErFila);
					} else if (strKey.equals(Constantes.CABECERA_locacion.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(strValue)) {
							if (strValue.length() <= Constantes.VALID_LENGTH_LOCACION) {
								b.setLocacion(Util.capitalizarFrase(strValue));
								continue;
							} else {
								strEr = Constantes.MENSAJE_LONGITUD_LOACION;
							}
						} else {
							strEr = Constantes.MENSAJE_REQUERIDO_LOCACION;
						}
						columna = strKey;
						resp = false;
						strErFila = "Error en fila:" + fila + " columna :" + columna + " Mensaje : " + strEr;
						lstErrores.add(strErFila);
					} else if (strKey.equals(Constantes.CABECERA_Telefono.trim().toLowerCase())) {
						if (ValidatorUtils.isNotNull(String.valueOf(strValue))) {
							if (strValue.length() >= Constantes.VALID_MIN_LENGTH_TELEFONO && strValue.length() <= Constantes.VALID_LENGTH_TELEFONO) {
								if(strValue.endsWith(".0")){
									strValue = strValue.substring(0, strValue.length()-2);
								}
								strValue = TextoUtil.formatearTelefonoCargas(strValue);
								b.setTelefono(strValue);
								continue;
							} else {
								strEr = Constantes.MENSAJE_LONGITUD_TELEFONO;
							}
							b.setTelefono(null);
							columna = strKey;
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
	public List<CargaTienda> getLst() {
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

	public static String obtenerTempTomcat(String temp) {
		temp = temp.substring(0, temp.indexOf("temp") + "temp".length());
		return temp;
	}
}