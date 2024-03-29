
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DAOCourseImpl;
import model.dao.DAOCourses;

@WebServlet("/courses")
public class CourseServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOCourses dao = new DAOCourseImpl();
        request.setAttribute("courses", dao.getAllCourses());
        request.getRequestDispatcher("/courseView.jsp").forward(request, response);
    }
    
}
