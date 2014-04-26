
<%-- 
    Document   : FirstCrew
    Created on : 04-17-2014, 04:47:55 PM
    Author     : EltonAlexánder
--%>

<%@page import="control.Sesiones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="admin" scope="session" class="control.Administrador"/>
<%
    String mensaje = "";
    String usuario="";
    String crew1 = "";
    String crew2 = "";
     HttpSession sesionOk = request.getSession();
    usuario = (String) sesionOk.getAttribute(Sesiones.sesionAdmin);
    if (usuario == null) {
       response.sendRedirect("LoginAdmin.jsp"); 
    } 
    
      admin.actualizarAdmin(usuario);
     crew1= admin.getEvento().getBatallaActual().crew1.getName();
     crew2= admin.getEvento().getBatallaActual().crew2.getName();
     
    int idBatalla=admin.getEvento().getBatallaId();
    String parametro=Integer.toString(admin.getEvento().getId_evento());
     if (request.getParameter("crew1") != null) {
            admin.setUpCrew1Primero();
            mensaje=admin.getMensaje();
    if(mensaje.equals("Todo listo para comenzar!")){
    response.sendRedirect("admin.jsp");
    }
    }
    if (request.getParameter("crew2") != null) {
            admin.setUpCrew2Primero();
            mensaje=admin.getMensaje();
    if(mensaje.equals("Todo listo para comenzar!")){
    response.sendRedirect("admin.jsp");
    }
            
    }
    System.out.println(mensaje);


    %>
<html>
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
                
       <!-- Include one of jTable styles. -->
       <link href="HTML/css/admin/jTables/metro/darkgray/jtable.css" rel="stylesheet" type="text/css" />
       <link href="HTML/css/admin/jTables/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
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
		
                     
                     <div class="content2" data-role="content" data-theme="a"> 
                          <form>
                         <label class="Text" for="username">Quien inicia primero? </label>
                         <br></br>
                         <input class="boton" id="c1" name="crew1" type="submit" value="<%=crew1 %>" data-role="button" data-theme="b">
                     <input class="boton" id="c2" name="crew2" type="submit" value="<%=crew2 %>" data-role="button" data-theme="b">
                     </form>
                     </div>              
                  </div> 
                    
    </body>
    
    
</html>
