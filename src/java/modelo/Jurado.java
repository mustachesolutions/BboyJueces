/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import db.ConsultasJurado;

/**
 *
 * @author EltonAlexánder
 */
public class Jurado {
    public static final int foundation=1;
    public static final int creativity=2;
    public static final int dynamics=3;
    public static final int execution=4;
    public static final int battle=5;
    public static final String fColor="rgb(10, 216, 81)";
    public static final String cColor="rgb(43, 175, 245)";
    public static final String dColor="rgb(234, 123, 12)";
    public static final String eColor="rgb(82, 43, 211)";
    public static final String bColor="rgb(168, 3, 175)";
    private int id_jurado;
    private String alias;
    private String nombre_jurado;
    private String password;
    private int categoria;
    private boolean conectado=true;
    private int id_evento;
  

   
    //atributos extras diferente a la base de datos
    private int nota;
    private String mensaje="";

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
   

    public Jurado(int categoria) {
        this.categoria=categoria;
    }
        public Jurado() {
     
    }

    
    
    /**
     * @return the id_jurado
     */
    public int getId_jurado() {
        return id_jurado;
    }

    /**
     * @param id_jurado the id_jurado to set
     */
    public void setId_jurado(int id_jurado) {
        this.id_jurado = id_jurado;
    }

    /**
     * @return the nombre_jurado
     */
    public String getNombre_jurado() {
        return nombre_jurado;
    }

    /**
     * @param nombre_jurado the nombre_jurado to set
     */
    public void setNombre_jurado(String nombre_jurado) {
        this.nombre_jurado = nombre_jurado;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the categoria
     */
    public int getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the conectado
     */
    public boolean isConectado() {
        return conectado;
    }

    /**
     * @param conectado the conectado to set
     */
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

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
     * @return the nota
     */
    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    public void saveNotaBattle(int next) {
        ConsultasJurado save=new ConsultasJurado();
        switch(categoria){
            case 1:
                setMensaje(save.foundationScore(id_evento,nota,next));
            break;
            case 2:
                 setMensaje(save.cerativityScore(id_evento,nota,next));
            break;
            case 3:
                 setMensaje(save.dynamicsScore(id_evento,nota,next));
            break;
            case 4:
                setMensaje(save.executionScore(id_evento,nota,next));
            break;
            case 5:
                setMensaje(save.battleScore(id_evento,nota,next));
            break;
                
        }
//        save.desconectar();
    }
    
    public String getHTMLColor(){
         switch(categoria){
            case 1:
                return Jurado.fColor;
           
            case 2:
                return Jurado.cColor;
            
            case 3:
                 return Jurado.dColor;
           
            case 4:
                 return Jurado.eColor;
           
            case 5:
                return Jurado.bColor;
           
                
        }
         return "red";
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

    public void updateNotaBattle() {
        mensaje=new ConsultasJurado().updateScore(id_evento, categoria, nota);
    }

   public boolean isCalficado(){
       return new ConsultasJurado().isCalficado(id_evento, categoria);
   }
    public String crewACorregir(int idBatalla){
        String campo="";
         switch(categoria){
            case 1:
                campo="foundation_save";
           break;
            case 2:
                campo= "creativity_save";
             break;
            case 3:
                 campo="dynamics_save";
            break;
            case 4:
                 campo="execution_save";
            break;
            case 5:
                campo= "battle_save";
            break;
                
        }
       return new ConsultasJurado().correctedCrew(idBatalla,campo);
   }
    public String notaACorregir(int idBatalla){
        String campo="";
        String campo2="";
         switch(categoria){
            case 1:
                campo="foundation_save";
                campo2="foundation";
           break;
            case 2:
                campo= "creativity_save";
                campo2= "creativity";
             break;
            case 3:
                 campo="dynamics_save";
                 campo2="dynamics";
            break;
            case 4:
                 campo="execution_save";
                 campo2="execution";
            break;
            case 5:
                campo= "battle_save";
                campo2= "battle";
            break;
                
        }
       return new ConsultasJurado().correctedScore(idBatalla,campo,campo2);
   }
    
}
