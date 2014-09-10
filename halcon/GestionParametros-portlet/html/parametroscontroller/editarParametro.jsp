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

<%@page import="pe.com.ibk.halcon.gestionparametros.bean.BeanEditarParametro"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.ext.portlet.halcon.model.Parametro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<portlet:defineObjects />
<portlet:renderURL var="renderHome" windowState="normal"/>
<portlet:actionURL var="actionURLCancelarEditarParametro" name="actionCancelarEditarParametro" >
	<portlet:param name="page" value="editarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLEditarParametro" name="actionEditarParametro" >
	<portlet:param name="page" value="editarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLActivarParametro" name="actionActivarParametro" >
	<portlet:param name="page" value="editarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLDesactivarParametro" name="actionDesactivarParametro" >
	<portlet:param name="page" value="editarParametro"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLLimpiarEditarParametro" name="actionLimpiarEditarParametro" />
<portlet:actionURL var="actionURLGuardarParametro" name="actionGuardarParametro" />
<portlet:actionURL var="actionURLMostrarFormularioParametro" name="actionMostrarFormularioParametro" />
<portlet:actionURL var="actionURLNuevoParametro" name="actionNuevoParametro" >
	<portlet:param name="page" value="nuevoParametro"/>
	<portlet:param name="id" value="${beanEditarParametro.criterioEditarParametro.parametro.idParametroPadre}"/>
</portlet:actionURL>
<portlet:actionURL var="actionURLNuevoRango" name="actionNuevoParametro" >
	<portlet:param name="page" value="nuevoRangoSiebel"/>
	<portlet:param name="id" value="${beanEditarParametro.criterioEditarParametro.parametro.idParametroPadre}"/>
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
	<td></td>
</tr>
	<tr>
		<td><div class="results-header">EDITAR PARÁMETROS.</div></td>
	</tr>
	<tr><td>&nbsp;</td></tr>
	<tr><td>

<!-- FORMULAIRO PRINCIPAL -->
<c:if test="${empty beanEditarParametro.criterioEditarParametro.parametroPadre.num2 && !beanEditarParametro.criterioEditarParametro.nuevoRango}">
<table>
<form:form id="formEditarParametro" name="formEditarParametro" action="${actionURLMostrarFormularioParametro}" method="post" modelAttribute="beanEditarParametro">
<tr>
	<td>
		<form:label path="criterioEditarParametro.parametro.idParametroPadre" for="criterioEditarParametro.parametro.idParametroPadre">Contenedor:</form:label>
	</td>
	<td>&nbsp;</td>
	<td>
		<form:select path="criterioEditarParametro.parametro.idParametroPadre" id="criterioEditarParametro.parametro.idParametroPadre" disabled="false" onchange="javascript:mostrarFormulario(this.form);">
			<form:option value="0" label="Seleccionar" />
			<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaPadreParametro}" itemValue="idParametro" itemLabel="dato1"/>
		</form:select>
	</td>
</tr>
</form:form>
</table>
</c:if>


<!-- FORMULAIRO DE TIPO RANGO -->
<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 && !beanEditarParametro.criterioEditarParametro.nuevoRango}">
<table>
<form:form id="formEditarParametro" name="formEditarParametro" action="${actionURLGuardarParametro}" method="post" modelAttribute="beanEditarParametro">
<tr>
	<td><form:label path="criterioEditarParametro.parametro.idParametroPadre" for="criterioEditarParametro.parametro.idParametroPadre">Contenedor:</form:label></td>
	<td>&nbsp;</td>
	<td><form:select path="criterioEditarParametro.parametro.idParametroPadre" id="criterioEditarParametro.parametro.idParametroPadre" disabled="true">
		<form:option value="0" label="Seleccionar" />
		<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaPadreParametro}" itemValue="idParametro" itemLabel="dato1"/>
	</form:select></td>
	<td>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<td></td>
	<td>&nbsp;</td>
	<td></td>
	<td>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<td colspan="5"><div class="results-header">DETALLE PARÁMETRO.</div></td>
</tr>
<tr>
	<td></td>
	<td>&nbsp;</td>
	<td></td>
	<td>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<td><form:label path="criterioEditarParametro.parametro.dato1" for="criterioEditarParametro.parametro.dato1">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato1}</form:label></td>
	<td>&nbsp;</td>
	<td><form:input path="criterioEditarParametro.parametro.dato1" id="criterioEditarParametro.parametro.dato1" size="70"/></td>
	<td>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto1 ne 'NONE'}">
		<td><form:label path="criterioEditarParametro.parametro.valorMonto1" for="criterioEditarParametro.parametro.valorMonto1">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto1}</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.valorMonto1" id="criterioEditarParametro.parametro.valorMonto1" size="30"/></td>
		<td>&nbsp;</td>
	</c:if>
	<td></td>
</tr>
<tr>
	<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto2 ne 'NONE'}">
		<td><form:label path="criterioEditarParametro.parametro.valorMonto2" for="criterioEditarParametro.parametro.valorMonto2">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto2}</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.valorMonto2" id="criterioEditarParametro.parametro.valorMonto2" size="30"/></td>
		<td>&nbsp;</td>
	</c:if>
	<td></td>
</tr>
<tr>
	<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto3 ne 'NONE'}">
		<td><form:label path="criterioEditarParametro.parametro.valorMonto3" for="criterioEditarParametro.parametro.valorMonto3">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto3}</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.valorMonto3" id="criterioEditarParametro.parametro.valorMonto3" size="30"/></td>
		<td>&nbsp;</td>
	</c:if>

	<td></td>
</tr>
<tr>
	<td><form:label path="criterioEditarParametro.parametro.num1" for="criterioEditarParametro.parametro.num1">Estado:</form:label></td>
	<td>&nbsp;</td>
	<td><form:select path="criterioEditarParametro.parametro.num1" id="criterioEditarParametro.parametro.num1" disabled="true">
		<form:option value="1" label="Seleccionar" />
		<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaEstadoParametro}" itemValue="idEstado" itemLabel="nombreEstado"/>
	</form:select></td>
	<td>&nbsp;</td>
	<td></td>
</tr>
<tr>
	<td><input type="submit" id="btnGuardar" value="Guardar" /></td>
	<td>&nbsp;</td>
	<td></td>
	<td>&nbsp;</td>
	<td></td>
</tr>

</form:form>
</table>
</c:if>

<!-- FORMULAIRO DE TIPO LISTA -->
<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20 && !beanEditarParametro.criterioEditarParametro.nuevoRango}">
<table>
<form:form id="formEditarParametro" name="formEditarParametro" action="${actionURLGuardarParametro}" method="post" modelAttribute="beanEditarParametro">
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.idParametroPadre" for="criterioEditarParametro.parametro.idParametroPadre">Contenedor:</form:label></td>
		<td>&nbsp;</td>
		<td colspan="6">
			<form:select path="criterioEditarParametro.parametro.idParametroPadre" id="criterioEditarParametro.parametro.idParametroPadre" disabled="true" >
				<form:option value="0" label="Seleccionar" />
				<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaPadreParametro}" itemValue="idParametro" itemLabel="dato1"/>
			</form:select>
		</td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td colspan="9"><div class="results-header">DETALLE PARÁMETRO.</div></td>
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.dato1" for="criterioEditarParametro.parametro.dato1" >${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato1}</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.dato1" id="criterioEditarParametro.parametro.dato1" size="30"/></td>
		<td>&nbsp;</td>
		<td></td>
		
		<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto1 ne 'NONE'}">
			<td><form:label path="criterioEditarParametro.parametro.valorMonto1" for="criterioEditarParametro.parametro.valorMonto1">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto1}</form:label></td>
			<td>&nbsp;</td>
			<td><form:input path="criterioEditarParametro.parametro.valorMonto1" id="criterioEditarParametro.parametro.valorMonto1" size="30"/></td>
			<td>&nbsp;</td>
			<td></td>	
		</c:if>
		
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.dato2" for="criterioEditarParametro.parametro.dato2">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato2}</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.dato2" id="criterioEditarParametro.parametro.dato2"/></td>
		<td>&nbsp;</td>
		<td></td>
		
		<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto2 ne 'NONE'}">
			<td><form:label path="criterioEditarParametro.parametro.valorMonto2" for="criterioEditarParametro.parametro.valorMonto2">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto2}</form:label></td>
			<td>&nbsp;</td>
			<td><form:input path="criterioEditarParametro.parametro.valorMonto2" id="criterioEditarParametro.parametro.valorMonto2" size="30"/></td>
			<td>&nbsp;</td>
			<td></td>
		</c:if>
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.num2" for="criterioEditarParametro.parametro.num2">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmNum2}</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.num2" id="criterioEditarParametro.parametro.num2" size="5"/></td>
		<td>&nbsp;</td>
		<td></td>
		
		<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto3 ne 'NONE'}">
			<td><form:label path="criterioEditarParametro.parametro.valorMonto3" for="criterioEditarParametro.parametro.valorMonto3">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto3}</form:label></td>
			<td>&nbsp;</td>
			<td><form:input path="criterioEditarParametro.parametro.valorMonto3" id="criterioEditarParametro.parametro.valorMonto3" size="30"/></td>
			<td>&nbsp;</td>
			<td></td>
		</c:if>
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.listaValorPorDefecto">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmNum3}</form:label></td>
		<td>&nbsp;</td>
		<td><form:checkbox path="criterioEditarParametro.listaValorPorDefecto"/></td>
		<td>&nbsp;</td>
		<td></td>
		
<%-- 		<c:if test="${beanEditarParametro.criterioEditarParametro.parametro.idParametro == 0}"> --%>
			<td><form:label path="criterioEditarParametro.parametro.dato4" for="criterioEditarParametro.parametro.dato4">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato4}</form:label></td>
			<td>&nbsp;</td>
			<td><form:input path="criterioEditarParametro.parametro.dato4" id="criterioEditarParametro.parametro.dato4" size="30"/></td>
			<td>&nbsp;</td>
			<td></td>
<%-- 		</c:if> --%>
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.num1" for="criterioEditarParametro.parametro.num1">${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmNum1}:</form:label></td>
		<td>&nbsp;</td>
		<td>
			<form:select path="criterioEditarParametro.parametro.num1" id="criterioEditarParametro.parametro.num1">
				<form:option value="1" label="Seleccionar" />
				<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaEstadoParametro}" itemValue="idEstado" itemLabel="nombreEstado"/>
			</form:select>
		</td>
		<td>&nbsp;</td>
		<td></td>
		
		<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.dato3 == 'ZONAS_RIESGO_FONDOS_MUTUOS'}">
			<td><form:label path="criterioEditarParametro.parametro.dato3" for="criterioEditarParametro.parametro.dato3">URL</form:label></td>
				<td>&nbsp;</td>
				<td><form:input path="criterioEditarParametro.parametro.dato3" id="criterioEditarParametro.parametro.dato3" size="30"/></td>
				<td>&nbsp;</td>
			<td></td>
		</c:if>
	</tr>
	
	<tr>
		<td><input type="submit" id="btnGuardar" value="Guardar" /></td>
		<td>&nbsp;</td>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
</form:form>
</table>
</c:if>

<!-- FORMULAIRO DE TIPO VALOR -->
<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 30 && !beanEditarParametro.criterioEditarParametro.nuevoRango}">
<table>
<form:form id="formEditarParametro" name="formEditarParametro" action="${actionURLGuardarParametro}" method="post" modelAttribute="beanEditarParametro">
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.idParametroPadre" for="criterioEditarParametro.parametro.idParametroPadre">Contenedor:</form:label></td>
		<td>&nbsp;</td>
		<td>
			<form:select path="criterioEditarParametro.parametro.idParametroPadre" id="criterioEditarParametro.parametro.idParametroPadre" disabled="true">
				<form:option value="0" label="Seleccionar" />
				<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaPadreParametro}" itemValue="idParametro" itemLabel="dato1"/>
			</form:select>
		</td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td colspan="5"><div class="results-header">DETALLE PARÁMETRO.</div></td>
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.dato1" for="criterioEditarParametro.parametro.dato1">Valor</form:label></td>
		<td>&nbsp;</td>
		<td><form:input path="criterioEditarParametro.parametro.dato1" id="criterioEditarParametro.parametro.dato1" size="30"/></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td><form:label path="criterioEditarParametro.parametro.num1" for="criterioEditarParametro.parametro.num1">Estado:</form:label></td>
		<td>&nbsp;</td>
		<td>
			<form:select path="criterioEditarParametro.parametro.num1" id="criterioEditarParametro.parametro.num1" disabled="true">
				<form:option value="1" label="Seleccionar" />
				<form:options items="${beanEditarParametro.soporteEditarParametro.dbListaEstadoParametro}" itemValue="idEstado" itemLabel="nombreEstado"/>
			</form:select>
		</td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td><input type="submit" id="btnGuardar" value="Guardar" /></td>
		<td>&nbsp;</td>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
</form:form>
</table>
</c:if>


<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 && beanEditarParametro.criterioEditarParametro.nuevoRango}">
	<table>
		<form:form id="formEditarParametro" name="formEditarParametro" action="${actionURLGuardarParametro}" method="post" modelAttribute="beanEditarParametro">
			<tr>
				<td><form:label path="criterioEditarParametro.beanNuevoRango.etiquetaProducto" for="criterioEditarParametro.beanNuevoRango.etiquetaProducto">Etiqueta</form:label></td>
				<td>&nbsp;&nbsp;</td>
				<td><form:input path="criterioEditarParametro.beanNuevoRango.etiquetaProducto" id="criterioEditarParametro.beanNuevoRango.etiquetaProducto" size="30"/></td>
				<td>&nbsp;</td>
				<td></td>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="criterioEditarParametro.beanNuevoRango.nombreProducto" for="criterioEditarParametro.beanNuevoRango.nombreProducto">Nombre de producto</form:label></td>
				<td>&nbsp;</td>
				<td><form:input path="criterioEditarParametro.beanNuevoRango.nombreProducto" id="criterioEditarParametro.beanNuevoRango.nombreProducto" size="30"/></td>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="criterioEditarParametro.beanNuevoRango.codigoSiebel" for="criterioEditarParametro.beanNuevoRango.codigoSiebel">Código Siebel</form:label></td>
				<td>&nbsp;</td>
				<td><form:input path="criterioEditarParametro.beanNuevoRango.codigoSiebel" id="criterioEditarParametro.beanNuevoRango.codigoSiebel" size="30"/></td>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td><form:label path="criterioEditarParametro.beanNuevoRango.codigoHPC" for="criterioEditarParametro.beanNuevoRango.codigoHPC">Código HPC</form:label></td>
				<td>&nbsp;</td>
				<td><form:input path="criterioEditarParametro.beanNuevoRango.codigoHPC" id="criterioEditarParametro.beanNuevoRango.codigoHPC" size="30"/></td>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" id="btnGuardar" value="Guardar" /></td>
				<td>&nbsp;</td>
				<td></td>
				<td>&nbsp;</td>
				<td></td>
			</tr>
			
		</form:form>
	</table>
</c:if>

<table>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
	<tr>
		<td><a href="${actionURLLimpiarEditarParametro}">Limpiar</a></td>
		<td>&nbsp;</td>
		<td><a href="${actionURLCancelarEditarParametro}">Cancelar</a></td>
		<td>&nbsp;</td>
		<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20}">
			<td><a href="${actionURLNuevoParametro}">Agregar</a></td>
		</c:if>
		<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10}">
			<td><a href="${actionURLNuevoRango}">Agregar Rango</a></td>
		</c:if>
		 
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;</td>
		<td></td>
	</tr>
</table>
 



<%

    BeanEditarParametro bean = (BeanEditarParametro)request.getAttribute("beanEditarParametro");
    List<Parametro> lista = bean.getLista();
    
    Integer count = (Integer)request.getAttribute("count");        
    Integer delta = (Integer)request.getAttribute("delta");        
    Integer cur = (Integer)request.getAttribute("cur");
    
    if(cur == null){
        cur = 1;
    }
    if(delta == null){
        delta = 5;
    }
    if (lista != null) {
		count = lista.size();
	}
    
    
    String search = (String) request.getAttribute("search");
    if(search == null){
        search = "";    
    }
    
    
    PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("action", "editarParametro");
    
%>

			<liferay-ui:search-container iteratorURL="<%=portletURL %>" delta="<%=delta %>" emptyResultsMessage="No se han encontrado Parámetros.">
				<liferay-ui:search-container-results total="<%=count %>" results="<%= ListUtil.subList(lista, searchContainer.getStart(), searchContainer.getEnd()) %>" />
				<liferay-ui:search-container-row modelVar="parametro" className="com.ext.portlet.halcon.model.Parametro" >
		 			<liferay-ui:search-container-column-text name="id." orderableProperty="true" property="idParametro"></liferay-ui:search-container-column-text>
		 			<c:choose>
			 			<c:when test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 30}">
			 				<liferay-ui:search-container-column-text name="Valor" orderableProperty="true" property="dato1"></liferay-ui:search-container-column-text>
			 			</c:when>
			 			<c:otherwise>
			 				<liferay-ui:search-container-column-text name="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato1}" orderableProperty="true" property="dato1"></liferay-ui:search-container-column-text>
			 			</c:otherwise>
			 			
		 			</c:choose>
					<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto1 ne 'NONE' and (beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20 or beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 )}">
						<liferay-ui:search-container-column-text name="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto1}" orderableProperty="true" property="valorMonto1"></liferay-ui:search-container-column-text>
					</c:if>
					<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto2 ne 'NONE' and (beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20 or beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 )}">
						<liferay-ui:search-container-column-text name="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto2}" orderableProperty="true" property="valorMonto2"></liferay-ui:search-container-column-text>
					</c:if>
					<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto3 ne 'NONE' and (beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20 or beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 )}">
						<liferay-ui:search-container-column-text name="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmValorMonto3}" orderableProperty="true" property="valorMonto3"></liferay-ui:search-container-column-text>
					</c:if>
					
					<c:if test="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato4 ne 'NONE' and beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20 }">
						<liferay-ui:search-container-column-text name="${beanEditarParametro.criterioEditarParametro.labelFormParametros.labelParmDato4}" orderableProperty="true" property="dato4"></liferay-ui:search-container-column-text>
					</c:if>
					<liferay-ui:search-container-column-text name="estado" orderableProperty="true" >
					
						<c:if test="${parametro.num1 == 0}">
							INACTIVO
						</c:if>
						<c:if test="${parametro.num1 == 1}">
							ACTIVO
						</c:if>
				
					</liferay-ui:search-container-column-text>
					<!-- FORMULAIRO DE TIPO LISTA -->
					<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20}">
						<liferay-ui:search-container-column-text name="orden" orderableProperty="true" property="num2"></liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="por defecto" orderableProperty="true">
						
							<c:if test="${parametro.num3 == 0}">
								NO
							</c:if>
							<c:if test="${parametro.num3 == 1}">
								SI
							</c:if>
						
						</liferay-ui:search-container-column-text>
					</c:if>
					<liferay-ui:search-container-column-text name="editar" orderableProperty="true">
					
						<c:if test="${parametro.idParametroPadre != ''}">
							<a href="<portlet:actionURL name="actionEditarParametro">
							<portlet:param name="page" value="editarParametro"/>
							<portlet:param name="id" value="${parametro.idParametro}"/>
						</portlet:actionURL>">Editar</a>
						</c:if>
					
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="activar" orderableProperty="true">
					
						<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20}">
							<c:if test="${parametro.idParametroPadre != ''}">
								<a href="<portlet:actionURL name="actionActivarParametro">
								<portlet:param name="page" value="editarParametro"/>
								<portlet:param name="id" value="${parametro.idParametro}"/>
							</portlet:actionURL>">Activar</a>
							</c:if>
						</c:if>
						<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 || beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 30}">
							Activar
						</c:if>
					
					</liferay-ui:search-container-column-text>
					<liferay-ui:search-container-column-text name="desactivar" orderableProperty="true">
					
						<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 20}">
							<c:if test="${parametro.idParametroPadre != ''}">
								<a href="<portlet:actionURL name="actionDesactivarParametro">
								<portlet:param name="page" value="editarParametro"/>
								<portlet:param name="id" value="${parametro.idParametro}"/>
							</portlet:actionURL>">Desactivar</a>
							</c:if>
						</c:if>
						<c:if test="${beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 10 || beanEditarParametro.criterioEditarParametro.parametroPadre.num2 == 30}">
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