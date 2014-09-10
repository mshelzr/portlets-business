<!-- Inicio de simulador de Crédito Hipotecarior // 3 // -->
<input type="hidden" id="URLvalidarCaptchaHipotecario" value="<portlet:resourceURL id="validarCaptchaHipotecario"/>"/>
<input type="hidden" id="URLTraerCaptchaHipotecario" value='<portlet:resourceURL id="traerCaptcha"/>'/>
      <div class="feature-hp alt_med">
        <div class="sec-feature" id="tabHipotecario">
          <h2>Simula tu Cr&eacute;dito Hipotecario</h2>
          <div class="content-pasos">
            <div class="no-click"><img src="${urlImagen}/space.gif" width="200" height="20" title="Pasos" /></div>
            <span class="float-left">Pasos&nbsp;&nbsp; </span> <a href="#" class="tab-hipoteca">1</a> <a href="#" class="tab-hipoteca">2</a> </div>
          <div class="pas-cont">
            <form  name="formCreHipotecario" id="formCreHipotecario" method="post">
              <div class="pas-feature pas-hipoteca">
                <div class="trtitulo-pr">
                  <div style="width:50px; margin-left:280px;">Moneda</div>
                </div>
                <div class="trform-pr">                  
					<div class="dropdown2 wd147 float-left hgt26" id="cmbTipDocHipotecario">
						<div>Tipo de Documento</div>
						<input type="text" name="docCreHipotecarioHidden" id="docCreHipotecarioHidden" value="0"/>
					</div>
                  <div class="sepw8 float-left"></div>
                  <input type="text" class="textform wt105 float-left" value=""  name="txtNumDocHipotecario" id="txtNumDocHipotecario" maxLength="8" placeholder="N&ordm; de Documento" />
                  <div class="sepw8 float-left"></div>
				<div class="optiongroup float-left" id="optTipMonedaHipotecario">
				   	<input type="hidden" id="tipoMonedaHipotecarioHidden" name="tipoMonedaHipotecarioHidden" value="1" />
				</div>
                </div>
                <br class="both" />
                <div class="trtxtad-pr">Ingresa tu N&ordm; de Documento para una mejor oferta</div>
                <div class="trespacio-pr"></div>
                <div class="trtitulo-pr">Tipo de Cr&eacute;dito </div>
                <div class="trform-pr">
                  <div class="optiongroup" id="optTipCreditoHipotecario">
                    <input type="hidden" id="tipoCreditoHipotecarioHidden" name="tipoCreditoHipotecarioHidden" value="1" />
				</div>
                </div>
                <br class="both"/>
                <div class="trform-pr">
                  <!-- slider selector simulador Credito Hipotecario -->
                  <div class="content-slider"> <span>Valor del bien:&nbsp;</span><span class="negra">&nbsp;S/.</span><span class="negra valor-sl"></span><span class="negra">.00</span>
                    <input type="hidden" id="sliderValorInmueble" name="sliderValorInmueble" value="" class="input-sl" />
                    <div id="valorInmueble" class="selector sl175">
                      <div class="sl-left"></div>
                      <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Simulador Credito Hipotecario"/>
                      <div class="knob"></div>
                      <div class="sl-right"></div>
                    </div>
                  </div>
                  <div class="content-slider"> <span>Cuota Inicial:&nbsp;</span><span class="negra valor-sl"></span><span class="negra">%</span>
                    <input type="hidden" id="sliderValorInicialHipotecario" name="sliderValorInicialHipotecario" value="" class="input-sl" />
                    <div id="cuotaInicialVehiculo" class="selector sl160">
                      <div class="sl-left"></div>
                      <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Simulador Credito Hipotecario"/>
                      <div class="knob"></div>
                      <div class="sl-right"></div>
                    </div>
                  </div>
                  <br class="both"/>
                  <!-- fin selector simulador Credito Hipotecario   -->
                </div>
                <div class="trform-pr">
                  <div class="continuar-pr float-right"><a id="btnCreHipotecarioContinuar" href="javascript:;" title="Continuar" onClick="_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 2 Simulacion ', 'Cr&eacute;dito Hipotecario']);">Continuar</a></div>
                  <br class="both" />
                </div>
                <div id="errorHipotecarioPaso1" class="trtxterror-pr"></div>
              </div>
              <div class="pas-feature pas-hipoteca">
                <div class="trtitulo-pr"></div>
                <div class="trform-pr">
                  <!-- slider selector Simulador Credito Hipotecario -->
                  <div class="content-slider"> 
                  	<span class="float-left">Plazo de Cr&eacute;dito:&nbsp;</span>
                  	<span class="negra valor-sl float-left"></span>
                  	<span class="negra valor-sl float-left">&nbsp;A&ntilde;os&nbsp;</span>
                    <input type="hidden" id="sliderPlazoCreditoHipotecario" name="sliderPlazoCreditoHipotecario" value="" class="input-sl" />
                    <div id="plazoCreditohipotecario" class="selector sl160 float-left no-margin">
                      <div class="sl-left"></div>
                      <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Simulador Credito Hipotecario"/>
                      <div class="knob"></div>
                      <div class="sl-right"></div>
                    </div>
                  </div>

                  <!-- fin SELECTOR simulador Credito Hipotecario -->
                  <br class="both"/>
                </div>
                <div class="trespacio-pr"></div>
                <div class="trespacio-pr"></div>
                <div class="trtitulo-pr">
                  <div class="float-left" style="width:151px;">Seguro de desgravamen</div>
                  <div class="float-left" style="width:151px; margin-left:8px;">Tipo de Cuota</div>
                  <br class="both"/>
                </div>
                <div class="trform-pr">
					<div class="optiongroup float-left" id="optTipSeguroHipotecario">
						<input type="hidden" id="tipoSeguroHipotecaria" name="tipoSeguroHipotecaria" value="1" />
					</div>
                  <div class="sepw8 float-left"></div>
                  <div class="optiongroup float-left" id="optTipCuotaHipotecario">
                    <input type="hidden" id="tipoCuotaHipotecaria" name="tipoCuotaHipotecaria" value="1" /> 
                  </div>                    
                  <br class="both" />
                </div>
                <div class="trtxtad-pr"></div>
                <div class="trform-pr">
                  <div class="captcha-pr float-left"><img id="captchaHipotecario" src='<portlet:resourceURL id="traerCaptcha"/>' width="106" title="Captcha" /></div>
                  <div class="traddcaptcha">
                    <div id="reloadcaptchaHipotecario" class="reload-pr">
                    	<div class="tool-hel-pr">Actualizar c&oacute;digo captcha</div>
                    </div>
                    <div class="help-pr">
                      <div class="tool-hel-pr">Ingresa los valores que ves en el cuadro</div>
                    </div>
                  </div>
                  <input type="text" class="textform wt105 float-left" value=""  name="txtCaptchaHipotecario" id="txtCaptchaHipotecario" placeholder="Ingresa el C&oacute;digo" />
                  <br class="both" />
                </div>
                <div class="trtitulo-pr"></div>
                <div class="trform-pr">
                  <div class="regresar-pr float-left" id="returnCaptchaHipo"><a href="javascript:;" title="Regresar" onClick="_gaq.push(['_trackEvent', 'Simulador Cr&eacute;dito Hipotecario', 'PASO 1', '${requestScope.simPaginaActual}']);">Regresar</a></div>
                  <input type="button" class="btn-simular-pr float-right" id="btnCreHipotecario" value="Simula tu Cr&eacute;dito" title="Simula tu Cr&eacute;dito" />
                  <br class="both" />
                </div>
                <div id="sendCreHipotecarioError" class="trtxterror-pr"></div>
              </div>
              <input id="utmSource" type="hidden" name="utmSource" value="${requestScope.utmSource}" />
              <input id="utmMedium" type="hidden" name="utmMedium" value="${requestScope.utmMedium}" />
              <input id="utmCampaing" type="hidden" name="utmCampaing" value="${requestScope.utmCampaing}" />
              <input id="utmContent" type="hidden" name="utmContent" value="${requestScope.utmContent}" />
            </form>
          </div>
        </div>
        <div class="sec-feature-img"> <img src="${urlImagen}/sim-credito-hipotecario-h.jpg" width="270" title="Simula tu Crédito Hipotecario" /> </div>
        <br class="both" />
        <div class="sec-feature-legal">Los datos emitidos por este simulador son referenciales, est&aacute;n sujetos a evaluaci&oacute;n y a la fecha real del desembolso del cr&eacute;dito. No se incluyen los gastos pagados al contado directamente por el cliente. El monto de las cuotas no incluye ITF.</div>
      </div>
	<input type="hidden" name="RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES" id="RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES" value='${requestScope.RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES" id="RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES" value='${requestScope.RANGO_VALOR_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES}'/>
	<input type="hidden" name="RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES" id="RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES" value='${requestScope.RANGO_VALOR_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES" id="RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES" value='${requestScope.RANGO_VALOR_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES" id="RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES" value='${requestScope.RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES" id="RANGO_VALOR_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES" value='${requestScope.RANGO_VALOR_GARANTIA_HIPOTECARIO_CRE_HIPO_DOLARES}'/>
	<input type="hidden" name="RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES" id="RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES" value='${requestScope.RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES" id="RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES" value='${requestScope.RANGO_CUOTA_CREDITO_HIPOTECARIO_CRE_HIPO_DOLARES}'/>
	<input type="hidden" name="RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES" id="RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES" value='${requestScope.RANGO_CUOTA_MIVIVIENDA_COFIDE_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES" id="RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES" value='${requestScope.RANGO_CUOTA_TECHO_PROPIO_COFIDE_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES" id="RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES" value='${requestScope.RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_SOLES}'/>
	<input type="hidden" name="RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES" id="RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES" value='${requestScope.RANGO_CUOTA_GARANTIA_HIPOTECARIA_CRE_HIPO_DOLARES}'/>
	<input type="hidden" name="RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO" id="RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO" value='${requestScope.RANGO_PLAZO_HIPOTECARIO_REGULAR_CRE_HIPO}'/>
	<input type="hidden" name="RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO" id="RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO" value='${requestScope.RANGO_PLAZO_MIVIVIENDA_COFIDE_CRE_HIPO}'/>
	<input type="hidden" name="RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO" id="RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO" value='${requestScope.RANGO_PLAZO_TECHO_PROPIO_COFIDE_CRE_HIPO}'/>
	<input type="hidden" name="RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO" id="RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO" value='${requestScope.RANGO_PLAZO_GARANTIA_HIPOTECARIA_CRE_HIPO}'/>
	<!-- fin Simulador Credito Hipotecario -->
	<input type="hidden" name="simuladorBean" id="simuladorBean" value='${requestScope.simuladorBean}' />
	<input type="hidden" name="productoDefaultHipotecario" id="productoDefaultHipotecario" value='${requestScope.productoDefault}' />
	<input type="hidden" value="${requestScope.vs }" name="idVSHip" id="idVSHip"/>	