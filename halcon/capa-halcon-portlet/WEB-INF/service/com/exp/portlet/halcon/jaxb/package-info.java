/**
 * 
 */
/**
 * @author ajimenez
 *
 */

@XmlSchema(
	    elementFormDefault = XmlNsForm.QUALIFIED,
	    xmlns={
	        @XmlNs(namespaceURI = "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882", prefix = "s"),
	        @XmlNs(namespaceURI = "uuid:C2F41010-65B3-11d1-A29F-00AA00C14882", prefix = "dt"),
	        @XmlNs(namespaceURI = "urn:schemas-microsoft-com:rowset", prefix = "rs"),
	        @XmlNs(namespaceURI = "#RowsetSchema", prefix = "z")
	    })
package com.exp.portlet.halcon.jaxb;

import javax.xml.bind.annotation.*;