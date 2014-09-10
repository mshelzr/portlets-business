<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

    <div class="RSCV">
      <h2>�Felicitaciones! Tienes un ${requestScope.nombreProducto } pre-aprobado.</h2>
      <p>Si quieres solicitarlo <a class="solicitaLink" href="${requestScope.urlSolicitud }" title="haz clic aqu� ">haz clic aqu� </a> <br />
        Nota: El cr�dito que tienes pre-aprobado puede diferir al que has simulado.</p>
    </div>

    <input type="hidden" value="<portlet:resourceURL id="redireccionSolicitud"/>" name="redireccionSolicitud" id="redireccionSolicitud"/>
    <input type="hidden" value="${requestScope.tipoSimulador }" name="tipSimSol" id="tipSimSol"/>
    <input type="hidden" value="${requestScope.codigoCampania }" name="codCampaniaSol" id="codCampaniaSol"/>