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
<portlet:actionURL var="actionURL" name="actionRespuesta">
	<portlet:param name="id" value="${variableRespuestaPerfiladorBean.idVariablePerfilador}"/>
</portlet:actionURL>

<h2>Respuestas Nivel ${nivelVariable}</h2>


<form:form id="formNuevaRespuesta" name="formNuevaRespuesta"
	action="${actionURL}" method="post" modelAttribute="variableRespuestaPerfiladorBean" cssClass="uni-form">
	<table>
		<tr>
			<td><form:label path="nombre" for="nombre">Pregunta</form:label></td>
			<td></td>
			<td colspan="4"><form:textarea path="nombre" readonly="true"
					cols="70" rows="2" /></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td height="3px;">
			<td>
		</tr>
		<tr>
			<td><form:label path="codigoClasificacion" 
					for="codigoClasificacion">Tipo de Respuesta</form:label></td>
			<td><form:hidden path="codigoClasificacion" ></form:hidden></td>
			<td><form:input readonly="true" path="tipoRespuestaTexto" /> </td>
		</tr>
		<tr>
			<td height="3px;">
			<td>
		</tr>
		<c:choose>
			<c:when test="${variableRespuestaPerfiladorBean.codigoClasificacion == 10}">
				<tr>
					<td><form:label path="valor1" for="valor1">Valor Inicial</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="valor1"  size="30" readonly="true" /></td>
					<td></td>
				</tr>
				<tr>
					<td height="3px;">
					<td>
				</tr>
				<tr>
					<td><form:label path="valor2" for="valor2">Valor Final</form:label></td>
					<td></td>
					<td><form:input path="valor2" size="30" readonly="true" /></td>
				</tr>

			</c:when>
		</c:choose>
		<tr><td colspan="6"><hr width=100% align="center"></td></tr>
		<c:choose>
			<c:when test="${variableRespuestaPerfiladorBean.codigoClasificacion == 10}">
				<tr id="val1">
					<td><form:label path="respuestaAsociada.valor1" for="respuestaAsociada.valor1">Valor Inicial</form:label></td>
					<td></td>
					<td colspan="2"><form:input path="respuestaAsociada.valor1" id="valor1" size="30" /></td>
					<td></td>
				</tr>
				<tr>
					<td height="3px;">
					<td>
				</tr>
				<tr>
					<td><form:label path="respuestaAsociada.valor2" for="respuestaAsociada.valor2">Valor Final</form:label></td>
					<td></td>
					<td><form:input path="respuestaAsociada.valor2" id="valor2" size="30"/></td>
				</tr>

			</c:when>
			<c:otherwise>
				<tr>
					<td><form:label path="respuestaAsociada.nombre" 
							for="respuestaAsociada.nombre">Respuesta</form:label></td>
					<td></td>
					<td><form:textarea path="respuestaAsociada.nombre" cols="70" rows="2" /></td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td height="3px;">
			<td>
		</tr>
		<tr>
			<td><form:label path="respuestaAsociada.estado" for="respuestaAsociada.estado">Estado</form:label></td>
			<td></td>
			<td><form:select path="respuestaAsociada.estado" id="respuestaAsociada.estado" disabled="false">
				<form:option value="1" label="Activo" />
				<form:option value="0" label="Inactivo" />
				</form:select></td>
		</tr>
		<tr><td height="20px;" colspan="4"></td></tr>
		<tr>
			<td></td>
			<td></td>
			<td>
			<input type="hidden" id="codigoPregunta" value="${variableRespuestaPerfiladorBean.idVariablePerfilador}"></td>

			<td></td>
			<td></td>
			<td></td>
							
			<td><c:if test="${not flagEdicion}"><input type="submit" id="actionAgregarR" name="action" value="Agregar Respuesta" /></c:if></td>
			
		</tr>
		<tr><td height="10px;"></td> </tr>
		<%
			int cant = ((VariablePerfiladorBean)request.getAttribute("variableRespuestaPerfiladorBean")).getListaErrores().size();
		%>
<%-- 		<c:if test="${variableRespuestaPerfiladorBean.listaErrores.size()>0}"> --%>
			<% if(cant>0) {%>
				<td colspan="6">
					<c:forEach items="${variableRespuestaPerfiladorBean.listaErrores}" var="error">
						<p class="portlet-msg-error" id="msj">${error}</p>
					</c:forEach>
				</td>
			<%} %>
			<tr>
			</tr>
<%-- 		</c:if> --%>
		
	</table>
	
	<%
			
			List<ConfiguracionPerfilador> lista = (List<ConfiguracionPerfilador>) request
					.getAttribute("listadoRespuestasPerfilador");

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
			if (lista != null) {
				count = lista.size();
			}

			String search = (String) request.getAttribute("search");
			if (search == null) {
				search = "";
			}

			PortletURL portletURL = renderResponse.createRenderURL();
	%>
	
	<liferay-ui:search-container iteratorURL="<%=portletURL%>"
		delta="<%=delta%>" emptyResultsMessage="Lista de Respuestas Vacia">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(lista, searchContainer.getStart(),
							searchContainer.getEnd())%>"
			total="<%=count%>" />
		<liferay-ui:search-container-row modelVar="variable"
			className="com.ext.portlet.halcon.model.ConfiguracionPerfilador">
			<liferay-ui:search-container-column-text name="id"
				orderableProperty="true" property="idConfiguracionPerfilador"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Descripción"
				orderableProperty="true" property="nombreVariable"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Mínimo">
				<c:choose>
						<c:when test="${variableRespuestaPerfiladorBean.codigoClasificacion == 10}">
							${variable.valor1}
						</c:when>
						<c:otherwise>
							--
						</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Máximo">
				<c:choose>
						<c:when test="${variableRespuestaPerfiladorBean.codigoClasificacion == 10}">
							${variable.valor2}
						</c:when>
						<c:otherwise>
							--
						</c:otherwise>
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
							<a href="<portlet:actionURL name="actionEditarRespuesta">
	                           <portlet:param name="actionEditarRespuesta" value="edit" />
	                           <portlet:param name="id" value="${variable.idConfiguracionPerfilador}"/>
	                     	</portlet:actionURL>">Editar</a>
	
						</c:when>
				</c:choose>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Asociar">
				<c:choose>
						<c:when test="${variable.estado == 0 || variable.estado == 1}">
					<a
						href="<portlet:actionURL name="actionAsociarPreguntas">
	                           <portlet:param name="action" value="asociar" />
	                           <portlet:param name="id" value="${variable.idConfiguracionPerfilador}" />
	                     </portlet:actionURL>">Asociar Pregunta</a>
	                 </c:when>
				</c:choose>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
	
	<input type="submit" name="action" id="btnGuardar" value="Guardar"  />
	<input type="submit" name="action" id="btnCancelar" value="Cancelar" />
	<a href="<portlet:actionURL name="irRegresarRespuesta">
								<portlet:param name="action" value="irRegresarRespuesta" />
							</portlet:actionURL>">Regresar</a>

</form:form>

<%
ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
String urlPortal = themeDisplay.getURLPortal();
%>

<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.core.js"> </script>
<script type="text/javascript"  src="<%=urlPortal%>/halcon-theme/js/halcon/mootools.more.js"> </script>