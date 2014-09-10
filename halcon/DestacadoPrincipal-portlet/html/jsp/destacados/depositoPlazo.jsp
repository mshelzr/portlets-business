<input type="hidden" id="URLValidarCaptchaDeposito" value="<portlet:resourceURL id="validarCaptchaDeposito"/>"/>
<input type="hidden" id="URLTraerCaptchaDeposito" value='<portlet:resourceURL id="traerCaptcha"/>'/>
<input type="hidden" value="${urlImagen}" id="urlImagenSliderDeposito"/>
<!-- Inicio simulador Deposito a Plazo // 2 //  -->
<div class="feature-hp alt_med">
	<div class="sec-feature" id="tabPlazo">
		<h2>Simula tu Dep&oacute;sito a Plazo</h2>
		<div class="content-pasos"></div>
		<form name="formDepPlazo" action="" id="formDepPlazo">
			<div class="trtitulo-pr">
				<div style="width: 50px; margin-left: 280px;">Moneda</div>
			</div>
			<div class="trform-pr">
				<div class="dropdown2 wd147 float-left hgt26"
					id="docCreDepositoPlazoContent">
					<div>Tipo de Documento</div>
					<input type="hidden" name="docCreDepositoPlazoHidden"
						id="docCreDepositoPlazoHidden" value="" />
				</div>
				<div class="sepw8 float-left"></div>
				<input type="text" class="textform wt105 float-left" value=""
					name="documentSimDeposito" id="documentSimDeposito" maxLength="8"
					placeholder="N&ordm; de Documento" />
				<div class="sepw8 float-left"></div>
				<div class="optiongroup float-left" id="tipoMonedaDepositoContent">
					<input type="hidden" id="tipoMonedaDepositoHidden"
						name="tipoMonedaDepositoHidden" value="1" />
				</div>
				<br class="both" />
			</div>
			<div class="trtxtad-pr">Tipo Documento</div>
			<div class="trespacio-pr"></div>
			<div class="trform-pr">
				<!-- slider selector simulador Deposito a Plazo  -->

				<div id="plazoCreditoFijoSlider" class="content-slider" style="width:190px;"><span style="margin-left:0px">Valor de inversi&oacute;n:</span><span class="negra">S/.</span><span class="negra valor-sl">,000</span><span class="negra">.00</span><input type="hidden" id="valorInversion" name="valorInversion"
						value="" class="input-sl" /> <span class="negra">&nbsp;</span>
					<div id="plazoCredito" class="selector sl160">
						<div class="sl-left"></div>
						<img src="${urlImagen}/bkg_slider.jpg" class="sl-img"
							title="Simulador Déposito a Plazo" />
						<div class="knob"></div>
						<div class="sl-right"></div>
					</div>
				</div>

				<div id="plazoDepositoFijoSlider" class="content-slider" style="width:165px;">
					<span style="margin-left:-20px; padding-left:17px;">Periodo de inversi&oacute;n:</span><span class="negra valor-sl"></span> 
						<input type="hidden" id="plazoInversion" value="" name="plazoInversion"	class="input-sl" />
					<div id="plazoDeposito" class="selector sl160">
						<div class="sl-left"></div>
						<img src="${urlImagen}/bkg_slider.jpg" class="sl-img"
							title="Simulador Déposito a Plazo" />
						<div class="knob"></div>
						<div class="sl-right"></div>
					</div>
				</div>
				<!-- fin selector simulador Plazo a Deposito  -->
				<br class="both" />
			</div>
			<br class="both" />
			<div class="trform-pr">
				<div class="captcha-pr float-left">
					<img id="captchaDeposito"
						src='<portlet:resourceURL id="traerCaptcha"/>' width="106"
						title="Captcha" />
				</div>
				<div class="traddcaptcha">
					<div class="reload-pr" id='reloadCaptchaDeposito'>
						<div class="tool-hel-pr">Actualizar c&oacute;digo captcha</div>
					</div>
					<div class="help-pr">
						<div class="tool-hel-pr">Ingresa los valores que ves en el cuadro</div>
					</div>
				</div>
				<input type="text" class="textform wt105 float-left" value=""
					name="codCaptchaDeposito" id="codCaptchaDeposito"
					placeholder="Ingresa el C&oacute;digo" /> <br class="both" />
			</div>
			<div class="trtitulo-pr"></div>
			<div class="trform-pr">
				<input type="button" class="btn-simular-pr float-right"
					id="btnDepPlazo" value="Simular" title="Simular" /> <br class="both" />
			</div>
			<div id="errorDeposito" class="trtxterror-pr"></div>
			<input id="utmSource" type="hidden" name="utmSource" value="${requestScope.utmSource}" />
              <input id="utmMedium" type="hidden" name="utmMedium" value="${requestScope.utmMedium}" />
              <input id="utmCampaing" type="hidden" name="utmCampaing" value="${requestScope.utmCampaing}" />
              <input id="utmContent" type="hidden" name="utmContent" value="${requestScope.utmContent}" />
		</form>
	</div>
	<div class="sec-feature-img" style="width:260px;">
		<img src="${urlImagen}/2-depositoaplazo_270x274.jpg" width="260"
			title="Simula tu Déposito a Plazo" />
	</div>
	<br class="both" />
	<div class="sec-feature-legal"></div>
</div>
<!-- Fin simulador de  Deposito a Plazo  -->
<input type="hidden" name="RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES"   id="RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES"   value='${requestScope.RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_SOLES}'/>
<input type="hidden" name="RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES" id="RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES" value='${requestScope.RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_DOLARES}'/>
<input type="hidden" name="RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS"   id="RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS"   value='${requestScope.RANGO_VALOR_DEPOSITO_SIM_DEP_PLA_EUROS}'/>	
<input type="hidden" name="simuladorBean" id="simuladorBean" value='${requestScope.simuladorBean}' />	