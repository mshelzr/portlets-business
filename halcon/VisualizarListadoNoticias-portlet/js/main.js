window.addEvent("domready", function(){
	irPaginacion();
	irPaginacionBloque();
});


function irPaginacion(){
	var pagina = $$(".resul-lista");
	
	pagina.addEvent("click",function(){
		var paginaIra = this.getProperty('title');
		
		var paginaIr = paginaIra;
		if(paginaIra=='Previous'){
			paginaIr = $('previous').get("value");
		}else if(paginaIra == 'Next'){
			paginaIr = $('next').get("value");
		}
		var obtenerListadoPagina = $("obtenerListadoPaginacionHidden").get("value");
		var paginasVisibles = 5;
	
		var jsonRequest = new Request.JSON({
			method : 'get',
			noCache : true,
			url : obtenerListadoPagina,
			data : {
				'pagina' : paginaIr
			},
			onComplete : function(response) {
				var total = response.total;
				var delta = response.delta;
				var totalPag = total%delta==0?total/delta:(total/delta).floor()+1;
				var maxOrder=(totalPag%paginasVisibles==0?totalPag/paginasVisibles:(totalPag/paginasVisibles).floor()+1);
				var ordenSlider=(paginaIr%paginasVisibles==0?paginaIr/paginasVisibles:(paginaIr/paginasVisibles).floor()+1);
				var inicioOrden=((ordenSlider-1)*paginasVisibles)+1;
				var finOrden=inicioOrden+paginasVisibles;
				var listado = response.lstNoticias;
				
				var html = '';
				var i=0;
				
				listado.each( function(item) {
					i++;
					if (i==1 && item.urlImagen!='') {
						html+='<div id="div123" class="small-not sin-padding margintop4"> <img src="' + item.urlImagen + '" width="160" height="146" alt="' + item.title + '"/>';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p>' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';

					} else if (i==1 && item.urlImagen=='') {
						html+='<div id="div123" class="small-not sin-padding margintop4">';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p style="width: 150%">' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';
					} else if (i>1 && item.urlImagen!='') {
						html+='<div class="small-not"> <img src="' + item.urlImagen + '" width="160" height="146" alt="' + item.title + '"/>';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p>' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';
					} else if (i>1 && item.urlImagen=='') {
						html+='<div class="small-not">';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p style="width: 150%">' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';
					}
				});
				html+='<div class="resul-total float-left sin-border width605"><div class="total-num margintop5"> ';
				
				html+='<a href="javascript:void(0);" title="Previous" class="sin-padding bef">&lt; Anterior</a>';
				
				for(var j=inicioOrden; j<finOrden  && j<= totalPag; j++){
					if(j==paginaIr){  
						html+='<a href="javascript:void(0);" class="resul-lista-activo" title="'+j+'" >'+ j+'</a>';
					} else {
						 html+='<a href="javascript:void(0);" class="resul-lista" title="'+ j +'">'+ j+'</a>';
					}
				}
				
				var nextIr = parseInt(paginaIr) + 1;
				var antIr = 1;
				
				if(nextIr > totalPag){
					nextIr = totalPag;
				}
				if(paginaIr>1){
					antIr = paginaIr-1;
				}

				html+='<a href="javascript:void(0);" class="sin-padding aft" title="Next">Siguiente &gt;</a>';
				html+='<input type="hidden" id="previous" value='+ antIr + '><input type="hidden" id="next" value='+ nextIr + ' ><input type="hidden" id="actual" value='+ paginaIr +' >';
				
				$('content-medio').set('html', html);
				
				irPaginacion();
				irPaginacionBloque();
				$('content-medio').setFocus();
			}
		});
		jsonRequest.send();
	});
}


function irPaginacionBloque(){
	var pagina1 = $$(".sin-padding");
	pagina1.addEvent("click",function(){	
		var paginaIra = this.getProperty('title');
		
		var paginaIr = 0;
		if(paginaIra=='Previous'){
			paginaIr = $('previous').get("value");
		}else if(paginaIra == 'Next'){
			paginaIr = $('next').get("value");
		}
		var obtenerListadoPagina = $("obtenerListadoPaginacionHidden").get("value");
		var paginasVisibles = 5;
		
		var jsonRequest = new Request.JSON({
			method : 'get',
			noCache : true,
			url : obtenerListadoPagina,
			data : {
				'pagina' : paginaIr
			},
			onComplete : function(response) {
				var total = response.total;
				var delta = response.delta;
				var totalPag = total%delta==0?total/delta:(total/delta).floor()+1;
				var maxOrder=(totalPag%paginasVisibles==0?totalPag/paginasVisibles:(totalPag/paginasVisibles).floor()+1);
				var ordenSlider=(paginaIr%paginasVisibles==0?paginaIr/paginasVisibles:(paginaIr/paginasVisibles).floor()+1);
				var inicioOrden=((ordenSlider-1)*paginasVisibles)+1;
				var finOrden=inicioOrden+paginasVisibles;
				var listado = response.lstNoticias;
				
				var html = '';
				var i=0;
				
				listado.each( function(item) {
					i++;
					if (i==1 && item.urlImagen!='') {
						html+='<div id="div123" class="small-not sin-padding margintop4"> <img src="' + item.urlImagen + '" width="160" height="146" alt="' + item.title + '"/>';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p>' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';

					} else if (i==1 && item.urlImagen=='') {
						html+='<div id="div123" class="small-not sin-padding margintop4">';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p style="width: 150%">' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';
					} else if (i>1 && item.urlImagen!='') {
						html+='<div class="small-not"> <img src="' + item.urlImagen + '" width="160" height="146" alt="' + item.title + '"/>';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p>' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';
					} else if (i>1 && item.urlImagen=='') {
						html+='<div class="small-not">';
						html+='<div class="info-not">';
						html+='<h3>' + item.title +'</h3>';
						html+='<span>' + item.fechaCreacion +'</span>';
						html+='<p style="width: 150%">' + item.resumen +' <a href="' + item.urlDetalle + '" title="Ver detalle">Ver detalle</a> </p>';
						html+='</div></div>';
					}
				});
				html+='<div class="resul-total float-left sin-border width605"><div class="total-num margintop5"> ';
				
				html+='<a href="javascript:void(0);" title="Previous" class="sin-padding bef">&lt; Anterior</a>';
				
				for(var j=inicioOrden; j<finOrden  && j<= totalPag; j++){
					if(j==paginaIr){  
						html+='<a href="javascript:void(0);" class="resul-lista-activo" title="'+j+'" >'+ j+'</a>';
					} else {
						 html+='<a href="javascript:void(0);" class="resul-lista" title="'+ j +'">'+ j+'</a>';
					}
				}
				
				html+='<a href="javascript:void(0);" class="sin-padding aft" title="Next" >Siguiente &gt;</a>';
				var nextIr = parseInt(paginaIr) + 1;
				var antIr = 1;
				
				if(nextIr > totalPag){
					nextIr = totalPag;
				}
				if(paginaIr>1){
					antIr = paginaIr-1;
				}
				
				
				html+='<input type="hidden" id="previous" value='+ antIr + '><input type="hidden" id="next" value='+ nextIr + ' ><input type="hidden" id="actual" value='+ paginaIr +' >';

				$('content-medio').set('html', html);
				
				irPaginacion();
				irPaginacionBloque();
				$('content-medio').setFocus();

			}
		});
		jsonRequest.send();
	});
	
	
	
}

Element.implement({
	  setFocus: function(index) {
	    this.setAttribute('tabIndex',index || 0);
	    this.focus();
	  }
	});

