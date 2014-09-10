<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.net.URLEncoder"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>


<portlet:defineObjects />

<%
HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
ThemeDisplay themeDisplay=(ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

PortletSession pSession=renderRequest.getPortletSession();

String  celular=(String)pSession.getAttribute("celular");
String  telFijo=(String)pSession.getAttribute("telFijo");
String  telTrabajo=(String)pSession.getAttribute("telTrabajo");
String  anexo=(String)pSession.getAttribute("anexo");
String  email=(String)pSession.getAttribute("email");
String  confEmail=(String)pSession.getAttribute("confEmail");
String  cbodepartamento=(String)pSession.getAttribute("cbodepartamento");
String  cboprovincia=(String)pSession.getAttribute("cboprovincia");
String  cbodistrito=(String)pSession.getAttribute("cbodistrito");
String  direccion=(String)pSession.getAttribute("direccion");
String  horario=(String)pSession.getAttribute("horario");
String  placa=(String)pSession.getAttribute("placa");

String checkCodProducto = (String) pSession.getAttribute("checkCodProducto");

if(celular==null){
	celular="";
}

if(telFijo==null){
	telFijo="";
}

if(telTrabajo==null){
	telTrabajo="";
}

if(anexo==null){
	anexo="";
}

if(email==null){
	email="";
}

if(confEmail==null){
	confEmail="";
}

if(direccion==null){
	direccion="";
}

if(placa==null){
	placa="";
}

if(checkCodProducto == null){
		checkCodProducto = "";
}
%>
<c:set  var="departamento" value="<%=cbodepartamento%>"/>
<c:set  var="provincia" value="<%=cboprovincia%>"/>
<c:set  var="distrito" value="<%=cbodistrito%>"/> 
<c:set  var="horario" value="<%=horario%>"/>
<c:set var="checkCodProducto" value="<%=checkCodProducto%>" />

<input id="validarCaptchaSolicitudes" type="hidden" value="<portlet:resourceURL id="validarCaptchaSolicitudes" />" />
<input id="urlImagen" type="hidden" value="<portlet:resourceURL id="traerImagen" />" />
<portlet:resourceURL var="traerImagen" id="traerImagen" />

<form action="/solicitud/seguro-soat/3" method="post" name="<portlet:namespace/>fm2" id="<portlet:namespace/>fm2">
  <input type="hidden" id="hiddenF2" name="hiddenF2" value="<portlet:namespace/>fm2" />
    <!--content-medio-->
    <div id="content-medio" class="sol2">
      <div class="selec-soli">
        <p>¿Qui&eacute;n eres?</p> 
        <p>¿C&oacute;mo te ubicamos?</p>
      </div>
      
      <!--sol-formulario-->
      <div class="sol-formulario paso2">
      
        <div class="campos-oblig sin-margin">
          <label>Celular</label>
          <input type="text" class="valid['mobil'] textform1 wt224 float-left" id="celular" name="celular" maxLength="10" value="<%=celular%>"/>
        </div>
			<div class="form-error" id="msj_celular">${MSJ_CELULAR}</div>
			
        <div class="campos-oblig">
          <label>Tel&eacute;fono de Casa (Opcional)</label>
          <input type="text" class="valid['optionalPhone'] textform1 wt224 float-left" id="telFijo" name="telFijo" maxLength="10" value="<%=telFijo%>"/>
        </div>
			<div class="form-error" id="msj_telFijo">${MSJ_TELEFONO_DOMICILIO}</div>
			
			
        <div class="campos-oblig">
          <label>Tel&eacute;fono de Trabajo (Opcional)</label>
          <input type="text" class="valid['optionalPhone'] textform1 wt224 float-left" id="telTrabajo" name="telTrabajo" maxLength="10" value="<%=telTrabajo%>"/>
        </div>
			<div class="form-error" id="msj_telTrabajo">${MSJ_TELEFONO_TRABAJO}</div>

        <div class="campos-oblig">
          <label>Anexo (Opcional)</label>
          <input type="text" class="valid['optionalNumeric'] textform1 wt224 float-left" id="anexo" name="anexo" maxLength="10" value="<%=anexo%>"/>
        </div>
			<div class="form-error" id="msj_anexo">${MSJ_ANEXO}</div>
		
        <div class="campos-oblig">
          <label>Correo Electr&oacute;nico</label>
          <input type="text" class="valid['email'] textform1 wt224 float-left" id="email" name="email" maxLength="100" value="<%=email%>"/>
        </div>
			<div class="form-error" id="msj_email">${MSJ_CORREO_ELECTRONICO}</div>
			
        <div class="campos-oblig">
          <label>Confirmar Correo Electr&oacute;nico</label>
          <input type="text" class="valid['=email'] textform1 wt224 float-left" id="confEmail" name="confEmail" maxLength="100" value="<%=confEmail%>" onpaste="return false;" ondragstart="return false;" ondrop="return false;"  onDragOver="return false;"/>
        </div>
			<div class="form-error" id="msj_confEmail">${MSJ_CONFIRMACION_CORREO_ELECTRONICO}</div>
			
      
      <c:set var="valorDepartamento" value="0"/>
          <c:choose> 
          	<c:when test="${departamento==null}"><c:set var="valorDepartamento" value="0"/></c:when>
          	<c:otherwise><c:set var="valorDepartamento" value="${departamento}"/></c:otherwise>
      </c:choose>    
      
        <div class="campos-oblig">
          <label>Departamento</label>
          <div class="valid['rdropdown'] dropdown wt190 float-left bgfa cbodepartamento" id="cbodepartamento">
	          <input type="text" name="cbodepartamentoHidden" id="cbodepartamentoHidden" value="${valorDepartamento}"  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;border-color:#FFF">
            <div>Seleccione</div>
          </div>
        </div>
       <div class="form-error" id="msj_cbodepartamento">${MSJ_DEPARTAMENTO}</div>
       
       
       
      <c:set var="valorProvincia" value="0"/>
          <c:choose> 
          	<c:when test="${provincia==null}"><c:set var="valorProvincia" value="0"/></c:when>
          	<c:otherwise><c:set var="valorProvincia" value="${provincia}"/></c:otherwise>
      </c:choose>
       <div class="campos-oblig">
          <label>Provincia</label>
          <div id="cboprovincia" class="valid['rdropdown'] dropdown wt190 float-left cboprovincia bgfa">
              <input type="text" name="cboprovinciaHidden" id="cboprovinciaHidden" value="${valorProvincia}"  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;border-color:#FFF">
              <div>Seleccione</div>
              </div>
        </div>
        <div class="form-error" id="msj_cboprovincia">${MSJ_PROVINCIA}</div>
        
        
        <c:set var="valorDistrito" value="0"/>
          <c:choose> 
          	<c:when test="${distrito==null}"><c:set var="valorDistrito" value="0"/></c:when>
          	<c:otherwise><c:set var="valorDistrito" value="${distrito}"/></c:otherwise>
      </c:choose>
       <div class="campos-oblig">
          <label>Distrito</label>
          <div id="cbodistrito" class="valid['rdropdown'] dropdown wt190 float-left cbodistrito bgfa">
              <input type="text" name="cbodistritoHidden" id="cbodistritoHidden" value="${valorDistrito}"  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;border-color:#FFF">
              <div>Seleccione</div>
              </div>
        </div>
        <div class="form-error" id="msj_cbodistrito">${MSJ_DISTRITO}</div>
        
        
        <div class="campos-oblig">
          <label>Direcci&oacute;n de Env&iacute;o</label>
          <input type="text" class="valid['alphaNumeric'] textform1 wt224 float-left" id="direccion" name="direccion" value="<%=direccion%>" maxLength="100"/>
        </div>
        <div class="form-error" id="msj_direccion">${MSJ_DIRECCION}</div>	  
		  
        
        <div class="campos-oblig">
          <label>Horario de Env&iacute;o</label>
          <div class="optiongroup">
          
             <c:choose>
              <c:when test="${horario==3}">
                 <input type="hidden" id="horaEnvio" name="horaEnvio" value="3" />
                <span  valor="1">9-1 p.m.</span>
                	<div class="separador-op"></div>
                <span  valor="2">1-6 p.m.</span>
                	<div class="separador-op"></div>
                <span class="active-op" valor="3">6-9 p.m.</span> 
              </c:when>
              
              <c:otherwise>
	              <c:choose>
	              <c:when test="${horario==2}">
	                 <input type="hidden" id="horaEnvio" name="horaEnvio" value="2" />
	                <span  valor="1">9-1 p.m.</span>
	                	<div class="separador-op"></div>
	                <span class="active-op" valor="2">1-6 p.m.</span>
	                	<div class="separador-op"></div>
	                <span valor="3">6-9 p.m.</span> 
	              </c:when>

                   <c:otherwise>
	                <input type="hidden" id="horaEnvio" name="horaEnvio" value="1" />
	                <span class="active-op" valor="1">9-1 p.m.</span>
	                <div class="separador-op"></div>
	                <span valor="2">1-6 p.m.</span>
	               	<div class="separador-op"></div>
	                <span valor="3">6-9 p.m.</span>
                  </c:otherwise> 
                 </c:choose>
              </c:otherwise> 
            </c:choose>

            </div>
        </div>
        
        
        <div class="campos-oblig">
          <label>Placa</label>
          <input type="text" class="valid['placa'] textform1 wt224 float-left" id="placa" name="placa" value="<%=placa%>" maxLength="8" />
        </div>
        	<div class="form-error" id="msj_placa">${MSJ_PLACA}</div>
        
					
        <div class="both"></div>
      </div>

		<!--sol-publi-->
		<div id="contentProductosComplementarios">
		<c:forEach var="d" items="${lstContenido}" >                
             <liferay-ui:journal-article articleId="${d.idContenidoWeb}" groupId="<%= themeDisplay.getScopeGroupId() %>" />
         </c:forEach> 	
		</div>

       <div class="recaptcha soli-codigo anula-fl-mg"> 
         <div class="bosrde" ><img src="${traerImagen}" width="106" height="28" id="imgCaptcha" title="Captcha"/></div>
            <div class="codigo-icons"> 
              <em class="volver" href="javascript:void(0)" onclick="actualizarImagen()"></em> 
               <em class="tool"><div class="tool-open"> Escribe los caracteres de la imagen en el siguiente cuadro. </div></em> 
            </div>
            <input type="text" class="valid['required'] textform1 wt112 float-left" value="" name="txtCaptcha" id="txtCaptcha" maxLength="5" placeholder="Ingresa el C&oacute;digo" autocomplete="off"/>
         </div>
         <br class="both" />
		 <div class="form-error mglf15" id="msj_txtCaptcha">${MSJ_CAPTCHA}</div>
          
      <div class="soli-botones padt15">
        <div class="next-sol regresar con-decoration sin-margin"> &lt; <a href="javascript:;" title="Regresar" name="btn2Atras" id="btn2Atras">Regresar</a> </div>
        <div class="bluebtn-cont width-sol sin-margin">
          <input name="btn2Adelante" id="btn2Adelante" type="button" value="Enviar Solicitud"  class="boton-form3" title="Enviar Solicitud"/>
        </div>
      </div>
      
    </div>	
</form>

<input type="hidden" id="obtenerURL" name="obtenerURL" value="${requestScope.obtenerURL}" />
<input type="hidden" id="paso" name="paso" value="${requestScope.paso}" />
<input type="hidden" id="checkCodProducto" name="checkCodProducto" value="${checkCodProducto}" />
<input type="hidden" id="obtenerFormato" name="obtenerFormato" value="${requestScope.formato}"/>
<input type="hidden" id="urlPaso2_ss" value='<portlet:resourceURL id="paso2_ss"/>'/>
<input type="hidden" id="nombre_producto_url" name="nombre_producto_url" value="${requestScope.nombre_producto_url}" />

<input type="hidden" id="numeroPaso1" name="numeroPaso1" value="${requestScope.numeroPaso1}" />
<input type="hidden" id="numeroPaso3" name="numeroPaso3" value="${requestScope.numeroPaso3}" />

<input type="hidden" id="estadoPaso1Soat" name="estadoPaso1Soat" value="${requestScope.estadoPaso1Soat}" />
<input type="hidden" id="estadoPaso2soat" name="estadoPaso2soat" value="${requestScope.estadoPaso2soat}" />  