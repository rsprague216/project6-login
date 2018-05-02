package edu.acc.project6;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Ryan Sprague
 */
public class UserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
         System.out.println("********** /project6 loaded");
         
         UserManager userManager = new UserManager();
         userManager.addUser(new User("ryan", "P@$$word"));
         
         sce.getServletContext().setAttribute("userManager", userManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
