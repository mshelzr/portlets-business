<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

<c:if test="${not empty requestScope.totalCategorias }">
 <div class="sidebar">
    <div class="roundy ann-frec-ask-dark">
      <h2><em class="icons ico-carp"></em>CATEGOR&iacute;AS EN LA B&Uacute;SQUEDA</h2>
      <div class="conte autheig roundy categorias-busqueda">
        <ul class="infor cat-busq">
          <!--<li class="cat-activo"><a href="#" title="General">General</a></li>
          <li><a href="#" title="Productos">Productos</a></li>
          <li><a href="#" title="Pagos y cobros">Pagos y cobros</a></li>
          <li><a href="#" title="Servicios">Servicios</a></li>
          <li><a href="#" title="Tiendas">Tiendas</a></li>
          <li class="sin-border"><a href="#" title="Agentes">Agentes</a></li> -->
          <c:forEach items="${requestScope.totalCategorias }" var="categorias" varStatus="i">
          	<c:set var="styleCategorias" value="" />
          	<c:if test="${i.last }"><c:set var="styleCategorias" value="sin-border" /></c:if>
          	
          	<c:set var="styleCategoriasSelected" value="" />
          	<c:if test="${requestScope.catID== categorias.categoryId}"><c:set var="styleCategoriasSelected" value="cat-activo" /></c:if>
          	<c:choose>
	          	<c:when test="${requestScope.idPregunta >0 }">  
	          		<li class="${styleCategorias } ${styleCategoriasSelected }"><a href="resultado-preguntas-frecuentes?id=${requestScope.idPregunta }&c=${categorias.categoryId}" title="${categorias.name }">${categorias.name }</a></li>
	          	</c:when>
	          	<c:otherwise>
	          		<li class="${styleCategorias } ${styleCategoriasSelected }"><a href="resultado-preguntas-frecuentes?keywords=${requestScope.key }&c=${categorias.categoryId}" title="${categorias.name }">${categorias.name }</a></li>
	          	</c:otherwise>
          	</c:choose>
          </c:forEach>
        </ul>
      </div>
    </div>
 </div>
</c:if>