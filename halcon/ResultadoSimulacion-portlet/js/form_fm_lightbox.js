


var initTemplate  = function()
{
	getdatacombo("/GestionParametros-portlet/js/resources/tip_doc_sim_fondos_mutuos.json","tipoMonedaSimFondosMutuoshidden","tipoMonedaSimFondosMutuosContent2");

	$('monto_inversion_light').addEvent('blur',function(){
		var monto_inversion_light = $('monto_inversion_light').value;
		if(!monto_inversion_light.test(/^[0-9]+$/) ){
			if(!$('monto_inversion_light').hasClass('text-error')){
				$('monto_inversion_light').addClass('text-error');
				$('msj_error').setStyle('display','block');
			}
		}else{
			if($('monto_inversion_light').hasClass('text-error')){
				$('monto_inversion_light').removeClass('text-error');
				$('msj_error').setStyle('display','none');
			}
		}
	});
	
	
	if($$('#enviar_form_solicitar')){
		$$('#enviar_form_solicitar').addEvent('click',function(e){
			e.stop();			
			var form_lightbox = window.parent.document.getElementById('form_lightbox').value;

			var monto_inversion_light = $('monto_inversion_light').value;
			var tipo_moneda_light = $('tipoMonedaSimFondosMutuoshidden').value;

			if(!monto_inversion_light.test(/^[0-9]+$/) ){
				if(!$('monto_inversion_light').hasClass('text-error')){
					$('monto_inversion_light').addClass('text-error');
					$('msj_error').setStyle('display','block');
				}
				return false;
			}else{
				if($('monto_inversion_light').hasClass('text-error')){
					$('monto_inversion_light').removeClass('text-error');
					$('msj_error').setStyle('display','none');
				}
			}
			loadform();
			var json = new Request.JSON({
				method : 'post',
				url : form_lightbox,
				data:
				{
					monto_inversion_light:monto_inversion_light,
					tipo_moneda_light:tipo_moneda_light
				} ,
				onComplete : function(data){
					if(data.flag =='enlace'){
						$("contenedor1").setStyle('display','none');						
						$("contenedor2").setStyle('display','block');
						closeloadform();
					}
					else if(data.flag =='nueva'){
						//var enlace = window.parent.document.getElementById('urlNuevaVentana');
						//enlace.href = data.urlSolicitud;
						//enlace.fireEvent('click');
						window.parent.document.location.href = data.urlSolicitud;
					}
				}
			});
			json.send();
		});
		
		//Carga los valores
		$('link_fondosmutuos').set('href',window.parent.document.getElementById('link_fondosmutuos').value);
		$('link_fondosmutuos').set('text',window.parent.document.getElementById('titulo_fondosmutuos').value);
		$('mensaje_fondosmutuos').set('text',window.parent.document.getElementById('mensaje_fondosmutuos').value);

	}
	
	
	$('link_fondosmutuos').addEvent('click',function(e){
		e.stop();
		window.parent.document.location.href = $('link_fondosmutuos').get('href');
	});
};


window.addEvent('domready', initTemplate);