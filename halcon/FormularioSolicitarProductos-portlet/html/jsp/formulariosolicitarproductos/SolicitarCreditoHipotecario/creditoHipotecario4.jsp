
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<portlet:defineObjects />

<!-- Facebook Conversion Code for Crédito Hipotecario - Halcón -->
<script type="text/javascript">
var fb_param = {};
fb_param.pixel_id = '6016421084066';
fb_param.value = '0.00';
fb_param.currency = 'USD';
(function(){
  var fpw = document.createElement('script');
  fpw.async = true;
  fpw.src = '//connect.facebook.net/en_US/fp.js';
  var ref = document.getElementsByTagName('script')[0];
  ref.parentNode.insertBefore(fpw, ref);
})();
</script>
<noscript><img height="1" width="1" alt="" style="display:none" src="https://www.facebook.com/offsite_event.php?id=6016421084066&amp;value=0&amp;currency=USD" /></noscript>


<%
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	PortletSession pSession = renderRequest.getPortletSession();
	String ruta = request.getScheme() + "://" + request.getServerName() + ":"
			+ request.getServerPort();

	String tipDoc = (String) pSession.getAttribute("tipDoc");
	String ndocumento = (String) pSession.getAttribute("ndocumento");
	String apePater = (String) pSession.getAttribute("apePater");
	String apeMater = (String) pSession.getAttribute("apeMater");
	String priNombre = (String) pSession.getAttribute("priNombre");
	String segNombre = (String) pSession.getAttribute("segNombre");
	String fecNacimiento = (String) pSession.getAttribute("fecNacimiento");
	String tipsexo = (String) pSession.getAttribute("tipsexo");
	String ruc = (String) pSession.getAttribute("ruc");
	String razonSocial = (String) pSession.getAttribute("razonSocial");

	String cbodepartamento = (String) pSession.getAttribute("cbodepartamentoTexto");
	String cboprovincia = (String) pSession.getAttribute("cboprovinciaTexto");
	String celular = (String) pSession.getAttribute("celular");
	String telFijo = (String) pSession.getAttribute("telFijo");
	String telTrabajo = (String) pSession.getAttribute("telTrabajo");
	String anexo = (String) pSession.getAttribute("anexo");
	String email = (String) pSession.getAttribute("email");
	String confEmail = (String) pSession.getAttribute("confEmail");

	String urlDireccionar = ruta + (String) pSession.getAttribute("urlRedireccionar");
	String mensajeConfirmacion = (String) pSession.getAttribute("mensajeConfirmacion");
	String nombreApellido = priNombre + " " + apePater;
	String titulo = (String) pSession.getAttribute("titulo");

	Integer error = (Integer) pSession.getAttribute("error");
	String tituloProducto = (String) pSession.getAttribute("tituloProducto");
	
%>
<c:set var="tipoDocumento" value="<%=tipDoc%>" />
<c:set var="urlDireccionar" value="<%=urlDireccionar%>" />
<c:set var="titulo" value="<%=titulo%>" />
<c:set var="error" value="<%=error%>" />

<div class="sol4" id="content-medio">

	<!--sol-formulario-->
	<div class="sol-formulario paso4">
		<c:choose>
			<c:when test="${error != 0}">
				<div class="resul-titulo con-decoration">
					<em class="exito"></em>
					<h3><%=nombreApellido%></h3>
					<%=mensajeConfirmacion%>
				</div>
			</c:when>
			<c:otherwise>
				<div class="resul-titulo con-decoration sin-padding">
					<em class="error"></em>
					<h3><%=nombreApellido%></h3>
					<%=mensajeConfirmacion%>
				</div>
			</c:otherwise>
		</c:choose>

		<div class="resul-soli">
			<h3>Tus datos</h3>
			<div class="campos-oblig-dos tus-datos">
				<label>Apellido Paterno</label>
				<p><%=apePater%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Apellido Materno</label>
				<p><%=apeMater%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Primer Nombre</label>
				<p><%=priNombre%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Segundo Nombre</label>
				<p><%=segNombre%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Tipo Documento</label>
				<p><c:choose>
						<c:when test="${tipoDocumento==2}">
				Carné Ext.
              </c:when>

						<c:otherwise>
                DNI
              </c:otherwise>
					</c:choose></p>
			</div>
			
			<div class="campos-oblig-dos tus-datos">
				<label> N&uacute;mero Documento
				</label>
				<p><%=ndocumento%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Fecha de Nacimiento</label>
				<p><%=fecNacimiento%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Departamento</label>
				<p><%=cbodepartamento%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Provincia</label>
				<p><%=cboprovincia%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Celular</label>
				<p><%=celular%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Teléfono de Casa</label>
				<p><%=telFijo%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Teléfono de Trabajo</label>
				<p><%=telTrabajo%></p>
			</div>
			<div class="campos-oblig-dos tus-datos">
				<label>Anexo</label>
				<p><%=anexo%></p>
			</div>
			<div class="campos-oblig-dos final">
				<label>Correo electrónico</label>
				<p><%=email%></p>
			</div>
		</div>
		<div class="resul-soli">
			<h3>Detalle del producto</h3>
			<div class="campos-oblig-dos final">
				<label>Producto</label>
					<p><%=tituloProducto%></p>
			</div>
		</div>
		<c:if test="${fn:length(sessionScope.listProductComplCheck) > 0}">
			<div class="resul-soli">
				<h3>Detalle del producto complementario</h3>
					<c:forEach items="${sessionScope.listProductComplCheck}" var="product">
						<c:if test="${product.principalidad == 'N'}">
							<div class="campos-oblig-dos tus-datos" style='height:auto !important'>
								<label>Tipo</label>
								<p>${product.producto}</p>
								<div class="both"></div>
							</div>	
						</c:if>
					</c:forEach>
			</div>
		</c:if>
		<div class="espaciado34 both"></div>
		<c:choose>
			<c:when test="${error != 0}">
				<div class="resul-impre con-decoration">
					<em></em> <a href="${requestScope.urlPrint[0] }"
						data-milkbox="milkbox:g1"
						data-milkbox-size="width:622,height:${requestScope.urlPrint[1]}"
						title="Versi&oacute;n para imprimir">Versi&oacute;n para
						imprimir</a> 
						<a class="sin-margin" href="${urlDireccionar}" title="Seguir viendo productos" style="cursor: pointer !important;">Seguir viendo productos
						<%
						String utm_source="";
						String utm_medium="";
						String utm_content="";
						String utm_campaign="";
						
						pSession.setAttribute("LIFERAY_SHARED_UTM_SOURCE", utm_source,PortletSession.APPLICATION_SCOPE);
						pSession.setAttribute("LIFERAY_SHARED_UTM_MEDIUM", utm_medium,PortletSession.APPLICATION_SCOPE);
						pSession.setAttribute("LIFERAY_SHARED_UTM_CONTENT", utm_content,PortletSession.APPLICATION_SCOPE);
						pSession.setAttribute("LIFERAY_SHARED_UTM_CAMPAIGN", utm_campaign,PortletSession.APPLICATION_SCOPE);
						%>
						</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="resul-impre con-decoration centrado">
					<a class="sin-margin" href="${urlDireccionar}" title="Seguir viendo productos" style="cursor: pointer !important;">Seguir viendo productos
						<%
						String utm_source="";
						String utm_medium="";
						String utm_content="";
						String utm_campaign="";
						
						pSession.setAttribute("LIFERAY_SHARED_UTM_SOURCE", utm_source,PortletSession.APPLICATION_SCOPE);
						pSession.setAttribute("LIFERAY_SHARED_UTM_MEDIUM", utm_medium,PortletSession.APPLICATION_SCOPE);
						pSession.setAttribute("LIFERAY_SHARED_UTM_CONTENT", utm_content,PortletSession.APPLICATION_SCOPE);
						pSession.setAttribute("LIFERAY_SHARED_UTM_CAMPAIGN", utm_campaign,PortletSession.APPLICATION_SCOPE);
						%>
					</a>
				</div>
			</c:otherwise>
		</c:choose>


		<div class="both"></div>
	</div>
</div>
<input type="hidden" id="obtenerFormato" name="obtenerFormato" value="${requestScope.formato}" />
<input type="hidden" id="numeroPaso1" name="numeroPaso1" value="${requestScope.numeroPaso1}" />
<input type="hidden" id="paso" name="paso" value="${requestScope.paso}" />

<input type="hidden" id="estadoPaso1Hipotecario" name="estadoPaso1Hipotecario" value="${requestScope.estadoPaso1Hipotecario}" />
<input type="hidden" id="estadoPaso2Hipotecario" name="estadoPaso2Hipotecario" value="${requestScope.estadoPaso2Hipotecario}" />
<%
/*
	pSession.removeAttribute("tipDoc");
	pSession.removeAttribute("ndocumento");
	pSession.removeAttribute("apePater");
	pSession.removeAttribute("apeMater");
	pSession.removeAttribute("priNombre");
	pSession.removeAttribute("segNombre");
	pSession.removeAttribute("fecNacimiento");
	pSession.removeAttribute("tipsexo");
	pSession.removeAttribute("ruc");
	pSession.removeAttribute("razonSocial");
	pSession.removeAttribute("valorRenta");
	pSession.removeAttribute("cboestadocivil");
	pSession.removeAttribute("cbosituacionlaboral");	
	
	pSession.removeAttribute("cbodepartamento");
	pSession.removeAttribute("celular");
	pSession.removeAttribute("telFijo");
	pSession.removeAttribute("telTrabajo");
	pSession.removeAttribute("anexo");
	pSession.removeAttribute("email");
	pSession.removeAttribute("confEmail");
	pSession.removeAttribute("nombreApellido");
	pSession.removeAttribute("checkCondiciones");
	pSession.removeAttribute("urlRedireccionar");
	pSession.removeAttribute("checkCodProducto");
	pSession.removeAttribute("mensajeConfirmacion");
	pSession.removeAttribute("error");
	
	pSession.removeAttribute("utm_source");
	pSession.removeAttribute("utm_medium");
	pSession.removeAttribute("utm_content");
	pSession.removeAttribute("utm_campaign");
	
	pSession.removeAttribute("listProductComplCheck");
	pSession.removeAttribute("listComplementarios");
	*/
%>
