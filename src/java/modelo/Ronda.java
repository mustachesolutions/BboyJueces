/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

/**
 *
 * @author EltonAlexánder
 */
public class Ronda {
    private int idRonda;
    private int idBatalla;
    private int idCrew;
    private int foundation;
    private int creativity;
    private int dynamics;
    private int execution;
    private int battle;
    private String nombreCrew="";

    /**
     * @return the idRonda
     */
    public int getIdRonda() {
        return idRonda;
    }

    /**
     * @param idRonda the idRonda to set
     */
    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    /**
     * @return the idBatalla
     */
    public int getIdBatalla() {
        return idBatalla;
    }

    /**
     * @param idBatalla the idBatalla to set
     */
    public void setIdBatalla(int idBatalla) {
        this.idBatalla = idBatalla;
    }

    /**
     * @return the idCrew
     */
    public int getIdCrew() {
        return idCrew;
    }

    /**
     * @param idCrew the idCrew to set
     */
    public void setIdCrew(int idCrew) {
        this.idCrew = idCrew;
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
     * @return the nombreCrew
     */
    public String getNombreCrew() {
        return nombreCrew;
    }

    /**
     * @param nombreCrew the nombreCrew to set
     */
    public void setNombreCrew(String nombreCrew) {
        this.nombreCrew = nombreCrew;
    }

    public int getNumeroRonda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
