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

<portlet:defineObjects />
<portlet:resourceURL var="descargarPDF" id="descargarPDF" />

<script type="text/javascript">
  function imprimir_pdf() {
      /* Llamada para al portlet para la generacion del archivo excel */
      var url="${descargarPDF}";
      var frm = document.form_print;
      frm.action=url;
      frm.submit();
  }
</script>

<form name="form_print" id="form_print" method="post" target="_blank">
<input type="hidden" id="pNombres" name="pNombres" value="${pNombres}">
<input type="hidden" id="pApellidos" name="pApellidos" value="${pApellidos}">
<input type="hidden" id="pEmail" name="pEmail" value="${pEmail}">
<input type="hidden" id="pTipodocumento" name="pTipodocumento" value="${pTipodocumento}">
<input type="hidden" id="pNdocumento" name="pNdocumento" value="${pNdocumento}">
<input type="hidden" id="pDireccion" name="pDireccion" value="${pDireccion}">
<input type="hidden" id="pTelefono" name="pTelefono" value="${pTelefono}">
<input type="hidden" id="pMensaje" name="pMensaje" value="${pMensaje}">
<input type="hidden" id="pImporte" name="pImporte" value="${pImporte}">
<input type="hidden" id="pTipoingreso" name="pTipoingreso" value="${pTipoingreso}">
<input type="hidden" id="pDepart" name="pDepart" value="${pDepart}">
<input type="hidden" id="pProv" name="pProv" value="${pProv}">
<input type="hidden" id="pDist" name="pDist" value="${pDist}">
<input type="hidden" id="pTipomoneda" name="pTipomoneda" value="${pTipomoneda}">
<input type="hidden" id="pTipotema" name="pTipotema" value="${pTipotema}">
<input type="hidden" id="pFechahora" name="pFechahora" value="${pFechahora}">

<input type="hidden" id="indicadorJS" name="indicadorJS" value="${indicadorJS}">

<div class="sol-formulario paso4">
	<!--  <div class="resul-titulo con-decoration">-->
	  <a href="<%=url%>"><em class="exito"></em></a>
	<!-- kenpak -->
	<div id="content-medio-template1">
		<div class="cntresRec">
			<div class="alinchek">
				<img border="0" src="/halcon-theme/images/halcon/checkConfirm.gif"
					width="27">
    </div>
			<p class="">
				Estimado ${requestScope.nombres}</span>
				hemos recibido sus datos correctamente, estaremos enviando la hoja
				de reclamación vía e-mail.
			</p>
			<p class="">Recuerde que también puede comunicarse con nosotros
				al 311-9000 o visitarnos a cualquier tienda a nivel nacional.</p>
			<p class="">
				Atentamente<br /> <span class="restle">Interbank<span>
			</p>
			<div class="resul-impre con-decoration impright">
				<em class="impre-centro"></em>
				<a href="javascript:void(0)" onclick="imprimir_pdf()">Imprimir formulario</a>
			</div>
		</div>
	</div>
	<!-- kenpak -->

  </div>
</form>