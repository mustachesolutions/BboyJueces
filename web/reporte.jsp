<%-- 
    Document   : reporte
    Created on : 04-19-2014, 10:26:01 PM
    Author     : EltonAlexánder
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:useBean id="reporte" scope="session" class="control.Reporte"/>
<%
    reporte.setMensaje("");
    String mensaje = "";
    String html = "";
    String evento = request.getParameter("evento");
    String batalla = request.getParameter("batalla");
    String titulo = "";
    if (batalla != null) {
        html = reporte.htmlBattle(Integer.parseInt(batalla));
        titulo = "Reporte de Batalla";
        reporte.getMensaje();
    } else {
        if (evento != null) {
            html = reporte.htmlEvento(Integer.parseInt(evento));
            titulo = "Reporte de Evento";

        } else {
            html = "No es una ruta válida";
        }
    }
%>
<html>
    <head>
        <title><%=titulo%></title>
        <meta charset="UTF-8" />
        <meta name="description" content="Reporte" />
        <meta name="keywords" content="Bboy, our, breakdance, crews" />
        <meta name="author" content="Enrique Ramirez, Elton Rivera" />
        <link rel="stylesheet" type="text/css" href="HTML/css/admin/reporte.css" />
    </head>
    <body>
        
        <%=html%>
    </body>
</html>
