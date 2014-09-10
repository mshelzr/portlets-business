(function(){
     //The Code is written here, which will be executed when the button is clicked
     var a= {
     exec:function(editor){
            
    	

    	 editor.insertHtml( "<ol class=\"andy1\"><li></li></ol>" );
     
    	    var format = {
                 element : 'ol',
                 attributes : { 'class' : 'andy1' },
             };

             var style = new CKEDITOR.style(format);
             style.apply(editor.document);
             
         
      }
},

//The actual button is defined/created here and the associated code is linked with it
b='plantilla_detalle_producto';
CKEDITOR.plugins.add(b,{
    init:function(editor){
    	
    	if ( !CKEDITOR.dialog.exists( 'templateSelector' ) )
		{
			// We need to do the following trick to find out the dialog
			// definition file URL path. In the real world, you would simply
			// point to an absolute path directly, like "/mydir/mydialog.js".
			var href = this.path + 'templateSelector.js';

			// Finally, register the dialog.
			CKEDITOR.dialog.add( 'templateSelector', href );
		}

    	
    //editor.addCommand(b,a); // associating the executable code with the button click
    
    // Register the command used to open the dialog.
	editor.addCommand( b, new CKEDITOR.dialogCommand( 'templateSelector' ) );
	
    editor.ui.addButton('plantilla_detalle_producto',{
                                     label:'Insertar formato detalle Producto',
                                     icon: this.path + 'insert_image_button.png',
                          //defining the path of the icon image which will be displayed on the toolbar for this button
                          //easiest would be to have the icon image in the same folder as the plugin.js

                                     command:b
                             });
   }
});
})();