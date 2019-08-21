
package model.dao;

import model.dto.updateTeacher;
import java.sql.SQLException;

public interface updateTeacherDAO {
    
   
    public void updateTeacher(updateTeacher upteacher) throws SQLException;
}
