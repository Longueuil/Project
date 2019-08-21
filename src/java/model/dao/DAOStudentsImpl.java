
package model.dao;

import model.dto.StudentV;
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
public class DAOStudentsImpl implements DAOStudents{

    @Override
    public List<StudentV> getAllStudents() {
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<StudentV> students = new ArrayList();
        try(Statement st = conn.createStatement()){
            String sql = "select s.STUDENT_ID, s.FIRST_NAME,s.LAST_NAME,s.ADDRESS,s.CITY,s.COUNTRY,"
                    + "s.PHONE_NUMBER,s.COURSE_ID,s.TEACHER_USERNAME,\n" +
"u.USERNAME,u.PASSWORD\n" +
"from student_inf s join users u on(s.username=u.username)";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                StudentV emp = new StudentV();
                emp.setSTUDENT_ID(result.getInt("STUDENT_ID"));
                emp.setFIRST_NAME(result.getString("FIRST_NAME"));
                emp.setLAST_NAME(result.getString("LAST_NAME"));
                emp.setADDRESS(result.getString("ADDRESS"));
                emp.setCITY(result.getString("CITY"));
                emp.setCOUNTRY(result.getString("COUNTRY"));
                emp.setPHONE_NUMBER(result.getLong("PHONE_NUMBER"));
                emp.setCOURSE_ID(result.getInt("COURSE_ID"));
                emp.setTEACHER_USERNAME(result.getString("TEACHER_USERNAME"));
                emp.setUSERNAME(result.getString("USERNAME"));
                emp.setPASSWORD(result.getString("PASSWORD"));
                students.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStudentsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return students;
    }

    
}
