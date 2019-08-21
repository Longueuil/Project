
package updateResultServlet;
import model.dao2.updateResultDAO;
import model.dao2.updateResultDAOImpl;
import model.dto.updateResult;
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

@WebServlet(urlPatterns={"/Admin/results/updateResultServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})
public class updateResultServlet extends HttpServlet{
    
    private updateResultDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new updateResultDAOImpl(url, user, password);
     }
      @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try {
            String MARK = request.getParameter("MARK");
            String USERNAME = request.getParameter("USERNAME");
            String TEACHER_USERNAME = request.getParameter("TEACHER_USERNAME");
            String STUDENT_USERNAME = request.getParameter("STUDENT_USERNAME");
            String COURSE_NAME = request.getParameter("COURSE_NAME");
            
            
            updateResult updateresult = new updateResult();
            updateresult.setMARK(Integer.valueOf(MARK));
            updateresult.setUSERNAME(USERNAME);
            updateresult.setTEACHER_USERNAME(TEACHER_USERNAME);
            updateresult.setSTUDENT_USERNAME(STUDENT_USERNAME);
            updateresult.setCOURSE_NAME(COURSE_NAME);
            
           
            
            
            dao.updateResults(updateresult);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Results was succesfully updated</h1>");
            out.println("<p>Mark: " + MARK + "</p>");
            out.println("<p>Username: " + USERNAME + "</p>");
            out.println("<p>Teacher username: " + TEACHER_USERNAME + "</p>");
            out.println("<p>Student username: " + STUDENT_USERNAME + "</p>");
            out.println("<p>Course name: " + COURSE_NAME + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(updateResult.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
