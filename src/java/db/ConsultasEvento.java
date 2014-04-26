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
import modelo.Batalla;
import modelo.Crew;
import modelo.Evento;
import modelo.Ronda;


/**
 *
 * @author bboyc_000
 */
public class ConsultasEvento extends Conection{
    
    
 /**Devuelve el listado de los crew de la batalla actual en el evento
 *@param id id de el evento en ejecucion
 * @author bboyc_000
 */
    
//CONSULTAS PARA LOS CREWS
    
     public ArrayList<Crew> buscarCrews(int id) {
         ArrayList<Crew>crews=new ArrayList<Crew>();
        Crew crew;
         
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call crews(?)");
            ps.setInt(1, id);//a
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               crew=new Crew(rs.getString("nombre_crew"));
               crew.setId_crew(rs.getInt("idcrew"));
               crew.setRound(rs.getInt("ronda"));
               crew.setFoundation(rs.getInt("f"));
               crew.setCreativity(rs.getInt("c"));
               crew.setDynamics(rs.getInt("d"));
               crew.setExecution(rs.getInt("e"));
               crew.setBattle(rs.getInt("b"));
               crew.setTurno(rs.getInt("turno")==crew.getId_crew());
               crews.add(crew);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crews; 
    }
     
public ArrayList<Crew> listaCrews() {
         ArrayList<Crew>crews=new ArrayList<Crew>();
        Crew crew;
         
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("SELECT * FROM judges.crew;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               crew=new Crew(rs.getString("nombre_crew"));
               crew.setId_crew(rs.getInt("idcrew"));            
               crews.add(crew);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return crews; 
    } 

public ArrayList<String> listaNombresCrews() {
         ArrayList<String>listaCrews=new ArrayList<String>();
        String nombre;
         
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("SELECT * FROM judges.crew;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               nombre = rs.getString("nombre_crew");                        
               listaCrews.add(nombre);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCrews; 
    }
     

public int agregarCrew(String nombre) {
    int idCrew=0;
		try {
			
			 PreparedStatement ps = this.getConnection().prepareStatement("call getcrew(?);");
			// Parameters start with 1			
			ps.setString(1, nombre);			
			 ResultSet rs = ps.executeQuery();
            if (rs.next()) {
              idCrew=rs.getInt(1);
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
                return idCrew;
	}
	
	public void deleteCrew(int idCrew) {
		try {
			 PreparedStatement ps = this.getConnection().prepareStatement("DELETE FROM crew WHERE idcrew=?");
			// Parameters start with 1
			ps.setInt(1, idCrew);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCrew(Crew crew) throws ParseException {
		try {
			PreparedStatement ps = this.getConnection().prepareStatement("UPDATE crew SET idcrew=?, nombre_crew=? WHERE idcrew=?");
			// Parameters start with 1			
			ps.setInt(1, crew.getId_crew());
			ps.setString(2, crew.getName());			
			ps.setInt(3, crew.getId_crew());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}




     //Falta terminar
      public ArrayList<Ronda> selectRondas(int idbatalla, int idCrew) {
         ArrayList<Ronda>rondas=new ArrayList<Ronda>();
        Ronda ronda;
         
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("call rondas(?,?)");
            ps.setInt(1, idbatalla);
             ps.setInt(2, idCrew);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               ronda=new Ronda();
              ronda.setNombreCrew(rs.getString("nombre_crew"));
              ronda.setFoundation(rs.getInt("foundation"));
              ronda.setCreativity(rs.getInt("creativity"));
              ronda.setDynamics(rs.getInt("dynamics"));
              ronda.setExecution(rs.getInt("execution"));
              ronda.setBattle(rs.getInt("battle"));
               rondas.add(ronda);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rondas; 
    }
     
     
     public Batalla buscarBatalla(int idEvento){
         Batalla batalla;
         
         batalla=new Batalla();
         try {
            PreparedStatement ps = this.getConnection().prepareStatement("select a.idbatalla,finish,turno,a.idevento from batalla a,evento b where a.idevento=b.idevento"
                    + " and a.idbatalla=b.batalla and a.idevento=?");
            ps.setInt(1, idEvento);
            ResultSet rs = ps.executeQuery();
           if(rs.next()) {
              batalla.setId_batalla(rs.getInt("idbatalla"));
              batalla.setFinish(rs.getBoolean("finish"));
              batalla.setTurno(rs.getInt("turno"));
              batalla.setIdEvento(rs.getInt("idevento"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         ArrayList<Crew>crews=buscarCrews(batalla.getId_batalla());
         if(crews.size()>1){
            batalla.setCrews(crews.get(0),crews.get(1));
         }
         
         return batalla;
     }
     
      public Batalla buscarBatallaPorID(int idBatalla){
         Batalla batalla=new Batalla();
         
         batalla=new Batalla();
         try {
            PreparedStatement ps = this.getConnection().prepareStatement("select idbatalla,finish,turno,idevento from batalla Where idbatalla=?");
            ps.setInt(1, idBatalla);
            ResultSet rs = ps.executeQuery();
           if(rs.next()) {
              batalla.setId_batalla(rs.getInt("idbatalla"));
              batalla.setFinish(rs.getBoolean("finish"));
              batalla.setTurno(rs.getInt("turno"));
              batalla.setIdEvento(rs.getInt("idevento"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         ArrayList<Crew>crews=buscarCrews(idBatalla);
         if(crews.size()>1){
          batalla.setCrews(crews.get(0),crews.get(1));
         }
         return batalla;
     }

    public Evento buscarEvento(int id_evento) {
        Evento evento=new Evento();
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("select* from evento where idevento=?");
            ps.setInt(1, id_evento);
            ResultSet rs = ps.executeQuery();
           if(rs.next()) {
              evento.setId_evento(rs.getInt("idevento"));
              evento.setNombre(rs.getString("nombre_evento"));
              evento.setBatallaId(rs.getInt("batalla"));
              evento.setIdAdmin(rs.getInt("idadmin"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasEvento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evento;
    }

    public void nuevaBatalla(int idEvento, String crew1, String crew2) {
        int idCrew1,idCrew2;
        idCrew1=agregarCrew(crew1);
        idCrew2=agregarCrew(crew2);
        try {
			
			 PreparedStatement ps = this.getConnection().prepareStatement("call nueva_batalla_crews(?,?,?);");
			// Parameters start with 1			
			ps.setInt(1, idCrew1);
                        ps.setInt(2, idCrew2);
                        ps.setInt(3, idEvento);
			ps.executeQuery();
           

		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }

    public String setUpFirstCrew(int id_batalla,int id_crew) {
         try {
			
			 PreparedStatement ps = this.getConnection().prepareStatement("call set_up_first(?,?);");
			// Parameters start with 1			
			ps.setInt(1, id_batalla);
                       ps.setInt(2, id_crew);
			 ResultSet rs = ps.executeQuery();
           

		} catch (SQLException e) {
			return "No se pudo establecer el primero";
		}
         return "Todo listo para comenzar!";
    }

    public ArrayList<Integer> buscarIDDeBatallas(int idEvento) {
        ArrayList<Integer>ids=new ArrayList<Integer>();
        
         
        try {
            PreparedStatement ps = this.getConnection().prepareStatement("SELECT idbatalla FROM batalla where idevento=?;");
            ps.setInt(1, idEvento);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                          
               ids.add(rs.getInt(1));
            }
            rs.close();
        } catch (SQLException ex) {
           
        }
        return ids;
    }
    
}
