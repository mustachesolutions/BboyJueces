<%-- 
    Document   : resultados-finales
    Created on : 11-abr-2014, 23:19:49
    Author     : Enrique
--%>

<%@page import="control.ResultadosFinales"%>
<%@page import="control.Sesiones"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="control.CategoriaControl"%>

<%@page contentType="text/html" session="true" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<jsp:useBean id="finalResult" scope="session" class="control.ResultadosFinales"/>
<%
    finalResult=new ResultadosFinales();
    String mensaje = "";
     String parametro= request.getParameter("batalla");
   if(parametro!=null){
   finalResult.buscarBatalla(Integer.parseInt(parametro));
   
   }else{
       parametro="0";
        mensaje="No es una ruta válida";
   }
    //NOMBRES DE LOS CREWS
    String nombreCrew1 = finalResult.batalla.crew1.getName();
    String nombreCrew2 = finalResult.batalla.crew2.getName();

    //NOTAS DEL CREW 1
    String notaFoundation1 = Integer.toString(finalResult.batalla.crew1.getFoundation());
    String notaExecution1 = Integer.toString(finalResult.batalla.crew1.getExecution());
    String notaDynamics1 = Integer.toString(finalResult.batalla.crew1.getDynamics());
    String notaBattle1 = Integer.toString(finalResult.batalla.crew1.getBattle());
    String notaCreativity1 = Integer.toString(finalResult.batalla.crew1.getCreativity());

    //NOTAS DEL CREW 2
    String notaFoundation2 = Integer.toString(finalResult.batalla.crew2.getFoundation());
    String notaExecution2 = Integer.toString(finalResult.batalla.crew2.getExecution());
    String notaDynamics2 = Integer.toString(finalResult.batalla.crew2.getDynamics());
    String notaBattle2 = Integer.toString(finalResult.batalla.crew2.getBattle());
    String notaCreativity2 = Integer.toString(finalResult.batalla.crew2.getCreativity());

    //CALCULO DE RESULTADO FINAL
    int notaFinal1 = finalResult.batalla.crew1.getFoundation()
            + finalResult.batalla.crew1.getExecution()
            + finalResult.batalla.crew1.getDynamics()
            + finalResult.batalla.crew1.getBattle()
            + finalResult.batalla.crew1.getCreativity();

    int notaFinal2 = finalResult.batalla.crew2.getFoundation()
            + finalResult.batalla.crew2.getExecution()
            + finalResult.batalla.crew2.getDynamics()
            + finalResult.batalla.crew2.getBattle()
            + finalResult.batalla.crew2.getCreativity();

    //Comversion a Strings de las notas finales
    String notaFinalCrew1 = Integer.toString(notaFinal1);
    String notaFinalCrew2 = Integer.toString(notaFinal2);
    
   
    String imagenes[] = finalResult.obtenerDireccionesImagenes();
finalResult=null;

%>




<html>


    <head>
        <title>Page title</title>
        <link rel="stylesheet" type="text/css" href="HTML/css/admin/estilo-resultados.css" />
    </head>
    <body>
        <header> 
            <h2 class="estiloh2">NOMBRE DEL EVENTO <a class="boton" href='reporte.jsp?batalla=<%=parametro%>'>Ver rondas</a></h2>  
            <h3 class="estiloh3"> </h3>
            
        </header>

        <div id="divCentro">
            <table width="100%" border="0"  cellpadding="2" cellspacing="1" bordercolor="gray">
                <tr><td class="tituloJuez" > <%=nombreCrew1%> </td><td></td> <td class="tituloJuez"> <%=nombreCrew2%> </td> </tr>
            <tr><td class="valorJuez"><img src="<%=imagenes[0]%>" border="0"> <img src="<%=imagenes[1]%>" border="0"> <img src="<%=imagenes[2]%>" border="0"> <img src="<%=imagenes[3]%>" border="0"> <img src="<%=imagenes[4]%>" border="0"></td>
                <td></td> 
                <td class="valorJuez"> <img src="<%=imagenes[10]%>" border="0"> <img src="<%=imagenes[11]%>" border="0"> <img src="<%=imagenes[12]%>" border="0"> <img src="<%=imagenes[13]%>" border="0"> <img src="<%=imagenes[14]%>" border="0"></td> </tr>
                <tr> 
                    <th class="thIzq">  </th><th></th><th class="thDer">  </th>
                </tr>  

                <tr> 

                    <td class="alinearDer"><%= notaFoundation1%></td>
                    <td class="centro"><img src="<%=imagenes[5]%>"></td>
                    <td class="alinearIzq"><%= notaFoundation2%></td>
                </tr>
                <tr> 
                    <td class="alinearDer"><%=notaCreativity1%></td>
                    <td><img src="<%=imagenes[6]%>"></td>
                    <td class="alinearIzq"><%=notaCreativity2%></td>
                </tr>
                <tr> 
                    <td class="alinearDer"><%=notaDynamics1%></td>
                    <td><img src="<%=imagenes[7]%>"> </td>
                    <td class="alinearIzq"><%=notaDynamics2%></td>
                </tr>
                <tr> 
                    <td class="alinearDer"><%=notaExecution1%></td>
                    <td><img src="<%=imagenes[8]%>"></td>
                    <td class="alinearIzq"><%=notaExecution2%></td>
                </tr>
                <tr> 
                    <td class="alinearDer"><%=notaBattle1%></td>
                    <td><img src="<%=imagenes[9]%>"></td>
                    <td class="alinearIzq"><%=notaBattle2%></td>
                </tr>

                <tr> 
                    <td class="alinearDer"><%=notaFinalCrew1%> </td>
                    <td>TOTAL</td>
                    <td class="alinearIzq"><%=notaFinalCrew2%></td>
                </tr>

            </table>
        </div>    




    </body>






</html>
