<!-- Inicio Simula tu Crédito por Fondos Mutuos -->
<input type="hidden" id="URLvalidarCaptchaFondosMutuos" value="<portlet:resourceURL id="validarCaptchaFondosMutuos"/>"/>
<input type="hidden" id="URLTraerCaptchaFondosMutuos" value='<portlet:resourceURL id="traerCaptcha"/>'/> 
<form enctype="multipart/form-data" name="formCreFondosMutuos" action="" id="formCreFondosMutuos" onsubmit="return false;">
 		<div class="feature-hp alt_med">
 		<div class="sec-feature" id="tabMutuos">
          <h2>Simula tus Fondos Mutuos</h2>
          <div class="content-pasos">
            <div class="no-click"><img src="${urlImagen}/space.gif" width="200" height="20" title="Pasos" /></div>
            <span class="float-left">Pasos&nbsp;&nbsp; </span> <a href="#" class="tab-mutuos">1</a> <a href="#" class="tab-mutuos">2</a> <a href="#" class="tab-mutuos">3</a> <a href="#" class="tab-mutuos">4</a> </div>
          <div class="pas-cont">
            <div class="pas-feature pas-mutuos ">
              <div class="trtitulo-pr"></div>
              <span class="gray4">${pregunta1Fondos}</span>
              <div id="fondosSimInvertidoContent" class="simuladorC-contenedor">
              </div>
              <div class="trform-pr">
                <div class="continuar-pr float-right"><a id="continuar2FondosMutuos" href="javascript:;" title="Continuar" onClick="_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 2 Simulacion ', 'Fondos Mutuos']);">Continuar</a></div>
                <br class="both" />
              </div>
              <div class="trtxterror-pr" id="trtxterrorCont2FonMut" ></div>
            </div>
            <div class="pas-feature pas-mutuos">
              <div class="trtitulo-pr"></div>
              <span class="gray4">${pregunta2Fondos}</span>
              <div id="fondosSimConocimientoContent" class="simuladorC-contenedor">
                
              </div>
              <div class="trform-pr">
                <div class="regresar-pr float-left "> <a href="#" title="Regresar" onClick="_gaq.push(['_trackEvent', 'Simulador Fondos Mutuos', 'PASO 1', '${requestScope.simPaginaActual}']);">Regresar</a> </div>
                <div class="continuar-pr float-right"> <a id="continuar3FondosMutuos" href="javascript:;" title="Continuar" onClick="_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 3 Simulacion ', 'Fondos Mutuos']);">Continuar</a> </div>
                <br class="both" />
              </div>
              <div class="trtxterror-pr" id="trtxterrorCont3FonMut"></div>
            </div>
            <div class="pas-feature pas-mutuos">
              <div class="trespacio-pr"></div>
              <span class="gray4">${pregunta3Fondos}</span>
              <div  id="fondosSimVariacionesContent" class="simuladorC-contenedor">
              </div>
              <div class="trform-pr">
                <div class="regresar-pr float-left "> <a href="javascript:;" title="Regresar" onClick="_gaq.push(['_trackEvent', 'Simulador Fondos Mutuos', 'PASO 2', '${requestScope.simPaginaActual}']);">Regresar</a> </div>
                <div class="continuar-pr float-right"> <a id="continuar4FondosMutuos" href="javascript:;" title="Continuar" onClick="_gaq.push(['_trackEvent', 'Simulaciones', 'Paso 4 Simulacion ', 'Fondos Mutuos']);">Continuar</a> </div>
                <br class="both" />
              </div>
              <div class="trtxterror-pr" id="trtxterrorCont4FonMut"></div>
            </div>
            <div class="pas-feature pas-mutuos">
              <div class="trform-pr"> <span class="centrado-medio"> ¿En que moneda te gustar&iacute;a invertir?</span>
                <div id="tipoMonedaSimFondosMutuosContent" class="optiongroup float-left">
                  <input type="hidden" id="tipoMonedaSimFondosMutuoshidden" name="tipoMonedaSimFondosMutuoshidden" value="0" />
               </div>
                <br class="both" />
              </div>
              <div class="trespacio-pr"></div>
              <div class="trform-pr">
                <!-- slider selector Simulador Crédito por Fondos Mutuos -->
                
                
                <div class="content-slider"> 
                <span> ¿Cu&aacute;nto deseas invertir?</span>
                  <input type="hidden" id="valorAuto7" value="" class="input-sl" name="monto_invertir"/>
                  <br id="brInvertir" class="both" />
                  <div id="scfmInvertir" class="selector sl160 float-left">
                    <div class="sl-left"></div>
                    <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Pasos"/>
                    <div class="knob"></div>
                    <div class="sl-right"></div>
                  </div>
                  <div class="sepw8 float-left height20"></div>
			  <span class="negra float-left">S/.&nbsp;</span> 
                  <span class="negra valor-sl float-left"></span>
                  </div>
                
                
                <br class="both" />
                
                
                <div class="content-slider"><span>¿Cuánto tiempo desea invertir su dinero?</span>
                  <input type="hidden" id="valorAuto12" name="tiempo_invertir" value="" class="input-sl" />
                  <br class="both" />
                  <div id="plazoSliderFondos" class="selector sl160 float-left">
                    <div class="sl-left"></div>
                    <img src="${urlImagen}/bkg_slider.jpg" class="sl-img" title="Pasos"/>
                    <div class="knob"></div>
                    <div class="sl-right"></div>
                  </div>
                  <div class="sepw8 float-left height20"></div>
                  <span class="negra valor-sl float-left"></span>
                  </div>
                  
                  
                <br class="both" />

                <!-- fin selector Simulador Crédito por Fondos Mutuos  -->
              </div>
              <div class="trform-pr">
                <div class="captcha-pr float-left"><img id="imgCaptchaFondosMutuos" src='<portlet:resourceURL id="traerCaptcha"/>' width="106" title="Captcha" /></div>
                <div class="traddcaptcha">
                  <div class="reload-pr" id="fondosCaptchaReload">
                  	<div class="tool-hel-pr">Actualizar c&oacute;digo captcha</div>
                  </div>
                  <div class="help-pr">
                    <div class="tool-hel-pr">Ingresa los valores que ves en el cuadro</div>
                  </div>
                </div>
                <input type="text" class="textform wt105 float-left" value=""  name="codCaptchaFondosMutuos" id="codCaptchaFondosMutuos" placeholder="Ingresa el Código" />
                <br class="both" />
              </div>
              <div class="trtitulo-pr"></div>
              <div class="trform-pr">
                <div class="regresar-pr float-left" id="returnCaptchaFondos"><a href="javascript:;" title="Regresar" >Regresar</a></div>
                <input type="button" id="validFondosMutuos" class="btn-simular-pr float-right"  value="Simular" title="Simular" />
                <br class="both" />
              </div>
              <div class="trtxterror-pr" id="validEnvioFondosMutuos"></div>
            </div>
          </div>
        </div>
        <div class="sec-feature-img"> <img src="${urlImagen}/simulafondosmutuos_270x274.jpg" width="270" title="Simula tu Crédito por Fondos Mutuos" /> </div>
        <br class="both" />
        <div class="sec-feature-legal"> Los datos emitidos por este simulador son referenciales, corresponden a un c&aacute;lculo realizado en base a la rentabilidad del periodo anterior. </div>
      </div>
</form>      
<input type="hidden" id="RANGO_PLAZO_FONDOS_MUTUOS_SOLES" name="RANGO_PLAZO_FONDOS_MUTUOS_SOLES" value='${requestScope.RANGO_PLAZO_FONDOS_MUTUOS_SOLES}'/>
<input type="hidden" id="RANGO_PLAZO_FONDOS_MUTUOS_DOLARES" name="RANGO_PLAZO_FONDOS_MUTUOS_DOLARES" value='${requestScope.RANGO_PLAZO_FONDOS_MUTUOS_DOLARES}'/>