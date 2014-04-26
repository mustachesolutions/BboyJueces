/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;



//OTROS IMPORTS
import java.io.IOException;

import java.util.ArrayList;

import java.util.List;


import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.google.gson.JsonArray;

import com.google.gson.JsonElement;

import com.google.gson.reflect.TypeToken;
import db.ConsultasAdmin;
import db.ConsultasEvento;

import modelo.Admin;
import modelo.Crew;


/**
 *
 * @author Enrique
 */
@WebServlet(name = "CRUDController", urlPatterns = {"/CRUDController"})
public class CRUDController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    Admin admin=new Admin();
    
    public CRUDController() {

    }
    
    /**Carga el administrador por su nombre de sesion y sirve para uso de su id_evento para usar en los filtros de jueces
     * 
     * @param usuario 
     */
     public void actualizarAdmin(String usuario) {
        ConsultasAdmin c=new ConsultasAdmin();
         admin=c.buscarAdminPorAlias(usuario);
//         c.desconectar();
        
    }
    
//EXTRAER INFORMACION DEL DAO A EL VIEW
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        if (request.getParameter("action") != null) {
            String action = (String) request.getParameter("action");
            if (action.equals("list")) {
                try {
                    List<Crew> listaCrews = new ArrayList<Crew>();

                    //Extraer datos de la DB
                    ConsultasEvento consultasEvento = new ConsultasEvento();
                    listaCrews = consultasEvento.listaCrews();

                    //Convert Java Object to Json
                    Gson gson = new Gson();
                    JsonElement element = gson.toJsonTree(listaCrews, new TypeToken<List<Crew>>() {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
       if(request.getParameter("action")!=null){
			List<Crew> listaCrews=new ArrayList<Crew>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
                                ConsultasEvento consultasEvento = new ConsultasEvento();
				listaCrews=consultasEvento.listaCrews();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(listaCrews, new TypeToken<List<Crew>>() {}.getType());
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
				Crew crew = new Crew();
				
				if(request.getParameter("nombre")!=null){
					String nombre=(String)request.getParameter("nombre");
					crew.setName(nombre);
				}
                                if(request.getParameter("id_crew")!=null){
					String idCrew=(String)request.getParameter("id_crew");
					crew.setId_crew(Integer.parseInt(idCrew));
				}
				
				try{											
					if(action.equals("create")){//Create new record
                                            ConsultasEvento consultasEvento = new ConsultasEvento();
						consultasEvento.agregarCrew(crew.getName());					
						listaCrews.add(crew);
						//Convert Java Object to Json				
						String json=gson.toJson(crew);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						ConsultasEvento consultasEvento = new ConsultasEvento();
						consultasEvento.updateCrew(crew);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("id_crew")!=null){
						String crewid=(String)request.getParameter("id_crew");
						ConsultasEvento consultasEvento = new ConsultasEvento();
						consultasEvento.deleteCrew(Integer.parseInt(crewid));
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
