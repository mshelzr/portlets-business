<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
ThemeDisplay themeDisplay=(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
String url = themeDisplay.getURLPortal();
%>

<style type="text/css">
.kjatxt tr td {
	padding: 3px;
}

.kjatxtadv {
	border: 1px solid #009B3A;
	padding: 5px;
	color: #000 !important;
}

div.resul-aclar-I {
	margin-left: 20px;
}
</style>



<input type="hidden" id="indicadorJS" name="indicadorJS" value="${indicadorJS}">
<input type="hidden" id="indicadorPrint" name="indicadorPrint" value="${indicadorPrint}">

<body class="resultado-sol" onload=" window.print();">
	<div class="content-milkbox">
		<div class="cabecera-lbox"></div>
		<div class="resul-aclar-I">
			<p>Estimado ${requestScope.nombres} hemos recibido sus datos
				correctamente, estaremos enviando a la brevedad la hoja de
				reclamación via email.</p>
			<p>Recuerde que también puede comunicarse con nosotros al
				311-9000 o visitarnos en cualquier Tienda a nivel nacional.</p>
			<p>
				Atentamente <br /> <span style="color: #0039A6;">Interbank</span>
			</p>

			<h3
				style="color: #009B3A; text-align: center; font-size: 16px; margin: 30px auto;">Formulario
				Libro de Reclamación Interbank</h3>
			<table border="0" width="100%" cellpadding="0" cellspacing="0"
				class="kjatxt">
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Nombres :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.nombres}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Apellido :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.apellidos}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Correo electr&oacute;nico :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.email}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Tipo y número de documento :</td>

					<td style="font-weight: bold; color: #000 !important;">${requestScope.ndocumento}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Dirección, Departamento, provincia y distrito :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.direccion},
						${requestScope.texdepart}, ${requestScope.texprov},
						${requestScope.texdist}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Teléfono :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.telefono}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Fecha y Hora :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.fecha}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Importe :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.importe}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Tipo de ingreso :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.tipoingreso}</td>
				</tr>
				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Tema :</td>
					<td style="font-weight: bold; color: #000 !important;">${requestScope.tipotema}</td>
				</tr>

				<tr>
					<td><img src="/halcon-theme/images/halcon/buellet_inc2.jpg"
						border="0" /></td>
					<td>Canal de ingreso :</td>
					<td style="font-weight: bold; color: #000 !important;">P&aacute;gina
						Web</td>
				</tr>
			</table>

			<h2
				style="font-weight: bold; font-size: 18px; text-align: center; margin: 30px auto 15px auto;">Mensaje</h2>
			<div class="kjatxtadv">
				<p>${requestScope.mensaje}</p>
				<p>&nbsp;</p>
			</div>
			<p style="float: right; margin-top: 15px; color: #000;">Banco
				Internacional del Perú, RUC 20100053455</p>
			<div class="both"></div>
		</div>
		<div class="both"></div>
		<br class="both" />
		
	</div>

</body>


