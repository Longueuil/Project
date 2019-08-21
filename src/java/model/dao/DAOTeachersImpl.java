
package model.dao;

import model.dto.TeacherV;
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
public class DAOTeachersImpl implements DAOTeachers{

    @Override
    public List<TeacherV> getAllTeachers() {
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<TeacherV> teachers = new ArrayList();
        try(Statement st = conn.createStatement()){
            String sql = "select s.TEACHER_ID, s.FIRST_NAME,s.LAST_NAME,s.ADDRESS,s.CITY,s.COUNTRY,s.PHONE_NUMBER,s.salary,\n" +
"u.USERNAME,u.PASSWORD\n" +
"from teacher_inf s join users u on(s.username=u.username)";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                TeacherV emp = new TeacherV();
                emp.setTEACHER_ID(result.getInt("TEACHER_ID"));
                emp.setFIRST_NAME(result.getString("FIRST_NAME"));
                emp.setLAST_NAME(result.getString("LAST_NAME"));
                emp.setADDRESS(result.getString("ADDRESS"));
                emp.setCITY(result.getString("CITY"));
                emp.setCOUNTRY(result.getString("COUNTRY"));
                emp.setPHONE_NUMBER(result.getLong("PHONE_NUMBER"));
                emp.setSALARY(result.getLong("SALARY"));
                emp.setUSERNAME(result.getString("USERNAME"));
                emp.setPASSWORD(result.getString("PASSWORD"));
                teachers.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeachersImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return teachers;
    }

    
}
