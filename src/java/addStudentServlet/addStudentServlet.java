
package addStudentServlet;

import model.dao.StudentDAO;
import model.dao.StudentDAOImpl;
import model.dto.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns={"/Admin/students/addStudentServlet"}, 
           initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})

public class addStudentServlet extends HttpServlet{
    
    private StudentDAO dao;
    
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");

        //Create DAO
        dao = new StudentDAOImpl(url, user, password);
     }
      @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String ADDRESS = request.getParameter("ADDRESS");
            String CITY = request.getParameter("CITY");
            String COUNTRY = request.getParameter("COUNTRY");
            String PHONE_NUMBER = request.getParameter("PHONE_NUMBER");
            String COURSE_ID = request.getParameter("COURSE_ID");
            String TEACHER_USERNAME = request.getParameter("TEACHER_USERNAME");
            String Username = request.getParameter("Username");
            String Password = request.getParameter("Password");
            String Role = request.getParameter("Role");
            String usernameRole = request.getParameter("usernameRole");
            
            
            Student student = new Student();
            student.setFirst_name(firstName);
            student.setLast_name(lastName);
            student.setAddress(ADDRESS);
            student.setCity(CITY);
            student.setCountry(COUNTRY);
            student.setPHONE_NUMBER(Long.valueOf(PHONE_NUMBER));
            student.setCOURSE_ID(Integer.valueOf(COURSE_ID));
            student.setTEACHER_USERNAME(TEACHER_USERNAME);
            student.setUsername(Username);
            student.setPassword(Password);
            student.setRole(Role);
            student.setUsernameRole(usernameRole);
            
            
            
            dao.addStudent(student);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Student Succesfully created</h1>");
            out.println("<p>First Name: " + firstName + "</p>");
            out.println("<p>Last Name: " + lastName + "</p>");
            out.println("<p>Address: " + ADDRESS + "</p>");
            out.println("<p>Job City: " + CITY + "</p>");
            out.println("<p>Country: " + COUNTRY + "</p>");
            out.println("<p>Phone number: " + PHONE_NUMBER + "</p>");
            out.println("<p>Course ID: " + COURSE_ID + "</p>");
            out.println("<p>Teacher: " + TEACHER_USERNAME + "</p>");
            out.println("<p>Username: " + Username + "</p>");
            out.println("<p>Password: " + Password + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          //error here
           Logger.getLogger(addStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("sadf");
       }
          
    }
}
