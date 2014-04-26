<%-- 
    Document   : LoginJudge
    Created on : 04-01-2014, 10:47:00 PM
    Author     : bboyc_000
--%>

<%@page import="control.Sesiones"%>
<%@page import="control.URL"%>
<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="loginJurado" scope="session" class="control.LoginJurado"/>
<%String url = "";
    String usuario = "";
    String clave = "";
    String mensaje = "";
    mensaje=loginJurado.getMensaje();
    if (request.getParameter("login") != null) {

        if (request.getParameter("usuario") != null) {
            usuario = request.getParameter("usuario");

            if (request.getParameter("clave") != null) {
                clave = request.getParameter("clave");

                loginJurado.setUsername(usuario);
                loginJurado.setPassword(clave);

                if (loginJurado.validarCredencialesUsuario()) {

                    HttpSession sesionOk = request.getSession();
                    sesionOk.setMaxInactiveInterval(86400);
                    sesionOk.setAttribute(Sesiones.sesionJudge, usuario);
                    response.sendRedirect("dynamics.jsp");
                    
                } else {
                   mensaje=loginJurado.getMensaje();
                   response.sendRedirect("LoginJudge.jsp");
                }

            }

        }

    }
%>
<html>
    <head>
        <!-- Adaptar a la version movil de la pagina web -->
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0,
              user-scalable=no">        
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
            <div data-role="page" id="inciarSesion" >
                <!--CABECERA-->
                <div data-role="header" data-theme="a" data-position="fixed">
                    <h1>INICIAR SESION COMO JUEZ</h1>
                </div>        
                <!--BODY-->
                <div data-role="content" data-theme="a">

                    <label for="username">Nombre de Usuario</label>
                    <input type="text" name="usuario" id="username">    

                    <label for="contrasenia">Contraseña</label>
                    <input type="password" name="clave" id="contrasenia">            
                    <!--input style="background: #333333;color: #0099ff;" class="nota"  id="login" type="submit" name="sesion" value="Iniciar Sesion" type="submit"/-->
                    <input  id="blogin" name="login" type="submit" value="Iniciar Sesion" data-role="button" data-theme="b"/>
                </div>       
                <!--FOOTER-->
                <div data-role="footer" data-theme="a" class="ui-bar" data-position="fixed" data-id="pieFijo">
                    <p>OUR Judge's Assistant</p>
                </div>
            </div>
        </form>

    </body>




</html>
