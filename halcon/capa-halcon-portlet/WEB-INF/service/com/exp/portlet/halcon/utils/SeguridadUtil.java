package com.exp.portlet.halcon.utils;

public class SeguridadUtil {

	private  static final String passPhrase = "HALCON_SIMULADORES";
	private  static final StringEncrypter desEncrypter = new StringEncrypter(passPhrase);

	public static String desencripta(String s) throws Exception {
		return desEncrypter.decrypt(s);
	}
	
	public static String encripta(String s) throws Exception {
		return desEncrypter.encrypt(s);
	}

}