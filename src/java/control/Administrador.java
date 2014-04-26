/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import db.ConsultasAdmin;
import db.ConsultasEvento;
import modelo.Admin;
import modelo.Evento;

/**
 *
 * @author EltonAlexánder
 */
public class Administrador {
    private Evento evento=new Evento();
    private Admin admin=new Admin();
    private String mensaje="";
    
     public void actualizarAdmin(String usuario) {
          mensaje="";
        ConsultasAdmin c=new ConsultasAdmin();
         setAdmin(c.buscarAdminPorAlias(usuario));
//         c.desconectar();
         actualizarEvento();
    }
     
    private void actualizarEvento(){
        ConsultasEvento c=new ConsultasEvento();
        setEvento(c.buscarEvento(getAdmin().getIdEvento()));
        getEvento().setBatallaActual(c.buscarBatalla(getAdmin().getIdEvento()));
//        c.desconectar();
    }
    
    public void nuevaBatalla(String crew1, String crew2){
         ConsultasEvento c=new ConsultasEvento();
         c.nuevaBatalla(getAdmin().getIdEvento(),crew1,crew2);
//         c.desconectar();
         actualizarEvento();
    }
    
    public void setUpCrew1Primero(){
        setMensaje(getEvento().getBatallaActual().setUpCrew1Primero());
    }
     public void setUpCrew2Primero(){
        setMensaje(getEvento().getBatallaActual().setUpCrew2Primero());
    }

    /**
     * @return the evento
     */
    public Evento getEvento() {
        return evento;
    }

    /**
     * @param evento the evento to set
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
