/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import phonebook.db.StudentsDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import phonebook.db.ConnectionSource;
import phonebook.db.TeachersDao;

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
        ConnectionSource conn =  new ConnectionSource(servidor, database, usuario, password);
        StudentsDao dbHelper = new StudentsDao(conn);
        TeachersDao dao = new TeachersDao(conn);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrm(dao, dbHelper).setVisible(true);
            }
        });
    }
    
}
