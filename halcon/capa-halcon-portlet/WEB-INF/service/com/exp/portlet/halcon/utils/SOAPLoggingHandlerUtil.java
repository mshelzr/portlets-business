package com.exp.portlet.halcon.utils;


import java.io.PrintStream;
import java.util.Map;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/*
 * This simple SOAPHandler will output the contents of incoming
 * and outgoing messages.
 */
public class SOAPLoggingHandlerUtil implements SOAPHandler<SOAPMessageContext> {

    // change this to redirect output if desired
    private static PrintStream out = System.out;

    public Set<QName> getHeaders() {
        return null;
    }

    public boolean handleMessage(SOAPMessageContext smc) {
        try {
			logToSystemOut(smc);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    public boolean handleFault(SOAPMessageContext smc) {
        try {
			logToSystemOut(smc);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return true;
    }

    // nothing to clean up
    public void close(MessageContext messageContext) {
    }

    /*
     * Check the MESSAGE_OUTBOUND_PROPERTY in the context
     * to see if this is an outgoing or incoming message.
     * Write a brief message to the print stream and
     * output the message. The writeTo() method can throw
     * SOAPException or IOException
     */
    private void logToSystemOut(SOAPMessageContext smc) throws SOAPException {
        Boolean outboundProperty = (Boolean)
            smc.get (MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outboundProperty.booleanValue()) {
            out.println("\nOutbound message:");
        } else {
            out.println("\nInbound message:");
        }

        SOAPMessage message = smc.getMessage();
        try {
            message.writeTo(out);
            out.println("");   // just to add a newline
            
        } catch (Exception e) {
            out.println("Exception in handler: " + e);
        }
    }
}