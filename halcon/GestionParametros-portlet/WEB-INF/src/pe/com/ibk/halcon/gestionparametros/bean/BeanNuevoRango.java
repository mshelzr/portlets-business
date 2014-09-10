package pe.com.ibk.halcon.gestionparametros.bean;

import java.io.Serializable;

public class BeanNuevoRango implements Serializable {

	private static final long serialVersionUID = 1L;	
	private String etiquetaProducto;
	private String nombreProducto;
	private String codigoSiebel;
	private String codigoHPC;
	private String estado;

	public String getEtiquetaProducto() {
		return etiquetaProducto;
	}

	public void setEtiquetaProducto(String etiquetaProducto) {
		this.etiquetaProducto = etiquetaProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCodigoSiebel() {
		return codigoSiebel;
	}

	public void setCodigoSiebel(String codigoSiebel) {
		this.codigoSiebel = codigoSiebel;
	}

	public String getCodigoHPC() {
		return codigoHPC;
	}

	public void setCodigoHPC(String codigoHPC) {
		this.codigoHPC = codigoHPC;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}