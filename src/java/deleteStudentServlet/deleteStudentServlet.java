
package deleteStudentServlet;

import model.dao.deleteStudentDAO;
import model.dao.deleteStudentDAOImpl;
import model.dto.deleteStudent;
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

@WebServlet(urlPatterns={"/Admin/students/deleteStudentServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})

public class deleteStudentServlet extends HttpServlet{
    private deleteStudentDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new deleteStudentDAOImpl(url, user, password);
     }
      @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try {
            
            String Username = request.getParameter("Username");
            
            
            deleteStudent student = new deleteStudent();
            
            student.setUsername(Username);
            
            
            dao.deleteStudent(student);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Student Succesfully deleted</h1>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(deleteStudentServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
