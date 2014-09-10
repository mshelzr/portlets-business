package com.ext.portlet.halcon.exception;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


public class BusinessException extends Exception {

	/**
	 * 
	 */
	private static Log _log = LogFactoryUtil.getLog(BusinessException.class);
	private static final long serialVersionUID = 1L;

	private String sqlState;

	private String message;
	
	private String errorMessage;
	
	private String trazaMessage;

	private String sqlSentence;

	private int errorCode;

	private String sqlMessage;
	
	private List<String> lista = new ArrayList<String>();
	
	public String getMensajesError(){
		String valor = null;
		String espacio = "\n";
		for (int i = 0; i < lista.size(); i++) {
			valor = valor + lista.get(i) + espacio;
			_log.info("*******valor**************:"+valor);
		}
		return valor;
	}

	public BusinessException(String errorMessage, String trazaMessage) {
		this.errorMessage = errorMessage;
		this.trazaMessage = trazaMessage;
		_log.info("*******trazaMessage**************:"+trazaMessage);
		lista.add(errorMessage + trazaMessage);
	}

	public BusinessException(String sqlState, String message,
			String sqlSentence, int errorCode, String sqlMessage) {
		this.sqlState = sqlState;
		this.message = message;
		this.sqlSentence = sqlSentence;
		this.errorCode = errorCode;
		this.sqlMessage = sqlMessage;
	}
	
	public BusinessException(String message) {

		this.message = message;

	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getSqlMessage() {
		return sqlMessage;
	}

	public String getSqlSentence() {
		return sqlSentence;
	}

	public String getSqlState() {
		return sqlState;
	}

	public String getMessage() {
		String msg = message;
		if (errorCode != 0) {
			msg = Mensajes.getString(String.valueOf(errorCode));
			if (msg == null)
				msg = "La operación no tuvo éxito:" + message;
		}
		if (sqlMessage != null)
			msg = msg + ". Causa: " + sqlMessage;
		return msg;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getTrazaMessage() {
		return trazaMessage;
	}

	public List<String> getLista() {
		return lista;
	}

	
	
}
