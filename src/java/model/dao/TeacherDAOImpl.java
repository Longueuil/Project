package model.dao;

import model.dto.Teacher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDAOImpl implements TeacherDAO {

    private String db, userName, password;

    public TeacherDAOImpl(String url, String user, String password) {
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
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addTeacher(Teacher st) throws SQLException {
        try {
            String sql = "INSERT INTO Teacher_INF(teacher_ID,first_name, last_name, "
                    + "ADDRESS, CITY, COUNTRY,PHONE_NUMBER, Salary,Username) "
                    + " VALUES (Teacher_INF_SEQ.nextval, ?, ?, ?, ?, ?, ?,?,?)";
            PreparedStatement pSt = getConnection().prepareStatement(sql);
            pSt.setString(1, st.getFirst_name());
            pSt.setString(2, st.getLast_name());
            pSt.setString(3, st.getAddress());
            pSt.setString(4, st.getCity());
            pSt.setString(5, st.getCountry());
            pSt.setLong(6, st.getPHONE_NUMBER());
            pSt.setLong(7, st.getSalary());
            pSt.setString(8, st.getUsername());

            String sql1 = "INSERT INTO Users(Username,Password) VALUES (?,?)";
            PreparedStatement pSt1 = getConnection().prepareStatement(sql1);
            pSt1.setString(1, st.getUsername());
            pSt1.setString(2, st.getPassword());

            String sql2 = "INSERT INTO USER_ROLE(Role,Username) VALUES (?,?)";
            PreparedStatement pSt2 = getConnection().prepareStatement(sql2);
            pSt2.setString(1, "teacher");
            pSt2.setString(2, st.getUsername());
            pSt1.execute();
            pSt.execute();
            pSt2.execute();
        } catch (Throwable t) {
            // i don't know why, byt it don't give me this line :(
            System.out.println("This username already exist!");
        }
    }

}
