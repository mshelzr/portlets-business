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


<div class="PF-FM" id="papa" style="width: 450px; height: 270px;" >
<h2>Configuración de Encabezado de Página</h2>

<input type="hidden" name="oculto" id="oculto" value="${requestScope.opcion}"/>

<form action="<portlet:actionURL name="actionApoyoURL" />" name="<portlet:namespace/>fm1" method="post">

	<div class="soli-formato sin-border">
		<label style="float: left; line-height: 26px;" for="<portlet:namespace/>contenidoPage">Slogan: </label>
		<input style="width: 290px" type="text" name="<portlet:namespace/>contenidoPage" value="${requestScope.contenidoPage}"/> <liferay-ui:icon-help message="Ingrese el slogan asociado a esta página." />
	</div>
	<div class="soli-formato sin-border">
		<label style="float: left; line-height: 26px;" for="<portlet:namespace/>sloganExt">Slogan extendido: </label>
		<input style="width: 290px" type="text" name="<portlet:namespace/>sloganExt" value="${requestScope.sloganExt}"/> <liferay-ui:icon-help message="Ingrese el slogan extendido asociado a esta página." />
	</div>
	<div  class="soli-formato">
		<input style="margin-left: 35%;" type="submit" name="<portlet:namespace/>btnEnviar" value="Guardar"/> 
	</div>
</form>
	<liferay-ui:success key="successEdit" message="Se actualizo el parámetro correctamente." />
	<liferay-ui:error key="errorEdit" message="No se pudo registrar el parámetro intentelo de nuevo." />
</div>