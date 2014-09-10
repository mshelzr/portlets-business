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

<%@page import="pe.com.ibk.halcon.gestionparametros.bean.soporte.Soporte"%>
<%@page import="pe.com.ibk.halcon.gestionparametros.bean.BeanListarParametro"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.ext.portlet.halcon.model.Parametro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ext.portlet.halcon.exception.BusinessException"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:defineObjects />

<link href="<c:url value="/css/ui-lightness/jquery-ui-1.9.1.custom.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/css/ui-lightness/jquery-ui-1.9.1.custom.min.css"></c:url>" rel="stylesheet">
<link href="<c:url value="/css/ui-lightness/ui.jqgrid.css"></c:url>" rel="stylesheet">

<portlet:actionURL var="actionURL" name="actionListarParametro" />
<portlet:actionURL var="actionURLEditarParametro" name="actionEditarParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLActivarParametro" name="actionActivarParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLDesactivarParametro" name="actionDesactivarParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLLimpiarListaParametro" name="actionLimpiarListaParametro" />
<portlet:actionURL var="actionURLGenerarUbigeo" name="actionGenerarUbigeo" />
<portlet:actionURL var="actionURLSincronizarJson" name="actionSincronizarJson" />
<portlet:actionURL var="actionURLNuevoParametro" name="actionNuevoParametro" >
	<portlet:param name="page" value="listarParametro"/>
</portlet:actionURL>


<%
/*Cambios de SEO*/

PortalUtil.setPageTitle("Mi titulo",request);
PortalUtil.setPageKeywords("Interbank",request);
PortalUtil.setPageDescription ("Mi descripcion personal",request);
%>

<table>
	<tr>
		<td></td>
		<td width="100%">
<table>
	<tr>
		<td>
		<!-- MENSAJES -->
		<c:if test="${requestScope.estado == 'success' }">
			<div class="portlet-msg-info">
				${requestScope.mensaje} 
			</div>
		</c:if>
		<c:if test="${requestScope.estado == 'error' }">
			<div class="portlet-msg-error">
				${requestScope.mensaje} 
			</div>
		</c:if>
		</td>
	</tr>
	<tr>
		<td><div class="results-header">BUSCAR PARÁMETROS.</div></td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>
<form:form id="formListarParametro" name="formListarParametro" action="${actionURL}" method="post" modelAttribute="beanListarParametro" cssClass="uni-form">
	<table>
	<tr>
		<td><form:label path="criterioListarParametro.descParametroPadre" for="criterioListarParametro.descParametroPadre">Descripción Padre</form:label></td>
		<td></td>
		<td><form:input path="criterioListarParametro.descParametroPadre" id="criterioListarParametro.descParametroPadre" size="30" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td></td
		<td>&nbsp;</td
		<td></td
		<td></td
	</tr>
	<tr>
		<td>
		<!-- <form:label path="criterioListarParametro.codParametro">Código</form:label>
		<form:input path="criterioListarParametro.codParametro" id="criterioListarParametro.codParametro" /> -->
		<form:label path="criterioListarParametro.descParametro" for="criterioListarParametro.descParametro">Descripción</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioListarParametro.descParametro" id="criterioListarParametro.descParametro" size="30" /></td>
		<td>&nbsp;</td>
		<td><input type="submit" id="btnEnviar" value="Buscar Parámetro" /></td>
	</tr>
	</table>
</form:form>
	</td></tr>
	
	<tr><td>
	<table>
		<tr>
			<td></td>
			<td>&nbsp;</td>
			<td></td>
			<td>&nbsp;</td>
			<td></td>
		</tr>
		<tr>
			<td><a href="${actionURLLimpiarListaParametro}">Limpiar</a></td>
			<td>&nbsp;</td>
			<td><a href="${actionURLGenerarUbigeo}">Generar Ubigeo</a></td>
			<td>&nbsp;</td>
			<td><a href="${actionURLSincronizarJson}">Sincronizar Json</a></td>
		</tr>
		<tr>
			<td></td>
			<td>&nbsp;</td>
			<td></td>
			<td>&nbsp;</td>
			<td></td>
		</tr>
	</table>
</td></tr>

<tr><td>

<%

    BeanListarParametro bean = (BeanListarParametro)request.getAttribute("beanListarParametro");
    List<Parametro> lista = bean.getLista();
    
    Integer count = (Integer)request.getAttribute("count");        
    Integer delta = (Integer)request.getAttribute("delta");        
    Integer cur = (Integer)request.getAttribute("cur");
    
    if(cur == null){
        cur = 1;
    }
    if(delta == null){
        delta = 20;
    }
    if (lista != null) {
		count = lista.size();
	}
    
    
    String search = (String) request.getAttribute("search");
    if(search == null){
        search = "";    
    }
    
    PortletURL portletURL = renderResponse.createRenderURL();
    
%>

			<liferay-ui:search-container iteratorURL="<%=portletURL %>" delta="<%=delta %>" emptyResultsMessage="Lista de Parámetros Vacía">
				<liferay-ui:search-container-results total="<%=count %>" results="<%= ListUtil.subList(lista, searchContainer.getStart(), searchContainer.getEnd()) %>" />
				<liferay-ui:search-container-row modelVar="parametro" className="com.ext.portlet.halcon.model.Parametro" >
		 			<liferay-ui:search-container-column-text name="id." orderableProperty="true" property="idParametro"></liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Descripción" orderableProperty="true" property="dato1"></liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="estado" orderableProperty="true" >
					
						<c:if test="${parametro.num1 == 0}">
							INACTIVO
						</c:if>
						<c:if test="${parametro.num1 == 1}">
							ACTIVO
						</c:if>
				
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="Descripción Padre" orderableProperty="true" property="dato4"></liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="tipo" orderableProperty="true" >
					
					
					<c:choose>
						<c:when test="${parametro.dato3 == 10}">
							RANGO
						</c:when>
						<c:when test="${parametro.dato3 == 20}">
							LISTA
						</c:when>
						<c:when test="${parametro.dato3 == 30}">
							VALOR
						</c:when>
						<c:otherwise>
							-
						</c:otherwise>
					</c:choose>
					
					
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="editar" orderableProperty="true">
					
						<c:if test="${parametro.idParametroPadre != ''}">
							<a href="<portlet:actionURL name="actionEditarParametro">
							<portlet:param name="page" value="listarParametro"/>
							<portlet:param name="id" value="${parametro.idParametro}"/>
						</portlet:actionURL>">Editar</a>
						</c:if>
					
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="activar" orderableProperty="true">
						
						<c:if test="${parametro.dato3 == 20}">					
							<c:if test="${parametro.idParametroPadre != ''}">
								<a href="<portlet:actionURL name="actionActivarParametro">
								<portlet:param name="page" value="listarParametro"/>
								<portlet:param name="id" value="${parametro.idParametro}"/>
							</portlet:actionURL>">Activar</a>
							</c:if>
						</c:if>
						<c:if test="${parametro.dato3 == 10 || parametro.dato3 == 30}">
							Activar
						</c:if>
						
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="desactivar" orderableProperty="true">
					
						<c:if test="${parametro.dato3 == 20 }">
							<c:if test="${parametro.idParametroPadre != ''}">
								<a href="<portlet:actionURL name="actionDesactivarParametro">
								<portlet:param name="page" value="listarParametro"/>
								<portlet:param name="id" value="${parametro.idParametro}"/>
							</portlet:actionURL>">Desactivar</a>
							</c:if>
						</c:if>
						<c:if test="${parametro.dato3 == 10 || parametro.dato3 == 30}">
							Desactivar
						</c:if>
					
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="<%=true %>"/>
			</liferay-ui:search-container>

</td></tr>

</table>

		</td>
		<td></td>
	</tr>
	

	
</table>