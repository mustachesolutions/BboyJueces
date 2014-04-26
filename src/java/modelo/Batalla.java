/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.ConsultasEvento;



/**
 *
 * @author rivera
 */
public class Batalla {
//Datos datos=new Datos();

    private int id_batalla;
    public int crew = 1;
    public Crew crew1 = new Crew("PRIMERO");
    public Crew crew2 = new Crew("SEGUNDO");
    private String winner = "TIE";
    private int turno;
    private boolean finish=false;
    private int idEvento;

    public void setCrews(Crew c1, Crew c2) {
        crew1=c1;
            crew2=c2;
       
        if(c2.isTurno()){
            
          crew=2;
        }else{
           crew=1;
          
        }
    }

    public Batalla() {

    }
    
    public String mensajeDeRonda(){
        String msg="";
        if (crew1.getRound() > crew2.getRound()) {
            msg="A "+crew2.getName()+" le falta una ronda";
        }
        if (crew1.getRound() < crew2.getRound()) {
            msg="A "+crew1.getName()+" le falta una ronda";
        }
        return msg;
    }
    public String getWinnerFoundation() {
        
            if (crew1.getFoundation() > crew2.getFoundation()) {
               
                return crew1.getName();
            }
            if (crew1.getFoundation() < crew2.getFoundation()) {
                
                return crew2.getName();
            }
            if (crew1.getFoundation() == crew2.getFoundation()) {
                return "TIE";
            }

       
        return mensajeDeRonda();
    }

    public String getWinnerCreativity() {
        
            if (crew1.getCreativity() > crew2.getCreativity()) {
                
                return crew1.getName();
            }
            if (crew1.getCreativity() < crew2.getCreativity()) {
              
                return crew2.getName();
            }
            if (crew1.getCreativity() == crew2.getCreativity()) {
                return "TIE";
            }
       
        return mensajeDeRonda();
    }

    public String getWinnerDynamics() {
        
            if (crew1.getDynamics() > crew2.getDynamics()) {
               
                return crew1.getName();
            }
            if (crew1.getDynamics() < crew2.getDynamics()) {
                
                return crew2.getName();
            }
            if (crew1.getDynamics() == crew2.getDynamics()) {
                return "TIE";
            }
       
        return mensajeDeRonda();
    }

    public String getWinnerExecution() {
        
            if (crew1.getExecution() > crew2.getExecution()) {
                
                return crew1.getName();
            }
            if (crew1.getExecution() < crew2.getExecution()) {
                
                return crew2.getName();
            }
            if (crew1.getExecution() == crew2.getExecution()) {
                return "TIE";
            }
        
        return mensajeDeRonda();
    }

    public String getWinnerBattle() {
        
            if (crew1.getBattle() > crew2.getBattle()) {
                
                return crew1.getName();
            }
            if (crew1.getBattle() < crew2.getBattle()) {
               
                return crew2.getName();
            }
            if (crew1.getBattle() == crew2.getBattle()) {
                return "TIE";
            }
        
        return mensajeDeRonda();
    }
    

    private void calcularFoundation() {
       
            if (crew1.getFoundation() > crew2.getFoundation()) {
                crew1.setPremios(crew1.getPremios() + 1);
                
            }
            if (crew1.getFoundation() < crew2.getFoundation()) {
                crew2.setPremios(crew2.getPremios() + 1);
                
            }
           

       
    }

    private void calcularCreativity() {
        
            if (crew1.getCreativity() > crew2.getCreativity()) {
                crew1.setPremios(crew1.getPremios() + 1);
                
            }
            if (crew1.getCreativity() < crew2.getCreativity()) {
                crew2.setPremios(crew2.getPremios() + 1);
                
            }
            
      
       
    }

    private void calclarDynamics() {
        
            if (crew1.getDynamics() > crew2.getDynamics()) {
                crew1.setPremios(crew1.getPremios() + 1);
                
            }
            if (crew1.getDynamics() < crew2.getDynamics()) {
                crew2.setPremios(crew2.getPremios() + 1);
              
            }
            
      
       
    }

    private void calcularExecution() {
        
            if (crew1.getExecution() > crew2.getExecution()) {
                crew1.setPremios(crew1.getPremios() + 1);
               
            }
            if (crew1.getExecution() < crew2.getExecution()) {
                crew2.setPremios(crew2.getPremios() + 1);
                
            }
           
     
       
    }

    private void calcularBattle() {
        
            if (crew1.getBattle() > crew2.getBattle()) {
                crew1.setPremios(crew1.getPremios() + 1);
                
            }
            if (crew1.getBattle() < crew2.getBattle()) {
                crew2.setPremios(crew2.getPremios() + 1);
               
            }
           
       
       
    }

//    public void setNotasCrew1(int F, int C, int D, int E, int B) {
//        crew = 2;
//        crew1.setFoundation(F);
//        crew1.setCreativity(C);
//        crew1.setDynamics(D);
//        crew1.setExecution(E);
//        crew1.setBattle(B);
//    }
//
//    public void setNotasCrew2(int F, int C, int D, int E, int B) {
//        crew = 1;
//        crew2.setFoundation(F);
//        crew2.setCreativity(C);
//        crew2.setDynamics(D);
//        crew2.setExecution(E);
//        crew2.setBattle(B);
//    }

    public int getTotalCrew1() {
        return crew1.getTotal();
    }

    public int getTotalCrew2() {
        return crew2.getTotal();
    }

    public String getWinner() {
        winner = "TIE";
        crew1.setPremios(0);
        crew2.setPremios(0);
        calcularExecution();
        calcularBattle();
        calcularCreativity();
        calclarDynamics();
        calcularFoundation();
        if (crew1.getPremios() > crew2.getPremios()) {
            winner = crew1.getName();

        } else {
            if (crew1.getPremios() < crew2.getPremios()) {
                winner = crew2.getName();
            } else {
                if (crew1.getPremios() == crew2.getPremios()) {
                    if (getTotalCrew1() == getTotalCrew2()) {
                        winner = "TIE";

                    } else {
                        if (getTotalCrew1() > getTotalCrew2()) {
                            winner = crew1.getName();

                        } else {
                            if (getTotalCrew1() < getTotalCrew2()) {
                                winner = crew2.getName();
                            }

                        }
                    }
                }
            }
        }
        return winner;
    }

    /**
     * @return the id_batalla
     */
    public int getId_batalla() {
        return id_batalla;
    }

    /**
     * @param id_batalla the id_batalla to set
     */
    public void setId_batalla(int id_batalla) {
        this.id_batalla = id_batalla;
    }
    public int getNext(){
        if (crew==2) {
            return crew1.getId_crew();
        }else{
            return crew2.getId_crew();
        }
        
    }
    
    public String getActualName(){
        
        
        if (crew==2) {
             return crew2.getName();
            
        }else{
           return crew1.getName();
               
           
            
        }
        
    }
    
    public String getNextName(){
        if (crew==2) {
            return crew1.getName();
        }else{
           
                return crew2.getName();
           
            
        }
        
    }

    /**
     * @return the turno
     */
    public int getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * @return the finish
     */
    public boolean isFinish() {
        return finish;
    }

    /**
     * @param finish the finish to set
     */
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String setUpCrew1Primero() {
        if(crew1.getRound()>0 || crew2.getRound()>0){
            return "El primero de la batalla ya fue establecido";
        }
        String msg;
        ConsultasEvento c=new ConsultasEvento();
        msg=c.setUpFirstCrew(id_batalla,crew1.getId_crew());
//        c.desconectar();
        return msg;
    }

    public String setUpCrew2Primero() {
        if(crew1.getRound()>0 || crew2.getRound()>0){
            return "El primero de la batalla ya fue establecido";
        }
        String msg;
        ConsultasEvento c=new ConsultasEvento();
        msg=c.setUpFirstCrew(id_batalla,crew2.getId_crew());
//        c.desconectar();
        return msg;
    }

}
