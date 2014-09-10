<%@page import="com.exp.portlet.halcon.utils.SimuladoresUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<portlet:defineObjects />
<script>
_gaq.push(['_trackEvent', 'Simulaciones', 'Simulacion finalizada', 'Pr&eacute;stamo Personal']);
</script>
    <div id="content-medio-template" >
      <div class="det-producto-pes ">
        <div class="sec-pes">
          <ul>
				<c:forEach items="${requestScope.simulaciones }" var="simulacion">
					<li><a href="#" title="${simulacion.key }" class="tab-dp" >${simulacion.key }</a></li>
				</c:forEach>
          </ul>
        </div>
        <div class="sec-det-II" style="height: 566px !important;">
        <c:forEach items="${requestScope.simulaciones }" var="simulacion">
          <div class="feature-dp"  style="height: auto !important;">
            <div class="content-dp"> 
              <!-- Inicio del Contenedor del CVT --> 
              <!-- Bloque uno // Crédito Personal Inteligente -->
              <c:forEach items="${simulacion.value }" var="simulacionBean">
	              <div class="cvt-content <c:if test='${requestScope.plazoSimulacion ==  simulacionBean.plazo}'>cvt-content-II</c:if>">
	                <h2>${simulacion.key }</h2>
	                <ul>
	                  <li class="borderTop"><span class="aumentado">${simulacionBean.plazo}</span> meses</li>
	                  <li><span class="aumentado aumentado-II">${requestScope.simboloMoneda } <fmt:formatNumber  value="${simulacionBean.montoCuotaOrdinaria}" pattern="#,###,##0.00" /> </span><br>
									&nbsp;Monto de cuota</li>
	                  <li><span class="aumentado-III"> <fmt:formatNumber  value="${simulacionBean.tasaCostoEfectivo}" pattern="#,###,##0.00" />%</span> <span class="aumentado-bloque">TCEA</span> </li>
	                </ul>
	                <div class="both"></div>
	                <div class="nc"> <a href="${simulacionBean.urlDetalle }" title="Más detalles del préstamo"  data-milkbox="milkbox:g2" data-milkbox-size="width:840,height:1400">Más detalles del préstamo</a> </div>
	                <!--div class="campana"> <a class="simulaLink" href="${requestScope.urlSolicitud}" title="Solicitar Cr&eacute;dito">Solic&iacute;talo aqu&iacute; </a> </div-->
	                
	                 <div class="blue-btn8">
			            <div class="bluebtn-izq">&nbsp;</div>
						<div class="bluebtn-medio boton"><a class="boton simulaLink" title="Solic&iacute;talo aqu&iacute;" href="${requestScope.urlSolicitud }" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Solicitalo aqui', 'Pr&eacute;stamo Personal']);">Solic&iacute;talo aqu&iacute;</a></div>
						<div class="bluebtn-der">&nbsp;</div>
			            <div class="both"></div>
			          </div>
			          
	              </div>
              </c:forEach>

              <br class="both" />
              <div class="cvt-finales">
                <p class="cvt-links"><a class="simulaLink" href="${requestScope.urlVolver}" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Volver a simular', 'Pr&eacute;stamo Personal']);" title="Volver a simular">Volver a simular</a> <a href="${requestScope.urlFicha}" onclick="_gaq.push(['_trackEvent', 'Simulaciones', 'Ver detalle del producto', 'Pr&eacute;stamo Personal']);" title="Ver detalle del producto">Ver detalle del producto</a> </p>
                <div class="listadob">
              		<ul>
					  <li>Los datos emitidos por este simulador son referenciales, están sujetos a evaluación y a la fecha real de desembolso del crédito.</li>
					  <li>No se incluyen los gastos pagados al contado directamente por el cliente.</li>
					  <li>El monto de las cuotas no incluye ITF.</li>
					  <li>El monto de la cuota incluye: la comisión por informe de pago y el seguro de desgravamen de Interbank.</li>
					  <li>El cliente tiene la opción de endosar su póliza de seguros a favor de Interbank</li>
					  <li>El cliente tiene la opción de elegir el envío del informe de pago mensual vía correo electrónico sin costo alguno.</li>
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

  <input type="hidden" name="simuladorCookiePersonal" id="simuladorCookiePersonal" value="${requestScope.simuladorCookie}"/>
  <input type="hidden" value="<portlet:resourceURL id="redireccionSimulador"/>" name="redireccionSimulador" id="redireccionSimulador"/>
  <input type="hidden" value="<%=SimuladoresUtil.SIMULADOR_PERSONAL %>" name="tipSim" id="tipSim"/>