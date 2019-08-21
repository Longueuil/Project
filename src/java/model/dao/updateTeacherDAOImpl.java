
package model.dao;

import model.dto.updateTeacher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class updateTeacherDAOImpl implements updateTeacherDAO{
    
    private String db, userName, password;
    
    public updateTeacherDAOImpl(String url, String user, String password){
        db= url;
        userName = user;
        this.password= password;
    }
     private Connection getConnection()  throws SQLException{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(db, userName, password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(updateStudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    @Override
    public void updateTeacher(updateTeacher upteacher) throws SQLException {
        String sql = ("UPDATE teacher_inf "
                + "SET first_name =? ,last_name=?,ADDRESS=?,CITY=?,COUNTRY=?,PHONE_NUMBER=?,Salary=?,  USERNAME=?"
                + "WHERE USERNAME =?");
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        pSt.setString(1, upteacher.getFirst_name());
        pSt.setString(2, upteacher.getLast_name());
        pSt.setString(3, upteacher.getAddress());
        pSt.setString(4, upteacher.getCity());
        pSt.setString(5, upteacher.getCountry());
        pSt.setLong(6, upteacher.getPHONE_NUMBER());
        pSt.setLong(7, upteacher.getSalary());
        pSt.setString(8, upteacher.getUSERNAME());
        pSt.setString(9, upteacher.getUSERNAME());
        
        pSt.executeUpdate();
    }

    
}
