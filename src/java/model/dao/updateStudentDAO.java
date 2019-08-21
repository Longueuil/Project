
package model.dao;

import model.dto.updateStudent;
import java.sql.SQLException;


public interface updateStudentDAO {
    
    public void updateStudent(updateStudent upstudent) throws SQLException;
}
