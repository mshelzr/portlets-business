<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.exp.portlet.halcon.utils.SimuladoresUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<portlet:defineObjects />
<script>
_gaq.push(['_trackEvent', 'Simulaciones', 'Simulacion finalizada', 'Fondos Mutuos']);
</script>
<%
String ruta = request.getScheme() + "://" + request.getServerName() + ":"
		+ request.getServerPort() + request.getContextPath();

 %> 
 <c:set var="ruta"  value="<%=ruta%>"></c:set>
 <!--sub-cabecera-->
 <style type="text/css">
	.formato-sf-III {
	    border: 1px solid #D2D2D2;
	    padding: 20px 15px 15px;
	    width: 590px;
		height:auto !important;
	}
	.formato-sf-III .RSFM-I .titulos {
	_border: 0 none !important;
	_padding:8px 0 8px 10px;
	_height:auto !important; 
	}
	.formato-sf-III .RSFM-I .titulos div {
		color: #555454;
	_padding-bottom:5px;
	}
	.formato-sf-III .RSFM-I ul li div {
		float: left;
		text-align: center;
		width: 112px;
		height: auto;
	}
	.formato-sf-III .RSFM-I ul li:first-child {
		border: 0 none !important;
	}
</style>

<input type="hidden" value='<portlet:resourceURL id="forzarDescargaPDF" />' id="forzarDescargaPDF" />

<input type="hidden" value='<portlet:resourceURL id="crearPDF" />' id="crearPDF" />
<input type="hidden" value='<portlet:resourceURL id="form_lightbox" />' id="form_lightbox" />
<input type="hidden" value='<portlet:resourceURL id="cambiar_periodo" />' id="cambiar_periodo" />


    
    <div id="content-medio-template" >
      <div class="formato-sf-III"> 
        <!-- Inicio Resultado de simulacion de fondos mutuos -->
        <div class="RSFM-I RSFM-separador" id="headerFondosMutuos">         
        	${requestScope.semaforo}
        	<c:forEach items="${requestScope.lista}" var="fondo2" varStatus="contador">
        		<c:choose>
					<c:when test="${contador.count == 1}">
						<span class='RSFM-icon'></span>	
					</c:when>
					<c:when test="${contador.count == 2}">
						<span class='RSFM-icon-I'></span>	
					</c:when>
					<c:when test="${contador.count > 2}">
						<span class='RSFM-icon-II'></span>
					</c:when>							
				</c:choose>
				<span class='RSFM-text'>
						${fondo2.dato1}
				</span>
        	</c:forEach>        	
          <div class="both"></div>
        </div>
        <!-- Opt Group -->
        <div class="RSFM-right">
          <div class="optiongroup" id="nav_per_inv" >
            <input type="hidden" id="tipoCredito" name="tipoCredito" value="Tradicional" />
<!--             <span class="active-op" valor="30 d&iacute;as">30 d&iacute;as</span> -->
<!--             <div class="separador-op"></div> -->
<!--             <span valor="90 d&iacute;as">90 d&iacute;as</span> -->
<!--             <div class="separador-op"></div> -->
<!--             <span valor="180 d&iacute;as">180 d&iacute;as</span> -->
<!--             <div class="separador-op"></div> -->
<!--             <span valor="1 a&ntilde;o">1 a&ntilde;o</span> -->
<!--             <div class="separador-op"></div> -->
<!--             <span valor="2 a&ntilde;o">2 a&ntilde;os</span> -->
<!--             <div class="separador-op"></div> -->
<!--             <span valor="3 a&ntilde;o">3 a&ntilde;os</span> -->
<!--             <div class="separador-op"></div> -->
<!--             <span valor="5 a&ntilde;o">5 a&ntilde;os</span> -->
            </div>
          <div class="both"></div>
        </div>
        <div class="both"></div>
        <!-- Grafica --> 
        <c:choose>
        	<c:when test="${requestScope.flag_grafico == 2}">
        		<img id="urlImagenChart" src="${ruta}/${requestScope.grafico}" />	
        	</c:when>
        	<c:otherwise>
        		<div id="chart_div" style="width: 588px; height: 306px;"></div>
        	</c:otherwise>
        </c:choose>         
        <br />
        <br />
     <div class="RSFM-I">
      <ul id="ListadoFondosMutuos">
        <li class="titulos">
          <div>Tipo de Inversi&oacute;n</div>
          <div>Partirías con</div>
          <div>Hoy tendrías*</div>
          <div>Nivel de Riesgo</div>
          <br class="both" />
        </li>       
        <c:forEach items="${requestScope.lista}" var="fondo" varStatus="cont">					
			<li>
				<div>
					<a href="${fondo.dato3}" title="${fondo.dato1}" target="_blank">${fondo.dato1}</a>
				</div>
				<div>
					${requestScope.simbolo} <fmt:formatNumber  value="${requestScope.cuota_inicial}" pattern="#,###,##0.00" />
				</div>
				<div>
				${requestScope.simbolo}
				<c:choose>
					<c:when test="${cont.count == 1}">
						<fmt:formatNumber  value="${requestScope.rentabilidad1}" pattern="#,###,##0.00" />	
					</c:when>
					<c:when test="${cont.count == 2}">
						<fmt:formatNumber  value="${requestScope.rentabilidad2}" pattern="#,###,##0.00" />	
					</c:when>
					<c:when test="${cont.count > 2}">
						<fmt:formatNumber  value="${requestScope.rentabilidad3}" pattern="#,###,##0.00" />
					</c:when>								
				</c:choose>
				</div>
				<div>
						${fondo.valorMonto1}
				</div>
				<div>
					<a href="/ResultadoSimulacion-portlet/template/fondosmutuos.jsp" class="campana" data-milkbox="milkbox:g1" data-milkbox-size="width:502,height:325" title="Solicitar" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Solicitar', 'Fondos Mutuos']);">Solicitar</a>
				</div>
				 <br class="both" />
			</li>
		</c:forEach>   
      </ul>
    </div>
        <p><span class="float-left">*C&aacute;lculo realizado en base a la rentabilidad del periodo anterior. </span>
        <c:if test="${requestScope.file_name_pdf != ''}">        
        	<a href="${requestScope.file_name_pdf}" id="download_pdf_fm" title="Descargar Simulaci&oacute;n" onclick="gaq.push(['_trackEvent', 'Simulaciones', 'Descargar Simulacion', 'Fondos Mutuos']);">Descargar Simulaci&oacute;n</a>
        </c:if>
        <a style="display:none" href="" id="simulador_redirect_blank" target="_blank">Ir</a>
        </p>        
        <div class="both"></div>
      </div>
      <br class="both" />
    </div>
    <!-- FIN Pestañas -->    
    <div id="_grafico" style="display:none">
    	${requestScope.grafico_json}
    </div>
    <c:if test="${requestScope.flag_grafico == 1}">
  			  <script type="text/javascript" src="https://www.google.com/jsapi"></script>
		 	<script type="text/javascript">
		      google.load("visualization", "1", {packages:["corechart"]});
		      google.setOnLoadCallback(function()
		      {
		    	  CrearGraficaFondosMutuos(document.getElementById("_grafico").innerHTML);
		      });
		    </script>
    </c:if>  

    
<input type="hidden" name="id_periodo_select" id="id_periodo_select" value="${requestScope._plazo_credito}" />
<input type="hidden" name="simuladorCookieFondos" id="simuladorCookieFondos" value="${requestScope.simuladorCookie}"/>
<input type="hidden" value="<portlet:resourceURL id="redireccionSimulador"/>" name="redireccionSimulador" id="redireccionSimulador"/>
<input type="hidden" value="<%=SimuladoresUtil.SIMULADOR_FONDOS_MUTUOS %>" name="tipSim" id="tipSim"/>

<input type="hidden" name="link_fondosmutuos" id="link_fondosmutuos" value='<%=PortletProps.get("link.tienda.interbank")%>' />
<input type="hidden" name="titulo_fondosmutuos" id="titulo_fondosmutuos" value='<%=PortletProps.get("titulo.link.tienda.interbank")%>' />
<input type="hidden" name="mensaje_fondosmutuos" id="mensaje_fondosmutuos" value='<%=PortletProps.get("mensaje.fondosmutuos.interbank")%>' />

<input type="hidden" name="tipoMoneda" id="tipoMoneda" value="${requestScope.tipoMoneda}" />



<a id="urlNuevaVentana" href="" target="_blank"  style="display: none;"></a>