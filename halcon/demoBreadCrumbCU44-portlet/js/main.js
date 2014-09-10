window.addEvent("domready", function(){
	
//	enviarRecomendacion();
	var cabecera= $$('.cadena-template') || false;
	if(cabecera){
		var titulo=$('snippetTitulo');
		if(titulo){
			cabecera.getElement('.activo').set('html',titulo.value);
		}
	}
	
});

function enviarRecomendacion(form, url) {
	
	if(form!=null){

		var inputs = form.elements;
		var nombreR = (inputs["nombreR"]).value;
		var emailR = (inputs["correoR"]).value;
		var nombreD = (inputs["nombreD"]).value;
		var emailD = (inputs["correoD"]).value;
		var comentario = (inputs["comentario"]).value;
		
			var enviarEmail = $("enviarCorreoHidden").get("value");
			var jsonRequest = new Request.JSON({
				method : 'get',
				url : enviarEmail,
				data : {
					'nombreR' : nombreR,
					'correoR' : emailR,
					'nombreD' : nombreD,
					'correoD' : emailD,
					'url' : url,
					'comentario' : comentario
				},
				onSuccess : function(response) {

					var resp = response.valor;
					 
					if(resp =='ok'){
						$('linkup').fireEvent('click');
					}
					if(resp =='nombreR' || resp =='2'){
						
						inputs["nombreR"].addClass("text-error");
						form.getElement("div#nombreRemError").setStyle('display','block');
					} 
					if(resp=='nombreAR' || resp =='2'){
						inputs["nombreD"].addClass("text-error");
						form.getElement("div#nombreDesError").setStyle('display','block');
					}											
				}
			});
			jsonRequest.send();
	}
}


