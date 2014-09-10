/*var formulario = null;

window.addEvent("domready",function(){
	formulario = $("formListarParametro");
	
	$("formListarParametro").addEvent("submit",function(e){
		submitFormularioListarParametro(e);
	});
	
});

function submitFormularioListarParametro(e){
	e.stop();
	
	var req = new Request.HTML({
		method : 'post',
		url : formulario.get("action"),
		data : formulario,
		onComplete : function() {
			alert("Mensaje de Prueba");
			$("formListarParametro").reset();			
		}
	});

	req.send();
}*/

function mostrarFormulario(form) {
	form.submit();
}