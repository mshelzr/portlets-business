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

<portlet:defineObjects />
<input type="hidden" id="obtenerReplicadorHidden" value='<portlet:resourceURL id="obtenerReplicador" />'  >


<div class="PF-FM" id="papa" style="width: 450px; height: 215px;" >
<h2>Replicadores de Crédito</h2>

<%-- <input type="hidden" name="oculto" id="oculto" value="${requestScope.opcion}"/> --%>

<form action="<portlet:actionURL name="configuraReplicador" />" name="<portlet:namespace/>fm1" method="post">
	<div class="soli-formato sin-border">
		<label style="float: left" for="<portlet:namespace/>cmbTipoReplicador">Tipo de Replicador:</label>
		<select name="<portlet:namespace/>cmbTipoReplicador" id="cmbTipoReplicador">
		   <option value="1"  <c:if test="${requestScope.tipoReplicador==1}">selected="selected"</c:if>>Replicador Crédito Hipotecario</option>
		   <option value="2"  <c:if test="${requestScope.tipoReplicador==2}">selected="selected"</c:if>>Perfilador Crédito Personal Garantía Hipotecaria</option>
		   <option value="3"  <c:if test="${requestScope.tipoReplicador==3}">selected="selected"</c:if>>Perfilador Crédito Personal</option>
		   <option value="4"  <c:if test="${requestScope.tipoReplicador==4}">selected="selected"</c:if>>Perfilador Crédito Vehicular</option>
		</select>
<!-- 		<div id="cmbTipoReplicador" class="dropdown2 wt190 float-left bgfa"></div> -->
	</div>
	
	<div  class="soli-formato">
		<input style="margin-left: 35%;" type="submit" name="<portlet:namespace/>btnEnviar" value="Guardar"/> 
	</div>
</form>
	<liferay-ui:success key="successEdit" message="Se actualizo el parámetro correctamente." />
	<liferay-ui:error key="errorEdit" message="No se pudo registrar el parámetro intentelo de nuevo." />
</div>
