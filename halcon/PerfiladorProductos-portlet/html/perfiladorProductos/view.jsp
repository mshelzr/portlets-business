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


<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<input type="hidden" id="obtenerComponentesHidden" value='<portlet:resourceURL id="obtenerComponentes" />'  >
<input type="hidden" id="enviarPerfiladorHidden" value='<portlet:resourceURL id="enviarPerfilador" />'  >
<input type="hidden" id="actualizarPerfiladorHidden" value='<portlet:resourceURL id="actualizarPerfilador" />'  >
<input type="hidden" id="obtenerPerfiladorHidden" value='<portlet:resourceURL id="obtenerPerfilador" />'  >
<input type="hidden" id="calcularRangoSliderHidden" value='<portlet:resourceURL id="calcularRangoSlider" />'  >
<input type="hidden" id="simularCreditoHipotecarioHidden" value='<portlet:resourceURL id="simularCreditoHipotecario" />'  >


<% String rutaImg = themeDisplay.getPathThemeImages() + "/halcon";%>
<c:set var="urlImagen" value="<%=rutaImg %>" scope="request"/>


		<div id="perfil" class="card">
		  <div id="paso1" class="profile position">
		    <div class="content">
	            <div class="head"> 
	            	<span id="cabeceraPerfilador">Descubre el producto Ahorros que <br/>tenemos para ti</span> 
	            </div>
            	
           		<div class="body">
           			<div id="bloque1" style="display: none;" class="cntObjPerfilador">
           			</div>
           			<div id="bloque2" style="display: none;" class="cntObjPerfilador">
           			</div>
           			<div id="bloque3" style="display: none;" class="cntObjPerfilador">
           			</div>
               		<div class="footer"><a href="javascript:void(0);" id="btnpaso1" class="btn btnlarge card" style="">Descubre tu producto</a></div>
					<div><input id="tipoPerf" type="hidden" value="" > </div>
					<div><input id="tipoPerfilador" type="hidden" value="" > </div>
           		</div>
              <div class="footer footerreply"></div> 
        	</div>
		</div>
		
		<div id="paso2" class="profile position w303">
	          <div class="content">
	            <div class="head"> <span id="cabecera2">¡Genial! Tenemos un crédito para ti, <br />
	              elige la que mejor te convenga</span> </div>
	            <div class="body">
	              <div class="content-head"></div>
	              <div id="resultadoProducto" class="content-body">
	              </div>
	              <div class="footer footerreply"> </div>
	            </div>
	          </div>
		 </div>
	</div>
