/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dav
 */
public class Conexion {
    /* DATOS PARA LA CONEXION */

    private String bd = "judges";
    private String login = "root";
    private String password = "medicina123";
    private String url = "jdbc:mysql://localhost:3306/" + bd;//Servidor
//  private String url = "jdbc:mysql://"+Global.ip+":3306/"+bd;//Cliente
    private Connection conn = null;

//    private String bd = "a4038975_clinica";
//    private String login = "a4038975_clinica";
//    private String password = "medirecord01";
//    private String url = "mysql7.000webhost.com/"+bd;//Servidor
////  private String url = "jdbc:mysql://"+Global.ip+":3306/"+bd;//Cliente
//    private Connection conn = null;
//___________________________________________________________________________________ Soy una barra separadora :)
    /**
     * db29179_cie10
     */
    public Conexion() {
        boolean msg = true;

        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url, login, password);

            if (conn != null) {
                System.out.println("Conexion a la base de datos: " + bd + " listo!");
            } else {

//              conectar();//cliente
           
            }
        } catch (SQLException e) {

//          conectar();//cliente
           

            System.out.println(e);
        } catch (ClassNotFoundException e) {

//          conectar();//cliente
          

            System.out.println(e);
        }
    }

    public boolean conectarBaseDeDatos() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url, login, password);

            if (conn != null) {

                System.out.println("Conexion a la base de datos: " + bd + " listo!");
                return true;
            } else {

                return false;
            }
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

//___________________________________________________________________________________ Soy una barra separadora :)
    /**
     *
     * @return
     */
    public Connection getConnection() {

        return this.conn;
    }

//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA REALIZAR UNA CONSULTA A LA BASE DE DATOS
     * INPUT:  
     *      table => nombre de la tabla donde se realizara la consulta, puede utilizarse tambien INNER JOIN
     *      fields => String con los nombres de los campos a devolver Ej.: campo1,campo2campo_n
     *      where => condicion para la consulta
     * OUTPUT: un object[][] con los datos resultantes, sino retorna NULL
     */

//___________________________________________________________________________________ Soy una barra separadora :)
/* METODO PARA INSERTAR UN REGISTRO EN LA BASE DE DATOS
     * INPUT:
     table = Nombre de la tabla
     fields = String con los nombres de los campos donde insertar Ej.: campo1,campo2campo_n
     values = String con los datos de los campos a insertar Ej.: valor1, valor2, valor_n
     */
//___________________________________________________________________________________ Soy una barra separadora :)

    /**
     *
     * @param table
     * @param fields
     * @param values
     * @return
     */
    public boolean insert(String table, String fields, String values) {
//        insertarVariableEnBaseDeDatos();
        boolean res = false;
        //Se arma la consulta
        String q = " INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos o con la conexión");
            System.out.println(e);
        }
        return res;
    }

    /**
     *
     * @param table
     * @param fields
     * @param values
     * @return
     */
    public boolean insertOrUpdate(String table, String fields, String values) {
//        insertarVariableEnBaseDeDatos();
        boolean res = false;
        //Se arma la consulta
        String q = " INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) "
                + "ON DUPLICATE KEY UPDATE name=values(name), age=values(age)";
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos o con la conexión");
            System.out.println(e);
        }
        return res;
    }

    /**
     *
     * @param tabla
     * @param valor
     * @param columna
     * @param condicion
     */
    public void Update(String tabla, String valor, String columna, String condicion) {
//        insertarVariableEnBaseDeDatos();
        String u = " UPDATE " + tabla
                + " SET " + columna + " = " + valor
                + " WHERE " + condicion;
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = conn.prepareStatement(u);
            pstm.execute();
            pstm.close();
        } catch (SQLException e) {

            System.out.println(e + " consulta: " + u);
        }
    }

    /**
     *
     */
    public void desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            
        }
        conn = null;
        System.out.println("La conexion a la  base de datos " + bd + " a terminado. PROBLEM?");
    }

    public void eliminar(String tabla, String condicion) {
//       insertarVariableEnBaseDeDatos();
        String d = " DELETE FROM " + tabla
                + " WHERE " + condicion;
        //se ejecuta la consulta
        try {
            PreparedStatement pstm = conn.prepareStatement(d);
            pstm.executeUpdate();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void setAutocommit(boolean b) throws SQLException {
        if (!(conn == null || conn.isClosed())) {
            //conn = establecerConexion();
            conn.setAutoCommit(b);
        }
    }

    private boolean conectar() {
        boolean resultado = false;
        try {
            boolean conecto = false;
            InetAddress address[] = null;
            address = InetAddress.getAllByName(Global.host);
            for (int i = 0; i < address.length; i++) {
                Global.ip = address[i].getHostAddress();
                System.err.println(address.length);
                url = "jdbc:mysql://" + Global.ip + ":3306/" + bd;
                if (conectarBaseDeDatos()) {
                    resultado = true;
                }
            }

            if (!conecto) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "El servidor no se encuentra habilitado o encendido");
            }
            return conecto;
        } catch (UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
