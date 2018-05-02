package edu.acc.project6;

import java.util.ArrayList;

/**
 * @author Ryan Sprague
 */
public class UserManager {
    private ArrayList<User> users = new ArrayList<>();
    
    public boolean nameAndPasswordMatches (User user, String name, String password) {
        return user.getName().equals(name) && user.checkPassword(password);
    }
    
    public User findUserIfValid(String name, String password) {
        if (name != null && password != null) {
            for (User user : users) {
                if (nameAndPasswordMatches(user, name, password))
                    return user;
            }
        }
        return null;
    }
    
    public void addUser(User newUser) {
        for (User user : users) {
            if (user.getName().equals(newUser.getName()))
                    throw new IllegalArgumentException("duplicate user");
        }
        users.add(newUser);
    }
    // would a getUser function make the security pointless?
}
