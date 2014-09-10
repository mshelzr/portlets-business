<%@page import="com.exp.portlet.halcon.utils.SimuladoresUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<portlet:defineObjects />
 <script>
 _gaq.push(['_trackEvent', 'Simulaciones', 'Simulacion finalizada', 'Cr&eacute;dito Hipotecario']);
</script>

  <div id="content-medio-template" >
    <div class="det-producto-pes "> 
      <div class="sec-pes">
        <ul>
          <li><a href="#" class="tab-dp" title="${nombreProducto}">${nombreProducto}</a></li>
        </ul>
      </div>
      
      <div class="sec-det-II fixheight442dp" style="height: 510px !important;">
      <c:forEach items="${requestScope.simulaciones }" var="simulacion">
        <div class="feature-dp" style="height: auto !important;">
          <div class="content-dp"> 
          
             <c:forEach items="${simulacion.value }" var="simulacionBean">
              <div class="cvt-content <c:if test='${requestScope.plazoSimulacion ==  simulacionBean.plazo}'>cvt-content-II</c:if>">
                <h2>${simulacion.key }</h2>
                <ul>
                  <li class="borderTop"><span class="aumentado">${simulacionBean.plazo}</span> meses</li>
                  <li><span class="aumentado aumentado-II">${requestScope.simboloMoneda }<fmt:formatNumber  value="${simulacionBean.montoCuotaOrdinaria}" pattern="#,###,##0.00"/></span><br>
									&nbsp;Monto de cuota</li>
                  <li><span class="aumentado-III"><fmt:formatNumber  value="${simulacionBean.tasaCostoEfectivo}" pattern="#,###,##0.00"/>%</span> <span class="aumentado-bloque">TCEA</span> </li>
                </ul>
                <div class="both"></div>
                <div class="nc"> <a href="${simulacionBean.urlDetalle }" title="Más detalles del Crédito"  data-milkbox="milkbox:g2" data-milkbox-size="width:840,height:1400">Más detalles del Crédito</a> </div>
                <!--div class="campana"> <a class="simulaLink" href="${requestScope.urlSolicitud }" title="Solic&iacute;talo aqu&iacute;">Solic&iacute;talo aqu&iacute;</a> </div-->
                
                	 <div class="blue-btn8">
			            <div class="bluebtn-izq">&nbsp;</div>
						<div class="bluebtn-medio boton"><a class="boton simulaLink" title="Solic&iacute;talo aqu&iacute;" href="${requestScope.urlSolicitud }" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Solicitalo aqui', 'Cr&eacute;dito Hipotecario']);">Solic&iacute;talo aqu&iacute;</a></div>
						<div class="bluebtn-der">&nbsp;</div>
			            <div class="both"></div>
			          </div>
              </div>
             </c:forEach>
             
            <br class="both" />
            <div class="cvt-finales">
              <p class="cvt-links"><a  class="simulaLink" href="${requestScope.urlVolver}" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Volver a simular', 'Cr&eacute;dito Hipotecario']);">Volver a simular</a> <a href="${requestScope.urlFicha }" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Ver detalle del producto', 'Cr&eacute;dito Hipotecario']);" title="Ver detalle del producto">Ver detalle del producto</a> </p>
              
 
              <div class="listadob">
              	<ul>
              		<li>Los datos emitidos por este simulador son referenciales, están sujetos a evaluación y a la fecha real de desembolso del crédito.</li>
					<li>No se incluyen los gastos pagados al contado directamente por el cliente.</li>
					<li>El monto de las cuotas no incluye ITF.</li>
					<li>El monto de la cuota incluye: el seguro de desgravamen de Interbank.</li>
					<li>El cliente tiene la opción de endosar su póliza de seguros a favor de Interbank.</li>
					<li>Para mayor información puede acercarse a nuestra red de Tiendas Interbank a nivel nacional.</li>
              	</ul>
              </div>
              
            </div>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
    <br class="both" />
  </div>
  
    
     <input type="hidden" name="simuladorCookieHipotecario" id="simuladorCookieHipotecario" value="${requestScope.simuladorCookie}"/>
    <input type="hidden" value="<portlet:resourceURL id="redireccionSimulador"/>" name="redireccionSimulador" id="redireccionSimulador"/>
    <input type="hidden" value="<%=SimuladoresUtil.SIMULADOR_HIPOTECARIO %>" name="tipSim" id="tipSim"/>