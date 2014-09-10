window.addEvent("domready",function(){
	
	activarCamposSlider();
//	desactivarCamposSlider();
//	nuevaPregunta();
	
	
});


function activarCamposSlider(){
	
	$('codigoClasificacion').addEvent("change",function(e){
		var valor = $('codigoClasificacion').get("value");

        if(valor=='10'){
			$(val1).setStyle('display','table-row');
			$(val2).setStyle('display','table-row');
			$(val3).setStyle('display','table-row');
    	} else {
    		$(val1).setStyle('display','none');
			$(val2).setStyle('display','none');
			$(val3).setStyle('display','none');
    	}
        	
     });
}


//function activarCamposSlider(){
//	
//	var sliderOpcion = $("sliderPreguntaCheck");
//	
//	if(sliderOpcion!=null){
//		sliderOpcion.addEvent("click",function(e){
//			console.log("activar");
//			$(val1).setStyle('display','table-row');
//			$(val2).setStyle('display','table-row');
//			$(val3).setStyle('display','table-row');
//		});
//	}
//	
//}

//function desactivarCamposSlider(){
//
//	var comboPregunta = $("comboPreguntaCheck");
//	
//	if(comboPregunta!=null){
//		comboPregunta.addEvent("click",function(e){
//				$(val1).setStyle('display','none');  
//				$(val2).setStyle('display','none');
//				$(val3).setStyle('display','none');
//		});
//	}
//
//	var listaPregunta = $("listaPreguntaCheck");
//	
//	if(comboPregunta!=null){
//		listaPregunta.addEvent("click",function(e){
//				$(val1).setStyle('display','none');
//				$(val2).setStyle('display','none');
//				$(val3).setStyle('display','none');
//		});
//	}
//		
//	var listaImg = $("listaImgPreguntaCheck");
//	
//	if(comboPregunta!=null){	
//		listaImg.addEvent("click",function(e){
//				console.info('dff');
//				$(val1).setStyle('display','none');
//				$(val2).setStyle('display','none');
//				$(val3).setStyle('display','none');
//		});	
//	}
//		
//}

function nuevaPregunta(){
	
	var btnNuevaP = $("nuevaPreg");
	if(btnNuevaP != null){
		btnNuevaP.addEvent("click",function(e){
			$("nombrePreg").set("value","");
			
		});
	}

}

function nuevaRespuesta(){
	var btnNuevaR = $("nuevaResp");
	
	if(btnNuevaR != null){
		btnNuevaR.addEvent("click",function(e){
			$("nuevaResp").set("disabled",false);
			$("nuevaResp").set("value","");
			
		});
	}
}


