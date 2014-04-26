/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import db.ConsultasJurado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Jurado;

/**
 *
 * @author Enrique
 */
public class JuecesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JuecesController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JuecesController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    //EXTRAER INFORMACION DEL DAO EN EL VIEW
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        System.err.println("ESTOY DENTRO");
        if (request.getParameter("action") != null) {
            String action = (String) request.getParameter("action");
            if (action.equals("list")) {
                try {
                    ArrayList<Jurado> listaJurado = new ArrayList<Jurado>();
                                      
                    //Extraer datos de la DB
                    ConsultasJurado consultasEvento = new ConsultasJurado();
                    listaJurado = consultasEvento.extraerListaJurados();

//                    for (int i = 1; i <= listaJurado.size(); i++) {
//                        System.err.println(listaJurado.get(i).getAlias());
//                    }
                    
                    //Convert Java Object to Json
                    Gson gson = new Gson();
                    JsonElement element = gson.toJsonTree(listaJurado, new TypeToken<List<Jurado>>() {
                    }.getType());
                    JsonArray jsonArray = element.getAsJsonArray();
                    String listData = jsonArray.toString();

                    //Return Json in the format required by jTable plugin
                    listData = "{\"Result\":\"OK\",\"Records\":" + listData + "}";
                    response.setContentType("application/json");
                    response.setHeader("Cache-control", "no-cache, no-store");
                    response.setHeader("Pragma", "no-cache");
                    response.setHeader("Expires", "-1");
                    response.getWriter().print(listData);
                    System.out.println(listData);
                } catch (Exception ex) {
                    String error = "{\"Result\":\"ERROR\",\"Message\":" + ex.getStackTrace() + "}";
                    response.getWriter().print(error);
                    System.out.println(error);
                }

            }
        }
    }

// GENERAR NUEVA INFORMACION A PARTIR DE LA CONSULTA SQL QUE PASA AL DAO Y LUEGO A LA TABLA    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
       if(request.getParameter("action")!=null){
			List<Jurado> listaJurados=new ArrayList<Jurado>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
                                ConsultasJurado consultasJurado = new ConsultasJurado();
				listaJurados=consultasJurado.extraerListaJurados();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(listaJurados, new TypeToken<List<Jurado>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData="{\"Result\":\"OK\",\"Records\":"+listData+"}";			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				Jurado jurado = new Jurado();
				
				if(request.getParameter("id_jurado")!=null){
					String idJurado=(String)request.getParameter("id_jurado");
					jurado.setId_jurado(Integer.parseInt(idJurado));
				}
                                if(request.getParameter("nombre_jurado")!=null){
					String nombre=(String)request.getParameter("nombre_jurado");
					jurado.setNombre_jurado(nombre);
				}
                                if(request.getParameter("alias")!=null){
					String alias=(String)request.getParameter("alias");
					jurado.setAlias(alias);
				}
                                if(request.getParameter("password")!=null){
					String password=(String)request.getParameter("password");
					jurado.setPassword(password);
				}
                                if(request.getParameter("categoria")!=null){
					String categoria=(String)request.getParameter("categoria");
					jurado.setCategoria(Integer.parseInt(categoria));
				}
				
				try{											
					if(action.equals("create")){//Create new record
                                            ConsultasJurado consultasJurado = new ConsultasJurado();
						consultasJurado.agregarJurado(jurado);					
						listaJurados.add(jurado);
						//Convert Java Object to Json				
						String json=gson.toJson(jurado);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						ConsultasJurado consultasJurado = new ConsultasJurado();
						consultasJurado.updateJurado(jurado);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("id_jurado")!=null){
						String idJurado=(String)request.getParameter("id_jurado");
						ConsultasJurado consultasJurado = new ConsultasJurado();
						consultasJurado.deleteJurado(Integer.parseInt(idJurado));
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
       }}

}
