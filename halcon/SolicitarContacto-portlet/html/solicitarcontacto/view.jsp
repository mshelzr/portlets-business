<%-->
/**
Julio Hurtado
26/11/2012
Portlet Solicita Contacto
*/
--%>
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
String url = themeDisplay.getURLPortal() + "/puntos-de-atencion" ;
%>

<portlet:defineObjects />

<input type="hidden" id="validarCaptcha" value="<portlet:resourceURL id="validarCaptcha" />" />
<input type="hidden" id="urlImagen"  value="<portlet:resourceURL id="traerImagen" />" />

<portlet:actionURL var="solicitarContacto" name="solicitarContacto"></portlet:actionURL>
<portlet:resourceURL var="traerImagen" id="traerImagen" />

<!-- formulario Solicita Contacto -->
<!--content-medio-->
<!--   target="upload_target" -->
  <form action="${solicitarContacto}" name="<portlet:namespace/>form1" id="<portlet:namespace/>form1"  method="post" >
  <input type="hidden" id="hiddenFormulario" name="hiddenFormulario" value="<portlet:namespace/>form1" />  
    <div id="content-medio" class="roundy wd623">
      <div class="inform">
        <p>Para mayor información, consulta o reclamo sobre cualquiera de nuestros productos y/o servicios,<br />
          ponemos a tu disposición los siguientes medios de contacto:</p>
        <ul>
          <li>Banca Telefónica: Llamando al 311 9000, donde serás atendido (a) cordialmente por una de<br />
            nuestras teleoperadoras.</li>
          <li>En cualquiera de <a href="<%=url%>" title="nuestras tiendas" class="celte">nuestras tiendas</a>.</li>
          <li>Vía <a href="http://www.dcf.com.pe/" target="_blank" title="Defensor del cliente financiero" class="celte">Defensor del cliente financiero</a>.</li>
          <li>Nuestro horario de atención para proceso de información vía Banca por Internet es de lunes a<br />
            viernes de 9 am. a 6pm.</li>
        </ul>
        <div class="linea"></div>
          <div class="no-cliente">
            <input type="checkbox" value="1" name="check" id="check" class="cheked" <c:if test="${requestScope.esCliente==1}"> checked </c:if> />
            Aún no soy cliente de Interbank </div>
          <div class="paraelform">
            <div class="campos-oblig">
              <label>Nombres</label>
                <c:set var="styleErrorNombre" value=""/>
    		   <c:if test="${fn:length(avisoNombre)>0}"><c:set var="styleErrorNombre" value="text-error"/></c:if>
              <input type="text" class="valid['alphabetic'] textform1 wt224 ${styleErrorNombre}" id="Nombres" name="Nombres" maxLength="50" value="${requestScope.nombres}"/>
            </div> 
        	<c:choose>
               <c:when test="${avisoNombre==null}">
      			<div class="form-error">Ingresa tu nombre.
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoNombre}   
              
            	</div>
               </c:otherwise> 
              </c:choose>  
            
            <div class="campos-oblig">
              <label>Apellidos</label>
                <c:set var="styleErrorApellido" value=""/>
    		   <c:if test="${fn:length(avisoApellido)>0}"><c:set var="styleErrorApellido" value="text-error"/></c:if>
              <input type="text" class="valid['alphabetic'] textform1 wt224 ${styleErrorApellido}" id="Apellidos" name="Apellidos" maxLength="50" value="${requestScope.apellidos}" />
            </div>  
    		<c:choose>
               <c:when test="${avisoApellido==null}">
      			<div class="form-error">Ingresa tus apellidos.   </div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoApellido}   </div>
               </c:otherwise> 
              </c:choose>  

            <div class="campos-oblig">
              <label>Correo electrónico</label>
                <c:set var="styleErrorCorreo" value=""/>
    		   <c:if test="${fn:length(avisoEmail)>0}"><c:set var="styleErrorCorreo" value="text-error"/></c:if>
              <input type="text" class="valid['email'] textform1 wt224 ${styleErrorCorreo}" id="email" name="email" maxLength="100" value="${requestScope.email}" />
            </div>       
               <c:choose>
               <c:when test="${avisoEmail==null}">
      			<div class="form-error">Ingresa un e-mail válido.
              
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoEmail}   
              
            	</div>
               </c:otherwise> 
              </c:choose>  
            
            <div class="campos-oblig">
              <label>Confirmación de correo</label>
                <c:set var="styleErrorConfCorreo" value=""/>
    		   <c:if test="${fn:length(avisoConfirmacionEmail)>0}"><c:set var="styleErrorConfCorreo" value="text-error"/></c:if>
              <input type="text" class="valid['=email'] textform1 wt224 ${styleErrorConfCorreo}" id="confmail" name="confmail" maxLength="100" value="${requestScope.confmail}" />
              <div class="coment_rec" style="background: url(/halcon-theme/images/halcon/coment_form_rec.gif) no-repeat center top;">La respuesta a su reclamación le será enviada al email que registre </div>
            </div>
              <c:choose>
               <c:when test="${avisoConfirmacionEmail==null}">
      			<div class="form-error">Los correos deben ser iguales.
              
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoConfirmacionEmail}   
              
            	</div>
               </c:otherwise> 
              </c:choose>
            
            <div class="campos-oblig sepa">
              <label>Tipo de Documento</label>
              <div class="valid['optText'] optiongroup2 float-left">
              
              <c:choose>
               <c:when test="${requestScope.tipoDocumento==2 }">
                 <input type="hidden" id="tipoDocumento" name="tipoDocumento" value="2" />
                <span  valor="1">DNI</span>
                <div class="separador-op"></div>
                <span class="active-op" valor="2">Carn&eacute; Ext.</span> 
                </c:when>
              
              <c:otherwise>
                <input type="hidden" id="tipoDocumento" name="tipoDocumento" value="1" />
                <span class="active-op" valor="1">DNI</span>
                <div class="separador-op"></div>
                <span valor="2">Carn&eacute; Ext.</span>
                </c:otherwise> 
              </c:choose>  

                </div>
                <c:set var="styleErrorTipDocumento" value=""/>
    		   <c:if test="${fn:length(avisoNumeroDocumento)>0}"><c:set var="styleErrorTipDocumento" value="text-error"/></c:if>
              <input type="text" class="textform1 wt115 margin-left9 float-left ${styleErrorTipDocumento}"  value="${requestScope.numDocumento}"  name="ndocumento" id="ndocumento" placeholder="N° de Documento"  />
            </div>
              <c:choose>
               <c:when test="${avisoNumeroDocumento==null}">
      			<div class="form-error">Ingresa un DNI de 8 dígitos.
              
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoNumeroDocumento}   
              
            	</div>
               </c:otherwise> 
              </c:choose>

            <div class="campos-oblig">
              <label>Dirección</label>
                <c:set var="styleErrorDireccion" value=""/>
    		   <c:if test="${fn:length(avisoDireccion)>0}"><c:set var="styleErrorDireccion" value="text-error"/></c:if>
              <input type="text" class="valid['alphaNumeric'] textform1 wt224 ${styleErrorDireccion}" id="direccion" name="direccion" maxLength="100" value="${requestScope.direccion}" />
            </div>         
               <c:choose>
               <c:when test="${avisoDireccion==null}">
      			<div class="form-error">Ingresa tu dirección.
              
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoDireccion}   
              
            	</div>
               </c:otherwise> 
              </c:choose>
             <!-- kenpak -->
              <div class="campos-oblig sepa">
				  <label>Teléfono</label>
				      <c:set var="styleTelefono" value=""/>
				      <c:if test="${fn:length(avisoNumeroDocumento)>0}">
				      <c:set var="styleTelefono" value="text-error"/>
				      </c:if>
				      <input type="text" class="valid['numeric'] textform1 wt224  ${styleTelefono}" id="telefono" name="telefono" maxLength="9" value="${requestScope.telefono}"/>
				</div>
				      <c:choose>
				        <c:when test="${avisoNumeroDocumento==null}">
				          <div class="form-error">Ingresa un teléfono</div>
				        </c:when>
				              <c:otherwise>
				                 <div class="form-error" style="display:block;">${avisoNumeroDocumento}</div>
				              </c:otherwise> 
				      </c:choose>
      		<!-- kenpak -->
    	   <c:set var="valorcito1" value="0"/>
            <c:choose> 
            	<c:when test="${requestScope.departamento==null}"><c:set var="valorcito1" value="0"/></c:when>
            	<c:otherwise><c:set var="valorcito1" value="${requestScope.departamento}"/></c:otherwise>
            </c:choose>        
            <div class="campos-oblig">
              <label>Departamento</label>
                <c:set var="styleErrorDepartamento" value="bgfa"/>
    		   <c:if test="${fn:length(avisoDepartamento)>0}"><c:set var="styleErrorDepartamento" value="text-error"/></c:if>
              <div id="cbodepartamento" class="valid['rdropdown'] dropdown2 wt190 float-left cbodepartamento ${styleErrorDepartamento}" >
              <input type="text" name="cboDepartamentoHidden" id="cboDepartamentoHidden" value="${valorcito1}"  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
              <div>Seleccione</div>
              </div>
            </div>
    		<c:choose>
               <c:when test="${avisoDepartamento==null}">
      			<div class="form-error">Selecciona un departamento.   
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoDepartamento}   
            	</div>
               </c:otherwise> 
              </c:choose> 
           <c:set var="valorcito2" value="0"/>
            <c:choose> 
            	<c:when test="${requestScope.provincia==null}"><c:set var="valorcito2" value="0"/></c:when>
            	<c:otherwise><c:set var="valorcito2" value="${requestScope.provincia}"/></c:otherwise>
            </c:choose>
            <div class="campos-oblig">
              <label>Provincia</label>
               <c:set var="styleErrorProvincia" value="bgfa"/>
    		   <c:if test="${fn:length(avisoProvincia)>0}"><c:set var="styleErrorProvincia" value="text-error"/></c:if>
              <div id="cboprovincia" class="valid['rdropdown'] dropdown2 wt190 float-left cboprovincia ${styleErrorProvincia}">
              <input type="text" name="cboProvinciaHidden" id="cboProvinciaHidden" value="${valorcito2}"  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
              <div>Seleccione</div>
              </div>
            </div>
    		<c:choose>
               <c:when test="${avisoProvincia==null}">
      			<div class="form-error">Selecciona una provincia.                
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoProvincia}   
            	</div>
               </c:otherwise> 
              </c:choose>


			<c:set var="valorcito3" value="0"/>
            <c:choose> 
            	<c:when test="${requestScope.distrito==null}"><c:set var="valorcito3" value="0"/></c:when>
            	<c:otherwise><c:set var="valorcito3" value="${requestScope.distrito}"/></c:otherwise>
            </c:choose>
            <div class="campos-oblig">
              <label>Distrito</label>
                <c:set var="styleErrorDistrito" value="bgfa"/>
    		   <c:if test="${fn:length(avisoDistrito)>0}">
                   <c:set var="styleErrorDistrito" value="text-error"/>
                   </c:if>
              <div id="cboDistrito" class="valid['rdropdown'] dropdown2 wt190 float-left cboDistrito ${styleErrorDistrito}">
              <input type="text" name="cboDistritoHidden" id="cboDistritoHidden" value="${valorcito3}"  class="textdropdown" style="opacity: 0; z-index: -1; position: absolute;">
              <div>Seleccione</div>
              </div>
            </div>
				<c:choose>
               <c:when test="${avisoDistrito==null}">
      			<div class="form-error">Selecciona una distrito.                
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoDistrito}   
            	</div>
               </c:otherwise> 
              </c:choose>  
            <div class="campos-oblig">
              <label>Fecha</label>
              <!--<input type="text" class="textform wd75 nobd" id="fecha" name="fecha" placeholder="03/10/2012"/>-->
              <input type="text" class="textform2 nobd wd75" readonly="readonly" id="fecha" name="fecha" value="${requestScope.fecha}"/>
            </div>
            <div class="both"></div>
          </div>
          <div class="linea"></div>
          <h2>Ingresa tu mensaje</h2>
          <div class="radmsg ">
            <input type="radio" name="msg" class="rdbtn" value="Consulta" id="msg" checked <c:if test="${requestScope.tipoMensaje=='Consulta'}"> checked </c:if> />
            <span class="esp10">Consulta</span>
            <input type="radio" name="msg" class="rdbtn" value="Pedido" id="msg" <c:if test="${requestScope.tipoMensaje=='Pedido'}"> checked </c:if> />
            <span class="esp10">Pedido</span>
            <input type="radio" name="msg" class="rdbtn" value="Reclamo" id="msg" <c:if test="${requestScope.tipoMensaje=='Reclamo'}"> checked </c:if> />
            <span class="esp16px po-rel">Reclamo</span>
            <input type="radio" name="msg" class="rdbtn" value="Sugerencia" id="msg" <c:if test="${requestScope.tipoMensaje=='Sugerencia'}"> checked </c:if> />
            <span class="esp10">Sugerencia</span>
            <input type="radio" name="msg" class="rdbtn" value="Queja" id="msg" <c:if test="${requestScope.tipoMensaje=='Queja'}"> checked </c:if> />
            <span class="esp10 po-rel">Queja</span>
            </div>

          <div class="paraelform mgtp12">
            <div id="infoontent1" class="campos-oblig hgauto w512p">
              
                           
              <div id="tema">
	              <label>Tema</label>
	              <div class="dropdown2 wt190 float-left bgfa cbotema" id="cbotema" ></div>
              </div>
              
              <div class="both"></div>            
              <div class="otroin w293p x" id="info">
                <p class="littletext">Si deseas consultar la información que tenemos en la Página Web sobre el tema seleccionado, por favor haz click en el link mostrado:<br/>
                                 
                  <a id="linkTarjetaCredito" href="http://www.interbank.com.pe/tarjeta-credito" class="celte2">http://www.interbank.com.pe/tarjeta-credito </a>
                  <a id="linkCuentasDeposito" href="http://www.interbank.com.pe/cuentas-para-transaccionar" class="celte2">http://www.interbank.com.pe/cuentas-para-transaccionar</a>
                  <a id="linkBancaElectronica" href="http://www.interbank.com.pe/banca-electronica" class="celte2">http://www.interbank.com.pe/banca-electronica</a>
                  <a id="linkCreditoPersonales" href="http://www.interbank.com.pe/para-mis-gastos-personales" class="celte2">http://www.interbank.com.pe/para-mis-gastos-personales</a>
                  <a id="linkSeguros" href="http://www.interbank.com.pe/salud-vida" class="celte2">http://www.interbank.com.pe/salud-vida</a>
                  <a id="linkFondosMutuos" href="http://www.interfondos.com.pe" class="celte2">http://www.interfondos.com.pe </a>
                  </p>
              </div>
              <!-- kenpak -->
              <div class="campos-oblig">
	            <div class="mnda">Moneda</div>
	              <label>Importe</label>
	                  <c:set var="styleImporte" value=""/>
				      <c:if test="${fn:length(avisoImporte)>0}">
				      <c:set var="styleImporte" value="text-error"/>
				      </c:if>
						<input type="text" class="valid['optionalNumeric'] textform wt115 mgr9 float-left ${styleImporte}"
							value="${requestScope.importe}" name="importe" id="importe" />
              
	              <div id="tipoMonedaDepositoContent" class="optiongroup float-left">
	                <input type="hidden" value="1" class="hiddenID" name="tipoMonedaDepositoHidden" id="tipoMonedaDepositoHidden">
	                <input type="hidden" value="S/." class="hiddenText" name="tipoMonedaDepositoHiddenText" id="tipoMonedaDepositoHiddenText">
	                <span valor="1" tool="Nuevos Soles" data-text="S/." class="active-op" style="text-align: center;">S/.</span>
	                <div class="separador-op"></div>
	                <span valor="2" tool="Dólares Americanos" data-text="US$">US$</span>
	                <div class="separador-op"></div>
	                <span valor="3"  tool="Euros" data-text="&#8364">&#8364</span></div>
	            </div>
 
	            <c:choose>
				        <c:when test="${avisoImporte==null}">
				          <div class="form-error">Ingresa un importe</div>
				        </c:when>
				              <c:otherwise>
				                 <div class="form-error" style="display:block;">${avisoImporte}</div>
				              </c:otherwise> 
				      </c:choose>
 			  <!-- kenpak -->	
            </div>
            <div class="textcontent campo-con-msg hgauto">
              <label>Mensaje</label>
                <c:set var="styleErrorMensaje" value=""/>
    		   <c:if test="${fn:length(avisoMensaje)>0}"><c:set var="styleErrorMensaje" value="text-error"/></c:if>
              <textarea name="mensaje" cols="" rows=""  class="valid['[1-1000]'] textform1 wd286  ${styleErrorMensaje}" id="mensaje" onKeyUp="imposeMaxLength(this, 1000);" onpaste="return false;" ondragstart="return false;" ondrop="return false;"  onDragOver="return false;">${requestScope.mensaje} </textarea>
<%--          <textarea name="mensaje" cols="" rows=""  class="valid['[1-10]'] textform1 wd286  ${styleErrorMensaje}" id="mensaje"  onKeyUp="cuenta(); imposeMaxLength(this, 9);">${requestScope.mensaje}</textarea> --%>
              <div class="both"></div>
              <div class="otroin" >
<!--                 <p class="littletext alignRight float-right" style="width:130px;"><span>tienes </span><span id="caracteres"> 0</span><span> caracteres</span></p> -->
                <p class="littletext float-left" style="width:160px;">Máximo permitido 1000 caracteres</p>
                <div class="both"></div>
              </div>
            </div>
            <br class="both" />
            
             <c:choose>
               <c:when test="${avisoMensaje==null}">
      			<div class="form-error">Por favor ingresa un mensaje.
            	</div>
               </c:when>
              <c:otherwise>
     		    <div class="form-error" style="display:block;">${avisoMensaje}   
            	</div>
               </c:otherwise> 
              </c:choose>
            
            <div class="both"></div>
          </div>
          <div class="linea"></div>
          <div class="notpie ">
            <p class="po-rel"><span class="resalte esp10px">Consulta</span>: Requerimiento de información o duda respecto a algún producto o servicio del banco.</p>
            <p class="po-rel"><span class="resalte esp10px">Reclamo</span>: Disconformidad relacionada a los productos o servicios.</p>
            <p class="po-rel"><span class="resalte esp10px">Pedido</span>: Servicio adicional o exigencia extra a la naturaleza del producto.</p>
            <p class="po-rel"><span class="resalte esp10px">Sugerencia</span>: Recomendación de mejora de nuestros clientes para que se tenga en consideración.</p>
            <p class="po-rel"><span class="resalte esp10px">Queja</span>: Disconformidad no relacionada a los productos o servicios, o malestar o descontento respecto a la atencion del público.</p>
            <br>
            <p class="po-rel"><span class="resalte esp10px">Menor de edad</span>: Ingresar los datos del apoderado o representante, y colocar en el mensaje los datos del menor de edad junto a la explicación de su reclamo o pedido.</p>
            <p class="mgtp25px">En caso de ser un reclamo o queja, el usuario al momento de enviar esta información, acepta los<br />
              siguientes términos:</p>
            <ul class="mgtp2px">
              <li>Manifiesta su conformidad con el contenido de la presente.</li>
              <li>Autoriza a Interbank a brindar la presente información al Instituto Nacional de Defensa<br />
                de la Competencia y de la Propiedad Intelectual (INDECOPI), en caso sea requerida por éste último.</li>
            </ul>
          </div>
          <div class="recaptcha soli-codigo anula-fl-mg"> <div class="bosrde" ><img src="${traerImagen}" width="106" height="28" id="imgCaptcha" title="Captcha"/></div>
            <div class="codigo-icons"> 
            
            <em class="volver" href="javascript:void(0)" onclick="actualizarImagen()"></em>
             <em class="tool">
              <div class="tool-open"> Escribe los caracteres de la imagen en el siguiente cuadro. </div>
              </em> </div>
                <c:set var="styleErrorCaptcha" value=""/>
    		   <c:if test="${avisocaptcha!=null}"><c:set var="styleErrorCaptcha" value="text-error"/></c:if>
            <input type="text" class="valid['required'] textform wt112 ${styleErrorCaptcha}" value="" name="txtCaptcha" id="txtCaptcha" maxLength="5" placeholder="Ingresa el C&oacute;digo" autocomplete="off" />
          </div>
          <br class="both" />
        	  <c:choose>
               <c:when test="${avisocaptcha==null}">
	           <div id="MSJ_CAPTCHA" name="MSJ_CAPTCHA" class="form-error mglf15" >Código de validación incorrecto, inténtalo nuevamente.   
         	   </div>
               </c:when>
               
              <c:otherwise>
     		   <div class="form-error mglf15"  style="display: block;" >${avisocaptcha}   
	            </div>
               </c:otherwise> 
              </c:choose>
        
          	<div class="bluebtn-cont8">
				<input class="btnform4" type="button" value="Enviar" id="enviar" name="enviar" title="Enviar">
			</div>
           <br class="both" />
      </div>
    </div>
  <input type="hidden" id="indicadorJS" name="indicadorJS" value="${indicadorJS}">
  <input type="hidden" id="ubigeo" name="ubigeo" value="">
<!--     <iframe id="upload_target" name="upload_target" src="" style="width:0;height:0;border:0px solid #fff;"></iframe> -->
   </form> 
   