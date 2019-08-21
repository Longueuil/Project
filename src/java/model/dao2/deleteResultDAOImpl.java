
package model.dao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Result;

public class deleteResultDAOImpl implements deleteResultDAO{
    
     private String db, userName, password;
    
    public deleteResultDAOImpl(String url, String user, String password){
        db= url;
        userName = user;
        this.password= password;
    }
     private Connection getConnection()  throws SQLException{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(db, userName, password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deleteResultDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void deleteResult(Result dresult) throws SQLException {
        String sql = "delete from RESULTS where STUDENT_USERNAME = ?";
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        
        pSt.setString(1, dresult.getSTUDENT_USERNAME());
        
        pSt.execute();
        
    }
}
