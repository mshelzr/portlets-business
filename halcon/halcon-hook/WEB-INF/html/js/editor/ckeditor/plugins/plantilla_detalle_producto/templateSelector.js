/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

CKEDITOR.dialog.add( 'templateSelector', function( editor )
{
	return {
		title : 'Plantilla de Detalle de Producto',
		minWidth : 400,
		minHeight : 200,
		contents : [
			{
				id : 'tabConfiguracion',
				label : 'Configuración',
				title : 'Configuración',
				elements :
				[
					{
						type : 'select',
						id : 'cmdTipoDetalle',
						label : 'Modelo',
						items : 
						[
							[ '<ninguno>', '0' ],
							[ 'Modelo 1', '1' ],
							[ 'Modelo 2', '2' ],
							[ 'Modelo 3', '3' ],
							[ 'Modelo 4', '4' ]
						],
						commit : function( data )
						{
							data.cmdTipoDetalle = this.getValue();
						}
					}
				]
			}
		],
		onOk : function()
		{
			var data = {};//Almacenara los datos del formulario
			this.commitContent( data );//Guardo los valores en la variable
			var htmlElement;
			
			switch( data.cmdTipoDetalle )
			{
				case '0' :
					
				break;
				case '1' :
					/*Formato 1*/
					  var html = '';
			          html+='<div class="feature-dp hgt339">';
			          html+='<div class="content-dp">';
			          html+='<ul class="dpf1">';
			          html+='<li>Ingresa tu texto</li>';
			          html+='<li>Ingresa tu texto</li>';
			          html+='<li>Ingresa tu texto</li>';
			          html+='</ul>';
			          html+='<img src="/halcon-theme/images/halcon/rentabilidad-dp1.jpg" width="564" alt="Imagen" title="Imagen" /> <br />';
			          html+='<br />';
			          html+='<br />';
			          html+='<br />';
			          html+='<br />';
			          html+='<br />';
			          html+='<br />';
			          html+='<br />';
			          html+='</div>';
			          html+='</div>';
			          htmlElement = CKEDITOR.dom.element.createFromHtml( html );
			          editor.insertElement( htmlElement );
				break;
				case '2' :
					/*Formato 2*/
					var html='';
					html+='<div class="feature-dp hgt339">';
					html+='<div class="contendedor-ventajas">';
					html+='<div class="ventajas-blocks"> <img src="/halcon-theme/images/halcon/ventajas-01.jpg" width="70" alt="Beneficios" title="Beneficios" />';
					html+='<h2>Promociones y ofertas exclusivas </h2>';
					html+=' <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry</p>';
					html+='</div>';
					html+='<div class="ventajas-blocks"> <img src="/halcon-theme/images/halcon/ventajas-02.jpg" width="70" alt="Beneficios" title="Beneficios" />';
					html+='<h2>Promociones y ofertas exclusivas </h2>';
					html+='<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry</p>';
					html+='</div>';
					html+='<div class="ventajas-blocks"> <img src="/halcon-theme/images/halcon/ventajas-03.jpg" width="70" alt="Beneficios" title="Beneficios" />';
					html+='<h2>Promociones y ofertas exclusivas </h2>';
					html+='<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry</p>';
					html+='</div>';
					html+='<div class="ventajas-blocks"> <img src="/halcon-theme/images/halcon/ventajas-00.jpg" width="70" alt="Beneficios" title="Beneficios" />';
					html+='<h2>Promociones y ofertas exclusivas </h2>';
					html+='<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry</p>';
					html+='</div>';
					html+='<p><br />';
					html+='Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.';
					html+='</p>';
					html+='</div>';
					html+='</div>';
					htmlElement = CKEDITOR.dom.element.createFromHtml( html );
					editor.insertElement( htmlElement );
				break;
				case '3' :
					/*Formato 3*/
					var html='';
					html+='<div class="feature-dp hgt354"> ';
					html+='<div class="beneficios-CV"> ';
					html+='<div class="beneficios-CV-textos">';
					html+='<ul>';
					html+='<li> <span class="CV-txt-dest">Hemos diseñado los plazos</span> de acuerdo a tus necesidades.</li>';
					html+='<li> <span class="CV-txt-dest">Te abonamos los intereses</span> directamente a tu cuenta a plazo.</li>';
					html+='<li> <span class="CV-txt-dest">Obtienes una mejor rentabilidad</span> según el plazo pactado.</li>';
					html+='<li> <span class="CV-txt-dest">Tu cuenta está libre</span> del cobro de mantenimiento mensual y portes.</li>';
					html+='<li> <span class="CV-txt-dest">En caso de vencimiento</span> del plazo fijado, las cuentas se renuevan automáticamente por el mismo plazo y según tasa vigente al momento de renovación.</li>';
					html+='<li> <span class="CV-txt-dest">Las renovaciones</span> de tus cuentas a plazo están exoneradas del cobro de ITF.</li>';
					html+='<li> <span class="CV-txt-dest">La capitalización</span> es en forma diaria.</li>';
					html+='</ul>';
					html+='</div>';
					html+='<div class="sol-asesor-cont"> <img src="/halcon-theme/images/halcon/tarjeta-00.jpg" width="197" height="211"  alt="Tarjeta"/> </div>';
					html+='</div>';
					html+='</div>';
					htmlElement = CKEDITOR.dom.element.createFromHtml( html );
					editor.insertElement( htmlElement );
				break;
				case '4' :
					/*Formato 4*/
					var html='';
					html+='<div class="feature-dp hgt339">'; 
					html+='<div class="beneficios-CV"> ';
					html+='<div class="beneficios-CV-textos">';
					html+='<ul>';
					html+='<li><samp class="CV-txt-dest">Cupones Vea</samp> </li>';
					html+='</ul>';
					html+='<p>Un programa que te premia por comprar con tu Tarjeta Vea Visa dentro y fuera de Plaza Vea! Recíbelos todos los meses en tu estado de cuenta por tus consumos. ¡Más compras, más ahorras!.</p>';
					html+='<p>¡Te regalamos un cupón de descuento adicional por cada S/.100 de compras al mes! </p>';
					html+='<div class="list-cards">';
					html+='<ul>';
					html+='<li>Si consumes S/. 100 => recibes 1 Cupón Vea</li>';
					html+='<li>Si consumes S/. 200 => recibes 2 Cupones Vea</li>';
					html+='<li>Si consumes S/. 300 => recibes 3 Cupones Vea</li>';
					html+='<li>Si consumes S/. 400 => recibes 4 Cupones Vea</li>';
					html+='<li>Si consumes S/. 500 => recibes 5 Cupones Vea</li>';
					html+='<li>Si consumes S/. 600 => recibes 6 Cupones Vea</li>';
					html+='<li>Si consumes S/. 700 => recibes 7 Cupones Vea</li>';
					html+='<li>Si consumes S/. 800 => recibes 8 Cupones Vea</li>';
					html+='<li>Si consumes S/. 900 => recibes 9 Cupones Vea</li>';
					html+='<li>Si consumes S/. 1,000 => recibes 10 Cupones Vea</li>';
					html+='<li>Si consumes S/. 1,100 => recibes 11 Cupones Vea</li>';
					html+='</ul>';
					html+='</div>';
					html+='</div>';
					html+='<div class="sol-asesor">';
					html+='<div class="b-top"></div>';
					html+='<h2>Solicitar <br />';
					html+='un Asesor </h2>';
					html+='<ul>';
					html+='<li><span class="phono-icon">311 9000 (Lima)<br />';
					html+='0 801 00802	(Provincias)</span></li>';
					html+='<li><span class="chat-icon">Chat Online</span></li>';
					html+='<li class="ultimo-elemento"><span class="mail-icon">Envía un e-mail</span></li>';
					html+='</ul>';
					html+='<br class="both" />';
					html+='<div class="b-btm"></div>'; 
					html+='</div>';
					html+='<div class="sol-asesor-II">';
					html+='<div class="b-top"></div>';
					html+='<h2 class="font16">Descargas </h2>';
					html+='<div class="asesor-descarg first-pd">';
					html+='<ul>';
					html+='<li>';
					html+='<span>.</span>';
					html+='<a href="#" title="Contrato Bien Independizado">Contrato Bien Independizado</a>';
					html+='</li>';
					html+='<li class="lh14">';
					html+='<span>.</span>';
					html+='<a href="#" title="Contrato Bien no Independizado">Contrato Bien no <br />  Independizado</a>';
					html+='</li>';
					html+='</ul>';
					html+='</div>	';		                
					html+='<div class="asesor-descarg">';
					html+='<p>Proyecto Interbank</p>';
					html+='<ul>';
					html+='<li>';
					html+='<span>.</span>';
					html+='<a href="#" title="Contrato Bien Independizado">Contrato Bien Independizado</a>';
					html+='</li>';
					html+='</ul>';
					html+='</div>	';		                
					html+='<div class="asesor-descarg">';
					html+='<p>Carta Fianza</p>';
					html+='<ul>';
					html+='<li class="lh14">';
					html+='<span>.</span>';
					html+='<a href="#" title="Contrato Bien no Independizado">Contrato Bien no Independizado</a>';
					html+='</li>';
					html+='</ul>';
					html+='</div>	';		                
					html+='<div class="asesor-descarg sin-border pdbtm0">';
					html+='<p>Certificado Bancario</p>';
					html+='<ul>';
					html+='<li>';
					html+='<span>.</span>';
					html+='<a href="#" title="Hoja de Resumen">Hoja de Resumen</a>';
					html+='</li>';
					html+='<li>';
					html+='<span>.</span>';
					html+='<a href="#" title="Cronograma Definitivo">Cronograma Definitivo</a>';
					html+='</li>';
					html+='<li>';
					html+='<span>.</span>';
					html+='<a href="#" title="Tarifario">Tarifario</a>';
					html+='</li>';
					html+='<li>';
					html+='<span>.</span>';
					html+='<a href="#" title="F&oacute;rmulas y ejemplos">F&oacute;rmulas y ejemplos</a>';
					html+='</li>';
					html+='</ul>';
					html+='</div> ';            			                
					html+='<br class="both" />';
					html+='<div class="b-btm"></div>';
					html+='</div>';
					html+='</div>';
					html+='</div>';
					
					htmlElement = CKEDITOR.dom.element.createFromHtml( html );
					editor.insertElement( htmlElement );
				break;
			}
			
		}
	};
} );
