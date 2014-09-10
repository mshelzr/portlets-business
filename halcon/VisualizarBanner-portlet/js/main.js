window.addEvent("domready",function(){
	if($("optRegistrar")!=null){
		$("optRegistrar").addEvent("click",function(e){
			e.stop();
			var url=$("optRegistrar").get('url');
			var fm=$("fmVPS");
			fm.action=url;
			var cod=$('cmbProducto').value;
			if(cod!=0){
				fm.submit();
			}else{
				alert('Seleccione un modo de visualización.');
			}
		});
	}
});
