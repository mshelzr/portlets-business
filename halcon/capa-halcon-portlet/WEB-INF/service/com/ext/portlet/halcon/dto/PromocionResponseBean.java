package com.ext.portlet.halcon.dto;

public class PromocionResponseBean {
	
	private String codigoPromocion;
	
	public String getCodigoPromocion() {
		return codigoPromocion;
	}

	public void setCodigoPromocion(String codigoPromocion) {
		this.codigoPromocion = codigoPromocion;
	}

	
	@Override
	public String toString() {
		return getCodigoPromocion();
	}
	
}
