package addResultServlet;

import model.dao2.ResultDAO;
import model.dao2.addResultDAOImpl;
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
                            
@WebServlet(urlPatterns = {"/Admin/results/addResultServlet"},
        initParams = {
            @WebInitParam(name = "url", value = "jdbc:oracle:thin:@localhost:1521:xe")
            ,
                @WebInitParam(name = "username", value = "hr")
            ,
                @WebInitParam(name = "password", value = "hr")})

public class addResultServlet extends HttpServlet {

    private ResultDAO dao;

    @Override
    public void init() {
        String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");

        //Create DAO
        dao = new addResultDAOImpl(url, user, password);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {

            String MARK = request.getParameter("MARK");
            String USERNAME = request.getParameter("USERNAME");
            String TEACHER_USERNAME = request.getParameter("TEACHER_USERNAME");
            String STUDENT_USERNAME = request.getParameter("STUDENT_USERNAME");
            String COURSE_NAME = request.getParameter("COURSE_NAME");

            Result result = new Result();
            result.setMARK(Integer.valueOf(MARK));
            result.setUSERNAME(USERNAME);
            result.setTEACHER_USERNAME(TEACHER_USERNAME);
            result.setSTUDENT_USERNAME(STUDENT_USERNAME);
            result.setCOURSE_NAME(COURSE_NAME);

            dao.addResult(result);

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Result Succesfully created</h1>");
            out.println("<p>Mark : " + MARK + "</p>");
            out.println("<p>Teacher username: " + TEACHER_USERNAME + "</p>");
            out.println("<p>Student username: " + STUDENT_USERNAME + "</p>");
            out.println("<p>Course username: " + COURSE_NAME + "</p>");
            out.println("<a href=\"../../newMainMenu.html\">Return to the main page</a>");
            out.println("</body></html>");
        } catch (SQLException ex) {
            Logger.getLogger(addResultServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
