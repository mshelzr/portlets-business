if($$('.solicitaLink')){
	$$('.solicitaLink').addEvent('click',function(e){
		e.stop();
		var url = this.get('href');
		volverSimular(url);
	});
	
}

function volverSimular(url){
	if($('redireccionSolicitud')){
		var urlVSim=$('redireccionSolicitud').value;
		var tipSim=$('tipSimSol').value;
		var codCampaniaSol=$('codCampaniaSol').value;
		
		var json = new Request.JSON({
			method : 'post',
			url : urlVSim,
			data:{
				url:url,
				tipSim:tipSim,
				codCampaniaSol:codCampaniaSol
			} ,
			onComplete : function(data) {
				location.replace(data.url);
			}
		});
		json.send();
		
	}
}