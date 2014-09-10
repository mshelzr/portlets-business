
var map = null;
var markersArray = new Array();
var infoWindowArray = new Array();
var ref = null;
var msg = null;
var codigoDistrito=0;
var selectPag = 1; 

function loadScript() {
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "http://maps.google.com/maps/api/js?sensor=true&callback=initialize";
	document.body.appendChild(script);
}

function initialize() {
	var latlng = new google.maps.LatLng(-12.094518, -77.034901);
	var myOptions = {
		zoom : 12,
		center : latlng,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	};
	map = new google.maps.Map(document.getElementById("gmap"), myOptions);
}

function addMarker(tipo, location, res, globo) {
	var marker = new google.maps.Marker({
		position : location,
		icon : globo
	});
	marker.setMap(map);

	creaInfoWindowTiendas(res, globo, marker);

}


function creaInfoWindowTiendas( res, globo, marker) {
	
	var ico = res.etiquetaImg;
	var titulo = res.titulo;
	var direccion = res.direccion;
	var telefono = res.telefono;
	var horario = res.horario;

	ico = "/BuscarTienda-portlet/img/globo-" + ico;
	var contentMap = " <div class='interactive-cloud'>  " + "<div class='glogo'> <img src=" + ico + " alt='logo'> </div>  " + "<div class='content'>" + "      <h5>" + titulo + "</h5> " + "      <p> " + direccion + "<br /> " + horario + "<br /> " + telefono + " </p> " + "        </div> " + "          </div>";

	var infowindow = new google.maps.InfoWindow();
	infowindow.setContent(contentMap);
	google.maps.event.addListener(marker, 'click', function() {
		closeAllInfoWindow();
		infowindow.open(map, marker);
	});

	if (ref != null) {
		ref.addEvent('mouseenter', function() {
			closeAllInfoWindow();
			infowindow.open(map, marker);
		});
	}

	markersArray.push(marker);
	infoWindowArray.push(infowindow);

}

function closeAllInfoWindow() {
	if (infoWindowArray) {
		for ( var i = 0; i < infoWindowArray.length; i++) {
			infoWindowArray[i].close();
		}
	}
}

function deleteOverlays() {
	if (markersArray) {
		if (markersArray.length > 0) {
			for ( var i = 0; i < markersArray.length; i++) {
				markersArray[i].setMap(null);
			}
			markersArray.length = 0;
		}
	}
}

function cargarPosicion(tipo, res, globo) {
	var lg = parseFloat(res.longitud);
	var lt = parseFloat(res.latitud);
	/**
	 * //deleteOverlays(); con esto borro todos los markers del mapa
	 */
	if ((lg != null || lg != "") && (lt != null && lt != "") && (!isNaN(lt) && !isNaN(lg))) {
		var myLatlng = new google.maps.LatLng(lt, lg);
		addMarker(tipo, myLatlng, res, globo);
	}
}

function centarMapa(longitud, latitud) {
	var l = new google.maps.LatLng(latitud, longitud);
	map.setCenter(l);
}


function mapaTotal() {
	var bounds = new google.maps.LatLngBounds();
	if (markersArray) {
		if (markersArray.length == 1) {
			var mak = markersArray[0];
			var mapaMarke = mak.map;
			if (mapaMarke != null) {	
				var array = Object.keys(mak.position).map(function(key) {
				    return {"type" : key, "name" : mak.position[key] };
				});															
				var lat = array[0].name;
				var lng = array[1].name;
				var latlng = new google.maps.LatLng(lat, lng);
				bounds.extend(latlng);				
			}
		}
		
		if (markersArray.length > 1) {
			for ( var i = 0; i < markersArray.length; i++) {
				var mak = markersArray[i];
				var mapaMarke = mak.map;
				if (mapaMarke != null) {	
					var array = Object.keys(mak.position).map(function(key) {
					    return {"type" : key, "name" : mak.position[key] };
					});															
					var lat = array[0].name;
					var lng = array[1].name;
					var latlng = new google.maps.LatLng(lat, lng);
					bounds.extend(latlng);
				}
			}
			map.setCenter(bounds.getCenter());
			map.fitBounds(bounds);
		}
		if (markersArray == null || markersArray.length == 0) {
			var latlng = new google.maps.LatLng(-12.094518, -77.034901);
			map.setCenter(latlng);
		}

	}
}

function cargarEventoCheckCanal() {

	var checks = $$("input[name=checkTipoLocal]");
	checks.addEvent("change", function() {
//		alert("check");
		var cboDistritoHidden = $("cboDistritoHidden");
		msg.setStyle("display","none"); 
		limpiarPaginacion();		
		if (cboDistritoHidden != null) {
			cboDistritoHidden = $("cboDistritoHidden").value;
			if (cboDistritoHidden != undefined && cboDistritoHidden != null && cboDistritoHidden != "" && cboDistritoHidden != 0 && cboDistritoHidden > 0 && (checkvalidate(checks)>0) ) {
//				alert(1);
				var obtListaSucursales = $("obtLstSucursales").get('value');
				msg.setStyle("display","none");
				paginarLista("formTiendas", "listaResultados", "paginador", 1, 10, obtListaSucursales, manipularRegistros, "lstSucursales");				
			}else{
//				alert("2");
				limpiarPaginacion();
			}
		}

	});
	
}


function limpiarPaginacion(){
	var listaResultados = $("listaResultados");
	var paginador = $("paginador");
	if(listaResultados!=null){
		listaResultados.dispose();
	}
	if(paginador!=null){
		paginador.dispose();
	}

	var checkTipoLocal = $$("input[name=checkTipoLocal]");

	if(codigoDistrito>0 &&  checkvalidate(checkTipoLocal)>0 ){
		msg.setStyle("display","block"); 		
	}else{
		msg.setStyle("display","none"); 	
	}	
	
}

function checkvalidate(checks) {
	var count = 0;
    for (var i = 0; lcheck = checks[i]; i++) {
        if (lcheck.checked) {
        	count++;
        }
    }
    return count;
}

function cargarEventoClickDepartamento(cbo) {
	cbo.addEvent('xChange', function(item) {// con el evento xChange se obtiene
		// el valor del departamento
		var valor = item.get('valor');
		var cboProvincias = filtrarJson3('get', "/GestionParametros-portlet/js/resources/provincia_tiendas.json", "id_departamento", "cboprovinciaHidden", "cboprovincia", valor);// se
		// genera
		// el
		// combo
		// de
		// provincias
		// del
		// departamento
		// selecionado
		// console.log(valor);
		// console.log(cboProvincias);
		
		var list =  $(document.body).getElement("div#listcboDistritoHidden.droplist") || false ;
		
		if(list){
			$("cboDistrito").getElement("div").set("html","Seleccione");
			$("cboDistrito").getElement("input").set("value","0");
			list.set('html','');
		}
		codigoDistrito = 0;		
		cargarEventoClickProvincia(cboProvincias);// se envia el combo de
		// provincias para generar
		// el evento
	});

}

function cargarEventoClickProvincia(cbo) {

	cbo.addEvent('xChange', function(item) {// se obtiene el valor seleccionado
		// y envia el distrito
		var valor = item.get('valor');
		var cboDistritos = filtrarJson3('get', "/GestionParametros-portlet/js/resources/distrito_tiendas.json", "id_provincia", "cboDistritoHidden", "cboDistrito", valor);// al
		// genera 
		// le
		// combo
		// de
		// distrito
		// se
		// solo
		// queda
		// asignar
		// el
		// evento
		// para
		// obetener
		// las
		// tiendas
		cargarEventoClickDistrito(cboDistritos);// se le asigna el evento
		codigoDistrito = 0;
	});

}

function generarCodigoDistrito() {
	codigoDistrito = 0;
	var dep = $("cbodepartamentoHidden").value;
	var prov = $("cboprovinciaHidden").value;
	var distri = $("cboDistritoHidden").value;
	if (dep.length == 1) {
		dep = "0" + dep;
	}
	if (prov.length == 3 || prov.length == 4) {
		prov = prov.substring(prov.length - 2, prov.length);
	}
	if (distri.length == 1) {
		distri = "0" + distri;
	}
	codigoDistrito = dep + prov + distri;
	$("cboDistritoHidden").value = codigoDistrito;
}

function cargarEventoClickDistrito(cbo) {
	cbo.addEvent('xChange', function(item) {// añl selecionar el evento se
		// obtiene el distrito y se lanza el
		// evento
//		var valor = item.get('valor');
		deleteOverlays();// limipia los markers
		generarCodigoDistrito();// genera el codigo ubigeo donde une
		// departamento provincia y distrito
		var obtListaSucursales = $("obtLstSucursales").get('value');// obtiene
		// el valor
		// generado
		
		var checkTipoLocal = $$("input[name=checkTipoLocal]");
//		console.log(checkTipoLocal);
		
		if(checkvalidate(checkTipoLocal)>0){
			paginarLista("formTiendas", "listaResultados", "paginador", 1, 10, obtListaSucursales, manipularRegistros, "lstSucursales");// hace
			// el
			// filtrado
			// donde
			// el
			// resultado
			// es
			// paginado
			// segun
			// el
			// filtrado
		}else{
			limpiarPaginacion();
		}
		
		
	});
}
/**
 * el formulario donde se ubica la paginacion la lista la cual se genera el
 * paginador cantida de filas la url el metodo que se le asigna para poner
 * manipular el json obtenido sin romper el paginado y el atributo de la cual se
 * obtiene el json y almacena la lista
 * 
 */
function paginarLista(form, list, pagtor, paginaInicio, cantidadFilas, url, callBack, atributoRespuesta) {
//	alert("paginarLista");
	var formualrio = $(form);
	var listaResultados = $(list);
	if (listaResultados == null) {
		listaResultados = new Element("div", {
			id : list,
			'class' : "list"
		});
		formualrio.appendChild(listaResultados);
	}

	var paginador = $(pagtor);
	if (paginador == null) {
		paginador = new Element("div", {
			id : pagtor,
			'class' : "paginator wd120p"
		});
		formualrio.appendChild(paginador);
	}
	var listaPaginas = $(pagtor + "paginas");
	if (listaPaginas == null) {
		listaPaginas = new Element("div", {
			id : pagtor + "paginas"
		});
		paginador.appendChild(listaPaginas);
		var br = new Element("div", {
			'class' : "both"
		});
		paginador.appendChild(br);

		var div = new Element("div", {
			id : list + "pageNavPosition",
			'class' : "pageNavPosition"
		});
		paginador.appendChild(div);
	}

	var instantPaginas = $(pagtor + "instantPaginas");
	if (instantPaginas == null) {
		instantPaginas = new Element("div", {
			id : pagtor + "instantPaginas",
			style : "display: none;"
		});
		paginador.appendChild(instantPaginas);
	}

	var inputpaginaIntant = $(pagtor + "pagina");
	if (inputpaginaIntant == null) {
		inputpaginaIntant = new Element("input", {
			id : pagtor + "pagina",
			name : "pagina",
			'class' : "pagina"
		});
		instantPaginas.appendChild(inputpaginaIntant);
	}
	inputpaginaIntant.value = paginaInicio;

	var inputfilasIntant = $(pagtor + "filas");
	if (inputfilasIntant == null) {
		inputfilasIntant = new Element("input", {
			id : pagtor + "filas",
			name : "filas",
			'class' : "pagina"
		});
		instantPaginas.appendChild(inputfilasIntant);
	}
	inputfilasIntant.value = cantidadFilas;

	var data = formualrio.toQueryString();
//	var html = "";

	loadform();

	var jsonRequest = new Request.JSON({
		method : 'get',
		url : url,
		data : data,
		noCache : true,
		async : false,
		onComplete : function(response) {
			closeloadform();
			if (response != null) {

				listaResultados.set("html", "");

				listaPaginas.set("html", "");

				callBack(listaResultados, response[atributoRespuesta]);

				var numeroPaginas = response.total;
				if (numeroPaginas > 0) {

					var lp = ' <a id="btnpagAntes" href="javascript:void(0);" title="retrocede"  class="btn-pag btnpagAntes">&lt;</a>';
					if (paginaInicio == 1) {
						if (numeroPaginas != undefined && numeroPaginas > 0) {
							lp += '<a href="javascript:void(0);" class="eventPaginado active" title="1">1</a>';
							if (numeroPaginas > 1) {
								for ( var ipag = 2; ipag < numeroPaginas + 1; ipag++) {
									lp += '<a href="javascript:void(0);" class="eventPaginado " title="' + ipag + '"  >' + ipag + '</a> ';
								}
							}
						}
					} else {
						if (numeroPaginas != undefined && numeroPaginas > 0) {
							lp += '<a href="javascript:void(0);" class="eventPaginado" title="1">1</a>';
							if (numeroPaginas > 1) {
								for ( var ipagina = 2; ipagina < numeroPaginas + 1; ipagina++) {
									lp += '<a href="javascript:void(0);" class="eventPaginado " title="' + ipagina + '"  >' + ipagina + '</a> ';
								}
							}
						}
					}

					lp += '<a id="btnpagSiguiente" href="javascript:void(0);" class="btn-pag btnpagSiguiente" title="siguiente" >&gt;</a>';
					listaPaginas.set("html", lp);

					var classEvent = listaPaginas.getElements(".eventPaginado");

					var btnpagAntes = listaPaginas.getElement(".btnpagAntes");					
					var btnpagSiguiente = listaPaginas.getElement(".btnpagSiguiente");
																	
					classEvent.addEvent("click", function() {
						var paginaSelect = this;
						classEvent.set("class", "eventPaginado");
						paginaSelect.set("class", "eventPaginado active");	
						selectPag = paginaSelect.title;		
						inputpaginaIntant.set("value", selectPag );
						paginarLista(form, list, pagtor, inputpaginaIntant.get("value"), cantidadFilas, url, callBack, atributoRespuesta);
					});
					classEvent.set("class", "eventPaginado");
					classEvent.each(function(item) {
						var pg = item;
						if (pg.title == paginaInicio) {
							pg.set("class", "eventPaginado active");
						}
					});
					
					btnpagAntes.addEvent("click", function() {
						if(selectPag>1&&selectPag<=numeroPaginas){
							selectPag--;
							var paginaSelect =null;
							inputpaginaIntant.set("value",selectPag);
							classEvent.set("class", "eventPaginado");	
							var pag = 0;
							for ( var i = 0; i < classEvent.length; i++) {								
								pag = classEvent[i];
								if(pag.title == selectPag ){
									paginaSelect = pag;						
									paginaSelect.set("class", "eventPaginado active");
									paginarLista(form, list, pagtor, inputpaginaIntant.get("value"), cantidadFilas, url, callBack, atributoRespuesta);
								}
							}
						}
					});

					btnpagSiguiente.addEvent("click", function() {
						if(selectPag>0&&selectPag<numeroPaginas){
							selectPag++;
							var paginaSelect =null;
							inputpaginaIntant.set("value",selectPag);
							classEvent.set("class", "eventPaginado");	
							var pag = 0;
							for ( var i = 0; i < classEvent.length; i++) {								
								pag = classEvent[i];
								if(pag.title == selectPag ){
									paginaSelect = pag;						
									paginaSelect.set("class", "eventPaginado active");
									paginarLista(form, list, pagtor, inputpaginaIntant.get("value"), cantidadFilas, url, callBack, atributoRespuesta);
								}
							}
						}
					});					
				}
			}
		}
	});
	jsonRequest.send();
}

// manipulo los registros del josn obtenidos
function manipularRegistros(content, result) {
//	alert("manipularRegistros");
	var html = "";
	var checkTipoLocal = $$("input[name=checkTipoLocal]");
	deleteOverlays();
	if (result != null || result != undefined  ) {		
		if(result.length > 0){
			msg.setStyle("display","none");
			result.each(function(res) {
				var d = ' <div class="trlist" id="trlist-' + res.id + '" >	' + ' <div class="ico"><img src="/BuscarTienda-portlet/img/ico-interbank.gif" border="0" width="20" height="20" /></div>	' + ' <div class="wrapper-list" style="width:215px;">	' + ' <h3 style="width: 134px;" >' + res.titulo + '</h3>		' + ' <p  style="width: 134px;">' + res.direccion + ' </p>	' + '<em><img src="/BuscarTienda-portlet/img/globo-' + res.etiquetaImg + '" border="0"  height="14" /> </em>' + '  <br class="both" /></div> ' + ' <span>			'
						+ ' <input type="hidden" class="longitud" value="' + res.longitud + '" >	' + ' <input type="hidden" class="latitud" value="' + res.latitud + '" >		' + ' <input type="hidden" class="titulo" value="' + res.titulo + '" >		' + ' <input type="hidden" class="descripcion" value="' + res.horario + '" > ' + ' <input type="hidden" class="direccion" value="' + res.direccion + '" > ' + ' <input type="hidden" class="telefono" value="' + res.telefono + '" > '
						+ ' <input type="hidden" class="ico" value="' + res.ico + '" >		' + ' </span>		' + ' <br class="both" /> </div>';
				html = html + d;
			});
			content.set("html", html);// asigno el html al contenedor de la lista

			result.each(function(res) {
				var id = "trlist-" + res.id;
				var registro = $(id);
				ref = registro;// Me asigna el evento click para mostrar la info
				cargarPosicion(1, res, "/BuscarTienda-portlet/img/ico-interbank.gif");// cargo
				// las
				// posiciones
				// en
				// el
				// mapa
			});

			cargarGEOSucursales();
		}else{
//			console.log(checkTipoLocal);
//			alert(" 1 --------------- result.length 0  ");
//			alert( " 11: " + checkTipoLocal);
//			alert( " 11: " + codigoDistrito);
//			alert(" 1 --------------- result.length 0 ");
			if(checkvalidate(checkTipoLocal)>0){
				if(codigoDistrito>0){
					msg.setStyle("display","block");
					return;
				}			
			}	
			msg.setStyle("display","none");	
		}
	}else{
//		alert(" 2 --------------- result.length 1 ");
//		alert( " 22: " + checkTipoLocal);
//		alert( " 22: " + codigoDistrito);
//		alert(" 2 --------------- result.length 1 ");
		if(checkvalidate(checkTipoLocal)>0){
			if(codigoDistrito>0){
				msg.setStyle("display","block");
				return;
			}			
		}	
		msg.setStyle("display","none");	
	}
}

function cargarGEOSucursales() {
	$("listaResultados").setStyle('cursor', 'pointer');
	$("listaResultados").getElements(".trlist").each(function(el) {
		el.addEvent('mouseenter', function(event) {
			$("listaResultados").getElements(".trlist").removeClass('active');
			this.addClass('active');
			var span = this.getElement('span');
			var longitud = span.getElement(".longitud");
			longitud = longitud.value;
			var latitud = span.getElement(".latitud");
			latitud = latitud.value;
			var titulo = span.getElement(".titulo");
			titulo = titulo.value;
			var direccion = span.getElement(".direccion");
			direccion = direccion.value;
			var descripcion = span.getElement(".descripcion");
			descripcion = descripcion.value;
			var telefono = span.getElement(".telefono");
			telefono = telefono.value;
//			var ico = "ico-interbank.gif";
			if ((longitud != null || longitud != "") && (latitud != null && latitud != "") && (!isNaN(latitud) && !isNaN(longitud))) {
				centarMapa(longitud, latitud);// centro la ubicacion
			}
		});
	});
	mapaTotal();
}

function cargarEventosTiendas() {
	
	var cbo = getdata5("/GestionParametros-portlet/js/resources/departamento_tiendas.json", "cbodepartamentoHidden", "cbodepartamento");// Al
	// obtener 
	// el
	// combo
	// no
	// es
	// necesario
	// obenerlo
	// nuevamente
	cargarEventoClickDepartamento(cbo);// se genera su evento enviando el combo
	// de departamento
	cargarEventoCheckCanal();// Se asigna el Evento de Check si hay algun
	// distrito selecciona para poder lanzar el
	// evneto de filtrado contra el servidor
}

window.addEvent("domready", function(e) {
	msg = $("MENSAJE_SIN_RESULTADOS");
	cargarEventosTiendas();// Para la pestaña de Tiendas
	loadScript();
});
