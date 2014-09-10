<input type="hidden" id="URLValidarCaptchaPersonal" value="<portlet:resourceURL id="validarCaptchaPersonal"/>"/>
<input type="hidden" id="URLTraerCaptchaPersonal" value='<portlet:resourceURL id="traerCaptcha"/>'/>
<input type="hidden" value="${urlImagen}" id="urlImagenSliderPersonal"/>
<div class="feature-hp alt_med">
  <div class="sec-feature" id="tabPersonal" >
    <h2>Simula tu Pr&eacute;stamo Personal</h2>
    <div class="content-pasos">
      <div class="no-click"><img src="${urlImagen}/space.gif" width="200" height="20" title="Pasos" /></div>
      <span class="float-left">Pasos&nbsp;&nbsp; </span> <a href="#" class="tab-personal">1</a> <a href="#" class="tab-personal">2</a> </div>
    <div class="pas-cont">
      <form enctype="multipart/form-data" name="formCrePersonal" action="" id="formCrePersonal">
        <div class="pas-feature pas-personal">
          <div class="trtitulo-pr"></div>
          <div class="trform-pr">
            <div class="dropdown2 wd147 float-left hgt26" id="docCrePersonal">
              <div>Tipo de Documento</div>
              <input type="text" name="docCrePersonalHidden" id="docCrePersonalHidden" value="0"/>
            </div>
            <div class="sepw8 float-left"></div>
            <input type="text" class="textform wt105 float-left" value=""  name="documentSimPersonal" id="documentSimPersonal" maxLength="8" placeholder="N&ordm; de Documento" />
            <div class="sepw8 float-left"></div>
            <br class="both" />
          </div>
          <div class="trtxtad-pr">Ingresa tu N&ordm; de Documento para una mejor oferta</div>
          <div class="trespacio-pr"></div>
          <div class="trtitulo-pr"> Tipo de Pr&eacute;stamo </div>
          <div class="trform-pr">
            <div class="optiongroup" style="height:28px;" id="tipoCreditoContent">
              <input type="hidden" id="tipoCreditoHidden" name="tipoCreditoHidden" value="1" />
            </div>
          </div>
          <div class="trtitulo-pr" style="height:5px;"></div>
          <div class="trtitulo-pr">
            <div style="width:50px;">Moneda</div>
          </div>
          <div class="trform-pr">
            <div class="optiongroup float-left" id="contentSimPertMoneda">
              <input type="hidden" id="hiddenSimPertMoneda" name="hiddenSimPertMoneda" value="1" />
            </div>
          </div>
          <div class="trform-pr"> 
            <!-- slider selector simulador Credito Hipotecario -->
            <div class="sepw8 float-left"></div>
            <div class="content-slider "><span>Monto de Cr&eacute;dito:</span><span class="negra">&nbsp;S/.</span><span class="negra valor-sl"></span><span class="negra valor-sl">.00</span>
              <input type="hidden" id="montoCredito" value="" name="montoCredito" class="input-sl" />
              <div id="montoCreditoPersonal" class="selector sl160">
                <div class="sl-left"></div>
                <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Destacados Interbank"/>
                <div class="knob"></div>
                <div class="sl-right"></div>
              </div>
            </div>
            <br class="both" />
            <!-- fin selector simulador Credito Hipotecario   --> 
          </div>
          <div class="trform-pr">
            <div class="continuar-pr float-right"> <a id="SimuladorPersonalPaso2" href="javascript:;" title="Continuar" onClick="_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 2 Simulacion ', 'Pr&eacute;stamo Personal']);">Continuar</a> </div>
            <br class="both" />
          </div>
          <div id="paso1CrePersonal" class="trtxterror-pr"></div>
        </div>
        <div class="pas-feature pas-personal">
          <div class="trtitulo-pr"></div>
          <div class="trform-pr"> 
            <!-- slider selector simulador Credito Personal -->
            <div class="content-slider"><span>Plazo de Cr&eacute;dito:&nbsp;</span><span class="negra valor-sl"></span>
              <input type="hidden" id="plazoCreditoPrestamo" value="" name="plazoCreditoPrestamo" class="input-sl" />
              <div id="plazoCreditoPersonal" class="selector sl160">
                <div class="sl-left"></div>
                <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Pasos"/>
                <div class="knob"></div>
                <div class="sl-right"></div>
              </div>
            </div>
            <br class="both" />
            
            <!-- fin selector simulador Credito Personal   --> 
          </div>
          <div class="trespacio-pr"></div>
          <div class="trespacio-pr"></div>
          <div class="trform-pr">
            <div class="float-left" style="width:80px; line-height:28px">Tipo de Cuota</div>
            <div class="sepw8 float-left"></div>
            <div id="tipoCuotaContent" class="optiongroup float-left">
              <input type="hidden" id="tipoCuotaHidden" name="tipoCuotaHidden" value="1" />
              <br class="both" />
            </div>
          </div>
          <br class="both" />
          <div class="trtxtad-pr"></div>
          <div class="trform-pr">
            <div class="captcha-pr float-left"><img id="captchaPersonal" src='<portlet:resourceURL id="traerCaptcha"/>' width="106" title="Captcha" height="28" /></div>
            <div class="traddcaptcha">
              <div class="reload-pr" id="reloadCaptchaPersonal">
              	<div class="tool-hel-pr">Actualizar c&oacute;digo captcha</div>
              </div>
              <div class="help-pr">
                <div class="tool-hel-pr">Ingresa los valores que ves en el cuadro</div>
              </div>
            </div>
            <input type="text" class="textform wt105 float-left" value=""  name="txtcaptchaPersonal" id="txtcaptchaPersonal" placeholder="Ingresa el C&oacute;digo" />
            <br class="both" />
          </div>
          <div class="trtitulo-pr"></div>
          <div class="trform-pr">
            <div class="regresar-pr float-left" id="returnCaptchaPersonal"><a href="javascript:;" title="Regresar" onClick="_gaq.push(['_trackEvent', 'Simulador Pr&eacute;stamo Personal', 'PASO 1', '${requestScope.simPaginaActual}']);">Regresar</a></div>
            <input type="button" class="btn-simular-pr float-right" id="btnCrePersonal" value="Simula tu Cr&eacute;dito" title="Simula tu Cr&eacute;dito" />
            <br class="both" />
          </div>
          <div id="paso2CrePersonal" class="trtxterror-pr"></div>
        </div>
        <input id="utmSource" type="hidden" name="utmSource" value="${requestScope.utmSource}" />
              <input id="utmMedium" type="hidden" name="utmMedium" value="${requestScope.utmMedium}" />
              <input id="utmCampaing" type="hidden" name="utmCampaing" value="${requestScope.utmCampaing}" />
              <input id="utmContent" type="hidden" name="utmContent" value="${requestScope.utmContent}" />
      </form>
    </div>
  </div>
  <div class="sec-feature-img"> <img src="${urlImagen}/prestamopersonal_270x274.jpg" width="270" title="Simula tu Crédito Personal" /></div>
  <br class="both" />
  <div class="sec-feature-legal">  Los datos emitidos por este simulador son referenciales, est&aacute;n sujetos a evaluaci&oacute;n y a la fecha real del desembolso del cr&eacute;dito. No se incluyen los gastos pagados al contado directamente por el cliente. El monto de las cuotas no incluye ITF. </div>
</div>

<!-- Hiddens de valores de validacion -->
<input type="hidden" name="RANGO_VALOR_PERSONAL_SIM_PER_SOLES"   id="RANGO_VALOR_PERSONAL_SIM_PER_SOLES"   value='${requestScope.RANGO_VALOR_PERSONAL_SIM_PER_SOLES}'/>
<input type="hidden" name="RANGO_VALOR_PERSONAL_SIM_PER_DOLARES" id="RANGO_VALOR_PERSONAL_SIM_PER_DOLARES" value='${requestScope.RANGO_VALOR_PERSONAL_SIM_PER_DOLARES}'/>
<input type="hidden" name="urlImagen" id="urlImagen" value='${urlImagen}'/>
<input type="hidden" name="simuladorBean" id="simuladorBean" value='${requestScope.simuladorBean}' />	
<input type="hidden" name="productoDefault" id="productoDefault" value='${requestScope.productoDefault}' />	