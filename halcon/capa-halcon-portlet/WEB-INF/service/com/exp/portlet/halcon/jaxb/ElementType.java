package com.exp.portlet.halcon.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "ElementType", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
@XmlSeeAlso({ AttributeType.class })
// @XmlAccessorType(XmlAccessType.FIELD)
public class ElementType {

	private String name;
	private String content;
	private String updatable;

	private List<AttributeType> attributeType;

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@XmlAttribute(name = "updatable", namespace = "urn:schemas-microsoft-com:rowset")
	public String getUpdatable() {
		return updatable;
	}

	public void setUpdatable(String updatable) {
		this.updatable = updatable;
	}

	// @XmlElementWrapper
	// @XmlElementRef
	@XmlElement(name = "AttributeType", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
	public List<AttributeType> getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(List<AttributeType> attributeType) {
		this.attributeType = attributeType;
	}

	public ElementType() {
		this.attributeType = new ArrayList();
	}

	public ElementType(String name, String content, String updatable, List<AttributeType> attributeType) {
		this.name = name;
		this.content = content;
		this.updatable = updatable;
		this.attributeType = attributeType;
	}
}
