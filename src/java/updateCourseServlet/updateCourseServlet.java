
package updateCourseServlet;

import model.dao.updateCourseDAO;
import model.dao.updateCourseDAOImpl;
import model.dto.updateCourse;
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

@WebServlet(urlPatterns={"/Admin/course/updateCoursetServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})

public class updateCourseServlet extends HttpServlet{
  
     private updateCourseDAO dao;
    
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");

        //Create DAO
        dao = new updateCourseDAOImpl(url, user, password);
     }
      @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try {
           
            String COURSE_NAME = request.getParameter("COURSE_NAME");
            String COURSE_ID = request.getParameter("COURSE_ID");
            String STUDENT_USERNAME = request.getParameter("STUDENT_USERNAME");
            String TEACHER_USERNAME = request.getParameter("TEACHER_USERNAME");
            String CREDIT = request.getParameter("CREDIT");
            String USERNAME = request.getParameter("USERNAME");
            
            
            
            
            
            updateCourse course = new updateCourse();
            course.setCOURSE_NAME(COURSE_NAME);
            course.setCOURSE_ID(Integer.valueOf(COURSE_ID));
            course.setSTUDENT_USERNAME(STUDENT_USERNAME);
            course.setTEACHER_USERNAME(TEACHER_USERNAME);
            course.setCREDIT(Integer.valueOf(CREDIT));
            course.setUSERNAME(USERNAME);
            
           
            
            
            
            dao.updateCourse(course);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Course Succesfully updated</h1>");
            out.println("<p>Course ID: " + COURSE_ID + "</p>");
            out.println("<p>Course name: " + COURSE_NAME + "</p>");
            out.println("<p>Student username: " + STUDENT_USERNAME + "</p>");
            out.println("<p>Teacher username: " + TEACHER_USERNAME + "</p>");
            out.println("<p>Credit: " + CREDIT + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(updateCourseServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
