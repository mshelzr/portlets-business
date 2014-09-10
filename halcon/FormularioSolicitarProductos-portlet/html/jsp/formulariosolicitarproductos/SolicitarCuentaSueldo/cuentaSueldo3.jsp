<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);
	PortletSession pSession = renderRequest.getPortletSession();
	
	String ruta = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort();
	String urlDireccionarError = ruta + PortletProps.get("pagina.error");

	String tipDoc = (String) pSession.getAttribute("tipDoc");
	String ndocumento = (String) pSession.getAttribute("ndocumento");
	String apePater = (String) pSession.getAttribute("apePater");
	String apeMater = (String) pSession.getAttribute("apeMater");
	String priNombre = (String) pSession.getAttribute("priNombre");
	String segNombre = (String) pSession.getAttribute("segNombre");
	String fecNacimiento = (String) pSession
			.getAttribute("fecNacimiento");
	String tipsexo = (String) pSession.getAttribute("tipsexo");
	String razonSocial = (String) pSession.getAttribute("razonSocial");

	String cbodepartamento = (String) pSession
			.getAttribute("cbodepartamentoTexto");
	String celular = (String) pSession.getAttribute("celular");
	String telFijo = (String) pSession.getAttribute("telFijo");
	String telTrabajo = (String) pSession.getAttribute("telTrabajo");
	String anexo = (String) pSession.getAttribute("anexo");
	String email = (String) pSession.getAttribute("email");
	String confEmail = (String) pSession.getAttribute("confEmail");
	String checkCodProducto = (String) pSession
			.getAttribute("checkCodProducto");


	HttpServletRequest httpReq = PortalUtil
			.getOriginalServletRequest(PortalUtil
					.getHttpServletRequest(renderRequest));

	if (checkCodProducto == null) {
		checkCodProducto = "";
	}
%>

<c:set var="tipoDocumento" value="<%=tipDoc%>" />
<c:set var="tipoSexo" value="<%=tipsexo%>" />
<c:set var="checkCodProducto" value="<%=checkCodProducto%>" />
<c:set var="urlDireccionarError" value="<%=urlDireccionarError%>" />

<form action="/solicitud/cuenta-sueldo/4" method="post"
	name="<portlet:namespace/>fm3" id="<portlet:namespace/>fm3"
	enctype="multipart/form-data">
	<input type="hidden" id="hiddenF3" name="hiddenF3"
		value="<portlet:namespace/>fm3" />

	<div class="sol3" id="content-medio">
		<div class="selec-soli">
			<p>�Qui&eacute;n eres?</p>
			<p>�C&oacute;mo te ubicamos?</p>
			<p class="paso-confir">Confirmaci&oacute;n</p>
		</div>

		<!--sol-formulario-->
		<div id="paso3" class="sol-formulario paso3" name="paso3">
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Tipo de Documento</label>
				<p id="mostrarTipoDocumento">
					<c:choose>
						<c:when test="${tipoDocumento==2}">
				Carn� Ext.
              </c:when>
						<c:otherwise>
                DNI
              </c:otherwise>
					</c:choose>
				</p>
			</div>

			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>N&uacute;mero de Documento</label>
				<p id="mostrarNumeroDocumento"><%=ndocumento%></p>
			</div>

			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Apellido Paterno</label>
				<p id="mostrarApellidoPaterno"><%=apePater%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Apellido Materno</label>
				<p id="mostrarApellidoMaterno"><%=apeMater%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Primer Nombre</label>
				<p id="mostrarPrimerNombre"><%=priNombre%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Segundo Nombre</label>
				<p id="mostrarSegundoNombre"><%=segNombre%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Fecha de Nacimiento</label>
				<p id="mostrarFechaNacimiento"><%=fecNacimiento%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Sexo</label>
				<p id="mostrarTipoSexo">
					<c:choose>
						<c:when test="${tipoSexo==2}">
				Femenino
              </c:when>

						<c:otherwise>
                Masculino
              </c:otherwise>
					</c:choose>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Raz&oacute;n Social de tu Empleador</label>
				<p id="mostrarRazonSocial"><%=razonSocial%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Departamento</label>
				<p id="mostrarDepartamento"><%=cbodepartamento%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Celular</label>
				<p id="mostrarCelular"><%=celular%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Tel&eacute;fono de casa</label>
				<p id="mostrarTelefonoFijo"><%=telFijo%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Tel&eacute;fono de trabajo</label>
				<p id="mostrarTelefonoTrabajo"><%=telTrabajo%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Anexo</label>
				<p id="mostrarAnexo"><%=anexo%>
				</p>
			</div>
			<div class="campos-oblig-dos cuenta-sueldo-label">
				<label>Correo Electr&oacute;nico</label>
				<p id="mostrarEmail"><%=email%>
				</p>
			</div>
			<div class="both"></div>
		</div>

		<!--sol-publi-->
		<div id="contentProductosComplementarios">
		<c:forEach var="d" items="${lstContenido}" >                
             <liferay-ui:journal-article articleId="${d.idContenidoWeb}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
         </c:forEach> 	
		</div>

		<div class="soli-botones2">
			<div class="next-sol regresar con-decoration sin-margin">
				&lt; <a id="btn3Atras" name="btn3Atras" href="javascript:;" title="Modificar datos">Modificar
					datos</a>
			</div>

			<div class="bluebtn-cont width-sol sin-margin">
				<input name="btn3Adelante" id="btn3Adelante" type="button"
					value="Confirmar solicitud" class="boton-form2" title="Confirmar solicitud"/>
			</div>
		</div>
	</div>

</form>

<input type="hidden" id="obtenerURL" name="obtenerURL" value="${requestScope.obtenerURL}" />
<input type="hidden" id="paso" name="paso" value="${requestScope.paso}" />
<input type="hidden" id="obtenerFormato" name="obtenerFormato" value="${requestScope.formato}" />
<input type="hidden" id="urlPaso3_cs" value='<portlet:resourceURL id="paso3_cs"/>' />
<input type="hidden" id="checkCodProducto" name="checkCodProducto" value="${checkCodProducto}" />
<input type="hidden" id="urlDireccionarError" name="urlDireccionarError"	value="${urlDireccionarError}" />
<input type="hidden" id="nombre_producto_url" name="nombre_producto_url" value="${requestScope.nombre_producto_url}" />

<input type="hidden" id="numeroPaso1" name="numeroPaso1" value="${requestScope.numeroPaso1}" />
<input type="hidden" id="numeroPaso2" name="numeroPaso2" value="${requestScope.numeroPaso2}" />
<input type="hidden" id="numeroPaso4" name="numeroPaso4" value="${requestScope.numeroPaso4}" />

<input type="hidden" id="estadoPaso1Sueldo" name="estadoPaso1Sueldo" value="${requestScope.estadoPaso1Sueldo}" />
<input type="hidden" id="estadoPaso2Sueldo" name="estadoPaso2Sueldo" value="${requestScope.estadoPaso2Sueldo}" />