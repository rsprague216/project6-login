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
@WebServlet(name = "SecretServlet", urlPatterns = {"/secret"})
public class SecretServlet extends HttpServlet {
    
    private boolean loggedIn(HttpServletRequest request) {
        return request.getSession().getAttribute("user") != null;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (loggedIn(request)) {
            request.getRequestDispatcher("/WEB-INF/secret.jsp").forward(request, response);
        } else {
            response.sendRedirect("/project6/home");
        }
    }
}
