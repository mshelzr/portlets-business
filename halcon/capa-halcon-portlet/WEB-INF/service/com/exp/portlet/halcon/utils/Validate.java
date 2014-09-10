package com.exp.portlet.halcon.utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  
public @interface Validate {

	boolean isCadena()  default false;
	boolean isNombre()  default false;
	boolean isNumber()  default false;
	boolean isDigit() default false;
	boolean isApellido() default false;
	boolean isEmail() default false;
	boolean isTelefono() default false;
	boolean isCelular() default false;
	boolean isDNI() default false;
	boolean isRUC() default false;
	boolean isCarneExtranjeria() default false;
	boolean isNullType() default false;
	String isNullTypeName() default "String";
	boolean isNull() default false;
	boolean isNotNullType() default false;
	String isNotNullTypeName() default "String";
	boolean isNotNull() default false;
	boolean isDate() default false;
	boolean isGregorianDate() default false;
	boolean isTrue()  default false;
		
}
