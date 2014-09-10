window.addEvent("domready",function(){
	
	if($("optRegistrar")!=null){
		$("optRegistrar").addEvent("click",function(e){
			e.stop();
			var url=$("optRegistrar").get('url');
			var fm=$("fmVPS");
			fm.action=url;
			var cod1=$('idcw1').value;
			var cod2=$('idcw2').value;
			var cod3=$('idcw3').value;
			if(cod1!=0 || cod2!=0 || cod3!=0){
				fm.submit();
			}else{
				alert('Ingrese un contenido para registrar.');
			}
		});
	}

	if($('ultimo')){
		var elementLast = $('ultimo').getElements('div.destacado-hp');//.addClass('sin-border');
		elementLast[elementLast.length - 1].addClass('sin-border');
	}
	
});

