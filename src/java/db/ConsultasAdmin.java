/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Admin;
import modelo.Jurado;

/**
 *
 * @author EltonAlexánder
 */
public class ConsultasAdmin extends Conection{

    public Admin buscarAdminPorAlias(String usuario) {//Este es el mismo que por ID
        Admin admin=new Admin();
         
        try {
            
            PreparedStatement ps = this.getConnection().prepareStatement("SELECT* from admin where nombre_admin='"+usuario+"';");
            
     
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                admin.setIdAdmin(rs.getInt("idadmin"));
                admin.setNombre(rs.getString("nombre_admin"));
                admin.setPassword(rs.getString("pass"));
                admin.setIdEvento(rs.getInt("idevento"));
                
                
             
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasJurado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin; }

//    public Admin buscarAdminPorID(String username) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
