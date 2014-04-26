/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import java.sql.Connection;

/**
 *
 * @author EltonAlexánder
 */
public class Conection {
     public Connection getConnection() {
        return Global.conexion.getConnection();
    }
}
