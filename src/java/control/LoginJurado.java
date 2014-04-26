/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import db.ConsultasJurado;
import modelo.Batalla;
import modelo.Jurado;

/**
 *
 * @author Enrique
 */
public class LoginJurado {

    private String username="6rf2cs4";
    private String password="42wes67f";
    Jurado jurado = new Jurado();
    private String mensaje="";
    public LoginJurado() {
    }
   
    
    
    //GETTERS Y SETTERS
    public String getUsername() {
        
        return username;

    }

    public void setUsername(String username) {
        this.username = username;
        ConsultasJurado consultasJurado = new ConsultasJurado();
        this.jurado = consultasJurado.buscarUsuarioPorID(username);
//        consultasJurado.desconectar();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

//DEFINICION DE METODOS DE VALIDACION DE LOGUEO
    public boolean validarExistenciaUsuario() {
        boolean resultado = false;
        if (this.jurado.getId_jurado() == 0) {
            resultado = false;
        } else {
            resultado = true;
        }

        return resultado;

    }

public boolean validarCredencialesUsuario(){
boolean resultado = false;
    if(this.username.equals(this.jurado.getNombre_jurado()) && this.password.equals(this.jurado.getPassword())){
        resultado = true;
         mensaje="";
    }
    if(!this.username.equals(this.jurado.getNombre_jurado())){
            setMensaje("El nombre de usuario es incorrecto");
            return resultado;
    }
    if(!this.password.equals(this.jurado.getPassword())){
            setMensaje("La contraseña es incorrecta");
    }
return resultado;
}  

public String getJuradoURL(){
    String url=URL.url;
    url=url+"dynamics.jsp";
        return url;
}

//public String getJuradoURL(){
//    String url=URL.url;
//    switch(jurado.getCategoria()){
//        case Jurado.foundation:
//            url=url+"foundation.jsp";
//            break;
//        case Jurado.creativity:
//            url=url+"creativity.jsp";
//            break;
//        case Jurado.dynamics:
//            url=url+"dynamics.jsp";
//            break;
//        case Jurado.execution:
//            url=url+"execution.jsp";
//            break;
//        case Jurado.battle:
//            url=url+"battle.jsp";
//            break;
//}
//    return url;
//}

//public String getSession(){
//    String session="";
//    switch(jurado.getCategoria()){
//        case Jurado.foundation:
//            session=Sesiones.sesionFoundation;
//            break;
//        case Jurado.creativity:
//            session=Sesiones.sesionCreativity;
//            break;
//        case Jurado.dynamics:
//            session=Sesiones.sesionDynamics;
//            break;
//        case Jurado.execution:
//            session=Sesiones.sesionExecution;
//            break;
//        case Jurado.battle:
//            session=Sesiones.sesionJudge;
//            break;
//}
//    return session;
//}

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
