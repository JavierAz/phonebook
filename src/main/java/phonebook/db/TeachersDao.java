package phonebook.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import phonebook.db.ConnectionSource;

/**
 *
 * @author javier
 */
public class TeachersDao {
    private String addQry = "INSERT INTO profesores (user, password, name, apellido1, apellido2) VALUES (?, ?, ?, ?, ?);";
    private ConnectionSource conFactory = null;
    private String findByCredsQuery = "SELECT * FROM profesores WHERE user=? AND password=?";
    
    public TeachersDao(ConnectionSource conn) throws SQLException{
        this.conFactory = conn;
    }
    
    public int insert(String user, String pwd){
        int res = 0;
        try(Connection conn = conFactory.openConnection()){
            try(PreparedStatement createST = conn.prepareStatement(addQry)){
                createST.setString(1, user);
                createST.setString(2, pwd);
                res = createST.executeUpdate();
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return res;
    }
    
    public boolean exists(String user, String password){
        boolean res = false;
        try(Connection conn = conFactory.openConnection()){
            try(PreparedStatement exist = conn.prepareStatement(findByCredsQuery)){
                exist.setString(1, user);
                exist.setString(2, password);
                try(ResultSet rs = exist.executeQuery()){
                    res = rs.next();
                }
            }      
        }catch(SQLException e){
            System.out.println("error in exists" + e);
        }
        return res;
    }
}
