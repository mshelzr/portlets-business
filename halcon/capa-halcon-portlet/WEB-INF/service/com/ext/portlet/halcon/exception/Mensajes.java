package com.ext.portlet.halcon.exception;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Mensajes {
	private static final String BUNDLE_NAME = "com.exp.portlet.halcon.exception";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Mensajes() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return null;
		}
	}
}
