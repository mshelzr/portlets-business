package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AttributeType", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
// @XmlAccessorType(XmlAccessType.FIELD)
public class AttributeType {

	private String name;
	private String number;
	private String baseCatalog;
	private String baseTable;
	private String keycolumn;
	private String autoincrement;

	private Datatype datatype;

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "number", namespace = "urn:schemas-microsoft-com:rowset")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@XmlAttribute(name = "baseCatalog", namespace = "urn:schemas-microsoft-com:rowset")
	public String getBaseCatalog() {
		return baseCatalog;
	}

	public void setBaseCatalog(String baseCatalog) {
		this.baseCatalog = baseCatalog;
	}

	@XmlAttribute(name = "baseTable", namespace = "urn:schemas-microsoft-com:rowset")
	public String getBaseTable() {
		return baseTable;
	}

	public void setBaseTable(String baseTable) {
		this.baseTable = baseTable;
	}

	@XmlAttribute(name = "keycolumn", namespace = "urn:schemas-microsoft-com:rowset")
	public String getKeycolumn() {
		return keycolumn;
	}

	public void setKeycolumn(String keycolumn) {
		this.keycolumn = keycolumn;
	}

	@XmlAttribute(name = "autoincrement", namespace = "urn:schemas-microsoft-com:rowset")
	public String getAutoincrement() {
		return autoincrement;
	}

	public void setAutoincrement(String autoincrement) {
		this.autoincrement = autoincrement;
	}

	@XmlElement(name = "datatype", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
	public Datatype getDatatype() {
		return datatype;
	}

	public void setDatatype(Datatype datatype) {
		this.datatype = datatype;
	}

	public AttributeType() {

	}
}
