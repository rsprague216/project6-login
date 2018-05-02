package edu.acc.project6;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        
        //get the login information
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        
        // validate username and password
        User user = userManager.findUserIfValid(name, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/project6/home");
        } else {
            request.setAttribute("error", "I don't know who you are.");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}
