package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "datatype", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
public class Datatype {

	private String type;
	private String maxlength;
	private String maybenull;

	@XmlAttribute(name = "type", namespace = "uuid:C2F41010-65B3-11d1-A29F-00AA00C14882")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlAttribute(name = "maxlength", namespace = "uuid:C2F41010-65B3-11d1-A29F-00AA00C14882")
	public String getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(String maxlength) {
		this.maxlength = maxlength;
	}

	@XmlAttribute(name = "maybenull", namespace = "urn:schemas-microsoft-com:rowset")
	public String getMaybenull() {
		return maybenull;
	}

	public void setMaybenull(String maybenull) {
		this.maybenull = maybenull;
	}

	public Datatype() {

	}

	public Datatype(String type, String maxlength, String maybenull) {
		this.type = type;
		this.maxlength = maxlength;
		this.maybenull = maybenull;
	}

}
