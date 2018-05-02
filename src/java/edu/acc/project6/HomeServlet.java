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
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        User user = (User)request.getSession().getAttribute("user");
        if (user != null) 
            request.setAttribute("userComments", user.getAllComments());
        
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }
}
