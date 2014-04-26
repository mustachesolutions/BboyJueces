<%-- 
    Document   : SingOut
    Created on : 04-17-2014, 05:41:34 PM
    Author     : EltonAlexánder
--%>

<%@page import="control.Sesiones"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:useBean id="batalla" scope="session" class="control.Administrador"/>
<%
     HttpSession sesionOk = request.getSession();
                    sesionOk.setAttribute(Sesiones.sesionJudge, null);
                   response.sendRedirect("LoginJudge.jsp");
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background: rgb(50,50,50);">
        <h1 style="color: white;">Cerrando Sesion</h1>
    </body>
</html>
