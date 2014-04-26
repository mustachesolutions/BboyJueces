<%-- 
    Document   : dynamics
    Created on : 03-29-2014, 12:33:45 AM
    Author     : bboyc_000
--%>



<%@page import="control.Sesiones"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="control.CategoriaControl"%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:useBean id="dynamics" scope="session" class="control.CategoriaControl"/>
<%

    String mensaje = "";
    dynamics.setMensaje("");
    String usuario="";
    String crew="";
    String imgCategoria="";
    HttpSession sesionOk = request.getSession();
    usuario = (String) sesionOk.getAttribute(Sesiones.sesionJudge);
     
    if (usuario == null) {
       response.sendRedirect("LoginJudge.jsp"); 
    } 
    
    dynamics.actualizarJurado(usuario);
    dynamics.actualizarEvento();
    int idBatalla=dynamics.getEvento().getBatallaId();
     imgCategoria=dynamics.imgCategoria();
     String color=dynamics.getJurado().getHTMLColor();
    if (request.getParameter("n5") != null) {
        dynamics.updateNota(5);
        response.sendRedirect("dynamics.jsp");
        
    }
    if (request.getParameter("n4") != null) {
        dynamics.updateNota(4);
        response.sendRedirect("dynamics.jsp");
    }
    if (request.getParameter("n3") != null) {
        dynamics.updateNota(3);
        response.sendRedirect("dynamics.jsp");
    }
    if (request.getParameter("n2") != null) {
        dynamics.updateNota(2);
        response.sendRedirect("dynamics.jsp");
    }
    if (request.getParameter("n1") != null) {
        dynamics.updateNota(1);
        response.sendRedirect("dynamics.jsp");
    }
    
    if (request.getParameter("n0") != null) {
        dynamics.updateNota(0);
        response.sendRedirect("dynamics.jsp");
    }
    crew=dynamics.correctedCrew();
    mensaje = dynamics.getMensaje();
    String nota=dynamics.getJurado().notaACorregir(dynamics.getEvento().getBatallaId());
    
   


%>
<html>
    <head>
        <!-- Adaptar a la version movil -->
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0,
              user-scalable=no">    
        <!-- Archivos necesarios para trabajar con el framework -->
        <link rel="stylesheet" type="text/css" href="HTML/jqm/jquery.mobile-1.4.2.css">
        <script type="text/javascript" src="HTML/jquery-2.1.0.min.js"></script>    
        <script type="text/javascript" src="HTML/jqm/jquery.mobile-1.4.2.js"></script> 
        <!-- Archivos para el manejo del boton -->
        <script type="text/javascript" src="HTML/js/script.js"></script>
        <script type="text/javascript" src="HTML/js/touch-dynamics.js"></script> 
       
        <link rel="stylesheet" type="text/css" href="HTML/css/estilo-evaluacion-juez.css">
    </head>

    <body onload="mostrar('<%=mensaje%>')">
        <form data-ajax="false">
            <div data-role="page" id="pagina1" >

                <!-- CABECERA   onfocus="mostrar('<%=mensaje%>')"-->
                <!--CREACION DE BOTONES DE OPCIONES PRINCIPALES-->
                <!-- Todo lo que va despues del data-position="fixed" queda fijo y en el orden en que se define en el html va desde la parte de   
                arriba del header hasta abajo-->
                <!--data-position="fixed" -->
                <div data-role="header" 
                     data-theme="b" 
                     data-ajax="false"
                     data-tap-toggle="false">

                    <a onclick="goTo('WebOUR/dynamics.jsp')" data-role="button" data-theme="b" data-icon="back">Atras</a>
                    <img src="<%=imgCategoria%>"

                         class="botonEfecto"


                         >
                   <a href="#popupMenu" data-rel="popup" data-role="button" data-inline="true" data-transition="flip">Opciones</a>   

               
                    
                    <div data-role="popup" id="popupMenu" data-overlay-theme="b">
                    <ul data-role="listview"  style="width:100%;" data-theme="b">
                   <li><a name="li1" onclick="goTo('WebOUR/dynamics.jsp')">Volver a Calificar</a></li>
                    <li><a name="e" onclick="goTo('WebOUR/resultados-finales.jsp?batalla=<%=idBatalla%>')">Ganador de categoria</a></li>
                    <li><a onclick="goTo('WebOUR/resultados-finales.jsp')">Resultados generales</a></li>
                    <li><a onclick="goTo('WebOUR/SingOut.jsp')">Cerrar Sesion</a></li>
                    </ul>
                    </div>   

                </div>
                <!-- CONTENIDO -->
                <div id="cuerpo" data-role="content" 
                     data-theme="b"
                     data-position="fixed"   
                     data-ajax="false"
                     >
                    <h2 id="h2"><%=crew%></h2>     
                    <br>
                    <h2 id="h2" style="color:red">Corregir la nota de <%=nota%> por:</h2>
                    <br>
                    <input class="nota"  id="nota5" name="n5" value="5. Excelente" type="submit"/>
                    <input class="nota"  id="nota4" name="n4" value="4. Bueno" type="submit"/>
                    <input class="nota"  id="nota3" name="n3" value="3. Normal" type="submit"/>
                    <input class="nota"  id="nota2" name="n2" value="2. Regular" type="submit"/>
                    <input class="nota"  id="nota1" name="n1" value="1. Malo" type="submit"/>
                    <input class="nota"  id="nota0" name="n0" value="0. Sancion" type="submit"/>



                </div>   
                <!-- PIE DE PAGINA -->
                <!--data-position="fixed" -->
                <div data-role="footer" 
                     data-theme="b" 
                     class="ui-bar" 
                     style="text-align:center"
                     data-tap-toggle="false"
                     data-ajax="false"
                     >
                    <div data-role="controlgroup" 
                         data-type="horizontal">                      


                    </div>



                </div>    




        </form>
    </body>

</html> 
