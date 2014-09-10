window.addEvent("domready",function(){
	
	if($("optRegistrarDN")!=null){
		$("optRegistrarDN").addEvent("click",function(e){
			e.stop();
			var url=$("optRegistrarDN").get('url');
			var fm=$("fmVPS");
			fm.action=url;
			var cod1=$('idcw1').value;
			var cod2=$('idcw2').value;
			var cod3=$('idcw3').value;
			var cod4=$('idcw4').value;
			if(cod1!=0 || cod2!=0 || cod3!=0 || cod4!=0){
				fm.submit();
			}else{
				alert('Ingrese un contenido para registrar.');
			}
		});
	}
	
	var elementLast = $('ultimo').getElements('div.destacado-hp');//.addClass('sin-border');
	elementLast[elementLast.length - 1].addClass('sin-border');
});

