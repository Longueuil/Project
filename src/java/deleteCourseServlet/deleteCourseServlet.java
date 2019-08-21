
package deleteCourseServlet;


import model.dao.deleteCourseDAO;
import model.dao.deleteCourseDAOImpl;
import model.dto.deleteCourse;
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

@WebServlet(urlPatterns={"/Admin/course/deleteCourseServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})

public class deleteCourseServlet extends HttpServlet{
    
     private deleteCourseDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new deleteCourseDAOImpl(url, user, password);
     }
      @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try {
            
            String COURSE_ID = request.getParameter("COURSE_ID");
            
            
            deleteCourse course = new deleteCourse();
            
            course.setCOURSE_ID(Integer.valueOf(COURSE_ID));
            
            
            dao.deleteCourse(course);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Course Succesfully deleted</h1>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(deleteCourseServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
