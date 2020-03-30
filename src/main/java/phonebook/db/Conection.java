/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook.db;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ciriaco
 */
import java.sql.*;
import java.util.Properties;

public class Conection {

    private Connection conexion=null;
    private String servidor="";
    private String database="";
    private String usuario="";
    private String password="";
    private String url="";
    
    public Conection(String servidor, String database, String usuario, String password){
        try {

            String url = "jdbc:mysql://" + servidor + "/"+ database;
            Properties props = new Properties();
            props.setProperty("user", usuario);
            props.setProperty("password", password);
            conexion = DriverManager.getConnection(url, props);

            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");

        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Connection getConexion(){
        return conexion;
    }

    public Connection cerrarConexion(){
        try {
            conexion.close();
             System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }
}
