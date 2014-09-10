<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:defineObjects />

<c:if test="${not mostrarImagen}">
	<style>
			#p_p_id<portlet:namespace/>{
				display: none;
			}
	</style>
</c:if>
<c:if test="${mostrarImagen}">

	<portlet:renderURL var="urlMostrarContenido"
		windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		<portlet:param name="action" value="mostrarContenido" />
		<portlet:param name="idDetalleProducto" value="${idDetalleProducto}" />
	</portlet:renderURL>

	<div class="benner ">
		<c:choose>
			<c:when test="${mostrarLightBox}">
				<a href="${urlMostrarContenido}"
					data-milkbox-size="width:715,height:639" data-milkbox="milkbox:g2"><img
					src="${imagenProducto}" border="0" width="305"></a>
			</c:when>
			<c:otherwise>
				<a href="javascript:void(0)"><img
					src="${imagenProducto}" border="0" width="305"></a>
			</c:otherwise>
		</c:choose>
	</div>
</c:if>


