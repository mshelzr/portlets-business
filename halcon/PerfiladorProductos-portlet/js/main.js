window.addEvent("domready", function() {

	var botonPaso1 = $("btnpaso1");

	if (botonPaso1 != null) {
		obtenerConfiguracionPerfilador();
		botonPaso1.addEvent("click", function() {
			var tipoP = $('tipoPerf').get('value');
			var btnEstado = botonPaso1.getStyle('opacity');
			if (btnEstado == 1) {
				_gaq.push(['_trackEvent', tipoP, 'Descubrelo aqui', 'Perfiladores']);
				var res = enviarPerfilador();
				if (res == '1') {
					$("paso2").tween("margin-left", "0px");
				}
			}
		});
		sizebodystep2();
		redimensionar();
	} else {
		cargarCombos();
	}

});

function cargarCombos() {
	var obtenerPerfilador = $("obtenerPerfiladorHidden");

	var jsonRequest = new Request.JSON(
		{
			method : 'get',
			url : obtenerPerfilador.get("value"),
			data : {

			},
			onComplete : function(response) {
				getdata3(
						"/GestionParametros-portlet/js/resources/cboPerfilador.json",
						"cmbTipoPerfiladorHidden", "cmbTipoPerfilador",
						response.tipoPerfilador);
			}
		});
	jsonRequest.send();

}

function optperfilador(data, nameHidden, btnpaso) {

	var contentDivBody = $('paso1').getElement('div.optPer');
	contentDivBody.set('html', ''), path = '/halcon-theme/images/halcon/',
			oldSpan = null, hidden = new Element('input', {
				'type' : 'hidden',
				'name' : nameHidden,
				'id' : nameHidden
			}).inject(contentDivBody);

	data.each(function(row) {
		var divitem = new Element('div', {
			'class' : 'item',
			styles : {
				'height' : 'auto'
			}
		}).inject(contentDivBody), em = new Element('em', {
			'val' : row.id
		}).inject(divitem), img = new Element('img', {
			'src' : path + row.ico
		}).inject(em), span = new Element('span', {
			'class' : 'text',
			'html' : row.title
		}).inject(divitem), height = span.getSize().y;
		if (height > 34) {
			em.setStyle('height', '45px');
			img.setStyle('margin-top', '10px');
		}
		divitem.addEvent('click', function() {
			if (oldSpan != null)
				oldSpan.removeProperties('style')
			span.setStyle('background', '#CCF0DE');
			oldSpan = span
			hidden.value = em.get('val');
		});
	});

}

// llenar datos dinamicos
function obtenerConfiguracionPerfilador() {

	var obtenerComponente = $("obtenerComponentesHidden");

	if (obtenerComponente != null) {

		var jsonRequest = new Request.JSON(
				{
					method : 'get',
					url : obtenerComponente.get("value"),
					data : {

					},
					onComplete : function(response) {
						var tipoPer = response.tipoPerfilador;
						var listaVar = response.listaVar;
						var htmlCabecera = '';
						var htmlCabecera2 = '';
						var nombreBoton = '';
						var iter = 0;
						$('perfil').setStyle('display', 'block');

						if (tipoPer == '2') {
							htmlCabecera = 'Descubre el cr\u00E9dito que m\u00E1s te conviene';
							htmlCabecera2 = '\u00A1Genial! Tenemos el cr\u00E9dito  que est\u00E1s buscando';
							nombreBoton = 'Desc\u00FAbrelo aqu\u00ED';
							$('tipoPerf').set('value', 'Necesito un credito');
							$('tipoPerfilador').set('value', '2');
						} else if (tipoPer == '3') {
							htmlCabecera = 'Descubre la tarjeta ideal para ti';
							htmlCabecera2 = '\u00A1Enhorabuena! Esta tarjeta es perfecta <br> para ti';
							nombreBoton = 'Desc\u00FAbrela aqu\u00ED';
							$(btnpaso1).set("html", "Descubre tu tarjeta");
							$('tipoPerf').set('value', 'Busco una tarjeta');
							$('tipoPerfilador').set('value', '3');
						} else if (tipoPer == '1') {
							htmlCabecera = 'Elige tu cuenta ideal para ahorrar';
							htmlCabecera2 = '\u00A1Genial! Tenemos la cuenta que est\u00E1s buscando';
							nombreBoton = 'Desc\u00FAbrela aqu\u00ED';
							$('tipoPerf').set('value', 'Quiero una cuenta');
							$('tipoPerfilador').set('value', '1');
						} else if (tipoPer == '4') {
							htmlCabecera = 'Descubre el seguro que tenemos para ti';
							htmlCabecera2 = '\u00A1Tenemos el seguro que est\u00E1s buscando!';
							nombreBoton = 'Desc\u00FAbrelo aqu\u00ED';
							$('tipoPerf').set('value', 'Seguros');
							$('tipoPerfilador').set('value', '4');
						}
						$('cabeceraPerfilador').set('html', htmlCabecera);
						$('cabecera2').set('html', htmlCabecera2);
						$('btnpaso1').set('html', nombreBoton);
						$('btnpaso1').set('title', nombreBoton);

						while (iter < 3) {
							iter++;
							listaVar
									.each(function(v) {
										if (v.nivel == iter) {
											var nombreB = 'bloque' + iter;
											var numeroIter = iter;
											var tipoComponente = 'tipo' + iter;
											if (v.codigoClasificacion == 40) {
												var opcH = 'opcionesHoriz1'
														+ iter;
												var nombreList = 'listaH'
														+ iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div><input id="'
														+ tipoComponente
														+ '" type="hidden" value="horizontal"></div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div>'
														+ '<div class="objScript"><div id="'
														+ opcH
														+ '" class="optiongroup perf">';

												// htmlBody1+='</div></div><span
												// class="textAdd">Recuerda que
												// tus opciones son
												// muchas</span><div
												// class="lineObj"></div><div
												// class="both"></div>';
												htmlBody1 += '</div></div><div class="lineObj"></div><div class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);
												var data = v.respuestasJson;
												upOptionGroup(data, nombreList,
														opcH);

												$(opcH)
														.addEvent(
																"click",
																function(e) {
																	actualizarComponentes(
																			numeroIter,
																			$(
																					nombreList)
																					.get(
																							"value"));
																});

											} else if (v.codigoClasificacion == 10) {
												var nombreSlider = 'vSlider'
														+ iter;
												var nombreValor = 'valorSlider'
														+ iter;
												var idConfiguracion = 'idConfig'
														+ iter;
												var rangoActual = 'rango'
														+ iter;
												var iterSlider = iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div><input id="'
														+ tipoComponente
														+ '" type="hidden" value="slider"><input id="'
														+ idConfiguracion
														+ '" type="hidden" value="'
														+ v.idVariablePerfilador
														+ '">'
														+ '<input id="'
														+ rangoActual
														+ '" type="hidden" value="0"> </div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div>'
														+ '<div class="objScript"><div class="content-slider"><div class="contentText"> <span>S/.</span><span class="valor-sl">'
														+ v.valor1
														+ '</span></div>'
														+ '<input type="hidden" class="input-sl" value="0" id="'
														+ nombreValor
														+ '">'
														+ '<div class="selector sl160" id="'
														+ nombreSlider
														+ '">'
														+ '<div class="sl-left"></div>'
														+ '<img alt="Simulador Monto para Vivienda - Interbank" class="sl-img" src="/halcon-theme/images/halcon/bkg_slider.jpg" style="clip: rect(0px, 0px, 10px, 0px);">'
														+ '<a class="knob" style="display:block;" title=""></a>'
														+ '<div class="sl-right"></div>'
														+ '</div></div><div class="both"></div></div>'
														+ '<span class="textAdd">Monto m&iacute;nimo S/. '
														+ format(v.valor1)
														+ '.00 Monto m&aacute;ximo S/. '
														+ format(v.valor2)
														+ '.00 a m&aacute;s.</span>'
														+ '<div class="lineObj"></div><div class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);

												var callback1 = function() {
													monto = $(nombreValor).get(
															"value");

													var obtenerRango = $("calcularRangoSliderHidden");

													var jsonRequest = new Request.JSON(
															{
																method : 'get',
																url : obtenerRango
																		.get("value"),
																data : {
																	'monto' : monto,
																	'iter' : iterSlider
																},
																onComplete : function(
																		response) {
																	if ($(
																			rangoActual)
																			.get(
																					"value") != response) {
																		$(
																				rangoActual)
																				.set(
																						"value",
																						response);
																		actualizarComponentes(
																				iterSlider,
																				response);
																	}
																}
															});
													jsonRequest.send();
													// actualizarComponentes(numeroIter,
													// monto);

												};

												selector2(nombreSlider,
														parseFloat(v.valor1),
														parseFloat(v.valor2),
														parseFloat(v.valor3),
														callback1,
														v.idRangoActual);

											} else if (v.codigoClasificacion == 20) {
												var nombreCombo = 'combo'
														+ iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div><input id="'
														+ tipoComponente
														+ '" type="hidden" value="combo"><input id="opcionCSeleccionada" type="hidden" value=""></div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div>'
														+ '<div class="objScript"><div id="document2" class="dropdown wt190"><div>Selecione</div></div></div>'
														+ '<div class="lineObj"></div><div class="both"></div>';
												// '<span
												// class="textAdd">Recuerda que
												// tus opciones son
												// muchas</span><div
												// class="lineObj"></div><div
												// class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);
												var data2 = v.respuestasJson;
												cbo = dropdownA2(data2,
														nombreCombo,
														"document2");
												cbo
														.addEvent(
																'xChange',
																function(item) {

																	var tipoDocSel = item
																			.get('valor');

																	if (tipoDocSel != '0') {
																		btnOn();
																		$(
																				opcionCSeleccionada)
																				.set(
																						'value',
																						item
																								.get('html'));
																	} else {
																		btnOff();
																	}
																	actualizarComponentes(
																			numeroIter,
																			tipoDocSel);
																});
												btnOff();

											} else if (v.codigoClasificacion == 30) {
												var nombreVertical = 'opcionVert'
														+ iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div class="content-body"><input id="'
														+ tipoComponente
														+ '" type="hidden" value="vertical">'
														+ '<input id="opcionVSeleccionada" type="hidden" value=""></div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div><div class="objScript"><div class="optPer"> </div></div>'
														+ '<div class="lineObj"></div>'
														+
														// '<span
														// class="textAdd">Recuerda
														// que tus opciones son
														// muchas</span><div
														// class="lineObj"></div>'
														// +
														'<div class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);
												var data = v.respuestasJson;
												optperfilador(data,
														nombreVertical,
														'btnpaso1');
												// optperfilador(data,
												// nombreVertical, 'btnpaso1',
												// 'div.bodyVertical2',
												// numeroIter);

												$$(".profile .item")
														.addEvent(
																"click",
																function(e) {
																	$(
																			opcionVSeleccionada)
																			.set(
																					'value',
																					this
																							.getElement(
																									'span')
																							.get(
																									'html'));
																	valor1 = $(
																			nombreVertical)
																			.get(
																					"value");
																	btnOn();
																	redimensionar();
																	actualizarComponentes(
																			numeroIter,
																			valor1);
																});
												btnOff();

											}

										}

									});
							redimensionar();
							// }
						}

					}
				});
		jsonRequest.send();
	}

}

function actualizarComponentes(iter, valorSeleccionado) {
	var actualizarPerfilador = $("actualizarPerfiladorHidden");
	var tipoPerfiladorPortal = $("tipoPerfilador");

	var jsonRequest = new Request.JSON(
			{
				method : 'get',
				url : actualizarPerfilador.get("value"),
				data : {
					'valSeleccionado' : valorSeleccionado,
					'nivelActual' : iter,
					'tipoPerfilador' : tipoPerfiladorPortal
				},
				onComplete : function(response) {
					if (response == null || response == undefined ){
						return;
					}
					
					var ultimoIter = 0;
					var listaVar = null;
					if(response.listaVar != undefined){
						listaVar = response.listaVar;
					}					 
					if (listaVar == null
							|| listaVar.length == 0) {
						// if(iter==1){
						// btnOff();
						// }
						while (iter < 3) {
							var nombreBloque = 'bloque' + (++iter);
							$(nombreBloque).set('html', '');

						}

					} else {
						while (iter < 3) {

							iter++;
							listaVar.each(function(v) {
										if (v.nivel == iter) {
											ultimoIter = iter;
											var nombreB = 'bloque' + iter;
											var numeroIter = iter;
											var tipoComponente = 'tipo' + iter;

											if (v.codigoClasificacion == 40) {

												var opcH = 'opcionesHoriz1'
														+ iter;
												var nombreList = 'listaH'
														+ iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div><input id="'
														+ tipoComponente
														+ '" type="hidden" value="horizontal"></div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div>'
														+ '<div class="objScript"><div id="'
														+ opcH
														+ '" class="optiongroup perf">';

												// htmlBody1+='</div></div><span
												// class="textAdd">Recuerda que
												// tus opciones son
												// muchas</span><div
												// class="lineObj"></div><div
												// class="both"></div>';
												htmlBody1 += '</div></div><div class="lineObj"></div><div class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);
												var data = v.respuestasJson;
												upOptionGroup(data, nombreList,
														opcH);

												$(opcH)
														.addEvent(
																"click",
																function(e) {
																	actualizarComponentes(
																			numeroIter,
																			$(
																					nombreList)
																					.get(
																							"value"));
																});

											} else if (v.codigoClasificacion == 10) {

												var nombreSlider = 'vSlider'
														+ iter;
												var nombreValor = 'valorSlider'
														+ iter;
												var idConfiguracion = 'idConfig'
														+ iter;
												var rangoActual = 'rango'
														+ iter;
												var iterSlider = iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div><input id="'
														+ tipoComponente
														+ '" type="hidden" value="slider"><input id="'
														+ idConfiguracion
														+ '" type="hidden" value="'
														+ v.idVariablePerfilador
														+ '">'
														+ '<input id="'
														+ rangoActual
														+ '" type="hidden" value="'
														+ response.rangoActual
														+ '"> </div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div>'
														+ '<div class="objScript"><div class="content-slider"><div class="contentText"> <span>S/.</span><span class="valor-sl">'
														+ v.valor1
														+ '</span></div>'
														+ '<input type="hidden" class="input-sl" value="" id="'
														+ nombreValor
														+ '">'
														+ '<div class="selector sl160" id="'
														+ nombreSlider
														+ '">'
														+ '<div class="sl-left"></div>'
														+ '<img alt="Simulador Monto para Vivienda - Interbank" class="sl-img" src="/halcon-theme/images/halcon/bkg_slider.jpg" style="clip: rect(0px, 0px, 10px, 0px);">'
														+ '<a class="knob" style="display:block;" title=""></a>'
														+ '<div class="sl-right"></div>'
														+ '</div></div><div class="both"></div></div>'
														+ '<span class="textAdd">Monto m&iacute;nimo S/. '
														+ format(v.valor1)
														+ '.00 Monto m&aacute;ximo S/. '
														+ format(v.valor2)
														+ '.00 a m&aacute;s.</span>'
														+ '<div class="lineObj"></div><div class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);

												var callback1 = function() {
													monto = $(nombreValor).get(
															"value");

													var obtenerRango = $("calcularRangoSliderHidden");

													var jsonRequest = new Request.JSON(
															{
																method : 'get',
																url : obtenerRango
																		.get("value"),
																data : {
																	'monto' : monto,
																	'iter' : iterSlider
																},
																onComplete : function(
																		response) {
																	if ($(
																			rangoActual)
																			.get(
																					"value") != response) {
																		$(
																				rangoActual)
																				.set(
																						"value",
																						response);
																		actualizarComponentes(
																				iterSlider,
																				response);
																	}
																}
															});
													jsonRequest.send();

												};

												selector2(nombreSlider,
														parseFloat(v.valor1),
														parseFloat(v.valor2),
														parseFloat(v.valor3),
														callback1,
														v.idRangoActual);

											} else if (v.codigoClasificacion == 20) {
												var nombreCombo = 'combo'
														+ iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div><input id="'
														+ tipoComponente
														+ '" type="hidden" value="combo"><input id="opcionCSeleccionada" type="hidden" value=""></div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div>'
														+ '<div class="objScript"><div id="document2" class="dropdown wt190"><div>Selecione</div></div></div>'
														+ '<div class="lineObj"></div><div class="both"></div>';
												// '<span
												// class="textAdd">Recuerda que
												// tus opciones son
												// muchas</span><div
												// class="lineObj"></div><div
												// class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);
												var data2 = v.respuestasJson;
												cbo = dropdownA2(data2,
														nombreCombo,
														"document2");
												cbo
														.addEvent(
																'xChange',
																function(item) {
																	var tipoDocSel = item
																			.get('valor');

																	if (tipoDocSel != '0') {
																		btnOn();
																		$(
																				opcionCSeleccionada)
																				.set(
																						'value',
																						item
																								.get('html'));
																	} else {
																		btnOff();
																	}
																	actualizarComponentes(
																			numeroIter,
																			tipoDocSel);

																});
												btnOff();

											} else if (v.codigoClasificacion == 30) {
												var nombreVertical = 'opcionVert'
														+ iter;
												$(nombreB).setStyle('display',
														'block');
												var htmlBody1 = '<div class="content-body"><input id="'
														+ tipoComponente
														+ '" type="hidden" value="vertical">'
														+ '<input id="opcionVSeleccionada" type="hidden" value=""></div></div>'
														+ '<div class="title">'
														+ v.nombre
														+ '</div><div class="objScript"><div class="optPer"> </div></div>'
														+
														// '<span
														// class="textAdd">Recuerda
														// que tus opciones son
														// muchas</span><div
														// class="lineObj"></div>'
														// +
														'<div class="lineObj"></div>'
														+ '<div class="both"></div>';
												$(nombreB).set('html',
														htmlBody1);

												var data = v.respuestasJson;
												optperfilador(data,
														nombreVertical,
														'btnpaso1');
												// optperfilador(data,
												// nombreVertical, 'btnpaso1',
												// 'div.bodyVertical2',
												// numeroIter);

												$$(".profile .item")
														.addEvent(
																"click",
																function(e) {
																	valor1 = $(
																			nombreVertical)
																			.get(
																					"value");
																	$(
																			opcionVSeleccionada)
																			.set(
																					'value',
																					this
																							.getElement(
																									'span')
																							.get(
																									'html'));
																	btnOn();
																	redimensionar();
																	actualizarComponentes(
																			numeroIter,
																			valor1);
																});
												btnOff();

											} else {
												$(nombreB).set('html', '');
											}

										}

									});
							redimensionar();
						}

						// rellenar con vacios

						while (ultimoIter < 3) {
							var nombreB = 'bloque' + (++ultimoIter);
							$(nombreB).set('html', '');
						}

					}

				}
			});
	jsonRequest.send();

}


var enviarPerfilador = function() {
	var utms = getUrlVarUTM();

	var metodoEnvioPerfilador = $("enviarPerfiladorHidden");
	var tipo1 = '';
	var tipo2 = '';
	var tipo3 = '';
	var tipo4 = '';
	var valor1 = '';
	var valor2 = '';
	var valor3 = '';
	var valor4 = '';
	var monto = '';
//	var motivacion = '';
	var exito = '1';
	var idConfiguracion = '';
	var preg1 = '';
	var preg2 = '';
	var preg3 = '';
	var preg4 = '';
	var resp1 = '';
	var resp2 = '';
	var resp3 = '';
	var resp4 = '';

	if ($("tipo1") != null) {
		tipo1 = $("tipo1").get("value");
		var nombreComp = '';
		var tt = $$('#bloque1 div.title');
		preg1 = tt.get("html");

		if (tipo1 == 'horizontal') {
			nombreComp = 'listaH1';
			resp1 = $$(".perf");
			resp1 = resp1.getChildren(".active-op")[0][0];
			resp1 = resp1.get("html");

		} else if (tipo1 == 'vertical') {
			nombreComp = 'opcionVert1';
			resp1 = $(opcionVSeleccionada).get('value');

		} else if (tipo1 == 'combo') {
			nombreComp = 'combo1';
			resp1 = $(opcionCSeleccionada).get('value');

		} else if (tipo1 == 'slider') {
			nombreComp = 'valorSlider1';
			resp1 = $(nombreComp).get("value");
			monto = resp1; 
			idConfiguracion = $('idConfig1').get("value");
		}
		valor1 = $(nombreComp).get("value");

		if (valor1 == '' || valor1 == '0') {
			exito = '0';
		}

	}
	if ($("tipo2") != null) {
		tipo2 = $("tipo2").get("value");
		var nombreComp = '';
		var tt = $$('#bloque2 div.title');
		preg2 = tt.get("text");

		if (tipo2 == 'horizontal') {
			nombreComp = 'listaH2';		
			resp2 = $$(".perf");
			resp2 = resp2.getChildren(".active-op")[0][0];
			resp2 = resp2.get("html");

		} else if (tipo2 == 'vertical') {
			nombreComp = 'opcionVert2';
			resp2 = $(opcionVSeleccionada).get('value');

		} else if (tipo2 == 'combo') {
			nombreComp = 'combo2';
			resp2 = $(opcionCSeleccionada).get('value');

		} else if (tipo2 == 'slider') {
			nombreComp = 'valorSlider2';
			idConfiguracion = $('idConfig2').get("value");
			resp2 = $(nombreComp).get("value");
			monto = resp2; 
		}
		valor2 = $(nombreComp).get("value");

		if (valor2 == '' || valor2 == '0') {
			exito = '0';
		}
	}
	if ($("tipo3") != null) {
		tipo3 = $("tipo3").get("value");
		var nombreComp = '';
		var tt = $$('#bloque3 div.title');
		preg3 = tt.get("text");

		if (tipo3 == 'horizontal') {
			nombreComp = 'listaH3';
			resp3 = $$(".perf");
			resp3 = resp3.getChildren(".active-op")[0][0];
			resp3 = resp3.get("html");

		} else if (tipo3 == 'vertical') {
			nombreComp = 'opcionVert3';
			resp3 = $(opcionVSeleccionada).get('value');

		} else if (tipo3 == 'combo') {
			nombreComp = 'combo3';
			resp3 = $(opcionCSeleccionada).get('value');

		} else if (tipo3 == 'slider') {
			nombreComp = 'valorSlider3';
			resp3 = $(nombreComp).get("value");
			idConfiguracion = $('idConfig3').get("value");
			monto = resp3; 
		}
		valor3 = $(nombreComp).get("value");

		if (valor3 == '' || valor3 == '0') {
			exito = '0';
		}

	}
	
	if ($("tipo4") != null) {
		tipo3 = $("tipo4").get("value");
		var nombreComp = '';
		var tt = $$('#bloque4 div.title');
		preg3 = tt.get("text");

		if (tipo3 == 'horizontal') {
			nombreComp = 'listaH4';	
			resp4 = $$(".perf");
			resp4 = resp4.getChildren(".active-op")[0][0];
			resp4 = resp4.get("html");

		} else if (tipo4 == 'vertical') {
			nombreComp = 'opcionVert4';
			resp3 = $(opcionVSeleccionada).get('value');

		} else if (tipo4 == 'combo') {
			nombreComp = 'combo4';
			resp3 = $(opcionCSeleccionada).get('value');

		} else if (tipo4 == 'slider') {
			nombreComp = 'valorSlider4';
			resp3 = $(nombreComp).get("value");
			idConfiguracion = $('idConfig4').get("value");
			monto = resp3; 
		}
		valor4 = $(nombreComp).get("value");

		if (valor4 == '' || valor4 == '0') {
			exito = '0';
		}
	}

	if (exito == '1') {
		var jsonRequest = new Request.JSON(
				{
					method : 'post',
					url : metodoEnvioPerfilador.get("value"),
					data : {
						'tipo1' : tipo1,
						'tipo2' : tipo2,
						'tipo3' : tipo3,
						'tipo4' : tipo4,
						'valor1' : valor1,
						'valor2' : valor2,
						'valor3' : valor3,
						'valor4' : valor4,
						'monto' : monto,
//						'motivacion' : motivacion,
						'stringUTM' : utms,
						'idConfiguracion' : idConfiguracion,
						'preg1' : preg1,
						'preg2' : preg2,
						'preg3' : preg3,
						'preg4' : preg4,
						'resp1' : resp1,
						'resp2' : resp2,
						'resp3' : resp3,
						'resp4' : resp4
					},
					onComplete : function(response) {
						var html = '';
						var total = response.length;
						var i = 0;
						response
								.each(function(p) {
									html += '<div class="item"> <div class="col1"> <h2>'
											+ p.nombre
											+ '</h2> <br class="both"><p><img src="'
											+ p.urlImagen
											+ '" alt="' + p.nombre + '" name="'+ p.nombre  +'" width="76" height="69" class="img-perfilador">'
											+ p.descripcion;
									if (p.flagSimulador) {
										//<a onClick=\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Ver detalle\" , \""+ p.nombre +"\"])\" href=\"http://localhost:8090/ahorro-techo\" class=\"btn btncredit btnsmall button btnSimular\">Simular</a>

										html += '<br> <a onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Ver detalle\", \""+ p.nombre +"\"])" href="'
												+ p.linkDetalle
												+ '">Ver Detalle</a> </p> </div> <div class="both"></div> ';
										if (p.urlSolicitud != null) {
											html += '<a onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Simular\", \""+ p.nombre +"\"])" href="'
													+ p.urlSimulador 
													+ '" class="btn btncredit btnsmall button btnSimular">Simular</a> <a '
													+ ' onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Solicitar producto\", \""+ p.nombre +"\"])" href="'
													+ p.urlSolicitud 
													+ '" class="btn btncredit btnmediun">Solicitar producto</a><div class="both"></div> ';
										} else {
											html += '<a onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Simular\", \""+ p.nombre +"\"])" '
													+' id="btnSimular2" class="btn btnreply btnSimular" href="'
													+ p.urlSimulador + 
													+ '">Simular</a><div class="both"></div>';
										}
									} else {
										if (p.urlSolicitud != null) {
											html += '<br> <a onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Ver detalle\", \""+ p.nombre +"\"])" href="'
													+ p.linkDetalle
													+ '">Ver Detalle</a> </p> </div> <div class="both"></div> ';
											html += '<a onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Solicitar producto\", \""+ p.nombre +"\"])" class="btn btnreply" href="'
													+ p.urlSolicitud
													+ '">Solicitar producto</a><div class="both"></div>';
										} else {
											html += '</p> </div> <div class="both"></div> ';
											html += '<a onClick="\"_gaq.push([\"_trackEvent\", \"Perfiladores\", \"Ver detalle\", \""+ p.nombre +"\"])" class="btn btnreply" href="'
													+ p.linkDetalle
													+ '">M\u00E1s informaci\u00F3n</a><div class="both"></div>';
										}
									}
									// if(p.urlSolicitud == ''){
									// html += '<a href="#" id="btnSimular"
									// class="btn btncredit btnsmall
									// button">Simular</a> <a href="' +
									// p.urlSolicitud + '" class="btn btncredit
									// btnmediun">Solicitar producto</a><div
									// class="both"></div> ';
									//						
									// } else {
									// html += '<a class="btn btnreply" href="'
									// + p.urlSolicitud + '">Solicitar
									// producto</a><div class="both"></div>';
									// }
									html += '</div>';
									if (++i < total) {
										html += '<span class="line"></span>';
									}

								});
						$("resultadoProducto").set('html', html);
//						simularCredito();
					}
				});
		
		jsonRequest.send();

	}
	return exito;
};


//$$('.cntObjPerfilador').addEvent(
//		'mouseenter',
//		function() {
//			var contentSlider = this.getElement('.knob');
//			if (contentSlider) {
//				var valSlider = this.getElement('.valor-sl').get('text');
//				this.getElement('.knob').addEvent('mouseenter', function() {
//					this.set('title', 'S/.' + valSlider);
//				})
//
//				this.getElement('.knob').addEvent(
//						'mouseleave',
//						function() {
//							this.getParent().getParent().getParent()
//									.getParent().fireEvent('mouseenter');
//						})
//
//			}
//		});

function redimensionar() {
	// Redimension de Div Padre
	$('perfil').setStyle('margin-bottom', 10);
	var paso1 = $('paso1').getSize().y;
	var heightBody = $('paso1').getElement('.body').getSize().y;

	if (paso1 > 507) {
		$('perfil').setStyle('height', paso1);
		$('paso2').setStyle('height', paso1);
		$('paso2').getElement('.body').setStyle('height', heightBody);
	} else {
		$('perfil').setStyle('height', 507);
		$('paso1').getElement('.body').setStyle('height', 463);
		$('paso2').setStyle('height', 507);
		$('paso2').getElement('.body').setStyle('height', 450);
	}
}

function getUrlVarUTM() {
	var vars = {};
	var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
			function(m, key, value) {
				vars[key] = value;
			});
	return vars;
}

function btnOn() {
	$$('.btn').fade(1);
}

function btnOff() {
	$$('.btn').fade(0.5);
}
// btnOff();
