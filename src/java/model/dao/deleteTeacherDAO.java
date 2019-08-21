/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.dto.deleteTeacher;
import java.sql.SQLException;


public interface deleteTeacherDAO {
    
       public void deleteTeacher(deleteTeacher dsteacher) throws SQLException;
}
