
package updateStudentServlet;

import model.dao.updateStudentDAO;
import model.dao.updateStudentDAOImpl;
import model.dto.updateStudent;
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

@WebServlet(urlPatterns={"/Admin/students/updateStudentServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})

public class updateStudentServlet extends HttpServlet{
    private updateStudentDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new updateStudentDAOImpl(url, user, password);
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
            String USERNAME = request.getParameter("USERNAME");
            
            
            updateStudent updatestudent = new updateStudent();
            updatestudent.setFirst_name(firstName);
            updatestudent.setLast_name(lastName);
            updatestudent.setAddress(ADDRESS);
            updatestudent.setCity(CITY);
            updatestudent.setCountry(COUNTRY);
            updatestudent.setPHONE_NUMBER(Long.valueOf(PHONE_NUMBER));
            updatestudent.setCOURSE_ID(Integer.valueOf(COURSE_ID));
            updatestudent.setUSERNAME(USERNAME);
           
            
            
            dao.updateStudent(updatestudent);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Student Succesfully updated</h1>");
            out.println("<p>First Name: " + firstName + "</p>");
            out.println("<p>Last Name: " + lastName + "</p>");
            out.println("<p>Address: " + ADDRESS + "</p>");
            out.println("<p>Job City: " + CITY + "</p>");
            out.println("<p>Country: " + COUNTRY + "</p>");
            out.println("<p>Phone number: " + PHONE_NUMBER + "</p>");
            out.println("<p>Course ID: " + COURSE_ID + "</p>");
            out.println("<p>Username: " + USERNAME + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(updateStudent.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
