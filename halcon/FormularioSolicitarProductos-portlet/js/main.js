var xscript="";
var julioHurtado="";

window.addEvent("domready", function(e){
	
	if($('obtenerFormato')){
		var tipoForm = $('obtenerFormato').value;
		julioHurtado=$('obtenerFormato').value;
		//console.log('tipoForm: ' + tipoForm);
		rowElement = Array('solicitar-credito-hipotecario.js','solicitar-credito-vehicular.js','solicitar-cuenta-sueldo.js','solicitar-fondos-mutuos.js','solicitar-prestamo-personal.js','solicitar-producto-preAprobado.js','solicitar-seguro-soat.js','solicitar-tarjeta-credito.js');		
		xscript = new Element('script',{'type':'text/javascript','src':'/FormularioSolicitarProductos-portlet/js/'+rowElement[tipoForm-1]}).inject($(document.body),'bottom');
	}
	
	
	/* datepiker-styleggl */
	
	
	var datepikerggl = function(dateInfo){ 
		
		var day,year, dayValue, monthValue, yearValue, currentYear, info, $class, dropdown;
		
		$class="text-error";
		day = $("day");
		year = $("year");
		currentYear =  $("anhoActual").value;
		minYear = 1900;
		
		var loadInfoDropdown = function(selectedDate){
			
			contentDropdown = "cbomonth";
			sNameHidden = "month";
			
			selectedDate =  selectedDate || false;
			$(contentDropdown).set("html","");
			
			data =[{"id":"0","etiqueta":"Seleccione","tool":"","orden":"0","defecto":"1"},
			       {"id":"01","etiqueta":"Enero","tool":"","orden":"1","defecto":"0"},
			       {"id":"02","etiqueta":"Febrero","tool":"","orden":"2","defecto":"0"},
			       {"id":"03","etiqueta":"Marzo","tool":"","orden":"3","defecto":"0"},
			       {"id":"04","etiqueta":"Abril","tool":"","orden":"4","defecto":"0"},
			       {"id":"05","etiqueta":"Mayo","tool":"","orden":"5","defecto":"0"},
			       {"id":"06","etiqueta":"Junio","tool":"","orden":"6","defecto":"0"},
			       {"id":"07","etiqueta":"Julio","tool":"","orden":"7","defecto":"0"},
			       {"id":"8","etiqueta":"Agosto","tool":"","orden":"8","defecto":"0"},
			       {"id":"9","etiqueta":"Septiembre","tool":"","orden":"9","defecto":"0"},
			       {"id":"10","etiqueta":"Octubre","tool":"","orden":"10","defecto":"0"},
			       {"id":"11","etiqueta":"Noviembre","tool":"","orden":"11","defecto":"0"},
			       {"id":"12","etiqueta":"Diciembre","tool":"","orden":"12","defecto":"0"}];

			if(!selectedDate){
				dropdown = new moodropdown($(contentDropdown),{'data':data,'nameHiden': sNameHidden});
			}else{
				
				fecha = selectedDate.split('/');
				selectedday = fecha[0];
	        	selectedmonth = fecha[1].toInt();
	        	selectedyear = fecha[2];
				
				dropdown = new moodropdown($(contentDropdown),{'data':data,'nameHiden': sNameHidden, 'selectedValue':selectedmonth});
				$("day").value = selectedday;
				$("year").value = selectedyear;
			}
			
			return dropdown;
		};
		
		var daysInMonth = function(iMonth, iYear){
			var day;
				day = new Date(iYear, iMonth, 0).getDate();
				return day;
		};
		
		var validateDateAge = function(Infodate){
			
			var dateTest = Infodate.test(/^(0[1-9]|[12][0-9]|3[01])[- \/.](0[1-9]|1[012])[- \/.](19|20)\d\d$/);
			
	    	if(dateTest){
	    		var dateToCheck, fecha, infoday, infomonth, infoyear;

		    		fecha = Infodate.split('/');
		        	infoday = fecha[0].toInt();
		        	infomonth = fecha[1].toInt() - 1;
		        	infoyear = fecha[2].toInt();

		        	dateToCheck = new Date(infoyear,infomonth,infoday );
		        	dateTest =  ((dateToCheck.getDate() == infoday) && (dateToCheck.getMonth() == infomonth) && (dateToCheck.getFullYear() == infoyear));

		        	if(dateTest){
		        		msjError = $("MSJ_FECHA_NACIMIENTO2").value;
		        		nowDate = new Date();
		        		nowYear = nowDate.getYear();
		        		nowMonth = nowDate.getMonth();
		        		nowDay = nowDate.getDate();
		        		if(nowYear < 1900)nowYear += 1900;
		        		age = nowYear - infoyear;
		        		if (nowMonth < (infomonth - 1)) age = age - 1;
		        		if (((infomonth - 1) == nowMonth) && (nowDay < infoday)) age = age - 1;
		        		dateTest = (age > 17);
		        	}
	    	}else{
	    		msjError = $("MSJ_FECHA_NACIMIENTO1").value;
	    	}
			
	    	return {
	    			'bValue':dateTest,
	    			'msjError': msjError
	    	};
	    	
		};
		
		var validateDate = function(){		
			dayValue = day.value;
			monthValue = $("month").value;
			yearValue = year.value;
			info = "";
			msjError = $("MSJ_FECHA_NACIMIENTO1").value;
			bValue = true;
			if(dayValue !="" && monthValue !=0 && yearValue !=""){
				day.removeClass($class);
				$("cbomonth").removeClass($class);
				year.removeClass($class);
				if(yearValue  >= minYear  && yearValue <= currentYear){
					if(monthValue > 0 && monthValue < 13){
							var lastDayMonth = daysInMonth(monthValue,yearValue);
							if(dayValue > 0 && dayValue <= lastDayMonth){
								dayValue =  (dayValue.length<2 )? "0"+dayValue:dayValue;
								monthValue = (monthValue.length < 2)?"0"+ monthValue:monthValue;
								info = dayValue + "/" + monthValue +  "/" +yearValue;
								infodate = validateDateAge(info);
								bValue = infodate.bValue;
								if(!infodate.bValue){
									msjError = infodate.msjError;
									$("msj_fecNacimiento").set({'html':msjError,'styles':{'display':'block'}});
									day.addClass($class);
									year.addClass($class);
									$("cbomonth").addClass($class);
									$("cbomonth").removeClass('bgfa');
								}
							}else{
								day.addClass($class);
								$("msj_fecNacimiento").set({'html':msjError,'styles':{'display':'block'}});
							}
					}else{
						$("cbomonth").addClass($class);
						$("cbomonth").removeClass('bgfa');
						$("msj_fecNacimiento").set({'html':msjError,'styles':{'display':'block'}});
					}
				}else{
					year.addClass($class);
					$("msj_fecNacimiento").set({'html':msjError,'styles':{'display':'block'}});
				}
			}else{
				$("msj_fecNacimiento").set({'html':msjError,'styles':{'display':'block'}});
				if(dayValue =="")day.addClass($class);
				if(yearValue =="")year.addClass($class);
				if(monthValue == 0){
					$("cbomonth").addClass($class);
					$("cbomonth").removeClass('bgfa');
				}
			}
			
			if(info != "" && bValue){
				$("msj_fecNacimiento").setStyle('display','none');
			}
			
			return info;
		};
		
		var number = function(e){
			key = e.code;
			return (key <= 13 || (key >= 48 && key <= 57));
		};
		
		var changeDate = function(){
			info = validateDate();
	    	$("fecNacimiento").value = info;
		};	
		
		dropdown = loadInfoDropdown(dateInfo);
		dropdown.addEvent('xChange',changeDate);
		day.addEvent("blur",changeDate);
		year.addEvent("blur",changeDate);
		day.addEvent("keypress",number);
		year.addEvent("keypress",number);
		
	};
	
	/* */
	//Edicion
	if($("optRegistrar")!=null){
		$("optRegistrar").addEvent("click",function(e){
			e.stop();
			var url=$("optRegistrar").get('url');
			var fm=$("fmVPS");
			fm.action=url;
			fm.submit();
		});
	 }
	
	if ($('formato') != null) {
		var urlObtener =$('obtenerContenidos').get('value');
		$('formato').addEvent("change",function(e){
			//console.log($('formato').get('value'));
			if($('formato').get('value') != '0'){
				var jsonRequest = new Request.JSON({
					method : 'post',
					url : urlObtener,
					data : {codProducto:$('formato').get('value')},
					onComplete : function(response) {
						$("idcw1").value = '0';
						$("idcw2").value = '0';
						$("idcw3").value = '0';
						$("idcw4").value = '0';
						$("idcw5").value = '0';
						if (response.length > 0) {
							response.each(function(res,index) {
								$('idcw'+(index+1)).value =  res.codigo;
							});
						}
					}
				});
				jsonRequest.send();
			}
		});
	}
	
	if($("datepikerggl")){
		var info; 
			info = $("fecNacimiento").value;
			datepikerggl(info);
	} 
	
});