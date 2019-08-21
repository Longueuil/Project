package model.dao2;

import model.dto.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;

public class addResultDAOImpl implements ResultDAO{
    
    private String db, userName, password;
    
    
    public addResultDAOImpl(String url, String user, String password){
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
            Logger.getLogger(addResultDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    @Override
    public void addResult(Result st) throws SQLException {
        try{
        Connection getConnection = DatabaseConnection.getConnection();
         String sql = "INSERT INTO RESULTS(MARK,USERNAME, TEACHER_USERNAME, "
                        + "STUDENT_USERNAME, COURSE_NAME) "
                + " VALUES (?, ?, ?, ?,?)";
        PreparedStatement pSt= getConnection.prepareStatement(sql);
        pSt.setInt(1, st.getMARK());
        pSt.setString(2, st.getTEACHER_USERNAME());
        pSt.setString(3, st.getTEACHER_USERNAME());
        pSt.setString(4, st.getSTUDENT_USERNAME());
        pSt.setString(5, st.getCOURSE_NAME());
                
        
        pSt.execute();
        
    }catch (Throwable e) {
            Logger.getLogger(addResultDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            
        }
        
    }

   
}
