package com.exp.portlet.halcon.jaxb;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data", namespace = "urn:schemas-microsoft-com:rowset")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCronograma {

	@XmlElement(name = "row", namespace = "#RowsetSchema")
	private List<Cuota> listaRow;

	public List<Cuota> getListaRow() {
		return listaRow;
	}

	public void setRow(List<Cuota> listaRow) {
		this.listaRow = listaRow;
	}

	public DataCronograma() {

	}

}
