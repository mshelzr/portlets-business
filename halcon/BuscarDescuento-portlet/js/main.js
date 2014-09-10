var map = null;
var markersArray = new Array();
var infoWindowArray = new Array();
var ref = null;
var msg = null;
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
		creaInfoWindowDescuentos(res, globo, marker);

}

function onVerDescuento(id){
	var btnDescuentos=$("box"+id);
	btnDescuentos.click();
}

function creaInfoWindowDescuentos(res, globo, marker) {
	var ico = res.globo_etiquetaImg;
	var titulo = res.titulo;
	var direccion = res.direccion;
	var telefono = res.telefono;
	var contentMap = '<div class="interactive-cloud">  ' 
		+ '<div class="glogo"> <img src=' + ico + ' alt="logo"  height="41" > </div>  ' + '<div class="content">' 
		+ '<h4>' + titulo + '</h4>      ' + '<p> <span class="gbold">Direccion</span>' + '<br>       '
		+ direccion + ' ' + '<br>        <span class="gbold">Telefono</span><br>         ' + telefono + ' <br>      ' 
		+ '</p>  <p class="urlDescuento"> <a href="javascript:void(0);onVerDescuento('+res.id+')" > Ver Descuento </a> </p> ' + '</div>  ' + '</div>';
		
	var infowindow = new google.maps.InfoWindow({maxWidth: 400});
	infowindow.setContent(contentMap );
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
		if (markersArray.length > 1) {
			for ( var i = 0; i < markersArray.length; i++) {
				var mak = markersArray[i];
				var mapaMarke = mak.map;
				if (mapaMarke != null) {
					var array = Object.keys(mak.position).map(function(key) {
						return {
							"type" : key,
							"name" : mak.position[key]
						};
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
		if (markersArray.length == 1) {
			var mak = markersArray[0];
			var mapaMarke = mak.map;
			if (mapaMarke != null) {
				var array = Object.keys(mak.position).map(function(key) {
					return {
						"type" : key,
						"name" : mak.position[key]
					};
				});
				var lat = array[0].name;
				var lng = array[1].name;
				var latlng = new google.maps.LatLng(lat, lng);
				bounds.extend(latlng);
			}
		}
	}
}

/**
 * el formulario donde se ubica la paginacion la lista la cual se genera el
 * paginador cantida de filas la url el metodo que se le asigna para poner
 * manipular el json obtenido sin romper el paginado y el atributo de la cual se
 * obtiene el json y almacena la lista
 * 
 */
function paginarLista(form, list, pagtor, paginaInicio, cantidadFilas, url, callBack, atributoRespuesta) {
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
	var html = "";

	loadform();

	var jsonRequest = new Request.JSON({
		method : 'get',
		url : url,
		data : data,
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
								for ( var ipagina = 2; ipagina < numeroPaginas + 1; ipagina++) {
									lp += '<a href="javascript:void(0);" class="eventPaginado " title="' + ipagina + '"  >' + ipagina + '</a> ';
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
						inputpaginaIntant.set("value", paginaSelect.title);
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

function cargarEventoClickBotonBuscar() {
	// cargo los combos y al lanzar rel evento de click lanza el metodo del
	// paginador segun el filtrado
	var busqueda = $$("input[name=busqueda-btn]");
	busqueda.addEvent("click", function() {

		var place = "Buscar en este sitio";
		var money = $("money").value;
		if (money.length > 0) {
			if (money == place) {
				$("money").value = "";
			}
		}
		var obtListaSucursalesDescuentos = $("obtListaSucursalesDescuentos").get("value");		
		msg.setStyle("display", "none");
		paginarLista("formDescuentos", "listaResultadosDescuentos", "paginadorDescuentos", 1, 10, obtListaSucursalesDescuentos, manipularRegistrosDescuentos, "lstDescuentos");

	});

	var cbocateg = getdata5("/GestionParametros-portlet/js/resources/categoria.json", "cboCategoriaHidden", "cboCategoria", "simple");
	cbocateg.addEvent('xChange', function(item) {
		busqueda.fireEvent("click");
	});
	var cbo = getdata5("/GestionParametros-portlet/js/resources/distrito_lima.json", "cboDistritosDescuentoHidden", "cboDistritosDescuento", "simple");
	cbo.addEvent('xChange', function(item) {
		busqueda.fireEvent("click");
	});

}

function manipularRegistrosDescuentos(content, result) {

	var html = "";
	deleteOverlays();

	if (result != null || result != undefined) {// manipoulacion del json para
		// genera el html
		if (result.length > 0) {
			msg.setStyle("display", "none");
			result.each(function(item) {///BuscarDescuento-portlet/img/
				html = '<div class="ico2" > <img src="' + item.etiquetaImg +
				'" border="0"  width="35" height="31"/></div>' + '<div class="wrapper-list">' + 
				'<h3>' + item.titulo + '</h3>' + '<p>' + item.direccion + '</p>' + '</div> ' + 
				'<span> ' + '<input type="hidden" class="longitud" value="' + item.longitud + '"> ' +
				'<input type="hidden" class="latitud" value="' + item.latitud + '"> ' +
				'<input type="hidden" class="titulo" value="' + item.titulo + '"> '	+ 
				'<input type="hidden" class="descripcion" value="' + item.descripcion + '"> ' +
				'<input type="hidden" class="direccion" value="' + item.direccion + '"> ' +						
				'<input type="hidden" class="telefono"	 value="' + item.telefono + '"> ' + 
				'<input type="hidden" class="ico" value="' + item.ico + '"> ' + '</span>';

				var div = new Element('div', {
					'id' : "trlist2-" + item.id,
					'class' : 'trlist',
					'html' : html
				}).inject(content);
				var p = div.getElement("div.wrapper-list");

				var hr = item.urlPreview;
				var a = new Element('a', {// aca se genera la invocacion al
					// ligthbox donde invoca el html
					// generado desde el servidor
					"id" : "box" + item.id,
					"href" : hr,
					"html" : "Ver descuento",
					"data-milkbox" : "milkbox:gtest" + item.id,
					"data-milkbox-size" : "width:322,height:354"
				}).inject(p);

				var br2 = new Element('br', {
					"id" : "oqsd1",
					"class" : "both"
				}).inject(div);

				var br = new Element('br', {
					"id" : "oqsd2",
					"class" : "both"
				}).inject(p);
				
				milkbox.galleries.push(new MilkboxGallery($$("#box" + item.id), {
					name : "milkbox:g" + item.name,
					remove_title : false
				}));
				milkbox.reloadPageGalleries();

			});

			result.each(function(item) {
				var id = "trlist2-" + item.id;
				var registro = $(id);
				ref = registro;
				cargarPosicion(2, item, "/GestionParametros-portlet/img/bolita.gif");
			});
			cargarGEODescuentos();

		} else {
			msg.setStyle("display", "block");
		}
	} else {
		msg.setStyle("display", "block");
	}

}

function cargarGEODescuentos() {

	$("listaResultadosDescuentos").setStyle('cursor', 'pointer');
	var listaResultadosDescuentos = $("listaResultadosDescuentos").getElements("div.trlist");

	listaResultadosDescuentos.each(function(el) {
		el.addEvent('mouseenter', function(event) {
			listaResultadosDescuentos.removeClass('active');
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
			var ico = span.getElement(".ico");
			ico = ico.value;
			if ((longitud != null || longitud != "") && (latitud != null && latitud != "") && (!isNaN(latitud) && !isNaN(longitud))) {
				centarMapa(longitud, latitud);
			}
		});
	});

	mapaTotal();
}

window.addEvent("domready", function(e) {
	msg = $("MENSAJE_SIN_RESULTADOS");
	cargarEventoClickBotonBuscar();// para la pestaña de Descuentos
	loadScript();
});
