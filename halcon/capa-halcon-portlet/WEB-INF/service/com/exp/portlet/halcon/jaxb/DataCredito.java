package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data", namespace = "urn:schemas-microsoft-com:rowset")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataCredito {

	@XmlElement(name = "row", namespace = "#RowsetSchema")
	private Credito row;

	public Credito getRow() {
		return row;
	}

	public void setRow(Credito row) {
		this.row = row;
	}

	public DataCredito() {

	}

}
