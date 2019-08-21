
package updateTeacherServlet;

import model.dao.updateTeacherDAO;
import model.dao.updateTeacherDAOImpl;
import model.dto.updateTeacher;
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

@WebServlet(urlPatterns={"/Admin/teachers/updateTeacherServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})

public class updateTeacherServlet extends HttpServlet{
    
    private updateTeacherDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new updateTeacherDAOImpl(url, user, password);
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
            String USERNAME = request.getParameter("USERNAME");
            
            
            
            updateTeacher updateteacher = new updateTeacher();
            updateteacher.setFirst_name(firstName);
            updateteacher.setLast_name(lastName);
            updateteacher.setAddress(ADDRESS);
            updateteacher.setCity(CITY);
            updateteacher.setCountry(COUNTRY);
            updateteacher.setPHONE_NUMBER(Long.valueOf(PHONE_NUMBER));
            updateteacher.setSalary(Long.valueOf(Salary));
            updateteacher.setUSERNAME(USERNAME);
            
           
            
            
            dao.updateTeacher(updateteacher);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Teacher Succesfully updated</h1>");
            out.println("<p>First Name: " + firstName + "</p>");
            out.println("<p>Last Name: " + lastName + "</p>");
            out.println("<p>Address: " + ADDRESS + "</p>");
            out.println("<p>Job City: " + CITY + "</p>");
            out.println("<p>Country: " + COUNTRY + "</p>");
            out.println("<p>Phone number: " + PHONE_NUMBER + "</p>");
            out.println("<p>Salary: " + Salary + "</p>");
            out.println("<p>Username Id: " + USERNAME + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(updateTeacherServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
