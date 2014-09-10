<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<portlet:defineObjects />


<input type="hidden" id="limite" value="${limite}">
<div>
	

	<br><br><br>
<%-- 	<portlet:resourceURL id="guardarArchivo" var="guardarArchivo" ></portlet:resourceURL> --%>
	<portlet:resourceURL id="obtenerRespuesta" var="obtenerRespuesta" ></portlet:resourceURL>
	<input type="hidden" value="${obtenerRespuesta}" id="obtenerRespuesta" >
	<portlet:actionURL name="guardarArchivo" var="guardarArchivo">	
	</portlet:actionURL>
	<portlet:resourceURL id="verListaErrores" var="verListaErrores" ></portlet:resourceURL>
	<input type="hidden" value="${verListaErrores}" id="verListaErrores" >
		
	<form id="formSociosRemesa" action="${guardarArchivo}" method="post"  enctype="multipart/form-data">
	<div class="uploader_de">
            <div id="UpImg">
              <input id="archivo_masivo"name="<portlet:namespace/>archivo_masivo" type="file" class=""/>
              <div class="btnupload">
                <p>Seleccionar</p>
              </div>
              <div class="both"></div>
            </div>
            <div class="float-left">                           
              <a href="javascript:void(0);"  id="btnGrabar"   >              
             	 <img alt=""  src="/cargarTiendas-portlet/img/cargar_arch2.jpg" >
              </a>   
            </div>
            <div class="both"></div>
          </div>
          <div>
          <p id="msj"></p>
          </div>
          <input type="submit" style="display: none" id="btnSubmit" >
	</form>	
</div>

<%
ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String urlPortal = themeDisplay.getURLPortal();
%>

<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.core.js"> </script>
<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.more.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/rotater.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/tabs.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/scrollable.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/slimpicker.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/slideGallery.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/milkbox.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/autocompleted-final.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/DD_roundies.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/validator.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/ajaxupload.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/moovalid.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/File.upload.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/moodropdown.js"> </script>
<script type="text/javascript" src="<%=urlPortal%>/halcon-theme/js/halcon/functions.js"> </script>

