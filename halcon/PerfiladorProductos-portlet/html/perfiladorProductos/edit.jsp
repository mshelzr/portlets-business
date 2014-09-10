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


<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<input type="hidden" id="obtenerPerfiladorHidden" value='<portlet:resourceURL id="obtenerPerfilador" />'  >

<div class="PF-FM" id="papa" style="width: 450px; height: 215px;" >
<h2>Configuración de Perfilador</h2>

<%-- <input type="hidden" name="oculto" id="oculto" value="${requestScope.opcion}"/> --%>

<form action="<portlet:actionURL name="configuraPerfilador" />" name="<portlet:namespace/>fm1" method="post">
	<div class="soli-formato sin-border">
		<label style="float: left" for="<portlet:namespace/>cmbTipoPerfilador">Tipo de Perfilador:</label>
<%-- 		<select name="<portlet:namespace/>cmbTipoPerfilador" id="cmbTipoPerfilador"> --%>
<%-- 		   <option value="1"  <c:if test="${requestScope.tipoPerfilador==1}">selected="selected"</c:if>>Perfilador Hipotecario</option> --%>
<%-- 		   <option value="2"  <c:if test="${requestScope.tipoPerfilador==2}">selected="selected"</c:if>>Perfilador Tarjetas de Crédito</option> --%>
<%-- 		   <option value="3"  <c:if test="${requestScope.tipoPerfilador==3}">selected="selected"</c:if>>Perfilador Cuentas de Ahorrro</option> --%>
<%-- 		   <option value="4"  <c:if test="${requestScope.tipoPerfilador==4}">selected="selected"</c:if>>Perfilador Seguros</option> --%>
<!-- 		</select> -->
		<div id="cmbTipoPerfilador" class="dropdown2 wt190 float-left bgfa"></div>
	</div>
	<div class="soli-formato sin-border">
		<label style="float: left; line-height: 26px;" for="<portlet:namespace/>idPerfilador">ID Perfilador asociado: </label>
		<input style="width: 200px" type="text" name="<portlet:namespace/>idPerfilador" value="${requestScope.idPerfilador}"/> <liferay-ui:icon-help message="Ingrese el tipo de Perfilador." />
	</div>
	<div  class="soli-formato">
		<input style="margin-left: 35%;" type="submit" name="<portlet:namespace/>btnEnviar" value="Guardar"/> 
	</div>
</form>
	<liferay-ui:success key="successEdit" message="Se actualizo el parámetro correctamente." />
	<liferay-ui:error key="errorEdit" message="No se pudo registrar el parámetro intentelo de nuevo." />
</div>