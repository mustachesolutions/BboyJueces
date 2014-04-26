/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import db.ConsultasEvento;
import modelo.Batalla;

/**
 *
 * @author Enrique
 */
public class ResultadosFinales {
    
    
    public Batalla batalla = new Batalla();

    public ResultadosFinales() {
    }

    public void buscarBatalla(int idBatalla) {
        ConsultasEvento c= new ConsultasEvento();
        batalla = c.buscarBatallaPorID(idBatalla);
//        c.desconectar();
    }

    public String[] obtenerDireccionesImagenes() {
        String imagenes[] = new String[15];

        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i] = getDireccionImagen(i);

        }
        return imagenes;
    }

    private String getDireccionImagen(int i) {
        String direccion = "HTML/imagenes/botones/transparente.png";

        switch (i + 1) {

            case 1:
                if (batalla.getWinnerFoundation().equals(batalla.crew1.getName())) {
                    direccion = "HTML/imagenes/botones/Foundation/BASE1Foundation.png";
                }else {
                    direccion = "HTML/imagenes/botones/Foundation/BASE1Foundation0.png";
                }
                break;
            case 2:
                if (batalla.getWinnerCreativity().equals(batalla.crew1.getName())) {
                    direccion = "HTML/imagenes/botones/Originality/originality1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Originality/originality0.png";
                }
                break;
            case 3:
                if (batalla.getWinnerDynamics().equals(batalla.crew1.getName())) {
                    direccion = "HTML/imagenes/botones/Dynamics/dynamics1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Dynamics/dynamics0.png";
                }
                break;
            case 4:
                if (batalla.getWinnerExecution().equals(batalla.crew1.getName())) {
                    direccion = "HTML/imagenes/botones/Execution/execution1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Execution/execution0.png";
                }
                break;
            case 5:
                if (batalla.getWinnerBattle().equals(batalla.crew1.getName())) {
                    direccion = "HTML/imagenes/botones/Battle/battle1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Battle/battle0.png";
                }
                break;

            case 6:
                if (!batalla.getWinnerFoundation().equals("TIE")) {
                    direccion = "HTML/imagenes/botones/Foundation/BASE1Foundation0.png";  //GRIS             
                } else {
                    direccion = "HTML/imagenes/botones/Foundation/BASE1Foundation.png";
                }
                break;
            case 7:
                if (!batalla.getWinnerCreativity().equals("TIE")) {
                    direccion = "HTML/imagenes/botones/Originality/originality0.png"; //GRIS  
                } else {
                    direccion = "HTML/imagenes/botones/Originality/originality1.png";
                }
                break;
            case 8:
                if (!batalla.getWinnerDynamics().equals("TIE")) {
                    direccion = "HTML/imagenes/botones/Dynamics/dynamics0.png"; //GRIS  
                } else {
                    direccion = "HTML/imagenes/botones/Dynamics/dynamics1.png";
                }
                break;
            case 9:
                if (!batalla.getWinnerExecution().equals("TIE")) {
                    direccion = "HTML/imagenes/botones/Execution/execution0.png";//GRIS  
                } else {
                    direccion = "HTML/imagenes/botones/Execution/execution1.png";
                }
                break;
            case 10:
                if (!batalla.getWinnerBattle().equals("TIE")) {
                    direccion = "HTML/imagenes/botones/Battle/battle0.png";//GRIS  
                } else {
                    direccion = "HTML/imagenes/botones/Battle/battle1.png";
                }
                break;
            case 11:
                if (batalla.getWinnerFoundation().equals(batalla.crew2.getName())) {
                    direccion = "HTML/imagenes/botones/Foundation/BASE1Foundation.png";
                }else {
                    direccion = "HTML/imagenes/botones/Foundation/BASE1Foundation0.png";
                }
                break;
            case 12:
                if (batalla.getWinnerCreativity().equals(batalla.crew2.getName())) {
                    direccion = "HTML/imagenes/botones/Originality/originality1.png";
                }else{
                    direccion = "HTML/imagenes/botones/Originality/originality0.png";
                }
                break;
            case 13:
                if (batalla.getWinnerDynamics().equals(batalla.crew2.getName())) {
                    direccion = "HTML/imagenes/botones/Dynamics/dynamics1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Dynamics/dynamics0.png";
                }
                break;
            case 14:
                if (batalla.getWinnerExecution().equals(batalla.crew2.getName())) {
                    direccion = "HTML/imagenes/botones/Execution/execution1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Execution/execution0.png";
                }
                break;
            case 15:
                if (batalla.getWinnerBattle().equals(batalla.crew2.getName())) {
                    direccion = "HTML/imagenes/botones/Battle/battle1.png";
                }else {
                    direccion = "HTML/imagenes/botones/Battle/battle0.png";
                }
                break;

        }
        return direccion;

    }

}
