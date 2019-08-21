
package model.dao;

import model.dto.updateCourse;
import java.sql.SQLException;

public interface updateCourseDAO {
   
    public void updateCourse(updateCourse upcourser) throws SQLException;
}
