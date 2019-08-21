
package model.dao2;

import model.dto.ResultV;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;


public class DAOResultsImpl implements DAOResults{

    @Override
    public List<ResultV> getAllResults() {
        Connection conn = DatabaseConnection.getConnection();
        ArrayList<ResultV> results = new ArrayList();
        try(Statement st = conn.createStatement()){
            String sql = "select MARK,TEACHER_USERNAME,STUDENT_USERNAME,COURSE_NAME from RESULTS ";
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                ResultV emp = new ResultV();
                emp.setMARK(result.getInt("MARK"));
                emp.setTEACHER_USERNAME(result.getString("TEACHER_USERNAME"));
                emp.setSTUDENT_USERNAME(result.getString("STUDENT_USERNAME"));
                emp.setCOURSE_NAME(result.getString("COURSE_NAME"));
                results.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOResultsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return results;
    }

    
}
