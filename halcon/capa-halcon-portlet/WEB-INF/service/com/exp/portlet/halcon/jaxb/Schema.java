package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Schema", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
// @XmlAccessorType(XmlAccessType.FIELD)
public class Schema {

	private String id;

	private ElementType elementType;

	@XmlAttribute(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement(name = "ElementType", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
	public ElementType getElementType() {
		return elementType;
	}

	public void setElementType(ElementType elementType) {
		this.elementType = elementType;
	}

	public Schema() {

	}

	public Schema(String id, ElementType elementType) {
		this.id = id;
		this.elementType = elementType;
	}

}
