window.addEvent('domready',function(){
	/*$('content').addClass('contenido-sol');*/
	
	if($$('.busqueda-btn') && $('busqueda-txt')){
		//Evento del buscador
		$$('.busqueda-btn').addEvent("click",function(){
			enviar();
		});
		
		$('busqueda-txt').addEvent("keydown",function(e){
			if(e.key == 'enter'){
				enviar();
			}
		});
	}
	
	
});

function enviar(){
	var keyword = $('busqueda-txt').get('value');
	location.href="/buscador?keywords="+encodeURI(keyword);
}