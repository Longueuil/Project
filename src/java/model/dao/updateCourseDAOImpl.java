
package model.dao;

import model.dto.updateCourse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class updateCourseDAOImpl implements updateCourseDAO{
    
private String db, userName, password;
    
    public updateCourseDAOImpl(String url, String user, String password){
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
            Logger.getLogger(updateCourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void updateCourse(updateCourse upcourse) throws SQLException {
        String sql = ("UPDATE course "
                + "SET COURSE_NAME=?,TEACHER_USERNAME=?,STUDENT_USERNAME=?,CREDIT=?,COURSE_ID=?"
                + "WHERE TEACHER_USERNAME =?");
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        
        pSt.setString(1, upcourse.getCOURSE_NAME());
        pSt.setString(2, upcourse.getTEACHER_USERNAME());
        pSt.setString(3, upcourse.getSTUDENT_USERNAME());
        pSt.setInt(4, upcourse.getCREDIT());
        pSt.setInt(5, upcourse.getCOURSE_ID());
        pSt.setString(6, upcourse.getTEACHER_USERNAME());
        
        
        pSt.executeUpdate();
    }

}
