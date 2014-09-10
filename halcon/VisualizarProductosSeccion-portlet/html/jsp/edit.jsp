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
    height: 600px;
}


#perfil.insurance {
    height: 650px;
}


.dotted {
    border-top: 1px dotted #999999;
    clear: right;
    margin-top: 37px;
    padding: 5px 0;
    width: 267px;
}

.posiciones{
	color: white; 
	font-weight: bold; 
	margin-left: 11px; 
	font-size: 14px; 
	text-align: center; 
	line-height: 32px;
}

</style>

<form action="" method="post" name="fmVPS" id="fmVPS">
 <div class="sidebar">
   <div id="perfil" class="insurance">
     <div id="paso1" class="profile position">
       <div class="content">
         <div class="head"> <span>Configuración de Productos adicionales</span> </div>
         <div class="body seguros">
           <div class="content-head"></div>
           <div class="content-body">
	           <div class="title"> 
				<h2>Titulo <liferay-ui:icon-help message="Ingrese un titulo para  la sección." />:</h2><input value="${requestScope.titulo }" type="text" name="<portlet:namespace/>txtTitulo" style="width: 250px;"><br/><br/>
				 </div>
				<div class="title"> 
				<h2>Slogan <liferay-ui:icon-help message="Ingrese un slogan para la sección." />:</h2><input value="${requestScope.slogan }" type="text" name="<portlet:namespace/>txtResumen" style="width: 250px;"><br/><br/>
				 </div>
			  <br class="both" />
	           <div class="footer"> 
		           <input type="button" name="optEditar" id="optEditar" value="Modificar textos" url="<portlet:actionURL name="actionEditarURL" />"> 
	           </div>
           <div class="dotted"></div>
           
             <div class="title">
               <h2>Seleccione un producto <liferay-ui:icon-help message="Seleccione los productos adicionales que se mostrarán dentro de la sección." />:</h2>
             </div>
             <div class="title"> 
              <select style="width: 250px;" name="<portlet:namespace/>cmbProducto" id="cmbProducto">
               		<option value="0">Seleccione un producto</option>
               		<c:forEach items="${requestScope.productos }" var="productos">             		
               			<option value="${productos.codigo }">${productos.nombre }</option>
               		</c:forEach>
               </select>
             </div>
             <div class="title">
               <h2>Seleccione el orden del producto<liferay-ui:icon-help message="Seleccione el orden en el ecual se móstrara el prodcuto en el listado." />:</h2>
             </div>
             <div class="title"> 
              <select style="width: 250px;" name="<portlet:namespace/>cmbOrdenProducto" id="cmbOrdenProducto">
               		<option value="0">Seleccione un Orden</option>
               		<c:forEach items="${requestScope.ordenes }" var="ordenes">             		
               			<option value="${ordenes}">${ordenes}</option>
               		</c:forEach>
               </select>
             </div>
             <div class="title">
               <h2>Productos Adicionales: <liferay-ui:icon-help message="Productos adicionales que se mostrarán dentro de la sección." />:</h2>
             </div>
               <c:choose>
                 <c:when test="${requestScope.numAdicionales > 0 }">
	                  <c:forEach items="${requestScope.productosSeleccionados }" var="productosSeleccionados">             		
	               			<c:if test="${ productosSeleccionados.regitrado}">
	               				<div class="item"> <em ><span class="posiciones">${productosSeleccionados.orden }</span></em> <span class="text">${productosSeleccionados.nombre }</span> </div>
	               			</c:if>
	               		</c:forEach>
                 </c:when>
                 <c:otherwise>
                 		<div class="item"> <em ></em> <span class="text">NO HAY PRODUCTOS ADICIONALES REGISTRADOS.</span> </div>
                 </c:otherwise>
               </c:choose>
             		
           </div>
           <br class="both" />
           <div class="footer"> 
	           <input type="button" name="optRegistrar" id="optRegistrar" value="Registrar" url="<portlet:actionURL name="actionRegistrarURL" />"> 
	           <input type="button" name="optEliminar" id="optEliminar" value="Eliminar" style="float:right" url="<portlet:actionURL name="actionEliminarURL" />"> 
           </div>
         </div>
       </div>
     </div>
   </div>
<liferay-ui:success key="successEditRegistra" message="Se registro el producto correctamente." />
<liferay-ui:error key="errorEditRegistra" message="No se pudo registrar el producto intentelo de nuevo." />

<liferay-ui:success key="successEditElimina" message="Se elimino el producto correctamente." />
<liferay-ui:error key="errorEditElimina" message="No se pudo eliminar el producto intentelo de nuevo." />

<liferay-ui:success key="successEditEdita" message="Se registro el titulo y slogan correctamente." />
<liferay-ui:error key="errorEditEdita" message="No se pudo registrar el titulo y slogan intentelo de nuevo." />

 </div>
 <br class="both">
</form>