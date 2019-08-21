
package model.dao;

import model.dto.Course;
import java.sql.SQLException;

public interface CourseDAO {
    
    
    public void addCourse(Course course) throws SQLException;
}
