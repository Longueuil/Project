package model.dao;

import model.dto.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DatabaseConnection;

public class StudentDAOImpl implements StudentDAO {

    private String db, userName, password;

    public StudentDAOImpl(String url, String user, String password) {
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
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void addStudent(Student st) throws SQLException {
        try {
            Connection getConnection = DatabaseConnection.getConnection();
            String sql = "INSERT INTO Student_INF(STUDENT_ID,first_name, last_name, "
                    + "ADDRESS, CITY, COUNTRY,PHONE_NUMBER, COURSE_ID,TEACHER_USERNAME,username) "
                    + " VALUES (Student_INF_SEQ.nextval, ?, ?, ?, ?, ?, ?,?,?,?)";
            PreparedStatement pSt = getConnection.prepareStatement(sql);
            pSt.setString(1, st.getFirst_name());
            pSt.setString(2, st.getLast_name());
            pSt.setString(3, st.getAddress());
            pSt.setString(4, st.getCity());
            pSt.setString(5, st.getCountry());
            pSt.setLong(6, st.getPHONE_NUMBER());
            pSt.setInt(7, st.getCOURSE_ID());
            pSt.setString(8, st.getTEACHER_USERNAME());
            pSt.setString(9, st.getUsername());

            String sql1 = "INSERT INTO Users(Username,Password) VALUES (?,?)";
            PreparedStatement pSt1 = getConnection.prepareStatement(sql1);
            pSt1.setString(1, st.getUsername());
            pSt1.setString(2, st.getPassword());

            String sql2 = "INSERT INTO USER_ROLE(Role,Username) VALUES (?,?)";
            PreparedStatement pSt2 = getConnection.prepareStatement(sql2);
            pSt2.setString(1, "student");
            pSt2.setString(2, st.getUsername());

            pSt1.execute();
            pSt.execute();
            pSt2.execute();

        } catch (Throwable e) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("You try to enter existing student username");

        }
    }
}
