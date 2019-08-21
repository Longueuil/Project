
package model.dao;

import model.dto.Student;
import java.sql.SQLException;

public interface StudentDAO {
    
    public void addStudent(Student st) throws SQLException;

}
