<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

<%
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	PortletSession pSession = renderRequest.getPortletSession();

//	String tipDoc = (String) pSession.getAttribute("tipDoc");
	String ndocumento = (String) pSession.getAttribute("ndocumento");
	String apePater = (String) pSession.getAttribute("apePater");
	String apeMater = (String) pSession.getAttribute("apeMater");
	String tipsexo = (String) pSession.getAttribute("tipsexo");
	String priNombre = (String) pSession.getAttribute("priNombre");
	String segNombre = (String) pSession.getAttribute("segNombre");
	String razonSocial = (String) pSession.getAttribute("razonSocial");
	String fecNacimiento = (String) pSession.getAttribute("fecNacimiento");
	String checkCodProducto = (String) pSession.getAttribute("checkCodProducto");

	if (ndocumento == null) {
		ndocumento = "";
	}

	if (apePater == null) {
		apePater = "";
	}

	if (apeMater == null) {
		apeMater = "";
	}

	if (priNombre == null) {
		priNombre = "";
	}

	if (segNombre == null) {
		segNombre = "";
	}
	if (razonSocial == null) {
		razonSocial = "";
	}
	if(checkCodProducto == null){
		checkCodProducto = "";
	}
%>

<%-- <c:set var="tipoDocumento" value="<%=tipDoc%>" /> --%>
<c:set var="tipoSexo" value="<%=tipsexo%>" />
<c:set var="fechaNacimiento" value="<%=fecNacimiento%>" />
<c:set var="checkCodProducto" value="<%=checkCodProducto%>" />

<input type="hidden" value="${MSJ_DNI}" id="MSJ_DNI"> 
<input type="hidden" value="${MSJ_CARNET_EXTRANJERIA}" id="MSJ_CARNET_EXTRANJERIA">
<input type="hidden" id="tipDocInicial" name="tipDocInicial" value="1" />

<form action="/solicitud/cuenta-sueldo/2" method="post"
	name="<portlet:namespace/>fm1" id="<portlet:namespace/>fm1">
	<input type="hidden" id="hiddenF1" name="hiddenF1"
		value="<portlet:namespace/>fm1" />
	<div class="sol" id="content-medio">
		<div class="selec-soli">
			<p>�Qui�n eres?</p>
		</div>

		<!--sol-formulario-->
		<div class="sol-formulario">
			<div class="campos-oblig">
			
				<label>Tipo de Documento</label>
				
				<input type="hidden" id="tipDoc1" name="tipDoc1" value="${valorHiddenTipoDoc}" />
				
				<div class="valid['optText6'] optiongroup float-left" id="cboDocumento">
				   	<input type="hidden" id="tipDoc" name="tipDoc" value="${valorHiddenTipoDoc}" />
				</div>				

				<input type="text" class="textform1 wt115 margin-left9 float-left"
					value="<%=ndocumento%>" name="ndocumento" id="ndocumento" maxLength="${longitud}"
					placeholder="N� de Documento" />
			</div>
			
			<div class="form-error" id="msj_ndocumento">${MSJ_DNI}
			</div>

			<div class="campos-oblig">
				<label>Apellido Paterno</label> <input type="text"
					class="valid['alphaNumeric'] textform1 wt224 float-left"
					value="<%=apePater%>" id="apePater" name="apePater" maxLength="50" />
			</div>

			<div class="form-error" id="msj_apePater">${MSJ_APELLIDO_PATERNO}</div>

			<div class="campos-oblig">
				<label>Apellido Materno</label> <input type="text"
					class="valid['optionalalphaNumericGroup2'] textform1 wt224 float-left"
					value="<%=apeMater%>" id="apeMater" name="apeMater" maxLength="50" />
			</div>
			<div class="form-error" id="msj_apeMater">${MSJ_APELLIDO_MATERNO}</div>

			<div class="campos-oblig">
				<label>Primer Nombre</label> <input type="text"
					class="valid['alphaNumeric'] textform1 wt224 float-left"
					value="<%=priNombre%>" id="priNombre" name="priNombre"
					maxLength="50" />
			</div>
			<div class="form-error" id="msj_priNombre">${MSJ_PRIMER_NOMBRE}</div>


			<div class="campos-oblig">
				<label>Segundo Nombre (Opcional)</label> <input type="text"
					class="valid['optionalalphaNumeric'] textform1 wt224 float-left" value="<%=segNombre%>"
					id="segNombre" name="segNombre" maxLength="50" />
			</div>
			<div class="form-error" id="msj_segNombre">${MSJ_SEGUNDO_NOMBRE}</div>


			<div class="campos-oblig">
				<label>Fecha de Nacimiento</label>
				<div id="datepikerggl" class="valid['datepikerggl'] pikerggl"> 
			  	<input type="text"  id="day" value="" class="textform1 wt40r float-left pkggl" maxLength="2" placeholder="D&iacute;a"/>
				<div id="cbomonth" class="dropdown2 wt112m float-left bgfa pkggl">
  				<input type="text" name="month" id="month" value="" class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
  				<div>Seleccione</div>
			</div>
				<input type="text"  id="year" value="" class="textform1 wt40l float-left pkggl" maxLength="4" placeholder="A&ntilde;o"/>
				<input type="hidden"  id="fecNacimiento" name="fecNacimiento" value="${fechaNacimiento}" class="pikerggl" />
			</div>
				<input type="hidden" value="${MSJ_FECHA_NACIMIENTO1}" id="MSJ_FECHA_NACIMIENTO1"> 
				<input type="hidden" value="${MSJ_FECHA_NACIMIENTO2}" id="MSJ_FECHA_NACIMIENTO2">
			</div>
			<div class="form-error" id="msj_fecNacimiento"></div>

			<div class="campos-oblig">
				<label>Sexo</label>
				<div class="optiongroup float-left">
					<c:choose>
						<c:when test="${tipoSexo==2}">
							<input type="hidden" id="tipsexo" name="tipsexo" value="2" />
							<span valor="1">Masculino</span>
							<div class="separador-op"></div>
							<span class="active-op" valor="2">Femenino</span>
						</c:when>

						<c:otherwise>
							<input type="hidden" id="tipsexo" name="tipsexo" value="1" />
							<span class="active-op" valor="1">Masculino</span>
							<div class="separador-op"></div>
							<span valor="2">Femenino</span>
						</c:otherwise>
					</c:choose>

				</div>
			</div>
			<div class="form-error">Debes ingresar el Sexo</div>

			
			<div class="campos-oblig">
				<label>Raz�n Social del Empleador</label> <input type="text"
					name="razonSocial" id="razonSocial" value="<%=razonSocial%>"
					class="valid['alphabetic'] textform1 wt224 float-left"
					maxLength="100">
			</div>
			<div class="form-error" id="msj_razonSocial">${MSJ_RAZON_SOCIAL}</div>

			<div class="both"></div>
		</div>

		<!--sol-publi-->
		<div id="contentProductosComplementarios">
		<c:forEach var="d" items="${lstContenido}" >                
             <liferay-ui:journal-article articleId="${d.idContenidoWeb}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
         </c:forEach> 	
		</div>

		<div class="next-sol con-decoration">
			<a href="javascript:;" title="Siguiente" id="btn1Adelante" name="btn1Adelante">Siguiente</a>
			<div class="espaciado34"></div>
		</div>
	</div>
</form>

<input type="hidden" id="anhoActual" name="anhoActual" value="${requestScope.anhoActual}" />

<input type="hidden" id="obtenerURL" name="obtenerURL" value="${requestScope.obtenerURL}" />
<input type="hidden" id="paso" name="paso" value="${requestScope.paso}" />
<input type="hidden" id="checkCodProducto" name="checkCodProducto" value="${checkCodProducto}" />
<input type="hidden" id="obtenerFormato" name="obtenerFormato" value="${requestScope.formato}" />
<input type="hidden" id="urlPaso1_cs" value='<portlet:resourceURL id="paso1_cs"/>' />
<input type="hidden" id="nombre_producto_url" name="nombre_producto_url" value="${requestScope.nombre_producto_url}" />

<input type="hidden" id="numeroPaso1" name="numeroPaso1" value="${requestScope.numeroPaso1}" />
<input type="hidden" id="numeroPaso2" name="numeroPaso2" value="${requestScope.numeroPaso2}" />

<input type="hidden" id="estadoPaso1Sueldo" name="estadoPaso1Sueldo" value="${requestScope.estadoPaso1Sueldo}" />
<input type="hidden" id="estadoPaso2Sueldo" name="estadoPaso2Sueldo" value="${requestScope.estadoPaso2Sueldo}" />