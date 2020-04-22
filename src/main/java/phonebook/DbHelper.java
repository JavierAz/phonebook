/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static phonebook.Vista.database;
import static phonebook.Vista.password;
import static phonebook.Vista.servidor;
import static phonebook.Vista.usuario;
import phonebook.db.ConnectionSource;

/**
 *
 * @author javier
 */
public class DbHelper {

    private String selectQuery = "SELECT boleta, nombre, apellido_paterno, apellido_materno, id FROM estudiantes";
    private String deleteQuery = "DELETE FROM estudiantes WHERE boleta = ?";
    private String insertQuery = "UPDATE estudiantes SET boleta=?, nombre=?, apellido_paterno=?, apellido_materno=? WHERE id=?";
    //private String insertQuery = "INSERT INTO estudiantes (boleta, nombre, apellido_paterno, apellido materno) VALUES (?, ?, ?, ?)";
    private String createQuery = "INSERT INTO estudiantes ( boleta, nombre, apellido_paterno, apellido_materno) value (?, ?, ?, ?)";
    private ConnectionSource conFactory = null;

    public DbHelper(ConnectionSource conn) throws SQLException {
        this.conFactory = conn;
    }

    public int delete(String id) {
        int res = 0;
        try (Connection conn = conFactory.openConnection()) {
            try (PreparedStatement deleteST = conn.prepareStatement(deleteQuery)) {
                deleteST.setString(1, id);
                res = deleteST.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return res;
    }
    
    public int update(String boleta, String nombre, String apellido_paterno, String apellido_materno, int id){
        int res = 0;
        try(Connection conn = conFactory.openConnection()){
            try(PreparedStatement insertST = conn.prepareStatement(insertQuery)){
                insertST.setString(1, boleta);
                insertST.setString(2, nombre);
                insertST.setString(3, apellido_paterno);
                insertST.setString(4, apellido_materno);
                insertST.setInt(5, id);
                res = insertST.executeUpdate();
            }
        } catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    
    public int insert(String boleta, String nombre, String apellido_paterno, String apellido_materno){
        int ress = 0;
        try(Connection conn = conFactory.openConnection()){
            try(PreparedStatement createST = conn.prepareStatement(createQuery)){
                createST.setString(1, boleta);
                createST.setString(2, nombre);
                createST.setString(3, apellido_paterno);
                createST.setString(4, apellido_materno);
                ress = createST.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return ress;
    }

    public List<Object[]> select() {
        List<Object[]> li = new ArrayList<>();
        try (Connection conn = conFactory.openConnection()) {
            try (PreparedStatement selectST = conn.prepareStatement(selectQuery)) {
                try (ResultSet rs = selectST.executeQuery()) {
                    ResultSetMetaData rsMd = rs.getMetaData();
                    int cantidadColumnas = rsMd.getColumnCount();
                                    
                    while (rs.next()) {
                        Object[] row = new Object[cantidadColumnas];
                        for (int i = 0; i < cantidadColumnas; i++) {
                            row[i] = rs.getObject(i + 1);
                        }
                        li.add(row);
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return li;
    }

}
