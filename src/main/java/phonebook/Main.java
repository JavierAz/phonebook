/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.db.Conection;

/**
 *
 * @author javier
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String servidor = "localhost";
        String database = "escuela";
        String usuario = "escuela";
        String password = "P@ssw0rd";
        Conection conn =  new Conection(servidor, database, usuario, password);
        
        PreparedStatement st = conn.getConexion().prepareStatement("SELECT * FROM estudiantes");
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            System.out.println("id = " + rs.getLong("id"));
            System.out.println("nombre = " + rs.getString("nombre"));   
        }
    }
    
}
