<input type="hidden" id="URLValidarCaptchaVehicular" value="<portlet:resourceURL id="validarCaptchaVehicular"/>"/>
<input type="hidden" id="URLTraerCaptchaVehicular" value='<portlet:resourceURL id="traerCaptcha"/>'/>
<input type="hidden" value="${urlImagen}" id="urlImagenSliderVehicular"/>

 <div class="feature-hp alt_med">
        <div class="sec-feature" id="tabVehicular">
          <h2>Simula tu Cr&eacute;dito Vehicular</h2>
          <div class="content-pasos">
            <div class="no-click"><img src="${urlImagen}/space.gif" width="200" height="20" title="Pasos"/></div>
            <span class="float-left">Pasos&nbsp;&nbsp; </span> <a href="#" class="tab-vehicular">1</a> <a href="#" class="tab-vehicular">2</a> </div>
          <div class="pas-cont">
            <form  name="formCreVehicular" action="" id="formCreVehicular" method="post">
              <div class="pas-feature pas-vehicular">
                <div class="trtitulo-pr">
                  <div style="width:50px; margin-left:280px;">Moneda</div>
                </div>
                <div class="trform-pr">
                  <div id="cmbTipDocVehicular" class="dropdown2 wd147 float-left hgt26">
                  </div>
                  <div class="sepw8 float-left"></div>
                  <input type="text" class="textform wt105 float-left " value=""  name="txtNumDocVehicular" id="txtNumDocVehicular" placeholder="N&ordm; de Documento" maxLength="11"/>
                  <div class="sepw8 float-left"></div>
                  <div id="optTipMonedaVehicular" class="optiongroup float-left">
                  </div>
                  <br class="both" />
                </div>
                <div class="trtxtad-pr">Ingresa tu N&ordm; de Documento para una mejor oferta</div>
                <div class="trespacio-pr"></div>
                <div class="trtitulo-pr"> Tipo de Cr&eacute;dito </div>
                <div class="trform-pr">
                   <div id="optTipCreditoVehicular" class="optiongroup anch">
                   <br class="both" />
                  </div>
                </div>
                <br class="both" />
                <div class="trform-pr">

                  <!-- slider selector simulador de Credito Vehicular Step#1  -->
                  <div class="content-slider"> <span>Valor del bien:&nbsp;</span><span  class="negra symbol">&nbsp;S/.</span><span class="negra valor-sl"></span><span class="negra">.00</span>
                    <input type="hidden" id="sliderValorAuto" value="" class="input-sl" name="sliderValorAuto"/>
                    <div id="valorAuto" class="selector sl175">
                      <div class="sl-left"></div>
                      <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Simulador de Credito Vehicular"/>
                      <div class="knob"></div>
                      <div class="sl-right"></div>
                    </div>
                  </div>
                  <div class="content-slider"> <span>Cuota Inicial:&nbsp;</span><span class="negra valor-sl"></span><span class="negra">%</span>
                    <input type="hidden" id="sliderValorInicial" value="" class="input-sl" name="sliderValorInicial"/>
                    <div id="valorInicial" class="selector sl160">
                      <div class="sl-left"></div>
                      <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Simulador de Credito Vehicular"/>
                      <div class="knob"></div>
                      <div class="sl-right"></div>
                    </div>
                  </div>
                  <br  class="both"/>
                  <!-- fin slider selector -->

                </div>
                <div class="trform-pr">
                  <div class="continuar-pr float-right"> <a href="javascript:;" title="Continuar" id="btnCreVehicularContinuar" onClick="_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 2 Simulacion ', 'Cr&eacute;dito Vehicular']);">Continuar</a> </div>
                  <br class="both" />
                </div>
                <div class="trtxterror-pr" id="errorVehicularPaso1"></div>
              </div>
              <div class="pas-feature pas-vehicular">
                <div class="trtitulo-pr"></div>
                <div class="trform-pr">

                  <!-- slider selector simulador de Credito Vehicular Step#2  -->

                  <div class="content-slider"> <span class="float-left">Plazo de Cr&eacute;dito:&nbsp;</span><span class="negra valor-sl float-left"></span><span class="negra float-left">&nbsp;meses&nbsp;</span>
                    <input type="hidden" id="sliderPlazoCreditoVehicular" value="" class="input-sl" name="sliderPlazoCreditoVehicular"/>
                    <div id="plazoCreditoVehicular" class="selector sl160 float-left no-margin">
                      <div class="sl-left"></div>
                      <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Simulador de Credito Vehicular"/>
                      <div class="knob"></div>
                      <div class="sl-right"></div>
                    </div>
                  </div>

                  <!-- fin slider selector -->
                  <br class="both"/>
                </div>
                <div class="trespacio-pr"></div>
                <div class="trespacio-pr"></div>
                <div class="trtitulo-pr">
                  <div class="float-left" style="width:151px; margin-left:-1px;">Tipo de Cuota</div>
                  <div class="float-left" style="width:151px;margin-left: 10px;">Seguro de desgravamen</div>
                  <div class="both"></div>
                </div>
                <div class="trform-pr">
                  <div class="optiongroup float-left" id="optTipCuotaVehicular"></div>
                  <div class="sepw8 float-left"></div>
                  <div class="optiongroup float-left" id="optTipSeguroVehicular"></div>
                  <br class="both"/>
                </div>
                <div class="trtxtad-pr"></div>
                <div class="trform-pr">
                  <div class="captcha-pr float-left"><img id="captchaVehicular" src='<portlet:resourceURL id="traerCaptcha"/>' width="106" title="Captcha" height="28" /></div>
                  <div class="traddcaptcha">
                    <div class="reload-pr" id="reloadCaptchaVehicular">
                    	<div class=" tool-hel-pr">Actualizar c&oacute;digo captcha</div>
                    </div>
                    <div class="help-pr">
                      <div class="tool-hel-pr">Ingresa los valores que ves en el cuadro</div>
                    </div>
                  </div>
                  <input type="text" class="textform wt105 float-left" value=""  name="txtCaptchaVehicular" id="txtCaptchaVehicular"  placeholder="Ingresa el C&oacute;digo"/>
                  <br class="both" />
                </div>
                <div class="trtitulo-pr"></div>
                <div class="trform-pr">
                  <div class="regresar-pr float-left" id="returnCaptchaVehi"><a href="javascript:;" title="Regresar" onClick="_gaq.push(['_trackEvent', 'Simulador Cr&eacute;dito Vehicular', 'PASO 1', '${requestScope.simPaginaActual}']);">Regresar</a></div>
                  <input type="submit" class="btn-simular-pr float-right" id="btnCreVehicular" value="Simula tu Cr&eacute;dito" title="Simula tu Cr&eacute;dito" />
                  <br class="both" />
                </div>
                <div class="trtxterror-pr" id="errorVehicularPaso2"></div>
              </div>
              <div id="upload_target_vehicular"></div>
              
              <input id="utmSource" type="hidden" name="utmSource" value="${requestScope.utmSource}" />
              <input id="utmMedium" type="hidden" name="utmMedium" value="${requestScope.utmMedium}" />
              <input id="utmCampaing" type="hidden" name="utmCampaing" value="${requestScope.utmCampaing}" />
              <input id="utmContent" type="hidden" name="utmContent" value="${requestScope.utmContent}" />
            </form>
          </div>
        </div>
        <div class="sec-feature-img"> <img src="${urlImagen}/sim-credito-vehicular-h.jpg" width="270" title="Simulador Crédito Vehicular" /> </div>
        <br class="both" />
        <div class="sec-feature-legal"> Los datos emitidos por este simulador son referenciales, est&aacute;n sujetos a evaluaci&oacute;n y a la fecha real del desembolso del cr&eacute;dito. No se incluyen los gastos pagados al contado directamente por el cliente. El monto de las cuotas no incluye ITF. </div>
      </div>
      <!--  Fin simulador de Credito Vehicular -->
      <!-- Hiddens de valores de validacion -->
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES"   id="RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES"   value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_TRA_SOLES}'/>
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES" id="RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES" value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_TRA_DOLARES}'/>
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES"   id="RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES"   value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_CNU_SOLES}'/>
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES" id="RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES" value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_CNU_DOLARES}'/>
	  <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES"   id="RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES"   value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_ESP_SOLES}'/>
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES" id="RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES" value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_ESP_DOLARES}'/>
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES"   id="RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES"   value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_CIN_SOLES}'/>
      <input type="hidden" name="RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES" id="RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES" value='${requestScope.RANGO_VALOR_VEHICULO_SIM_VEH_CIN_DOLARES}'/>
      
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES"   id="RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES"   value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_TRA_SOLES}'/>
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES" id="RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES" value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_TRA_DOLARES}'/>
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES"   id="RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES"   value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_CNU_SOLES}'/>
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES" id="RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES" value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_CNU_DOLARES}'/>
	  <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES"   id="RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES"   value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_ESP_SOLES}'/>
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES" id="RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES" value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_ESP_DOLARES}'/>
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES"   id="RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES"   value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_CIN_SOLES}'/>
      <input type="hidden" name="RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES" id="RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES" value='${requestScope.RANGO_CUOTA_INICIAL_SIM_VEH_CIN_DOLARES}'/>
      
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES"   id="RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES"   value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_TRA_SOLES}'/>
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES" id="RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES" value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_TRA_DOLARES}'/>
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES"   id="RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES"   value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_CNU_SOLES}'/>
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES" id="RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES" value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_CNU_DOLARES}'/>
	  <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES"   id="RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES"   value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_ESP_SOLES}'/>
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES" id="RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES" value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_ESP_DOLARES}'/>
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES"   id="RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES"   value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_CIN_SOLES}'/>
      <input type="hidden" name="RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES" id="RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES" value='${requestScope.RANGO_PLAZO_CREDITO_SIM_VEH_CIN_DOLARES}'/> 
      <input type="hidden" name="simuladorBean" id="simuladorBean" value='${requestScope.simuladorBean}' />
      <input type="hidden" name="productoDefault" id="productoDefault" value='${requestScope.productoDefault}' />		