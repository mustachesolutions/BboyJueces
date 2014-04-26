/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import db.ConsultasEvento;
import db.ConsultasJurado;
import java.awt.Robot;
import java.util.ArrayList;
import modelo.Evento;
import modelo.Jurado;
import modelo.Ronda;

/**
 *
 * @author bboyc_000
 */
public class CategoriaControl {
    private Evento evento=new Evento();
    private Jurado jurado=new Jurado();
    private String mensaje="";
     private boolean nota0=false;
     
     public String getLoginURL(){
         return URL.url+"LoginJudge.jsp";
     }

    public void actualizarJurado(String usuario) {
        ConsultasJurado c=new ConsultasJurado();
         jurado=c.buscarUsuarioPorID(usuario);
//         c.desconectar();
         System.out.println(jurado.getNombre_jurado());
    }

    public CategoriaControl() {
    }

    public String imgCategoria(){
      String url="";
    switch(jurado.getCategoria()){
        case Jurado.foundation:
            url="HTML/imagenes/botones/Foundation/BASE1Foundation.svg";
            break;
        case Jurado.creativity:
            url="HTML/imagenes/botones/Originality/originality1.svg";
            break;
        case Jurado.dynamics:
            url="HTML/imagenes/botones/Dynamics/dynamics1.svg";
            break;
        case Jurado.execution:
            url="HTML/imagenes/botones/Execution/execution1.svg";
            break;
        case Jurado.battle:
            url="HTML/imagenes/botones/Battle/battle1.svg";
            break;
}
    return url;
}
    
    public String getNombreCrew(){
        if(jurado.isCalficado()){
           
             return evento.getBatallaActual().getNextName();
        }
        else{
            return evento.getBatallaActual().getActualName();
        }
       
    }
     
     
    
    public void saveNota(int nota){
        if(evento.getBatallaActual().getId_batalla()==0){
            setMensaje("La batalla no se ha inicializado cargar para volver a intentar");
            return;
        }
         if((evento.getBatallaActual().getTurno()==0)){
            setMensaje("La batalla no se ha inicializado cargar para volver a intentar");
            return;
        }
        
       
        jurado.setNota(nota);
        jurado.saveNotaBattle(evento.getBatallaActual().getNext());
        setMensaje(jurado.getMensaje());
       
    }
    
    
    public void updateNota(int nota){
        if(evento.getBatallaId()==0){
            setMensaje("La batalla no se ha inicializado cargar para volver a intentar");
            return;
        }
       
        jurado.setNota(nota);
        jurado.updateNotaBattle();
        setMensaje(jurado.getMensaje());
       
    }
    
    public void actualizarEvento(){
        ConsultasEvento c=new ConsultasEvento();
        evento=c.buscarEvento(jurado.getId_evento());
        evento.setBatallaActual(c.buscarBatalla(jurado.getId_evento()));
//        c.desconectar();
    }
    
    public String totalCrew1(){
         String total="";
    switch(jurado.getCategoria()){
        case Jurado.foundation:
            total=Integer.toString(evento.getBatallaActual().crew1.getFoundation());
            break;
        case Jurado.creativity:
            total=Integer.toString(evento.getBatallaActual().crew1.getCreativity());
            break;
        case Jurado.dynamics:
            total=Integer.toString(evento.getBatallaActual().crew1.getDynamics());
            break;
        case Jurado.execution:
            total=Integer.toString(evento.getBatallaActual().crew1.getExecution());
            break;
        case Jurado.battle:
            total=Integer.toString(evento.getBatallaActual().crew1.getBattle());
            break;
}
    return total;
    }
    
     public String totalCrew2(){
         String total="";
    switch(jurado.getCategoria()){
        case Jurado.foundation:
            total=Integer.toString(evento.getBatallaActual().crew2.getFoundation());
            break;
        case Jurado.creativity:
            total=Integer.toString(evento.getBatallaActual().crew2.getCreativity());
            break;
        case Jurado.dynamics:
            total=Integer.toString(evento.getBatallaActual().crew2.getDynamics());
            break;
        case Jurado.execution:
            total=Integer.toString(evento.getBatallaActual().crew2.getExecution());
            break;
        case Jurado.battle:
            total=Integer.toString(evento.getBatallaActual().crew2.getBattle());
            break;
}
    return total;
    }
    
     public String getWinnerCategoria(){
         String crewWinner="";
    switch(jurado.getCategoria()){
        case Jurado.foundation:
            crewWinner=evento.getBatallaActual().getWinnerFoundation();
            break;
        case Jurado.creativity:
            crewWinner=evento.getBatallaActual().getWinnerCreativity();
            break;
        case Jurado.dynamics:
            crewWinner=evento.getBatallaActual().getWinnerDynamics();
            break;
        case Jurado.execution:
            crewWinner=evento.getBatallaActual().getWinnerExecution();
            break;
        case Jurado.battle:
            crewWinner=evento.getBatallaActual().getWinnerBattle();
            break;
}
    return crewWinner;
    }
     
    public String getHTMLResultsCrew1(){
       
        ArrayList<Ronda>rondaCrew1=evento.getBatallaActual().crew1.getRondas(evento.getBatallaId());
       
        String html="";
        for (int i = 0; i < rondaCrew1.size(); i++) {
            html=html+"<li>Round "+Integer.toString(i+1)+": "+notaDeJuez(rondaCrew1.get(i))+"</li>";
        }
        return html;
    }
    public String getHTMLResultsCrew2(){
       
        ArrayList<Ronda>rondaCrew2=evento.getBatallaActual().crew2.getRondas(evento.getBatallaId());
       
        String html="";
        for (int i = 0; i < rondaCrew2.size(); i++) {
            html=html+"<li>Round "+Integer.toString(i+1)+": "+notaDeJuez(rondaCrew2.get(i))+"</li>";
        }
        return html;
    }
    
    private String notaDeJuez(Ronda ronda){
        String nota="";
    switch(jurado.getCategoria()){
        case Jurado.foundation:
            nota=Integer.toString(ronda.getFoundation());
            break;
        case Jurado.creativity:
            nota=Integer.toString(ronda.getCreativity());
            break;
        case Jurado.dynamics:
            nota=Integer.toString(ronda.getDynamics());
            break;
        case Jurado.execution:
            nota=Integer.toString(ronda.getExecution());
            break;
        case Jurado.battle:
            nota=Integer.toString(ronda.getBattle());
            break;
}
    return nota;
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
     * @return the jurado
     */
    public Jurado getJurado() {
        return jurado;
    }

    /**
     * @param jurado the jurado to set
     */
    public void setJurado(Jurado jurado) {
        this.jurado = jurado;
    }

    /**
     * @return the nota0
     */
    public boolean isNota0() {
        return nota0;
    }

    /**
     * @param nota0 the nota0 to set
     */
    public void setNota0(boolean nota0) {
        this.nota0 = nota0;
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
    
    public String correctedCrew(){
        return jurado.crewACorregir(this.evento.getBatallaActual().getId_batalla());
    }
    
    
    
}
