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
public class dbHelper {
    
    PreparedStatement st;
    PreparedStatement st2;
    PreparedStatement st3;
        
    public dbHelper(Conection conn) throws SQLException{
        //mostrar valores
        
        String selectQuery = "SELECT * FROM estudiantes";
        PreparedStatement st = conn.getConexion().prepareStatement(selectQuery);
        
        //eliminar
        String deleteQuery = "DELETE FROM estudiantes WHERE id = ?";
        PreparedStatement st2 = conn.getConexion().prepareStatement(deleteQuery);
        
        //modifcar
        String insertQuery = "INSERT INTO estudiantes (boleta, nombre, apellido_paterno, apellido materno) VALUES (?, ?, ?, ?)";
        PreparedStatement st3 = conn.getConexion().prepareStatement(insertQuery);
    }
    
    public void delete(int id){
        /*
        no te awuites carnal, awevo que si lo sacamos antes de las 2 pm
        
        */
        //ResultSet rs = st.executeQuery();
    }
    
}
