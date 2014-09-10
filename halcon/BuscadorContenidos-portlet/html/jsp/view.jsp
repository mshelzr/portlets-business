<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<portlet:defineObjects />

<%
String keywords=(String)renderRequest.getAttribute("keywords");
int total=(Integer)renderRequest.getAttribute("total");
int paginaActual=(Integer)renderRequest.getAttribute("paginaActual");
int delta=(Integer)renderRequest.getAttribute("delta");
int numPaginas=(total%delta==0?total/delta:total/delta+1);
/*Las primeras n paginas de n en n*/
/**Ubicamos cual es el orden de n=10 que tiene**/
/**Ej. la pagina 12 tiene orden 2 pq esta en la segunda decena
Ej. la pagina 52 tiene orden 6 pq esta en la sexta  decena
**/
int n=10;//Se mostraran las paginas agrupadas en n
int maxOrder=(numPaginas%n==0?numPaginas/n:(numPaginas/n)+1);
int ordenSlider=(paginaActual%n==0?paginaActual/n:(paginaActual/n)+1);
int inicioOrden=((ordenSlider-1)*n)+1;
int finOrden=inicioOrden+n;
%>
    <!--sub-cabecera-->
    <div class="subcabecera-template">
      
      <div class="sub-titulo">
        <%if(paginaActual >1){ %>
        	<h1>Resultado de búsqueda - Página <%=paginaActual %></h1>
        <%}else{ %>
        	<h1>Resultado de búsqueda</h1>
        <%} %>
      </div>
      <!-- <p class="texto-sec">En Interbank sabemos que tu tiempo vale más que el dinero.</p> --> </div>
    <!--CONT-MEDIO-->
    <div id="content-medio">
    
      <div class="searching-I">
        <div class="mg12">
          <form action="javascript:enviar();" method="post">
            <input name="busqueda-txt" id="busqueda-txt" type="text" placeholder="Buscador" class="txtfrm textform" />
            <input type="button" name="busqueda-btn" class="btnform busqueda-btn" />
            <div class="both"></div>
          </form>
          <c:set var="textoResultados" value="resultados"/>
          <c:if test="${requestScope.total == 1}">
             <c:set var="textoResultados" value="resultado"/>
          </c:if>
          <p class="dialogo-resultados-busqueda both">Tiene ${requestScope.total} ${textoResultados} de <span class=" drb-dest">"${requestScope.keywords}"</span></p>
        </div>
        <div class="both"></div>
      </div>
      <div class="det-producto-pes sepa">
        <ol class="res-search" start="${requestScope.inicio}">
           <c:forEach items="${requestScope.resultado}" var="resultado">
	          <li>
	            <div class="resultados-busqueda"> <span class="rb-destacado">${resultado.titulo}</span>
	              <p>${resultado.resumen}</p>
	              <a href="${resultado.url}" >${resultado.url}</a> </div>
	          </li>
          </c:forEach>
        </ol>
        
        
      </div>
      
      <div class="paginator">
        <p>Total de <span class="res-dest"><%=numPaginas %> páginas</span></p>
        <!--<a href="#" class="btn-pag">&lt;</a>--> 
        <!-- <a href="#">2</a> <a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">6</a> <a href="#" class="active">7</a> <a href="#">8</a> <a href="#">9</a> <a href="#">10</a> <a href="#">11</a> <a href="#">12</a> <a href="#" class="btn-pag">&gt;</a> -->
	       <%if(ordenSlider>1){ 
	    	   String urlPagina="/buscador?keywords="+HtmlUtil.escapeURL(keywords)+"&page="+(paginaActual-1);
	       %>
	            <a href="<%=urlPagina %>" class="btn-pag">&lt;</a>
           <%} %>
           
           <%for(int i=inicioOrden;i<finOrden && i<=numPaginas;i++){ 
        	    String urlPagina="/buscador?keywords="+HtmlUtil.escapeURL(keywords)+"&page="+i;
                if(i==paginaActual){   
            %>
           		 <a href="<%=urlPagina %>" class="active"><%=i %></a>
              <%}else{%>
           		 <a href="<%=urlPagina %>"><%=i %></a>
              <%} 
             }
              %>
              
           <%if(ordenSlider<maxOrder){ 
           		String urlPagina="/buscador?keywords="+HtmlUtil.escapeURL(keywords)+"&page="+(paginaActual+1);
            %>
               <a href="<%=urlPagina %>" class="btn-pag">&gt;</a>
           <%}%>
        <div class="both"></div>
      </div>
      <div class="both"></div>
      <div class="no-respuesta">
        <h4>¿No encontraste lo que buscas?</h4>
        <span>Envíanos un <a href="contactanos" rel="nofollow">e-mail con tu consulta</a>, o si prefieres, escríbenos directo en&nbsp;</span> 
        <span>
        		<a href="http://www.facebook.com/InterbankPeru" title="Interbank en Facebook"><img class="margin-right5" src="/halcon-theme/images/halcon/ico-fb.jpg" width="18" alt="Interbank en Facebook" /></a>
        </span> 
        <span>
        		<a href="https://twitter.com/interbank" title="Interbank en Twitter"><img src="/halcon-theme/images/halcon/ico-tw.jpg" width="18" alt="Interbank en Twitter"/></a>
        </span>
        <div class="both"></div>
      </div>
      
      
    </div>
