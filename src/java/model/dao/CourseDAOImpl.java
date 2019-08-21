package model.dao;

import model.dto.Course;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAOImpl implements CourseDAO {

    private String db, userName, password;

    public CourseDAOImpl(String url, String user, String password) {
        db = url;
        userName = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(db, userName, password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    @Override
    public void addCourse(Course course) throws SQLException {
        try{
        String sql = "INSERT INTO Course(COURSE_ID,COURSE_NAME,TEACHER_USERNAME,STUDENT_USERNAME, CREDIT,USERNAME)"
                + " VALUES (?,?,?,?,?,?)";

        PreparedStatement pSt = getConnection().prepareStatement(sql);
        pSt.setInt(1, course.getCOURSE_ID());
        pSt.setString(2, course.getCOURSE_NAME());
        pSt.setString(3, course.getTEACHER_USERNAME());
        pSt.setString(4, course.getSTUDENT_USERNAME());
        pSt.setInt(5, course.getCREDIT());
        pSt.setString(6, course.getTEACHER_USERNAME());

        pSt.execute();
    }catch (Throwable e) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("You try to enter existing student username");
        }
        
    }

}
