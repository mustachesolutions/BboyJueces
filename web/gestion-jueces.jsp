<%-- 
    Document   : agregar-crews
    Created on : 16-abr-2014, 19:36:40
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
                
       <!-- Include one of jTable styles. -->
       <link href="HTML/css/admin/jTables/metro/darkgray/jtable.css" rel="stylesheet" type="text/css" />
       <link href="HTML/css/admin/jTables/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="HTML/js/admin/JTables/jquery-1.8.2.js" type="text/javascript"></script>
<script src="HTML/js/admin/JTables/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="HTML/js/admin/JTables/jquery.jtable.js" type="text/javascript"></script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#JudgesTableContainer').jtable({
            title: 'Jueces',
            actions: {
                listAction: 'JuecesController?action=list',
                
                updateAction: 'JuecesController?action=update'
            },
            fields: {
                id_jurado: {
                    title:'Nº',
                    key: true,
                    width: '5%',
                    edit:false
                    
                },
                nombre_jurado: {
                    title: 'Nombre completo',
                    width: '40%'
                },              
                alias: {
                    title: 'Alias',
                    width: '10%'
                },
                password: {
                    title: 'Password',
                    type: 'password',
                    width: '10%'
                },
                categoria: {
                    title: 'Categoria',
                    width: '10%',
                    edit:false,
                    type: 'radiobutton',
                    options: [
                        { Value: '1', DisplayText: 'Foundation' },
                        { Value: '2', DisplayText: 'Creativity' },
                        { Value: '3', DisplayText: 'Dynamics' },
                        { Value: '4', DisplayText: 'Execution' },
                        { Value: '5', DisplayText: 'Battle' }
                    ]
                }              
            }
        });
        $('#JudgesTableContainer').jtable('load');
    });
</script>                                            
    </head>
    <body>
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
			<div id="JudgesTableContainer"></div> 
		</div>
        

       
        
    </body>
</html>