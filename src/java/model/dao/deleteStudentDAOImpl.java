package model.dao;

import model.dto.deleteStudent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class deleteStudentDAOImpl implements deleteStudentDAO {

    private String db, userName, password;

    public deleteStudentDAOImpl(String url, String user, String password) {
        db = url;
        userName = user;
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(db, userName, password);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deleteStudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deleteStudent(deleteStudent dst) throws SQLException {
        String sql = "delete from student_inf where username = ?";
        PreparedStatement pSt = getConnection().prepareStatement(sql);

        pSt.setString(1, dst.getUsername());

        pSt.execute();

        String sql1 = "delete from user_role where username = ?";
        PreparedStatement pSt1 = getConnection().prepareStatement(sql1);

        pSt1.setString(1, dst.getUsername());

        pSt1.execute(); 

        String sql3 = "delete from users where username = ?";
        PreparedStatement pSt3 = getConnection().prepareStatement(sql3);

        pSt3.setString(1, dst.getUsername());

        pSt3.execute();
        
        String sql4 = "delete from COURSE where STUDENT_USERNAME = ?";
        PreparedStatement pSt4 = getConnection().prepareStatement(sql4);

        pSt4.setString(1, dst.getUsername());

        pSt4.execute();
        
        String sql5 = "delete from RESULTS where STUDENT_USERNAME = ?";
        PreparedStatement pSt5 = getConnection().prepareStatement(sql5);

        pSt5.setString(1, dst.getUsername());

        pSt5.execute();
    }

}
