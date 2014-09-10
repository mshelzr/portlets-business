<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<%
	int total=(Integer)renderRequest.getAttribute("total");
	int paginaActual=(Integer)renderRequest.getAttribute("paginaActual");
	int delta=(Integer)renderRequest.getAttribute("delta");
	int numPaginas=(total%delta==0?total/delta:total/delta+1);
	int n=5;//Se mostraran las paginas agrupadas en n
	int maxOrder=(numPaginas%n==0?numPaginas/n:(numPaginas/n)+1);
	int ordenSlider=(paginaActual%n==0?paginaActual/n:(paginaActual/n)+1);
	int inicioOrden=((ordenSlider-1)*n)+1;
	int finOrden=inicioOrden+n;
%>

<input type="hidden" id="obtenerListadoPaginacionHidden" value='<portlet:resourceURL id="obtenerListadoPaginacion" />'  >

<div id="content-medio" class="noticias-detalle">
	<c:forEach var="n" items="${listaNoticias}" varStatus="status">
		<c:choose>
		  <c:when test="${((status.index) eq 0) and (n.urlImagen ne '')}">
		  		<div class="small-not sin-padding margintop4"> <img src="${n.urlImagen}" width="160" height="146" alt="${n.title}"/>
		        <div class="info-not">
		          <h3>${n.title}</h3>
		          <span>${n.fechaCreacion}</span>
	          		<p>${n.resumen} <a href="${n.urlDetalle}" title="Ver detalle"> Ver detalle</a> </p>
			        </div>
			      </div>
		  </c:when>
		   <c:when test="${((status.index) eq 0) and (n.urlImagen eq '')}">
		   		<div class="small-not sin-padding margintop4">
			        <div class="info-not">
			          <h3>${n.title}</h3>
			          <span>${n.fechaCreacion}</span>
		          			<p style="width: 150%">${n.resumen} <a href="${n.urlDetalle}" title="Ver detalle"> Ver detalle</a> </p>
	        		</div>
	      		</div>
		   </c:when>
		   <c:when test="${((status.index) > 0) and (n.urlImagen ne '')}">
		   		<div class="small-not"> <img src="${n.urlImagen}" width="160" height="146" alt="${n.title}"/>
			        <div class="info-not">
			          <h3>${n.title}</h3>
			          <span>${n.fechaCreacion}</span>
		          			<p>${n.resumen} <a href="${n.urlDetalle}" title="Ver detalle"> Ver detalle</a> </p>
	        		</div>
	      		</div>
		   </c:when>
	  	<c:otherwise>
	  		 <div class="small-not"> 
		         <div class="info-not">
		          <h3>${n.title}</h3>
		          <span>${n.fechaCreacion}</span>
		          <p style="width: 150%">${n.resumen} <a href="${n.urlDetalle}" title="Ver detalle"> Ver detalle</a> </p>
		        </div>
		      </div>
	  	</c:otherwise>
	  </c:choose>
	</c:forEach>

     <div class="resul-total float-left sin-border width605">
        <div class="total-num margintop5"> 
        	
        	 <%if(total>0){ 
 		       %> 
		          <a href="javascript:void(0);" class="sin-padding bef" title="Previous" >&lt; Anterior</a>
	           <%} %>
        		
        		<%for(int i=inicioOrden;i<finOrden && i<=numPaginas;i++){ 
	                if(i==paginaActual){   
	            %>
	           		 <a href="javascript:void(0);" class="resul-lista-activo" title="<%=i %>" ><%=i %></a>
	              <%}else{%>
	           		 <a href="javascript:void(0);" class="resul-lista" title="<%=i %>"><%=i %></a>
	              <%} 
	             }%>
	             
	           <%if(total>0){ 
	            %> 
	               <a href="javascript:void(0);" class="sin-padding aft" title="Next">Siguiente &gt;</a>
	           <%}%> 
	           <% 
	           int bloqueNext=1;
	           if(numPaginas > 1){
	        	   bloqueNext = paginaActual + 1; 
	           }
	           %>
			<input type="hidden" id="previous" value="1">			
			<input type="hidden" id="next" value="<%=bloqueNext%>" >
			<input type="hidden" id="actual" value="<%=paginaActual%>" >
        </div>
      </div>
    </div>
