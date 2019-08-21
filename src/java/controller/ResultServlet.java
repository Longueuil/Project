
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao2.DAOResultsImpl;
import model.dao2.DAOResults;

@WebServlet("/results")
public class ResultServlet extends HttpServlet{
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        DAOResults dao = new DAOResultsImpl();
        request.setAttribute("results", dao.getAllResults());
        request.getRequestDispatcher("/resultView.jsp").forward(request, response);
    }
    
}
