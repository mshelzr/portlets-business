window.addEvent("domready",function(){
	iTabs('.credit-tab-hp', '.perfilador-hp');
	
	function TabSizeAuto(){
		var maxHeight = parseInt($$(".TC-pestana").getStyle('height'));
		var arrC = new Array();
		Array.each($$(".TC-detail-prods").getStyle('height'), function(alto, index){arrC[index] = alto.replace("px","").toInt();});
		var maxHeightC = arrC.max();
		if(maxHeight < maxHeightC){
			maxHeight = maxHeightC;
			}
			
		$$(".TC-pestana").setStyle('height',maxHeight + 30);
		$$(".TC-pestana").getParent().setStyle('height',maxHeight + 30);
		$$(".TC-pestana").getParent().getElement(".TC-detail-cont").setStyle('height',maxHeight + 30);
		$$(".TC-detail-prods").setStyle('height',maxHeight + 30);
		}
		
		TabSizeAuto();
	
	
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
				alert('Seleccione un producto para registrar.');
			}
		});
	}
	
	if($("optEliminar")!=null){
		$("optEliminar").addEvent("click",function(e){
			e.stop();
			var url=$("optEliminar").get('url');
			var fm=$("fmVPS");
			fm.action=url;
			var cod=$('cmbProducto').value;
			if(cod!=0){
				fm.submit();
			}else{
				alert('Seleccione un producto para Eliminar.');
			}
		});
	}
	
	if($("optEditar")!=null){
		$("optEditar").addEvent("click",function(e){
			e.stop();
			var url=$("optEditar").get('url');
			var fm=$("fmVPS");
			fm.action=url;
			fm.submit();
		});
	}
});

