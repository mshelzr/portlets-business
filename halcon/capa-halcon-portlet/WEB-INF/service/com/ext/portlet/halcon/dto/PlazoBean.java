package com.ext.portlet.halcon.dto;

/**
 * @author rlopez
 *
 */
public class PlazoBean {
	
	private Integer id;
	private Integer etiqueta;
	private String tool;
	private Integer orden;
	private Integer defecto;
	
	public PlazoBean() {
		
	}
	
	public PlazoBean(Integer id, Integer etiqueta, String tool, Integer orden,
			Integer defecto) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
		this.tool = tool;
		this.orden = orden;
		this.defecto = defecto;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(Integer etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Integer getDefecto() {
		return defecto;
	}
	public void setDefecto(Integer defecto) {
		this.defecto = defecto;
	}
	
}
