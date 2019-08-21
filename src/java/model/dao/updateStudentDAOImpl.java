
package model.dao;

import model.dto.updateStudent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class updateStudentDAOImpl implements updateStudentDAO{
    
    private String db, userName, password;
    
    public updateStudentDAOImpl(String url, String user, String password){
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
    public void updateStudent(updateStudent upst) throws SQLException {
        String sql = ("UPDATE student_inf "
                + "SET first_name =? ,last_name=?,ADDRESS=?,CITY=?,COUNTRY=?,PHONE_NUMBER=?,COURSE_ID =? "
                + "WHERE USERNAME =?");
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        pSt.setString(1, upst.getFirst_name());
        pSt.setString(2, upst.getLast_name());
        pSt.setString(3, upst.getAddress());
        pSt.setString(4, upst.getCity());
        pSt.setString(5, upst.getCountry());
        pSt.setLong(6, upst.getPHONE_NUMBER());
        pSt.setInt(7, upst.getCOURSE_ID());
        pSt.setString(8, upst.getUSERNAME());
        
        
        
        pSt.executeUpdate();
    }

  
}
