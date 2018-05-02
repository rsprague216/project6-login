package edu.acc.project6;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ryan Sprague
 */
public class User {
    private final String NAME, PASSWORD_HASH;
    private final byte[] SALT = new byte[4];
    private String avatar;
    ArrayList<String> comments = new ArrayList<>();
    
    public User(String username, String password, String picture) {
        this.NAME = username;
        generateSalt();
        this.PASSWORD_HASH = PasswordHash.hashPassword(password, SALT);
        this.avatar = picture;
    }
    
    public User(String username, String password) {
        this.NAME = username;
        generateSalt();
        this.PASSWORD_HASH = PasswordHash.hashPassword(password, SALT);
        this.avatar = "/project6/pictures/genericPic.jpg";
    }
    
    public String getName() {
        return this.NAME;
    }
    
    public String getPic() {
        return this.avatar;
    }
    
    public boolean checkPassword(String passwordToTest) {
        return this.PASSWORD_HASH.equals(PasswordHash.hashPassword(passwordToTest, SALT));
    }
    
    public String[] getAllComments() {
        return (String[])this.comments.toArray(new String[comments.size()]);
    }
    
    public void addComment(String comment) {
        comments.add(comment);
    }
    
    
    // Private Methods
    private byte[] generateSalt() {
        Random random = new Random();
        random.nextBytes(SALT);
        return SALT;
        // return "" + (int)(999 + Math.random() * 9000);
    }
}
