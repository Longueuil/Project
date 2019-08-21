
package addTeacherServlet;

import model.dao.TeacherDAO;
import model.dao.TeacherDAOImpl;
import model.dto.Teacher;
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

@WebServlet(urlPatterns={"/Admin/teachers/addTeacherServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})
public class addTeacherServlet extends HttpServlet{
    
     private TeacherDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new TeacherDAOImpl(url, user, password);
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
            String Salary = request.getParameter("Salary");
            String Username = request.getParameter("Username");
            String Password = request.getParameter("Password");
            String Role = request.getParameter("Role");
            String usernameRole = request.getParameter("usernameRole");
            
            
            
            Teacher teacher = new Teacher();
            teacher.setFirst_name(firstName);
            teacher.setLast_name(lastName);
            teacher.setAddress(ADDRESS);
            teacher.setCity(CITY);
            teacher.setCountry(COUNTRY);
            teacher.setPHONE_NUMBER(Long.valueOf(PHONE_NUMBER));
            teacher.setSalary(Long.valueOf(Salary));
            teacher.setUsername(Username);
            teacher.setPassword(Password);
            teacher.setRole(Role);
            teacher.setUsernameRole(usernameRole);
            
            
            
            dao.addTeacher(teacher);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Teacher Succesfully created</h1>");
            out.println("<p>First Name: " + firstName + "</p>");
            out.println("<p>Last Name: " + lastName + "</p>");
            out.println("<p>Address: " + ADDRESS + "</p>");
            out.println("<p>Job City: " + CITY + "</p>");
            out.println("<p>Country: " + COUNTRY + "</p>");
            out.println("<p>Phone number: " + PHONE_NUMBER + "</p>");
            out.println("<p>Mark: " + Salary + "</p>");
            out.println("<p>Username: " + Username + "</p>");
            out.println("<p>Password: " + Password + "</p>");
            out.println("<p>Role: " + Role + "</p>");
            out.println("<p>Username Role: " + usernameRole + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(addTeacherServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
