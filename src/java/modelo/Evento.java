/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author Marlene
 */
public class Evento{
    private int id_evento;
    private String nombre="";
    private Batalla batallaActual;
    private int batalla;
    private int idAdmin;

    /**
     * @return the id_evento
     */
    public int getId_evento() {
        return id_evento;
    }

    /**
     * @param id_evento the id_evento to set
     */
    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the batallaActual
     */
    public Batalla getBatallaActual() {
        return batallaActual;
    }

    /**
     * @param batallaActual the batallaActual to set
     */
    public void setBatallaActual(Batalla batallaActual) {
        this.batallaActual = batallaActual;
    }

    /**
     * @return the turno
     */
    public int getBatallaId() {
        return batalla;
    }

    /**
     * @param turno the turno to set
     */
    public void setBatallaId(int turno) {
        this.batalla = turno;
    }

    /**
     * @return the idAdmin
     */
    public int getIdAdmin() {
        return idAdmin;
    }

    /**
     * @param idAdmin the idAdmin to set
     */
    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    
}
