
package model.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.deleteTeacher;

public class deleteTeacherDAOImpl implements deleteTeacherDAO{
    
    private String db, userName, password;
    
    public deleteTeacherDAOImpl(String url, String user, String password){
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
            Logger.getLogger(deleteTeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void deleteTeacher(deleteTeacher dsteacher) throws SQLException {
        String sql = "delete from teacher_inf where username = ?";
        PreparedStatement pSt= getConnection().prepareStatement(sql);
        
        pSt.setString(1, dsteacher.getUsername());
        
        pSt.execute();
        
        String sql1 = "delete from user_role where username = ?";
        PreparedStatement pSt1= getConnection().prepareStatement(sql1);
        
        pSt1.setString(1, dsteacher.getUsername());
               
        pSt1.execute();
      
        String sql2 = "delete from users where username = ?";
        PreparedStatement pSt2= getConnection().prepareStatement(sql2);
        
        pSt2.setString(1, dsteacher.getUsername());
               
        pSt2.execute();
        
         String sql3 = "delete from COURSE where TEACHER_USERNAME = ?";
        PreparedStatement pSt3= getConnection().prepareStatement(sql3);
        
        pSt3.setString(1, dsteacher.getUsername());
               
        pSt3.execute();
        
         String sql4 = "delete from RESULTS where TEACHER_USERNAME = ?";
        PreparedStatement pSt4= getConnection().prepareStatement(sql4);
        
        pSt4.setString(1, dsteacher.getUsername());
               
        pSt4.execute();
    }
}

   
