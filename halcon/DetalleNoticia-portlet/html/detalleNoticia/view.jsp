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

<div id="content-medio" class="noticias-detalle">
      <p>${resumen}</p>
      <div class="fecha-not">${fechaCreacion}</div>
      ${html}
      
      <div class="next-sol con-decoration sin-margin"> <a href="/noticias" title="Ver todas las noticias">Ver todas las noticias</a> </div>
    </div>
