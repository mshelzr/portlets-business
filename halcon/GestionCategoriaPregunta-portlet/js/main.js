function cargarDivCategoria(){
	
	var EE2 = $$('input[name=tipoCategoria]');
	console.log(EE2);

	EE2.addEvent('click', function(event) {
		var tipo =$$('input[name=tipoCategoria]:checked').map(function(e) { return e.value; });
		$('nombreCategoria').set('disabled', true); 
		$('nombreCategoriaC').set('disabled', true);
		$('nombreSubCategoria').set('disabled', true); 
		
		if (tipo == 'subcategoria'){
			$('ingresarSubCategoria').setStyle('display','block');
			$('ingresarCategoria').setStyle('display','none');
			
			$('listaCategorias').setStyle('display','none');
			$('listaSubCategorias').setStyle('display','block');
			
			/*var jsonRequest = new Request.JSON({
				method : 'get',
				url : buscarReporteH.get("value"),
				data : {
					'fechaHistorico' : fecha
				},
				onComplete : function(response) {
					var html = '';
					
					if (response == 'error') {
						$('resReporteHistorico').removeClass('rp-cdr');
						$('resReporteHistorico').setStyle('display','block');
						
					} else {
						$('resReporteHistorico').addClass('rp-cdr');
						$('resReporteHistorico').setStyle('display','block');
						html = '<div class="title-cdr">Nombre</div><div class="title-cdr sin-border">Enlace</div><div class="both"></div>';
						console.log(response);
						html+= '<div class="result-cdr">' + response.title + '</div>';
						html+= '<div class="result-cdr">' + response.url + '</div>';
						
					}	
					
					$('resReporteHistorico').set('html', html);
						
				}
			});
			jsonRequest.send();*/
			
		} else {
			$('ingresarCategoria').setStyle('display','block');
			$('ingresarSubCategoria').setStyle('display','none');
			
			$('listaCategorias').setStyle('display','block');
			$('listaSubCategorias').setStyle('display','none');
		}
		
		//$('resReporteHistorico').setStyle('display','block');
		
	});
	
	//console.log(" buscarReporte.get(value):"+ buscarReporte.get("value"));
	
	/*mooEl.addEvent('click', function(event) {
		var fecha = $("fechaHistorico").get('value');
		var jsonRequest = new Request.JSON({
			method : 'get',
			url : buscarReporteH.get("value"),
			data : {
				'fechaHistorico' : fecha
			},
			onComplete : function(response) {
				var html = '';
				
				if (response == 'error') {
					$('resReporteHistorico').removeClass('rp-cdr');
					$('resReporteHistorico').setStyle('display','block');
					
				} else {
					$('resReporteHistorico').addClass('rp-cdr');
					$('resReporteHistorico').setStyle('display','block');
					html = '<div class="title-cdr">Nombre</div><div class="title-cdr sin-border">Enlace</div><div class="both"></div>';
					console.log(response);
					html+= '<div class="result-cdr">' + response.title + '</div>';
					html+= '<div class="result-cdr">' + response.url + '</div>';
					
				}	
				
				$('resReporteHistorico').set('html', html);
					
			}
		});*/
		//jsonRequest.send();
//	});
}

function guardarCategoria() {
	
	var guardarCategoriaF = $("guardarCategoriaHidden");
	var mooEl = $('guardarCategoria');
	
		mooEl.addEvent('click', function(event) {
			var tipo = $$('input[name=tipoCategoria]:checked').map(function(e) { return e.value; });
			var html ='';
			
			if (tipo == 'subcategoria'){
				var nombreCatC = $("nombreCategoriaC").get('value');
				var nombreSubCat = $("nombreSubCategoria").get('value');
				
				var jsonRequest = new Request.JSON({
					method : 'get',
					url : guardarCategoriaF.get("value"),
					data : {
						'categoria' : nombreCatC,
						'subcategoria' : nombreSubCat,
						'tipo' : 'subcategoria'
					},
					onComplete : function(response) {
						html = '<table><tr><td></td><td>Descripcion</td><td>Tipo</td><td></td></tr>';
						response.each( function(item) {
						html += "<tr><td><input type='checkbox' name='option1[]' value=" + item._idCategoriaSubCat + "></td><td>"+item._descripcion+"</td>" +
									"<td>"; 
						if (item._idCategoriaSubCatPadre == ''){
							html += "Categoria";
						} else{
							html += "SubCategoria";
						}
							
						html+= "</td> <td>Editar</td></tr>";				
						});
						html += '</table>';
						$('listaSubCategorias').set('html', html);
					}
				});
				jsonRequest.send();

				
			} else {
				var nombreCat = $("nombreCategoria").get('value');
				
				var jsonRequest = new Request.JSON({
					method : 'get',
					url : guardarCategoriaF.get("value"),
					data : {
						'tipo' : 'categoria',
						'categoria' : nombreCat
					},
					onComplete : function(response) {
						html = '<table><tr><td></td><td>Descripcion</td><td></td></tr>';
						response.each( function(item) {
							html += "<tr><td><input type='checkbox' name='option1[]' value=" + item._idCategoriaSubCat + "></td><td>"+item._descripcion+"</td>" +
							"<td>"; 
							if (item._idCategoriaSubCatPadre == ''){
								html += "Categoria";
							} else{
								html += "SubCategoria";
							}
							html+= "</td> <td><a href='javascript:editarCategoria?idCategoria="+ item._idCategoriaSubCat +"'>Editar</td></tr>";				
						});
						html += '</table>';
						$('listaCategorias').set('html', html);
					}
				});
				jsonRequest.send();
				
			}

	});
	
}

function agregarCategoria() {
	
	var agregarCategoria = $("agregarCategoria");
	
	agregarCategoria.addEvent('click', function(event) {
		
		var tipo = $$('input[name=tipoCategoria]:checked').map(function(e) { return e.value; });
		if (tipo == 'categoria'){
			$('nombreCategoria').set('disabled',false); 
			$('nombreCategoria').setFocus();
		} else {
			$('nombreCategoriaC').set('disabled',false);
			$('nombreSubCategoria').set('disabled',false); 
		}
	});
	
	
}

function cancelarAccion() {
	
	var cancelarAc = $("cancelarAc");
	
	cancelarAc.addEvent('click', function(event) {

		$('nombreCategoria').set('value','');
		$('nombreCategoria').set('disabled',true); 
		$('nombreCategoriaC').set('disabled',true);
		$('nombreSubCategoria').set('disabled',true);
		$('nombreSubCategoria').set('value','');

	});
	
}

function editarCategoria() {
	
	var cancelarAc = $("cancelarAc");
	
	cancelarAc.addEvent('click', function(event) {
		alert("Ediatar");

		$('nombreCategoria').set('value','');
		$('nombreCategoria').set('disabled',true); 
		$('nombreCategoriaC').set('disabled',true);
		$('nombreSubCategoria').set('disabled',true);
		$('nombreSubCategoria').set('value','');

	});
	
}

function eliminarCategoria() {
	var btn = $("eliminarCat");
	btn.addEvent("click", function() {
		var formulario = $("formCategorias");
		var data = formulario.toQueryString();
		
		var tipo =$$('input[name=tipoCategoria]:checked').map(function(e) { return e.value; });
		alert(tipo);
		if (tipo == 'subcategoria'){

			var jsonRequest = new Request.JSON({
				method : 'post',
				url : formulario.get("action"),
				data : data,
				onComplete : function(response) {	
					html = '<table><tr><td></td><td>Descripcion</td><td>Tipo</td><td></td></tr>';
					response.each( function(item) {
					html += "<tr><td><input type='checkbox' name='categoria' value=" + item._idCategoriaSubCat + "></td><td>"+item._descripcion+"</td>" +
								"<td>"; 
					if (item._idCategoriaSubCatPadre == ''){
						html += "Categoria";
					} else{
						html += "SubCategoria";
					}
						
					html+= "</td> <td>Editar</td></tr>";				
					});
					html += '</table>';
					console.log(html);
					$('listaSubCategorias').set('html', html);
				}
			});
	
			jsonRequest.send();
		} else {
			
			var jsonRequest = new Request.JSON({
					method : 'post',
					url : formulario.get("action"),
					data : data,
				onComplete : function(response) {
					html = '<table><tr><td></td><td>Descripcion</td><td></td></tr>';
					response.each( function(item) {
						html += "<tr><td><input type='checkbox' name='categoria' value=" + item._idCategoriaSubCat + "></td><td>"+item._descripcion+"</td>" +
						"<td>"; 
						if (item._idCategoriaSubCatPadre == ''){
							html += "Categoria";
						} else{
							html += "SubCategoria";
						}
						html+= "</td> <td><a href='javascript:editarCategoria?idCategoria="+ item._idCategoriaSubCat +"'>Editar</td></tr>";				
					});
					html += '</table>';
					console.log(html);
					$('listaCategorias').set('html', html);
				}
			});
			jsonRequest.send();
		}
	});
}


window.addEvent("domready", function(e) {
	cargarDivCategoria();
	agregarCategoria();
	guardarCategoria();
	eliminarCategoria();
	cancelarAccion();
	editarCategoria();
});