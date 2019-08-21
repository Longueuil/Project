
package model.dao2;

import model.dto.updateResult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class updateResultDAOImpl implements updateResultDAO{
    
    private String db, userName, password;
    
    public updateResultDAOImpl(String url, String user, String password){
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
            Logger.getLogger(updateResultDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    @Override
    public void updateResults(updateResult updateresult) throws SQLException {
        String sql = ("UPDATE RESULTS SET MARK =? ,TEACHER_USERNAME=?,USERNAME=?,STUDENT_USERNAME=?,COURSE_NAME=? WHERE USERNAME =?");
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        pSt.setInt(1, updateresult.getMARK());
        pSt.setString(2, updateresult.getTEACHER_USERNAME());
        pSt.setString(3, updateresult.getTEACHER_USERNAME());
        pSt.setString(4, updateresult.getSTUDENT_USERNAME());
        pSt.setString(5, updateresult.getCOURSE_NAME());
        pSt.setString(6, updateresult.getTEACHER_USERNAME());
        
        
        pSt.executeUpdate();
    }

}
