package edu.acc.project6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ryan Sprague
 */
@WebServlet(name = "NewPostServlet", urlPatterns = {"/newpost"})
public class NewPostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/newPost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserManager userManager = (UserManager)getServletContext().getAttribute("userManager");
        String userComment = request.getParameter("comment");
        // need access to the user class to add comments to the comments array
        User user = (User)request.getSession().getAttribute("user");
        if (userComment.equals("")) {
            request.getRequestDispatcher("/WEB-INF/newPost.jsp").forward(request, response);
        } else {
            user.addComment(userComment);
            response.sendRedirect("/project6/home");
        }
    }
}
