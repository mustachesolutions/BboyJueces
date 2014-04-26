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
    String crew1,crew2,total1,total2;
    String imgCategoria="";
    String color,winner ,resultadoCrew1,resultadoCrew2;
    HttpSession sesionOk = request.getSession();
    usuario = (String) sesionOk.getAttribute(Sesiones.sesionJudge);
    
    if (usuario == null) {
        response.sendRedirect("LoginJudge.jsp");   
    } 
    
   dynamics.actualizarJurado(usuario);
   dynamics.actualizarEvento();
    int idBatalla=dynamics.getEvento().getBatallaId();
    crew1=dynamics.getEvento().getBatallaActual().crew1.getName();
    crew2=dynamics.getEvento().getBatallaActual().crew2.getName();
    imgCategoria=dynamics.imgCategoria();
    color=dynamics.getJurado().getHTMLColor();
    winner=dynamics.getWinnerCategoria();
    resultadoCrew1=dynamics.getHTMLResultsCrew1();
    resultadoCrew2=dynamics.getHTMLResultsCrew2();
    total1=dynamics.totalCrew1();
    total2=dynamics.totalCrew2();

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
        <script type="text/javascript" src="HTML/js/script.js">
            
        </script>
        <script type="text/javascript" src="HTML/js/touch-dynamics.js"></script> 
        <link rel="stylesheet" type="text/css" href="HTML/css/estilo-evaluacion-juez.css">
    </head>

    <body onload="mostrar('<%=mensaje%>')">
        <form data-ajax="false">
            <div data-role="page" id="pagina1" >
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
                    <li><a onclick="goTo('WebOUR/resultados-finales.jsp?batalla=<%=idBatalla%>')">Resultados generales</a></li>
                    <li><a onclick="goTo('WebOUR/SingOut.jsp')">Cerrar Sesion</a></li>
                    </ul>
                    </div>

            </div>
            <!-- CONTENIDO -->
            <div id="cuerpo" data-role="content" 
                 data-theme="b"
                 data-position="fixed"      
                 >
                <div >
                <h2 id="h2">Ganador</h2>
                <br>
                <h2 id="h2" style="color:<%=color%>;"><%=winner%></h2>
                <br>
                <br>
                </div>
                <ul  data-role="listview">
        <li  style="background:rgb(30, 30, 30);
        color:rgba(8, 218, 245, 0.92); font-size: 20px;"><%=crew1%></li>
        
       <%=resultadoCrew1%>
                          
        <li style="color:<%=color%>;">Total: <%=total1%></li>
        
         
        <li style="background:rgb(30, 30, 30);
        color:rgba(8, 218, 245, 0.92); font-size: 20px;"><%=crew2%></li>
                
         <%=resultadoCrew2%>
         
        <li style="color:<%=color%>;">Total: <%=total2%></li>
       
     </ul>

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
