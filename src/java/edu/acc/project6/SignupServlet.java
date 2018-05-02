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
@WebServlet(name = "SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String pwCheck = request.getParameter("confirmPW");
        
        // need some logic to protect against empty submissions, and to make sure the passwords are equal
        
        User newUser = userManager.findUserIfValid(name, password);
        if (newUser != null) {
            request.setAttribute("error", "Username or password already taken.");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        } else if (!password.equals(pwCheck)) {
            request.setAttribute("error", "password fields do not match.");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        } else if (name.isEmpty() || password.isEmpty() || pwCheck.isEmpty()) {
            request.setAttribute("error", "username and password cannot be empty.");
            request.getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
        } else {
            User user = new User(name, password);
            userManager.addUser(user);
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/project6/reset");
        }
    }
}
