package com.ext.test.controllers;

import com.exp.portlet.halcon.utils.JSonUtil;

import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: Auto-generated Javadoc
/**
 * <ul>
 * <li>Copyright 2013 Interbank - IBK. Todos los derechos reservados.</li>
 * </ul>
 * 
 * The Class DemoController.
 *
 * @author Infonet Consulting S.A.C.
 * Fecha:  22/08/2013
 * @version Halcon 1.0
 */
@Controller
@RequestMapping("VIEW")
public class DemoController {

	/** The indicador portlet. */
	private static Integer indicadorPortlet=52;
	
	/** The indicador controller. */
	private static Integer indicadorController=1;
	/* Ejemplos del uso del Metodo Render */
	/**
	 * Default view.
	 * Fecha: 22/08/2013
	 *
	 * @param renderRequest the render request
	 * @return the string
	 */
	@RequestMapping
	protected String defaultView(RenderRequest renderRequest) {
		JSonUtil.LogAuditoria(renderRequest, indicadorPortlet, indicadorController);
		return "view";
	}
}
