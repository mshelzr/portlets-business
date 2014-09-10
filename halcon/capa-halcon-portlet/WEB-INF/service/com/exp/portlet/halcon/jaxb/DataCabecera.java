package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data", namespace = "urn:schemas-microsoft-com:rowset")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCabecera {

	@XmlElement(name = "row", namespace = "#RowsetSchema")
	private Cabecera row;

	public Cabecera getRow() {
		return row;
	}

	public void setRow(Cabecera row) {
		this.row = row;
	}

	public DataCabecera() {

	}

}
