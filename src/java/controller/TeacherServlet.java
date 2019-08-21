
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DAOTeachersImpl;
import model.dao.DAOTeachers;

@WebServlet("/teachers")
public class TeacherServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOTeachers dao = new DAOTeachersImpl();
        request.setAttribute("teachers", dao.getAllTeachers());
        request.getRequestDispatcher("/teachView.jsp").forward(request, response);
    }
    
}
