<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://interbank.com.pe/tld" prefix="ht" %>
<portlet:defineObjects />

<div class="subcabecera-template" style="background:#FFFFFF;">
      <div class="sub-titulo">
        <h3>Mapa del sitio </h3>
      </div>
</div>
<c:set value="1" var="flag" />
<div class="sitemapgeneral" style="background:#FFFFFF;">
      <ul>
        <c:forEach items="${requestScope.paginas }" var="nivel1" varStatus="loop">
		   
		   <c:if test="${nivel1.friendlyURL eq '/header' || nivel1.friendlyURL eq '/footer' }">
		   		<c:set value="0" var="flag" />
		   </c:if>
		   

		          <c:set var="stylo1" value=""/>
		          <c:if test="${loop.last || nivel1.friendlyURL eq '/footer'}"><c:set var="stylo1" value="nobd"/></c:if>
		            
		        	<li>
		        	    <c:set value="${fn:replace(nivel1.name ,';','')}" var="tituloN1"/>
		        		<h2 class="${stylo1} no-pd"><a href="#" class="ico-mapsite float-left"></a> ${tituloN1}</h2>
		        		<div>
		        		   <ul>
		        			<c:forEach items="${nivel1.children}" var="nivel2">
		        			      <c:if test="${ !nivel2.privateLayout && !nivel2.hidden}">
		   								
		        			      			<li>
		        			      			 
		        			      			 <c:choose>
		        			      			 	<c:when test="${flag==1 }">
		        			      			 		<h3 class="no-pd34"><a href="#" class="ico-mapsite float-left"></a> ${fn:replace(nivel2.name,';','') }  </h3>
		        			      			 	</c:when>
		        			      			 	<c:otherwise>
		        			      			 		<h3 class="no-pd34"><a href="#" class="ico-mapsite float-left"></a> <a class="txtmap" href="${nivel2.friendlyURL}">${fn:replace(nivel2.name,';','') }  </a> </h3>
		        			      			 	</c:otherwise>
		        			      			 </c:choose>

		        			      			 <div>
		        			      			 	<ul class="cont">
		        			      			 	   <c:forEach items="${nivel2.children}" var="nivel3">
		        			      			 	     <c:if test="${ !nivel3.privateLayout && !nivel3.hidden}">
		   													
		        			      			 	      <li>
		        			      			 	         <h4 class="no-pd66"><a href="#" class="ico-mapsite float-left"></a> <a href='<ht:urlVerdadera paginaActual="${nivel3}"/>' class="txtmap">${fn:replace(nivel3.name ,';','')} </a></h4>
		        			      			 	         <div>
		        			      			 	            <ul class="desplegado">
		        			      			 	               <c:forEach items="${nivel3.children}" var="nivel4">
		        			      			 	    			  <c:if test="${ !nivel4.privateLayout && !nivel4.hidden}">
		        			      			 	    			  	   
		        			      			 	    			  	   <li><a href='<ht:urlVerdadera paginaActual="${nivel4}"/>' title="">${fn:replace(nivel4.name,';','') }</a></li>
		        			      			 	    			  </c:if>
		        			      			 	    			</c:forEach>
		        			      			 	            </ul>
		        			      			 	         </div>
		        			      			 	      </li>
		        			      			 	     </c:if>
		        			      			 	   </c:forEach>
		        			      			 	</ul>
		        			      			 </div>
		        			      			</li>
		        			      </c:if>
		        			</c:forEach>
		        		   </ul>
		        		</div>
		        	</li>
           
        </c:forEach>
  	  </ul>
</div>