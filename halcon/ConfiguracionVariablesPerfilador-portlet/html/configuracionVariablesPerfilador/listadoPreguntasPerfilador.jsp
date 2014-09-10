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

<%@page import="pe.com.ibk.halcon.gestionperfilador.bean.VariablePerfiladorBean"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.ext.portlet.halcon.model.ConfiguracionPerfilador"%>
<%@page
	import="pe.com.ibk.halcon.gestionperfilador.bean.BeanListadoVariables"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>


<portlet:defineObjects />
<portlet:actionURL var="actionURL" name="action">
</portlet:actionURL>

<portlet:actionURL var="actionEditarPregunta" name="actionEditarPregunta" >
<%-- 	<portlet:param name="page" value="listadoPreguntasPerfilador"/> --%>
</portlet:actionURL>

<portlet:actionURL var="actionAsociarPregunta" name="actionAsociarPregunta" >
<%-- 	<portlet:param name="page" value="listadoPreguntasPerfilador"/> --%>
</portlet:actionURL>

<h2>Pregunta Nivel ${nivelVariable}</h2>

<form:form id="formNuevaVariable" name="formNuevaVariable"
	action="${actionURL}" method="post" modelAttribute="variablePreguntaPerfiladorBean" cssClass="uni-form">
	<table>
		<tr>
			<td><form:label path="nombre" for="nombre">Pregunta</form:label></td>
			<td></td>
			<td colspan="4"><form:textarea path="nombre" id="nombrePreg"
					cols="70" rows="2" /></td>
			<td><form:hidden  path="idVariablePerfilador" for="idVariablePerfilador" /></td>
			<td></td>
		</tr>
		<tr>
			<td height="3px;">
			<td>
		</tr>
		<tr>
			<td><form:label path="codigoClasificacion"
 					for="codigoClasificacion">Tipo de Respuesta</form:label></td> 
			<td></td>
<%-- 			<td><form:radiobutton id="sliderPreguntaCheck" path="codigoClasificacion" value="10" --%>
<%-- 					cssClass="radio" />Slider</td> --%>
<%-- 			<td><form:radiobutton id="comboPreguntaCheck" path="codigoClasificacion" value="20" --%>
<%-- 					cssClass="radio" />Combo</td> --%>
<%-- 			<td><form:radiobutton id="listaPreguntaCheck" path="codigoClasificacion" value="40" --%>
<%-- 					cssClass="radio" />Lista</td> --%>
<!-- 			<td></td> -->
<%-- 			<td><form:radiobutton id="listaImgPreguntaCheck" path="codigoClasificacion" value="30" --%>
<%-- 					cssClass="radio" />Lista con Imagen</td> --%>
			<td>
				<form:select path="codigoClasificacion" id="codigoClasificacion" disabled="false">
					<form:option value="10" label="Slider"  />
					<form:option value="20" label="Combo" />
					<form:option value="30" label="Lista con Imagen" />
					<form:option value="40" label="Lista Horizontal" />
				</form:select>
			</td>

			<td></td>
		</tr>
		
		<tr>
			<td height="3px;">
			<td>
		</tr>
		<tr>
			<td><form:label path="estado" for="estado">Estado</form:label></td>
			<td></td>
			
			<td>
				<form:select path="estado" id="estado" disabled="false">
				<form:option value="1" label="Activo" />
				<form:option value="0" label="Inactivo" />
<%-- 				<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaPadreParametro}" itemValue="idParametro" itemLabel="dato1"/> --%>
				</form:select>
			</td>
<%-- 			<td><form:radiobutton path="estado" value="1" --%>
<%-- 					cssClass="radio" />Activo</td> --%>
<%-- 			<td><form:radiobutton path="estado" value="0" --%>
<%-- 					cssClass="radio" />Inactivo</td> --%>
		</tr>
		<tr>
			<td height="3px;">
			<td>
		</tr>

		<c:choose>
			<c:when test="${variablePreguntaPerfiladorBean.codigoClasificacion == 10}">
				<tr id="val1">
					<td><form:label path="valor1" for="valor1">Valor Inicial</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor1" id="valor1" size="30" /></td>
					<td></td>
					<td></td>
				</tr>
				
				<tr>
					<td height="3px;">
					<td>
				</tr>
				
				<tr id="val2">
					<td><form:label path="valor2" for="valor2">Valor Final</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor2" id="valor2" size="30" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td height="3px;">
					<td>
				</tr>
				<tr id="val3" >
					<td><form:label path="valor3" for="valor3">Incremento</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor3" id="valor3" size="30" /></td>
					<td></td>
					<td></td>
				</tr>
			</c:when>
			<c:otherwise>
				<tr id="val1" style="display: none;">
					<td><form:label path="valor1" for="valor1">Valor Inicial</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor1" id="valor1" size="30" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td height="3px;">
					<td>
				</tr>
				<tr id="val2" style="display: none;">
					<td><form:label path="valor2" for="valor2">Valor Final</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor2" id="valor2" size="30" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td height="3px;">
					<td>
				</tr>
				<tr id="val3" style="display: none;" >
					<td><form:label path="valor3" for="valor3">Incremento</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor3" id="valor3" size="30" /></td>
					<td></td>
					<td></td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr><td height="20px;" colspan="4"></td></tr>
		
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			
			<td></td>
			<td>
			<c:if test="${not flagEdicion}">
				<input type="submit" id="actionAgregarP" name="action" value="Agregar Pregunta" />
			</c:if>
			</td>
		</tr>
		<tr><td height="10px;"></td> </tr>
		<%
			int cant = ((VariablePerfiladorBean)request.getAttribute("variablePreguntaPerfiladorBean")).getListaErrores().size();
		%>
<%-- 		<c:if test="${variablePreguntaPerfiladorBean.listaErrores.size()>0}"> --%>
				<% if(cant>0) {%>
					<td colspan="3">
						<c:forEach items="${variablePreguntaPerfiladorBean.listaErrores}" var="error">
							<p class="portlet-msg-error" id="msj">${error}</p>
						</c:forEach>
					</td>
					
				<%} %>
			<tr>
			</tr>
<%-- 		</c:if> --%>
		
	</table>

	<%
		BeanListadoVariables beanP = (BeanListadoVariables) request
					.getAttribute("beanListadoVariables");
			
			List<ConfiguracionPerfilador> listaP = beanP.getListaVariable();
			System.out.println(listaP.size());

			Integer count = (Integer) request.getAttribute("count");
			Integer delta = (Integer) request.getAttribute("delta");
			Integer cur = (Integer) request.getAttribute("cur");
			String estadoT = (String) request.getAttribute("estadoT");

			if (cur == null) {
				cur = 1;
			}
			if (delta == null) {
				delta = 20;
			}
			if (listaP != null) {
				count = listaP.size();
			}

			String search = (String) request.getAttribute("search");
			if (search == null) {
				search = "";
			}

			PortletURL portletURL = renderResponse.createRenderURL();
	%>

	<liferay-ui:search-container iteratorURL="<%=portletURL%>"
		delta="<%=delta%>" emptyResultsMessage="Lista de Preguntas Vacia">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(listaP, searchContainer.getStart(),
							searchContainer.getEnd())%>"
			total="<%=count%>" />
		<liferay-ui:search-container-row modelVar="variable"
			className="com.ext.portlet.halcon.model.ConfiguracionPerfilador">
			<liferay-ui:search-container-column-text name="id"
				property="idConfiguracionPerfilador"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Descripción"
				orderableProperty="true" property="nombreVariable"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Tipo Respuesta">

				<c:choose>
					<c:when test="${variable.codigoClasificacion == 10}">
							Slider
						</c:when>
					<c:when test="${variable.codigoClasificacion == 20}">
							Combo
						</c:when>
					<c:when test="${variable.codigoClasificacion == 30}">
							Lista con Imagen
						</c:when>
					<c:when test="${variable.codigoClasificacion == 40}">
							Lista Horizontal
						</c:when>
				</c:choose>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Estado">

				<c:choose>
					<c:when test="${variable.estado == 0}">
						Inactivo
					</c:when>
					<c:when test="${variable.estado == 2}">
						Inactivo
					</c:when>
					<c:otherwise>
						Activo
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Editar">
				<c:choose>
					<c:when test="${variable.estado == 0 || variable.estado == 1}">
						
						<a href="<portlet:actionURL name="actionEditarPregunta"> 
		                       <portlet:param name="actionEditarPregunta" value="edit" />
		                       <portlet:param name="id" value="${variable.idConfiguracionPerfilador}"/>
		                </portlet:actionURL>">Editar</a>

					</c:when>

				</c:choose>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Asociar">
				<c:choose>
					<c:when test="${variable.estado == 0 || variable.estado == 1}">
						<a
							href="<portlet:actionURL name="actionAsociarRespuestas">
		                           <portlet:param name="action" value="asociaRespuestas" />
		                           <portlet:param name="id" value="${variable.idConfiguracionPerfilador}" />
		                     </portlet:actionURL>">Asociar Respuestas</a>
				
					</c:when>
				</c:choose>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>

	<input type="submit" name="action" id="btnGuardar" value="Guardar Pregunta"  />
	<input type="submit" name="action" id="btnCancelar" value="Cancelar" />
	<a href="<portlet:actionURL name="irRegresarPregunta">
						<portlet:param name="action" value="irRegresarPregunta" />
					</portlet:actionURL>">Regresar</a>

</form:form>

<%
ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String urlPortal = themeDisplay.getURLPortal();
%>

<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.core.js"> </script>
<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.more.js"> </script>