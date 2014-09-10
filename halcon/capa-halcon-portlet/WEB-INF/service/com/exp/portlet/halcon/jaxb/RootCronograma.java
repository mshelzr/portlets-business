package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootCronograma {

	@XmlElement(name = "data", namespace = "urn:schemas-microsoft-com:rowset")
	private DataCronograma data;

	@XmlElement(name = "Schema", namespace = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882")
	private Schema schema;

	public DataCronograma getData() {
		return data;
	}

	public void setData(DataCronograma data) {
		this.data = data;
	}

	public Schema getSchema() {
		return schema;
	}

	public void setSchema(Schema schema) {
		this.schema = schema;
	}

	public RootCronograma() {

	}

}
