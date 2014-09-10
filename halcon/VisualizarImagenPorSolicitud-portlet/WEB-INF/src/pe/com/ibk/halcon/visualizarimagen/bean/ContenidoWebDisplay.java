package pe.com.ibk.halcon.visualizarimagen.bean;

public class ContenidoWebDisplay {
	
	private String titulo;
	private String contenido;
	private String tituloHTML;
	private String tituloAmigable;
	private boolean saltoLinea;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getTituloHTML() {
		return tituloHTML;
	}
	public void setTituloHTML(String tituloHTML) {
		this.tituloHTML = tituloHTML;
	}
	public String getTituloAmigable() {
		return tituloAmigable;
	}
	public void setTituloAmigable(String tituloAmigable) {
		this.tituloAmigable = tituloAmigable;
	}

	public boolean isSaltoLinea() {
		return saltoLinea;
	}

	public void setSaltoLinea(boolean saltoLinea) {
		this.saltoLinea = saltoLinea;
	}
	
}
