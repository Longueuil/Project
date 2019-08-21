
package model.dao;

import model.dto.Teacher;
import java.sql.SQLException;

public interface TeacherDAO {
    
    
    public void addTeacher(Teacher student) throws SQLException;
}
