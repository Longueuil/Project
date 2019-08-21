
package model.dao;

import model.dto.deleteCourse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class deleteCourseDAOImpl implements deleteCourseDAO{
    
    private String db, userName, password;
    
    public deleteCourseDAOImpl(String url, String user, String password){
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
            Logger.getLogger(deleteCourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void deleteCourse(deleteCourse dcourse) throws SQLException {
        String sql = "delete from course where COURSE_ID = ?";
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        
        pSt.setInt(1, dcourse.getCOURSE_ID());
        
        pSt.execute();
        
       
    }
}
