package pe.com.ibk.halcon.contenidoweb.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.liferay.portal.kernel.util.CharPool;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class ValidatorUtils, realiza validacion de los metodos en el controller
 * 
 * @author Infonet Consulting S.A.C. Fecha: 30/01/2013
 * @version Halcon 1.0
 */
public class ValidatorUtils {

	/** The _patron_nombre. */
	private static Pattern _patron_nombre = Pattern.compile("[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\s-']{1,50}");

	/** The _patron_email. */
	private static Pattern _patron_email = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
	
	/** The _patron_telefono. */
	private static Pattern _patron_telefono = Pattern.compile("[0-9]{6,9}");

	/** The _patron_telefono. */
	private static Pattern _patron_importe = Pattern.compile("[0-9]");

	/** The _patron_celular. */
	private static Pattern _patron_celular = Pattern.compile("[0-9]{9}");

	/** The _patron_dni. */
	private static Pattern _patron_dni = Pattern.compile("[0-9]{8}");

	/** The _patron_ruc. */
	private static Pattern _patron_ruc = Pattern.compile("[0-9]{11}");

	/** The _patron_carnet_extranjeria. */
	private static Pattern _patron_carnet_extranjeria = Pattern.compile("[a-zA-ZñÑ0-9]{4,12}");

	/** The _patron_direccion. */
	private static Pattern _patron_direccion = Pattern.compile("[a-zA-ZñÑ0-9áéíóúÁÉÍÓÚüÜ\\s]{1,100}");

	/** The _patron_direccion. */
	private static Pattern _patron_mensaje = Pattern.compile("[a-zA-ZñÑ0-9áéíóúÁÉÍÓÚüÜ\\s]{1,1000}");
	
	/** The Constant _DIGIT_BEGIN. */
	private static final int _DIGIT_BEGIN = 48;

	/** The Constant _DIGIT_END. */
	private static final int _DIGIT_END = 57;

	/**
	 * Retorna <code>true</code> Si la cadena es un nombre válido con caracteres letras y caracteres
	 * con tildes.
	 * 
	 * @param nombres el nombre a verificar
	 * @return <code>true</code> si la cadena es un nombre válido; <code>false</code> otro caso
	 */
	public static boolean isNombre(String nombres) {
		if (isNull(nombres))
			return false;
		Matcher matcher = _patron_nombre.matcher(nombres);
		return matcher.matches();
	}

	/**
	 * Comprueba si es number. Fecha: 30/01/2013
	 * 
	 * @param number the number
	 * @return true, si es number
	 */
	public static boolean isNumber(String number) {
		if (isNull(number)) {
			return false;
		}

		for (char c : number.toCharArray()) {
			if (!isDigit(c)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Comprueba si es digit. Fecha: 30/01/2013
	 * 
	 * @param c the c
	 * @return true, si es digit
	 */
	public static boolean isDigit(char c) {
		int x = c;

		if ((x >= _DIGIT_BEGIN) && (x <= _DIGIT_END)) {
			return true;
		}

		return false;
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un apellido válido con caracteres letras y
	 * caracteres con tildes.
	 * 
	 * @param apellidos el apellido a verificar
	 * @return <code>true</code> si la cadena es un apellido válido; <code>false</code> otro caso
	 */
	public static boolean isApellido(String apellidos) {
		if (isNull(apellidos))
			return false;
		Matcher matcher = _patron_nombre.matcher(apellidos);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es una dirección de correo electrónico válido.
	 * 
	 * @param email el correo electrónico a verificar
	 * @return <code>true</code> si la cadena es un correo electrónico válido; <code>false</code>
	 *         otro caso
	 */
	public static boolean isEmail(String email) {
		if (isNull(email))
			return false;
		Matcher matcher = _patron_email.matcher(email);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un número de telefono valido de
	 * <code>7 digitos</code>.
	 * 
	 * @param telefono el número de telefono a verificar
	 * @return <code>true</code> si la cadena es un telefono válido; <code>false</code> otro caso
	 */
	public static boolean isTelefono(String telefono) {
		if (isNull(telefono))
			return false;
		Matcher matcher = _patron_telefono.matcher(telefono);
		return matcher.matches();
	}
	/**
	 * Retorna <code>true</code> Si la cadena es un número de telefono valido de
	 * <code>7 digitos</code>.
	 * 
	 * @param telefono el número de telefono a verificar
	 * @return <code>true</code> si la cadena es un telefono válido; <code>false</code> otro caso
	 */
	public static boolean isImporte(String importe) {
		//if (isNull(importe))
		//	return f;
		Matcher matcher = _patron_importe.matcher(importe);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un número de celular valido de
	 * <code>9 digitos</code>.
	 * 
	 * @param celular el número de celular a verificar
	 * @return <code>true</code> si la cadena es un celular válido; <code>false</code> otro caso
	 */
	public static boolean isCelular(String celular) {
		if (isNull(celular))
			return false;
		if (celular.charAt(0) != '9')
			return false;
		Matcher matcher = _patron_celular.matcher(celular);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un número de DNI valido de <code>8 digitos</code>.
	 * 
	 * @param dni el número de DNI a verificar
	 * @return <code>true</code> si la cadena es un DNI válido; <code>false</code> otro caso
	 */
	public static boolean isDNI(String dni) {
		if (isNull(dni))
			return false;
		if (dni.equals("00000000"))
			return false;
		Matcher matcher = _patron_dni.matcher(dni);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un número de RUC valido de <code>11 digitos</code>.
	 * 
	 * @param ruc el número de RUC a verificar
	 * @return <code>true</code> si la cadena es un RUC válido; <code>false</code> otro caso
	 */
	public static boolean isRUC(String ruc) {
		if (isNull(ruc))
			return false;
		if (ruc.charAt(0) != '1' && ruc.charAt(0) != '2')
			return false;
		Matcher matcher = _patron_ruc.matcher(ruc);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es un número de carné de extanjería valido de
	 * <code>9 - 11 caracteres alfanumerico</code>.
	 * 
	 * @param ce el número de carné de extanjería a verificar
	 * @return <code>true</code> si la cadena es un carné de extanjería válido; <code>false</code>
	 *         otro caso
	 */
	public static boolean isCarneExtranjeria(String ce) {
		if (isNull(ce))
			return false;
		Matcher matcher = _patron_carnet_extranjeria.matcher(ce);
		return matcher.matches();
	}

	/**
	 * Retorna <code>true</code> Si la cadena es <code>null</code>, lo que indica una referencia a
	 * <code>null</code> ,nada más que espacios, o la cadena "<code>null</code>".
	 * 
	 * @param s la cadena a verificar
	 * @return <code>true</code> si la cadena es <code>null</code>; <code>false</code> otro caso
	 */
	public static boolean isNull(String s) {
		if (s == null) {
			return true;
		}

		int counter = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == CharPool.SPACE) {
				continue;
			} else if (counter > 3) {
				return false;
			}

			if (counter == 0) {
				if (c != CharPool.LOWER_CASE_N) {
					return false;
				}
			} else if (counter == 1) {
				if (c != CharPool.LOWER_CASE_U) {
					return false;
				}
			} else if ((counter == 2) || (counter == 3)) {
				if (c != CharPool.LOWER_CASE_L) {
					return false;
				}
			}

			counter++;
		}

		if ((counter == 0) || (counter == 4)) {
			return true;
		}

		return false;
	}

	/**
	 * Comprueba si es null. Fecha: 30/01/2013
	 * 
	 * @param l the l
	 * @return true, si es null
	 */
	public static boolean isNull(Long l) {
		if ((l == null) || (l.longValue() == 0)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Comprueba si es null. Fecha: 30/01/2013
	 * 
	 * @param obj the obj
	 * @return true, si es null
	 */
	public static boolean isNull(Object obj) {
		if (obj instanceof Long) {
			return isNull((Long) obj);
		} else if (obj instanceof String) {
			return isNull((String) obj);
		} else if (obj == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Retorna <code>true</code> si la cadena no es <code>null</code>, esto indica que no es una
	 * referencia <code>null</code>,nada mas que espacios, o la cadena "<code>null</code>".
	 * 
	 * @param l the l
	 * @return <code>true</code> si la cadena no es <code>null</code>; <code>false</code> en otro
	 *         caso
	 */
	public static boolean isNotNull(Long l) {
		return !isNull(l);
	}

	/**
	 * Returns <code>true</code> if the object is not <code>null</code>, using the rules from.
	 * 
	 * @param obj the object to check
	 * @return <code>true</code> if the object is not <code>null</code>; <code>false</code>
	 *         otherwise {@link #isNotNull(Long)} or {@link #isNotNull(String)} if the object is one
	 *         of these types.
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	/**
	 * Returns <code>true</code> if the array is not <code>null</code>, meaning it is neither a
	 * <code>null</code> reference or empty.
	 * 
	 * @param array the array to check
	 * @return <code>true</code> if the array is not <code>null</code>; <code>false</code> otherwise
	 */
	public static boolean isNotNull(Object[] array) {
		return !isNull(array);
	}

	/**
	 * Retorna <code>true</code> si la fecha es válida en el Calendario Gregoriano (Perú).
	 * 
	 * @param dia el dia a verificar
	 * @param mes el mes a verificar (basado en 0, 0 para enero)
	 * @param anio the anio
	 * @return <code>true</code> si la fecha es válida en el Calendario Gregoriano;
	 *         <code>false</code> en otro caso
	 */
	public static boolean isDate(int dia, int mes, int anio) {
		return isGregorianDate(dia, mes, anio);
	}

	/**
	 * Retorna <code>true</code> si la fecha es válida en el Calendario Gregoriano (Perú)..
	 * 
	 * @param dia el día del mes
	 * @param mes el mes (basado en 0, 0 para enero)
	 * @param anio el año
	 * @return <code>true</code> si la fecha es válida; <code>false</code> en otro caso
	 */
	public static boolean isGregorianDate(int dia, int mes, int anio) {
		if ((mes < 0) || (mes > 11)) {
			return false;
		}

		int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (mes == 1) {
			int febMax = 28;

			if (((anio % 4) == 0) && ((anio % 100) != 0) || ((anio % 400) == 0)) {

				febMax = 29;
			}

			if ((dia < 1) || (dia > febMax)) {
				return false;
			}
		} else if ((dia < 1) || (dia > months[mes])) {
			return false;
		}

		return true;
	}

	/**
	 * Comprueba si es direccion. Fecha: 30/01/2013
	 *
	 * @param direccion the direccion
	 * @return true, si es direccion
	 */
	public static boolean isDireccion(String direccion) {
		if (isNull(direccion))
			return false;
		Matcher matcher = _patron_direccion.matcher(direccion);
		return matcher.matches();
	}

	/**
	 * Comprueba si es mensaje.
	 * Fecha: 22/08/2013
	 *
	 * @param mensaje the mensaje
	 * @return true, si es mensaje
	 */
	public static boolean isMensaje(String mensaje) {
		if (isNull(mensaje))
			return false;
		Matcher matcher = _patron_mensaje.matcher(mensaje);
		return matcher.matches();
	}
}
