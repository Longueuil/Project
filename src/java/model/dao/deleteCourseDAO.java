
package model.dao;

import model.dto.deleteCourse;
import java.sql.SQLException;

public interface deleteCourseDAO {
   
    public void deleteCourse(deleteCourse dcourse) throws SQLException;
}
