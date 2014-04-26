<%-- 
    Document   : crear-batalla
    Created on : 17-abr-2014, 12:23:31
    Author     : Enrique
--%>





<%@page import="control.Sesiones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="admin" scope="session" class="control.Administrador"/>
<%
    String crew1 = "";
    String crew2 = "";
    String mensaje = "";
    String usuario="";
     HttpSession sesionOk = request.getSession();
    usuario = (String) sesionOk.getAttribute(Sesiones.sesionAdmin);
   
    if (usuario == null) {
       response.sendRedirect("LoginAdmin.jsp"); 
    } 
     admin.actualizarAdmin(usuario);
     int idBatalla=admin.getEvento().getBatallaId();
     String parametro=Integer.toString(admin.getEvento().getId_evento());
    if (request.getParameter("login") != null) {
        if (request.getParameter("crew1") != null && request.getParameter("crew2") != null) {
            
            crew1 = request.getParameter("crew1");
            crew2 = request.getParameter("crew2");
        }

        if(request.getParameter("crew1") == request.getParameter("crew2") ){
        mensaje = "No se pueden crear batallas entre un mismo Crew";
        }
        else{
           
            admin.nuevaBatalla(crew1, crew2);
            response.sendRedirect("FirstCrew.jsp");
            
            sesionOk.setAttribute("crew1", crew1);
            sesionOk.setAttribute("crew2", crew2);
             
        }
    }
%>
<html>
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
                
       <!-- Include one of jTable styles. -->
       <link href="HTML/css/admin/jTables/metro/crimson/jtable.css" rel="stylesheet" type="text/css" />
       <link href="HTML/css/admin/jTables/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="HTML/js/admin/JTables/jquery-1.8.2.js" type="text/javascript"></script>
<script src="HTML/js/admin/JTables/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="HTML/js/admin/JTables/jquery.jtable.js" type="text/javascript"></script>
        
        <!--SCRIPTS DEL AUTOCOMPLETE -->
        <link rel="stylesheet" type="text/css" href="HTML/css/admin/jquery.autocomplete.css" />
	<script src="http://www.google.com/jsapi"></script>  
	<script>  
		google.load("jquery", "1");
	</script>
        <script src="HTML/js/admin/jq/jquery.autocomplete.js"></script> 
        
    </head>

    <body onload="mostrar('<%=mensaje%>')">
        
        <form data-ajax="false">
            <div data-role="page" id="inciarSesion" data-rel="dialog" data-transition="pop">
                <!--CABECERA-->
                      
                <!--BODY-->
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
                    <br>
                    <label class="Text" for="username">Crew 1 : </label>
                    <input type="text" name="crew1" id="crew1">    
                    
                    <label class="Text" for="contrasenia">Crew 2 : </label>
                    
                    <input type="text" name="crew2" id="crew2">            
                    <!--input style="background: #333333;color: #0099ff;" class="nota"  id="login" type="submit" name="sesion" value="Iniciar Sesion" type="submit"/-->   
                    <input class="boton" id="blogin" name="login" type="submit" value="Crear Batalla" data-role="button" data-theme="b"/>
                </div>       
                <!--FOOTER-->
                
                </div>
            </div>
        </form>
        
        <script>
		$("#crew1").autocomplete("getdata.jsp");
                $("#crew2").autocomplete("getdata.jsp");
	</script>
        

    </body>

    



</html>
