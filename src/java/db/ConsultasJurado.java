/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Crew;
import modelo.Jurado;

/**
 *
 * @author Enrique
 */
public class ConsultasJurado extends Conection{
    
     public Jurado buscarUsuarioPorID(String id) {
        Jurado jurado=new Jurado();
         
        try {
            
            PreparedStatement ps = this.getConnection().prepareStatement("SELECT* from jurado where alias='"+id+"';");
            
     
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                jurado.setId_jurado(rs.getInt("idjurado"));
                jurado.setNombre_jurado(rs.getString("nombre_jurado"));
                jurado.setPassword(rs.getString("password"));
                jurado.setCategoria(rs.getInt("categoria"));
                jurado.setId_evento(rs.getInt("idevento"));
                jurado.setAlias(rs.getString("alias"));
                
             
            }
            rs.close();
        } catch (SQLException ex) {
            
        }
        return jurado; 
    }
     
//METODOS PARA EL CRUD DE JURADO     
      public ArrayList <Jurado> extraerListaJurados() {
        
        ArrayList <Jurado> listaJurados = new <Jurado> ArrayList();
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("SELECT * from jurado;");
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Jurado jurado=new Jurado();
                jurado.setId_jurado(rs.getInt("idjurado"));
                jurado.setNombre_jurado(rs.getString("nombre_jurado"));
                jurado.setPassword(rs.getString("password"));
                jurado.setCategoria(rs.getInt("categoria"));             
                jurado.setId_evento(rs.getInt("idevento"));             
                jurado.setAlias(rs.getString("alias"));   
                
              listaJurados.add(jurado);
            }
           rs.close();        
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasJurado.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaJurados; 
    }
      
      public void agregarJurado(Jurado jurado) {
    
		try {
			
			 PreparedStatement ps = this.getConnection()
                         .prepareStatement("INSERT INTO jurado (`nombre_jurado`, `password`, `categoria`, `conectado`, `id_evento`,`alias`) VALUES (?, ?, ?, ?, ?, ?);");
			// Parameters start with 1			
			ps.setString(1, jurado.getNombre_jurado());
                        ps.setString(2, jurado.getPassword());	
                        ps.setInt(3, jurado.getCategoria());	
                        ps.setBoolean(4, jurado.isConectado());	
                        ps.setInt(5, jurado.getId_evento());	
                        ps.setString(6, jurado.getAlias());
                        
			ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
              
	}
	
	public void deleteJurado(int idJurado) {
		try {
			 PreparedStatement ps = this.getConnection().prepareStatement("DELETE FROM jurado WHERE idjurado=? ;");
			// Parameters start with 1
			ps.setInt(1, idJurado);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateJurado(Jurado jurado) throws ParseException {
		try {
			PreparedStatement ps = this.getConnection()
                        .prepareStatement("UPDATE jurado SET `nombre_jurado`=?, `password`=?, `categoria`=?, `alias`=? WHERE `idjurado`=?;");
			// Parameters start with 1			
			ps.setString(1, jurado.getNombre_jurado());
			ps.setString(2, jurado.getPassword());			
			ps.setInt(3, jurado.getCategoria());
                        ps.setString(4, jurado.getAlias());
                        ps.setInt(5, jurado.getId_jurado());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


      

    public String foundationScore(int id_evento, int nota, int next) {
        String mensaje="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call foundation_score(?,?,?);");
            ps.setInt(1, id_evento);
            ps.setInt(2, nota);
            ps.setInt(3, next);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               mensaje=rs.getString(1);
            }
           rs.close();        
        } catch (SQLException ex) {
           mensaje="No se pudo guardar la nota";
        }
        return mensaje;
    }

    public String cerativityScore(int id_evento, int nota, int next) {
        String mensaje="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call creativity_score(?,?,?);");
            ps.setInt(1, id_evento);
            ps.setInt(2, nota);
            ps.setInt(3, next);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               mensaje=rs.getString(1);
            }
           rs.close();        
        } catch (SQLException ex) {
           mensaje="No se pudo guardar la nota";
        }
        return mensaje;
    }

    public String dynamicsScore(int id_evento, int nota, int next) {
        String mensaje="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call dynamics_score(?,?,?);");
            ps.setInt(1, id_evento);
            ps.setInt(2, nota);
            ps.setInt(3, next);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               mensaje=rs.getString(1);
            }
           rs.close();        
        } catch (SQLException ex) {
           mensaje="No se pudo guardar la nota";
        }
        return mensaje;
    }

    public String executionScore(int id_evento, int nota, int next) {
       String mensaje="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call execution_score(?,?,?);");
            ps.setInt(1, id_evento);
            ps.setInt(2, nota);
            ps.setInt(3, next);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               mensaje=rs.getString(1);
            }
           rs.close();        
        } catch (SQLException ex) {
           mensaje="No se pudo guardar la nota";
        }
        return mensaje;
    }

    public String battleScore(int id_evento, int nota, int next) {
        String mensaje="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call battle_score(?,?,?);");
            ps.setInt(1, id_evento);
            ps.setInt(2, nota);
            ps.setInt(3, next);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               mensaje=rs.getString(1);
            }
           rs.close();        
        } catch (SQLException ex) {
           mensaje="No se pudo guardar la nota";
        }
        return mensaje;
    }
   
 public boolean isCalficado(int id_evento, int categoria) {
     String campo="";
     switch(categoria){
        case Jurado.foundation:
           campo="foundation_save";
            break;
        case Jurado.creativity:
           campo="creativity_save";
            break;
        case Jurado.dynamics:
            campo="dynamics_save";
            break;
        case Jurado.execution:
           campo="execution_save";
            break;
        case Jurado.battle:
            campo="battle_save";
            break;
}
     
        boolean califico=false;
        try {
            PreparedStatement ps = this.getConnection().prepareStatement(" SELECT "+campo+" from ronda where idronda=get_idronda(?);");
            ps.setInt(1, id_evento);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              califico=rs.getBoolean(1);
            }
           rs.close();        
        } catch (SQLException ex) {
          
        }
        return califico;
    }
 
      public String correctedCrew(int id_batalla,String categoria) {
        String crew="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("Select nombre_crew from ronda a,crew b \n" +
"			where idbatalla=? and "+categoria+"=true and a.idcrew=b.idcrew order by idronda desc limit 1;");
            ps.setInt(1, id_batalla);
           
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               crew=rs.getString(1);
            }
               System.err.println(ps.toString());
                System.err.println(crew);
           rs.close();        
        } catch (SQLException ex) {
          
        }
       
        return crew;
    }
      
      public String correctedScore(int id_batalla,String categoria,String campo) {
        String crew="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("Select "+campo+" from ronda a,crew b \n" +
"			where idbatalla=? and "+categoria+"=true and a.idcrew=b.idcrew order by idronda desc limit 1;");
            ps.setInt(1, id_batalla);
           
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               crew=rs.getString(1);
            }
               System.err.println(ps.toString());
                System.err.println(crew);
           rs.close();        
        } catch (SQLException ex) {
          
        }
       
        return crew;
    }
      
     public String updateScore(int id_evento,int categoria, int nota) {
        String mensaje="";
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call modificar_nota(?,?,?);");
            ps.setInt(1, id_evento);
            ps.setInt(2, categoria);
            ps.setInt(3, nota);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
               mensaje=rs.getString(1);
            }
           rs.close();        
        } catch (SQLException ex) {
           mensaje="No se pudo guardar la nota";
        }
        return mensaje;
    }

   
    
}
