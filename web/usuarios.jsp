<%-- 
    Document   : usuarios
    Created on : 02-abr-2014, 22:48:28
    Author     : Enrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Pagina principal Administrador</title>
		<meta charset="UTF-8" />
        <meta name="description" content="Menu Principal para el administrador del evento" />
        <meta name="keywords" content="Bboy, our, breakdance, crews" />
		<meta name="author" content="Enrique Ramirez, Elton Rivera" />
                <link rel="stylesheet" type="text/css" href="HTML/css/admin/estilo-menu.css" />
		<link rel="stylesheet" type="text/css" href="HTML/css/admin/stimenu.css" />
        <link rel="stylesheet"  type="text/css" href="HTML/css/admin/style.css">
		<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow&v1' rel='stylesheet' type='text/css' />
		<link href='http://fonts.googleapis.com/css?family=Wire+One&v1' rel='stylesheet' type='text/css' />
     
    </head>
    <body>
        <nav>
         <div id="cssmenu"  >
            <ul >
               <li>
                  <a href='../html/administrador.html' class='icon-home' title ='inicio'><span>Inicio</span></a>
               </li>
               <li class='has-sub'>
					<a href="../html/crew.html" class=''><span>Crews</span></a>
               </li>
               <li class='has-sub'><a href='../html/batalla.html' class=''><span>Batalla</span></a></li>
                <li class='has-sub'><a href='../html/resultados.html' class=''><span>Resultados</span></a></li>
                <li class='has-sub'><a href='../html/usuarios.html' class=''><span>Usuarios</span></a></li>
            
            </ul>
         </div>

      </nav>
        
		
        <div style="width:60%;margin-right:20%;margin-left:20%;text-align:center;">

<h1><span>O.U.R. Judges Assistant</span></h1>      <h1>Usuarios</h1>      
<div id="PersonTableContainer"></div>
</div>
        
        
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js"></script>
		<script type="text/javascript" src="HTML/js/admin/jquery.iconmenu.js"></script>
        <script type="text/javascript" src="HTML/js/admin/jquery.easing.1.3.js"></script>   
		<script type="text/javascript">
			$(function() {
				$('#sti-menu').iconmenu({
					animMouseenter	: {
						'mText' : {speed : 400, easing : 'easeOutBack', delay : 200, dir : -1},
						'sText' : {speed : 400, easing : 'easeOutBack', delay : 400, dir : -1},
						'icon'  : {speed : 400, easing : 'easeOutBack', delay : 0, dir : -1}
					},
					animMouseleave	: {
						'mText' : {speed : 200, easing : 'easeInExpo', delay : 150, dir : 1},
						'sText' : {speed : 200, easing : 'easeInExpo', delay : 300, dir : 1},
						'icon'  : {speed : 200, easing : 'easeInExpo', delay : 0, dir : 1}
					}
				});
			});
		</script>
        
        <!-- Include one of jTable styles. -->
<link href="HTML/js/admin/jq/jtable.2.4.0/themes/metro/lightgray/jtable.css" rel="stylesheet" type="text/css" />
<link href="HTML/js/admin/jq/jquery-ui-1.10.4/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.css" rel="stylesheet" type="text/css" />

<!-- Include jTable script file. -->

<script src="HTML/js/admin/jq/jquery-ui-1.10.4/jquery-ui-1.10.4.custom/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="HTML/js/admin/jq/jquery-ui-1.10.4/jquery-ui-1.10.4.custom/js/jquery-ui-1.10.4.custom.js" type="text/javascript"></script>
<script src="HTML/js/admin/jq/jtable.2.4.0/jquery.jtable.js" type="text/javascript"></script>
    
<script type="text/javascript">
    $(document).ready(function () {

        //initialize jTable
        $('#PersonTableContainer').jtable({
            title: 'Usuarios',
            actions: {
                listAction: 'CRUDController?action=list',
                createAction:'CRUDController?action=create',
                updateAction: 'CRUDController?action=update',
                deleteAction: 'CRUDController?action=delete'
            },
            fields: {
               idjurado: {
                    key: true,
                    list: false
                },

                nombre_jurado: {
                    title: 'Nombre',
                    width: '30%'
                },

                password: {
                title: 'Password',
                    width: '30%'
                },

                categoria: {
                    title: 'Categoria',
                    width: '20%',
                    create: false,
                    edit: false
                    
                },

                conectado: {
                    title: 'Conectado',
                    width: '20%'
                }, 
                alias: {
                    title: 'Alias',
                    width: '20%'
                }  
            }

        });       
        $('#PersonTableContainer').jtable('load');
    });

</script>
        
        
    </body>
</html>
