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

<portlet:defineObjects />

<input type="hidden" id="urlCabeceraVideo" value="<portlet:resourceURL id="traerCabeceras"/>"/>
<input type="hidden" id="urlDetalleVideo" value="<portlet:resourceURL id="traerDetalle"/>"/>
<input type="hidden" id="idCabeceraActiva" value="${requestScope.idCabeceraActiva }"/>
<input type="hidden" id="snipetVideo" value="${requestScope.snipetVideo }"/>


<div id="content-medio">
 	<div class="det-producto-pes sepa">
 		<!-- Cabecera -->
 		<div class="sec-pes">
          <ul id="cabeceraVideo">
          
          </ul>
        </div>
         <!-- Contendido -->
         <div class="sec-det">
          <div class="feature-dp"> 
          	<!-- <div class="text-video">
            	<em></em>
                <p>Lorem ipsum dolor sit amet</p>
                Proin vulputate eros a turpis ultricies nec euismod diam luctus. 
            </div>  -->
            
            <div id="videoHTMLHeader"></div>
            
            <div class="beneficios-CV"> 
             <ul id="detalleVideo">
			
			 </ul>
			 
             	<!--<p class="sin-padding mg-lft7 mg-tp23 margin-bottom7">Proin vulputate eros a turpis ultricies nec euismod diam luctus.</p>
                <div class="con-decoration mg-btm15 submg-left7"><a href="#">diam luctus.</a></div>   --> 
                
                <div id="videoHTMLFooter"></div>
                                        
             </div>
          </div>
         </div>
 	</div>
 	
</div>
