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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<portlet:defineObjects />
<input type="hidden" id="guardarCategoriaHidden" value='<portlet:resourceURL id="agregarCategoriaNueva" />'  >
<input type="hidden" id="eliminarCategoriaHidden" value='<portlet:resourceURL id="eliminarCategoria" />'  >
<input type="hidden" id="editarCategoriaHidden" value='<portlet:resourceURL id="editarCategoria" />'  >
<input type="hidden" id="agregarSubCategoriaHidden" value='<portlet:resourceURL id="agregarSubCategoria" />'  >

<form id="formCategorias"  name="categoriaPreguntas" method="post" action="<portlet:resourceURL id="eliminarCategoria" />">
<div style="width: 50%">
	<div style="font-weight: bold; color: green;">Gestión de Categorías de Preguntas Frecuentes</div>
	
	<div>
		<div style="margin: 10px; margin-left: 17%;">
			<input type="radio" name="tipoCategoria" value="categoria" checked="checked" style="margin-left: 30px;">Categoria
			<input type="radio" name="tipoCategoria" value="subcategoria" style="margin-left: 30px;">Subcategoria
		</div>
		
		<div id="ingresarCategoria" style="display: block; margin: 10px;margin-left: 20%; height: 30px;">
				<div style="float: left; margin-right: 10px; line-height: 28px;"> Categoria</div>
				<div><input type="text" id="nombreCategoria" disabled="disabled" ></div>
		</div>
		
		<div id="ingresarSubCategoria" style="display: none;margin: 10px; margin-left: 20%;">
			<div><div style="float: left;margin-right: 10px; width: 70px; line-height: 28px;"> Categoria</div>
			<div style="height: 38px;">
			<select id="nombreCategoriaC" disabled="disabled" style="width: width: 120px;">
				<c:forEach var="cat" items="${lstCategorias}">
					<option value="${cat.getIdCategoriaSubCat()}">${cat.getDescripcion()}</option>
	            </c:forEach>  
			</select> 
			</div></div>
			<div style="height: 30px;"><div style="float: left;margin-right: 10px; line-height: 35px;"> SubCategoria</div>
			<div><input type="text" id="nombreSubCategoria" style="display: inline;" disabled="disabled"></div></div>
		</div>
		<div id="botones" >
				<div><input type="button" id="agregarCategoria" value="Agregar" style="float: left; margin:20px; margin-left: 50px;"></div>
				<div><input type="button" id="guardarCategoria" value="Guardar" style="float: left; margin:20px; margin-left: 50px; margin-right: 50px;"></div>
				<div><input type="button" id="cancelarAc" value="Cancelar" style="margin-left: 50px; margin:20px;"></div>
		</div>
		<div style="float: left;">
			

			<div id="listaCategorias">
				<table>
					<tr><td></td><td>Descripción</td><td>Tipo</td></tr>
					<c:forEach var="cat" items="${lstCategorias}">
						<tr><td><input type="checkbox" name="option1[]" value="${cat.getIdCategoriaSubCat()}"></td>
							<td>${cat.getDescripcion()}</td>
							<td>
								<c:out value="${cat.getIdCategoriaSubCatPadre() eq '' ? 'Categoria': 'Subcategoria'}" />
							</td>
							
							<td><a href="#">Editar</a></td></tr>
		            </c:forEach>   
				</table>
			</div>
			
			<div id="listaSubCategorias" style="display: none;">
				<table>
					<tr><td></td><td>Descripción</td><td>Tipo</td></tr>
					<c:forEach var="cat" items="${lstSubCategorias}">
						<tr><td><input type="checkbox" name="categoria" value="${cat.getIdCategoriaSubCat()}"></td>
							<td>${cat.getDescripcion()}</td>
							<td>
								<c:out value="${cat.getIdCategoriaSubCatPadre() eq '' ? 'Categoria': 'Subcategoria'}" />
							</td>
							
							<td><a href="#{request.getContextPath()}">Editar</a></td></tr>
		            </c:forEach>  
				</table>
			</div>
			
			<div style="width: 100%; float: left;"><input type="button" id="eliminarCat" value="Eliminar" style="float: left; margin:20px; margin-left: 50px;"></div>
		</div>

	</div>
</div>
</form>