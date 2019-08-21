
package deleteResultServlet;

import model.dao2.deleteResultDAO;
import model.dao2.deleteResultDAOImpl;
import model.dto.Result;
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

@WebServlet(urlPatterns={"/Admin/results/deleteResultServlet"}, 
            initParams = {
                @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe"),
                @WebInitParam(name = "username", value = "hr"),
                @WebInitParam(name = "password", value = "hr")})
public class deleteResultServlet extends HttpServlet{
    
    private deleteResultDAO dao;
    
     public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
        //Create DAO
        dao = new deleteResultDAOImpl(url, user, password);
     }
      @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
       try {
            
            String STUDENT_USERNAME = request.getParameter("STUDENT_USERNAME");
            
            
            Result result = new Result();
            
            result.setSTUDENT_USERNAME(STUDENT_USERNAME);
            
            
            dao.deleteResult(result);
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Result Succesfully deleted</h1>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
       } catch (SQLException ex) {
          Logger.getLogger(deleteResultServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
