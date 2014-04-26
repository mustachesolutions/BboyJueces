<%-- 
    Document   : admin
    Created on : 16-abr-2014, 13:41:37
    Author     : Enrique
--%>

<%@page import="control.Sesiones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="admin" scope="session" class="control.Administrador"/>
<%
    String mensaje = "";
    String usuario="";
    
     HttpSession sesionOk = request.getSession();
    usuario = (String) sesionOk.getAttribute(Sesiones.sesionAdmin);
     
    if (usuario == null) {
       response.sendRedirect("LoginAdmin.jsp"); 
    } 
    mensaje=admin.getMensaje();
    admin.actualizarAdmin(usuario);
    int idBatalla=admin.getEvento().getBatallaId();
    String parametro=Integer.toString(admin.getEvento().getId_evento());
    
    %>
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
		
                                             
   <script type="text/javascript" src="HTML/js/script.js"></script>

    </head>
    <body onload="mostrar('<%=mensaje%>')">
        <nav>
         <div id="cssmenu"  >
            <ul >
               <li>
                   <a href='admin.jsp' class='icon-home' title ='inicio'><span>Inicio</span></a>
               </li>
               <li ><a href='agregar-crews.jsp' class=''><span>Crews</span></a></li>
               <li class='has-sub'><a href='' class=''><span>Batalla</span></a>
                 <ul >
                     <li class="Last" ><a href='crear-batalla.jsp'><span>Nueva Batalla</span></a></li>
                    <li class="Last"><a href='FirstCrew.jsp' ><span>Seleccionar Primero</span></a></li>
                    <li class='has-sub'><a href='resultados-finales.jsp?batalla=<%=idBatalla%>' class=''><span>Resultados</span></a></li>
                     </ul>
                </li>
                <li class='has-sub'><a href='reporte.jsp?evento=<%=parametro%>' class=''><span>Reporte del evento</span></a></li>
                <li class='has-sub'><a href='' class=''><span>Sesion y Jurado</span></a><ul >
                     <li class="Last" ><a href='gestion-jueces.jsp'><span>Gestionar jurados</span></a></li>
                    <li class="Last"><a href='dynamics.jsp' ><span>Iniciar como jurado</span></a></li>
                       <li class="Last"><a href='SingOutAdmin.jsp' ><span>Cerrar Sesión</span></a></li>
                     </ul>
                </li>
            </ul>
         </div>

      </nav>
        
        
        
		<div class="container">
			<h1>O.U.R.<span> Judges Assistant</span></h1>
			<ul id="sti-menu" class="sti-menu">
				<li data-hovercolor="#37c5e9">
					<a href='agregar-crews.jsp'>
						<h2 data-type="mText" class="sti-item">CREWS</h2>
						<h3 data-type="sText" class="sti-item">Gestione los crew del evento</h3>
						<span data-type="icon" class="sti-icon sti-icon-crew sti-item"></span>
					</a>
				</li>
				<li data-hovercolor="#ff395e">
					<a href='crear-batalla.jsp'>
						<h2 data-type="mText" class="sti-item">Batalla!</h2>
						<h3 data-type="sText" class="sti-item">Crea una nueva batalla</h3>
						<span data-type="icon" class="sti-icon sti-icon-batalla sti-item"></span>
					</a>
				</li>
				<li data-hovercolor="#57e676">
					<a href='resultados-finales.jsp?batalla=<%=idBatalla%>'>
						<h2 data-type="mText" class="sti-item">Resultados</h2>
						<h3 data-type="sText" class="sti-item">Ver resultados de las batallas</h3>
						<span data-type="icon" class="sti-icon sti-icon-resultados sti-item"></span>
					</a>
				</li>
				
			</ul>

			
		</div>
        

<div id="PersonTableContainer"></div>        
        
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
    </body>
</html>