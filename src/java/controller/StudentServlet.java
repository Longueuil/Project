
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DAOStudents;
import model.dao.DAOStudentsImpl;

@WebServlet("/students")
public class StudentServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOStudents dao = new DAOStudentsImpl();
        request.setAttribute("students", dao.getAllStudents());
        request.getRequestDispatcher("/empView.jsp").forward(request, response);
    }
    
}
