
package model.dao;

import model.dto.deleteStudent;
import java.sql.SQLException;

public interface deleteStudentDAO {
    
    public void deleteStudent(deleteStudent dstudent) throws SQLException;
    
   }
