function esBisiesto(ano)
{
	return ((ano%4==0 && ano%100!=0)||(ano%400==0)?true:false)
}

function llenarDias(ano, mes, dia)
{
	var valMes, valAno, indiceCbo, i, n, cboAno, cboMes, cboDia, carMes
	
	cboDia=document.getElementById(dia)
	cboMes=document.getElementById(mes)
	cboAno=document.getElementById(ano)
	
	//se eliminan todos los elementos del combo 'D�a'
	n=cboDia.options.length
	for (i=n-1; i>=0; i--)
	cboDia.options[i] = null
	
	//se llena el combo 'D�a' con valores del 1 al 28
	for (i=1; i<=28; i++)
	cboDia.options[i-1]=new Option (String(i),String(i))//String() paraconvertir en cadena un n�mero
	
	//se obtiene el valor del mes
	indiceCbo=cboMes.selectedIndex//�ndice de la opci�n seleccionada
	valMes=parseInt(cboMes.options[indiceCbo].value) //parseInt() para convertir en n�mero una cadena
	
	//se obtiene el valor del a�o
	indiceCbo=cboAno.selectedIndex //�ndice de la opci�n seleccionada
	valAno=parseInt(cboAno.options[indiceCbo].value)
	
	i=29
	if (valMes==2) //si el mes es febrero
	{
		if (esBisiesto(valAno)) //si el a�o es biciesto
		//se agrega 1 d�as m�s al combo 'D�a' para que llegue a 29
		cboDia.options[i-1]=new Option (String(i),String(i))
	}
	else if ((valMes%2==0||valMes>=8)&&(valMes%2!=0||valMes<=7 )) //si el mes es abril, junio, septiembre o noviembre
	{
		//se agregan 2 d�as m�s al combo 'D�a' para que llegue a 30
		for (i=29; i<=30; i++)
		cboDia.options[i-1]=new Option (String(i),String(i))
	}
	else if ((valMes%2!=0&&valMes<8)||(valMes%2==0&&valMes>7)) //si el mes es enero, marzo, mayo, julio, agosto, octubre o diciembre
	{
		//se agregan 3 d�as m�s al combo 'D�a' para que llegue a 31
		for (i=29; i<=31; i++)
		cboDia.options[i-1]=new Option (String(i),String(i))
	}
}


function validarCorreo(email){
	return /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
}

function validarNombresApellidos(nombre){ // 1
	return /^[a-zA-Z��������������\s]+$/.test(nombre);
} 

function validarTelefono(numero){
	return /^[0-9]{6,9}$/.test(numero);
}

function validarCelular(numero){
	return /^[0-9]{9}$/.test(numero);
}

function validarDNI(dni){
	return /^[0-9]{8}$/.test(dni);
}

function validarRUC(ruc){
	return /^[0-9]{11}$/.test(ruc);
}

function validarCExtranjeria(ce){
	return /^[a-zA-Z��0-9]{4,12}$/.test(ce);
}

function getEdad(dia,mes,anio){
	var fechaActual = new Date();
    diaActual = fechaActual.getDate();
    mesActual = fechaActual.getMonth() +1;
    annoActual = fechaActual.getFullYear();
	
    var edad=annoActual-anio;
    
    if (mesActual < mes){
    	edad--;
    } else if (mesActual == mes){
    	if (diaActual < dia)
    	edad--;
    }
    
    return edad;
}

function letters(e) { // 1
	tecla = (document.all) ? e.keyCode : e.which; // 2tecla
	if (tecla==8||tecla==0) return true; // 3
	patron =/[A-Za-z��������������\s]/;// solo letras
	te = String.fromCharCode(tecla); // 5
	return patron.test(te); // 6
} 

function numbers(e) { // 1
	tecla = (document.all) ? e.keyCode : e.which; // 2
	if (tecla==8||tecla==0) return true; // 3
	patron = /\d/; // Solo acepta n�meros
	te = String.fromCharCode(tecla); // 5
	return patron.test(te); // 6
} 

function alphanumeric(e) { // 1
	tecla = (document.all) ? e.keyCode : e.which; // 2
	if (tecla==8||tecla==0) return true; // 3
	patron = /\w/; // Alfanumerico
	te = String.fromCharCode(tecla); // 5
	return patron.test(te); // 6
} 

function email(e) {
	  var tecla = (document.all) ? e.keyCode : e.which;
	   if (tecla==8) return true;	  //tecla borrar
	       if (tecla==0) return true; //tecla tab
	       patron = /[-._@0-9A-Za-z��\s]/;
	   te = String.fromCharCode(tecla);
	   return patron.test(te);
}

/*Para formatear numero de la forma 1,200.50*/
function formatNumber(num,prefix){
    prefix = prefix || '';
    num +='';
    var splitStr = num.split('.');
    var splitLeft = splitStr[0];
    var splitRight = splitStr.length > 1 ? '.' + splitStr[1] : '';
    var regx = /(\d+)(\d{3})/;
	    while (regx.test(splitLeft)) {
	    splitLeft = splitLeft.replace(regx, '$1' + ',' + '$2');
	    }
    return prefix + splitLeft + splitRight;
}

function unformatNumber(num) {
	//return num.replace(/([^0-9\.\-])/g,'')*1;
	return num.replace(/([^0-9\-])/g,'')*1;
} 

