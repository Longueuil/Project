
package model.dao;

import model.dto.CourseV;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;

/**
 *
 * @author user
 */
public class DAOCourseImpl implements DAOCourses{

    @Override
    public List<CourseV> getAllCourses() {
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<CourseV> courses = new ArrayList();
        try(Statement st = conn.createStatement()){
            String sql = "select COURSE_ID,COURSE_NAME,TEACHER_USERNAME,STUDENT_USERNAME,CREDIT from course ";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                CourseV emp = new CourseV();
                emp.setCOURSE_ID(result.getInt("COURSE_ID"));
                emp.setCOURSE_NAME(result.getString("COURSE_NAME"));
                emp.setTEACHER_USERNAME(result.getString("TEACHER_USERNAME"));
                emp.setSTUDENT_USERNAME(result.getString("STUDENT_USERNAME"));
                emp.setCREDIT(result.getInt("CREDIT"));
                courses.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCourseImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return courses;
    }

    
}
