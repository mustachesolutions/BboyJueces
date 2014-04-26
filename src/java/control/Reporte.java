/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import db.ConsultasEvento;
import java.util.ArrayList;
import modelo.Batalla;
import modelo.Ronda;

/**
 *
 * @author EltonAlexánder
 */
public class Reporte {
    private String mensaje="";

    public String htmlEvento(int idEvento){
       
        
        ConsultasEvento c=new ConsultasEvento();
        String html="<h1>"+c.buscarEvento(idEvento).getNombre()+"</h1>";
        ArrayList<Integer>ids=c.buscarIDDeBatallas(idEvento);
//        c.desconectar();
        for (Integer id : ids) {
            html = html + htmlBattle(id);  
        }
        return html;
    }
    
    public String htmlBattle(int idbatalla) {
    ArrayList<Ronda> crew1 = new ArrayList<Ronda>();
    ArrayList<Ronda> crew2 = new ArrayList<Ronda>();
        ConsultasEvento c=new ConsultasEvento();
        Batalla batalla=c.buscarBatallaPorID(idbatalla);
        crew1=c.selectRondas(idbatalla, batalla.crew1.getId_crew());
        crew2=c.selectRondas(idbatalla, batalla.crew2.getId_crew());
//        c.desconectar();
        Ronda rondaCrew1,rondaCrew2;
        setMensaje(batalla.mensajeDeRonda());
        String html = "<h2>"+batalla.crew1.getName()+" vs "+batalla.crew2.getName()+"</h2>";
        int j=0;
        for (int i = crew1.size() - 1; i >= 0; i--) {
            j++;
            if(crew1.size()<i+1){
                rondaCrew1=new Ronda();
                
            }else{
                  rondaCrew1=crew1.get(i);
            }
            if(crew2.size()<i+1){
                  rondaCrew2=new Ronda();
            }else{
                  rondaCrew2=crew2.get(i);
            }
            html = html + htmlRound(rondaCrew1, rondaCrew2, j);

            if (i == 0) {
                html = html + "<div style=\"background: #e0dfdf;\">\n"
                        + "<table border=\"0\" >\n"
                        + "  \n"
                        + "<tr>\n"
                        + "    <td >Total:</td>\n"
                        + "    <td >&nbsp;&nbsp;Bboy/Crew&nbsp;&nbsp;</td>\n"
                        + "    <td>Foundation</td>\n"
                        + "    <td>Creativity</td>\n"
                        + "    <td>Dynamics</td>\n"
                        + "    <td>Execution</td>\n"
                        + "    <td>Battle</td>\n"
                        + "  </tr>\n"
                        + "<tr>\n"
                        + "    <td></td>\n"
                       + "    <td>"+batalla.crew1.getName()+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew1.getFoundation())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew1.getCreativity())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew1.getDynamics())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew1.getExecution())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew1.getBattle())+"</td>\n"
                        + "  </tr>\n"
                        + "<tr>\n"
                        + "    <td></td>\n"
                        + "    <td>"+batalla.crew2.getName()+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew2.getFoundation())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew2.getCreativity())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew2.getDynamics())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew2.getExecution())+"</td>\n"
                        + "    <td>"+Integer.toString(batalla.crew2.getBattle())+"</td>\n"
                        + "  </tr>\n"
                        + "</table> \n"
                        + "<br> \n" 
                        + "<label>Winner: "+batalla.getWinner()+"</label>"
                        + "</div>";
            }
        }
        return html;
    }

    private String htmlRound(Ronda rondaCrew1, Ronda rondaCrew2, int numeroRonda) {
        String html = "<table border=\"0\" >\n"
                + "  \n"
                + "<tr>\n"
                + "    <td >Round: " + Integer.toString(numeroRonda) + "</td>\n"
                + "    <td >&nbsp;&nbsp;Bboy/Crew&nbsp;&nbsp;</td>\n"
                + "    <td>Foundation</td>\n"
                + "    <td>Creativity</td>\n"
                + "    <td>Dynamics</td>\n"
                + "    <td>Execution</td>\n"
                + "    <td>Battle</td>\n"
                + "  </tr>\n"
                + "<tr>\n"
                + "    <td></td>\n"
                + "    <td>" + rondaCrew1.getNombreCrew() + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew1.getFoundation()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew1.getCreativity()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew1.getDynamics()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew1.getExecution()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew1.getBattle()) + "</td>\n"
                + "  </tr>\n"
                + "<tr>\n"
                + "    <td></td>\n"
                + "    <td>" + rondaCrew2.getNombreCrew() + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew2.getFoundation()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew2.getCreativity()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew2.getDynamics()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew2.getExecution()) + "</td>\n"
                + "    <td>" + Integer.toString(rondaCrew2.getBattle()) + "</td>\n"
                + "  </tr>\n"
                + "</table>  \n"
                + "<br></br>";
        return html;
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
