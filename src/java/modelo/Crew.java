/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author rivera
 */
public class Crew implements Serializable {

    private int id_crew;
    private int id_batalla;
    private String nombre = "";
    private int foundation = 0;
    private int creativity = 0;
    private int dynamics = 0;
    private int execution = 0;
    private int battle = 0;
    private int round = 0;
    private int total = 0;
    private int premios = 0;
    private boolean turno=false;

    public Crew(String nombre) {
        this.nombre = nombre;
    }

    public Crew() {
        
    }

    

    /**
     * @return the total
     */
    public int getTotal() {
        total = getFoundation() + getCreativity() + getDynamics() + getExecution() + getBattle();
        return total;
    }

    /**
     * @return the name
     */
    public String getName() {
        return nombre;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.nombre = name;
    }

    /**
     * @return the foundation
     */
    public int getFoundation() {
        return foundation;
    }

    /**
     * @param foundation the foundation to set
     */
    public void setFoundation(int foundation) {

        this.foundation = foundation;
    }

    /**
     * @return the creativity
     */
    public int getCreativity() {
        return creativity;
    }

    /**
     * @param creativity the creativity to set
     */
    public void setCreativity(int creativity) {
        this.creativity = creativity;
    }

    /**
     * @return the dynamics
     */
    public int getDynamics() {
        return dynamics;
    }

    /**
     * @param dynamics the dynamics to set
     */
    public void setDynamics(int dynamics) {
        this.dynamics = dynamics;
    }

    /**
     * @return the execution
     */
    public int getExecution() {
        return execution;
    }

    /**
     * @param execution the execution to set
     */
    public void setExecution(int execution) {
        this.execution = execution;
    }

    /**
     * @return the battle
     */
    public int getBattle() {
        return battle;
    }

    /**
     * @param battle the battle to set
     */
    public void setBattle(int battle) {
        this.battle = battle;
    }

    /**
     * @return the round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round the round to set
     */
    public void setRound(int round) {
        this.round = round;
    }

    /**
     * @return the premios
     */
    public int getPremios() {
        return premios;
    }

    /**
     * @param premios the premios to set
     */
    public void setPremios(int premios) {
        this.premios = premios;
    }

    /**
     * @return the id_crew
     */
    public int getId_crew() {
        return id_crew;
    }

    /**
     * @param id_crew the id_crew to set
     */
    public void setId_crew(int id_crew) {
        this.id_crew = id_crew;
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

    /**
     * @return the turno
     */
    public boolean isTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    public ArrayList<Ronda> getRondas(int idBatalla){
        return new db.ConsultasEvento().selectRondas(idBatalla, id_crew);
    }

}
