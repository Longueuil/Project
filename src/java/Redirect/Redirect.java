
package Redirect;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.DatabaseConnection;


@WebServlet(urlPatterns=("/redirect"))
          
public class Redirect extends HttpServlet{
    
     
    public void init(){
      String url = getServletConfig().getInitParameter("url");
        String user = getServletConfig().getInitParameter("username");
        String password = getServletConfig().getInitParameter("password");
       
               
    }
    @Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
  
   
    HttpSession session = request.getSession();
    session.setAttribute("USERNAME", request.getRemoteUser());
    request.getSession();
        if(request.isUserInRole("admin")){
            RequestDispatcher rd = request.getRequestDispatcher("newMainMenu.html");
            rd.forward(request, response);
        } else if (request.isUserInRole("student")){
            RequestDispatcher rd = request.getRequestDispatcher("programs.html");
            rd.forward(request, response);
                    
        }else if (request.isUserInRole("teacher")){
            RequestDispatcher rd = request.getRequestDispatcher("newStartPage.html");
            rd.forward(request, response);
                    
        }
}}
