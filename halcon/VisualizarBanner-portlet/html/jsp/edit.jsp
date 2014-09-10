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

<style>
.seguros {
    height: 150x;
}


#perfil.insurance {
    height: 200px;
}


.dotted {
    border-top: 1px dotted #999999;
    clear: right;
    margin-top: 37px;
    padding: 5px 0;
    width: 267px;
}
</style>

<form action="" method="post" name="fmVPS" id="fmVPS">
 <div class="sidebar">
   <div id="perfil" class="insurance">
     <div id="paso1" class="profile position">
       <div class="content">
         <div class="head"> <span>Configuración de visualización de banner promocional</span> </div>
         <div class="body seguros">
           <div class="content-head"></div>
           <div class="content-body">

             <div class="title">
               <h2>Seleccione un modo de visualización <liferay-ui:icon-help message="Seleccione el modo de visualización del banner (LAteral o Central)." />:</h2>
             </div>
             <div class="title"> 
              <select style="width: 250px;" name="<portlet:namespace/>cmbProducto" id="cmbProducto">
               		<option value="0">Seleccione un modo</option>
               		<option value="L" <c:if test="${requestScope.tipo =='L'}">selected="selected"</c:if>    >Lateral</option>
               		<option value="C" <c:if test="${requestScope.tipo =='C'}">selected="selected"</c:if> >Central</option>             
               </select>
             </div>

             		
           </div>
           <br class="both" />
           <div class="footer"> 
	           <input type="button" name="optRegistrar" id="optRegistrar" value="Registrar" url="<portlet:actionURL name="actionRegistrarURL" />">  
           </div>
         </div>
       </div>
     </div>
   </div>
<liferay-ui:success key="successEditRegistra" message="Se registro el modo correctamente." />
<liferay-ui:error key="errorEditRegistra" message="No se pudo registrar el modo intentelo de nuevo." />
 </div>
</form>